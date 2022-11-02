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
public final class TwZhiBoUser extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_ANCHORLEVEL;
    public static final String DEFAULT_FIELDEX = "";
    public static final Integer DEFAULT_INBLACKLIST;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer anchorLevel;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String fieldEx;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer inBlackList;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<TwZhiBoUser> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer anchorLevel;
        public String fieldEx;
        public Integer inBlackList;

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
        public Builder(TwZhiBoUser twZhiBoUser) {
            super(twZhiBoUser);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {twZhiBoUser};
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
            if (twZhiBoUser == null) {
                return;
            }
            this.anchorLevel = twZhiBoUser.anchorLevel;
            this.inBlackList = twZhiBoUser.inBlackList;
            this.fieldEx = twZhiBoUser.fieldEx;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public TwZhiBoUser build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new TwZhiBoUser(this, z, null);
            }
            return (TwZhiBoUser) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-535177149, "Lprotobuf/TwZhiBoUser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-535177149, "Lprotobuf/TwZhiBoUser;");
                return;
            }
        }
        DEFAULT_ANCHORLEVEL = 0;
        DEFAULT_INBLACKLIST = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwZhiBoUser(Builder builder, boolean z) {
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
            Integer num = builder.anchorLevel;
            if (num == null) {
                this.anchorLevel = DEFAULT_ANCHORLEVEL;
            } else {
                this.anchorLevel = num;
            }
            Integer num2 = builder.inBlackList;
            if (num2 == null) {
                this.inBlackList = DEFAULT_INBLACKLIST;
            } else {
                this.inBlackList = num2;
            }
            String str = builder.fieldEx;
            if (str == null) {
                this.fieldEx = "";
                return;
            } else {
                this.fieldEx = str;
                return;
            }
        }
        this.anchorLevel = builder.anchorLevel;
        this.inBlackList = builder.inBlackList;
        this.fieldEx = builder.fieldEx;
    }

    public /* synthetic */ TwZhiBoUser(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
