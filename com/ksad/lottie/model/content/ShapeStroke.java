package com.ksad.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.a.q;
import java.util.List;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31876a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31877b;

    /* renamed from: c  reason: collision with root package name */
    public final List<com.ksad.lottie.model.a.b> f31878c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.a f31879d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f31880e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31881f;

    /* renamed from: g  reason: collision with root package name */
    public final LineCapType f31882g;

    /* renamed from: h  reason: collision with root package name */
    public final LineJoinType f31883h;
    public final float i;

    /* renamed from: com.ksad.lottie.model.content.ShapeStroke$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31884a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f31885b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f31885b = iArr;
            try {
                iArr[LineJoinType.Bevel.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31885b[LineJoinType.Miter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31885b[LineJoinType.Round.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f31884a = iArr2;
            try {
                iArr2[LineCapType.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31884a[LineCapType.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31884a[LineCapType.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        public Paint.Cap toPaintCap() {
            int i = AnonymousClass1.f31884a[ordinal()];
            return i != 1 ? i != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* loaded from: classes6.dex */
    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public Paint.Join toPaintJoin() {
            int i = AnonymousClass1.f31885b[ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return Paint.Join.BEVEL;
        }
    }

    public ShapeStroke(String str, @Nullable com.ksad.lottie.model.a.b bVar, List<com.ksad.lottie.model.a.b> list, com.ksad.lottie.model.a.a aVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f2) {
        this.f31876a = str;
        this.f31877b = bVar;
        this.f31878c = list;
        this.f31879d = aVar;
        this.f31880e = dVar;
        this.f31881f = bVar2;
        this.f31882g = lineCapType;
        this.f31883h = lineJoinType;
        this.i = f2;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String a() {
        return this.f31876a;
    }

    public com.ksad.lottie.model.a.a b() {
        return this.f31879d;
    }

    public com.ksad.lottie.model.a.d c() {
        return this.f31880e;
    }

    public com.ksad.lottie.model.a.b d() {
        return this.f31881f;
    }

    public List<com.ksad.lottie.model.a.b> e() {
        return this.f31878c;
    }

    public com.ksad.lottie.model.a.b f() {
        return this.f31877b;
    }

    public LineCapType g() {
        return this.f31882g;
    }

    public LineJoinType h() {
        return this.f31883h;
    }

    public float i() {
        return this.i;
    }
}
