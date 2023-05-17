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
public class C1 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ F1 a;

    public C1(F1 f1) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f1};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = f1;
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
                        F1 f1 = this.a;
                        if (f1.j && (info = f1.c) != null && V1.a(info, f1.h)) {
                            this.a.h = System.currentTimeMillis();
                            F1 f12 = this.a;
                            Context context = f12.a;
                            String open = f12.c.getOpen();
                            F1 f13 = this.a;
                            V1.a(context, open, f13.c, f13.g, f13.d().toString());
                            e1.a(this.a.a).a(new f1(this.a.c), (String) null).a("desc", this.a.d().toString()).a();
                            F1 f14 = this.a;
                            M.a(f14.c, f14.d().toString());
                            E e = this.a.f;
                            if (e != null) {
                                e.onClicked();
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
                this.a.v = System.currentTimeMillis();
                this.a.p = (int) motionEvent.getX();
                this.a.q = (int) motionEvent.getY();
                F1.a(this.a, view2);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
