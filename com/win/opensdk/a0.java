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
/* loaded from: classes10.dex */
public class a0 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f76946a;

    public a0(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76946a = d0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f76946a.f77007j = true;
                this.f76946a.k = System.currentTimeMillis();
                this.f76946a.l = motionEvent.getX();
                this.f76946a.m = motionEvent.getY();
                this.f76946a.n = (int) motionEvent.getRawX();
                this.f76946a.o = (int) motionEvent.getRawY();
                this.f76946a.v = System.currentTimeMillis();
                this.f76946a.p = (int) motionEvent.getX();
                this.f76946a.q = (int) motionEvent.getY();
                d0.a(this.f76946a, view);
            } else if (action == 1) {
                this.f76946a.w = (int) motionEvent.getRawX();
                this.f76946a.x = (int) motionEvent.getRawY();
                this.f76946a.r = (int) motionEvent.getX();
                this.f76946a.s = (int) motionEvent.getY();
                this.f76946a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f76946a.l);
                Math.abs(motionEvent.getY() - this.f76946a.m);
                if (System.currentTimeMillis() - this.f76946a.k < 2000) {
                    d0 d0Var = this.f76946a;
                    if (d0Var.f77007j && (info = d0Var.f77000c) != null && Q1.a(info, d0Var.f77005h)) {
                        this.f76946a.f77005h = System.currentTimeMillis();
                        d0 d0Var2 = this.f76946a;
                        Context context = d0Var2.f76998a;
                        String open = d0Var2.f77000c.getOpen();
                        d0 d0Var3 = this.f76946a;
                        Q1.a(context, open, d0Var3.f77000c, d0Var3.f77004g, d0Var3.d().toString());
                        Z0.a(this.f76946a.f76998a).a(new a1(this.f76946a.f77000c), (String) null).a("desc", this.f76946a.d().toString()).a();
                        d0 d0Var4 = this.f76946a;
                        N.a(d0Var4.f77000c, d0Var4.d().toString());
                        f fVar = this.f76946a.f77003f;
                        if (fVar != null) {
                            fVar.onClicked();
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
