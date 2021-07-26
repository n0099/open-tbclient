package d.a.a0.a.h;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f41119a;

    /* renamed from: b  reason: collision with root package name */
    public String f41120b;

    /* renamed from: c  reason: collision with root package name */
    public String f41121c;

    /* renamed from: d  reason: collision with root package name */
    public String f41122d;

    /* renamed from: e  reason: collision with root package name */
    public String f41123e;

    /* renamed from: f  reason: collision with root package name */
    public String f41124f;

    /* renamed from: g  reason: collision with root package name */
    public File f41125g;

    /* renamed from: h  reason: collision with root package name */
    public File f41126h;

    public c() {
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
        this.f41119a = "5.1_v2";
        this.f41125g = null;
    }

    public static c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            c cVar = new c();
            cVar.f41122d = "source";
            cVar.f41119a = "5.1_v2";
            cVar.f41124f = "resource_capture";
            String a2 = cVar.a("resource_capture");
            cVar.f41120b = a2;
            cVar.f41121c = f.b(a2);
            cVar.f41125g = cVar.k();
            cVar.f41126h = cVar.d();
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public static c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            c cVar = new c();
            cVar.f41122d = "source";
            cVar.f41119a = "5.1_v2";
            cVar.f41124f = "resource_live";
            String a2 = cVar.a("resource_live");
            cVar.f41120b = a2;
            cVar.f41121c = f.b(a2);
            cVar.f41125g = cVar.k();
            cVar.f41126h = cVar.d();
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public static c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c cVar = new c();
            cVar.f41122d = "so";
            cVar.f41123e = "so1";
            cVar.f41119a = "5.1_v2";
            String j = cVar.j("so1");
            cVar.f41120b = j;
            cVar.f41121c = f.b(j);
            cVar.f41125g = cVar.k();
            if (d.a.a0.a.b.n()) {
                d.a.a0.a.j.i.a("DuAr_", "so1 local file path = " + cVar.f41125g.getAbsolutePath());
            }
            cVar.f41126h = cVar.d();
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            c cVar = new c();
            cVar.f41122d = "so";
            cVar.f41123e = "so2";
            cVar.f41119a = "5.1_v2";
            String j = cVar.j("so2");
            cVar.f41120b = j;
            cVar.f41121c = f.b(j);
            cVar.f41125g = cVar.k();
            if (d.a.a0.a.b.n()) {
                d.a.a0.a.j.i.a("DuAr_", "So2 local file path = " + cVar.f41125g.getAbsolutePath());
            }
            cVar.f41126h = cVar.d();
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = TextUtils.equals("resource_live", str) ? "https://pic.rmb.bdstatic.com/baidu-ar-source-live-" : "https://pic.rmb.bdstatic.com/baidu-ar-source-";
            return str2 + "5.1_v2.zip";
        }
        return (String) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.equals(this.f41122d, "so")) {
                if (TextUtils.equals(this.f41123e, "so2")) {
                    return d.f().getAbsolutePath();
                }
                return d.b().getAbsolutePath();
            }
            return d.d().g().getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    public File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k() : (File) invokeV.objValue;
    }

    public File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f41126h == null) {
                File c2 = c();
                String absolutePath = c2 != null ? c2.getAbsolutePath() : null;
                if (absolutePath == null) {
                    return null;
                }
                if (!absolutePath.endsWith(".zip")) {
                    absolutePath = absolutePath + ".zip";
                }
                if (!absolutePath.endsWith(".loading")) {
                    absolutePath = absolutePath + ".loading";
                }
                this.f41126h = new File(absolutePath);
            }
            return this.f41126h;
        }
        return (File) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f41119a + "-" + this.f41121c;
        }
        return (String) invokeV.objValue;
    }

    public final String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            String str2 = TextUtils.equals("so2", str) ? "https://pic.rmb.bdstatic.com/baidu-ar-so-live-" : "https://pic.rmb.bdstatic.com/baidu-ar-so-";
            return str2 + "5.1_v2.zip";
        }
        return (String) invokeL.objValue;
    }

    public File k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f41125g == null && !TextUtils.isEmpty(this.f41119a)) {
                this.f41125g = new File(b(), e());
            }
            return this.f41125g;
        }
        return (File) invokeV.objValue;
    }
}
