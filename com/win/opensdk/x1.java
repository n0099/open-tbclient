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
public class x1 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A1 f77539a;

    public x1(A1 a1) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a1};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77539a = a1;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f77539a.f77082j = true;
                this.f77539a.k = System.currentTimeMillis();
                this.f77539a.l = motionEvent.getX();
                this.f77539a.m = motionEvent.getY();
                this.f77539a.n = (int) motionEvent.getRawX();
                this.f77539a.o = (int) motionEvent.getRawY();
                this.f77539a.v = System.currentTimeMillis();
                this.f77539a.p = (int) motionEvent.getX();
                this.f77539a.q = (int) motionEvent.getY();
                A1.a(this.f77539a, view);
            } else if (action == 1) {
                this.f77539a.w = (int) motionEvent.getRawX();
                this.f77539a.x = (int) motionEvent.getRawY();
                this.f77539a.r = (int) motionEvent.getX();
                this.f77539a.s = (int) motionEvent.getY();
                this.f77539a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f77539a.l);
                Math.abs(motionEvent.getY() - this.f77539a.m);
                if (System.currentTimeMillis() - this.f77539a.k < 2000) {
                    A1 a1 = this.f77539a;
                    if (a1.f77082j && (info = a1.f77075c) != null && Q1.a(info, a1.f77080h)) {
                        this.f77539a.f77080h = System.currentTimeMillis();
                        A1 a12 = this.f77539a;
                        Context context = a12.f77073a;
                        String open = a12.f77075c.getOpen();
                        A1 a13 = this.f77539a;
                        Q1.a(context, open, a13.f77075c, a13.f77079g, a13.d().toString());
                        Z0.a(this.f77539a.f77073a).a(new a1(this.f77539a.f77075c), (String) null).a("desc", this.f77539a.d().toString()).a();
                        A1 a14 = this.f77539a;
                        N.a(a14.f77075c, a14.d().toString());
                        F f2 = this.f77539a.f77078f;
                        if (f2 != null) {
                            f2.onClicked();
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
