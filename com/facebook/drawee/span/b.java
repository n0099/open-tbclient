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
    private final Set<com.facebook.drawee.span.a> lNJ;
    private final a lNK;
    private View lNL;
    private Drawable lNM;
    private c lNN;

    /* loaded from: classes5.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.lNJ = new HashSet();
        this.lNK = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.lNK);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0660b(aVar, z, i4));
            }
            this.lNJ.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.lNN = cVar;
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
        for (com.facebook.drawee.span.a aVar : this.lNJ) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.lNJ) {
            aVar.onDetach();
        }
    }

    protected void dq(View view) {
        dni();
        this.lNL = view;
    }

    protected void dr(View view) {
        if (view == this.lNL) {
            this.lNL = null;
        }
    }

    protected void y(Drawable drawable) {
        if (drawable == this.lNM) {
            this.lNM = null;
        }
    }

    protected void dni() {
        if (this.lNL != null) {
            dr(this.lNL);
        }
        if (this.lNM != null) {
            y(this.lNM);
        }
    }

    /* loaded from: classes5.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.lNL != null) {
                b.this.lNL.invalidate();
            } else if (b.this.lNM != null) {
                b.this.lNM.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.lNL != null) {
                b.this.lNL.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.lNM != null) {
                b.this.lNM.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.lNL != null) {
                b.this.lNL.removeCallbacks(runnable);
            } else if (b.this.lNM != null) {
                b.this.lNM.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0660b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a lNP;
        private final boolean lNQ;
        private final int lNR;

        public C0660b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.lNP = aVar;
            this.lNQ = z;
            this.lNR = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void onFinalImageSet(String str, f fVar, Animatable animatable) {
            if (this.lNQ && fVar != null && this.lNP.dnh().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.lNP.dnh().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.lNR != -1) {
                    int height = (int) ((this.lNR / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.lNR) {
                        topLevelDrawable.setBounds(0, 0, height, this.lNR);
                        if (b.this.lNN != null) {
                            b.this.lNN.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.lNN != null) {
                        b.this.lNN.d(b.this);
                    }
                }
            }
        }
    }
}
