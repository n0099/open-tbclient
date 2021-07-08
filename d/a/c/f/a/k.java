package d.a.c.f.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class k extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Path r;
    public Paint s;
    public a t;
    public boolean u;

    /* loaded from: classes7.dex */
    public interface a {
        Path a(RectF rectF);

        void b(Canvas canvas);
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new Path();
        this.s = null;
        this.u = false;
    }

    @Override // d.a.c.f.a.a
    public void c(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        Path a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, dVar, imageView, scaleType) == null) {
            super.c(dVar, imageView, scaleType);
            a aVar = this.t;
            if (aVar == null || (a2 = aVar.a(j())) == null) {
                return;
            }
            this.r.set(a2);
            if (this.s == null) {
                Paint paint = new Paint();
                this.s = paint;
                paint.setStyle(Paint.Style.STROKE);
                this.s.setAntiAlias(true);
                this.s.setColor(637534208);
                this.s.setDither(true);
                this.s.setStrokeWidth(2.0f);
            }
            r();
        }
    }

    @Override // d.a.c.f.a.a
    public void g(Canvas canvas, d dVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, dVar, imageView) == null) {
            super.g(canvas, dVar, imageView);
            if (this.u) {
                canvas.drawPath(this.r, this.s);
                a aVar = this.t;
                if (aVar != null) {
                    aVar.b(canvas);
                }
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void t(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.t = aVar;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.u = z;
        }
    }
}
