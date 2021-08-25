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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class E0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f76601a;

    /* renamed from: b  reason: collision with root package name */
    public m1 f76602b;

    /* renamed from: c  reason: collision with root package name */
    public Info f76603c;

    /* renamed from: d  reason: collision with root package name */
    public View f76604d;

    /* renamed from: e  reason: collision with root package name */
    public List f76605e;

    /* renamed from: f  reason: collision with root package name */
    public PBNativeListener f76606f;

    /* renamed from: g  reason: collision with root package name */
    public g2 f76607g;

    /* renamed from: h  reason: collision with root package name */
    public long f76608h;

    /* renamed from: i  reason: collision with root package name */
    public n1 f76609i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f76610j;
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

    public E0(Context context, String str) {
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
        this.f76605e = Collections.synchronizedList(new ArrayList());
        this.f76608h = 0L;
        this.f76609i = new y0(this);
        this.f76610j = false;
        this.k = 0L;
        this.f76601a = context;
        m1 m1Var = new m1(context, str, M.f76635c);
        this.f76602b = m1Var;
        m1Var.f76923g = this.f76609i;
        this.f76607g = new g2(context);
    }

    public static /* synthetic */ void a(E0 e0, View view) {
        if (e0.t <= 0 || e0.u <= 0) {
            e0.u = view.getHeight();
            e0.t = view.getWidth();
        }
    }

    public final List a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            ArrayList arrayList = new ArrayList();
            if (view instanceof ViewGroup) {
                try {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        View childAt = viewGroup.getChildAt(i2);
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
                if (this.f76602b != null) {
                    this.f76602b.a();
                    this.f76602b = null;
                }
                if (this.f76606f != null) {
                    this.f76606f = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Info info = this.f76603c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                for (View view : this.f76605e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f76605e.clear();
                if (this.f76604d != null) {
                    this.f76604d = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public HashMap d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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

    public void a(View view, PBMediaView pBMediaView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, pBMediaView) == null) {
            List arrayList = new ArrayList();
            if (view != null) {
                arrayList = a(view);
            }
            a(view, pBMediaView, arrayList);
        }
    }

    public void a(View view, PBMediaView pBMediaView, List list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, view, pBMediaView, list) == null) || view == null || list == null || list.size() == 0 || !b()) {
            return;
        }
        this.f76608h = 0L;
        if (this.f76604d != null) {
            c();
        }
        this.f76604d = view;
        try {
            D0 d0 = new D0(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f76605e.contains(view2)) {
                        this.f76605e.add(view2);
                    }
                    view2.setOnClickListener(d0);
                    view2.setOnTouchListener(d0);
                }
            }
        } catch (Exception unused) {
        }
        if (pBMediaView != null) {
            try {
                if (pBMediaView.getHtmlWebView() != null) {
                    h0 htmlWebView = pBMediaView.getHtmlWebView();
                    htmlWebView.a(b() ? this.f76603c.getLoad() : "", this.f76603c);
                    if (this.f76603c.isNat()) {
                        htmlWebView.f76858c.setOnTouchListener(new B0(this));
                    }
                    htmlWebView.f76857b = new C0(this);
                }
            } catch (Exception unused2) {
            }
        }
        Z0.a(this.f76601a).b(new a1(this.f76603c)).a();
        PBNativeListener pBNativeListener = this.f76606f;
        if (pBNativeListener != null) {
            pBNativeListener.onDisplayed();
        }
        if (this.f76603c != null) {
            U1.b(this.f76601a, this.f76603c.getId() + ":" + System.currentTimeMillis(), false);
        }
        N.a(this.f76603c);
        new O0().a(view, this.f76603c, new A0(this, view));
    }
}
