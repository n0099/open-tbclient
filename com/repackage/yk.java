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
/* loaded from: classes7.dex */
public class yk extends vk {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect v;

    public yk() {
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
        this.v = new Rect();
    }

    @Override // com.repackage.ok, com.repackage.mk
    public void h(Canvas canvas, pk pkVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, canvas, pkVar, imageView) == null) {
            Matrix matrix = this.e;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            canvas.save();
            if (this.u) {
                try {
                    canvas.clipPath(this.r);
                } catch (Error unused) {
                }
            }
            if (pkVar.e()) {
                Bitmap bitmap = pkVar.a.getBitmap();
                this.v.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                canvas.drawBitmap(bitmap, this.v, this.f, this.b);
            } else {
                this.v.set(0, 0, pkVar.b(), pkVar.a());
                pkVar.b.g(canvas, this.v, this.f, this.b);
            }
            canvas.restore();
        }
    }
}
