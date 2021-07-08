package com.yy.hiidostatis.api;

import android.content.Context;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.controller.HttpSendController;
import com.yy.hiidostatis.defs.interf.IMetricsAPI;
import com.yy.hiidostatis.defs.obj.ActionResult;
import com.yy.hiidostatis.defs.obj.Counter;
import com.yy.hiidostatis.defs.obj.MetricsPkg;
import com.yy.hiidostatis.defs.obj.MetricsValue;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.implementation.CommonFiller;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.StringUtil;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.hdid.DeviceProxy;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class MetricsWorker implements IMetricsAPI {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACT = "mmetric";
    public transient /* synthetic */ FieldHolder $fh;
    public String appKey;
    public String appVer;
    public Context context;
    public AtomicInteger count;
    public long expire;
    public HttpSendController httpSendController;
    public String mac;
    public int maxCount;
    public String osVer;
    @Deprecated
    public int period;
    @Deprecated
    public int periodCount;
    public MetricsPkg pkg;
    public String sdkVer;

    @Deprecated
    public MetricsWorker(Context context, int i2, HttpSendController httpSendController, long j, String str, String str2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), httpSendController, Long.valueOf(j), str, str2, str3, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.count = new AtomicInteger(0);
        this.maxCount = i2;
        this.httpSendController = httpSendController;
        this.expire = j;
        this.appKey = str;
        this.appVer = str2;
        this.context = context;
        this.sdkVer = str3;
        this.period = i3;
        this.pkg = new MetricsPkg(i2);
    }

    private String notNull(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? str == null ? "" : str : (String) invokeL.objValue;
    }

    private void sendPkg(MetricsPkg metricsPkg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, metricsPkg) == null) {
            try {
                for (JSONObject jSONObject : metricsPkg.toJson()) {
                    String content = toContent(jSONObject);
                    if (content != null) {
                        this.httpSendController.send(content, this.expire);
                    }
                }
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
            }
        }
    }

    private String toContent(JSONObject jSONObject) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject)) == null) {
            try {
                StatisContent statisContent = new StatisContent();
                String valueOf = String.valueOf(Util.wallTimeSec());
                statisContent.put("act", ACT);
                statisContent.put("time", valueOf);
                statisContent.put("key", CommonFiller.calKey(ACT, valueOf));
                statisContent.put("appkey", this.appKey);
                statisContent.put("ver", notNull(this.appVer));
                statisContent.put(BaseStatisContent.SDKVER, notNull(this.sdkVer));
                statisContent.put("sys", 2);
                if (this.osVer == null) {
                    str = ArdUtil.getOS();
                    this.osVer = str;
                } else {
                    str = this.osVer;
                }
                statisContent.put("osver", notNull(str));
                statisContent.put("model", notNull(Build.MODEL));
                statisContent.put("net", ArdUtil.getNetworkTypeNew(this.context));
                statisContent.put(BaseStatisContent.NTM, ArdUtil.getNtm(this.context));
                statisContent.put("hdid", DeviceProxy.getHdid(this.context));
                statisContent.put("imei", CommonFiller.getIMEI(this.context));
                statisContent.put("mac", CommonFiller.getMacAddr(this.context));
                statisContent.put(BaseStatisContent.SJP, ArdUtil.getSjp(this.context));
                statisContent.put(BaseStatisContent.GUID, StringUtil.geneGuid());
                System.currentTimeMillis();
                statisContent.put("clienttime", String.valueOf(jSONObject.getLong("clienttime") / 1000));
                JSONArray jSONArray = jSONObject.has("reqdata") ? jSONObject.getJSONArray("reqdata") : null;
                JSONArray jSONArray2 = jSONObject.has("counterdata") ? jSONObject.getJSONArray("counterdata") : null;
                JSONArray jSONArray3 = jSONObject.has("flatdata") ? jSONObject.getJSONArray("flatdata") : null;
                if (jSONArray != null) {
                    statisContent.put("reqdata", notNull(jSONArray.toString()));
                }
                if (jSONArray2 != null) {
                    statisContent.put("counterdata", notNull(jSONArray2.toString()));
                }
                if (jSONArray3 != null) {
                    statisContent.put("flatdata", notNull(jSONArray3.toString()));
                }
                return statisContent.toString();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public MetricsPkg cutPiece() {
        InterceptResult invokeV;
        MetricsPkg metricsPkg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.count.get() > this.maxCount) {
                    metricsPkg = this.pkg;
                    this.pkg = new MetricsPkg(this.maxCount);
                    this.count.set(0);
                } else {
                    metricsPkg = null;
                }
            }
            return metricsPkg;
        }
        return (MetricsPkg) invokeV.objValue;
    }

    @Deprecated
    public void onTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.periodCount + 1;
            this.periodCount = i2;
            if (i2 >= this.period) {
                this.periodCount = 0;
                sendNow();
            }
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IMetricsAPI
    public void reportCount(int i2, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, str2, Long.valueOf(j)}) == null) {
            reportCount(i2, str, str2, j, 1);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IMetricsAPI
    public void reportReturnCode(int i2, String str, long j, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j), str2}) == null) {
            reportReturnCode(i2, str, j, str2, null);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IMetricsAPI
    public void reportSrcData(int i2, String str, String str2, long j, Map<String, String> map) {
        MetricsPkg cutPiece;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), str, str2, Long.valueOf(j), map}) == null) {
            this.pkg.addMetricsValue(new MetricsValue(i2, str, str2, j, map));
            if (this.count.incrementAndGet() <= this.maxCount || (cutPiece = cutPiece()) == null) {
                return;
            }
            sendPkg(cutPiece);
        }
    }

    public void sendNow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MetricsPkg metricsPkg = this.pkg;
            this.pkg = new MetricsPkg(this.maxCount);
            this.count.set(0);
            if (metricsPkg.isEmpty()) {
                return;
            }
            sendPkg(metricsPkg);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IMetricsAPI
    public void reportCount(int i2, String str, String str2, long j, int i3) {
        MetricsPkg cutPiece;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, str2, Long.valueOf(j), Integer.valueOf(i3)}) == null) {
            Counter counter = new Counter(i2, str, str2);
            counter.count(j, i3);
            if (!this.pkg.addCounter(counter) || this.count.incrementAndGet() <= this.maxCount || (cutPiece = cutPiece()) == null) {
                return;
            }
            sendPkg(cutPiece);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IMetricsAPI
    public void reportReturnCode(int i2, String str, long j, String str2, Map<String, String> map) {
        MetricsPkg cutPiece;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j), str2, map}) == null) {
            this.pkg.addActionResult(new ActionResult(i2, str, j, str2, map));
            if (this.count.incrementAndGet() <= this.maxCount || (cutPiece = cutPiece()) == null) {
                return;
            }
            sendPkg(cutPiece);
        }
    }

    public MetricsWorker(Context context, int i2, HttpSendController httpSendController, long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), httpSendController, Long.valueOf(j), str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.count = new AtomicInteger(0);
        this.maxCount = i2;
        this.httpSendController = httpSendController;
        this.expire = j;
        this.appKey = str;
        this.appVer = str2;
        this.context = context;
        this.sdkVer = str3;
        this.pkg = new MetricsPkg(i2);
    }
}
