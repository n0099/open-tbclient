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
import protobuf.GroupInfo;
import protobuf.MsgInfo;
/* loaded from: classes5.dex */
public final class GroupMsg extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer DEFAULT_HASMORE;
    public static final List<MsgInfo> DEFAULT_MSGLIST;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1)
    public final GroupInfo groupInfo;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer hasMore;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<MsgInfo> msgList;

    /* loaded from: classes5.dex */
    public static final class Builder extends Message.Builder<GroupMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public GroupInfo groupInfo;
        public Integer hasMore;
        public List<MsgInfo> msgList;

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
        public Builder(GroupMsg groupMsg) {
            super(groupMsg);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupMsg};
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
            if (groupMsg == null) {
                return;
            }
            this.groupInfo = groupMsg.groupInfo;
            this.msgList = Message.copyOf(groupMsg.msgList);
            this.hasMore = groupMsg.hasMore;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GroupMsg build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new GroupMsg(this, z, null) : (GroupMsg) invokeZ.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1715151914, "Lprotobuf/GetGroupMsg/GroupMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1715151914, "Lprotobuf/GetGroupMsg/GroupMsg;");
                return;
            }
        }
        DEFAULT_MSGLIST = Collections.emptyList();
        DEFAULT_HASMORE = 0;
    }

    public /* synthetic */ GroupMsg(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupMsg(Builder builder, boolean z) {
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
            this.groupInfo = builder.groupInfo;
            List<MsgInfo> list = builder.msgList;
            if (list == null) {
                this.msgList = DEFAULT_MSGLIST;
            } else {
                this.msgList = Message.immutableCopyOf(list);
            }
            Integer num = builder.hasMore;
            if (num == null) {
                this.hasMore = DEFAULT_HASMORE;
                return;
            } else {
                this.hasMore = num;
                return;
            }
        }
        this.groupInfo = builder.groupInfo;
        this.msgList = Message.immutableCopyOf(builder.msgList);
        this.hasMore = builder.hasMore;
    }
}
