package protobuf.GetLivableForumList;

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
    public static final Integer DEFAULT_FILTERFLAG;
    public static final Integer DEFAULT_LIKEFORUMFLAG;
    public static final Integer DEFAULT_MINLEVEL;
    public static final Integer DEFAULT_PAGENO;
    public static final Integer DEFAULT_PAGESIZE;
    public static final Long DEFAULT_USERID;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer filterFlag;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer likeForumFlag;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer minLevel;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer pageNo;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer pageSize;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long userId;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer filterFlag;
        public Integer likeForumFlag;
        public Integer minLevel;
        public Integer pageNo;
        public Integer pageSize;
        public Long userId;

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
            this.userId = dataReq.userId;
            this.filterFlag = dataReq.filterFlag;
            this.minLevel = dataReq.minLevel;
            this.likeForumFlag = dataReq.likeForumFlag;
            this.pageSize = dataReq.pageSize;
            this.pageNo = dataReq.pageNo;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-161525140, "Lprotobuf/GetLivableForumList/DataReq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-161525140, "Lprotobuf/GetLivableForumList/DataReq;");
                return;
            }
        }
        DEFAULT_USERID = 0L;
        DEFAULT_FILTERFLAG = 0;
        DEFAULT_MINLEVEL = 0;
        DEFAULT_LIKEFORUMFLAG = 0;
        DEFAULT_PAGESIZE = 0;
        DEFAULT_PAGENO = 0;
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
            Long l = builder.userId;
            if (l == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = l;
            }
            Integer num = builder.filterFlag;
            if (num == null) {
                this.filterFlag = DEFAULT_FILTERFLAG;
            } else {
                this.filterFlag = num;
            }
            Integer num2 = builder.minLevel;
            if (num2 == null) {
                this.minLevel = DEFAULT_MINLEVEL;
            } else {
                this.minLevel = num2;
            }
            Integer num3 = builder.likeForumFlag;
            if (num3 == null) {
                this.likeForumFlag = DEFAULT_LIKEFORUMFLAG;
            } else {
                this.likeForumFlag = num3;
            }
            Integer num4 = builder.pageSize;
            if (num4 == null) {
                this.pageSize = DEFAULT_PAGESIZE;
            } else {
                this.pageSize = num4;
            }
            Integer num5 = builder.pageNo;
            if (num5 == null) {
                this.pageNo = DEFAULT_PAGENO;
                return;
            } else {
                this.pageNo = num5;
                return;
            }
        }
        this.userId = builder.userId;
        this.filterFlag = builder.filterFlag;
        this.minLevel = builder.minLevel;
        this.likeForumFlag = builder.likeForumFlag;
        this.pageSize = builder.pageSize;
        this.pageNo = builder.pageNo;
    }
}
