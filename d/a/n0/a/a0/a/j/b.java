package d.a.n0.a.a0.a.j;

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
/* loaded from: classes7.dex */
public class b implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Stack<b> f43218e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f43219f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f43220g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f43221h;

    /* renamed from: i  reason: collision with root package name */
    public TextPaint f43222i;
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
        this.f43218e = new Stack<>();
        this.f43219f = new Paint();
        this.f43220g = new Paint();
        this.f43221h = new Paint();
        this.f43222i = new TextPaint();
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
        if (this.l != null && (k0Var = this.m) != null && (iVar = k0Var.f43273h) != null && !iVar.c()) {
            k0 k0Var2 = this.m;
            paint.setShadowLayer(k0Var2.f43272g, k0Var2.f43270e, k0Var2.f43271f, k0Var2.f43273h.a());
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
            this.f43220g.setStyle(Paint.Style.STROKE);
            this.f43219f.setColor(-16777216);
            this.f43220g.setColor(-16777216);
            this.f43221h.setColor(-16777216);
            this.f43222i.setColor(-16777216);
            this.f43220g.setStrokeWidth(d.a.n0.a.v2.n0.g(1.0f));
            this.f43220g.setAntiAlias(true);
            this.f43222i.setAntiAlias(true);
            this.f43221h.setAntiAlias(true);
            this.j.reset();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f43218e.empty()) {
            return;
        }
        b pop = this.f43218e.pop();
        this.f43219f = pop.f43219f;
        this.f43220g = pop.f43220g;
        this.f43221h = pop.f43221h;
        this.f43222i = pop.f43222i;
        this.j = pop.j;
        this.k = pop.k;
        this.f43218e = pop.f43218e;
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
            bVar.f43219f = new Paint(this.f43219f);
            bVar.f43220g = new Paint(this.f43220g);
            bVar.f43221h = new Paint(this.f43221h);
            bVar.f43222i = new TextPaint(this.f43222i);
            bVar.j = new Path(this.j);
            bVar.o = this.o;
            bVar.p = this.p;
            bVar.q = this.q;
            this.f43218e.push(bVar);
        }
    }
}
