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
/* loaded from: classes7.dex */
public class f0 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f42562a;

    public f0(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42562a = i0Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f42562a.j = true;
                this.f42562a.k = System.currentTimeMillis();
                this.f42562a.l = motionEvent.getX();
                this.f42562a.m = motionEvent.getY();
                this.f42562a.n = (int) motionEvent.getRawX();
                this.f42562a.o = (int) motionEvent.getRawY();
                this.f42562a.p = (int) motionEvent.getX();
                this.f42562a.q = (int) motionEvent.getY();
                this.f42562a.v = System.currentTimeMillis();
                i0.a(this.f42562a, view);
            } else if (action == 1) {
                this.f42562a.w = (int) motionEvent.getRawX();
                this.f42562a.x = (int) motionEvent.getRawY();
                this.f42562a.r = (int) motionEvent.getX();
                this.f42562a.s = (int) motionEvent.getY();
                this.f42562a.y = System.currentTimeMillis();
                Math.abs(motionEvent.getX() - this.f42562a.l);
                Math.abs(motionEvent.getY() - this.f42562a.m);
                if (System.currentTimeMillis() - this.f42562a.k < 2000) {
                    i0 i0Var = this.f42562a;
                    if (i0Var.j && (info = i0Var.f42581c) != null && o1.a(info, i0Var.f42586h)) {
                        this.f42562a.f42586h = System.currentTimeMillis();
                        i0 i0Var2 = this.f42562a;
                        Context context = i0Var2.f42579a;
                        String open = i0Var2.f42581c.getOpen();
                        i0 i0Var3 = this.f42562a;
                        o1.a(context, open, i0Var3.f42581c, i0Var3.f42585g, i0Var3.d().toString());
                        x0.a(this.f42562a.f42579a).a(new y0(this.f42562a.f42581c), (String) null).a("desc", this.f42562a.d().toString()).a();
                        i0 i0Var4 = this.f42562a;
                        z.a(i0Var4.f42581c, i0Var4.d().toString());
                        PBNativeListener pBNativeListener = this.f42562a.f42584f;
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
