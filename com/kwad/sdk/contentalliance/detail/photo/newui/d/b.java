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
    public ImageView f32444a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f32445b;

    /* renamed from: f  reason: collision with root package name */
    public Handler f32449f;

    /* renamed from: g  reason: collision with root package name */
    public a f32450g;

    /* renamed from: c  reason: collision with root package name */
    public AnimatorSet f32446c = new AnimatorSet();

    /* renamed from: d  reason: collision with root package name */
    public AnimatorSet f32447d = new AnimatorSet();

    /* renamed from: e  reason: collision with root package name */
    public AnimatorSet f32448e = new AnimatorSet();

    /* renamed from: h  reason: collision with root package name */
    public Runnable f32451h = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.b.1
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
            if (b.this.f32445b == null) {
                return;
            }
            b.this.f32445b.setVisibility(0);
            b.this.f32445b.setPivotX(ao.a(b.this.f32445b.getContext(), 154.0f));
            b.this.f32445b.setPivotY(ao.a(b.this.f32445b.getContext(), 27.0f));
            b.this.f32445b.invalidate();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b.this.f32445b, "alpha", 0.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(b.this.f32445b, "scaleX", 0.5f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(b.this.f32445b, "scaleY", 0.5f, 1.0f);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            arrayList.add(ofFloat3);
            b.this.f32447d.playTogether(arrayList);
            b.this.f32447d.setDuration(300L);
            b.this.f32447d.start();
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public b(@NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull Handler handler, @NonNull a aVar) {
        this.f32444a = imageView;
        this.f32445b = imageView2;
        this.f32450g = aVar;
        this.f32449f = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f32445b == null || this.f32444a == null) {
            return;
        }
        a aVar = this.f32450g;
        if (aVar != null) {
            aVar.a();
        }
        c();
        this.f32449f.postDelayed(this.j, 500L);
        this.f32449f.postDelayed(this.i, 3000L);
    }

    private void c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f32444a, "scaleX", 1.1f, 1.0f, 1.1f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f32444a, "scaleY", 1.1f, 1.0f, 1.1f);
        ofFloat.setRepeatCount(-1);
        ofFloat2.setRepeatCount(-1);
        this.f32446c.setDuration(600L);
        this.f32446c.play(ofFloat).with(ofFloat2);
        this.f32446c.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        a aVar = this.f32450g;
        if (aVar != null) {
            aVar.b();
        }
        ImageView imageView = this.f32445b;
        if (imageView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f32445b, "scaleX", 1.0f, 0.5f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f32445b, "scaleY", 1.0f, 0.5f);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            arrayList.add(ofFloat3);
            this.f32448e.playTogether(arrayList);
            this.f32448e.setDuration(300L);
            this.f32448e.start();
        }
        AnimatorSet animatorSet = this.f32446c;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void a() {
        a aVar = this.f32450g;
        if (aVar != null) {
            aVar.b();
        }
        Handler handler = this.f32449f;
        if (handler != null) {
            handler.removeCallbacks(this.j);
            this.f32449f.removeCallbacks(this.f32451h);
            this.f32449f.removeCallbacks(this.i);
        }
        ImageView imageView = this.f32445b;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        AnimatorSet animatorSet = this.f32447d;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f32448e;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.f32446c;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        this.f32444a = null;
        this.f32445b = null;
        this.f32450g = null;
    }

    public void a(long j) {
        this.f32449f.postDelayed(this.f32451h, j);
    }
}
