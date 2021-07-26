package com.win.opensdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class x1 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A1 f39988a;

    public x1(A1 a1) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a1};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39988a = a1;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f39988a.j = true;
                this.f39988a.k = System.currentTimeMillis();
                this.f39988a.l = motionEvent.getX();
                this.f39988a.m = motionEvent.getY();
                this.f39988a.n = (int) motionEvent.getRawX();
                this.f39988a.o = (int) motionEvent.getRawY();
                this.f39988a.v = System.currentTimeMillis();
                this.f39988a.p = (int) motionEvent.getX();
                this.f39988a.q = (int) motionEvent.getY();
                A1.a(this.f39988a, view);
            } else if (action == 1) {
                this.f39988a.w = (int) motionEvent.getRawX();
                this.f39988a.x = (int) motionEvent.getRawY();
                this.f39988a.r = (int) motionEvent.getX();
                this.f39988a.s = (int) motionEvent.getY();
                this.f39988a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f39988a.l);
                Math.abs(motionEvent.getY() - this.f39988a.m);
                if (System.currentTimeMillis() - this.f39988a.k < 2000) {
                    A1 a1 = this.f39988a;
                    if (a1.j && (info = a1.f39541c) != null && Q1.a(info, a1.f39546h)) {
                        this.f39988a.f39546h = System.currentTimeMillis();
                        A1 a12 = this.f39988a;
                        Context context = a12.f39539a;
                        String open = a12.f39541c.getOpen();
                        A1 a13 = this.f39988a;
                        Q1.a(context, open, a13.f39541c, a13.f39545g, a13.d().toString());
                        Z0.a(this.f39988a.f39539a).a(new a1(this.f39988a.f39541c), (String) null).a("desc", this.f39988a.d().toString()).a();
                        A1 a14 = this.f39988a;
                        N.a(a14.f39541c, a14.d().toString());
                        F f2 = this.f39988a.f39544f;
                        if (f2 != null) {
                            f2.onClicked();
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
