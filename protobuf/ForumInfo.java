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
public final class ForumInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_AVATAR = "";
    public static final Long DEFAULT_FORUMID;
    public static final String DEFAULT_FORUMNAME = "";
    public static final Integer DEFAULT_MEMBERCOUNT;
    public static final String DEFAULT_SLOGAN = "";
    public static final String DEFAULT_THREADNUM = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String avatar;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long forumId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String forumName;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer memberCount;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String slogan;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String threadNum;

    /* loaded from: classes9.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class Builder extends Message.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String avatar;
        public Long forumId;
        public String forumName;
        public Integer memberCount;
        public String slogan;
        public String threadNum;

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
        public Builder(ForumInfo forumInfo) {
            super(forumInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumInfo};
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
            if (forumInfo == null) {
                return;
            }
            this.forumId = forumInfo.forumId;
            this.forumName = forumInfo.forumName;
            this.avatar = forumInfo.avatar;
            this.memberCount = forumInfo.memberCount;
            this.slogan = forumInfo.slogan;
            this.threadNum = forumInfo.threadNum;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ForumInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new ForumInfo(this, z, null);
            }
            return (ForumInfo) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1871285756, "Lprotobuf/ForumInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1871285756, "Lprotobuf/ForumInfo;");
                return;
            }
        }
        DEFAULT_FORUMID = 0L;
        DEFAULT_MEMBERCOUNT = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumInfo(Builder builder, boolean z) {
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
            Long l = builder.forumId;
            if (l == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = l;
            }
            String str = builder.forumName;
            if (str == null) {
                this.forumName = "";
            } else {
                this.forumName = str;
            }
            String str2 = builder.avatar;
            if (str2 == null) {
                this.avatar = "";
            } else {
                this.avatar = str2;
            }
            Integer num = builder.memberCount;
            if (num == null) {
                this.memberCount = DEFAULT_MEMBERCOUNT;
            } else {
                this.memberCount = num;
            }
            String str3 = builder.slogan;
            if (str3 == null) {
                this.slogan = "";
            } else {
                this.slogan = str3;
            }
            String str4 = builder.threadNum;
            if (str4 == null) {
                this.threadNum = "";
                return;
            } else {
                this.threadNum = str4;
                return;
            }
        }
        this.forumId = builder.forumId;
        this.forumName = builder.forumName;
        this.avatar = builder.avatar;
        this.memberCount = builder.memberCount;
        this.slogan = builder.slogan;
        this.threadNum = builder.threadNum;
    }

    public /* synthetic */ ForumInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
