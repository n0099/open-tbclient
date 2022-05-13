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
public class iq9 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ pq9 a;

    public iq9(pq9 pq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pq9Var;
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
                pq9.c(this.a, view2);
            } else if (action == 1) {
                this.a.w = (int) motionEvent.getRawX();
                this.a.x = (int) motionEvent.getRawY();
                this.a.r = (int) motionEvent.getX();
                this.a.s = (int) motionEvent.getY();
                this.a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.a.l);
                Math.abs(motionEvent.getY() - this.a.m);
                if (System.currentTimeMillis() - this.a.k < 2000) {
                    pq9 pq9Var = this.a;
                    if (pq9Var.j && (info = pq9Var.c) != null && vp9.d(info, pq9Var.h)) {
                        this.a.h = System.currentTimeMillis();
                        pq9 pq9Var2 = this.a;
                        Context context = pq9Var2.a;
                        String open = pq9Var2.c.getOpen();
                        pq9 pq9Var3 = this.a;
                        vp9.a(context, open, pq9Var3.c, pq9Var3.g, pq9Var3.g().toString());
                        tq9 a = xq9.a(this.a.a);
                        a.h(new br9(this.a.c), null);
                        a.l("desc", this.a.g().toString());
                        a.m();
                        pq9 pq9Var4 = this.a;
                        ro9.p(pq9Var4.c, pq9Var4.g().toString());
                        dr9 dr9Var = this.a.f;
                        if (dr9Var != null) {
                            dr9Var.onClicked();
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
