package com.tachikoma.core.component.text;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.utility.ScheduleHandler;
import com.tachikoma.core.utility.SizeUtil;
/* loaded from: classes8.dex */
public class MarqueeTextView extends TextView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MARQUEE_DP_PER_SECOND = 12;
    public static final int MARQUEE_INTERVAL = 48;
    public static final int PADDING;
    public transient /* synthetic */ FieldHolder $fh;
    public float mBaseLine;
    public boolean mIsStoped;
    public ScheduleHandler mProgressUpdateHandler;
    public float mScroll;
    public final float mSpeed;
    public String mText;
    public float mTextStartOffset;
    public float mTextWidth;
    public int mWidth;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1810663905, "Lcom/tachikoma/core/component/text/MarqueeTextView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1810663905, "Lcom/tachikoma/core/component/text/MarqueeTextView;");
                return;
            }
        }
        PADDING = SizeUtil.dp2Px(20);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mIsStoped = true;
        this.mSpeed = ((context.getResources().getDisplayMetrics().density * 12.0f) * 48.0f) / 1000.0f;
    }

    private float getScrollInitialValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? -this.mTextStartOffset : invokeV.floatValue;
    }

    private void initProgressUpdateHandler() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.mProgressUpdateHandler == null) {
            this.mProgressUpdateHandler = new ScheduleHandler(48L, new Runnable(this) { // from class: com.tachikoma.core.component.text.MarqueeTextView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MarqueeTextView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mIsStoped) {
                        return;
                    }
                    this.this$0.mScroll += this.this$0.mSpeed;
                    if (this.this$0.mScroll > this.this$0.mTextWidth + MarqueeTextView.PADDING) {
                        this.this$0.mScroll -= this.this$0.mTextWidth + MarqueeTextView.PADDING;
                    }
                    this.this$0.postInvalidate();
                }
            });
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.onDraw(canvas);
            this.mWidth = getWidth();
            if (TextUtils.isEmpty(this.mText) || this.mTextWidth <= 0.0f || this.mWidth <= 0) {
                return;
            }
            float f = -this.mScroll;
            while (f < this.mWidth) {
                canvas.drawText(this.mText, f, this.mBaseLine, getPaint());
                f += this.mTextWidth + PADDING;
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            this.mBaseLine = (int) ((getHeight() / 2) - ((getPaint().descent() + getPaint().ascent()) / 2.0f));
        }
    }

    public void pauseMarquee() {
        ScheduleHandler scheduleHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (scheduleHandler = this.mProgressUpdateHandler) == null) {
            return;
        }
        scheduleHandler.stop();
        this.mIsStoped = true;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mText = null;
            stopMarquee();
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = this.mText;
        if (str2 == null || !str2.equals(str)) {
            this.mText = str;
            this.mTextWidth = getPaint().measureText(this.mText);
        }
        initProgressUpdateHandler();
        postInvalidate();
        startMarquee();
    }

    public void setText(String str, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048581, this, str, f) == null) {
            this.mTextStartOffset = f;
            this.mScroll = -f;
            setText(str);
        }
    }

    public void startMarquee() {
        ScheduleHandler scheduleHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (scheduleHandler = this.mProgressUpdateHandler) == null || scheduleHandler.isRunning()) {
            return;
        }
        this.mProgressUpdateHandler.start();
        this.mIsStoped = false;
    }

    public void stopMarquee() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            pauseMarquee();
            if (this.mScroll != getScrollInitialValue()) {
                this.mScroll = getScrollInitialValue();
                postInvalidate();
            }
        }
    }
}
