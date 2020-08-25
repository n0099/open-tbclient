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
    private final Set<com.facebook.drawee.span.a> nqh;
    private final a nqi;
    private View nqj;
    private Drawable nqk;
    private c nql;

    /* loaded from: classes6.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.nqh = new HashSet();
        this.nqi = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.nqi);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0868b(aVar, z, i4));
            }
            this.nqh.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.nql = cVar;
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
        for (com.facebook.drawee.span.a aVar : this.nqh) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.nqh) {
            aVar.onDetach();
        }
    }

    protected void dt(View view) {
        dQX();
        this.nqj = view;
    }

    protected void du(View view) {
        if (view == this.nqj) {
            this.nqj = null;
        }
    }

    protected void u(Drawable drawable) {
        if (drawable == this.nqk) {
            this.nqk = null;
        }
    }

    protected void dQX() {
        if (this.nqj != null) {
            du(this.nqj);
        }
        if (this.nqk != null) {
            u(this.nqk);
        }
    }

    /* loaded from: classes6.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.nqj != null) {
                b.this.nqj.invalidate();
            } else if (b.this.nqk != null) {
                b.this.nqk.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.nqj != null) {
                b.this.nqj.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.nqk != null) {
                b.this.nqk.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.nqj != null) {
                b.this.nqj.removeCallbacks(runnable);
            } else if (b.this.nqk != null) {
                b.this.nqk.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0868b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a nqn;
        private final boolean nqo;
        private final int nqp;

        public C0868b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.nqn = aVar;
            this.nqo = z;
            this.nqp = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, f fVar, Animatable animatable) {
            if (this.nqo && fVar != null && this.nqn.dQW().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.nqn.dQW().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.nqp != -1) {
                    int height = (int) ((this.nqp / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.nqp) {
                        topLevelDrawable.setBounds(0, 0, height, this.nqp);
                        if (b.this.nql != null) {
                            b.this.nql.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.nql != null) {
                        b.this.nql.d(b.this);
                    }
                }
            }
        }
    }
}
