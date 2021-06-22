package com.bytedance.sdk.openadsdk.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.s;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import d.b.c.b.b.i;
import d.b.c.b.b.j;
import d.b.c.b.d.o;
import java.util.List;
import java.util.Random;
import java.util.UUID;
/* loaded from: classes6.dex */
public class b implements com.bytedance.sdk.openadsdk.m.a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f29740a;

    /* renamed from: b  reason: collision with root package name */
    public final f f29741b;

    @SuppressLint({"StaticFieldLeak"})
    /* loaded from: classes6.dex */
    public class a extends com.bytedance.sdk.openadsdk.l.g {

        /* renamed from: b  reason: collision with root package name */
        public final e f29747b;

        /* renamed from: c  reason: collision with root package name */
        public final String f29748c;

        private String c(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains("__TS__")) {
                long currentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
            }
            if ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.f29748c)) {
                str = str.replace("{UID}", this.f29748c).replace("__UID__", this.f29748c);
            }
            String a2 = y.a();
            return ((str.contains("{OAID}") || str.contains("__OAID__")) && !TextUtils.isEmpty(a2)) ? str.replace("{OAID}", a2).replace("__OAID__", a2) : str;
        }

        public boolean a(String str) {
            return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
        }

        public String b(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(new Random().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception e2) {
                e2.printStackTrace();
                return str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.sdk.openadsdk.core.h.g.a() && a(this.f29747b.b())) {
                if (this.f29747b.d() == 0) {
                    b.this.f29741b.c(this.f29747b);
                    return;
                }
                while (this.f29747b.d() > 0) {
                    try {
                        if (this.f29747b.d() == 5) {
                            b.this.f29741b.a(this.f29747b);
                        }
                    } catch (Throwable unused) {
                    }
                    if (!x.a(b.this.b())) {
                        return;
                    }
                    String c2 = c(this.f29747b.b());
                    if (this.f29747b.c()) {
                        c2 = b(c2);
                    }
                    i c3 = i.c();
                    j jVar = new j(0, c2, c3);
                    d.b.c.b.d.g b2 = com.bytedance.sdk.openadsdk.i.e.b();
                    b2.b(10000);
                    jVar.setRetryPolicy(b2).build(com.bytedance.sdk.openadsdk.i.e.c().e());
                    o oVar = null;
                    try {
                        oVar = c3.get();
                    } catch (Throwable unused2) {
                    }
                    if (oVar != null && oVar.f()) {
                        b.this.f29741b.c(this.f29747b);
                        if (u.c()) {
                            u.c("trackurl", "track success : " + this.f29747b.b());
                            return;
                        }
                        return;
                    }
                    if (u.c()) {
                        u.c("trackurl", "track fail : " + this.f29747b.b());
                    }
                    this.f29747b.a(this.f29747b.d() - 1);
                    if (this.f29747b.d() == 0) {
                        b.this.f29741b.c(this.f29747b);
                        if (u.c()) {
                            u.c("trackurl", "track fail and delete : " + this.f29747b.b());
                            return;
                        }
                        return;
                    }
                    b.this.f29741b.b(this.f29747b);
                }
            }
        }

        public a(e eVar, String str) {
            super("AdsStats");
            this.f29747b = eVar;
            this.f29748c = str;
        }
    }

    public b(Context context, f fVar) {
        this.f29740a = context;
        this.f29741b = fVar;
    }

    public static com.bytedance.sdk.openadsdk.m.a c() {
        return d.b();
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public void a() {
    }

    public Context b() {
        Context context = this.f29740a;
        return context == null ? p.a() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public void a(String str, List<String> list, boolean z) {
        if (com.bytedance.sdk.openadsdk.core.h.g.a() && s.b(list)) {
            for (String str2 : list) {
                com.bytedance.sdk.openadsdk.l.e.a(new a(new e(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), str2, z, 5), str));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public void a(final String str) {
        if (com.bytedance.sdk.openadsdk.core.h.g.a()) {
            com.bytedance.sdk.openadsdk.l.e.a(new com.bytedance.sdk.openadsdk.l.g("trackFailedUrls") { // from class: com.bytedance.sdk.openadsdk.m.b.1
                @Override // java.lang.Runnable
                public void run() {
                    final List<e> a2 = b.this.f29741b.a();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            b.this.a(a2, str);
                        }
                    });
                }
            }, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<e> list, String str) {
        if (s.b(list)) {
            for (e eVar : list) {
                com.bytedance.sdk.openadsdk.l.e.a(new a(eVar, str));
            }
        }
    }
}
