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
public class V0 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f39507a;

    public V0(Y0 y0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39507a = y0;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f39507a.j = true;
                this.f39507a.k = System.currentTimeMillis();
                this.f39507a.l = motionEvent.getX();
                this.f39507a.m = motionEvent.getY();
                this.f39507a.n = (int) motionEvent.getRawX();
                this.f39507a.o = (int) motionEvent.getRawY();
                this.f39507a.v = System.currentTimeMillis();
                this.f39507a.p = (int) motionEvent.getX();
                this.f39507a.q = (int) motionEvent.getY();
                Y0.a(this.f39507a, view);
            } else if (action == 1) {
                this.f39507a.w = (int) motionEvent.getRawX();
                this.f39507a.x = (int) motionEvent.getRawY();
                this.f39507a.r = (int) motionEvent.getX();
                this.f39507a.s = (int) motionEvent.getY();
                this.f39507a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f39507a.l);
                Math.abs(motionEvent.getY() - this.f39507a.m);
                if (System.currentTimeMillis() - this.f39507a.k < 2000) {
                    Y0 y0 = this.f39507a;
                    if (y0.j && (info = y0.f39522c) != null && o1.a(info, y0.f39527h)) {
                        this.f39507a.f39527h = System.currentTimeMillis();
                        Y0 y02 = this.f39507a;
                        Context context = y02.f39520a;
                        String open = y02.f39522c.getOpen();
                        Y0 y03 = this.f39507a;
                        o1.a(context, open, y03.f39522c, y03.f39526g, y03.d().toString());
                        x0.a(this.f39507a.f39520a).a(new y0(this.f39507a.f39522c), (String) null).a("desc", this.f39507a.d().toString()).a();
                        Y0 y04 = this.f39507a;
                        z.a(y04.f39522c, y04.d().toString());
                        r rVar = this.f39507a.f39525f;
                        if (rVar != null) {
                            rVar.onClicked();
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
