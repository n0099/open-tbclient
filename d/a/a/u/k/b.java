package d.a.a.u.k;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.layer.Layer;
import d.a.a.k;
import d.a.a.s.c.p;
import d.a.a.x.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends d.a.a.u.k.a {
    public final RectF A;
    public Paint B;
    @Nullable
    public Boolean C;
    @Nullable
    public Boolean D;
    @Nullable
    public d.a.a.s.c.a<Float, Float> x;
    public final List<d.a.a.u.k.a> y;
    public final RectF z;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41729a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f41729a = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41729a[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(d.a.a.f fVar, Layer layer, List<Layer> list, d.a.a.d dVar) {
        super(fVar, layer);
        int i;
        d.a.a.u.k.a aVar;
        this.y = new ArrayList();
        this.z = new RectF();
        this.A = new RectF();
        this.B = new Paint();
        d.a.a.u.i.b s = layer.s();
        if (s != null) {
            d.a.a.s.c.a<Float, Float> a2 = s.a();
            this.x = a2;
            i(a2);
            this.x.a(this);
        } else {
            this.x = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar.j().size());
        int size = list.size() - 1;
        d.a.a.u.k.a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            d.a.a.u.k.a u = d.a.a.u.k.a.u(layer2, fVar, dVar);
            if (u != null) {
                longSparseArray.put(u.v().b(), u);
                if (aVar2 != null) {
                    aVar2.E(u);
                    aVar2 = null;
                } else {
                    this.y.add(0, u);
                    int i2 = a.f41729a[layer2.f().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        aVar2 = u;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            d.a.a.u.k.a aVar3 = (d.a.a.u.k.a) longSparseArray.get(longSparseArray.keyAt(i));
            if (aVar3 != null && (aVar = (d.a.a.u.k.a) longSparseArray.get(aVar3.v().h())) != null) {
                aVar3.F(aVar);
            }
        }
    }

    @Override // d.a.a.u.k.a
    public void D(d.a.a.u.d dVar, int i, List<d.a.a.u.d> list, d.a.a.u.d dVar2) {
        for (int i2 = 0; i2 < this.y.size(); i2++) {
            this.y.get(i2).d(dVar, i, list, dVar2);
        }
    }

    @Override // d.a.a.u.k.a
    public void G(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        super.G(f2);
        if (this.x != null) {
            f2 = ((this.x.h().floatValue() * this.o.a().h()) - this.o.a().o()) / (this.n.p().e() + 0.01f);
        }
        if (this.x == null) {
            f2 -= this.o.p();
        }
        if (this.o.t() != 0.0f) {
            f2 /= this.o.t();
        }
        for (int size = this.y.size() - 1; size >= 0; size--) {
            this.y.get(size).G(f2);
        }
    }

    public boolean J() {
        if (this.D == null) {
            for (int size = this.y.size() - 1; size >= 0; size--) {
                d.a.a.u.k.a aVar = this.y.get(size);
                if (aVar instanceof e) {
                    if (aVar.w()) {
                        this.D = Boolean.TRUE;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).J()) {
                    this.D = Boolean.TRUE;
                    return true;
                }
            }
            this.D = Boolean.FALSE;
        }
        return this.D.booleanValue();
    }

    public boolean K() {
        if (this.C == null) {
            if (x()) {
                this.C = Boolean.TRUE;
                return true;
            }
            for (int size = this.y.size() - 1; size >= 0; size--) {
                if (this.y.get(size).x()) {
                    this.C = Boolean.TRUE;
                    return true;
                }
            }
            this.C = Boolean.FALSE;
        }
        return this.C.booleanValue();
    }

    @Override // d.a.a.u.k.a, d.a.a.u.e
    public <T> void c(T t, @Nullable d.a.a.y.c<T> cVar) {
        super.c(t, cVar);
        if (t == k.A) {
            if (cVar == null) {
                d.a.a.s.c.a<Float, Float> aVar = this.x;
                if (aVar != null) {
                    aVar.m(null);
                    return;
                }
                return;
            }
            p pVar = new p(cVar);
            this.x = pVar;
            pVar.a(this);
            i(this.x);
        }
    }

    @Override // d.a.a.u.k.a, d.a.a.s.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        for (int size = this.y.size() - 1; size >= 0; size--) {
            this.z.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.y.get(size).e(this.z, this.m, true);
            rectF.union(this.z);
        }
    }

    @Override // d.a.a.u.k.a
    public void t(Canvas canvas, Matrix matrix, int i) {
        d.a.a.c.a("CompositionLayer#draw");
        this.A.set(0.0f, 0.0f, this.o.j(), this.o.i());
        matrix.mapRect(this.A);
        boolean z = this.n.K() && this.y.size() > 1 && i != 255;
        if (z) {
            this.B.setAlpha(i);
            h.m(canvas, this.A, this.B);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.y.size() - 1; size >= 0; size--) {
            if (!this.A.isEmpty() ? canvas.clipRect(this.A) : true) {
                this.y.get(size).g(canvas, matrix, i);
            }
        }
        canvas.restore();
        d.a.a.c.b("CompositionLayer#draw");
    }
}
