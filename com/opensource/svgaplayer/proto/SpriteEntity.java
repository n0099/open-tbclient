package com.opensource.svgaplayer.proto;

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
import d.k.a.c;
import d.k.a.d;
import d.k.a.h.a;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
/* loaded from: classes7.dex */
public final class SpriteEntity extends Message<SpriteEntity, Builder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ProtoAdapter<SpriteEntity> ADAPTER;
    public static final String DEFAULT_IMAGEKEY = "";
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    @WireField(adapter = "com.opensource.svgaplayer.proto.FrameEntity#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<FrameEntity> frames;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String imageKey;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.a<SpriteEntity, Builder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<FrameEntity> frames;
        public String imageKey;

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
            this.frames = a.i();
        }

        public Builder frames(List<FrameEntity> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
                a.a(list);
                this.frames = list;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder imageKey(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.imageKey = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public SpriteEntity build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new SpriteEntity(this.imageKey, this.frames, super.buildUnknownFields()) : (SpriteEntity) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class ProtoAdapter_SpriteEntity extends ProtoAdapter<SpriteEntity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProtoAdapter_SpriteEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, SpriteEntity.class);
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
        public SpriteEntity decode(c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, cVar)) != null) {
                return (SpriteEntity) invokeL.objValue;
            }
            Builder builder = new Builder();
            long c2 = cVar.c();
            while (true) {
                int f2 = cVar.f();
                if (f2 == -1) {
                    cVar.d(c2);
                    return builder.build();
                } else if (f2 == 1) {
                    builder.imageKey(ProtoAdapter.STRING.decode(cVar));
                } else if (f2 != 2) {
                    FieldEncoding g2 = cVar.g();
                    builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                } else {
                    builder.frames.add(FrameEntity.ADAPTER.decode(cVar));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, SpriteEntity spriteEntity) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, spriteEntity) == null) {
                String str = spriteEntity.imageKey;
                if (str != null) {
                    ProtoAdapter.STRING.encodeWithTag(dVar, 1, str);
                }
                FrameEntity.ADAPTER.asRepeated().encodeWithTag(dVar, 2, spriteEntity.frames);
                dVar.k(spriteEntity.unknownFields());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(SpriteEntity spriteEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, spriteEntity)) == null) {
                String str = spriteEntity.imageKey;
                return (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, str) : 0) + FrameEntity.ADAPTER.asRepeated().encodedSizeWithTag(2, spriteEntity.frames) + spriteEntity.unknownFields().size();
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r5v1, types: [com.squareup.wire2.Message$a, com.opensource.svgaplayer.proto.SpriteEntity$Builder] */
        @Override // com.squareup.wire2.ProtoAdapter
        public SpriteEntity redact(SpriteEntity spriteEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, spriteEntity)) == null) {
                ?? newBuilder2 = spriteEntity.newBuilder2();
                a.k(newBuilder2.frames, FrameEntity.ADAPTER);
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
            return (SpriteEntity) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(218057419, "Lcom/opensource/svgaplayer/proto/SpriteEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(218057419, "Lcom/opensource/svgaplayer/proto/SpriteEntity;");
                return;
            }
        }
        ADAPTER = new ProtoAdapter_SpriteEntity();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpriteEntity(String str, List<FrameEntity> list) {
        this(str, list, ByteString.EMPTY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (List) objArr2[1], (ByteString) objArr2[2]);
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
            if (obj instanceof SpriteEntity) {
                SpriteEntity spriteEntity = (SpriteEntity) obj;
                return unknownFields().equals(spriteEntity.unknownFields()) && a.f(this.imageKey, spriteEntity.imageKey) && this.frames.equals(spriteEntity.frames);
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
                String str = this.imageKey;
                int hashCode2 = ((hashCode + (str != null ? str.hashCode() : 0)) * 37) + this.frames.hashCode();
                this.hashCode = hashCode2;
                return hashCode2;
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
            if (this.imageKey != null) {
                sb.append(", imageKey=");
                sb.append(this.imageKey);
            }
            if (!this.frames.isEmpty()) {
                sb.append(", frames=");
                sb.append(this.frames);
            }
            StringBuilder replace = sb.replace(0, 2, "SpriteEntity{");
            replace.append('}');
            return replace.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpriteEntity(String str, List<FrameEntity> list, ByteString byteString) {
        super(ADAPTER, byteString);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, list, byteString};
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
        this.imageKey = str;
        this.frames = a.g("frames", list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.SpriteEntity$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<SpriteEntity, Builder> newBuilder2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Builder builder = new Builder();
            builder.imageKey = this.imageKey;
            builder.frames = a.c("frames", this.frames);
            builder.addUnknownFields(unknownFields());
            return builder;
        }
        return (Builder) invokeV.objValue;
    }
}
