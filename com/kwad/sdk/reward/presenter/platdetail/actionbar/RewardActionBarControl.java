package com.kwad.sdk.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class RewardActionBarControl {
    public b a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public d f41030b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public a f41031c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public c f41032d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f41033e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f41034f;

    /* renamed from: h  reason: collision with root package name */
    public final long f41036h;
    public Context j;

    /* renamed from: g  reason: collision with root package name */
    public Handler f41035g = new Handler(Looper.getMainLooper());
    public boolean i = false;

    /* loaded from: classes7.dex */
    public enum ShowActionBarResult {
        SHOW_NEW_STYLE,
        SHOW_NATIVE,
        SHOW_H5_SUCCESS,
        SHOW_H5_FAILURE,
        SHOW_FOLLOW,
        SHOW_ORDER
    }

    /* loaded from: classes7.dex */
    public interface a {
        void d();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void d();
    }

    /* loaded from: classes7.dex */
    public interface d {
        boolean a();
    }

    public RewardActionBarControl(Context context, AdTemplate adTemplate) {
        this.j = context;
        this.f41033e = adTemplate;
        this.f41034f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        long c2 = com.kwad.sdk.core.response.a.b.c(adTemplate);
        this.f41036h = c2 <= 0 ? 1000L : c2;
    }

    private ShowActionBarResult a(boolean z) {
        c cVar;
        a aVar;
        if (com.kwad.sdk.core.response.a.a.aH(this.f41034f) && (aVar = this.f41031c) != null) {
            aVar.d();
            return ShowActionBarResult.SHOW_FOLLOW;
        } else if (com.kwad.sdk.core.response.a.a.aI(this.f41034f) && (cVar = this.f41032d) != null) {
            cVar.d();
            return ShowActionBarResult.SHOW_ORDER;
        } else if (com.kwad.sdk.core.response.a.a.T(this.f41034f)) {
            return ShowActionBarResult.SHOW_NEW_STYLE;
        } else {
            if (!com.kwad.sdk.core.response.a.b.d(this.f41033e) || this.f41030b == null) {
                b(z);
                return ShowActionBarResult.SHOW_NATIVE;
            }
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success in " + this.f41036h);
            return this.f41030b.a() ? ShowActionBarResult.SHOW_H5_SUCCESS : ShowActionBarResult.SHOW_H5_FAILURE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (this.a != null) {
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showNativeActionBar");
            this.a.a(z);
        }
    }

    public void a(int i, int i2) {
        ShowActionBarResult a2 = a(false);
        com.kwad.sdk.core.d.a.a("ActionBarControl", "showActionBarOnVideoStart result: " + a2);
        if (a2 != ShowActionBarResult.SHOW_H5_FAILURE) {
            return;
        }
        this.f41035g.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
            @Override // java.lang.Runnable
            public void run() {
                RewardActionBarControl.this.i = true;
                com.kwad.sdk.core.d.a.a("ActionBarControl", "mHasOutTime");
                if (RewardActionBarControl.this.f41030b != null && RewardActionBarControl.this.f41030b.a()) {
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success on " + RewardActionBarControl.this.f41036h);
                    return;
                }
                com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar out " + RewardActionBarControl.this.f41036h);
                com.kwad.sdk.core.report.d.c(RewardActionBarControl.this.f41033e, RewardActionBarControl.this.f41036h);
                RewardActionBarControl.this.b(true);
            }
        }, this.f41036h);
    }

    @MainThread
    public void a(@Nullable a aVar) {
        this.f41031c = aVar;
    }

    @MainThread
    public void a(b bVar) {
        this.a = bVar;
    }

    @MainThread
    public void a(@Nullable c cVar) {
        this.f41032d = cVar;
    }

    @MainThread
    public void a(d dVar) {
        this.f41030b = dVar;
    }

    public void b(int i, int i2) {
        if (this.i) {
            com.kwad.sdk.core.d.a.c("ActionBarControl", "showWebActionBar time out on pageStatus");
            return;
        }
        this.f41035g.removeCallbacksAndMessages(null);
        a(true);
    }
}
