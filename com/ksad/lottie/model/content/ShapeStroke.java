package com.ksad.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.a.q;
import java.util.List;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f32124a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32125b;

    /* renamed from: c  reason: collision with root package name */
    public final List<com.ksad.lottie.model.a.b> f32126c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.a f32127d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f32128e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32129f;

    /* renamed from: g  reason: collision with root package name */
    public final LineCapType f32130g;

    /* renamed from: h  reason: collision with root package name */
    public final LineJoinType f32131h;

    /* renamed from: i  reason: collision with root package name */
    public final float f32132i;

    /* renamed from: com.ksad.lottie.model.content.ShapeStroke$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32133a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f32134b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f32134b = iArr;
            try {
                iArr[LineJoinType.Bevel.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32134b[LineJoinType.Miter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32134b[LineJoinType.Round.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f32133a = iArr2;
            try {
                iArr2[LineCapType.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32133a[LineCapType.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32133a[LineCapType.Unknown.ordinal()] = 3;
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
            int i2 = AnonymousClass1.f32133a[ordinal()];
            return i2 != 1 ? i2 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* loaded from: classes6.dex */
    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public Paint.Join toPaintJoin() {
            int i2 = AnonymousClass1.f32134b[ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
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
        this.f32124a = str;
        this.f32125b = bVar;
        this.f32126c = list;
        this.f32127d = aVar;
        this.f32128e = dVar;
        this.f32129f = bVar2;
        this.f32130g = lineCapType;
        this.f32131h = lineJoinType;
        this.f32132i = f2;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String a() {
        return this.f32124a;
    }

    public com.ksad.lottie.model.a.a b() {
        return this.f32127d;
    }

    public com.ksad.lottie.model.a.d c() {
        return this.f32128e;
    }

    public com.ksad.lottie.model.a.b d() {
        return this.f32129f;
    }

    public List<com.ksad.lottie.model.a.b> e() {
        return this.f32126c;
    }

    public com.ksad.lottie.model.a.b f() {
        return this.f32125b;
    }

    public LineCapType g() {
        return this.f32130g;
    }

    public LineJoinType h() {
        return this.f32131h;
    }

    public float i() {
        return this.f32132i;
    }
}
