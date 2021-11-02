package protobuf.CommitReceivedPmsg;

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
/* loaded from: classes3.dex */
public final class DataRes extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Long DEFAULT_GROUPID;
    public static final Long DEFAULT_READMSGID;
    public static final Long DEFAULT_TOUID;
    public static final Integer DEFAULT_TOUSERTYPE;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long readMsgId;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long toUid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer toUserType;

    /* loaded from: classes3.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Long groupId;
        public Long readMsgId;
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
        public Builder(DataRes dataRes) {
            super(dataRes);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dataRes};
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
            if (dataRes == null) {
                return;
            }
            this.readMsgId = dataRes.readMsgId;
            this.groupId = dataRes.groupId;
            this.toUid = dataRes.toUid;
            this.toUserType = dataRes.toUserType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new DataRes(this, z, null) : (DataRes) invokeZ.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1247881709, "Lprotobuf/CommitReceivedPmsg/DataRes;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1247881709, "Lprotobuf/CommitReceivedPmsg/DataRes;");
                return;
            }
        }
        DEFAULT_READMSGID = 0L;
        DEFAULT_GROUPID = 0L;
        DEFAULT_TOUID = 0L;
        DEFAULT_TOUSERTYPE = 0;
    }

    public /* synthetic */ DataRes(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataRes(Builder builder, boolean z) {
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
            Long l = builder.readMsgId;
            if (l == null) {
                this.readMsgId = DEFAULT_READMSGID;
            } else {
                this.readMsgId = l;
            }
            Long l2 = builder.groupId;
            if (l2 == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l2;
            }
            Long l3 = builder.toUid;
            if (l3 == null) {
                this.toUid = DEFAULT_TOUID;
            } else {
                this.toUid = l3;
            }
            Integer num = builder.toUserType;
            if (num == null) {
                this.toUserType = DEFAULT_TOUSERTYPE;
                return;
            } else {
                this.toUserType = num;
                return;
            }
        }
        this.readMsgId = builder.readMsgId;
        this.groupId = builder.groupId;
        this.toUid = builder.toUid;
        this.toUserType = builder.toUserType;
    }
}
