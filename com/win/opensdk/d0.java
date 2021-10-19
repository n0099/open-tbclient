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
/* loaded from: classes10.dex */
public class d0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f77352a;

    /* renamed from: b  reason: collision with root package name */
    public m1 f77353b;

    /* renamed from: c  reason: collision with root package name */
    public Info f77354c;

    /* renamed from: d  reason: collision with root package name */
    public View f77355d;

    /* renamed from: e  reason: collision with root package name */
    public List f77356e;

    /* renamed from: f  reason: collision with root package name */
    public f f77357f;

    /* renamed from: g  reason: collision with root package name */
    public g2 f77358g;

    /* renamed from: h  reason: collision with root package name */
    public long f77359h;

    /* renamed from: i  reason: collision with root package name */
    public n1 f77360i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f77361j;
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

    public d0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77356e = Collections.synchronizedList(new ArrayList());
        this.f77359h = 0L;
        this.f77360i = new X(this);
        this.f77361j = false;
        this.k = 0L;
        this.f77352a = context;
        m1 m1Var = new m1(context, str, M.f77172f);
        this.f77353b = m1Var;
        m1Var.f77457g = this.f77360i;
        this.f77358g = new g2(context);
    }

    public static /* synthetic */ void a(d0 d0Var, View view) {
        if (d0Var.t <= 0 || d0Var.u <= 0) {
            d0Var.u = view.getHeight();
            d0Var.t = view.getWidth();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                c();
                if (this.f77353b != null) {
                    this.f77353b.a();
                    this.f77353b = null;
                }
                if (this.f77357f != null) {
                    this.f77357f = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Info info = this.f77354c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                for (View view : this.f77356e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f77356e.clear();
                if (this.f77355d != null) {
                    this.f77355d = null;
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
            N.a(hashMap, this.p, this.q, this.r, this.s, this.t, this.u);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public void a(View view, PBMediaView pBMediaView, List list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, pBMediaView, list) == null) || view == null || list == null || list.size() == 0 || !b()) {
            return;
        }
        this.f77359h = 0L;
        if (this.f77355d != null) {
            c();
        }
        this.f77355d = view;
        try {
            c0 c0Var = new c0(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f77356e.contains(view2)) {
                        this.f77356e.add(view2);
                    }
                    if (!(view2 instanceof CircleProgressbar)) {
                        view2.setOnClickListener(c0Var);
                        view2.setOnTouchListener(c0Var);
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (pBMediaView != null) {
            try {
                if (pBMediaView.getHtmlWebView() != null) {
                    h0 htmlWebView = pBMediaView.getHtmlWebView();
                    htmlWebView.a(b() ? this.f77354c.getLoad() : "", this.f77354c);
                    if (this.f77354c.isNat()) {
                        htmlWebView.f77392c.setOnTouchListener(new a0(this));
                    }
                    htmlWebView.f77391b = new b0(this);
                }
            } catch (Exception unused2) {
            }
        }
        Z0.a(this.f77352a).b(new a1(this.f77354c)).a();
        f fVar = this.f77357f;
        if (fVar != null) {
            fVar.onDisplayed();
        }
        if (this.f77354c != null) {
            U1.b(this.f77352a, this.f77354c.getId() + ":" + System.currentTimeMillis(), false);
        }
        N.a(this.f77354c);
        new O0().a(view, this.f77354c, new Z(this, view));
    }
}
