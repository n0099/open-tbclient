package d.l.a.d.b.e;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.compliance.d;
import d.l.a.a.a.c.r;
import d.l.a.d.b.c;
import d.l.a.d.b.g;
import d.l.a.d.b.l;
import d.l.a.d.f;
import d.l.a.d.h;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SoftReference<Activity> f74267a;

    /* loaded from: classes10.dex */
    public class a implements h.i.a<Boolean, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f74268a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f74269b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f74270c;

        public a(b bVar, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74270c = bVar;
            this.f74268a = j;
            this.f74269b = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.l.a.d.h.i.a
        public Object a(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bool)) == null) {
                if (bool.booleanValue()) {
                    this.f74270c.b(c.C2049c.b(this.f74268a, this.f74269b));
                    d.l.a.d.b.e.c.f("lp_app_dialog_try_show", this.f74269b);
                    return null;
                }
                this.f74270c.i(this.f74269b);
                return null;
            }
            return invokeL.objValue;
        }
    }

    /* renamed from: d.l.a.d.b.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C2053b implements h.i.a<String, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f74271a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f74272b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f74273c;

        /* renamed from: d.l.a.d.b.e.b$b$a */
        /* loaded from: classes10.dex */
        public class a implements r {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean[] f74274a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ C2053b f74275b;

            public a(C2053b c2053b, boolean[] zArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2053b, zArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74275b = c2053b;
                this.f74274a = zArr;
            }

            @Override // d.l.a.a.a.c.r
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    boolean[] zArr = this.f74274a;
                    C2053b c2053b = this.f74275b;
                    zArr[0] = c2053b.f74273c.d(c2053b.f74271a, c2053b.f74272b, str);
                }
            }

            @Override // d.l.a.a.a.c.r
            public void a(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    d.l.a.d.b.e.c.a(2, this.f74275b.f74272b);
                    this.f74274a[0] = false;
                }
            }
        }

        public C2053b(b bVar, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74273c = bVar;
            this.f74271a = j;
            this.f74272b = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.l.a.d.h.i.a
        public Boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                boolean[] zArr = {false};
                l.q().a("GET", str, new HashMap(), new a(this, zArr));
                return Boolean.valueOf(zArr[0]);
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static b f74276a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1317906620, "Ld/l/a/d/b/e/b$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1317906620, "Ld/l/a/d/b/e/b$c;");
                    return;
                }
            }
            f74276a = new b(null);
        }
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f74276a : (b) invokeV.objValue;
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            TTDelegateActivity.a(j);
        }
    }

    public void c(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            this.f74267a = new SoftReference<>(activity);
        }
    }

    public final boolean d(long j, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str})) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject(AsInstallService.SCHEME_PACKAGE_ADDED);
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    c.C2049c c2049c = new c.C2049c();
                    c2049c.f74202a = j;
                    c2049c.f74203b = j2;
                    c2049c.f74204c = optJSONObject.optString("icon_url");
                    c2049c.f74205d = optJSONObject.optString("app_name");
                    optJSONObject.optString("package_name");
                    c2049c.f74206e = optJSONObject.optString("version_name");
                    c2049c.f74207f = optJSONObject.optString("developer_name");
                    c2049c.f74209h = optJSONObject.optString("policy_url");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(i2);
                            c2049c.f74208g.add(new Pair<>(jSONObject.optString(IdCardActivity.RESULT_PERMISSION_KEY), jSONObject.optString("permission_desc")));
                        }
                    }
                    com.ss.android.downloadlib.addownload.compliance.c.a().a(c2049c);
                    d.a().a(c2049c.a(), j2, c2049c.f74204c);
                    return true;
                }
                d.l.a.d.b.e.c.a(7, j2);
                return false;
            } catch (Exception e2) {
                f.e.b().a(e2, "AdLpComplianceManager parseResponse");
                d.l.a.d.b.e.c.a(7, j2);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public boolean e(d.l.a.a.a.d.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) {
            if (dVar.t() && l.v().optInt("ad_lp_show_app_dialog") != 0) {
                String a2 = dVar.x() == null ? null : dVar.x().a();
                return (TextUtils.isEmpty(a2) || Pattern.compile(l.v().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(a2).matches()) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f(@NonNull c.f fVar) {
        InterceptResult invokeL;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) {
            if (!TextUtils.isEmpty(fVar.f74225b.u())) {
                try {
                    j = h.r.g(new JSONObject(fVar.f74225b.u()), "convert_id");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j = 0;
                }
                if (j <= 0) {
                    d.l.a.d.b.e.c.b(3, fVar);
                }
                j2 = j;
            } else {
                d.l.a.d.b.e.c.b(9, fVar);
                f.e.b().d("requestAppInfo getLogExtra null");
                j2 = 0;
            }
            long j3 = fVar.f74224a;
            c.C2049c a2 = com.ss.android.downloadlib.addownload.compliance.c.a().a(j2, j3);
            if (a2 != null) {
                d.a().a(a2.a(), j3, a2.f74204c);
                b(a2.a());
                d.l.a.d.b.e.c.d("lp_app_dialog_try_show", fVar);
                return true;
            }
            StringBuilder sb = new StringBuilder();
            if (j2 > 0) {
                sb.append("convert_id=");
                sb.append(j2);
            }
            if (!TextUtils.isEmpty(fVar.f74225b.v())) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append("package_name=");
                sb.append(fVar.f74225b.v());
            }
            if (sb.length() <= 0) {
                d.l.a.d.b.e.c.b(6, fVar);
                return false;
            }
            long j4 = j2;
            h.i.c(new C2053b(this, j4, j3), "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).b(new a(this, j4, j3)).d();
            return true;
        }
        return invokeL.booleanValue;
    }

    public Activity h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Activity activity = this.f74267a.get();
            this.f74267a = null;
            return activity;
        }
        return (Activity) invokeV.objValue;
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            g a2 = d.l.a.d.g.b().a(c.g.e().v(j).f74225b.a());
            if (a2 != null) {
                a2.r(true, true);
                return;
            }
            d.l.a.d.b.e.c.a(11, j);
            f.e.b().g("startDownload handler null");
        }
    }

    public b() {
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
}
