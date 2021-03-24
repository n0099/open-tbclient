package d.o.a.d.f.f;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.compliance.d;
import d.o.a.a.a.a.p;
import d.o.a.d.f.c;
import d.o.a.d.f.i;
import d.o.a.d.f.n;
import d.o.a.d.k;
import d.o.a.d.n.c;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public SoftReference<Activity> f66578a;

    /* loaded from: classes6.dex */
    public class a implements c.a<Boolean, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f66579a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f66580b;

        public a(long j, long j2) {
            this.f66579a = j;
            this.f66580b = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.o.a.d.n.c.a
        public Object a(Boolean bool) {
            if (bool.booleanValue()) {
                b.this.b(c.C1823c.b(this.f66579a, this.f66580b));
                d.o.a.d.f.f.c.f("lp_app_dialog_try_show", this.f66580b);
                return null;
            }
            b.this.i(this.f66580b);
            return null;
        }
    }

    /* renamed from: d.o.a.d.f.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1826b implements c.a<String, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f66582a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f66583b;

        /* renamed from: d.o.a.d.f.f.b$b$a */
        /* loaded from: classes6.dex */
        public class a implements p {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean[] f66585a;

            public a(boolean[] zArr) {
                this.f66585a = zArr;
            }

            @Override // d.o.a.a.a.a.p
            public void a(String str) {
                boolean[] zArr = this.f66585a;
                C1826b c1826b = C1826b.this;
                zArr[0] = b.this.d(c1826b.f66582a, c1826b.f66583b, str);
            }

            @Override // d.o.a.a.a.a.p
            public void a(Throwable th) {
                k.f.c(th);
                d.o.a.d.f.f.c.a(2, C1826b.this.f66583b);
                this.f66585a[0] = false;
            }
        }

        public C1826b(long j, long j2) {
            this.f66582a = j;
            this.f66583b = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.o.a.d.n.c.a
        public Boolean a(String str) {
            boolean[] zArr = {false};
            n.o().a("GET", str, new HashMap(), new a(zArr));
            return Boolean.valueOf(zArr[0]);
        }
    }

    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f66587a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b a() {
        return c.f66587a;
    }

    public void b(long j) {
        TTDelegateActivity.a(j);
    }

    public void c(Activity activity) {
        this.f66578a = new SoftReference<>(activity);
    }

    public final boolean d(long j, long j2, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("package");
            if (optJSONObject != null && optJSONObject.length() != 0) {
                c.C1823c c1823c = new c.C1823c();
                c1823c.f66520a = j;
                c1823c.f66521b = j2;
                c1823c.f66522c = optJSONObject.optString("icon_url");
                c1823c.f66523d = optJSONObject.optString(DpStatConstants.KEY_APP_NAME);
                optJSONObject.optString("package_name");
                c1823c.f66524e = optJSONObject.optString("version_name");
                c1823c.f66525f = optJSONObject.optString("developer_name");
                c1823c.f66527h = optJSONObject.optString("policy_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) optJSONArray.get(i);
                        c1823c.f66526g.add(new Pair<>(jSONObject.optString(IdCardActivity.RESULT_PERMISSION_KEY), jSONObject.optString("permission_desc")));
                    }
                }
                com.ss.android.downloadlib.addownload.compliance.c.a().a(c1823c);
                d.a().a(c1823c.a(), j2, c1823c.f66522c);
                return true;
            }
            d.o.a.d.f.f.c.a(7, j2);
            return false;
        } catch (Exception e2) {
            k.f.c(e2);
            d.o.a.d.f.f.c.a(7, j2);
            return false;
        }
    }

    public boolean e(d.o.a.a.a.c.d dVar) {
        if (dVar.t() && n.s().optInt("ad_lp_show_app_dialog") != 0) {
            String a2 = dVar.x() == null ? null : dVar.x().a();
            return (TextUtils.isEmpty(a2) || Pattern.compile(n.s().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(a2).matches()) ? false : true;
        }
        return false;
    }

    public boolean f(@NonNull c.f fVar) {
        long j;
        long j2;
        if (!TextUtils.isEmpty(fVar.f66543b.u())) {
            try {
                j = d.o.a.d.n.k.g(new JSONObject(fVar.f66543b.u()), "convert_id");
            } catch (Exception e2) {
                e2.printStackTrace();
                j = 0;
            }
            if (j <= 0) {
                d.o.a.d.f.f.c.b(3, fVar);
            }
            j2 = j;
        } else {
            d.o.a.d.f.f.c.b(9, fVar);
            k.f.a();
            j2 = 0;
        }
        long j3 = fVar.f66542a;
        c.C1823c a2 = com.ss.android.downloadlib.addownload.compliance.c.a().a(j2, j3);
        if (a2 != null) {
            d.a().a(a2.a(), j3, a2.f66522c);
            b(a2.a());
            d.o.a.d.f.f.c.d("lp_app_dialog_try_show", fVar);
            return true;
        } else if (n.o() == null) {
            k.f.a();
            d.o.a.d.f.f.c.b(1, fVar);
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            if (j2 > 0) {
                sb.append("convert_id=");
                sb.append(j2);
            }
            if (!TextUtils.isEmpty(fVar.f66543b.v())) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append("package_name=");
                sb.append(fVar.f66543b.v());
            }
            if (sb.length() <= 0) {
                d.o.a.d.f.f.c.b(6, fVar);
                return false;
            }
            long j4 = j2;
            d.o.a.d.n.c.c(new C1826b(j4, j3), "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).b(new a(j4, j3)).d();
            return true;
        }
    }

    public Activity h() {
        Activity activity = this.f66578a.get();
        this.f66578a = null;
        return activity;
    }

    public void i(long j) {
        i a2 = k.b().a(c.g.e().v(j).f66543b.a());
        if (a2 != null) {
            a2.p(false);
            return;
        }
        d.o.a.d.f.f.c.a(11, j);
        k.f.a();
    }

    public b() {
    }
}
