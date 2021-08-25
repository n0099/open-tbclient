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
    public final /* synthetic */ d0 f76766a;

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
        this.f76766a = d0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f76766a.f76827j = true;
                this.f76766a.k = System.currentTimeMillis();
                this.f76766a.l = motionEvent.getX();
                this.f76766a.m = motionEvent.getY();
                this.f76766a.n = (int) motionEvent.getRawX();
                this.f76766a.o = (int) motionEvent.getRawY();
                this.f76766a.v = System.currentTimeMillis();
                this.f76766a.p = (int) motionEvent.getX();
                this.f76766a.q = (int) motionEvent.getY();
                d0.a(this.f76766a, view);
            } else if (action == 1) {
                this.f76766a.w = (int) motionEvent.getRawX();
                this.f76766a.x = (int) motionEvent.getRawY();
                this.f76766a.r = (int) motionEvent.getX();
                this.f76766a.s = (int) motionEvent.getY();
                this.f76766a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f76766a.l);
                Math.abs(motionEvent.getY() - this.f76766a.m);
                if (System.currentTimeMillis() - this.f76766a.k < 2000) {
                    d0 d0Var = this.f76766a;
                    if (d0Var.f76827j && (info = d0Var.f76820c) != null && Q1.a(info, d0Var.f76825h)) {
                        this.f76766a.f76825h = System.currentTimeMillis();
                        d0 d0Var2 = this.f76766a;
                        Context context = d0Var2.f76818a;
                        String open = d0Var2.f76820c.getOpen();
                        d0 d0Var3 = this.f76766a;
                        Q1.a(context, open, d0Var3.f76820c, d0Var3.f76824g, d0Var3.d().toString());
                        Z0.a(this.f76766a.f76818a).a(new a1(this.f76766a.f76820c), (String) null).a("desc", this.f76766a.d().toString()).a();
                        d0 d0Var4 = this.f76766a;
                        N.a(d0Var4.f76820c, d0Var4.d().toString());
                        f fVar = this.f76766a.f76823f;
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
