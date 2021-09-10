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
    public final f0 f77044a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f77045b;

    /* renamed from: c  reason: collision with root package name */
    public long f77046c;

    /* renamed from: d  reason: collision with root package name */
    public float f77047d;

    /* renamed from: e  reason: collision with root package name */
    public float f77048e;

    /* renamed from: f  reason: collision with root package name */
    public int f77049f;

    /* renamed from: g  reason: collision with root package name */
    public int f77050g;

    /* renamed from: h  reason: collision with root package name */
    public int f77051h;

    /* renamed from: i  reason: collision with root package name */
    public int f77052i;

    /* renamed from: j  reason: collision with root package name */
    public int f77053j;
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
        this.f77045b = false;
        this.f77046c = 0L;
        this.f77044a = f0Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f77049f));
            hashMap.put("dy", Integer.valueOf(this.f77050g));
            hashMap.put("dts", Long.valueOf(this.n));
            hashMap.put("ux", Integer.valueOf(this.o));
            hashMap.put("uy", Integer.valueOf(this.p));
            hashMap.put("uts", Long.valueOf(this.q));
            N.a(hashMap, this.f77051h, this.f77052i, this.f77053j, this.k, this.l, this.m);
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
                this.f77045b = true;
                this.f77046c = System.currentTimeMillis();
                this.f77047d = motionEvent.getX();
                this.f77048e = motionEvent.getY();
                this.f77051h = (int) motionEvent.getX();
                this.f77052i = (int) motionEvent.getY();
                this.f77049f = (int) motionEvent.getRawX();
                this.f77050g = (int) motionEvent.getRawY();
                if (this.l <= 0 || this.m <= 0) {
                    this.m = view.getHeight();
                    this.l = view.getWidth();
                }
                this.n = System.currentTimeMillis();
            } else if (action == 1) {
                this.o = (int) motionEvent.getRawX();
                this.p = (int) motionEvent.getRawY();
                this.f77053j = (int) motionEvent.getX();
                this.k = (int) motionEvent.getY();
                this.q = System.currentTimeMillis();
                boolean z = Math.abs(motionEvent.getX() - this.f77047d) < 51.0f;
                boolean z2 = Math.abs(motionEvent.getY() - this.f77048e) < 51.0f;
                boolean z3 = System.currentTimeMillis() - this.f77046c < 2000;
                if (z && z2 && z3 && this.f77045b) {
                    String str = null;
                    try {
                        str = a().toString();
                        x2 x2Var = this.f77044a.f77021a.f77037b;
                        if (x2Var != null) {
                            x2Var.a(str);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    f0 f0Var = this.f77044a;
                    f0Var.f77021a.f77039d = true;
                    f0Var.f77021a.f77040e = str;
                    return false;
                } else if (this.f77044a != null) {
                    try {
                        String hashMap = a().toString();
                        x2 x2Var2 = this.f77044a.f77021a.f77037b;
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
