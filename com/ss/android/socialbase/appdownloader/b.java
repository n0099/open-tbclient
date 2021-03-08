package com.ss.android.socialbase.appdownloader;

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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.ss.android.socialbase.appdownloader.a.j;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.l.f;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private static final HashMap<String, g.a> b = new HashMap<>();
    private static c qen;
    private static a qeo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.socialbase.appdownloader.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1220b {
        boolean a(@NonNull Context context);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.appdownloader.a aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(Context context, com.ss.android.socialbase.downloader.g.c cVar, Intent intent, boolean z) {
        JSONArray abN = com.ss.android.socialbase.downloader.k.a.Sa(cVar.g()).abN("anti_plans");
        if (abN != null) {
            int length = abN.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = abN.optJSONObject(i);
                if (optJSONObject != null && a(optJSONObject) && b(optJSONObject) && a(context, cVar, intent, optJSONObject, z)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static boolean a(Context context, com.ss.android.socialbase.downloader.g.c cVar, Intent intent, JSONObject jSONObject, boolean z) {
        char c2;
        com.ss.android.socialbase.appdownloader.a fl;
        boolean z2 = false;
        if (jSONObject != null && cVar != null) {
            com.ss.android.socialbase.appdownloader.a aVar = new com.ss.android.socialbase.appdownloader.a();
            String optString = jSONObject.optString("type");
            if (!TextUtils.isEmpty(optString)) {
                aVar.f7742a = optString;
                switch (optString.hashCode()) {
                    case -2097307557:
                        if (optString.equals("jump_file_manager")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1870668843:
                        if (optString.equals("jump_file_manager_custom")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 778176993:
                        if (optString.equals("jump_unknown_source")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1146121817:
                        if (optString.equals("custom_save_path")) {
                            c2 = 3;
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
                        if (Build.VERSION.SDK_INT >= 26 || com.ss.android.socialbase.downloader.m.g.b()) {
                            if ((jSONObject.optInt("enable_for_all", 0) == 1) || z) {
                                z2 = a(context, intent, jSONObject, aVar);
                            }
                            fl = aVar;
                            break;
                        }
                        fl = aVar;
                        break;
                    case 1:
                        fl = fk(jSONObject);
                        if (fl.b == 0) {
                            if (!cVar.eIe()) {
                                aVar.b = cVar.fO(-1);
                                fl = aVar;
                                break;
                            } else {
                                z2 = a(context, cVar, jSONObject, aVar);
                                fl = aVar;
                                break;
                            }
                        }
                        break;
                    case 2:
                        fl = fk(jSONObject);
                        if (fl.b == 0) {
                            if (!cVar.eIe()) {
                                aVar.b = cVar.fO(-1);
                                fl = aVar;
                                break;
                            } else {
                                z2 = b(context, cVar, jSONObject, aVar);
                                fl = aVar;
                                break;
                            }
                        }
                        break;
                    case 3:
                        fl = fl(jSONObject);
                        if (fl.b == 0) {
                            try {
                                com.ss.android.socialbase.appdownloader.c.k(context, intent);
                                aVar.b = 0;
                                fl = aVar;
                                z2 = true;
                                break;
                            } catch (Throwable th) {
                                aVar.b = 4;
                                aVar.c = th.toString();
                                fl = aVar;
                                break;
                            }
                        }
                        break;
                    default:
                        fl = aVar;
                        break;
                }
                if (z2) {
                    cVar.eIh().put("anti_hijack_attempt", fl.a());
                }
                if (qen != null) {
                    qen.a(cVar, fl);
                }
            }
        }
        return z2;
    }

    private static boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        String optString = jSONObject.optString("device_rom");
        if (TextUtils.isEmpty(optString)) {
            return true;
        }
        String f = com.ss.android.socialbase.downloader.m.g.f();
        return !TextUtils.isEmpty(f) && optString.toLowerCase().contains(f.toLowerCase());
    }

    private static boolean b(JSONObject jSONObject) {
        int optInt;
        return jSONObject == null || (optInt = jSONObject.optInt("min_os_api", -1)) < 0 || Build.VERSION.SDK_INT >= optInt;
    }

    private static boolean a(Context context, com.ss.android.socialbase.downloader.g.c cVar, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.a aVar) {
        String str;
        boolean z = true;
        if (context == null || jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("device_plans");
        aVar.e = optString;
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        String[] split = optString.split(",");
        String k = cVar.k();
        if (TextUtils.isEmpty(k)) {
            return false;
        }
        File file = new File(k);
        StringBuilder sb = new StringBuilder();
        int length = split.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = null;
                z = false;
                break;
            }
            str = split[i];
            com.ss.android.socialbase.appdownloader.a.a a2 = com.ss.android.socialbase.appdownloader.a.d.a(context, str, jSONObject, cVar);
            if (a2 != null) {
                Intent b2 = a2.b();
                if (b2 != null) {
                    if (a(file, cVar, jSONObject)) {
                        try {
                            c(context, b2, false);
                            break;
                        } catch (Throwable th) {
                            sb.append(str).append(" startActivity failed : ").append(a(th));
                            a(aVar, 1);
                        }
                    } else {
                        a(aVar, 6);
                        sb.append(str).append(" createDescFile failed! ");
                    }
                } else {
                    a(aVar, 3);
                    sb.append(str).append(" resolveActivity failed! ");
                }
            }
            sb.append("  ");
            i++;
        }
        if (!z) {
            aVar.c = sb.toString();
        } else {
            aVar.d = str;
            aVar.b = 0;
        }
        return z;
    }

    private static boolean b(Context context, @NonNull com.ss.android.socialbase.downloader.g.c cVar, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.a aVar) {
        if (context == null || jSONObject == null) {
            return false;
        }
        String k = cVar.k();
        if (TextUtils.isEmpty(k)) {
            return false;
        }
        aVar.d = "custom";
        com.ss.android.socialbase.appdownloader.a.a a2 = com.ss.android.socialbase.appdownloader.a.d.a(context, "custom", jSONObject, cVar);
        if (a2 == null || !a2.a()) {
            aVar.b = 3;
            return false;
        }
        Intent b2 = a2.b();
        if (b2 != null) {
            if (a(new File(k), cVar, jSONObject)) {
                if (j(context, b2)) {
                    aVar.b = 0;
                    return true;
                }
                aVar.b = 1;
                return false;
            }
            aVar.b = 6;
            return false;
        }
        return false;
    }

    public static int d(@NonNull com.ss.android.socialbase.downloader.k.a aVar) {
        boolean z;
        int i;
        JSONObject abM = aVar.abM("anti_hijack_dir");
        if (abM != null) {
            z = !TextUtils.isEmpty(abM.optString("dir_name"));
        } else {
            z = false;
        }
        if (!z) {
            return 5;
        }
        if (!com.ss.android.socialbase.downloader.k.a.eIH().a("get_download_info_by_list")) {
            return 4;
        }
        JSONArray abN = aVar.abN("anti_plans");
        if (abN == null) {
            i = -1;
        } else {
            int length = abN.length();
            i = -1;
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = abN.optJSONObject(i2);
                if (optJSONObject != null && a(optJSONObject) && b(optJSONObject)) {
                    String optString = optJSONObject.optString("type");
                    if ("jump_file_manager".equals(optString) || "jump_file_manager_custom".equals(optString)) {
                        com.ss.android.socialbase.appdownloader.a fk = fk(optJSONObject);
                        i = fk.b;
                        if (fk.b == 0) {
                            return 0;
                        }
                    } else if ("custom_save_path".equalsIgnoreCase(optString)) {
                        com.ss.android.socialbase.appdownloader.a fl = fl(optJSONObject);
                        i = fl.b;
                        if (fl.b == 0) {
                            return 0;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return i;
    }

    @NonNull
    private static com.ss.android.socialbase.appdownloader.a fk(JSONObject jSONObject) {
        com.ss.android.socialbase.appdownloader.a aVar = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject != null) {
            String optString = jSONObject.optString("type");
            aVar.f7742a = optString;
            try {
                if (!ac(jSONObject.optJSONArray("device_requirements"))) {
                    a(aVar, 2);
                } else if ("jump_file_manager_custom".equals(optString)) {
                    aVar.e = "custom";
                    if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.b.eGG(), "custom", jSONObject)) {
                        aVar.b = 0;
                    } else {
                        a(aVar, 3);
                    }
                } else {
                    String optString2 = jSONObject.optString("device_plans");
                    aVar.e = optString2;
                    if (!TextUtils.isEmpty(optString2)) {
                        String[] split = optString2.split(",");
                        int length = split.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.b.eGG(), split[i], jSONObject)) {
                                aVar.b = 0;
                                break;
                            }
                            a(aVar, 3);
                            i++;
                        }
                    }
                }
            } catch (Throwable th) {
                aVar.c = "checkJumpFileManagerConfig" + a(th);
                a(aVar, 4);
            }
        }
        return aVar;
    }

    private static com.ss.android.socialbase.appdownloader.a fl(JSONObject jSONObject) {
        com.ss.android.socialbase.appdownloader.a aVar = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject != null) {
            aVar.f7742a = jSONObject.optString("type");
            try {
                if (!ac(jSONObject.optJSONArray("device_requirements"))) {
                    a(aVar, 2);
                } else {
                    aVar.b = 0;
                }
            } catch (Throwable th) {
                aVar.c = "checkCustomSavePathConfig" + a(th);
                a(aVar, 4);
            }
        }
        return aVar;
    }

    private static void a(com.ss.android.socialbase.appdownloader.a aVar, int i) {
        if (aVar.b != -1) {
            aVar.b = (aVar.b * 10) + i;
        } else {
            aVar.b = i;
        }
    }

    public static boolean ac(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean z = false;
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("package_names");
                JSONArray optJSONArray = optJSONObject.optJSONArray("version_white");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("version_black");
                if (TextUtils.isEmpty(optString) || (optJSONArray == null && optJSONArray2 == null)) {
                    return false;
                }
                String[] split = optString.split(",");
                if (split != null) {
                    for (String str : split) {
                        g.a abg = abg(str);
                        if (abg != null && !(z = a(optJSONArray, optJSONArray2, abg))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return z;
    }

    private static g.a abg(String str) {
        if (b.containsKey(str)) {
            g.a aVar = b.get(str);
            if (aVar != null) {
                return aVar;
            }
        } else {
            g.a abh = g.abh(str);
            b.put(str, abh);
            if (abh != null) {
                return abh;
            }
        }
        return null;
    }

    @NonNull
    public static g.a abh(String str) {
        g.a abg;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split != null) {
                for (String str2 : split) {
                    if (!TextUtils.isEmpty(str2) && (abg = abg(str2)) != null) {
                        return abg;
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2, g.a aVar) {
        String str = aVar.f() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + aVar.g();
        if (jSONArray != null && jSONArray.length() > 0) {
            if (e(jSONArray, str)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !e(jSONArray2, str)) {
            return true;
        }
        return false;
    }

    private static boolean e(JSONArray jSONArray, String str) {
        if (jSONArray == null || str == null) {
            return false;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            if (str.equalsIgnoreCase(jSONArray.optString(i).trim())) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(File file, com.ss.android.socialbase.downloader.g.c cVar, @NonNull JSONObject jSONObject) {
        File file2 = null;
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject abM = com.ss.android.socialbase.downloader.k.a.Sa(cVar.g()).abM("anti_hijack_dir");
        String optString = abM != null ? abM.optString("ins_desc") : null;
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
            file2 = new File(path + File.separator + optString);
        }
        if (file2 != null) {
            try {
                if (file2.createNewFile()) {
                    file2.deleteOnExit();
                }
            } catch (IOException e2) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(Context context, @Nullable Intent intent, JSONObject jSONObject, @Nullable com.ss.android.socialbase.appdownloader.a aVar) {
        int optInt;
        SharedPreferences sharedPreferences;
        int i;
        if (context == null || jSONObject == null || (optInt = jSONObject.optInt("max_jump_count", 0)) <= 0 || (i = (sharedPreferences = context.getSharedPreferences("sp_anti_hijack_config", 0)).getInt("jump_unknown_source_count", 0)) >= optInt || a(context)) {
            return false;
        }
        sharedPreferences.edit().putInt("jump_unknown_source_count", i + 1).apply();
        Intent intent2 = new Intent(context, JumpUnknownSourceActivity.class);
        intent2.addFlags(268435456);
        intent2.putExtra("intent", intent);
        intent2.putExtra("config", jSONObject.toString());
        try {
            c(context, intent2, false);
            if (aVar != null) {
                aVar.b = 0;
            }
            return true;
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.b = 1;
                aVar.c = "tryShowUnknownSourceDialog" + a(th);
                return false;
            }
            return false;
        }
    }

    public static boolean a(Context context, @Nullable Intent intent, JSONObject jSONObject) {
        boolean z = false;
        try {
            if (com.ss.android.socialbase.downloader.m.g.b() && Build.VERSION.SDK_INT < 26) {
                if (!d(context)) {
                    j jVar = new j(context);
                    if (jVar.a()) {
                        a(context, intent, jSONObject, new InterfaceC1220b() { // from class: com.ss.android.socialbase.appdownloader.b.1
                            @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC1220b
                            public boolean a(@NonNull Context context2) {
                                return b.d(context2);
                            }
                        });
                        z = j(context, jVar.b());
                    } else {
                        z = true;
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !e(context)) {
                com.ss.android.socialbase.appdownloader.a.b bVar = new com.ss.android.socialbase.appdownloader.a.b(context);
                if (bVar.a()) {
                    a(context, intent, jSONObject, new InterfaceC1220b() { // from class: com.ss.android.socialbase.appdownloader.b.2
                        @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC1220b
                        public boolean a(@NonNull Context context2) {
                            return b.e(context2);
                        }
                    });
                    z = j(context, bVar.b());
                }
            }
        } catch (Throwable th) {
        }
        return z;
    }

    public static boolean a(Context context) {
        boolean z = true;
        if (context != null) {
            try {
                if (com.ss.android.socialbase.downloader.m.g.b() && Build.VERSION.SDK_INT < 26) {
                    z = d(context);
                } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
                    z = e(context);
                }
            } catch (Throwable th) {
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable th) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable th) {
            return true;
        }
    }

    private static void a(Context context, Intent intent, JSONObject jSONObject, InterfaceC1220b interfaceC1220b) {
        if (qeo != null) {
            com.ss.android.socialbase.downloader.a.a.eGc().b(qeo);
            qeo = null;
        }
        qeo = new a(context, intent, jSONObject, interfaceC1220b);
        com.ss.android.socialbase.downloader.a.a.eGc().a(qeo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean j(Context context, Intent intent) {
        return c(context, intent, true);
    }

    public static boolean c(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.putExtra("start_only_for_android", true);
        context.startActivity(intent);
        return true;
    }

    public static String a(Throwable th) {
        String th2 = th.toString();
        if (th2.length() > 800) {
            return th2.substring(0, 500);
        }
        return th2;
    }

    /* loaded from: classes6.dex */
    private static class d implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f7746a;
        private final Handler c;
        private final long d;
        private final InterfaceC1220b qeq;

        public d(Handler handler, Context context, InterfaceC1220b interfaceC1220b, long j) {
            this.f7746a = context;
            this.qeq = interfaceC1220b;
            this.c = handler;
            this.d = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            if (this.qeq == null || this.d <= 0 || this.d > 10000) {
                return false;
            }
            Context context = this.f7746a;
            boolean a2 = context != null ? this.qeq.a(context) : false;
            Message obtain = Message.obtain();
            if (a2) {
                obtain.what = 2;
                this.c.sendMessage(obtain);
            } else {
                obtain.what = 1;
                this.c.sendMessageDelayed(obtain, this.d);
            }
            return false;
        }
    }

    public static void a(c cVar) {
        qen = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements a.InterfaceC1223a {
        private final int b;
        private JSONObject c;
        private final e qep;

        public a(Context context, Intent intent, JSONObject jSONObject, InterfaceC1220b interfaceC1220b) {
            this.c = jSONObject;
            this.b = jSONObject.optInt("query_interval", 1000);
            this.qep = new e(context, intent, interfaceC1220b, this.b);
        }

        @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1223a
        public void b() {
            if (!this.qep.g) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.qep.d.sendMessage(obtain);
            }
            com.ss.android.socialbase.downloader.a.a.eGc().b(this);
            a unused = b.qeo = null;
        }

        @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1223a
        public void c() {
            if (Build.VERSION.SDK_INT < 29) {
                int optInt = this.c.optInt("time_out_second", 10);
                Message obtain = Message.obtain();
                obtain.what = 1;
                this.qep.d.sendMessage(obtain);
                if (optInt > 0 && optInt < 60) {
                    Message obtain2 = Message.obtain();
                    obtain2.what = 2;
                    this.qep.d.sendMessageDelayed(obtain2, optInt * 1000);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    private static class e implements f.a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f7747a;
        private final Intent b;
        private final long e;
        private final InterfaceC1220b qer;
        private Future<Boolean> qes;
        private boolean g = false;
        private final Handler d = new com.ss.android.socialbase.downloader.l.f(Looper.getMainLooper(), this);

        public e(Context context, Intent intent, InterfaceC1220b interfaceC1220b, long j) {
            this.f7747a = context;
            this.b = intent;
            this.qer = interfaceC1220b;
            this.e = j;
        }

        @Override // com.ss.android.socialbase.downloader.l.f.a
        public void a(Message message) {
            if (message != null) {
                if (message.what == 1) {
                    if (this.e > 0 && this.e <= 10000) {
                        this.qes = com.ss.android.socialbase.downloader.downloader.b.eGo().submit(new d(this.d, this.f7747a, this.qer, this.e));
                    }
                } else if (message.what == 2) {
                    this.d.removeMessages(2);
                    this.d.removeMessages(1);
                    if (this.qes != null) {
                        this.qes.cancel(true);
                    }
                    if (!this.g) {
                        b.j(this.f7747a, this.b);
                        this.g = true;
                    }
                }
            }
        }
    }
}
