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
    public final /* synthetic */ E0 f76584a;

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
        this.f76584a = e0;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f76584a.f76610j = true;
                this.f76584a.k = System.currentTimeMillis();
                this.f76584a.l = motionEvent.getX();
                this.f76584a.m = motionEvent.getY();
                this.f76584a.n = (int) motionEvent.getRawX();
                this.f76584a.o = (int) motionEvent.getRawY();
                this.f76584a.p = (int) motionEvent.getX();
                this.f76584a.q = (int) motionEvent.getY();
                this.f76584a.v = System.currentTimeMillis();
                E0.a(this.f76584a, view);
            } else if (action == 1) {
                this.f76584a.w = (int) motionEvent.getRawX();
                this.f76584a.x = (int) motionEvent.getRawY();
                this.f76584a.r = (int) motionEvent.getX();
                this.f76584a.s = (int) motionEvent.getY();
                this.f76584a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f76584a.l);
                Math.abs(motionEvent.getY() - this.f76584a.m);
                if (System.currentTimeMillis() - this.f76584a.k < 2000) {
                    E0 e0 = this.f76584a;
                    if (e0.f76610j && (info = e0.f76603c) != null && Q1.a(info, e0.f76608h)) {
                        this.f76584a.f76608h = System.currentTimeMillis();
                        E0 e02 = this.f76584a;
                        Context context = e02.f76601a;
                        String open = e02.f76603c.getOpen();
                        E0 e03 = this.f76584a;
                        Q1.a(context, open, e03.f76603c, e03.f76607g, e03.d().toString());
                        Z0.a(this.f76584a.f76601a).a(new a1(this.f76584a.f76603c), (String) null).a("desc", this.f76584a.d().toString()).a();
                        E0 e04 = this.f76584a;
                        N.a(e04.f76603c, e04.d().toString());
                        PBNativeListener pBNativeListener = this.f76584a.f76606f;
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
