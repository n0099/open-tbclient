package protobuf.QueryHistoryMsg;

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
    public static final Integer DEFAULT_FORUMID;
    public static final Integer DEFAULT_HEIGHT;
    public static final Integer DEFAULT_ID;
    public static final Integer DEFAULT_SMALLHEIGHT;
    public static final Integer DEFAULT_SMALLWIDTH;
    public static final Long DEFAULT_USERID;
    public static final Integer DEFAULT_WIDTH;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer forumId;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer height;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer smallHeight;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer smallWidth;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long userId;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer width;

    /* loaded from: classes9.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class Builder extends Message.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer forumId;
        public Integer height;
        public Integer id;
        public Integer smallHeight;
        public Integer smallWidth;
        public Long userId;
        public Integer width;

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
            this.forumId = dataReq.forumId;
            this.userId = dataReq.userId;
            this.id = dataReq.id;
            this.width = dataReq.width;
            this.height = dataReq.height;
            this.smallWidth = dataReq.smallWidth;
            this.smallHeight = dataReq.smallHeight;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new DataReq(this, z, null);
            }
            return (DataReq) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1444055751, "Lprotobuf/QueryHistoryMsg/DataReq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1444055751, "Lprotobuf/QueryHistoryMsg/DataReq;");
                return;
            }
        }
        DEFAULT_FORUMID = 0;
        DEFAULT_USERID = 0L;
        DEFAULT_ID = 0;
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
        DEFAULT_SMALLWIDTH = 0;
        DEFAULT_SMALLHEIGHT = 0;
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
            Integer num = builder.forumId;
            if (num == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = num;
            }
            Long l = builder.userId;
            if (l == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = l;
            }
            Integer num2 = builder.id;
            if (num2 == null) {
                this.id = DEFAULT_ID;
            } else {
                this.id = num2;
            }
            Integer num3 = builder.width;
            if (num3 == null) {
                this.width = DEFAULT_WIDTH;
            } else {
                this.width = num3;
            }
            Integer num4 = builder.height;
            if (num4 == null) {
                this.height = DEFAULT_HEIGHT;
            } else {
                this.height = num4;
            }
            Integer num5 = builder.smallWidth;
            if (num5 == null) {
                this.smallWidth = DEFAULT_SMALLWIDTH;
            } else {
                this.smallWidth = num5;
            }
            Integer num6 = builder.smallHeight;
            if (num6 == null) {
                this.smallHeight = DEFAULT_SMALLHEIGHT;
                return;
            } else {
                this.smallHeight = num6;
                return;
            }
        }
        this.forumId = builder.forumId;
        this.userId = builder.userId;
        this.id = builder.id;
        this.width = builder.width;
        this.height = builder.height;
        this.smallWidth = builder.smallWidth;
        this.smallHeight = builder.smallHeight;
    }

    public /* synthetic */ DataReq(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
