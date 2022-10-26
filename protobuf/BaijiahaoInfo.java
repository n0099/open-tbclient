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
public final class BaijiahaoInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_AUTHDESC = "";
    public static final Integer DEFAULT_AUTHID;
    public static final String DEFAULT_AVATAR = "";
    public static final String DEFAULT_AVATARH = "";
    public static final String DEFAULT_BRIEF = "";
    public static final Integer DEFAULT_CANMODIFYAVATAR;
    public static final String DEFAULT_NAME = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String authDesc;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer authId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String avatar;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String avatarH;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String brief;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer canModifyAvatar;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;

    /* loaded from: classes9.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class Builder extends Message.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String authDesc;
        public Integer authId;
        public String avatar;
        public String avatarH;
        public String brief;
        public Integer canModifyAvatar;
        public String name;

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
        public Builder(BaijiahaoInfo baijiahaoInfo) {
            super(baijiahaoInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baijiahaoInfo};
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
            if (baijiahaoInfo == null) {
                return;
            }
            this.name = baijiahaoInfo.name;
            this.avatar = baijiahaoInfo.avatar;
            this.avatarH = baijiahaoInfo.avatarH;
            this.brief = baijiahaoInfo.brief;
            this.authId = baijiahaoInfo.authId;
            this.authDesc = baijiahaoInfo.authDesc;
            this.canModifyAvatar = baijiahaoInfo.canModifyAvatar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public BaijiahaoInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new BaijiahaoInfo(this, z, null);
            }
            return (BaijiahaoInfo) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(216601703, "Lprotobuf/BaijiahaoInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(216601703, "Lprotobuf/BaijiahaoInfo;");
                return;
            }
        }
        DEFAULT_AUTHID = 0;
        DEFAULT_CANMODIFYAVATAR = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaijiahaoInfo(Builder builder, boolean z) {
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
            String str = builder.name;
            if (str == null) {
                this.name = "";
            } else {
                this.name = str;
            }
            String str2 = builder.avatar;
            if (str2 == null) {
                this.avatar = "";
            } else {
                this.avatar = str2;
            }
            String str3 = builder.avatarH;
            if (str3 == null) {
                this.avatarH = "";
            } else {
                this.avatarH = str3;
            }
            String str4 = builder.brief;
            if (str4 == null) {
                this.brief = "";
            } else {
                this.brief = str4;
            }
            Integer num = builder.authId;
            if (num == null) {
                this.authId = DEFAULT_AUTHID;
            } else {
                this.authId = num;
            }
            String str5 = builder.authDesc;
            if (str5 == null) {
                this.authDesc = "";
            } else {
                this.authDesc = str5;
            }
            Integer num2 = builder.canModifyAvatar;
            if (num2 == null) {
                this.canModifyAvatar = DEFAULT_CANMODIFYAVATAR;
                return;
            } else {
                this.canModifyAvatar = num2;
                return;
            }
        }
        this.name = builder.name;
        this.avatar = builder.avatar;
        this.avatarH = builder.avatarH;
        this.brief = builder.brief;
        this.authId = builder.authId;
        this.authDesc = builder.authDesc;
        this.canModifyAvatar = builder.canModifyAvatar;
    }

    public /* synthetic */ BaijiahaoInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
