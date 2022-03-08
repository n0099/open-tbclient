package protobuf.QueryGroupsByUid;

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
import protobuf.GroupPermission;
/* loaded from: classes9.dex */
public final class DataRes extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer DEFAULT_COMMONGROUPNUM;
    public static final List<GroupInfo> DEFAULT_COMMONGROUPS;
    public static final Integer DEFAULT_GROUPNUM;
    public static final List<GroupInfo> DEFAULT_GROUPS;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(label = Message.Label.REPEATED, tag = 3)
    public final List<GroupInfo> commonGroups;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer commongroupnum;
    @ProtoField(tag = 2)
    public final GroupPermission groupPerm;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer groupnum;
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<GroupInfo> groups;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<GroupInfo> commonGroups;
        public Integer commongroupnum;
        public GroupPermission groupPerm;
        public Integer groupnum;
        public List<GroupInfo> groups;

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
        public Builder(DataRes dataRes) {
            super(dataRes);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dataRes};
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
            if (dataRes == null) {
                return;
            }
            this.groups = Message.copyOf(dataRes.groups);
            this.groupPerm = dataRes.groupPerm;
            this.commonGroups = Message.copyOf(dataRes.commonGroups);
            this.groupnum = dataRes.groupnum;
            this.commongroupnum = dataRes.commongroupnum;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-185025825, "Lprotobuf/QueryGroupsByUid/DataRes;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-185025825, "Lprotobuf/QueryGroupsByUid/DataRes;");
                return;
            }
        }
        DEFAULT_GROUPS = Collections.emptyList();
        DEFAULT_COMMONGROUPS = Collections.emptyList();
        DEFAULT_GROUPNUM = 0;
        DEFAULT_COMMONGROUPNUM = 0;
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
            List<GroupInfo> list = builder.groups;
            if (list == null) {
                this.groups = DEFAULT_GROUPS;
            } else {
                this.groups = Message.immutableCopyOf(list);
            }
            this.groupPerm = builder.groupPerm;
            List<GroupInfo> list2 = builder.commonGroups;
            if (list2 == null) {
                this.commonGroups = DEFAULT_COMMONGROUPS;
            } else {
                this.commonGroups = Message.immutableCopyOf(list2);
            }
            Integer num = builder.groupnum;
            if (num == null) {
                this.groupnum = DEFAULT_GROUPNUM;
            } else {
                this.groupnum = num;
            }
            Integer num2 = builder.commongroupnum;
            if (num2 == null) {
                this.commongroupnum = DEFAULT_COMMONGROUPNUM;
                return;
            } else {
                this.commongroupnum = num2;
                return;
            }
        }
        this.groups = Message.immutableCopyOf(builder.groups);
        this.groupPerm = builder.groupPerm;
        this.commonGroups = Message.immutableCopyOf(builder.commonGroups);
        this.groupnum = builder.groupnum;
        this.commongroupnum = builder.commongroupnum;
    }
}
