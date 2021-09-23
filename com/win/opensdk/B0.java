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
public class B0 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ E0 f77083a;

    public B0(E0 e0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77083a = e0;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f77083a.f77109j = true;
                this.f77083a.k = System.currentTimeMillis();
                this.f77083a.l = motionEvent.getX();
                this.f77083a.m = motionEvent.getY();
                this.f77083a.n = (int) motionEvent.getRawX();
                this.f77083a.o = (int) motionEvent.getRawY();
                this.f77083a.p = (int) motionEvent.getX();
                this.f77083a.q = (int) motionEvent.getY();
                this.f77083a.v = System.currentTimeMillis();
                E0.a(this.f77083a, view);
            } else if (action == 1) {
                this.f77083a.w = (int) motionEvent.getRawX();
                this.f77083a.x = (int) motionEvent.getRawY();
                this.f77083a.r = (int) motionEvent.getX();
                this.f77083a.s = (int) motionEvent.getY();
                this.f77083a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f77083a.l);
                Math.abs(motionEvent.getY() - this.f77083a.m);
                if (System.currentTimeMillis() - this.f77083a.k < 2000) {
                    E0 e0 = this.f77083a;
                    if (e0.f77109j && (info = e0.f77102c) != null && Q1.a(info, e0.f77107h)) {
                        this.f77083a.f77107h = System.currentTimeMillis();
                        E0 e02 = this.f77083a;
                        Context context = e02.f77100a;
                        String open = e02.f77102c.getOpen();
                        E0 e03 = this.f77083a;
                        Q1.a(context, open, e03.f77102c, e03.f77106g, e03.d().toString());
                        Z0.a(this.f77083a.f77100a).a(new a1(this.f77083a.f77102c), (String) null).a("desc", this.f77083a.d().toString()).a();
                        E0 e04 = this.f77083a;
                        N.a(e04.f77102c, e04.d().toString());
                        PBNativeListener pBNativeListener = this.f77083a.f77105f;
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
