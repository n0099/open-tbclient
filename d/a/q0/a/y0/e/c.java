package d.a.q0.a.y0.e;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.q0.a.h0.g.g;
import d.a.q0.a.k;
import d.a.q0.a.v2.n0;
import d.a.q0.a.y0.d;
import d.a.q0.a.y0.e.e.b;
/* loaded from: classes8.dex */
public class c implements d.a.q0.a.y0.d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f51713a;

    /* renamed from: b  reason: collision with root package name */
    public String f51714b;

    /* renamed from: c  reason: collision with root package name */
    public String f51715c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.a.h0.g.f f51716d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f51717e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.a.y0.e.e.b f51718f;

    /* renamed from: g  reason: collision with root package name */
    public f f51719g;

    /* renamed from: h  reason: collision with root package name */
    public int f51720h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f51721i;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f51722e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f51723f;

        public a(c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51723f = cVar;
            this.f51722e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51723f.D0(this.f51722e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f51724e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51724e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51724e.v0();
            }
        }
    }

    /* renamed from: d.a.q0.a.y0.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1027c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f51725e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f51726f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f51727g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f51728h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f51729i;

        public RunnableC1027c(c cVar, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51729i = cVar;
            this.f51725e = i2;
            this.f51726f = i3;
            this.f51727g = i4;
            this.f51728h = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51729i.B0(this.f51725e, this.f51726f, this.f51727g, this.f51728h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f51730e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51730e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51730e.A0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f51731a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51731a = cVar;
        }

        @Override // d.a.q0.a.y0.e.e.b.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e("onKeyboardHide", null);
                if (this.f51731a.f51719g != null) {
                    this.f51731a.f51719g.a();
                }
            }
        }

        @Override // d.a.q0.a.y0.e.e.b.e
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                e("onKeyboardShow", "height: " + i2);
                if (this.f51731a.f51719g != null) {
                    this.f51731a.f51719g.b(i2);
                }
            }
        }

        @Override // d.a.q0.a.y0.e.e.b.e
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                e("onInput", "inputText: " + str);
                if (this.f51731a.f51719g != null) {
                    this.f51731a.f51719g.c(str);
                }
            }
        }

        @Override // d.a.q0.a.y0.e.e.b.e
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                e("onDeletePressed", null);
                if (this.f51731a.f51719g != null) {
                    this.f51731a.f51719g.d();
                }
            }
        }

        public final void e(String str, @Nullable String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && c.j) {
                String str3 = ("【" + this.f51731a.j0() + "-" + this.f51731a.hashCode() + "】\t") + "【" + str + "】";
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str3 + str2;
                }
                Log.i("【KeyboardCallback】", str3);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a();

        void b(int i2);

        void c(String str);

        void d();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1386948927, "Ld/a/q0/a/y0/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1386948927, "Ld/a/q0/a/y0/e/c;");
                return;
            }
        }
        j = k.f49133a;
    }

    public c(ZeusPluginFactory.Invoker invoker, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51721i = new e(this);
        if (invoker != null) {
            this.f51715c = (String) invoker.get("id");
        }
        this.f51713a = d.a.q0.a.c1.a.b();
        this.f51714b = str;
        this.f51717e = new Handler(this.f51713a.getMainLooper());
        this.f51716d = t0();
    }

    @Override // d.a.q0.a.y0.d
    public void A(@NonNull d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (d.a.q0.a.a2.e.i() == null) {
                aVar.a(false);
            } else {
                aVar.a(true);
            }
        }
    }

    public final void A0() {
        d.a.q0.a.h0.g.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (fVar = this.f51716d) == null || this.f51720h == 0) {
            return;
        }
        this.f51720h = 0;
        if (fVar.k3().getScrollY() > 0) {
            this.f51716d.k3().setScrollY(0);
        }
    }

    public final void B0(int i2, int i3, int i4, int i5) {
        int i6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) || this.f51716d == null) {
            return;
        }
        d.a.q0.a.p.e.c h2 = d.a.q0.a.g1.f.V().h();
        if (this.f51720h == i4 || h2 == null) {
            return;
        }
        this.f51720h = i4;
        int height = ((this.f51716d.k3().getHeight() - i2) - i3) + h2.getWebViewScrollY() + n0.k(this.f51713a);
        if (i5 > height) {
            i5 = height;
        }
        int i7 = height - i4;
        int scrollY = this.f51716d.k3().getScrollY();
        if (i7 < 0) {
            i6 = i5 - i7;
        } else {
            if (i5 > i7) {
                scrollY = i5 - i7;
            }
            i6 = scrollY;
        }
        this.f51716d.k3().setScrollY(i6);
    }

    public void C0(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f51719g = fVar;
        }
    }

    public final void D0(int i2) {
        Activity u0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (u0 = u0()) == null) {
            return;
        }
        d.a.q0.a.y0.e.e.b bVar = new d.a.q0.a.y0.e.e.b(u0, i2, this.f51721i);
        this.f51718f = bVar;
        bVar.e();
    }

    @Override // d.a.q0.a.y0.d
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f51714b : (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.y0.d
    @Nullable
    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f51715c : (String) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Nullable
    public final d.a.q0.a.h0.g.f t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            g W = d.a.q0.a.g1.f.V().W();
            if (W == null) {
                return null;
            }
            int k = W.k();
            for (int i2 = 0; i2 < k; i2++) {
                d.a.q0.a.h0.g.d j2 = W.j(i2);
                if (j2 instanceof d.a.q0.a.h0.g.f) {
                    d.a.q0.a.h0.g.f fVar = (d.a.q0.a.h0.g.f) j2;
                    if (TextUtils.equals(fVar.g3(), this.f51714b)) {
                        return fVar;
                    }
                }
            }
            return null;
        }
        return (d.a.q0.a.h0.g.f) invokeV.objValue;
    }

    @Nullable
    public final Activity u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            d.a.q0.a.a2.e i2 = d.a.q0.a.a2.e.i();
            if (i2 == null) {
                return null;
            }
            return i2.k();
        }
        return (Activity) invokeV.objValue;
    }

    public final void v0() {
        d.a.q0.a.y0.e.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bVar = this.f51718f) == null) {
            return;
        }
        bVar.dismiss();
        this.f51718f = null;
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f51717e.post(new b(this));
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f51717e.post(new d(this));
        }
    }

    public void y0(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048589, this, i2, i3, i4, i5) == null) {
            this.f51717e.post(new RunnableC1027c(this, i2, i3, i4, i5));
        }
    }

    public void z0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f51717e.post(new a(this, i2));
        }
    }
}
