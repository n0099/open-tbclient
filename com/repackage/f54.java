package com.repackage;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ed3;
/* loaded from: classes6.dex */
public class f54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements ed3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zm2 a;
        public final /* synthetic */ q54 b;
        public final /* synthetic */ m54 c;

        public a(zm2 zm2Var, q54 q54Var, m54 m54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm2Var, q54Var, m54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zm2Var;
            this.b = q54Var;
            this.c = m54Var;
        }

        @Override // com.repackage.ed3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    hx1.o("map", " icon is null ");
                }
                if (bitmap != null) {
                    int i = this.a.d.c;
                    if (i == -1) {
                        i = bitmap.getWidth();
                    }
                    int i2 = this.a.d.d;
                    if (i2 == -1) {
                        i2 = bitmap.getHeight();
                    }
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                    builder.width(i);
                    builder.height(i2);
                    builder.align(1, 8);
                    en2 en2Var = this.a.d;
                    builder.point(new Point(en2Var.a, en2Var.b));
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.b.l.addView(imageView, builder.build());
                    imageView.setOnClickListener(this.c);
                    imageView.setClickable(this.a.c);
                    o54 o54Var = new o54();
                    o54Var.a = this.a;
                    o54Var.b = imageView;
                    this.b.o.add(o54Var);
                }
            }
        }
    }

    public static void a(q54 q54Var, zm2 zm2Var, m54 m54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, q54Var, zm2Var, m54Var) == null) {
            hx1.i("map", "createControl start");
            if (zm2Var != null && zm2Var.isValid()) {
                ed3.e(zm2Var.b, new a(zm2Var, q54Var, m54Var));
            }
            hx1.i("map", "createControl end");
        }
    }
}
