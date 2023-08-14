package com.opensource.svgaplayer.proto;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.srb;
import com.baidu.tieba.trb;
import com.baidu.tieba.xrb;
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
/* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.frames = xrb.i();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public SpriteEntity build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new SpriteEntity(this.imageKey, this.frames, super.buildUnknownFields());
            }
            return (SpriteEntity) invokeV.objValue;
        }

        public Builder frames(List<FrameEntity> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
                xrb.a(list);
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
    }

    /* loaded from: classes10.dex */
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
        public SpriteEntity decode(srb srbVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, srbVar)) == null) {
                Builder builder = new Builder();
                long c = srbVar.c();
                while (true) {
                    int f = srbVar.f();
                    if (f != -1) {
                        if (f != 1) {
                            if (f != 2) {
                                FieldEncoding g = srbVar.g();
                                builder.addUnknownField(f, g, g.rawProtoAdapter().decode(srbVar));
                            } else {
                                builder.frames.add(FrameEntity.ADAPTER.decode(srbVar));
                            }
                        } else {
                            builder.imageKey(ProtoAdapter.STRING.decode(srbVar));
                        }
                    } else {
                        srbVar.d(c);
                        return builder.build();
                    }
                }
            } else {
                return (SpriteEntity) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r5v1, types: [com.squareup.wire2.Message$a, com.opensource.svgaplayer.proto.SpriteEntity$Builder] */
        @Override // com.squareup.wire2.ProtoAdapter
        public SpriteEntity redact(SpriteEntity spriteEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, spriteEntity)) == null) {
                ?? newBuilder2 = spriteEntity.newBuilder2();
                xrb.k(newBuilder2.frames, FrameEntity.ADAPTER);
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
            return (SpriteEntity) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(trb trbVar, SpriteEntity spriteEntity) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, trbVar, spriteEntity) == null) {
                String str = spriteEntity.imageKey;
                if (str != null) {
                    ProtoAdapter.STRING.encodeWithTag(trbVar, 1, str);
                }
                FrameEntity.ADAPTER.asRepeated().encodeWithTag(trbVar, 2, spriteEntity.frames);
                trbVar.k(spriteEntity.unknownFields());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(SpriteEntity spriteEntity) {
            InterceptResult invokeL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, spriteEntity)) == null) {
                String str = spriteEntity.imageKey;
                if (str != null) {
                    i = ProtoAdapter.STRING.encodedSizeWithTag(1, str);
                } else {
                    i = 0;
                }
                return i + FrameEntity.ADAPTER.asRepeated().encodedSizeWithTag(2, spriteEntity.frames) + spriteEntity.unknownFields().size();
            }
            return invokeL.intValue;
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
            builder.frames = xrb.c("frames", this.frames);
            builder.addUnknownFields(unknownFields());
            return builder;
        }
        return (Builder) invokeV.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (List) objArr2[1], (ByteString) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        this.imageKey = str;
        this.frames = xrb.g("frames", list);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SpriteEntity)) {
                return false;
            }
            SpriteEntity spriteEntity = (SpriteEntity) obj;
            if (unknownFields().equals(spriteEntity.unknownFields()) && xrb.f(this.imageKey, spriteEntity.imageKey) && this.frames.equals(spriteEntity.frames)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.hashCode;
            if (i2 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                String str = this.imageKey;
                if (str != null) {
                    i = str.hashCode();
                } else {
                    i = 0;
                }
                int hashCode2 = ((hashCode + i) * 37) + this.frames.hashCode();
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
}
