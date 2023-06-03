package com.fun.module.gdt;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class p extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public int c;
    public int d;
    public int e;
    public float f;
    public float g;
    public final int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
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
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(10.0f);
        setBackgroundDrawable(gradientDrawable);
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(true);
        }
        this.c = i;
        this.h = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onAttachedToWindow();
            post(new a(this));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
        if (r3 > r4) goto L17;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.a = getX() - motionEvent.getRawX();
                this.b = getY() - motionEvent.getRawY();
                this.f = 0.0f;
                this.g = 0.0f;
            } else if (action == 1) {
                float f = this.d;
                if ((motionEvent.getRawX() + this.a) * 2.0f <= f) {
                    f = this.c;
                }
                animate().x(f).setDuration(0L).start();
                float f2 = this.f;
                float f3 = this.h;
                if (f2 > f3 || this.g > f3) {
                    return true;
                }
            } else if (action == 2) {
                float rawX = motionEvent.getRawX() + this.a;
                float rawY = motionEvent.getRawY() + this.b;
                this.f += Math.abs(rawX - getX());
                this.g += Math.abs(rawY - getY());
                int i = this.c;
                float f4 = i;
                if (rawX < f4) {
                    rawX = f4;
                } else {
                    float f5 = this.d;
                    if (rawX > f5) {
                        rawX = f5;
                    }
                }
                if (rawY >= f4) {
                    i = this.e;
                }
                rawY = i;
                animate().x(rawX).y(rawY).setDuration(0L).start();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p a;

        public a(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (view2 = (View) this.a.getParent()) == null) {
                return;
            }
            int width = view2.getWidth();
            int height = view2.getHeight();
            p pVar = this.a;
            int height2 = height - pVar.getHeight();
            p pVar2 = this.a;
            pVar.e = height2 - pVar2.c;
            pVar2.d = (width - pVar2.getWidth()) - this.a.c;
        }
    }
}
