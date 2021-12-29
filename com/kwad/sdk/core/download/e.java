package com.kwad.sdk.core.download;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.x;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class e {
    public static int a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f57974b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static e f57975c;

    /* renamed from: d  reason: collision with root package name */
    public InstallTipsViewHelper f57976d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, Integer> f57977e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, Integer> f57978f = new HashMap();

    public static e a() {
        if (f57975c == null) {
            synchronized (e.class) {
                if (f57975c == null) {
                    f57975c = new e();
                }
            }
        }
        return f57975c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final AdInfo adInfo, final AdTemplate adTemplate, final boolean z) {
        ax.a(new Runnable() { // from class: com.kwad.sdk.core.download.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.f57976d != null) {
                    ax.a(new Runnable() { // from class: com.kwad.sdk.core.download.e.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.f57976d != null) {
                                e.this.f57976d.b();
                                e.this.f57976d.c();
                                e.this.f57976d = null;
                            }
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            e.this.b(adInfo, adTemplate, z);
                        }
                    }, null, 500L);
                } else {
                    e.this.b(adInfo, adTemplate, z);
                }
            }
        });
    }

    private void a(Map<String, Integer> map, String str) {
        map.put(str, map.containsKey(str) ? Integer.valueOf(map.get(str).intValue() + 1) : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void b(AdInfo adInfo, AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.d.a.a("InstallTipsManager", "addToWindow");
        Activity c2 = x.a().c();
        if (c2 != null) {
            View findViewById = c2.getWindow().getDecorView().findViewById(16908290);
            if (findViewById instanceof FrameLayout) {
                InstallTipsViewHelper installTipsViewHelper = new InstallTipsViewHelper(z, adInfo, adTemplate);
                installTipsViewHelper.a((FrameLayout) findViewById);
                String valueOf = String.valueOf(adInfo.adBaseInfo.creativeId);
                if (z) {
                    a(this.f57977e, valueOf);
                    com.kwad.sdk.core.report.a.c(adTemplate, 92, null);
                } else {
                    com.kwad.sdk.core.report.a.d(adTemplate, 93, null);
                    a(this.f57978f, valueOf);
                }
                this.f57976d = installTipsViewHelper;
            }
        }
    }

    public void a(InstallTipsViewHelper installTipsViewHelper) {
        InstallTipsViewHelper installTipsViewHelper2;
        if (installTipsViewHelper == null || (installTipsViewHelper2 = this.f57976d) == null || !installTipsViewHelper.equals(installTipsViewHelper2)) {
            return;
        }
        this.f57976d = null;
    }

    public void a(final AdInfo adInfo, final AdTemplate adTemplate) {
        int L = com.kwad.sdk.core.config.b.L();
        com.kwad.sdk.core.d.a.a("InstallTipsManager", "onDownloadFinished installTipsTime: " + L);
        if (L <= 0 || adInfo == null || adTemplate == null || adTemplate.mAdScene.getAdStyle() == 0) {
            return;
        }
        String valueOf = String.valueOf(adInfo.adBaseInfo.creativeId);
        int i2 = 0;
        if (this.f57977e.containsKey(valueOf)) {
            i2 = this.f57977e.get(valueOf).intValue();
            this.f57977e.put(valueOf, Integer.valueOf(i2));
        }
        if (i2 >= a) {
            return;
        }
        i.a(new Runnable() { // from class: com.kwad.sdk.core.download.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.core.d.a.a("InstallTipsManager", "onDownloadFinished run() adInfo.status: " + adInfo.status);
                AdInfo adInfo2 = adInfo;
                int i3 = adInfo2.status;
                if (i3 == 12 || i3 == 10) {
                    return;
                }
                e.this.a(adInfo2, adTemplate, true);
            }
        }, L, TimeUnit.SECONDS);
    }

    public void b(final AdInfo adInfo, final AdTemplate adTemplate) {
        int av = com.kwad.sdk.core.config.b.av();
        if (av < 0) {
            return;
        }
        String valueOf = String.valueOf(adInfo.adBaseInfo.creativeId);
        int i2 = 0;
        if (this.f57978f.containsKey(valueOf)) {
            i2 = this.f57978f.get(valueOf).intValue();
            this.f57978f.put(valueOf, Integer.valueOf(i2));
        }
        if (i2 >= f57974b) {
            return;
        }
        i.a(new Runnable() { // from class: com.kwad.sdk.core.download.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (ag.b(KsAdSDK.getContext(), com.kwad.sdk.core.response.a.a.v(adInfo)) == 1) {
                    return;
                }
                e.this.a(adInfo, adTemplate, false);
            }
        }, av, TimeUnit.SECONDS);
    }
}
