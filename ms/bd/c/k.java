package ms.bd.c;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import java.util.ArrayList;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class k extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public SDKMonitor f79287b;

    /* loaded from: classes2.dex */
    public class a implements SDKMonitor.IGetExtendParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(k kVar, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // ms.bd.c.j
    public void d(long j2, long j3, String str, String str2, String str3, int i2, JSONObject jSONObject) {
        SDKMonitor sDKMonitor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2, str3, Integer.valueOf(i2), jSONObject}) == null) || (sDKMonitor = this.f79287b) == null) {
            return;
        }
        sDKMonitor.monitorApiError(j2, j3, str, str2, str3, i2, jSONObject);
    }

    @Override // ms.bd.c.j
    public void e(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, jSONObject2, jSONObject3) == null) || this.f79287b == null) {
            return;
        }
        if ((jSONObject == null || jSONObject.length() <= 0) && (jSONObject2 == null || jSONObject2.length() <= 0)) {
            return;
        }
        this.f79287b.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    @Override // ms.bd.c.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        String str2;
        String str3;
        ArrayList arrayList;
        ArrayList arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) != null) {
            return invokeL.booleanValue;
        }
        Context a2 = ms.bd.c.a.c().a();
        String str4 = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
                String str5 = (String) h.a(16777217, 0, 0L, "850140", new byte[]{58, 50, 78});
            }
            if (jSONObject != null) {
                return false;
            }
            try {
                str3 = jSONObject.getString((String) h.a(16777217, 0, 0L, "5718bb", new byte[]{55, 49, 73, 115, 92, 124, 50}));
                try {
                    str4 = jSONObject.getString((String) h.a(16777217, 0, 0L, "fa53bb", new byte[]{ByteCompanionObject.MAX_VALUE, 108, 85, 83, 98, 116, 108, 68}));
                    arrayList = new ArrayList();
                    arrayList2 = new ArrayList();
                    JSONArray jSONArray = jSONObject.getJSONArray((String) h.a(16777217, 0, 0L, "3b36fe", new byte[]{PublicSuffixDatabase.EXCEPTION_MARKER, 111, 78, 68, 80, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 5, 113, 78, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1}));
                    JSONArray jSONArray2 = jSONObject.getJSONArray((String) h.a(16777217, 0, 0L, "2f3553", new byte[]{49, 97, 80, 78, 24, 48, 4, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 78, 118}));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        arrayList.add(jSONArray.getString(i2));
                    }
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        arrayList2.add(jSONArray2.getString(i3));
                    }
                } catch (JSONException unused2) {
                    str2 = str4;
                    str4 = str3;
                    String str6 = (String) h.a(16777217, 0, 0L, "262018", new byte[]{48, 49, 76, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 7});
                    str3 = str4;
                    str4 = str2;
                    jSONObject.remove((String) h.a(16777217, 0, 0L, "69bb53", new byte[]{36, 52, 31, 16, 3, Base64.INTERNAL_PADDING, 0, 42, 31, PublicSuffixDatabase.EXCEPTION_MARKER}));
                    jSONObject.remove((String) h.a(16777217, 0, 0L, "d639cb", new byte[]{103, 49, 80, 66, 78, 97, 82, 37, 78, 122}));
                    SDKMonitorUtils.initMonitor(a2, str3, jSONObject, new a(this, jSONObject, str4));
                    this.f79287b = SDKMonitorUtils.getInstance(str3);
                    return true;
                }
            } catch (JSONException unused3) {
                str2 = null;
            }
            if (arrayList.size() <= 0 || arrayList2.size() <= 0) {
                return false;
            }
            SDKMonitorUtils.setConfigUrl(str3, arrayList);
            SDKMonitorUtils.setDefaultReportUrl(str3, arrayList2);
            jSONObject.remove((String) h.a(16777217, 0, 0L, "69bb53", new byte[]{36, 52, 31, 16, 3, Base64.INTERNAL_PADDING, 0, 42, 31, PublicSuffixDatabase.EXCEPTION_MARKER}));
            jSONObject.remove((String) h.a(16777217, 0, 0L, "d639cb", new byte[]{103, 49, 80, 66, 78, 97, 82, 37, 78, 122}));
            SDKMonitorUtils.initMonitor(a2, str3, jSONObject, new a(this, jSONObject, str4));
            this.f79287b = SDKMonitorUtils.getInstance(str3);
            return true;
        }
        jSONObject = null;
        if (jSONObject != null) {
        }
    }

    @Override // ms.bd.c.j
    public void h(long j2, long j3, String str, String str2, String str3, int i2, JSONObject jSONObject) {
        SDKMonitor sDKMonitor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2, str3, Integer.valueOf(i2), jSONObject}) == null) || (sDKMonitor = this.f79287b) == null) {
            return;
        }
        sDKMonitor.monitorSLA(j2, j3, str, str2, str3, i2, jSONObject);
    }
}
