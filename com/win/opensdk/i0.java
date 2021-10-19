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
/* loaded from: classes10.dex */
public class i0 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final f0 f77398a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f77399b;

    /* renamed from: c  reason: collision with root package name */
    public long f77400c;

    /* renamed from: d  reason: collision with root package name */
    public float f77401d;

    /* renamed from: e  reason: collision with root package name */
    public float f77402e;

    /* renamed from: f  reason: collision with root package name */
    public int f77403f;

    /* renamed from: g  reason: collision with root package name */
    public int f77404g;

    /* renamed from: h  reason: collision with root package name */
    public int f77405h;

    /* renamed from: i  reason: collision with root package name */
    public int f77406i;

    /* renamed from: j  reason: collision with root package name */
    public int f77407j;
    public int k;
    public int l;
    public int m;
    public long n;
    public int o;
    public int p;
    public long q;

    public i0(Info info, f0 f0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {info, f0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77399b = false;
        this.f77400c = 0L;
        this.f77398a = f0Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f77403f));
            hashMap.put("dy", Integer.valueOf(this.f77404g));
            hashMap.put("dts", Long.valueOf(this.n));
            hashMap.put("ux", Integer.valueOf(this.o));
            hashMap.put("uy", Integer.valueOf(this.p));
            hashMap.put("uts", Long.valueOf(this.q));
            N.a(hashMap, this.f77405h, this.f77406i, this.f77407j, this.k, this.l, this.m);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f77399b = true;
                this.f77400c = System.currentTimeMillis();
                this.f77401d = motionEvent.getX();
                this.f77402e = motionEvent.getY();
                this.f77405h = (int) motionEvent.getX();
                this.f77406i = (int) motionEvent.getY();
                this.f77403f = (int) motionEvent.getRawX();
                this.f77404g = (int) motionEvent.getRawY();
                if (this.l <= 0 || this.m <= 0) {
                    this.m = view.getHeight();
                    this.l = view.getWidth();
                }
                this.n = System.currentTimeMillis();
            } else if (action == 1) {
                this.o = (int) motionEvent.getRawX();
                this.p = (int) motionEvent.getRawY();
                this.f77407j = (int) motionEvent.getX();
                this.k = (int) motionEvent.getY();
                this.q = System.currentTimeMillis();
                boolean z = Math.abs(motionEvent.getX() - this.f77401d) < 51.0f;
                boolean z2 = Math.abs(motionEvent.getY() - this.f77402e) < 51.0f;
                boolean z3 = System.currentTimeMillis() - this.f77400c < 2000;
                if (z && z2 && z3 && this.f77399b) {
                    String str = null;
                    try {
                        str = a().toString();
                        x2 x2Var = this.f77398a.f77375a.f77391b;
                        if (x2Var != null) {
                            x2Var.a(str);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    f0 f0Var = this.f77398a;
                    f0Var.f77375a.f77393d = true;
                    f0Var.f77375a.f77394e = str;
                    return false;
                } else if (this.f77398a != null) {
                    try {
                        String hashMap = a().toString();
                        x2 x2Var2 = this.f77398a.f77375a.f77391b;
                        if (x2Var2 != null) {
                            x2Var2.a(hashMap);
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
