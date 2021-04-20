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
    public Stack<b> f47361e = new Stack<>();

    /* renamed from: f  reason: collision with root package name */
    public Paint f47362f = new Paint();

    /* renamed from: g  reason: collision with root package name */
    public Paint f47363g = new Paint();

    /* renamed from: h  reason: collision with root package name */
    public Paint f47364h = new Paint();
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
        if (this.l != null && (k0Var = this.m) != null && (iVar = k0Var.f47414h) != null && !iVar.c()) {
            k0 k0Var2 = this.m;
            paint.setShadowLayer(k0Var2.f47413g, k0Var2.f47411e, k0Var2.f47412f, k0Var2.f47414h.a());
        }
        int i = this.n;
        if (i < 0 || i > 255) {
            return;
        }
        paint.setAlpha(Math.min((paint.getAlpha() * this.n) >> 8, 255));
    }

    public void e() {
        this.q = -16777216;
        this.f47363g.setStyle(Paint.Style.STROKE);
        this.f47362f.setColor(-16777216);
        this.f47363g.setColor(-16777216);
        this.f47364h.setColor(-16777216);
        this.i.setColor(-16777216);
        this.f47363g.setStrokeWidth(d.b.g0.a.i2.h0.f(1.0f));
        this.f47363g.setAntiAlias(true);
        this.i.setAntiAlias(true);
        this.f47364h.setAntiAlias(true);
        this.j.reset();
    }

    public void f() {
        if (this.f47361e.empty()) {
            return;
        }
        b pop = this.f47361e.pop();
        this.f47362f = pop.f47362f;
        this.f47363g = pop.f47363g;
        this.f47364h = pop.f47364h;
        this.i = pop.i;
        this.j = pop.j;
        this.k = pop.k;
        this.f47361e = pop.f47361e;
        this.m = pop.m;
        this.n = pop.n;
        this.o = pop.o;
        this.p = pop.p;
        this.q = pop.q;
    }

    public void g() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.f47362f = new Paint(this.f47362f);
        bVar.f47363g = new Paint(this.f47363g);
        bVar.f47364h = new Paint(this.f47364h);
        bVar.i = new TextPaint(this.i);
        bVar.j = new Path(this.j);
        bVar.o = this.o;
        bVar.p = this.p;
        bVar.q = this.q;
        this.f47361e.push(bVar);
    }
}
