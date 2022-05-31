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
public class ck9 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ok9 a;

    public ck9(ok9 ok9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ok9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ok9Var;
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
                ok9.d(this.a, view2);
            } else if (action == 1) {
                this.a.w = (int) motionEvent.getRawX();
                this.a.x = (int) motionEvent.getRawY();
                this.a.r = (int) motionEvent.getX();
                this.a.s = (int) motionEvent.getY();
                this.a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.a.l);
                Math.abs(motionEvent.getY() - this.a.m);
                if (System.currentTimeMillis() - this.a.k < 2000) {
                    ok9 ok9Var = this.a;
                    if (ok9Var.j && (info = ok9Var.c) != null && pm9.d(info, ok9Var.h)) {
                        this.a.h = System.currentTimeMillis();
                        ok9 ok9Var2 = this.a;
                        Context context = ok9Var2.a;
                        String open = ok9Var2.c.getOpen();
                        ok9 ok9Var3 = this.a;
                        pm9.a(context, open, ok9Var3.c, ok9Var3.g, ok9Var3.h().toString());
                        nn9 a = rn9.a(this.a.a);
                        a.h(new vn9(this.a.c), null);
                        a.l("desc", this.a.h().toString());
                        a.m();
                        ok9 ok9Var4 = this.a;
                        ll9.p(ok9Var4.c, ok9Var4.h().toString());
                        mk9 mk9Var = this.a.f;
                        if (mk9Var != null) {
                            mk9Var.onClicked();
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
