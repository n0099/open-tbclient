package com.ksad.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.a.q;
import java.util.List;
/* loaded from: classes6.dex */
public class ShapeStroke implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31491a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31492b;

    /* renamed from: c  reason: collision with root package name */
    public final List<com.ksad.lottie.model.a.b> f31493c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.a f31494d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f31495e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31496f;

    /* renamed from: g  reason: collision with root package name */
    public final LineCapType f31497g;

    /* renamed from: h  reason: collision with root package name */
    public final LineJoinType f31498h;
    public final float i;

    /* renamed from: com.ksad.lottie.model.content.ShapeStroke$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31499a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f31500b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f31500b = iArr;
            try {
                iArr[LineJoinType.Bevel.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31500b[LineJoinType.Miter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31500b[LineJoinType.Round.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f31499a = iArr2;
            try {
                iArr2[LineCapType.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31499a[LineCapType.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31499a[LineCapType.Unknown.ordinal()] = 3;
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
            int i = AnonymousClass1.f31499a[ordinal()];
            return i != 1 ? i != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* loaded from: classes6.dex */
    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public Paint.Join toPaintJoin() {
            int i = AnonymousClass1.f31500b[ordinal()];
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
        this.f31491a = str;
        this.f31492b = bVar;
        this.f31493c = list;
        this.f31494d = aVar;
        this.f31495e = dVar;
        this.f31496f = bVar2;
        this.f31497g = lineCapType;
        this.f31498h = lineJoinType;
        this.i = f2;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String a() {
        return this.f31491a;
    }

    public com.ksad.lottie.model.a.a b() {
        return this.f31494d;
    }

    public com.ksad.lottie.model.a.d c() {
        return this.f31495e;
    }

    public com.ksad.lottie.model.a.b d() {
        return this.f31496f;
    }

    public List<com.ksad.lottie.model.a.b> e() {
        return this.f31493c;
    }

    public com.ksad.lottie.model.a.b f() {
        return this.f31492b;
    }

    public LineCapType g() {
        return this.f31497g;
    }

    public LineJoinType h() {
        return this.f31498h;
    }

    public float i() {
        return this.i;
    }
}
