package d.a.a.s.k;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.layer.Layer;
import d.a.a.j;
import d.a.a.q.b.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends d.a.a.s.k.a {
    @Nullable
    public Boolean A;
    @Nullable
    public Boolean B;
    @Nullable
    public d.a.a.q.b.a<Float, Float> w;
    public final List<d.a.a.s.k.a> x;
    public final RectF y;
    public final RectF z;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41419a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f41419a = iArr;
            try {
                iArr[Layer.MatteType.Add.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41419a[Layer.MatteType.Invert.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(d.a.a.f fVar, Layer layer, List<Layer> list, d.a.a.d dVar) {
        super(fVar, layer);
        int i;
        d.a.a.s.k.a aVar;
        this.x = new ArrayList();
        this.y = new RectF();
        this.z = new RectF();
        d.a.a.s.i.b s = layer.s();
        if (s != null) {
            d.a.a.q.b.a<Float, Float> a2 = s.a();
            this.w = a2;
            h(a2);
            this.w.a(this);
        } else {
            this.w = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar.j().size());
        int size = list.size() - 1;
        d.a.a.s.k.a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            d.a.a.s.k.a n = d.a.a.s.k.a.n(layer2, fVar, dVar);
            if (n != null) {
                longSparseArray.put(n.o().b(), n);
                if (aVar2 != null) {
                    aVar2.x(n);
                    aVar2 = null;
                } else {
                    this.x.add(0, n);
                    int i2 = a.f41419a[layer2.f().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        aVar2 = n;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            d.a.a.s.k.a aVar3 = (d.a.a.s.k.a) longSparseArray.get(longSparseArray.keyAt(i));
            if (aVar3 != null && (aVar = (d.a.a.s.k.a) longSparseArray.get(aVar3.o().h())) != null) {
                aVar3.y(aVar);
            }
        }
    }

    public boolean C() {
        if (this.B == null) {
            for (int size = this.x.size() - 1; size >= 0; size--) {
                d.a.a.s.k.a aVar = this.x.get(size);
                if (aVar instanceof e) {
                    if (aVar.p()) {
                        this.B = Boolean.TRUE;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).C()) {
                    this.B = Boolean.TRUE;
                    return true;
                }
            }
            this.B = Boolean.FALSE;
        }
        return this.B.booleanValue();
    }

    public boolean D() {
        if (this.A == null) {
            if (q()) {
                this.A = Boolean.TRUE;
                return true;
            }
            for (int size = this.x.size() - 1; size >= 0; size--) {
                if (this.x.get(size).q()) {
                    this.A = Boolean.TRUE;
                    return true;
                }
            }
            this.A = Boolean.FALSE;
        }
        return this.A.booleanValue();
    }

    @Override // d.a.a.s.k.a, d.a.a.q.a.d
    public void c(RectF rectF, Matrix matrix) {
        super.c(rectF, matrix);
        this.y.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.x.size() - 1; size >= 0; size--) {
            this.x.get(size).c(this.y, this.m);
            if (rectF.isEmpty()) {
                rectF.set(this.y);
            } else {
                rectF.set(Math.min(rectF.left, this.y.left), Math.min(rectF.top, this.y.top), Math.max(rectF.right, this.y.right), Math.max(rectF.bottom, this.y.bottom));
            }
        }
    }

    @Override // d.a.a.s.k.a, d.a.a.s.f
    public <T> void d(T t, @Nullable d.a.a.w.c<T> cVar) {
        super.d(t, cVar);
        if (t == j.w) {
            if (cVar == null) {
                this.w = null;
                return;
            }
            p pVar = new p(cVar);
            this.w = pVar;
            h(pVar);
        }
    }

    @Override // d.a.a.s.k.a
    public void m(Canvas canvas, Matrix matrix, int i) {
        d.a.a.c.a("CompositionLayer#draw");
        int save = canvas.save();
        this.z.set(0.0f, 0.0f, this.o.j(), this.o.i());
        matrix.mapRect(this.z);
        for (int size = this.x.size() - 1; size >= 0; size--) {
            if (!this.z.isEmpty() ? canvas.clipRect(this.z) : true) {
                this.x.get(size).g(canvas, matrix, i);
            }
        }
        if (save > 0) {
            canvas.restoreToCount(save);
        }
        d.a.a.c.c("CompositionLayer#draw");
    }

    @Override // d.a.a.s.k.a
    public void v(d.a.a.s.e eVar, int i, List<d.a.a.s.e> list, d.a.a.s.e eVar2) {
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            this.x.get(i2).e(eVar, i, list, eVar2);
        }
    }

    @Override // d.a.a.s.k.a
    public void z(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        super.z(f2);
        if (this.w != null) {
            f2 = (this.w.h().floatValue() * 1000.0f) / this.n.l().d();
        }
        if (this.o.t() != 0.0f) {
            f2 /= this.o.t();
        }
        float p = f2 - this.o.p();
        for (int size = this.x.size() - 1; size >= 0; size--) {
            this.x.get(size).z(p);
        }
    }
}
