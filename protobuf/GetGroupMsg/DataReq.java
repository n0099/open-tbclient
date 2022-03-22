package protobuf.GetGroupMsg;

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
import java.util.Collections;
import java.util.List;
import protobuf.GroupLastId;
import protobuf.NewpushRepair;
/* loaded from: classes8.dex */
public final class DataReq extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_GETTYPE = "";
    public static final List<GroupLastId> DEFAULT_GROUPMIDS;
    public static final Integer DEFAULT_HEIGHT;
    public static final String DEFAULT_MAX_TIME = "";
    public static final String DEFAULT_MIN_TIME = "";
    public static final String DEFAULT_PROCESS_TYPE = "";
    public static final String DEFAULT_PUSHTIMES = "";
    public static final Integer DEFAULT_SMALLHEIGHT;
    public static final Integer DEFAULT_SMALLWIDTH;
    public static final Integer DEFAULT_WIDTH;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String gettype;
    @ProtoField(label = Message.Label.REPEATED, tag = 6)
    public final List<GroupLastId> groupMids;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer height;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String max_time;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String min_time;
    @ProtoField(tag = 11)
    public final NewpushRepair newpushRepire;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String process_type;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String pushTimes;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer smallHeight;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer smallWidth;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer width;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String gettype;
        public List<GroupLastId> groupMids;
        public Integer height;
        public String max_time;
        public String min_time;
        public NewpushRepair newpushRepire;
        public String process_type;
        public String pushTimes;
        public Integer smallHeight;
        public Integer smallWidth;
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
            this.width = dataReq.width;
            this.height = dataReq.height;
            this.smallWidth = dataReq.smallWidth;
            this.smallHeight = dataReq.smallHeight;
            this.pushTimes = dataReq.pushTimes;
            this.groupMids = Message.copyOf(dataReq.groupMids);
            this.gettype = dataReq.gettype;
            this.min_time = dataReq.min_time;
            this.max_time = dataReq.max_time;
            this.process_type = dataReq.process_type;
            this.newpushRepire = dataReq.newpushRepire;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1017329706, "Lprotobuf/GetGroupMsg/DataReq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1017329706, "Lprotobuf/GetGroupMsg/DataReq;");
                return;
            }
        }
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
        DEFAULT_SMALLWIDTH = 0;
        DEFAULT_SMALLHEIGHT = 0;
        DEFAULT_GROUPMIDS = Collections.emptyList();
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
            Integer num3 = builder.smallWidth;
            if (num3 == null) {
                this.smallWidth = DEFAULT_SMALLWIDTH;
            } else {
                this.smallWidth = num3;
            }
            Integer num4 = builder.smallHeight;
            if (num4 == null) {
                this.smallHeight = DEFAULT_SMALLHEIGHT;
            } else {
                this.smallHeight = num4;
            }
            String str = builder.pushTimes;
            if (str == null) {
                this.pushTimes = "";
            } else {
                this.pushTimes = str;
            }
            List<GroupLastId> list = builder.groupMids;
            if (list == null) {
                this.groupMids = DEFAULT_GROUPMIDS;
            } else {
                this.groupMids = Message.immutableCopyOf(list);
            }
            String str2 = builder.gettype;
            if (str2 == null) {
                this.gettype = "";
            } else {
                this.gettype = str2;
            }
            String str3 = builder.min_time;
            if (str3 == null) {
                this.min_time = "";
            } else {
                this.min_time = str3;
            }
            String str4 = builder.max_time;
            if (str4 == null) {
                this.max_time = "";
            } else {
                this.max_time = str4;
            }
            String str5 = builder.process_type;
            if (str5 == null) {
                this.process_type = "";
            } else {
                this.process_type = str5;
            }
            this.newpushRepire = builder.newpushRepire;
            return;
        }
        this.width = builder.width;
        this.height = builder.height;
        this.smallWidth = builder.smallWidth;
        this.smallHeight = builder.smallHeight;
        this.pushTimes = builder.pushTimes;
        this.groupMids = Message.immutableCopyOf(builder.groupMids);
        this.gettype = builder.gettype;
        this.min_time = builder.min_time;
        this.max_time = builder.max_time;
        this.process_type = builder.process_type;
        this.newpushRepire = builder.newpushRepire;
    }
}
