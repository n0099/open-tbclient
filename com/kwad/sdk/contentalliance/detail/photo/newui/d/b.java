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
    public ImageView f33019a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f33020b;

    /* renamed from: f  reason: collision with root package name */
    public Handler f33024f;

    /* renamed from: g  reason: collision with root package name */
    public a f33025g;

    /* renamed from: c  reason: collision with root package name */
    public AnimatorSet f33021c = new AnimatorSet();

    /* renamed from: d  reason: collision with root package name */
    public AnimatorSet f33022d = new AnimatorSet();

    /* renamed from: e  reason: collision with root package name */
    public AnimatorSet f33023e = new AnimatorSet();

    /* renamed from: h  reason: collision with root package name */
    public Runnable f33026h = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.b();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public Runnable f33027i = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.d();
        }
    };
    public Runnable j = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.b.3
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f33020b == null) {
                return;
            }
            b.this.f33020b.setVisibility(0);
            b.this.f33020b.setPivotX(ao.a(b.this.f33020b.getContext(), 154.0f));
            b.this.f33020b.setPivotY(ao.a(b.this.f33020b.getContext(), 27.0f));
            b.this.f33020b.invalidate();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b.this.f33020b, "alpha", 0.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(b.this.f33020b, "scaleX", 0.5f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(b.this.f33020b, "scaleY", 0.5f, 1.0f);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            arrayList.add(ofFloat3);
            b.this.f33022d.playTogether(arrayList);
            b.this.f33022d.setDuration(300L);
            b.this.f33022d.start();
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public b(@NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull Handler handler, @NonNull a aVar) {
        this.f33019a = imageView;
        this.f33020b = imageView2;
        this.f33025g = aVar;
        this.f33024f = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f33020b == null || this.f33019a == null) {
            return;
        }
        a aVar = this.f33025g;
        if (aVar != null) {
            aVar.a();
        }
        c();
        this.f33024f.postDelayed(this.j, 500L);
        this.f33024f.postDelayed(this.f33027i, 3000L);
    }

    private void c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f33019a, "scaleX", 1.1f, 1.0f, 1.1f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f33019a, "scaleY", 1.1f, 1.0f, 1.1f);
        ofFloat.setRepeatCount(-1);
        ofFloat2.setRepeatCount(-1);
        this.f33021c.setDuration(600L);
        this.f33021c.play(ofFloat).with(ofFloat2);
        this.f33021c.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        a aVar = this.f33025g;
        if (aVar != null) {
            aVar.b();
        }
        ImageView imageView = this.f33020b;
        if (imageView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f33020b, "scaleX", 1.0f, 0.5f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f33020b, "scaleY", 1.0f, 0.5f);
            ArrayList arrayList = new ArrayList();
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            arrayList.add(ofFloat3);
            this.f33023e.playTogether(arrayList);
            this.f33023e.setDuration(300L);
            this.f33023e.start();
        }
        AnimatorSet animatorSet = this.f33021c;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void a() {
        a aVar = this.f33025g;
        if (aVar != null) {
            aVar.b();
        }
        Handler handler = this.f33024f;
        if (handler != null) {
            handler.removeCallbacks(this.j);
            this.f33024f.removeCallbacks(this.f33026h);
            this.f33024f.removeCallbacks(this.f33027i);
        }
        ImageView imageView = this.f33020b;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        AnimatorSet animatorSet = this.f33022d;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f33023e;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.f33021c;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        this.f33019a = null;
        this.f33020b = null;
        this.f33025g = null;
    }

    public void a(long j) {
        this.f33024f.postDelayed(this.f33026h, j);
    }
}
