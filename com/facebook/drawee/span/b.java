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
/* loaded from: classes6.dex */
public class b extends SpannableStringBuilder {
    private final Set<com.facebook.drawee.span.a> nPQ;
    private final a nPR;
    private View nPS;
    private Drawable nPT;
    private c nPU;

    /* loaded from: classes6.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.nPQ = new HashSet();
        this.nPR = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.nPR);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0883b(aVar, z, i4));
            }
            this.nPQ.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.nPU = cVar;
    }

    public void dE(View view) {
        dG(view);
        onAttach();
    }

    public void dF(View view) {
        dH(view);
        onDetach();
    }

    void onAttach() {
        for (com.facebook.drawee.span.a aVar : this.nPQ) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.nPQ) {
            aVar.onDetach();
        }
    }

    protected void dG(View view) {
        dYP();
        this.nPS = view;
    }

    protected void dH(View view) {
        if (view == this.nPS) {
            this.nPS = null;
        }
    }

    protected void u(Drawable drawable) {
        if (drawable == this.nPT) {
            this.nPT = null;
        }
    }

    protected void dYP() {
        if (this.nPS != null) {
            dH(this.nPS);
        }
        if (this.nPT != null) {
            u(this.nPT);
        }
    }

    /* loaded from: classes6.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.nPS != null) {
                b.this.nPS.invalidate();
            } else if (b.this.nPT != null) {
                b.this.nPT.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.nPS != null) {
                b.this.nPS.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.nPT != null) {
                b.this.nPT.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.nPS != null) {
                b.this.nPS.removeCallbacks(runnable);
            } else if (b.this.nPT != null) {
                b.this.nPT.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0883b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a nPW;
        private final boolean nPX;
        private final int nPY;

        public C0883b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.nPW = aVar;
            this.nPX = z;
            this.nPY = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, f fVar, Animatable animatable) {
            if (this.nPX && fVar != null && this.nPW.dYO().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.nPW.dYO().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.nPY != -1) {
                    int height = (int) ((this.nPY / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.nPY) {
                        topLevelDrawable.setBounds(0, 0, height, this.nPY);
                        if (b.this.nPU != null) {
                            b.this.nPU.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.nPU != null) {
                        b.this.nPU.d(b.this);
                    }
                }
            }
        }
    }
}
