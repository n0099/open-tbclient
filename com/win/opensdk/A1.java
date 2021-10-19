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
public class A1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f77108a;

    /* renamed from: b  reason: collision with root package name */
    public m1 f77109b;

    /* renamed from: c  reason: collision with root package name */
    public Info f77110c;

    /* renamed from: d  reason: collision with root package name */
    public View f77111d;

    /* renamed from: e  reason: collision with root package name */
    public List f77112e;

    /* renamed from: f  reason: collision with root package name */
    public F f77113f;

    /* renamed from: g  reason: collision with root package name */
    public g2 f77114g;

    /* renamed from: h  reason: collision with root package name */
    public long f77115h;

    /* renamed from: i  reason: collision with root package name */
    public n1 f77116i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f77117j;
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

    public A1(Context context, String str) {
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
        this.f77112e = Collections.synchronizedList(new ArrayList());
        this.f77115h = 0L;
        this.f77116i = new u1(this);
        this.f77117j = false;
        this.k = 0L;
        this.f77108a = context;
        m1 m1Var = new m1(context, str, M.f77171e);
        this.f77109b = m1Var;
        m1Var.f77457g = this.f77116i;
        this.f77114g = new g2(context);
    }

    public static /* synthetic */ void a(A1 a1, View view) {
        if (a1.t <= 0 || a1.u <= 0) {
            a1.u = view.getHeight();
            a1.t = view.getWidth();
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
                if (this.f77109b != null) {
                    this.f77109b.a();
                    this.f77109b = null;
                }
                if (this.f77113f != null) {
                    this.f77113f = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Info info = this.f77110c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                for (View view : this.f77112e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f77112e.clear();
                if (this.f77111d != null) {
                    this.f77111d = null;
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
            N.a(hashMap, this.p, this.q, this.r, this.s, this.t, this.u);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public void a(View view, PBMediaView pBMediaView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, pBMediaView) == null) {
            List<View> arrayList = new ArrayList();
            if (view != null) {
                arrayList = a(view);
            }
            if (view == null || arrayList == null || arrayList.size() == 0 || !b()) {
                return;
            }
            this.f77115h = 0L;
            if (this.f77111d != null) {
                c();
            }
            this.f77111d = view;
            try {
                z1 z1Var = new z1(this);
                for (View view2 : arrayList) {
                    if (view2 != null && !(view2 instanceof PBMediaView)) {
                        if (!this.f77112e.contains(view2)) {
                            this.f77112e.add(view2);
                        }
                        if (!(view2 instanceof CircleProgressbar)) {
                            view2.setOnClickListener(z1Var);
                            view2.setOnTouchListener(z1Var);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            if (pBMediaView != null) {
                try {
                    if (pBMediaView.getHtmlWebView() != null) {
                        h0 htmlWebView = pBMediaView.getHtmlWebView();
                        htmlWebView.a(b() ? this.f77110c.getLoad() : "", this.f77110c);
                        if (this.f77110c.isNat()) {
                            htmlWebView.f77392c.setOnTouchListener(new x1(this));
                        }
                        htmlWebView.f77391b = new y1(this);
                    }
                } catch (Exception unused2) {
                }
            }
            Z0.a(this.f77108a).b(new a1(this.f77110c)).a();
            F f2 = this.f77113f;
            if (f2 != null) {
                f2.onDisplayed();
            }
            if (this.f77110c != null) {
                U1.b(this.f77108a, this.f77110c.getId() + ":" + System.currentTimeMillis(), false);
            }
            N.a(this.f77110c);
            new O0().a(view, this.f77110c, new w1(this, view));
        }
    }
}
