package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.L;
import com.win.opensdk.PBMediaView;
import com.win.opensdk.PBNativeListener;
import com.win.opensdk.core.Info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class mk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public wp9 b;
    public Info c;
    public View d;
    public List e;
    public PBNativeListener f;
    public dp9 g;
    public long h;
    public aq9 i;
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

    public mk9(Context context, String str) {
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
        this.i = new sq9(this);
        this.j = false;
        this.k = 0L;
        this.a = context;
        wp9 wp9Var = new wp9(context, str, L.c);
        this.b = wp9Var;
        wp9Var.g = this.i;
        this.g = new dp9(context);
    }

    public static /* synthetic */ void e(mk9 mk9Var, View view2) {
        if (mk9Var.t <= 0 || mk9Var.u <= 0) {
            mk9Var.u = view2.getHeight();
            mk9Var.t = view2.getWidth();
        }
    }

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

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                h();
                if (this.b != null) {
                    this.b.b();
                    this.b = null;
                }
                if (this.f != null) {
                    this.f = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void c(View view2, PBMediaView pBMediaView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, pBMediaView) == null) {
            List arrayList = new ArrayList();
            if (view2 != null) {
                arrayList = a(view2);
            }
            d(view2, pBMediaView, arrayList);
        }
    }

    public void d(View view2, PBMediaView pBMediaView, List list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, view2, pBMediaView, list) == null) || view2 == null || list == null || list.size() == 0 || !g()) {
            return;
        }
        this.h = 0L;
        if (this.d != null) {
            h();
        }
        this.d = view2;
        try {
            ik9 ik9Var = new ik9(this);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                View view3 = (View) it.next();
                if (view3 != null && !(view3 instanceof PBMediaView)) {
                    if (!this.e.contains(view3)) {
                        this.e.add(view3);
                    }
                    view3.setOnClickListener(ik9Var);
                    view3.setOnTouchListener(ik9Var);
                }
            }
        } catch (Exception unused) {
        }
        if (pBMediaView != null) {
            try {
                if (pBMediaView.getHtmlWebView() != null) {
                    fo9 htmlWebView = pBMediaView.getHtmlWebView();
                    htmlWebView.a(g() ? this.c.getLoad() : "", this.c);
                    if (this.c.isNat()) {
                        htmlWebView.c.setOnTouchListener(new bk9(this));
                    }
                    htmlWebView.b = new ek9(this);
                }
            } catch (Exception unused2) {
            }
        }
        un9 a = yn9.a(this.a);
        a.o(new co9(this.c));
        a.m();
        if (this.c != null) {
            in9.m(this.a, this.c.getId() + ":" + System.currentTimeMillis(), false);
        }
        new tl9().a(view2, this.c, new ar9(this, view2));
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Info info = this.c;
            return info != null && info.isEffective();
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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

    public HashMap i() {
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
            sl9.j(hashMap, this.p, this.q, this.r, this.s, this.t, this.u);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }
}
