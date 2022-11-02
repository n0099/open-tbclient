package com.kwad.sdk.core.network.a;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.retry.HttpRetryStatistic;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;
import java.util.Random;
/* loaded from: classes8.dex */
public final class d implements b {
    public static boolean Zh = true;
    public static double Zi = 1.0d;
    public long Zj = -1;
    public long Zk = -1;
    public long Zl = -1;
    public k Zm = new k();

    public d() {
        Zi = new Random().nextDouble();
    }

    public static boolean A(long j) {
        return j != -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: B */
    public d z(long j) {
        this.Zm.YH = j;
        ch("responseSize:" + j);
        return this;
    }

    private d C(long j) {
        this.Zm.YJ = j;
        ch("totalCost:" + j);
        return this;
    }

    public static j a(k kVar) {
        j jVar = new j();
        jVar.errorMsg = kVar.errorMsg;
        jVar.host = kVar.host;
        jVar.httpCode = kVar.httpCode;
        jVar.Yp = kVar.Yp;
        jVar.url = kVar.url;
        jVar.Yq = kVar.Yq;
        return jVar;
    }

    public static boolean a(@NonNull j jVar) {
        if (TextUtils.isEmpty(jVar.url)) {
            return true;
        }
        String lowerCase = jVar.url.toLowerCase();
        return lowerCase.contains("beta") || lowerCase.contains("test") || lowerCase.contains("staging");
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: aF */
    public d aB(int i) {
        this.Zm.httpCode = i;
        ch("http_code:" + i);
        return this;
    }

    private d aG(int i) {
        this.Zm.YM = i;
        ch("hasData:" + i);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: aH */
    public d aD(int i) {
        this.Zm.result = i;
        ch("result:" + i);
        return this;
    }

    public static void b(j jVar) {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            float lJ = fVar.lJ();
            if (lJ == 0.0f || lJ > 1.0f) {
                com.kwad.sdk.core.e.b.e("NetworkMonitorRecorder", "error rate invalid rate is :" + lJ);
                return;
            }
            float f = 1.0f / lJ;
            jVar.Yr = (int) f;
            jVar.ratioCount = f;
        }
    }

    public static void ch(String str) {
        if (Zh) {
            com.kwad.sdk.core.e.b.d("NetworkMonitorRecorder", str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: ci */
    public d cc(String str) {
        this.Zm.url = str;
        if (!TextUtils.isEmpty(str)) {
            ch(HttpRetryStatistic.RETRY_URL + str);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: cj */
    public d cd(String str) {
        try {
            Uri parse = Uri.parse(str);
            this.Zm.host = parse.getHost();
            ch("host:" + this.Zm.host);
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.e("NetworkMonitorRecorder", Log.getStackTraceString(e));
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: ck */
    public d ce(String str) {
        this.Zm.errorMsg = str;
        ch(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: cl */
    public d cf(String str) {
        this.Zm.Yp = str;
        ch("reqType:" + str);
        cn(com.kwad.sdk.ip.direct.a.xs());
        ua();
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: cm */
    public d cg(String str) {
        this.Zm.YL = str;
        ch("requestId:" + str);
        return this;
    }

    private d cn(String str) {
        this.Zm.YO = str;
        return this;
    }

    public static double qu() {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar == null) {
            return 1.0d;
        }
        return fVar.lI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: tU */
    public d tM() {
        this.Zm.YB = SystemClock.elapsedRealtime();
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: tV */
    public d tN() {
        this.Zk = SystemClock.elapsedRealtime();
        ch("this.responseReceiveTime:" + this.Zk);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: tW */
    public d tO() {
        if (A(this.Zj) && A(this.Zk)) {
            this.Zm.YI = this.Zk - this.Zj;
            ch("info.waiting_response_cost:" + this.Zm.YI);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: tX */
    public d tP() {
        if (A(this.Zm.YB)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.Zj = elapsedRealtime;
            k kVar = this.Zm;
            kVar.Yv = elapsedRealtime - kVar.YB;
            if (A(kVar.Yt)) {
                k kVar2 = this.Zm;
                kVar2.Yu = kVar2.Yv - kVar2.Yt;
            }
            ch("info.request_create_cost:" + this.Zm.Yv);
            ch("info.requestAddParamsCost:" + this.Zm.Yu);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: tY */
    public d tR() {
        if (A(this.Zk)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.Zl = elapsedRealtime;
            this.Zm.YG = elapsedRealtime - this.Zk;
            ch("info.response_parse_cost:" + this.Zm.YG);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* renamed from: tZ */
    public d tS() {
        if (A(this.Zl)) {
            this.Zm.YN = SystemClock.elapsedRealtime() - this.Zl;
            ch("info.response_done_cost:" + this.Zm.YN);
        }
        return this;
    }

    private d ua() {
        this.Zm.YQ = (int) com.kwad.sdk.ip.direct.a.xt();
        this.Zm.YR = (int) com.kwad.sdk.ip.direct.a.xu();
        this.Zm.YS = (int) com.kwad.sdk.ip.direct.a.xv();
        return this;
    }

    private void ub() {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            float lI = fVar.lI();
            if (lI == 0.0f || lI > 1.0f) {
                com.kwad.sdk.core.e.b.e("NetworkMonitorRecorder", "success rate invalid rate is :" + lI);
                return;
            }
            k kVar = this.Zm;
            float f = 1.0f / lI;
            kVar.Yr = (int) f;
            kVar.ratioCount = f;
        }
    }

    public static double uc() {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar == null) {
            return 1.0d;
        }
        return fVar.lJ();
    }

    private void ud() {
        if (((f) ServiceProvider.get(f.class)) != null) {
            return;
        }
        j a = a(this.Zm);
        b(a);
        l lVar = (l) ServiceProvider.get(l.class);
        if (lVar != null) {
            lVar.a(uc(), a);
        }
        ch("reportError" + a.toString());
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final /* synthetic */ b aC(int i) {
        return aG(1);
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final b aE(int i) {
        k kVar = this.Zm;
        kVar.YP = i;
        if (i != 0) {
            kVar.Yq = 1;
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final void of() {
        if (((f) ServiceProvider.get(f.class)) == null && !a((j) this.Zm)) {
            if (this.Zm.httpCode != 200) {
                ud();
                return;
            }
            long elapsedRealtime = A(this.Zm.YB) ? SystemClock.elapsedRealtime() - this.Zm.YB : -1L;
            C(elapsedRealtime);
            if (elapsedRealtime > 30000 || elapsedRealtime <= -1) {
                return;
            }
            ub();
            l lVar = (l) ServiceProvider.get(l.class);
            if (lVar != null) {
                lVar.a(qu(), this.Zm);
            }
            ch("report normal" + this.Zm.toString());
        }
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final b tQ() {
        if (A(this.Zm.YB)) {
            this.Zm.Yt = SystemClock.elapsedRealtime() - this.Zm.YB;
            ch("info.request_prepare_cost:" + this.Zm.Yt);
        }
        return this;
    }
}
