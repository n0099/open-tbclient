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
/* loaded from: classes4.dex */
public final class ForumRalatedInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_AVATAR = "";
    public static final Integer DEFAULT_CURSCORE;
    public static final Integer DEFAULT_FORUMID;
    public static final Integer DEFAULT_LEFTSCORE;
    public static final Integer DEFAULT_LEVEL;
    public static final String DEFAULT_NAME = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String avatar;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer curScore;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer forumId;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer leftScore;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer level;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;

    /* loaded from: classes4.dex */
    public static final class Builder extends Message.Builder<ForumRalatedInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String avatar;
        public Integer curScore;
        public Integer forumId;
        public Integer leftScore;
        public Integer level;
        public String name;

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
        public Builder(ForumRalatedInfo forumRalatedInfo) {
            super(forumRalatedInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRalatedInfo};
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
            if (forumRalatedInfo == null) {
                return;
            }
            this.forumId = forumRalatedInfo.forumId;
            this.name = forumRalatedInfo.name;
            this.avatar = forumRalatedInfo.avatar;
            this.level = forumRalatedInfo.level;
            this.curScore = forumRalatedInfo.curScore;
            this.leftScore = forumRalatedInfo.leftScore;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ForumRalatedInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new ForumRalatedInfo(this, z, null) : (ForumRalatedInfo) invokeZ.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(112955463, "Lprotobuf/ForumRalatedInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(112955463, "Lprotobuf/ForumRalatedInfo;");
                return;
            }
        }
        DEFAULT_FORUMID = 0;
        DEFAULT_LEVEL = 0;
        DEFAULT_CURSCORE = 0;
        DEFAULT_LEFTSCORE = 0;
    }

    public /* synthetic */ ForumRalatedInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRalatedInfo(Builder builder, boolean z) {
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
            Integer num = builder.forumId;
            if (num == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = num;
            }
            String str = builder.name;
            if (str == null) {
                this.name = "";
            } else {
                this.name = str;
            }
            String str2 = builder.avatar;
            if (str2 == null) {
                this.avatar = "";
            } else {
                this.avatar = str2;
            }
            Integer num2 = builder.level;
            if (num2 == null) {
                this.level = DEFAULT_LEVEL;
            } else {
                this.level = num2;
            }
            Integer num3 = builder.curScore;
            if (num3 == null) {
                this.curScore = DEFAULT_CURSCORE;
            } else {
                this.curScore = num3;
            }
            Integer num4 = builder.leftScore;
            if (num4 == null) {
                this.leftScore = DEFAULT_LEFTSCORE;
                return;
            } else {
                this.leftScore = num4;
                return;
            }
        }
        this.forumId = builder.forumId;
        this.name = builder.name;
        this.avatar = builder.avatar;
        this.level = builder.level;
        this.curScore = builder.curScore;
        this.leftScore = builder.leftScore;
    }
}
