package d.a.i0.a.a0.a.j;

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
    public Stack<b> f40412e = new Stack<>();

    /* renamed from: f  reason: collision with root package name */
    public Paint f40413f = new Paint();

    /* renamed from: g  reason: collision with root package name */
    public Paint f40414g = new Paint();

    /* renamed from: h  reason: collision with root package name */
    public Paint f40415h = new Paint();

    /* renamed from: i  reason: collision with root package name */
    public TextPaint f40416i = new TextPaint();
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
        if (this.l != null && (k0Var = this.m) != null && (iVar = k0Var.f40467h) != null && !iVar.c()) {
            k0 k0Var2 = this.m;
            paint.setShadowLayer(k0Var2.f40466g, k0Var2.f40464e, k0Var2.f40465f, k0Var2.f40467h.a());
        }
        int i2 = this.n;
        if (i2 < 0 || i2 > 255) {
            return;
        }
        paint.setAlpha(Math.min((paint.getAlpha() * this.n) >> 8, 255));
    }

    public void e() {
        this.q = -16777216;
        this.f40414g.setStyle(Paint.Style.STROKE);
        this.f40413f.setColor(-16777216);
        this.f40414g.setColor(-16777216);
        this.f40415h.setColor(-16777216);
        this.f40416i.setColor(-16777216);
        this.f40414g.setStrokeWidth(d.a.i0.a.v2.n0.g(1.0f));
        this.f40414g.setAntiAlias(true);
        this.f40416i.setAntiAlias(true);
        this.f40415h.setAntiAlias(true);
        this.j.reset();
    }

    public void f() {
        if (this.f40412e.empty()) {
            return;
        }
        b pop = this.f40412e.pop();
        this.f40413f = pop.f40413f;
        this.f40414g = pop.f40414g;
        this.f40415h = pop.f40415h;
        this.f40416i = pop.f40416i;
        this.j = pop.j;
        this.k = pop.k;
        this.f40412e = pop.f40412e;
        this.m = pop.m;
        this.n = pop.n;
        this.o = pop.o;
        this.p = pop.p;
        this.q = pop.q;
    }

    public void g() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.f40413f = new Paint(this.f40413f);
        bVar.f40414g = new Paint(this.f40414g);
        bVar.f40415h = new Paint(this.f40415h);
        bVar.f40416i = new TextPaint(this.f40416i);
        bVar.j = new Path(this.j);
        bVar.o = this.o;
        bVar.p = this.p;
        bVar.q = this.q;
        this.f40412e.push(bVar);
    }
}
