package com.faceunity.gles;

import d.e.c.d;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class Drawable2d {

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f30610h;
    public static final FloatBuffer j;
    public static final float[] l;
    public static final FloatBuffer n;
    public static final float[] p;
    public static final FloatBuffer r;

    /* renamed from: a  reason: collision with root package name */
    public FloatBuffer f30612a;

    /* renamed from: b  reason: collision with root package name */
    public FloatBuffer f30613b;

    /* renamed from: c  reason: collision with root package name */
    public int f30614c;

    /* renamed from: d  reason: collision with root package name */
    public int f30615d;

    /* renamed from: e  reason: collision with root package name */
    public int f30616e;

    /* renamed from: f  reason: collision with root package name */
    public int f30617f;

    /* renamed from: g  reason: collision with root package name */
    public Prefab f30618g;

    /* renamed from: i  reason: collision with root package name */
    public static final float[] f30611i = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer k = d.c(f30611i);
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
        public static final /* synthetic */ int[] f30619a;

        static {
            int[] iArr = new int[Prefab.values().length];
            f30619a = iArr;
            try {
                iArr[Prefab.TRIANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30619a[Prefab.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30619a[Prefab.FULL_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        f30610h = fArr;
        j = d.c(fArr);
        float[] fArr2 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        l = fArr2;
        n = d.c(fArr2);
        float[] fArr3 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        p = fArr3;
        r = d.c(fArr3);
    }

    public Drawable2d(Prefab prefab) {
        int i2 = a.f30619a[prefab.ordinal()];
        if (i2 == 1) {
            this.f30612a = j;
            this.f30613b = k;
            this.f30615d = 2;
            this.f30616e = 2 * 4;
            this.f30614c = f30610h.length / 2;
        } else if (i2 == 2) {
            this.f30612a = n;
            this.f30613b = o;
            this.f30615d = 2;
            this.f30616e = 2 * 4;
            this.f30614c = l.length / 2;
        } else if (i2 == 3) {
            this.f30612a = r;
            this.f30613b = s;
            this.f30615d = 2;
            this.f30616e = 2 * 4;
            this.f30614c = p.length / 2;
        } else {
            throw new RuntimeException("Unknown shape " + prefab);
        }
        this.f30617f = 8;
        this.f30618g = prefab;
    }

    public int a() {
        return this.f30615d;
    }

    public FloatBuffer b() {
        return this.f30613b;
    }

    public int c() {
        return this.f30617f;
    }

    public FloatBuffer d() {
        return this.f30612a;
    }

    public int e() {
        return this.f30614c;
    }

    public int f() {
        return this.f30616e;
    }

    public String toString() {
        if (this.f30618g != null) {
            return "[Drawable2d: " + this.f30618g + "]";
        }
        return "[Drawable2d: ...]";
    }
}
