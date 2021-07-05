package d.a.u0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.GZIP;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class a implements v {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f70562b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e0 f70563a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-455625847, "Ld/a/u0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-455625847, "Ld/a/u0/a;");
                return;
            }
        }
        f70562b = AppConfig.isDebug();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70563a = new e0();
    }

    @Override // d.a.u0.v
    public boolean a(JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, jSONObject, z)) == null) ? b(BaseContentUploader.ONLINE_URL, jSONObject, z) : invokeLZ.booleanValue;
    }

    public boolean b(String str, JSONObject jSONObject, boolean z) {
        InterceptResult invokeLLZ;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, z)) == null) {
            boolean isUBCDebug = this.f70563a.isUBCDebug();
            if (isUBCDebug) {
                str2 = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=zubc";
            } else {
                str2 = str + "/ztbox?action=zubc";
            }
            String processUrl = CommonUrlParamManager.getInstance().processUrl(str2);
            if (isUBCDebug && !TextUtils.isEmpty(processUrl)) {
                processUrl = UrlUtil.addParam(processUrl, "debug", "1");
            }
            if (z) {
                processUrl = UrlUtil.addParam(processUrl, "reallog", "1");
            }
            if (g.m().u()) {
                processUrl = UrlUtil.addParam(processUrl, "beta", "1");
            }
            HashMap hashMap = new HashMap(2);
            hashMap.put("Content-type", "application/x-www-form-urlencoded");
            hashMap.put(BaseContentUploader.NB, "1");
            try {
                byte[] gZip = GZIP.gZip(jSONObject.toString().getBytes());
                if (gZip.length < 2) {
                    return false;
                }
                gZip[0] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1;
                gZip[1] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2;
                c0 c2 = c(processUrl, gZip, hashMap);
                if (!c2.d()) {
                    if (f70562b) {
                        Log.d("UploadManager", "postByteRequest, fail: " + c2.c());
                    } else {
                        b0.a().h(c2.c(), null);
                    }
                    c2.a();
                    return false;
                }
                try {
                    int i2 = new JSONObject(c2.b()).getInt("error");
                    if (i2 != 0) {
                        if (f70562b) {
                            Log.d("UploadManager", "server error");
                        }
                        if (!f70562b) {
                            b0.a().j(i2);
                        }
                    }
                } catch (Exception e2) {
                    if (f70562b) {
                        Log.d("UploadManager", "body tostring fail:" + e2.getMessage());
                    } else {
                        b0.a().i(Log.getStackTraceString(e2));
                    }
                }
                c2.a();
                return true;
            } catch (Exception e3) {
                if (f70562b) {
                    Log.d("UploadManager", "postByteRequest, Exception: ", e3);
                } else {
                    b0.a().h(null, Log.getStackTraceString(e3));
                }
                return false;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public abstract c0 c(String str, byte[] bArr, Map<String, String> map) throws IOException;
}
