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
public final class McnAdInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Long DEFAULT_ADENDTIME;
    public static final Long DEFAULT_ADSTARTTIME;
    public static final String DEFAULT_BUTTONTITLE = "";
    public static final String DEFAULT_CARDTITLE = "";
    public static final Long DEFAULT_EFFECTTIME;
    public static final Long DEFAULT_EXPIRETIME;
    public static final String DEFAULT_JUMPURL = "";
    public static final String DEFAULT_PICURL = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long adEndTime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long adStartTime;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String buttonTitle;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String cardTitle;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long effectTime;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long expireTime;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String jumpUrl;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String picUrl;

    /* loaded from: classes9.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class Builder extends Message.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Long adEndTime;
        public Long adStartTime;
        public String buttonTitle;
        public String cardTitle;
        public Long effectTime;
        public Long expireTime;
        public String jumpUrl;
        public String picUrl;

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
        public Builder(McnAdInfo mcnAdInfo) {
            super(mcnAdInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mcnAdInfo};
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
            if (mcnAdInfo == null) {
                return;
            }
            this.adStartTime = mcnAdInfo.adStartTime;
            this.adEndTime = mcnAdInfo.adEndTime;
            this.picUrl = mcnAdInfo.picUrl;
            this.jumpUrl = mcnAdInfo.jumpUrl;
            this.cardTitle = mcnAdInfo.cardTitle;
            this.buttonTitle = mcnAdInfo.buttonTitle;
            this.effectTime = mcnAdInfo.effectTime;
            this.expireTime = mcnAdInfo.expireTime;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public McnAdInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new McnAdInfo(this, z, null);
            }
            return (McnAdInfo) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-576783478, "Lprotobuf/McnAdInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-576783478, "Lprotobuf/McnAdInfo;");
                return;
            }
        }
        DEFAULT_ADSTARTTIME = 0L;
        DEFAULT_ADENDTIME = 0L;
        DEFAULT_EFFECTTIME = 0L;
        DEFAULT_EXPIRETIME = 0L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McnAdInfo(Builder builder, boolean z) {
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
            Long l = builder.adStartTime;
            if (l == null) {
                this.adStartTime = DEFAULT_ADSTARTTIME;
            } else {
                this.adStartTime = l;
            }
            Long l2 = builder.adEndTime;
            if (l2 == null) {
                this.adEndTime = DEFAULT_ADENDTIME;
            } else {
                this.adEndTime = l2;
            }
            String str = builder.picUrl;
            if (str == null) {
                this.picUrl = "";
            } else {
                this.picUrl = str;
            }
            String str2 = builder.jumpUrl;
            if (str2 == null) {
                this.jumpUrl = "";
            } else {
                this.jumpUrl = str2;
            }
            String str3 = builder.cardTitle;
            if (str3 == null) {
                this.cardTitle = "";
            } else {
                this.cardTitle = str3;
            }
            String str4 = builder.buttonTitle;
            if (str4 == null) {
                this.buttonTitle = "";
            } else {
                this.buttonTitle = str4;
            }
            Long l3 = builder.effectTime;
            if (l3 == null) {
                this.effectTime = DEFAULT_EFFECTTIME;
            } else {
                this.effectTime = l3;
            }
            Long l4 = builder.expireTime;
            if (l4 == null) {
                this.expireTime = DEFAULT_EXPIRETIME;
                return;
            } else {
                this.expireTime = l4;
                return;
            }
        }
        this.adStartTime = builder.adStartTime;
        this.adEndTime = builder.adEndTime;
        this.picUrl = builder.picUrl;
        this.jumpUrl = builder.jumpUrl;
        this.cardTitle = builder.cardTitle;
        this.buttonTitle = builder.buttonTitle;
        this.effectTime = builder.effectTime;
        this.expireTime = builder.expireTime;
    }

    public /* synthetic */ McnAdInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
