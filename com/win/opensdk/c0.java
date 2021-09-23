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
    public int f77303a;

    /* renamed from: b  reason: collision with root package name */
    public int f77304b;

    /* renamed from: c  reason: collision with root package name */
    public long f77305c;

    /* renamed from: d  reason: collision with root package name */
    public int f77306d;

    /* renamed from: e  reason: collision with root package name */
    public int f77307e;

    /* renamed from: f  reason: collision with root package name */
    public long f77308f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ d0 f77309g;

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
        this.f77309g = d0Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f77303a));
            hashMap.put("dy", Integer.valueOf(this.f77304b));
            hashMap.put("dts", Long.valueOf(this.f77305c));
            hashMap.put("ux", Integer.valueOf(this.f77306d));
            hashMap.put("uy", Integer.valueOf(this.f77307e));
            hashMap.put("uts", Long.valueOf(this.f77308f));
            d0 d0Var = this.f77309g;
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
                this.f77303a = (int) motionEvent.getRawX();
                this.f77304b = (int) motionEvent.getRawY();
                this.f77305c = System.currentTimeMillis();
                this.f77309g.p = (int) motionEvent.getX();
                this.f77309g.q = (int) motionEvent.getY();
                d0.a(this.f77309g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f77306d = (int) motionEvent.getRawX();
                this.f77307e = (int) motionEvent.getRawY();
                this.f77308f = System.currentTimeMillis();
                this.f77309g.r = (int) motionEvent.getX();
                this.f77309g.s = (int) motionEvent.getY();
                d0 d0Var = this.f77309g;
                Info info = d0Var.f77319c;
                if (info == null || !Q1.a(info, d0Var.f77324h)) {
                    return false;
                }
                this.f77309g.f77324h = System.currentTimeMillis();
                d0 d0Var2 = this.f77309g;
                Context context = d0Var2.f77317a;
                String open = d0Var2.f77319c.getOpen();
                d0 d0Var3 = this.f77309g;
                Q1.a(context, open, d0Var3.f77319c, d0Var3.f77323g, a().toString());
                Z0.a(this.f77309g.f77317a).a(new a1(this.f77309g.f77319c), (String) null).a("desc", a().toString()).a();
                N.a(this.f77309g.f77319c, a().toString());
                f fVar = this.f77309g.f77322f;
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
