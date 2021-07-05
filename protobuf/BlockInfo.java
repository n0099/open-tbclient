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
/* loaded from: classes10.dex */
public final class BlockInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_BLOCKCANCEL = "";
    public static final String DEFAULT_BLOCKCONFIRM = "";
    public static final String DEFAULT_BLOCKDEALURL = "";
    public static final String DEFAULT_BLOCKERRMSG = "";
    public static final Integer DEFAULT_BLOCKERRNO;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String blockCancel;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String blockConfirm;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String blockDealurl;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String blockErrmsg;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer blockErrno;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<BlockInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String blockCancel;
        public String blockConfirm;
        public String blockDealurl;
        public String blockErrmsg;
        public Integer blockErrno;

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
        public Builder(BlockInfo blockInfo) {
            super(blockInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {blockInfo};
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
            if (blockInfo == null) {
                return;
            }
            this.blockErrno = blockInfo.blockErrno;
            this.blockErrmsg = blockInfo.blockErrmsg;
            this.blockDealurl = blockInfo.blockDealurl;
            this.blockConfirm = blockInfo.blockConfirm;
            this.blockCancel = blockInfo.blockCancel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public BlockInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new BlockInfo(this, z, null) : (BlockInfo) invokeZ.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(256245272, "Lprotobuf/BlockInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(256245272, "Lprotobuf/BlockInfo;");
                return;
            }
        }
        DEFAULT_BLOCKERRNO = 0;
    }

    public /* synthetic */ BlockInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockInfo(Builder builder, boolean z) {
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
            Integer num = builder.blockErrno;
            if (num == null) {
                this.blockErrno = DEFAULT_BLOCKERRNO;
            } else {
                this.blockErrno = num;
            }
            String str = builder.blockErrmsg;
            if (str == null) {
                this.blockErrmsg = "";
            } else {
                this.blockErrmsg = str;
            }
            String str2 = builder.blockDealurl;
            if (str2 == null) {
                this.blockDealurl = "";
            } else {
                this.blockDealurl = str2;
            }
            String str3 = builder.blockConfirm;
            if (str3 == null) {
                this.blockConfirm = "";
            } else {
                this.blockConfirm = str3;
            }
            String str4 = builder.blockCancel;
            if (str4 == null) {
                this.blockCancel = "";
                return;
            } else {
                this.blockCancel = str4;
                return;
            }
        }
        this.blockErrno = builder.blockErrno;
        this.blockErrmsg = builder.blockErrmsg;
        this.blockDealurl = builder.blockDealurl;
        this.blockConfirm = builder.blockConfirm;
        this.blockCancel = builder.blockCancel;
    }
}
