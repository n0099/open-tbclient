package com.win.opensdk;

import android.content.Context;
import android.view.View;
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
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public r1 b;
    public Info c;
    public View d;
    public List e;
    public f f;
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

    public c0(Context context, String str) {
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
        this.i = new W(this);
        this.j = false;
        this.k = 0L;
        this.a = context;
        r1 r1Var = new r1(context, str, L.f);
        this.b = r1Var;
        r1Var.g = this.i;
        this.g = new m2(context);
    }

    public static /* synthetic */ void a(c0 c0Var, View view2) {
        if (c0Var.t <= 0 || c0Var.u <= 0) {
            c0Var.u = view2.getHeight();
            c0Var.t = view2.getWidth();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Info info = this.c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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

    public void a(View view2, PBMediaView pBMediaView, List list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, pBMediaView, list) == null) || view2 == null || list == null || list.size() == 0 || !b()) {
            return;
        }
        this.h = 0L;
        if (this.d != null) {
            c();
        }
        this.d = view2;
        try {
            b0 b0Var = new b0(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view3 = (View) it.next();
                if (view3 != null && !(view3 instanceof PBMediaView)) {
                    if (!this.e.contains(view3)) {
                        this.e.add(view3);
                    }
                    if (!(view3 instanceof CircleProgressbar)) {
                        view3.setOnClickListener(b0Var);
                        view3.setOnTouchListener(b0Var);
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (pBMediaView != null) {
            try {
                if (pBMediaView.getHtmlWebView() != null) {
                    g0 htmlWebView = pBMediaView.getHtmlWebView();
                    htmlWebView.a(b() ? this.c.getLoad() : "", this.c);
                    if (this.c.isNat()) {
                        htmlWebView.c.setOnTouchListener(new Z(this));
                    }
                    htmlWebView.b = new a0(this);
                }
            } catch (Exception unused2) {
            }
        }
        e1.a(this.a).b(new f1(this.c)).a();
        if (this.c != null) {
            Z1.b(this.a, this.c.getId() + ":" + System.currentTimeMillis(), false);
        }
        new N0().a(view2, this.c, new Y(this, view2));
    }
}
