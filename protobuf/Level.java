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
public final class Level extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_ENDTIME;
    public static final String DEFAULT_EXPIREDNOTIFY = "";
    public static final String DEFAULT_EXPIRINGNOTIFY = "";
    public static final Integer DEFAULT_LEFTNUM;
    public static final String DEFAULT_MAXFREESCORE = "";
    public static final String DEFAULT_OPENSTATUS = "";
    public static final String DEFAULT_PICURL = "";
    public static final String DEFAULT_PROPSCATEGORY = "";
    public static final Integer DEFAULT_PROPSID;
    public static final String DEFAULT_PROPSTYPE = "";
    public static final Integer DEFAULT_UPDATETIME;
    public static final String DEFAULT_USEDSTATUS = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer endTime;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String expiredNotify;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String expiringNotify;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer leftNum;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String maxFreeScore;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String openStatus;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String picUrl;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String propsCategory;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer propsId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String propsType;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer updateTime;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String usedStatus;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<Level> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer endTime;
        public String expiredNotify;
        public String expiringNotify;
        public Integer leftNum;
        public String maxFreeScore;
        public String openStatus;
        public String picUrl;
        public String propsCategory;
        public Integer propsId;
        public String propsType;
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
        public Builder(Level level) {
            super(level);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {level};
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
            if (level == null) {
                return;
            }
            this.propsId = level.propsId;
            this.propsType = level.propsType;
            this.propsCategory = level.propsCategory;
            this.endTime = level.endTime;
            this.leftNum = level.leftNum;
            this.updateTime = level.updateTime;
            this.usedStatus = level.usedStatus;
            this.openStatus = level.openStatus;
            this.expiringNotify = level.expiringNotify;
            this.expiredNotify = level.expiredNotify;
            this.maxFreeScore = level.maxFreeScore;
            this.picUrl = level.picUrl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Level build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new Level(this, z, null) : (Level) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(996143759, "Lprotobuf/Level;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(996143759, "Lprotobuf/Level;");
                return;
            }
        }
        DEFAULT_PROPSID = 0;
        DEFAULT_ENDTIME = 0;
        DEFAULT_LEFTNUM = 0;
        DEFAULT_UPDATETIME = 0;
    }

    public /* synthetic */ Level(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Level(Builder builder, boolean z) {
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
            Integer num2 = builder.endTime;
            if (num2 == null) {
                this.endTime = DEFAULT_ENDTIME;
            } else {
                this.endTime = num2;
            }
            Integer num3 = builder.leftNum;
            if (num3 == null) {
                this.leftNum = DEFAULT_LEFTNUM;
            } else {
                this.leftNum = num3;
            }
            Integer num4 = builder.updateTime;
            if (num4 == null) {
                this.updateTime = DEFAULT_UPDATETIME;
            } else {
                this.updateTime = num4;
            }
            String str3 = builder.usedStatus;
            if (str3 == null) {
                this.usedStatus = "";
            } else {
                this.usedStatus = str3;
            }
            String str4 = builder.openStatus;
            if (str4 == null) {
                this.openStatus = "";
            } else {
                this.openStatus = str4;
            }
            String str5 = builder.expiringNotify;
            if (str5 == null) {
                this.expiringNotify = "";
            } else {
                this.expiringNotify = str5;
            }
            String str6 = builder.expiredNotify;
            if (str6 == null) {
                this.expiredNotify = "";
            } else {
                this.expiredNotify = str6;
            }
            String str7 = builder.maxFreeScore;
            if (str7 == null) {
                this.maxFreeScore = "";
            } else {
                this.maxFreeScore = str7;
            }
            String str8 = builder.picUrl;
            if (str8 == null) {
                this.picUrl = "";
                return;
            } else {
                this.picUrl = str8;
                return;
            }
        }
        this.propsId = builder.propsId;
        this.propsType = builder.propsType;
        this.propsCategory = builder.propsCategory;
        this.endTime = builder.endTime;
        this.leftNum = builder.leftNum;
        this.updateTime = builder.updateTime;
        this.usedStatus = builder.usedStatus;
        this.openStatus = builder.openStatus;
        this.expiringNotify = builder.expiringNotify;
        this.expiredNotify = builder.expiredNotify;
        this.maxFreeScore = builder.maxFreeScore;
        this.picUrl = builder.picUrl;
    }
}
