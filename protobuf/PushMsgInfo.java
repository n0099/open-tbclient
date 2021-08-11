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
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class PushMsgInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_ET = "";
    public static final Long DEFAULT_GROUPID;
    public static final Integer DEFAULT_GROUPTYPE;
    public static final List<MsgInfo> DEFAULT_MSGINFO;
    public static final Long DEFAULT_PUSHTIME;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String et;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer groupType;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<MsgInfo> msgInfo;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long pushTime;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<PushMsgInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String et;
        public Long groupId;
        public Integer groupType;
        public List<MsgInfo> msgInfo;
        public Long pushTime;

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
        public Builder(PushMsgInfo pushMsgInfo) {
            super(pushMsgInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushMsgInfo};
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
            if (pushMsgInfo == null) {
                return;
            }
            this.groupId = pushMsgInfo.groupId;
            this.msgInfo = Message.copyOf(pushMsgInfo.msgInfo);
            this.groupType = pushMsgInfo.groupType;
            this.et = pushMsgInfo.et;
            this.pushTime = pushMsgInfo.pushTime;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PushMsgInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new PushMsgInfo(this, z, null) : (PushMsgInfo) invokeZ.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(668219102, "Lprotobuf/PushMsgInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(668219102, "Lprotobuf/PushMsgInfo;");
                return;
            }
        }
        DEFAULT_GROUPID = 0L;
        DEFAULT_MSGINFO = Collections.emptyList();
        DEFAULT_GROUPTYPE = 0;
        DEFAULT_PUSHTIME = 0L;
    }

    public /* synthetic */ PushMsgInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushMsgInfo(Builder builder, boolean z) {
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
            List<MsgInfo> list = builder.msgInfo;
            if (list == null) {
                this.msgInfo = DEFAULT_MSGINFO;
            } else {
                this.msgInfo = Message.immutableCopyOf(list);
            }
            Integer num = builder.groupType;
            if (num == null) {
                this.groupType = DEFAULT_GROUPTYPE;
            } else {
                this.groupType = num;
            }
            String str = builder.et;
            if (str == null) {
                this.et = "";
            } else {
                this.et = str;
            }
            Long l2 = builder.pushTime;
            if (l2 == null) {
                this.pushTime = DEFAULT_PUSHTIME;
                return;
            } else {
                this.pushTime = l2;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.msgInfo = Message.immutableCopyOf(builder.msgInfo);
        this.groupType = builder.groupType;
        this.et = builder.et;
        this.pushTime = builder.pushTime;
    }
}
