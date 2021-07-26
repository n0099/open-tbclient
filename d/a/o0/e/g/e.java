package d.a.o0.e.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.p.d.d1;
import d.a.o0.a.v2.r0;
import d.a.o0.a.v2.y;
import d.a.o0.a.z1.b.e.b;
@Service
/* loaded from: classes7.dex */
public class e implements d1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.a.w2.j.b f49661a;

    /* loaded from: classes7.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f49662a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f49663b;

        public a(e eVar, SwanAppActivity swanAppActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, swanAppActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49662a = swanAppActivity;
            this.f49663b = str;
        }

        @Override // d.a.o0.a.z1.b.e.b.a
        public void a(d.a.o0.a.z1.b.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                d.a.o0.a.i1.d.e.a.d(bVar.c(), this.f49662a, this.f49663b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends d.a.o0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f49664a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f49665b;

        public b(e eVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49665b = eVar;
            this.f49664a = swanAppActivity;
        }

        @Override // d.a.o0.a.t0.a, d.a.o0.a.t0.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49665b.f49661a.j();
                this.f49664a.unregisterCallback(this);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(269485201, "Ld/a/o0/e/g/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(269485201, "Ld/a/o0/e/g/e;");
                return;
            }
        }
        boolean z = k.f46335a;
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // d.a.o0.a.p.d.d1
    public void a(NgWebView ngWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ngWebView) == null) {
            ngWebView.doSelectionCancel();
        }
    }

    @Override // d.a.o0.a.p.d.d1
    public void b(NgWebView ngWebView, String str) {
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ngWebView, str) == null) || (x = d.a.o0.a.a2.d.g().x()) == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f49661a = new d.a.o0.a.w2.j.b(ngWebView.covertToView());
        int[] g2 = g(x);
        int[] h2 = h(x);
        for (int i2 = 0; i2 < g2.length; i2++) {
            this.f49661a.e(g2[i2], h2[i2]);
        }
        this.f49661a.r(new a(this, x, str));
        this.f49661a.t();
        x.registerCallback(new b(this, x));
    }

    @Override // d.a.o0.a.p.d.d1
    public void c(NgWebView ngWebView, int i2, int i3, int i4, int i5, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{ngWebView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Boolean.valueOf(z)}) == null) {
            ngWebView.updateAndShowPopupWindow(i4, i5, i2, i3, str, true);
            if (z) {
                i("show", null, null);
            }
        }
    }

    @Override // d.a.o0.a.p.d.d1
    public void d(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, context) == null) {
        }
    }

    @Override // d.a.o0.a.p.d.d1
    public void e(String str, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, context) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        r0.b(context).c(str);
        i(PrefetchEvent.STATE_CLICK, "copy", null);
    }

    public int[] g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            int[] iArr = {7, 6, 5, 8};
            if (y.a(context, "android.permission.SET_WALLPAPER")) {
                return iArr;
            }
            int[] iArr2 = new int[3];
            System.arraycopy(iArr, 0, iArr2, 0, 3);
            return iArr2;
        }
        return (int[]) invokeL.objValue;
    }

    public int[] h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            int[] iArr = {d.a.o0.e.e.swan_app_img_menu_load_image, d.a.o0.e.e.swan_app_img_menu_save_image, d.a.o0.e.e.swan_app_img_menu_share_image, d.a.o0.e.e.swan_app_img_menu_set_wallpaper};
            if (y.a(context, "android.permission.SET_WALLPAPER")) {
                return iArr;
            }
            int[] iArr2 = new int[3];
            System.arraycopy(iArr, 0, iArr2, 0, 3);
            return iArr2;
        }
        return (int[]) invokeL.objValue;
    }

    public void i(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            d.a.o0.a.j2.p.e eVar = new d.a.o0.a.j2.p.e();
            eVar.f46321a = "tool";
            eVar.f46326f = d.a.o0.a.a2.d.g().getAppId();
            eVar.f46323c = "miniapp";
            eVar.f46327g = "text";
            eVar.f46322b = str;
            eVar.f46325e = str2;
            if (!TextUtils.isEmpty(str3)) {
                eVar.a("query", str3);
            }
            d.a.o0.a.j2.k.u("810", eVar);
        }
    }
}
