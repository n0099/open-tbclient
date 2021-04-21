package com.kwad.sdk.contentalliance.detail.photo.newui.d;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ao;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f32828a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f32829b;

    /* renamed from: f  reason: collision with root package name */
    public Handler f32833f;

    /* renamed from: g  reason: collision with root package name */
    public a f32834g;

    /* renamed from: c  reason: collision with root package name */
    public AnimatorSet f32830c = new AnimatorSet();

    /* renamed from: d  reason: collision with root package name */
    public AnimatorSet f32831d = new AnimatorSet();

    /* renamed from: e  reason: collision with root package name */
    public AnimatorSet f32832e = new AnimatorSet();

    /* renamed from: h  reason: collision with root package name */
    public Runnable f32835h = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.b();
        }
    };
    public Runnable i = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.d();
        }
    };
    public Runnable j = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f32829b == null) {
                return;
            }
            b.this.f32829b.setVisibility(0);
            b.this.f32829b.setPivotX(ao.a(b.this.f32829b.getContext(), 154.0f));
            b.this.f32829b.setPivotY(ao.a(b.this.f32829b.getContext(), 27.0f));
            b.this.f32829b.invalidate();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b.this.f32829b, "alpha", 0.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(b.this.f32829b, "scaleX", 0.5f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(b.this.f32829b, "scaleY", 0.5f, 1.0f);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            arrayList.add(ofFloat3);
            b.this.f32831d.playTogether(arrayList);
            b.this.f32831d.setDuration(300L);
            b.this.f32831d.start();
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public b(@NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull Handler handler, @NonNull a aVar) {
        this.f32828a = imageView;
        this.f32829b = imageView2;
        this.f32834g = aVar;
        this.f32833f = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f32829b == null || this.f32828a == null) {
            return;
        }
        a aVar = this.f32834g;
        if (aVar != null) {
            aVar.a();
        }
        c();
        this.f32833f.postDelayed(this.j, 500L);
        this.f32833f.postDelayed(this.i, 3000L);
    }

    private void c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f32828a, "scaleX", 1.1f, 1.0f, 1.1f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f32828a, "scaleY", 1.1f, 1.0f, 1.1f);
        ofFloat.setRepeatCount(-1);
        ofFloat2.setRepeatCount(-1);
        this.f32830c.setDuration(600L);
        this.f32830c.play(ofFloat).with(ofFloat2);
        this.f32830c.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        a aVar = this.f32834g;
        if (aVar != null) {
            aVar.b();
        }
        ImageView imageView = this.f32829b;
        if (imageView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f32829b, "scaleX", 1.0f, 0.5f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f32829b, "scaleY", 1.0f, 0.5f);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            arrayList.add(ofFloat3);
            this.f32832e.playTogether(arrayList);
            this.f32832e.setDuration(300L);
            this.f32832e.start();
        }
        AnimatorSet animatorSet = this.f32830c;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void a() {
        a aVar = this.f32834g;
        if (aVar != null) {
            aVar.b();
        }
        Handler handler = this.f32833f;
        if (handler != null) {
            handler.removeCallbacks(this.j);
            this.f32833f.removeCallbacks(this.f32835h);
            this.f32833f.removeCallbacks(this.i);
        }
        ImageView imageView = this.f32829b;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        AnimatorSet animatorSet = this.f32831d;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f32832e;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.f32830c;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        this.f32828a = null;
        this.f32829b = null;
        this.f32834g = null;
    }

    public void a(long j) {
        this.f32833f.postDelayed(this.f32835h, j);
    }
}
