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
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class UserInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_BJHAVATAR = "";
    public static final Integer DEFAULT_BUSINESSACCOUNT;
    public static final String DEFAULT_FANSNICKNAME = "";
    public static final Integer DEFAULT_FANSNUM;
    public static final Integer DEFAULT_INTIME;
    public static final Integer DEFAULT_LASTREPLYTIME;
    public static final Double DEFAULT_LAT;
    public static final Double DEFAULT_LNG;
    public static final Integer DEFAULT_LOGINTIME;
    public static final String DEFAULT_NICKNAME = "";
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_POSITION = "";
    public static final Integer DEFAULT_SEX;
    public static final Integer DEFAULT_SYSGROUPID;
    public static final List<TshowInfo> DEFAULT_TSHOWICON;
    public static final Long DEFAULT_USERID;
    public static final String DEFAULT_USERNAME = "";
    public static final String DEFAULT_USERNAMESHOW = "";
    public static final Integer DEFAULT_USERTYPE;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String bjhAvatar;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer businessaccount;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String fansNickname;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer fansNum;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer inTime;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer lastReplyTime;
    @ProtoField(tag = 8, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(tag = 7, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer loginTime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String nickName;
    @ProtoField(tag = 13)
    public final UserPermission permission;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String position;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer sex;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer sysGroupId;
    @ProtoField(label = Message.Label.REPEATED, tag = 14)
    public final List<TshowInfo> tshowIcon;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long userId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String userName;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String userNameShow;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer userType;

    /* loaded from: classes5.dex */
    public static final class Builder extends Message.Builder<UserInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String bjhAvatar;
        public Integer businessaccount;
        public String fansNickname;
        public Integer fansNum;
        public Integer inTime;
        public Integer lastReplyTime;
        public Double lat;
        public Double lng;
        public Integer loginTime;
        public String nickName;
        public UserPermission permission;
        public String portrait;
        public String position;
        public Integer sex;
        public Integer sysGroupId;
        public List<TshowInfo> tshowIcon;
        public Long userId;
        public String userName;
        public String userNameShow;
        public Integer userType;

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
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(UserInfo userInfo) {
            super(userInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userInfo};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Message) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (userInfo == null) {
                return;
            }
            this.userId = userInfo.userId;
            this.userName = userInfo.userName;
            this.nickName = userInfo.nickName;
            this.portrait = userInfo.portrait;
            this.sex = userInfo.sex;
            this.position = userInfo.position;
            this.lng = userInfo.lng;
            this.lat = userInfo.lat;
            this.inTime = userInfo.inTime;
            this.loginTime = userInfo.loginTime;
            this.lastReplyTime = userInfo.lastReplyTime;
            this.sysGroupId = userInfo.sysGroupId;
            this.permission = userInfo.permission;
            this.tshowIcon = Message.copyOf(userInfo.tshowIcon);
            this.userType = userInfo.userType;
            this.fansNum = userInfo.fansNum;
            this.fansNickname = userInfo.fansNickname;
            this.userNameShow = userInfo.userNameShow;
            this.bjhAvatar = userInfo.bjhAvatar;
            this.businessaccount = userInfo.businessaccount;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UserInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new UserInfo(this, z, null) : (UserInfo) invokeZ.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-129187862, "Lprotobuf/UserInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-129187862, "Lprotobuf/UserInfo;");
                return;
            }
        }
        DEFAULT_USERID = 0L;
        DEFAULT_SEX = 0;
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LNG = valueOf;
        DEFAULT_LAT = valueOf;
        DEFAULT_INTIME = 0;
        DEFAULT_LOGINTIME = 0;
        DEFAULT_LASTREPLYTIME = 0;
        DEFAULT_SYSGROUPID = 0;
        DEFAULT_TSHOWICON = Collections.emptyList();
        DEFAULT_USERTYPE = 0;
        DEFAULT_FANSNUM = 0;
        DEFAULT_BUSINESSACCOUNT = 0;
    }

    public /* synthetic */ UserInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserInfo(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            String str = builder.userName;
            if (str == null) {
                this.userName = "";
            } else {
                this.userName = str;
            }
            String str2 = builder.nickName;
            if (str2 == null) {
                this.nickName = "";
            } else {
                this.nickName = str2;
            }
            String str3 = builder.portrait;
            if (str3 == null) {
                this.portrait = "";
            } else {
                this.portrait = str3;
            }
            Integer num = builder.sex;
            if (num == null) {
                this.sex = DEFAULT_SEX;
            } else {
                this.sex = num;
            }
            String str4 = builder.position;
            if (str4 == null) {
                this.position = "";
            } else {
                this.position = str4;
            }
            Double d2 = builder.lng;
            if (d2 == null) {
                this.lng = DEFAULT_LNG;
            } else {
                this.lng = d2;
            }
            Double d3 = builder.lat;
            if (d3 == null) {
                this.lat = DEFAULT_LAT;
            } else {
                this.lat = d3;
            }
            Integer num2 = builder.inTime;
            if (num2 == null) {
                this.inTime = DEFAULT_INTIME;
            } else {
                this.inTime = num2;
            }
            Integer num3 = builder.loginTime;
            if (num3 == null) {
                this.loginTime = DEFAULT_LOGINTIME;
            } else {
                this.loginTime = num3;
            }
            Integer num4 = builder.lastReplyTime;
            if (num4 == null) {
                this.lastReplyTime = DEFAULT_LASTREPLYTIME;
            } else {
                this.lastReplyTime = num4;
            }
            Integer num5 = builder.sysGroupId;
            if (num5 == null) {
                this.sysGroupId = DEFAULT_SYSGROUPID;
            } else {
                this.sysGroupId = num5;
            }
            this.permission = builder.permission;
            List<TshowInfo> list = builder.tshowIcon;
            if (list == null) {
                this.tshowIcon = DEFAULT_TSHOWICON;
            } else {
                this.tshowIcon = Message.immutableCopyOf(list);
            }
            Integer num6 = builder.userType;
            if (num6 == null) {
                this.userType = DEFAULT_USERTYPE;
            } else {
                this.userType = num6;
            }
            Integer num7 = builder.fansNum;
            if (num7 == null) {
                this.fansNum = DEFAULT_FANSNUM;
            } else {
                this.fansNum = num7;
            }
            String str5 = builder.fansNickname;
            if (str5 == null) {
                this.fansNickname = "";
            } else {
                this.fansNickname = str5;
            }
            String str6 = builder.userNameShow;
            if (str6 == null) {
                this.userNameShow = "";
            } else {
                this.userNameShow = str6;
            }
            String str7 = builder.bjhAvatar;
            if (str7 == null) {
                this.bjhAvatar = "";
            } else {
                this.bjhAvatar = str7;
            }
            Integer num8 = builder.businessaccount;
            if (num8 == null) {
                this.businessaccount = DEFAULT_BUSINESSACCOUNT;
                return;
            } else {
                this.businessaccount = num8;
                return;
            }
        }
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.nickName = builder.nickName;
        this.portrait = builder.portrait;
        this.sex = builder.sex;
        this.position = builder.position;
        this.lng = builder.lng;
        this.lat = builder.lat;
        this.inTime = builder.inTime;
        this.loginTime = builder.loginTime;
        this.lastReplyTime = builder.lastReplyTime;
        this.sysGroupId = builder.sysGroupId;
        this.permission = builder.permission;
        this.tshowIcon = Message.immutableCopyOf(builder.tshowIcon);
        this.userType = builder.userType;
        this.fansNum = builder.fansNum;
        this.fansNickname = builder.fansNickname;
        this.userNameShow = builder.userNameShow;
        this.bjhAvatar = builder.bjhAvatar;
        this.businessaccount = builder.businessaccount;
    }
}
