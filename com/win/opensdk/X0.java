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
/* loaded from: classes7.dex */
public class X0 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f42499a;

    /* renamed from: b  reason: collision with root package name */
    public int f42500b;

    /* renamed from: c  reason: collision with root package name */
    public long f42501c;

    /* renamed from: d  reason: collision with root package name */
    public int f42502d;

    /* renamed from: e  reason: collision with root package name */
    public int f42503e;

    /* renamed from: f  reason: collision with root package name */
    public long f42504f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Y0 f42505g;

    public X0(Y0 y0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42505g = y0;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f42499a));
            hashMap.put("dy", Integer.valueOf(this.f42500b));
            hashMap.put("dts", Long.valueOf(this.f42501c));
            hashMap.put("ux", Integer.valueOf(this.f42502d));
            hashMap.put("uy", Integer.valueOf(this.f42503e));
            hashMap.put("uts", Long.valueOf(this.f42504f));
            Y0 y0 = this.f42505g;
            z.a(hashMap, y0.p, y0.q, y0.r, y0.s, y0.t, y0.u);
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
                this.f42499a = (int) motionEvent.getRawX();
                this.f42500b = (int) motionEvent.getRawY();
                this.f42501c = System.currentTimeMillis();
                this.f42505g.p = (int) motionEvent.getX();
                this.f42505g.q = (int) motionEvent.getY();
                Y0.a(this.f42505g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f42502d = (int) motionEvent.getRawX();
                this.f42503e = (int) motionEvent.getRawY();
                this.f42504f = System.currentTimeMillis();
                this.f42505g.r = (int) motionEvent.getX();
                this.f42505g.s = (int) motionEvent.getY();
                Y0 y0 = this.f42505g;
                Info info = y0.f42508c;
                if (info == null || !o1.a(info, y0.f42513h)) {
                    return false;
                }
                this.f42505g.f42513h = System.currentTimeMillis();
                Y0 y02 = this.f42505g;
                Context context = y02.f42506a;
                String open = y02.f42508c.getOpen();
                Y0 y03 = this.f42505g;
                o1.a(context, open, y03.f42508c, y03.f42512g, a().toString());
                x0.a(this.f42505g.f42506a).a(new y0(this.f42505g.f42508c), (String) null).a("desc", a().toString()).a();
                z.a(this.f42505g.f42508c, a().toString());
                r rVar = this.f42505g.f42511f;
                if (rVar != null) {
                    rVar.onClicked();
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
