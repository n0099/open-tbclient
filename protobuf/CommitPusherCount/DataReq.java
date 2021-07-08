package protobuf.CommitPusherCount;

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
public final class DataReq extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Long DEFAULT_DOWNFLOWSIZE;
    public static final Long DEFAULT_ENTERFORECOUNT;
    public static final Long DEFAULT_PUSHERCOUNT;
    public static final Long DEFAULT_UPFLOWSIZE;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long downFlowSize;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long enterForeCount;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long pusherCount;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long upFlowSize;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Long downFlowSize;
        public Long enterForeCount;
        public Long pusherCount;
        public Long upFlowSize;

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
            this.pusherCount = dataReq.pusherCount;
            this.upFlowSize = dataReq.upFlowSize;
            this.downFlowSize = dataReq.downFlowSize;
            this.enterForeCount = dataReq.enterForeCount;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new DataReq(this, z, null) : (DataReq) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(360877469, "Lprotobuf/CommitPusherCount/DataReq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(360877469, "Lprotobuf/CommitPusherCount/DataReq;");
                return;
            }
        }
        DEFAULT_PUSHERCOUNT = 0L;
        DEFAULT_UPFLOWSIZE = 0L;
        DEFAULT_DOWNFLOWSIZE = 0L;
        DEFAULT_ENTERFORECOUNT = 0L;
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
            Long l = builder.pusherCount;
            if (l == null) {
                this.pusherCount = DEFAULT_PUSHERCOUNT;
            } else {
                this.pusherCount = l;
            }
            Long l2 = builder.upFlowSize;
            if (l2 == null) {
                this.upFlowSize = DEFAULT_UPFLOWSIZE;
            } else {
                this.upFlowSize = l2;
            }
            Long l3 = builder.downFlowSize;
            if (l3 == null) {
                this.downFlowSize = DEFAULT_DOWNFLOWSIZE;
            } else {
                this.downFlowSize = l3;
            }
            Long l4 = builder.enterForeCount;
            if (l4 == null) {
                this.enterForeCount = DEFAULT_ENTERFORECOUNT;
                return;
            } else {
                this.enterForeCount = l4;
                return;
            }
        }
        this.pusherCount = builder.pusherCount;
        this.upFlowSize = builder.upFlowSize;
        this.downFlowSize = builder.downFlowSize;
        this.enterForeCount = builder.enterForeCount;
    }
}
