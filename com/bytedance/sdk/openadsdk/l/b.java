package com.bytedance.sdk.openadsdk.l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.openadsdk.core.h.j;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.s;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.List;
import java.util.Random;
import java.util.UUID;
/* loaded from: classes4.dex */
public class b implements com.bytedance.sdk.openadsdk.l.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7329a;

    /* renamed from: b  reason: collision with root package name */
    private final f f7330b;

    public b(Context context, f fVar) {
        this.f7329a = context;
        this.f7330b = fVar;
    }

    public Context b() {
        return this.f7329a == null ? p.a() : this.f7329a;
    }

    @Override // com.bytedance.sdk.openadsdk.l.a
    public void a(String str, List<String> list, boolean z) {
        if (j.a() && s.b(list)) {
            for (String str2 : list) {
                new a(new e(UUID.randomUUID().toString() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + System.currentTimeMillis(), str2, z, 5), str).executeOnExecutor(com.bytedance.sdk.openadsdk.k.a.a().b(), new Void[0]);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.l.a
    public void a(final String str) {
        if (j.a()) {
            com.bytedance.sdk.openadsdk.k.a.a().d(new Runnable() { // from class: com.bytedance.sdk.openadsdk.l.b.1
                @Override // java.lang.Runnable
                public void run() {
                    final List<e> a2 = b.this.f7330b.a();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.l.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.a(a2, str);
                        }
                    });
                }
            }, 1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.l.a
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<e> list, String str) {
        if (s.b(list)) {
            for (e eVar : list) {
                new a(eVar, str).executeOnExecutor(com.bytedance.sdk.openadsdk.k.a.a().b(), new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})
    /* loaded from: classes4.dex */
    public class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: b  reason: collision with root package name */
        private final e f7336b;
        private final String c;

        private a(e eVar, String str) {
            this.f7336b = eVar;
            this.c = str;
        }

        private String c(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("{TS}") || str.contains("__TS__")) {
                    long currentTimeMillis = System.currentTimeMillis();
                    str = str.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
                }
                if ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.c)) {
                    str = str.replace("{UID}", this.c).replace("__UID__", this.c);
                }
                String a2 = y.a();
                if ((str.contains("{OAID}") || str.contains("__OAID__")) && !TextUtils.isEmpty(a2)) {
                    return str.replace("{OAID}", a2).replace("__OAID__", a2);
                }
                return str;
            }
            return str;
        }

        boolean a(String str) {
            return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX));
        }

        String b(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return str.replace("[ss_random]", String.valueOf(new Random().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
                } catch (Exception e) {
                    e.printStackTrace();
                    return str;
                }
            }
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            com.bytedance.sdk.adnet.core.p pVar;
            if (j.a() && a(this.f7336b.b())) {
                if (this.f7336b.d() != 0) {
                    while (true) {
                        if (this.f7336b.d() <= 0 || isCancelled()) {
                            break;
                        }
                        try {
                            if (this.f7336b.d() == 5) {
                                b.this.f7330b.a(this.f7336b);
                            }
                        } catch (Throwable th) {
                        }
                        if (!x.a(b.this.b())) {
                            break;
                        }
                        String c = c(this.f7336b.b());
                        if (this.f7336b.c()) {
                            c = b(c);
                        }
                        i eop = i.eop();
                        new com.bytedance.sdk.adnet.b.j(0, c, eop).setRetryPolicy(com.bytedance.sdk.openadsdk.i.e.b().Om(10000)).build(com.bytedance.sdk.openadsdk.i.e.a(b.this.b()).d());
                        try {
                            pVar = eop.get();
                        } catch (Throwable th2) {
                            pVar = null;
                        }
                        if (pVar != null && pVar.a()) {
                            b.this.f7330b.c(this.f7336b);
                            if (u.c()) {
                                u.c("trackurl", "track success : " + this.f7336b.b());
                            }
                        } else {
                            if (u.c()) {
                                u.c("trackurl", "track fail : " + this.f7336b.b());
                            }
                            this.f7336b.a(this.f7336b.d() - 1);
                            if (this.f7336b.d() == 0) {
                                b.this.f7330b.c(this.f7336b);
                                if (u.c()) {
                                    u.c("trackurl", "track fail and delete : " + this.f7336b.b());
                                }
                            } else {
                                b.this.f7330b.b(this.f7336b);
                            }
                        }
                    }
                } else {
                    b.this.f7330b.c(this.f7336b);
                }
            }
            return null;
        }
    }

    public static com.bytedance.sdk.openadsdk.l.a c() {
        return d.b();
    }
}
