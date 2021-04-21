package d.b.h0.a.f1.h;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import d.b.h0.a.k;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45168c = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public double f45169a = 1.0d;

    /* renamed from: b  reason: collision with root package name */
    public Set<Integer> f45170b;

    /* renamed from: d.b.h0.a.f1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0723a {
        public static a a(String str) {
            return b(str, 0.5d);
        }

        public static a b(String str, double d2) {
            char c2;
            int hashCode = str.hashCode();
            if (hashCode == -2129978548) {
                if (str.equals("simple_parser")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode != -585839565) {
                if (hashCode == 544848403 && str.equals("hsv_parser")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else {
                if (str.equals("solid_parser")) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        return new c();
                    }
                    return new d();
                }
                return new b(d2);
            }
            return new c();
        }
    }

    public abstract boolean a(Bitmap bitmap, Rect rect);

    public boolean b(Bitmap bitmap, Rect rect) {
        if (bitmap == null || rect == null || rect.top < 0 || rect.bottom < 0 || rect.left < 0 || rect.right < 0) {
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = rect.top;
        int i2 = rect.bottom;
        if (i >= i2 || i2 > height) {
            return false;
        }
        int i3 = rect.left;
        int i4 = rect.right;
        return i3 < i4 && i4 <= width;
    }

    public void c(int i) {
        Set<Integer> set = this.f45170b;
        if (set == null) {
            this.f45170b = new TreeSet();
        } else {
            set.clear();
        }
        if (f45168c) {
            Log.d("ErrorPageParser", "set color " + String.format("#%06X", Integer.valueOf(16777215 & i)));
        }
        this.f45170b.add(Integer.valueOf(i));
    }
}
