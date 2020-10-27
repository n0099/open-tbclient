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
    private final Set<com.facebook.drawee.span.a> oHj;
    private final a oHk;
    private View oHl;
    private Drawable oHm;
    private c oHn;

    /* loaded from: classes6.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.oHj = new HashSet();
        this.oHk = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.oHk);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0955b(aVar, z, i4));
            }
            this.oHj.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.oHn = cVar;
    }

    public void dM(View view) {
        dO(view);
        onAttach();
    }

    public void dN(View view) {
        dP(view);
        onDetach();
    }

    void onAttach() {
        for (com.facebook.drawee.span.a aVar : this.oHj) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.oHj) {
            aVar.onDetach();
        }
    }

    protected void dO(View view) {
        eiN();
        this.oHl = view;
    }

    protected void dP(View view) {
        if (view == this.oHl) {
            this.oHl = null;
        }
    }

    protected void z(Drawable drawable) {
        if (drawable == this.oHm) {
            this.oHm = null;
        }
    }

    protected void eiN() {
        if (this.oHl != null) {
            dP(this.oHl);
        }
        if (this.oHm != null) {
            z(this.oHm);
        }
    }

    /* loaded from: classes6.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.oHl != null) {
                b.this.oHl.invalidate();
            } else if (b.this.oHm != null) {
                b.this.oHm.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.oHl != null) {
                b.this.oHl.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.oHm != null) {
                b.this.oHm.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.oHl != null) {
                b.this.oHl.removeCallbacks(runnable);
            } else if (b.this.oHm != null) {
                b.this.oHm.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0955b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a oHp;
        private final boolean oHq;
        private final int oHr;

        public C0955b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.oHp = aVar;
            this.oHq = z;
            this.oHr = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, f fVar, Animatable animatable) {
            if (this.oHq && fVar != null && this.oHp.eiM().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.oHp.eiM().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.oHr != -1) {
                    int height = (int) ((this.oHr / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.oHr) {
                        topLevelDrawable.setBounds(0, 0, height, this.oHr);
                        if (b.this.oHn != null) {
                            b.this.oHn.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.oHn != null) {
                        b.this.oHn.d(b.this);
                    }
                }
            }
        }
    }
}
