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
    private final Set<com.facebook.drawee.span.a> mOg;
    private final a mOh;
    private View mOi;
    private Drawable mOj;
    private c mOk;

    /* loaded from: classes5.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.mOg = new HashSet();
        this.mOh = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.mOh);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0801b(aVar, z, i4));
            }
            this.mOg.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.mOk = cVar;
    }

    public void dh(View view) {
        dj(view);
        onAttach();
    }

    public void di(View view) {
        dk(view);
        onDetach();
    }

    void onAttach() {
        for (com.facebook.drawee.span.a aVar : this.mOg) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.mOg) {
            aVar.onDetach();
        }
    }

    protected void dj(View view) {
        dBL();
        this.mOi = view;
    }

    protected void dk(View view) {
        if (view == this.mOi) {
            this.mOi = null;
        }
    }

    protected void u(Drawable drawable) {
        if (drawable == this.mOj) {
            this.mOj = null;
        }
    }

    protected void dBL() {
        if (this.mOi != null) {
            dk(this.mOi);
        }
        if (this.mOj != null) {
            u(this.mOj);
        }
    }

    /* loaded from: classes5.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.mOi != null) {
                b.this.mOi.invalidate();
            } else if (b.this.mOj != null) {
                b.this.mOj.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.mOi != null) {
                b.this.mOi.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.mOj != null) {
                b.this.mOj.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.mOi != null) {
                b.this.mOi.removeCallbacks(runnable);
            } else if (b.this.mOj != null) {
                b.this.mOj.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0801b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a mOm;
        private final boolean mOn;
        private final int mOo;

        public C0801b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.mOm = aVar;
            this.mOn = z;
            this.mOo = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, f fVar, Animatable animatable) {
            if (this.mOn && fVar != null && this.mOm.dBK().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.mOm.dBK().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.mOo != -1) {
                    int height = (int) ((this.mOo / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.mOo) {
                        topLevelDrawable.setBounds(0, 0, height, this.mOo);
                        if (b.this.mOk != null) {
                            b.this.mOk.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.mOk != null) {
                        b.this.mOk.d(b.this);
                    }
                }
            }
        }
    }
}
