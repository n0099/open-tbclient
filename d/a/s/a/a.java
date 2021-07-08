package d.a.s.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s.a.b.a;
import d.a.s.a.b.d;
import d.a.s.a.e.b;
import d.a.s.a.e.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f67484e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f67485a;

    /* renamed from: b  reason: collision with root package name */
    public String f67486b;

    /* renamed from: c  reason: collision with root package name */
    public Context f67487c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67488d;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67486b = "";
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f67484e == null) {
                synchronized (a.class) {
                    if (f67484e == null) {
                        f67484e = new a();
                    }
                }
            }
            return f67484e;
        }
        return (a) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67486b : (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67488d : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67485a : invokeV.intValue;
    }

    public void e(Context context, String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f67486b = str;
            if (context != null) {
                this.f67487c = context.getApplicationContext();
            }
            this.f67485a = i2;
            this.f67488d = z;
        }
    }

    public void f(JSONArray jSONArray, boolean z, boolean z2, boolean z3) {
        byte[] a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{jSONArray, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (TextUtils.isEmpty(this.f67486b) || this.f67487c == null || jSONArray == null || jSONArray.length() == 0) {
                c.a("IMLiteUBC", "cuid is empty or context null or upload json is null");
                return;
            }
            Context context = this.f67487c;
            if (jSONArray == null || jSONArray.length() == 0) {
                c.a("UBCUploader", "upload json is null");
                return;
            }
            c.a("UBCUploader", "uploadjson:" + jSONArray.toString() + ", isReal:" + z + ", isSave:" + z2);
            if (z2) {
                c.a("UBCUploader", "save ubcdata");
                return;
            }
            JSONObject a3 = new d.a.s.a.d.a(z, jSONArray).a();
            if (a3 == null) {
                c.a("UBCUploader", "uploadJsonData is null");
                return;
            }
            String jSONObject = a3.toString();
            if (TextUtils.isEmpty(jSONObject)) {
                a2 = null;
            } else {
                a2 = b.a(jSONObject.getBytes());
                if (a2 != null && a2.length > 2) {
                    a2[0] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1;
                    a2[1] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2;
                }
            }
            byte[] bArr = a2;
            if (bArr == null || bArr.length < 3) {
                c.a("UBCUploader", "uploadGzip is null or uploadGzip length<3");
                return;
            }
            c.a("UBCUploader", "gzip success, length:" + bArr.length);
            c.a("UBCUploader", "start execute http upload data");
            d dVar = new d(context);
            d.a.s.a.b.a a4 = d.a.s.a.b.a.a(context);
            if (context == null || TextUtils.isEmpty(dVar.a())) {
                dVar.b(d.a.s.a.b.a.f67490d, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes());
            } else if (z3) {
                d.a.s.a.c.a.a().b(new a.RunnableC1911a(a4, dVar, bArr, dVar));
            } else {
                a4.e(dVar.b(), dVar.a(), bArr, dVar.d(), dVar.c(), dVar);
            }
        }
    }
}
