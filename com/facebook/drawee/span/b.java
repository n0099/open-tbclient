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
    private final Set<com.facebook.drawee.span.a> mOd;
    private final a mOe;
    private View mOf;
    private Drawable mOg;
    private c mOh;

    /* loaded from: classes5.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.mOd = new HashSet();
        this.mOe = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.mOe);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0800b(aVar, z, i4));
            }
            this.mOd.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.mOh = cVar;
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
        for (com.facebook.drawee.span.a aVar : this.mOd) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.mOd) {
            aVar.onDetach();
        }
    }

    protected void dj(View view) {
        dBH();
        this.mOf = view;
    }

    protected void dk(View view) {
        if (view == this.mOf) {
            this.mOf = null;
        }
    }

    protected void u(Drawable drawable) {
        if (drawable == this.mOg) {
            this.mOg = null;
        }
    }

    protected void dBH() {
        if (this.mOf != null) {
            dk(this.mOf);
        }
        if (this.mOg != null) {
            u(this.mOg);
        }
    }

    /* loaded from: classes5.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.mOf != null) {
                b.this.mOf.invalidate();
            } else if (b.this.mOg != null) {
                b.this.mOg.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.mOf != null) {
                b.this.mOf.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.mOg != null) {
                b.this.mOg.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.mOf != null) {
                b.this.mOf.removeCallbacks(runnable);
            } else if (b.this.mOg != null) {
                b.this.mOg.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0800b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a mOj;
        private final boolean mOk;
        private final int mOl;

        public C0800b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.mOj = aVar;
            this.mOk = z;
            this.mOl = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, f fVar, Animatable animatable) {
            if (this.mOk && fVar != null && this.mOj.dBG().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.mOj.dBG().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.mOl != -1) {
                    int height = (int) ((this.mOl / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.mOl) {
                        topLevelDrawable.setBounds(0, 0, height, this.mOl);
                        if (b.this.mOh != null) {
                            b.this.mOh.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.mOh != null) {
                        b.this.mOh.d(b.this);
                    }
                }
            }
        }
    }
}
