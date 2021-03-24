package d.o.a.d.n;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.google.protobuf.CodedInputStream;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import d.o.a.a.a.a.p;
import d.o.a.d.e;
import d.o.a.d.f.c;
import d.o.a.d.f.n;
import d.o.a.d.g;
import d.o.a.d.j;
import java.lang.reflect.Field;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h {

    /* loaded from: classes6.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f66770e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f66771f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.f f66772g;

        /* renamed from: d.o.a.d.n.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1837a implements p {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JSONObject f66773a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f66774b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f66775c;

            public C1837a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                this.f66773a = jSONObject;
                this.f66774b = jSONObject2;
                this.f66775c = str;
            }

            @Override // d.o.a.a.a.a.p
            public void a(String str) {
                a aVar = a.this;
                h.m(aVar.f66770e, aVar.f66771f, str, aVar.f66772g, true, this.f66773a, this.f66774b, this.f66775c);
            }

            @Override // d.o.a.a.a.a.p
            public void a(Throwable th) {
                Context context = a.this.f66770e;
                h.a(context, Uri.parse("market://details?id=" + a.this.f66771f));
                k.r(this.f66773a, "error_code", 4);
                k.r(this.f66773a, "ttdownloader_type", 1);
                j.c.a().t("am_result", this.f66773a, a.this.f66772g);
            }
        }

        public a(Context context, String str, c.f fVar) {
            this.f66770e = context;
            this.f66771f = str;
            this.f66772g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject s = n.s();
            String optString = s.optString("s");
            JSONObject jSONObject = new JSONObject();
            String b2 = d.o.a.e.a.h.b.b(s.optString("x"), optString);
            if (n.o() == null) {
                Context context = this.f66770e;
                h.a(context, Uri.parse("market://details?id=" + this.f66771f));
                k.r(jSONObject, "error_code", 5);
                k.r(jSONObject, "ttdownloader_type", 1);
                j.c.a().t("am_result", jSONObject, this.f66772g);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            k.r(jSONObject2, "p", this.f66771f);
            k.r(jSONObject2, "i", Build.VERSION.INCREMENTAL);
            k.r(jSONObject2, "m", Build.MODEL);
            k.r(jSONObject2, "im", d.o.a.d.e$i.b.b(this.f66770e));
            k.r(jSONObject2, "d", d.o.a.d.e$i.b.d(this.f66770e));
            k.r(jSONObject2, "t", "m");
            byte[] bytes = jSONObject2.toString().getBytes();
            n.o().a(b2, EncryptorUtil.a(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new C1837a(jSONObject, s, optString));
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f66777e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f66778f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.f f66779g;

        public b(Context context, String str, c.f fVar) {
            this.f66777e = context;
            this.f66778f = str;
            this.f66779g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f66777e;
            g.b.b(h.a(context, Uri.parse("market://details?id=" + this.f66778f)), this.f66779g);
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject s = n.s();
                Thread.sleep(s.optInt("m2_delay_millis", 1000));
                d.o.a.d.e$j.a.b().e(this.f66777e, true);
                com.ss.android.downloadlib.a.c.b bVar = new com.ss.android.downloadlib.a.c.b();
                bVar.f38625a = 1;
                bVar.f38626b = 0;
                bVar.f38627c = String.format(d.o.a.e.a.h.b.b(s.optString("v"), s.optString("s")), this.f66778f);
                d.o.a.d.e$j.a.b().c(bVar, null);
                d.o.a.d.e$j.a.b().f();
                k.r(jSONObject, "error_code", -1);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public static c.h a(Context context, Uri uri) {
        if (context != null && uri != null && "market".equals(uri.getScheme())) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                if (!k.u(context, intent)) {
                    return new c.h(6, 13);
                }
                String k = d.o.a.e.a.h.c.k();
                if (k.I(context, k) && !d.o.a.e.a.h.c.h()) {
                    intent.setPackage(k);
                }
                if (d.o.a.e.b.j.a.r().l("fix_jump_market")) {
                    intent.addFlags(335544320);
                } else if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                return new c.h(5);
            } catch (Exception unused) {
                return new c.h(6, 14);
            }
        }
        return new c.h(6, 12);
    }

    public static c.h b(Context context, c.f fVar, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (d.o.a.e.a.h.c.h() && k.I(context, "com.sec.android.app.samsungapps")) {
                return o(context, str);
            }
            if (!fVar.f66543b.t()) {
                return a(context, Uri.parse("market://details?id=" + str));
            }
            JSONArray optJSONArray = n.s().optJSONArray("am_plans");
            if (d.o.a.e.a.h.c.d() && e.h.a(optJSONArray, "am_0")) {
                l(context, fVar, str);
                return new c.h(7, "am_m1");
            } else if (d.o.a.e.a.h.c.f() && e.h.a(optJSONArray, "am_3")) {
                return n(context, fVar, str);
            } else {
                if (d.o.a.e.a.h.c.g() && e.h.a(optJSONArray, "am_2")) {
                    p(context, fVar, str);
                    return new c.h(7, "am_m2");
                } else if (d.o.a.e.a.h.c.a() && e.h.a(optJSONArray, "am_4")) {
                    return q(context, fVar, str);
                } else {
                    return a(context, Uri.parse("market://details?id=" + str));
                }
            }
        }
        return new c.h(6, 11);
    }

    public static c.h c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (d.o.a.e.a.h.c.h() && k.I(context, "com.sec.android.app.samsungapps")) {
                return o(context, str);
            }
            return a(context, Uri.parse("market://details?id=" + str));
        }
        return new c.h(6, 11);
    }

    public static c.h d(Context context, String str, d.o.a.b.a.c.a aVar) {
        Intent M = k.M(context, str);
        if (M == null) {
            return new c.h(4, 22);
        }
        if (Build.VERSION.SDK_INT >= 26 && n.s().optInt("open_package_mode") == 1 && n.u() != null && n.u().a() && aVar.q()) {
            TTDelegateActivity.b(str, aVar);
            return new c.h(3);
        }
        M.putExtra("start_only_for_android", true);
        try {
            context.startActivity(M);
            return new c.h(3);
        } catch (Exception unused) {
            return new c.h(4, 23);
        }
    }

    public static c.h e(@NonNull d.o.a.b.a.c.b bVar, String str, String str2) {
        c.h k = k(str, bVar);
        return (g.C1830g.c(bVar) && k.a() == 2) ? f(str2, bVar) : k;
    }

    public static c.h f(String str, d.o.a.b.a.c.a aVar) {
        return d(n.a(), str, aVar);
    }

    public static String g(String str, @NonNull JSONObject jSONObject, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String b2 = d.o.a.e.a.h.b.b(jSONObject.optString("g"), str2);
        String b3 = d.o.a.e.a.h.b.b(jSONObject.optString("h"), str2);
        return (TextUtils.isEmpty(b2) || TextUtils.isEmpty(b3)) ? str : str.replace(b2, b3);
    }

    public static void h(Context context, String str, long j, boolean z) {
        boolean z2;
        Boolean valueOf;
        JSONObject jSONObject = new JSONObject();
        c.f v = c.g.e().v(j);
        try {
            JSONObject s = n.s();
            String optString = s.optString("s");
            String b2 = d.o.a.e.a.h.b.b(s.optString("aa"), optString);
            String b3 = d.o.a.e.a.h.b.b(s.optString("ac"), optString);
            String b4 = d.o.a.e.a.h.b.b(s.optString("af"), optString);
            boolean r = r(context, b3);
            try {
                StringBuilder sb = new StringBuilder(String.format(b2, str, b4, b3));
                Intent intent = new Intent("android.intent.action.VIEW");
                String k = d.o.a.e.a.h.c.k();
                if (k.I(context, k)) {
                    intent.setPackage(k);
                }
                if (z) {
                    sb.append(d.o.a.e.a.h.b.b(s.optString("ae"), optString));
                } else {
                    intent.addFlags(335544320);
                }
                intent.setData(Uri.parse(sb.toString()));
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                g.b.e("am_kllk2", jSONObject, v);
                k.r(jSONObject, "error_code", -1);
                k.r(jSONObject, "if", Boolean.valueOf(z));
                k.r(jSONObject, "ttdownloader_type", 4);
                valueOf = Boolean.valueOf(r);
            } catch (Exception unused) {
                z2 = r;
                try {
                    g.b.b(a(context, Uri.parse("market://details?id=" + str)), v);
                    k.r(jSONObject, "error_code", 2);
                    k.r(jSONObject, "if", Boolean.valueOf(z));
                    k.r(jSONObject, "ttdownloader_type", 4);
                    valueOf = Boolean.valueOf(z2);
                    k.r(jSONObject, "mf", valueOf);
                    j.c.a().t("am_result", jSONObject, v);
                } catch (Throwable th) {
                    th = th;
                    k.r(jSONObject, "if", Boolean.valueOf(z));
                    k.r(jSONObject, "ttdownloader_type", 4);
                    k.r(jSONObject, "mf", Boolean.valueOf(z2));
                    j.c.a().t("am_result", jSONObject, v);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                z2 = r;
                k.r(jSONObject, "if", Boolean.valueOf(z));
                k.r(jSONObject, "ttdownloader_type", 4);
                k.r(jSONObject, "mf", Boolean.valueOf(z2));
                j.c.a().t("am_result", jSONObject, v);
                throw th;
            }
        } catch (Exception unused2) {
            z2 = false;
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
        }
        k.r(jSONObject, "mf", valueOf);
        j.c.a().t("am_result", jSONObject, v);
    }

    public static c.h j(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new c.h(4, 11);
        }
        if (context == null) {
            context = n.a();
        }
        Intent M = k.M(context, str);
        if (M == null) {
            return new c.h(4, 22);
        }
        M.putExtra("start_only_for_android", true);
        try {
            context.startActivity(M);
            return new c.h(3);
        } catch (Exception unused) {
            return new c.h(4, 23);
        }
    }

    public static c.h k(String str, @NonNull d.o.a.b.a.c.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return new c.h(2, 21);
        }
        Context a2 = n.a();
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(268435456);
        intent.putExtra("open_url", str);
        intent.putExtra("start_only_for_android", true);
        if (d.o.a.e.b.j.a.r().l("fix_app_link_flag")) {
            intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        }
        if (k.C(a2, intent)) {
            if (n.s().optInt("open_url_mode") == 0 && n.u() != null && n.u().a() && Build.VERSION.SDK_INT >= 26 && aVar.q()) {
                TTDelegateActivity.a(str, aVar);
            } else {
                try {
                    n.a().startActivity(intent);
                } catch (Exception unused) {
                    return new c.h(2);
                }
            }
            return new c.h(1);
        }
        return new c.h(2, 24);
    }

    public static void l(Context context, c.f fVar, String str) {
        d.o.a.d.i.a().b(new a(context, str, fVar));
    }

    public static void m(Context context, String str, String str2, @NonNull c.f fVar, boolean z, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, String str3) {
        k.r(jSONObject, "ttdownloader_type", Integer.valueOf(z ? 1 : 2));
        try {
            String a2 = d.o.a.e.a.h.b.a(new JSONObject(str2).optString("a"));
            if (z) {
                a2 = g(a2, jSONObject2, str3);
            }
            k.r(jSONObject, "open_url", a2);
            if (s(context, a2)) {
                k.r(jSONObject, "error_code", -2);
                j.c.a().t("am_result", jSONObject, fVar);
                g.b.e(z ? "am_m1" : "am_m2", jSONObject, fVar);
                return;
            }
            g.b.b(a(context, Uri.parse("market://details?id=" + str)), fVar);
            k.r(jSONObject, "error_code", 2);
            j.c.a().t("am_result", jSONObject, fVar);
        } catch (Exception unused) {
            g.b.b(a(context, Uri.parse("market://details?id=" + str)), fVar);
            k.r(jSONObject, "error_code", 3);
            j.c.a().t("am_result", jSONObject, fVar);
        }
    }

    public static c.h n(Context context, c.f fVar, String str) {
        Intent intent = new Intent(context, JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("p", str);
        intent.putExtra("id", fVar.f66542a);
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new c.h(7, "am_kllk2");
        } catch (Throwable unused) {
            k.r(jSONObject, "error_code", 1);
            k.r(jSONObject, d.o.a.e.a.h.c.k(), Integer.valueOf(k.z(context, d.o.a.e.a.h.c.k())));
            k.r(jSONObject, "ttdownloader_type", 4);
            j.c.a().t("am_result", jSONObject, fVar);
            return a(context, Uri.parse("market://details?id=" + str));
        }
    }

    public static c.h o(@NonNull Context context, @NonNull String str) {
        try {
            Uri parse = Uri.parse("http://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(parse);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new c.h(5);
        } catch (Exception unused) {
            return new c.h(6, 14);
        }
    }

    public static void p(Context context, c.f fVar, String str) {
        d.o.a.d.i.a().b(new b(context, str, fVar));
    }

    public static c.h q(Context context, c.f fVar, String str) {
        JSONObject s = n.s();
        String optString = s.optString("s");
        String c2 = d.o.a.e.a.h.b.c(s, "ay", optString);
        JSONObject jSONObject = new JSONObject();
        k.r(jSONObject, "ttdownloader_type", 4);
        if (d.o.a.d.e$g.b.c(context, str, c2, s, optString)) {
            k.r(jSONObject, "error_code", -1);
            j.c.a().t("am_result", jSONObject, fVar);
            return new c.h(5, "am_hw");
        }
        k.r(jSONObject, "error_code", 1);
        j.c.a().t("am_result", jSONObject, fVar);
        return a(context, Uri.parse("market://details?id=" + str));
    }

    public static boolean r(Context context, String str) {
        JSONObject s = n.s();
        String optString = s.optString("s");
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                String b2 = d.o.a.e.a.h.b.b(s.optString("az"), optString);
                String b3 = d.o.a.e.a.h.b.b(s.optString("ba"), optString);
                Field declaredField = ContextWrapper.class.getDeclaredField(b2);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(b3);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean s(Context context, String str) {
        if (context == null) {
            context = n.a();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
            if (d.o.a.e.b.j.a.r().l("fix_app_link_flag")) {
                intent.addFlags(32768);
            }
        }
        intent.setData(Uri.parse(str));
        intent.putExtra("start_only_for_android", true);
        String k = d.o.a.e.a.h.c.k();
        if (k.I(n.a(), k)) {
            intent.setPackage(k);
        }
        if (k.u(n.a(), intent)) {
            try {
                context.startActivity(intent);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }
}
