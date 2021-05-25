package d.a.r0.a.e;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tieba.service.AsInstallService;
import com.bumptech.glide.load.engine.GlideException;
import d.a.r0.a.d.b;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static int f64421a;

    /* loaded from: classes5.dex */
    public static class b extends d.a.r0.a.f.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f64422e;

        public b(Context context) {
            this.f64422e = context;
        }

        @Override // d.a.r0.a.f.c
        public final void a() {
            g.k(this.f64422e);
            if (d.a.r0.a.c.i().j() != null && !d.a.r0.a.c.i().j().equals("")) {
                d.a.r0.a.f.i.a("BaiDuAB sdk  init success");
            } else {
                String h2 = g.h(d.a.r0.a.c.i().g());
                if (h2 == null || h2.equals("")) {
                    d.a.r0.a.f.i.b("SDK getToken Error do you have set correct  BAIDUAB_APPKEY in Manifest or network is available");
                    return;
                }
            }
            g.d();
            g.c();
            d.a.r0.a.f.b.b(new k(), f.e(), f.c());
            d.a.r0.a.f.j.b();
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends d.a.r0.a.f.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f64425e;

        /* loaded from: classes5.dex */
        public class a implements b.a<JSONObject> {
            public a(e eVar) {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // d.a.r0.a.d.b.a
            public final /* synthetic */ void a(JSONObject jSONObject) {
                d.a.r0.a.f.d.a("status_updated");
            }

            @Override // d.a.r0.a.d.b.a
            public final void a(String str) {
            }
        }

        public e(String str) {
            this.f64425e = str;
        }

        @Override // d.a.r0.a.f.c
        public final void a() {
            if (d.a.r0.a.f.d.b("status_updated")) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("exids", this.f64425e);
            d.a.r0.a.d.b.c(d.a.r0.a.d.b.d("http://absample.baidu.com/appabapp/appapi/updateStatus", hashMap), new a(this));
        }
    }

    public static /* synthetic */ void a(String str) {
        d.a.r0.a.f.b.a(new e(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(d.a.r0.a.b bVar) {
        byte b2;
        int i2;
        int g2 = bVar.g();
        if (g2 < 1000) {
            String e2 = i.e(bVar.a());
            int length = e2.length();
            int i3 = length << 1;
            byte[] bArr = new byte[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < length; i5++) {
                char charAt = e2.charAt(i5);
                int i6 = i4 + 1;
                bArr[i4] = (byte) (charAt & 255);
                i4 = i6 + 1;
                bArr[i6] = (byte) (charAt >> '\b');
            }
            int i7 = (-1756908916) ^ i3;
            int i8 = i3 / 4;
            for (int i9 = 0; i9 < i8; i9++) {
                int i10 = i9 * 4;
                int i11 = ((bArr[i10 + 0] & 255) + ((bArr[i10 + 1] & 255) << 8) + ((bArr[i10 + 2] & 255) << 16) + ((bArr[i10 + 3] & 255) << 24)) * 1540483477;
                i7 = (i7 * 1540483477) ^ (((i11 >>> 24) ^ i11) * 1540483477);
            }
            int i12 = i3 % 4;
            if (i12 == 3) {
                int i13 = i3 & (-4);
                i7 = (i7 ^ ((bArr[i13 + 2] & 255) << 16)) ^ ((bArr[i13 + 1] & 255) << 8);
                b2 = bArr[i13];
            } else if (i12 == 2) {
                int i14 = i3 & (-4);
                i7 ^= (bArr[i14 + 1] & 255) << 8;
                b2 = bArr[i14];
            } else {
                if (i12 == 1) {
                    b2 = bArr[i3 & (-4)];
                }
                i2 = (i7 ^ (i7 >>> 13)) * 1540483477;
                if (Math.abs((i2 ^ (i2 >>> 15)) % 1000) >= g2) {
                    d.a.r0.a.a.f(false);
                    return;
                }
            }
            i7 = (i7 ^ (b2 & 255)) * 1540483477;
            i2 = (i7 ^ (i7 >>> 13)) * 1540483477;
            if (Math.abs((i2 ^ (i2 >>> 15)) % 1000) >= g2) {
            }
        }
        d.a.r0.a.c.i().a(bVar.a());
        d.a.r0.a.a.f(true);
        d.a.r0.a.f.i.g(bVar.b());
        d.a.r0.a.f.a.b(com.baidu.ubs.analytics.d.a.c() + "-进行一次 初始化   " + new Date().toLocaleString() + GlideException.IndentedAppendable.INDENT + j(bVar.a()));
        f.b(bVar.c());
        f.f(bVar.d());
        f.g(bVar.f());
        f.h(bVar.e());
        d.a.r0.a.e.b.a(bVar.a());
        d.a.r0.a.f.b.a(new b(bVar.a()));
    }

    public static void c() {
        if (TextUtils.isEmpty(d.a.r0.a.c.i().k())) {
            d();
        }
        if (TextUtils.isEmpty(d.a.r0.a.c.i().k())) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(AsInstallService.SCHEME_PACKAGE_ADDED, d.a.r0.a.c.i().g().getPackageName());
        hashMap.put("cuid", d.a.r0.a.c.i().k());
        d.a.r0.a.d.b.c(d.a.r0.a.d.b.d("http://absample.baidu.com/appabapp/appapi/getgroup", hashMap), new a());
    }

    public static void d() {
        String e2 = d.a.r0.a.f.d.e("cuid", "");
        if (!TextUtils.isEmpty(e2)) {
            d.a.r0.a.f.a.b("本地 取得  cuid~~");
            d.a.r0.a.c.i().e(e2);
            return;
        }
        d.a.r0.a.f.a.b("网络请求  cuid~~");
        HashMap hashMap = new HashMap();
        hashMap.put("imei", i.g(d.a.r0.a.c.i().g()));
        hashMap.put(IAdRequestParam.MAC, i.h(d.a.r0.a.c.i().g()));
        d.a.r0.a.d.b.c(d.a.r0.a.d.b.d("http://absample.baidu.com/appabapp/appapi/getcuid", hashMap), new d());
    }

    public static /* synthetic */ int f() {
        int i2 = f64421a;
        f64421a = i2 + 1;
        return i2;
    }

    public static String h(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        String i2 = i(context);
        HashMap hashMap = new HashMap();
        hashMap.put("key", i2);
        hashMap.put(AsInstallService.SCHEME_PACKAGE_ADDED, context.getPackageName());
        d.a.r0.a.d.b.c(d.a.r0.a.d.b.d("http://absample.baidu.com/appabapp/appapi/gettoken", hashMap), new c(currentTimeMillis, context));
        return d.a.r0.a.c.i().j();
    }

    public static String i(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("BAIDUAB_APPKEY");
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String j(Context context) {
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager.getRunningAppProcesses() == null) {
            return "unknow";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "unknow";
    }

    public static /* synthetic */ String k(Context context) {
        String e2 = d.a.r0.a.f.d.e("lastkey", "");
        long c2 = d.a.r0.a.f.d.c("token_update_time");
        if (e2.equals(i(context)) && c2 + 86400000 >= System.currentTimeMillis()) {
            String e3 = d.a.r0.a.f.d.e("token", "");
            if (!e3.equals("")) {
                d.a.r0.a.c.i().b(e3);
                return e3;
            }
        }
        return h(context);
    }

    /* loaded from: classes5.dex */
    public static class d implements b.a<JSONObject> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // d.a.r0.a.d.b.a
        public final /* synthetic */ void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("cuid");
            if (TextUtils.isEmpty(optString)) {
                d.a.r0.a.c.i().e("");
                return;
            }
            d.a.r0.a.c.i().e(optString);
            d.a.r0.a.f.d.f("cuid", optString);
        }

        @Override // d.a.r0.a.d.b.a
        public final void a(String str) {
            if (str.equals("1")) {
                d.a.r0.a.c.i().e("");
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements b.a<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f64423a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f64424b;

        public c(long j, Context context) {
            this.f64423a = j;
            this.f64424b = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // d.a.r0.a.d.b.a
        public final /* synthetic */ void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("token");
            if (optString == null || optString.isEmpty()) {
                return;
            }
            d.a.r0.a.c.i().b(optString);
            d.a.r0.a.f.d.f("token", optString);
            d.a.r0.a.f.d.g("token_update_time", this.f64423a);
            d.a.r0.a.f.d.f("lastkey", g.i(this.f64424b));
        }

        @Override // d.a.r0.a.d.b.a
        public final void a(String str) {
            d.a.r0.a.f.i.b("SDK getToken Error do you have set correct  BAIDUAB_APPKEY  in Manifest   or network is available");
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements b.a<JSONArray> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // d.a.r0.a.d.b.a
        public final /* synthetic */ void a(JSONArray jSONArray) {
            JSONArray jSONArray2 = jSONArray;
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                com.baidu.ubs.analytics.a.g gVar = new com.baidu.ubs.analytics.a.g();
                gVar.setGroup(optJSONObject.optString("group"));
                gVar.setId(optJSONObject.optString("id"));
                gVar.y(optJSONObject.optString("sid"));
                if (i2 > 0) {
                    stringBuffer.append("_");
                }
                stringBuffer.append(gVar.getId());
                arrayList.add(gVar);
            }
            d.a.r0.a.c.i().c(arrayList);
            g.a(stringBuffer.toString());
        }

        @Override // d.a.r0.a.d.b.a
        public final void a(String str) {
            while (g.f64421a < 2) {
                synchronized (this) {
                    g.f();
                }
                g.c();
            }
        }
    }
}
