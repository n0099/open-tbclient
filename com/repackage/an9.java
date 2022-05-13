package com.repackage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBNativeListener;
import com.win.opensdk.core.Info;
/* loaded from: classes5.dex */
public class an9 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ln9 a;

    public an9(ln9 ln9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ln9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ln9Var;
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
                this.a.p = (int) motionEvent.getX();
                this.a.q = (int) motionEvent.getY();
                this.a.v = System.currentTimeMillis();
                ln9.e(this.a, view2);
            } else if (action == 1) {
                this.a.w = (int) motionEvent.getRawX();
                this.a.x = (int) motionEvent.getRawY();
                this.a.r = (int) motionEvent.getX();
                this.a.s = (int) motionEvent.getY();
                this.a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.a.l);
                Math.abs(motionEvent.getY() - this.a.m);
                if (System.currentTimeMillis() - this.a.k < 2000) {
                    ln9 ln9Var = this.a;
                    if (ln9Var.j && (info = ln9Var.c) != null && vp9.d(info, ln9Var.h)) {
                        this.a.h = System.currentTimeMillis();
                        ln9 ln9Var2 = this.a;
                        Context context = ln9Var2.a;
                        String open = ln9Var2.c.getOpen();
                        ln9 ln9Var3 = this.a;
                        vp9.a(context, open, ln9Var3.c, ln9Var3.g, ln9Var3.i().toString());
                        tq9 a = xq9.a(this.a.a);
                        a.h(new br9(this.a.c), null);
                        a.l("desc", this.a.i().toString());
                        a.m();
                        ln9 ln9Var4 = this.a;
                        ro9.p(ln9Var4.c, ln9Var4.i().toString());
                        PBNativeListener pBNativeListener = this.a.f;
                        if (pBNativeListener != null) {
                            pBNativeListener.onClicked();
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
