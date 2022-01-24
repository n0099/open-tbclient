package protobuf.UploadClientLog;

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
/* loaded from: classes5.dex */
public final class ClientLog extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_ET = "";
    public static final String DEFAULT_NET = "";
    public static final Integer DEFAULT_PROCESS_TYPE;
    public static final Integer DEFAULT_PUSHCNT;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String et;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String net;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer process_type;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer pushcnt;

    /* loaded from: classes5.dex */
    public static final class Builder extends Message.Builder<ClientLog> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String et;
        public String net;
        public Integer process_type;
        public Integer pushcnt;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(ClientLog clientLog) {
            super(clientLog);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {clientLog};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Message) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (clientLog == null) {
                return;
            }
            this.et = clientLog.et;
            this.pushcnt = clientLog.pushcnt;
            this.net = clientLog.net;
            this.process_type = clientLog.process_type;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ClientLog build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new ClientLog(this, z, null) : (ClientLog) invokeZ.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1701945007, "Lprotobuf/UploadClientLog/ClientLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1701945007, "Lprotobuf/UploadClientLog/ClientLog;");
                return;
            }
        }
        DEFAULT_PUSHCNT = 0;
        DEFAULT_PROCESS_TYPE = 0;
    }

    public /* synthetic */ ClientLog(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientLog(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (z) {
            String str = builder.et;
            if (str == null) {
                this.et = "";
            } else {
                this.et = str;
            }
            Integer num = builder.pushcnt;
            if (num == null) {
                this.pushcnt = DEFAULT_PUSHCNT;
            } else {
                this.pushcnt = num;
            }
            String str2 = builder.net;
            if (str2 == null) {
                this.net = "";
            } else {
                this.net = str2;
            }
            Integer num2 = builder.process_type;
            if (num2 == null) {
                this.process_type = DEFAULT_PROCESS_TYPE;
                return;
            } else {
                this.process_type = num2;
                return;
            }
        }
        this.et = builder.et;
        this.pushcnt = builder.pushcnt;
        this.net = builder.net;
        this.process_type = builder.process_type;
    }
}
