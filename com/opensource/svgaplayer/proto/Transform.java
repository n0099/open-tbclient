package com.opensource.svgaplayer.proto;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bo9;
import com.repackage.wn9;
import com.repackage.xn9;
import com.squareup.wire2.FieldEncoding;
import com.squareup.wire2.Message;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import java.io.IOException;
import okio.ByteString;
/* loaded from: classes5.dex */
public final class Transform extends Message<Transform, Builder> {
    public static /* synthetic */ Interceptable $ic;
    public static final ProtoAdapter<Transform> ADAPTER;
    public static final Float DEFAULT_A;
    public static final Float DEFAULT_B;
    public static final Float DEFAULT_C;
    public static final Float DEFAULT_D;
    public static final Float DEFAULT_TX;
    public static final Float DEFAULT_TY;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float a;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float b;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float c;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float d;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
    public final Float tx;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    public final Float ty;

    /* loaded from: classes5.dex */
    public static final class Builder extends Message.a<Transform, Builder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Float a;
        public Float b;
        public Float c;
        public Float d;
        public Float tx;
        public Float ty;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public Builder a(Float f) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f)) == null) {
                this.a = f;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder b(Float f) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
                this.b = f;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder c(Float f) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f)) == null) {
                this.c = f;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder d(Float f) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f)) == null) {
                this.d = f;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder tx(Float f) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, f)) == null) {
                this.tx = f;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder ty(Float f) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, f)) == null) {
                this.ty = f;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public Transform build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new Transform(this.a, this.b, this.c, this.d, this.tx, this.ty, super.buildUnknownFields()) : (Transform) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class ProtoAdapter_Transform extends ProtoAdapter<Transform> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProtoAdapter_Transform() {
            super(FieldEncoding.LENGTH_DELIMITED, Transform.class);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super((FieldEncoding) objArr[0], (Class) objArr[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public Transform decode(wn9 wn9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wn9Var)) == null) {
                Builder builder = new Builder();
                long c = wn9Var.c();
                while (true) {
                    int f = wn9Var.f();
                    if (f != -1) {
                        switch (f) {
                            case 1:
                                builder.a(ProtoAdapter.FLOAT.decode(wn9Var));
                                break;
                            case 2:
                                builder.b(ProtoAdapter.FLOAT.decode(wn9Var));
                                break;
                            case 3:
                                builder.c(ProtoAdapter.FLOAT.decode(wn9Var));
                                break;
                            case 4:
                                builder.d(ProtoAdapter.FLOAT.decode(wn9Var));
                                break;
                            case 5:
                                builder.tx(ProtoAdapter.FLOAT.decode(wn9Var));
                                break;
                            case 6:
                                builder.ty(ProtoAdapter.FLOAT.decode(wn9Var));
                                break;
                            default:
                                FieldEncoding g = wn9Var.g();
                                builder.addUnknownField(f, g, g.rawProtoAdapter().decode(wn9Var));
                                break;
                        }
                    } else {
                        wn9Var.d(c);
                        return builder.build();
                    }
                }
            } else {
                return (Transform) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(xn9 xn9Var, Transform transform) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, xn9Var, transform) == null) {
                Float f = transform.a;
                if (f != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(xn9Var, 1, f);
                }
                Float f2 = transform.b;
                if (f2 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(xn9Var, 2, f2);
                }
                Float f3 = transform.c;
                if (f3 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(xn9Var, 3, f3);
                }
                Float f4 = transform.d;
                if (f4 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(xn9Var, 4, f4);
                }
                Float f5 = transform.tx;
                if (f5 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(xn9Var, 5, f5);
                }
                Float f6 = transform.ty;
                if (f6 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(xn9Var, 6, f6);
                }
                xn9Var.k(transform.unknownFields());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(Transform transform) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, transform)) == null) {
                Float f = transform.a;
                int encodedSizeWithTag = f != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f) : 0;
                Float f2 = transform.b;
                int encodedSizeWithTag2 = encodedSizeWithTag + (f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f2) : 0);
                Float f3 = transform.c;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f3) : 0);
                Float f4 = transform.d;
                int encodedSizeWithTag4 = encodedSizeWithTag3 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f4) : 0);
                Float f5 = transform.tx;
                int encodedSizeWithTag5 = encodedSizeWithTag4 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(5, f5) : 0);
                Float f6 = transform.ty;
                return encodedSizeWithTag5 + (f6 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(6, f6) : 0) + transform.unknownFields().size();
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public Transform redact(Transform transform) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, transform)) == null) {
                Message.a<Transform, Builder> newBuilder2 = transform.newBuilder2();
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
            return (Transform) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1024117577, "Lcom/opensource/svgaplayer/proto/Transform;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1024117577, "Lcom/opensource/svgaplayer/proto/Transform;");
                return;
            }
        }
        ADAPTER = new ProtoAdapter_Transform();
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_A = valueOf;
        DEFAULT_B = valueOf;
        DEFAULT_C = valueOf;
        DEFAULT_D = valueOf;
        DEFAULT_TX = valueOf;
        DEFAULT_TY = valueOf;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Transform(Float f, Float f2, Float f3, Float f4, Float f5, Float f6) {
        this(f, f2, f3, f4, f5, f6, ByteString.EMPTY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f, f2, f3, f4, f5, f6};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Float) objArr2[0], (Float) objArr2[1], (Float) objArr2[2], (Float) objArr2[3], (Float) objArr2[4], (Float) objArr2[5], (ByteString) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Transform) {
                Transform transform = (Transform) obj;
                return unknownFields().equals(transform.unknownFields()) && bo9.f(this.a, transform.a) && bo9.f(this.b, transform.b) && bo9.f(this.c, transform.c) && bo9.f(this.d, transform.d) && bo9.f(this.tx, transform.tx) && bo9.f(this.ty, transform.ty);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.hashCode;
            if (i == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                Float f = this.a;
                int hashCode2 = (hashCode + (f != null ? f.hashCode() : 0)) * 37;
                Float f2 = this.b;
                int hashCode3 = (hashCode2 + (f2 != null ? f2.hashCode() : 0)) * 37;
                Float f3 = this.c;
                int hashCode4 = (hashCode3 + (f3 != null ? f3.hashCode() : 0)) * 37;
                Float f4 = this.d;
                int hashCode5 = (hashCode4 + (f4 != null ? f4.hashCode() : 0)) * 37;
                Float f5 = this.tx;
                int hashCode6 = (hashCode5 + (f5 != null ? f5.hashCode() : 0)) * 37;
                Float f6 = this.ty;
                int hashCode7 = hashCode6 + (f6 != null ? f6.hashCode() : 0);
                this.hashCode = hashCode7;
                return hashCode7;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.a != null) {
                sb.append(", a=");
                sb.append(this.a);
            }
            if (this.b != null) {
                sb.append(", b=");
                sb.append(this.b);
            }
            if (this.c != null) {
                sb.append(", c=");
                sb.append(this.c);
            }
            if (this.d != null) {
                sb.append(", d=");
                sb.append(this.d);
            }
            if (this.tx != null) {
                sb.append(", tx=");
                sb.append(this.tx);
            }
            if (this.ty != null) {
                sb.append(", ty=");
                sb.append(this.ty);
            }
            StringBuilder replace = sb.replace(0, 2, "Transform{");
            replace.append('}');
            return replace.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Transform(Float f, Float f2, Float f3, Float f4, Float f5, Float f6, ByteString byteString) {
        super(ADAPTER, byteString);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f, f2, f3, f4, f5, f6, byteString};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ProtoAdapter) objArr2[0], (ByteString) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.tx = f5;
        this.ty = f6;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.Transform$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<Transform, Builder> newBuilder2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Builder builder = new Builder();
            builder.a = this.a;
            builder.b = this.b;
            builder.c = this.c;
            builder.d = this.d;
            builder.tx = this.tx;
            builder.ty = this.ty;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
        return (Builder) invokeV.objValue;
    }
}
