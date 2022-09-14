package protobuf.UpdateClientInfo;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.ByteString;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class DataReq extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_BDUSS = "";
    public static final String DEFAULT_DEVICE = "";
    public static final Long DEFAULT_GROUPID;
    public static final Integer DEFAULT_HEIGHT;
    public static final Double DEFAULT_LAT;
    public static final Double DEFAULT_LNG;
    public static final String DEFAULT_PROJECT = "";
    public static final Integer DEFAULT_PUB_ENV;
    public static final ByteString DEFAULT_SECRETKEY;
    public static final String DEFAULT_STOKEN = "";
    public static final Integer DEFAULT_UNREAD_MSG;
    public static final Integer DEFAULT_WIDTH;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String bduss;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String device;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer height;
    @ProtoField(tag = 4, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(tag = 5, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String project;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer pub_env;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final ByteString secretKey;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String stoken;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer unread_msg;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer width;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String bduss;
        public String device;
        public Long groupId;
        public Integer height;
        public Double lat;
        public Double lng;
        public String project;
        public Integer pub_env;
        public ByteString secretKey;
        public String stoken;
        public Integer unread_msg;
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
            this.bduss = dataReq.bduss;
            this.device = dataReq.device;
            this.secretKey = dataReq.secretKey;
            this.lat = dataReq.lat;
            this.lng = dataReq.lng;
            this.width = dataReq.width;
            this.height = dataReq.height;
            this.unread_msg = dataReq.unread_msg;
            this.pub_env = dataReq.pub_env;
            this.project = dataReq.project;
            this.groupId = dataReq.groupId;
            this.stoken = dataReq.stoken;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1638592668, "Lprotobuf/UpdateClientInfo/DataReq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1638592668, "Lprotobuf/UpdateClientInfo/DataReq;");
                return;
            }
        }
        DEFAULT_SECRETKEY = ByteString.EMPTY;
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LAT = valueOf;
        DEFAULT_LNG = valueOf;
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
        DEFAULT_UNREAD_MSG = 0;
        DEFAULT_PUB_ENV = 0;
        DEFAULT_GROUPID = 0L;
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
            String str = builder.bduss;
            if (str == null) {
                this.bduss = "";
            } else {
                this.bduss = str;
            }
            String str2 = builder.device;
            if (str2 == null) {
                this.device = "";
            } else {
                this.device = str2;
            }
            ByteString byteString = builder.secretKey;
            if (byteString == null) {
                this.secretKey = DEFAULT_SECRETKEY;
            } else {
                this.secretKey = byteString;
            }
            Double d = builder.lat;
            if (d == null) {
                this.lat = DEFAULT_LAT;
            } else {
                this.lat = d;
            }
            Double d2 = builder.lng;
            if (d2 == null) {
                this.lng = DEFAULT_LNG;
            } else {
                this.lng = d2;
            }
            Integer num = builder.width;
            if (num == null) {
                this.width = DEFAULT_WIDTH;
            } else {
                this.width = num;
            }
            Integer num2 = builder.height;
            if (num2 == null) {
                this.height = DEFAULT_HEIGHT;
            } else {
                this.height = num2;
            }
            Integer num3 = builder.unread_msg;
            if (num3 == null) {
                this.unread_msg = DEFAULT_UNREAD_MSG;
            } else {
                this.unread_msg = num3;
            }
            Integer num4 = builder.pub_env;
            if (num4 == null) {
                this.pub_env = DEFAULT_PUB_ENV;
            } else {
                this.pub_env = num4;
            }
            String str3 = builder.project;
            if (str3 == null) {
                this.project = "";
            } else {
                this.project = str3;
            }
            Long l = builder.groupId;
            if (l == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l;
            }
            String str4 = builder.stoken;
            if (str4 == null) {
                this.stoken = "";
                return;
            } else {
                this.stoken = str4;
                return;
            }
        }
        this.bduss = builder.bduss;
        this.device = builder.device;
        this.secretKey = builder.secretKey;
        this.lat = builder.lat;
        this.lng = builder.lng;
        this.width = builder.width;
        this.height = builder.height;
        this.unread_msg = builder.unread_msg;
        this.pub_env = builder.pub_env;
        this.project = builder.project;
        this.groupId = builder.groupId;
        this.stoken = builder.stoken;
    }
}
