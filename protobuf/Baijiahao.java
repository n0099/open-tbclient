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
public final class Baijiahao extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_FORWARDURL = "";
    public static final String DEFAULT_ORIUGCNID = "";
    public static final String DEFAULT_ORIUGCTID = "";
    public static final Integer DEFAULT_ORIUGCTYPE;
    public static final String DEFAULT_ORIUGCVID = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String forwardUrl;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String oriUgcNid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String oriUgcTid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer oriUgcType;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String oriUgcVid;

    /* loaded from: classes9.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class Builder extends Message.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String forwardUrl;
        public String oriUgcNid;
        public String oriUgcTid;
        public Integer oriUgcType;
        public String oriUgcVid;

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
        public Builder(Baijiahao baijiahao) {
            super(baijiahao);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baijiahao};
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
            if (baijiahao == null) {
                return;
            }
            this.oriUgcNid = baijiahao.oriUgcNid;
            this.oriUgcTid = baijiahao.oriUgcTid;
            this.oriUgcType = baijiahao.oriUgcType;
            this.oriUgcVid = baijiahao.oriUgcVid;
            this.forwardUrl = baijiahao.forwardUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Baijiahao build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new Baijiahao(this, z, null);
            }
            return (Baijiahao) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1321238411, "Lprotobuf/Baijiahao;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1321238411, "Lprotobuf/Baijiahao;");
                return;
            }
        }
        DEFAULT_ORIUGCTYPE = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Baijiahao(Builder builder, boolean z) {
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
            String str = builder.oriUgcNid;
            if (str == null) {
                this.oriUgcNid = "";
            } else {
                this.oriUgcNid = str;
            }
            String str2 = builder.oriUgcTid;
            if (str2 == null) {
                this.oriUgcTid = "";
            } else {
                this.oriUgcTid = str2;
            }
            Integer num = builder.oriUgcType;
            if (num == null) {
                this.oriUgcType = DEFAULT_ORIUGCTYPE;
            } else {
                this.oriUgcType = num;
            }
            String str3 = builder.oriUgcVid;
            if (str3 == null) {
                this.oriUgcVid = "";
            } else {
                this.oriUgcVid = str3;
            }
            String str4 = builder.forwardUrl;
            if (str4 == null) {
                this.forwardUrl = "";
                return;
            } else {
                this.forwardUrl = str4;
                return;
            }
        }
        this.oriUgcNid = builder.oriUgcNid;
        this.oriUgcTid = builder.oriUgcTid;
        this.oriUgcType = builder.oriUgcType;
        this.oriUgcVid = builder.oriUgcVid;
        this.forwardUrl = builder.forwardUrl;
    }

    public /* synthetic */ Baijiahao(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
