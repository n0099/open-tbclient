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
public class c0 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f76804a;

    /* renamed from: b  reason: collision with root package name */
    public int f76805b;

    /* renamed from: c  reason: collision with root package name */
    public long f76806c;

    /* renamed from: d  reason: collision with root package name */
    public int f76807d;

    /* renamed from: e  reason: collision with root package name */
    public int f76808e;

    /* renamed from: f  reason: collision with root package name */
    public long f76809f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ d0 f76810g;

    public c0(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76810g = d0Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f76804a));
            hashMap.put("dy", Integer.valueOf(this.f76805b));
            hashMap.put("dts", Long.valueOf(this.f76806c));
            hashMap.put("ux", Integer.valueOf(this.f76807d));
            hashMap.put("uy", Integer.valueOf(this.f76808e));
            hashMap.put("uts", Long.valueOf(this.f76809f));
            d0 d0Var = this.f76810g;
            N.a(hashMap, d0Var.p, d0Var.q, d0Var.r, d0Var.s, d0Var.t, d0Var.u);
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
                this.f76804a = (int) motionEvent.getRawX();
                this.f76805b = (int) motionEvent.getRawY();
                this.f76806c = System.currentTimeMillis();
                this.f76810g.p = (int) motionEvent.getX();
                this.f76810g.q = (int) motionEvent.getY();
                d0.a(this.f76810g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f76807d = (int) motionEvent.getRawX();
                this.f76808e = (int) motionEvent.getRawY();
                this.f76809f = System.currentTimeMillis();
                this.f76810g.r = (int) motionEvent.getX();
                this.f76810g.s = (int) motionEvent.getY();
                d0 d0Var = this.f76810g;
                Info info = d0Var.f76820c;
                if (info == null || !Q1.a(info, d0Var.f76825h)) {
                    return false;
                }
                this.f76810g.f76825h = System.currentTimeMillis();
                d0 d0Var2 = this.f76810g;
                Context context = d0Var2.f76818a;
                String open = d0Var2.f76820c.getOpen();
                d0 d0Var3 = this.f76810g;
                Q1.a(context, open, d0Var3.f76820c, d0Var3.f76824g, a().toString());
                Z0.a(this.f76810g.f76818a).a(new a1(this.f76810g.f76820c), (String) null).a("desc", a().toString()).a();
                N.a(this.f76810g.f76820c, a().toString());
                f fVar = this.f76810g.f76823f;
                if (fVar != null) {
                    fVar.onClicked();
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
