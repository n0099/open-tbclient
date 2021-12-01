package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class DownloadProgressBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f59677b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f59678c;

    /* renamed from: d  reason: collision with root package name */
    public Path f59679d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f59680e;

    /* renamed from: f  reason: collision with root package name */
    public String f59681f;

    /* renamed from: g  reason: collision with root package name */
    public float f59682g;

    /* renamed from: h  reason: collision with root package name */
    public Rect f59683h;

    /* renamed from: i  reason: collision with root package name */
    public LinearGradient f59684i;

    /* renamed from: j  reason: collision with root package name */
    public LinearGradient f59685j;

    /* renamed from: k  reason: collision with root package name */
    public LinearGradient f59686k;
    public long l;
    public Matrix m;
    public Runnable n;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadProgressBar(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.n = new Runnable(this) { // from class: com.kwad.sdk.widget.DownloadProgressBar.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DownloadProgressBar a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.invalidate();
                    if (this.a.getWindowVisibility() == 0) {
                        this.a.postDelayed(this, 34L);
                    }
                }
            }
        };
        this.a = new Paint(1);
        this.f59677b = new Paint(1);
        this.f59680e = new RectF();
        Paint paint = new Paint(1);
        this.f59678c = paint;
        paint.setTextSize(com.kwad.sdk.a.kwai.a.a(context, 16.0f));
        this.f59678c.setColor(-1);
        this.f59678c.setTextAlign(Paint.Align.CENTER);
        this.f59683h = new Rect();
        this.m = new Matrix();
        this.f59679d = new Path();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onDetachedFromWindow();
            removeCallbacks(this.n);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.clipPath(this.f59679d);
            this.a.setShader(this.f59684i);
            canvas.drawRect(this.f59680e, this.a);
            this.a.setShader(this.f59685j);
            canvas.drawRect(0.0f, 0.0f, (getWidth() * this.f59682g) / 100.0f, getHeight(), this.a);
            float f2 = this.f59682g;
            float f3 = 0.0f;
            if (f2 > 0.0f && f2 < 100.0f) {
                long elapsedRealtime = (SystemClock.elapsedRealtime() - this.l) % TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS;
                int i2 = (elapsedRealtime > 1500L ? 1 : (elapsedRealtime == 1500L ? 0 : -1));
                float f4 = i2 >= 0 ? 0.0f : ((float) elapsedRealtime) / 1500.0f;
                this.m.reset();
                this.m.setScale(1.0f, f4);
                this.f59686k.setLocalMatrix(this.m);
                this.f59677b.setShader(this.f59686k);
                canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.f59682g) / 100.0f) * f4, getHeight(), this.f59677b);
                if (elapsedRealtime > 500 && i2 <= 0) {
                    f3 = ((float) (elapsedRealtime - 500)) / 1000.0f;
                }
                float width = ((getWidth() * this.f59682g) / 100.0f) * f3;
                this.m.reset();
                this.m.setScale(1.0f, f4);
                this.f59686k.setLocalMatrix(this.m);
                this.f59677b.setShader(this.f59686k);
                canvas.drawRect(0.0f, 0.0f, width, getHeight(), this.f59677b);
            }
            String str = this.f59681f;
            if (str != null) {
                this.f59678c.getTextBounds(str, 0, str.length(), this.f59683h);
                Rect rect = this.f59683h;
                canvas.drawText(this.f59681f, getWidth() / 2.0f, (getHeight() / 2.0f) - ((rect.top + rect.bottom) / 2.0f), this.f59678c);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.f59684i = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
            this.f59685j = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
            this.a.setShader(this.f59684i);
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
            this.f59686k = linearGradient;
            this.f59677b.setShader(linearGradient);
            float f2 = i2;
            this.f59680e.set(0.0f, 0.0f, f2, i3);
            this.f59679d.reset();
            float f3 = f2 / 2.0f;
            this.f59679d.addRoundRect(this.f59680e, f3, f3, Path.Direction.CW);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view, i2) == null) {
            super.onVisibilityChanged(view, i2);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (i2 != 0) {
                removeCallbacks(this.n);
                return;
            }
            float f2 = this.f59682g;
            if (f2 <= 0.0f || f2 >= 100.0f) {
                return;
            }
            this.l = SystemClock.elapsedRealtime();
            post(this.n);
        }
    }

    public void setProgress(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.f59682g = f2;
            invalidate();
            if (f2 == 0.0f || f2 == 100.0f) {
                removeCallbacks(this.n);
            } else if (getWindowVisibility() == 0 && this.l == 0) {
                post(this.n);
            }
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f59681f = str;
            invalidate();
        }
    }
}
