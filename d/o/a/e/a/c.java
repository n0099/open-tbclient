package d.o.a.e.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.alibaba.fastjson.asm.Label;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bumptech.glide.load.engine.GlideException;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.a.j;
import d.o.a.e.b.a.a;
import d.o.a.e.b.k.g;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f66291a = "c";

    /* renamed from: b  reason: collision with root package name */
    public static e f66292b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, j.a> f66293c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public static C1813c f66294d;

    /* loaded from: classes6.dex */
    public static class a implements d {
        @Override // d.o.a.e.a.c.d
        public boolean a(@NonNull Context context) {
            return c.L(context);
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements d {
        @Override // d.o.a.e.a.c.d
        public boolean a(@NonNull Context context) {
            return c.N(context);
        }
    }

    /* renamed from: d.o.a.e.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1813c implements a.b {

        /* renamed from: e  reason: collision with root package name */
        public final g f66295e;

        /* renamed from: f  reason: collision with root package name */
        public final int f66296f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f66297g;

        public C1813c(Context context, Intent intent, int i2, JSONObject jSONObject, d dVar) {
            this.f66297g = jSONObject;
            int optInt = jSONObject.optInt("query_interval", 1000);
            this.f66296f = optInt;
            this.f66295e = new g(context, intent, i2, dVar, optInt);
        }

        @Override // d.o.a.e.b.a.a.b
        public void b() {
            if (!this.f66295e.f66310g) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.f66295e.f66307d.sendMessage(obtain);
            }
            d.o.a.e.b.a.a.c().h(this);
            C1813c unused = c.f66294d = null;
        }

        @Override // d.o.a.e.b.a.a.b
        public void c() {
            int optInt = this.f66297g.optInt("time_out_second", 20);
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.f66295e.f66307d.sendMessage(obtain);
            if (optInt <= 0 || optInt >= 60) {
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            this.f66295e.f66307d.sendMessageDelayed(obtain2, optInt * 1000);
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        boolean a(@NonNull Context context);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(DownloadInfo downloadInfo, d.o.a.e.a.b bVar);
    }

    /* loaded from: classes6.dex */
    public static class f implements Callable<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final Context f66298e;

        /* renamed from: f  reason: collision with root package name */
        public final d f66299f;

        /* renamed from: g  reason: collision with root package name */
        public final Handler f66300g;

        /* renamed from: h  reason: collision with root package name */
        public final long f66301h;

        public f(Handler handler, Context context, d dVar, long j) {
            this.f66298e = context;
            this.f66299f = dVar;
            this.f66300g = handler;
            this.f66301h = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            if (this.f66299f != null && this.f66301h > 0 && this.f66301h <= 10000) {
                Context context = this.f66298e;
                boolean a2 = context != null ? this.f66299f.a(context) : false;
                Message obtain = Message.obtain();
                if (a2) {
                    obtain.what = 2;
                    this.f66300g.sendMessage(obtain);
                } else {
                    obtain.what = 1;
                    this.f66300g.sendMessageDelayed(obtain, this.f66301h);
                }
                return Boolean.FALSE;
            }
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements g.a {

        /* renamed from: h  reason: collision with root package name */
        public static int f66302h;

        /* renamed from: i  reason: collision with root package name */
        public static int f66303i;

        /* renamed from: a  reason: collision with root package name */
        public final Context f66304a;

        /* renamed from: b  reason: collision with root package name */
        public final Intent f66305b;

        /* renamed from: c  reason: collision with root package name */
        public final d f66306c;

        /* renamed from: d  reason: collision with root package name */
        public final Handler f66307d;

        /* renamed from: e  reason: collision with root package name */
        public final long f66308e;

        /* renamed from: f  reason: collision with root package name */
        public Future<Boolean> f66309f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f66310g = false;

        public g(Context context, Intent intent, int i2, d dVar, long j) {
            this.f66304a = context;
            this.f66305b = intent;
            f66303i = i2;
            this.f66306c = dVar;
            this.f66307d = new d.o.a.e.b.k.g(Looper.getMainLooper(), this);
            this.f66308e = j;
        }

        @Override // d.o.a.e.b.k.g.a
        public void a(Message message) {
            if (message != null) {
                int i2 = message.what;
                if (i2 == 1) {
                    long j = this.f66308e;
                    if (j <= 0 || j > 10000) {
                        return;
                    }
                    f66302h = 1;
                    this.f66309f = d.o.a.e.b.g.d.w0().submit(new f(this.f66307d, this.f66304a, this.f66306c, this.f66308e));
                } else if (i2 == 2) {
                    f66302h = 2;
                    this.f66307d.removeMessages(2);
                    this.f66307d.removeMessages(1);
                    Future<Boolean> future = this.f66309f;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.f66310g && (Build.VERSION.SDK_INT < 29 || d.o.a.e.b.a.a.c().j())) {
                        Intent intent = this.f66305b;
                        if (intent != null) {
                            c.E(this.f66304a, intent);
                        } else {
                            DownloadInfo f2 = d.o.a.e.b.g.a.l(this.f66304a).f(f66303i);
                            if (f2 != null && f2.m1()) {
                                d.o.a.e.a.d.D(this.f66304a, f66303i, false);
                            }
                        }
                        this.f66310g = true;
                    }
                    c.C(f66303i, this.f66305b == null, c.l(this.f66304a));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public static final String f66311a;

        static {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            boolean z2 = !TextUtils.isEmpty(Build.VERSION.RELEASE);
            boolean z3 = !TextUtils.isEmpty(Build.ID);
            z = (!"REL".equals(Build.VERSION.CODENAME) || TextUtils.isEmpty(Build.MODEL)) ? false : false;
            sb.append("AppDownloader");
            if (z2) {
                sb.append("/");
                sb.append(Build.VERSION.RELEASE);
            }
            sb.append(" (Linux; U; Android");
            if (z2) {
                sb.append(" ");
                sb.append(Build.VERSION.RELEASE);
            }
            if (z || z3) {
                sb.append(";");
                if (z) {
                    sb.append(" ");
                    sb.append(Build.MODEL);
                }
                if (z3) {
                    sb.append(" Build/");
                    sb.append(Build.ID);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            f66311a = sb.toString();
        }
    }

    public static j.a A(String str) {
        if (f66293c.containsKey(str)) {
            j.a aVar = f66293c.get(str);
            if (aVar != null) {
                return aVar;
            }
            return null;
        }
        j.a c2 = j.c(str);
        f66293c.put(str, c2);
        if (c2 != null) {
            return c2;
        }
        return null;
    }

    public static void B(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        d.o.a.e.b.g.d.n().a(i2, "guide_auth_dialog_cancel", jSONObject2);
    }

    public static void C(int i2, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i3 = 1;
        try {
            jSONObject.put("scene", z ? 1 : 2);
            if (!z2) {
                i3 = 2;
            }
            jSONObject.put("result_code", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        d.o.a.e.b.g.d.n().a(i2, "guide_auth_result", jSONObject);
    }

    public static boolean E(Context context, Intent intent) {
        return p(context, intent, true);
    }

    public static boolean F(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull d.o.a.e.a.b bVar) {
        if (context != null && jSONObject != null) {
            String F0 = downloadInfo.F0();
            if (TextUtils.isEmpty(F0)) {
                return false;
            }
            bVar.f66289d = SchedulerSupport.CUSTOM;
            d.o.a.e.a.a.a a2 = d.o.a.e.a.a.d.a(context, SchedulerSupport.CUSTOM, jSONObject, downloadInfo);
            if (a2 != null && a2.a()) {
                Intent b2 = a2.b();
                if (b2 == null) {
                    return false;
                }
                if (u(new File(F0), downloadInfo, jSONObject)) {
                    if (E(context, b2)) {
                        bVar.f66287b = 0;
                        return true;
                    }
                    bVar.f66287b = 1;
                } else {
                    bVar.f66287b = 6;
                }
                return false;
            }
            bVar.f66287b = 3;
        }
        return false;
    }

    public static boolean G(JSONObject jSONObject) {
        return jSONObject == null || d.o.a.e.a.h.d.c() || jSONObject.optInt("scy_mode") != 1;
    }

    public static d.o.a.e.a.b H(JSONObject jSONObject) {
        d.o.a.e.a.b bVar = new d.o.a.e.a.b();
        if (jSONObject == null) {
            return bVar;
        }
        bVar.f66286a = jSONObject.optString("type");
        try {
            if (!v(jSONObject.optJSONArray("device_requirements"))) {
                i(bVar, 2);
                return bVar;
            }
            bVar.f66287b = 0;
            return bVar;
        } catch (Throwable th) {
            bVar.f66288c = "check plan_d Config" + e(th);
            i(bVar, 4);
            return bVar;
        }
    }

    public static void I(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        d.o.a.e.b.g.d.n().a(i2, "guide_auth_open_setting", jSONObject2);
    }

    public static void K(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        d.o.a.e.b.g.d.n().a(i2, "guide_auth_dialog_show", jSONObject2);
    }

    public static boolean L(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean M(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        String optString = jSONObject.optString("device_rom");
        if (TextUtils.isEmpty(optString)) {
            return true;
        }
        String i2 = d.o.a.e.a.h.c.i();
        return !TextUtils.isEmpty(i2) && optString.toLowerCase().contains(i2.toLowerCase());
    }

    @RequiresApi(api = 26)
    public static boolean N(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static int a(@NonNull d.o.a.e.b.j.a aVar) {
        JSONObject u = aVar.u("download_dir");
        if (u != null ? !TextUtils.isEmpty(u.optString("dir_name")) : false) {
            if (d.o.a.e.b.j.a.r().l("get_download_info_by_list")) {
                JSONArray v = aVar.v("ah_plans");
                int i2 = -1;
                if (v != null) {
                    int length = v.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject optJSONObject = v.optJSONObject(i3);
                        if (optJSONObject != null && M(optJSONObject) && y(optJSONObject) && G(optJSONObject)) {
                            String optString = optJSONObject.optString("type");
                            if (!"plan_a".equals(optString) && !"plan_b".equals(optString) && !"plan_e".equals(optString) && !"plan_f".equals(optString)) {
                                if ("plan_d".equalsIgnoreCase(optString) && (i2 = H(optJSONObject).f66287b) == 0) {
                                    return 0;
                                }
                            } else {
                                i2 = b(optJSONObject, aVar).f66287b;
                                if (i2 == 0) {
                                    return 0;
                                }
                            }
                        }
                    }
                }
                return i2;
            }
            return 4;
        }
        return 5;
    }

    @NonNull
    public static d.o.a.e.a.b b(JSONObject jSONObject, d.o.a.e.b.j.a aVar) {
        d.o.a.e.a.b bVar = new d.o.a.e.a.b();
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("type");
        bVar.f66286a = optString;
        try {
            boolean v = v(jSONObject.optJSONArray("device_requirements"));
            d.o.a.e.b.c.a.g(f66291a, "requirements fit ? " + v);
            if (!v) {
                i(bVar, 2);
                return bVar;
            }
            if ("plan_b".equals(optString)) {
                bVar.f66290e = SchedulerSupport.CUSTOM;
                if (d.o.a.e.a.a.d.b(d.o.a.e.b.g.d.l(), SchedulerSupport.CUSTOM, jSONObject, aVar)) {
                    bVar.f66287b = 0;
                    return bVar;
                }
                i(bVar, 3);
            } else {
                String optString2 = jSONObject.optString("device_plans");
                bVar.f66290e = optString2;
                if (!TextUtils.isEmpty(optString2)) {
                    for (String str : optString2.split(",")) {
                        if (d.o.a.e.a.a.d.b(d.o.a.e.b.g.d.l(), str, jSONObject, aVar)) {
                            bVar.f66287b = 0;
                            return bVar;
                        }
                        i(bVar, 3);
                    }
                }
            }
            return bVar;
        } catch (Throwable th) {
            bVar.f66288c = "check plan_a Config" + e(th);
            i(bVar, 4);
            return bVar;
        }
    }

    public static j.a d(String str) {
        j.a A;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split != null) {
                for (String str2 : split) {
                    if (!TextUtils.isEmpty(str2) && (A = A(str2)) != null) {
                        return A;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String e(Throwable th) {
        String th2 = th.toString();
        return th2.length() > 800 ? th2.substring(0, 500) : th2;
    }

    public static void f(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        d.o.a.e.b.g.d.n().a(i2, "guide_auth_dialog_confirm", jSONObject2);
    }

    public static void h(Context context, Intent intent, int i2, JSONObject jSONObject, d dVar) {
        if (f66294d != null) {
            d.o.a.e.b.a.a.c().h(f66294d);
            f66294d = null;
        }
        f66294d = new C1813c(context, intent, i2, jSONObject, dVar);
        d.o.a.e.b.a.a.c().f(f66294d);
    }

    public static void i(d.o.a.e.a.b bVar, int i2) {
        int i3 = bVar.f66287b;
        if (i3 != -1) {
            bVar.f66287b = (i3 * 10) + i2;
        } else {
            bVar.f66287b = i2;
        }
    }

    public static void j(e eVar) {
        f66292b = eVar;
    }

    public static boolean k() {
        return g.f66302h == 1;
    }

    public static boolean l(Context context) {
        if (context == null) {
            return true;
        }
        if (d.o.a.e.a.h.c.d() && Build.VERSION.SDK_INT < 26) {
            return L(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return N(context);
        }
        return true;
    }

    public static boolean n(Context context, @Nullable Intent intent, int i2, JSONObject jSONObject) {
        try {
            if (d.o.a.e.a.h.c.d() && Build.VERSION.SDK_INT < 26 && !L(context)) {
                d.o.a.e.a.a.f fVar = new d.o.a.e.a.a.f(context);
                if (fVar.a()) {
                    h(context, intent, i2, jSONObject, new a());
                    return E(context, fVar.b());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !N(context)) {
                d.o.a.e.a.a.b bVar = new d.o.a.e.a.a.b(context);
                if (bVar.a()) {
                    h(context, intent, i2, jSONObject, new b());
                    return E(context, bVar.b());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean o(Context context, @Nullable Intent intent, JSONObject jSONObject, int i2, @Nullable d.o.a.e.a.b bVar) {
        if (context != null && jSONObject != null) {
            long optLong = jSONObject.optLong("jump_interval", 0L);
            if (optLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("sp_ah_config", 0);
            if ((System.currentTimeMillis() - sharedPreferences.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= optLong && !l(context)) {
                sharedPreferences.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, JumpUnknownSourceActivity.class);
                    intent2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i2);
                    try {
                        if (p(context, intent2, false)) {
                            K(i2, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (bVar != null) {
                            bVar.f66287b = 1;
                            bVar.f66288c = "tryShowUnknownSourceDialog" + e(th);
                        }
                        return false;
                    }
                }
                if (n(context, intent, i2, jSONObject)) {
                    I(i2, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean p(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra("start_only_for_android", true);
        context.startActivity(intent);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean q(Context context, DownloadInfo downloadInfo, Intent intent, JSONObject jSONObject, boolean z) {
        char c2;
        d.o.a.e.a.b b2;
        boolean s;
        boolean z2 = false;
        if (jSONObject != null && downloadInfo != null) {
            d.o.a.e.a.b bVar = new d.o.a.e.a.b();
            String optString = jSONObject.optString("type");
            if (!TextUtils.isEmpty(optString)) {
                d.o.a.e.b.j.a f2 = d.o.a.e.b.j.a.f(downloadInfo);
                bVar.f66286a = optString;
                switch (optString.hashCode()) {
                    case -985763637:
                        if (optString.equals("plan_a")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -985763636:
                        if (optString.equals("plan_b")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -985763635:
                        if (optString.equals("plan_c")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -985763634:
                        if (optString.equals("plan_d")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -985763633:
                        if (optString.equals("plan_e")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -985763632:
                        if (optString.equals("plan_f")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -985763631:
                        if (optString.equals("plan_g")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                    case 1:
                        if (!downloadInfo.O1()) {
                            bVar.f66287b = downloadInfo.s(-1);
                            break;
                        }
                    case 2:
                        b2 = b(jSONObject, f2);
                        if (b2.f66287b == 0) {
                            if (optString.equals("plan_f") && TextUtils.isEmpty(downloadInfo.I("file_content_uri"))) {
                                bVar.f66287b = downloadInfo.s(10);
                                break;
                            } else {
                                s = s(context, downloadInfo, jSONObject, bVar);
                                z2 = s;
                                break;
                            }
                        }
                        bVar = b2;
                        break;
                    case 3:
                        b2 = b(jSONObject, f2);
                        if (b2.f66287b == 0) {
                            if (!downloadInfo.O1()) {
                                bVar.f66287b = downloadInfo.s(-1);
                                break;
                            } else {
                                s = F(context, downloadInfo, jSONObject, bVar);
                                z2 = s;
                                break;
                            }
                        }
                        bVar = b2;
                        break;
                    case 4:
                        d.o.a.e.a.b H = H(jSONObject);
                        if (H.f66287b == 0) {
                            try {
                                d.o.a.e.a.d.f(context, intent);
                                bVar.f66287b = 0;
                                z2 = true;
                                break;
                            } catch (Throwable th) {
                                bVar.f66287b = 4;
                                bVar.f66288c = th.toString();
                                break;
                            }
                        } else {
                            bVar = H;
                            break;
                        }
                    case 5:
                        b2 = z(jSONObject, f2);
                        if (b2.f66287b == 0) {
                            s = t(context, downloadInfo, jSONObject, bVar, f2);
                            z2 = s;
                            break;
                        }
                        bVar = b2;
                        break;
                    case 6:
                        if (Build.VERSION.SDK_INT >= 26 || d.o.a.e.a.h.c.d()) {
                            if ((jSONObject.optInt("enable_for_all", 0) == 1) || z) {
                                if (!(jSONObject.optInt("show_unknown_source_on_startup") == 1)) {
                                    s = o(context, intent, jSONObject, downloadInfo.c0(), bVar);
                                    z2 = s;
                                    break;
                                }
                            }
                        }
                        break;
                }
                if (z2) {
                    downloadInfo.L0().put("ah_attempt", bVar.b());
                }
                e eVar = f66292b;
                if (eVar != null) {
                    eVar.a(downloadInfo, bVar);
                }
            }
        }
        return z2;
    }

    public static boolean r(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray v = d.o.a.e.b.j.a.d(downloadInfo.c0()).v("ah_plans");
        if (v != null) {
            int length = v.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = v.optJSONObject(i2);
                if (optJSONObject != null && M(optJSONObject) && y(optJSONObject) && G(optJSONObject) && q(context, downloadInfo, intent, optJSONObject, z)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean s(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, d.o.a.e.a.b bVar) {
        boolean z;
        if (context != null && jSONObject != null) {
            String optString = jSONObject.optString("device_plans");
            bVar.f66290e = optString;
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                String F0 = downloadInfo.F0();
                if (TextUtils.isEmpty(F0)) {
                    return false;
                }
                File file = new File(F0);
                StringBuilder sb = new StringBuilder();
                String str = null;
                int length = split.length;
                int i2 = 0;
                while (true) {
                    z = true;
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    String str2 = split[i2];
                    d.o.a.e.a.a.a a2 = d.o.a.e.a.a.d.a(context, str2, jSONObject, downloadInfo);
                    if (a2 != null) {
                        Intent b2 = a2.b();
                        if (b2 != null) {
                            if (u(file, downloadInfo, jSONObject)) {
                                try {
                                    p(context, b2, false);
                                    str = str2;
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str2);
                                    sb.append(" startActivity failed : ");
                                    sb.append(e(th));
                                    i(bVar, 1);
                                }
                            } else {
                                i(bVar, 6);
                                sb.append(str2);
                                sb.append(" createDescFile failed! ");
                            }
                        } else {
                            i(bVar, 3);
                            sb.append(str2);
                            sb.append(" resolveActivity failed! ");
                        }
                    }
                    sb.append(GlideException.IndentedAppendable.INDENT);
                    i2++;
                }
                if (!z) {
                    bVar.f66288c = sb.toString();
                } else {
                    bVar.f66289d = str;
                    bVar.f66287b = 0;
                }
                return z;
            }
        }
        return false;
    }

    public static boolean t(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull d.o.a.e.a.b bVar, d.o.a.e.b.j.a aVar) {
        boolean z;
        String optString = jSONObject.optString("type");
        bVar.f66286a = optString;
        Intent b2 = d.o.a.e.a.a.d.a(context, "vbi", jSONObject, downloadInfo).b();
        StringBuilder sb = new StringBuilder();
        try {
            z = E(context, b2);
        } catch (Throwable th) {
            sb.append(optString);
            sb.append(" startActivity failed : ");
            sb.append(e(th));
            i(bVar, 1);
            z = false;
        }
        if (!z) {
            bVar.f66288c = sb.toString();
        } else {
            bVar.f66287b = 0;
        }
        return true;
    }

    public static boolean u(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject u = d.o.a.e.b.j.a.d(downloadInfo.c0()).u("download_dir");
        File file2 = null;
        String optString = u != null ? u.optString("ins_desc") : null;
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
            file2 = new File(path + File.separator + optString);
        }
        if (file2 != null) {
            try {
                if (file2.createNewFile()) {
                    file2.deleteOnExit();
                    return true;
                }
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return true;
    }

    public static boolean v(JSONArray jSONArray) {
        int length;
        String[] split;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("package_names");
                JSONArray optJSONArray = optJSONObject.optJSONArray("version_allow");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("version_block");
                String optString2 = optJSONObject.optString("allow_version_range");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                for (String str : optString.split(",")) {
                    if ("market".equals(str)) {
                        str = d.o.a.e.a.h.c.k();
                    }
                    j.a A = A(str);
                    if (A != null && !(z = x(optJSONArray, optJSONArray2, optString2, A))) {
                        return false;
                    }
                }
                continue;
            }
        }
        return z;
    }

    public static boolean w(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i2).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean x(JSONArray jSONArray, JSONArray jSONArray2, String str, @NonNull j.a aVar) {
        String n = aVar.n();
        int m = aVar.m();
        String str2 = m + "_" + n;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("[-,]");
                for (int i2 = 0; i2 < split.length; i2 += 2) {
                    int parseInt = Integer.parseInt(split[i2]);
                    int parseInt2 = Integer.parseInt(split[i2 + 1]);
                    if (m >= parseInt && m <= parseInt2) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (w(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !w(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    public static boolean y(JSONObject jSONObject) {
        int optInt;
        return jSONObject == null || (optInt = jSONObject.optInt("min_os_api", -1)) < 0 || Build.VERSION.SDK_INT >= optInt;
    }

    public static d.o.a.e.a.b z(JSONObject jSONObject, d.o.a.e.b.j.a aVar) {
        d.o.a.e.a.b bVar = new d.o.a.e.a.b();
        if (jSONObject == null) {
            return bVar;
        }
        bVar.f66286a = jSONObject.optString("type");
        try {
            if (!v(jSONObject.optJSONArray("device_requirements"))) {
                i(bVar, 2);
                return bVar;
            }
            bVar.f66290e = "vbi";
            if (d.o.a.e.a.a.d.b(d.o.a.e.b.g.d.l(), "vbi", jSONObject, aVar)) {
                bVar.f66287b = 0;
            } else {
                i(bVar, 3);
            }
            return bVar;
        } catch (Throwable th) {
            bVar.f66288c = "check plan_g Config" + e(th);
            i(bVar, 4);
            return bVar;
        }
    }
}
