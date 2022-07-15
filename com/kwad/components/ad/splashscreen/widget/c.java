package com.kwad.components.ad.splashscreen.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class c extends AnimationDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap a;
    public Bitmap b;
    public Bitmap c;
    public Bitmap d;
    public Bitmap e;
    public Bitmap f;
    public int g;
    public RectF h;
    public Paint i;
    public Paint j;
    public PorterDuffXfermode k;
    public final int l;
    public final int m;
    public float n;
    public float o;
    public RectF p;
    public Paint q;
    public int r;
    public int s;
    public ValueAnimator t;
    public final float u;
    public final float v;
    public float w;
    public float x;
    public Context y;
    public int z;

    public c(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = 6.0f;
        this.v = 11.0f;
        this.y = context;
        this.l = com.kwad.sdk.b.kwai.a.a(context, 51.0f);
        this.m = com.kwad.sdk.b.kwai.a.a(context, 61.0f);
        this.z = i;
        a();
    }

    private void a() {
        float f;
        float f2;
        Matrix matrix;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.a = BitmapFactory.decodeResource(this.y.getResources(), R.drawable.obfuscated_res_0x7f080c38);
            this.b = BitmapFactory.decodeResource(this.y.getResources(), R.drawable.obfuscated_res_0x7f080c3a);
            this.c = BitmapFactory.decodeResource(this.y.getResources(), R.drawable.obfuscated_res_0x7f080c39);
            this.d = BitmapFactory.decodeResource(this.y.getResources(), R.drawable.obfuscated_res_0x7f080c3c);
            this.e = BitmapFactory.decodeResource(this.y.getResources(), R.drawable.obfuscated_res_0x7f080c3b);
            Bitmap decodeResource = BitmapFactory.decodeResource(this.y.getResources(), R.drawable.obfuscated_res_0x7f080c41);
            int i = this.z;
            if (i != 0) {
                if (i == 1) {
                    matrix = new Matrix();
                    f3 = 270.0f;
                } else if (i == 2) {
                    matrix = new Matrix();
                    f3 = 90.0f;
                }
                matrix.postRotate(f3);
                this.f = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true);
            } else {
                this.f = decodeResource;
            }
            this.g = com.kwad.sdk.b.kwai.a.a(this.y, 10.0f);
            this.q = new Paint(1);
            int i2 = this.z;
            if (i2 == 0) {
                this.s = (int) this.y.getResources().getDimension(R.dimen.obfuscated_res_0x7f0703fc);
                int dimension = (int) this.y.getResources().getDimension(R.dimen.obfuscated_res_0x7f0703fd);
                this.r = dimension;
                this.n = (-this.m) * 0.22f;
                f = dimension;
                f2 = 0.08f;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    this.s = (int) this.y.getResources().getDimension(R.dimen.obfuscated_res_0x7f0703fd);
                    this.r = (int) this.y.getResources().getDimension(R.dimen.obfuscated_res_0x7f0703fc);
                    this.n = this.s * 0.09f;
                    f = -this.l;
                    f2 = 0.5f;
                }
                this.p = new RectF(0.0f, 0.0f, this.r, this.s);
                this.i = new Paint(3);
                Paint paint = new Paint(3);
                this.j = paint;
                paint.setDither(true);
                float f4 = this.p.right;
                this.h = new RectF(f4 - this.l, 0.0f, f4, this.m);
                this.k = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
                this.t = ofFloat;
                ofFloat.setDuration(1100L);
                this.t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.components.ad.splashscreen.widget.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                            this.a.w = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            c cVar = this.a;
                            cVar.a(cVar.w);
                            this.a.invalidateSelf();
                        }
                    }
                });
                this.t.setRepeatCount(-1);
            } else {
                this.s = (int) this.y.getResources().getDimension(R.dimen.obfuscated_res_0x7f0703fd);
                this.r = (int) this.y.getResources().getDimension(R.dimen.obfuscated_res_0x7f0703fc);
                this.n = this.s * 0.09f;
                f = -this.l;
                f2 = 0.2f;
            }
            this.o = f * f2;
            this.p = new RectF(0.0f, 0.0f, this.r, this.s);
            this.i = new Paint(3);
            Paint paint2 = new Paint(3);
            this.j = paint2;
            paint2.setDither(true);
            float f42 = this.p.right;
            this.h = new RectF(f42 - this.l, 0.0f, f42, this.m);
            this.k = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
            this.t = ofFloat2;
            ofFloat2.setDuration(1100L);
            this.t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.components.ad.splashscreen.widget.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        this.a.w = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        c cVar = this.a;
                        cVar.a(cVar.w);
                        this.a.invalidateSelf();
                    }
                }
            });
            this.t.setRepeatCount(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, this, f) == null) || f > 6.0f) {
            return;
        }
        float f2 = f / 6.0f;
        int i = this.z;
        if (i == 0) {
            RectF rectF = this.p;
            float f3 = this.s * (1.0f - f2);
            rectF.top = f3;
            this.h.offsetTo(rectF.left + this.o, f3 + this.n);
            this.x = (f2 * 30.0f) + 290.0f;
        } else if (i == 1) {
            RectF rectF2 = this.p;
            float f4 = 1.0f - f2;
            float f5 = this.r * f4;
            rectF2.left = f5;
            this.h.offsetTo(f5 + this.o, rectF2.top + this.n);
            this.x = f4 * 30.0f;
        } else if (i != 2) {
        } else {
            RectF rectF3 = this.p;
            float f6 = this.r * f2;
            rectF3.right = f6;
            this.h.offsetTo(f6 + this.o, rectF3.top + this.n);
            this.x = (f2 * 30.0f) + 330.0f;
        }
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(@NonNull Canvas canvas) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.p == null) {
            return;
        }
        canvas.save();
        canvas.translate((getIntrinsicWidth() - this.r) / 2, (getIntrinsicHeight() - this.s) / 2);
        float f = this.w;
        if (f <= 6.0f) {
            this.q.setAlpha((int) ((f * 255.0f) / 6.0f));
            this.j.setAlpha(255);
        } else {
            int i = (int) ((1.0f - ((f - 6.0f) / 5.0f)) * 255.0f);
            this.q.setAlpha(i);
            this.j.setAlpha(i);
        }
        int save = canvas.save();
        int saveLayer = canvas.saveLayer(this.p, this.q, 31);
        canvas.drawBitmap(this.f, (Rect) null, this.p, this.q);
        canvas.rotate(this.x, this.h.centerX(), this.h.centerY());
        this.i.setXfermode(this.k);
        int i2 = this.z;
        if (i2 != 0) {
            if (i2 == 1) {
                canvas.drawBitmap(this.b, (Rect) null, this.h, this.i);
                bitmap = this.c;
            }
            canvas.drawBitmap(this.a, (Rect) null, this.h, this.i);
            canvas.restoreToCount(saveLayer);
            canvas.rotate(this.x, this.h.centerX(), this.h.centerY());
            canvas.drawBitmap(this.a, (Rect) null, this.h, this.j);
            canvas.restoreToCount(save);
            canvas.restore();
        }
        canvas.drawBitmap(this.d, (Rect) null, this.h, this.i);
        bitmap = this.e;
        canvas.drawBitmap(bitmap, (Rect) null, this.h, this.i);
        canvas.drawBitmap(this.a, (Rect) null, this.h, this.i);
        canvas.restoreToCount(saveLayer);
        canvas.rotate(this.x, this.h.centerX(), this.h.centerY());
        canvas.drawBitmap(this.a, (Rect) null, this.h, this.j);
        canvas.restoreToCount(save);
        canvas.restore();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s + this.m + this.g : invokeV.intValue;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.r + this.l : invokeV.intValue;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return -2;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ValueAnimator valueAnimator = this.t;
            if (valueAnimator != null) {
                return valueAnimator.isRunning();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (valueAnimator = this.t) == null) {
            return;
        }
        valueAnimator.start();
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void stop() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (valueAnimator = this.t) == null) {
            return;
        }
        valueAnimator.cancel();
    }
}
