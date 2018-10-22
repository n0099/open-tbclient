package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class n {

    /* loaded from: classes2.dex */
    public interface b {
        public static final b iaK = i.iaS;
        public static final b iaL = h.iaS;
        public static final b iaM = f.iaS;
        public static final b iaN = g.iaS;
        public static final b iaO = c.iaS;
        public static final b iaP = e.iaS;
        public static final b iaQ = d.iaS;
        public static final b iaR = j.iaS;

        Matrix a(Matrix matrix, Rect rect, int i, int i2, float f, float f2);
    }

    /* loaded from: classes2.dex */
    public interface k {
        Object getState();
    }

    @Nullable
    public static m l(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof m) {
            return (m) drawable;
        }
        if (drawable instanceof com.facebook.drawee.drawable.c) {
            return l(((com.facebook.drawee.drawable.c) drawable).getDrawable());
        }
        if (drawable instanceof com.facebook.drawee.drawable.a) {
            com.facebook.drawee.drawable.a aVar = (com.facebook.drawee.drawable.a) drawable;
            int numberOfLayers = aVar.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                m l = l(aVar.getDrawable(i2));
                if (l != null) {
                    return l;
                }
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public static abstract class a implements b {
        public abstract void a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4);

        @Override // com.facebook.drawee.drawable.n.b
        public Matrix a(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            a(matrix, rect, i, i2, f, f2, rect.width() / i, rect.height() / i2);
            return matrix;
        }
    }

    /* loaded from: classes2.dex */
    private static class i extends a {
        public static final b iaS = new i();

        private i() {
        }

        @Override // com.facebook.drawee.drawable.n.a
        public void a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            matrix.setScale(f3, f4);
            matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + 0.5f));
        }

        public String toString() {
            return "fit_xy";
        }
    }

    /* loaded from: classes2.dex */
    private static class h extends a {
        public static final b iaS = new h();

        private h() {
        }

        @Override // com.facebook.drawee.drawable.n.a
        public void a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float min = Math.min(f3, f4);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + 0.5f));
        }

        public String toString() {
            return "fit_start";
        }
    }

    /* loaded from: classes2.dex */
    private static class f extends a {
        public static final b iaS = new f();

        private f() {
        }

        @Override // com.facebook.drawee.drawable.n.a
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

    /* loaded from: classes2.dex */
    private static class g extends a {
        public static final b iaS = new g();

        private g() {
        }

        @Override // com.facebook.drawee.drawable.n.a
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

    /* loaded from: classes2.dex */
    private static class c extends a {
        public static final b iaS = new c();

        private c() {
        }

        @Override // com.facebook.drawee.drawable.n.a
        public void a(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            matrix.setTranslate((int) (rect.left + ((rect.width() - i) * 0.5f) + 0.5f), (int) (rect.top + ((rect.height() - i2) * 0.5f) + 0.5f));
        }

        public String toString() {
            return "center";
        }
    }

    /* loaded from: classes2.dex */
    private static class e extends a {
        public static final b iaS = new e();

        private e() {
        }

        @Override // com.facebook.drawee.drawable.n.a
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

    /* loaded from: classes2.dex */
    private static class d extends a {
        public static final b iaS = new d();

        private d() {
        }

        @Override // com.facebook.drawee.drawable.n.a
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

    /* loaded from: classes2.dex */
    private static class j extends a {
        public static final b iaS = new j();

        private j() {
        }

        @Override // com.facebook.drawee.drawable.n.a
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
