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
    public int f77582a;

    /* renamed from: b  reason: collision with root package name */
    public int f77583b;

    /* renamed from: c  reason: collision with root package name */
    public long f77584c;

    /* renamed from: d  reason: collision with root package name */
    public int f77585d;

    /* renamed from: e  reason: collision with root package name */
    public int f77586e;

    /* renamed from: f  reason: collision with root package name */
    public long f77587f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ A1 f77588g;

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
        this.f77588g = a1;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f77582a));
            hashMap.put("dy", Integer.valueOf(this.f77583b));
            hashMap.put("dts", Long.valueOf(this.f77584c));
            hashMap.put("ux", Integer.valueOf(this.f77585d));
            hashMap.put("uy", Integer.valueOf(this.f77586e));
            hashMap.put("uts", Long.valueOf(this.f77587f));
            A1 a1 = this.f77588g;
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
                this.f77582a = (int) motionEvent.getRawX();
                this.f77583b = (int) motionEvent.getRawY();
                this.f77584c = System.currentTimeMillis();
                this.f77588g.p = (int) motionEvent.getX();
                this.f77588g.q = (int) motionEvent.getY();
                A1.a(this.f77588g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f77585d = (int) motionEvent.getRawX();
                this.f77586e = (int) motionEvent.getRawY();
                this.f77587f = System.currentTimeMillis();
                this.f77588g.r = (int) motionEvent.getX();
                this.f77588g.s = (int) motionEvent.getY();
                A1 a1 = this.f77588g;
                Info info = a1.f77110c;
                if (info == null || !Q1.a(info, a1.f77115h)) {
                    return false;
                }
                this.f77588g.f77115h = System.currentTimeMillis();
                A1 a12 = this.f77588g;
                Context context = a12.f77108a;
                String open = a12.f77110c.getOpen();
                A1 a13 = this.f77588g;
                Q1.a(context, open, a13.f77110c, a13.f77114g, a().toString());
                Z0.a(this.f77588g.f77108a).a(new a1(this.f77588g.f77110c), (String) null).a("desc", a().toString()).a();
                N.a(this.f77588g.f77110c, a().toString());
                F f2 = this.f77588g.f77113f;
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
