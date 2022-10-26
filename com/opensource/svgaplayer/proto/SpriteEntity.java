package com.opensource.svgaplayer.proto;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.au9;
import com.baidu.tieba.vt9;
import com.baidu.tieba.wt9;
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
public final class SpriteEntity extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ProtoAdapter ADAPTER;
    public static final String DEFAULT_IMAGEKEY = "";
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    @WireField(adapter = "com.opensource.svgaplayer.proto.FrameEntity#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List frames;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String imageKey;

    /* loaded from: classes8.dex */
    public final class Builder extends Message.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List frames;
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
            this.frames = au9.i();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.Message.a
        public SpriteEntity build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new SpriteEntity(this.imageKey, this.frames, super.buildUnknownFields());
            }
            return (SpriteEntity) invokeV.objValue;
        }

        public Builder frames(List list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
                au9.a(list);
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

    /* loaded from: classes8.dex */
    public final class ProtoAdapter_SpriteEntity extends ProtoAdapter {
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
        @Override // com.squareup.wire2.ProtoAdapter
        public SpriteEntity decode(vt9 vt9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, vt9Var)) == null) {
                Builder builder = new Builder();
                long c = vt9Var.c();
                while (true) {
                    int f = vt9Var.f();
                    if (f != -1) {
                        if (f != 1) {
                            if (f != 2) {
                                FieldEncoding g = vt9Var.g();
                                builder.addUnknownField(f, g, g.rawProtoAdapter().decode(vt9Var));
                            } else {
                                builder.frames.add(FrameEntity.ADAPTER.decode(vt9Var));
                            }
                        } else {
                            builder.imageKey((String) ProtoAdapter.STRING.decode(vt9Var));
                        }
                    } else {
                        vt9Var.d(c);
                        return builder.build();
                    }
                }
            } else {
                return (SpriteEntity) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public SpriteEntity redact(SpriteEntity spriteEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, spriteEntity)) == null) {
                Builder newBuilder = spriteEntity.newBuilder();
                au9.k(newBuilder.frames, FrameEntity.ADAPTER);
                newBuilder.clearUnknownFields();
                return newBuilder.build();
            }
            return (SpriteEntity) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(wt9 wt9Var, SpriteEntity spriteEntity) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, wt9Var, spriteEntity) == null) {
                String str = spriteEntity.imageKey;
                if (str != null) {
                    ProtoAdapter.STRING.encodeWithTag(wt9Var, 1, str);
                }
                FrameEntity.ADAPTER.asRepeated().encodeWithTag(wt9Var, 2, spriteEntity.frames);
                wt9Var.k(spriteEntity.unknownFields());
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
    @Override // com.squareup.wire2.Message
    public Builder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Builder builder = new Builder();
            builder.imageKey = this.imageKey;
            builder.frames = au9.c("frames", this.frames);
            builder.addUnknownFields(unknownFields());
            return builder;
        }
        return (Builder) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpriteEntity(String str, List list) {
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
    public SpriteEntity(String str, List list, ByteString byteString) {
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
        this.frames = au9.g("frames", list);
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
            if (unknownFields().equals(spriteEntity.unknownFields()) && au9.f(this.imageKey, spriteEntity.imageKey) && this.frames.equals(spriteEntity.frames)) {
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
