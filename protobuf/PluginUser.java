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
public final class PluginUser extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_ISDOWNLOADCARDWHITEUSER;
    public static final Long DEFAULT_USERID;
    public static final String DEFAULT_USERNAMESHOW = "";
    public static final String DEFAULT_USERPHOTO = "";
    public static final Integer DEFAULT_USERTYPE;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer isDownloadCardWhiteuser;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long userId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String userNameShow;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String userPhoto;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userType;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<PluginUser> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer isDownloadCardWhiteuser;
        public Long userId;
        public String userNameShow;
        public String userPhoto;
        public Integer userType;

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
        public Builder(PluginUser pluginUser) {
            super(pluginUser);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginUser};
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
            if (pluginUser == null) {
                return;
            }
            this.userId = pluginUser.userId;
            this.userNameShow = pluginUser.userNameShow;
            this.userType = pluginUser.userType;
            this.userPhoto = pluginUser.userPhoto;
            this.isDownloadCardWhiteuser = pluginUser.isDownloadCardWhiteuser;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PluginUser build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new PluginUser(this, z, null) : (PluginUser) invokeZ.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-350801915, "Lprotobuf/PluginUser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-350801915, "Lprotobuf/PluginUser;");
                return;
            }
        }
        DEFAULT_USERID = 0L;
        DEFAULT_USERTYPE = 0;
        DEFAULT_ISDOWNLOADCARDWHITEUSER = 0;
    }

    public /* synthetic */ PluginUser(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginUser(Builder builder, boolean z) {
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
            String str = builder.userNameShow;
            if (str == null) {
                this.userNameShow = "";
            } else {
                this.userNameShow = str;
            }
            Integer num = builder.userType;
            if (num == null) {
                this.userType = DEFAULT_USERTYPE;
            } else {
                this.userType = num;
            }
            String str2 = builder.userPhoto;
            if (str2 == null) {
                this.userPhoto = "";
            } else {
                this.userPhoto = str2;
            }
            Integer num2 = builder.isDownloadCardWhiteuser;
            if (num2 == null) {
                this.isDownloadCardWhiteuser = DEFAULT_ISDOWNLOADCARDWHITEUSER;
                return;
            } else {
                this.isDownloadCardWhiteuser = num2;
                return;
            }
        }
        this.userId = builder.userId;
        this.userNameShow = builder.userNameShow;
        this.userType = builder.userType;
        this.userPhoto = builder.userPhoto;
        this.isDownloadCardWhiteuser = builder.isDownloadCardWhiteuser;
    }
}
