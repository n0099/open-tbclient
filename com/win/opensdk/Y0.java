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
/* loaded from: classes7.dex */
public class Y0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f42506a;

    /* renamed from: b  reason: collision with root package name */
    public K0 f42507b;

    /* renamed from: c  reason: collision with root package name */
    public Info f42508c;

    /* renamed from: d  reason: collision with root package name */
    public View f42509d;

    /* renamed from: e  reason: collision with root package name */
    public List f42510e;

    /* renamed from: f  reason: collision with root package name */
    public r f42511f;

    /* renamed from: g  reason: collision with root package name */
    public E1 f42512g;

    /* renamed from: h  reason: collision with root package name */
    public long f42513h;

    /* renamed from: i  reason: collision with root package name */
    public L0 f42514i;
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

    public Y0(Context context, String str) {
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
        this.f42510e = Collections.synchronizedList(new ArrayList());
        this.f42513h = 0L;
        this.f42514i = new S0(this);
        this.j = false;
        this.k = 0L;
        this.f42506a = context;
        K0 k0 = new K0(context, str, y.f42706e);
        this.f42507b = k0;
        k0.f42385g = this.f42514i;
        this.f42512g = new E1(context);
    }

    public static /* synthetic */ void a(Y0 y0, View view) {
        if (y0.t <= 0 || y0.u <= 0) {
            y0.u = view.getHeight();
            y0.t = view.getWidth();
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
                if (this.f42507b != null) {
                    this.f42507b.a();
                    this.f42507b = null;
                }
                if (this.f42511f != null) {
                    this.f42511f = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Info info = this.f42508c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                for (View view : this.f42510e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f42510e.clear();
                if (this.f42509d != null) {
                    this.f42509d = null;
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
            z.a(hashMap, this.p, this.q, this.r, this.s, this.t, this.u);
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
            this.f42513h = 0L;
            if (this.f42509d != null) {
                c();
            }
            this.f42509d = view;
            try {
                X0 x0 = new X0(this);
                for (View view2 : arrayList) {
                    if (view2 != null && !(view2 instanceof PBMediaView)) {
                        if (!this.f42510e.contains(view2)) {
                            this.f42510e.add(view2);
                        }
                        if (!(view2 instanceof CircleProgressbar)) {
                            view2.setOnClickListener(x0);
                            view2.setOnTouchListener(x0);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            if (pBMediaView != null) {
                try {
                    if (pBMediaView.getHtmlWebView() != null) {
                        K htmlWebView = pBMediaView.getHtmlWebView();
                        htmlWebView.a(b() ? this.f42508c.getLoad() : "", this.f42508c);
                        if (this.f42508c.isNat()) {
                            htmlWebView.f42376c.setOnTouchListener(new V0(this));
                        }
                        htmlWebView.f42375b = new W0(this);
                    }
                } catch (Exception unused2) {
                }
            }
            x0.a(this.f42506a).a(new y0(this.f42508c)).a();
            r rVar = this.f42511f;
            if (rVar != null) {
                rVar.onDisplayed();
            }
            if (this.f42508c != null) {
                s1.b(this.f42506a, this.f42508c.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.a(this.f42508c);
            new m0().a(view, this.f42508c, new U0(this, view));
        }
    }
}
