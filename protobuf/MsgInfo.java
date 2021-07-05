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
/* loaded from: classes10.dex */
public final class MsgInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CONTENT = "";
    public static final Integer DEFAULT_CREATETIME;
    public static final Integer DEFAULT_DURATION;
    public static final Integer DEFAULT_FOLLOWSTATUS;
    public static final Long DEFAULT_GROUPID;
    public static final Integer DEFAULT_ISFRIEND;
    public static final String DEFAULT_LINK = "";
    public static final Long DEFAULT_MSGID;
    public static final Integer DEFAULT_MSGTYPE;
    public static final Long DEFAULT_RECORDID;
    public static final Long DEFAULT_SERVICEID;
    public static final Long DEFAULT_SID;
    public static final String DEFAULT_STAT = "";
    public static final Integer DEFAULT_STATUS;
    public static final Long DEFAULT_TASKID;
    public static final Long DEFAULT_TOUID;
    public static final Long DEFAULT_USERID;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer createTime;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer duration;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer followStatus;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer isFriend;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String link;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long msgId;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer msgType;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long recordId;
    @ProtoField(tag = 19, type = Message.Datatype.INT64)
    public final Long serviceId;
    @ProtoField(tag = 17, type = Message.Datatype.INT64)
    public final Long sid;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String stat;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long taskId;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long toUid;
    @ProtoField(tag = 12)
    public final UserInfo toUserInfo;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long userId;
    @ProtoField(tag = 10)
    public final UserInfo userInfo;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<MsgInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public Integer createTime;
        public Integer duration;
        public Integer followStatus;
        public Long groupId;
        public Integer isFriend;
        public String link;
        public Long msgId;
        public Integer msgType;
        public Long recordId;
        public Long serviceId;
        public Long sid;
        public String stat;
        public Integer status;
        public Long taskId;
        public Long toUid;
        public UserInfo toUserInfo;
        public Long userId;
        public UserInfo userInfo;

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
        public Builder(MsgInfo msgInfo) {
            super(msgInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgInfo};
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
            if (msgInfo == null) {
                return;
            }
            this.msgId = msgInfo.msgId;
            this.groupId = msgInfo.groupId;
            this.msgType = msgInfo.msgType;
            this.userId = msgInfo.userId;
            this.content = msgInfo.content;
            this.status = msgInfo.status;
            this.duration = msgInfo.duration;
            this.createTime = msgInfo.createTime;
            this.recordId = msgInfo.recordId;
            this.userInfo = msgInfo.userInfo;
            this.toUid = msgInfo.toUid;
            this.toUserInfo = msgInfo.toUserInfo;
            this.link = msgInfo.link;
            this.stat = msgInfo.stat;
            this.taskId = msgInfo.taskId;
            this.isFriend = msgInfo.isFriend;
            this.sid = msgInfo.sid;
            this.followStatus = msgInfo.followStatus;
            this.serviceId = msgInfo.serviceId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public MsgInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new MsgInfo(this, z, null) : (MsgInfo) invokeZ.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(344213924, "Lprotobuf/MsgInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(344213924, "Lprotobuf/MsgInfo;");
                return;
            }
        }
        DEFAULT_MSGID = 0L;
        DEFAULT_GROUPID = 0L;
        DEFAULT_MSGTYPE = 0;
        DEFAULT_USERID = 0L;
        DEFAULT_STATUS = 0;
        DEFAULT_DURATION = 0;
        DEFAULT_CREATETIME = 0;
        DEFAULT_RECORDID = 0L;
        DEFAULT_TOUID = 0L;
        DEFAULT_TASKID = 0L;
        DEFAULT_ISFRIEND = 0;
        DEFAULT_SID = 0L;
        DEFAULT_FOLLOWSTATUS = 0;
        DEFAULT_SERVICEID = 0L;
    }

    public /* synthetic */ MsgInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgInfo(Builder builder, boolean z) {
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
            Long l = builder.msgId;
            if (l == null) {
                this.msgId = DEFAULT_MSGID;
            } else {
                this.msgId = l;
            }
            Long l2 = builder.groupId;
            if (l2 == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l2;
            }
            Integer num = builder.msgType;
            if (num == null) {
                this.msgType = DEFAULT_MSGTYPE;
            } else {
                this.msgType = num;
            }
            Long l3 = builder.userId;
            if (l3 == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = l3;
            }
            String str = builder.content;
            if (str == null) {
                this.content = "";
            } else {
                this.content = str;
            }
            Integer num2 = builder.status;
            if (num2 == null) {
                this.status = DEFAULT_STATUS;
            } else {
                this.status = num2;
            }
            Integer num3 = builder.duration;
            if (num3 == null) {
                this.duration = DEFAULT_DURATION;
            } else {
                this.duration = num3;
            }
            Integer num4 = builder.createTime;
            if (num4 == null) {
                this.createTime = DEFAULT_CREATETIME;
            } else {
                this.createTime = num4;
            }
            Long l4 = builder.recordId;
            if (l4 == null) {
                this.recordId = DEFAULT_RECORDID;
            } else {
                this.recordId = l4;
            }
            this.userInfo = builder.userInfo;
            Long l5 = builder.toUid;
            if (l5 == null) {
                this.toUid = DEFAULT_TOUID;
            } else {
                this.toUid = l5;
            }
            this.toUserInfo = builder.toUserInfo;
            String str2 = builder.link;
            if (str2 == null) {
                this.link = "";
            } else {
                this.link = str2;
            }
            String str3 = builder.stat;
            if (str3 == null) {
                this.stat = "";
            } else {
                this.stat = str3;
            }
            Long l6 = builder.taskId;
            if (l6 == null) {
                this.taskId = DEFAULT_TASKID;
            } else {
                this.taskId = l6;
            }
            Integer num5 = builder.isFriend;
            if (num5 == null) {
                this.isFriend = DEFAULT_ISFRIEND;
            } else {
                this.isFriend = num5;
            }
            Long l7 = builder.sid;
            if (l7 == null) {
                this.sid = DEFAULT_SID;
            } else {
                this.sid = l7;
            }
            Integer num6 = builder.followStatus;
            if (num6 == null) {
                this.followStatus = DEFAULT_FOLLOWSTATUS;
            } else {
                this.followStatus = num6;
            }
            Long l8 = builder.serviceId;
            if (l8 == null) {
                this.serviceId = DEFAULT_SERVICEID;
                return;
            } else {
                this.serviceId = l8;
                return;
            }
        }
        this.msgId = builder.msgId;
        this.groupId = builder.groupId;
        this.msgType = builder.msgType;
        this.userId = builder.userId;
        this.content = builder.content;
        this.status = builder.status;
        this.duration = builder.duration;
        this.createTime = builder.createTime;
        this.recordId = builder.recordId;
        this.userInfo = builder.userInfo;
        this.toUid = builder.toUid;
        this.toUserInfo = builder.toUserInfo;
        this.link = builder.link;
        this.stat = builder.stat;
        this.taskId = builder.taskId;
        this.isFriend = builder.isFriend;
        this.sid = builder.sid;
        this.followStatus = builder.followStatus;
        this.serviceId = builder.serviceId;
    }
}
