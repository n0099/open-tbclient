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
public final class GroupPermission extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_CANCREATENORMAL;
    public static final Integer DEFAULT_CANCREATENORMALNUM;
    public static final Integer DEFAULT_CANCREATEOFFICIAL;
    public static final Integer DEFAULT_CANCREATEOFFICIALNUM;
    public static final Integer DEFAULT_CANCREATEPERSONAL;
    public static final Integer DEFAULT_CANCREATEPERSONALNUM;
    public static final String DEFAULT_CREATENORMALTIP = "";
    public static final String DEFAULT_CREATEOFFICIALTIP = "";
    public static final String DEFAULT_CREATEPERSONALTIP = "";
    public static final Integer DEFAULT_ISFORUMMANAGER;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer canCreateNormal;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer canCreateNormalNum;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer canCreateOfficial;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer canCreateOfficialNum;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer canCreatePersonal;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer canCreatePersonalNum;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String createNormalTip;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String createOfficialTip;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String createPersonalTip;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isForumManager;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<GroupPermission> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer canCreateNormal;
        public Integer canCreateNormalNum;
        public Integer canCreateOfficial;
        public Integer canCreateOfficialNum;
        public Integer canCreatePersonal;
        public Integer canCreatePersonalNum;
        public String createNormalTip;
        public String createOfficialTip;
        public String createPersonalTip;
        public Integer isForumManager;

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
        public Builder(GroupPermission groupPermission) {
            super(groupPermission);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupPermission};
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
            if (groupPermission == null) {
                return;
            }
            this.isForumManager = groupPermission.isForumManager;
            this.canCreateNormal = groupPermission.canCreateNormal;
            this.canCreateOfficial = groupPermission.canCreateOfficial;
            this.canCreatePersonal = groupPermission.canCreatePersonal;
            this.createNormalTip = groupPermission.createNormalTip;
            this.createOfficialTip = groupPermission.createOfficialTip;
            this.createPersonalTip = groupPermission.createPersonalTip;
            this.canCreateNormalNum = groupPermission.canCreateNormalNum;
            this.canCreateOfficialNum = groupPermission.canCreateOfficialNum;
            this.canCreatePersonalNum = groupPermission.canCreatePersonalNum;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GroupPermission build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new GroupPermission(this, z, null) : (GroupPermission) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2049818715, "Lprotobuf/GroupPermission;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2049818715, "Lprotobuf/GroupPermission;");
                return;
            }
        }
        DEFAULT_ISFORUMMANAGER = 0;
        DEFAULT_CANCREATENORMAL = 0;
        DEFAULT_CANCREATEOFFICIAL = 0;
        DEFAULT_CANCREATEPERSONAL = 0;
        DEFAULT_CANCREATENORMALNUM = 0;
        DEFAULT_CANCREATEOFFICIALNUM = 0;
        DEFAULT_CANCREATEPERSONALNUM = 0;
    }

    public /* synthetic */ GroupPermission(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupPermission(Builder builder, boolean z) {
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
            Integer num = builder.isForumManager;
            if (num == null) {
                this.isForumManager = DEFAULT_ISFORUMMANAGER;
            } else {
                this.isForumManager = num;
            }
            Integer num2 = builder.canCreateNormal;
            if (num2 == null) {
                this.canCreateNormal = DEFAULT_CANCREATENORMAL;
            } else {
                this.canCreateNormal = num2;
            }
            Integer num3 = builder.canCreateOfficial;
            if (num3 == null) {
                this.canCreateOfficial = DEFAULT_CANCREATEOFFICIAL;
            } else {
                this.canCreateOfficial = num3;
            }
            Integer num4 = builder.canCreatePersonal;
            if (num4 == null) {
                this.canCreatePersonal = DEFAULT_CANCREATEPERSONAL;
            } else {
                this.canCreatePersonal = num4;
            }
            String str = builder.createNormalTip;
            if (str == null) {
                this.createNormalTip = "";
            } else {
                this.createNormalTip = str;
            }
            String str2 = builder.createOfficialTip;
            if (str2 == null) {
                this.createOfficialTip = "";
            } else {
                this.createOfficialTip = str2;
            }
            String str3 = builder.createPersonalTip;
            if (str3 == null) {
                this.createPersonalTip = "";
            } else {
                this.createPersonalTip = str3;
            }
            Integer num5 = builder.canCreateNormalNum;
            if (num5 == null) {
                this.canCreateNormalNum = DEFAULT_CANCREATENORMALNUM;
            } else {
                this.canCreateNormalNum = num5;
            }
            Integer num6 = builder.canCreateOfficialNum;
            if (num6 == null) {
                this.canCreateOfficialNum = DEFAULT_CANCREATEOFFICIALNUM;
            } else {
                this.canCreateOfficialNum = num6;
            }
            Integer num7 = builder.canCreatePersonalNum;
            if (num7 == null) {
                this.canCreatePersonalNum = DEFAULT_CANCREATEPERSONALNUM;
                return;
            } else {
                this.canCreatePersonalNum = num7;
                return;
            }
        }
        this.isForumManager = builder.isForumManager;
        this.canCreateNormal = builder.canCreateNormal;
        this.canCreateOfficial = builder.canCreateOfficial;
        this.canCreatePersonal = builder.canCreatePersonal;
        this.createNormalTip = builder.createNormalTip;
        this.createOfficialTip = builder.createOfficialTip;
        this.createPersonalTip = builder.createPersonalTip;
        this.canCreateNormalNum = builder.canCreateNormalNum;
        this.canCreateOfficialNum = builder.canCreateOfficialNum;
        this.canCreatePersonalNum = builder.canCreatePersonalNum;
    }
}
