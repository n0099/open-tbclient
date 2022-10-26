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
public final class MyGroupInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Long DEFAULT_GROUPID;
    public static final String DEFAULT_GROUPNAME = "";
    public static final Integer DEFAULT_MAXMEMBERNUM;
    public static final Integer DEFAULT_MEMBERNUM;
    public static final String DEFAULT_PORTRAIT = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long groupId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String groupName;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer maxMemberNum;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer memberNum;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String portrait;

    /* loaded from: classes9.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class Builder extends Message.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Long groupId;
        public String groupName;
        public Integer maxMemberNum;
        public Integer memberNum;
        public String portrait;

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
        public Builder(MyGroupInfo myGroupInfo) {
            super(myGroupInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myGroupInfo};
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
            if (myGroupInfo == null) {
                return;
            }
            this.groupId = myGroupInfo.groupId;
            this.groupName = myGroupInfo.groupName;
            this.portrait = myGroupInfo.portrait;
            this.memberNum = myGroupInfo.memberNum;
            this.maxMemberNum = myGroupInfo.maxMemberNum;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public MyGroupInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new MyGroupInfo(this, z, null);
            }
            return (MyGroupInfo) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2003763250, "Lprotobuf/MyGroupInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2003763250, "Lprotobuf/MyGroupInfo;");
                return;
            }
        }
        DEFAULT_GROUPID = 0L;
        DEFAULT_MEMBERNUM = 0;
        DEFAULT_MAXMEMBERNUM = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGroupInfo(Builder builder, boolean z) {
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
            Long l = builder.groupId;
            if (l == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l;
            }
            String str = builder.groupName;
            if (str == null) {
                this.groupName = "";
            } else {
                this.groupName = str;
            }
            String str2 = builder.portrait;
            if (str2 == null) {
                this.portrait = "";
            } else {
                this.portrait = str2;
            }
            Integer num = builder.memberNum;
            if (num == null) {
                this.memberNum = DEFAULT_MEMBERNUM;
            } else {
                this.memberNum = num;
            }
            Integer num2 = builder.maxMemberNum;
            if (num2 == null) {
                this.maxMemberNum = DEFAULT_MAXMEMBERNUM;
                return;
            } else {
                this.maxMemberNum = num2;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.groupName = builder.groupName;
        this.portrait = builder.portrait;
        this.memberNum = builder.memberNum;
        this.maxMemberNum = builder.maxMemberNum;
    }

    public /* synthetic */ MyGroupInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
