package com.sina.weibo.sdk.web.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class WbSdkProgressBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean addStart;
    public double growTime;
    public double growTimeMax;
    public Handler handler;
    public long lastTime;
    public float length;
    public final int maxLength;
    public final int minLength;
    public int miniSize;
    public int padding;
    public Paint paint;
    public int paintWidth;
    public float progress;
    public RectF rect;
    public boolean showView;
    public float speed;
    public long stopGrowTime;
    public long stopGrowTimeMax;
    public int stopNum;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WbSdkProgressBar(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WbSdkProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WbSdkProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.minLength = 20;
        this.maxLength = 300;
        this.lastTime = 0L;
        this.speed = 200.0f;
        this.stopGrowTimeMax = 180L;
        this.stopGrowTime = 0L;
        this.growTimeMax = 490.0d;
        this.addStart = false;
        this.showView = true;
        this.stopNum = 0;
        this.handler = new Handler(this) { // from class: com.sina.weibo.sdk.web.view.WbSdkProgressBar.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WbSdkProgressBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    super.handleMessage(message);
                    if (message.what != 0) {
                        return;
                    }
                    this.this$0.showView = false;
                }
            }
        };
        this.miniSize = dip2px(context, 50);
        this.paintWidth = dip2px(context, 5);
        this.padding = dip2px(context, 3);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setColor(-48861);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.paintWidth);
        int i4 = this.padding;
        int i5 = this.miniSize;
        this.rect = new RectF(i4, i4, i5 - i4, i5 - i4);
    }

    private int dip2px(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, this, context, i)) == null) {
            return (int) (context.getResources().getDisplayMetrics().density * i);
        }
        return invokeLI.intValue;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int i3 = this.miniSize;
            setMeasuredDimension(i3, i3);
        }
    }

    private void calculateProgress(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j) == null) {
            long j2 = this.stopGrowTime;
            if (j2 >= this.stopGrowTimeMax) {
                double d = this.growTime + j;
                this.growTime = d;
                double d2 = this.growTimeMax;
                if (d >= d2) {
                    this.growTime = d - d2;
                    this.stopGrowTime = 0L;
                    this.addStart = !this.addStart;
                }
                float cos = (((float) Math.cos(((this.growTime / this.growTimeMax) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
                if (!this.addStart) {
                    this.length = cos * 280;
                    return;
                }
                float f = 280 * (1.0f - cos);
                this.progress += this.length - f;
                this.length = f;
                return;
            }
            this.stopGrowTime = j2 + j;
        }
    }

    @Override // android.view.View
    public synchronized void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            synchronized (this) {
                long abs = Math.abs(SystemClock.uptimeMillis() - this.lastTime) % 360;
                calculateProgress(abs);
                this.lastTime = SystemClock.uptimeMillis();
                float f = this.progress + ((this.speed * ((float) abs)) / 1000.0f);
                this.progress = f;
                if (f >= 360.0f) {
                    this.progress = f - 360.0f;
                }
                canvas.drawArc(this.rect, this.progress - 90.0f, this.length + 20.0f, false, this.paint);
                if (this.showView) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        postInvalidate();
                    } else {
                        invalidate();
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view2, i) == null) {
            super.onVisibilityChanged(view2, i);
            if (i == 8) {
                this.handler.sendEmptyMessageDelayed(0, 1000L);
            } else if (i == 0 && getVisibility() == 0) {
                this.handler.removeMessages(0);
                this.showView = true;
                invalidate();
            }
        }
    }

    public void setProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.paint.setColor(i);
        }
    }
}
