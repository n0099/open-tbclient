package com.faceunity.gles;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import d.e.c.d;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class Drawable2d {

    /* renamed from: h  reason: collision with root package name */
    public static final float[] f30783h;
    public static final FloatBuffer j;
    public static final float[] l;
    public static final FloatBuffer n;
    public static final float[] p;
    public static final FloatBuffer r;

    /* renamed from: a  reason: collision with root package name */
    public FloatBuffer f30785a;

    /* renamed from: b  reason: collision with root package name */
    public FloatBuffer f30786b;

    /* renamed from: c  reason: collision with root package name */
    public int f30787c;

    /* renamed from: d  reason: collision with root package name */
    public int f30788d;

    /* renamed from: e  reason: collision with root package name */
    public int f30789e;

    /* renamed from: f  reason: collision with root package name */
    public int f30790f;

    /* renamed from: g  reason: collision with root package name */
    public Prefab f30791g;

    /* renamed from: i  reason: collision with root package name */
    public static final float[] f30784i = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer k = d.c(f30784i);
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
        public static final /* synthetic */ int[] f30792a;

        static {
            int[] iArr = new int[Prefab.values().length];
            f30792a = iArr;
            try {
                iArr[Prefab.TRIANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30792a[Prefab.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30792a[Prefab.FULL_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        f30783h = fArr;
        j = d.c(fArr);
        float[] fArr2 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        l = fArr2;
        n = d.c(fArr2);
        float[] fArr3 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        p = fArr3;
        r = d.c(fArr3);
    }

    public Drawable2d(Prefab prefab) {
        int i2 = a.f30792a[prefab.ordinal()];
        if (i2 == 1) {
            this.f30785a = j;
            this.f30786b = k;
            this.f30788d = 2;
            this.f30789e = 2 * 4;
            this.f30787c = f30783h.length / 2;
        } else if (i2 == 2) {
            this.f30785a = n;
            this.f30786b = o;
            this.f30788d = 2;
            this.f30789e = 2 * 4;
            this.f30787c = l.length / 2;
        } else if (i2 == 3) {
            this.f30785a = r;
            this.f30786b = s;
            this.f30788d = 2;
            this.f30789e = 2 * 4;
            this.f30787c = p.length / 2;
        } else {
            throw new RuntimeException("Unknown shape " + prefab);
        }
        this.f30790f = 8;
        this.f30791g = prefab;
    }

    public int a() {
        return this.f30788d;
    }

    public FloatBuffer b() {
        return this.f30786b;
    }

    public int c() {
        return this.f30790f;
    }

    public FloatBuffer d() {
        return this.f30785a;
    }

    public int e() {
        return this.f30787c;
    }

    public int f() {
        return this.f30789e;
    }

    public String toString() {
        if (this.f30791g != null) {
            return "[Drawable2d: " + this.f30791g + PreferencesUtil.RIGHT_MOUNT;
        }
        return "[Drawable2d: ...]";
    }
}
