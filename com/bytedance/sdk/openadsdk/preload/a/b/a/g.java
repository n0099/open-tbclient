package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.q;
import com.bytedance.sdk.openadsdk.preload.a.t;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes6.dex */
public final class g implements w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f31732a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.c f31733b;

    /* loaded from: classes6.dex */
    public final class a<K, V> extends v<Map<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f31734a;

        /* renamed from: b  reason: collision with root package name */
        public final v<K> f31735b;

        /* renamed from: c  reason: collision with root package name */
        public final v<V> f31736c;

        /* renamed from: d  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.b.i<? extends Map<K, V>> f31737d;

        public a(g gVar, com.bytedance.sdk.openadsdk.preload.a.f fVar, Type type, v<K> vVar, Type type2, v<V> vVar2, com.bytedance.sdk.openadsdk.preload.a.b.i<? extends Map<K, V>> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, fVar, type, vVar, type2, vVar2, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31734a = gVar;
            this.f31735b = new m(fVar, vVar, type);
            this.f31736c = new m(fVar, vVar2, type2);
            this.f31737d = iVar;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public /* bridge */ /* synthetic */ void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException {
            a(cVar, (Map) ((Map) obj));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        /* renamed from: a */
        public Map<K, V> b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                com.bytedance.sdk.openadsdk.preload.a.d.b f2 = aVar.f();
                if (f2 == com.bytedance.sdk.openadsdk.preload.a.d.b.f31918i) {
                    aVar.j();
                    return null;
                }
                Map<K, V> a2 = this.f31737d.a();
                if (f2 == com.bytedance.sdk.openadsdk.preload.a.d.b.f31910a) {
                    aVar.a();
                    while (aVar.e()) {
                        aVar.a();
                        K b2 = this.f31735b.b(aVar);
                        if (a2.put(b2, this.f31736c.b(aVar)) == null) {
                            aVar.b();
                        } else {
                            throw new t("duplicate key: " + b2);
                        }
                    }
                    aVar.b();
                } else {
                    aVar.c();
                    while (aVar.e()) {
                        com.bytedance.sdk.openadsdk.preload.a.b.f.f31855a.a(aVar);
                        K b3 = this.f31735b.b(aVar);
                        if (a2.put(b3, this.f31736c.b(aVar)) != null) {
                            throw new t("duplicate key: " + b3);
                        }
                    }
                    aVar.d();
                }
                return a2;
            }
            return (Map) invokeL.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: com.bytedance.sdk.openadsdk.preload.a.v<V> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: com.bytedance.sdk.openadsdk.preload.a.v<V> */
        /* JADX WARN: Multi-variable type inference failed */
        public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Map<K, V> map) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, map) == null) {
                if (map == null) {
                    cVar.f();
                } else if (!this.f31734a.f31732a) {
                    cVar.d();
                    for (Map.Entry<K, V> entry : map.entrySet()) {
                        cVar.a(String.valueOf(entry.getKey()));
                        this.f31736c.a(cVar, entry.getValue());
                    }
                    cVar.e();
                } else {
                    ArrayList arrayList = new ArrayList(map.size());
                    ArrayList arrayList2 = new ArrayList(map.size());
                    int i2 = 0;
                    boolean z = false;
                    for (Map.Entry<K, V> entry2 : map.entrySet()) {
                        com.bytedance.sdk.openadsdk.preload.a.l a2 = this.f31735b.a(entry2.getKey());
                        arrayList.add(a2);
                        arrayList2.add(entry2.getValue());
                        z |= a2.g() || a2.h();
                    }
                    if (z) {
                        cVar.b();
                        int size = arrayList.size();
                        while (i2 < size) {
                            cVar.b();
                            com.bytedance.sdk.openadsdk.preload.a.b.l.a((com.bytedance.sdk.openadsdk.preload.a.l) arrayList.get(i2), cVar);
                            this.f31736c.a(cVar, arrayList2.get(i2));
                            cVar.c();
                            i2++;
                        }
                        cVar.c();
                        return;
                    }
                    cVar.d();
                    int size2 = arrayList.size();
                    while (i2 < size2) {
                        cVar.a(a((com.bytedance.sdk.openadsdk.preload.a.l) arrayList.get(i2)));
                        this.f31736c.a(cVar, arrayList2.get(i2));
                        i2++;
                    }
                    cVar.e();
                }
            }
        }

        private String a(com.bytedance.sdk.openadsdk.preload.a.l lVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, lVar)) == null) {
                if (lVar.i()) {
                    q m = lVar.m();
                    if (m.o()) {
                        return String.valueOf(m.a());
                    }
                    if (m.n()) {
                        return Boolean.toString(m.f());
                    }
                    if (m.p()) {
                        return m.b();
                    }
                    throw new AssertionError();
                } else if (lVar.j()) {
                    return StringUtil.NULL_STRING;
                } else {
                    throw new AssertionError();
                }
            }
            return (String) invokeL.objValue;
        }
    }

    public g(com.bytedance.sdk.openadsdk.preload.a.b.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31733b = cVar;
        this.f31732a = z;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) {
            Type b2 = aVar.b();
            if (Map.class.isAssignableFrom(aVar.a())) {
                Type[] b3 = com.bytedance.sdk.openadsdk.preload.a.b.b.b(b2, com.bytedance.sdk.openadsdk.preload.a.b.b.e(b2));
                return new a(this, fVar, b3[0], a(fVar, b3[0]), b3[1], fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(b3[1])), this.f31733b.a(aVar));
            }
            return null;
        }
        return (v) invokeLL.objValue;
    }

    private v<?> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, fVar, type)) == null) {
            if (type != Boolean.TYPE && type != Boolean.class) {
                return fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(type));
            }
            return n.f31782f;
        }
        return (v) invokeLL.objValue;
    }
}
