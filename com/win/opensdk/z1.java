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
/* loaded from: classes6.dex */
public class z1 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f39996a;

    /* renamed from: b  reason: collision with root package name */
    public int f39997b;

    /* renamed from: c  reason: collision with root package name */
    public long f39998c;

    /* renamed from: d  reason: collision with root package name */
    public int f39999d;

    /* renamed from: e  reason: collision with root package name */
    public int f40000e;

    /* renamed from: f  reason: collision with root package name */
    public long f40001f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ A1 f40002g;

    public z1(A1 a1) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a1};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40002g = a1;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f39996a));
            hashMap.put("dy", Integer.valueOf(this.f39997b));
            hashMap.put("dts", Long.valueOf(this.f39998c));
            hashMap.put("ux", Integer.valueOf(this.f39999d));
            hashMap.put("uy", Integer.valueOf(this.f40000e));
            hashMap.put("uts", Long.valueOf(this.f40001f));
            A1 a1 = this.f40002g;
            N.a(hashMap, a1.p, a1.q, a1.r, a1.s, a1.t, a1.u);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f39996a = (int) motionEvent.getRawX();
                this.f39997b = (int) motionEvent.getRawY();
                this.f39998c = System.currentTimeMillis();
                this.f40002g.p = (int) motionEvent.getX();
                this.f40002g.q = (int) motionEvent.getY();
                A1.a(this.f40002g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f39999d = (int) motionEvent.getRawX();
                this.f40000e = (int) motionEvent.getRawY();
                this.f40001f = System.currentTimeMillis();
                this.f40002g.r = (int) motionEvent.getX();
                this.f40002g.s = (int) motionEvent.getY();
                A1 a1 = this.f40002g;
                Info info = a1.f39541c;
                if (info == null || !Q1.a(info, a1.f39546h)) {
                    return false;
                }
                this.f40002g.f39546h = System.currentTimeMillis();
                A1 a12 = this.f40002g;
                Context context = a12.f39539a;
                String open = a12.f39541c.getOpen();
                A1 a13 = this.f40002g;
                Q1.a(context, open, a13.f39541c, a13.f39545g, a().toString());
                Z0.a(this.f40002g.f39539a).a(new a1(this.f40002g.f39541c), (String) null).a("desc", a().toString()).a();
                N.a(this.f40002g.f39541c, a().toString());
                F f2 = this.f40002g.f39544f;
                if (f2 != null) {
                    f2.onClicked();
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
