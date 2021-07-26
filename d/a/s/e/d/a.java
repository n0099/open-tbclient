package d.a.s.e.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s.e.a;
import d.a.s.g.d.a;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.s.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a.C1904a f67779f;

    /* renamed from: g  reason: collision with root package name */
    public C1899a f67780g;

    /* renamed from: d.a.s.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1899a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f67781a;

        /* renamed from: b  reason: collision with root package name */
        public String f67782b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f67783c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f67784d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f67785e;

        public C1899a(a aVar) {
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
            this.f67785e = aVar;
            this.f67784d = true;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67781a : invokeV.longValue;
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.f67781a == j) {
                return;
            }
            this.f67781a = j;
            this.f67783c = true;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str.equals(this.f67782b)) {
                return;
            }
            this.f67782b = str;
            this.f67783c = true;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67782b : (String) invokeV.objValue;
        }

        public boolean e(String str) {
            InterceptResult invokeL;
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f67784d = false;
                try {
                    context = this.f67785e.f67763a.f67767a.createPackageContext(str, 0);
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                    context = null;
                }
                if (context == null) {
                    return false;
                }
                try {
                    File externalCacheDir = context.getExternalCacheDir();
                    if (externalCacheDir == null) {
                        return false;
                    }
                    return g(d.a.s.g.d.a.e(new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es"), "pub.dat", "UTF-8", true));
                } catch (Throwable unused) {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? g(this.f67785e.f67779f.g("pub.dat", true)) : invokeV.booleanValue;
        }

        public final boolean g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.f67781a = jSONObject.getLong("pub_lst_ts");
                        this.f67782b = jSONObject.getString("pub_id");
                        jSONObject.getInt("d_form_ver");
                        this.f67783c = false;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.f67784d) {
                    if (this.f67783c) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pub_id", this.f67782b);
                            jSONObject.put("pub_lst_ts", this.f67781a);
                            jSONObject.put("d_form_ver", 1);
                            this.f67785e.f67779f.i("pub.dat", jSONObject.toString(), true);
                            this.f67783c = false;
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

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                try {
                    File externalCacheDir = this.f67785e.f67763a.f67767a.getExternalCacheDir();
                    File file = new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pub_id", this.f67782b);
                    jSONObject.put("pub_lst_ts", this.f67781a);
                    jSONObject.put("d_form_ver", 1);
                    d.a.s.g.d.a.f(file, "pub.dat", jSONObject.toString(), "UTF-8", true);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f67786d;

        /* renamed from: e  reason: collision with root package name */
        public long f67787e;

        /* renamed from: f  reason: collision with root package name */
        public long f67788f;

        /* renamed from: g  reason: collision with root package name */
        public long f67789g;

        /* renamed from: h  reason: collision with root package name */
        public String f67790h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, String str) {
            super(aVar.f67779f, str);
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
                    super((a.C1904a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // d.a.s.e.a.c
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f67786d = jSONObject.getString("pkg");
                this.f67788f = jSONObject.getInt("tar_pkg_lst_pub_ts");
                this.f67787e = jSONObject.getLong("last_fe_ts");
                this.f67790h = jSONObject.getString("id");
                this.f67789g = jSONObject.getLong("tar_pkg_lst_up_ts");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // d.a.s.e.a.c
        public void e(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.f67786d);
                jSONObject.put("last_fe_ts", this.f67787e);
                jSONObject.put("tar_pkg_lst_pub_ts", this.f67788f);
                jSONObject.put("id", this.f67790h);
                jSONObject.put("tar_pkg_lst_up_ts", this.f67789g);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67786d : (String) invokeV.objValue;
        }

        public void g(C1899a c1899a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, c1899a) == null) {
                l(c1899a.d());
                k(c1899a.a());
            }
        }

        public boolean h(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
                if (this.f67787e != j) {
                    this.f67787e = j;
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
                if (str.equals(this.f67786d)) {
                    return false;
                }
                this.f67786d = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f67790h : (String) invokeV.objValue;
        }

        public boolean k(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                if (this.f67788f != j) {
                    this.f67788f = j;
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
                if (str.equals(this.f67790h)) {
                    return false;
                }
                this.f67790h = str;
                a(true);
                return true;
            }
            return invokeL.booleanValue;
        }

        public long m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f67789g : invokeV.longValue;
        }

        public boolean n(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
                if (this.f67789g != j) {
                    this.f67789g = j;
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
        super("esc-es", 7000000L);
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
        this.f67780g = new C1899a(this);
    }

    @Override // d.a.s.e.a
    public a.h b(String str, a.g gVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, gVar)) == null) {
            Context context = this.f67763a.f67767a;
            b bVar = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return a.h.a(-1);
            }
            if (gVar.f67773a) {
                bVar = new b(this, str);
                bVar.d();
                if (str.equals(bVar.f()) && packageInfo.lastUpdateTime == bVar.m()) {
                    String j = bVar.j();
                    if (!TextUtils.isEmpty(j)) {
                        return a.h.e(j);
                    }
                }
            }
            if (context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
                C1899a c1899a = new C1899a(this);
                if (c1899a.e(str)) {
                    if (gVar.f67773a && bVar != null) {
                        bVar.g(c1899a);
                        bVar.h(System.currentTimeMillis());
                        bVar.n(packageInfo.lastUpdateTime);
                        bVar.i(str);
                        bVar.b();
                    }
                    return a.h.e(c1899a.d());
                }
                return a.h.a(-2);
            }
            return a.h.a(-100);
        }
        return (a.h) invokeLL.objValue;
    }

    @Override // d.a.s.e.a
    public void e(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.f67779f = this.f67764b.f("esc-es");
        }
    }

    @Override // d.a.s.e.a
    public a.f f(a.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return a.f.a();
            }
            this.f67780g.f();
            try {
                return i(eVar);
            } finally {
                this.f67780g.h();
            }
        }
        return (a.f) invokeL.objValue;
    }

    public final a.f i(a.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, eVar)) == null) {
            String c2 = this.f67763a.f67769c.a("aid").c();
            if (c2.equals(this.f67780g.d())) {
                return a.f.d();
            }
            this.f67780g.c(c2);
            this.f67780g.b(System.currentTimeMillis());
            this.f67780g.h();
            return this.f67780g.i() ? a.f.d() : a.f.a();
        }
        return (a.f) invokeL.objValue;
    }
}
