package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;
    public Paint b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.b = new Paint();
        }
    }

    public Rect a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null) {
                this.a = new Rect();
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                int min = Math.min(Math.min((measuredHeight - 60) - 80, measuredWidth), 640);
                int i = (measuredWidth - min) / 2;
                int i2 = (measuredHeight - min) / 2;
                this.a.set(i, i2, i + min, min + i2);
            }
            return this.a;
        }
        return (Rect) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            Rect a = a();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.b.setStyle(Paint.Style.FILL);
            this.b.setColor(Color.argb(100, 0, 0, 0));
            float f = measuredWidth;
            canvas.drawRect(0.0f, 0.0f, f, a.top, this.b);
            canvas.drawRect(0.0f, a.bottom, f, measuredHeight, this.b);
            canvas.drawRect(0.0f, a.top, a.left, a.bottom, this.b);
            canvas.drawRect(a.right, a.top, f, a.bottom, this.b);
            canvas.drawColor(Color.argb(100, 0, 0, 0));
            this.b.setStyle(Paint.Style.STROKE);
            this.b.setColor(-1);
            canvas.drawRect(a.left, a.top, a.right - 1, a.bottom, this.b);
        }
    }
}
