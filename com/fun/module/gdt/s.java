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
/* loaded from: classes6.dex */
public class s extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f38645b;

    /* renamed from: c  reason: collision with root package name */
    public int f38646c;

    /* renamed from: d  reason: collision with root package name */
    public int f38647d;

    /* renamed from: e  reason: collision with root package name */
    public int f38648e;

    /* renamed from: f  reason: collision with root package name */
    public float f38649f;

    /* renamed from: g  reason: collision with root package name */
    public float f38650g;

    /* renamed from: h  reason: collision with root package name */
    public final int f38651h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s a;

        public a(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (view = (View) this.a.getParent()) == null) {
                return;
            }
            int width = view.getWidth();
            int height = view.getHeight();
            s sVar = this.a;
            int height2 = height - sVar.getHeight();
            s sVar2 = this.a;
            sVar.f38648e = height2 - sVar2.f38646c;
            sVar2.f38647d = (width - sVar2.getWidth()) - this.a.f38646c;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Context context, int i) {
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
        this.f38646c = i;
        this.f38651h = ViewConfiguration.get(context).getScaledTouchSlop();
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
                this.f38645b = getY() - motionEvent.getRawY();
                this.f38649f = 0.0f;
                this.f38650g = 0.0f;
            } else if (action == 1) {
                float f2 = this.f38647d;
                if ((motionEvent.getRawX() + this.a) * 2.0f <= f2) {
                    f2 = this.f38646c;
                }
                animate().x(f2).setDuration(0L).start();
                float f3 = this.f38649f;
                float f4 = this.f38651h;
                if (f3 > f4 || this.f38650g > f4) {
                    return true;
                }
            } else if (action == 2) {
                float rawX = motionEvent.getRawX() + this.a;
                float rawY = motionEvent.getRawY() + this.f38645b;
                this.f38649f += Math.abs(rawX - getX());
                this.f38650g += Math.abs(rawY - getY());
                int i = this.f38646c;
                float f5 = i;
                if (rawX < f5) {
                    rawX = f5;
                } else {
                    float f6 = this.f38647d;
                    if (rawX > f6) {
                        rawX = f6;
                    }
                }
                if (rawY >= f5) {
                    i = this.f38648e;
                }
                rawY = i;
                animate().x(rawX).y(rawY).setDuration(0L).start();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
