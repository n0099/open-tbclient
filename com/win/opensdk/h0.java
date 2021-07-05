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
public class h0 implements View.OnClickListener, View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f42571a;

    /* renamed from: b  reason: collision with root package name */
    public int f42572b;

    /* renamed from: c  reason: collision with root package name */
    public long f42573c;

    /* renamed from: d  reason: collision with root package name */
    public int f42574d;

    /* renamed from: e  reason: collision with root package name */
    public int f42575e;

    /* renamed from: f  reason: collision with root package name */
    public long f42576f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i0 f42577g;

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
        this.f42577g = i0Var;
    }

    public HashMap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.f42571a));
            hashMap.put("dy", Integer.valueOf(this.f42572b));
            hashMap.put("dts", Long.valueOf(this.f42573c));
            hashMap.put("ux", Integer.valueOf(this.f42574d));
            hashMap.put("uy", Integer.valueOf(this.f42575e));
            hashMap.put("uts", Long.valueOf(this.f42576f));
            i0 i0Var = this.f42577g;
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
                this.f42571a = (int) motionEvent.getRawX();
                this.f42572b = (int) motionEvent.getRawY();
                this.f42573c = System.currentTimeMillis();
                this.f42577g.p = (int) motionEvent.getX();
                this.f42577g.q = (int) motionEvent.getY();
                i0.a(this.f42577g, view);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                this.f42574d = (int) motionEvent.getRawX();
                this.f42575e = (int) motionEvent.getRawY();
                this.f42576f = System.currentTimeMillis();
                this.f42577g.r = (int) motionEvent.getX();
                this.f42577g.s = (int) motionEvent.getY();
                i0 i0Var = this.f42577g;
                Info info = i0Var.f42581c;
                if (info == null || !o1.a(info, i0Var.f42586h)) {
                    return false;
                }
                this.f42577g.f42586h = System.currentTimeMillis();
                i0 i0Var2 = this.f42577g;
                Context context = i0Var2.f42579a;
                String open = i0Var2.f42581c.getOpen();
                i0 i0Var3 = this.f42577g;
                o1.a(context, open, i0Var3.f42581c, i0Var3.f42585g, a().toString());
                x0.a(this.f42577g.f42579a).a(new y0(this.f42577g.f42581c), (String) null).a("desc", a().toString()).a();
                z.a(this.f42577g.f42581c, a().toString());
                PBNativeListener pBNativeListener = this.f42577g.f42584f;
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
