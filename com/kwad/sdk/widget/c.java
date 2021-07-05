package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
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
        setIncludeFontPadding(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            if (compoundDrawables != null && compoundDrawables.length > 3 && (drawable = compoundDrawables[2]) != null) {
                float measureText = getPaint().measureText(getText().toString()) + drawable.getIntrinsicWidth() + getCompoundDrawablePadding();
                setPadding(0, 0, (int) (getWidth() - measureText), 0);
                canvas.translate((getWidth() - measureText) / 2.0f, 0.0f);
            }
            super.onDraw(canvas);
        }
    }
}
