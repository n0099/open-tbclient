package d.a.q0.a.a0.a.j;

import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Stack;
/* loaded from: classes8.dex */
public class b implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Stack<b> f46520e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f46521f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f46522g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f46523h;

    /* renamed from: i  reason: collision with root package name */
    public TextPaint f46524i;
    public Path j;
    public boolean k;
    public CanvasView l;
    public k0 m;
    public int n;
    public int o;
    public int p;
    public int q;

    public b(CanvasView canvasView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {canvasView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46520e = new Stack<>();
        this.f46521f = new Paint();
        this.f46522g = new Paint();
        this.f46523h = new Paint();
        this.f46524i = new TextPaint();
        this.j = new Path();
        this.k = false;
        this.n = -1;
        this.o = 0;
        this.p = 0;
        this.q = -16777216;
        this.l = canvasView;
        g();
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.p : invokeV.intValue;
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.p = i2;
        }
    }

    public void f(Paint paint) {
        k0 k0Var;
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, paint) == null) || paint == null) {
            return;
        }
        if (this.l != null && (k0Var = this.m) != null && (iVar = k0Var.f46575h) != null && !iVar.c()) {
            k0 k0Var2 = this.m;
            paint.setShadowLayer(k0Var2.f46574g, k0Var2.f46572e, k0Var2.f46573f, k0Var2.f46575h.a());
        }
        int i2 = this.n;
        if (i2 < 0 || i2 > 255) {
            return;
        }
        paint.setAlpha(Math.min((paint.getAlpha() * this.n) >> 8, 255));
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.q = -16777216;
            this.f46522g.setStyle(Paint.Style.STROKE);
            this.f46521f.setColor(-16777216);
            this.f46522g.setColor(-16777216);
            this.f46523h.setColor(-16777216);
            this.f46524i.setColor(-16777216);
            this.f46522g.setStrokeWidth(d.a.q0.a.v2.n0.g(1.0f));
            this.f46522g.setAntiAlias(true);
            this.f46524i.setAntiAlias(true);
            this.f46523h.setAntiAlias(true);
            this.j.reset();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f46520e.empty()) {
            return;
        }
        b pop = this.f46520e.pop();
        this.f46521f = pop.f46521f;
        this.f46522g = pop.f46522g;
        this.f46523h = pop.f46523h;
        this.f46524i = pop.f46524i;
        this.j = pop.j;
        this.k = pop.k;
        this.f46520e = pop.f46520e;
        this.m = pop.m;
        this.n = pop.n;
        this.o = pop.o;
        this.p = pop.p;
        this.q = pop.q;
    }

    public void i() throws CloneNotSupportedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b bVar = (b) super.clone();
            bVar.f46521f = new Paint(this.f46521f);
            bVar.f46522g = new Paint(this.f46522g);
            bVar.f46523h = new Paint(this.f46523h);
            bVar.f46524i = new TextPaint(this.f46524i);
            bVar.j = new Path(this.j);
            bVar.o = this.o;
            bVar.p = this.p;
            bVar.q = this.q;
            this.f46520e.push(bVar);
        }
    }
}
