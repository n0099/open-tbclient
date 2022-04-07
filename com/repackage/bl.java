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
public class bl extends yk {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect v;

    public bl() {
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

    @Override // com.repackage.rk, com.repackage.pk
    public void h(Canvas canvas, sk skVar, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, canvas, skVar, imageView) == null) {
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
            if (skVar.e()) {
                Bitmap bitmap = skVar.a.getBitmap();
                this.v.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                canvas.drawBitmap(bitmap, this.v, this.f, this.b);
            } else {
                this.v.set(0, 0, skVar.b(), skVar.a());
                skVar.b.g(canvas, this.v, this.f, this.b);
            }
            canvas.restore();
        }
    }
}
