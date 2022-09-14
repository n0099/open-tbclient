package protobuf;

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
public final class LiveRoomInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_BTNTITLE = "";
    public static final String DEFAULT_JUMPURL = "";
    public static final Integer DEFAULT_OWNROOMCOUNT;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String btnTitle;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String jumpUrl;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer ownRoomCount;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<LiveRoomInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String btnTitle;
        public String jumpUrl;
        public Integer ownRoomCount;

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
        public Builder(LiveRoomInfo liveRoomInfo) {
            super(liveRoomInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveRoomInfo};
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
            if (liveRoomInfo == null) {
                return;
            }
            this.btnTitle = liveRoomInfo.btnTitle;
            this.ownRoomCount = liveRoomInfo.ownRoomCount;
            this.jumpUrl = liveRoomInfo.jumpUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public LiveRoomInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new LiveRoomInfo(this, z, null) : (LiveRoomInfo) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-963610290, "Lprotobuf/LiveRoomInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-963610290, "Lprotobuf/LiveRoomInfo;");
                return;
            }
        }
        DEFAULT_OWNROOMCOUNT = 0;
    }

    public /* synthetic */ LiveRoomInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveRoomInfo(Builder builder, boolean z) {
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
            String str = builder.btnTitle;
            if (str == null) {
                this.btnTitle = "";
            } else {
                this.btnTitle = str;
            }
            Integer num = builder.ownRoomCount;
            if (num == null) {
                this.ownRoomCount = DEFAULT_OWNROOMCOUNT;
            } else {
                this.ownRoomCount = num;
            }
            String str2 = builder.jumpUrl;
            if (str2 == null) {
                this.jumpUrl = "";
                return;
            } else {
                this.jumpUrl = str2;
                return;
            }
        }
        this.btnTitle = builder.btnTitle;
        this.ownRoomCount = builder.ownRoomCount;
        this.jumpUrl = builder.jumpUrl;
    }
}
