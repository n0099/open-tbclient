package com.bytedance.sdk.openadsdk.multipro.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.l;
import com.bytedance.sdk.openadsdk.c.n;
import com.bytedance.sdk.openadsdk.c.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.h.c.c;
import com.bytedance.sdk.openadsdk.m.g;
import com.bytedance.sdk.openadsdk.multipro.e;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a implements com.bytedance.sdk.openadsdk.multipro.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f29571a;

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0332a implements com.bytedance.sdk.openadsdk.h.a.a {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f29572a;

        public C0332a(String str) {
            try {
                this.f29572a = new JSONObject(str);
            } catch (Throwable unused) {
            }
        }

        public static C0332a b(String str) {
            return new C0332a(str);
        }

        @Override // com.bytedance.sdk.openadsdk.h.a.a
        public JSONObject a() {
            return this.f29572a;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static volatile com.bytedance.sdk.openadsdk.h.c.c f29576a;

        public static com.bytedance.sdk.openadsdk.h.c.c a() {
            if (f29576a == null) {
                synchronized (com.bytedance.sdk.openadsdk.h.c.c.class) {
                    if (f29576a == null) {
                        f29576a = new com.bytedance.sdk.openadsdk.h.c.c();
                    }
                }
            }
            return f29576a;
        }
    }

    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static volatile com.bytedance.sdk.openadsdk.m.a f29577a;

        public static com.bytedance.sdk.openadsdk.m.a a() {
            if (f29577a == null) {
                synchronized (com.bytedance.sdk.openadsdk.m.a.class) {
                    if (f29577a == null) {
                        f29577a = new com.bytedance.sdk.openadsdk.m.b(p.a(), new g(p.a()));
                    }
                }
            }
            return f29577a;
        }
    }

    public static void a(boolean z) {
        if (p.a() == null) {
            return;
        }
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                e2.getType(Uri.parse(f() + "logStatusStart" + ("?isRealTime=" + String.valueOf(z))));
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                e2.getType(Uri.parse(f() + "trackFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        if (p.a() == null) {
            return;
        }
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                e2.getType(Uri.parse(f() + "adEventStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void d() {
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                e2.getType(Uri.parse(f() + "logStatusInit"));
            }
        } catch (Throwable unused) {
        }
    }

    public static ContentResolver e() {
        try {
            if (p.a() != null) {
                return p.a().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String f() {
        return e.f29583b + "/t_event_ad_event/";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
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
    @NonNull
    public String a() {
        return "t_event_ad_event";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                String a2 = com.bytedance.sdk.openadsdk.multipro.c.a(str);
                e2.getType(Uri.parse(f() + "logStatusUpload?event=" + a2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u.b("AdEventProviderImpl", "dispatch event");
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                String a2 = com.bytedance.sdk.openadsdk.multipro.c.a(str);
                e2.getType(Uri.parse(f() + "adEventDispatch?event=" + a2));
            }
        } catch (Throwable th) {
            u.f("AdEventProviderImpl", "dispatch event Throwable:" + th.toString());
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static volatile com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> f29573a;

        /* renamed from: b  reason: collision with root package name */
        public static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f29574b;

        /* renamed from: c  reason: collision with root package name */
        public static volatile com.bytedance.sdk.openadsdk.c.b<c.a> f29575c;

        public static com.bytedance.sdk.openadsdk.c.b<com.bytedance.sdk.openadsdk.c.a> a() {
            if (f29573a == null) {
                synchronized (p.class) {
                    if (f29573a == null) {
                        f29573a = new com.bytedance.sdk.openadsdk.c.b<>(new f(p.a()), p.f(), g.b.a(), d());
                    }
                }
            }
            return f29573a;
        }

        public static com.bytedance.sdk.openadsdk.c.b<c.a> b() {
            if (f29575c == null) {
                synchronized (p.class) {
                    if (f29575c == null) {
                        f29575c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                    }
                }
            }
            return f29575c;
        }

        public static com.bytedance.sdk.openadsdk.c.b<c.a> c() {
            if (f29574b == null) {
                synchronized (p.class) {
                    if (f29574b == null) {
                        f29574b = a("ttad_bk_stats", "AdStatsEventThread", true);
                    }
                }
            }
            return f29574b;
        }

        public static g.a d() {
            return new g.a() { // from class: com.bytedance.sdk.openadsdk.multipro.c.a.b.1
                @Override // com.bytedance.sdk.openadsdk.c.g.a
                public boolean a() {
                    return x.a(p.a());
                }
            };
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
            g.a d2 = d();
            return new com.bytedance.sdk.openadsdk.c.b<>(lVar, null, b2, d2, new o(str, str2, lVar, null, b2, d2));
        }
    }

    public static void a(String str, List<String> list, boolean z) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                for (String str2 : list) {
                    sb.append(com.bytedance.sdk.openadsdk.multipro.c.a(str2));
                    sb.append(",");
                }
                String a2 = com.bytedance.sdk.openadsdk.multipro.c.a(sb.toString());
                String str3 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(a2) + "&replace=" + String.valueOf(z);
                ContentResolver e2 = e();
                if (e2 == null) {
                    return;
                }
                e2.getType(Uri.parse(f() + "trackUrl" + str3));
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                e2.getType(Uri.parse(f() + "logStatusDispatch" + ("?event=" + com.bytedance.sdk.openadsdk.multipro.c.a(str) + "&isRealTime=" + String.valueOf(z))));
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        this.f29571a = context;
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
            if (a3 == null) {
                return null;
            }
            if (valueOf.booleanValue()) {
                b.c().a(a3);
            } else {
                b.b().a(a3);
            }
        } else if ("trackUrl".equals(str)) {
            try {
                String queryParameter2 = uri.getQueryParameter("did");
                boolean booleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                String[] split = com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("track")).split(",");
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
            } catch (Throwable unused) {
            }
        } else if ("trackFailed".equals(str)) {
            d.a().a(uri.getQueryParameter("did"));
            u.b("AdEventProviderImpl", "track failed: " + String.valueOf(queryParameter));
        } else if ("logStatusInit".equals(str)) {
            c.a().a();
        } else if ("logStatusUpload".equals(str)) {
            String b3 = com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event"));
            if (!TextUtils.isEmpty(b3)) {
                c.a().a(C0332a.b(b3));
            }
        }
        return null;
    }
}
