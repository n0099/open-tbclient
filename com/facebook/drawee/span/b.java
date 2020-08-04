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
    private final Set<com.facebook.drawee.span.a> mWr;
    private final a mWs;
    private View mWt;
    private Drawable mWu;
    private c mWv;

    /* loaded from: classes6.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.mWr = new HashSet();
        this.mWs = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.mWs);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0810b(aVar, z, i4));
            }
            this.mWr.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.mWv = cVar;
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
        for (com.facebook.drawee.span.a aVar : this.mWr) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.mWr) {
            aVar.onDetach();
        }
    }

    protected void dp(View view) {
        dEY();
        this.mWt = view;
    }

    protected void dq(View view) {
        if (view == this.mWt) {
            this.mWt = null;
        }
    }

    protected void u(Drawable drawable) {
        if (drawable == this.mWu) {
            this.mWu = null;
        }
    }

    protected void dEY() {
        if (this.mWt != null) {
            dq(this.mWt);
        }
        if (this.mWu != null) {
            u(this.mWu);
        }
    }

    /* loaded from: classes6.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.mWt != null) {
                b.this.mWt.invalidate();
            } else if (b.this.mWu != null) {
                b.this.mWu.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.mWt != null) {
                b.this.mWt.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.mWu != null) {
                b.this.mWu.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.mWt != null) {
                b.this.mWt.removeCallbacks(runnable);
            } else if (b.this.mWu != null) {
                b.this.mWu.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0810b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a mWx;
        private final boolean mWy;
        private final int mWz;

        public C0810b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.mWx = aVar;
            this.mWy = z;
            this.mWz = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, f fVar, Animatable animatable) {
            if (this.mWy && fVar != null && this.mWx.dEX().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.mWx.dEX().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.mWz != -1) {
                    int height = (int) ((this.mWz / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.mWz) {
                        topLevelDrawable.setBounds(0, 0, height, this.mWz);
                        if (b.this.mWv != null) {
                            b.this.mWv.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.mWv != null) {
                        b.this.mWv.d(b.this);
                    }
                }
            }
        }
    }
}
