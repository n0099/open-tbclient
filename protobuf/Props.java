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
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public final class Props extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_ENDTIME = "";
    public static final String DEFAULT_EXPIREDNOTIFY = "";
    public static final String DEFAULT_EXPIRINGNOTIFY = "";
    public static final Integer DEFAULT_LEFTNUM;
    public static final String DEFAULT_NOTICE = "";
    public static final Integer DEFAULT_NUM;
    public static final String DEFAULT_OPENSTATUS = "";
    public static final List<String> DEFAULT_PATTERN;
    public static final String DEFAULT_PROPSCATEGORY = "";
    public static final Integer DEFAULT_PROPSID;
    public static final String DEFAULT_PROPSTYPE = "";
    public static final String DEFAULT_TITLE = "";
    public static final Integer DEFAULT_UPDATETIME;
    public static final String DEFAULT_USEDSTATUS = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String endTime;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String expiredNotify;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String expiringNotify;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer leftNum;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String notice;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer num;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String openStatus;
    @ProtoField(label = Message.Label.REPEATED, tag = 15, type = Message.Datatype.STRING)
    public final List<String> pattern;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String propsCategory;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer propsId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String propsType;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer updateTime;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String usedStatus;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<Props> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String endTime;
        public String expiredNotify;
        public String expiringNotify;
        public Integer leftNum;
        public String notice;
        public Integer num;
        public String openStatus;
        public List<String> pattern;
        public String propsCategory;
        public Integer propsId;
        public String propsType;
        public String title;
        public Integer updateTime;
        public String usedStatus;

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
        public Builder(Props props) {
            super(props);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {props};
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
            if (props == null) {
                return;
            }
            this.propsId = props.propsId;
            this.propsType = props.propsType;
            this.propsCategory = props.propsCategory;
            this.leftNum = props.leftNum;
            this.usedStatus = props.usedStatus;
            this.num = props.num;
            this.endTime = props.endTime;
            this.notice = props.notice;
            this.updateTime = props.updateTime;
            this.openStatus = props.openStatus;
            this.expiringNotify = props.expiringNotify;
            this.expiredNotify = props.expiredNotify;
            this.title = props.title;
            this.pattern = Message.copyOf(props.pattern);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Props build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new Props(this, z, null);
            }
            return (Props) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1122468387, "Lprotobuf/Props;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1122468387, "Lprotobuf/Props;");
                return;
            }
        }
        DEFAULT_PROPSID = 0;
        DEFAULT_LEFTNUM = 0;
        DEFAULT_NUM = 0;
        DEFAULT_UPDATETIME = 0;
        DEFAULT_PATTERN = Collections.emptyList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Props(Builder builder, boolean z) {
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
            Integer num = builder.propsId;
            if (num == null) {
                this.propsId = DEFAULT_PROPSID;
            } else {
                this.propsId = num;
            }
            String str = builder.propsType;
            if (str == null) {
                this.propsType = "";
            } else {
                this.propsType = str;
            }
            String str2 = builder.propsCategory;
            if (str2 == null) {
                this.propsCategory = "";
            } else {
                this.propsCategory = str2;
            }
            Integer num2 = builder.leftNum;
            if (num2 == null) {
                this.leftNum = DEFAULT_LEFTNUM;
            } else {
                this.leftNum = num2;
            }
            String str3 = builder.usedStatus;
            if (str3 == null) {
                this.usedStatus = "";
            } else {
                this.usedStatus = str3;
            }
            Integer num3 = builder.num;
            if (num3 == null) {
                this.num = DEFAULT_NUM;
            } else {
                this.num = num3;
            }
            String str4 = builder.endTime;
            if (str4 == null) {
                this.endTime = "";
            } else {
                this.endTime = str4;
            }
            String str5 = builder.notice;
            if (str5 == null) {
                this.notice = "";
            } else {
                this.notice = str5;
            }
            Integer num4 = builder.updateTime;
            if (num4 == null) {
                this.updateTime = DEFAULT_UPDATETIME;
            } else {
                this.updateTime = num4;
            }
            String str6 = builder.openStatus;
            if (str6 == null) {
                this.openStatus = "";
            } else {
                this.openStatus = str6;
            }
            String str7 = builder.expiringNotify;
            if (str7 == null) {
                this.expiringNotify = "";
            } else {
                this.expiringNotify = str7;
            }
            String str8 = builder.expiredNotify;
            if (str8 == null) {
                this.expiredNotify = "";
            } else {
                this.expiredNotify = str8;
            }
            String str9 = builder.title;
            if (str9 == null) {
                this.title = "";
            } else {
                this.title = str9;
            }
            List<String> list = builder.pattern;
            if (list == null) {
                this.pattern = DEFAULT_PATTERN;
                return;
            } else {
                this.pattern = Message.immutableCopyOf(list);
                return;
            }
        }
        this.propsId = builder.propsId;
        this.propsType = builder.propsType;
        this.propsCategory = builder.propsCategory;
        this.leftNum = builder.leftNum;
        this.usedStatus = builder.usedStatus;
        this.num = builder.num;
        this.endTime = builder.endTime;
        this.notice = builder.notice;
        this.updateTime = builder.updateTime;
        this.openStatus = builder.openStatus;
        this.expiringNotify = builder.expiringNotify;
        this.expiredNotify = builder.expiredNotify;
        this.title = builder.title;
        this.pattern = Message.immutableCopyOf(builder.pattern);
    }

    public /* synthetic */ Props(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
