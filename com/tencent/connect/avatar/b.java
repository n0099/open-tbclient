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
/* loaded from: classes10.dex */
public class b extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Rect f76538a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f76539b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.f76539b = new Paint();
        }
    }

    public Rect a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f76538a == null) {
                this.f76538a = new Rect();
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                int min = Math.min(Math.min((measuredHeight - 60) - 80, measuredWidth), 640);
                int i2 = (measuredWidth - min) / 2;
                int i3 = (measuredHeight - min) / 2;
                this.f76538a.set(i2, i3, i2 + min, min + i3);
            }
            return this.f76538a;
        }
        return (Rect) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            Rect a2 = a();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.f76539b.setStyle(Paint.Style.FILL);
            this.f76539b.setColor(Color.argb(100, 0, 0, 0));
            float f2 = measuredWidth;
            canvas.drawRect(0.0f, 0.0f, f2, a2.top, this.f76539b);
            canvas.drawRect(0.0f, a2.bottom, f2, measuredHeight, this.f76539b);
            canvas.drawRect(0.0f, a2.top, a2.left, a2.bottom, this.f76539b);
            canvas.drawRect(a2.right, a2.top, f2, a2.bottom, this.f76539b);
            canvas.drawColor(Color.argb(100, 0, 0, 0));
            this.f76539b.setStyle(Paint.Style.STROKE);
            this.f76539b.setColor(-1);
            canvas.drawRect(a2.left, a2.top, a2.right - 1, a2.bottom, this.f76539b);
        }
    }
}
