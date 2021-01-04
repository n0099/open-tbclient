package com.kwad.sdk.contentalliance.detail.photo.newui.d;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.IMConnection;
import com.kwad.sdk.utils.ao;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f8858a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f8859b;
    private Handler f;
    private a g;
    private AnimatorSet c = new AnimatorSet();
    private AnimatorSet d = new AnimatorSet();
    private AnimatorSet e = new AnimatorSet();
    private Runnable h = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.b();
        }
    };
    private Runnable i = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.d();
        }
    };
    private Runnable j = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f8859b == null) {
                return;
            }
            b.this.f8859b.setVisibility(0);
            b.this.f8859b.setPivotX(ao.a(b.this.f8859b.getContext(), 154.0f));
            b.this.f8859b.setPivotY(ao.a(b.this.f8859b.getContext(), 27.0f));
            b.this.f8859b.invalidate();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b.this.f8859b, "alpha", 0.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(b.this.f8859b, "scaleX", 0.5f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(b.this.f8859b, "scaleY", 0.5f, 1.0f);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            arrayList.add(ofFloat3);
            b.this.d.playTogether(arrayList);
            b.this.d.setDuration(300L);
            b.this.d.start();
        }
    };

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public b(@NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull Handler handler, @NonNull a aVar) {
        this.f8858a = imageView;
        this.f8859b = imageView2;
        this.g = aVar;
        this.f = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f8859b == null || this.f8858a == null) {
            return;
        }
        if (this.g != null) {
            this.g.a();
        }
        c();
        this.f.postDelayed(this.j, 500L);
        this.f.postDelayed(this.i, IMConnection.RETRY_DELAY_TIMES);
    }

    private void c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f8858a, "scaleX", 1.1f, 1.0f, 1.1f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f8858a, "scaleY", 1.1f, 1.0f, 1.1f);
        ofFloat.setRepeatCount(-1);
        ofFloat2.setRepeatCount(-1);
        this.c.setDuration(600L);
        this.c.play(ofFloat).with(ofFloat2);
        this.c.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.g != null) {
            this.g.b();
        }
        if (this.f8859b != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f8859b, "alpha", 1.0f, 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f8859b, "scaleX", 1.0f, 0.5f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f8859b, "scaleY", 1.0f, 0.5f);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            arrayList.add(ofFloat3);
            this.e.playTogether(arrayList);
            this.e.setDuration(300L);
            this.e.start();
        }
        if (this.c != null) {
            this.c.cancel();
        }
    }

    public void a() {
        if (this.g != null) {
            this.g.b();
        }
        if (this.f != null) {
            this.f.removeCallbacks(this.j);
            this.f.removeCallbacks(this.h);
            this.f.removeCallbacks(this.i);
        }
        if (this.f8859b != null) {
            this.f8859b.setVisibility(8);
        }
        if (this.d != null) {
            this.d.cancel();
        }
        if (this.e != null) {
            this.e.cancel();
        }
        if (this.c != null) {
            this.c.cancel();
        }
        this.f8858a = null;
        this.f8859b = null;
        this.g = null;
    }

    public void a(long j) {
        this.f.postDelayed(this.h, j);
    }
}
