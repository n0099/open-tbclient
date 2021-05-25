package d.a.l0.a.f1.e;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.c2.f.p0.j;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.k;
import d.a.l0.a.v2.o0;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b<SelfT extends b<SelfT>> extends e<SelfT> {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f41838i = k.f43199a;

    /* renamed from: h  reason: collision with root package name */
    public long f41839h;

    /* loaded from: classes3.dex */
    public static final class a extends b<a> {
        @Override // d.a.l0.a.f1.e.b, d.a.l0.a.f1.e.f.c
        public /* bridge */ /* synthetic */ d.a.l0.a.f1.e.f.c D(Bundle bundle) {
            return super.D(bundle);
        }

        public a K1() {
            return this;
        }

        @Override // d.a.l0.a.f1.e.b, d.a.l0.a.f1.e.e
        public /* bridge */ /* synthetic */ e P0(int i2) {
            return super.P0(i2);
        }

        @Override // d.a.l0.a.v2.e1.d
        public /* bridge */ /* synthetic */ d.a.l0.a.v2.e1.d a() {
            K1();
            return this;
        }

        @Override // d.a.l0.a.f1.e.b, d.a.l0.a.f1.e.e
        public /* bridge */ /* synthetic */ e u0(String str) {
            return super.u0(str);
        }
    }

    public static b b1(@NonNull Intent intent) {
        boolean z = f41838i;
        return new a().I1(intent);
    }

    public static String j1(String str, SwanAppConfigData swanAppConfigData) {
        if (TextUtils.isEmpty(str) || swanAppConfigData == null) {
            return null;
        }
        String f2 = o0.f(str);
        if (d.a.l0.a.t1.b.a.e(f2)) {
            return o0.i(str, d.a.l0.a.c2.g.a.f41303b);
        }
        if (swanAppConfigData.o(j.b(f2))) {
            return str;
        }
        return null;
    }

    public static String k1(b bVar, SwanAppConfigData swanAppConfigData) {
        return j1(w1(bVar.e0()), swanAppConfigData);
    }

    public static String l1(String str, SwanAppConfigData swanAppConfigData) {
        if (!TextUtils.isEmpty(str) && swanAppConfigData != null) {
            return j1(w1(m1(str)), swanAppConfigData);
        }
        if (f41838i) {
            Log.d("SwanAppLaunchInfo", "getPageInfo ret null - " + str);
            return null;
        }
        return null;
    }

    public static String m1(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        String j = o0.j(parse);
        if (TextUtils.isEmpty(j)) {
            if (f41838i) {
                Log.d("SwanAppLaunchInfo", "getPageInfo appId is null");
            }
            return null;
        }
        String n = o0.n(j, parse, true);
        if (TextUtils.isEmpty(n)) {
            if (f41838i) {
                Log.d("SwanAppLaunchInfo", "getPageInfo no launchPath ");
            }
            return null;
        }
        String i2 = o0.i(parse.getEncodedQuery(), d.a.l0.a.c2.g.a.f41303b);
        if (f41838i) {
            Log.d("SwanAppLaunchInfo", "query: " + i2);
        }
        if (!TextUtils.isEmpty(i2)) {
            n = n + "?" + i2;
        }
        if (f41838i) {
            Log.d("SwanAppLaunchInfo", "launch path - " + n);
        }
        return n;
    }

    public static String w1(String str) {
        return (TextUtils.isEmpty(str) || !str.startsWith(File.separator)) ? str : str.substring(1);
    }

    public SelfT A1(String str) {
        PMSAppInfo f0 = f0();
        if (f0 != null) {
            f0.appName = str;
        }
        return (SelfT) super.w0(str);
    }

    public SelfT B1(String str) {
        super.D0(str);
        PMSAppInfo f0 = f0();
        if (f0 != null) {
            f0.iconUrl = str;
            return (SelfT) super.D0(str);
        }
        return (SelfT) a();
    }

    @Override // d.a.l0.a.f1.e.f.c
    public Bundle C() {
        Bundle C = super.C();
        d.a.l0.a.e0.f.b.g(C);
        String H = H();
        if (!TextUtils.isEmpty(H)) {
            C.putString("mAppId", H);
        }
        return C;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.f1.e.e
    /* renamed from: C1 */
    public SelfT P0(int i2) {
        PMSAppInfo f0 = f0();
        if (f0 != null) {
            f0.n(i2);
            return (SelfT) super.P0(i2);
        }
        return (SelfT) a();
    }

    public SelfT D1(String str) {
        PMSAppInfo f0 = f0();
        if (f0 != null) {
            f0.serviceCategory = str;
            return (SelfT) super.T0(str);
        }
        return (SelfT) a();
    }

    public SelfT E1(String str) {
        PMSAppInfo f0 = f0();
        if (f0 != null) {
            f0.subjectInfo = str;
            return (SelfT) super.V0(str);
        }
        return (SelfT) a();
    }

    public SelfT F1(long j) {
        if (this.f41839h < 1 && j > 0) {
            this.f41839h = j;
            return (SelfT) super.W0(j);
        }
        return (SelfT) a();
    }

    public SelfT G1(String str) {
        PMSAppInfo f0 = f0();
        if (!TextUtils.isEmpty(str) && f0 != null) {
            try {
                f0.versionCode = Integer.parseInt(str);
                return (SelfT) super.Z0(str);
            } catch (NumberFormatException e2) {
                if (f41838i) {
                    e2.printStackTrace();
                }
            }
        }
        return (SelfT) a();
    }

    @Override // d.a.l0.a.f1.e.e
    public String H() {
        PMSAppInfo f0 = f0();
        return (f0 == null || TextUtils.isEmpty(f0.appId)) ? super.H() : f0.appId;
    }

    public String H1() {
        return "SwanAppLaunchInfo{mAppId='" + H() + "', mAppKey='" + I() + "', mAppTitle='" + K() + "', pmsAppInfo is null='" + k0() + "', launchFrom='" + T() + "', launchScheme='" + W() + "', page='" + e0() + "', mErrorCode=" + d1() + ", mErrorDetail='" + e1() + "', mErrorMsg='" + f1() + "', mResumeDate='" + p1() + "', maxSwanVersion='" + Z() + "', minSwanVersion='" + a0() + "', mVersion='" + u1() + "', mType=" + t1() + ", extraData=" + P() + ", isDebug=" + m0() + ", isLocalDebug=" + o0() + ", targetSwanVersion='" + j0() + "', swanCoreVersion=" + i0() + ", appFrameType=" + G() + ", consoleSwitch=" + l0() + ", orientation=" + d0() + ", versionCode='" + v1() + "', launchFlags=" + S() + ", swanAppStartTime=" + s1() + ", extStartTimestamp=" + N() + ", remoteDebug='" + g0() + "', extJSonObject=" + M() + ", launchId=" + V() + '}';
    }

    @Override // d.a.l0.a.f1.e.e
    public String I() {
        PMSAppInfo f0 = f0();
        return (f0 == null || TextUtils.isEmpty(f0.appKey)) ? super.I() : f0.appKey;
    }

    public SelfT I1(Intent intent) {
        if (intent == null) {
            return (SelfT) a();
        }
        D(intent.getExtras());
        if (d.a(intent)) {
            H0("1250000000000000");
            w("box_cold_launch", -1L);
        }
        return (SelfT) a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.f1.e.f.c
    /* renamed from: J1 */
    public SelfT D(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) a();
        }
        d.a.l0.a.e0.f.b.h(bundle);
        d.a.l0.a.r1.j.e().h(bundle);
        super.D(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            A("mPage");
        }
        return (SelfT) a();
    }

    @Override // d.a.l0.a.f1.e.e
    public String K() {
        PMSAppInfo f0 = f0();
        return (f0 == null || TextUtils.isEmpty(f0.appName)) ? super.K() : f0.appName;
    }

    @Override // d.a.l0.a.f1.e.e
    public String Q() {
        PMSAppInfo f0 = f0();
        return (f0 == null || TextUtils.isEmpty(f0.iconUrl)) ? super.Q() : f0.iconUrl;
    }

    public String c1() {
        PMSAppInfo f0 = f0();
        return f0 == null ? "" : f0.description;
    }

    @Override // d.a.l0.a.f1.e.e
    public int d0() {
        PMSAppInfo f0 = f0();
        int i2 = f0 == null ? -1 : f0.i();
        return -1 < i2 ? i2 : super.d0();
    }

    public int d1() {
        PMSAppInfo f0 = f0();
        if (f0 == null) {
            return 0;
        }
        return f0.appStatus;
    }

    public String e1() {
        PMSAppInfo f0 = f0();
        return f0 == null ? "" : f0.statusDetail;
    }

    public String f1() {
        PMSAppInfo f0 = f0();
        return f0 == null ? "" : f0.statusDesc;
    }

    public long g1() {
        PMSAppInfo f0 = f0();
        if (f0 == null) {
            return 0L;
        }
        return f0.pkgSize;
    }

    public JSONObject h1() {
        String W = W();
        if (W != null) {
            String queryParameter = Uri.parse(W).getQueryParameter("_swaninfo");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    return new JSONObject(queryParameter).optJSONObject("baidusearch");
                } catch (JSONException e2) {
                    if (f41838i) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return new JSONObject();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public SwanAppBearInfo i1() {
        PMSAppInfo f0 = f0();
        if (f0 == null) {
            return null;
        }
        String str = f0.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    public int n1() {
        PMSAppInfo f0 = f0();
        return f0 == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : f0.payProtected;
    }

    public String o1() {
        PMSAppInfo f0 = f0();
        if (f0 == null) {
            return null;
        }
        return f0.quickAppKey;
    }

    public String p1() {
        PMSAppInfo f0 = f0();
        return f0 == null ? "" : f0.resumeDate;
    }

    public String q1() {
        PMSAppInfo f0 = f0();
        return f0 == null ? "" : f0.serviceCategory;
    }

    public String r1() {
        PMSAppInfo f0 = f0();
        return f0 == null ? "" : f0.subjectInfo;
    }

    public long s1() {
        return this.f41839h;
    }

    public int t1() {
        PMSAppInfo f0 = f0();
        if (f0 == null) {
            return 0;
        }
        return f0.type;
    }

    public String u1() {
        PMSAppInfo f0 = f0();
        return f0 == null ? "" : String.valueOf(f0.versionCode);
    }

    public String v1() {
        PMSAppInfo f0 = f0();
        return f0 == null ? "" : f0.versionName;
    }

    public SelfT x1(String str) {
        PMSAppInfo f0 = f0();
        if (f0 != null) {
            f0.description = str;
            return (SelfT) super.s0(str);
        }
        return (SelfT) a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.f1.e.e
    /* renamed from: y1 */
    public SelfT u0(String str) {
        super.u0(str);
        PMSAppInfo f0 = f0();
        if (f0 != null) {
            f0.appId = str;
            return (SelfT) super.u0(str);
        }
        return (SelfT) a();
    }

    public SelfT z1(String str) {
        PMSAppInfo f0 = f0();
        if (f0 != null) {
            f0.appKey = str;
        }
        return (SelfT) super.v0(str);
    }
}
