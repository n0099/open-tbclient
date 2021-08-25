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
public class D0 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f76591a;

    /* renamed from: b  reason: collision with root package name */
    public int f76592b;

    /* renamed from: c  reason: collision with root package name */
    public long f76593c;

    /* renamed from: d  reason: collision with root package name */
    public int f76594d;

    /* renamed from: e  reason: collision with root package name */
    public int f76595e;

    /* renamed from: f  reason: collision with root package name */
    public long f76596f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ E0 f76597g;

    public D0(E0 e0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76597g = e0;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f76591a));
            hashMap.put("dy", Integer.valueOf(this.f76592b));
            hashMap.put("dts", Long.valueOf(this.f76593c));
            hashMap.put("ux", Integer.valueOf(this.f76594d));
            hashMap.put("uy", Integer.valueOf(this.f76595e));
            hashMap.put("uts", Long.valueOf(this.f76596f));
            E0 e0 = this.f76597g;
            N.a(hashMap, e0.p, e0.q, e0.r, e0.s, e0.t, e0.u);
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
                this.f76591a = (int) motionEvent.getRawX();
                this.f76592b = (int) motionEvent.getRawY();
                this.f76593c = System.currentTimeMillis();
                this.f76597g.p = (int) motionEvent.getX();
                this.f76597g.q = (int) motionEvent.getY();
                E0.a(this.f76597g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f76594d = (int) motionEvent.getRawX();
                this.f76595e = (int) motionEvent.getRawY();
                this.f76596f = System.currentTimeMillis();
                this.f76597g.r = (int) motionEvent.getX();
                this.f76597g.s = (int) motionEvent.getY();
                E0 e0 = this.f76597g;
                Info info = e0.f76603c;
                if (info == null || !Q1.a(info, e0.f76608h)) {
                    return false;
                }
                this.f76597g.f76608h = System.currentTimeMillis();
                E0 e02 = this.f76597g;
                Context context = e02.f76601a;
                String open = e02.f76603c.getOpen();
                E0 e03 = this.f76597g;
                Q1.a(context, open, e03.f76603c, e03.f76607g, a().toString());
                Z0.a(this.f76597g.f76601a).a(new a1(this.f76597g.f76603c), (String) null).a("desc", a().toString()).a();
                N.a(this.f76597g.f76603c, a().toString());
                PBNativeListener pBNativeListener = this.f76597g.f76606f;
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
