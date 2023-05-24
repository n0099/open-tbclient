package com.squareup.wire2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.s4b;
import com.baidu.tieba.t4b;
import com.baidu.tieba.u4b;
import com.baidu.tieba.v4b;
import com.baidu.tieba.w4b;
import com.baidu.tieba.x4b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire2.Message;
import com.squareup.wire2.WireField;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
/* loaded from: classes9.dex */
public abstract class ProtoAdapter<E> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ProtoAdapter<Boolean> BOOL;
    public static final ProtoAdapter<ByteString> BYTES;
    public static final ProtoAdapter<Double> DOUBLE;
    public static final ProtoAdapter<Integer> FIXED32;
    public static final ProtoAdapter<Long> FIXED64;
    public static final int FIXED_32_SIZE = 4;
    public static final int FIXED_64_SIZE = 8;
    public static final int FIXED_BOOL_SIZE = 1;
    public static final ProtoAdapter<Float> FLOAT;
    public static final ProtoAdapter<Integer> INT32;
    public static final ProtoAdapter<Long> INT64;
    public static final ProtoAdapter<Integer> SFIXED32;
    public static final ProtoAdapter<Long> SFIXED64;
    public static final ProtoAdapter<Integer> SINT32;
    public static final ProtoAdapter<Long> SINT64;
    public static final ProtoAdapter<String> STRING;
    public static final ProtoAdapter<Integer> UINT32;
    public static final ProtoAdapter<Long> UINT64;
    public transient /* synthetic */ FieldHolder $fh;
    public final FieldEncoding fieldEncoding;
    public final Class<?> javaType;
    public ProtoAdapter<List<E>> packedAdapter;
    public ProtoAdapter<List<E>> repeatedAdapter;

    public abstract E decode(t4b t4bVar) throws IOException;

    public abstract void encode(u4b u4bVar, E e2) throws IOException;

    public abstract int encodedSize(E e2);

    public E redact(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, e2)) == null) {
            return null;
        }
        return (E) invokeL.objValue;
    }

    /* loaded from: classes9.dex */
    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnumConstantNotFoundException(int i, Class<?> cls) {
            super("Unknown enum tag " + i + " for " + cls.getCanonicalName());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = i;
        }
    }

    /* loaded from: classes9.dex */
    public static class a extends ProtoAdapter<Float> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Float f) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f)) == null) {
                return 4;
            }
            return invokeL.intValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Float decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                return Float.valueOf(Float.intBitsToFloat(t4bVar.i()));
            }
            return (Float) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(u4b u4bVar, Float f) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, f) == null) {
                u4bVar.l(Float.floatToIntBits(f.floatValue()));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends ProtoAdapter<Double> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Double d) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d)) == null) {
                return 8;
            }
            return invokeL.intValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Double decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                return Double.valueOf(Double.longBitsToDouble(t4bVar.j()));
            }
            return (Double) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(u4b u4bVar, Double d) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, d) == null) {
                u4bVar.m(Double.doubleToLongBits(d.doubleValue()));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c extends ProtoAdapter<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public String decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                return t4bVar.k();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                return u4b.h(str);
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(u4b u4bVar, String str) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, str) == null) {
                u4bVar.o(str);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d extends ProtoAdapter<ByteString> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public ByteString decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                return t4bVar.h();
            }
            return (ByteString) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteString)) == null) {
                return byteString.size();
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(u4b u4bVar, ByteString byteString) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, byteString) == null) {
                u4bVar.k(byteString);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends ProtoAdapter<List<E>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ProtoAdapter a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ProtoAdapter protoAdapter, FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {protoAdapter, fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = protoAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public List<E> decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                return Collections.singletonList(this.a.decode(t4bVar));
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: d */
        public int encodedSize(List<E> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
                int size = list.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    i += this.a.encodedSize(list.get(i2));
                }
                return i;
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: f */
        public List<E> redact(List<E> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
                return Collections.emptyList();
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(u4b u4bVar, List<E> list) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, list) == null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    this.a.encode(u4bVar, (u4b) list.get(i));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: e */
        public int encodedSizeWithTag(int i, List<E> list) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, list)) == null) {
                if (list.isEmpty()) {
                    return 0;
                }
                return super.encodedSizeWithTag(i, list);
            }
            return invokeIL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public void encodeWithTag(u4b u4bVar, int i, List<E> list) throws IOException {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, u4bVar, i, list) == null) && !list.isEmpty()) {
                super.encodeWithTag(u4bVar, i, list);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends ProtoAdapter<List<E>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ProtoAdapter a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ProtoAdapter protoAdapter, FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {protoAdapter, fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = protoAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public List<E> decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                return Collections.singletonList(this.a.decode(t4bVar));
            }
            return (List) invokeL.objValue;
        }

        public int d(List<E> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }
            return invokeL.intValue;
        }

        @Override // com.squareup.wire2.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
            d((List) obj);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: f */
        public List<E> redact(List<E> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
                return Collections.emptyList();
            }
            return (List) invokeL.objValue;
        }

        public void b(u4b u4bVar, List<E> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, list) == null) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: e */
        public int encodedSizeWithTag(int i, List<E> list) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, list)) == null) {
                int size = list.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    i2 += this.a.encodedSizeWithTag(i, list.get(i3));
                }
                return i2;
            }
            return invokeIL.intValue;
        }

        @Override // com.squareup.wire2.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(u4b u4bVar, Object obj) throws IOException {
            b(u4bVar, (List) obj);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public void encodeWithTag(u4b u4bVar, int i, List<E> list) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, u4bVar, i, list) == null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.a.encodeWithTag(u4bVar, i, list.get(i2));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class g extends ProtoAdapter<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool)) == null) {
                return 1;
            }
            return invokeL.intValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Boolean decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                int l = t4bVar.l();
                if (l == 0) {
                    return Boolean.FALSE;
                }
                if (l == 1) {
                    return Boolean.TRUE;
                }
                throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(l)));
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(u4b u4bVar, Boolean bool) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, bool) == null) {
                u4bVar.q(bool.booleanValue() ? 1 : 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class h extends ProtoAdapter<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Integer decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                return Integer.valueOf(t4bVar.l());
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num)) == null) {
                return u4b.e(num.intValue());
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(u4b u4bVar, Integer num) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, num) == null) {
                u4bVar.n(num.intValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class i extends ProtoAdapter<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Integer decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                return Integer.valueOf(t4bVar.l());
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num)) == null) {
                return u4b.i(num.intValue());
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(u4b u4bVar, Integer num) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, num) == null) {
                u4bVar.q(num.intValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class j extends ProtoAdapter<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Integer decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                return Integer.valueOf(u4b.a(t4bVar.l()));
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num)) == null) {
                return u4b.i(u4b.c(num.intValue()));
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(u4b u4bVar, Integer num) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, num) == null) {
                u4bVar.q(u4b.c(num.intValue()));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class k extends ProtoAdapter<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num)) == null) {
                return 4;
            }
            return invokeL.intValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Integer decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                return Integer.valueOf(t4bVar.i());
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(u4b u4bVar, Integer num) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, num) == null) {
                u4bVar.l(num.intValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class l extends ProtoAdapter<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Long decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                return Long.valueOf(t4bVar.m());
            }
            return (Long) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Long l) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l)) == null) {
                return u4b.j(l.longValue());
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(u4b u4bVar, Long l) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, l) == null) {
                u4bVar.r(l.longValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class m extends ProtoAdapter<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Long decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                return Long.valueOf(t4bVar.m());
            }
            return (Long) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Long l) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l)) == null) {
                return u4b.j(l.longValue());
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(u4b u4bVar, Long l) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, l) == null) {
                u4bVar.r(l.longValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class n extends ProtoAdapter<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Long decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                return Long.valueOf(u4b.b(t4bVar.m()));
            }
            return (Long) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Long l) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l)) == null) {
                return u4b.j(u4b.d(l.longValue()));
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(u4b u4bVar, Long l) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, l) == null) {
                u4bVar.r(u4b.d(l.longValue()));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class o extends ProtoAdapter<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Long l) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l)) == null) {
                return 8;
            }
            return invokeL.intValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Long decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                return Long.valueOf(t4bVar.j());
            }
            return (Long) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(u4b u4bVar, Long l) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, l) == null) {
                u4bVar.m(l.longValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class p<K, V> extends ProtoAdapter<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ProtoAdapter<K> a;
        public final ProtoAdapter<V> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {protoAdapter, protoAdapter2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = protoAdapter;
            this.b = protoAdapter2;
        }

        public Map.Entry<K, V> a(t4b t4bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Map.Entry) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Map.Entry<K, V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, entry)) == null) {
                return this.a.encodedSizeWithTag(1, entry.getKey()) + this.b.encodedSizeWithTag(2, entry.getValue());
            }
            return invokeL.intValue;
        }

        @Override // com.squareup.wire2.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(t4b t4bVar) throws IOException {
            a(t4bVar);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(u4b u4bVar, Map.Entry<K, V> entry) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, entry) == null) {
                this.a.encodeWithTag(u4bVar, 1, entry.getKey());
                this.b.encodeWithTag(u4bVar, 2, entry.getValue());
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class q<K, V> extends ProtoAdapter<Map<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final p<K, V> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {protoAdapter, protoAdapter2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new p<>(protoAdapter, protoAdapter2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Map<K, V> decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                long c = t4bVar.c();
                K k = null;
                V v = null;
                while (true) {
                    int f = t4bVar.f();
                    if (f == -1) {
                        break;
                    } else if (f != 1) {
                        if (f == 2) {
                            v = this.a.b.decode(t4bVar);
                        }
                    } else {
                        k = this.a.a.decode(t4bVar);
                    }
                }
                t4bVar.d(c);
                if (k != null) {
                    if (v != null) {
                        return Collections.singletonMap(k, v);
                    }
                    throw new IllegalStateException("Map entry with null value");
                }
                throw new IllegalStateException("Map entry with null key");
            }
            return (Map) invokeL.objValue;
        }

        public void b(u4b u4bVar, Map<K, V> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u4bVar, map) == null) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: e */
        public int encodedSizeWithTag(int i, Map<K, V> map) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, map)) == null) {
                int i2 = 0;
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    i2 += this.a.encodedSizeWithTag(i, entry);
                }
                return i2;
            }
            return invokeIL.intValue;
        }

        @Override // com.squareup.wire2.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(u4b u4bVar, Object obj) throws IOException {
            b(u4bVar, (Map) obj);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public void encodeWithTag(u4b u4bVar, int i, Map<K, V> map) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, u4bVar, i, map) == null) {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    this.a.encodeWithTag(u4bVar, i, entry);
                }
            }
        }

        public int d(Map<K, V> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }
            return invokeL.intValue;
        }

        @Override // com.squareup.wire2.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
            d((Map) obj);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: f */
        public Map<K, V> redact(Map<K, V> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, map)) == null) {
                return Collections.emptyMap();
            }
            return (Map) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1038124939, "Lcom/squareup/wire2/ProtoAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1038124939, "Lcom/squareup/wire2/ProtoAdapter;");
                return;
            }
        }
        BOOL = new g(FieldEncoding.VARINT, Boolean.class);
        INT32 = new h(FieldEncoding.VARINT, Integer.class);
        UINT32 = new i(FieldEncoding.VARINT, Integer.class);
        SINT32 = new j(FieldEncoding.VARINT, Integer.class);
        k kVar = new k(FieldEncoding.FIXED32, Integer.class);
        FIXED32 = kVar;
        SFIXED32 = kVar;
        INT64 = new l(FieldEncoding.VARINT, Long.class);
        UINT64 = new m(FieldEncoding.VARINT, Long.class);
        SINT64 = new n(FieldEncoding.VARINT, Long.class);
        o oVar = new o(FieldEncoding.FIXED64, Long.class);
        FIXED64 = oVar;
        SFIXED64 = oVar;
        FLOAT = new a(FieldEncoding.FIXED32, Float.class);
        DOUBLE = new b(FieldEncoding.FIXED64, Double.class);
        STRING = new c(FieldEncoding.LENGTH_DELIMITED, String.class);
        BYTES = new d(FieldEncoding.LENGTH_DELIMITED, ByteString.class);
    }

    public ProtoAdapter(FieldEncoding fieldEncoding, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fieldEncoding, cls};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.fieldEncoding = fieldEncoding;
        this.javaType = cls;
    }

    private ProtoAdapter<List<E>> createPacked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            FieldEncoding fieldEncoding = this.fieldEncoding;
            FieldEncoding fieldEncoding2 = FieldEncoding.LENGTH_DELIMITED;
            if (fieldEncoding != fieldEncoding2) {
                return new e(this, fieldEncoding2, List.class);
            }
            throw new IllegalArgumentException("Unable to pack a length-delimited type.");
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    private ProtoAdapter<List<E>> createRepeated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return new f(this, this.fieldEncoding, List.class);
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    public final ProtoAdapter<List<E>> asPacked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ProtoAdapter<List<E>> protoAdapter = this.packedAdapter;
            if (protoAdapter == null) {
                ProtoAdapter<List<E>> createPacked = createPacked();
                this.packedAdapter = createPacked;
                return createPacked;
            }
            return protoAdapter;
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ProtoAdapter<List<E>> protoAdapter = this.repeatedAdapter;
            if (protoAdapter == null) {
                ProtoAdapter<List<E>> createRepeated = createRepeated();
                this.repeatedAdapter = createRepeated;
                return createRepeated;
            }
            return protoAdapter;
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    public static <M extends Message> ProtoAdapter<M> get(M m2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, m2)) == null) {
            return get(m2.getClass());
        }
        return (ProtoAdapter) invokeL.objValue;
    }

    public static <E extends x4b> v4b<E> newEnumAdapter(Class<E> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) {
            return new v4b<>(cls);
        }
        return (v4b) invokeL.objValue;
    }

    public static <M extends Message<M, B>, B extends Message.a<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) {
            return w4b.a(cls);
        }
        return (ProtoAdapter) invokeL.objValue;
    }

    public final E decode(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, inputStream)) == null) {
            s4b.a(inputStream, "stream == null");
            return decode(Okio.buffer(Okio.source(inputStream)));
        }
        return (E) invokeL.objValue;
    }

    public final byte[] encode(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, e2)) == null) {
            s4b.a(e2, "value == null");
            Buffer buffer = new Buffer();
            try {
                encode((BufferedSink) buffer, (Buffer) e2);
                return buffer.readByteArray();
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public String toString(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, e2)) == null) {
            return e2.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.squareup.wire2.ProtoAdapter<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public ProtoAdapter<?> withLabel(WireField.Label label) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, label)) == null) {
            if (label.isRepeated()) {
                if (label.isPacked()) {
                    return asPacked();
                }
                return asRepeated();
            }
            return this;
        }
        return (ProtoAdapter) invokeL.objValue;
    }

    public static <M> ProtoAdapter<M> get(Class<M> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cls)) == null) {
            try {
                return (ProtoAdapter) cls.getField("ADAPTER").get(null);
            } catch (IllegalAccessException | NoSuchFieldException e2) {
                throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", e2);
            }
        }
        return (ProtoAdapter) invokeL.objValue;
    }

    public static ProtoAdapter<?> get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                int indexOf = str.indexOf(35);
                return (ProtoAdapter) Class.forName(str.substring(0, indexOf)).getField(str.substring(indexOf + 1)).get(null);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                throw new IllegalArgumentException("failed to access " + str, e2);
            }
        }
        return (ProtoAdapter) invokeL.objValue;
    }

    public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, protoAdapter, protoAdapter2)) == null) {
            return new q(protoAdapter, protoAdapter2);
        }
        return (ProtoAdapter) invokeLL.objValue;
    }

    public final void encode(OutputStream outputStream, E e2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, outputStream, e2) == null) {
            s4b.a(e2, "value == null");
            s4b.a(outputStream, "stream == null");
            BufferedSink buffer = Okio.buffer(Okio.sink(outputStream));
            encode(buffer, (BufferedSink) e2);
            buffer.emit();
        }
    }

    public int encodedSizeWithTag(int i2, E e2) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, e2)) == null) {
            int encodedSize = encodedSize(e2);
            if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
                encodedSize += u4b.i(encodedSize);
            }
            return encodedSize + u4b.g(i2);
        }
        return invokeIL.intValue;
    }

    public final E decode(BufferedSource bufferedSource) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bufferedSource)) == null) {
            s4b.a(bufferedSource, "source == null");
            return decode(new t4b(bufferedSource));
        }
        return (E) invokeL.objValue;
    }

    public final E decode(ByteString byteString) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, byteString)) == null) {
            s4b.a(byteString, "bytes == null");
            return decode(new Buffer().write(byteString));
        }
        return (E) invokeL.objValue;
    }

    public final E decode(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            s4b.a(bArr, "bytes == null");
            return decode(new Buffer().write(bArr));
        }
        return (E) invokeL.objValue;
    }

    public final void encode(BufferedSink bufferedSink, E e2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bufferedSink, e2) == null) {
            s4b.a(e2, "value == null");
            s4b.a(bufferedSink, "sink == null");
            encode(new u4b(bufferedSink), (u4b) e2);
        }
    }

    public void encodeWithTag(u4b u4bVar, int i2, E e2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, u4bVar, i2, e2) == null) {
            u4bVar.p(i2, this.fieldEncoding);
            if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
                u4bVar.q(encodedSize(e2));
            }
            encode(u4bVar, (u4b) e2);
        }
    }
}
