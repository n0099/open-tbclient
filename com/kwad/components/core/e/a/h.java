package com.kwad.components.core.e.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public final class h implements d {
    public static WeakReference<Window> JY;
    public g JV;
    public b JW;
    public WeakReference<Activity> JX;
    public ViewGroup nX;
    public boolean nY;
    public final com.kwad.sdk.core.c.c<Activity> wS = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            com.kwad.sdk.core.c.b.Ct();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            if (!activity.equals((Activity) h.this.JX.get())) {
                return;
            }
            h.this.eP();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void eP() {
        g gVar;
        if (this.nY) {
            return;
        }
        this.nY = true;
        this.JW.eO();
        ViewGroup viewGroup = this.nX;
        if (viewGroup != null && (gVar = this.JV) != null) {
            viewGroup.removeView(gVar);
        }
        com.kwad.sdk.core.c.b.Ct();
        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this.wS);
    }

    public static void ne() {
        WeakReference<Window> weakReference = JY;
        if (weakReference != null) {
            weakReference.clear();
        }
        JY = null;
    }

    @Override // com.kwad.components.core.e.a.d
    public final void mW() {
        eP();
    }

    public static void a(Window window) {
        JY = new WeakReference<>(window);
    }

    public final boolean b(AdTemplate adTemplate, b bVar) {
        Window window;
        try {
            this.JW = bVar;
            com.kwad.sdk.core.c.b.Ct();
            Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                if (JY != null) {
                    window = JY.get();
                } else {
                    window = currentActivity.getWindow();
                }
                View findViewById = window.getDecorView().findViewById(16908290);
                if (!(findViewById instanceof ViewGroup)) {
                    return false;
                }
                this.JX = new WeakReference<>(currentActivity);
                this.JV = new g(l.wrapContextIfNeed(currentActivity), adTemplate, this);
                com.kwad.sdk.core.c.b.Ct();
                com.kwad.sdk.core.c.b.a(this.wS);
                this.nX = (ViewGroup) findViewById;
                this.nX.addView(this.JV, new ViewGroup.LayoutParams(-1, -1));
                bVar.mV();
                return true;
            }
            com.kwad.sdk.core.e.c.d("InstalledActivateViewHelper", "showInWindow fail activity:" + currentActivity);
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.d("InstalledActivateViewHelper", "showInWindow fail error:" + th);
            com.kwad.sdk.core.e.c.printStackTrace(th);
            return false;
        }
    }
}
