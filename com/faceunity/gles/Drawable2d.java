package com.faceunity.gles;

import d.e.c.d;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class Drawable2d {

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f30701h;
    public static final FloatBuffer j;
    public static final float[] l;
    public static final FloatBuffer n;
    public static final float[] p;
    public static final FloatBuffer r;

    /* renamed from: a  reason: collision with root package name */
    public FloatBuffer f30703a;

    /* renamed from: b  reason: collision with root package name */
    public FloatBuffer f30704b;

    /* renamed from: c  reason: collision with root package name */
    public int f30705c;

    /* renamed from: d  reason: collision with root package name */
    public int f30706d;

    /* renamed from: e  reason: collision with root package name */
    public int f30707e;

    /* renamed from: f  reason: collision with root package name */
    public int f30708f;

    /* renamed from: g  reason: collision with root package name */
    public Prefab f30709g;

    /* renamed from: i  reason: collision with root package name */
    public static final float[] f30702i = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer k = d.c(f30702i);
    public static final float[] m = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final FloatBuffer o = d.c(m);
    public static final float[] q = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer s = d.c(q);

    /* loaded from: classes6.dex */
    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30710a;

        static {
            int[] iArr = new int[Prefab.values().length];
            f30710a = iArr;
            try {
                iArr[Prefab.TRIANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30710a[Prefab.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30710a[Prefab.FULL_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        f30701h = fArr;
        j = d.c(fArr);
        float[] fArr2 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        l = fArr2;
        n = d.c(fArr2);
        float[] fArr3 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        p = fArr3;
        r = d.c(fArr3);
    }

    public Drawable2d(Prefab prefab) {
        int i2 = a.f30710a[prefab.ordinal()];
        if (i2 == 1) {
            this.f30703a = j;
            this.f30704b = k;
            this.f30706d = 2;
            this.f30707e = 2 * 4;
            this.f30705c = f30701h.length / 2;
        } else if (i2 == 2) {
            this.f30703a = n;
            this.f30704b = o;
            this.f30706d = 2;
            this.f30707e = 2 * 4;
            this.f30705c = l.length / 2;
        } else if (i2 == 3) {
            this.f30703a = r;
            this.f30704b = s;
            this.f30706d = 2;
            this.f30707e = 2 * 4;
            this.f30705c = p.length / 2;
        } else {
            throw new RuntimeException("Unknown shape " + prefab);
        }
        this.f30708f = 8;
        this.f30709g = prefab;
    }

    public int a() {
        return this.f30706d;
    }

    public FloatBuffer b() {
        return this.f30704b;
    }

    public int c() {
        return this.f30708f;
    }

    public FloatBuffer d() {
        return this.f30703a;
    }

    public int e() {
        return this.f30705c;
    }

    public int f() {
        return this.f30707e;
    }

    public String toString() {
        if (this.f30709g != null) {
            return "[Drawable2d: " + this.f30709g + "]";
        }
        return "[Drawable2d: ...]";
    }
}
