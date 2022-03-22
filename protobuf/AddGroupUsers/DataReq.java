package protobuf.AddGroupUsers;

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
/* loaded from: classes8.dex */
public final class DataReq extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_DECISION;
    public static final Long DEFAULT_GROUPID;
    public static final Long DEFAULT_INVITEUSERID;
    public static final Integer DEFAULT_JOINTYPE;
    public static final Integer DEFAULT_SYSGROUPID;
    public static final Integer DEFAULT_SYSMSGID;
    public static final String DEFAULT_USERIDS = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer decision;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long inviteUserId;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer joinType;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer sysGroupId;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer sysMsgId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String userIds;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer decision;
        public Long groupId;
        public Long inviteUserId;
        public Integer joinType;
        public Integer sysGroupId;
        public Integer sysMsgId;
        public String userIds;

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
        public Builder(DataReq dataReq) {
            super(dataReq);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dataReq};
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
            if (dataReq == null) {
                return;
            }
            this.groupId = dataReq.groupId;
            this.userIds = dataReq.userIds;
            this.sysMsgId = dataReq.sysMsgId;
            this.sysGroupId = dataReq.sysGroupId;
            this.decision = dataReq.decision;
            this.inviteUserId = dataReq.inviteUserId;
            this.joinType = dataReq.joinType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new DataReq(this, z, null) : (DataReq) invokeZ.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1283187140, "Lprotobuf/AddGroupUsers/DataReq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1283187140, "Lprotobuf/AddGroupUsers/DataReq;");
                return;
            }
        }
        DEFAULT_GROUPID = 0L;
        DEFAULT_SYSMSGID = 0;
        DEFAULT_SYSGROUPID = 0;
        DEFAULT_DECISION = 0;
        DEFAULT_INVITEUSERID = 0L;
        DEFAULT_JOINTYPE = 0;
    }

    public /* synthetic */ DataReq(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataReq(Builder builder, boolean z) {
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
            Long l = builder.groupId;
            if (l == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l;
            }
            String str = builder.userIds;
            if (str == null) {
                this.userIds = "";
            } else {
                this.userIds = str;
            }
            Integer num = builder.sysMsgId;
            if (num == null) {
                this.sysMsgId = DEFAULT_SYSMSGID;
            } else {
                this.sysMsgId = num;
            }
            Integer num2 = builder.sysGroupId;
            if (num2 == null) {
                this.sysGroupId = DEFAULT_SYSGROUPID;
            } else {
                this.sysGroupId = num2;
            }
            Integer num3 = builder.decision;
            if (num3 == null) {
                this.decision = DEFAULT_DECISION;
            } else {
                this.decision = num3;
            }
            Long l2 = builder.inviteUserId;
            if (l2 == null) {
                this.inviteUserId = DEFAULT_INVITEUSERID;
            } else {
                this.inviteUserId = l2;
            }
            Integer num4 = builder.joinType;
            if (num4 == null) {
                this.joinType = DEFAULT_JOINTYPE;
                return;
            } else {
                this.joinType = num4;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.userIds = builder.userIds;
        this.sysMsgId = builder.sysMsgId;
        this.sysGroupId = builder.sysGroupId;
        this.decision = builder.decision;
        this.inviteUserId = builder.inviteUserId;
        this.joinType = builder.joinType;
    }
}
