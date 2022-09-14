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
public final class DeletedReasonInfo extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer DEFAULT_ISBOOMGROW;
    public static final Integer DEFAULT_ISGRAYSCALEFORUM;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer isBoomgrow;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isGraysCaleForum;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<DeletedReasonInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer isBoomgrow;
        public Integer isGraysCaleForum;

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
        public Builder(DeletedReasonInfo deletedReasonInfo) {
            super(deletedReasonInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {deletedReasonInfo};
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
            if (deletedReasonInfo == null) {
                return;
            }
            this.isGraysCaleForum = deletedReasonInfo.isGraysCaleForum;
            this.isBoomgrow = deletedReasonInfo.isBoomgrow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DeletedReasonInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new DeletedReasonInfo(this, z, null) : (DeletedReasonInfo) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(332853480, "Lprotobuf/DeletedReasonInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(332853480, "Lprotobuf/DeletedReasonInfo;");
                return;
            }
        }
        DEFAULT_ISGRAYSCALEFORUM = 0;
        DEFAULT_ISBOOMGROW = 0;
    }

    public /* synthetic */ DeletedReasonInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeletedReasonInfo(Builder builder, boolean z) {
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
            Integer num = builder.isGraysCaleForum;
            if (num == null) {
                this.isGraysCaleForum = DEFAULT_ISGRAYSCALEFORUM;
            } else {
                this.isGraysCaleForum = num;
            }
            Integer num2 = builder.isBoomgrow;
            if (num2 == null) {
                this.isBoomgrow = DEFAULT_ISBOOMGROW;
                return;
            } else {
                this.isBoomgrow = num2;
                return;
            }
        }
        this.isGraysCaleForum = builder.isGraysCaleForum;
        this.isBoomgrow = builder.isBoomgrow;
    }
}
