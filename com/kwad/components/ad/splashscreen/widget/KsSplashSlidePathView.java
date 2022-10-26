package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class KsSplashSlidePathView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Path Be;
    public Paint Bf;
    public float Bg;
    public float Bh;
    public float Bi;
    public float Bj;
    public int Bk;
    public a Bl;
    public GestureDetector kE;

    /* loaded from: classes7.dex */
    public interface a {
        void a(float f, float f2, float f3, float f4);

        void kt();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsSplashSlidePathView(Context context) {
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
        this.Bk = Color.parseColor("#66ffffff");
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsSplashSlidePathView(Context context, AttributeSet attributeSet) {
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
        this.Bk = Color.parseColor("#66ffffff");
        init();
    }

    private void a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, motionEvent) == null) || this.kE.onTouchEvent(motionEvent)) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.Be.reset();
            this.Bg = motionEvent.getX();
            float y = motionEvent.getY();
            this.Bh = y;
            float f = this.Bg;
            this.Bi = f;
            this.Bj = y;
            this.Be.moveTo(f, y);
            invalidate();
            if (this.Bl != null) {
            }
        } else if (actionMasked != 1) {
            if (actionMasked != 2) {
                return;
            }
            b(motionEvent.getX(), motionEvent.getY());
            invalidate();
        } else {
            this.Be.reset();
            invalidate();
            a aVar = this.Bl;
            if (aVar != null) {
                aVar.a(this.Bg, this.Bh, motionEvent.getX(), motionEvent.getY());
            }
        }
    }

    private void b(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            float abs = Math.abs(f - this.Bi);
            float abs2 = Math.abs(f2 - this.Bj);
            if (abs >= 3.0f || abs2 >= 3.0f) {
                Path path = this.Be;
                float f3 = this.Bi;
                float f4 = this.Bj;
                path.quadTo(f3, f4, (f + f3) / 2.0f, (f2 + f4) / 2.0f);
                this.Bi = f;
                this.Bj = f2;
            }
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.Be = new Path();
            Paint paint = new Paint();
            this.Bf = paint;
            paint.setStrokeCap(Paint.Cap.ROUND);
            this.Bf.setStrokeWidth(com.kwad.sdk.b.kwai.a.a(getContext(), 15.0f));
            this.Bf.setStyle(Paint.Style.STROKE);
            this.Bf.setColor(this.Bk);
            this.Bf.setDither(true);
            this.kE = new GestureDetector(new GestureDetector.OnGestureListener(this) { // from class: com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsSplashSlidePathView Bm;

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
                    this.Bm = this;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final boolean onDown(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, motionEvent)) == null) {
                        return false;
                    }
                    return invokeL.booleanValue;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                        return false;
                    }
                    return invokeCommon.booleanValue;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final void onLongPress(MotionEvent motionEvent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
                    }
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                        return false;
                    }
                    return invokeCommon.booleanValue;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final void onShowPress(MotionEvent motionEvent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, motionEvent) == null) {
                    }
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public final boolean onSingleTapUp(MotionEvent motionEvent) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048581, this, motionEvent)) == null) {
                        if (this.Bm.Bl != null) {
                            this.Bm.Bl.kt();
                            return true;
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.onDraw(canvas);
            canvas.drawPath(this.Be, this.Bf);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            a(motionEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setOnSlideTouchListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.Bl = aVar;
        }
    }
}
