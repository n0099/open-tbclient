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
import com.win.opensdk.PBNativeListener;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class hn9 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public long c;
    public int d;
    public int e;
    public long f;
    public final /* synthetic */ ln9 g;

    public hn9(ln9 ln9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ln9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = ln9Var;
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
            ln9 ln9Var = this.g;
            ro9.j(hashMap, ln9Var.p, ln9Var.q, ln9Var.r, ln9Var.s, ln9Var.t, ln9Var.u);
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
                ln9.e(this.g, view2);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.d = (int) motionEvent.getRawX();
                this.e = (int) motionEvent.getRawY();
                this.f = System.currentTimeMillis();
                this.g.r = (int) motionEvent.getX();
                this.g.s = (int) motionEvent.getY();
                ln9 ln9Var = this.g;
                Info info = ln9Var.c;
                if (info == null || !vp9.d(info, ln9Var.h)) {
                    return false;
                }
                this.g.h = System.currentTimeMillis();
                ln9 ln9Var2 = this.g;
                Context context = ln9Var2.a;
                String open = ln9Var2.c.getOpen();
                ln9 ln9Var3 = this.g;
                vp9.a(context, open, ln9Var3.c, ln9Var3.g, a().toString());
                tq9 a = xq9.a(this.g.a);
                a.h(new br9(this.g.c), null);
                a.l("desc", a().toString());
                a.m();
                ro9.p(this.g.c, a().toString());
                PBNativeListener pBNativeListener = this.g.f;
                if (pBNativeListener != null) {
                    pBNativeListener.onClicked();
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
