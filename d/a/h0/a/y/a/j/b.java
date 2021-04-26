package d.a.h0.a.y.a.j;

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
    public Stack<b> f45122e = new Stack<>();

    /* renamed from: f  reason: collision with root package name */
    public Paint f45123f = new Paint();

    /* renamed from: g  reason: collision with root package name */
    public Paint f45124g = new Paint();

    /* renamed from: h  reason: collision with root package name */
    public Paint f45125h = new Paint();

    /* renamed from: i  reason: collision with root package name */
    public TextPaint f45126i = new TextPaint();
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
        if (this.l != null && (k0Var = this.m) != null && (iVar = k0Var.f45177h) != null && !iVar.c()) {
            k0 k0Var2 = this.m;
            paint.setShadowLayer(k0Var2.f45176g, k0Var2.f45174e, k0Var2.f45175f, k0Var2.f45177h.a());
        }
        int i2 = this.n;
        if (i2 < 0 || i2 > 255) {
            return;
        }
        paint.setAlpha(Math.min((paint.getAlpha() * this.n) >> 8, 255));
    }

    public void e() {
        this.q = -16777216;
        this.f45124g.setStyle(Paint.Style.STROKE);
        this.f45123f.setColor(-16777216);
        this.f45124g.setColor(-16777216);
        this.f45125h.setColor(-16777216);
        this.f45126i.setColor(-16777216);
        this.f45124g.setStrokeWidth(d.a.h0.a.i2.h0.f(1.0f));
        this.f45124g.setAntiAlias(true);
        this.f45126i.setAntiAlias(true);
        this.f45125h.setAntiAlias(true);
        this.j.reset();
    }

    public void f() {
        if (this.f45122e.empty()) {
            return;
        }
        b pop = this.f45122e.pop();
        this.f45123f = pop.f45123f;
        this.f45124g = pop.f45124g;
        this.f45125h = pop.f45125h;
        this.f45126i = pop.f45126i;
        this.j = pop.j;
        this.k = pop.k;
        this.f45122e = pop.f45122e;
        this.m = pop.m;
        this.n = pop.n;
        this.o = pop.o;
        this.p = pop.p;
        this.q = pop.q;
    }

    public void g() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.f45123f = new Paint(this.f45123f);
        bVar.f45124g = new Paint(this.f45124g);
        bVar.f45125h = new Paint(this.f45125h);
        bVar.f45126i = new TextPaint(this.f45126i);
        bVar.j = new Path(this.j);
        bVar.o = this.o;
        bVar.p = this.p;
        bVar.q = this.q;
        this.f45122e.push(bVar);
    }
}
