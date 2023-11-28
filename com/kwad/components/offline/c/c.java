package com.kwad.components.offline.c;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.g;
import com.kwad.components.core.request.h;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.core.n.b.a<ITkOfflineCompo> {
    public static long acH;
    public final List<com.kwad.components.core.n.a.d.a> acG;
    public final AtomicBoolean acI;

    @Override // com.kwad.components.core.n.b.a
    public final String getTag() {
        return "TkInitModule";
    }

    @Override // com.kwad.components.core.n.b.a
    public final int oD() {
        return 1;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oE() {
        return ITkOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oF() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oG() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-3.3.55-ab4730d57f-416.zip";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oH() {
        return "5ee16e4e58a6ac66adb25dc99ecfcb63";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oI() {
        return "ks_tk_3355";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oJ() {
        return ITkOfflineCompo.IMPL;
    }

    /* renamed from: com.kwad.components.offline.c.c$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass1 implements InitCallBack {
        public final /* synthetic */ ITkOfflineCompo acJ;
        public final /* synthetic */ boolean acK;
        public final /* synthetic */ long acL;
        public final /* synthetic */ long acM;
        public final /* synthetic */ Context gq;

        public AnonymousClass1(ITkOfflineCompo iTkOfflineCompo, boolean z, long j, long j2, Context context) {
            this.acJ = iTkOfflineCompo;
            this.acK = z;
            this.acL = j;
            this.acM = j2;
            this.gq = context;
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onSuccess(boolean z) {
            int i;
            final b bVar = new b(this.acJ);
            com.kwad.sdk.components.c.a(com.kwad.components.core.n.a.d.c.class, bVar);
            int i2 = 1;
            c.this.acI.set(true);
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            if (this.acK) {
                i2 = 2;
            }
            c.this.b(i, i2, SystemClock.elapsedRealtime() - this.acL, this.acM);
            TkLoggerReporter.get().reportTKSOLoad(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(3).setOfflineLoadTime(this.acM).setSoLoadTime(SystemClock.elapsedRealtime() - this.acL).setOfflineSource(i2).setSoSource(i).toJson());
            c.this.oC();
            g.b(new h() { // from class: com.kwad.components.offline.c.c.1.1
                @Override // com.kwad.components.core.request.h, com.kwad.components.core.request.g.a
                public final void a(@NonNull final SdkConfigData sdkConfigData) {
                    super.a(sdkConfigData);
                    if (sdkConfigData != null) {
                        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.offline.c.c.1.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                C06751 c06751 = C06751.this;
                                bVar.onConfigRefresh(AnonymousClass1.this.gq, sdkConfigData.toJson());
                            }
                        });
                    }
                }
            });
        }
    }

    /* loaded from: classes10.dex */
    public static final class a {
        public static final c acS = new c((byte) 0);
    }

    public c() {
        this.acG = new CopyOnWriteArrayList();
        this.acI = new AtomicBoolean(false);
    }

    public static c tz() {
        return a.acS;
    }

    @Override // com.kwad.components.core.n.b.a
    public final boolean isEnabled() {
        return ((Boolean) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.apE)).booleanValue();
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.n.b.b.class, methodId = "initOC")
    public static void aj(Context context) {
        acH = SystemClock.elapsedRealtime();
        tz().init(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.b.a
    public void a(Context context, boolean z, ITkOfflineCompo iTkOfflineCompo) {
        iTkOfflineCompo.init(context, new d(), new AnonymousClass1(iTkOfflineCompo, z, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - acH, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, long j, long j2) {
        for (com.kwad.components.core.n.a.d.a aVar : this.acG) {
            aVar.a(i, i2, j, j2);
        }
    }

    public final void a(com.kwad.components.core.n.a.d.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.acI.get()) {
            aVar.a(1, 1, 0L, 0L);
        }
        this.acG.add(aVar);
    }

    public final void b(com.kwad.components.core.n.a.d.a aVar) {
        if (aVar == null) {
            return;
        }
        this.acG.remove(aVar);
    }
}
