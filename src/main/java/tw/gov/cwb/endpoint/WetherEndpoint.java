package tw.gov.cwb.endpoint;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import tw.gov.cwb.model.CwbOpenData;
import tw.gov.cwb.service.WetherService;

@RestController
@RequestMapping(value = "/cwb")
public class WetherEndpoint {
	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(WetherEndpoint.class);

	@Autowired
	private WetherService service;
	/***
	 * server快取
	 */
	private LoadingCache<String, CwbOpenData> cacheData = CacheBuilder.newBuilder().maximumSize(1000)
			.expireAfterAccess(2, TimeUnit.HOURS).build(new CacheLoader<String, CwbOpenData>() {
				@Override
				public CwbOpenData load(final String dataid) throws Exception {
					CwbOpenData result = service.retrieveData(dataid);

					return result;
				}
			});

	@CrossOrigin(origins = { "*" })
	@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "/F-C0032-001")
	public DeferredResult<ResponseEntity<CwbOpenData>> F_C0032_001() {
		final DeferredResult<ResponseEntity<CwbOpenData>> result = new DeferredResult<>();
		new Thread(new Runnable() {
			@Override
			public void run() {
				CwbOpenData data = null;
				try {
					data = cacheData.get("F-C0032-001");
				} catch (ExecutionException e) {
					LOGGER.warn("An exception occurred while " + "fetching place details!", e.getCause());

				}
				/***
				 * client cache
				 */
				final CacheControl cc = CacheControl.maxAge(5l, TimeUnit.MINUTES);

				final ResponseEntity<CwbOpenData> initresult = ResponseEntity.ok().cacheControl(cc).body(data);
				result.setResult(initresult);
			}
		}).start();
		return result;
	}
	@CrossOrigin(origins = { "*" })
	@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, value = "/F-C0032-005")
	public DeferredResult<ResponseEntity<CwbOpenData>> F_C0032_005() {
		final DeferredResult<ResponseEntity<CwbOpenData>> result = new DeferredResult<>();
		new Thread(new Runnable() {
			@Override
			public void run() {
				CwbOpenData data = null;
				try {
					data = cacheData.get("F-C0032-005");
				} catch (ExecutionException e) {
					LOGGER.warn("An exception occurred while " + "fetching place details!", e.getCause());

				}
				/***
				 * client cache
				 */
				final CacheControl cc = CacheControl.maxAge(5l, TimeUnit.MINUTES);

				final ResponseEntity<CwbOpenData> initresult = ResponseEntity.ok().cacheControl(cc).body(data);
				result.setResult(initresult);
			}
		}).start();
		return result;
	}
}
