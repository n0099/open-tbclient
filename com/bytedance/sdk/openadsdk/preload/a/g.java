package com.bytedance.sdk.openadsdk.preload.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.a.b.d f68411a;

    /* renamed from: b  reason: collision with root package name */
    public u f68412b;

    /* renamed from: c  reason: collision with root package name */
    public e f68413c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Type, h<?>> f68414d;

    /* renamed from: e  reason: collision with root package name */
    public final List<w> f68415e;

    /* renamed from: f  reason: collision with root package name */
    public final List<w> f68416f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68417g;

    /* renamed from: h  reason: collision with root package name */
    public String f68418h;

    /* renamed from: i  reason: collision with root package name */
    public int f68419i;

    /* renamed from: j  reason: collision with root package name */
    public int f68420j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68411a = com.bytedance.sdk.openadsdk.preload.a.b.d.f68306a;
        this.f68412b = u.f68425a;
        this.f68413c = d.f68359a;
        this.f68414d = new HashMap();
        this.f68415e = new ArrayList();
        this.f68416f = new ArrayList();
        this.f68417g = false;
        this.f68419i = 2;
        this.f68420j = 2;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = false;
    }

    public g a(Type type, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, type, obj)) == null) {
            boolean z = obj instanceof s;
            com.bytedance.sdk.openadsdk.preload.a.b.a.a(z || (obj instanceof k) || (obj instanceof h) || (obj instanceof v));
            if (obj instanceof h) {
                this.f68414d.put(type, (h) obj);
            }
            if (z || (obj instanceof k)) {
                this.f68415e.add(com.bytedance.sdk.openadsdk.preload.a.b.a.l.a(com.bytedance.sdk.openadsdk.preload.a.c.a.a(type), obj));
            }
            if (obj instanceof v) {
                this.f68415e.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(com.bytedance.sdk.openadsdk.preload.a.c.a.a(type), (v) obj));
            }
            return this;
        }
        return (g) invokeLL.objValue;
    }

    public f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<w> arrayList = new ArrayList<>(this.f68415e.size() + this.f68416f.size() + 3);
            arrayList.addAll(this.f68415e);
            Collections.reverse(arrayList);
            ArrayList arrayList2 = new ArrayList(this.f68416f);
            Collections.reverse(arrayList2);
            arrayList.addAll(arrayList2);
            a(this.f68418h, this.f68419i, this.f68420j, arrayList);
            return new f(this.f68411a, this.f68413c, this.f68414d, this.f68417g, this.k, this.o, this.m, this.n, this.p, this.l, this.f68412b, this.f68418h, this.f68419i, this.f68420j, this.f68415e, this.f68416f, arrayList);
        }
        return (f) invokeV.objValue;
    }

    private void a(String str, int i2, int i3, List<w> list) {
        a aVar;
        a aVar2;
        a aVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), list}) == null) {
            if (str != null && !"".equals(str.trim())) {
                aVar = new a(Date.class, str);
                aVar2 = new a(Timestamp.class, str);
                aVar3 = new a(java.sql.Date.class, str);
            } else if (i2 == 2 || i3 == 2) {
                return;
            } else {
                a aVar4 = new a(Date.class, i2, i3);
                a aVar5 = new a(Timestamp.class, i2, i3);
                a aVar6 = new a(java.sql.Date.class, i2, i3);
                aVar = aVar4;
                aVar2 = aVar5;
                aVar3 = aVar6;
            }
            list.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(Date.class, aVar));
            list.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(Timestamp.class, aVar2));
            list.add(com.bytedance.sdk.openadsdk.preload.a.b.a.n.a(java.sql.Date.class, aVar3));
        }
    }
}
