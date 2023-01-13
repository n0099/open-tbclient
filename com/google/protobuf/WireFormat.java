package com.google.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class WireFormat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MESSAGE_SET_ITEM = 1;
    public static final int MESSAGE_SET_ITEM_END_TAG;
    public static final int MESSAGE_SET_ITEM_TAG;
    public static final int MESSAGE_SET_MESSAGE = 3;
    public static final int MESSAGE_SET_MESSAGE_TAG;
    public static final int MESSAGE_SET_TYPE_ID = 2;
    public static final int MESSAGE_SET_TYPE_ID_TAG;
    public static final int TAG_TYPE_BITS = 3;
    public static final int TAG_TYPE_MASK = 7;
    public static final int WIRETYPE_END_GROUP = 4;
    public static final int WIRETYPE_FIXED32 = 5;
    public static final int WIRETYPE_FIXED64 = 1;
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;
    public static final int WIRETYPE_START_GROUP = 3;
    public static final int WIRETYPE_VARINT = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.google.protobuf.WireFormat$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public static int getTagFieldNumber(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i >>> 3 : invokeI.intValue;
    }

    public static int getTagWireType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i & 7 : invokeI.intValue;
    }

    public static int makeTag(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2)) == null) ? (i << 3) | i2 : invokeII.intValue;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static class FieldType {
        public static final /* synthetic */ FieldType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FieldType BOOL;
        public static final FieldType BYTES;
        public static final FieldType DOUBLE;
        public static final FieldType ENUM;
        public static final FieldType FIXED32;
        public static final FieldType FIXED64;
        public static final FieldType FLOAT;
        public static final FieldType GROUP;
        public static final FieldType INT32;
        public static final FieldType INT64;
        public static final FieldType MESSAGE;
        public static final FieldType SFIXED32;
        public static final FieldType SFIXED64;
        public static final FieldType SINT32;
        public static final FieldType SINT64;
        public static final FieldType STRING;
        public static final FieldType UINT32;
        public static final FieldType UINT64;
        public transient /* synthetic */ FieldHolder $fh;
        public final JavaType javaType;
        public final int wireType;

        public boolean isPackable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1093900697, "Lcom/google/protobuf/WireFormat$FieldType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1093900697, "Lcom/google/protobuf/WireFormat$FieldType;");
                    return;
                }
            }
            DOUBLE = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            FLOAT = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            INT64 = new FieldType("INT64", 2, JavaType.LONG, 0);
            UINT64 = new FieldType("UINT64", 3, JavaType.LONG, 0);
            INT32 = new FieldType("INT32", 4, JavaType.INT, 0);
            FIXED64 = new FieldType("FIXED64", 5, JavaType.LONG, 1);
            FIXED32 = new FieldType("FIXED32", 6, JavaType.INT, 5);
            BOOL = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            STRING = new FieldType("STRING", 8, JavaType.STRING, 2) { // from class: com.google.protobuf.WireFormat.FieldType.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.google.protobuf.WireFormat.FieldType
                public boolean isPackable() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r12, r13, r14, r15, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r12, Integer.valueOf(r13), r14, Integer.valueOf(r15)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (JavaType) objArr2[2], ((Integer) objArr2[3]).intValue(), (AnonymousClass1) objArr2[4]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }
            };
            GROUP = new FieldType("GROUP", 9, JavaType.MESSAGE, 3) { // from class: com.google.protobuf.WireFormat.FieldType.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.google.protobuf.WireFormat.FieldType
                public boolean isPackable() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r12, r13, r14, r15, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r12, Integer.valueOf(r13), r14, Integer.valueOf(r15)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (JavaType) objArr2[2], ((Integer) objArr2[3]).intValue(), (AnonymousClass1) objArr2[4]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }
            };
            MESSAGE = new FieldType("MESSAGE", 10, JavaType.MESSAGE, 2) { // from class: com.google.protobuf.WireFormat.FieldType.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.google.protobuf.WireFormat.FieldType
                public boolean isPackable() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r12, r13, r14, r15, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r12, Integer.valueOf(r13), r14, Integer.valueOf(r15)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (JavaType) objArr2[2], ((Integer) objArr2[3]).intValue(), (AnonymousClass1) objArr2[4]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }
            };
            BYTES = new FieldType("BYTES", 11, JavaType.BYTE_STRING, 2) { // from class: com.google.protobuf.WireFormat.FieldType.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.google.protobuf.WireFormat.FieldType
                public boolean isPackable() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r12, r13, r14, r15, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r12, Integer.valueOf(r13), r14, Integer.valueOf(r15)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (JavaType) objArr2[2], ((Integer) objArr2[3]).intValue(), (AnonymousClass1) objArr2[4]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }
            };
            UINT32 = new FieldType("UINT32", 12, JavaType.INT, 0);
            ENUM = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            SFIXED32 = new FieldType("SFIXED32", 14, JavaType.INT, 5);
            SFIXED64 = new FieldType("SFIXED64", 15, JavaType.LONG, 1);
            SINT32 = new FieldType("SINT32", 16, JavaType.INT, 0);
            FieldType fieldType = new FieldType("SINT64", 17, JavaType.LONG, 0);
            SINT64 = fieldType;
            $VALUES = new FieldType[]{DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, GROUP, MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, fieldType};
        }

        public FieldType(String str, int i, JavaType javaType, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), javaType, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.javaType = javaType;
            this.wireType = i2;
        }

        public /* synthetic */ FieldType(String str, int i, JavaType javaType, int i2, AnonymousClass1 anonymousClass1) {
            this(str, i, javaType, i2);
        }

        public static FieldType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (FieldType) Enum.valueOf(FieldType.class, str);
            }
            return (FieldType) invokeL.objValue;
        }

        public static FieldType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (FieldType[]) $VALUES.clone();
            }
            return (FieldType[]) invokeV.objValue;
        }

        public JavaType getJavaType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.javaType;
            }
            return (JavaType) invokeV.objValue;
        }

        public int getWireType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.wireType;
            }
            return invokeV.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class JavaType {
        public static final /* synthetic */ JavaType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final JavaType BOOLEAN;
        public static final JavaType BYTE_STRING;
        public static final JavaType DOUBLE;
        public static final JavaType ENUM;
        public static final JavaType FLOAT;
        public static final JavaType INT;
        public static final JavaType LONG;
        public static final JavaType MESSAGE;
        public static final JavaType STRING;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object defaultDefault;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-906735553, "Lcom/google/protobuf/WireFormat$JavaType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-906735553, "Lcom/google/protobuf/WireFormat$JavaType;");
                    return;
                }
            }
            INT = new JavaType("INT", 0, 0);
            LONG = new JavaType("LONG", 1, 0L);
            FLOAT = new JavaType("FLOAT", 2, Float.valueOf(0.0f));
            DOUBLE = new JavaType("DOUBLE", 3, Double.valueOf(0.0d));
            BOOLEAN = new JavaType("BOOLEAN", 4, Boolean.FALSE);
            STRING = new JavaType("STRING", 5, "");
            BYTE_STRING = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
            ENUM = new JavaType("ENUM", 7, null);
            JavaType javaType = new JavaType("MESSAGE", 8, null);
            MESSAGE = javaType;
            $VALUES = new JavaType[]{INT, LONG, FLOAT, DOUBLE, BOOLEAN, STRING, BYTE_STRING, ENUM, javaType};
        }

        public JavaType(String str, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), obj};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.defaultDefault = obj;
        }

        public static JavaType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (JavaType) Enum.valueOf(JavaType.class, str);
            }
            return (JavaType) invokeL.objValue;
        }

        public static JavaType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (JavaType[]) $VALUES.clone();
            }
            return (JavaType[]) invokeV.objValue;
        }

        public Object getDefaultDefault() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.defaultDefault;
            }
            return invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2099138295, "Lcom/google/protobuf/WireFormat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2099138295, "Lcom/google/protobuf/WireFormat;");
                return;
            }
        }
        MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
        MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
        MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
        MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
    }

    public WireFormat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
