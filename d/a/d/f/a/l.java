package d.a.d.f.a;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class l extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Matrix q;
    public BitmapShader r;
    public RectF s;

    public l() {
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
        this.q = new Matrix();
        this.s = new RectF();
    }

    @Override // d.a.d.f.a.a
    public void a(d dVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, imageView) == null) {
            int b2 = dVar.b();
            int a2 = dVar.a();
            RectF rectF = this.f42096f;
            PointF b3 = b(rectF.left, rectF.top, this.f42095e);
            int i2 = (int) b3.x;
            int i3 = (int) b3.y;
            RectF rectF2 = this.f42096f;
            PointF b4 = b(rectF2.right, rectF2.bottom, this.f42095e);
            int i4 = (int) b4.x;
            int i5 = (int) b4.y;
            this.q.reset();
            this.q.postScale((i4 - i2) / b2, (i5 - i3) / a2);
            this.q.postTranslate(i2, i3);
            if (dVar.e()) {
                Bitmap bitmap = dVar.f42103a.getBitmap();
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.r = new BitmapShader(bitmap, tileMode, tileMode);
            } else {
                this.r = dVar.f42104b.d();
            }
            BitmapShader bitmapShader = this.r;
            if (bitmapShader == null) {
                return;
            }
            bitmapShader.setLocalMatrix(this.q);
            this.f42092b.setShader(this.r);
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            this.s.set(Math.max(i2, 0), Math.max(i3, 0), Math.min(i4, width), Math.min(i5, height));
            e eVar = this.k;
            if (eVar.f42108c) {
                float f2 = eVar.f42109d / 2.0f;
                if (!eVar.f42112g) {
                    this.f42097g.set(f2, f2, imageView.getWidth() - f2, imageView.getHeight() - f2);
                    return;
                }
                RectF rectF3 = this.f42097g;
                RectF rectF4 = this.s;
                rectF3.set(rectF4.left + f2, rectF4.top + f2, rectF4.right - f2, rectF4.bottom - f2);
            }
        }
    }

    @Override // d.a.d.f.a.a
    public void f(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, imageView) == null) {
            e eVar = this.k;
            if (eVar.f42108c) {
                if (!eVar.f42107b) {
                    canvas.drawPath(l(this.f42097g, eVar.f42106a), this.f42093c);
                    return;
                }
                RectF rectF = this.s;
                float f2 = (rectF.right + rectF.left) / 2.0f;
                float f3 = (rectF.top + rectF.bottom) / 2.0f;
                float min = Math.min(rectF.width(), this.s.height()) / 2.0f;
                if (min <= 0.0f) {
                    f2 = (imageView.getRight() + imageView.getLeft()) / 2.0f;
                    f3 = (imageView.getTop() + imageView.getBottom()) / 2.0f;
                    min = Math.min(imageView.getWidth(), imageView.getHeight()) / 2.0f;
                }
                canvas.drawCircle(f2, f3, min - (this.k.f42109d / 2.0f), this.f42093c);
            }
        }
    }

    @Override // d.a.d.f.a.a
    public void h(Canvas canvas, d dVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, canvas, dVar, imageView) == null) {
            boolean d2 = dVar.d();
            if (d2 && dVar.d()) {
                dVar.f42104b.b(true);
            }
            e eVar = this.k;
            if (!eVar.f42107b) {
                canvas.drawPath(l(this.s, eVar.f42106a), this.f42092b);
            } else {
                RectF rectF = this.s;
                canvas.drawCircle((rectF.right + rectF.left) / 2.0f, (rectF.top + rectF.bottom) / 2.0f, Math.min(rectF.width(), this.s.height()) / 2.0f, this.f42092b);
            }
            if (d2 && dVar.d()) {
                dVar.f42104b.b(false);
            }
        }
    }

    @Override // d.a.d.f.a.a
    public void i(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, canvas, imageView) == null) || this.k.m == 0) {
            return;
        }
        int scrollX = imageView.getScrollX();
        int scrollY = imageView.getScrollY();
        canvas.translate(scrollX, scrollY);
        this.f42094d.setColor(this.k.m);
        if (!this.k.f42107b) {
            this.n.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            canvas.drawPath(l(this.n, this.k.f42106a), this.f42094d);
        } else {
            float width = imageView.getWidth() / 2.0f;
            float height = imageView.getHeight() / 2.0f;
            canvas.drawCircle(width, height, Math.min(width, height) - (this.k.f42109d / 2.0f), this.f42094d);
        }
        canvas.translate(-scrollX, -scrollY);
    }
}
