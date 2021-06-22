package com.kwad.sdk.glide.load.resource.b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.engine.o;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes7.dex */
public abstract class b<T extends Drawable> implements o, s<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f36425a;

    public b(T t) {
        this.f36425a = (T) j.a(t);
    }

    @Override // com.kwad.sdk.glide.load.engine.o
    public void b() {
        Bitmap b2;
        T t = this.f36425a;
        if (t instanceof BitmapDrawable) {
            b2 = ((BitmapDrawable) t).getBitmap();
        } else if (!(t instanceof com.kwad.sdk.glide.load.resource.d.c)) {
            return;
        } else {
            b2 = ((com.kwad.sdk.glide.load.resource.d.c) t).b();
        }
        b2.prepareToDraw();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    /* renamed from: f */
    public final T e() {
        Drawable.ConstantState constantState = this.f36425a.getConstantState();
        return constantState == null ? this.f36425a : (T) constantState.newDrawable();
    }
}
