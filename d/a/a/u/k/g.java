package d.a.a.u.k;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.layer.Layer;
import com.android.internal.http.multipart.Part;
import d.a.a.r;
import d.a.a.s.c.n;
import d.a.a.s.c.p;
import d.a.a.u.i.k;
import d.a.a.u.j.j;
import d.a.a.x.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g extends d.a.a.u.k.a {
    public final Paint A;
    public final Paint B;
    public final Map<d.a.a.u.c, List<d.a.a.s.b.d>> C;
    public final LongSparseArray<String> D;
    public final n E;
    public final d.a.a.f F;
    public final d.a.a.d G;
    @Nullable
    public d.a.a.s.c.a<Integer, Integer> H;
    @Nullable
    public d.a.a.s.c.a<Integer, Integer> I;
    @Nullable
    public d.a.a.s.c.a<Integer, Integer> J;
    @Nullable
    public d.a.a.s.c.a<Integer, Integer> K;
    @Nullable
    public d.a.a.s.c.a<Float, Float> L;
    @Nullable
    public d.a.a.s.c.a<Float, Float> M;
    @Nullable
    public d.a.a.s.c.a<Float, Float> N;
    @Nullable
    public d.a.a.s.c.a<Float, Float> O;
    @Nullable
    public d.a.a.s.c.a<Float, Float> P;
    @Nullable
    public d.a.a.s.c.a<Float, Float> Q;
    public final StringBuilder x;
    public final RectF y;
    public final Matrix z;

    /* loaded from: classes.dex */
    public class a extends Paint {
        public a(g gVar, int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    /* loaded from: classes.dex */
    public class b extends Paint {
        public b(g gVar, int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41825a;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            f41825a = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41825a[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41825a[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public g(d.a.a.f fVar, Layer layer) {
        super(fVar, layer);
        d.a.a.u.i.b bVar;
        d.a.a.u.i.b bVar2;
        d.a.a.u.i.a aVar;
        d.a.a.u.i.a aVar2;
        this.x = new StringBuilder(2);
        this.y = new RectF();
        this.z = new Matrix();
        this.A = new a(this, 1);
        this.B = new b(this, 1);
        this.C = new HashMap();
        this.D = new LongSparseArray<>();
        this.F = fVar;
        this.G = layer.a();
        n a2 = layer.q().a();
        this.E = a2;
        a2.a(this);
        i(this.E);
        k r = layer.r();
        if (r != null && (aVar2 = r.f41751a) != null) {
            d.a.a.s.c.a<Integer, Integer> a3 = aVar2.a();
            this.H = a3;
            a3.a(this);
            i(this.H);
        }
        if (r != null && (aVar = r.f41752b) != null) {
            d.a.a.s.c.a<Integer, Integer> a4 = aVar.a();
            this.J = a4;
            a4.a(this);
            i(this.J);
        }
        if (r != null && (bVar2 = r.f41753c) != null) {
            d.a.a.s.c.a<Float, Float> a5 = bVar2.a();
            this.L = a5;
            a5.a(this);
            i(this.L);
        }
        if (r == null || (bVar = r.f41754d) == null) {
            return;
        }
        d.a.a.s.c.a<Float, Float> a6 = bVar.a();
        this.N = a6;
        a6.a(this);
        i(this.N);
    }

    public final void J(DocumentData.Justification justification, Canvas canvas, float f2) {
        int i = c.f41825a[justification.ordinal()];
        if (i == 2) {
            canvas.translate(-f2, 0.0f);
        } else if (i != 3) {
        } else {
            canvas.translate((-f2) / 2.0f, 0.0f);
        }
    }

    public final String K(String str, int i) {
        int codePointAt = str.codePointAt(i);
        int charCount = Character.charCount(codePointAt) + i;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!W(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j = codePointAt;
        if (this.D.containsKey(j)) {
            return this.D.get(j);
        }
        this.x.setLength(0);
        while (i < charCount) {
            int codePointAt3 = str.codePointAt(i);
            this.x.appendCodePoint(codePointAt3);
            i += Character.charCount(codePointAt3);
        }
        String sb = this.x.toString();
        this.D.put(j, sb);
        return sb;
    }

    public final void L(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public final void M(d.a.a.u.c cVar, Matrix matrix, float f2, DocumentData documentData, Canvas canvas) {
        List<d.a.a.s.b.d> T = T(cVar);
        for (int i = 0; i < T.size(); i++) {
            Path path = T.get(i).getPath();
            path.computeBounds(this.y, false);
            this.z.set(matrix);
            this.z.preTranslate(0.0f, (-documentData.f1585g) * h.e());
            this.z.preScale(f2, f2);
            path.transform(this.z);
            if (documentData.k) {
                P(path, this.A, canvas);
                P(path, this.B, canvas);
            } else {
                P(path, this.B, canvas);
                P(path, this.A, canvas);
            }
        }
    }

    public final void N(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.k) {
            L(str, this.A, canvas);
            L(str, this.B, canvas);
            return;
        }
        L(str, this.B, canvas);
        L(str, this.A, canvas);
    }

    public final void O(String str, DocumentData documentData, Canvas canvas, float f2) {
        int i = 0;
        while (i < str.length()) {
            String K = K(str, i);
            i += K.length();
            N(K, documentData, canvas);
            canvas.translate(this.A.measureText(K) + f2, 0.0f);
        }
    }

    public final void P(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final void Q(String str, DocumentData documentData, Matrix matrix, d.a.a.u.b bVar, Canvas canvas, float f2, float f3) {
        float floatValue;
        for (int i = 0; i < str.length(); i++) {
            d.a.a.u.c cVar = this.G.c().get(d.a.a.u.c.c(str.charAt(i), bVar.a(), bVar.c()));
            if (cVar != null) {
                M(cVar, matrix, f3, documentData, canvas);
                float b2 = ((float) cVar.b()) * f3 * h.e() * f2;
                float f4 = documentData.f1583e / 10.0f;
                d.a.a.s.c.a<Float, Float> aVar = this.O;
                if (aVar != null) {
                    floatValue = aVar.h().floatValue();
                } else {
                    d.a.a.s.c.a<Float, Float> aVar2 = this.N;
                    if (aVar2 != null) {
                        floatValue = aVar2.h().floatValue();
                    }
                    canvas.translate(b2 + (f4 * f2), 0.0f);
                }
                f4 += floatValue;
                canvas.translate(b2 + (f4 * f2), 0.0f);
            }
        }
    }

    public final void R(DocumentData documentData, Matrix matrix, d.a.a.u.b bVar, Canvas canvas) {
        float f2;
        d.a.a.s.c.a<Float, Float> aVar = this.Q;
        if (aVar != null) {
            f2 = aVar.h().floatValue();
        } else {
            d.a.a.s.c.a<Float, Float> aVar2 = this.P;
            if (aVar2 != null) {
                f2 = aVar2.h().floatValue();
            } else {
                f2 = documentData.f1581c;
            }
        }
        float f3 = f2 / 100.0f;
        float g2 = h.g(matrix);
        String str = documentData.f1579a;
        float e2 = documentData.f1584f * h.e();
        List<String> V = V(str);
        int size = V.size();
        for (int i = 0; i < size; i++) {
            String str2 = V.get(i);
            float U = U(str2, bVar, f3, g2);
            canvas.save();
            J(documentData.f1582d, canvas, U);
            canvas.translate(0.0f, (i * e2) - (((size - 1) * e2) / 2.0f));
            Q(str2, documentData, matrix, bVar, canvas, g2, f3);
            canvas.restore();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a7 A[LOOP:0: B:22:0x00a5->B:23:0x00a7, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void S(DocumentData documentData, d.a.a.u.b bVar, Matrix matrix, Canvas canvas) {
        float f2;
        float floatValue;
        int size;
        int i;
        h.g(matrix);
        Typeface G = this.F.G(bVar.a(), bVar.c());
        if (G == null) {
            return;
        }
        String str = documentData.f1579a;
        r F = this.F.F();
        if (F == null) {
            this.A.setTypeface(G);
            d.a.a.s.c.a<Float, Float> aVar = this.Q;
            if (aVar != null) {
                f2 = aVar.h().floatValue();
            } else {
                d.a.a.s.c.a<Float, Float> aVar2 = this.P;
                if (aVar2 != null) {
                    f2 = aVar2.h().floatValue();
                } else {
                    f2 = documentData.f1581c;
                }
            }
            this.A.setTextSize(h.e() * f2);
            this.B.setTypeface(this.A.getTypeface());
            this.B.setTextSize(this.A.getTextSize());
            float e2 = documentData.f1584f * h.e();
            float f3 = documentData.f1583e / 10.0f;
            d.a.a.s.c.a<Float, Float> aVar3 = this.O;
            if (aVar3 != null) {
                floatValue = aVar3.h().floatValue();
            } else {
                d.a.a.s.c.a<Float, Float> aVar4 = this.N;
                if (aVar4 != null) {
                    floatValue = aVar4.h().floatValue();
                }
                float e3 = ((f3 * h.e()) * f2) / 100.0f;
                List<String> V = V(str);
                size = V.size();
                for (i = 0; i < size; i++) {
                    String str2 = V.get(i);
                    float measureText = this.B.measureText(str2) + ((str2.length() - 1) * e3);
                    canvas.save();
                    J(documentData.f1582d, canvas, measureText);
                    canvas.translate(0.0f, (i * e2) - (((size - 1) * e2) / 2.0f));
                    O(str2, documentData, canvas, e3);
                    canvas.restore();
                }
                return;
            }
            f3 += floatValue;
            float e32 = ((f3 * h.e()) * f2) / 100.0f;
            List<String> V2 = V(str);
            size = V2.size();
            while (i < size) {
            }
            return;
        }
        F.a(str);
        throw null;
    }

    public final List<d.a.a.s.b.d> T(d.a.a.u.c cVar) {
        if (this.C.containsKey(cVar)) {
            return this.C.get(cVar);
        }
        List<j> a2 = cVar.a();
        int size = a2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new d.a.a.s.b.d(this.F, this, a2.get(i)));
        }
        this.C.put(cVar, arrayList);
        return arrayList;
    }

    public final float U(String str, d.a.a.u.b bVar, float f2, float f3) {
        float f4 = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            d.a.a.u.c cVar = this.G.c().get(d.a.a.u.c.c(str.charAt(i), bVar.a(), bVar.c()));
            if (cVar != null) {
                f4 = (float) (f4 + (cVar.b() * f2 * h.e() * f3));
            }
        }
        return f4;
    }

    public final List<String> V(String str) {
        return Arrays.asList(str.replaceAll(Part.CRLF, "\r").replaceAll("\n", "\r").split("\r"));
    }

    public final boolean W(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 19;
    }

    @Override // d.a.a.u.k.a, d.a.a.u.e
    public <T> void c(T t, @Nullable d.a.a.y.c<T> cVar) {
        super.c(t, cVar);
        if (t == d.a.a.k.f41581a) {
            d.a.a.s.c.a<Integer, Integer> aVar = this.I;
            if (aVar != null) {
                C(aVar);
            }
            if (cVar == null) {
                this.I = null;
                return;
            }
            p pVar = new p(cVar);
            this.I = pVar;
            pVar.a(this);
            i(this.I);
        } else if (t == d.a.a.k.f41582b) {
            d.a.a.s.c.a<Integer, Integer> aVar2 = this.K;
            if (aVar2 != null) {
                C(aVar2);
            }
            if (cVar == null) {
                this.K = null;
                return;
            }
            p pVar2 = new p(cVar);
            this.K = pVar2;
            pVar2.a(this);
            i(this.K);
        } else if (t == d.a.a.k.o) {
            d.a.a.s.c.a<Float, Float> aVar3 = this.M;
            if (aVar3 != null) {
                C(aVar3);
            }
            if (cVar == null) {
                this.M = null;
                return;
            }
            p pVar3 = new p(cVar);
            this.M = pVar3;
            pVar3.a(this);
            i(this.M);
        } else if (t == d.a.a.k.p) {
            d.a.a.s.c.a<Float, Float> aVar4 = this.O;
            if (aVar4 != null) {
                C(aVar4);
            }
            if (cVar == null) {
                this.O = null;
                return;
            }
            p pVar4 = new p(cVar);
            this.O = pVar4;
            pVar4.a(this);
            i(this.O);
        } else if (t == d.a.a.k.B) {
            d.a.a.s.c.a<Float, Float> aVar5 = this.Q;
            if (aVar5 != null) {
                C(aVar5);
            }
            if (cVar == null) {
                this.Q = null;
                return;
            }
            p pVar5 = new p(cVar);
            this.Q = pVar5;
            pVar5.a(this);
            i(this.Q);
        }
    }

    @Override // d.a.a.u.k.a, d.a.a.s.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.G.b().width(), this.G.b().height());
    }

    @Override // d.a.a.u.k.a
    public void t(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.F.x0()) {
            canvas.concat(matrix);
        }
        DocumentData h2 = this.E.h();
        d.a.a.u.b bVar = this.G.g().get(h2.f1580b);
        if (bVar == null) {
            canvas.restore();
            return;
        }
        d.a.a.s.c.a<Integer, Integer> aVar = this.I;
        if (aVar != null) {
            this.A.setColor(aVar.h().intValue());
        } else {
            d.a.a.s.c.a<Integer, Integer> aVar2 = this.H;
            if (aVar2 != null) {
                this.A.setColor(aVar2.h().intValue());
            } else {
                this.A.setColor(h2.f1586h);
            }
        }
        d.a.a.s.c.a<Integer, Integer> aVar3 = this.K;
        if (aVar3 != null) {
            this.B.setColor(aVar3.h().intValue());
        } else {
            d.a.a.s.c.a<Integer, Integer> aVar4 = this.J;
            if (aVar4 != null) {
                this.B.setColor(aVar4.h().intValue());
            } else {
                this.B.setColor(h2.i);
            }
        }
        int intValue = ((this.v.h() == null ? 100 : this.v.h().h().intValue()) * 255) / 100;
        this.A.setAlpha(intValue);
        this.B.setAlpha(intValue);
        d.a.a.s.c.a<Float, Float> aVar5 = this.M;
        if (aVar5 != null) {
            this.B.setStrokeWidth(aVar5.h().floatValue());
        } else {
            d.a.a.s.c.a<Float, Float> aVar6 = this.L;
            if (aVar6 != null) {
                this.B.setStrokeWidth(aVar6.h().floatValue());
            } else {
                this.B.setStrokeWidth(h2.j * h.e() * h.g(matrix));
            }
        }
        if (this.F.x0()) {
            R(h2, matrix, bVar, canvas);
        } else {
            S(h2, bVar, matrix, canvas);
        }
        canvas.restore();
    }
}
