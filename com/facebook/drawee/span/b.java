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
    private final a nqA;
    private View nqB;
    private Drawable nqC;
    private c nqD;
    private final Set<com.facebook.drawee.span.a> nqz;

    /* loaded from: classes6.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.nqz = new HashSet();
        this.nqA = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.nqA);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0868b(aVar, z, i4));
            }
            this.nqz.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.nqD = cVar;
    }

    public void dr(View view) {
        dt(view);
        onAttach();
    }

    public void ds(View view) {
        du(view);
        onDetach();
    }

    void onAttach() {
        for (com.facebook.drawee.span.a aVar : this.nqz) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.nqz) {
            aVar.onDetach();
        }
    }

    protected void dt(View view) {
        dRg();
        this.nqB = view;
    }

    protected void du(View view) {
        if (view == this.nqB) {
            this.nqB = null;
        }
    }

    protected void u(Drawable drawable) {
        if (drawable == this.nqC) {
            this.nqC = null;
        }
    }

    protected void dRg() {
        if (this.nqB != null) {
            du(this.nqB);
        }
        if (this.nqC != null) {
            u(this.nqC);
        }
    }

    /* loaded from: classes6.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.nqB != null) {
                b.this.nqB.invalidate();
            } else if (b.this.nqC != null) {
                b.this.nqC.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.nqB != null) {
                b.this.nqB.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.nqC != null) {
                b.this.nqC.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.nqB != null) {
                b.this.nqB.removeCallbacks(runnable);
            } else if (b.this.nqC != null) {
                b.this.nqC.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0868b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a nqF;
        private final boolean nqG;
        private final int nqH;

        public C0868b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.nqF = aVar;
            this.nqG = z;
            this.nqH = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, f fVar, Animatable animatable) {
            if (this.nqG && fVar != null && this.nqF.dRf().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.nqF.dRf().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.nqH != -1) {
                    int height = (int) ((this.nqH / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.nqH) {
                        topLevelDrawable.setBounds(0, 0, height, this.nqH);
                        if (b.this.nqD != null) {
                            b.this.nqD.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.nqD != null) {
                        b.this.nqD.d(b.this);
                    }
                }
            }
        }
    }
}
