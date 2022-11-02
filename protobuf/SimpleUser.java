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
public final class SimpleUser extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_AGREETYPE;
    public static final String DEFAULT_AHEADURL = "";
    public static final String DEFAULT_BLOCKMSG = "";
    public static final Integer DEFAULT_INCOMPLETEUSER;
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_SECUREEMAIL = "";
    public static final String DEFAULT_SECUREMOBIL = "";
    public static final Integer DEFAULT_SHOWONLYME;
    public static final Long DEFAULT_USERID;
    public static final String DEFAULT_USERNAME = "";
    public static final String DEFAULT_USERNICKNAME = "";
    public static final Integer DEFAULT_USERSTATUS;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer agreeType;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String aheadUrl;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String blockMsg;
    @ProtoField(tag = 7, type = Message.Datatype.UINT32)
    public final Integer incompleteUser;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String secureemail;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String securemobil;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer showOnlyme;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long userId;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String userName;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String userNickname;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userStatus;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<SimpleUser> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer agreeType;
        public String aheadUrl;
        public String blockMsg;
        public Integer incompleteUser;
        public String portrait;
        public String secureemail;
        public String securemobil;
        public Integer showOnlyme;
        public Long userId;
        public String userName;
        public String userNickname;
        public Integer userStatus;

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
        public Builder(SimpleUser simpleUser) {
            super(simpleUser);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {simpleUser};
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
            if (simpleUser == null) {
                return;
            }
            this.userId = simpleUser.userId;
            this.userStatus = simpleUser.userStatus;
            this.secureemail = simpleUser.secureemail;
            this.securemobil = simpleUser.securemobil;
            this.userName = simpleUser.userName;
            this.userNickname = simpleUser.userNickname;
            this.incompleteUser = simpleUser.incompleteUser;
            this.portrait = simpleUser.portrait;
            this.agreeType = simpleUser.agreeType;
            this.aheadUrl = simpleUser.aheadUrl;
            this.blockMsg = simpleUser.blockMsg;
            this.showOnlyme = simpleUser.showOnlyme;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public SimpleUser build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new SimpleUser(this, z, null);
            }
            return (SimpleUser) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1627858150, "Lprotobuf/SimpleUser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1627858150, "Lprotobuf/SimpleUser;");
                return;
            }
        }
        DEFAULT_USERID = 0L;
        DEFAULT_USERSTATUS = 0;
        DEFAULT_INCOMPLETEUSER = 0;
        DEFAULT_AGREETYPE = 0;
        DEFAULT_SHOWONLYME = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleUser(Builder builder, boolean z) {
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
            Long l = builder.userId;
            if (l == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = l;
            }
            Integer num = builder.userStatus;
            if (num == null) {
                this.userStatus = DEFAULT_USERSTATUS;
            } else {
                this.userStatus = num;
            }
            String str = builder.secureemail;
            if (str == null) {
                this.secureemail = "";
            } else {
                this.secureemail = str;
            }
            String str2 = builder.securemobil;
            if (str2 == null) {
                this.securemobil = "";
            } else {
                this.securemobil = str2;
            }
            String str3 = builder.userName;
            if (str3 == null) {
                this.userName = "";
            } else {
                this.userName = str3;
            }
            String str4 = builder.userNickname;
            if (str4 == null) {
                this.userNickname = "";
            } else {
                this.userNickname = str4;
            }
            Integer num2 = builder.incompleteUser;
            if (num2 == null) {
                this.incompleteUser = DEFAULT_INCOMPLETEUSER;
            } else {
                this.incompleteUser = num2;
            }
            String str5 = builder.portrait;
            if (str5 == null) {
                this.portrait = "";
            } else {
                this.portrait = str5;
            }
            Integer num3 = builder.agreeType;
            if (num3 == null) {
                this.agreeType = DEFAULT_AGREETYPE;
            } else {
                this.agreeType = num3;
            }
            String str6 = builder.aheadUrl;
            if (str6 == null) {
                this.aheadUrl = "";
            } else {
                this.aheadUrl = str6;
            }
            String str7 = builder.blockMsg;
            if (str7 == null) {
                this.blockMsg = "";
            } else {
                this.blockMsg = str7;
            }
            Integer num4 = builder.showOnlyme;
            if (num4 == null) {
                this.showOnlyme = DEFAULT_SHOWONLYME;
                return;
            } else {
                this.showOnlyme = num4;
                return;
            }
        }
        this.userId = builder.userId;
        this.userStatus = builder.userStatus;
        this.secureemail = builder.secureemail;
        this.securemobil = builder.securemobil;
        this.userName = builder.userName;
        this.userNickname = builder.userNickname;
        this.incompleteUser = builder.incompleteUser;
        this.portrait = builder.portrait;
        this.agreeType = builder.agreeType;
        this.aheadUrl = builder.aheadUrl;
        this.blockMsg = builder.blockMsg;
        this.showOnlyme = builder.showOnlyme;
    }

    public /* synthetic */ SimpleUser(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
