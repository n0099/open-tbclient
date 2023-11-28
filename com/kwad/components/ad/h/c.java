package com.kwad.components.ad.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.kwad.components.core.i.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.y;
import java.util.List;
/* loaded from: classes10.dex */
public final class c implements Runnable {
    public static final Handler nM = new Handler(Looper.getMainLooper());
    public static volatile boolean nQ;
    public final long nN;
    public final AdTemplate nO;
    public boolean nP = false;
    @Nullable
    public d nR;

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void eM() {
        d dVar;
        if (!b.eH().eJ()) {
            com.kwad.sdk.core.e.c.d("PushAdManager", "run preCheckResult false");
            return;
        }
        nQ = false;
        if (!this.nP && (dVar = this.nR) != null && dVar.eR()) {
            this.nP = true;
            this.nR.c(new com.kwad.components.ad.b.a.b() { // from class: com.kwad.components.ad.h.c.3
                @Override // com.kwad.components.ad.b.a.b
                public final void T() {
                    y.ax(System.currentTimeMillis());
                    e.eU().eQ();
                }

                @Override // com.kwad.components.ad.b.a.b
                public final void U() {
                    com.kwad.sdk.core.e.c.d("PushAdManager", "onAdClose: ");
                    e.eU().eS();
                    b.eH().a(c.this);
                }
            });
        }
    }

    public final void eL() {
        com.kwad.sdk.core.e.c.w("PushAdManager", "startRequestPushAd processingPush: " + nQ);
        if (!nQ && this.nO.mAdScene != null) {
            nQ = true;
            com.kwad.components.core.i.a.b(this.nO.mAdScene, new a.InterfaceC0649a() { // from class: com.kwad.components.ad.h.c.1
                @Override // com.kwad.components.core.i.a.InterfaceC0649a
                public final void onRequestResult(int i) {
                }

                @Override // com.kwad.components.core.i.a.InterfaceC0649a
                public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
                    com.kwad.sdk.core.e.c.d("PushAdManager", "onInnerAdLoad: " + list);
                    if (list != null && list.size() > 0) {
                        AdTemplate adTemplate = list.get(0).getAdTemplate();
                        if (com.kwad.sdk.core.response.b.a.cQ(com.kwad.sdk.core.response.b.e.dP(adTemplate))) {
                            com.kwad.sdk.core.e.c.d("PushAdManager", "loadPushTK");
                            Context context = ServiceProvider.getContext();
                            c.this.nR = new d(context, adTemplate);
                            return;
                        }
                        c.access$002(false);
                        com.kwad.sdk.core.e.c.d("PushAdManager", "pushAdInfo templateId invalid");
                        return;
                    }
                    c.access$002(false);
                }

                @Override // com.kwad.components.core.i.a.InterfaceC0649a
                public final void onError(int i, String str) {
                    com.kwad.sdk.core.e.c.d("PushAdManager", "onError: " + str);
                    c.access$002(false);
                }
            });
        }
    }

    public final void eN() {
        com.kwad.sdk.core.e.c.d("PushAdManager", "onOutSDKPage: ");
        if (!nM.hasMessages(1000001)) {
            com.kwad.sdk.core.e.c.d("PushAdManager", "onOutSDKPage: sendMessageDelay MSG_WHAT_PAGE_OUT");
            a(1000002, this, 500L);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (com.kwad.components.core.e.a.e.mX().isShowing()) {
            com.kwad.components.core.e.a.e.mX().a(new com.kwad.components.core.e.a.c() { // from class: com.kwad.components.ad.h.c.2
                @Override // com.kwad.components.core.e.a.c, com.kwad.components.core.e.a.b
                public final void eO() {
                    com.kwad.components.core.e.a.e.mX().b(this);
                    c.this.eM();
                }
            });
        } else {
            eM();
        }
    }

    public c(@NonNull com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        this.nO = adTemplate;
        this.nN = com.kwad.sdk.core.response.b.a.cS(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        com.kwad.sdk.core.e.c.d("PushAdManager", "PushAdManager create adTemplate: " + this.nO.hashCode() + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.nN);
    }

    public final void d(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (!adTemplate.equals(this.nO)) {
            com.kwad.sdk.core.e.c.d("PushAdManager", "onAdExit not current ad");
            return;
        }
        com.kwad.sdk.core.e.c.d("PushAdManager", "onAdExit showPushAdDelayTime: " + this.nN + ", adTemplate: " + adTemplate.hashCode());
        if (aVar.ag()) {
            a(1000001, this, this.nN);
        }
    }

    public static void a(int i, Runnable runnable, long j) {
        Message obtain = Message.obtain(nM, runnable);
        obtain.what = i;
        nM.sendMessageDelayed(obtain, j);
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        nQ = false;
        return false;
    }
}
