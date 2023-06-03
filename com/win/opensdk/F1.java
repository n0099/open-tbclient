package com.win.opensdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.views.CircleProgressbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class F1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public r1 b;
    public Info c;
    public View d;
    public List e;
    public E f;
    public m2 g;
    public long h;
    public s1 i;
    public boolean j;
    public long k;
    public float l;
    public float m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public long v;
    public int w;
    public int x;
    public long y;

    public final List a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (view2 instanceof ViewGroup) {
                try {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt != null) {
                            arrayList.add(childAt);
                            if (!(childAt instanceof PBMediaView)) {
                                arrayList.addAll(a(childAt));
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                c();
                if (this.b != null) {
                    this.b.a();
                    this.b = null;
                }
                if (this.f != null) {
                    this.f = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Info info = this.c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                for (View view2 : this.e) {
                    if (view2 != null) {
                        view2.setOnClickListener(null);
                    }
                }
                this.e.clear();
                if (this.d != null) {
                    this.d = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public HashMap d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dx", Integer.valueOf(this.n));
            hashMap.put("dy", Integer.valueOf(this.o));
            hashMap.put("dts", Long.valueOf(this.v));
            hashMap.put("ux", Integer.valueOf(this.w));
            hashMap.put("uy", Integer.valueOf(this.x));
            hashMap.put("uts", Long.valueOf(this.y));
            M.a(hashMap, this.p, this.q, this.r, this.s, this.t, this.u);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public F1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = Collections.synchronizedList(new ArrayList());
        this.h = 0L;
        this.i = new z1(this);
        this.j = false;
        this.k = 0L;
        this.a = context;
        r1 r1Var = new r1(context, str, L.e);
        this.b = r1Var;
        r1Var.g = this.i;
        this.g = new m2(context);
    }

    public static /* synthetic */ void a(F1 f1, View view2) {
        if (f1.t <= 0 || f1.u <= 0) {
            f1.u = view2.getHeight();
            f1.t = view2.getWidth();
        }
    }

    public void a(View view2, PBMediaView pBMediaView) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, pBMediaView) == null) {
            List<View> arrayList = new ArrayList();
            if (view2 != null) {
                arrayList = a(view2);
            }
            if (view2 != null && arrayList != null && arrayList.size() != 0 && b()) {
                this.h = 0L;
                if (this.d != null) {
                    c();
                }
                this.d = view2;
                try {
                    E1 e1 = new E1(this);
                    for (View view3 : arrayList) {
                        if (view3 != null && !(view3 instanceof PBMediaView)) {
                            if (!this.e.contains(view3)) {
                                this.e.add(view3);
                            }
                            if (!(view3 instanceof CircleProgressbar)) {
                                view3.setOnClickListener(e1);
                                view3.setOnTouchListener(e1);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
                if (pBMediaView != null) {
                    try {
                        if (pBMediaView.getHtmlWebView() != null) {
                            g0 htmlWebView = pBMediaView.getHtmlWebView();
                            if (b()) {
                                str = this.c.getLoad();
                            } else {
                                str = "";
                            }
                            htmlWebView.a(str, this.c);
                            if (this.c.isNat()) {
                                htmlWebView.c.setOnTouchListener(new C1(this));
                            }
                            htmlWebView.b = new D1(this);
                        }
                    } catch (Exception unused2) {
                    }
                }
                e1.a(this.a).b(new f1(this.c)).a();
                if (this.c != null) {
                    Z1.b(this.a, this.c.getId() + ":" + System.currentTimeMillis(), false);
                }
                new N0().a(view2, this.c, new B1(this, view2));
            }
        }
    }
}
