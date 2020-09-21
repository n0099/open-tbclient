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
    private Drawable nAA;
    private c nAB;
    private final Set<com.facebook.drawee.span.a> nAx;
    private final a nAy;
    private View nAz;

    /* loaded from: classes6.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.nAx = new HashSet();
        this.nAy = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.nAy);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0865b(aVar, z, i4));
            }
            this.nAx.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.nAB = cVar;
    }

    public void dA(View view) {
        dC(view);
        onAttach();
    }

    public void dB(View view) {
        dD(view);
        onDetach();
    }

    void onAttach() {
        for (com.facebook.drawee.span.a aVar : this.nAx) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.nAx) {
            aVar.onDetach();
        }
    }

    protected void dC(View view) {
        dVe();
        this.nAz = view;
    }

    protected void dD(View view) {
        if (view == this.nAz) {
            this.nAz = null;
        }
    }

    protected void u(Drawable drawable) {
        if (drawable == this.nAA) {
            this.nAA = null;
        }
    }

    protected void dVe() {
        if (this.nAz != null) {
            dD(this.nAz);
        }
        if (this.nAA != null) {
            u(this.nAA);
        }
    }

    /* loaded from: classes6.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.nAz != null) {
                b.this.nAz.invalidate();
            } else if (b.this.nAA != null) {
                b.this.nAA.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.nAz != null) {
                b.this.nAz.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.nAA != null) {
                b.this.nAA.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.nAz != null) {
                b.this.nAz.removeCallbacks(runnable);
            } else if (b.this.nAA != null) {
                b.this.nAA.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0865b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a nAD;
        private final boolean nAE;
        private final int nAF;

        public C0865b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.nAD = aVar;
            this.nAE = z;
            this.nAF = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, f fVar, Animatable animatable) {
            if (this.nAE && fVar != null && this.nAD.dVd().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.nAD.dVd().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.nAF != -1) {
                    int height = (int) ((this.nAF / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.nAF) {
                        topLevelDrawable.setBounds(0, 0, height, this.nAF);
                        if (b.this.nAB != null) {
                            b.this.nAB.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.nAB != null) {
                        b.this.nAB.d(b.this);
                    }
                }
            }
        }
    }
}
