package com.opensource.svgaplayer.proto;

import c.n.a.c;
import c.n.a.d;
import c.n.a.h.a;
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
import java.util.List;
import okio.ByteString;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.shapes = a.i();
        }

        public Builder alpha(Float f2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f2)) == null) {
                this.alpha = f2;
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
                a.a(list);
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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public FrameEntity build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new FrameEntity(this.alpha, this.layout, this.transform, this.clipPath, this.shapes, super.buildUnknownFields()) : (FrameEntity) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public FrameEntity decode(c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, cVar)) != null) {
                return (FrameEntity) invokeL.objValue;
            }
            Builder builder = new Builder();
            long c2 = cVar.c();
            while (true) {
                int f2 = cVar.f();
                if (f2 == -1) {
                    cVar.d(c2);
                    return builder.build();
                } else if (f2 == 1) {
                    builder.alpha(ProtoAdapter.FLOAT.decode(cVar));
                } else if (f2 == 2) {
                    builder.layout(Layout.ADAPTER.decode(cVar));
                } else if (f2 == 3) {
                    builder.transform(Transform.ADAPTER.decode(cVar));
                } else if (f2 == 4) {
                    builder.clipPath(ProtoAdapter.STRING.decode(cVar));
                } else if (f2 != 5) {
                    FieldEncoding g2 = cVar.g();
                    builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                } else {
                    builder.shapes.add(ShapeEntity.ADAPTER.decode(cVar));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, FrameEntity frameEntity) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, frameEntity) == null) {
                Float f2 = frameEntity.alpha;
                if (f2 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, f2);
                }
                Layout layout = frameEntity.layout;
                if (layout != null) {
                    Layout.ADAPTER.encodeWithTag(dVar, 2, layout);
                }
                Transform transform = frameEntity.transform;
                if (transform != null) {
                    Transform.ADAPTER.encodeWithTag(dVar, 3, transform);
                }
                String str = frameEntity.clipPath;
                if (str != null) {
                    ProtoAdapter.STRING.encodeWithTag(dVar, 4, str);
                }
                ShapeEntity.ADAPTER.asRepeated().encodeWithTag(dVar, 5, frameEntity.shapes);
                dVar.k(frameEntity.unknownFields());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(FrameEntity frameEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, frameEntity)) == null) {
                Float f2 = frameEntity.alpha;
                int encodedSizeWithTag = f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f2) : 0;
                Layout layout = frameEntity.layout;
                int encodedSizeWithTag2 = encodedSizeWithTag + (layout != null ? Layout.ADAPTER.encodedSizeWithTag(2, layout) : 0);
                Transform transform = frameEntity.transform;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + (transform != null ? Transform.ADAPTER.encodedSizeWithTag(3, transform) : 0);
                String str = frameEntity.clipPath;
                return encodedSizeWithTag3 + (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, str) : 0) + ShapeEntity.ADAPTER.asRepeated().encodedSizeWithTag(5, frameEntity.shapes) + frameEntity.unknownFields().size();
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
                a.k(newBuilder2.shapes, ShapeEntity.ADAPTER);
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
    public FrameEntity(Float f2, Layout layout, Transform transform, String str, List<ShapeEntity> list) {
        this(f2, layout, transform, str, list, ByteString.EMPTY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f2, layout, transform, str, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Float) objArr2[0], (Layout) objArr2[1], (Transform) objArr2[2], (String) objArr2[3], (List) objArr2[4], (ByteString) objArr2[5]);
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
            if (obj instanceof FrameEntity) {
                FrameEntity frameEntity = (FrameEntity) obj;
                return unknownFields().equals(frameEntity.unknownFields()) && a.f(this.alpha, frameEntity.alpha) && a.f(this.layout, frameEntity.layout) && a.f(this.transform, frameEntity.transform) && a.f(this.clipPath, frameEntity.clipPath) && this.shapes.equals(frameEntity.shapes);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.hashCode;
            if (i2 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                Float f2 = this.alpha;
                int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 37;
                Layout layout = this.layout;
                int hashCode3 = (hashCode2 + (layout != null ? layout.hashCode() : 0)) * 37;
                Transform transform = this.transform;
                int hashCode4 = (hashCode3 + (transform != null ? transform.hashCode() : 0)) * 37;
                String str = this.clipPath;
                int hashCode5 = ((hashCode4 + (str != null ? str.hashCode() : 0)) * 37) + this.shapes.hashCode();
                this.hashCode = hashCode5;
                return hashCode5;
            }
            return i2;
        }
        return invokeV.intValue;
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
            replace.append(ExtendedMessageFormat.END_FE);
            return replace.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameEntity(Float f2, Layout layout, Transform transform, String str, List<ShapeEntity> list, ByteString byteString) {
        super(ADAPTER, byteString);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f2, layout, transform, str, list, byteString};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ProtoAdapter) objArr2[0], (ByteString) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.alpha = f2;
        this.layout = layout;
        this.transform = transform;
        this.clipPath = str;
        this.shapes = a.g("shapes", list);
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
            builder.shapes = a.c("shapes", this.shapes);
            builder.addUnknownFields(unknownFields());
            return builder;
        }
        return (Builder) invokeV.objValue;
    }
}
