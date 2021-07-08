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
/* loaded from: classes6.dex */
public class f0 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f39576a;

    public f0(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39576a = i0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f39576a.j = true;
                this.f39576a.k = System.currentTimeMillis();
                this.f39576a.l = motionEvent.getX();
                this.f39576a.m = motionEvent.getY();
                this.f39576a.n = (int) motionEvent.getRawX();
                this.f39576a.o = (int) motionEvent.getRawY();
                this.f39576a.p = (int) motionEvent.getX();
                this.f39576a.q = (int) motionEvent.getY();
                this.f39576a.v = System.currentTimeMillis();
                i0.a(this.f39576a, view);
            } else if (action == 1) {
                this.f39576a.w = (int) motionEvent.getRawX();
                this.f39576a.x = (int) motionEvent.getRawY();
                this.f39576a.r = (int) motionEvent.getX();
                this.f39576a.s = (int) motionEvent.getY();
                this.f39576a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f39576a.l);
                Math.abs(motionEvent.getY() - this.f39576a.m);
                if (System.currentTimeMillis() - this.f39576a.k < 2000) {
                    i0 i0Var = this.f39576a;
                    if (i0Var.j && (info = i0Var.f39595c) != null && o1.a(info, i0Var.f39600h)) {
                        this.f39576a.f39600h = System.currentTimeMillis();
                        i0 i0Var2 = this.f39576a;
                        Context context = i0Var2.f39593a;
                        String open = i0Var2.f39595c.getOpen();
                        i0 i0Var3 = this.f39576a;
                        o1.a(context, open, i0Var3.f39595c, i0Var3.f39599g, i0Var3.d().toString());
                        x0.a(this.f39576a.f39593a).a(new y0(this.f39576a.f39595c), (String) null).a("desc", this.f39576a.d().toString()).a();
                        i0 i0Var4 = this.f39576a;
                        z.a(i0Var4.f39595c, i0Var4.d().toString());
                        PBNativeListener pBNativeListener = this.f39576a.f39598f;
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
