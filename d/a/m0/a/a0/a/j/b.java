package d.a.m0.a.a0.a.j;

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
    public Stack<b> f44370e = new Stack<>();

    /* renamed from: f  reason: collision with root package name */
    public Paint f44371f = new Paint();

    /* renamed from: g  reason: collision with root package name */
    public Paint f44372g = new Paint();

    /* renamed from: h  reason: collision with root package name */
    public Paint f44373h = new Paint();

    /* renamed from: i  reason: collision with root package name */
    public TextPaint f44374i = new TextPaint();
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
        if (this.l != null && (k0Var = this.m) != null && (iVar = k0Var.f44425h) != null && !iVar.c()) {
            k0 k0Var2 = this.m;
            paint.setShadowLayer(k0Var2.f44424g, k0Var2.f44422e, k0Var2.f44423f, k0Var2.f44425h.a());
        }
        int i2 = this.n;
        if (i2 < 0 || i2 > 255) {
            return;
        }
        paint.setAlpha(Math.min((paint.getAlpha() * this.n) >> 8, 255));
    }

    public void e() {
        this.q = -16777216;
        this.f44372g.setStyle(Paint.Style.STROKE);
        this.f44371f.setColor(-16777216);
        this.f44372g.setColor(-16777216);
        this.f44373h.setColor(-16777216);
        this.f44374i.setColor(-16777216);
        this.f44372g.setStrokeWidth(d.a.m0.a.v2.n0.g(1.0f));
        this.f44372g.setAntiAlias(true);
        this.f44374i.setAntiAlias(true);
        this.f44373h.setAntiAlias(true);
        this.j.reset();
    }

    public void f() {
        if (this.f44370e.empty()) {
            return;
        }
        b pop = this.f44370e.pop();
        this.f44371f = pop.f44371f;
        this.f44372g = pop.f44372g;
        this.f44373h = pop.f44373h;
        this.f44374i = pop.f44374i;
        this.j = pop.j;
        this.k = pop.k;
        this.f44370e = pop.f44370e;
        this.m = pop.m;
        this.n = pop.n;
        this.o = pop.o;
        this.p = pop.p;
        this.q = pop.q;
    }

    public void g() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        bVar.f44371f = new Paint(this.f44371f);
        bVar.f44372g = new Paint(this.f44372g);
        bVar.f44373h = new Paint(this.f44373h);
        bVar.f44374i = new TextPaint(this.f44374i);
        bVar.j = new Path(this.j);
        bVar.o = this.o;
        bVar.p = this.p;
        bVar.q = this.q;
        this.f44370e.push(bVar);
    }
}
