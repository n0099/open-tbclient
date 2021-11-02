package protobuf.QueryGroupDetail;

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
public final class DataReq extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_BIGHEIGHT;
    public static final Integer DEFAULT_BIGWIDTH;
    public static final String DEFAULT_FROM = "";
    public static final Long DEFAULT_GROUPID;
    public static final Integer DEFAULT_SMALLHEIGHT;
    public static final Integer DEFAULT_SMALLWIDTH;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer bigHeight;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer bigWidth;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String from;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer smallHeight;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer smallWidth;

    /* loaded from: classes3.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer bigHeight;
        public Integer bigWidth;
        public String from;
        public Long groupId;
        public Integer smallHeight;
        public Integer smallWidth;

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
            this.smallHeight = dataReq.smallHeight;
            this.smallWidth = dataReq.smallWidth;
            this.bigHeight = dataReq.bigHeight;
            this.bigWidth = dataReq.bigWidth;
            this.from = dataReq.from;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new DataReq(this, z, null) : (DataReq) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1391267242, "Lprotobuf/QueryGroupDetail/DataReq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1391267242, "Lprotobuf/QueryGroupDetail/DataReq;");
                return;
            }
        }
        DEFAULT_GROUPID = 0L;
        DEFAULT_SMALLHEIGHT = 0;
        DEFAULT_SMALLWIDTH = 0;
        DEFAULT_BIGHEIGHT = 0;
        DEFAULT_BIGWIDTH = 0;
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
            Integer num = builder.smallHeight;
            if (num == null) {
                this.smallHeight = DEFAULT_SMALLHEIGHT;
            } else {
                this.smallHeight = num;
            }
            Integer num2 = builder.smallWidth;
            if (num2 == null) {
                this.smallWidth = DEFAULT_SMALLWIDTH;
            } else {
                this.smallWidth = num2;
            }
            Integer num3 = builder.bigHeight;
            if (num3 == null) {
                this.bigHeight = DEFAULT_BIGHEIGHT;
            } else {
                this.bigHeight = num3;
            }
            Integer num4 = builder.bigWidth;
            if (num4 == null) {
                this.bigWidth = DEFAULT_BIGWIDTH;
            } else {
                this.bigWidth = num4;
            }
            String str = builder.from;
            if (str == null) {
                this.from = "";
                return;
            } else {
                this.from = str;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.smallHeight = builder.smallHeight;
        this.smallWidth = builder.smallWidth;
        this.bigHeight = builder.bigHeight;
        this.bigWidth = builder.bigWidth;
        this.from = builder.from;
    }
}
