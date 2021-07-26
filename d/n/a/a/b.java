package d.n.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.yxcorp.kuaishou.addfp.android.Orange;
import d.n.a.a.c.a.a;
import d.n.a.a.c.b.c;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static String f72617g = "KWE_NS";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f72618a;

    /* renamed from: b  reason: collision with root package name */
    public String f72619b;

    /* renamed from: c  reason: collision with root package name */
    public String f72620c;

    /* renamed from: d  reason: collision with root package name */
    public String f72621d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f72622e;

    /* renamed from: f  reason: collision with root package name */
    public d f72623f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-629865267, "Ld/n/a/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-629865267, "Ld/n/a/a/b;");
        }
    }

    public b() {
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
        this.f72619b = "";
        this.f72620c = "";
        this.f72621d = "";
        this.f72622e = false;
    }

    public /* synthetic */ b(e eVar) {
        this();
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f.a() : (b) invokeV.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) == null) ? Orange.a().b(context, str.getBytes(), 20) : (String) invokeLL.objValue;
    }

    public String d(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, context, str, z)) == null) {
            if (TextUtils.isEmpty(this.f72620c)) {
                return null;
            }
            return this.f72620c;
        }
        return (String) invokeLLZ.objValue;
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            try {
                d.n.a.a.a.a.b.c().g(context);
            } catch (Throwable th) {
                c.c(th);
            }
        }
    }

    public void g(Context context, boolean z, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Boolean.valueOf(z), dVar}) == null) {
            try {
                this.f72623f = dVar;
                this.f72618a = context;
                this.f72622e = z;
                Thread thread = new Thread(new e(this));
                thread.setName("adsence-dfp");
                thread.start();
            } catch (Throwable th) {
                String d2 = d.n.a.a.c.b.f.d(th);
                if (dVar != null) {
                    dVar.a(-1, d2);
                }
            }
        }
    }

    public final void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            try {
                boolean b2 = new d.n.a.a.c.a.e(this.f72618a).b();
                f(this.f72618a);
                j(b2);
                this.f72621d = a.a().c(this.f72618a, dVar, this.f72622e, TextUtils.isEmpty(this.f72620c));
                if (dVar == null) {
                    return;
                }
                if (TextUtils.isEmpty(this.f72620c) && (TextUtils.isEmpty(this.f72621d) || this.f72621d.startsWith("KWE"))) {
                    if (this.f72621d.equals("KWE_PE")) {
                        return;
                    }
                    dVar.a(-2, "need check");
                    return;
                }
                dVar.a(this.f72620c, this.f72621d);
            } catch (Throwable th) {
                if (dVar != null) {
                    try {
                        dVar.a(-1, d.n.a.a.c.b.f.d(th));
                    } catch (Throwable unused) {
                        c.c(th);
                    }
                }
            }
        }
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            try {
                Pair a2 = d.n.a.a.c.a.c.b(this.f72618a).a();
                if (a2 != null && a2.second != null) {
                    String str = (String) ((ConcurrentHashMap) a2.second).get("cache_e");
                    if (!TextUtils.isEmpty(str)) {
                        this.f72620c = str;
                    }
                }
                if (TextUtils.isEmpty(this.f72620c)) {
                    String c2 = Build.VERSION.SDK_INT < 29 ? d.n.a.a.c.a.d.c(this.f72618a, "k_w_o_d_out_dtt") : null;
                    String str2 = "";
                    if (TextUtils.isEmpty(c2)) {
                        d.n.a.a.c.b.b.b();
                        if (d.n.a.a.c.b.f.g(this.f72618a, new String[]{"android.permission.READ_EXTERNAL_STORAGE", StorageUtils.EXTERNAL_STORAGE_PERMISSION})) {
                            str2 = d.n.a.a.c.a.c.b(this.f72618a).g("Lm91a2R0ZnQ=");
                        }
                    }
                    if (TextUtils.isEmpty(c2) && TextUtils.isEmpty(str2)) {
                        return;
                    }
                    LinkedHashMap d2 = d.n.a.a.c.a.c.b(this.f72618a).d(c2);
                    if (d2 == null || d2.size() == 0) {
                        d2 = d.n.a.a.c.a.c.b(this.f72618a).d(str2);
                    }
                    if (d2 == null || d2.size() <= 0) {
                        return;
                    }
                    String str3 = (String) d2.get(a.a().e());
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    this.f72620c = str3;
                }
            } catch (Throwable th) {
                c.c(th);
            }
        }
    }

    public boolean l(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("DFP") && str.length() == 64) {
                d.n.a.a.c.a.c.b(context).f(str, "");
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
