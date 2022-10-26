package com.squareup.wire2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ut9;
import com.baidu.tieba.vt9;
import com.baidu.tieba.wt9;
import com.baidu.tieba.xt9;
import com.baidu.tieba.yt9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes8.dex */
public abstract class ProtoAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ProtoAdapter BOOL;
    public static final ProtoAdapter BYTES;
    public static final ProtoAdapter DOUBLE;
    public static final ProtoAdapter FIXED32;
    public static final ProtoAdapter FIXED64;
    public static final int FIXED_32_SIZE = 4;
    public static final int FIXED_64_SIZE = 8;
    public static final int FIXED_BOOL_SIZE = 1;
    public static final ProtoAdapter FLOAT;
    public static final ProtoAdapter INT32;
    public static final ProtoAdapter INT64;
    public static final ProtoAdapter SFIXED32;
    public static final ProtoAdapter SFIXED64;
    public static final ProtoAdapter SINT32;
    public static final ProtoAdapter SINT64;
    public static final ProtoAdapter STRING;
    public static final ProtoAdapter UINT32;
    public static final ProtoAdapter UINT64;
    public transient /* synthetic */ FieldHolder $fh;
    public final FieldEncoding fieldEncoding;
    public final Class javaType;
    public ProtoAdapter packedAdapter;
    public ProtoAdapter repeatedAdapter;

    public abstract Object decode(vt9 vt9Var) throws IOException;

    public abstract void encode(wt9 wt9Var, Object obj) throws IOException;

    public abstract int encodedSize(Object obj);

    public Object redact(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            return null;
        }
        return invokeL.objValue;
    }

    /* loaded from: classes8.dex */
    public final class EnumConstantNotFoundException extends IllegalArgumentException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnumConstantNotFoundException(int i, Class cls) {
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

    /* loaded from: classes8.dex */
    public final class a extends ProtoAdapter {
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
        public Float decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                return Float.valueOf(Float.intBitsToFloat(vt9Var.i()));
            }
            return (Float) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(wt9 wt9Var, Float f) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, f) == null) {
                wt9Var.l(Float.floatToIntBits(f.floatValue()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class b extends ProtoAdapter {
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
        public Double decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                return Double.valueOf(Double.longBitsToDouble(vt9Var.j()));
            }
            return (Double) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(wt9 wt9Var, Double d) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, d) == null) {
                wt9Var.m(Double.doubleToLongBits(d.doubleValue()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class c extends ProtoAdapter {
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
        public String decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                return vt9Var.k();
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
                return wt9.h(str);
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(wt9 wt9Var, String str) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, str) == null) {
                wt9Var.o(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class d extends ProtoAdapter {
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
        public ByteString decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                return vt9Var.h();
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
        public void encode(wt9 wt9Var, ByteString byteString) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, byteString) == null) {
                wt9Var.k(byteString);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends ProtoAdapter {
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
        public List decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                return Collections.singletonList(this.a.decode(vt9Var));
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: d */
        public int encodedSize(List list) {
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
        public List redact(List list) {
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
        public void encode(wt9 wt9Var, List list) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, list) == null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    this.a.encode(wt9Var, list.get(i));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: e */
        public int encodedSizeWithTag(int i, List list) {
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
        public void encodeWithTag(wt9 wt9Var, int i, List list) throws IOException {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, wt9Var, i, list) == null) && !list.isEmpty()) {
                super.encodeWithTag(wt9Var, i, list);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends ProtoAdapter {
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
        public List decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                return Collections.singletonList(this.a.decode(vt9Var));
            }
            return (List) invokeL.objValue;
        }

        public int d(List list) {
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
        public List redact(List list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
                return Collections.emptyList();
            }
            return (List) invokeL.objValue;
        }

        public void b(wt9 wt9Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, list) == null) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: e */
        public int encodedSizeWithTag(int i, List list) {
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
        public /* bridge */ /* synthetic */ void encode(wt9 wt9Var, Object obj) throws IOException {
            b(wt9Var, (List) obj);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public void encodeWithTag(wt9 wt9Var, int i, List list) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, wt9Var, i, list) == null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.a.encodeWithTag(wt9Var, i, list.get(i2));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class g extends ProtoAdapter {
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
        public Boolean decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                int l = vt9Var.l();
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
        public void encode(wt9 wt9Var, Boolean bool) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, bool) == null) {
                wt9Var.q(bool.booleanValue() ? 1 : 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class h extends ProtoAdapter {
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
        public Integer decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                return Integer.valueOf(vt9Var.l());
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
                return wt9.e(num.intValue());
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(wt9 wt9Var, Integer num) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, num) == null) {
                wt9Var.n(num.intValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class i extends ProtoAdapter {
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
        public Integer decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                return Integer.valueOf(vt9Var.l());
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
                return wt9.i(num.intValue());
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(wt9 wt9Var, Integer num) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, num) == null) {
                wt9Var.q(num.intValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class j extends ProtoAdapter {
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
        public Integer decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                return Integer.valueOf(wt9.a(vt9Var.l()));
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
                return wt9.i(wt9.c(num.intValue()));
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(wt9 wt9Var, Integer num) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, num) == null) {
                wt9Var.q(wt9.c(num.intValue()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class k extends ProtoAdapter {
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
        public Integer decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                return Integer.valueOf(vt9Var.i());
            }
            return (Integer) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(wt9 wt9Var, Integer num) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, num) == null) {
                wt9Var.l(num.intValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class l extends ProtoAdapter {
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
        public Long decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                return Long.valueOf(vt9Var.m());
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
                return wt9.j(l.longValue());
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(wt9 wt9Var, Long l) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, l) == null) {
                wt9Var.r(l.longValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class m extends ProtoAdapter {
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
        public Long decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                return Long.valueOf(vt9Var.m());
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
                return wt9.j(l.longValue());
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(wt9 wt9Var, Long l) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, l) == null) {
                wt9Var.r(l.longValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class n extends ProtoAdapter {
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
        public Long decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                return Long.valueOf(wt9.b(vt9Var.m()));
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
                return wt9.j(wt9.d(l.longValue()));
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(wt9 wt9Var, Long l) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, l) == null) {
                wt9Var.r(wt9.d(l.longValue()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class o extends ProtoAdapter {
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
        public Long decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                return Long.valueOf(vt9Var.j());
            }
            return (Long) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(wt9 wt9Var, Long l) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, l) == null) {
                wt9Var.m(l.longValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class p extends ProtoAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ProtoAdapter a;
        public final ProtoAdapter b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ProtoAdapter protoAdapter, ProtoAdapter protoAdapter2) {
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

        public Map.Entry a(vt9 vt9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Map.Entry) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(Map.Entry entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, entry)) == null) {
                return this.a.encodedSizeWithTag(1, entry.getKey()) + this.b.encodedSizeWithTag(2, entry.getValue());
            }
            return invokeL.intValue;
        }

        @Override // com.squareup.wire2.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(vt9 vt9Var) throws IOException {
            a(vt9Var);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: b */
        public void encode(wt9 wt9Var, Map.Entry entry) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, entry) == null) {
                this.a.encodeWithTag(wt9Var, 1, entry.getKey());
                this.b.encodeWithTag(wt9Var, 2, entry.getValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class q extends ProtoAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final p a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(ProtoAdapter protoAdapter, ProtoAdapter protoAdapter2) {
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
            this.a = new p(protoAdapter, protoAdapter2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: a */
        public Map decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                long c = vt9Var.c();
                Object obj = null;
                Object obj2 = null;
                while (true) {
                    int f = vt9Var.f();
                    if (f == -1) {
                        break;
                    } else if (f != 1) {
                        if (f == 2) {
                            obj2 = this.a.b.decode(vt9Var);
                        }
                    } else {
                        obj = this.a.a.decode(vt9Var);
                    }
                }
                vt9Var.d(c);
                if (obj != null) {
                    if (obj2 != null) {
                        return Collections.singletonMap(obj, obj2);
                    }
                    throw new IllegalStateException("Map entry with null value");
                }
                throw new IllegalStateException("Map entry with null key");
            }
            return (Map) invokeL.objValue;
        }

        public void b(wt9 wt9Var, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wt9Var, map) == null) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: e */
        public int encodedSizeWithTag(int i, Map map) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, map)) == null) {
                int i2 = 0;
                for (Map.Entry entry : map.entrySet()) {
                    i2 += this.a.encodedSizeWithTag(i, entry);
                }
                return i2;
            }
            return invokeIL.intValue;
        }

        @Override // com.squareup.wire2.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(wt9 wt9Var, Object obj) throws IOException {
            b(wt9Var, (Map) obj);
            throw null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        /* renamed from: c */
        public void encodeWithTag(wt9 wt9Var, int i, Map map) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, wt9Var, i, map) == null) {
                for (Map.Entry entry : map.entrySet()) {
                    this.a.encodeWithTag(wt9Var, i, entry);
                }
            }
        }

        public int d(Map map) {
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
        public Map redact(Map map) {
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

    public ProtoAdapter(FieldEncoding fieldEncoding, Class cls) {
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

    private ProtoAdapter createPacked() {
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

    private ProtoAdapter createRepeated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return new f(this, this.fieldEncoding, List.class);
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    public final ProtoAdapter asPacked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ProtoAdapter protoAdapter = this.packedAdapter;
            if (protoAdapter == null) {
                ProtoAdapter createPacked = createPacked();
                this.packedAdapter = createPacked;
                return createPacked;
            }
            return protoAdapter;
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    public final ProtoAdapter asRepeated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ProtoAdapter protoAdapter = this.repeatedAdapter;
            if (protoAdapter == null) {
                ProtoAdapter createRepeated = createRepeated();
                this.repeatedAdapter = createRepeated;
                return createRepeated;
            }
            return protoAdapter;
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    public static ProtoAdapter get(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, message)) == null) {
            return get(message.getClass());
        }
        return (ProtoAdapter) invokeL.objValue;
    }

    public static xt9 newEnumAdapter(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) {
            return new xt9(cls);
        }
        return (xt9) invokeL.objValue;
    }

    public static ProtoAdapter newMessageAdapter(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) {
            return yt9.a(cls);
        }
        return (ProtoAdapter) invokeL.objValue;
    }

    public final Object decode(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, inputStream)) == null) {
            ut9.a(inputStream, "stream == null");
            return decode(Okio.buffer(Okio.source(inputStream)));
        }
        return invokeL.objValue;
    }

    public final byte[] encode(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            ut9.a(obj, "value == null");
            Buffer buffer = new Buffer();
            try {
                encode(buffer, obj);
                return buffer.readByteArray();
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public String toString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            return obj.toString();
        }
        return (String) invokeL.objValue;
    }

    public ProtoAdapter withLabel(WireField.Label label) {
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

    public static ProtoAdapter get(Class cls) {
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

    public static ProtoAdapter get(String str) {
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

    public static ProtoAdapter newMapAdapter(ProtoAdapter protoAdapter, ProtoAdapter protoAdapter2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, protoAdapter, protoAdapter2)) == null) {
            return new q(protoAdapter, protoAdapter2);
        }
        return (ProtoAdapter) invokeLL.objValue;
    }

    public final void encode(OutputStream outputStream, Object obj) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, outputStream, obj) == null) {
            ut9.a(obj, "value == null");
            ut9.a(outputStream, "stream == null");
            BufferedSink buffer = Okio.buffer(Okio.sink(outputStream));
            encode(buffer, obj);
            buffer.emit();
        }
    }

    public int encodedSizeWithTag(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, obj)) == null) {
            int encodedSize = encodedSize(obj);
            if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
                encodedSize += wt9.i(encodedSize);
            }
            return encodedSize + wt9.g(i2);
        }
        return invokeIL.intValue;
    }

    public final Object decode(BufferedSource bufferedSource) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bufferedSource)) == null) {
            ut9.a(bufferedSource, "source == null");
            return decode(new vt9(bufferedSource));
        }
        return invokeL.objValue;
    }

    public final Object decode(ByteString byteString) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, byteString)) == null) {
            ut9.a(byteString, "bytes == null");
            return decode(new Buffer().write(byteString));
        }
        return invokeL.objValue;
    }

    public final Object decode(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            ut9.a(bArr, "bytes == null");
            return decode(new Buffer().write(bArr));
        }
        return invokeL.objValue;
    }

    public final void encode(BufferedSink bufferedSink, Object obj) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bufferedSink, obj) == null) {
            ut9.a(obj, "value == null");
            ut9.a(bufferedSink, "sink == null");
            encode(new wt9(bufferedSink), obj);
        }
    }

    public void encodeWithTag(wt9 wt9Var, int i2, Object obj) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, wt9Var, i2, obj) == null) {
            wt9Var.p(i2, this.fieldEncoding);
            if (this.fieldEncoding == FieldEncoding.LENGTH_DELIMITED) {
                wt9Var.q(encodedSize(obj));
            }
            encode(wt9Var, obj);
        }
    }
}
