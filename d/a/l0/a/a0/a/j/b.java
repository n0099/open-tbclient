package d.a.l0.a.a0.a.j;

import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import com.baidu.swan.apps.canvas.view.CanvasView;
import java.util.Stack;
/* loaded from: classes2.dex */
public class b implements Cloneable {
    public CanvasView l;
    public k0 m;

    /* renamed from: e  reason: collision with root package name */
    public Stack<b> f44262e = new Stack<>();

    /* renamed from: f  reason: collision with root package name */
    public Paint f44263f = new Paint();

    /* renamed from: g  reason: collision with root package name */
    public Paint f44264g = new Paint();

    /* renamed from: h  reason: collision with root package name */
    public Paint f44265h = new Paint();

    /* renamed from: i  reason: collision with root package name */
    public TextPaint f44266i = new TextPaint();
    public Path j = new Path();
    public boolean k = false;
    public int n = -1;
    public int o = 0;
    public int p = 0;
    public int q = -16777216;

    public b(CanvasView canvasView) {
        this.l = canvasView;
        e();
    }

    public int b() {
        return this.p;
    }

    public void c(int i2) {
        this.p = i2;
    }

    public void d(Paint paint) {
        k0 k0Var;
        i iVar;
        if (paint == null) {
            return;
        }
        if (this.l != null && (k0Var = this.m) != null && (iVar = k0Var.f44317h) != null && !iVar.c()) {
            k0 k0Var2 = this.m;
            paint.setShadowLayer(k0Var2.f44316g, k0Var2.f44314e, k0Var2.f44315f, k0Var2.f44317h.a());
        }
        int i2 = this.n;
        if (i2 < 0 || i2 > 255) {
            return;
        }
        paint.setAlpha(Math.min((paint.getAlpha() * this.n) >> 8, 255));
    }

    public void e() {
        this.q = -16777216;
        this.f44264g.setStyle(Paint.Style.STROKE);
        this.f44263f.setColor(-16777216);
        this.f44264g.setColor(-16777216);
        this.f44265h.setColor(-16777216);
        this.f44266i.setColor(-16777216);
        this.f44264g.setStrokeWidth(d.a.l0.a.v2.n0.g(1.0f));
        this.f44264g.setAntiAlias(true);
        this.f44266i.setAntiAlias(true);
        this.f44265h.setAntiAlias(true);
        this.j.reset();
    }

    public void f() {
        if (this.f44262e.empty()) {
            return;
        }
        b pop = this.f44262e.pop();
        this.f44263f = pop.f44263f;
        this.f44264g = pop.f44264g;
        this.f44265h = pop.f44265h;
        this.f44266i = pop.f44266i;
        this.j = pop.j;
        this.k = pop.k;
        this.f44262e = pop.f44262e;
        this.m = pop.m;
        this.n = pop.n;
        this.o = pop.o;
        this.p = pop.p;
        this.q = pop.q;
    }

    public void g() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.f44263f = new Paint(this.f44263f);
        bVar.f44264g = new Paint(this.f44264g);
        bVar.f44265h = new Paint(this.f44265h);
        bVar.f44266i = new TextPaint(this.f44266i);
        bVar.j = new Path(this.j);
        bVar.o = this.o;
        bVar.p = this.p;
        bVar.q = this.q;
        this.f44262e.push(bVar);
    }
}
