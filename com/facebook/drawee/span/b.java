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
/* loaded from: classes5.dex */
public class b extends SpannableStringBuilder {
    private final Set<com.facebook.drawee.span.a> mqV;
    private final a mqW;
    private View mqX;
    private Drawable mqY;
    private c mqZ;

    /* loaded from: classes5.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.mqV = new HashSet();
        this.mqW = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.mqW);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0780b(aVar, z, i4));
            }
            this.mqV.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.mqZ = cVar;
    }

    public void dg(View view) {
        di(view);
        onAttach();
    }

    public void dh(View view) {
        dj(view);
        onDetach();
    }

    void onAttach() {
        for (com.facebook.drawee.span.a aVar : this.mqV) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.mqV) {
            aVar.onDetach();
        }
    }

    protected void di(View view) {
        dwR();
        this.mqX = view;
    }

    protected void dj(View view) {
        if (view == this.mqX) {
            this.mqX = null;
        }
    }

    protected void u(Drawable drawable) {
        if (drawable == this.mqY) {
            this.mqY = null;
        }
    }

    protected void dwR() {
        if (this.mqX != null) {
            dj(this.mqX);
        }
        if (this.mqY != null) {
            u(this.mqY);
        }
    }

    /* loaded from: classes5.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.mqX != null) {
                b.this.mqX.invalidate();
            } else if (b.this.mqY != null) {
                b.this.mqY.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.mqX != null) {
                b.this.mqX.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.mqY != null) {
                b.this.mqY.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.mqX != null) {
                b.this.mqX.removeCallbacks(runnable);
            } else if (b.this.mqY != null) {
                b.this.mqY.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0780b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a mrb;
        private final boolean mrc;
        private final int mrd;

        public C0780b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.mrb = aVar;
            this.mrc = z;
            this.mrd = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, f fVar, Animatable animatable) {
            if (this.mrc && fVar != null && this.mrb.dwQ().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.mrb.dwQ().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.mrd != -1) {
                    int height = (int) ((this.mrd / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.mrd) {
                        topLevelDrawable.setBounds(0, 0, height, this.mrd);
                        if (b.this.mqZ != null) {
                            b.this.mqZ.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.mqZ != null) {
                        b.this.mqZ.d(b.this);
                    }
                }
            }
        }
    }
}
