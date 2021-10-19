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
    public final /* synthetic */ d0 f77300a;

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
        this.f77300a = d0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f77300a.f77361j = true;
                this.f77300a.k = System.currentTimeMillis();
                this.f77300a.l = motionEvent.getX();
                this.f77300a.m = motionEvent.getY();
                this.f77300a.n = (int) motionEvent.getRawX();
                this.f77300a.o = (int) motionEvent.getRawY();
                this.f77300a.v = System.currentTimeMillis();
                this.f77300a.p = (int) motionEvent.getX();
                this.f77300a.q = (int) motionEvent.getY();
                d0.a(this.f77300a, view);
            } else if (action == 1) {
                this.f77300a.w = (int) motionEvent.getRawX();
                this.f77300a.x = (int) motionEvent.getRawY();
                this.f77300a.r = (int) motionEvent.getX();
                this.f77300a.s = (int) motionEvent.getY();
                this.f77300a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f77300a.l);
                Math.abs(motionEvent.getY() - this.f77300a.m);
                if (System.currentTimeMillis() - this.f77300a.k < 2000) {
                    d0 d0Var = this.f77300a;
                    if (d0Var.f77361j && (info = d0Var.f77354c) != null && Q1.a(info, d0Var.f77359h)) {
                        this.f77300a.f77359h = System.currentTimeMillis();
                        d0 d0Var2 = this.f77300a;
                        Context context = d0Var2.f77352a;
                        String open = d0Var2.f77354c.getOpen();
                        d0 d0Var3 = this.f77300a;
                        Q1.a(context, open, d0Var3.f77354c, d0Var3.f77358g, d0Var3.d().toString());
                        Z0.a(this.f77300a.f77352a).a(new a1(this.f77300a.f77354c), (String) null).a("desc", this.f77300a.d().toString()).a();
                        d0 d0Var4 = this.f77300a;
                        N.a(d0Var4.f77354c, d0Var4.d().toString());
                        f fVar = this.f77300a.f77357f;
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
