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
    public Stack<b> f40586e = new Stack<>();

    /* renamed from: f  reason: collision with root package name */
    public Paint f40587f = new Paint();

    /* renamed from: g  reason: collision with root package name */
    public Paint f40588g = new Paint();

    /* renamed from: h  reason: collision with root package name */
    public Paint f40589h = new Paint();

    /* renamed from: i  reason: collision with root package name */
    public TextPaint f40590i = new TextPaint();
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
        if (this.l != null && (k0Var = this.m) != null && (iVar = k0Var.f40641h) != null && !iVar.c()) {
            k0 k0Var2 = this.m;
            paint.setShadowLayer(k0Var2.f40640g, k0Var2.f40638e, k0Var2.f40639f, k0Var2.f40641h.a());
        }
        int i2 = this.n;
        if (i2 < 0 || i2 > 255) {
            return;
        }
        paint.setAlpha(Math.min((paint.getAlpha() * this.n) >> 8, 255));
    }

    public void e() {
        this.q = -16777216;
        this.f40588g.setStyle(Paint.Style.STROKE);
        this.f40587f.setColor(-16777216);
        this.f40588g.setColor(-16777216);
        this.f40589h.setColor(-16777216);
        this.f40590i.setColor(-16777216);
        this.f40588g.setStrokeWidth(d.a.l0.a.v2.n0.g(1.0f));
        this.f40588g.setAntiAlias(true);
        this.f40590i.setAntiAlias(true);
        this.f40589h.setAntiAlias(true);
        this.j.reset();
    }

    public void f() {
        if (this.f40586e.empty()) {
            return;
        }
        b pop = this.f40586e.pop();
        this.f40587f = pop.f40587f;
        this.f40588g = pop.f40588g;
        this.f40589h = pop.f40589h;
        this.f40590i = pop.f40590i;
        this.j = pop.j;
        this.k = pop.k;
        this.f40586e = pop.f40586e;
        this.m = pop.m;
        this.n = pop.n;
        this.o = pop.o;
        this.p = pop.p;
        this.q = pop.q;
    }

    public void g() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.f40587f = new Paint(this.f40587f);
        bVar.f40588g = new Paint(this.f40588g);
        bVar.f40589h = new Paint(this.f40589h);
        bVar.f40590i = new TextPaint(this.f40590i);
        bVar.j = new Path(this.j);
        bVar.o = this.o;
        bVar.p = this.p;
        bVar.q = this.q;
        this.f40586e.push(bVar);
    }
}
