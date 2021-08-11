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
    public final /* synthetic */ d0 f76565a;

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
        this.f76565a = d0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f76565a.f76626j = true;
                this.f76565a.k = System.currentTimeMillis();
                this.f76565a.l = motionEvent.getX();
                this.f76565a.m = motionEvent.getY();
                this.f76565a.n = (int) motionEvent.getRawX();
                this.f76565a.o = (int) motionEvent.getRawY();
                this.f76565a.v = System.currentTimeMillis();
                this.f76565a.p = (int) motionEvent.getX();
                this.f76565a.q = (int) motionEvent.getY();
                d0.a(this.f76565a, view);
            } else if (action == 1) {
                this.f76565a.w = (int) motionEvent.getRawX();
                this.f76565a.x = (int) motionEvent.getRawY();
                this.f76565a.r = (int) motionEvent.getX();
                this.f76565a.s = (int) motionEvent.getY();
                this.f76565a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f76565a.l);
                Math.abs(motionEvent.getY() - this.f76565a.m);
                if (System.currentTimeMillis() - this.f76565a.k < 2000) {
                    d0 d0Var = this.f76565a;
                    if (d0Var.f76626j && (info = d0Var.f76619c) != null && Q1.a(info, d0Var.f76624h)) {
                        this.f76565a.f76624h = System.currentTimeMillis();
                        d0 d0Var2 = this.f76565a;
                        Context context = d0Var2.f76617a;
                        String open = d0Var2.f76619c.getOpen();
                        d0 d0Var3 = this.f76565a;
                        Q1.a(context, open, d0Var3.f76619c, d0Var3.f76623g, d0Var3.d().toString());
                        Z0.a(this.f76565a.f76617a).a(new a1(this.f76565a.f76619c), (String) null).a("desc", this.f76565a.d().toString()).a();
                        d0 d0Var4 = this.f76565a;
                        N.a(d0Var4.f76619c, d0Var4.d().toString());
                        f fVar = this.f76565a.f76622f;
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
