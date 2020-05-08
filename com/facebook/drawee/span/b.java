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
    private final Set<com.facebook.drawee.span.a> lXb;
    private final a lXc;
    private View lXd;
    private Drawable lXe;
    private c lXf;

    /* loaded from: classes5.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.lXb = new HashSet();
        this.lXc = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.lXc);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0725b(aVar, z, i4));
            }
            this.lXb.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.lXf = cVar;
    }

    public void df(View view) {
        dh(view);
        onAttach();
    }

    public void dg(View view) {
        di(view);
        onDetach();
    }

    void onAttach() {
        for (com.facebook.drawee.span.a aVar : this.lXb) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.lXb) {
            aVar.onDetach();
        }
    }

    protected void dh(View view) {
        dpy();
        this.lXd = view;
    }

    protected void di(View view) {
        if (view == this.lXd) {
            this.lXd = null;
        }
    }

    protected void u(Drawable drawable) {
        if (drawable == this.lXe) {
            this.lXe = null;
        }
    }

    protected void dpy() {
        if (this.lXd != null) {
            di(this.lXd);
        }
        if (this.lXe != null) {
            u(this.lXe);
        }
    }

    /* loaded from: classes5.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.lXd != null) {
                b.this.lXd.invalidate();
            } else if (b.this.lXe != null) {
                b.this.lXe.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.lXd != null) {
                b.this.lXd.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.lXe != null) {
                b.this.lXe.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.lXd != null) {
                b.this.lXd.removeCallbacks(runnable);
            } else if (b.this.lXe != null) {
                b.this.lXe.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0725b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a lXh;
        private final boolean lXi;
        private final int lXj;

        public C0725b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.lXh = aVar;
            this.lXi = z;
            this.lXj = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, f fVar, Animatable animatable) {
            if (this.lXi && fVar != null && this.lXh.dpx().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.lXh.dpx().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.lXj != -1) {
                    int height = (int) ((this.lXj / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.lXj) {
                        topLevelDrawable.setBounds(0, 0, height, this.lXj);
                        if (b.this.lXf != null) {
                            b.this.lXf.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.lXf != null) {
                        b.this.lXf.d(b.this);
                    }
                }
            }
        }
    }
}
