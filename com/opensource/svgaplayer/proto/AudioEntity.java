package com.opensource.svgaplayer.proto;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t4b;
import com.baidu.tieba.u4b;
import com.baidu.tieba.y4b;
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
/* loaded from: classes9.dex */
public final class AudioEntity extends Message<AudioEntity, Builder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ProtoAdapter<AudioEntity> ADAPTER;
    public static final String DEFAULT_AUDIOKEY = "";
    public static final Integer DEFAULT_ENDFRAME;
    public static final Integer DEFAULT_STARTFRAME;
    public static final Integer DEFAULT_STARTTIME;
    public static final Integer DEFAULT_TOTALTIME;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String audioKey;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer endFrame;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer startFrame;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer startTime;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer totalTime;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.a<AudioEntity, Builder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String audioKey;
        public Integer endFrame;
        public Integer startFrame;
        public Integer startTime;
        public Integer totalTime;

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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public AudioEntity build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new AudioEntity(this.audioKey, this.startFrame, this.endFrame, this.startTime, this.totalTime, super.buildUnknownFields());
            }
            return (AudioEntity) invokeV.objValue;
        }

        public Builder audioKey(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.audioKey = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder endFrame(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, num)) == null) {
                this.endFrame = num;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder startFrame(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, num)) == null) {
                this.startFrame = num;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder startTime(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, num)) == null) {
                this.startTime = num;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder totalTime(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, num)) == null) {
                this.totalTime = num;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class ProtoAdapter_AudioEntity extends ProtoAdapter<AudioEntity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProtoAdapter_AudioEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, AudioEntity.class);
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
        public AudioEntity decode(t4b t4bVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t4bVar)) == null) {
                Builder builder = new Builder();
                long c = t4bVar.c();
                while (true) {
                    int f = t4bVar.f();
                    if (f != -1) {
                        if (f != 1) {
                            if (f != 2) {
                                if (f != 3) {
                                    if (f != 4) {
                                        if (f != 5) {
                                            FieldEncoding g = t4bVar.g();
                                            builder.addUnknownField(f, g, g.rawProtoAdapter().decode(t4bVar));
                                        } else {
                                            builder.totalTime(ProtoAdapter.INT32.decode(t4bVar));
                                        }
                                    } else {
                                        builder.startTime(ProtoAdapter.INT32.decode(t4bVar));
                                    }
                                } else {
                                    builder.endFrame(ProtoAdapter.INT32.decode(t4bVar));
                                }
                            } else {
                                builder.startFrame(ProtoAdapter.INT32.decode(t4bVar));
                            }
                        } else {
                            builder.audioKey(ProtoAdapter.STRING.decode(t4bVar));
                        }
                    } else {
                        t4bVar.d(c);
                        return builder.build();
                    }
                }
            } else {
                return (AudioEntity) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public AudioEntity redact(AudioEntity audioEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, audioEntity)) == null) {
                Message.a<AudioEntity, Builder> newBuilder2 = audioEntity.newBuilder2();
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
            return (AudioEntity) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(u4b u4bVar, AudioEntity audioEntity) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, u4bVar, audioEntity) == null) {
                String str = audioEntity.audioKey;
                if (str != null) {
                    ProtoAdapter.STRING.encodeWithTag(u4bVar, 1, str);
                }
                Integer num = audioEntity.startFrame;
                if (num != null) {
                    ProtoAdapter.INT32.encodeWithTag(u4bVar, 2, num);
                }
                Integer num2 = audioEntity.endFrame;
                if (num2 != null) {
                    ProtoAdapter.INT32.encodeWithTag(u4bVar, 3, num2);
                }
                Integer num3 = audioEntity.startTime;
                if (num3 != null) {
                    ProtoAdapter.INT32.encodeWithTag(u4bVar, 4, num3);
                }
                Integer num4 = audioEntity.totalTime;
                if (num4 != null) {
                    ProtoAdapter.INT32.encodeWithTag(u4bVar, 5, num4);
                }
                u4bVar.k(audioEntity.unknownFields());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(AudioEntity audioEntity) {
            InterceptResult invokeL;
            int i;
            int i2;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, audioEntity)) == null) {
                String str = audioEntity.audioKey;
                int i5 = 0;
                if (str != null) {
                    i = ProtoAdapter.STRING.encodedSizeWithTag(1, str);
                } else {
                    i = 0;
                }
                Integer num = audioEntity.startFrame;
                if (num != null) {
                    i2 = ProtoAdapter.INT32.encodedSizeWithTag(2, num);
                } else {
                    i2 = 0;
                }
                int i6 = i + i2;
                Integer num2 = audioEntity.endFrame;
                if (num2 != null) {
                    i3 = ProtoAdapter.INT32.encodedSizeWithTag(3, num2);
                } else {
                    i3 = 0;
                }
                int i7 = i6 + i3;
                Integer num3 = audioEntity.startTime;
                if (num3 != null) {
                    i4 = ProtoAdapter.INT32.encodedSizeWithTag(4, num3);
                } else {
                    i4 = 0;
                }
                int i8 = i7 + i4;
                Integer num4 = audioEntity.totalTime;
                if (num4 != null) {
                    i5 = ProtoAdapter.INT32.encodedSizeWithTag(5, num4);
                }
                return i8 + i5 + audioEntity.unknownFields().size();
            }
            return invokeL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1951141782, "Lcom/opensource/svgaplayer/proto/AudioEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1951141782, "Lcom/opensource/svgaplayer/proto/AudioEntity;");
                return;
            }
        }
        ADAPTER = new ProtoAdapter_AudioEntity();
        DEFAULT_STARTFRAME = 0;
        DEFAULT_ENDFRAME = 0;
        DEFAULT_STARTTIME = 0;
        DEFAULT_TOTALTIME = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.AudioEntity$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<AudioEntity, Builder> newBuilder2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Builder builder = new Builder();
            builder.audioKey = this.audioKey;
            builder.startFrame = this.startFrame;
            builder.endFrame = this.endFrame;
            builder.startTime = this.startTime;
            builder.totalTime = this.totalTime;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
        return (Builder) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AudioEntity(String str, Integer num, Integer num2, Integer num3, Integer num4) {
        this(str, num, num2, num3, num4, ByteString.EMPTY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, num, num2, num3, num4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Integer) objArr2[1], (Integer) objArr2[2], (Integer) objArr2[3], (Integer) objArr2[4], (ByteString) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioEntity(String str, Integer num, Integer num2, Integer num3, Integer num4, ByteString byteString) {
        super(ADAPTER, byteString);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, num, num2, num3, num4, byteString};
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
        this.audioKey = str;
        this.startFrame = num;
        this.endFrame = num2;
        this.startTime = num3;
        this.totalTime = num4;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AudioEntity)) {
                return false;
            }
            AudioEntity audioEntity = (AudioEntity) obj;
            if (unknownFields().equals(audioEntity.unknownFields()) && y4b.f(this.audioKey, audioEntity.audioKey) && y4b.f(this.startFrame, audioEntity.startFrame) && y4b.f(this.endFrame, audioEntity.endFrame) && y4b.f(this.startTime, audioEntity.startTime) && y4b.f(this.totalTime, audioEntity.totalTime)) {
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
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i5 = this.hashCode;
            if (i5 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                String str = this.audioKey;
                int i6 = 0;
                if (str != null) {
                    i = str.hashCode();
                } else {
                    i = 0;
                }
                int i7 = (hashCode + i) * 37;
                Integer num = this.startFrame;
                if (num != null) {
                    i2 = num.hashCode();
                } else {
                    i2 = 0;
                }
                int i8 = (i7 + i2) * 37;
                Integer num2 = this.endFrame;
                if (num2 != null) {
                    i3 = num2.hashCode();
                } else {
                    i3 = 0;
                }
                int i9 = (i8 + i3) * 37;
                Integer num3 = this.startTime;
                if (num3 != null) {
                    i4 = num3.hashCode();
                } else {
                    i4 = 0;
                }
                int i10 = (i9 + i4) * 37;
                Integer num4 = this.totalTime;
                if (num4 != null) {
                    i6 = num4.hashCode();
                }
                int i11 = i10 + i6;
                this.hashCode = i11;
                return i11;
            }
            return i5;
        }
        return invokeV.intValue;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.audioKey != null) {
                sb.append(", audioKey=");
                sb.append(this.audioKey);
            }
            if (this.startFrame != null) {
                sb.append(", startFrame=");
                sb.append(this.startFrame);
            }
            if (this.endFrame != null) {
                sb.append(", endFrame=");
                sb.append(this.endFrame);
            }
            if (this.startTime != null) {
                sb.append(", startTime=");
                sb.append(this.startTime);
            }
            if (this.totalTime != null) {
                sb.append(", totalTime=");
                sb.append(this.totalTime);
            }
            StringBuilder replace = sb.replace(0, 2, "AudioEntity{");
            replace.append('}');
            return replace.toString();
        }
        return (String) invokeV.objValue;
    }
}
