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
    public View f37257b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37259d;

    /* renamed from: c  reason: collision with root package name */
    public Handler f37258c = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public e f37260e = new e() { // from class: com.kwad.sdk.reward.b.c.b.b.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            long P = com.kwad.sdk.core.config.c.P() * 1000;
            if (P == 0 || !b.this.f37259d) {
                b.this.e();
            } else {
                b.this.f37258c.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.b.c.b.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.m() == null || b.this.m().isFinishing()) {
                            return;
                        }
                        b.this.e();
                        b.this.f37257b.setAlpha(0.0f);
                        b.this.f37257b.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, P);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f37257b.setVisibility(0);
        this.f37257b.setOnClickListener(this);
    }

    private void f() {
        Activity activity = ((d) this).f37299a.f37054g;
        if (activity != null) {
            activity.finish();
        }
    }

    private void g() {
        ((d) this).f37299a.f37049b.a(false);
    }

    private void h() {
        ((d) this).f37299a.f37049b.e();
    }

    public b a(boolean z) {
        this.f37259d = z;
        return this;
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((d) this).f37299a.n.add(this.f37260e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f37299a.n.remove(this.f37260e);
        this.f37258c.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37257b = b(R.id.ksad_end_close_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f37258c.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f37257b) {
            h();
            g();
            f();
        }
    }
}
