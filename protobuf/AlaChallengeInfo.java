package protobuf;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class AlaChallengeInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Long DEFAULT_CHALLENGEID;
    public static final String DEFAULT_EXT = "";
    public static final String DEFAULT_RIVALHLSURL = "";
    public static final String DEFAULT_RIVALRTMPURL = "";
    public static final String DEFAULT_RIVALSESSION = "";
    public static final Long DEFAULT_WINNINGNUM;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long challengeId;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String ext;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String rivalHlsUrl;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String rivalRtmpUrl;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String rivalSession;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long winningNum;

    /* loaded from: classes9.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class Builder extends Message.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Long challengeId;
        public String ext;
        public String rivalHlsUrl;
        public String rivalRtmpUrl;
        public String rivalSession;
        public Long winningNum;

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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(AlaChallengeInfo alaChallengeInfo) {
            super(alaChallengeInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaChallengeInfo};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Message) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (alaChallengeInfo == null) {
                return;
            }
            this.challengeId = alaChallengeInfo.challengeId;
            this.winningNum = alaChallengeInfo.winningNum;
            this.rivalSession = alaChallengeInfo.rivalSession;
            this.rivalRtmpUrl = alaChallengeInfo.rivalRtmpUrl;
            this.rivalHlsUrl = alaChallengeInfo.rivalHlsUrl;
            this.ext = alaChallengeInfo.ext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AlaChallengeInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new AlaChallengeInfo(this, z, null);
            }
            return (AlaChallengeInfo) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(936013192, "Lprotobuf/AlaChallengeInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(936013192, "Lprotobuf/AlaChallengeInfo;");
                return;
            }
        }
        DEFAULT_CHALLENGEID = 0L;
        DEFAULT_WINNINGNUM = 0L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaChallengeInfo(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (z) {
            Long l = builder.challengeId;
            if (l == null) {
                this.challengeId = DEFAULT_CHALLENGEID;
            } else {
                this.challengeId = l;
            }
            Long l2 = builder.winningNum;
            if (l2 == null) {
                this.winningNum = DEFAULT_WINNINGNUM;
            } else {
                this.winningNum = l2;
            }
            String str = builder.rivalSession;
            if (str == null) {
                this.rivalSession = "";
            } else {
                this.rivalSession = str;
            }
            String str2 = builder.rivalRtmpUrl;
            if (str2 == null) {
                this.rivalRtmpUrl = "";
            } else {
                this.rivalRtmpUrl = str2;
            }
            String str3 = builder.rivalHlsUrl;
            if (str3 == null) {
                this.rivalHlsUrl = "";
            } else {
                this.rivalHlsUrl = str3;
            }
            String str4 = builder.ext;
            if (str4 == null) {
                this.ext = "";
                return;
            } else {
                this.ext = str4;
                return;
            }
        }
        this.challengeId = builder.challengeId;
        this.winningNum = builder.winningNum;
        this.rivalSession = builder.rivalSession;
        this.rivalRtmpUrl = builder.rivalRtmpUrl;
        this.rivalHlsUrl = builder.rivalHlsUrl;
        this.ext = builder.ext;
    }

    public /* synthetic */ AlaChallengeInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
