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
    private final Set<com.facebook.drawee.span.a> oQC;
    private final a oQD;
    private View oQE;
    private Drawable oQF;
    private c oQG;

    /* loaded from: classes6.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.oQC = new HashSet();
        this.oQD = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.oQD);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0974b(aVar, z, i4));
            }
            this.oQC.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.oQG = cVar;
    }

    public void dU(View view) {
        dW(view);
        onAttach();
    }

    public void dV(View view) {
        dX(view);
        onDetach();
    }

    void onAttach() {
        for (com.facebook.drawee.span.a aVar : this.oQC) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.oQC) {
            aVar.onDetach();
        }
    }

    protected void dW(View view) {
        emC();
        this.oQE = view;
    }

    protected void dX(View view) {
        if (view == this.oQE) {
            this.oQE = null;
        }
    }

    protected void z(Drawable drawable) {
        if (drawable == this.oQF) {
            this.oQF = null;
        }
    }

    protected void emC() {
        if (this.oQE != null) {
            dX(this.oQE);
        }
        if (this.oQF != null) {
            z(this.oQF);
        }
    }

    /* loaded from: classes6.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.oQE != null) {
                b.this.oQE.invalidate();
            } else if (b.this.oQF != null) {
                b.this.oQF.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.oQE != null) {
                b.this.oQE.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.oQF != null) {
                b.this.oQF.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.oQE != null) {
                b.this.oQE.removeCallbacks(runnable);
            } else if (b.this.oQF != null) {
                b.this.oQF.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0974b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a oQI;
        private final boolean oQJ;
        private final int oQK;

        public C0974b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.oQI = aVar;
            this.oQJ = z;
            this.oQK = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, f fVar, Animatable animatable) {
            if (this.oQJ && fVar != null && this.oQI.emB().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.oQI.emB().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.oQK != -1) {
                    int height = (int) ((this.oQK / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.oQK) {
                        topLevelDrawable.setBounds(0, 0, height, this.oQK);
                        if (b.this.oQG != null) {
                            b.this.oQG.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.oQG != null) {
                        b.this.oQG.d(b.this);
                    }
                }
            }
        }
    }
}
