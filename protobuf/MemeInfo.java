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
public final class MemeInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_DETAILLINK = "";
    public static final Integer DEFAULT_HEIGHT;
    public static final Integer DEFAULT_PCKID;
    public static final Long DEFAULT_PICID;
    public static final String DEFAULT_PICURL = "";
    public static final String DEFAULT_THUMBNAIL = "";
    public static final Integer DEFAULT_WIDTH;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String detailLink;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer height;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer pckId;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long picId;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String picUrl;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String thumbnail;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer width;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<MemeInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String detailLink;
        public Integer height;
        public Integer pckId;
        public Long picId;
        public String picUrl;
        public String thumbnail;
        public Integer width;

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
        public Builder(MemeInfo memeInfo) {
            super(memeInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memeInfo};
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
            if (memeInfo == null) {
                return;
            }
            this.pckId = memeInfo.pckId;
            this.picId = memeInfo.picId;
            this.picUrl = memeInfo.picUrl;
            this.thumbnail = memeInfo.thumbnail;
            this.width = memeInfo.width;
            this.height = memeInfo.height;
            this.detailLink = memeInfo.detailLink;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public MemeInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new MemeInfo(this, z, null) : (MemeInfo) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(953920933, "Lprotobuf/MemeInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(953920933, "Lprotobuf/MemeInfo;");
                return;
            }
        }
        DEFAULT_PCKID = 0;
        DEFAULT_PICID = 0L;
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
    }

    public /* synthetic */ MemeInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemeInfo(Builder builder, boolean z) {
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
            Integer num = builder.pckId;
            if (num == null) {
                this.pckId = DEFAULT_PCKID;
            } else {
                this.pckId = num;
            }
            Long l = builder.picId;
            if (l == null) {
                this.picId = DEFAULT_PICID;
            } else {
                this.picId = l;
            }
            String str = builder.picUrl;
            if (str == null) {
                this.picUrl = "";
            } else {
                this.picUrl = str;
            }
            String str2 = builder.thumbnail;
            if (str2 == null) {
                this.thumbnail = "";
            } else {
                this.thumbnail = str2;
            }
            Integer num2 = builder.width;
            if (num2 == null) {
                this.width = DEFAULT_WIDTH;
            } else {
                this.width = num2;
            }
            Integer num3 = builder.height;
            if (num3 == null) {
                this.height = DEFAULT_HEIGHT;
            } else {
                this.height = num3;
            }
            String str3 = builder.detailLink;
            if (str3 == null) {
                this.detailLink = "";
                return;
            } else {
                this.detailLink = str3;
                return;
            }
        }
        this.pckId = builder.pckId;
        this.picId = builder.picId;
        this.picUrl = builder.picUrl;
        this.thumbnail = builder.thumbnail;
        this.width = builder.width;
        this.height = builder.height;
        this.detailLink = builder.detailLink;
    }
}
