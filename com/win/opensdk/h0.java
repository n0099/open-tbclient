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
public class h0 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f39585a;

    /* renamed from: b  reason: collision with root package name */
    public int f39586b;

    /* renamed from: c  reason: collision with root package name */
    public long f39587c;

    /* renamed from: d  reason: collision with root package name */
    public int f39588d;

    /* renamed from: e  reason: collision with root package name */
    public int f39589e;

    /* renamed from: f  reason: collision with root package name */
    public long f39590f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i0 f39591g;

    public h0(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39591g = i0Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f39585a));
            hashMap.put("dy", Integer.valueOf(this.f39586b));
            hashMap.put("dts", Long.valueOf(this.f39587c));
            hashMap.put("ux", Integer.valueOf(this.f39588d));
            hashMap.put("uy", Integer.valueOf(this.f39589e));
            hashMap.put("uts", Long.valueOf(this.f39590f));
            i0 i0Var = this.f39591g;
            z.a(hashMap, i0Var.p, i0Var.q, i0Var.r, i0Var.s, i0Var.t, i0Var.u);
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
                this.f39585a = (int) motionEvent.getRawX();
                this.f39586b = (int) motionEvent.getRawY();
                this.f39587c = System.currentTimeMillis();
                this.f39591g.p = (int) motionEvent.getX();
                this.f39591g.q = (int) motionEvent.getY();
                i0.a(this.f39591g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f39588d = (int) motionEvent.getRawX();
                this.f39589e = (int) motionEvent.getRawY();
                this.f39590f = System.currentTimeMillis();
                this.f39591g.r = (int) motionEvent.getX();
                this.f39591g.s = (int) motionEvent.getY();
                i0 i0Var = this.f39591g;
                Info info = i0Var.f39595c;
                if (info == null || !o1.a(info, i0Var.f39600h)) {
                    return false;
                }
                this.f39591g.f39600h = System.currentTimeMillis();
                i0 i0Var2 = this.f39591g;
                Context context = i0Var2.f39593a;
                String open = i0Var2.f39595c.getOpen();
                i0 i0Var3 = this.f39591g;
                o1.a(context, open, i0Var3.f39595c, i0Var3.f39599g, a().toString());
                x0.a(this.f39591g.f39593a).a(new y0(this.f39591g.f39595c), (String) null).a("desc", a().toString()).a();
                z.a(this.f39591g.f39595c, a().toString());
                PBNativeListener pBNativeListener = this.f39591g.f39598f;
                if (pBNativeListener != null) {
                    pBNativeListener.onClicked();
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
