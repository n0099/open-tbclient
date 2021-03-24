package com.kwad.sdk.reward.b.c.b;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.d;
/* loaded from: classes6.dex */
public class b extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public View f36416b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36418d;

    /* renamed from: c  reason: collision with root package name */
    public Handler f36417c = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public e f36419e = new e() { // from class: com.kwad.sdk.reward.b.c.b.b.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            long P = com.kwad.sdk.core.config.c.P() * 1000;
            if (P == 0 || !b.this.f36418d) {
                b.this.e();
            } else {
                b.this.f36417c.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.b.c.b.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.m() == null || b.this.m().isFinishing()) {
                            return;
                        }
                        b.this.e();
                        b.this.f36416b.setAlpha(0.0f);
                        b.this.f36416b.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, P);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f36416b.setVisibility(0);
        this.f36416b.setOnClickListener(this);
    }

    private void f() {
        Activity activity = ((d) this).f36457a.f36222g;
        if (activity != null) {
            activity.finish();
        }
    }

    private void g() {
        ((d) this).f36457a.f36217b.a(false);
    }

    private void h() {
        ((d) this).f36457a.f36217b.e();
    }

    public b a(boolean z) {
        this.f36418d = z;
        return this;
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((d) this).f36457a.n.add(this.f36419e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f36457a.n.remove(this.f36419e);
        this.f36417c.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f36416b = b(R.id.ksad_end_close_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f36417c.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f36416b) {
            h();
            g();
            f();
        }
    }
}
