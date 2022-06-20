package com.repackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class al extends xk {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect x;

    public al() {
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
        this.x = new Rect();
    }

    @Override // com.repackage.qk, com.repackage.ok
    public void h(Canvas canvas, rk rkVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, canvas, rkVar, imageView) == null) {
            Matrix matrix = this.f;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            canvas.save();
            if (this.w) {
                try {
                    canvas.clipPath(this.t);
                } catch (Error unused) {
                }
            }
            if (rkVar.e()) {
                Bitmap bitmap = rkVar.a.getBitmap();
                this.x.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                canvas.drawBitmap(bitmap, this.x, this.g, this.c);
            } else {
                this.x.set(0, 0, rkVar.b(), rkVar.a());
                rkVar.b.g(canvas, this.x, this.g, this.c);
            }
            canvas.restore();
        }
    }
}
