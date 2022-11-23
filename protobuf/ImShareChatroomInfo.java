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
public final class ImShareChatroomInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Long DEFAULT_CHATCOUNT;
    public static final Long DEFAULT_FORUMID;
    public static final String DEFAULT_FORUMNAME = "";
    public static final String DEFAULT_ICON = "";
    public static final Long DEFAULT_ID;
    public static final String DEFAULT_NAME = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long chatCount;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long forumId;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String forumName;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String icon;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<ImShareChatroomInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Long chatCount;
        public Long forumId;
        public String forumName;
        public String icon;
        public Long id;
        public String name;

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
        public Builder(ImShareChatroomInfo imShareChatroomInfo) {
            super(imShareChatroomInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imShareChatroomInfo};
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
            if (imShareChatroomInfo == null) {
                return;
            }
            this.id = imShareChatroomInfo.id;
            this.name = imShareChatroomInfo.name;
            this.icon = imShareChatroomInfo.icon;
            this.forumId = imShareChatroomInfo.forumId;
            this.forumName = imShareChatroomInfo.forumName;
            this.chatCount = imShareChatroomInfo.chatCount;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ImShareChatroomInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new ImShareChatroomInfo(this, z, null);
            }
            return (ImShareChatroomInfo) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-293155113, "Lprotobuf/ImShareChatroomInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-293155113, "Lprotobuf/ImShareChatroomInfo;");
                return;
            }
        }
        DEFAULT_ID = 0L;
        DEFAULT_FORUMID = 0L;
        DEFAULT_CHATCOUNT = 0L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImShareChatroomInfo(Builder builder, boolean z) {
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
            Long l = builder.id;
            if (l == null) {
                this.id = DEFAULT_ID;
            } else {
                this.id = l;
            }
            String str = builder.name;
            if (str == null) {
                this.name = "";
            } else {
                this.name = str;
            }
            String str2 = builder.icon;
            if (str2 == null) {
                this.icon = "";
            } else {
                this.icon = str2;
            }
            Long l2 = builder.forumId;
            if (l2 == null) {
                this.forumId = DEFAULT_FORUMID;
            } else {
                this.forumId = l2;
            }
            String str3 = builder.forumName;
            if (str3 == null) {
                this.forumName = "";
            } else {
                this.forumName = str3;
            }
            Long l3 = builder.chatCount;
            if (l3 == null) {
                this.chatCount = DEFAULT_CHATCOUNT;
                return;
            } else {
                this.chatCount = l3;
                return;
            }
        }
        this.id = builder.id;
        this.name = builder.name;
        this.icon = builder.icon;
        this.forumId = builder.forumId;
        this.forumName = builder.forumName;
        this.chatCount = builder.chatCount;
    }

    public /* synthetic */ ImShareChatroomInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
