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
public class L implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final I f39405a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39406b;

    /* renamed from: c  reason: collision with root package name */
    public long f39407c;

    /* renamed from: d  reason: collision with root package name */
    public float f39408d;

    /* renamed from: e  reason: collision with root package name */
    public float f39409e;

    /* renamed from: f  reason: collision with root package name */
    public int f39410f;

    /* renamed from: g  reason: collision with root package name */
    public int f39411g;

    /* renamed from: h  reason: collision with root package name */
    public int f39412h;

    /* renamed from: i  reason: collision with root package name */
    public int f39413i;
    public int j;
    public int k;
    public int l;
    public int m;
    public long n;
    public int o;
    public int p;
    public long q;

    public L(Info info, I i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {info, i2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39406b = false;
        this.f39407c = 0L;
        this.f39405a = i2;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f39410f));
            hashMap.put("dy", Integer.valueOf(this.f39411g));
            hashMap.put("dts", Long.valueOf(this.n));
            hashMap.put("ux", Integer.valueOf(this.o));
            hashMap.put("uy", Integer.valueOf(this.p));
            hashMap.put("uts", Long.valueOf(this.q));
            z.a(hashMap, this.f39412h, this.f39413i, this.j, this.k, this.l, this.m);
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
                this.f39406b = true;
                this.f39407c = System.currentTimeMillis();
                this.f39408d = motionEvent.getX();
                this.f39409e = motionEvent.getY();
                this.f39412h = (int) motionEvent.getX();
                this.f39413i = (int) motionEvent.getY();
                this.f39410f = (int) motionEvent.getRawX();
                this.f39411g = (int) motionEvent.getRawY();
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
                boolean z = Math.abs(motionEvent.getX() - this.f39408d) < 51.0f;
                boolean z2 = Math.abs(motionEvent.getY() - this.f39409e) < 51.0f;
                boolean z3 = System.currentTimeMillis() - this.f39407c < 2000;
                if (z && z2 && z3 && this.f39406b) {
                    String str = null;
                    try {
                        str = a().toString();
                        V1 v1 = this.f39405a.f39371a.f39389b;
                        if (v1 != null) {
                            v1.a(str);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    I i2 = this.f39405a;
                    i2.f39371a.f39391d = true;
                    i2.f39371a.f39392e = str;
                    return false;
                } else if (this.f39405a != null) {
                    try {
                        String hashMap = a().toString();
                        V1 v12 = this.f39405a.f39371a.f39389b;
                        if (v12 != null) {
                            v12.a(hashMap);
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
