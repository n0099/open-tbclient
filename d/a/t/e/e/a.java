package d.a.t.e.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.t.e.a;
import d.a.t.g.c.a.e;
import d.a.t.g.d.a;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends d.a.t.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a.C1937a f70266f;

    /* renamed from: g  reason: collision with root package name */
    public b f70267g;

    /* renamed from: d.a.t.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1934a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a(a.C1937a c1937a, d.a.t.g.d.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, c1937a, aVar)) == null) {
                if (Build.VERSION.SDK_INT < 23) {
                    while (c1937a != null && !c1937a.b().equals(aVar.b())) {
                        c1937a.b().setExecutable(true, false);
                        c1937a = c1937a.e();
                    }
                    return true;
                }
                while (c1937a != null) {
                    if (!b(c1937a.b())) {
                        return false;
                    }
                    c1937a = c1937a.e();
                }
                return b(aVar.b());
            }
            return invokeLL.booleanValue;
        }

        public static boolean b(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        int i2 = Os.stat(file.getAbsolutePath()).st_mode;
                        if ((i2 & 1) == 0) {
                            Os.chmod(file.getAbsolutePath(), i2 | 1);
                        }
                        return true;
                    } catch (Throwable unused) {
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public e f70268a;

        /* renamed from: b  reason: collision with root package name */
        public long f70269b;

        /* renamed from: c  reason: collision with root package name */
        public String f70270c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f70271d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f70272e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f70273f;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70273f = aVar;
            this.f70268a = new e();
            this.f70272e = true;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70269b : invokeV.longValue;
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.f70269b == j) {
                return;
            }
            this.f70269b = j;
            this.f70271d = true;
        }

        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.f70268a.c(j, j2)) {
                this.f70271d = true;
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || str.equals(this.f70270c)) {
                return;
            }
            this.f70270c = str;
            this.f70271d = true;
        }

        public boolean e(PackageInfo packageInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, packageInfo)) == null) {
                String g2 = this.f70273f.f70266f.h(new File(packageInfo.applicationInfo.dataDir)).g("pub.dat", true);
                this.f70272e = false;
                return g(g2);
            }
            return invokeL.booleanValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f70270c : (String) invokeV.objValue;
        }

        public final boolean g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.f70269b = jSONObject.getLong("pub_lst_ts");
                        this.f70270c = jSONObject.getString("pub_id");
                        jSONObject.getInt("d_form_ver");
                        this.f70271d = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? g(this.f70273f.f70266f.g("pub.dat", true)) : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.f70272e) {
                    if (this.f70271d) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pub_id", this.f70270c);
                            jSONObject.put("pub_lst_ts", this.f70269b);
                            jSONObject.put("d_form_ver", 1);
                            this.f70273f.f70266f.i("pub.dat", jSONObject.toString(), true);
                            this.f70271d = false;
                            return true;
                        } catch (Exception unused) {
                        }
                    }
                    return false;
                }
                throw new IllegalStateException();
            }
            return invokeV.booleanValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? a.k(this.f70273f.f70266f.d("pub.dat"), true) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c extends a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f70274d;

        /* renamed from: e  reason: collision with root package name */
        public long f70275e;

        /* renamed from: f  reason: collision with root package name */
        public long f70276f;

        /* renamed from: g  reason: collision with root package name */
        public long f70277g;

        /* renamed from: h  reason: collision with root package name */
        public String f70278h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, String str) {
            super(aVar.f70266f, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a.C1937a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // d.a.t.e.a.c
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f70274d = jSONObject.getString("pkg");
                this.f70276f = jSONObject.getInt("tar_pkg_lst_pub_ts");
                this.f70275e = jSONObject.getLong("last_fe_ts");
                this.f70278h = jSONObject.getString("id");
                this.f70277g = jSONObject.getLong("tar_pkg_lst_up_ts");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // d.a.t.e.a.c
        public void e(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f70274d);
                jSONObject.put("last_fe_ts", this.f70275e);
                jSONObject.put("tar_pkg_lst_pub_ts", this.f70276f);
                jSONObject.put("id", this.f70278h);
                jSONObject.put("tar_pkg_lst_up_ts", this.f70277g);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70274d : (String) invokeV.objValue;
        }

        public void g(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
                l(bVar.f());
                k(bVar.a());
            }
        }

        public boolean h(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                if (this.f70275e != j) {
                    this.f70275e = j;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                if (str.equals(this.f70274d)) {
                    return false;
                }
                this.f70274d = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f70278h : (String) invokeV.objValue;
        }

        public boolean k(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                if (this.f70276f != j) {
                    this.f70276f = j;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                if (str.equals(this.f70278h)) {
                    return false;
                }
                this.f70278h = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public long m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f70277g : invokeV.longValue;
        }

        public boolean n(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
                if (this.f70277g != j) {
                    this.f70277g = j;
                    a(true);
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("isc", 8000000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70267g = new b(this);
    }

    public static boolean k(File file, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, file, z)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    Os.chmod(file.getAbsolutePath(), z ? 436 : 432);
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
            try {
                if (z) {
                    return file.setReadable(true, false);
                }
                return file.setReadable(false, false) && file.setReadable(true, true);
            } catch (Throwable unused2) {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    @Override // d.a.t.e.a
    public a.h b(String str, a.g gVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        String f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, gVar)) == null) {
            c cVar = null;
            try {
                packageInfo = this.f70227a.f70231a.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return a.h.a(-2);
            }
            if (gVar.f70237a) {
                cVar = new c(this, str);
                cVar.d();
                if (str.equals(cVar.f()) && packageInfo.lastUpdateTime == cVar.m()) {
                    f2 = cVar.j();
                    return a.h.e(f2);
                }
            }
            b bVar = new b(this);
            if (bVar.e(packageInfo)) {
                if (gVar.f70237a && cVar != null) {
                    cVar.g(bVar);
                    cVar.h(System.currentTimeMillis());
                    cVar.n(packageInfo.lastUpdateTime);
                    cVar.i(str);
                    cVar.b();
                }
                f2 = bVar.f();
                return a.h.e(f2);
            }
            return a.h.a(-2);
        }
        return (a.h) invokeLL.objValue;
    }

    @Override // d.a.t.e.a
    public void e(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.f70266f = this.f70228b.f("isc");
        }
    }

    @Override // d.a.t.e.a
    public a.f f(a.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            Context context = this.f70227a.f70231a;
            if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
                this.f70267g.h();
                try {
                    return h(eVar);
                } finally {
                    this.f70267g.i();
                    i();
                    this.f70267g.i();
                    this.f70267g.j();
                }
            }
            return a.f.b(-100);
        }
        return (a.f) invokeL.objValue;
    }

    public final a.f h(a.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eVar)) == null) {
            this.f70267g.h();
            this.f70266f.a();
            String c2 = this.f70227a.f70233c.a("aid").c();
            if (c2.equals(this.f70267g.f())) {
                return a.f.d();
            }
            this.f70267g.d(c2);
            this.f70267g.b(System.currentTimeMillis());
            return a.f.d();
        }
        return (a.f) invokeL.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f70267g.c(C1934a.a(this.f70266f, this.f70227a.f70232b) ? 1 : 2, 3L);
        }
    }
}
