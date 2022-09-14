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
public final class NewGodInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_FIELDID;
    public static final String DEFAULT_FIELDNAME = "";
    public static final Integer DEFAULT_STATUS;
    public static final Integer DEFAULT_TYPE;
    public static final String DEFAULT_TYPENAME = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer fieldId;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String fieldName;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer type;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String typeName;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<NewGodInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer fieldId;
        public String fieldName;
        public Integer status;
        public Integer type;
        public String typeName;

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
        public Builder(NewGodInfo newGodInfo) {
            super(newGodInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGodInfo};
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
            if (newGodInfo == null) {
                return;
            }
            this.status = newGodInfo.status;
            this.fieldId = newGodInfo.fieldId;
            this.fieldName = newGodInfo.fieldName;
            this.type = newGodInfo.type;
            this.typeName = newGodInfo.typeName;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public NewGodInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new NewGodInfo(this, z, null) : (NewGodInfo) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1800963481, "Lprotobuf/NewGodInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1800963481, "Lprotobuf/NewGodInfo;");
                return;
            }
        }
        DEFAULT_STATUS = 0;
        DEFAULT_FIELDID = 0;
        DEFAULT_TYPE = 0;
    }

    public /* synthetic */ NewGodInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewGodInfo(Builder builder, boolean z) {
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
            Integer num = builder.status;
            if (num == null) {
                this.status = DEFAULT_STATUS;
            } else {
                this.status = num;
            }
            Integer num2 = builder.fieldId;
            if (num2 == null) {
                this.fieldId = DEFAULT_FIELDID;
            } else {
                this.fieldId = num2;
            }
            String str = builder.fieldName;
            if (str == null) {
                this.fieldName = "";
            } else {
                this.fieldName = str;
            }
            Integer num3 = builder.type;
            if (num3 == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = num3;
            }
            String str2 = builder.typeName;
            if (str2 == null) {
                this.typeName = "";
                return;
            } else {
                this.typeName = str2;
                return;
            }
        }
        this.status = builder.status;
        this.fieldId = builder.fieldId;
        this.fieldName = builder.fieldName;
        this.type = builder.type;
        this.typeName = builder.typeName;
    }
}
