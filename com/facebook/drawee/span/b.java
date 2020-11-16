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
    private final Set<com.facebook.drawee.span.a> oSf;
    private final a oSg;
    private View oSh;
    private Drawable oSi;
    private c oSj;

    /* loaded from: classes6.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.oSf = new HashSet();
        this.oSg = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.oSg);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0977b(aVar, z, i4));
            }
            this.oSf.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.oSj = cVar;
    }

    public void eb(View view) {
        ed(view);
        onAttach();
    }

    public void ec(View view) {
        ee(view);
        onDetach();
    }

    void onAttach() {
        for (com.facebook.drawee.span.a aVar : this.oSf) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.oSf) {
            aVar.onDetach();
        }
    }

    protected void ed(View view) {
        emA();
        this.oSh = view;
    }

    protected void ee(View view) {
        if (view == this.oSh) {
            this.oSh = null;
        }
    }

    protected void A(Drawable drawable) {
        if (drawable == this.oSi) {
            this.oSi = null;
        }
    }

    protected void emA() {
        if (this.oSh != null) {
            ee(this.oSh);
        }
        if (this.oSi != null) {
            A(this.oSi);
        }
    }

    /* loaded from: classes6.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.oSh != null) {
                b.this.oSh.invalidate();
            } else if (b.this.oSi != null) {
                b.this.oSi.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.oSh != null) {
                b.this.oSh.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.oSi != null) {
                b.this.oSi.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.oSh != null) {
                b.this.oSh.removeCallbacks(runnable);
            } else if (b.this.oSi != null) {
                b.this.oSi.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0977b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a oSl;
        private final boolean oSm;
        private final int oSn;

        public C0977b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.oSl = aVar;
            this.oSm = z;
            this.oSn = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, f fVar, Animatable animatable) {
            if (this.oSm && fVar != null && this.oSl.emz().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.oSl.emz().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.oSn != -1) {
                    int height = (int) ((this.oSn / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.oSn) {
                        topLevelDrawable.setBounds(0, 0, height, this.oSn);
                        if (b.this.oSj != null) {
                            b.this.oSj.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.oSj != null) {
                        b.this.oSj.d(b.this);
                    }
                }
            }
        }
    }
}
