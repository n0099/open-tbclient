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
/* loaded from: classes8.dex */
public class Z implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ c0 a;

    public Z(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        boolean z;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    this.a.w = (int) motionEvent.getRawX();
                    this.a.x = (int) motionEvent.getRawY();
                    this.a.r = (int) motionEvent.getX();
                    this.a.s = (int) motionEvent.getY();
                    this.a.y = System.currentTimeMillis();
                    Math.abs(motionEvent.getX() - this.a.l);
                    Math.abs(motionEvent.getY() - this.a.m);
                    if (System.currentTimeMillis() - this.a.k < 2000) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        c0 c0Var = this.a;
                        if (c0Var.j && (info = c0Var.c) != null && V1.a(info, c0Var.h)) {
                            this.a.h = System.currentTimeMillis();
                            c0 c0Var2 = this.a;
                            Context context = c0Var2.a;
                            String open = c0Var2.c.getOpen();
                            c0 c0Var3 = this.a;
                            V1.a(context, open, c0Var3.c, c0Var3.g, c0Var3.d().toString());
                            e1.a(this.a.a).a(new f1(this.a.c), (String) null).a("desc", this.a.d().toString()).a();
                            c0 c0Var4 = this.a;
                            M.a(c0Var4.c, c0Var4.d().toString());
                            f fVar = this.a.f;
                            if (fVar != null) {
                                fVar.onClicked();
                            }
                        }
                    }
                }
            } else {
                this.a.j = true;
                this.a.k = System.currentTimeMillis();
                this.a.l = motionEvent.getX();
                this.a.m = motionEvent.getY();
                this.a.n = (int) motionEvent.getRawX();
                this.a.o = (int) motionEvent.getRawY();
                this.a.v = System.currentTimeMillis();
                this.a.p = (int) motionEvent.getX();
                this.a.q = (int) motionEvent.getY();
                c0.a(this.a, view2);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
