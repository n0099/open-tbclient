package d.b.n0.a.e;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.bumptech.glide.load.engine.GlideException;
import d.b.n0.a.d.b;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static int f65075a;

    /* loaded from: classes5.dex */
    public static class b extends d.b.n0.a.f.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f65076e;

        public b(Context context) {
            this.f65076e = context;
        }

        @Override // d.b.n0.a.f.c
        public final void a() {
            g.k(this.f65076e);
            if (d.b.n0.a.c.i().j() != null && !d.b.n0.a.c.i().j().equals("")) {
                d.b.n0.a.f.i.a("BaiDuAB sdk  init success");
            } else {
                String h2 = g.h(d.b.n0.a.c.i().g());
                if (h2 == null || h2.equals("")) {
                    d.b.n0.a.f.i.b("SDK getToken Error do you have set correct  BAIDUAB_APPKEY in Manifest or network is available");
                    return;
                }
            }
            g.d();
            g.c();
            d.b.n0.a.f.b.b(new k(), f.e(), f.c());
            d.b.n0.a.f.j.b();
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends d.b.n0.a.f.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f65079e;

        /* loaded from: classes5.dex */
        public class a implements b.a<JSONObject> {
            public a(e eVar) {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // d.b.n0.a.d.b.a
            public final /* synthetic */ void a(JSONObject jSONObject) {
                d.b.n0.a.f.d.a("status_updated");
            }

            @Override // d.b.n0.a.d.b.a
            public final void a(String str) {
            }
        }

        public e(String str) {
            this.f65079e = str;
        }

        @Override // d.b.n0.a.f.c
        public final void a() {
            if (d.b.n0.a.f.d.b("status_updated")) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("exids", this.f65079e);
            d.b.n0.a.d.b.c(d.b.n0.a.d.b.d("http://absample.baidu.com/appabapp/appapi/updateStatus", hashMap), new a(this));
        }
    }

    public static /* synthetic */ void a(String str) {
        d.b.n0.a.f.b.a(new e(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(d.b.n0.a.b bVar) {
        byte b2;
        int i;
        int g2 = bVar.g();
        if (g2 < 1000) {
            String e2 = i.e(bVar.a());
            int length = e2.length();
            int i2 = length << 1;
            byte[] bArr = new byte[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = e2.charAt(i4);
                int i5 = i3 + 1;
                bArr[i3] = (byte) (charAt & 255);
                i3 = i5 + 1;
                bArr[i5] = (byte) (charAt >> '\b');
            }
            int i6 = (-1756908916) ^ i2;
            int i7 = i2 / 4;
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = i8 * 4;
                int i10 = ((bArr[i9 + 0] & 255) + ((bArr[i9 + 1] & 255) << 8) + ((bArr[i9 + 2] & 255) << 16) + ((bArr[i9 + 3] & 255) << 24)) * 1540483477;
                i6 = (i6 * 1540483477) ^ (((i10 >>> 24) ^ i10) * 1540483477);
            }
            int i11 = i2 % 4;
            if (i11 == 3) {
                int i12 = i2 & (-4);
                i6 = (i6 ^ ((bArr[i12 + 2] & 255) << 16)) ^ ((bArr[i12 + 1] & 255) << 8);
                b2 = bArr[i12];
            } else if (i11 == 2) {
                int i13 = i2 & (-4);
                i6 ^= (bArr[i13 + 1] & 255) << 8;
                b2 = bArr[i13];
            } else {
                if (i11 == 1) {
                    b2 = bArr[i2 & (-4)];
                }
                i = (i6 ^ (i6 >>> 13)) * 1540483477;
                if (Math.abs((i ^ (i >>> 15)) % 1000) >= g2) {
                    d.b.n0.a.a.f(false);
                    return;
                }
            }
            i6 = (i6 ^ (b2 & 255)) * 1540483477;
            i = (i6 ^ (i6 >>> 13)) * 1540483477;
            if (Math.abs((i ^ (i >>> 15)) % 1000) >= g2) {
            }
        }
        d.b.n0.a.c.i().a(bVar.a());
        d.b.n0.a.a.f(true);
        d.b.n0.a.f.i.g(bVar.b());
        d.b.n0.a.f.a.b(com.baidu.ubs.analytics.d.a.c() + "-进行一次 初始化   " + new Date().toLocaleString() + GlideException.IndentedAppendable.INDENT + j(bVar.a()));
        f.b(bVar.c());
        f.f(bVar.d());
        f.g(bVar.f());
        f.h(bVar.e());
        d.b.n0.a.e.b.a(bVar.a());
        d.b.n0.a.f.b.a(new b(bVar.a()));
    }

    public static void c() {
        if (TextUtils.isEmpty(d.b.n0.a.c.i().k())) {
            d();
        }
        if (TextUtils.isEmpty(d.b.n0.a.c.i().k())) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("package", d.b.n0.a.c.i().g().getPackageName());
        hashMap.put("cuid", d.b.n0.a.c.i().k());
        d.b.n0.a.d.b.c(d.b.n0.a.d.b.d("http://absample.baidu.com/appabapp/appapi/getgroup", hashMap), new a());
    }

    public static void d() {
        String e2 = d.b.n0.a.f.d.e("cuid", "");
        if (!TextUtils.isEmpty(e2)) {
            d.b.n0.a.f.a.b("本地 取得  cuid~~");
            d.b.n0.a.c.i().e(e2);
            return;
        }
        d.b.n0.a.f.a.b("网络请求  cuid~~");
        HashMap hashMap = new HashMap();
        hashMap.put("imei", i.g(d.b.n0.a.c.i().g()));
        hashMap.put(IAdRequestParam.MAC, i.h(d.b.n0.a.c.i().g()));
        d.b.n0.a.d.b.c(d.b.n0.a.d.b.d("http://absample.baidu.com/appabapp/appapi/getcuid", hashMap), new d());
    }

    public static /* synthetic */ int f() {
        int i = f65075a;
        f65075a = i + 1;
        return i;
    }

    public static String h(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        String i = i(context);
        HashMap hashMap = new HashMap();
        hashMap.put("key", i);
        hashMap.put("package", context.getPackageName());
        d.b.n0.a.d.b.c(d.b.n0.a.d.b.d("http://absample.baidu.com/appabapp/appapi/gettoken", hashMap), new c(currentTimeMillis, context));
        return d.b.n0.a.c.i().j();
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
        String e2 = d.b.n0.a.f.d.e("lastkey", "");
        long c2 = d.b.n0.a.f.d.c("token_update_time");
        if (e2.equals(i(context)) && c2 + 86400000 >= System.currentTimeMillis()) {
            String e3 = d.b.n0.a.f.d.e("token", "");
            if (!e3.equals("")) {
                d.b.n0.a.c.i().b(e3);
                return e3;
            }
        }
        return h(context);
    }

    /* loaded from: classes5.dex */
    public static class d implements b.a<JSONObject> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // d.b.n0.a.d.b.a
        public final /* synthetic */ void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("cuid");
            if (TextUtils.isEmpty(optString)) {
                d.b.n0.a.c.i().e("");
                return;
            }
            d.b.n0.a.c.i().e(optString);
            d.b.n0.a.f.d.f("cuid", optString);
        }

        @Override // d.b.n0.a.d.b.a
        public final void a(String str) {
            if (str.equals("1")) {
                d.b.n0.a.c.i().e("");
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements b.a<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f65077a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f65078b;

        public c(long j, Context context) {
            this.f65077a = j;
            this.f65078b = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // d.b.n0.a.d.b.a
        public final /* synthetic */ void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("token");
            if (optString == null || optString.isEmpty()) {
                return;
            }
            d.b.n0.a.c.i().b(optString);
            d.b.n0.a.f.d.f("token", optString);
            d.b.n0.a.f.d.g("token_update_time", this.f65077a);
            d.b.n0.a.f.d.f("lastkey", g.i(this.f65078b));
        }

        @Override // d.b.n0.a.d.b.a
        public final void a(String str) {
            d.b.n0.a.f.i.b("SDK getToken Error do you have set correct  BAIDUAB_APPKEY  in Manifest   or network is available");
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements b.a<JSONArray> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // d.b.n0.a.d.b.a
        public final /* synthetic */ void a(JSONArray jSONArray) {
            JSONArray jSONArray2 = jSONArray;
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray2.length(); i++) {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                com.baidu.ubs.analytics.a.g gVar = new com.baidu.ubs.analytics.a.g();
                gVar.setGroup(optJSONObject.optString("group"));
                gVar.setId(optJSONObject.optString("id"));
                gVar.y(optJSONObject.optString("sid"));
                if (i > 0) {
                    stringBuffer.append("_");
                }
                stringBuffer.append(gVar.getId());
                arrayList.add(gVar);
            }
            d.b.n0.a.c.i().c(arrayList);
            g.a(stringBuffer.toString());
        }

        @Override // d.b.n0.a.d.b.a
        public final void a(String str) {
            while (g.f65075a < 2) {
                synchronized (this) {
                    g.f();
                }
                g.c();
            }
        }
    }
}
