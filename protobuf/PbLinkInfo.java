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
public final class PbLinkInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_EXTTXT = "";
    public static final String DEFAULT_LINKFROM = "";
    public static final String DEFAULT_PICURL = "";
    public static final Integer DEFAULT_SORT;
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_TOURL = "";
    public static final Integer DEFAULT_URLTYPE;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String extTxt;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String linkFrom;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String picUrl;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer sort;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String toUrl;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer urlType;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<PbLinkInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String extTxt;
        public String linkFrom;
        public String picUrl;
        public Integer sort;
        public String title;
        public String toUrl;
        public Integer urlType;

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
        public Builder(PbLinkInfo pbLinkInfo) {
            super(pbLinkInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbLinkInfo};
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
            if (pbLinkInfo == null) {
                return;
            }
            this.title = pbLinkInfo.title;
            this.toUrl = pbLinkInfo.toUrl;
            this.picUrl = pbLinkInfo.picUrl;
            this.linkFrom = pbLinkInfo.linkFrom;
            this.extTxt = pbLinkInfo.extTxt;
            this.sort = pbLinkInfo.sort;
            this.urlType = pbLinkInfo.urlType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PbLinkInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new PbLinkInfo(this, z, null) : (PbLinkInfo) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1941608777, "Lprotobuf/PbLinkInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1941608777, "Lprotobuf/PbLinkInfo;");
                return;
            }
        }
        DEFAULT_SORT = 0;
        DEFAULT_URLTYPE = 0;
    }

    public /* synthetic */ PbLinkInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbLinkInfo(Builder builder, boolean z) {
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
            String str = builder.title;
            if (str == null) {
                this.title = "";
            } else {
                this.title = str;
            }
            String str2 = builder.toUrl;
            if (str2 == null) {
                this.toUrl = "";
            } else {
                this.toUrl = str2;
            }
            String str3 = builder.picUrl;
            if (str3 == null) {
                this.picUrl = "";
            } else {
                this.picUrl = str3;
            }
            String str4 = builder.linkFrom;
            if (str4 == null) {
                this.linkFrom = "";
            } else {
                this.linkFrom = str4;
            }
            String str5 = builder.extTxt;
            if (str5 == null) {
                this.extTxt = "";
            } else {
                this.extTxt = str5;
            }
            Integer num = builder.sort;
            if (num == null) {
                this.sort = DEFAULT_SORT;
            } else {
                this.sort = num;
            }
            Integer num2 = builder.urlType;
            if (num2 == null) {
                this.urlType = DEFAULT_URLTYPE;
                return;
            } else {
                this.urlType = num2;
                return;
            }
        }
        this.title = builder.title;
        this.toUrl = builder.toUrl;
        this.picUrl = builder.picUrl;
        this.linkFrom = builder.linkFrom;
        this.extTxt = builder.extTxt;
        this.sort = builder.sort;
        this.urlType = builder.urlType;
    }
}
