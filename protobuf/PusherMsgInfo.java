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
public final class PusherMsgInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_ET = "";
    public static final String DEFAULT_FOLLOW_ID = "";
    public static final String DEFAULT_FOLLOW_TYPE = "";
    public static final Long DEFAULT_GROUPID;
    public static final Integer DEFAULT_GROUPTYPE;
    public static final Long DEFAULT_MSGID;
    public static final Long DEFAULT_PUSHTIME;
    public static final String DEFAULT_TASK_ID = "";
    public static final Integer DEFAULT_TYPE;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String et;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String follow_id;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String follow_type;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer groupType;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long msgId;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long pushTime;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String task_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer type;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<PusherMsgInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public String et;
        public String follow_id;
        public String follow_type;
        public Long groupId;
        public Integer groupType;
        public Long msgId;
        public Long pushTime;
        public String task_id;
        public Integer type;

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
        public Builder(PusherMsgInfo pusherMsgInfo) {
            super(pusherMsgInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pusherMsgInfo};
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
            if (pusherMsgInfo == null) {
                return;
            }
            this.groupId = pusherMsgInfo.groupId;
            this.msgId = pusherMsgInfo.msgId;
            this.pushTime = pusherMsgInfo.pushTime;
            this.type = pusherMsgInfo.type;
            this.content = pusherMsgInfo.content;
            this.et = pusherMsgInfo.et;
            this.groupType = pusherMsgInfo.groupType;
            this.task_id = pusherMsgInfo.task_id;
            this.follow_id = pusherMsgInfo.follow_id;
            this.follow_type = pusherMsgInfo.follow_type;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PusherMsgInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new PusherMsgInfo(this, z, null) : (PusherMsgInfo) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-375590389, "Lprotobuf/PusherMsgInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-375590389, "Lprotobuf/PusherMsgInfo;");
                return;
            }
        }
        DEFAULT_GROUPID = 0L;
        DEFAULT_MSGID = 0L;
        DEFAULT_PUSHTIME = 0L;
        DEFAULT_TYPE = 0;
        DEFAULT_GROUPTYPE = 0;
    }

    public /* synthetic */ PusherMsgInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PusherMsgInfo(Builder builder, boolean z) {
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
            Long l = builder.groupId;
            if (l == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l;
            }
            Long l2 = builder.msgId;
            if (l2 == null) {
                this.msgId = DEFAULT_MSGID;
            } else {
                this.msgId = l2;
            }
            Long l3 = builder.pushTime;
            if (l3 == null) {
                this.pushTime = DEFAULT_PUSHTIME;
            } else {
                this.pushTime = l3;
            }
            Integer num = builder.type;
            if (num == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = num;
            }
            String str = builder.content;
            if (str == null) {
                this.content = "";
            } else {
                this.content = str;
            }
            String str2 = builder.et;
            if (str2 == null) {
                this.et = "";
            } else {
                this.et = str2;
            }
            Integer num2 = builder.groupType;
            if (num2 == null) {
                this.groupType = DEFAULT_GROUPTYPE;
            } else {
                this.groupType = num2;
            }
            String str3 = builder.task_id;
            if (str3 == null) {
                this.task_id = "";
            } else {
                this.task_id = str3;
            }
            String str4 = builder.follow_id;
            if (str4 == null) {
                this.follow_id = "";
            } else {
                this.follow_id = str4;
            }
            String str5 = builder.follow_type;
            if (str5 == null) {
                this.follow_type = "";
                return;
            } else {
                this.follow_type = str5;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.msgId = builder.msgId;
        this.pushTime = builder.pushTime;
        this.type = builder.type;
        this.content = builder.content;
        this.et = builder.et;
        this.groupType = builder.groupType;
        this.task_id = builder.task_id;
        this.follow_id = builder.follow_id;
        this.follow_type = builder.follow_type;
    }
}
