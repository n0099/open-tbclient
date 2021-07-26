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
public class D0 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f39555a;

    /* renamed from: b  reason: collision with root package name */
    public int f39556b;

    /* renamed from: c  reason: collision with root package name */
    public long f39557c;

    /* renamed from: d  reason: collision with root package name */
    public int f39558d;

    /* renamed from: e  reason: collision with root package name */
    public int f39559e;

    /* renamed from: f  reason: collision with root package name */
    public long f39560f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ E0 f39561g;

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
        this.f39561g = e0;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f39555a));
            hashMap.put("dy", Integer.valueOf(this.f39556b));
            hashMap.put("dts", Long.valueOf(this.f39557c));
            hashMap.put("ux", Integer.valueOf(this.f39558d));
            hashMap.put("uy", Integer.valueOf(this.f39559e));
            hashMap.put("uts", Long.valueOf(this.f39560f));
            E0 e0 = this.f39561g;
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
                this.f39555a = (int) motionEvent.getRawX();
                this.f39556b = (int) motionEvent.getRawY();
                this.f39557c = System.currentTimeMillis();
                this.f39561g.p = (int) motionEvent.getX();
                this.f39561g.q = (int) motionEvent.getY();
                E0.a(this.f39561g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f39558d = (int) motionEvent.getRawX();
                this.f39559e = (int) motionEvent.getRawY();
                this.f39560f = System.currentTimeMillis();
                this.f39561g.r = (int) motionEvent.getX();
                this.f39561g.s = (int) motionEvent.getY();
                E0 e0 = this.f39561g;
                Info info = e0.f39567c;
                if (info == null || !Q1.a(info, e0.f39572h)) {
                    return false;
                }
                this.f39561g.f39572h = System.currentTimeMillis();
                E0 e02 = this.f39561g;
                Context context = e02.f39565a;
                String open = e02.f39567c.getOpen();
                E0 e03 = this.f39561g;
                Q1.a(context, open, e03.f39567c, e03.f39571g, a().toString());
                Z0.a(this.f39561g.f39565a).a(new a1(this.f39561g.f39567c), (String) null).a("desc", a().toString()).a();
                N.a(this.f39561g.f39567c, a().toString());
                PBNativeListener pBNativeListener = this.f39561g.f39570f;
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
