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
/* loaded from: classes4.dex */
public class c extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60416b;

    /* renamed from: c  reason: collision with root package name */
    public Matrix f60417c;

    /* renamed from: d  reason: collision with root package name */
    public Matrix f60418d;

    /* renamed from: e  reason: collision with root package name */
    public int f60419e;

    /* renamed from: f  reason: collision with root package name */
    public float f60420f;

    /* renamed from: g  reason: collision with root package name */
    public float f60421g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f60422h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60423i;

    /* renamed from: j  reason: collision with root package name */
    public float f60424j;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60417c = new Matrix();
        this.f60418d = new Matrix();
        this.f60419e = 0;
        this.f60420f = 1.0f;
        this.f60421g = 1.0f;
        this.f60423i = false;
        this.a = "TouchView";
        this.l = new PointF();
        this.m = new PointF();
        this.n = 1.0f;
        this.o = 0.0f;
        this.f60416b = false;
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
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || this.f60422h == null) {
            return;
        }
        float width = this.p.width();
        float height = this.p.height();
        float[] fArr = new float[9];
        this.f60417c.getValues(fArr);
        float f2 = fArr[2];
        float f3 = fArr[5];
        float f4 = fArr[0];
        Animation animation = null;
        float f5 = this.f60420f;
        if (f4 > f5) {
            float f6 = f5 / f4;
            this.o = f6;
            Matrix matrix = this.f60417c;
            PointF pointF = this.m;
            matrix.postScale(f6, f6, pointF.x, pointF.y);
            setImageMatrix(this.f60417c);
            float f7 = this.o;
            float f8 = 1.0f / f7;
            float f9 = 1.0f / f7;
            PointF pointF2 = this.m;
            animation = new ScaleAnimation(f8, 1.0f, f9, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f10 = this.f60421g;
            if (f4 < f10) {
                float f11 = f10 / f4;
                this.o = f11;
                Matrix matrix2 = this.f60417c;
                PointF pointF3 = this.m;
                matrix2.postScale(f11, f11, pointF3.x, pointF3.y);
                float f12 = this.o;
                PointF pointF4 = this.m;
                animation = new ScaleAnimation(1.0f, f12, 1.0f, f12, pointF4.x, pointF4.y);
            } else {
                float width2 = this.f60422h.getWidth() * f4;
                float height2 = this.f60422h.getHeight() * f4;
                int i2 = this.p.left;
                float f13 = i2 - f2;
                float f14 = rect.top - f3;
                if (f13 < 0.0f) {
                    f2 = i2;
                    z = true;
                } else {
                    z = false;
                }
                if (f14 < 0.0f) {
                    f3 = this.p.top;
                    z = true;
                }
                float f15 = height2 - f14;
                if (width2 - f13 < width) {
                    f2 = this.p.left - (width2 - width);
                    z = true;
                }
                if (f15 < height) {
                    f3 = this.p.top - (height2 - height);
                    z = true;
                }
                if (z) {
                    fArr[2] = f2;
                    fArr[5] = f3;
                    this.f60417c.setValues(fArr);
                    setImageMatrix(this.f60417c);
                    animation = new TranslateAnimation(fArr[2] - f2, 0.0f, fArr[5] - f3, 0.0f);
                } else {
                    setImageMatrix(this.f60417c);
                }
            }
        }
        if (animation != null) {
            this.f60423i = true;
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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            Thread.sleep(300L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
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
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
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
                        this.a.f60423i = false;
                    }
                }
            }).start();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.f60422h == null) {
            return;
        }
        this.f60417c.getValues(r0);
        float max = Math.max(this.p.width() / this.f60422h.getWidth(), this.p.height() / this.f60422h.getHeight());
        this.f60424j = this.p.left - (((this.f60422h.getWidth() * max) - this.p.width()) / 2.0f);
        float height = this.p.top - (((this.f60422h.getHeight() * max) - this.p.height()) / 2.0f);
        this.k = height;
        float[] fArr = {max, 0.0f, this.f60424j, 0.0f, max, height};
        this.f60417c.setValues(fArr);
        float min = Math.min(2048.0f / this.f60422h.getWidth(), 2048.0f / this.f60422h.getHeight());
        this.f60420f = min;
        this.f60421g = max;
        if (min < max) {
            this.f60420f = max;
        }
        setImageMatrix(this.f60417c);
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
            if (this.f60423i) {
                return true;
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int i2 = this.f60419e;
                        if (i2 == 1) {
                            this.f60417c.set(this.f60418d);
                            this.f60417c.postTranslate(motionEvent.getX() - this.l.x, motionEvent.getY() - this.l.y);
                            setImageMatrix(this.f60417c);
                        } else if (i2 == 2) {
                            Matrix matrix = this.f60417c;
                            matrix.set(matrix);
                            float a = a(motionEvent);
                            if (a > 10.0f) {
                                this.f60417c.set(this.f60418d);
                                float f2 = a / this.n;
                                Matrix matrix2 = this.f60417c;
                                PointF pointF = this.m;
                                matrix2.postScale(f2, f2, pointF.x, pointF.y);
                            }
                            setImageMatrix(this.f60417c);
                        }
                    } else if (action == 5) {
                        float a2 = a(motionEvent);
                        this.n = a2;
                        if (a2 > 10.0f) {
                            this.f60418d.set(this.f60417c);
                            a(this.m);
                            this.f60419e = 2;
                        }
                    }
                }
                b();
                this.f60419e = 0;
            } else {
                this.f60417c.set(getImageMatrix());
                this.f60418d.set(this.f60417c);
                this.l.set(motionEvent.getX(), motionEvent.getY());
                this.f60419e = 1;
            }
            this.f60416b = true;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
            super.setImageBitmap(bitmap);
            this.f60422h = bitmap;
            if (bitmap != null) {
                this.f60422h = bitmap;
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
            if (this.f60422h != null) {
                c();
            }
        }
    }

    private void a(PointF pointF) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, pointF) == null) || this.f60422h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.f60417c.getValues(fArr);
        float f2 = fArr[2];
        float f3 = fArr[5];
        float f4 = fArr[0];
        float width = this.f60422h.getWidth() * f4;
        float height = this.f60422h.getHeight() * f4;
        float f5 = this.p.left - f2;
        if (f5 <= 1.0f) {
            f5 = 1.0f;
        }
        float f6 = (f2 + width) - this.p.right;
        if (f6 <= 1.0f) {
            f6 = 1.0f;
        }
        float width2 = this.p.width() * f5;
        Rect rect = this.p;
        float f7 = (width2 / (f6 + f5)) + rect.left;
        float f8 = rect.top - f3;
        float f9 = (f3 + height) - rect.bottom;
        if (f8 <= 1.0f) {
            f8 = 1.0f;
        }
        pointF.set(f7, ((this.p.height() * f8) / ((f9 > 1.0f ? f9 : 1.0f) + f8)) + this.p.top);
    }
}
