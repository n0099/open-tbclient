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
    private final Set<com.facebook.drawee.span.a> msf;
    private final a msh;
    private View msi;
    private Drawable msj;
    private c msk;

    /* loaded from: classes5.dex */
    public interface c {
        void d(b bVar);
    }

    public b(CharSequence charSequence) {
        super(charSequence);
        this.msf = new HashSet();
        this.msh = new a();
    }

    public void a(com.facebook.drawee.view.b bVar, int i, int i2, int i3, int i4, boolean z, int i5) {
        if (i2 < length()) {
            Drawable topLevelDrawable = bVar.getTopLevelDrawable();
            if (topLevelDrawable != null) {
                if (topLevelDrawable.getBounds().isEmpty()) {
                    topLevelDrawable.setBounds(0, 0, i3, i4);
                }
                topLevelDrawable.setCallback(this.msh);
            }
            com.facebook.drawee.span.a aVar = new com.facebook.drawee.span.a(bVar, i5);
            com.facebook.drawee.d.a controller = bVar.getController();
            if (controller instanceof com.facebook.drawee.controller.a) {
                ((com.facebook.drawee.controller.a) controller).a(new C0781b(aVar, z, i4));
            }
            this.msf.add(aVar);
            setSpan(aVar, i, i2 + 1, 33);
        }
    }

    public void a(c cVar) {
        this.msk = cVar;
    }

    public void dg(View view) {
        di(view);
        onAttach();
    }

    public void dh(View view) {
        dj(view);
        onDetach();
    }

    void onAttach() {
        for (com.facebook.drawee.span.a aVar : this.msf) {
            aVar.onAttach();
        }
    }

    void onDetach() {
        for (com.facebook.drawee.span.a aVar : this.msf) {
            aVar.onDetach();
        }
    }

    protected void di(View view) {
        dxf();
        this.msi = view;
    }

    protected void dj(View view) {
        if (view == this.msi) {
            this.msi = null;
        }
    }

    protected void u(Drawable drawable) {
        if (drawable == this.msj) {
            this.msj = null;
        }
    }

    protected void dxf() {
        if (this.msi != null) {
            dj(this.msi);
        }
        if (this.msj != null) {
            u(this.msj);
        }
    }

    /* loaded from: classes5.dex */
    private class a implements Drawable.Callback {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (b.this.msi != null) {
                b.this.msi.invalidate();
            } else if (b.this.msj != null) {
                b.this.msj.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (b.this.msi != null) {
                b.this.msi.postDelayed(runnable, j - SystemClock.uptimeMillis());
            } else if (b.this.msj != null) {
                b.this.msj.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (b.this.msi != null) {
                b.this.msi.removeCallbacks(runnable);
            } else if (b.this.msj != null) {
                b.this.msj.unscheduleSelf(runnable);
            }
        }
    }

    /* renamed from: com.facebook.drawee.span.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private class C0781b extends com.facebook.drawee.controller.b<f> {
        private final com.facebook.drawee.span.a msm;
        private final boolean msn;
        private final int mso;

        public C0781b(com.facebook.drawee.span.a aVar, boolean z, int i) {
            g.checkNotNull(aVar);
            this.msm = aVar;
            this.msn = z;
            this.mso = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
        public void a(String str, f fVar, Animatable animatable) {
            if (this.msn && fVar != null && this.msm.dxe().getTopLevelDrawable() != null) {
                Drawable topLevelDrawable = this.msm.dxe().getTopLevelDrawable();
                Rect bounds = topLevelDrawable.getBounds();
                if (this.mso != -1) {
                    int height = (int) ((this.mso / fVar.getHeight()) * fVar.getWidth());
                    if (bounds.width() != height || bounds.height() != this.mso) {
                        topLevelDrawable.setBounds(0, 0, height, this.mso);
                        if (b.this.msk != null) {
                            b.this.msk.d(b.this);
                        }
                    }
                } else if (bounds.width() != fVar.getWidth() || bounds.height() != fVar.getHeight()) {
                    topLevelDrawable.setBounds(0, 0, fVar.getWidth(), fVar.getHeight());
                    if (b.this.msk != null) {
                        b.this.msk.d(b.this);
                    }
                }
            }
        }
    }
}
