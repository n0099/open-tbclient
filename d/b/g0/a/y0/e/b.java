package d.b.g0.a.y0.e;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.g0.a.i2.i0;
import d.b.g0.a.j1.k;
import d.b.g0.a.t1.k.p0.j;
import d.b.g0.a.y0.e.b;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class b<SelfT extends b<SelfT>> extends e<SelfT> {
    public long i;

    /* loaded from: classes2.dex */
    public static final class a extends b<a> {
        @Override // d.b.g0.a.y0.e.b, d.b.g0.a.y0.e.f.c
        public /* bridge */ /* synthetic */ d.b.g0.a.y0.e.f.c C(Bundle bundle) {
            return super.C(bundle);
        }

        public a D1() {
            return this;
        }

        @Override // d.b.g0.a.y0.e.b, d.b.g0.a.y0.e.e
        public /* bridge */ /* synthetic */ e I0(int i) {
            return super.I0(i);
        }

        @Override // d.b.g0.a.i2.u0.d
        public /* bridge */ /* synthetic */ d.b.g0.a.i2.u0.d a() {
            D1();
            return this;
        }

        @Override // d.b.g0.a.y0.e.b, d.b.g0.a.y0.e.e
        public /* bridge */ /* synthetic */ e q0(String str) {
            return super.q0(str);
        }
    }

    public static b U0() {
        a aVar = new a();
        aVar.t1("小程序测试");
        aVar.q0("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.G0(Color.parseColor("#FF308EF0"));
        aVar.D0("1230000000000000");
        aVar.q1("小程序简介");
        aVar.w1("测试服务类目");
        aVar.x1("测试主体信息");
        aVar.s1("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.z1("1.0");
        aVar.u1("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static b V0(Intent intent) {
        if (intent != null) {
            return new a().B1(intent);
        }
        throw new IllegalArgumentException("intent must not be null.");
    }

    public static String d1(String str, SwanAppConfigData swanAppConfigData) {
        if (TextUtils.isEmpty(str) || swanAppConfigData == null) {
            return null;
        }
        String d2 = i0.d(str);
        if (d.b.g0.a.l1.b.a.d(d2)) {
            return i0.h(str, d.b.g0.a.t1.l.a.f46591b);
        }
        if (swanAppConfigData.o(j.b(d2))) {
            return str;
        }
        return null;
    }

    public static String e1(b bVar, SwanAppConfigData swanAppConfigData) {
        return d1(p1(bVar.b0()), swanAppConfigData);
    }

    public static String f1(String str, SwanAppConfigData swanAppConfigData) {
        if (!TextUtils.isEmpty(str) && swanAppConfigData != null) {
            Uri parse = Uri.parse(str);
            String i = i0.i(parse);
            if (TextUtils.isEmpty(i)) {
                if (e.f47090h) {
                    Log.d("SwanAppLaunchInfo", "getPageInfo appId is null");
                }
                return null;
            }
            String g1 = g1(i, parse);
            if (TextUtils.isEmpty(g1)) {
                if (e.f47090h) {
                    Log.d("SwanAppLaunchInfo", "getPageInfo no launchPath ");
                }
                return null;
            }
            String h2 = i0.h(parse.getEncodedQuery(), d.b.g0.a.t1.l.a.f46591b);
            if (!TextUtils.isEmpty(h2)) {
                g1 = g1 + "?" + h2;
            }
            return d1(p1(g1), swanAppConfigData);
        }
        if (e.f47090h) {
            Log.d("SwanAppLaunchInfo", "getPageInfo ret null - " + str);
        }
        return null;
    }

    public static String g1(String str, Uri uri) {
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        String substring = path.substring(str.length() + 1);
        if (substring.endsWith(File.separator)) {
            substring = substring.substring(0, substring.length() - 1);
        }
        return substring.replaceAll("/+", "/");
    }

    public static String p1(String str) {
        return (TextUtils.isEmpty(str) || !str.startsWith(File.separator)) ? str : str.substring(1);
    }

    @Override // d.b.g0.a.y0.e.f.c
    public Bundle A() {
        Bundle A = super.A();
        d.b.g0.a.c0.d.b.g(A);
        String G = G();
        if (!TextUtils.isEmpty(G)) {
            A.putString("mAppId", G);
        }
        return A;
    }

    public String A1() {
        return "SwanAppLaunchInfo{mAppId='" + G() + "', mAppKey='" + H() + "', mAppTitle='" + J() + "', pmsAppInfo is null='" + h0() + "', launchFrom='" + S() + "', launchScheme='" + V() + "', page='" + b0() + "', mErrorCode=" + X0() + ", mErrorDetail='" + Y0() + "', mErrorMsg='" + Z0() + "', mResumeDate='" + i1() + "', maxSwanVersion='" + W() + "', minSwanVersion='" + X() + "', mVersion='" + n1() + "', mType=" + m1() + ", extraData=" + O() + ", isDebug=" + j0() + ", targetSwanVersion='" + g0() + "', swanCoreVersion=" + f0() + ", appFrameType=" + F() + ", consoleSwitch=" + i0() + ", orientation=" + a0() + ", versionCode='" + o1() + "', launchFlags=" + R() + ", swanAppStartTime=" + l1() + ", extStartTimestamp=" + M() + ", remoteDebug='" + d0() + "', extJSonObject=" + L() + ", launchId=" + U() + '}';
    }

    public SelfT B1(Intent intent) {
        if (intent == null) {
            return (SelfT) a();
        }
        C(intent.getExtras());
        if (d.a(intent)) {
            D0("1250000000000000");
            u("box_cold_launch", -1L);
        }
        return (SelfT) a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.y0.e.f.c
    /* renamed from: C1 */
    public SelfT C(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) a();
        }
        d.b.g0.a.c0.d.b.h(bundle);
        k.e().h(bundle);
        super.C(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            y("mPage");
        }
        return (SelfT) a();
    }

    @Override // d.b.g0.a.y0.e.e
    public String G() {
        PMSAppInfo c0 = c0();
        return (c0 == null || TextUtils.isEmpty(c0.appId)) ? super.G() : c0.appId;
    }

    @Override // d.b.g0.a.y0.e.e
    public String H() {
        PMSAppInfo c0 = c0();
        return (c0 == null || TextUtils.isEmpty(c0.appKey)) ? super.H() : c0.appKey;
    }

    @Override // d.b.g0.a.y0.e.e
    public String J() {
        PMSAppInfo c0 = c0();
        return (c0 == null || TextUtils.isEmpty(c0.appName)) ? super.J() : c0.appName;
    }

    @Override // d.b.g0.a.y0.e.e
    public String P() {
        PMSAppInfo c0 = c0();
        return (c0 == null || TextUtils.isEmpty(c0.iconUrl)) ? super.P() : c0.iconUrl;
    }

    public String W0() {
        PMSAppInfo c0 = c0();
        return c0 == null ? "" : c0.description;
    }

    public int X0() {
        PMSAppInfo c0 = c0();
        if (c0 == null) {
            return 0;
        }
        return c0.appStatus;
    }

    public String Y0() {
        PMSAppInfo c0 = c0();
        return c0 == null ? "" : c0.statusDetail;
    }

    public String Z0() {
        PMSAppInfo c0 = c0();
        return c0 == null ? "" : c0.statusDesc;
    }

    @Override // d.b.g0.a.y0.e.e
    public int a0() {
        PMSAppInfo c0 = c0();
        int i = c0 == null ? -1 : c0.i();
        return -1 < i ? i : super.a0();
    }

    public long a1() {
        PMSAppInfo c0 = c0();
        if (c0 == null) {
            return 0L;
        }
        return c0.pkgSize;
    }

    public JSONObject b1() {
        String V = V();
        if (V != null) {
            String queryParameter = Uri.parse(V).getQueryParameter("_swaninfo");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    return new JSONObject(queryParameter).optJSONObject("baidusearch");
                } catch (JSONException e2) {
                    if (e.f47090h) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return new JSONObject();
    }

    public SwanAppBearInfo c1() {
        PMSAppInfo c0 = c0();
        if (c0 == null) {
            return null;
        }
        String str = c0.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    public String h1() {
        PMSAppInfo c0 = c0();
        if (c0 == null) {
            return null;
        }
        return c0.quickAppKey;
    }

    public String i1() {
        PMSAppInfo c0 = c0();
        return c0 == null ? "" : c0.resumeDate;
    }

    public String j1() {
        PMSAppInfo c0 = c0();
        return c0 == null ? "" : c0.serviceCategory;
    }

    public String k1() {
        PMSAppInfo c0 = c0();
        return c0 == null ? "" : c0.subjectInfo;
    }

    public long l1() {
        return this.i;
    }

    public int m1() {
        PMSAppInfo c0 = c0();
        if (c0 == null) {
            return 0;
        }
        return c0.type;
    }

    public String n1() {
        PMSAppInfo c0 = c0();
        return c0 == null ? "" : String.valueOf(c0.versionCode);
    }

    public String o1() {
        PMSAppInfo c0 = c0();
        return c0 == null ? "" : c0.versionName;
    }

    public SelfT q1(String str) {
        PMSAppInfo c0 = c0();
        if (c0 != null) {
            c0.description = str;
            return (SelfT) super.o0(str);
        }
        return (SelfT) a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.y0.e.e
    /* renamed from: r1 */
    public SelfT q0(String str) {
        super.q0(str);
        PMSAppInfo c0 = c0();
        if (c0 != null) {
            c0.appId = str;
            return (SelfT) super.q0(str);
        }
        return (SelfT) a();
    }

    public SelfT s1(String str) {
        PMSAppInfo c0 = c0();
        if (c0 != null) {
            c0.appKey = str;
        }
        return (SelfT) super.r0(str);
    }

    public SelfT t1(String str) {
        PMSAppInfo c0 = c0();
        if (c0 != null) {
            c0.appName = str;
        }
        return (SelfT) super.s0(str);
    }

    public SelfT u1(String str) {
        super.z0(str);
        PMSAppInfo c0 = c0();
        if (c0 != null) {
            c0.iconUrl = str;
            return (SelfT) super.z0(str);
        }
        return (SelfT) a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.y0.e.e
    /* renamed from: v1 */
    public SelfT I0(int i) {
        PMSAppInfo c0 = c0();
        if (c0 != null) {
            c0.m(i);
            return (SelfT) super.I0(i);
        }
        return (SelfT) a();
    }

    public SelfT w1(String str) {
        PMSAppInfo c0 = c0();
        if (c0 != null) {
            c0.serviceCategory = str;
            return (SelfT) super.M0(str);
        }
        return (SelfT) a();
    }

    public SelfT x1(String str) {
        PMSAppInfo c0 = c0();
        if (c0 != null) {
            c0.subjectInfo = str;
            return (SelfT) super.O0(str);
        }
        return (SelfT) a();
    }

    public SelfT y1(long j) {
        if (this.i < 1 && j > 0) {
            this.i = j;
            return (SelfT) super.P0(j);
        }
        return (SelfT) a();
    }

    public SelfT z1(String str) {
        PMSAppInfo c0 = c0();
        if (!TextUtils.isEmpty(str) && c0 != null) {
            try {
                c0.versionCode = Integer.parseInt(str);
                return (SelfT) super.S0(str);
            } catch (NumberFormatException e2) {
                if (e.f47090h) {
                    e2.printStackTrace();
                }
            }
        }
        return (SelfT) a();
    }
}
