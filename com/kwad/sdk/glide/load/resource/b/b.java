package com.kwad.sdk.glide.load.resource.b;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.engine.o;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes3.dex */
public abstract class b<T extends Drawable> implements o, s<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final T f6779a;

    public b(T t) {
        this.f6779a = (T) j.a(t);
    }

    @Override // com.kwad.sdk.glide.load.engine.o
    public void b() {
        if (this.f6779a instanceof BitmapDrawable) {
            ((BitmapDrawable) this.f6779a).getBitmap().prepareToDraw();
        } else if (this.f6779a instanceof com.kwad.sdk.glide.load.resource.d.c) {
            ((com.kwad.sdk.glide.load.resource.d.c) this.f6779a).b().prepareToDraw();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    /* renamed from: f */
    public final T e() {
        Drawable.ConstantState constantState = this.f6779a.getConstantState();
        return constantState == null ? this.f6779a : (T) constantState.newDrawable();
    }
}
