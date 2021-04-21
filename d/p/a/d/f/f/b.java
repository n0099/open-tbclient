package d.p.a.d.f.f;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.compliance.d;
import d.p.a.a.a.a.p;
import d.p.a.d.f.c;
import d.p.a.d.f.i;
import d.p.a.d.f.n;
import d.p.a.d.k;
import d.p.a.d.n.c;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public SoftReference<Activity> f67723a;

    /* loaded from: classes6.dex */
    public class a implements c.a<Boolean, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f67724a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f67725b;

        public a(long j, long j2) {
            this.f67724a = j;
            this.f67725b = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.p.a.d.n.c.a
        public Object a(Boolean bool) {
            if (bool.booleanValue()) {
                b.this.b(c.C1863c.b(this.f67724a, this.f67725b));
                d.p.a.d.f.f.c.f("lp_app_dialog_try_show", this.f67725b);
                return null;
            }
            b.this.i(this.f67725b);
            return null;
        }
    }

    /* renamed from: d.p.a.d.f.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1866b implements c.a<String, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f67727a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f67728b;

        /* renamed from: d.p.a.d.f.f.b$b$a */
        /* loaded from: classes6.dex */
        public class a implements p {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean[] f67730a;

            public a(boolean[] zArr) {
                this.f67730a = zArr;
            }

            @Override // d.p.a.a.a.a.p
            public void a(String str) {
                boolean[] zArr = this.f67730a;
                C1866b c1866b = C1866b.this;
                zArr[0] = b.this.d(c1866b.f67727a, c1866b.f67728b, str);
            }

            @Override // d.p.a.a.a.a.p
            public void a(Throwable th) {
                k.f.c(th);
                d.p.a.d.f.f.c.a(2, C1866b.this.f67728b);
                this.f67730a[0] = false;
            }
        }

        public C1866b(long j, long j2) {
            this.f67727a = j;
            this.f67728b = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.p.a.d.n.c.a
        public Boolean a(String str) {
            boolean[] zArr = {false};
            n.o().a("GET", str, new HashMap(), new a(zArr));
            return Boolean.valueOf(zArr[0]);
        }
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f67732a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b a() {
        return c.f67732a;
    }

    public void b(long j) {
        TTDelegateActivity.a(j);
    }

    public void c(Activity activity) {
        this.f67723a = new SoftReference<>(activity);
    }

    public final boolean d(long j, long j2, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("package");
            if (optJSONObject != null && optJSONObject.length() != 0) {
                c.C1863c c1863c = new c.C1863c();
                c1863c.f67661a = j;
                c1863c.f67662b = j2;
                c1863c.f67663c = optJSONObject.optString("icon_url");
                c1863c.f67664d = optJSONObject.optString(DpStatConstants.KEY_APP_NAME);
                optJSONObject.optString("package_name");
                c1863c.f67665e = optJSONObject.optString("version_name");
                c1863c.f67666f = optJSONObject.optString("developer_name");
                c1863c.f67668h = optJSONObject.optString("policy_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) optJSONArray.get(i);
                        c1863c.f67667g.add(new Pair<>(jSONObject.optString(IdCardActivity.RESULT_PERMISSION_KEY), jSONObject.optString("permission_desc")));
                    }
                }
                com.ss.android.downloadlib.addownload.compliance.c.a().a(c1863c);
                d.a().a(c1863c.a(), j2, c1863c.f67663c);
                return true;
            }
            d.p.a.d.f.f.c.a(7, j2);
            return false;
        } catch (Exception e2) {
            k.f.c(e2);
            d.p.a.d.f.f.c.a(7, j2);
            return false;
        }
    }

    public boolean e(d.p.a.a.a.c.d dVar) {
        if (dVar.t() && n.s().optInt("ad_lp_show_app_dialog") != 0) {
            String a2 = dVar.x() == null ? null : dVar.x().a();
            return (TextUtils.isEmpty(a2) || Pattern.compile(n.s().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(a2).matches()) ? false : true;
        }
        return false;
    }

    public boolean f(@NonNull c.f fVar) {
        long j;
        long j2;
        if (!TextUtils.isEmpty(fVar.f67684b.u())) {
            try {
                j = d.p.a.d.n.k.g(new JSONObject(fVar.f67684b.u()), "convert_id");
            } catch (Exception e2) {
                e2.printStackTrace();
                j = 0;
            }
            if (j <= 0) {
                d.p.a.d.f.f.c.b(3, fVar);
            }
            j2 = j;
        } else {
            d.p.a.d.f.f.c.b(9, fVar);
            k.f.a();
            j2 = 0;
        }
        long j3 = fVar.f67683a;
        c.C1863c a2 = com.ss.android.downloadlib.addownload.compliance.c.a().a(j2, j3);
        if (a2 != null) {
            d.a().a(a2.a(), j3, a2.f67663c);
            b(a2.a());
            d.p.a.d.f.f.c.d("lp_app_dialog_try_show", fVar);
            return true;
        } else if (n.o() == null) {
            k.f.a();
            d.p.a.d.f.f.c.b(1, fVar);
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            if (j2 > 0) {
                sb.append("convert_id=");
                sb.append(j2);
            }
            if (!TextUtils.isEmpty(fVar.f67684b.v())) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append("package_name=");
                sb.append(fVar.f67684b.v());
            }
            if (sb.length() <= 0) {
                d.p.a.d.f.f.c.b(6, fVar);
                return false;
            }
            long j4 = j2;
            d.p.a.d.n.c.c(new C1866b(j4, j3), "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).b(new a(j4, j3)).d();
            return true;
        }
    }

    public Activity h() {
        Activity activity = this.f67723a.get();
        this.f67723a = null;
        return activity;
    }

    public void i(long j) {
        i a2 = k.b().a(c.g.e().v(j).f67684b.a());
        if (a2 != null) {
            a2.p(false);
            return;
        }
        d.p.a.d.f.f.c.a(11, j);
        k.f.a();
    }

    public b() {
    }
}
