package com.fun.ad.sdk.channel.model.baidu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class CustomProgressButton extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Paint b;
    public Paint c;
    public final int d;
    public boolean e;
    public String f;
    public float g;
    public int h;
    public Typeface i;
    public int j;
    public int k;
    public int l;
    public float m;
    public final PorterDuffXfermode n;
    public NativeResponse o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomProgressButton(Context context) {
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
        this.a = -1;
        this.d = Color.parseColor("#3388FF");
        this.e = false;
        this.g = 10.0f;
        this.h = -1;
        this.l = 100;
        this.m = 12.0f;
        this.n = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.d = Color.parseColor("#3388FF");
        this.e = false;
        this.g = 10.0f;
        this.h = -1;
        this.l = 100;
        this.m = 12.0f;
        this.n = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomProgressButton(Context context, AttributeSet attributeSet, int i) {
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
        this.a = -1;
        this.d = Color.parseColor("#3388FF");
        this.e = false;
        this.g = 10.0f;
        this.h = -1;
        this.l = 100;
        this.m = 12.0f;
        this.n = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Paint paint = new Paint();
            this.b = paint;
            paint.setAntiAlias(true);
            this.b.setStrokeWidth(3.0f);
            Paint paint2 = new Paint();
            this.c = paint2;
            paint2.setAntiAlias(true);
            this.c.setColor(this.d);
            this.c.setStrokeWidth(3);
            this.c.setStyle(Paint.Style.STROKE);
            this.c.setStrokeJoin(Paint.Join.ROUND);
        }
    }

    public final void a(Canvas canvas, int i, int i2, int i3, int i4, float f, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), paint}) == null) {
            paint.setAntiAlias(true);
            if (Build.VERSION.SDK_INT >= 21) {
                canvas.drawRoundRect(i, i2, i3, i4, f, f, paint);
            } else {
                canvas.drawRoundRect(new RectF(i, i2, i3, i4), f, f, paint);
            }
        }
    }

    public final void a(Canvas canvas, Paint paint, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, canvas, paint, i) == null) {
            paint.setXfermode(this.n);
            paint.setColor(i);
            a(canvas, 0, 0, (getWidth() * this.a) / this.l, getHeight(), 0.0f, paint);
            paint.setXfermode(null);
        }
    }

    public final void a(Canvas canvas, String str, Paint paint, int i, float f, Typeface typeface) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{canvas, str, paint, Integer.valueOf(i), Float.valueOf(f), typeface}) == null) || canvas == null || paint == null || TextUtils.isEmpty(str)) {
            return;
        }
        paint.setColor(i);
        paint.setTextSize(f);
        if (typeface != null) {
            paint.setTypeface(typeface);
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = fontMetrics.descent;
        canvas.drawText(str, (getMeasuredWidth() - paint.measureText(str)) / 2.0f, ((getHeight() / 2) - f2) + ((f2 - fontMetrics.ascent) / 2.0f), paint);
    }

    public void a(NativeResponse nativeResponse) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nativeResponse) == null) {
            int downloadStatus = nativeResponse.getDownloadStatus();
            if (downloadStatus < 0) {
                this.a = this.l;
                if (nativeResponse.getAdActionType() == 2) {
                    str = "立即下载";
                    this.f = str;
                    postInvalidate();
                }
                str = "查看详情";
                this.f = str;
                postInvalidate();
            }
            if (downloadStatus < 101) {
                this.f = downloadStatus + "%";
                this.a = downloadStatus;
            } else {
                if (downloadStatus == 101) {
                    this.a = this.l;
                    if (nativeResponse.getAdActionType() == 2) {
                        str = "点击安装";
                    }
                    str = "查看详情";
                } else if (downloadStatus == 102) {
                    str = "继续下载";
                } else if (downloadStatus == 104) {
                    this.f = "重新下载";
                    this.a = this.l;
                }
                this.f = str;
            }
            postInvalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (motionEvent.getActionMasked() == 1) {
                int downloadStatus = this.o.getDownloadStatus();
                if (downloadStatus <= 0 || downloadStatus >= 101) {
                    performClick();
                    a(this.o);
                    return false;
                }
                this.o.pauseAppDownload();
                a(this.o);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.k = i;
        }
    }

    public void setCornerRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.m = i;
        }
    }

    public void setForegroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.j = i;
        }
    }

    public void setMax(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || i <= 0) {
            return;
        }
        this.l = i;
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || i > this.l) {
            return;
        }
        this.a = i;
        postInvalidate();
    }

    public void setStroke(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.e = z;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f = str;
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.h = i;
        }
    }

    public void setTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.g = i;
        }
    }

    public void setTypeFace(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, typeface) == null) {
            this.i = typeface;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            int i = this.a;
            if (i >= 0 && i < this.l) {
                Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                this.b.setColor(this.k);
                a(canvas2, 0, 0, getWidth(), getHeight(), this.m, this.b);
                a(canvas2, this.b, this.j);
                canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
                if (!createBitmap.isRecycled()) {
                    createBitmap.recycle();
                }
                if (!TextUtils.isEmpty(this.f)) {
                    Bitmap createBitmap2 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(createBitmap2);
                    a(canvas3, this.f, this.b, this.j, this.g, this.i);
                    a(canvas3, this.b, this.h);
                    canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
                    if (!createBitmap2.isRecycled()) {
                        createBitmap2.recycle();
                        return;
                    }
                    return;
                }
                return;
            }
            this.b.setColor(this.j);
            a(canvas, 0, 0, getWidth(), getHeight(), this.m, this.b);
            if (this.e) {
                a(canvas, 1, 1, getWidth() - 1, getHeight() - 1, this.m, this.c);
            }
            a(canvas, this.f, this.b, this.h, this.g, this.i);
        }
    }
}
