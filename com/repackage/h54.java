package com.repackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dn2;
/* loaded from: classes6.dex */
public class h54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t54 a;
        public final /* synthetic */ dn2 b;

        public a(t54 t54Var, dn2 dn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t54Var, dn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t54Var;
            this.b = dn2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                o54.a(this.a, this.b);
            }
        }
    }

    public static View a(t54 t54Var, dn2 dn2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, t54Var, dn2Var)) == null) {
            jx1.i("map", "creatCallout start");
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setColor(dn2Var.i.b);
            paint.setTextSize(dn2Var.i.c);
            dn2.b bVar = dn2Var.i;
            float f = bVar.e;
            float f2 = bVar.f;
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            paint2.setColor(dn2Var.i.h);
            String str = dn2Var.i.a;
            int g = ae3.g(6.0f);
            float f3 = f * 2.0f;
            float measureText = paint.measureText(str) + f3;
            float f4 = paint.getFontMetrics().bottom - paint.getFontMetrics().top;
            float f5 = g + f4 + f3;
            if (f5 > 0.0f && measureText > 0.0f) {
                Bitmap createBitmap = Bitmap.createBitmap((int) measureText, (int) f5, Bitmap.Config.ARGB_8888);
                createBitmap.eraseColor(Color.argb(0, 0, 0, 0));
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                RectF rectF = new RectF();
                rectF.left = 0.0f;
                rectF.top = 0.0f;
                float f6 = f4 + f3;
                rectF.bottom = f6;
                rectF.right = measureText;
                canvas.drawRoundRect(rectF, f2, f2, paint2);
                Path path = new Path();
                float f7 = measureText / 2.0f;
                float f8 = g / 2;
                path.moveTo(f7 - f8, f6);
                path.lineTo(f7, f5);
                path.lineTo(f7 + f8, f6);
                path.close();
                canvas.drawPath(path, paint2);
                canvas.drawText(str, f, (-paint.getFontMetrics().top) + f, paint);
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(createBitmap.getWidth(), createBitmap.getHeight()));
                imageView.setImageBitmap(createBitmap);
                imageView.setOnClickListener(new a(t54Var, dn2Var));
                jx1.i("map", "creatCallout end");
                return imageView;
            }
            jx1.o("map", "callout height or wodth is 0");
            return new ImageView(AppRuntime.getAppContext());
        }
        return (View) invokeLL.objValue;
    }
}
