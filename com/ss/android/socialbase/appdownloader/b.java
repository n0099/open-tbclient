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
import androidx.annotation.RequiresApi;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.bumptech.glide.load.engine.GlideException;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.h.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static final String a = "b";

    /* renamed from: b  reason: collision with root package name */
    public static c f62052b;

    /* renamed from: c  reason: collision with root package name */
    public static a f62053c;

    /* loaded from: classes3.dex */
    public static class a implements a.InterfaceC2180a {
        public final e a;

        /* renamed from: b  reason: collision with root package name */
        public final int f62054b;

        /* renamed from: c  reason: collision with root package name */
        public JSONObject f62055c;

        public a(Context context, Intent intent, int i2, JSONObject jSONObject, InterfaceC2177b interfaceC2177b) {
            this.f62055c = jSONObject;
            int optInt = jSONObject.optInt("query_interval", 1000);
            this.f62054b = optInt;
            this.a = new e(context, intent, i2, interfaceC2177b, optInt);
        }

        @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC2180a
        public void b() {
            if (!this.a.f62066i) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.a.f62063f.sendMessage(obtain);
            }
            com.ss.android.socialbase.downloader.a.a.a().b(this);
            a unused = b.f62053c = null;
        }

        @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC2180a
        public void c() {
            int optInt = this.f62055c.optInt("time_out_second", 20);
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.a.f62063f.sendMessage(obtain);
            if (optInt <= 0 || optInt >= 60) {
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            this.a.f62063f.sendMessageDelayed(obtain2, optInt * 1000);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2177b {
        boolean a(@NonNull Context context);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar);
    }

    /* loaded from: classes3.dex */
    public static class d implements Callable<Boolean> {
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public final InterfaceC2177b f62056b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f62057c;

        /* renamed from: d  reason: collision with root package name */
        public final long f62058d;

        public d(Handler handler, Context context, InterfaceC2177b interfaceC2177b, long j2) {
            this.a = context;
            this.f62056b = interfaceC2177b;
            this.f62057c = handler;
            this.f62058d = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            if (this.f62056b != null && this.f62058d > 0 && this.f62058d <= 10000) {
                Context context = this.a;
                boolean a = context != null ? this.f62056b.a(context) : false;
                Message obtain = Message.obtain();
                if (a) {
                    obtain.what = 2;
                    this.f62057c.sendMessage(obtain);
                } else {
                    obtain.what = 1;
                    this.f62057c.sendMessageDelayed(obtain, this.f62058d);
                }
                return Boolean.FALSE;
            }
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements h.a {
        public static int a;

        /* renamed from: b  reason: collision with root package name */
        public static int f62059b;

        /* renamed from: c  reason: collision with root package name */
        public final Context f62060c;

        /* renamed from: d  reason: collision with root package name */
        public final Intent f62061d;

        /* renamed from: e  reason: collision with root package name */
        public final InterfaceC2177b f62062e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f62063f;

        /* renamed from: g  reason: collision with root package name */
        public final long f62064g;

        /* renamed from: h  reason: collision with root package name */
        public Future<Boolean> f62065h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f62066i = false;

        public e(Context context, Intent intent, int i2, InterfaceC2177b interfaceC2177b, long j2) {
            this.f62060c = context;
            this.f62061d = intent;
            f62059b = i2;
            this.f62062e = interfaceC2177b;
            this.f62063f = new com.ss.android.socialbase.downloader.h.h(Looper.getMainLooper(), this);
            this.f62064g = j2;
        }

        @Override // com.ss.android.socialbase.downloader.h.h.a
        public void a(Message message) {
            if (message != null) {
                int i2 = message.what;
                if (i2 == 1) {
                    long j2 = this.f62064g;
                    if (j2 <= 0 || j2 > 10000) {
                        return;
                    }
                    a = 1;
                    this.f62065h = com.ss.android.socialbase.downloader.downloader.c.l().submit(new d(this.f62063f, this.f62060c, this.f62062e, this.f62064g));
                } else if (i2 == 2) {
                    a = 2;
                    this.f62063f.removeMessages(2);
                    this.f62063f.removeMessages(1);
                    Future<Boolean> future = this.f62065h;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.f62066i && (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.a.a.a().b())) {
                        Intent intent = this.f62061d;
                        if (intent != null) {
                            b.b(this.f62060c, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.f62060c).getDownloadInfo(f62059b);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.c.b(this.f62060c, f62059b, false);
                            }
                        }
                        this.f62066i = true;
                    }
                    b.b(f62059b, this.f62061d == null, b.a(this.f62060c));
                }
            }
        }
    }

    public static boolean d(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    @RequiresApi(api = 26)
    public static boolean e(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean b(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.a aVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            aVar.f62045d = "custom";
            com.ss.android.socialbase.appdownloader.a.a a2 = com.ss.android.socialbase.appdownloader.a.d.a(context, "custom", jSONObject, downloadInfo);
            if (a2 != null && a2.a()) {
                Intent b2 = a2.b();
                if (b2 == null) {
                    return false;
                }
                if (a(new File(savePath), downloadInfo, jSONObject)) {
                    if (b(context, b2)) {
                        aVar.f62043b = 0;
                        return true;
                    }
                    aVar.f62043b = 1;
                } else {
                    aVar.f62043b = 6;
                }
                return false;
            }
            aVar.f62043b = 3;
        }
        return false;
    }

    public static void c(int i2, JSONObject jSONObject) {
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
        com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_open_setting", jSONObject2);
    }

    public static void d(int i2, JSONObject jSONObject) {
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
        com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_dialog_show", jSONObject2);
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray e2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).e("ah_plans");
        if (e2 != null) {
            int length = e2.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = e2.optJSONObject(i2);
                if (com.ss.android.socialbase.appdownloader.f.a.a(optJSONObject) && a(context, downloadInfo, intent, optJSONObject, z)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean a(Context context, DownloadInfo downloadInfo, Intent intent, JSONObject jSONObject, boolean z) {
        char c2;
        com.ss.android.socialbase.appdownloader.a a2;
        boolean a3;
        boolean z2 = false;
        if (jSONObject != null && downloadInfo != null) {
            com.ss.android.socialbase.appdownloader.a aVar = new com.ss.android.socialbase.appdownloader.a();
            String optString = jSONObject.optString("type");
            if (!TextUtils.isEmpty(optString)) {
                com.ss.android.socialbase.downloader.g.a a4 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo);
                aVar.a = optString;
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
                            c2 = 7;
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
                    case -985763630:
                        if (optString.equals("plan_h")) {
                            c2 = 6;
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
                        if (!downloadInfo.isSavePathRedirected()) {
                            aVar.f62043b = downloadInfo.getAntiHijackErrorCode(-1);
                            break;
                        }
                    case 2:
                        a2 = a(jSONObject, a4);
                        if (a2.f62043b == 0) {
                            if (optString.equals("plan_f") && TextUtils.isEmpty(downloadInfo.getDBJsonString("file_content_uri"))) {
                                aVar.f62043b = downloadInfo.getAntiHijackErrorCode(10);
                                break;
                            } else {
                                a3 = a(context, downloadInfo, jSONObject, aVar);
                                z2 = a3;
                                break;
                            }
                        }
                        aVar = a2;
                        break;
                    case 3:
                        a2 = a(jSONObject, a4);
                        if (a2.f62043b == 0) {
                            if (!downloadInfo.isSavePathRedirected()) {
                                aVar.f62043b = downloadInfo.getAntiHijackErrorCode(-1);
                                break;
                            } else {
                                a3 = b(context, downloadInfo, jSONObject, aVar);
                                z2 = a3;
                                break;
                            }
                        }
                        aVar = a2;
                        break;
                    case 4:
                        aVar.a = "plan_d";
                        if (!com.ss.android.socialbase.appdownloader.f.d.c()) {
                            aVar.f62043b = 2;
                            break;
                        } else {
                            try {
                                com.ss.android.socialbase.appdownloader.c.a(context, intent);
                                aVar.f62043b = 0;
                                z2 = true;
                                break;
                            } catch (Throwable th) {
                                aVar.f62043b = 4;
                                aVar.f62044c = th.toString();
                                break;
                            }
                        }
                    case 5:
                        a2 = b(jSONObject, a4);
                        if (a2.f62043b == 0) {
                            a3 = a(context, downloadInfo, jSONObject, aVar, a4);
                            z2 = a3;
                            break;
                        }
                        aVar = a2;
                        break;
                    case 6:
                        String a5 = com.ss.android.socialbase.appdownloader.f.c.a(a4.c("bh"), a4.c("s"));
                        com.ss.android.socialbase.appdownloader.a a6 = a(jSONObject, a5, context, a4);
                        if (a6.f62043b == 0) {
                            String packageName = context.getPackageName();
                            if (com.ss.android.socialbase.appdownloader.f.a.a(com.ss.android.socialbase.downloader.g.a.b(), context, a5)) {
                                try {
                                    com.ss.android.socialbase.appdownloader.c.a(context, intent);
                                    aVar.f62043b = 0;
                                    z2 = true;
                                    break;
                                } catch (Throwable th2) {
                                    try {
                                        aVar.f62043b = 1;
                                        aVar.f62044c = th2.toString();
                                        break;
                                    } finally {
                                        com.ss.android.socialbase.appdownloader.f.a.a(com.ss.android.socialbase.downloader.g.a.b(), context, packageName);
                                    }
                                }
                            } else {
                                aVar.f62043b = 11;
                                break;
                            }
                        } else {
                            aVar = a6;
                            break;
                        }
                    case 7:
                        if (Build.VERSION.SDK_INT >= 26 || com.ss.android.socialbase.appdownloader.f.d.b()) {
                            if ((jSONObject.optInt("enable_for_all", 0) == 1) || z) {
                                if (!(jSONObject.optInt("show_unknown_source_on_startup") == 1)) {
                                    a3 = a(context, intent, jSONObject, downloadInfo.getId(), aVar);
                                    z2 = a3;
                                    break;
                                }
                            }
                        }
                        break;
                }
                if (z2) {
                    downloadInfo.getTempCacheData().put("ah_attempt", aVar.a());
                }
                if (f62052b != null) {
                    downloadInfo.getTempCacheData().put("intent", intent);
                    f62052b.a(downloadInfo, aVar);
                }
            }
        }
        return z2;
    }

    public static com.ss.android.socialbase.appdownloader.a b(JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        com.ss.android.socialbase.appdownloader.a aVar2 = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject == null) {
            return aVar2;
        }
        aVar2.a = jSONObject.optString("type");
        aVar2.f62046e = "vbi";
        if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.c.N(), "vbi", jSONObject, aVar)) {
            aVar2.f62043b = 0;
        } else {
            a(aVar2, 3);
        }
        return aVar2;
    }

    public static void b(int i2, JSONObject jSONObject) {
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
        com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_dialog_cancel", jSONObject2);
    }

    public static void b(int i2, boolean z, boolean z2) {
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
        com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_result", jSONObject);
    }

    public static boolean b(Context context, Intent intent) {
        return a(context, intent, true);
    }

    public static boolean a(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.a aVar, com.ss.android.socialbase.downloader.g.a aVar2) {
        boolean z;
        String optString = jSONObject.optString("type");
        aVar.a = optString;
        Intent b2 = com.ss.android.socialbase.appdownloader.a.d.a(context, "vbi", jSONObject, downloadInfo).b();
        StringBuilder sb = new StringBuilder();
        try {
            z = b(context, b2);
        } catch (Throwable th) {
            sb.append(optString);
            sb.append(" startActivity failed : ");
            sb.append(a(th));
            a(aVar, 1);
            z = false;
        }
        if (!z) {
            aVar.f62044c = sb.toString();
        } else {
            aVar.f62043b = 0;
        }
        return true;
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.a aVar) {
        boolean z;
        if (context != null && jSONObject != null) {
            String optString = jSONObject.optString("device_plans");
            aVar.f62046e = optString;
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
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
                    com.ss.android.socialbase.appdownloader.a.a a2 = com.ss.android.socialbase.appdownloader.a.d.a(context, str2, jSONObject, downloadInfo);
                    if (a2 != null) {
                        Intent b2 = a2.b();
                        if (b2 != null) {
                            if (a(file, downloadInfo, jSONObject)) {
                                try {
                                    a(context, b2, false);
                                    str = str2;
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str2);
                                    sb.append(" startActivity failed : ");
                                    sb.append(a(th));
                                    a(aVar, 1);
                                }
                            } else {
                                a(aVar, 6);
                                sb.append(str2);
                                sb.append(" createDescFile failed! ");
                            }
                        } else {
                            a(aVar, 3);
                            sb.append(str2);
                            sb.append(" resolveActivity failed! ");
                        }
                    }
                    sb.append(GlideException.IndentedAppendable.INDENT);
                    i2++;
                }
                if (!z) {
                    aVar.f62044c = sb.toString();
                } else {
                    aVar.f62045d = str;
                    aVar.f62043b = 0;
                }
                return z;
            }
        }
        return false;
    }

    public static int a(@NonNull com.ss.android.socialbase.downloader.g.a aVar) {
        JSONObject d2 = aVar.d("download_dir");
        if (d2 != null ? !TextUtils.isEmpty(d2.optString("dir_name")) : false) {
            if (com.ss.android.socialbase.downloader.g.a.c().a("get_download_info_by_list")) {
                JSONArray e2 = aVar.e("ah_plans");
                int i2 = -1;
                if (e2 != null) {
                    int length = e2.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject optJSONObject = e2.optJSONObject(i3);
                        if (com.ss.android.socialbase.appdownloader.f.a.a(optJSONObject)) {
                            String optString = optJSONObject.optString("type");
                            if (!"plan_a".equals(optString) && !"plan_b".equals(optString) && !"plan_e".equals(optString) && !"plan_f".equals(optString)) {
                                if ("plan_d".equalsIgnoreCase(optString) || "plan_h".equalsIgnoreCase(optString) || ("plan_g".equalsIgnoreCase(optString) && (i2 = b(optJSONObject, aVar).f62043b) == 0)) {
                                    return 0;
                                }
                            } else {
                                i2 = a(optJSONObject, aVar).f62043b;
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
    public static com.ss.android.socialbase.appdownloader.a a(JSONObject jSONObject, com.ss.android.socialbase.downloader.g.a aVar) {
        com.ss.android.socialbase.appdownloader.a aVar2 = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject == null) {
            return aVar2;
        }
        String optString = jSONObject.optString("type");
        aVar2.a = optString;
        if ("plan_b".equals(optString)) {
            aVar2.f62046e = "custom";
            if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.c.N(), "custom", jSONObject, aVar)) {
                aVar2.f62043b = 0;
                return aVar2;
            }
            a(aVar2, 3);
        } else {
            String optString2 = jSONObject.optString("device_plans");
            aVar2.f62046e = optString2;
            if (!TextUtils.isEmpty(optString2)) {
                for (String str : optString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.a.d.a(com.ss.android.socialbase.downloader.downloader.c.N(), str, jSONObject, aVar)) {
                        aVar2.f62043b = 0;
                        return aVar2;
                    }
                    a(aVar2, 3);
                }
            }
        }
        return aVar2;
    }

    public static com.ss.android.socialbase.appdownloader.a a(JSONObject jSONObject, String str, Context context, com.ss.android.socialbase.downloader.g.a aVar) {
        com.ss.android.socialbase.appdownloader.a aVar2 = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.f.d.b()) {
            aVar2.a = jSONObject.optString("type");
            if (aVar.a(NotificationStyle.BANNER_IMAGE_URL, 0) == 1) {
                aVar2.f62043b = 0;
                return aVar2;
            } else if (a(context)) {
                aVar2.f62043b = 2;
            } else if (com.ss.android.socialbase.appdownloader.f.a.a(str) != null) {
                aVar2.f62043b = 0;
            } else {
                aVar2.f62043b = 9;
            }
        }
        return aVar2;
    }

    public static void a(com.ss.android.socialbase.appdownloader.a aVar, int i2) {
        int i3 = aVar.f62043b;
        if (i3 != -1) {
            aVar.f62043b = (i3 * 10) + i2;
        } else {
            aVar.f62043b = i2;
        }
    }

    public static boolean a(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject d2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).d("download_dir");
        File file2 = null;
        String optString = d2 != null ? d2.optString("ins_desc") : null;
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

    public static boolean a(Context context, @Nullable Intent intent, JSONObject jSONObject, int i2, @Nullable com.ss.android.socialbase.appdownloader.a aVar) {
        if (context != null && jSONObject != null) {
            long optLong = jSONObject.optLong("jump_interval", 0L);
            if (optLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("sp_ah_config", 0);
            if ((System.currentTimeMillis() - sharedPreferences.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= optLong && !a(context)) {
                sharedPreferences.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, JumpUnknownSourceActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, jSONObject.toString());
                    intent2.putExtra("id", i2);
                    try {
                        if (a(context, intent2, false)) {
                            d(i2, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (aVar != null) {
                            aVar.f62043b = 1;
                            aVar.f62044c = "tryShowUnknownSourceDialog" + a(th);
                        }
                        return false;
                    }
                }
                if (a(context, intent, i2, jSONObject)) {
                    c(i2, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context, @Nullable Intent intent, int i2, JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.f.d.b() && Build.VERSION.SDK_INT < 26 && !d(context)) {
                com.ss.android.socialbase.appdownloader.a.f fVar = new com.ss.android.socialbase.appdownloader.a.f(context);
                if (fVar.a()) {
                    a(context, intent, i2, jSONObject, new InterfaceC2177b() { // from class: com.ss.android.socialbase.appdownloader.b.1
                        @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC2177b
                        public boolean a(@NonNull Context context2) {
                            return b.d(context2);
                        }
                    });
                    return b(context, fVar.b());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !e(context)) {
                com.ss.android.socialbase.appdownloader.a.b bVar = new com.ss.android.socialbase.appdownloader.a.b(context);
                if (bVar.a()) {
                    a(context, intent, i2, jSONObject, new InterfaceC2177b() { // from class: com.ss.android.socialbase.appdownloader.b.2
                        @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC2177b
                        public boolean a(@NonNull Context context2) {
                            return b.e(context2);
                        }
                    });
                    return b(context, bVar.b());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.f.d.b() && Build.VERSION.SDK_INT < 26) {
            return d(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return e(context);
        }
        return true;
    }

    public static boolean a() {
        return e.a == 1;
    }

    public static void a(int i2, JSONObject jSONObject) {
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
        com.ss.android.socialbase.downloader.downloader.c.P().b(i2, "guide_auth_dialog_confirm", jSONObject2);
    }

    public static void a(Context context, Intent intent, int i2, JSONObject jSONObject, InterfaceC2177b interfaceC2177b) {
        if (f62053c != null) {
            com.ss.android.socialbase.downloader.a.a.a().b(f62053c);
            f62053c = null;
        }
        f62053c = new a(context, intent, i2, jSONObject, interfaceC2177b);
        com.ss.android.socialbase.downloader.a.a.a().a(f62053c);
    }

    public static boolean a(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        context.startActivity(intent);
        return true;
    }

    public static String a(Throwable th) {
        String th2 = th.toString();
        return th2.length() > 800 ? th2.substring(0, 500) : th2;
    }

    public static void a(c cVar) {
        f62052b = cVar;
    }
}
