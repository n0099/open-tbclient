package protobuf;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes8.dex */
public final class SignatureInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_GAMEID = "";
    public static final String DEFAULT_GAMENAME = "";
    public static final String DEFAULT_PLAYER = "";
    public static final String DEFAULT_POWER = "";
    public static final String DEFAULT_SERVER = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 5)
    public final Avatar avatar;
    @ProtoField(tag = 1)
    public final Equipment equipment;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String gameId;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String gameName;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String player;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String power;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String server;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<SignatureInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Avatar avatar;
        public Equipment equipment;
        public String gameId;
        public String gameName;
        public String player;
        public String power;
        public String server;

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
        public Builder(SignatureInfo signatureInfo) {
            super(signatureInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signatureInfo};
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
            if (signatureInfo == null) {
                return;
            }
            this.equipment = signatureInfo.equipment;
            this.gameId = signatureInfo.gameId;
            this.gameName = signatureInfo.gameName;
            this.player = signatureInfo.player;
            this.avatar = signatureInfo.avatar;
            this.power = signatureInfo.power;
            this.server = signatureInfo.server;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SignatureInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new SignatureInfo(this, z, null) : (SignatureInfo) invokeZ.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ SignatureInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignatureInfo(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (z) {
            this.equipment = builder.equipment;
            String str = builder.gameId;
            if (str == null) {
                this.gameId = "";
            } else {
                this.gameId = str;
            }
            String str2 = builder.gameName;
            if (str2 == null) {
                this.gameName = "";
            } else {
                this.gameName = str2;
            }
            String str3 = builder.player;
            if (str3 == null) {
                this.player = "";
            } else {
                this.player = str3;
            }
            this.avatar = builder.avatar;
            String str4 = builder.power;
            if (str4 == null) {
                this.power = "";
            } else {
                this.power = str4;
            }
            String str5 = builder.server;
            if (str5 == null) {
                this.server = "";
                return;
            } else {
                this.server = str5;
                return;
            }
        }
        this.equipment = builder.equipment;
        this.gameId = builder.gameId;
        this.gameName = builder.gameName;
        this.player = builder.player;
        this.avatar = builder.avatar;
        this.power = builder.power;
        this.server = builder.server;
    }
}
