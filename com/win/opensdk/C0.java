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
/* loaded from: classes8.dex */
public class C0 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public long c;
    public int d;
    public int e;
    public long f;
    public final /* synthetic */ D0 g;

    public C0(D0 d0) {
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
        this.g = d0;
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
            D0 d0 = this.g;
            M.a(hashMap, d0.p, d0.q, d0.r, d0.s, d0.t, d0.u);
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
                    D0 d0 = this.g;
                    Info info = d0.c;
                    if (info != null && V1.a(info, d0.h)) {
                        this.g.h = System.currentTimeMillis();
                        D0 d02 = this.g;
                        Context context = d02.a;
                        String open = d02.c.getOpen();
                        D0 d03 = this.g;
                        V1.a(context, open, d03.c, d03.g, a().toString());
                        e1.a(this.g.a).a(new f1(this.g.c), (String) null).a("desc", a().toString()).a();
                        M.a(this.g.c, a().toString());
                        PBNativeListener pBNativeListener = this.g.f;
                        if (pBNativeListener != null) {
                            pBNativeListener.onClicked();
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
            D0.a(this.g, view2);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
