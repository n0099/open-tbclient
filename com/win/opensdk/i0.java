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
/* loaded from: classes6.dex */
public class i0 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final f0 f39822a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39823b;

    /* renamed from: c  reason: collision with root package name */
    public long f39824c;

    /* renamed from: d  reason: collision with root package name */
    public float f39825d;

    /* renamed from: e  reason: collision with root package name */
    public float f39826e;

    /* renamed from: f  reason: collision with root package name */
    public int f39827f;

    /* renamed from: g  reason: collision with root package name */
    public int f39828g;

    /* renamed from: h  reason: collision with root package name */
    public int f39829h;

    /* renamed from: i  reason: collision with root package name */
    public int f39830i;
    public int j;
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
        this.f39823b = false;
        this.f39824c = 0L;
        this.f39822a = f0Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f39827f));
            hashMap.put("dy", Integer.valueOf(this.f39828g));
            hashMap.put("dts", Long.valueOf(this.n));
            hashMap.put("ux", Integer.valueOf(this.o));
            hashMap.put("uy", Integer.valueOf(this.p));
            hashMap.put("uts", Long.valueOf(this.q));
            N.a(hashMap, this.f39829h, this.f39830i, this.j, this.k, this.l, this.m);
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
                this.f39823b = true;
                this.f39824c = System.currentTimeMillis();
                this.f39825d = motionEvent.getX();
                this.f39826e = motionEvent.getY();
                this.f39829h = (int) motionEvent.getX();
                this.f39830i = (int) motionEvent.getY();
                this.f39827f = (int) motionEvent.getRawX();
                this.f39828g = (int) motionEvent.getRawY();
                if (this.l <= 0 || this.m <= 0) {
                    this.m = view.getHeight();
                    this.l = view.getWidth();
                }
                this.n = System.currentTimeMillis();
            } else if (action == 1) {
                this.o = (int) motionEvent.getRawX();
                this.p = (int) motionEvent.getRawY();
                this.j = (int) motionEvent.getX();
                this.k = (int) motionEvent.getY();
                this.q = System.currentTimeMillis();
                boolean z = Math.abs(motionEvent.getX() - this.f39825d) < 51.0f;
                boolean z2 = Math.abs(motionEvent.getY() - this.f39826e) < 51.0f;
                boolean z3 = System.currentTimeMillis() - this.f39824c < 2000;
                if (z && z2 && z3 && this.f39823b) {
                    String str = null;
                    try {
                        str = a().toString();
                        x2 x2Var = this.f39822a.f39799a.f39815b;
                        if (x2Var != null) {
                            x2Var.a(str);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    f0 f0Var = this.f39822a;
                    f0Var.f39799a.f39817d = true;
                    f0Var.f39799a.f39818e = str;
                    return false;
                } else if (this.f39822a != null) {
                    try {
                        String hashMap = a().toString();
                        x2 x2Var2 = this.f39822a.f39799a.f39815b;
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
