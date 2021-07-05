package d.k.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire2.Message;
import com.squareup.wire2.Message.a;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public final class a<M extends Message<M, B>, B extends Message.a<M, B>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WireField.Label f73994a;

    /* renamed from: b  reason: collision with root package name */
    public final String f73995b;

    /* renamed from: c  reason: collision with root package name */
    public final int f73996c;

    /* renamed from: d  reason: collision with root package name */
    public final String f73997d;

    /* renamed from: e  reason: collision with root package name */
    public final String f73998e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f73999f;

    /* renamed from: g  reason: collision with root package name */
    public final Field f74000g;

    /* renamed from: h  reason: collision with root package name */
    public final Field f74001h;

    /* renamed from: i  reason: collision with root package name */
    public final Method f74002i;
    public ProtoAdapter<?> j;
    public ProtoAdapter<?> k;
    public ProtoAdapter<Object> l;

    public a(WireField wireField, Field field, Class<B> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wireField, field, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73994a = wireField.label();
        this.f73995b = field.getName();
        this.f73996c = wireField.tag();
        this.f73997d = wireField.keyAdapter();
        this.f73998e = wireField.adapter();
        this.f73999f = wireField.redacted();
        this.f74000g = field;
        this.f74001h = c(cls, this.f73995b);
        this.f74002i = d(cls, this.f73995b, field.getType());
    }

    public static Field c(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, str)) == null) {
            try {
                return cls.getField(str);
            } catch (NoSuchFieldException unused) {
                throw new AssertionError("No builder field " + cls.getName() + "." + str);
            }
        }
        return (Field) invokeLL.objValue;
    }

    public static Method d(Class<?> cls, String str, Class<?> cls2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cls, str, cls2)) == null) {
            try {
                return cls.getMethod(str, cls2);
            } catch (NoSuchMethodException unused) {
                throw new AssertionError("No builder method " + cls.getName() + "." + str + "(" + cls2.getName() + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public ProtoAdapter<Object> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ProtoAdapter<Object> protoAdapter = this.l;
            if (protoAdapter != null) {
                return protoAdapter;
            }
            if (f()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(g(), i());
                this.l = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = i().withLabel(this.f73994a);
            this.l = withLabel;
            return withLabel;
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    public Object b(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m)) == null) {
            try {
                return this.f74000g.get(m);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
        return invokeL.objValue;
    }

    public Object e(B b2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2)) == null) {
            try {
                return this.f74001h.get(b2);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
        return invokeL.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !this.f73997d.isEmpty() : invokeV.booleanValue;
    }

    public ProtoAdapter<?> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ProtoAdapter<?> protoAdapter = this.k;
            if (protoAdapter != null) {
                return protoAdapter;
            }
            ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.f73997d);
            this.k = protoAdapter2;
            return protoAdapter2;
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    public void h(B b2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, b2, obj) == null) {
            try {
                if (this.f73994a.isOneOf()) {
                    this.f74002i.invoke(b2, obj);
                } else {
                    this.f74001h.set(b2, obj);
                }
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public ProtoAdapter<?> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ProtoAdapter<?> protoAdapter = this.j;
            if (protoAdapter != null) {
                return protoAdapter;
            }
            ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.f73998e);
            this.j = protoAdapter2;
            return protoAdapter2;
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    public void j(B b2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, b2, obj) == null) {
            if (this.f73994a.isRepeated()) {
                ((List) e(b2)).add(obj);
            } else if (!this.f73997d.isEmpty()) {
                ((Map) e(b2)).putAll((Map) obj);
            } else {
                h(b2, obj);
            }
        }
    }
}
