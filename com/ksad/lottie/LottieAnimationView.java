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
/* loaded from: classes6.dex */
public class LottieAnimationView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public static final String f31174a = LottieAnimationView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final h<d> f31175b;

    /* renamed from: c  reason: collision with root package name */
    public final h<Throwable> f31176c;

    /* renamed from: d  reason: collision with root package name */
    public final f f31177d;

    /* renamed from: e  reason: collision with root package name */
    public String f31178e;
    @RawRes

    /* renamed from: f  reason: collision with root package name */
    public int f31179f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31180g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f31181h;
    public boolean i;
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
            public a[] newArray(int i) {
                return new a[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public String f31184a;

        /* renamed from: b  reason: collision with root package name */
        public int f31185b;

        /* renamed from: c  reason: collision with root package name */
        public float f31186c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f31187d;

        /* renamed from: e  reason: collision with root package name */
        public String f31188e;

        /* renamed from: f  reason: collision with root package name */
        public int f31189f;

        /* renamed from: g  reason: collision with root package name */
        public int f31190g;

        public a(Parcel parcel) {
            super(parcel);
            this.f31184a = parcel.readString();
            this.f31186c = parcel.readFloat();
            this.f31187d = parcel.readInt() == 1;
            this.f31188e = parcel.readString();
            this.f31189f = parcel.readInt();
            this.f31190g = parcel.readInt();
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f31184a);
            parcel.writeFloat(this.f31186c);
            parcel.writeInt(this.f31187d ? 1 : 0);
            parcel.writeString(this.f31188e);
            parcel.writeInt(this.f31189f);
            parcel.writeInt(this.f31190g);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.f31175b = new h<d>() { // from class: com.ksad.lottie.LottieAnimationView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(d dVar) {
                LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.f31176c = new h<Throwable>() { // from class: com.ksad.lottie.LottieAnimationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.f31177d = new f();
        this.f31180g = false;
        this.f31181h = false;
        this.i = false;
        this.j = new HashSet();
        a((AttributeSet) null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f31175b = new h<d>() { // from class: com.ksad.lottie.LottieAnimationView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(d dVar) {
                LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.f31176c = new h<Throwable>() { // from class: com.ksad.lottie.LottieAnimationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.f31177d = new f();
        this.f31180g = false;
        this.f31181h = false;
        this.i = false;
        this.j = new HashSet();
        a(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f31175b = new h<d>() { // from class: com.ksad.lottie.LottieAnimationView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(d dVar) {
                LottieAnimationView.this.setComposition(dVar);
            }
        };
        this.f31176c = new h<Throwable>() { // from class: com.ksad.lottie.LottieAnimationView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.f31177d = new f();
        this.f31180g = false;
        this.f31181h = false;
        this.i = false;
        this.j = new HashSet();
        a(attributeSet);
    }

    private void a(Drawable drawable, boolean z) {
        if (z && drawable != this.f31177d) {
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
            kVar.b(this.f31175b);
            this.k.d(this.f31176c);
        }
    }

    private void f() {
        this.l = null;
        this.f31177d.e();
    }

    private void g() {
        setLayerType(this.i && this.f31177d.n() ? 2 : 1, null);
    }

    private void setCompositionTask(k<d> kVar) {
        f();
        e();
        this.k = kVar.a(this.f31175b).c(this.f31176c);
    }

    @VisibleForTesting
    public void a() {
        this.f31177d.c();
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.f31177d.a(animatorListener);
    }

    public void a(JsonReader jsonReader, @Nullable String str) {
        setCompositionTask(e.a(jsonReader, str));
    }

    public void a(String str, @Nullable String str2) {
        a(new JsonReader(new StringReader(str)), str2);
    }

    public void a(boolean z) {
        this.f31177d.a(z);
    }

    @MainThread
    public void b() {
        this.f31177d.f();
        g();
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.f31177d.b(animatorListener);
    }

    public boolean c() {
        return this.f31177d.n();
    }

    @MainThread
    public void d() {
        this.f31177d.s();
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
        return this.f31177d.k();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f31177d.b();
    }

    public float getMaxFrame() {
        return this.f31177d.i();
    }

    public float getMinFrame() {
        return this.f31177d.h();
    }

    @Nullable
    public l getPerformanceTracker() {
        return this.f31177d.d();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.f31177d.t();
    }

    public int getRepeatCount() {
        return this.f31177d.m();
    }

    public int getRepeatMode() {
        return this.f31177d.l();
    }

    public float getScale() {
        return this.f31177d.q();
    }

    public float getSpeed() {
        return this.f31177d.j();
    }

    public boolean getUseHardwareAcceleration() {
        return this.i;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        f fVar = this.f31177d;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f31181h && this.f31180g) {
            b();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (c()) {
            d();
            this.f31180g = true;
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
        String str = aVar.f31184a;
        this.f31178e = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.f31178e);
        }
        int i = aVar.f31185b;
        this.f31179f = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(aVar.f31186c);
        if (aVar.f31187d) {
            b();
        }
        this.f31177d.a(aVar.f31188e);
        setRepeatMode(aVar.f31189f);
        setRepeatCount(aVar.f31190g);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f31184a = this.f31178e;
        aVar.f31185b = this.f31179f;
        aVar.f31186c = this.f31177d.t();
        aVar.f31187d = this.f31177d.n();
        aVar.f31188e = this.f31177d.b();
        aVar.f31189f = this.f31177d.l();
        aVar.f31190g = this.f31177d.m();
        return aVar;
    }

    public void setAnimation(@RawRes int i) {
        this.f31179f = i;
        this.f31178e = null;
        setCompositionTask(e.a(getContext(), i));
    }

    public void setAnimation(String str) {
        this.f31178e = str;
        this.f31179f = 0;
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
        if (c.f31328a) {
            String str = f31174a;
            Log.v(str, "Set Composition \n" + dVar);
        }
        this.f31177d.setCallback(this);
        this.l = dVar;
        boolean a2 = this.f31177d.a(dVar);
        g();
        if (getDrawable() != this.f31177d || a2) {
            setImageDrawable(null);
            setImageDrawable(this.f31177d);
            requestLayout();
            for (i iVar : this.j) {
                iVar.a(dVar);
            }
        }
    }

    public void setFontAssetDelegate(com.ksad.lottie.a aVar) {
        this.f31177d.a(aVar);
    }

    public void setFrame(int i) {
        this.f31177d.c(i);
    }

    public void setImageAssetDelegate(b bVar) {
        this.f31177d.a(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f31177d.a(str);
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
        this.f31177d.b(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f31177d.b(f2);
    }

    public void setMinFrame(int i) {
        this.f31177d.a(i);
    }

    public void setMinProgress(float f2) {
        this.f31177d.a(f2);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f31177d.b(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f31177d.d(f2);
    }

    public void setRepeatCount(int i) {
        this.f31177d.e(i);
    }

    public void setRepeatMode(int i) {
        this.f31177d.d(i);
    }

    public void setScale(float f2) {
        this.f31177d.e(f2);
        if (getDrawable() == this.f31177d) {
            a((Drawable) null, false);
            a((Drawable) this.f31177d, false);
        }
    }

    public void setSpeed(float f2) {
        this.f31177d.c(f2);
    }

    public void setTextDelegate(m mVar) {
        this.f31177d.a(mVar);
    }
}
