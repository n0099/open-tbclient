package com.kwad.sdk.reward.b.c.b;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.d;
/* loaded from: classes7.dex */
public class b extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public View f37159b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37161d;

    /* renamed from: c  reason: collision with root package name */
    public Handler f37160c = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public e f37162e = new e() { // from class: com.kwad.sdk.reward.b.c.b.b.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            long P = com.kwad.sdk.core.config.c.P() * 1000;
            if (P == 0 || !b.this.f37161d) {
                b.this.e();
            } else {
                b.this.f37160c.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.b.c.b.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.m() == null || b.this.m().isFinishing()) {
                            return;
                        }
                        b.this.e();
                        b.this.f37159b.setAlpha(0.0f);
                        b.this.f37159b.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, P);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f37159b.setVisibility(0);
        this.f37159b.setOnClickListener(this);
    }

    private void f() {
        Activity activity = ((d) this).f37201a.f36956g;
        if (activity != null) {
            activity.finish();
        }
    }

    private void g() {
        ((d) this).f37201a.f36951b.a(false);
    }

    private void h() {
        ((d) this).f37201a.f36951b.e();
    }

    public b a(boolean z) {
        this.f37161d = z;
        return this;
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((d) this).f37201a.n.add(this.f37162e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f37201a.n.remove(this.f37162e);
        this.f37160c.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37159b = b(R.id.ksad_end_close_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f37160c.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f37159b) {
            h();
            g();
            f();
        }
    }
}
