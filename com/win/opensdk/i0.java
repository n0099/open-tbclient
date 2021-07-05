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
/* loaded from: classes7.dex */
public class i0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f42579a;

    /* renamed from: b  reason: collision with root package name */
    public K0 f42580b;

    /* renamed from: c  reason: collision with root package name */
    public Info f42581c;

    /* renamed from: d  reason: collision with root package name */
    public View f42582d;

    /* renamed from: e  reason: collision with root package name */
    public List f42583e;

    /* renamed from: f  reason: collision with root package name */
    public PBNativeListener f42584f;

    /* renamed from: g  reason: collision with root package name */
    public E1 f42585g;

    /* renamed from: h  reason: collision with root package name */
    public long f42586h;

    /* renamed from: i  reason: collision with root package name */
    public L0 f42587i;
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

    public i0(Context context, String str) {
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
        this.f42583e = Collections.synchronizedList(new ArrayList());
        this.f42586h = 0L;
        this.f42587i = new c0(this);
        this.j = false;
        this.k = 0L;
        this.f42579a = context;
        K0 k0 = new K0(context, str, y.f42704c);
        this.f42580b = k0;
        k0.f42385g = this.f42587i;
        this.f42585g = new E1(context);
    }

    public static /* synthetic */ void a(i0 i0Var, View view) {
        if (i0Var.t <= 0 || i0Var.u <= 0) {
            i0Var.u = view.getHeight();
            i0Var.t = view.getWidth();
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
                if (this.f42580b != null) {
                    this.f42580b.a();
                    this.f42580b = null;
                }
                if (this.f42584f != null) {
                    this.f42584f = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Info info = this.f42581c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                for (View view : this.f42583e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f42583e.clear();
                if (this.f42582d != null) {
                    this.f42582d = null;
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
            z.a(hashMap, this.p, this.q, this.r, this.s, this.t, this.u);
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
        this.f42586h = 0L;
        if (this.f42582d != null) {
            c();
        }
        this.f42582d = view;
        try {
            h0 h0Var = new h0(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                if (view2 != null && !(view2 instanceof PBMediaView)) {
                    if (!this.f42583e.contains(view2)) {
                        this.f42583e.add(view2);
                    }
                    view2.setOnClickListener(h0Var);
                    view2.setOnTouchListener(h0Var);
                }
            }
        } catch (Exception unused) {
        }
        if (pBMediaView != null) {
            try {
                if (pBMediaView.getHtmlWebView() != null) {
                    K htmlWebView = pBMediaView.getHtmlWebView();
                    htmlWebView.a(b() ? this.f42581c.getLoad() : "", this.f42581c);
                    if (this.f42581c.isNat()) {
                        htmlWebView.f42376c.setOnTouchListener(new f0(this));
                    }
                    htmlWebView.f42375b = new g0(this);
                }
            } catch (Exception unused2) {
            }
        }
        x0.a(this.f42579a).a(new y0(this.f42581c)).a();
        PBNativeListener pBNativeListener = this.f42584f;
        if (pBNativeListener != null) {
            pBNativeListener.onDisplayed();
        }
        if (this.f42581c != null) {
            s1.b(this.f42579a, this.f42581c.getId() + ":" + System.currentTimeMillis(), false);
        }
        z.a(this.f42581c);
        new m0().a(view, this.f42581c, new e0(this, view));
    }
}
