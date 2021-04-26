package com.kwad.sdk.reward.b.c.b;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.d;
/* loaded from: classes6.dex */
public class b extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public View f34539b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34541d;

    /* renamed from: e  reason: collision with root package name */
    public long f34542e;

    /* renamed from: c  reason: collision with root package name */
    public Handler f34540c = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public f f34543f = new f() { // from class: com.kwad.sdk.reward.b.c.b.b.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((d) b.this).f34594a.s) {
                return;
            }
            long j = b.this.f34542e;
            if (j == 0 || !b.this.f34541d) {
                b.this.e();
            } else {
                b.this.f34540c.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.b.c.b.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.j() == null || b.this.j().isFinishing()) {
                            return;
                        }
                        b.this.e();
                        b.this.f34539b.setAlpha(0.0f);
                        b.this.f34539b.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, j);
            }
        }
    };

    public b(long j) {
        this.f34542e = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f34539b.setVisibility(0);
        this.f34539b.setOnClickListener(this);
    }

    private void m() {
        Activity activity = ((d) this).f34594a.f34322g;
        if (activity != null) {
            activity.finish();
        }
    }

    private void n() {
        ((d) this).f34594a.f34317b.a(false);
    }

    private void o() {
        ((d) this).f34594a.f34317b.e();
    }

    public b a(boolean z) {
        this.f34541d = z;
        return this;
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((d) this).f34594a.a(this.f34543f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f34539b = a(R.id.ksad_end_close_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((d) this).f34594a.b(this.f34543f);
        this.f34540c.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f34540c.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f34539b) {
            o();
            n();
            m();
        }
    }
}
