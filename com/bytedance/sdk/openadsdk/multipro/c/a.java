package com.bytedance.sdk.openadsdk.multipro.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.l;
import com.bytedance.sdk.openadsdk.c.n;
import com.bytedance.sdk.openadsdk.c.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.g.c.c;
import com.bytedance.sdk.openadsdk.multipro.e;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.yy.videoplayer.stat.VideoPlayerStatistic;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements com.bytedance.sdk.openadsdk.multipro.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f4919a;

    private static ContentResolver e() {
        try {
            if (p.a() != null) {
                return p.a().getContentResolver();
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static void c() {
        if (p.a() != null) {
            try {
                ContentResolver e = e();
                if (e != null) {
                    e.getType(Uri.parse(f() + "adEventStart"));
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void a(boolean z) {
        if (p.a() != null) {
            try {
                ContentResolver e = e();
                if (e != null) {
                    e.getType(Uri.parse(f() + "logStatusStart" + ("?isRealTime=" + String.valueOf(z))));
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            u.b("AdEventProviderImpl", "dispatch event");
            try {
                ContentResolver e = e();
                if (e != null) {
                    e.getType(Uri.parse(f() + "adEventDispatch?event=" + com.bytedance.sdk.openadsdk.multipro.c.a(str)));
                }
            } catch (Throwable th) {
                u.f("AdEventProviderImpl", "dispatch event Throwable:" + th.toString());
            }
        }
    }

    public static void a(String str, List<String> list, boolean z) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                for (String str2 : list) {
                    sb.append(com.bytedance.sdk.openadsdk.multipro.c.a(str2)).append(",");
                }
                String str3 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(com.bytedance.sdk.openadsdk.multipro.c.a(sb.toString())) + "&replace=" + String.valueOf(z);
                ContentResolver e = e();
                if (e != null) {
                    e.getType(Uri.parse(f() + "trackUrl" + str3));
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ContentResolver e = e();
                if (e != null) {
                    e.getType(Uri.parse(f() + "trackFailed?did=" + String.valueOf(str)));
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void d() {
        try {
            ContentResolver e = e();
            if (e != null) {
                e.getType(Uri.parse(f() + "logStatusInit"));
            }
        } catch (Throwable th) {
        }
    }

    public static void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ContentResolver e = e();
                if (e != null) {
                    e.getType(Uri.parse(f() + "logStatusUpload?event=" + com.bytedance.sdk.openadsdk.multipro.c.a(str)));
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ContentResolver e = e();
                if (e != null) {
                    e.getType(Uri.parse(f() + "logStatusDispatch" + ("?event=" + com.bytedance.sdk.openadsdk.multipro.c.a(str) + "&isRealTime=" + String.valueOf(z))));
                }
            } catch (Throwable th) {
            }
        }
    }

    private static String f() {
        return e.b + "/t_event_ad_event/";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        this.f4919a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    @NonNull
    public String a() {
        return "t_event_ad_event";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(@NonNull Uri uri) {
        String queryParameter;
        String str = uri.getPath().split("/")[2];
        if ("adEventStart".equals(str)) {
            u.b("AdEventProviderImpl", "====ad event function will be start====");
            b.a().a();
        } else if ("logStatusStart".equals(str)) {
            u.b("AdEventProviderImpl", "====log stats function will be start====");
            if (Boolean.valueOf(uri.getQueryParameter("isRealTime")).booleanValue()) {
                b.c().a();
            } else {
                b.b().a();
            }
        } else if ("adEventDispatch".equals(str)) {
            u.b("AdEventProviderImpl", "dispatch FUN_AD_EVENT_DISPATCH");
            com.bytedance.sdk.openadsdk.c.a a2 = com.bytedance.sdk.openadsdk.c.a.a(com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event")));
            if (a2 != null) {
                b.a().a(a2);
            }
        } else if ("logStatusDispatch".equals(str)) {
            Boolean valueOf = Boolean.valueOf(uri.getQueryParameter("isRealTime"));
            c.a a3 = c.a.a(com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event")));
            if (a3 != null) {
                if (valueOf.booleanValue()) {
                    b.c().a(a3);
                } else {
                    b.b().a(a3);
                }
            }
        } else if ("trackUrl".equals(str)) {
            try {
                String queryParameter2 = uri.getQueryParameter(VideoPlayerStatistic.AudienceHiidoCoreStatisticKey.DecodeId);
                boolean booleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                String[] split = com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter(ARPScriptEnvironment.KEY_DATA_PIP_TRACK)).split(",");
                if (split.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : split) {
                        String b2 = com.bytedance.sdk.openadsdk.multipro.c.b(str2);
                        if (!TextUtils.isEmpty(b2)) {
                            arrayList.add(b2);
                        }
                    }
                    d.a().a(queryParameter2, arrayList, booleanValue);
                }
            } catch (Throwable th) {
            }
        } else if ("trackFailed".equals(str)) {
            d.a().a(uri.getQueryParameter(VideoPlayerStatistic.AudienceHiidoCoreStatisticKey.DecodeId));
            u.b("AdEventProviderImpl", "track failed: " + String.valueOf(queryParameter));
        } else if ("logStatusInit".equals(str)) {
            c.a().a();
        } else if ("logStatusUpload".equals(str)) {
            String b3 = com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event"));
            if (!TextUtils.isEmpty(b3)) {
                c.a().a(C1041a.b(b3));
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    /* loaded from: classes6.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> f4921a;
        private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> b;
        private static volatile com.bytedance.sdk.openadsdk.c.b<c.a> c;

        static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> a() {
            if (f4921a == null) {
                synchronized (p.class) {
                    if (f4921a == null) {
                        f4921a = new com.bytedance.sdk.openadsdk.c.b<>(new f(p.a()), p.f(), g.b.a(), d());
                    }
                }
            }
            return f4921a;
        }

        public static com.bytedance.sdk.openadsdk.c.b<c.a> b() {
            if (c == null) {
                synchronized (p.class) {
                    if (c == null) {
                        c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
            return c;
        }

        public static com.bytedance.sdk.openadsdk.c.b<c.a> c() {
            if (b == null) {
                synchronized (p.class) {
                    if (b == null) {
                        b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
            return b;
        }

        public static com.bytedance.sdk.openadsdk.c.b<c.a> a(String str, String str2, boolean z) {
            g.b b2;
            com.bytedance.sdk.openadsdk.c.e lVar;
            if (z) {
                lVar = new n(p.a());
                b2 = g.b.a();
            } else {
                b2 = g.b.b();
                lVar = new l(p.a());
            }
            g.a d = d();
            return new com.bytedance.sdk.openadsdk.c.b<>(lVar, null, b2, d, new o(str, str2, lVar, null, b2, d));
        }

        private static g.a d() {
            return new g.a() { // from class: com.bytedance.sdk.openadsdk.multipro.c.a.b.1
                @Override // com.bytedance.sdk.openadsdk.c.g.a
                public boolean a() {
                    return x.a(p.a());
                }
            };
        }
    }

    /* loaded from: classes6.dex */
    private static class d {

        /* renamed from: a  reason: collision with root package name */
        private static volatile com.bytedance.sdk.openadsdk.k.a f4923a;

        public static com.bytedance.sdk.openadsdk.k.a a() {
            if (f4923a == null) {
                synchronized (com.bytedance.sdk.openadsdk.k.a.class) {
                    if (f4923a == null) {
                        f4923a = new com.bytedance.sdk.openadsdk.k.b(p.a(), new com.bytedance.sdk.openadsdk.k.g(p.a()));
                    }
                }
            }
            return f4923a;
        }
    }

    /* loaded from: classes6.dex */
    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private static volatile com.bytedance.sdk.openadsdk.g.c.c f4922a;

        public static com.bytedance.sdk.openadsdk.g.c.c a() {
            if (f4922a == null) {
                synchronized (com.bytedance.sdk.openadsdk.g.c.c.class) {
                    if (f4922a == null) {
                        f4922a = new com.bytedance.sdk.openadsdk.g.c.c();
                    }
                }
            }
            return f4922a;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C1041a implements com.bytedance.sdk.openadsdk.g.a.a {

        /* renamed from: a  reason: collision with root package name */
        JSONObject f4920a;

        /* JADX INFO: Access modifiers changed from: private */
        public static C1041a b(String str) {
            return new C1041a(str);
        }

        private C1041a(String str) {
            try {
                this.f4920a = new JSONObject(str);
            } catch (Throwable th) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.g.a.a
        public JSONObject a() {
            return this.f4920a;
        }
    }
}
