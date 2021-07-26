package com.bytedance.sdk.openadsdk.preload.a.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class d implements w, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final d f32152a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public double f32153b;

    /* renamed from: c  reason: collision with root package name */
    public int f32154c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32155d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32156e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.preload.a.b> f32157f;

    /* renamed from: g  reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.preload.a.b> f32158g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(639650733, "Lcom/bytedance/sdk/openadsdk/preload/a/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(639650733, "Lcom/bytedance/sdk/openadsdk/preload/a/b/d;");
                return;
            }
        }
        f32152a = new d();
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32153b = -1.0d;
        this.f32154c = 136;
        this.f32155d = true;
        this.f32157f = Collections.emptyList();
        this.f32158g = Collections.emptyList();
    }

    private boolean b(Class<?> cls, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, this, cls, z)) == null) {
            for (com.bytedance.sdk.openadsdk.preload.a.b bVar : z ? this.f32157f : this.f32158g) {
                if (bVar.a(cls)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    private boolean c(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, this, cls)) == null) ? cls.isMemberClass() && !d(cls) : invokeL.booleanValue;
    }

    private boolean d(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, this, cls)) == null) ? (cls.getModifiers() & 8) != 0 : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public d clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return (d) super.clone();
            } catch (CloneNotSupportedException e2) {
                throw new AssertionError(e2);
            }
        }
        return (d) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, aVar)) == null) {
            Class<? super T> a2 = aVar.a();
            boolean a3 = a(a2);
            boolean z = a3 || b(a2, true);
            boolean z2 = a3 || b(a2, false);
            if (z || z2) {
                return new v<T>(this, z2, z, fVar, aVar) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ boolean f32159a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ boolean f32160b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.preload.a.f f32161c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.preload.a.c.a f32162d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ d f32163e;

                    /* renamed from: f  reason: collision with root package name */
                    public v<T> f32164f;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z2), Boolean.valueOf(z), fVar, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f32163e = this;
                        this.f32159a = z2;
                        this.f32160b = z;
                        this.f32161c = fVar;
                        this.f32162d = aVar;
                    }

                    @Override // com.bytedance.sdk.openadsdk.preload.a.v
                    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, cVar, t) == null) {
                            if (this.f32160b) {
                                cVar.f();
                            } else {
                                b().a(cVar, t);
                            }
                        }
                    }

                    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object] */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.v
                    public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar2) throws IOException {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2)) == null) {
                            if (this.f32159a) {
                                aVar2.n();
                                return null;
                            }
                            return b().b(aVar2);
                        }
                        return invokeL.objValue;
                    }

                    private v<T> b() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) {
                            v<T> vVar = this.f32164f;
                            if (vVar != 0) {
                                return vVar;
                            }
                            v<T> a4 = this.f32161c.a(this.f32163e, this.f32162d);
                            this.f32164f = a4;
                            return a4;
                        }
                        return (v) invokeV.objValue;
                    }
                };
            }
            return null;
        }
        return (v) invokeLL.objValue;
    }

    private boolean b(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, cls)) == null) ? !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass()) : invokeL.booleanValue;
    }

    public boolean a(Field field, boolean z) {
        InterceptResult invokeLZ;
        com.bytedance.sdk.openadsdk.preload.a.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, field, z)) == null) {
            if ((this.f32154c & field.getModifiers()) != 0) {
                return true;
            }
            if ((this.f32153b == -1.0d || a((com.bytedance.sdk.openadsdk.preload.a.a.d) field.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.d.class), (com.bytedance.sdk.openadsdk.preload.a.a.e) field.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.e.class))) && !field.isSynthetic()) {
                if (!this.f32156e || ((aVar = (com.bytedance.sdk.openadsdk.preload.a.a.a) field.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.a.class)) != null && (!z ? !aVar.b() : !aVar.a()))) {
                    if ((this.f32155d || !c(field.getType())) && !b(field.getType())) {
                        List<com.bytedance.sdk.openadsdk.preload.a.b> list = z ? this.f32157f : this.f32158g;
                        if (list.isEmpty()) {
                            return false;
                        }
                        com.bytedance.sdk.openadsdk.preload.a.c cVar = new com.bytedance.sdk.openadsdk.preload.a.c(field);
                        for (com.bytedance.sdk.openadsdk.preload.a.b bVar : list) {
                            if (bVar.a(cVar)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    private boolean a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, cls)) == null) {
            if (this.f32153b == -1.0d || a((com.bytedance.sdk.openadsdk.preload.a.a.d) cls.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.d.class), (com.bytedance.sdk.openadsdk.preload.a.a.e) cls.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.e.class))) {
                return (!this.f32155d && c(cls)) || b(cls);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean a(Class<?> cls, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, cls, z)) == null) ? a(cls) || b(cls, z) : invokeLZ.booleanValue;
    }

    private boolean a(com.bytedance.sdk.openadsdk.preload.a.a.d dVar, com.bytedance.sdk.openadsdk.preload.a.a.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, dVar, eVar)) == null) ? a(dVar) && a(eVar) : invokeLL.booleanValue;
    }

    private boolean a(com.bytedance.sdk.openadsdk.preload.a.a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, dVar)) == null) ? dVar == null || dVar.a() <= this.f32153b : invokeL.booleanValue;
    }

    private boolean a(com.bytedance.sdk.openadsdk.preload.a.a.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, eVar)) == null) ? eVar == null || eVar.a() > this.f32153b : invokeL.booleanValue;
    }
}
