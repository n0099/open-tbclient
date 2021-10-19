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
    public final /* synthetic */ E0 f77118a;

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
        this.f77118a = e0;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f77118a.f77144j = true;
                this.f77118a.k = System.currentTimeMillis();
                this.f77118a.l = motionEvent.getX();
                this.f77118a.m = motionEvent.getY();
                this.f77118a.n = (int) motionEvent.getRawX();
                this.f77118a.o = (int) motionEvent.getRawY();
                this.f77118a.p = (int) motionEvent.getX();
                this.f77118a.q = (int) motionEvent.getY();
                this.f77118a.v = System.currentTimeMillis();
                E0.a(this.f77118a, view);
            } else if (action == 1) {
                this.f77118a.w = (int) motionEvent.getRawX();
                this.f77118a.x = (int) motionEvent.getRawY();
                this.f77118a.r = (int) motionEvent.getX();
                this.f77118a.s = (int) motionEvent.getY();
                this.f77118a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f77118a.l);
                Math.abs(motionEvent.getY() - this.f77118a.m);
                if (System.currentTimeMillis() - this.f77118a.k < 2000) {
                    E0 e0 = this.f77118a;
                    if (e0.f77144j && (info = e0.f77137c) != null && Q1.a(info, e0.f77142h)) {
                        this.f77118a.f77142h = System.currentTimeMillis();
                        E0 e02 = this.f77118a;
                        Context context = e02.f77135a;
                        String open = e02.f77137c.getOpen();
                        E0 e03 = this.f77118a;
                        Q1.a(context, open, e03.f77137c, e03.f77141g, e03.d().toString());
                        Z0.a(this.f77118a.f77135a).a(new a1(this.f77118a.f77137c), (String) null).a("desc", this.f77118a.d().toString()).a();
                        E0 e04 = this.f77118a;
                        N.a(e04.f77137c, e04.d().toString());
                        PBNativeListener pBNativeListener = this.f77118a.f77140f;
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
