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
public final class YyExt extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_ICONURL = "";
    public static final Integer DEFAULT_ISYYGAME;
    public static final String DEFAULT_RANKSHOW = "";
    public static final String DEFAULT_SID = "";
    public static final String DEFAULT_SSID = "";
    public static final String DEFAULT_STREAMINFO = "";
    public static final String DEFAULT_TEMPLATEID = "";
    public static final String DEFAULT_YYUID = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String iconUrl;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer isYyGame;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String rankShow;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String sid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String ssid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String streamInfo;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String templateId;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String yyUid;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<YyExt> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String iconUrl;
        public Integer isYyGame;
        public String rankShow;
        public String sid;
        public String ssid;
        public String streamInfo;
        public String templateId;
        public String yyUid;

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
        public Builder(YyExt yyExt) {
            super(yyExt);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yyExt};
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
            if (yyExt == null) {
                return;
            }
            this.sid = yyExt.sid;
            this.ssid = yyExt.ssid;
            this.templateId = yyExt.templateId;
            this.yyUid = yyExt.yyUid;
            this.isYyGame = yyExt.isYyGame;
            this.streamInfo = yyExt.streamInfo;
            this.rankShow = yyExt.rankShow;
            this.iconUrl = yyExt.iconUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public YyExt build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new YyExt(this, z, null);
            }
            return (YyExt) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1385351890, "Lprotobuf/YyExt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1385351890, "Lprotobuf/YyExt;");
                return;
            }
        }
        DEFAULT_ISYYGAME = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YyExt(Builder builder, boolean z) {
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
            String str = builder.sid;
            if (str == null) {
                this.sid = "";
            } else {
                this.sid = str;
            }
            String str2 = builder.ssid;
            if (str2 == null) {
                this.ssid = "";
            } else {
                this.ssid = str2;
            }
            String str3 = builder.templateId;
            if (str3 == null) {
                this.templateId = "";
            } else {
                this.templateId = str3;
            }
            String str4 = builder.yyUid;
            if (str4 == null) {
                this.yyUid = "";
            } else {
                this.yyUid = str4;
            }
            Integer num = builder.isYyGame;
            if (num == null) {
                this.isYyGame = DEFAULT_ISYYGAME;
            } else {
                this.isYyGame = num;
            }
            String str5 = builder.streamInfo;
            if (str5 == null) {
                this.streamInfo = "";
            } else {
                this.streamInfo = str5;
            }
            String str6 = builder.rankShow;
            if (str6 == null) {
                this.rankShow = "";
            } else {
                this.rankShow = str6;
            }
            String str7 = builder.iconUrl;
            if (str7 == null) {
                this.iconUrl = "";
                return;
            } else {
                this.iconUrl = str7;
                return;
            }
        }
        this.sid = builder.sid;
        this.ssid = builder.ssid;
        this.templateId = builder.templateId;
        this.yyUid = builder.yyUid;
        this.isYyGame = builder.isYyGame;
        this.streamInfo = builder.streamInfo;
        this.rankShow = builder.rankShow;
        this.iconUrl = builder.iconUrl;
    }

    public /* synthetic */ YyExt(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
