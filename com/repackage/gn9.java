package com.repackage;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class gn9 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public long c;
    public int d;
    public int e;
    public long f;
    public final /* synthetic */ jn9 g;

    public gn9(jn9 jn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jn9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = jn9Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.a));
            hashMap.put("dy", Integer.valueOf(this.b));
            hashMap.put("dts", Long.valueOf(this.c));
            hashMap.put("ux", Integer.valueOf(this.d));
            hashMap.put("uy", Integer.valueOf(this.e));
            hashMap.put("uts", Long.valueOf(this.f));
            jn9 jn9Var = this.g;
            ll9.j(hashMap, jn9Var.p, jn9Var.q, jn9Var.r, jn9Var.s, jn9Var.t, jn9Var.u);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.a = (int) motionEvent.getRawX();
                this.b = (int) motionEvent.getRawY();
                this.c = System.currentTimeMillis();
                this.g.p = (int) motionEvent.getX();
                this.g.q = (int) motionEvent.getY();
                jn9.c(this.g, view2);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.d = (int) motionEvent.getRawX();
                this.e = (int) motionEvent.getRawY();
                this.f = System.currentTimeMillis();
                this.g.r = (int) motionEvent.getX();
                this.g.s = (int) motionEvent.getY();
                jn9 jn9Var = this.g;
                Info info = jn9Var.c;
                if (info == null || !pm9.d(info, jn9Var.h)) {
                    return false;
                }
                this.g.h = System.currentTimeMillis();
                jn9 jn9Var2 = this.g;
                Context context = jn9Var2.a;
                String open = jn9Var2.c.getOpen();
                jn9 jn9Var3 = this.g;
                pm9.a(context, open, jn9Var3.c, jn9Var3.g, a().toString());
                nn9 a = rn9.a(this.g.a);
                a.h(new vn9(this.g.c), null);
                a.l("desc", a().toString());
                a.m();
                ll9.p(this.g.c, a().toString());
                xn9 xn9Var = this.g.f;
                if (xn9Var != null) {
                    xn9Var.onClicked();
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
