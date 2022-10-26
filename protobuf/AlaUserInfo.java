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
public final class AlaUserInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Long DEFAULT_ALAID;
    public static final Integer DEFAULT_ANCHORFANS;
    public static final Long DEFAULT_ANCHORLIVE;
    public static final Long DEFAULT_CHARMCOUNT;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Long DEFAULT_ENTERLIVE;
    public static final String DEFAULT_GREATANCHORDESCGRADE = "";
    public static final String DEFAULT_GREATANCHORDESCROLE = "";
    public static final String DEFAULT_GREATANCHORICON = "";
    public static final Integer DEFAULT_ISOFFICIAL;
    public static final Double DEFAULT_LAT;
    public static final Long DEFAULT_LEVELEXP;
    public static final Integer DEFAULT_LEVELID;
    public static final String DEFAULT_LEVELNAME = "";
    public static final Long DEFAULT_LIVEID;
    public static final Integer DEFAULT_LIVESTATUS;
    public static final Double DEFAULT_LNG;
    public static final String DEFAULT_LOCATION = "";
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_SEX = "";
    public static final Integer DEFAULT_UPDATETIME;
    public static final Long DEFAULT_USERID;
    public static final String DEFAULT_USERNAME = "";
    public static final String DEFAULT_VERIFYSTATUS = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long alaId;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer anchorFans;
    @ProtoField(tag = 7, type = Message.Datatype.UINT64)
    public final Long anchorLive;
    @ProtoField(tag = 14, type = Message.Datatype.UINT64)
    public final Long charmCount;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 6, type = Message.Datatype.UINT64)
    public final Long enterLive;
    @ProtoField(tag = 20, type = Message.Datatype.STRING)
    public final String greatAnchorDescGrade;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String greatAnchorDescRole;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String greatAnchorIcon;
    @ProtoField(tag = 16, type = Message.Datatype.UINT32)
    public final Integer isOfficial;
    @ProtoField(tag = 12, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(tag = 15, type = Message.Datatype.UINT64)
    public final Long levelExp;
    @ProtoField(tag = 18, type = Message.Datatype.UINT32)
    public final Integer levelId;
    @ProtoField(tag = 22, type = Message.Datatype.STRING)
    public final String levelName;
    @ProtoField(tag = 9, type = Message.Datatype.UINT64)
    public final Long liveId;
    @ProtoField(tag = 8, type = Message.Datatype.UINT32)
    public final Integer liveStatus;
    @ProtoField(tag = 11, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String location;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String sex;
    @ProtoField(tag = 13, type = Message.Datatype.UINT32)
    public final Integer updateTime;
    @ProtoField(tag = 23, type = Message.Datatype.UINT64)
    public final Long userId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String userName;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String verifyStatus;
    @ProtoField(tag = 25)
    public final YyExt yyExt;

    /* loaded from: classes9.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public final class Builder extends Message.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Long alaId;
        public Integer anchorFans;
        public Long anchorLive;
        public Long charmCount;
        public String description;
        public Long enterLive;
        public String greatAnchorDescGrade;
        public String greatAnchorDescRole;
        public String greatAnchorIcon;
        public Integer isOfficial;
        public Double lat;
        public Long levelExp;
        public Integer levelId;
        public String levelName;
        public Long liveId;
        public Integer liveStatus;
        public Double lng;
        public String location;
        public String portrait;
        public String sex;
        public Integer updateTime;
        public Long userId;
        public String userName;
        public String verifyStatus;
        public YyExt yyExt;

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
        public Builder(AlaUserInfo alaUserInfo) {
            super(alaUserInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaUserInfo};
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
            if (alaUserInfo == null) {
                return;
            }
            this.alaId = alaUserInfo.alaId;
            this.userName = alaUserInfo.userName;
            this.portrait = alaUserInfo.portrait;
            this.description = alaUserInfo.description;
            this.sex = alaUserInfo.sex;
            this.enterLive = alaUserInfo.enterLive;
            this.anchorLive = alaUserInfo.anchorLive;
            this.liveStatus = alaUserInfo.liveStatus;
            this.liveId = alaUserInfo.liveId;
            this.location = alaUserInfo.location;
            this.lng = alaUserInfo.lng;
            this.lat = alaUserInfo.lat;
            this.updateTime = alaUserInfo.updateTime;
            this.charmCount = alaUserInfo.charmCount;
            this.levelExp = alaUserInfo.levelExp;
            this.isOfficial = alaUserInfo.isOfficial;
            this.verifyStatus = alaUserInfo.verifyStatus;
            this.levelId = alaUserInfo.levelId;
            this.greatAnchorIcon = alaUserInfo.greatAnchorIcon;
            this.greatAnchorDescGrade = alaUserInfo.greatAnchorDescGrade;
            this.greatAnchorDescRole = alaUserInfo.greatAnchorDescRole;
            this.levelName = alaUserInfo.levelName;
            this.userId = alaUserInfo.userId;
            this.anchorFans = alaUserInfo.anchorFans;
            this.yyExt = alaUserInfo.yyExt;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AlaUserInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                return new AlaUserInfo(this, z, null);
            }
            return (AlaUserInfo) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-474102108, "Lprotobuf/AlaUserInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-474102108, "Lprotobuf/AlaUserInfo;");
                return;
            }
        }
        DEFAULT_ALAID = 0L;
        DEFAULT_ENTERLIVE = 0L;
        DEFAULT_ANCHORLIVE = 0L;
        DEFAULT_LIVESTATUS = 0;
        DEFAULT_LIVEID = 0L;
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LNG = valueOf;
        DEFAULT_LAT = valueOf;
        DEFAULT_UPDATETIME = 0;
        DEFAULT_CHARMCOUNT = 0L;
        DEFAULT_LEVELEXP = 0L;
        DEFAULT_ISOFFICIAL = 0;
        DEFAULT_LEVELID = 0;
        DEFAULT_USERID = 0L;
        DEFAULT_ANCHORFANS = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaUserInfo(Builder builder, boolean z) {
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
            Long l = builder.alaId;
            if (l == null) {
                this.alaId = DEFAULT_ALAID;
            } else {
                this.alaId = l;
            }
            String str = builder.userName;
            if (str == null) {
                this.userName = "";
            } else {
                this.userName = str;
            }
            String str2 = builder.portrait;
            if (str2 == null) {
                this.portrait = "";
            } else {
                this.portrait = str2;
            }
            String str3 = builder.description;
            if (str3 == null) {
                this.description = "";
            } else {
                this.description = str3;
            }
            String str4 = builder.sex;
            if (str4 == null) {
                this.sex = "";
            } else {
                this.sex = str4;
            }
            Long l2 = builder.enterLive;
            if (l2 == null) {
                this.enterLive = DEFAULT_ENTERLIVE;
            } else {
                this.enterLive = l2;
            }
            Long l3 = builder.anchorLive;
            if (l3 == null) {
                this.anchorLive = DEFAULT_ANCHORLIVE;
            } else {
                this.anchorLive = l3;
            }
            Integer num = builder.liveStatus;
            if (num == null) {
                this.liveStatus = DEFAULT_LIVESTATUS;
            } else {
                this.liveStatus = num;
            }
            Long l4 = builder.liveId;
            if (l4 == null) {
                this.liveId = DEFAULT_LIVEID;
            } else {
                this.liveId = l4;
            }
            String str5 = builder.location;
            if (str5 == null) {
                this.location = "";
            } else {
                this.location = str5;
            }
            Double d = builder.lng;
            if (d == null) {
                this.lng = DEFAULT_LNG;
            } else {
                this.lng = d;
            }
            Double d2 = builder.lat;
            if (d2 == null) {
                this.lat = DEFAULT_LAT;
            } else {
                this.lat = d2;
            }
            Integer num2 = builder.updateTime;
            if (num2 == null) {
                this.updateTime = DEFAULT_UPDATETIME;
            } else {
                this.updateTime = num2;
            }
            Long l5 = builder.charmCount;
            if (l5 == null) {
                this.charmCount = DEFAULT_CHARMCOUNT;
            } else {
                this.charmCount = l5;
            }
            Long l6 = builder.levelExp;
            if (l6 == null) {
                this.levelExp = DEFAULT_LEVELEXP;
            } else {
                this.levelExp = l6;
            }
            Integer num3 = builder.isOfficial;
            if (num3 == null) {
                this.isOfficial = DEFAULT_ISOFFICIAL;
            } else {
                this.isOfficial = num3;
            }
            String str6 = builder.verifyStatus;
            if (str6 == null) {
                this.verifyStatus = "";
            } else {
                this.verifyStatus = str6;
            }
            Integer num4 = builder.levelId;
            if (num4 == null) {
                this.levelId = DEFAULT_LEVELID;
            } else {
                this.levelId = num4;
            }
            String str7 = builder.greatAnchorIcon;
            if (str7 == null) {
                this.greatAnchorIcon = "";
            } else {
                this.greatAnchorIcon = str7;
            }
            String str8 = builder.greatAnchorDescGrade;
            if (str8 == null) {
                this.greatAnchorDescGrade = "";
            } else {
                this.greatAnchorDescGrade = str8;
            }
            String str9 = builder.greatAnchorDescRole;
            if (str9 == null) {
                this.greatAnchorDescRole = "";
            } else {
                this.greatAnchorDescRole = str9;
            }
            String str10 = builder.levelName;
            if (str10 == null) {
                this.levelName = "";
            } else {
                this.levelName = str10;
            }
            Long l7 = builder.userId;
            if (l7 == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = l7;
            }
            Integer num5 = builder.anchorFans;
            if (num5 == null) {
                this.anchorFans = DEFAULT_ANCHORFANS;
            } else {
                this.anchorFans = num5;
            }
            this.yyExt = builder.yyExt;
            return;
        }
        this.alaId = builder.alaId;
        this.userName = builder.userName;
        this.portrait = builder.portrait;
        this.description = builder.description;
        this.sex = builder.sex;
        this.enterLive = builder.enterLive;
        this.anchorLive = builder.anchorLive;
        this.liveStatus = builder.liveStatus;
        this.liveId = builder.liveId;
        this.location = builder.location;
        this.lng = builder.lng;
        this.lat = builder.lat;
        this.updateTime = builder.updateTime;
        this.charmCount = builder.charmCount;
        this.levelExp = builder.levelExp;
        this.isOfficial = builder.isOfficial;
        this.verifyStatus = builder.verifyStatus;
        this.levelId = builder.levelId;
        this.greatAnchorIcon = builder.greatAnchorIcon;
        this.greatAnchorDescGrade = builder.greatAnchorDescGrade;
        this.greatAnchorDescRole = builder.greatAnchorDescRole;
        this.levelName = builder.levelName;
        this.userId = builder.userId;
        this.anchorFans = builder.anchorFans;
        this.yyExt = builder.yyExt;
    }

    public /* synthetic */ AlaUserInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }
}
