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
    private final Set<com.facebook.drawee.span.a> lNU;
    private final a lNV;
    private View lNW;
    private Drawable lNX;
    private c lNY;

    /* loaded from: classes5.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.lNU = new HashSet();
        this.lNV = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.lNV);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0660b(aVar, z, i4));
            }
            this.lNU.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.lNY = cVar;
    }

    /* renamed from: do  reason: not valid java name */
    public void m38do(View view) {
        dq(view);
        onAttach();
    }

    public void dp(View view) {
        dr(view);
        onDetach();
    }

    void onAttach() {
        for (com.facebook.drawee.span.a aVar : this.lNU) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.lNU) {
            aVar.onDetach();
        }
    }

    protected void dq(View view) {
        dnj();
        this.lNW = view;
    }

    protected void dr(View view) {
        if (view == this.lNW) {
            this.lNW = null;
        }
    }

    protected void y(Drawable drawable) {
        if (drawable == this.lNX) {
            this.lNX = null;
        }
    }

    protected void dnj() {
        if (this.lNW != null) {
            dr(this.lNW);
        }
        if (this.lNX != null) {
            y(this.lNX);
        }
    }

    /* loaded from: classes5.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.lNW != null) {
                b.this.lNW.invalidate();
            } else if (b.this.lNX != null) {
                b.this.lNX.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.lNW != null) {
                b.this.lNW.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.lNX != null) {
                b.this.lNX.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.lNW != null) {
                b.this.lNW.removeCallbacks(runnable);
            } else if (b.this.lNX != null) {
                b.this.lNX.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0660b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a lOa;
        private final boolean lOb;
        private final int lOc;

        public C0660b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.lOa = aVar;
            this.lOb = z;
            this.lOc = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, f fVar, Animatable animatable) {
            if (this.lOb && fVar != null && this.lOa.dni().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.lOa.dni().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.lOc != -1) {
                    int height = (int) ((this.lOc / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.lOc) {
                        topLevelDrawable.setBounds(0, 0, height, this.lOc);
                        if (b.this.lNY != null) {
                            b.this.lNY.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.lNY != null) {
                        b.this.lNY.d(b.this);
                    }
                }
            }
        }
    }
}
