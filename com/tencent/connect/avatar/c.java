package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public boolean b;
    public Matrix c;
    public Matrix d;
    public int e;
    public float f;
    public float g;
    public Bitmap h;
    public boolean i;
    public float j;
    public float k;
    public PointF l;
    public PointF m;
    public float n;
    public float o;
    public Rect p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
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
        this.c = new Matrix();
        this.d = new Matrix();
        this.e = 0;
        this.f = 1.0f;
        this.g = 1.0f;
        this.i = false;
        this.a = "TouchView";
        this.l = new PointF();
        this.m = new PointF();
        this.n = 1.0f;
        this.o = 0.0f;
        this.b = false;
        Rect rect = new Rect();
        this.p = rect;
        getDrawingRect(rect);
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Rect rect;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || this.h == null) {
            return;
        }
        float width = this.p.width();
        float height = this.p.height();
        float[] fArr = new float[9];
        this.c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        Animation animation = null;
        float f4 = this.f;
        if (f3 > f4) {
            float f5 = f4 / f3;
            this.o = f5;
            Matrix matrix = this.c;
            PointF pointF = this.m;
            matrix.postScale(f5, f5, pointF.x, pointF.y);
            setImageMatrix(this.c);
            float f6 = this.o;
            float f7 = 1.0f / f6;
            float f8 = 1.0f / f6;
            PointF pointF2 = this.m;
            animation = new ScaleAnimation(f7, 1.0f, f8, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f9 = this.g;
            if (f3 < f9) {
                float f10 = f9 / f3;
                this.o = f10;
                Matrix matrix2 = this.c;
                PointF pointF3 = this.m;
                matrix2.postScale(f10, f10, pointF3.x, pointF3.y);
                float f11 = this.o;
                PointF pointF4 = this.m;
                animation = new ScaleAnimation(1.0f, f11, 1.0f, f11, pointF4.x, pointF4.y);
            } else {
                float width2 = this.h.getWidth() * f3;
                float height2 = this.h.getHeight() * f3;
                int i = this.p.left;
                float f12 = i - f;
                float f13 = rect.top - f2;
                if (f12 < 0.0f) {
                    f = i;
                    z = true;
                } else {
                    z = false;
                }
                if (f13 < 0.0f) {
                    f2 = this.p.top;
                    z = true;
                }
                float f14 = height2 - f13;
                if (width2 - f12 < width) {
                    f = this.p.left - (width2 - width);
                    z = true;
                }
                if (f14 < height) {
                    f2 = this.p.top - (height2 - height);
                    z = true;
                }
                if (z) {
                    fArr[2] = f;
                    fArr[5] = f2;
                    this.c.setValues(fArr);
                    setImageMatrix(this.c);
                    animation = new TranslateAnimation(fArr[2] - f, 0.0f, fArr[5] - f2, 0.0f);
                } else {
                    setImageMatrix(this.c);
                }
            }
        }
        if (animation != null) {
            this.i = true;
            animation.setDuration(300L);
            startAnimation(animation);
            new Thread(new Runnable(this) { // from class: com.tencent.connect.avatar.c.1
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            Thread.sleep(300L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        this.a.post(new Runnable(this) { // from class: com.tencent.connect.avatar.c.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.a.a.clearAnimation();
                                    this.a.a.b();
                                }
                            }
                        });
                        this.a.i = false;
                    }
                }
            }).start();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.h == null) {
            return;
        }
        this.c.getValues(r0);
        float max = Math.max(this.p.width() / this.h.getWidth(), this.p.height() / this.h.getHeight());
        this.j = this.p.left - (((this.h.getWidth() * max) - this.p.width()) / 2.0f);
        float height = this.p.top - (((this.h.getHeight() * max) - this.p.height()) / 2.0f);
        this.k = height;
        float[] fArr = {max, 0.0f, this.j, 0.0f, max, height};
        this.c.setValues(fArr);
        float min = Math.min(2048.0f / this.h.getWidth(), 2048.0f / this.h.getHeight());
        this.f = min;
        this.g = max;
        if (min < max) {
            this.f = max;
        }
        setImageMatrix(this.c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:
        if (r0 != 6) goto L16;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (this.i) {
                return true;
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int i = this.e;
                        if (i == 1) {
                            this.c.set(this.d);
                            this.c.postTranslate(motionEvent.getX() - this.l.x, motionEvent.getY() - this.l.y);
                            setImageMatrix(this.c);
                        } else if (i == 2) {
                            Matrix matrix = this.c;
                            matrix.set(matrix);
                            float a = a(motionEvent);
                            if (a > 10.0f) {
                                this.c.set(this.d);
                                float f = a / this.n;
                                Matrix matrix2 = this.c;
                                PointF pointF = this.m;
                                matrix2.postScale(f, f, pointF.x, pointF.y);
                            }
                            setImageMatrix(this.c);
                        }
                    } else if (action == 5) {
                        float a2 = a(motionEvent);
                        this.n = a2;
                        if (a2 > 10.0f) {
                            this.d.set(this.c);
                            a(this.m);
                            this.e = 2;
                        }
                    }
                }
                b();
                this.e = 0;
            } else {
                this.c.set(getImageMatrix());
                this.d.set(this.c);
                this.l.set(motionEvent.getX(), motionEvent.getY());
                this.e = 1;
            }
            this.b = true;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
            super.setImageBitmap(bitmap);
            this.h = bitmap;
            if (bitmap != null) {
                this.h = bitmap;
            }
        }
    }

    private float a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, motionEvent)) == null) {
            if (motionEvent.getPointerCount() < 2) {
                return 0.0f;
            }
            float x = motionEvent.getX(0) - motionEvent.getX(1);
            float y = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((x * x) + (y * y));
        }
        return invokeL.floatValue;
    }

    public void a(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rect) == null) {
            this.p = rect;
            if (this.h != null) {
                c();
            }
        }
    }

    private void a(PointF pointF) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, pointF) == null) || this.h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float width = this.h.getWidth() * f3;
        float height = this.h.getHeight() * f3;
        float f4 = this.p.left - f;
        if (f4 <= 1.0f) {
            f4 = 1.0f;
        }
        float f5 = (f + width) - this.p.right;
        if (f5 <= 1.0f) {
            f5 = 1.0f;
        }
        float width2 = this.p.width() * f4;
        Rect rect = this.p;
        float f6 = (width2 / (f5 + f4)) + rect.left;
        float f7 = rect.top - f2;
        float f8 = (f2 + height) - rect.bottom;
        if (f7 <= 1.0f) {
            f7 = 1.0f;
        }
        pointF.set(f6, ((this.p.height() * f7) / ((f8 > 1.0f ? f8 : 1.0f) + f7)) + this.p.top);
    }
}
