package com.kwad.sdk.core.network.a;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.retry.HttpRetryStatistic;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;
/* loaded from: classes5.dex */
public final class d implements b {
    public static boolean a = true;
    public long b = -1;
    public long c = -1;
    public long d = -1;
    public j e = new j();

    public static i a(j jVar) {
        i iVar = new i();
        iVar.d = jVar.d;
        iVar.b = jVar.b;
        iVar.c = jVar.c;
        iVar.e = jVar.e;
        iVar.a = jVar.a;
        iVar.f = jVar.f;
        return iVar;
    }

    public static boolean a(@NonNull i iVar) {
        if (TextUtils.isEmpty(iVar.a)) {
            return true;
        }
        String lowerCase = iVar.a.toLowerCase();
        return lowerCase.contains("beta") || lowerCase.contains("test") || lowerCase.contains("staging");
    }

    public static void b(i iVar) {
        f fVar = (f) ServiceProvider.a(f.class);
        if (fVar != null) {
            float o = fVar.o();
            if (o != 0.0f && o <= 1.0f) {
                iVar.g = (int) (1.0f / o);
                return;
            }
            com.kwad.sdk.core.d.b.e("NetworkMonitorRecorder", "error rate invalid rate is :" + o);
        }
    }

    public static boolean b(long j) {
        return j != -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: c */
    public d a(long j) {
        this.e.w = j;
        f("responseSize:" + j);
        return this;
    }

    private d d(long j) {
        this.e.y = j;
        f("totalCost:" + j);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: e */
    public d a(int i) {
        this.e.c = i;
        f("http_code:" + i);
        return this;
    }

    private d f(int i) {
        this.e.B = i;
        f("hasData:" + i);
        return this;
    }

    public static void f(String str) {
        if (a) {
            com.kwad.sdk.core.d.b.a("NetworkMonitorRecorder", str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: g */
    public d c(int i) {
        this.e.C = i;
        f("result:" + i);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: g */
    public d a(String str) {
        this.e.a = str;
        if (!TextUtils.isEmpty(str)) {
            f(HttpRetryStatistic.RETRY_URL + str);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: h */
    public d b(String str) {
        try {
            Uri parse = Uri.parse(str);
            this.e.b = parse.getHost();
            f("host:" + this.e.b);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.e("NetworkMonitorRecorder", Log.getStackTraceString(e));
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: i */
    public d a() {
        this.e.q = SystemClock.elapsedRealtime();
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: i */
    public d c(String str) {
        this.e.d = str;
        f(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: j */
    public d b() {
        this.c = SystemClock.elapsedRealtime();
        f("this.responseReceiveTime:" + this.c);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: j */
    public d d(String str) {
        this.e.e = str;
        f("reqType:" + str);
        l(com.kwad.sdk.f.kwai.a.a());
        o();
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: k */
    public d c() {
        if (b(this.b) && b(this.c)) {
            this.e.x = this.c - this.b;
            f("info.waiting_response_cost:" + this.e.x);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: k */
    public d e(String str) {
        this.e.A = str;
        f("requestId:" + str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: l */
    public d d() {
        if (b(this.e.q)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.b = elapsedRealtime;
            j jVar = this.e;
            jVar.k = elapsedRealtime - jVar.q;
            if (b(jVar.i)) {
                j jVar2 = this.e;
                jVar2.j = jVar2.k - jVar2.i;
            }
            f("info.request_create_cost:" + this.e.k);
            f("info.requestAddParamsCost:" + this.e.j);
        }
        return this;
    }

    private d l(String str) {
        this.e.E = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: m */
    public d f() {
        if (b(this.c)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.d = elapsedRealtime;
            this.e.v = elapsedRealtime - this.c;
            f("info.response_parse_cost:" + this.e.v);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: n */
    public d g() {
        if (b(this.d)) {
            this.e.D = SystemClock.elapsedRealtime() - this.d;
            f("info.response_done_cost:" + this.e.D);
        }
        return this;
    }

    private d o() {
        this.e.G = (int) com.kwad.sdk.f.kwai.a.b();
        this.e.H = (int) com.kwad.sdk.f.kwai.a.c();
        this.e.I = (int) com.kwad.sdk.f.kwai.a.d();
        return this;
    }

    private void p() {
        f fVar = (f) ServiceProvider.a(f.class);
        if (fVar != null) {
            float n = fVar.n();
            if (n != 0.0f && n <= 1.0f) {
                this.e.g = (int) (1.0f / n);
                return;
            }
            com.kwad.sdk.core.d.b.e("NetworkMonitorRecorder", "success rate invalid rate is :" + n);
        }
    }

    private void q() {
        i a2 = a(this.e);
        b(a2);
        k kVar = (k) ServiceProvider.a(k.class);
        if (kVar != null) {
            kVar.a(a2);
        }
        f("reportError" + a2.toString());
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final /* synthetic */ b b(int i) {
        return f(1);
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final b d(int i) {
        j jVar = this.e;
        jVar.F = i;
        if (i != 0) {
            jVar.f = 1;
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final b e() {
        if (b(this.e.q)) {
            this.e.i = SystemClock.elapsedRealtime() - this.e.q;
            f("info.request_prepare_cost:" + this.e.i);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final void h() {
        if (a((i) this.e)) {
            return;
        }
        if (this.e.c != 200) {
            q();
            return;
        }
        long elapsedRealtime = b(this.e.q) ? SystemClock.elapsedRealtime() - this.e.q : -1L;
        d(elapsedRealtime);
        if (elapsedRealtime > 30000 || elapsedRealtime <= -1) {
            return;
        }
        p();
        k kVar = (k) ServiceProvider.a(k.class);
        if (kVar != null) {
            kVar.a(this.e);
        }
        f("report normal" + this.e.toString());
    }
}
