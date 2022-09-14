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
public final class AlaShareInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CONTENT = "";
    public static final Long DEFAULT_RECORDTID;
    public static final Integer DEFAULT_SHARECOUNT;
    public static final Integer DEFAULT_SHAREUSERCOUNT;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long recordTid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shareCount;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shareUserCount;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<AlaShareInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public Long recordTid;
        public Integer shareCount;
        public Integer shareUserCount;

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
        public Builder(AlaShareInfo alaShareInfo) {
            super(alaShareInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaShareInfo};
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
            if (alaShareInfo == null) {
                return;
            }
            this.content = alaShareInfo.content;
            this.shareUserCount = alaShareInfo.shareUserCount;
            this.shareCount = alaShareInfo.shareCount;
            this.recordTid = alaShareInfo.recordTid;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AlaShareInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new AlaShareInfo(this, z, null) : (AlaShareInfo) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-625703284, "Lprotobuf/AlaShareInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-625703284, "Lprotobuf/AlaShareInfo;");
                return;
            }
        }
        DEFAULT_SHAREUSERCOUNT = 0;
        DEFAULT_SHARECOUNT = 0;
        DEFAULT_RECORDTID = 0L;
    }

    public /* synthetic */ AlaShareInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaShareInfo(Builder builder, boolean z) {
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
            String str = builder.content;
            if (str == null) {
                this.content = "";
            } else {
                this.content = str;
            }
            Integer num = builder.shareUserCount;
            if (num == null) {
                this.shareUserCount = DEFAULT_SHAREUSERCOUNT;
            } else {
                this.shareUserCount = num;
            }
            Integer num2 = builder.shareCount;
            if (num2 == null) {
                this.shareCount = DEFAULT_SHARECOUNT;
            } else {
                this.shareCount = num2;
            }
            Long l = builder.recordTid;
            if (l == null) {
                this.recordTid = DEFAULT_RECORDTID;
                return;
            } else {
                this.recordTid = l;
                return;
            }
        }
        this.content = builder.content;
        this.shareUserCount = builder.shareUserCount;
        this.shareCount = builder.shareCount;
        this.recordTid = builder.recordTid;
    }
}
