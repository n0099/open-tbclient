package com.win.opensdk;

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
public class h0 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e0 a;
    public boolean b;
    public long c;
    public float d;
    public float e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public long n;
    public int o;
    public int p;
    public long q;

    public h0(Info info, e0 e0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {info, e0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = 0L;
        this.a = e0Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f));
            hashMap.put("dy", Integer.valueOf(this.g));
            hashMap.put("dts", Long.valueOf(this.n));
            hashMap.put("ux", Integer.valueOf(this.o));
            hashMap.put("uy", Integer.valueOf(this.p));
            hashMap.put("uts", Long.valueOf(this.q));
            M.a(hashMap, this.h, this.i, this.j, this.k, this.l, this.m);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.b = true;
                this.c = System.currentTimeMillis();
                this.d = motionEvent.getX();
                this.e = motionEvent.getY();
                this.h = (int) motionEvent.getX();
                this.i = (int) motionEvent.getY();
                this.f = (int) motionEvent.getRawX();
                this.g = (int) motionEvent.getRawY();
                if (this.l <= 0 || this.m <= 0) {
                    this.m = view2.getHeight();
                    this.l = view2.getWidth();
                }
                this.n = System.currentTimeMillis();
            } else if (action == 1) {
                this.o = (int) motionEvent.getRawX();
                this.p = (int) motionEvent.getRawY();
                this.j = (int) motionEvent.getX();
                this.k = (int) motionEvent.getY();
                this.q = System.currentTimeMillis();
                boolean z = Math.abs(motionEvent.getX() - this.d) < 51.0f;
                boolean z2 = Math.abs(motionEvent.getY() - this.e) < 51.0f;
                boolean z3 = System.currentTimeMillis() - this.c < 2000;
                if (z && z2 && z3 && this.b) {
                    String str = null;
                    try {
                        str = a().toString();
                        E2 e2 = this.a.a.b;
                        if (e2 != null) {
                            e2.a(str);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    e0 e0Var = this.a;
                    e0Var.a.d = true;
                    e0Var.a.e = str;
                    return false;
                } else if (this.a != null) {
                    try {
                        String hashMap = a().toString();
                        E2 e22 = this.a.a.b;
                        if (e22 != null) {
                            e22.a(hashMap);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
