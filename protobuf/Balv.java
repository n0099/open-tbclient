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
public final class Balv extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer DEFAULT_DAYSTOFREE;
    public static final Integer DEFAULT_ISBLACK;
    public static final Integer DEFAULT_ISBLOCK;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer daysTofree;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isBlack;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer isBlock;

    /* loaded from: classes9.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class Builder extends Message.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer daysTofree;
        public Integer isBlack;
        public Integer isBlock;

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
        public Builder(Balv balv) {
            super(balv);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {balv};
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
            if (balv == null) {
                return;
            }
            this.isBlack = balv.isBlack;
            this.isBlock = balv.isBlock;
            this.daysTofree = balv.daysTofree;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Balv build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new Balv(this, z, null);
            }
            return (Balv) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(299864826, "Lprotobuf/Balv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(299864826, "Lprotobuf/Balv;");
                return;
            }
        }
        DEFAULT_ISBLACK = 0;
        DEFAULT_ISBLOCK = 0;
        DEFAULT_DAYSTOFREE = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Balv(Builder builder, boolean z) {
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
            Integer num = builder.isBlack;
            if (num == null) {
                this.isBlack = DEFAULT_ISBLACK;
            } else {
                this.isBlack = num;
            }
            Integer num2 = builder.isBlock;
            if (num2 == null) {
                this.isBlock = DEFAULT_ISBLOCK;
            } else {
                this.isBlock = num2;
            }
            Integer num3 = builder.daysTofree;
            if (num3 == null) {
                this.daysTofree = DEFAULT_DAYSTOFREE;
                return;
            } else {
                this.daysTofree = num3;
                return;
            }
        }
        this.isBlack = builder.isBlack;
        this.isBlock = builder.isBlock;
        this.daysTofree = builder.daysTofree;
    }

    public /* synthetic */ Balv(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
