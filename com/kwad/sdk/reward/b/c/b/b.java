package com.kwad.sdk.reward.b.c.b;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.d;
/* loaded from: classes3.dex */
public class b extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private View f10631b;
    private boolean d;
    private Handler c = new Handler(Looper.getMainLooper());
    private e e = new e() { // from class: com.kwad.sdk.reward.b.c.b.b.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            long P = com.kwad.sdk.core.config.c.P() * 1000;
            if (P == 0 || !b.this.d) {
                b.this.e();
            } else {
                b.this.c.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.b.c.b.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.m() == null || b.this.m().isFinishing()) {
                            return;
                        }
                        b.this.e();
                        b.this.f10631b.setAlpha(0.0f);
                        b.this.f10631b.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, P);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f10631b.setVisibility(0);
        this.f10631b.setOnClickListener(this);
    }

    private void f() {
        Activity activity = this.f10652a.g;
        if (activity != null) {
            activity.finish();
        }
    }

    private void g() {
        this.f10652a.f10527b.a(false);
    }

    private void h() {
        this.f10652a.f10527b.e();
    }

    public b a(boolean z) {
        this.d = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f10652a.n.add(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f10652a.n.remove(this.e);
        this.c.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f10631b = b(R.id.ksad_end_close_btn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.c.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f10631b) {
            h();
            g();
            f();
        }
    }
}
