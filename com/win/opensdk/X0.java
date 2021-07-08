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
public class X0 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f39513a;

    /* renamed from: b  reason: collision with root package name */
    public int f39514b;

    /* renamed from: c  reason: collision with root package name */
    public long f39515c;

    /* renamed from: d  reason: collision with root package name */
    public int f39516d;

    /* renamed from: e  reason: collision with root package name */
    public int f39517e;

    /* renamed from: f  reason: collision with root package name */
    public long f39518f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Y0 f39519g;

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
        this.f39519g = y0;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f39513a));
            hashMap.put("dy", Integer.valueOf(this.f39514b));
            hashMap.put("dts", Long.valueOf(this.f39515c));
            hashMap.put("ux", Integer.valueOf(this.f39516d));
            hashMap.put("uy", Integer.valueOf(this.f39517e));
            hashMap.put("uts", Long.valueOf(this.f39518f));
            Y0 y0 = this.f39519g;
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
                this.f39513a = (int) motionEvent.getRawX();
                this.f39514b = (int) motionEvent.getRawY();
                this.f39515c = System.currentTimeMillis();
                this.f39519g.p = (int) motionEvent.getX();
                this.f39519g.q = (int) motionEvent.getY();
                Y0.a(this.f39519g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f39516d = (int) motionEvent.getRawX();
                this.f39517e = (int) motionEvent.getRawY();
                this.f39518f = System.currentTimeMillis();
                this.f39519g.r = (int) motionEvent.getX();
                this.f39519g.s = (int) motionEvent.getY();
                Y0 y0 = this.f39519g;
                Info info = y0.f39522c;
                if (info == null || !o1.a(info, y0.f39527h)) {
                    return false;
                }
                this.f39519g.f39527h = System.currentTimeMillis();
                Y0 y02 = this.f39519g;
                Context context = y02.f39520a;
                String open = y02.f39522c.getOpen();
                Y0 y03 = this.f39519g;
                o1.a(context, open, y03.f39522c, y03.f39526g, a().toString());
                x0.a(this.f39519g.f39520a).a(new y0(this.f39519g.f39522c), (String) null).a("desc", a().toString()).a();
                z.a(this.f39519g.f39522c, a().toString());
                r rVar = this.f39519g.f39525f;
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
