package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class MistView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int MASK_COLOR_DEFAULT_TRANSPARENT;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f55950e;

    /* renamed from: f  reason: collision with root package name */
    public int f55951f;

    /* renamed from: g  reason: collision with root package name */
    public final Rect f55952g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1619293700, "Lcom/dxmpay/wallet/base/widget/MistView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1619293700, "Lcom/dxmpay/wallet/base/widget/MistView;");
                return;
            }
        }
        MASK_COLOR_DEFAULT_TRANSPARENT = Color.argb(127, 0, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55952g = new Rect();
        this.f55950e = new Paint();
        this.f55951f = MASK_COLOR_DEFAULT_TRANSPARENT;
    }

    public Rect getFocusFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55952g : (Rect) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.f55950e.setColor(this.f55951f);
            if (this.f55952g.width() == 0) {
                return;
            }
            float f2 = width;
            canvas.drawRect(0.0f, 0.0f, f2, this.f55952g.top, this.f55950e);
            Rect rect = this.f55952g;
            canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.f55950e);
            Rect rect2 = this.f55952g;
            canvas.drawRect(rect2.right, rect2.top, f2, rect2.bottom, this.f55950e);
            canvas.drawRect(0.0f, this.f55952g.bottom, f2, height, this.f55950e);
            Rect rect3 = this.f55952g;
            postInvalidateDelayed(100L, rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
    }

    public void setMistColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f55951f = i2;
            postInvalidate();
        }
    }
}
