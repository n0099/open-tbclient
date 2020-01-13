package com.facebook.drawee.span;

import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.f;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class b extends SpannableStringBuilder {
    private final Set<com.facebook.drawee.span.a> lMV;
    private final a lMW;
    private View lMX;
    private Drawable lMY;
    private c lMZ;

    /* loaded from: classes4.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.lMV = new HashSet();
        this.lMW = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.lMW);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0652b(aVar, z, i4));
            }
            this.lMV.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.lMZ = cVar;
    }

    public void dm(View view) {
        m32do(view);
        onAttach();
    }

    public void dn(View view) {
        dp(view);
        onDetach();
    }

    void onAttach() {
        for (com.facebook.drawee.span.a aVar : this.lMV) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.lMV) {
            aVar.onDetach();
        }
    }

    /* renamed from: do  reason: not valid java name */
    protected void m32do(View view) {
        dlS();
        this.lMX = view;
    }

    protected void dp(View view) {
        if (view == this.lMX) {
            this.lMX = null;
        }
    }

    protected void y(Drawable drawable) {
        if (drawable == this.lMY) {
            this.lMY = null;
        }
    }

    protected void dlS() {
        if (this.lMX != null) {
            dp(this.lMX);
        }
        if (this.lMY != null) {
            y(this.lMY);
        }
    }

    /* loaded from: classes4.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.lMX != null) {
                b.this.lMX.invalidate();
            } else if (b.this.lMY != null) {
                b.this.lMY.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.lMX != null) {
                b.this.lMX.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.lMY != null) {
                b.this.lMY.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.lMX != null) {
                b.this.lMX.removeCallbacks(runnable);
            } else if (b.this.lMY != null) {
                b.this.lMY.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0652b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a lNb;
        private final boolean lNc;
        private final int lNd;

        public C0652b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.lNb = aVar;
            this.lNc = z;
            this.lNd = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, f fVar, Animatable animatable) {
            if (this.lNc && fVar != null && this.lNb.dlR().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.lNb.dlR().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.lNd != -1) {
                    int height = (int) ((this.lNd / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.lNd) {
                        topLevelDrawable.setBounds(0, 0, height, this.lNd);
                        if (b.this.lMZ != null) {
                            b.this.lMZ.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.lMZ != null) {
                        b.this.lMZ.d(b.this);
                    }
                }
            }
        }
    }
}
