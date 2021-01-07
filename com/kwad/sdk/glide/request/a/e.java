package com.kwad.sdk.glide.request.a;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.request.b.b;
/* loaded from: classes5.dex */
public abstract class e<Z> extends k<ImageView, Z> implements b.a {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Animatable f10640b;

    public e(ImageView imageView) {
        super(imageView);
    }

    private void b(@Nullable Z z) {
        a((e<Z>) z);
        c((e<Z>) z);
    }

    private void c(@Nullable Z z) {
        if (!(z instanceof Animatable)) {
            this.f10640b = null;
            return;
        }
        this.f10640b = (Animatable) z;
        this.f10640b.start();
    }

    @Override // com.kwad.sdk.glide.request.a.k, com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void a(@Nullable Drawable drawable) {
        super.a(drawable);
        if (this.f10640b != null) {
            this.f10640b.stop();
        }
        b((e<Z>) null);
        e(drawable);
    }

    protected abstract void a(@Nullable Z z);

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
        if (this.f10640b != null) {
            this.f10640b.start();
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
        if (this.f10640b != null) {
            this.f10640b.stop();
        }
    }

    public void e(Drawable drawable) {
        ((ImageView) this.f10646a).setImageDrawable(drawable);
    }
}
