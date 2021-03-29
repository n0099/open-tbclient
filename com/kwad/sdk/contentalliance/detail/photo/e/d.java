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
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: d  reason: collision with root package name */
    public ImageButton f32334d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32335e;

    /* renamed from: g  reason: collision with root package name */
    public KsAdFrameLayout f32337g;
    public GestureDetector n;
    public SlidePlayViewPager o;
    public com.kwad.sdk.contentalliance.home.swipe.c p;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.trends.view.c f32333c = new com.kwad.sdk.contentalliance.trends.view.d() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.1
        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a() {
            d.this.a(1);
            d.this.f32334d.setVisibility(4);
        }

        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void b() {
            d.this.a(0);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public b f32336f = new e();

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f32338h = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            d.this.f();
        }
    };
    public com.kwad.sdk.contentalliance.detail.video.e i = new f() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.3
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
            if (com.kwad.sdk.core.response.b.c.B(((com.kwad.sdk.contentalliance.detail.b) d.this).f32133a.j) && ((com.kwad.sdk.contentalliance.detail.b) d.this).f32133a.f32152a != null && ((com.kwad.sdk.contentalliance.detail.b) d.this).f32133a.f32152a.l) {
                d.this.a(1);
                d.this.f32334d.setVisibility(4);
            }
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            d.this.g();
            d.this.e().a(new C0363d());
            d.this.k = false;
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void c() {
            d.this.e().a(new c());
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            d.this.e().a(new C0363d());
        }
    };
    public Runnable j = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.4
        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.core.d.a.a("PhotoVideoControlPresenter", "mAutoHidePauseButtonCallback run=" + d.this.f32336f);
            if (d.this.f32336f != null) {
                d.this.f32336f.a(new C0363d());
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f32332b = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.g();
            if (d.this.e() instanceof C0363d) {
                d.this.e().b();
            } else {
                d.this.e().a();
            }
        }
    };
    public boolean k = false;
    public b.a l = new b.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.6
        @Override // com.kwad.sdk.contentalliance.detail.video.b.a
        public boolean a() {
            return d.this.k;
        }
    };
    public GestureDetector.SimpleOnGestureListener m = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.7

        /* renamed from: a  reason: collision with root package name */
        public boolean f32345a = false;

        /* renamed from: b  reason: collision with root package name */
        public long f32346b = 0;

        private boolean a() {
            return SystemClock.elapsedRealtime() - this.f32346b < ((long) ViewConfiguration.getJumpTapTimeout());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            this.f32346b = SystemClock.elapsedRealtime();
            return this.f32345a;
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
            this.f32345a = false;
            this.f32346b = 0L;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f32345a = false;
            return true;
        }
    };
    public com.kwad.sdk.contentalliance.home.swipe.a q = new com.kwad.sdk.contentalliance.home.swipe.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.d.8
        @Override // com.kwad.sdk.contentalliance.home.swipe.b, com.kwad.sdk.contentalliance.home.swipe.a
        public void a(float f2) {
            d.this.a(f2);
        }
    };

    /* loaded from: classes6.dex */
    public abstract class a implements b {
        public a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void a() {
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void a(@NonNull b bVar) {
            d.this.f32336f = bVar;
            bVar.c();
        }

        @Override // com.kwad.sdk.contentalliance.detail.photo.e.d.b
        public void b() {
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class c extends a {
        public c() {
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

    /* renamed from: com.kwad.sdk.contentalliance.detail.photo.e.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0363d extends a {
        public C0363d() {
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

    /* loaded from: classes6.dex */
    public class e extends a {
        public e() {
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
    public void a(float f2) {
        this.f32334d.setAlpha(f2);
        this.f32334d.setClickable(f2 == 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.f32335e;
        if (bVar != null) {
            if (i == 1) {
                this.k = true;
                bVar.g();
                return;
            }
            this.k = false;
            bVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.f32334d.setBackgroundResource(R.drawable.ksad_photo_video_play_icon_2);
        this.f32334d.setVisibility(z ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        g();
        this.f32336f = new e();
        a(false);
        this.k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f32334d.removeCallbacks(this.j);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.k = false;
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a;
        this.o = cVar.l;
        this.p = cVar.f32152a.f32795g;
        com.kwad.sdk.contentalliance.detail.video.b bVar = cVar.m;
        this.f32335e = bVar;
        bVar.a(this.l);
        this.f32335e.a(this.i);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32153b.add(this.f32338h);
        f();
        this.f32334d.setOnClickListener(this.f32332b);
        GestureDetector gestureDetector = new GestureDetector(o(), this.m);
        this.n = gestureDetector;
        this.f32337g.a(gestureDetector);
        if (com.kwad.sdk.core.response.b.c.B(((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j)) {
            ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.a(this.f32333c);
        }
        a(this.o.getSourceType() == 0 ? 1.0f : 0.0f);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32156e.add(this.q);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32335e.b(this.l);
        this.f32335e.b(this.i);
        this.f32334d.setOnClickListener(null);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32153b.remove(this.f32338h);
        this.f32337g.b(this.n);
        f();
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.b(this.f32333c);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32156e.remove(this.q);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32334d = (ImageButton) b(R.id.ksad_video_control_button);
        KsAdFrameLayout ksAdFrameLayout = (KsAdFrameLayout) b(R.id.ksad_video_container);
        this.f32337g = ksAdFrameLayout;
        ksAdFrameLayout.setClickable(true);
    }

    public b e() {
        if (this.f32336f == null) {
            this.f32336f = new C0363d();
        }
        return this.f32336f;
    }
}
