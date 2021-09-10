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
    public final /* synthetic */ E0 f76764a;

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
        this.f76764a = e0;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f76764a.f76790j = true;
                this.f76764a.k = System.currentTimeMillis();
                this.f76764a.l = motionEvent.getX();
                this.f76764a.m = motionEvent.getY();
                this.f76764a.n = (int) motionEvent.getRawX();
                this.f76764a.o = (int) motionEvent.getRawY();
                this.f76764a.p = (int) motionEvent.getX();
                this.f76764a.q = (int) motionEvent.getY();
                this.f76764a.v = System.currentTimeMillis();
                E0.a(this.f76764a, view);
            } else if (action == 1) {
                this.f76764a.w = (int) motionEvent.getRawX();
                this.f76764a.x = (int) motionEvent.getRawY();
                this.f76764a.r = (int) motionEvent.getX();
                this.f76764a.s = (int) motionEvent.getY();
                this.f76764a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f76764a.l);
                Math.abs(motionEvent.getY() - this.f76764a.m);
                if (System.currentTimeMillis() - this.f76764a.k < 2000) {
                    E0 e0 = this.f76764a;
                    if (e0.f76790j && (info = e0.f76783c) != null && Q1.a(info, e0.f76788h)) {
                        this.f76764a.f76788h = System.currentTimeMillis();
                        E0 e02 = this.f76764a;
                        Context context = e02.f76781a;
                        String open = e02.f76783c.getOpen();
                        E0 e03 = this.f76764a;
                        Q1.a(context, open, e03.f76783c, e03.f76787g, e03.d().toString());
                        Z0.a(this.f76764a.f76781a).a(new a1(this.f76764a.f76783c), (String) null).a("desc", this.f76764a.d().toString()).a();
                        E0 e04 = this.f76764a;
                        N.a(e04.f76783c, e04.d().toString());
                        PBNativeListener pBNativeListener = this.f76764a.f76786f;
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
