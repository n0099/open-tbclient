package d.c.b;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f65782a = null;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    public static j f65783b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f65784c = true;

    /* renamed from: e  reason: collision with root package name */
    public static volatile e0 f65786e;

    /* renamed from: g  reason: collision with root package name */
    public static d f65788g;

    /* renamed from: d  reason: collision with root package name */
    public static l0 f65785d = new l0();

    /* renamed from: f  reason: collision with root package name */
    public static ConcurrentHashMap<String, String> f65787f = new ConcurrentHashMap<>(4);

    public static void a() {
        x1.b();
    }

    @Nullable
    public static JSONObject b() {
        if (f65782a != null) {
            return f65782a.Q();
        }
        return null;
    }

    @Nullable
    public static String c() {
        if (f65782a != null) {
            return f65782a.P();
        }
        return null;
    }

    public static String d() {
        j jVar = f65783b;
        if (jVar != null) {
            return jVar.x();
        }
        return null;
    }

    public static boolean e() {
        return f65784c;
    }

    @NonNull
    public static b f() {
        return f65785d;
    }

    public static String g() {
        j jVar = f65783b;
        return jVar != null ? jVar.r() : "";
    }

    public static boolean h() {
        return true;
    }

    public static e0 i() {
        return f65786e;
    }

    public static <T> T j(String str, T t) {
        j jVar = f65783b;
        if (jVar != null) {
            return (T) jVar.a(str, t);
        }
        return null;
    }

    public static d k() {
        return f65788g;
    }

    public static q1 l() {
        if (f65782a != null) {
            return f65782a.o();
        }
        return null;
    }

    public static int m() {
        if (f65782a != null) {
            return f65782a.E();
        }
        return 0;
    }

    public static String n() {
        j jVar = f65783b;
        return jVar != null ? jVar.u() : "";
    }

    public static void o(@NonNull Context context, @NonNull q1 q1Var) {
        if (!r0.f65909b && Looper.myLooper() != Looper.getMainLooper()) {
            r0.b(new RuntimeException("Wrong thread!"));
        } else if (f65782a != null) {
            r0.b(new RuntimeException("Init Twice!"));
            return;
        } else if (q1Var.E() == null) {
            r0.b(new RuntimeException("need to involve setSensitiveInfoProvider!"));
            return;
        }
        Application application = (Application) context.getApplicationContext();
        x1 f2 = x1.f();
        i iVar = new i(application, q1Var);
        j jVar = new j(application, iVar);
        f2.c(application, iVar, jVar, new s1(q1Var.p()));
        f65782a = iVar;
        f65783b = jVar;
        r0.e("Inited", null);
    }

    public static void onEvent(String str) {
        p("umeng", str, null, 0L, 0L, null);
    }

    public static void p(@NonNull String str, @NonNull String str2, String str3, long j, long j2, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            x1.d(new b0(str, str2, str3, j, j2, jSONObject != null ? jSONObject.toString() : null));
            return;
        }
        if (r0.f65909b) {
            r0.a("category or label is empty", null);
        }
        x1.d(new i0("" + str2 + str3, "2", 1));
    }

    public static void q(@NonNull String str, @Nullable Bundle bundle) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        r0.b(th);
                        r(str, jSONObject);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        r(str, jSONObject);
    }

    public static void r(@NonNull String str, @Nullable JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            r0.a("eventName is empty", null);
            x1.d(new i0("", "2", 1));
        }
        x1.d(new d0(str, false, jSONObject != null ? jSONObject.toString() : null));
    }

    public static void s(HashMap<String, Object> hashMap) {
        j jVar = f65783b;
        if (jVar != null) {
            jVar.d(hashMap);
        }
    }

    @AnyThread
    public static void t(@Nullable c cVar) {
        x0.e(cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] u(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                if (h()) {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(str.getBytes("UTF-8"));
                        gZIPOutputStream = gZIPOutputStream2;
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        try {
                            r0.b(th);
                            if (gZIPOutputStream != null) {
                                gZIPOutputStream.close();
                            }
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            if (!h()) {
                            }
                        } catch (Throwable th2) {
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e2) {
                                    r0.b(e2);
                                }
                            }
                            throw th2;
                        }
                    }
                } else {
                    byteArrayOutputStream.write(str.getBytes("UTF-8"));
                }
            } catch (IOException e3) {
                r0.b(e3);
            }
        } catch (Throwable th3) {
            th = th3;
        }
        if (gZIPOutputStream != null) {
            gZIPOutputStream.close();
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        return !h() ? TTEncryptUtils.a(byteArray2, byteArray2.length) : byteArray2;
    }
}
