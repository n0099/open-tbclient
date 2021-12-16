package protobuf.CommitPersonalMsg;

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
/* loaded from: classes4.dex */
public final class DataReq extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CONTENT = "";
    public static final Integer DEFAULT_DURATION;
    public static final Long DEFAULT_GROUPID;
    public static final Integer DEFAULT_MSGTYPE;
    public static final Long DEFAULT_RECORDID;
    public static final String DEFAULT_ST_TYPE = "";
    public static final Long DEFAULT_TOUID;
    public static final Integer DEFAULT_TOUSERTYPE;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer duration;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer msgType;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long recordId;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String st_type;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long toUid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer toUserType;

    /* loaded from: classes4.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public Integer duration;
        public Long groupId;
        public Integer msgType;
        public Long recordId;
        public String st_type;
        public Long toUid;
        public Integer toUserType;

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
        public Builder(DataReq dataReq) {
            super(dataReq);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dataReq};
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
            if (dataReq == null) {
                return;
            }
            this.groupId = dataReq.groupId;
            this.toUid = dataReq.toUid;
            this.msgType = dataReq.msgType;
            this.content = dataReq.content;
            this.duration = dataReq.duration;
            this.recordId = dataReq.recordId;
            this.toUserType = dataReq.toUserType;
            this.st_type = dataReq.st_type;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new DataReq(this, z, null) : (DataReq) invokeZ.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1330352292, "Lprotobuf/CommitPersonalMsg/DataReq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1330352292, "Lprotobuf/CommitPersonalMsg/DataReq;");
                return;
            }
        }
        DEFAULT_GROUPID = 0L;
        DEFAULT_TOUID = 0L;
        DEFAULT_MSGTYPE = 0;
        DEFAULT_DURATION = 0;
        DEFAULT_RECORDID = 0L;
        DEFAULT_TOUSERTYPE = 0;
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
            Long l2 = builder.toUid;
            if (l2 == null) {
                this.toUid = DEFAULT_TOUID;
            } else {
                this.toUid = l2;
            }
            Integer num = builder.msgType;
            if (num == null) {
                this.msgType = DEFAULT_MSGTYPE;
            } else {
                this.msgType = num;
            }
            String str = builder.content;
            if (str == null) {
                this.content = "";
            } else {
                this.content = str;
            }
            Integer num2 = builder.duration;
            if (num2 == null) {
                this.duration = DEFAULT_DURATION;
            } else {
                this.duration = num2;
            }
            Long l3 = builder.recordId;
            if (l3 == null) {
                this.recordId = DEFAULT_RECORDID;
            } else {
                this.recordId = l3;
            }
            Integer num3 = builder.toUserType;
            if (num3 == null) {
                this.toUserType = DEFAULT_TOUSERTYPE;
            } else {
                this.toUserType = num3;
            }
            String str2 = builder.st_type;
            if (str2 == null) {
                this.st_type = "";
                return;
            } else {
                this.st_type = str2;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.toUid = builder.toUid;
        this.msgType = builder.msgType;
        this.content = builder.content;
        this.duration = builder.duration;
        this.recordId = builder.recordId;
        this.toUserType = builder.toUserType;
        this.st_type = builder.st_type;
    }
}
