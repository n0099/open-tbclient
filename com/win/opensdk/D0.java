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
    public int f77125a;

    /* renamed from: b  reason: collision with root package name */
    public int f77126b;

    /* renamed from: c  reason: collision with root package name */
    public long f77127c;

    /* renamed from: d  reason: collision with root package name */
    public int f77128d;

    /* renamed from: e  reason: collision with root package name */
    public int f77129e;

    /* renamed from: f  reason: collision with root package name */
    public long f77130f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ E0 f77131g;

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
        this.f77131g = e0;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f77125a));
            hashMap.put("dy", Integer.valueOf(this.f77126b));
            hashMap.put("dts", Long.valueOf(this.f77127c));
            hashMap.put("ux", Integer.valueOf(this.f77128d));
            hashMap.put("uy", Integer.valueOf(this.f77129e));
            hashMap.put("uts", Long.valueOf(this.f77130f));
            E0 e0 = this.f77131g;
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
                this.f77125a = (int) motionEvent.getRawX();
                this.f77126b = (int) motionEvent.getRawY();
                this.f77127c = System.currentTimeMillis();
                this.f77131g.p = (int) motionEvent.getX();
                this.f77131g.q = (int) motionEvent.getY();
                E0.a(this.f77131g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f77128d = (int) motionEvent.getRawX();
                this.f77129e = (int) motionEvent.getRawY();
                this.f77130f = System.currentTimeMillis();
                this.f77131g.r = (int) motionEvent.getX();
                this.f77131g.s = (int) motionEvent.getY();
                E0 e0 = this.f77131g;
                Info info = e0.f77137c;
                if (info == null || !Q1.a(info, e0.f77142h)) {
                    return false;
                }
                this.f77131g.f77142h = System.currentTimeMillis();
                E0 e02 = this.f77131g;
                Context context = e02.f77135a;
                String open = e02.f77137c.getOpen();
                E0 e03 = this.f77131g;
                Q1.a(context, open, e03.f77137c, e03.f77141g, a().toString());
                Z0.a(this.f77131g.f77135a).a(new a1(this.f77131g.f77137c), (String) null).a("desc", a().toString()).a();
                N.a(this.f77131g.f77137c, a().toString());
                PBNativeListener pBNativeListener = this.f77131g.f77140f;
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
