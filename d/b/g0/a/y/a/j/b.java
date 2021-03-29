package d.b.g0.a.y.a.j;

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
    public Stack<b> f46969e = new Stack<>();

    /* renamed from: f  reason: collision with root package name */
    public Paint f46970f = new Paint();

    /* renamed from: g  reason: collision with root package name */
    public Paint f46971g = new Paint();

    /* renamed from: h  reason: collision with root package name */
    public Paint f46972h = new Paint();
    public TextPaint i = new TextPaint();
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

    public void c(int i) {
        this.p = i;
    }

    public void d(Paint paint) {
        k0 k0Var;
        i iVar;
        if (paint == null) {
            return;
        }
        if (this.l != null && (k0Var = this.m) != null && (iVar = k0Var.f47022h) != null && !iVar.c()) {
            k0 k0Var2 = this.m;
            paint.setShadowLayer(k0Var2.f47021g, k0Var2.f47019e, k0Var2.f47020f, k0Var2.f47022h.a());
        }
        int i = this.n;
        if (i < 0 || i > 255) {
            return;
        }
        paint.setAlpha(Math.min((paint.getAlpha() * this.n) >> 8, 255));
    }

    public void e() {
        this.q = -16777216;
        this.f46971g.setStyle(Paint.Style.STROKE);
        this.f46970f.setColor(-16777216);
        this.f46971g.setColor(-16777216);
        this.f46972h.setColor(-16777216);
        this.i.setColor(-16777216);
        this.f46971g.setStrokeWidth(d.b.g0.a.i2.h0.f(1.0f));
        this.f46971g.setAntiAlias(true);
        this.i.setAntiAlias(true);
        this.f46972h.setAntiAlias(true);
        this.j.reset();
    }

    public void f() {
        if (this.f46969e.empty()) {
            return;
        }
        b pop = this.f46969e.pop();
        this.f46970f = pop.f46970f;
        this.f46971g = pop.f46971g;
        this.f46972h = pop.f46972h;
        this.i = pop.i;
        this.j = pop.j;
        this.k = pop.k;
        this.f46969e = pop.f46969e;
        this.m = pop.m;
        this.n = pop.n;
        this.o = pop.o;
        this.p = pop.p;
        this.q = pop.q;
    }

    public void g() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.f46970f = new Paint(this.f46970f);
        bVar.f46971g = new Paint(this.f46971g);
        bVar.f46972h = new Paint(this.f46972h);
        bVar.i = new TextPaint(this.i);
        bVar.j = new Path(this.j);
        bVar.o = this.o;
        bVar.p = this.p;
        bVar.q = this.q;
        this.f46969e.push(bVar);
    }
}
