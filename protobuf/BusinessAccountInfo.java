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
/* loaded from: classes8.dex */
public final class BusinessAccountInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_BUSINESSNAME = "";
    public static final String DEFAULT_IDENTIFIEXPLAIN = "";
    public static final Integer DEFAULT_ISBUSINESSACCOUNT;
    public static final Integer DEFAULT_ISFORUMBUSINESSACCOUNT;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String businessName;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String identifiExplain;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isBusinessAccount;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer isForumBusinessAccount;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<BusinessAccountInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String businessName;
        public String identifiExplain;
        public Integer isBusinessAccount;
        public Integer isForumBusinessAccount;

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
        public Builder(BusinessAccountInfo businessAccountInfo) {
            super(businessAccountInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {businessAccountInfo};
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
            if (businessAccountInfo == null) {
                return;
            }
            this.isBusinessAccount = businessAccountInfo.isBusinessAccount;
            this.isForumBusinessAccount = businessAccountInfo.isForumBusinessAccount;
            this.businessName = businessAccountInfo.businessName;
            this.identifiExplain = businessAccountInfo.identifiExplain;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public BusinessAccountInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new BusinessAccountInfo(this, z, null) : (BusinessAccountInfo) invokeZ.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(782721624, "Lprotobuf/BusinessAccountInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(782721624, "Lprotobuf/BusinessAccountInfo;");
                return;
            }
        }
        DEFAULT_ISBUSINESSACCOUNT = 0;
        DEFAULT_ISFORUMBUSINESSACCOUNT = 0;
    }

    public /* synthetic */ BusinessAccountInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BusinessAccountInfo(Builder builder, boolean z) {
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
            Integer num = builder.isBusinessAccount;
            if (num == null) {
                this.isBusinessAccount = DEFAULT_ISBUSINESSACCOUNT;
            } else {
                this.isBusinessAccount = num;
            }
            Integer num2 = builder.isForumBusinessAccount;
            if (num2 == null) {
                this.isForumBusinessAccount = DEFAULT_ISFORUMBUSINESSACCOUNT;
            } else {
                this.isForumBusinessAccount = num2;
            }
            String str = builder.businessName;
            if (str == null) {
                this.businessName = "";
            } else {
                this.businessName = str;
            }
            String str2 = builder.identifiExplain;
            if (str2 == null) {
                this.identifiExplain = "";
                return;
            } else {
                this.identifiExplain = str2;
                return;
            }
        }
        this.isBusinessAccount = builder.isBusinessAccount;
        this.isForumBusinessAccount = builder.isForumBusinessAccount;
        this.businessName = builder.businessName;
        this.identifiExplain = builder.identifiExplain;
    }
}
