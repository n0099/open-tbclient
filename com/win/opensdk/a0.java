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
public class a0 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f39725a;

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
        this.f39725a = d0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f39725a.j = true;
                this.f39725a.k = System.currentTimeMillis();
                this.f39725a.l = motionEvent.getX();
                this.f39725a.m = motionEvent.getY();
                this.f39725a.n = (int) motionEvent.getRawX();
                this.f39725a.o = (int) motionEvent.getRawY();
                this.f39725a.v = System.currentTimeMillis();
                this.f39725a.p = (int) motionEvent.getX();
                this.f39725a.q = (int) motionEvent.getY();
                d0.a(this.f39725a, view);
            } else if (action == 1) {
                this.f39725a.w = (int) motionEvent.getRawX();
                this.f39725a.x = (int) motionEvent.getRawY();
                this.f39725a.r = (int) motionEvent.getX();
                this.f39725a.s = (int) motionEvent.getY();
                this.f39725a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f39725a.l);
                Math.abs(motionEvent.getY() - this.f39725a.m);
                if (System.currentTimeMillis() - this.f39725a.k < 2000) {
                    d0 d0Var = this.f39725a;
                    if (d0Var.j && (info = d0Var.f39779c) != null && Q1.a(info, d0Var.f39784h)) {
                        this.f39725a.f39784h = System.currentTimeMillis();
                        d0 d0Var2 = this.f39725a;
                        Context context = d0Var2.f39777a;
                        String open = d0Var2.f39779c.getOpen();
                        d0 d0Var3 = this.f39725a;
                        Q1.a(context, open, d0Var3.f39779c, d0Var3.f39783g, d0Var3.d().toString());
                        Z0.a(this.f39725a.f39777a).a(new a1(this.f39725a.f39779c), (String) null).a("desc", this.f39725a.d().toString()).a();
                        d0 d0Var4 = this.f39725a;
                        N.a(d0Var4.f39779c, d0Var4.d().toString());
                        f fVar = this.f39725a.f39782f;
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
