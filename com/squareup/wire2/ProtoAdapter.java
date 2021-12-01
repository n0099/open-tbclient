package com.squareup.wire2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnumConstantNotFoundException(int i2, Class<?> cls) {
            super("Unknown enum tag " + i2 + " for " + cls.getCanonicalName());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = i2;
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends ProtoAdapter<Float> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public Float decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? Float.valueOf(Float.intBitsToFloat(cVar.i())) : (Float) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(c.n.a.d dVar, Float f2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, f2) == null) {
                dVar.l(Float.floatToIntBits(f2.floatValue()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Float f2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
                return 4;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends ProtoAdapter<Double> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public Double decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? Double.valueOf(Double.longBitsToDouble(cVar.j())) : (Double) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(c.n.a.d dVar, Double d2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, d2) == null) {
                dVar.m(Double.doubleToLongBits(d2.doubleValue()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Double d2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2)) == null) {
                return 8;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public String decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.k() : (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(c.n.a.d dVar, String str) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, str) == null) {
                dVar.o(str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? c.n.a.d.h(str) : invokeL.intValue;
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public ByteString decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.h() : (ByteString) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(c.n.a.d dVar, ByteString byteString) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, byteString) == null) {
                dVar.k(byteString);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteString)) == null) ? byteString.size() : invokeL.intValue;
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public List<E> decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? Collections.singletonList(this.a.decode(cVar)) : (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(c.n.a.d dVar, List<E> list) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, list) == null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.a.encode(dVar, (c.n.a.d) list.get(i2));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public void encodeWithTag(c.n.a.d dVar, int i2, List<E> list) throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, dVar, i2, list) == null) || list.isEmpty()) {
                return;
            }
            super.encodeWithTag(dVar, i2, list);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: d */
        public int encodedSize(List<E> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
                int size = list.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    i2 += this.a.encodedSize(list.get(i3));
                }
                return i2;
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: e */
        public int encodedSizeWithTag(int i2, List<E> list) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, list)) == null) {
                if (list.isEmpty()) {
                    return 0;
                }
                return super.encodedSizeWithTag(i2, list);
            }
            return invokeIL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: f */
        public List<E> redact(List<E> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) ? Collections.emptyList() : (List) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public List<E> decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? Collections.singletonList(this.a.decode(cVar)) : (List) invokeL.objValue;
        }

        public void b(c.n.a.d dVar, List<E> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, list) == null) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public void encodeWithTag(c.n.a.d dVar, int i2, List<E> list) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, dVar, i2, list) == null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.a.encodeWithTag(dVar, i2, list.get(i3));
                }
            }
        }

        public int d(List<E> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: e */
        public int encodedSizeWithTag(int i2, List<E> list) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, list)) == null) {
                int size = list.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    i3 += this.a.encodedSizeWithTag(i2, list.get(i4));
                }
                return i3;
            }
            return invokeIL.intValue;
        }

        @Override // com.squareup.wire2.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(c.n.a.d dVar, Object obj) throws IOException {
            b(dVar, (List) obj);
            throw null;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) ? Collections.emptyList() : (List) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class g extends ProtoAdapter<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public Boolean decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                int l = cVar.l();
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
        public void encode(c.n.a.d dVar, Boolean bool) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, bool) == null) {
                dVar.q(bool.booleanValue() ? 1 : 0);
            }
        }

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
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public Integer decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? Integer.valueOf(cVar.l()) : (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(c.n.a.d dVar, Integer num) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, num) == null) {
                dVar.n(num.intValue());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num)) == null) ? c.n.a.d.e(num.intValue()) : invokeL.intValue;
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public Integer decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? Integer.valueOf(cVar.l()) : (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(c.n.a.d dVar, Integer num) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, num) == null) {
                dVar.q(num.intValue());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num)) == null) ? c.n.a.d.i(num.intValue()) : invokeL.intValue;
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public Integer decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? Integer.valueOf(c.n.a.d.a(cVar.l())) : (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(c.n.a.d dVar, Integer num) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, num) == null) {
                dVar.q(c.n.a.d.c(num.intValue()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num)) == null) ? c.n.a.d.i(c.n.a.d.c(num.intValue())) : invokeL.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class k extends ProtoAdapter<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public Integer decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? Integer.valueOf(cVar.i()) : (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(c.n.a.d dVar, Integer num) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, num) == null) {
                dVar.l(num.intValue());
            }
        }

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
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public Long decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? Long.valueOf(cVar.m()) : (Long) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(c.n.a.d dVar, Long l) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, l) == null) {
                dVar.r(l.longValue());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Long l) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l)) == null) ? c.n.a.d.j(l.longValue()) : invokeL.intValue;
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public Long decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? Long.valueOf(cVar.m()) : (Long) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(c.n.a.d dVar, Long l) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, l) == null) {
                dVar.r(l.longValue());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Long l) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l)) == null) ? c.n.a.d.j(l.longValue()) : invokeL.intValue;
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public Long decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? Long.valueOf(c.n.a.d.b(cVar.m())) : (Long) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(c.n.a.d dVar, Long l) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, l) == null) {
                dVar.r(c.n.a.d.d(l.longValue()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Long l) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l)) == null) ? c.n.a.d.j(c.n.a.d.d(l.longValue())) : invokeL.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class o extends ProtoAdapter<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(FieldEncoding fieldEncoding, Class cls) {
            super(fieldEncoding, cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fieldEncoding, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public Long decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? Long.valueOf(cVar.j()) : (Long) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(c.n.a.d dVar, Long l) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, l) == null) {
                dVar.m(l.longValue());
            }
        }

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
    }

    /* loaded from: classes2.dex */
    public static final class p<K, V> extends ProtoAdapter<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ProtoAdapter<K> a;

        /* renamed from: b  reason: collision with root package name */
        public final ProtoAdapter<V> f61046b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {protoAdapter, protoAdapter2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((FieldEncoding) objArr2[0], (Class) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = protoAdapter;
            this.f61046b = protoAdapter2;
        }

        public Map.Entry<K, V> a(c.n.a.c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Map.Entry) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(c.n.a.d dVar, Map.Entry<K, V> entry) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, entry) == null) {
                this.a.encodeWithTag(dVar, 1, entry.getKey());
                this.f61046b.encodeWithTag(dVar, 2, entry.getValue());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Map.Entry<K, V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, entry)) == null) ? this.a.encodedSizeWithTag(1, entry.getKey()) + this.f61046b.encodedSizeWithTag(2, entry.getValue()) : invokeL.intValue;
        }

        @Override // com.squareup.wire2.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(c.n.a.c cVar) throws IOException {
            a(cVar);
            throw null;
        }
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public Map<K, V> decode(c.n.a.c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                long c2 = cVar.c();
                K k2 = null;
                V v = null;
                while (true) {
                    int f2 = cVar.f();
                    if (f2 == -1) {
                        break;
                    } else if (f2 == 1) {
                        k2 = this.a.a.decode(cVar);
                    } else if (f2 == 2) {
                        v = this.a.f61046b.decode(cVar);
                    }
                }
                cVar.d(c2);
                if (k2 != null) {
                    if (v != null) {
                        return Collections.singletonMap(k2, v);
                    }
                    throw new IllegalStateException("Map entry with null value");
                }
                throw new IllegalStateException("Map entry with null key");
            }
            return (Map) invokeL.objValue;
        }

        public void b(c.n.a.d dVar, Map<K, V> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, map) == null) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public void encodeWithTag(c.n.a.d dVar, int i2, Map<K, V> map) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, dVar, i2, map) == null) {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    this.a.encodeWithTag(dVar, i2, entry);
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: e */
        public int encodedSizeWithTag(int i2, Map<K, V> map) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, map)) == null) {
                int i3 = 0;
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    i3 += this.a.encodedSizeWithTag(i2, entry);
                }
                return i3;
            }
            return invokeIL.intValue;
        }

        @Override // com.squareup.wire2.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(c.n.a.d dVar, Object obj) throws IOException {
            b(dVar, (Map) obj);
            throw null;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, map)) == null) ? Collections.emptyMap() : (Map) invokeL.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? new f(this, this.fieldEncoding, List.class) : (ProtoAdapter) invokeV.objValue;
    }

    public static <M extends Message> ProtoAdapter<M> get(M m2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, m2)) == null) ? get(m2.getClass()) : (ProtoAdapter) invokeL.objValue;
    }

    public static <E extends c.n.a.g> c.n.a.e<E> newEnumAdapter(Class<E> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) ? new c.n.a.e<>(cls) : (c.n.a.e) invokeL.objValue;
    }

    public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> protoAdapter, ProtoAdapter<V> protoAdapter2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, protoAdapter, protoAdapter2)) == null) ? new q(protoAdapter, protoAdapter2) : (ProtoAdapter) invokeLL.objValue;
    }

    public static <M extends Message<M, B>, B extends Message.a<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) ? c.n.a.f.a(cls) : (ProtoAdapter) invokeL.objValue;
    }

    public final ProtoAdapter<List<E>> asPacked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ProtoAdapter<List<E>> protoAdapter = this.packedAdapter;
            if (protoAdapter != null) {
                return protoAdapter;
            }
            ProtoAdapter<List<E>> createPacked = createPacked();
            this.packedAdapter = createPacked;
            return createPacked;
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ProtoAdapter<List<E>> protoAdapter = this.repeatedAdapter;
            if (protoAdapter != null) {
                return protoAdapter;
            }
            ProtoAdapter<List<E>> createRepeated = createRepeated();
            this.repeatedAdapter = createRepeated;
            return createRepeated;
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    public abstract E decode(c.n.a.c cVar) throws IOException;

    public final E decode(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            c.n.a.b.a(bArr, "bytes == null");
            return decode(new Buffer().write(bArr));
        }
        return (E) invokeL.objValue;
    }

    public abstract void encode(c.n.a.d dVar, E e2) throws IOException;

    public final void encode(BufferedSink bufferedSink, E e2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bufferedSink, e2) == null) {
            c.n.a.b.a(e2, "value == null");
            c.n.a.b.a(bufferedSink, "sink == null");
            encode(new c.n.a.d(bufferedSink), (c.n.a.d) e2);
        }
    }

    public void encodeWithTag(c.n.a.d dVar, int i2, E e2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, dVar, i2, e2) == null) {
            dVar.p(i2, this.fieldEncoding);
            if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
                dVar.q(encodedSize(e2));
            }
            encode(dVar, (c.n.a.d) e2);
        }
    }

    public abstract int encodedSize(E e2);

    public int encodedSizeWithTag(int i2, E e2) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, e2)) == null) {
            int encodedSize = encodedSize(e2);
            if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
                encodedSize += c.n.a.d.i(encodedSize);
            }
            return encodedSize + c.n.a.d.g(i2);
        }
        return invokeIL.intValue;
    }

    public E redact(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, e2)) == null) {
            return null;
        }
        return (E) invokeL.objValue;
    }

    public String toString(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, e2)) == null) ? e2.toString() : (String) invokeL.objValue;
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

    public final E decode(ByteString byteString) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, byteString)) == null) {
            c.n.a.b.a(byteString, "bytes == null");
            return decode(new Buffer().write(byteString));
        }
        return (E) invokeL.objValue;
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

    public final byte[] encode(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, e2)) == null) {
            c.n.a.b.a(e2, "value == null");
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

    public final E decode(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, inputStream)) == null) {
            c.n.a.b.a(inputStream, "stream == null");
            return decode(Okio.buffer(Okio.source(inputStream)));
        }
        return (E) invokeL.objValue;
    }

    public final E decode(BufferedSource bufferedSource) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bufferedSource)) == null) {
            c.n.a.b.a(bufferedSource, "source == null");
            return decode(new c.n.a.c(bufferedSource));
        }
        return (E) invokeL.objValue;
    }

    public final void encode(OutputStream outputStream, E e2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, outputStream, e2) == null) {
            c.n.a.b.a(e2, "value == null");
            c.n.a.b.a(outputStream, "stream == null");
            BufferedSink buffer = Okio.buffer(Okio.sink(outputStream));
            encode(buffer, (BufferedSink) e2);
            buffer.emit();
        }
    }
}
