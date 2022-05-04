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
public final class ApkDetail extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_AUTHORITYURL = "";
    public static final String DEFAULT_DEVELOPER = "";
    public static final Integer DEFAULT_NEEDINNERBUY;
    public static final Integer DEFAULT_NEEDNETWORK;
    public static final Integer DEFAULT_PKGSOURCE;
    public static final String DEFAULT_PRIVACYURL = "";
    public static final String DEFAULT_PUBLISHER = "";
    public static final String DEFAULT_SIZE = "";
    public static final String DEFAULT_UPDATETIME = "";
    public static final String DEFAULT_VERSION = "";
    public static final Integer DEFAULT_VERSIONCODE;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String authorityUrl;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String developer;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer needInnerBuy;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer needNetwork;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer pkgSource;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String privacyUrl;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String publisher;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String size;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String updateTime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String version;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer versionCode;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<ApkDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String authorityUrl;
        public String developer;
        public Integer needInnerBuy;
        public Integer needNetwork;
        public Integer pkgSource;
        public String privacyUrl;
        public String publisher;
        public String size;
        public String updateTime;
        public String version;
        public Integer versionCode;

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
        public Builder(ApkDetail apkDetail) {
            super(apkDetail);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apkDetail};
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
            if (apkDetail == null) {
                return;
            }
            this.developer = apkDetail.developer;
            this.publisher = apkDetail.publisher;
            this.version = apkDetail.version;
            this.versionCode = apkDetail.versionCode;
            this.updateTime = apkDetail.updateTime;
            this.size = apkDetail.size;
            this.needNetwork = apkDetail.needNetwork;
            this.needInnerBuy = apkDetail.needInnerBuy;
            this.authorityUrl = apkDetail.authorityUrl;
            this.privacyUrl = apkDetail.privacyUrl;
            this.pkgSource = apkDetail.pkgSource;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ApkDetail build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new ApkDetail(this, z, null) : (ApkDetail) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1556310438, "Lprotobuf/ApkDetail;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1556310438, "Lprotobuf/ApkDetail;");
                return;
            }
        }
        DEFAULT_VERSIONCODE = 0;
        DEFAULT_NEEDNETWORK = 0;
        DEFAULT_NEEDINNERBUY = 0;
        DEFAULT_PKGSOURCE = 0;
    }

    public /* synthetic */ ApkDetail(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkDetail(Builder builder, boolean z) {
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
            String str = builder.developer;
            if (str == null) {
                this.developer = "";
            } else {
                this.developer = str;
            }
            String str2 = builder.publisher;
            if (str2 == null) {
                this.publisher = "";
            } else {
                this.publisher = str2;
            }
            String str3 = builder.version;
            if (str3 == null) {
                this.version = "";
            } else {
                this.version = str3;
            }
            Integer num = builder.versionCode;
            if (num == null) {
                this.versionCode = DEFAULT_VERSIONCODE;
            } else {
                this.versionCode = num;
            }
            String str4 = builder.updateTime;
            if (str4 == null) {
                this.updateTime = "";
            } else {
                this.updateTime = str4;
            }
            String str5 = builder.size;
            if (str5 == null) {
                this.size = "";
            } else {
                this.size = str5;
            }
            Integer num2 = builder.needNetwork;
            if (num2 == null) {
                this.needNetwork = DEFAULT_NEEDNETWORK;
            } else {
                this.needNetwork = num2;
            }
            Integer num3 = builder.needInnerBuy;
            if (num3 == null) {
                this.needInnerBuy = DEFAULT_NEEDINNERBUY;
            } else {
                this.needInnerBuy = num3;
            }
            String str6 = builder.authorityUrl;
            if (str6 == null) {
                this.authorityUrl = "";
            } else {
                this.authorityUrl = str6;
            }
            String str7 = builder.privacyUrl;
            if (str7 == null) {
                this.privacyUrl = "";
            } else {
                this.privacyUrl = str7;
            }
            Integer num4 = builder.pkgSource;
            if (num4 == null) {
                this.pkgSource = DEFAULT_PKGSOURCE;
                return;
            } else {
                this.pkgSource = num4;
                return;
            }
        }
        this.developer = builder.developer;
        this.publisher = builder.publisher;
        this.version = builder.version;
        this.versionCode = builder.versionCode;
        this.updateTime = builder.updateTime;
        this.size = builder.size;
        this.needNetwork = builder.needNetwork;
        this.needInnerBuy = builder.needInnerBuy;
        this.authorityUrl = builder.authorityUrl;
        this.privacyUrl = builder.privacyUrl;
        this.pkgSource = builder.pkgSource;
    }
}
