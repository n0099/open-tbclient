package com.kwad.sdk.core.network.b;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;
/* loaded from: classes10.dex */
public final class d implements b {
    public static boolean auH = true;
    public static double auI = 1.0d;
    public static volatile boolean auM = false;
    public static String auN = "";
    public long auJ = -1;
    public long auK = -1;
    public long auL = -1;
    public j auO = new j();

    public static boolean ac(long j) {
        return j != -1;
    }

    public static boolean af(long j) {
        return j >= 50;
    }

    public d() {
        auI = new Random().nextDouble();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: CZ */
    public d CR() {
        this.auO.atS = SystemClock.elapsedRealtime();
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: Da */
    public d CS() {
        this.auK = SystemClock.elapsedRealtime();
        dC("this.responseReceiveTime:" + this.auK);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: Db */
    public d CT() {
        if (ac(this.auJ) && ac(this.auK)) {
            this.auO.atZ = this.auK - this.auJ;
            dC("info.waiting_response_cost:" + this.auO.atZ);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: Dd */
    public d CW() {
        if (ac(this.auK)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.auL = elapsedRealtime;
            this.auO.atX = elapsedRealtime - this.auK;
            dC("info.response_parse_cost:" + this.auO.atX);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: De */
    public d CX() {
        if (ac(this.auL)) {
            this.auO.aue = SystemClock.elapsedRealtime() - this.auL;
            Df();
            dC("info.response_done_cost:" + this.auO.aue);
        }
        return this;
    }

    private void Df() {
        j jVar = this.auO;
        if (jVar != null && jVar.aud == 1 && !af(jVar.aue)) {
            this.auO.aue = -1L;
        }
    }

    private d Dg() {
        this.auO.auh = (int) com.kwad.sdk.ip.direct.a.Ho();
        this.auO.aui = (int) com.kwad.sdk.ip.direct.a.Hp();
        this.auO.auj = (int) com.kwad.sdk.ip.direct.a.Hq();
        return this;
    }

    private void Dh() {
        i c = c(this.auO);
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(c);
        }
        com.kwad.sdk.core.e.c.d("NetworkMonitorRecorder", "reportError" + c.toJson().toString());
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b CV() {
        if (ac(this.auO.atS)) {
            this.auO.atK = SystemClock.elapsedRealtime() - this.auO.atS;
            dC("info.request_prepare_cost:" + this.auO.atK);
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: Dc */
    public d CU() {
        if (ac(this.auO.atS)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.auJ = elapsedRealtime;
            j jVar = this.auO;
            jVar.atM = elapsedRealtime - jVar.atS;
            if (ac(jVar.atK)) {
                j jVar2 = this.auO;
                jVar2.atL = jVar2.atM - jVar2.atK;
            }
            dC("info.request_create_cost:" + this.auO.atM);
            dC("info.requestAddParamsCost:" + this.auO.atL);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final void report() {
        long j;
        if (c((i) this.auO)) {
            return;
        }
        if (this.auO.httpCode != 200) {
            Dh();
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (ac(this.auO.atS)) {
            j = elapsedRealtime - this.auO.atS;
        } else {
            j = -1;
        }
        ae(j);
        if (j <= 30000 && j > -1) {
            k kVar = (k) ServiceProvider.get(k.class);
            if (kVar != null) {
                kVar.a(this.auO);
            }
            dC("report normal" + this.auO.toString());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: ad */
    public d ab(long j) {
        this.auO.atY = j;
        dC("responseSize:" + j);
        return this;
    }

    private d ae(long j) {
        this.auO.aua = j;
        dC("totalCost:" + j);
        return this;
    }

    public static i c(j jVar) {
        i iVar = new i();
        iVar.errorMsg = jVar.errorMsg;
        iVar.host = jVar.host;
        iVar.httpCode = jVar.httpCode;
        iVar.atI = jVar.atI;
        iVar.url = jVar.url;
        iVar.atJ = jVar.atJ;
        return iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: cw */
    public d cs(int i) {
        this.auO.httpCode = i;
        dC("http_code:" + i);
        return this;
    }

    private d cx(int i) {
        this.auO.aud = i;
        dC("hasData:" + i);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: cy */
    public d cu(int i) {
        this.auO.result = i;
        dC("result:" + i);
        return this;
    }

    public static void dC(String str) {
        if (auH) {
            com.kwad.sdk.core.e.c.d("NetworkMonitorRecorder", str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dE */
    public d dy(String str) {
        try {
            Uri parse = Uri.parse(str);
            this.auO.host = parse.getHost();
            dC("host:" + this.auO.host);
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.e("NetworkMonitorRecorder", Log.getStackTraceString(e));
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dF */
    public d dz(String str) {
        this.auO.errorMsg = str;
        dC(str);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dG */
    public d dA(String str) {
        this.auO.atI = str;
        dC("reqType:" + str);
        dI(com.kwad.sdk.ip.direct.a.Hn());
        Dg();
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dH */
    public d dB(String str) {
        this.auO.auc = str;
        dC("requestId:" + str);
        return this;
    }

    private d dI(String str) {
        this.auO.auf = str;
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final /* synthetic */ b ct(int i) {
        return cx(1);
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b cv(int i) {
        j jVar = this.auO;
        jVar.aug = i;
        if (i != 0) {
            jVar.atJ = 1;
        }
        return this;
    }

    public static boolean c(@NonNull i iVar) {
        if (TextUtils.isEmpty(iVar.url)) {
            return true;
        }
        String lowerCase = iVar.url.toLowerCase();
        if (lowerCase.contains("beta") || lowerCase.contains(DebugActiveUploadResult.SOURCE) || lowerCase.contains("staging")) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dD */
    public d dx(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.auO.url = str;
        if (str.contains("?")) {
            String[] split = str.split("\\?");
            if (split.length > 0) {
                str = split[0];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            dC(HttpRetryStatistic.RETRY_URL + str);
        }
        return this;
    }
}
