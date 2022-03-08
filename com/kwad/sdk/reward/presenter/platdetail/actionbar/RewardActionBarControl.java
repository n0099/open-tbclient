package com.kwad.sdk.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public class RewardActionBarControl {
    public b a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public d f56086b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public a f56087c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public c f56088d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f56089e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f56090f;

    /* renamed from: h  reason: collision with root package name */
    public final long f56092h;

    /* renamed from: j  reason: collision with root package name */
    public Context f56094j;

    /* renamed from: g  reason: collision with root package name */
    public Handler f56091g = new Handler(Looper.getMainLooper());

    /* renamed from: i  reason: collision with root package name */
    public boolean f56093i = false;

    /* loaded from: classes8.dex */
    public enum ShowActionBarResult {
        SHOW_NEW_STYLE,
        SHOW_NATIVE,
        SHOW_H5_SUCCESS,
        SHOW_H5_FAILURE,
        SHOW_FOLLOW,
        SHOW_ORDER
    }

    /* loaded from: classes8.dex */
    public interface a {
        void d();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(boolean z);
    }

    /* loaded from: classes8.dex */
    public interface c {
        void d();
    }

    /* loaded from: classes8.dex */
    public interface d {
        boolean a();
    }

    public RewardActionBarControl(Context context, AdTemplate adTemplate) {
        this.f56094j = context;
        this.f56089e = adTemplate;
        this.f56090f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        long c2 = com.kwad.sdk.core.response.a.b.c(adTemplate);
        this.f56092h = c2 <= 0 ? 1000L : c2;
    }

    private ShowActionBarResult a(boolean z) {
        c cVar;
        a aVar;
        if (com.kwad.sdk.core.response.a.a.aH(this.f56090f) && (aVar = this.f56087c) != null) {
            aVar.d();
            return ShowActionBarResult.SHOW_FOLLOW;
        } else if (com.kwad.sdk.core.response.a.a.aI(this.f56090f) && (cVar = this.f56088d) != null) {
            cVar.d();
            return ShowActionBarResult.SHOW_ORDER;
        } else if (com.kwad.sdk.core.response.a.a.T(this.f56090f)) {
            return ShowActionBarResult.SHOW_NEW_STYLE;
        } else {
            if (!com.kwad.sdk.core.response.a.b.d(this.f56089e) || this.f56086b == null) {
                b(z);
                return ShowActionBarResult.SHOW_NATIVE;
            }
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success in " + this.f56092h);
            return this.f56086b.a() ? ShowActionBarResult.SHOW_H5_SUCCESS : ShowActionBarResult.SHOW_H5_FAILURE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (this.a != null) {
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showNativeActionBar");
            this.a.a(z);
        }
    }

    public void a(int i2, int i3) {
        ShowActionBarResult a2 = a(false);
        com.kwad.sdk.core.d.a.a("ActionBarControl", "showActionBarOnVideoStart result: " + a2);
        if (a2 != ShowActionBarResult.SHOW_H5_FAILURE) {
            return;
        }
        this.f56091g.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
            @Override // java.lang.Runnable
            public void run() {
                RewardActionBarControl.this.f56093i = true;
                com.kwad.sdk.core.d.a.a("ActionBarControl", "mHasOutTime");
                if (RewardActionBarControl.this.f56086b != null && RewardActionBarControl.this.f56086b.a()) {
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success on " + RewardActionBarControl.this.f56092h);
                    return;
                }
                com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar out " + RewardActionBarControl.this.f56092h);
                com.kwad.sdk.core.report.d.c(RewardActionBarControl.this.f56089e, RewardActionBarControl.this.f56092h);
                RewardActionBarControl.this.b(true);
            }
        }, this.f56092h);
    }

    @MainThread
    public void a(@Nullable a aVar) {
        this.f56087c = aVar;
    }

    @MainThread
    public void a(b bVar) {
        this.a = bVar;
    }

    @MainThread
    public void a(@Nullable c cVar) {
        this.f56088d = cVar;
    }

    @MainThread
    public void a(d dVar) {
        this.f56086b = dVar;
    }

    public void b(int i2, int i3) {
        if (this.f56093i) {
            com.kwad.sdk.core.d.a.c("ActionBarControl", "showWebActionBar time out on pageStatus");
            return;
        }
        this.f56091g.removeCallbacksAndMessages(null);
        a(true);
    }
}
