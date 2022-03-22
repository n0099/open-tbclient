package com.opensource.svgaplayer.proto;

import c.k.a.c;
import c.k.a.d;
import c.k.a.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire2.FieldEncoding;
import com.squareup.wire2.Message;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import java.io.IOException;
import okio.ByteString;
/* loaded from: classes7.dex */
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

    /* renamed from: b  reason: collision with root package name */
    public final Float f42293b;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)

    /* renamed from: c  reason: collision with root package name */
    public final Float f42294c;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)

    /* renamed from: d  reason: collision with root package name */
    public final Float f42295d;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
    public final Float tx;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    public final Float ty;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.a<Transform, Builder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Float a;

        /* renamed from: b  reason: collision with root package name */
        public Float f42296b;

        /* renamed from: c  reason: collision with root package name */
        public Float f42297c;

        /* renamed from: d  reason: collision with root package name */
        public Float f42298d;
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

        public Builder a(Float f2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f2)) == null) {
                this.a = f2;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder b(Float f2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
                this.f42296b = f2;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder c(Float f2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f2)) == null) {
                this.f42297c = f2;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder d(Float f2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f2)) == null) {
                this.f42298d = f2;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder tx(Float f2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, f2)) == null) {
                this.tx = f2;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder ty(Float f2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, f2)) == null) {
                this.ty = f2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new Transform(this.a, this.f42296b, this.f42297c, this.f42298d, this.tx, this.ty, super.buildUnknownFields()) : (Transform) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
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
        public Transform decode(c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                Builder builder = new Builder();
                long c2 = cVar.c();
                while (true) {
                    int f2 = cVar.f();
                    if (f2 != -1) {
                        switch (f2) {
                            case 1:
                                builder.a(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            case 2:
                                builder.b(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            case 3:
                                builder.c(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            case 4:
                                builder.d(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            case 5:
                                builder.tx(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            case 6:
                                builder.ty(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            default:
                                FieldEncoding g2 = cVar.g();
                                builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                                break;
                        }
                    } else {
                        cVar.d(c2);
                        return builder.build();
                    }
                }
            } else {
                return (Transform) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, Transform transform) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, transform) == null) {
                Float f2 = transform.a;
                if (f2 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, f2);
                }
                Float f3 = transform.f42293b;
                if (f3 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, f3);
                }
                Float f4 = transform.f42294c;
                if (f4 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, f4);
                }
                Float f5 = transform.f42295d;
                if (f5 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 4, f5);
                }
                Float f6 = transform.tx;
                if (f6 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 5, f6);
                }
                Float f7 = transform.ty;
                if (f7 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 6, f7);
                }
                dVar.k(transform.unknownFields());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(Transform transform) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, transform)) == null) {
                Float f2 = transform.a;
                int encodedSizeWithTag = f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f2) : 0;
                Float f3 = transform.f42293b;
                int encodedSizeWithTag2 = encodedSizeWithTag + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f3) : 0);
                Float f4 = transform.f42294c;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f4) : 0);
                Float f5 = transform.f42295d;
                int encodedSizeWithTag4 = encodedSizeWithTag3 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f5) : 0);
                Float f6 = transform.tx;
                int encodedSizeWithTag5 = encodedSizeWithTag4 + (f6 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(5, f6) : 0);
                Float f7 = transform.ty;
                return encodedSizeWithTag5 + (f7 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(6, f7) : 0) + transform.unknownFields().size();
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
    public Transform(Float f2, Float f3, Float f4, Float f5, Float f6, Float f7) {
        this(f2, f3, f4, f5, f6, f7, ByteString.EMPTY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f2, f3, f4, f5, f6, f7};
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
                return unknownFields().equals(transform.unknownFields()) && a.f(this.a, transform.a) && a.f(this.f42293b, transform.f42293b) && a.f(this.f42294c, transform.f42294c) && a.f(this.f42295d, transform.f42295d) && a.f(this.tx, transform.tx) && a.f(this.ty, transform.ty);
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
                Float f2 = this.a;
                int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 37;
                Float f3 = this.f42293b;
                int hashCode3 = (hashCode2 + (f3 != null ? f3.hashCode() : 0)) * 37;
                Float f4 = this.f42294c;
                int hashCode4 = (hashCode3 + (f4 != null ? f4.hashCode() : 0)) * 37;
                Float f5 = this.f42295d;
                int hashCode5 = (hashCode4 + (f5 != null ? f5.hashCode() : 0)) * 37;
                Float f6 = this.tx;
                int hashCode6 = (hashCode5 + (f6 != null ? f6.hashCode() : 0)) * 37;
                Float f7 = this.ty;
                int hashCode7 = hashCode6 + (f7 != null ? f7.hashCode() : 0);
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
            if (this.f42293b != null) {
                sb.append(", b=");
                sb.append(this.f42293b);
            }
            if (this.f42294c != null) {
                sb.append(", c=");
                sb.append(this.f42294c);
            }
            if (this.f42295d != null) {
                sb.append(", d=");
                sb.append(this.f42295d);
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
    public Transform(Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, ByteString byteString) {
        super(ADAPTER, byteString);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f2, f3, f4, f5, f6, f7, byteString};
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
        this.a = f2;
        this.f42293b = f3;
        this.f42294c = f4;
        this.f42295d = f5;
        this.tx = f6;
        this.ty = f7;
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
            builder.f42296b = this.f42293b;
            builder.f42297c = this.f42294c;
            builder.f42298d = this.f42295d;
            builder.tx = this.tx;
            builder.ty = this.ty;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
        return (Builder) invokeV.objValue;
    }
}
