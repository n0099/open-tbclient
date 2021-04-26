package com.faceunity.gles;

import d.e.c.d;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class Drawable2d {

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f31436h;
    public static final FloatBuffer j;
    public static final float[] l;
    public static final FloatBuffer n;
    public static final float[] p;
    public static final FloatBuffer r;

    /* renamed from: a  reason: collision with root package name */
    public FloatBuffer f31438a;

    /* renamed from: b  reason: collision with root package name */
    public FloatBuffer f31439b;

    /* renamed from: c  reason: collision with root package name */
    public int f31440c;

    /* renamed from: d  reason: collision with root package name */
    public int f31441d;

    /* renamed from: e  reason: collision with root package name */
    public int f31442e;

    /* renamed from: f  reason: collision with root package name */
    public int f31443f;

    /* renamed from: g  reason: collision with root package name */
    public Prefab f31444g;

    /* renamed from: i  reason: collision with root package name */
    public static final float[] f31437i = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer k = d.c(f31437i);
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
        public static final /* synthetic */ int[] f31445a;

        static {
            int[] iArr = new int[Prefab.values().length];
            f31445a = iArr;
            try {
                iArr[Prefab.TRIANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31445a[Prefab.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31445a[Prefab.FULL_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        f31436h = fArr;
        j = d.c(fArr);
        float[] fArr2 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        l = fArr2;
        n = d.c(fArr2);
        float[] fArr3 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        p = fArr3;
        r = d.c(fArr3);
    }

    public Drawable2d(Prefab prefab) {
        int i2 = a.f31445a[prefab.ordinal()];
        if (i2 == 1) {
            this.f31438a = j;
            this.f31439b = k;
            this.f31441d = 2;
            this.f31442e = 2 * 4;
            this.f31440c = f31436h.length / 2;
        } else if (i2 == 2) {
            this.f31438a = n;
            this.f31439b = o;
            this.f31441d = 2;
            this.f31442e = 2 * 4;
            this.f31440c = l.length / 2;
        } else if (i2 == 3) {
            this.f31438a = r;
            this.f31439b = s;
            this.f31441d = 2;
            this.f31442e = 2 * 4;
            this.f31440c = p.length / 2;
        } else {
            throw new RuntimeException("Unknown shape " + prefab);
        }
        this.f31443f = 8;
        this.f31444g = prefab;
    }

    public int a() {
        return this.f31441d;
    }

    public FloatBuffer b() {
        return this.f31439b;
    }

    public int c() {
        return this.f31443f;
    }

    public FloatBuffer d() {
        return this.f31438a;
    }

    public int e() {
        return this.f31440c;
    }

    public int f() {
        return this.f31442e;
    }

    public String toString() {
        if (this.f31444g != null) {
            return "[Drawable2d: " + this.f31444g + "]";
        }
        return "[Drawable2d: ...]";
    }
}
