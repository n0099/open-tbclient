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
    public Context f77100a;

    /* renamed from: b  reason: collision with root package name */
    public m1 f77101b;

    /* renamed from: c  reason: collision with root package name */
    public Info f77102c;

    /* renamed from: d  reason: collision with root package name */
    public View f77103d;

    /* renamed from: e  reason: collision with root package name */
    public List f77104e;

    /* renamed from: f  reason: collision with root package name */
    public PBNativeListener f77105f;

    /* renamed from: g  reason: collision with root package name */
    public g2 f77106g;

    /* renamed from: h  reason: collision with root package name */
    public long f77107h;

    /* renamed from: i  reason: collision with root package name */
    public n1 f77108i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f77109j;
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
        this.f77104e = Collections.synchronizedList(new ArrayList());
        this.f77107h = 0L;
        this.f77108i = new y0(this);
        this.f77109j = false;
        this.k = 0L;
        this.f77100a = context;
        m1 m1Var = new m1(context, str, M.f77134c);
        this.f77101b = m1Var;
        m1Var.f77422g = this.f77108i;
        this.f77106g = new g2(context);
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
                if (this.f77101b != null) {
                    this.f77101b.a();
                    this.f77101b = null;
                }
                if (this.f77105f != null) {
                    this.f77105f = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Info info = this.f77102c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                for (View view : this.f77104e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f77104e.clear();
                if (this.f77103d != null) {
                    this.f77103d = null;
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
        this.f77107h = 0L;
        if (this.f77103d != null) {
            c();
        }
        this.f77103d = view;
        try {
            D0 d0 = new D0(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f77104e.contains(view2)) {
                        this.f77104e.add(view2);
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
                    htmlWebView.a(b() ? this.f77102c.getLoad() : "", this.f77102c);
                    if (this.f77102c.isNat()) {
                        htmlWebView.f77357c.setOnTouchListener(new B0(this));
                    }
                    htmlWebView.f77356b = new C0(this);
                }
            } catch (Exception unused2) {
            }
        }
        Z0.a(this.f77100a).b(new a1(this.f77102c)).a();
        PBNativeListener pBNativeListener = this.f77105f;
        if (pBNativeListener != null) {
            pBNativeListener.onDisplayed();
        }
        if (this.f77102c != null) {
            U1.b(this.f77100a, this.f77102c.getId() + ":" + System.currentTimeMillis(), false);
        }
        N.a(this.f77102c);
        new O0().a(view, this.f77102c, new A0(this, view));
    }
}
