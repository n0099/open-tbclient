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
public class no9 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ zo9 a;

    public no9(zo9 zo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zo9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zo9Var;
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
                zo9.d(this.a, view2);
            } else if (action == 1) {
                this.a.w = (int) motionEvent.getRawX();
                this.a.x = (int) motionEvent.getRawY();
                this.a.r = (int) motionEvent.getX();
                this.a.s = (int) motionEvent.getY();
                this.a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.a.l);
                Math.abs(motionEvent.getY() - this.a.m);
                if (System.currentTimeMillis() - this.a.k < 2000) {
                    zo9 zo9Var = this.a;
                    if (zo9Var.j && (info = zo9Var.c) != null && ar9.d(info, zo9Var.h)) {
                        this.a.h = System.currentTimeMillis();
                        zo9 zo9Var2 = this.a;
                        Context context = zo9Var2.a;
                        String open = zo9Var2.c.getOpen();
                        zo9 zo9Var3 = this.a;
                        ar9.a(context, open, zo9Var3.c, zo9Var3.g, zo9Var3.h().toString());
                        yr9 a = cs9.a(this.a.a);
                        a.h(new gs9(this.a.c), null);
                        a.l("desc", this.a.h().toString());
                        a.m();
                        zo9 zo9Var4 = this.a;
                        wp9.p(zo9Var4.c, zo9Var4.h().toString());
                        xo9 xo9Var = this.a.f;
                        if (xo9Var != null) {
                            xo9Var.onClicked();
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
