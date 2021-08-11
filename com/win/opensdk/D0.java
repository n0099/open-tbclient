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
    public int f76390a;

    /* renamed from: b  reason: collision with root package name */
    public int f76391b;

    /* renamed from: c  reason: collision with root package name */
    public long f76392c;

    /* renamed from: d  reason: collision with root package name */
    public int f76393d;

    /* renamed from: e  reason: collision with root package name */
    public int f76394e;

    /* renamed from: f  reason: collision with root package name */
    public long f76395f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ E0 f76396g;

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
        this.f76396g = e0;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f76390a));
            hashMap.put("dy", Integer.valueOf(this.f76391b));
            hashMap.put("dts", Long.valueOf(this.f76392c));
            hashMap.put("ux", Integer.valueOf(this.f76393d));
            hashMap.put("uy", Integer.valueOf(this.f76394e));
            hashMap.put("uts", Long.valueOf(this.f76395f));
            E0 e0 = this.f76396g;
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
                this.f76390a = (int) motionEvent.getRawX();
                this.f76391b = (int) motionEvent.getRawY();
                this.f76392c = System.currentTimeMillis();
                this.f76396g.p = (int) motionEvent.getX();
                this.f76396g.q = (int) motionEvent.getY();
                E0.a(this.f76396g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f76393d = (int) motionEvent.getRawX();
                this.f76394e = (int) motionEvent.getRawY();
                this.f76395f = System.currentTimeMillis();
                this.f76396g.r = (int) motionEvent.getX();
                this.f76396g.s = (int) motionEvent.getY();
                E0 e0 = this.f76396g;
                Info info = e0.f76402c;
                if (info == null || !Q1.a(info, e0.f76407h)) {
                    return false;
                }
                this.f76396g.f76407h = System.currentTimeMillis();
                E0 e02 = this.f76396g;
                Context context = e02.f76400a;
                String open = e02.f76402c.getOpen();
                E0 e03 = this.f76396g;
                Q1.a(context, open, e03.f76402c, e03.f76406g, a().toString());
                Z0.a(this.f76396g.f76400a).a(new a1(this.f76396g.f76402c), (String) null).a("desc", a().toString()).a();
                N.a(this.f76396g.f76402c, a().toString());
                PBNativeListener pBNativeListener = this.f76396g.f76405f;
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
