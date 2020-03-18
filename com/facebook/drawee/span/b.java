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
    private final Set<com.facebook.drawee.span.a> lPA;
    private final a lPB;
    private View lPC;
    private Drawable lPD;
    private c lPE;

    /* loaded from: classes5.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.lPA = new HashSet();
        this.lPB = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.lPB);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0661b(aVar, z, i4));
            }
            this.lPA.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.lPE = cVar;
    }

    /* renamed from: do  reason: not valid java name */
    public void m36do(View view) {
        dq(view);
        onAttach();
    }

    public void dp(View view) {
        dr(view);
        onDetach();
    }

    void onAttach() {
        for (com.facebook.drawee.span.a aVar : this.lPA) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.lPA) {
            aVar.onDetach();
        }
    }

    protected void dq(View view) {
        dnH();
        this.lPC = view;
    }

    protected void dr(View view) {
        if (view == this.lPC) {
            this.lPC = null;
        }
    }

    protected void y(Drawable drawable) {
        if (drawable == this.lPD) {
            this.lPD = null;
        }
    }

    protected void dnH() {
        if (this.lPC != null) {
            dr(this.lPC);
        }
        if (this.lPD != null) {
            y(this.lPD);
        }
    }

    /* loaded from: classes5.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.lPC != null) {
                b.this.lPC.invalidate();
            } else if (b.this.lPD != null) {
                b.this.lPD.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.lPC != null) {
                b.this.lPC.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.lPD != null) {
                b.this.lPD.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.lPC != null) {
                b.this.lPC.removeCallbacks(runnable);
            } else if (b.this.lPD != null) {
                b.this.lPD.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0661b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a lPG;
        private final boolean lPH;
        private final int lPI;

        public C0661b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.lPG = aVar;
            this.lPH = z;
            this.lPI = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, f fVar, Animatable animatable) {
            if (this.lPH && fVar != null && this.lPG.dnG().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.lPG.dnG().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.lPI != -1) {
                    int height = (int) ((this.lPI / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.lPI) {
                        topLevelDrawable.setBounds(0, 0, height, this.lPI);
                        if (b.this.lPE != null) {
                            b.this.lPE.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.lPE != null) {
                        b.this.lPE.d(b.this);
                    }
                }
            }
        }
    }
}
