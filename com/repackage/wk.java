package com.repackage;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
import com.baidu.adp.newwidget.ImageView.DrawerArgs;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wk extends mk {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Matrix q;
    public BitmapShader r;
    public RectF s;

    public wk() {
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
        this.q = new Matrix();
        this.s = new RectF();
    }

    @Override // com.repackage.mk
    public void a(pk pkVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, pkVar, imageView) == null) {
            int b = pkVar.b();
            int a = pkVar.a();
            RectF rectF = this.f;
            PointF b2 = b(rectF.left, rectF.top, this.e);
            int i = (int) b2.x;
            int i2 = (int) b2.y;
            RectF rectF2 = this.f;
            PointF b3 = b(rectF2.right, rectF2.bottom, this.e);
            int i3 = (int) b3.x;
            int i4 = (int) b3.y;
            this.q.reset();
            this.q.postScale((i3 - i) / b, (i4 - i2) / a);
            this.q.postTranslate(i, i2);
            if (pkVar.e()) {
                Bitmap bitmap = pkVar.a.getBitmap();
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.r = new BitmapShader(bitmap, tileMode, tileMode);
            } else {
                this.r = pkVar.b.d();
            }
            BitmapShader bitmapShader = this.r;
            if (bitmapShader == null) {
                return;
            }
            bitmapShader.setLocalMatrix(this.q);
            this.b.setShader(this.r);
            int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
            int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
            this.s.set(Math.max(i, 0), Math.max(i2, 0), Math.min(i3, width), Math.min(i4, height));
            DrawerArgs drawerArgs = this.k;
            if (drawerArgs.c) {
                float f = drawerArgs.d / 2.0f;
                if (!drawerArgs.g) {
                    this.g.set(f, f, imageView.getWidth() - f, imageView.getHeight() - f);
                    return;
                }
                RectF rectF3 = this.g;
                RectF rectF4 = this.s;
                rectF3.set(rectF4.left + f, rectF4.top + f, rectF4.right - f, rectF4.bottom - f);
            }
        }
    }

    @Override // com.repackage.mk
    public void f(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, imageView) == null) {
            DrawerArgs drawerArgs = this.k;
            if (drawerArgs.c) {
                if (!drawerArgs.b) {
                    canvas.drawPath(l(this.g, drawerArgs.a), this.c);
                    return;
                }
                RectF rectF = this.s;
                float f = (rectF.right + rectF.left) / 2.0f;
                float f2 = (rectF.top + rectF.bottom) / 2.0f;
                float min = Math.min(rectF.width(), this.s.height()) / 2.0f;
                if (min <= 0.0f) {
                    f = (imageView.getRight() + imageView.getLeft()) / 2.0f;
                    f2 = (imageView.getTop() + imageView.getBottom()) / 2.0f;
                    min = Math.min(imageView.getWidth(), imageView.getHeight()) / 2.0f;
                }
                canvas.drawCircle(f, f2, min - (this.k.d / 2.0f), this.c);
            }
        }
    }

    @Override // com.repackage.mk
    public void h(Canvas canvas, pk pkVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, canvas, pkVar, imageView) == null) {
            boolean d = pkVar.d();
            if (d && pkVar.d()) {
                pkVar.b.b(true);
            }
            DrawerArgs drawerArgs = this.k;
            if (!drawerArgs.b) {
                canvas.drawPath(l(this.s, drawerArgs.a), this.b);
            } else {
                RectF rectF = this.s;
                canvas.drawCircle((rectF.right + rectF.left) / 2.0f, (rectF.top + rectF.bottom) / 2.0f, Math.min(rectF.width(), this.s.height()) / 2.0f, this.b);
            }
            if (d && pkVar.d()) {
                pkVar.b.b(false);
            }
        }
    }

    @Override // com.repackage.mk
    public void i(Canvas canvas, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, canvas, imageView) == null) || this.k.m == 0) {
            return;
        }
        int scrollX = imageView.getScrollX();
        int scrollY = imageView.getScrollY();
        canvas.translate(scrollX, scrollY);
        this.d.setColor(this.k.m);
        if (!this.k.b) {
            this.n.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
            canvas.drawPath(l(this.n, this.k.a), this.d);
        } else {
            float width = imageView.getWidth() / 2.0f;
            float height = imageView.getHeight() / 2.0f;
            canvas.drawCircle(width, height, Math.min(width, height) - (this.k.d / 2.0f), this.d);
        }
        canvas.translate(-scrollX, -scrollY);
    }
}
