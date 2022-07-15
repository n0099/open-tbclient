package com.kwad.sdk.kwai.kwai;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    public static b a;
    public c b;
    public final Map<String, Integer> c = new HashMap();
    public final Map<String, Integer> d = new HashMap();
    public final Stack<AdTemplate> e = new Stack<>();

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final AdTemplate adTemplate, final boolean z) {
        az.a(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.b.3
            @Override // java.lang.Runnable
            public final void run() {
                int r = d.r();
                if (z && r == 2) {
                    b.this.f(adTemplate);
                } else {
                    b.this.a(adTemplate, z, r);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(AdTemplate adTemplate, boolean z, int i) {
        if (this.b != null || com.kwad.components.core.c.kwai.b.a()) {
            return;
        }
        boolean z2 = true;
        a(adTemplate, z, (z && i == 1) ? false : false);
    }

    @UiThread
    private void a(AdTemplate adTemplate, boolean z, boolean z2) {
        Context a2;
        Context wrapContextIfNeed;
        com.kwad.sdk.core.lifecycle.a.c();
        Activity e = com.kwad.sdk.core.lifecycle.a.e();
        if (e == null || (a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a()) == null || (wrapContextIfNeed = Wrapper.wrapContextIfNeed(a2)) == null) {
            return;
        }
        c cVar = new c(wrapContextIfNeed, adTemplate, z, z2);
        View findViewById = e.getWindow().getDecorView().findViewById(16908290);
        if (findViewById instanceof FrameLayout) {
            cVar.a((FrameLayout) findViewById);
            this.b = cVar;
            b(adTemplate, z);
        }
    }

    public static void a(Map<String, Integer> map, String str) {
        map.put(str, map.containsKey(str) ? Integer.valueOf(map.get(str).intValue() + 1) : 1);
    }

    private void b(AdTemplate adTemplate, boolean z) {
        String valueOf = String.valueOf(com.kwad.sdk.core.response.a.d.t(adTemplate));
        if (z) {
            a(this.c, valueOf);
            com.kwad.sdk.core.report.a.c(adTemplate, 92, (JSONObject) null);
            return;
        }
        com.kwad.sdk.core.report.a.d(adTemplate, 93, null);
        a(this.d, valueOf);
    }

    public static boolean e(AdTemplate adTemplate) {
        String a2;
        if (adTemplate == null) {
            return false;
        }
        AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null || af.a(context, com.kwad.sdk.core.response.a.a.C(i)) || (a2 = com.kwad.sdk.core.download.a.a(i)) == null || TextUtils.isEmpty(a2)) {
            return false;
        }
        return new File(a2).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void f(AdTemplate adTemplate) {
        if (a.b()) {
            return;
        }
        com.kwad.sdk.core.lifecycle.a.c();
        Activity e = com.kwad.sdk.core.lifecycle.a.e();
        if (e != null && a.a(e, adTemplate, null, null)) {
            b(adTemplate, true);
        }
    }

    public final void a(AdTemplate adTemplate) {
        if (e(adTemplate)) {
            this.e.add(adTemplate);
        }
    }

    @Nullable
    public final AdTemplate b() {
        AdTemplate adTemplate = null;
        while (!this.e.isEmpty()) {
            AdTemplate pop = this.e.pop();
            if (e(pop)) {
                adTemplate = pop;
            }
        }
        if (adTemplate != null) {
            this.e.add(0, adTemplate);
        }
        return adTemplate;
    }

    public final void b(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        this.e.remove(adTemplate);
    }

    public final void c() {
        this.b = null;
    }

    public final void c(final AdTemplate adTemplate) {
        int q = d.q();
        if (adTemplate == null || q <= 0) {
            return;
        }
        final AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
        if (adTemplate.mAdScene.getAdStyle() == 0) {
            return;
        }
        String valueOf = String.valueOf(com.kwad.sdk.core.response.a.d.t(adTemplate));
        int i2 = 0;
        if (this.c.containsKey(valueOf)) {
            i2 = this.c.get(valueOf).intValue();
            this.c.put(valueOf, Integer.valueOf(i2));
        }
        if (i2 > 0) {
            return;
        }
        g.a(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.b.1
            @Override // java.lang.Runnable
            public final void run() {
                int i3 = i.status;
                if (i3 == 12 || i3 == 10) {
                    return;
                }
                b.this.a(adTemplate, true);
            }
        }, q, TimeUnit.SECONDS);
    }

    public final void d() {
        a.c();
        c cVar = this.b;
        if (cVar != null) {
            cVar.a();
            this.b = null;
        }
    }

    public final void d(final AdTemplate adTemplate) {
        int F = d.F();
        if (F < 0) {
            return;
        }
        final AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
        String valueOf = String.valueOf(i.adBaseInfo.creativeId);
        int i2 = 0;
        if (this.d.containsKey(valueOf)) {
            i2 = this.d.get(valueOf).intValue();
            this.d.put(valueOf, Integer.valueOf(i2));
        }
        if (i2 > 0) {
            return;
        }
        g.a(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.b.2
            @Override // java.lang.Runnable
            public final void run() {
                if (af.b(KsAdSDK.getContext(), com.kwad.sdk.core.response.a.a.C(i)) == 1) {
                    return;
                }
                b.this.a(adTemplate, false);
            }
        }, F, TimeUnit.SECONDS);
    }
}
