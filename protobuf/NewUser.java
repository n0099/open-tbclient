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
/* loaded from: classes8.dex */
public final class NewUser extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final List<Props> DEFAULT_APPRAISE;
    public static final String DEFAULT_BGID = "";
    public static final String DEFAULT_BILLBOARD = "";
    public static final String DEFAULT_CARD = "";
    public static final String DEFAULT_CDNERROR = "";
    public static final String DEFAULT_FREEFLAG = "";
    public static final String DEFAULT_ISCOREUSER = "";
    public static final String DEFAULT_ISDOUDIZHU = "";
    public static final Integer DEFAULT_ISGROUPOWNER;
    public static final Integer DEFAULT_ISHARDWORKING;
    public static final String DEFAULT_ISINTERESTMAN = "";
    public static final Integer DEFAULT_ISMEMBER;
    public static final Integer DEFAULT_ISPASSER;
    public static final Integer DEFAULT_ISQUNSPRING;
    public static final Integer DEFAULT_ISSHENGYOU;
    public static final Integer DEFAULT_ISTENYEAR;
    public static final Integer DEFAULT_MEIZHILEVEL;
    public static final List<NoticeMask> DEFAULT_NOTICEMASK;
    public static final String DEFAULT_PAPER = "";
    public static final String DEFAULT_PORTRAITTIME = "";
    public static final List<Rpgoldicon> DEFAULT_RPGOLDICON;
    public static final Integer DEFAULT_SUPERBOY;
    public static final List<TbmallMonthIcon> DEFAULT_TBMALLMONTHICON;
    public static final String DEFAULT_TBSCOREREPEATEFINISHTIME = "";
    public static final Long DEFAULT_USERID;
    public static final String DEFAULT_USERNAME = "";
    public static final Integer DEFAULT_USERSEX;
    public static final Integer DEFAULT_USERSTATUS;
    public static final Integer DEFAULT_USERTYPE;
    public static final Integer DEFAULT_USESIG;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(label = Message.Label.REPEATED, tag = 22)
    public final List<Props> appraise;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String bgId;
    @ProtoField(tag = 20, type = Message.Datatype.STRING)
    public final String billboard;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String card;
    @ProtoField(tag = 30, type = Message.Datatype.STRING)
    public final String cdnError;
    @ProtoField(tag = 36, type = Message.Datatype.STRING)
    public final String freeFlag;
    @ProtoField(tag = 33)
    public final GameAttr gameAttr;
    @ProtoField(tag = 35)
    public final Global global;
    @ProtoField(tag = 32, type = Message.Datatype.STRING)
    public final String isCoreuser;
    @ProtoField(tag = 29, type = Message.Datatype.STRING)
    public final String isDoudizhu;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer isGroupOwner;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer isHardworking;
    @ProtoField(tag = 34, type = Message.Datatype.STRING)
    public final String isInterestman;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer isMember;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer isPasser;
    @ProtoField(tag = 26, type = Message.Datatype.INT32)
    public final Integer isQunSpring;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer isShengyou;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer isTenyear;
    @ProtoField(tag = 9)
    public final MparrProps mParrProps;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer meizhiLevel;
    @ProtoField(label = Message.Label.REPEATED, tag = 27)
    public final List<NoticeMask> noticeMask;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String paper;
    @ProtoField(tag = 8)
    public final ParrProps parrProps;
    @ProtoField(tag = 13)
    public final ParrScores parrScores;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String portraitTime;
    @ProtoField(label = Message.Label.REPEATED, tag = 28)
    public final List<Rpgoldicon> rpgoldicon;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer superboy;
    @ProtoField(label = Message.Label.REPEATED, tag = 31)
    public final List<TbmallMonthIcon> tbmallMonthIcon;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String tbscoreRepeateFinishTime;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer useSig;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long userId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String userName;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userSex;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer userStatus;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer userType;
    @ProtoField(tag = 10)
    public final WapRn wapRn;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<NewUser> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<Props> appraise;
        public String bgId;
        public String billboard;
        public String card;
        public String cdnError;
        public String freeFlag;
        public GameAttr gameAttr;
        public Global global;
        public String isCoreuser;
        public String isDoudizhu;
        public Integer isGroupOwner;
        public Integer isHardworking;
        public String isInterestman;
        public Integer isMember;
        public Integer isPasser;
        public Integer isQunSpring;
        public Integer isShengyou;
        public Integer isTenyear;
        public MparrProps mParrProps;
        public Integer meizhiLevel;
        public List<NoticeMask> noticeMask;
        public String paper;
        public ParrProps parrProps;
        public ParrScores parrScores;
        public String portraitTime;
        public List<Rpgoldicon> rpgoldicon;
        public Integer superboy;
        public List<TbmallMonthIcon> tbmallMonthIcon;
        public String tbscoreRepeateFinishTime;
        public Integer useSig;
        public Long userId;
        public String userName;
        public Integer userSex;
        public Integer userStatus;
        public Integer userType;
        public WapRn wapRn;

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
        public Builder(NewUser newUser) {
            super(newUser);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUser};
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
            if (newUser == null) {
                return;
            }
            this.userId = newUser.userId;
            this.userName = newUser.userName;
            this.userSex = newUser.userSex;
            this.userStatus = newUser.userStatus;
            this.meizhiLevel = newUser.meizhiLevel;
            this.superboy = newUser.superboy;
            this.card = newUser.card;
            this.parrProps = newUser.parrProps;
            this.mParrProps = newUser.mParrProps;
            this.wapRn = newUser.wapRn;
            this.isTenyear = newUser.isTenyear;
            this.isGroupOwner = newUser.isGroupOwner;
            this.parrScores = newUser.parrScores;
            this.userType = newUser.userType;
            this.useSig = newUser.useSig;
            this.paper = newUser.paper;
            this.bgId = newUser.bgId;
            this.isShengyou = newUser.isShengyou;
            this.isHardworking = newUser.isHardworking;
            this.billboard = newUser.billboard;
            this.portraitTime = newUser.portraitTime;
            this.appraise = Message.copyOf(newUser.appraise);
            this.tbscoreRepeateFinishTime = newUser.tbscoreRepeateFinishTime;
            this.isMember = newUser.isMember;
            this.isPasser = newUser.isPasser;
            this.isQunSpring = newUser.isQunSpring;
            this.noticeMask = Message.copyOf(newUser.noticeMask);
            this.rpgoldicon = Message.copyOf(newUser.rpgoldicon);
            this.isDoudizhu = newUser.isDoudizhu;
            this.cdnError = newUser.cdnError;
            this.tbmallMonthIcon = Message.copyOf(newUser.tbmallMonthIcon);
            this.isCoreuser = newUser.isCoreuser;
            this.gameAttr = newUser.gameAttr;
            this.isInterestman = newUser.isInterestman;
            this.global = newUser.global;
            this.freeFlag = newUser.freeFlag;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public NewUser build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new NewUser(this, z, null) : (NewUser) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1278795928, "Lprotobuf/NewUser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1278795928, "Lprotobuf/NewUser;");
                return;
            }
        }
        DEFAULT_USERID = 0L;
        DEFAULT_USERSEX = 0;
        DEFAULT_USERSTATUS = 0;
        DEFAULT_MEIZHILEVEL = 0;
        DEFAULT_SUPERBOY = 0;
        DEFAULT_ISTENYEAR = 0;
        DEFAULT_ISGROUPOWNER = 0;
        DEFAULT_USERTYPE = 0;
        DEFAULT_USESIG = 0;
        DEFAULT_ISSHENGYOU = 0;
        DEFAULT_ISHARDWORKING = 0;
        DEFAULT_APPRAISE = Collections.emptyList();
        DEFAULT_ISMEMBER = 0;
        DEFAULT_ISPASSER = 0;
        DEFAULT_ISQUNSPRING = 0;
        DEFAULT_NOTICEMASK = Collections.emptyList();
        DEFAULT_RPGOLDICON = Collections.emptyList();
        DEFAULT_TBMALLMONTHICON = Collections.emptyList();
    }

    public /* synthetic */ NewUser(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUser(Builder builder, boolean z) {
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
            String str = builder.userName;
            if (str == null) {
                this.userName = "";
            } else {
                this.userName = str;
            }
            Integer num = builder.userSex;
            if (num == null) {
                this.userSex = DEFAULT_USERSEX;
            } else {
                this.userSex = num;
            }
            Integer num2 = builder.userStatus;
            if (num2 == null) {
                this.userStatus = DEFAULT_USERSTATUS;
            } else {
                this.userStatus = num2;
            }
            Integer num3 = builder.meizhiLevel;
            if (num3 == null) {
                this.meizhiLevel = DEFAULT_MEIZHILEVEL;
            } else {
                this.meizhiLevel = num3;
            }
            Integer num4 = builder.superboy;
            if (num4 == null) {
                this.superboy = DEFAULT_SUPERBOY;
            } else {
                this.superboy = num4;
            }
            String str2 = builder.card;
            if (str2 == null) {
                this.card = "";
            } else {
                this.card = str2;
            }
            this.parrProps = builder.parrProps;
            this.mParrProps = builder.mParrProps;
            this.wapRn = builder.wapRn;
            Integer num5 = builder.isTenyear;
            if (num5 == null) {
                this.isTenyear = DEFAULT_ISTENYEAR;
            } else {
                this.isTenyear = num5;
            }
            Integer num6 = builder.isGroupOwner;
            if (num6 == null) {
                this.isGroupOwner = DEFAULT_ISGROUPOWNER;
            } else {
                this.isGroupOwner = num6;
            }
            this.parrScores = builder.parrScores;
            Integer num7 = builder.userType;
            if (num7 == null) {
                this.userType = DEFAULT_USERTYPE;
            } else {
                this.userType = num7;
            }
            Integer num8 = builder.useSig;
            if (num8 == null) {
                this.useSig = DEFAULT_USESIG;
            } else {
                this.useSig = num8;
            }
            String str3 = builder.paper;
            if (str3 == null) {
                this.paper = "";
            } else {
                this.paper = str3;
            }
            String str4 = builder.bgId;
            if (str4 == null) {
                this.bgId = "";
            } else {
                this.bgId = str4;
            }
            Integer num9 = builder.isShengyou;
            if (num9 == null) {
                this.isShengyou = DEFAULT_ISSHENGYOU;
            } else {
                this.isShengyou = num9;
            }
            Integer num10 = builder.isHardworking;
            if (num10 == null) {
                this.isHardworking = DEFAULT_ISHARDWORKING;
            } else {
                this.isHardworking = num10;
            }
            String str5 = builder.billboard;
            if (str5 == null) {
                this.billboard = "";
            } else {
                this.billboard = str5;
            }
            String str6 = builder.portraitTime;
            if (str6 == null) {
                this.portraitTime = "";
            } else {
                this.portraitTime = str6;
            }
            List<Props> list = builder.appraise;
            if (list == null) {
                this.appraise = DEFAULT_APPRAISE;
            } else {
                this.appraise = Message.immutableCopyOf(list);
            }
            String str7 = builder.tbscoreRepeateFinishTime;
            if (str7 == null) {
                this.tbscoreRepeateFinishTime = "";
            } else {
                this.tbscoreRepeateFinishTime = str7;
            }
            Integer num11 = builder.isMember;
            if (num11 == null) {
                this.isMember = DEFAULT_ISMEMBER;
            } else {
                this.isMember = num11;
            }
            Integer num12 = builder.isPasser;
            if (num12 == null) {
                this.isPasser = DEFAULT_ISPASSER;
            } else {
                this.isPasser = num12;
            }
            Integer num13 = builder.isQunSpring;
            if (num13 == null) {
                this.isQunSpring = DEFAULT_ISQUNSPRING;
            } else {
                this.isQunSpring = num13;
            }
            List<NoticeMask> list2 = builder.noticeMask;
            if (list2 == null) {
                this.noticeMask = DEFAULT_NOTICEMASK;
            } else {
                this.noticeMask = Message.immutableCopyOf(list2);
            }
            List<Rpgoldicon> list3 = builder.rpgoldicon;
            if (list3 == null) {
                this.rpgoldicon = DEFAULT_RPGOLDICON;
            } else {
                this.rpgoldicon = Message.immutableCopyOf(list3);
            }
            String str8 = builder.isDoudizhu;
            if (str8 == null) {
                this.isDoudizhu = "";
            } else {
                this.isDoudizhu = str8;
            }
            String str9 = builder.cdnError;
            if (str9 == null) {
                this.cdnError = "";
            } else {
                this.cdnError = str9;
            }
            List<TbmallMonthIcon> list4 = builder.tbmallMonthIcon;
            if (list4 == null) {
                this.tbmallMonthIcon = DEFAULT_TBMALLMONTHICON;
            } else {
                this.tbmallMonthIcon = Message.immutableCopyOf(list4);
            }
            String str10 = builder.isCoreuser;
            if (str10 == null) {
                this.isCoreuser = "";
            } else {
                this.isCoreuser = str10;
            }
            this.gameAttr = builder.gameAttr;
            String str11 = builder.isInterestman;
            if (str11 == null) {
                this.isInterestman = "";
            } else {
                this.isInterestman = str11;
            }
            this.global = builder.global;
            String str12 = builder.freeFlag;
            if (str12 == null) {
                this.freeFlag = "";
                return;
            } else {
                this.freeFlag = str12;
                return;
            }
        }
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.userSex = builder.userSex;
        this.userStatus = builder.userStatus;
        this.meizhiLevel = builder.meizhiLevel;
        this.superboy = builder.superboy;
        this.card = builder.card;
        this.parrProps = builder.parrProps;
        this.mParrProps = builder.mParrProps;
        this.wapRn = builder.wapRn;
        this.isTenyear = builder.isTenyear;
        this.isGroupOwner = builder.isGroupOwner;
        this.parrScores = builder.parrScores;
        this.userType = builder.userType;
        this.useSig = builder.useSig;
        this.paper = builder.paper;
        this.bgId = builder.bgId;
        this.isShengyou = builder.isShengyou;
        this.isHardworking = builder.isHardworking;
        this.billboard = builder.billboard;
        this.portraitTime = builder.portraitTime;
        this.appraise = Message.immutableCopyOf(builder.appraise);
        this.tbscoreRepeateFinishTime = builder.tbscoreRepeateFinishTime;
        this.isMember = builder.isMember;
        this.isPasser = builder.isPasser;
        this.isQunSpring = builder.isQunSpring;
        this.noticeMask = Message.immutableCopyOf(builder.noticeMask);
        this.rpgoldicon = Message.immutableCopyOf(builder.rpgoldicon);
        this.isDoudizhu = builder.isDoudizhu;
        this.cdnError = builder.cdnError;
        this.tbmallMonthIcon = Message.immutableCopyOf(builder.tbmallMonthIcon);
        this.isCoreuser = builder.isCoreuser;
        this.gameAttr = builder.gameAttr;
        this.isInterestman = builder.isInterestman;
        this.global = builder.global;
        this.freeFlag = builder.freeFlag;
    }
}
