package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class InstrumentedDrawable extends ForwardingDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsChecked;
    public final Listener mListener;
    public final String mScaleType;

    /* loaded from: classes7.dex */
    public interface Listener {
        void track(int i, int i2, int i3, int i4, int i5, int i6, String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstrumentedDrawable(Drawable drawable, Listener listener) {
        super(drawable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {drawable, listener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Drawable) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsChecked = false;
        this.mListener = listener;
        this.mScaleType = getScaleType(drawable);
    }

    private String getScaleType(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, drawable)) == null) ? drawable instanceof ScaleTypeDrawable ? ((ScaleTypeDrawable) drawable).getScaleType().toString() : "none" : (String) invokeL.objValue;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (!this.mIsChecked) {
                this.mIsChecked = true;
                RectF rectF = new RectF();
                getRootBounds(rectF);
                int width = (int) rectF.width();
                int height = (int) rectF.height();
                getTransformedBounds(rectF);
                int width2 = (int) rectF.width();
                int height2 = (int) rectF.height();
                int intrinsicWidth = getIntrinsicWidth();
                int intrinsicHeight = getIntrinsicHeight();
                Listener listener = this.mListener;
                if (listener != null) {
                    listener.track(width, height, intrinsicWidth, intrinsicHeight, width2, height2, this.mScaleType);
                }
            }
            super.draw(canvas);
        }
    }
}
