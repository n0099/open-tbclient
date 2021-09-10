package com.bytedance.sdk.openadsdk.preload.a.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.t;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public final class i implements w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.c f68384a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.e f68385b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.d f68386c;

    /* renamed from: d  reason: collision with root package name */
    public final d f68387d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.b.b f68388e;

    /* loaded from: classes9.dex */
    public static final class a<T> extends v<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.b.i<T> f68396a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<String, b> f68397b;

        public a(com.bytedance.sdk.openadsdk.preload.a.b.i<T> iVar, Map<String, b> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68396a = iVar;
            this.f68397b = map;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, t) == null) {
                if (t == null) {
                    cVar.f();
                    return;
                }
                cVar.d();
                try {
                    for (b bVar : this.f68397b.values()) {
                        if (bVar.a(t)) {
                            cVar.a(bVar.f68398h);
                            bVar.a(cVar, t);
                        }
                    }
                    cVar.e();
                } catch (IllegalAccessException e2) {
                    throw new AssertionError(e2);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.f68564i) {
                    aVar.j();
                    return null;
                }
                T a2 = this.f68396a.a();
                try {
                    aVar.c();
                    while (aVar.e()) {
                        b bVar = this.f68397b.get(aVar.g());
                        if (bVar != null && bVar.f68400j) {
                            bVar.a(aVar, a2);
                        }
                        aVar.n();
                    }
                    aVar.d();
                    return a2;
                } catch (IllegalAccessException e2) {
                    throw new AssertionError(e2);
                } catch (IllegalStateException e3) {
                    throw new t(e3);
                }
            }
            return (T) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final String f68398h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f68399i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f68400j;

        public b(String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68398h = str;
            this.f68399i = z;
            this.f68400j = z2;
        }

        public abstract void a(com.bytedance.sdk.openadsdk.preload.a.d.a aVar, Object obj) throws IOException, IllegalAccessException;

        public abstract void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException, IllegalAccessException;

        public abstract boolean a(Object obj) throws IOException, IllegalAccessException;
    }

    public i(com.bytedance.sdk.openadsdk.preload.a.b.c cVar, com.bytedance.sdk.openadsdk.preload.a.e eVar, com.bytedance.sdk.openadsdk.preload.a.b.d dVar, d dVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, eVar, dVar, dVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68388e = com.bytedance.sdk.openadsdk.preload.a.b.b.b.a();
        this.f68384a = cVar;
        this.f68385b = eVar;
        this.f68386c = dVar;
        this.f68387d = dVar2;
    }

    public boolean a(Field field, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, field, z)) == null) ? a(field, z, this.f68386c) : invokeLZ.booleanValue;
    }

    public static boolean a(Field field, boolean z, com.bytedance.sdk.openadsdk.preload.a.b.d dVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{field, Boolean.valueOf(z), dVar})) == null) ? (dVar.a(field.getType(), z) || dVar.a(field, z)) ? false : true : invokeCommon.booleanValue;
    }

    private List<String> a(Field field) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, field)) == null) {
            com.bytedance.sdk.openadsdk.preload.a.a.c cVar = (com.bytedance.sdk.openadsdk.preload.a.a.c) field.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.c.class);
            if (cVar == null) {
                return Collections.singletonList(this.f68385b.a(field));
            }
            String a2 = cVar.a();
            String[] b2 = cVar.b();
            if (b2.length == 0) {
                return Collections.singletonList(a2);
            }
            ArrayList arrayList = new ArrayList(b2.length + 1);
            arrayList.add(a2);
            for (String str : b2) {
                arrayList.add(str);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) {
            Class<? super T> a2 = aVar.a();
            if (Object.class.isAssignableFrom(a2)) {
                return new a(this.f68384a.a(aVar), a(fVar, (com.bytedance.sdk.openadsdk.preload.a.c.a<?>) aVar, (Class<?>) a2));
            }
            return null;
        }
        return (v) invokeLL.objValue;
    }

    private b a(com.bytedance.sdk.openadsdk.preload.a.f fVar, Field field, String str, com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{fVar, field, str, aVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean a2 = com.bytedance.sdk.openadsdk.preload.a.b.k.a(aVar.a());
            com.bytedance.sdk.openadsdk.preload.a.a.b bVar = (com.bytedance.sdk.openadsdk.preload.a.a.b) field.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.b.class);
            v<?> a3 = bVar != null ? this.f68387d.a(this.f68384a, fVar, aVar, bVar) : null;
            boolean z3 = a3 != null;
            if (a3 == null) {
                a3 = fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) aVar);
            }
            return new b(this, str, z, z2, field, z3, a3, fVar, aVar, a2) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.i.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Field f68389a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f68390b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ v f68391c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.preload.a.f f68392d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.preload.a.c.a f68393e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f68394f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ i f68395g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(str, z, z2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r3;
                        Object[] objArr = {this, str, Boolean.valueOf(z), Boolean.valueOf(z2), field, Boolean.valueOf(z3), a3, fVar, aVar, Boolean.valueOf(a2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68395g = this;
                    this.f68389a = field;
                    this.f68390b = z3;
                    this.f68391c = a3;
                    this.f68392d = fVar;
                    this.f68393e = aVar;
                    this.f68394f = a2;
                }

                @Override // com.bytedance.sdk.openadsdk.preload.a.b.a.i.b
                public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException, IllegalAccessException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, obj) == null) {
                        (this.f68390b ? this.f68391c : new m(this.f68392d, this.f68391c, this.f68393e.b())).a(cVar, this.f68389a.get(obj));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.preload.a.b.a.i.b
                public void a(com.bytedance.sdk.openadsdk.preload.a.d.a aVar2, Object obj) throws IOException, IllegalAccessException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, aVar2, obj) == null) {
                        Object b2 = this.f68391c.b(aVar2);
                        if (b2 == null && this.f68394f) {
                            return;
                        }
                        this.f68389a.set(obj, b2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.preload.a.b.a.i.b
                public boolean a(Object obj) throws IOException, IllegalAccessException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? this.f68399i && this.f68389a.get(obj) != obj : invokeL.booleanValue;
                }
            };
        }
        return (b) invokeCommon.objValue;
    }

    private Map<String, b> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, Class<?> cls) {
        InterceptResult invokeLLL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, fVar, aVar, cls)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (cls.isInterface()) {
                return linkedHashMap;
            }
            Type b2 = aVar.b();
            com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar2 = aVar;
            Class<?> cls2 = cls;
            while (cls2 != Object.class) {
                Field[] declaredFields = cls2.getDeclaredFields();
                int length = declaredFields.length;
                boolean z = false;
                int i2 = 0;
                while (i2 < length) {
                    Field field = declaredFields[i2];
                    boolean a2 = a(field, true);
                    boolean a3 = a(field, z);
                    if (a2 || a3) {
                        this.f68388e.a(field);
                        Type a4 = com.bytedance.sdk.openadsdk.preload.a.b.b.a(aVar2.b(), cls2, field.getGenericType());
                        List<String> a5 = a(field);
                        int size = a5.size();
                        b bVar2 = null;
                        int i3 = 0;
                        while (i3 < size) {
                            String str = a5.get(i3);
                            boolean z2 = i3 != 0 ? false : a2;
                            int i4 = i3;
                            b bVar3 = bVar2;
                            int i5 = size;
                            List<String> list = a5;
                            Field field2 = field;
                            bVar2 = bVar3 == null ? (b) linkedHashMap.put(str, a(fVar, field, str, com.bytedance.sdk.openadsdk.preload.a.c.a.a(a4), z2, a3)) : bVar3;
                            i3 = i4 + 1;
                            a2 = z2;
                            a5 = list;
                            size = i5;
                            field = field2;
                        }
                        if (bVar2 != null) {
                            throw new IllegalArgumentException(b2 + " declares multiple JSON fields named " + bVar.f68398h);
                        }
                    }
                    i2++;
                    z = false;
                }
                aVar2 = com.bytedance.sdk.openadsdk.preload.a.c.a.a(com.bytedance.sdk.openadsdk.preload.a.b.b.a(aVar2.b(), cls2, cls2.getGenericSuperclass()));
                cls2 = aVar2.a();
            }
            return linkedHashMap;
        }
        return (Map) invokeLLL.objValue;
    }
}
