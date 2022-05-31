package com.repackage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes5.dex */
public class cn9 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ jn9 a;

    public cn9(jn9 jn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jn9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jn9Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.a.j = true;
                this.a.k = System.currentTimeMillis();
                this.a.l = motionEvent.getX();
                this.a.m = motionEvent.getY();
                this.a.n = (int) motionEvent.getRawX();
                this.a.o = (int) motionEvent.getRawY();
                this.a.v = System.currentTimeMillis();
                this.a.p = (int) motionEvent.getX();
                this.a.q = (int) motionEvent.getY();
                jn9.c(this.a, view2);
            } else if (action == 1) {
                this.a.w = (int) motionEvent.getRawX();
                this.a.x = (int) motionEvent.getRawY();
                this.a.r = (int) motionEvent.getX();
                this.a.s = (int) motionEvent.getY();
                this.a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.a.l);
                Math.abs(motionEvent.getY() - this.a.m);
                if (System.currentTimeMillis() - this.a.k < 2000) {
                    jn9 jn9Var = this.a;
                    if (jn9Var.j && (info = jn9Var.c) != null && pm9.d(info, jn9Var.h)) {
                        this.a.h = System.currentTimeMillis();
                        jn9 jn9Var2 = this.a;
                        Context context = jn9Var2.a;
                        String open = jn9Var2.c.getOpen();
                        jn9 jn9Var3 = this.a;
                        pm9.a(context, open, jn9Var3.c, jn9Var3.g, jn9Var3.g().toString());
                        nn9 a = rn9.a(this.a.a);
                        a.h(new vn9(this.a.c), null);
                        a.l("desc", this.a.g().toString());
                        a.m();
                        jn9 jn9Var4 = this.a;
                        ll9.p(jn9Var4.c, jn9Var4.g().toString());
                        xn9 xn9Var = this.a.f;
                        if (xn9Var != null) {
                            xn9Var.onClicked();
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
