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
/* loaded from: classes6.dex */
public class Y0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f39520a;

    /* renamed from: b  reason: collision with root package name */
    public K0 f39521b;

    /* renamed from: c  reason: collision with root package name */
    public Info f39522c;

    /* renamed from: d  reason: collision with root package name */
    public View f39523d;

    /* renamed from: e  reason: collision with root package name */
    public List f39524e;

    /* renamed from: f  reason: collision with root package name */
    public r f39525f;

    /* renamed from: g  reason: collision with root package name */
    public E1 f39526g;

    /* renamed from: h  reason: collision with root package name */
    public long f39527h;

    /* renamed from: i  reason: collision with root package name */
    public L0 f39528i;
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
        this.f39524e = Collections.synchronizedList(new ArrayList());
        this.f39527h = 0L;
        this.f39528i = new S0(this);
        this.j = false;
        this.k = 0L;
        this.f39520a = context;
        K0 k0 = new K0(context, str, y.f39720e);
        this.f39521b = k0;
        k0.f39399g = this.f39528i;
        this.f39526g = new E1(context);
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
                if (this.f39521b != null) {
                    this.f39521b.a();
                    this.f39521b = null;
                }
                if (this.f39525f != null) {
                    this.f39525f = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Info info = this.f39522c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                for (View view : this.f39524e) {
                    if (view != null) {
                        view.setOnClickListener(null);
                    }
                }
                this.f39524e.clear();
                if (this.f39523d != null) {
                    this.f39523d = null;
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
            this.f39527h = 0L;
            if (this.f39523d != null) {
                c();
            }
            this.f39523d = view;
            try {
                X0 x0 = new X0(this);
                for (View view2 : arrayList) {
                    if (view2 != null && !(view2 instanceof PBMediaView)) {
                        if (!this.f39524e.contains(view2)) {
                            this.f39524e.add(view2);
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
                        htmlWebView.a(b() ? this.f39522c.getLoad() : "", this.f39522c);
                        if (this.f39522c.isNat()) {
                            htmlWebView.f39390c.setOnTouchListener(new V0(this));
                        }
                        htmlWebView.f39389b = new W0(this);
                    }
                } catch (Exception unused2) {
                }
            }
            x0.a(this.f39520a).a(new y0(this.f39522c)).a();
            r rVar = this.f39525f;
            if (rVar != null) {
                rVar.onDisplayed();
            }
            if (this.f39522c != null) {
                s1.b(this.f39520a, this.f39522c.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.a(this.f39522c);
            new m0().a(view, this.f39522c, new U0(this, view));
        }
    }
}
