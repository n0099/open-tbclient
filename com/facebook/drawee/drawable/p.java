package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class p {

    /* loaded from: classes15.dex */
    public interface b {
        public static final b pxB = j.pxK;
        public static final b pxC = i.pxK;
        public static final b pxD = g.pxK;
        public static final b pxE = h.pxK;
        public static final b pxF = c.pxK;
        public static final b pxG = e.pxK;
        public static final b pxH = d.pxK;
        public static final b pxI = k.pxK;
        public static final b pxJ = f.pxK;

        Matrix a(Matrix matrix, Rect rect, int i, int i2, float f, float f2);
    }

    /* loaded from: classes15.dex */
    public interface l {
        Object getState();
    }

    @Nullable
    public static o z(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof o) {
            return (o) drawable;
        }
        if (drawable instanceof com.facebook.drawee.drawable.c) {
            return z(((com.facebook.drawee.drawable.c) drawable).getDrawable());
        }
        if (drawable instanceof com.facebook.drawee.drawable.a) {
            com.facebook.drawee.drawable.a aVar = (com.facebook.drawee.drawable.a) drawable;
            int evC = aVar.evC();
            for (int i2 = 0; i2 < evC; i2++) {
                o z = z(aVar.getDrawable(i2));
                if (z != null) {
                    return z;
                }
            }
        }
        return null;
    }

    /* loaded from: classes15.dex */
    public static abstract class a implements b {
        public abstract void a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4);

        @Override // com.facebook.drawee.drawable.p.b
        public Matrix a(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            a(matrix, rect, i, i2, f, f2, rect.width() / i, rect.height() / i2);
            return matrix;
        }
    }

    /* loaded from: classes15.dex */
    private static class j extends a {
        public static final b pxK = new j();

        private j() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            matrix.setScale(f3, f4);
            matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + 0.5f));
        }

        public String toString() {
            return "fit_xy";
        }
    }

    /* loaded from: classes15.dex */
    private static class i extends a {
        public static final b pxK = new i();

        private i() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(f3, f4);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + 0.5f));
        }

        public String toString() {
            return "fit_start";
        }
    }

    /* loaded from: classes15.dex */
    private static class f extends a {
        public static final b pxK = new f();

        private f() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(f3, f4);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + (rect.height() - (i2 * min)) + 0.5f));
        }

        public String toString() {
            return "fit_bottom_start";
        }
    }

    /* loaded from: classes15.dex */
    private static class g extends a {
        public static final b pxK = new g();

        private g() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(f3, f4);
            float width = rect.left + ((rect.width() - (i * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (width + 0.5f), (int) (rect.top + ((rect.height() - (i2 * min)) * 0.5f) + 0.5f));
        }

        public String toString() {
            return "fit_center";
        }
    }

    /* loaded from: classes15.dex */
    private static class h extends a {
        public static final b pxK = new h();

        private h() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(f3, f4);
            float width = rect.left + (rect.width() - (i * min));
            matrix.setScale(min, min);
            matrix.postTranslate((int) (width + 0.5f), (int) (rect.top + (rect.height() - (i2 * min)) + 0.5f));
        }

        public String toString() {
            return "fit_end";
        }
    }

    /* loaded from: classes15.dex */
    private static class c extends a {
        public static final b pxK = new c();

        private c() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            matrix.setTranslate((int) (rect.left + ((rect.width() - i) * 0.5f) + 0.5f), (int) (rect.top + ((rect.height() - i2) * 0.5f) + 0.5f));
        }

        public String toString() {
            return "center";
        }
    }

    /* loaded from: classes15.dex */
    private static class e extends a {
        public static final b pxK = new e();

        private e() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(Math.min(f3, f4), 1.0f);
            float width = rect.left + ((rect.width() - (i * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (width + 0.5f), (int) (rect.top + ((rect.height() - (i2 * min)) * 0.5f) + 0.5f));
        }

        public String toString() {
            return "center_inside";
        }
    }

    /* loaded from: classes15.dex */
    private static class d extends a {
        public static final b pxK = new d();

        private d() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float f5;
            float height;
            if (f4 > f3) {
                f5 = ((rect.width() - (i * f4)) * 0.5f) + rect.left;
                height = rect.top;
            } else {
                f5 = rect.left;
                height = rect.top + ((rect.height() - (i2 * f3)) * 0.5f);
                f4 = f3;
            }
            matrix.setScale(f4, f4);
            matrix.postTranslate((int) (f5 + 0.5f), (int) (height + 0.5f));
        }

        public String toString() {
            return "center_crop";
        }
    }

    /* loaded from: classes15.dex */
    private static class k extends a {
        public static final b pxK = new k();

        private k() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float f5;
            float max;
            if (f4 > f3) {
                f5 = rect.left + Math.max(Math.min((rect.width() * 0.5f) - ((i * f4) * f), 0.0f), rect.width() - (i * f4));
                max = rect.top;
            } else {
                f5 = rect.left;
                max = Math.max(Math.min((rect.height() * 0.5f) - ((i2 * f3) * f2), 0.0f), rect.height() - (i2 * f3)) + rect.top;
                f4 = f3;
            }
            matrix.setScale(f4, f4);
            matrix.postTranslate((int) (f5 + 0.5f), (int) (max + 0.5f));
        }

        public String toString() {
            return "focus_crop";
        }
    }
}
