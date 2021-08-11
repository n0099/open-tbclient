package protobuf.QueryGroupDetail;

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
import protobuf.ActivityInfo;
import protobuf.GroupInfo;
import protobuf.Photo;
import protobuf.UserInfo;
/* loaded from: classes2.dex */
public final class DataRes extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer DEFAULT_ALREADYCREATENUM;
    public static final Integer DEFAULT_CANCREATEMEMBER;
    public static final Integer DEFAULT_CANJOINGROUPNUM;
    public static final Integer DEFAULT_HIDERECOMMENDGROUP;
    public static final Integer DEFAULT_ISGROUPMANAGER;
    public static final Integer DEFAULT_ISJOIN;
    public static final Integer DEFAULT_JOINGROUPNUM;
    public static final Integer DEFAULT_LEFTCREATENUM;
    public static final List<UserInfo> DEFAULT_MEMBER;
    public static final List<Photo> DEFAULT_PHOTO;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 12)
    public final ActivityInfo activity;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer alreadyCreateNum;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer canCreateMember;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer canJoinGroupNum;
    @ProtoField(tag = 1)
    public final GroupInfo group;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer hideRecommendGroup;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer isGroupManager;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer isJoin;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer joinGroupNum;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer leftCreateNum;
    @ProtoField(label = Message.Label.REPEATED, tag = 3)
    public final List<UserInfo> member;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<Photo> photo;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ActivityInfo activity;
        public Integer alreadyCreateNum;
        public Integer canCreateMember;
        public Integer canJoinGroupNum;
        public GroupInfo group;
        public Integer hideRecommendGroup;
        public Integer isGroupManager;
        public Integer isJoin;
        public Integer joinGroupNum;
        public Integer leftCreateNum;
        public List<UserInfo> member;
        public List<Photo> photo;

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
            this.group = dataRes.group;
            this.photo = Message.copyOf(dataRes.photo);
            this.member = Message.copyOf(dataRes.member);
            this.joinGroupNum = dataRes.joinGroupNum;
            this.canJoinGroupNum = dataRes.canJoinGroupNum;
            this.isJoin = dataRes.isJoin;
            this.isGroupManager = dataRes.isGroupManager;
            this.hideRecommendGroup = dataRes.hideRecommendGroup;
            this.canCreateMember = dataRes.canCreateMember;
            this.alreadyCreateNum = dataRes.alreadyCreateNum;
            this.leftCreateNum = dataRes.leftCreateNum;
            this.activity = dataRes.activity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new DataRes(this, z, null) : (DataRes) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1391267180, "Lprotobuf/QueryGroupDetail/DataRes;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1391267180, "Lprotobuf/QueryGroupDetail/DataRes;");
                return;
            }
        }
        DEFAULT_PHOTO = Collections.emptyList();
        DEFAULT_MEMBER = Collections.emptyList();
        DEFAULT_JOINGROUPNUM = 0;
        DEFAULT_CANJOINGROUPNUM = 0;
        DEFAULT_ISJOIN = 0;
        DEFAULT_ISGROUPMANAGER = 0;
        DEFAULT_HIDERECOMMENDGROUP = 0;
        DEFAULT_CANCREATEMEMBER = 0;
        DEFAULT_ALREADYCREATENUM = 0;
        DEFAULT_LEFTCREATENUM = 0;
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
            this.group = builder.group;
            List<Photo> list = builder.photo;
            if (list == null) {
                this.photo = DEFAULT_PHOTO;
            } else {
                this.photo = Message.immutableCopyOf(list);
            }
            List<UserInfo> list2 = builder.member;
            if (list2 == null) {
                this.member = DEFAULT_MEMBER;
            } else {
                this.member = Message.immutableCopyOf(list2);
            }
            Integer num = builder.joinGroupNum;
            if (num == null) {
                this.joinGroupNum = DEFAULT_JOINGROUPNUM;
            } else {
                this.joinGroupNum = num;
            }
            Integer num2 = builder.canJoinGroupNum;
            if (num2 == null) {
                this.canJoinGroupNum = DEFAULT_CANJOINGROUPNUM;
            } else {
                this.canJoinGroupNum = num2;
            }
            Integer num3 = builder.isJoin;
            if (num3 == null) {
                this.isJoin = DEFAULT_ISJOIN;
            } else {
                this.isJoin = num3;
            }
            Integer num4 = builder.isGroupManager;
            if (num4 == null) {
                this.isGroupManager = DEFAULT_ISGROUPMANAGER;
            } else {
                this.isGroupManager = num4;
            }
            Integer num5 = builder.hideRecommendGroup;
            if (num5 == null) {
                this.hideRecommendGroup = DEFAULT_HIDERECOMMENDGROUP;
            } else {
                this.hideRecommendGroup = num5;
            }
            Integer num6 = builder.canCreateMember;
            if (num6 == null) {
                this.canCreateMember = DEFAULT_CANCREATEMEMBER;
            } else {
                this.canCreateMember = num6;
            }
            Integer num7 = builder.alreadyCreateNum;
            if (num7 == null) {
                this.alreadyCreateNum = DEFAULT_ALREADYCREATENUM;
            } else {
                this.alreadyCreateNum = num7;
            }
            Integer num8 = builder.leftCreateNum;
            if (num8 == null) {
                this.leftCreateNum = DEFAULT_LEFTCREATENUM;
            } else {
                this.leftCreateNum = num8;
            }
            this.activity = builder.activity;
            return;
        }
        this.group = builder.group;
        this.photo = Message.immutableCopyOf(builder.photo);
        this.member = Message.immutableCopyOf(builder.member);
        this.joinGroupNum = builder.joinGroupNum;
        this.canJoinGroupNum = builder.canJoinGroupNum;
        this.isJoin = builder.isJoin;
        this.isGroupManager = builder.isGroupManager;
        this.hideRecommendGroup = builder.hideRecommendGroup;
        this.canCreateMember = builder.canCreateMember;
        this.alreadyCreateNum = builder.alreadyCreateNum;
        this.leftCreateNum = builder.leftCreateNum;
        this.activity = builder.activity;
    }
}
