package com.kwad.sdk.glide.request.a;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.request.b.b;
/* loaded from: classes6.dex */
public abstract class e<Z> extends k<ImageView, Z> implements b.a {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public Animatable f36160b;

    public e(ImageView imageView) {
        super(imageView);
    }

    private void b(@Nullable Z z) {
        a((e<Z>) z);
        c((e<Z>) z);
    }

    private void c(@Nullable Z z) {
        if (!(z instanceof Animatable)) {
            this.f36160b = null;
            return;
        }
        Animatable animatable = (Animatable) z;
        this.f36160b = animatable;
        animatable.start();
    }

    @Override // com.kwad.sdk.glide.request.a.k, com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void a(@Nullable Drawable drawable) {
        super.a(drawable);
        Animatable animatable = this.f36160b;
        if (animatable != null) {
            animatable.stop();
        }
        b((e<Z>) null);
        e(drawable);
    }

    public abstract void a(@Nullable Z z);

    @Override // com.kwad.sdk.glide.request.a.j
    public void a(@NonNull Z z, @Nullable com.kwad.sdk.glide.request.b.b<? super Z> bVar) {
        if (bVar == null || !bVar.a(z, this)) {
            b((e<Z>) z);
        } else {
            c((e<Z>) z);
        }
    }

    @Override // com.kwad.sdk.glide.request.a.k, com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void b(@Nullable Drawable drawable) {
        super.b(drawable);
        b((e<Z>) null);
        e(drawable);
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.c.i
    public void c() {
        Animatable animatable = this.f36160b;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void c(@Nullable Drawable drawable) {
        super.c(drawable);
        b((e<Z>) null);
        e(drawable);
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.c.i
    public void d() {
        Animatable animatable = this.f36160b;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public void e(Drawable drawable) {
        ((ImageView) ((k) this).f36167a).setImageDrawable(drawable);
    }
}
