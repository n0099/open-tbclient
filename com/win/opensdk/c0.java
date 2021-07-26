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
public class c0 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f39763a;

    /* renamed from: b  reason: collision with root package name */
    public int f39764b;

    /* renamed from: c  reason: collision with root package name */
    public long f39765c;

    /* renamed from: d  reason: collision with root package name */
    public int f39766d;

    /* renamed from: e  reason: collision with root package name */
    public int f39767e;

    /* renamed from: f  reason: collision with root package name */
    public long f39768f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ d0 f39769g;

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
        this.f39769g = d0Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f39763a));
            hashMap.put("dy", Integer.valueOf(this.f39764b));
            hashMap.put("dts", Long.valueOf(this.f39765c));
            hashMap.put("ux", Integer.valueOf(this.f39766d));
            hashMap.put("uy", Integer.valueOf(this.f39767e));
            hashMap.put("uts", Long.valueOf(this.f39768f));
            d0 d0Var = this.f39769g;
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
                this.f39763a = (int) motionEvent.getRawX();
                this.f39764b = (int) motionEvent.getRawY();
                this.f39765c = System.currentTimeMillis();
                this.f39769g.p = (int) motionEvent.getX();
                this.f39769g.q = (int) motionEvent.getY();
                d0.a(this.f39769g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f39766d = (int) motionEvent.getRawX();
                this.f39767e = (int) motionEvent.getRawY();
                this.f39768f = System.currentTimeMillis();
                this.f39769g.r = (int) motionEvent.getX();
                this.f39769g.s = (int) motionEvent.getY();
                d0 d0Var = this.f39769g;
                Info info = d0Var.f39779c;
                if (info == null || !Q1.a(info, d0Var.f39784h)) {
                    return false;
                }
                this.f39769g.f39784h = System.currentTimeMillis();
                d0 d0Var2 = this.f39769g;
                Context context = d0Var2.f39777a;
                String open = d0Var2.f39779c.getOpen();
                d0 d0Var3 = this.f39769g;
                Q1.a(context, open, d0Var3.f39779c, d0Var3.f39783g, a().toString());
                Z0.a(this.f39769g.f39777a).a(new a1(this.f39769g.f39779c), (String) null).a("desc", a().toString()).a();
                N.a(this.f39769g.f39779c, a().toString());
                f fVar = this.f39769g.f39782f;
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
