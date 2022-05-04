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
public final class GiftInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_GIFTID;
    public static final String DEFAULT_GIFTNAME = "";
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_LARGETHUMBNAILURL = "";
    public static final Integer DEFAULT_NUM;
    public static final Long DEFAULT_SENDERID;
    public static final String DEFAULT_SENDERNAME = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer giftId;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String giftName;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String icon;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String largeThumbnailUrl;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer num;
    @ProtoField(tag = 6, type = Message.Datatype.UINT64)
    public final Long senderId;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String senderName;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<GiftInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer giftId;
        public String giftName;
        public String icon;
        public String largeThumbnailUrl;
        public Integer num;
        public Long senderId;
        public String senderName;

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
        public Builder(GiftInfo giftInfo) {
            super(giftInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftInfo};
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
            if (giftInfo == null) {
                return;
            }
            this.icon = giftInfo.icon;
            this.num = giftInfo.num;
            this.giftId = giftInfo.giftId;
            this.giftName = giftInfo.giftName;
            this.largeThumbnailUrl = giftInfo.largeThumbnailUrl;
            this.senderId = giftInfo.senderId;
            this.senderName = giftInfo.senderName;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GiftInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new GiftInfo(this, z, null) : (GiftInfo) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(101898661, "Lprotobuf/GiftInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(101898661, "Lprotobuf/GiftInfo;");
                return;
            }
        }
        DEFAULT_NUM = 0;
        DEFAULT_GIFTID = 0;
        DEFAULT_SENDERID = 0L;
    }

    public /* synthetic */ GiftInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftInfo(Builder builder, boolean z) {
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
            String str = builder.icon;
            if (str == null) {
                this.icon = "";
            } else {
                this.icon = str;
            }
            Integer num = builder.num;
            if (num == null) {
                this.num = DEFAULT_NUM;
            } else {
                this.num = num;
            }
            Integer num2 = builder.giftId;
            if (num2 == null) {
                this.giftId = DEFAULT_GIFTID;
            } else {
                this.giftId = num2;
            }
            String str2 = builder.giftName;
            if (str2 == null) {
                this.giftName = "";
            } else {
                this.giftName = str2;
            }
            String str3 = builder.largeThumbnailUrl;
            if (str3 == null) {
                this.largeThumbnailUrl = "";
            } else {
                this.largeThumbnailUrl = str3;
            }
            Long l = builder.senderId;
            if (l == null) {
                this.senderId = DEFAULT_SENDERID;
            } else {
                this.senderId = l;
            }
            String str4 = builder.senderName;
            if (str4 == null) {
                this.senderName = "";
                return;
            } else {
                this.senderName = str4;
                return;
            }
        }
        this.icon = builder.icon;
        this.num = builder.num;
        this.giftId = builder.giftId;
        this.giftName = builder.giftName;
        this.largeThumbnailUrl = builder.largeThumbnailUrl;
        this.senderId = builder.senderId;
        this.senderName = builder.senderName;
    }
}
