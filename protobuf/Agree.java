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
public final class Agree extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Long DEFAULT_AGREENUM;
    public static final Integer DEFAULT_AGREETYPE;
    public static final Long DEFAULT_DIFFAGREENUM;
    public static final Long DEFAULT_DISAGREENUM;
    public static final Integer DEFAULT_HASAGREE;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long agreeNum;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer agreeType;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long diffAgreeNum;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long disagreeNum;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer hasAgree;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<Agree> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Long agreeNum;
        public Integer agreeType;
        public Long diffAgreeNum;
        public Long disagreeNum;
        public Integer hasAgree;

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
        public Builder(Agree agree) {
            super(agree);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {agree};
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
            if (agree == null) {
                return;
            }
            this.agreeNum = agree.agreeNum;
            this.hasAgree = agree.hasAgree;
            this.agreeType = agree.agreeType;
            this.disagreeNum = agree.disagreeNum;
            this.diffAgreeNum = agree.diffAgreeNum;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Agree build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new Agree(this, z, null) : (Agree) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(682950759, "Lprotobuf/Agree;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(682950759, "Lprotobuf/Agree;");
                return;
            }
        }
        DEFAULT_AGREENUM = 0L;
        DEFAULT_HASAGREE = 0;
        DEFAULT_AGREETYPE = 0;
        DEFAULT_DISAGREENUM = 0L;
        DEFAULT_DIFFAGREENUM = 0L;
    }

    public /* synthetic */ Agree(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Agree(Builder builder, boolean z) {
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
            Long l = builder.agreeNum;
            if (l == null) {
                this.agreeNum = DEFAULT_AGREENUM;
            } else {
                this.agreeNum = l;
            }
            Integer num = builder.hasAgree;
            if (num == null) {
                this.hasAgree = DEFAULT_HASAGREE;
            } else {
                this.hasAgree = num;
            }
            Integer num2 = builder.agreeType;
            if (num2 == null) {
                this.agreeType = DEFAULT_AGREETYPE;
            } else {
                this.agreeType = num2;
            }
            Long l2 = builder.disagreeNum;
            if (l2 == null) {
                this.disagreeNum = DEFAULT_DISAGREENUM;
            } else {
                this.disagreeNum = l2;
            }
            Long l3 = builder.diffAgreeNum;
            if (l3 == null) {
                this.diffAgreeNum = DEFAULT_DIFFAGREENUM;
                return;
            } else {
                this.diffAgreeNum = l3;
                return;
            }
        }
        this.agreeNum = builder.agreeNum;
        this.hasAgree = builder.hasAgree;
        this.agreeType = builder.agreeType;
        this.disagreeNum = builder.disagreeNum;
        this.diffAgreeNum = builder.diffAgreeNum;
    }
}
