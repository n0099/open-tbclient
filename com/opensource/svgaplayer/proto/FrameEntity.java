package com.opensource.svgaplayer.proto;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dza;
import com.baidu.tieba.yya;
import com.baidu.tieba.zya;
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
import java.util.List;
import okio.ByteString;
/* loaded from: classes8.dex */
public final class FrameEntity extends Message<FrameEntity, Builder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ProtoAdapter<FrameEntity> ADAPTER;
    public static final Float DEFAULT_ALPHA;
    public static final String DEFAULT_CLIPPATH = "";
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float alpha;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String clipPath;
    @WireField(adapter = "com.opensource.svgaplayer.proto.Layout#ADAPTER", tag = 2)
    public final Layout layout;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<ShapeEntity> shapes;
    @WireField(adapter = "com.opensource.svgaplayer.proto.Transform#ADAPTER", tag = 3)
    public final Transform transform;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.a<FrameEntity, Builder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Float alpha;
        public String clipPath;
        public Layout layout;
        public List<ShapeEntity> shapes;
        public Transform transform;

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
                    return;
                }
            }
            this.shapes = dza.i();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public FrameEntity build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new FrameEntity(this.alpha, this.layout, this.transform, this.clipPath, this.shapes, super.buildUnknownFields());
            }
            return (FrameEntity) invokeV.objValue;
        }

        public Builder alpha(Float f) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f)) == null) {
                this.alpha = f;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder clipPath(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.clipPath = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder layout(Layout layout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, layout)) == null) {
                this.layout = layout;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder shapes(List<ShapeEntity> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
                dza.a(list);
                this.shapes = list;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder transform(Transform transform) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, transform)) == null) {
                this.transform = transform;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class ProtoAdapter_FrameEntity extends ProtoAdapter<FrameEntity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProtoAdapter_FrameEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, FrameEntity.class);
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
        public FrameEntity decode(yya yyaVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yyaVar)) == null) {
                Builder builder = new Builder();
                long c = yyaVar.c();
                while (true) {
                    int f = yyaVar.f();
                    if (f != -1) {
                        if (f != 1) {
                            if (f != 2) {
                                if (f != 3) {
                                    if (f != 4) {
                                        if (f != 5) {
                                            FieldEncoding g = yyaVar.g();
                                            builder.addUnknownField(f, g, g.rawProtoAdapter().decode(yyaVar));
                                        } else {
                                            builder.shapes.add(ShapeEntity.ADAPTER.decode(yyaVar));
                                        }
                                    } else {
                                        builder.clipPath(ProtoAdapter.STRING.decode(yyaVar));
                                    }
                                } else {
                                    builder.transform(Transform.ADAPTER.decode(yyaVar));
                                }
                            } else {
                                builder.layout(Layout.ADAPTER.decode(yyaVar));
                            }
                        } else {
                            builder.alpha(ProtoAdapter.FLOAT.decode(yyaVar));
                        }
                    } else {
                        yyaVar.d(c);
                        return builder.build();
                    }
                }
            } else {
                return (FrameEntity) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(zya zyaVar, FrameEntity frameEntity) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, zyaVar, frameEntity) == null) {
                Float f = frameEntity.alpha;
                if (f != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(zyaVar, 1, f);
                }
                Layout layout = frameEntity.layout;
                if (layout != null) {
                    Layout.ADAPTER.encodeWithTag(zyaVar, 2, layout);
                }
                Transform transform = frameEntity.transform;
                if (transform != null) {
                    Transform.ADAPTER.encodeWithTag(zyaVar, 3, transform);
                }
                String str = frameEntity.clipPath;
                if (str != null) {
                    ProtoAdapter.STRING.encodeWithTag(zyaVar, 4, str);
                }
                ShapeEntity.ADAPTER.asRepeated().encodeWithTag(zyaVar, 5, frameEntity.shapes);
                zyaVar.k(frameEntity.unknownFields());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(FrameEntity frameEntity) {
            InterceptResult invokeL;
            int i;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, frameEntity)) == null) {
                Float f = frameEntity.alpha;
                int i4 = 0;
                if (f != null) {
                    i = ProtoAdapter.FLOAT.encodedSizeWithTag(1, f);
                } else {
                    i = 0;
                }
                Layout layout = frameEntity.layout;
                if (layout != null) {
                    i2 = Layout.ADAPTER.encodedSizeWithTag(2, layout);
                } else {
                    i2 = 0;
                }
                int i5 = i + i2;
                Transform transform = frameEntity.transform;
                if (transform != null) {
                    i3 = Transform.ADAPTER.encodedSizeWithTag(3, transform);
                } else {
                    i3 = 0;
                }
                int i6 = i5 + i3;
                String str = frameEntity.clipPath;
                if (str != null) {
                    i4 = ProtoAdapter.STRING.encodedSizeWithTag(4, str);
                }
                return i6 + i4 + ShapeEntity.ADAPTER.asRepeated().encodedSizeWithTag(5, frameEntity.shapes) + frameEntity.unknownFields().size();
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r5v1, types: [com.squareup.wire2.Message$a, com.opensource.svgaplayer.proto.FrameEntity$Builder] */
        @Override // com.squareup.wire2.ProtoAdapter
        public FrameEntity redact(FrameEntity frameEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, frameEntity)) == null) {
                ?? newBuilder2 = frameEntity.newBuilder2();
                Layout layout = newBuilder2.layout;
                if (layout != null) {
                    newBuilder2.layout = Layout.ADAPTER.redact(layout);
                }
                Transform transform = newBuilder2.transform;
                if (transform != null) {
                    newBuilder2.transform = Transform.ADAPTER.redact(transform);
                }
                dza.k(newBuilder2.shapes, ShapeEntity.ADAPTER);
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
            return (FrameEntity) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1491581683, "Lcom/opensource/svgaplayer/proto/FrameEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1491581683, "Lcom/opensource/svgaplayer/proto/FrameEntity;");
                return;
            }
        }
        ADAPTER = new ProtoAdapter_FrameEntity();
        DEFAULT_ALPHA = Float.valueOf(0.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrameEntity(Float f, Layout layout, Transform transform, String str, List<ShapeEntity> list) {
        this(f, layout, transform, str, list, ByteString.EMPTY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f, layout, transform, str, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Float) objArr2[0], (Layout) objArr2[1], (Transform) objArr2[2], (String) objArr2[3], (List) objArr2[4], (ByteString) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameEntity(Float f, Layout layout, Transform transform, String str, List<ShapeEntity> list, ByteString byteString) {
        super(ADAPTER, byteString);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f, layout, transform, str, list, byteString};
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
        this.alpha = f;
        this.layout = layout;
        this.transform = transform;
        this.clipPath = str;
        this.shapes = dza.g("shapes", list);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FrameEntity)) {
                return false;
            }
            FrameEntity frameEntity = (FrameEntity) obj;
            if (unknownFields().equals(frameEntity.unknownFields()) && dza.f(this.alpha, frameEntity.alpha) && dza.f(this.layout, frameEntity.layout) && dza.f(this.transform, frameEntity.transform) && dza.f(this.clipPath, frameEntity.clipPath) && this.shapes.equals(frameEntity.shapes)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i4 = this.hashCode;
            if (i4 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                Float f = this.alpha;
                int i5 = 0;
                if (f != null) {
                    i = f.hashCode();
                } else {
                    i = 0;
                }
                int i6 = (hashCode + i) * 37;
                Layout layout = this.layout;
                if (layout != null) {
                    i2 = layout.hashCode();
                } else {
                    i2 = 0;
                }
                int i7 = (i6 + i2) * 37;
                Transform transform = this.transform;
                if (transform != null) {
                    i3 = transform.hashCode();
                } else {
                    i3 = 0;
                }
                int i8 = (i7 + i3) * 37;
                String str = this.clipPath;
                if (str != null) {
                    i5 = str.hashCode();
                }
                int hashCode2 = ((i8 + i5) * 37) + this.shapes.hashCode();
                this.hashCode = hashCode2;
                return hashCode2;
            }
            return i4;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.FrameEntity$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<FrameEntity, Builder> newBuilder2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Builder builder = new Builder();
            builder.alpha = this.alpha;
            builder.layout = this.layout;
            builder.transform = this.transform;
            builder.clipPath = this.clipPath;
            builder.shapes = dza.c("shapes", this.shapes);
            builder.addUnknownFields(unknownFields());
            return builder;
        }
        return (Builder) invokeV.objValue;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.alpha != null) {
                sb.append(", alpha=");
                sb.append(this.alpha);
            }
            if (this.layout != null) {
                sb.append(", layout=");
                sb.append(this.layout);
            }
            if (this.transform != null) {
                sb.append(", transform=");
                sb.append(this.transform);
            }
            if (this.clipPath != null) {
                sb.append(", clipPath=");
                sb.append(this.clipPath);
            }
            if (!this.shapes.isEmpty()) {
                sb.append(", shapes=");
                sb.append(this.shapes);
            }
            StringBuilder replace = sb.replace(0, 2, "FrameEntity{");
            replace.append('}');
            return replace.toString();
        }
        return (String) invokeV.objValue;
    }
}
