package com.ksad.lottie;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.VisibleForTesting;
import com.baidu.mapapi.map.WeightedLatLng;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class LottieAnimationView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5304a = LottieAnimationView.class.getSimpleName();
    private final h<d> b;
    private final h<Throwable> c;
    private final f d;
    private String e;
    @RawRes
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;
    private Set<i> j;
    @Nullable
    private k<d> k;
    @Nullable
    private d l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.ksad.lottie.LottieAnimationView.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public a[] newArray(int i) {
                return new a[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        String f5307a;
        int b;
        float c;
        boolean d;
        String e;
        int f;
        int g;

        private a(Parcel parcel) {
            super(parcel);
            this.f5307a = parcel.readString();
            this.c = parcel.readFloat();
            this.d = parcel.readInt() == 1;
            this.e = parcel.readString();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f5307a);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.d ? 1 : 0);
            parcel.writeString(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.b = new h<d>() { // from class: com.ksad.lottie.LottieAnimationView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(d dVar) {
                LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.c = new h<Throwable>() { // from class: com.ksad.lottie.LottieAnimationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.d = new f();
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = new HashSet();
        a((AttributeSet) null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new h<d>() { // from class: com.ksad.lottie.LottieAnimationView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(d dVar) {
                LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.c = new h<Throwable>() { // from class: com.ksad.lottie.LottieAnimationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.d = new f();
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = new HashSet();
        a(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new h<d>() { // from class: com.ksad.lottie.LottieAnimationView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(d dVar) {
                LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.c = new h<Throwable>() { // from class: com.ksad.lottie.LottieAnimationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.d = new f();
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = new HashSet();
        a(attributeSet);
    }

    private void a(Drawable drawable, boolean z) {
        if (z && drawable != this.d) {
            a();
        }
        e();
        super.setImageDrawable(drawable);
    }

    private void a(@Nullable AttributeSet attributeSet) {
        g();
    }

    private void e() {
        if (this.k != null) {
            this.k.b(this.b);
            this.k.d(this.c);
        }
    }

    private void f() {
        this.l = null;
        this.d.e();
    }

    private void g() {
        setLayerType(this.i && this.d.n() ? 2 : 1, null);
    }

    private void setCompositionTask(k<d> kVar) {
        f();
        e();
        this.k = kVar.a(this.b).c(this.c);
    }

    @VisibleForTesting
    void a() {
        this.d.c();
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.d.a(animatorListener);
    }

    public void a(JsonReader jsonReader, @Nullable String str) {
        setCompositionTask(e.a(jsonReader, str));
    }

    public void a(String str, @Nullable String str2) {
        a(new JsonReader(new StringReader(str)), str2);
    }

    public void a(boolean z) {
        this.d.a(z);
    }

    @MainThread
    public void b() {
        this.d.f();
        g();
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.d.b(animatorListener);
    }

    public boolean c() {
        return this.d.n();
    }

    @MainThread
    public void d() {
        this.d.s();
        g();
    }

    @Nullable
    public d getComposition() {
        return this.l;
    }

    public long getDuration() {
        if (this.l != null) {
            return this.l.c();
        }
        return 0L;
    }

    public int getFrame() {
        return this.d.k();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.d.b();
    }

    public float getMaxFrame() {
        return this.d.i();
    }

    public float getMinFrame() {
        return this.d.h();
    }

    @Nullable
    public l getPerformanceTracker() {
        return this.d.d();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.d.t();
    }

    public int getRepeatCount() {
        return this.d.m();
    }

    public int getRepeatMode() {
        return this.d.l();
    }

    public float getScale() {
        return this.d.q();
    }

    public float getSpeed() {
        return this.d.j();
    }

    public boolean getUseHardwareAcceleration() {
        return this.i;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.d) {
            super.invalidateDrawable(this.d);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h && this.g) {
            b();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (c()) {
            d();
            this.g = true;
        }
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.e = aVar.f5307a;
        if (!TextUtils.isEmpty(this.e)) {
            setAnimation(this.e);
        }
        this.f = aVar.b;
        if (this.f != 0) {
            setAnimation(this.f);
        }
        setProgress(aVar.c);
        if (aVar.d) {
            b();
        }
        this.d.a(aVar.e);
        setRepeatMode(aVar.f);
        setRepeatCount(aVar.g);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f5307a = this.e;
        aVar.b = this.f;
        aVar.c = this.d.t();
        aVar.d = this.d.n();
        aVar.e = this.d.b();
        aVar.f = this.d.l();
        aVar.g = this.d.m();
        return aVar;
    }

    public void setAnimation(@RawRes int i) {
        this.f = i;
        this.e = null;
        setCompositionTask(e.a(getContext(), i));
    }

    public void setAnimation(String str) {
        this.e = str;
        this.f = 0;
        setCompositionTask(e.b(getContext(), str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        a(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(e.a(getContext(), str));
    }

    public void setComposition(@NonNull d dVar) {
        if (c.f5327a) {
            Log.v(f5304a, "Set Composition \n" + dVar);
        }
        this.d.setCallback(this);
        this.l = dVar;
        boolean a2 = this.d.a(dVar);
        g();
        if (getDrawable() != this.d || a2) {
            setImageDrawable(null);
            setImageDrawable(this.d);
            requestLayout();
            for (i iVar : this.j) {
                iVar.a(dVar);
            }
        }
    }

    public void setFontAssetDelegate(com.ksad.lottie.a aVar) {
        this.d.a(aVar);
    }

    public void setFrame(int i) {
        this.d.c(i);
    }

    public void setImageAssetDelegate(b bVar) {
        this.d.a(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.d.a(str);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        a();
        e();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        a(drawable, true);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        a();
        e();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.d.b(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.d.b(f);
    }

    public void setMinFrame(int i) {
        this.d.a(i);
    }

    public void setMinProgress(float f) {
        this.d.a(f);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.d.b(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.d.d(f);
    }

    public void setRepeatCount(int i) {
        this.d.e(i);
    }

    public void setRepeatMode(int i) {
        this.d.d(i);
    }

    public void setScale(float f) {
        this.d.e(f);
        if (getDrawable() == this.d) {
            a((Drawable) null, false);
            a((Drawable) this.d, false);
        }
    }

    public void setSpeed(float f) {
        this.d.c(f);
    }

    public void setTextDelegate(m mVar) {
        this.d.a(mVar);
    }
}
