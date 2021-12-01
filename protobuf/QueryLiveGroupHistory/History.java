package protobuf.QueryLiveGroupHistory;

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
public final class History extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_ENDTIME;
    public static final Long DEFAULT_GROUPID;
    public static final Integer DEFAULT_LIKERS;
    public static final Integer DEFAULT_LISTENERS;
    public static final String DEFAULT_PLAYURL = "";
    public static final Integer DEFAULT_STARTTIME;
    public static final Long DEFAULT_USERID;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer endTime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer likers;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer listeners;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String playUrl;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer startTime;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long userId;

    /* loaded from: classes3.dex */
    public static final class Builder extends Message.Builder<History> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer endTime;
        public Long groupId;
        public Integer likers;
        public Integer listeners;
        public String playUrl;
        public Integer startTime;
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
        public Builder(History history) {
            super(history);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {history};
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
            if (history == null) {
                return;
            }
            this.groupId = history.groupId;
            this.startTime = history.startTime;
            this.endTime = history.endTime;
            this.userId = history.userId;
            this.listeners = history.listeners;
            this.likers = history.likers;
            this.playUrl = history.playUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public History build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new History(this, z, null) : (History) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(593316325, "Lprotobuf/QueryLiveGroupHistory/History;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(593316325, "Lprotobuf/QueryLiveGroupHistory/History;");
                return;
            }
        }
        DEFAULT_GROUPID = 0L;
        DEFAULT_STARTTIME = 0;
        DEFAULT_ENDTIME = 0;
        DEFAULT_USERID = 0L;
        DEFAULT_LISTENERS = 0;
        DEFAULT_LIKERS = 0;
    }

    public /* synthetic */ History(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public History(Builder builder, boolean z) {
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
            Integer num = builder.startTime;
            if (num == null) {
                this.startTime = DEFAULT_STARTTIME;
            } else {
                this.startTime = num;
            }
            Integer num2 = builder.endTime;
            if (num2 == null) {
                this.endTime = DEFAULT_ENDTIME;
            } else {
                this.endTime = num2;
            }
            Long l2 = builder.userId;
            if (l2 == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = l2;
            }
            Integer num3 = builder.listeners;
            if (num3 == null) {
                this.listeners = DEFAULT_LISTENERS;
            } else {
                this.listeners = num3;
            }
            Integer num4 = builder.likers;
            if (num4 == null) {
                this.likers = DEFAULT_LIKERS;
            } else {
                this.likers = num4;
            }
            String str = builder.playUrl;
            if (str == null) {
                this.playUrl = "";
                return;
            } else {
                this.playUrl = str;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.userId = builder.userId;
        this.listeners = builder.listeners;
        this.likers = builder.likers;
        this.playUrl = builder.playUrl;
    }
}
