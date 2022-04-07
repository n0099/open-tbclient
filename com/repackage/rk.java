package com.repackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;
import com.baidu.adp.newwidget.ImageView.DrawerArgs;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rk extends pk {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect q;

    public rk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new Rect();
    }

    @Override // com.repackage.pk
    public void a(sk skVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, skVar, imageView) == null) {
            DrawerArgs drawerArgs = this.k;
            if (drawerArgs.c) {
                float f = drawerArgs.d / 2.0f;
                if (!drawerArgs.g) {
                    this.g.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                    return;
                }
                int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
                int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
                RectF rectF = this.f;
                PointF b = b(rectF.left, rectF.top, this.e);
                RectF rectF2 = this.f;
                PointF b2 = b(rectF2.right, rectF2.bottom, this.e);
                this.g.set(Math.max((int) b.x, 0) + f, Math.max((int) b.y, 0) + f, Math.min((int) b2.x, width) - f, Math.min((int) b2.y, height) - f);
            }
        }
    }

    @Override // com.repackage.pk
    public void f(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, imageView) == null) && this.k.c) {
            canvas.drawRect(this.g, this.c);
        }
    }

    @Override // com.repackage.pk
    public void h(Canvas canvas, sk skVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, canvas, skVar, imageView) == null) {
            Matrix matrix = this.e;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            if (skVar.e()) {
                Bitmap bitmap = skVar.a.getBitmap();
                this.q.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                canvas.drawBitmap(bitmap, this.q, this.f, this.b);
            } else if (skVar.d()) {
                this.q.set(0, 0, skVar.b(), skVar.a());
                skVar.b.g(canvas, this.q, this.f, this.b);
            }
        }
    }

    @Override // com.repackage.pk
    public void i(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, canvas, imageView) == null) || this.k.m == 0) {
            return;
        }
        int scrollX = imageView.getScrollX();
        int scrollY = imageView.getScrollY();
        canvas.translate(scrollX, scrollY);
        this.n.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
        this.d.setColor(this.k.m);
        canvas.drawRect(this.n, this.d);
        canvas.translate(-scrollX, -scrollY);
    }
}
