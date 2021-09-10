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
    public final /* synthetic */ A1 f77220a;

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
        this.f77220a = a1;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f77220a.f76763j = true;
                this.f77220a.k = System.currentTimeMillis();
                this.f77220a.l = motionEvent.getX();
                this.f77220a.m = motionEvent.getY();
                this.f77220a.n = (int) motionEvent.getRawX();
                this.f77220a.o = (int) motionEvent.getRawY();
                this.f77220a.v = System.currentTimeMillis();
                this.f77220a.p = (int) motionEvent.getX();
                this.f77220a.q = (int) motionEvent.getY();
                A1.a(this.f77220a, view);
            } else if (action == 1) {
                this.f77220a.w = (int) motionEvent.getRawX();
                this.f77220a.x = (int) motionEvent.getRawY();
                this.f77220a.r = (int) motionEvent.getX();
                this.f77220a.s = (int) motionEvent.getY();
                this.f77220a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f77220a.l);
                Math.abs(motionEvent.getY() - this.f77220a.m);
                if (System.currentTimeMillis() - this.f77220a.k < 2000) {
                    A1 a1 = this.f77220a;
                    if (a1.f76763j && (info = a1.f76756c) != null && Q1.a(info, a1.f76761h)) {
                        this.f77220a.f76761h = System.currentTimeMillis();
                        A1 a12 = this.f77220a;
                        Context context = a12.f76754a;
                        String open = a12.f76756c.getOpen();
                        A1 a13 = this.f77220a;
                        Q1.a(context, open, a13.f76756c, a13.f76760g, a13.d().toString());
                        Z0.a(this.f77220a.f76754a).a(new a1(this.f77220a.f76756c), (String) null).a("desc", this.f77220a.d().toString()).a();
                        A1 a14 = this.f77220a;
                        N.a(a14.f76756c, a14.d().toString());
                        F f2 = this.f77220a.f76759f;
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
