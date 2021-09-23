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
    public final /* synthetic */ d0 f77265a;

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
        this.f77265a = d0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f77265a.f77326j = true;
                this.f77265a.k = System.currentTimeMillis();
                this.f77265a.l = motionEvent.getX();
                this.f77265a.m = motionEvent.getY();
                this.f77265a.n = (int) motionEvent.getRawX();
                this.f77265a.o = (int) motionEvent.getRawY();
                this.f77265a.v = System.currentTimeMillis();
                this.f77265a.p = (int) motionEvent.getX();
                this.f77265a.q = (int) motionEvent.getY();
                d0.a(this.f77265a, view);
            } else if (action == 1) {
                this.f77265a.w = (int) motionEvent.getRawX();
                this.f77265a.x = (int) motionEvent.getRawY();
                this.f77265a.r = (int) motionEvent.getX();
                this.f77265a.s = (int) motionEvent.getY();
                this.f77265a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f77265a.l);
                Math.abs(motionEvent.getY() - this.f77265a.m);
                if (System.currentTimeMillis() - this.f77265a.k < 2000) {
                    d0 d0Var = this.f77265a;
                    if (d0Var.f77326j && (info = d0Var.f77319c) != null && Q1.a(info, d0Var.f77324h)) {
                        this.f77265a.f77324h = System.currentTimeMillis();
                        d0 d0Var2 = this.f77265a;
                        Context context = d0Var2.f77317a;
                        String open = d0Var2.f77319c.getOpen();
                        d0 d0Var3 = this.f77265a;
                        Q1.a(context, open, d0Var3.f77319c, d0Var3.f77323g, d0Var3.d().toString());
                        Z0.a(this.f77265a.f77317a).a(new a1(this.f77265a.f77319c), (String) null).a("desc", this.f77265a.d().toString()).a();
                        d0 d0Var4 = this.f77265a;
                        N.a(d0Var4.f77319c, d0Var4.d().toString());
                        f fVar = this.f77265a.f77322f;
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
