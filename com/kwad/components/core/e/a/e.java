package com.kwad.components.core.e.a;

import android.app.Activity;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class e {
    public final List<b> JJ;
    public final Stack<AdTemplate> JK;
    public final AtomicBoolean JL;
    public final Set<String> JM;
    public final String TAG;
    public final AtomicBoolean oc;

    /* loaded from: classes10.dex */
    public static class a {
        public static final e JQ = new e((byte) 0);
    }

    public e() {
        this.TAG = "InstalledActivateManager";
        this.JJ = new CopyOnWriteArrayList();
        this.JK = new Stack<>();
        this.oc = new AtomicBoolean();
        this.JL = new AtomicBoolean();
        this.JM = new HashSet();
    }

    public static e mX() {
        return a.JQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void mY() {
        if (this.JK.isEmpty()) {
            return;
        }
        an(this.JK.pop());
    }

    public final void dJ() {
        this.oc.set(false);
        for (b bVar : this.JJ) {
            bVar.eO();
        }
    }

    public final void dZ() {
        this.oc.set(true);
        for (b bVar : this.JJ) {
            bVar.mV();
        }
    }

    public final boolean isShowing() {
        return this.oc.get();
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(AdTemplate adTemplate) {
        if (!a(adTemplate, new b() { // from class: com.kwad.components.core.e.a.e.2
            @Override // com.kwad.components.core.e.a.b
            public final void eO() {
                com.kwad.sdk.core.e.c.d("InstalledActivateManager", "onViewClose");
                e.this.dJ();
                e.this.mY();
            }

            @Override // com.kwad.components.core.e.a.b
            public final void mV() {
                com.kwad.sdk.core.e.c.d("InstalledActivateManager", "onViewShow");
                e.this.dZ();
            }
        })) {
            mY();
        }
    }

    public final synchronized void am(AdTemplate adTemplate) {
        String ay = com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        if (com.kwad.sdk.core.response.b.b.di(adTemplate) && !this.JM.contains(ay)) {
            this.JM.add(ay);
            an(adTemplate);
        }
    }

    public static boolean a(AdTemplate adTemplate, b bVar) {
        com.kwad.sdk.core.e.c.d("InstalledActivateManager", "showToActivityWindow");
        return new h().b(adTemplate, bVar);
    }

    private void an(final AdTemplate adTemplate) {
        if (!this.JL.get() && !this.oc.get()) {
            com.kwad.sdk.core.e.c.d("InstalledActivateManager", "showInstalledActivate");
            this.JL.set(true);
            bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.e.a.e.1
                /* JADX INFO: Access modifiers changed from: private */
                public void mZ() {
                    com.kwad.sdk.core.c.b.Ct();
                    if (!com.kwad.sdk.core.c.b.isEnable()) {
                        e.this.JL.set(false);
                        return;
                    }
                    com.kwad.sdk.core.c.b.Ct();
                    if (com.kwad.sdk.core.c.b.getCurrentActivity() != null) {
                        com.kwad.sdk.core.c.b.Ct();
                        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                            na();
                            return;
                        }
                    }
                    com.kwad.sdk.core.c.b.Ct();
                    com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.e.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                        /* renamed from: onActivityResumed */
                        public final void d(Activity activity) {
                            super.d(activity);
                            com.kwad.sdk.core.c.b.Ct();
                            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                            com.kwad.sdk.core.e.c.d("InstalledActivateManager", "startShow onBackToForeground");
                            na();
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void na() {
                    com.kwad.sdk.core.e.c.d("InstalledActivateManager", "startShow");
                    e.this.ao(adTemplate);
                    e.this.JL.set(false);
                    e.this.JM.remove(com.kwad.sdk.core.response.b.a.ay(com.kwad.sdk.core.response.b.e.dP(adTemplate)));
                }

                @Override // java.lang.Runnable
                public final void run() {
                    final com.kwad.components.ad.b.a.a aVar = (com.kwad.components.ad.b.a.a) com.kwad.sdk.components.c.f(com.kwad.components.ad.b.a.a.class);
                    if (aVar != null && aVar.S()) {
                        aVar.a(new com.kwad.components.ad.b.a.c() { // from class: com.kwad.components.core.e.a.e.1.1
                            @Override // com.kwad.components.ad.b.a.c, com.kwad.components.ad.b.a.b
                            public final void U() {
                                aVar.b(this);
                                mZ();
                                com.kwad.sdk.core.e.c.d("InstalledActivateManager", "startShow onPushAdClose");
                            }
                        });
                    } else {
                        mZ();
                    }
                }
            }, com.kwad.sdk.core.response.b.b.dj(adTemplate));
            return;
        }
        com.kwad.sdk.core.e.c.d("InstalledActivateManager", "mLoadDisable: " + this.oc.get() + ", mLoadDisable: " + this.JL.get());
        this.JK.add(adTemplate);
    }

    public final void a(b bVar) {
        this.JJ.add(bVar);
    }

    public final void b(b bVar) {
        this.JJ.remove(bVar);
    }
}
