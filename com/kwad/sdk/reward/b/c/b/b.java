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
    public View f33713b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33715d;

    /* renamed from: e  reason: collision with root package name */
    public long f33716e;

    /* renamed from: c  reason: collision with root package name */
    public Handler f33714c = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public f f33717f = new f() { // from class: com.kwad.sdk.reward.b.c.b.b.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((d) b.this).f33768a.s) {
                return;
            }
            long j = b.this.f33716e;
            if (j == 0 || !b.this.f33715d) {
                b.this.e();
            } else {
                b.this.f33714c.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.b.c.b.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.j() == null || b.this.j().isFinishing()) {
                            return;
                        }
                        b.this.e();
                        b.this.f33713b.setAlpha(0.0f);
                        b.this.f33713b.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, j);
            }
        }
    };

    public b(long j) {
        this.f33716e = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f33713b.setVisibility(0);
        this.f33713b.setOnClickListener(this);
    }

    private void m() {
        Activity activity = ((d) this).f33768a.f33496g;
        if (activity != null) {
            activity.finish();
        }
    }

    private void n() {
        ((d) this).f33768a.f33491b.a(false);
    }

    private void o() {
        ((d) this).f33768a.f33491b.e();
    }

    public b a(boolean z) {
        this.f33715d = z;
        return this;
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((d) this).f33768a.a(this.f33717f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f33713b = a(R.id.ksad_end_close_btn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((d) this).f33768a.b(this.f33717f);
        this.f33714c.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        this.f33714c.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33713b) {
            o();
            n();
            m();
        }
    }
}
