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
public class B0 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ E0 f39548a;

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
        this.f39548a = e0;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f39548a.j = true;
                this.f39548a.k = System.currentTimeMillis();
                this.f39548a.l = motionEvent.getX();
                this.f39548a.m = motionEvent.getY();
                this.f39548a.n = (int) motionEvent.getRawX();
                this.f39548a.o = (int) motionEvent.getRawY();
                this.f39548a.p = (int) motionEvent.getX();
                this.f39548a.q = (int) motionEvent.getY();
                this.f39548a.v = System.currentTimeMillis();
                E0.a(this.f39548a, view);
            } else if (action == 1) {
                this.f39548a.w = (int) motionEvent.getRawX();
                this.f39548a.x = (int) motionEvent.getRawY();
                this.f39548a.r = (int) motionEvent.getX();
                this.f39548a.s = (int) motionEvent.getY();
                this.f39548a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f39548a.l);
                Math.abs(motionEvent.getY() - this.f39548a.m);
                if (System.currentTimeMillis() - this.f39548a.k < 2000) {
                    E0 e0 = this.f39548a;
                    if (e0.j && (info = e0.f39567c) != null && Q1.a(info, e0.f39572h)) {
                        this.f39548a.f39572h = System.currentTimeMillis();
                        E0 e02 = this.f39548a;
                        Context context = e02.f39565a;
                        String open = e02.f39567c.getOpen();
                        E0 e03 = this.f39548a;
                        Q1.a(context, open, e03.f39567c, e03.f39571g, e03.d().toString());
                        Z0.a(this.f39548a.f39565a).a(new a1(this.f39548a.f39567c), (String) null).a("desc", this.f39548a.d().toString()).a();
                        E0 e04 = this.f39548a;
                        N.a(e04.f39567c, e04.d().toString());
                        PBNativeListener pBNativeListener = this.f39548a.f39570f;
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
