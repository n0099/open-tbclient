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
/* loaded from: classes6.dex */
public class in9 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ un9 a;

    public in9(un9 un9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {un9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = un9Var;
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
                un9.d(this.a, view2);
            } else if (action == 1) {
                this.a.w = (int) motionEvent.getRawX();
                this.a.x = (int) motionEvent.getRawY();
                this.a.r = (int) motionEvent.getX();
                this.a.s = (int) motionEvent.getY();
                this.a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.a.l);
                Math.abs(motionEvent.getY() - this.a.m);
                if (System.currentTimeMillis() - this.a.k < 2000) {
                    un9 un9Var = this.a;
                    if (un9Var.j && (info = un9Var.c) != null && vp9.d(info, un9Var.h)) {
                        this.a.h = System.currentTimeMillis();
                        un9 un9Var2 = this.a;
                        Context context = un9Var2.a;
                        String open = un9Var2.c.getOpen();
                        un9 un9Var3 = this.a;
                        vp9.a(context, open, un9Var3.c, un9Var3.g, un9Var3.h().toString());
                        tq9 a = xq9.a(this.a.a);
                        a.h(new br9(this.a.c), null);
                        a.l("desc", this.a.h().toString());
                        a.m();
                        un9 un9Var4 = this.a;
                        ro9.p(un9Var4.c, un9Var4.h().toString());
                        sn9 sn9Var = this.a.f;
                        if (sn9Var != null) {
                            sn9Var.onClicked();
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
