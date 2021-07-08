package d.a.n0.h.f;

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
import d.a.n0.a.a1.e;
import d.a.n0.a.v2.k;
import d.a.n0.a.v2.q0;
import d.a.n0.a.z1.b.b.h;
import java.io.File;
import java.util.Date;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49964b;

    /* renamed from: c  reason: collision with root package name */
    public static d f49965c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f49966a;

    /* loaded from: classes7.dex */
    public class a implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f49967a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.v2.e1.b f49968b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f49969c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f49970d;

        public a(d dVar, File file, d.a.n0.a.v2.e1.b bVar, boolean z) {
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
            this.f49970d = dVar;
            this.f49967a = file;
            this.f49968b = bVar;
            this.f49969c = z;
        }

        @Override // d.a.n0.a.a1.e.c
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // d.a.n0.a.a1.e.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f49968b.onCallback(Boolean.FALSE);
                this.f49970d.f49966a = this.f49969c;
            }
        }

        @Override // d.a.n0.a.a1.e.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File k = this.f49970d.k();
                if (k.exists()) {
                    d.a.n0.t.d.i(k);
                }
                boolean T = d.a.n0.t.d.T(this.f49967a.getAbsolutePath(), k.getAbsolutePath());
                if (T) {
                    this.f49970d.r();
                    Date date = new Date();
                    this.f49970d.q(k.e(date, "'debug'-HH:mm:ss"), date.getTime());
                }
                d.a.n0.t.d.i(this.f49967a);
                this.f49968b.onCallback(Boolean.valueOf(T));
                this.f49970d.f49966a = this.f49969c;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.v2.e1.b f49971e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f49972f;

        public b(d dVar, d.a.n0.a.v2.e1.b bVar) {
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
            this.f49972f = dVar;
            this.f49971e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49971e.onCallback(Boolean.valueOf(this.f49972f.n()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends d.a.n0.h.f.k.a {
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

        @Override // d.a.n0.h.f.k.a
        @NonNull
        public File a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.m().k() : (File) invokeV.objValue;
        }

        @Override // d.a.n0.h.f.k.a
        public void b(@NonNull String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                d.m().q(str, j);
            }
        }
    }

    /* renamed from: d.a.n0.h.f.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1091d implements d.a.n0.h.f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.v2.e1.b f49973a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f49974b;

        /* renamed from: d.a.n0.h.f.d$d$a */
        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1091d f49975e;

            public a(C1091d c1091d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1091d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49975e = c1091d;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C1091d c1091d = this.f49975e;
                    c1091d.f49973a.onCallback(Boolean.valueOf(c1091d.f49974b.n()));
                }
            }
        }

        public C1091d(d dVar, d.a.n0.a.v2.e1.b bVar) {
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
            this.f49974b = dVar;
            this.f49973a = bVar;
        }

        @Override // d.a.n0.h.f.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f49974b.r();
                q0.b0(new a(this));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2132170001, "Ld/a/n0/h/f/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2132170001, "Ld/a/n0/h/f/d;");
                return;
            }
        }
        f49964b = d.a.n0.a.k.f45831a;
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
        this.f49966a = f49964b && d.a.n0.a.u1.a.a.u();
    }

    public static d m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f49965c == null) {
                synchronized (d.class) {
                    if (f49965c == null) {
                        f49965c = new d();
                    }
                }
            }
            return f49965c;
        }
        return (d) invokeV.objValue;
    }

    public void c(String str, d.a.n0.a.v2.e1.b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, bVar) == null) && f49964b) {
            boolean z = this.f49966a;
            this.f49966a = true;
            e.d dVar = new e.d();
            dVar.f43322a = str;
            File g2 = g();
            new d.a.n0.a.k0.a().e(dVar, g2.getAbsolutePath(), new a(this, g2, bVar, z));
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a.n0.a.k2.g.h.a().getLong("swan-game-sconsole-version-code", -1L) : invokeV.longValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String string = d.a.n0.a.k2.g.h.a().getString("swan-game-sconsole-version-name", "");
            return !TextUtils.isEmpty(string) ? string : d.a.n0.t.d.D(l());
        }
        return (String) invokeV.objValue;
    }

    public final File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File file = new File(d.a.n0.h.s.a.d(), "game_core_console");
            if (f49964b && this.f49966a) {
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
                if (f49964b) {
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

    public void o(@NonNull d.a.n0.a.v2.e1.b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            if (f49964b && this.f49966a) {
                q0.b0(new b(this, bVar));
            } else {
                d.a.n0.n.b.e(new d.a.n0.n.i.m.a(e(), d()), new d.a.n0.h.f.j.a(new c(this), new C1091d(this, bVar)));
            }
        }
    }

    public void p(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, activity, onClickListener) == null) {
            h.a aVar = new h.a(activity);
            aVar.U(d.a.n0.a.h.aiapps_debug_switch_title);
            aVar.v(d.a.n0.f.g.aiapps_sconsole_load_error);
            aVar.n(new d.a.n0.a.w2.h.a());
            aVar.m(false);
            aVar.O(d.a.n0.f.g.aiapps_ok, onClickListener);
            aVar.X();
        }
    }

    public void q(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048589, this, str, j) == null) {
            File l = l();
            if (l.exists()) {
                d.a.n0.t.d.i(l);
            }
            d.a.n0.a.k2.g.h.a().putString("swan-game-sconsole-version-name", str);
            d.a.n0.a.k2.g.h.a().putLong("swan-game-sconsole-version-code", j);
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
            String C = d.a.n0.t.d.C(d.a.n0.a.c1.a.b(), "aigames/sConsole.html");
            if (C != null) {
                d.a.n0.t.d.M(String.format(C, format), h2);
            }
        }
    }
}
