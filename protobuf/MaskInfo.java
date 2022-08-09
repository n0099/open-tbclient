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
public final class MaskInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_MASKFIDS = "";
    public static final String DEFAULT_MASKGIDS = "";
    public static final String DEFAULT_MASKUIDS = "";
    public static final Integer DEFAULT_REMINDMASK;
    public static final Integer DEFAULT_SHIELDSTATUS;
    public static final Long DEFAULT_USERID;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String maskFids;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String maskGids;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String maskUids;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer remindMask;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer shieldStatus;
    @ProtoField(tag = 7)
    public final PushSignMask signMask;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long userId;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<MaskInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String maskFids;
        public String maskGids;
        public String maskUids;
        public Integer remindMask;
        public Integer shieldStatus;
        public PushSignMask signMask;
        public Long userId;

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
        public Builder(MaskInfo maskInfo) {
            super(maskInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maskInfo};
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
            if (maskInfo == null) {
                return;
            }
            this.userId = maskInfo.userId;
            this.maskGids = maskInfo.maskGids;
            this.remindMask = maskInfo.remindMask;
            this.maskUids = maskInfo.maskUids;
            this.shieldStatus = maskInfo.shieldStatus;
            this.maskFids = maskInfo.maskFids;
            this.signMask = maskInfo.signMask;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public MaskInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new MaskInfo(this, z, null) : (MaskInfo) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-520523415, "Lprotobuf/MaskInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-520523415, "Lprotobuf/MaskInfo;");
                return;
            }
        }
        DEFAULT_USERID = 0L;
        DEFAULT_REMINDMASK = 0;
        DEFAULT_SHIELDSTATUS = 0;
    }

    public /* synthetic */ MaskInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskInfo(Builder builder, boolean z) {
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
            Long l = builder.userId;
            if (l == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = l;
            }
            String str = builder.maskGids;
            if (str == null) {
                this.maskGids = "";
            } else {
                this.maskGids = str;
            }
            Integer num = builder.remindMask;
            if (num == null) {
                this.remindMask = DEFAULT_REMINDMASK;
            } else {
                this.remindMask = num;
            }
            String str2 = builder.maskUids;
            if (str2 == null) {
                this.maskUids = "";
            } else {
                this.maskUids = str2;
            }
            Integer num2 = builder.shieldStatus;
            if (num2 == null) {
                this.shieldStatus = DEFAULT_SHIELDSTATUS;
            } else {
                this.shieldStatus = num2;
            }
            String str3 = builder.maskFids;
            if (str3 == null) {
                this.maskFids = "";
            } else {
                this.maskFids = str3;
            }
            this.signMask = builder.signMask;
            return;
        }
        this.userId = builder.userId;
        this.maskGids = builder.maskGids;
        this.remindMask = builder.remindMask;
        this.maskUids = builder.maskUids;
        this.shieldStatus = builder.shieldStatus;
        this.maskFids = builder.maskFids;
        this.signMask = builder.signMask;
    }
}
