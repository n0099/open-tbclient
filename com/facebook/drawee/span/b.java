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
    private final Set<com.facebook.drawee.span.a> mWp;
    private final a mWq;
    private View mWr;
    private Drawable mWs;
    private c mWt;

    /* loaded from: classes6.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.mWp = new HashSet();
        this.mWq = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.mWq);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0810b(aVar, z, i4));
            }
            this.mWp.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.mWt = cVar;
    }

    public void dn(View view) {
        dp(view);
        onAttach();
    }

    /* renamed from: do  reason: not valid java name */
    public void m40do(View view) {
        dq(view);
        onDetach();
    }

    void onAttach() {
        for (com.facebook.drawee.span.a aVar : this.mWp) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.mWp) {
            aVar.onDetach();
        }
    }

    protected void dp(View view) {
        dEX();
        this.mWr = view;
    }

    protected void dq(View view) {
        if (view == this.mWr) {
            this.mWr = null;
        }
    }

    protected void u(Drawable drawable) {
        if (drawable == this.mWs) {
            this.mWs = null;
        }
    }

    protected void dEX() {
        if (this.mWr != null) {
            dq(this.mWr);
        }
        if (this.mWs != null) {
            u(this.mWs);
        }
    }

    /* loaded from: classes6.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.mWr != null) {
                b.this.mWr.invalidate();
            } else if (b.this.mWs != null) {
                b.this.mWs.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.mWr != null) {
                b.this.mWr.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.mWs != null) {
                b.this.mWs.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.mWr != null) {
                b.this.mWr.removeCallbacks(runnable);
            } else if (b.this.mWs != null) {
                b.this.mWs.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0810b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a mWv;
        private final boolean mWw;
        private final int mWx;

        public C0810b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.mWv = aVar;
            this.mWw = z;
            this.mWx = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, f fVar, Animatable animatable) {
            if (this.mWw && fVar != null && this.mWv.dEW().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.mWv.dEW().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.mWx != -1) {
                    int height = (int) ((this.mWx / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.mWx) {
                        topLevelDrawable.setBounds(0, 0, height, this.mWx);
                        if (b.this.mWt != null) {
                            b.this.mWt.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.mWt != null) {
                        b.this.mWt.d(b.this);
                    }
                }
            }
        }
    }
}
