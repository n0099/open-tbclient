package protobuf.UpdateClientInfo;

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
import protobuf.ConfigVersion;
import protobuf.GroupInfo;
import protobuf.MaskInfo;
import protobuf.UserInfo;
/* loaded from: classes9.dex */
public final class DataRes extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final List<GroupInfo> DEFAULT_GROUPINFO;
    public static final List<Integer> DEFAULT_HEARTBEATINTERVAL;
    public static final Long DEFAULT_ISUSERAVAILABLE;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 5)
    public final ConfigVersion configVersion;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<GroupInfo> groupInfo;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> heartbeatInterval;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long isUserAvailable;
    @ProtoField(tag = 3)
    public final MaskInfo maskInfo;
    @ProtoField(tag = 2)
    public final UserInfo userInfo;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ConfigVersion configVersion;
        public List<GroupInfo> groupInfo;
        public List<Integer> heartbeatInterval;
        public Long isUserAvailable;
        public MaskInfo maskInfo;
        public UserInfo userInfo;

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
        public Builder(DataRes dataRes) {
            super(dataRes);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dataRes};
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
            if (dataRes == null) {
                return;
            }
            this.groupInfo = Message.copyOf(dataRes.groupInfo);
            this.userInfo = dataRes.userInfo;
            this.maskInfo = dataRes.maskInfo;
            this.heartbeatInterval = Message.copyOf(dataRes.heartbeatInterval);
            this.configVersion = dataRes.configVersion;
            this.isUserAvailable = dataRes.isUserAvailable;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new DataRes(this, z, null) : (DataRes) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1638592730, "Lprotobuf/UpdateClientInfo/DataRes;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1638592730, "Lprotobuf/UpdateClientInfo/DataRes;");
                return;
            }
        }
        DEFAULT_GROUPINFO = Collections.emptyList();
        DEFAULT_HEARTBEATINTERVAL = Collections.emptyList();
        DEFAULT_ISUSERAVAILABLE = 0L;
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
            List<GroupInfo> list = builder.groupInfo;
            if (list == null) {
                this.groupInfo = DEFAULT_GROUPINFO;
            } else {
                this.groupInfo = Message.immutableCopyOf(list);
            }
            this.userInfo = builder.userInfo;
            this.maskInfo = builder.maskInfo;
            List<Integer> list2 = builder.heartbeatInterval;
            if (list2 == null) {
                this.heartbeatInterval = DEFAULT_HEARTBEATINTERVAL;
            } else {
                this.heartbeatInterval = Message.immutableCopyOf(list2);
            }
            this.configVersion = builder.configVersion;
            Long l = builder.isUserAvailable;
            if (l == null) {
                this.isUserAvailable = DEFAULT_ISUSERAVAILABLE;
                return;
            } else {
                this.isUserAvailable = l;
                return;
            }
        }
        this.groupInfo = Message.immutableCopyOf(builder.groupInfo);
        this.userInfo = builder.userInfo;
        this.maskInfo = builder.maskInfo;
        this.heartbeatInterval = Message.immutableCopyOf(builder.heartbeatInterval);
        this.configVersion = builder.configVersion;
        this.isUserAvailable = builder.isUserAvailable;
    }
}
