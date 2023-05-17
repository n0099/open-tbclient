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
public class A0 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ D0 a;

    public A0(D0 d0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d0;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        boolean z;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    this.a.w = (int) motionEvent.getRawX();
                    this.a.x = (int) motionEvent.getRawY();
                    this.a.r = (int) motionEvent.getX();
                    this.a.s = (int) motionEvent.getY();
                    this.a.y = System.currentTimeMillis();
                    Math.abs(motionEvent.getX() - this.a.l);
                    Math.abs(motionEvent.getY() - this.a.m);
                    if (System.currentTimeMillis() - this.a.k < 2000) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        D0 d0 = this.a;
                        if (d0.j && (info = d0.c) != null && V1.a(info, d0.h)) {
                            this.a.h = System.currentTimeMillis();
                            D0 d02 = this.a;
                            Context context = d02.a;
                            String open = d02.c.getOpen();
                            D0 d03 = this.a;
                            V1.a(context, open, d03.c, d03.g, d03.d().toString());
                            e1.a(this.a.a).a(new f1(this.a.c), (String) null).a("desc", this.a.d().toString()).a();
                            D0 d04 = this.a;
                            M.a(d04.c, d04.d().toString());
                            PBNativeListener pBNativeListener = this.a.f;
                            if (pBNativeListener != null) {
                                pBNativeListener.onClicked();
                            }
                        }
                    }
                }
            } else {
                this.a.j = true;
                this.a.k = System.currentTimeMillis();
                this.a.l = motionEvent.getX();
                this.a.m = motionEvent.getY();
                this.a.n = (int) motionEvent.getRawX();
                this.a.o = (int) motionEvent.getRawY();
                this.a.p = (int) motionEvent.getX();
                this.a.q = (int) motionEvent.getY();
                this.a.v = System.currentTimeMillis();
                D0.a(this.a, view2);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
