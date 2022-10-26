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
public final class MultiForumPerm extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_BAWUTYPE = "";
    public static final Integer DEFAULT_ISBAWU;
    public static final Integer DEFAULT_ISBLOCKBAWUDELETE;
    public static final Integer DEFAULT_ISDELETED;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String bawuType;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isBawu;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer isBlockBawuDelete;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer isDeleted;

    /* loaded from: classes9.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class Builder extends Message.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String bawuType;
        public Integer isBawu;
        public Integer isBlockBawuDelete;
        public Integer isDeleted;

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
        public Builder(MultiForumPerm multiForumPerm) {
            super(multiForumPerm);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiForumPerm};
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
            if (multiForumPerm == null) {
                return;
            }
            this.isBawu = multiForumPerm.isBawu;
            this.bawuType = multiForumPerm.bawuType;
            this.isDeleted = multiForumPerm.isDeleted;
            this.isBlockBawuDelete = multiForumPerm.isBlockBawuDelete;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public MultiForumPerm build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new MultiForumPerm(this, z, null);
            }
            return (MultiForumPerm) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-743104917, "Lprotobuf/MultiForumPerm;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-743104917, "Lprotobuf/MultiForumPerm;");
                return;
            }
        }
        DEFAULT_ISBAWU = 0;
        DEFAULT_ISDELETED = 0;
        DEFAULT_ISBLOCKBAWUDELETE = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiForumPerm(Builder builder, boolean z) {
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
            Integer num = builder.isBawu;
            if (num == null) {
                this.isBawu = DEFAULT_ISBAWU;
            } else {
                this.isBawu = num;
            }
            String str = builder.bawuType;
            if (str == null) {
                this.bawuType = "";
            } else {
                this.bawuType = str;
            }
            Integer num2 = builder.isDeleted;
            if (num2 == null) {
                this.isDeleted = DEFAULT_ISDELETED;
            } else {
                this.isDeleted = num2;
            }
            Integer num3 = builder.isBlockBawuDelete;
            if (num3 == null) {
                this.isBlockBawuDelete = DEFAULT_ISBLOCKBAWUDELETE;
                return;
            } else {
                this.isBlockBawuDelete = num3;
                return;
            }
        }
        this.isBawu = builder.isBawu;
        this.bawuType = builder.bawuType;
        this.isDeleted = builder.isDeleted;
        this.isBlockBawuDelete = builder.isBlockBawuDelete;
    }

    public /* synthetic */ MultiForumPerm(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
