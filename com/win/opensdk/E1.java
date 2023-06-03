package com.win.opensdk;

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
/* loaded from: classes10.dex */
public class E1 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public long c;
    public int d;
    public int e;
    public long f;
    public final /* synthetic */ F1 g;

    public E1(F1 f1) {
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
        this.g = f1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
        }
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
            F1 f1 = this.g;
            M.a(hashMap, f1.p, f1.q, f1.r, f1.s, f1.t, f1.u);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    this.d = (int) motionEvent.getRawX();
                    this.e = (int) motionEvent.getRawY();
                    this.f = System.currentTimeMillis();
                    this.g.r = (int) motionEvent.getX();
                    this.g.s = (int) motionEvent.getY();
                    F1 f1 = this.g;
                    Info info = f1.c;
                    if (info != null && V1.a(info, f1.h)) {
                        this.g.h = System.currentTimeMillis();
                        F1 f12 = this.g;
                        Context context = f12.a;
                        String open = f12.c.getOpen();
                        F1 f13 = this.g;
                        V1.a(context, open, f13.c, f13.g, a().toString());
                        e1.a(this.g.a).a(new f1(this.g.c), (String) null).a("desc", a().toString()).a();
                        M.a(this.g.c, a().toString());
                        E e = this.g.f;
                        if (e != null) {
                            e.onClicked();
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            this.a = (int) motionEvent.getRawX();
            this.b = (int) motionEvent.getRawY();
            this.c = System.currentTimeMillis();
            this.g.p = (int) motionEvent.getX();
            this.g.q = (int) motionEvent.getY();
            F1.a(this.g, view2);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
