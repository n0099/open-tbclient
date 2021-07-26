package d.a.o0.h.f;

import android.app.Activity;
import android.content.DialogInterface;
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
import com.facebook.common.util.UriUtil;
import d.a.o0.a.a1.e;
import d.a.o0.a.v2.k;
import d.a.o0.a.v2.q0;
import d.a.o0.a.z1.b.b.h;
import java.io.File;
import java.util.Date;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f50468b;

    /* renamed from: c  reason: collision with root package name */
    public static d f50469c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f50470a;

    /* loaded from: classes7.dex */
    public class a implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f50471a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v2.e1.b f50472b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f50473c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f50474d;

        public a(d dVar, File file, d.a.o0.a.v2.e1.b bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, file, bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50474d = dVar;
            this.f50471a = file;
            this.f50472b = bVar;
            this.f50473c = z;
        }

        @Override // d.a.o0.a.a1.e.c
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // d.a.o0.a.a1.e.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f50472b.onCallback(Boolean.FALSE);
                this.f50474d.f50470a = this.f50473c;
            }
        }

        @Override // d.a.o0.a.a1.e.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File k = this.f50474d.k();
                if (k.exists()) {
                    d.a.o0.t.d.i(k);
                }
                boolean T = d.a.o0.t.d.T(this.f50471a.getAbsolutePath(), k.getAbsolutePath());
                if (T) {
                    this.f50474d.r();
                    Date date = new Date();
                    this.f50474d.q(k.e(date, "'debug'-HH:mm:ss"), date.getTime());
                }
                d.a.o0.t.d.i(this.f50471a);
                this.f50472b.onCallback(Boolean.valueOf(T));
                this.f50474d.f50470a = this.f50473c;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v2.e1.b f50475e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f50476f;

        public b(d dVar, d.a.o0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50476f = dVar;
            this.f50475e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50475e.onCallback(Boolean.valueOf(this.f50476f.n()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends d.a.o0.h.f.k.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.o0.h.f.k.a
        @NonNull
        public File a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.m().k() : (File) invokeV.objValue;
        }

        @Override // d.a.o0.h.f.k.a
        public void b(@NonNull String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                d.m().q(str, j);
            }
        }
    }

    /* renamed from: d.a.o0.h.f.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1100d implements d.a.o0.h.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.v2.e1.b f50477a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f50478b;

        /* renamed from: d.a.o0.h.f.d$d$a */
        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1100d f50479e;

            public a(C1100d c1100d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1100d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50479e = c1100d;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C1100d c1100d = this.f50479e;
                    c1100d.f50477a.onCallback(Boolean.valueOf(c1100d.f50478b.n()));
                }
            }
        }

        public C1100d(d dVar, d.a.o0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50478b = dVar;
            this.f50477a = bVar;
        }

        @Override // d.a.o0.h.f.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f50478b.r();
                q0.b0(new a(this));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(355342832, "Ld/a/o0/h/f/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(355342832, "Ld/a/o0/h/f/d;");
                return;
            }
        }
        f50468b = d.a.o0.a.k.f46335a;
    }

    public d() {
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
        this.f50470a = f50468b && d.a.o0.a.u1.a.a.u();
    }

    public static d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f50469c == null) {
                synchronized (d.class) {
                    if (f50469c == null) {
                        f50469c = new d();
                    }
                }
            }
            return f50469c;
        }
        return (d) invokeV.objValue;
    }

    public void c(String str, d.a.o0.a.v2.e1.b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, bVar) == null) && f50468b) {
            boolean z = this.f50470a;
            this.f50470a = true;
            e.d dVar = new e.d();
            dVar.f43826a = str;
            File g2 = g();
            new d.a.o0.a.k0.a().e(dVar, g2.getAbsolutePath(), new a(this, g2, bVar, z));
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a.o0.a.k2.g.h.a().getLong("swan-game-sconsole-version-code", -1L) : invokeV.longValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String string = d.a.o0.a.k2.g.h.a().getString("swan-game-sconsole-version-name", "");
            return !TextUtils.isEmpty(string) ? string : d.a.o0.t.d.D(l());
        }
        return (String) invokeV.objValue;
    }

    public final File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File file = new File(d.a.o0.h.s.a.d(), "game_core_console");
            if (f50468b && this.f50470a) {
                file = new File(file, "debug");
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public final File g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new File(f(), "debugGameSconsole.zip") : (File) invokeV.objValue;
    }

    public final File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new File(f(), "swan-game-sconsole.html") : (File) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                return h().toURI().toURL().toString();
            } catch (Exception e2) {
                if (f50468b) {
                    Log.e("ConsoleResourceManager", "getGameConsoleHtmlUrl:" + e2);
                    return "";
                }
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public final File j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new File(k(), "swan-game-sconsole.js") : (File) invokeV.objValue;
    }

    public File k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new File(f(), UriUtil.LOCAL_RESOURCE_SCHEME) : (File) invokeV.objValue;
    }

    public final File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new File(k(), "swan-game-sconsole.version") : (File) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? j().exists() && h().exists() : invokeV.booleanValue;
    }

    public void o(@NonNull d.a.o0.a.v2.e1.b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            if (f50468b && this.f50470a) {
                q0.b0(new b(this, bVar));
            } else {
                d.a.o0.n.b.e(new d.a.o0.n.i.m.a(e(), d()), new d.a.o0.h.f.j.a(new c(this), new C1100d(this, bVar)));
            }
        }
    }

    public void p(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, activity, onClickListener) == null) {
            h.a aVar = new h.a(activity);
            aVar.U(d.a.o0.a.h.aiapps_debug_switch_title);
            aVar.v(d.a.o0.f.g.aiapps_sconsole_load_error);
            aVar.n(new d.a.o0.a.w2.h.a());
            aVar.m(false);
            aVar.O(d.a.o0.f.g.aiapps_ok, onClickListener);
            aVar.X();
        }
    }

    public void q(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048589, this, str, j) == null) {
            File l = l();
            if (l.exists()) {
                d.a.o0.t.d.i(l);
            }
            d.a.o0.a.k2.g.h.a().putString("swan-game-sconsole-version-name", str);
            d.a.o0.a.k2.g.h.a().putLong("swan-game-sconsole-version-code", j);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            File j = j();
            File h2 = h();
            if (h2.exists() || !j.exists()) {
                return;
            }
            String format = String.format("%s%s%s", UriUtil.LOCAL_RESOURCE_SCHEME, File.separator, "swan-game-sconsole.js");
            String C = d.a.o0.t.d.C(d.a.o0.a.c1.a.b(), "aigames/sConsole.html");
            if (C != null) {
                d.a.o0.t.d.M(String.format(C, format), h2);
            }
        }
    }
}
