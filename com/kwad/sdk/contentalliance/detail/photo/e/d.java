package com.kwad.sdk.contentalliance.detail.photo.e;

import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageButton;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.b;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.widget.KsAdFrameLayout;
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.contentalliance.detail.b {
    private ImageButton d;
    private com.kwad.sdk.contentalliance.detail.video.b e;
    private KsAdFrameLayout g;
    private GestureDetector n;
    private SlidePlayViewPager o;
    private com.kwad.sdk.contentalliance.home.swipe.c p;
    private com.kwad.sdk.contentalliance.trends.view.c c = new com.kwad.sdk.contentalliance.trends.view.d() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.1
        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a() {
            d.this.a(1);
            d.this.d.setVisibility(4);
        }

        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void b() {
            d.this.a(0);
        }
    };
    private b f = new e();
    private com.kwad.sdk.contentalliance.a.a h = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            d.this.f();
        }
    };
    private com.kwad.sdk.contentalliance.detail.video.e i = new f() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.3
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            d.this.f();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(int i, int i2) {
            d.this.f();
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a(long j, long j2) {
            if (com.kwad.sdk.core.response.b.c.B(d.this.f8395a.j) && d.this.f8395a.f8404a != null && d.this.f8395a.f8404a.l) {
                d.this.a(1);
                d.this.d.setVisibility(4);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            d.this.g();
            d.this.e().a(new C1078d());
            d.this.k = false;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            d.this.e().a(new c());
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            d.this.e().a(new C1078d());
        }
    };
    private Runnable j = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.4
        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.core.d.a.a("PhotoVideoControlPresenter", "mAutoHidePauseButtonCallback run=" + d.this.f);
            if (d.this.f != null) {
                d.this.f.a(new C1078d());
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    View.OnClickListener f8500b = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.g();
            if (d.this.e() instanceof C1078d) {
                d.this.e().b();
            } else {
                d.this.e().a();
            }
        }
    };
    private boolean k = false;
    private b.a l = new b.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.6
        @Override // com.kwad.sdk.contentalliance.detail.video.b.a
        public boolean a() {
            return d.this.k;
        }
    };
    private GestureDetector.SimpleOnGestureListener m = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.7

        /* renamed from: a  reason: collision with root package name */
        boolean f8507a = false;

        /* renamed from: b  reason: collision with root package name */
        long f8508b = 0;

        private boolean a() {
            return SystemClock.elapsedRealtime() - this.f8508b < ((long) ViewConfiguration.getJumpTapTimeout());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            this.f8508b = SystemClock.elapsedRealtime();
            return this.f8507a;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (a()) {
                return false;
            }
            d.this.g();
            if (d.this.p == null || (d.this.o.getSourceType() == 0 && !d.this.p.b())) {
                d.this.e().b();
            } else {
                d.this.p.c();
            }
            this.f8507a = false;
            this.f8508b = 0L;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f8507a = false;
            return true;
        }
    };
    private com.kwad.sdk.contentalliance.home.swipe.a q = new com.kwad.sdk.contentalliance.home.swipe.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.8
        @Override // com.kwad.sdk.contentalliance.home.swipe.b, com.kwad.sdk.contentalliance.home.swipe.a
        public void a(float f) {
            d.this.a(f);
        }
    };

    /* loaded from: classes3.dex */
    private abstract class a implements b {
        private a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void a(@NonNull b bVar) {
            d.this.f = bVar;
            bVar.c();
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface b {
        @MainThread
        void a();

        @MainThread
        void a(@NonNull b bVar);

        @MainThread
        void b();

        @MainThread
        void c();
    }

    /* loaded from: classes3.dex */
    private class c extends a {
        private c() {
            super();
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.a, com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void a() {
            d.this.a(0);
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.a, com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void b() {
            d.this.a(0);
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void c() {
            d.this.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.kwad.sdk.contentalliance.detail.photo.e.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1078d extends a {
        private C1078d() {
            super();
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.a, com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void b() {
            d.this.a(1);
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void c() {
            d.this.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class e extends a {
        private e() {
            super();
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.a, com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void b() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void c() {
            d.this.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        this.d.setAlpha(f);
        this.d.setClickable(f == 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.e != null) {
            if (i == 1) {
                this.k = true;
                this.e.g();
                return;
            }
            this.k = false;
            this.e.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.d.setBackgroundResource(R.drawable.ksad_photo_video_play_icon_2);
        this.d.setVisibility(z ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        g();
        this.f = new e();
        a(false);
        this.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.d.removeCallbacks(this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.k = false;
        this.o = this.f8395a.l;
        this.p = this.f8395a.f8404a.g;
        this.e = this.f8395a.m;
        this.e.a(this.l);
        this.e.a(this.i);
        this.f8395a.f8405b.add(this.h);
        f();
        this.d.setOnClickListener(this.f8500b);
        this.n = new GestureDetector(o(), this.m);
        this.g.a(this.n);
        if (com.kwad.sdk.core.response.b.c.B(this.f8395a.j)) {
            this.f8395a.a(this.c);
        }
        a(this.o.getSourceType() == 0 ? 1.0f : 0.0f);
        this.f8395a.e.add(this.q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.e.b(this.l);
        this.e.b(this.i);
        this.d.setOnClickListener(null);
        this.f8395a.f8405b.remove(this.h);
        this.g.b(this.n);
        f();
        this.f8395a.b(this.c);
        this.f8395a.e.remove(this.q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.d = (ImageButton) b(R.id.ksad_video_control_button);
        this.g = (KsAdFrameLayout) b(R.id.ksad_video_container);
        this.g.setClickable(true);
    }

    public b e() {
        if (this.f == null) {
            this.f = new C1078d();
        }
        return this.f;
    }
}
