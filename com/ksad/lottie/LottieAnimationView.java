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
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class LottieAnimationView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public static final String f31694a = LottieAnimationView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final h<d> f31695b;

    /* renamed from: c  reason: collision with root package name */
    public final h<Throwable> f31696c;

    /* renamed from: d  reason: collision with root package name */
    public final f f31697d;

    /* renamed from: e  reason: collision with root package name */
    public String f31698e;
    @RawRes

    /* renamed from: f  reason: collision with root package name */
    public int f31699f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31700g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f31701h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f31702i;
    public Set<i> j;
    @Nullable
    public k<d> k;
    @Nullable
    public d l;

    /* loaded from: classes6.dex */
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
            public a[] newArray(int i2) {
                return new a[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public String f31705a;

        /* renamed from: b  reason: collision with root package name */
        public int f31706b;

        /* renamed from: c  reason: collision with root package name */
        public float f31707c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f31708d;

        /* renamed from: e  reason: collision with root package name */
        public String f31709e;

        /* renamed from: f  reason: collision with root package name */
        public int f31710f;

        /* renamed from: g  reason: collision with root package name */
        public int f31711g;

        public a(Parcel parcel) {
            super(parcel);
            this.f31705a = parcel.readString();
            this.f31707c = parcel.readFloat();
            this.f31708d = parcel.readInt() == 1;
            this.f31709e = parcel.readString();
            this.f31710f = parcel.readInt();
            this.f31711g = parcel.readInt();
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f31705a);
            parcel.writeFloat(this.f31707c);
            parcel.writeInt(this.f31708d ? 1 : 0);
            parcel.writeString(this.f31709e);
            parcel.writeInt(this.f31710f);
            parcel.writeInt(this.f31711g);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.f31695b = new h<d>() { // from class: com.ksad.lottie.LottieAnimationView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(d dVar) {
                LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.f31696c = new h<Throwable>() { // from class: com.ksad.lottie.LottieAnimationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.f31697d = new f();
        this.f31700g = false;
        this.f31701h = false;
        this.f31702i = false;
        this.j = new HashSet();
        a((AttributeSet) null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f31695b = new h<d>() { // from class: com.ksad.lottie.LottieAnimationView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(d dVar) {
                LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.f31696c = new h<Throwable>() { // from class: com.ksad.lottie.LottieAnimationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.f31697d = new f();
        this.f31700g = false;
        this.f31701h = false;
        this.f31702i = false;
        this.j = new HashSet();
        a(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f31695b = new h<d>() { // from class: com.ksad.lottie.LottieAnimationView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(d dVar) {
                LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.f31696c = new h<Throwable>() { // from class: com.ksad.lottie.LottieAnimationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.f31697d = new f();
        this.f31700g = false;
        this.f31701h = false;
        this.f31702i = false;
        this.j = new HashSet();
        a(attributeSet);
    }

    private void a(Drawable drawable, boolean z) {
        if (z && drawable != this.f31697d) {
            a();
        }
        e();
        super.setImageDrawable(drawable);
    }

    private void a(@Nullable AttributeSet attributeSet) {
        g();
    }

    private void e() {
        k<d> kVar = this.k;
        if (kVar != null) {
            kVar.b(this.f31695b);
            this.k.d(this.f31696c);
        }
    }

    private void f() {
        this.l = null;
        this.f31697d.e();
    }

    private void g() {
        setLayerType(this.f31702i && this.f31697d.n() ? 2 : 1, null);
    }

    private void setCompositionTask(k<d> kVar) {
        f();
        e();
        this.k = kVar.a(this.f31695b).c(this.f31696c);
    }

    @VisibleForTesting
    public void a() {
        this.f31697d.c();
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.f31697d.a(animatorListener);
    }

    public void a(JsonReader jsonReader, @Nullable String str) {
        setCompositionTask(e.a(jsonReader, str));
    }

    public void a(String str, @Nullable String str2) {
        a(new JsonReader(new StringReader(str)), str2);
    }

    public void a(boolean z) {
        this.f31697d.a(z);
    }

    @MainThread
    public void b() {
        this.f31697d.f();
        g();
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.f31697d.b(animatorListener);
    }

    public boolean c() {
        return this.f31697d.n();
    }

    @MainThread
    public void d() {
        this.f31697d.s();
        g();
    }

    @Nullable
    public d getComposition() {
        return this.l;
    }

    public long getDuration() {
        d dVar = this.l;
        if (dVar != null) {
            return dVar.c();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f31697d.k();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f31697d.b();
    }

    public float getMaxFrame() {
        return this.f31697d.i();
    }

    public float getMinFrame() {
        return this.f31697d.h();
    }

    @Nullable
    public l getPerformanceTracker() {
        return this.f31697d.d();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.f31697d.t();
    }

    public int getRepeatCount() {
        return this.f31697d.m();
    }

    public int getRepeatMode() {
        return this.f31697d.l();
    }

    public float getScale() {
        return this.f31697d.q();
    }

    public float getSpeed() {
        return this.f31697d.j();
    }

    public boolean getUseHardwareAcceleration() {
        return this.f31702i;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        f fVar = this.f31697d;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f31701h && this.f31700g) {
            b();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (c()) {
            d();
            this.f31700g = true;
        }
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        String str = aVar.f31705a;
        this.f31698e = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.f31698e);
        }
        int i2 = aVar.f31706b;
        this.f31699f = i2;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(aVar.f31707c);
        if (aVar.f31708d) {
            b();
        }
        this.f31697d.a(aVar.f31709e);
        setRepeatMode(aVar.f31710f);
        setRepeatCount(aVar.f31711g);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f31705a = this.f31698e;
        aVar.f31706b = this.f31699f;
        aVar.f31707c = this.f31697d.t();
        aVar.f31708d = this.f31697d.n();
        aVar.f31709e = this.f31697d.b();
        aVar.f31710f = this.f31697d.l();
        aVar.f31711g = this.f31697d.m();
        return aVar;
    }

    public void setAnimation(@RawRes int i2) {
        this.f31699f = i2;
        this.f31698e = null;
        setCompositionTask(e.a(getContext(), i2));
    }

    public void setAnimation(String str) {
        this.f31698e = str;
        this.f31699f = 0;
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
        if (c.f31856a) {
            String str = f31694a;
            Log.v(str, "Set Composition \n" + dVar);
        }
        this.f31697d.setCallback(this);
        this.l = dVar;
        boolean a2 = this.f31697d.a(dVar);
        g();
        if (getDrawable() != this.f31697d || a2) {
            setImageDrawable(null);
            setImageDrawable(this.f31697d);
            requestLayout();
            for (i iVar : this.j) {
                iVar.a(dVar);
            }
        }
    }

    public void setFontAssetDelegate(com.ksad.lottie.a aVar) {
        this.f31697d.a(aVar);
    }

    public void setFrame(int i2) {
        this.f31697d.c(i2);
    }

    public void setImageAssetDelegate(b bVar) {
        this.f31697d.a(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f31697d.a(str);
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
    public void setImageResource(int i2) {
        a();
        e();
        super.setImageResource(i2);
    }

    public void setMaxFrame(int i2) {
        this.f31697d.b(i2);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f31697d.b(f2);
    }

    public void setMinFrame(int i2) {
        this.f31697d.a(i2);
    }

    public void setMinProgress(float f2) {
        this.f31697d.a(f2);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f31697d.b(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f31697d.d(f2);
    }

    public void setRepeatCount(int i2) {
        this.f31697d.e(i2);
    }

    public void setRepeatMode(int i2) {
        this.f31697d.d(i2);
    }

    public void setScale(float f2) {
        this.f31697d.e(f2);
        if (getDrawable() == this.f31697d) {
            a((Drawable) null, false);
            a((Drawable) this.f31697d, false);
        }
    }

    public void setSpeed(float f2) {
        this.f31697d.c(f2);
    }

    public void setTextDelegate(m mVar) {
        this.f31697d.a(mVar);
    }
}
