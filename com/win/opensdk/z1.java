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
public class z1 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f76847a;

    /* renamed from: b  reason: collision with root package name */
    public int f76848b;

    /* renamed from: c  reason: collision with root package name */
    public long f76849c;

    /* renamed from: d  reason: collision with root package name */
    public int f76850d;

    /* renamed from: e  reason: collision with root package name */
    public int f76851e;

    /* renamed from: f  reason: collision with root package name */
    public long f76852f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ A1 f76853g;

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
        this.f76853g = a1;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f76847a));
            hashMap.put("dy", Integer.valueOf(this.f76848b));
            hashMap.put("dts", Long.valueOf(this.f76849c));
            hashMap.put("ux", Integer.valueOf(this.f76850d));
            hashMap.put("uy", Integer.valueOf(this.f76851e));
            hashMap.put("uts", Long.valueOf(this.f76852f));
            A1 a1 = this.f76853g;
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
                this.f76847a = (int) motionEvent.getRawX();
                this.f76848b = (int) motionEvent.getRawY();
                this.f76849c = System.currentTimeMillis();
                this.f76853g.p = (int) motionEvent.getX();
                this.f76853g.q = (int) motionEvent.getY();
                A1.a(this.f76853g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f76850d = (int) motionEvent.getRawX();
                this.f76851e = (int) motionEvent.getRawY();
                this.f76852f = System.currentTimeMillis();
                this.f76853g.r = (int) motionEvent.getX();
                this.f76853g.s = (int) motionEvent.getY();
                A1 a1 = this.f76853g;
                Info info = a1.f76375c;
                if (info == null || !Q1.a(info, a1.f76380h)) {
                    return false;
                }
                this.f76853g.f76380h = System.currentTimeMillis();
                A1 a12 = this.f76853g;
                Context context = a12.f76373a;
                String open = a12.f76375c.getOpen();
                A1 a13 = this.f76853g;
                Q1.a(context, open, a13.f76375c, a13.f76379g, a().toString());
                Z0.a(this.f76853g.f76373a).a(new a1(this.f76853g.f76375c), (String) null).a("desc", a().toString()).a();
                N.a(this.f76853g.f76375c, a().toString());
                F f2 = this.f76853g.f76378f;
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
