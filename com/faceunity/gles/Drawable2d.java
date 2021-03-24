package com.faceunity.gles;

import d.e.c.d;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class Drawable2d {

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f30725h;
    public static final FloatBuffer j;
    public static final float[] l;
    public static final FloatBuffer n;
    public static final float[] p;
    public static final FloatBuffer r;

    /* renamed from: a  reason: collision with root package name */
    public FloatBuffer f30726a;

    /* renamed from: b  reason: collision with root package name */
    public FloatBuffer f30727b;

    /* renamed from: c  reason: collision with root package name */
    public int f30728c;

    /* renamed from: d  reason: collision with root package name */
    public int f30729d;

    /* renamed from: e  reason: collision with root package name */
    public int f30730e;

    /* renamed from: f  reason: collision with root package name */
    public int f30731f;

    /* renamed from: g  reason: collision with root package name */
    public Prefab f30732g;
    public static final float[] i = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer k = d.c(i);
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
        public static final /* synthetic */ int[] f30733a;

        static {
            int[] iArr = new int[Prefab.values().length];
            f30733a = iArr;
            try {
                iArr[Prefab.TRIANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30733a[Prefab.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30733a[Prefab.FULL_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        f30725h = fArr;
        j = d.c(fArr);
        float[] fArr2 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        l = fArr2;
        n = d.c(fArr2);
        float[] fArr3 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        p = fArr3;
        r = d.c(fArr3);
    }

    public Drawable2d(Prefab prefab) {
        int i2 = a.f30733a[prefab.ordinal()];
        if (i2 == 1) {
            this.f30726a = j;
            this.f30727b = k;
            this.f30729d = 2;
            this.f30730e = 2 * 4;
            this.f30728c = f30725h.length / 2;
        } else if (i2 == 2) {
            this.f30726a = n;
            this.f30727b = o;
            this.f30729d = 2;
            this.f30730e = 2 * 4;
            this.f30728c = l.length / 2;
        } else if (i2 == 3) {
            this.f30726a = r;
            this.f30727b = s;
            this.f30729d = 2;
            this.f30730e = 2 * 4;
            this.f30728c = p.length / 2;
        } else {
            throw new RuntimeException("Unknown shape " + prefab);
        }
        this.f30731f = 8;
        this.f30732g = prefab;
    }

    public int a() {
        return this.f30729d;
    }

    public FloatBuffer b() {
        return this.f30727b;
    }

    public int c() {
        return this.f30731f;
    }

    public FloatBuffer d() {
        return this.f30726a;
    }

    public int e() {
        return this.f30728c;
    }

    public int f() {
        return this.f30730e;
    }

    public String toString() {
        if (this.f30732g != null) {
            return "[Drawable2d: " + this.f30732g + "]";
        }
        return "[Drawable2d: ...]";
    }
}
