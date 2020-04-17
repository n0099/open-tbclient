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
    private final Set<com.facebook.drawee.span.a> lWX;
    private final a lWY;
    private View lWZ;
    private Drawable lXa;
    private c lXb;

    /* loaded from: classes5.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.lWX = new HashSet();
        this.lWY = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.lWY);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0704b(aVar, z, i4));
            }
            this.lWX.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.lXb = cVar;
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
        for (com.facebook.drawee.span.a aVar : this.lWX) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.lWX) {
            aVar.onDetach();
        }
    }

    protected void dh(View view) {
        dpB();
        this.lWZ = view;
    }

    protected void di(View view) {
        if (view == this.lWZ) {
            this.lWZ = null;
        }
    }

    protected void u(Drawable drawable) {
        if (drawable == this.lXa) {
            this.lXa = null;
        }
    }

    protected void dpB() {
        if (this.lWZ != null) {
            di(this.lWZ);
        }
        if (this.lXa != null) {
            u(this.lXa);
        }
    }

    /* loaded from: classes5.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.lWZ != null) {
                b.this.lWZ.invalidate();
            } else if (b.this.lXa != null) {
                b.this.lXa.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.lWZ != null) {
                b.this.lWZ.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.lXa != null) {
                b.this.lXa.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.lWZ != null) {
                b.this.lWZ.removeCallbacks(runnable);
            } else if (b.this.lXa != null) {
                b.this.lXa.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0704b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a lXd;
        private final boolean lXe;
        private final int lXf;

        public C0704b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.lXd = aVar;
            this.lXe = z;
            this.lXf = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, f fVar, Animatable animatable) {
            if (this.lXe && fVar != null && this.lXd.dpA().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.lXd.dpA().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.lXf != -1) {
                    int height = (int) ((this.lXf / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.lXf) {
                        topLevelDrawable.setBounds(0, 0, height, this.lXf);
                        if (b.this.lXb != null) {
                            b.this.lXb.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.lXb != null) {
                        b.this.lXb.d(b.this);
                    }
                }
            }
        }
    }
}
