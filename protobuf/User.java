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
public final class User extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_AGREENUM;
    public static final String DEFAULT_APPEALTHREADPOPOVER = "";
    public static final String DEFAULT_BAWUTYPE = "";
    public static final String DEFAULT_BGPIC = "";
    public static final Integer DEFAULT_BIMGENDTIME;
    public static final String DEFAULT_BIMGURL = "";
    public static final Integer DEFAULT_BOOKMARKCOUNT;
    public static final Integer DEFAULT_BOOKMARKNEWCOUNT;
    public static final Integer DEFAULT_CANMODIFYAVATAR;
    public static final Integer DEFAULT_CONCERNNUM;
    public static final Integer DEFAULT_DISPLAYAUTHTYPE;
    public static final Integer DEFAULT_EACHOTHERFRIEND;
    public static final String DEFAULT_FANSNICKNAME = "";
    public static final Integer DEFAULT_FANSNUM;
    public static final Integer DEFAULT_FAVORITENUM;
    public static final String DEFAULT_FOLLOWFROM = "";
    public static final List<ForumToolPerm> DEFAULT_FORUMTOOLAUTH;
    public static final Long DEFAULT_FRIENDNUM;
    public static final Integer DEFAULT_GENDER;
    public static final List<GiftInfo> DEFAULT_GIFTLIST;
    public static final Integer DEFAULT_GIFTNUM;
    public static final List<MyGroupInfo> DEFAULT_GROUPLIST;
    public static final Integer DEFAULT_HASBOTTLEENTER;
    public static final Integer DEFAULT_HASCONCERNED;
    public static final Integer DEFAULT_HEAVYUSER;
    public static final List<Icon> DEFAULT_ICONINFO;
    public static final Long DEFAULT_ID;
    public static final Integer DEFAULT_INFLUENCE;
    public static final String DEFAULT_INTRO = "";
    public static final String DEFAULT_IOSBIMGFORMAT = "";
    public static final String DEFAULT_IP = "";
    public static final Integer DEFAULT_ISBAWU;
    public static final Integer DEFAULT_ISCOREUSER;
    public static final Integer DEFAULT_ISDEFAULTAVATAR;
    public static final Integer DEFAULT_ISFANS;
    public static final Integer DEFAULT_ISFRIEND;
    public static final Integer DEFAULT_ISGUANFANG;
    public static final Integer DEFAULT_ISHUINIBUKE;
    public static final Integer DEFAULT_ISINTERESTMAN;
    public static final Integer DEFAULT_ISINVITED;
    public static final Integer DEFAULT_ISLIKE;
    public static final Integer DEFAULT_ISLOGIN;
    public static final Integer DEFAULT_ISMANAGER;
    public static final Integer DEFAULT_ISMASK;
    public static final Integer DEFAULT_ISMEM;
    public static final Integer DEFAULT_ISSELECTTAIL;
    public static final Integer DEFAULT_ISSHOWREDPACKET;
    public static final Integer DEFAULT_ISVERIFY;
    public static final Integer DEFAULT_ISVIDEOBIGGIE;
    public static final Integer DEFAULT_LEFTCALLNUM;
    public static final Integer DEFAULT_LEVELID;
    public static final String DEFAULT_LEVELINFLUENCE = "";
    public static final String DEFAULT_LEVELNAME = "";
    public static final List<LikeForumInfo> DEFAULT_LIKEFORUM;
    public static final List<BazhuSign> DEFAULT_MANAGERFORUM;
    public static final Integer DEFAULT_MEIZHILEVEL;
    public static final String DEFAULT_MODIFYAVATARDESC = "";
    public static final List<SimpleUser> DEFAULT_MUTEUSER;
    public static final Integer DEFAULT_MYLIKENUM;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAMESHOW = "";
    public static final List<TshowInfo> DEFAULT_NEWTSHOWICON;
    public static final Integer DEFAULT_NICKNAMEUPDATETIME;
    public static final Integer DEFAULT_NOPOSTHIGH;
    public static final Integer DEFAULT_NOUN;
    public static final String DEFAULT_PASSWD = "";
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_PORTRAITH = "";
    public static final Integer DEFAULT_POSTNUM;
    public static final Integer DEFAULT_PRIVTHREAD;
    public static final List<TwAnchorProfitItem> DEFAULT_PROFITLIST;
    public static final String DEFAULT_RANK = "";
    public static final String DEFAULT_SEALPREFIX = "";
    public static final Integer DEFAULT_SEX;
    public static final Integer DEFAULT_SHOWPBPRIVATEFLAG;
    public static final String DEFAULT_TBAGE = "";
    public static final Integer DEFAULT_THREADNUM;
    public static final String DEFAULT_TIEBAUID = "";
    public static final Integer DEFAULT_TOTALAGREENUM;
    public static final Integer DEFAULT_TOTALVISITORNUM;
    public static final List<TshowInfo> DEFAULT_TSHOWICON;
    public static final Integer DEFAULT_TYPE;
    public static final String DEFAULT_UK = "";
    public static final Integer DEFAULT_USERHIDE;
    public static final List<UserPics> DEFAULT_USERPICS;
    public static final Integer DEFAULT_USERTYPE;
    public static final Integer DEFAULT_VISITORNUM;
    public static final Integer DEFAULT_WORKNUM;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 71)
    public final ActivitySponsor activitySponsor;
    @ProtoField(tag = 88, type = Message.Datatype.INT32)
    public final Integer agreeNum;
    @ProtoField(tag = 78)
    public final AlaUserInfo alaInfo;
    @ProtoField(tag = 85)
    public final AlaLiveInfo alaLiveInfo;
    @ProtoField(tag = 112, type = Message.Datatype.STRING)
    public final String appealThreadPopover;
    @ProtoField(tag = 95)
    public final BaijiahaoInfo baijiahaoInfo;
    @ProtoField(tag = 10)
    public final Balv balv;
    @ProtoField(tag = 103)
    public final BawuThrones bawuThrones;
    @ProtoField(tag = 26, type = Message.Datatype.STRING)
    public final String bawuType;
    @ProtoField(tag = 105)
    public final BazhuSign bazhuGrade;
    @ProtoField(tag = 58, type = Message.Datatype.STRING)
    public final String bgPic;
    @ProtoField(tag = 40, type = Message.Datatype.INT32)
    public final Integer bimgEndTime;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String bimgUrl;
    @ProtoField(tag = 96)
    public final BirthdayInfo birthdayInfo;
    @ProtoField(tag = 53, type = Message.Datatype.INT32)
    public final Integer bookmarkCount;
    @ProtoField(tag = 54, type = Message.Datatype.INT32)
    public final Integer bookmarkNewCount;
    @ProtoField(tag = 111)
    public final BusinessAccountInfo businessAccountInfo;
    @ProtoField(tag = 104)
    public final CallFansInfo callFansInfo;
    @ProtoField(tag = 97, type = Message.Datatype.INT32)
    public final Integer canModifyAvatar;
    @ProtoField(tag = 31, type = Message.Datatype.INT32)
    public final Integer concernNum;
    @ProtoField(tag = 68)
    public final ConsumeInfo consumeInfo;
    @ProtoField(tag = 108)
    public final CreationData creationData;
    @ProtoField(tag = 123, type = Message.Datatype.INT32)
    public final Integer displayAuthType;
    @ProtoField(tag = 83, type = Message.Datatype.INT32)
    public final Integer eachOtherFriend;
    @ProtoField(tag = 74)
    public final Ecom ecom;
    @ProtoField(tag = 126)
    public final EditConfig editConfig;
    @ProtoField(tag = 84)
    public final EsportInfo esportData;
    @ProtoField(tag = 57, type = Message.Datatype.STRING)
    public final String fansNickname;
    @ProtoField(tag = 30, type = Message.Datatype.INT32)
    public final Integer fansNum;
    @ProtoField(tag = 109, type = Message.Datatype.INT32)
    public final Integer favoriteNum;
    @ProtoField(tag = 121, type = Message.Datatype.STRING)
    public final String followFrom;
    @ProtoField(label = Message.Label.REPEATED, tag = 113)
    public final List<ForumToolPerm> forumToolAuth;
    @ProtoField(tag = 56, type = Message.Datatype.INT64)
    public final Long friendNum;
    @ProtoField(tag = 42, type = Message.Datatype.INT32)
    public final Integer gender;
    @ProtoField(label = Message.Label.REPEATED, tag = 50)
    public final List<GiftInfo> giftList;
    @ProtoField(tag = 49, type = Message.Datatype.INT32)
    public final Integer giftNum;
    @ProtoField(tag = 62)
    public final GodInfo godData;
    @ProtoField(label = Message.Label.REPEATED, tag = 48)
    public final List<MyGroupInfo> groupList;
    @ProtoField(tag = 80, type = Message.Datatype.INT32)
    public final Integer hasBottleEnter;
    @ProtoField(tag = 35, type = Message.Datatype.INT32)
    public final Integer hasConcerned;
    @ProtoField(tag = 63, type = Message.Datatype.INT32)
    public final Integer heavyUser;
    @ProtoField(label = Message.Label.REPEATED, tag = 17)
    public final List<Icon> iconinfo;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 99, type = Message.Datatype.INT32)
    public final Integer influence;
    @ProtoField(tag = 34, type = Message.Datatype.STRING)
    public final String intro;
    @ProtoField(tag = 22, type = Message.Datatype.STRING)
    public final String iosBimgFormat;
    @ProtoField(tag = 28, type = Message.Datatype.STRING)
    public final String ip;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer isBawu;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer isCoreuser;
    @ProtoField(tag = 106, type = Message.Datatype.INT32)
    public final Integer isDefaultAvatar;
    @ProtoField(tag = 91, type = Message.Datatype.INT32)
    public final Integer isFans;
    @ProtoField(tag = 46, type = Message.Datatype.INT32)
    public final Integer isFriend;
    @ProtoField(tag = 52, type = Message.Datatype.INT32)
    public final Integer isGuanfang;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer isHuinibuke;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer isInterestman;
    @ProtoField(tag = 90, type = Message.Datatype.INT32)
    public final Integer isInvited;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer isLike;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer isLogin;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer isManager;
    @ProtoField(tag = 43, type = Message.Datatype.INT32)
    public final Integer isMask;
    @ProtoField(tag = 39, type = Message.Datatype.INT32)
    public final Integer isMem;
    @ProtoField(tag = 51, type = Message.Datatype.INT32)
    public final Integer isSelectTail;
    @ProtoField(tag = 94, type = Message.Datatype.INT32)
    public final Integer isShowRedpacket;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer isVerify;
    @ProtoField(tag = 93, type = Message.Datatype.INT32)
    public final Integer isVideobiggie;
    @ProtoField(tag = 89, type = Message.Datatype.INT32)
    public final Integer leftCallNum;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer levelId;
    @ProtoField(tag = 100, type = Message.Datatype.STRING)
    public final String levelInfluence;
    @ProtoField(tag = 125, type = Message.Datatype.STRING)
    public final String levelName;
    @ProtoField(label = Message.Label.REPEATED, tag = 47)
    public final List<LikeForumInfo> likeForum;
    @ProtoField(tag = 110)
    public final LiveRoomInfo liveRoomInfo;
    @ProtoField(label = Message.Label.REPEATED, tag = 122)
    public final List<BazhuSign> managerForum;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer meizhiLevel;
    @ProtoField(tag = 98, type = Message.Datatype.STRING)
    public final String modifyAvatarDesc;
    @ProtoField(label = Message.Label.REPEATED, tag = 55)
    public final List<SimpleUser> muteUser;
    @ProtoField(tag = 33, type = Message.Datatype.INT32)
    public final Integer myLikeNum;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String nameShow;
    @ProtoField(tag = 101)
    public final NewGodInfo newGodData;
    @ProtoField(label = Message.Label.REPEATED, tag = 65)
    public final List<TshowInfo> newTshowIcon;
    @ProtoField(tag = 8)
    public final NewUser newUserInfo;
    @ProtoField(tag = 86, type = Message.Datatype.INT32)
    public final Integer nicknameUpdateTime;
    @ProtoField(tag = 73, type = Message.Datatype.UINT32)
    public final Integer noPostHigh;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer noUn;
    @ProtoField(tag = 60)
    public final NovelFansInfo novelFansInfo;
    @ProtoField(tag = 59)
    public final NewParrScores parrScores;
    @ProtoField(tag = 36, type = Message.Datatype.STRING)
    public final String passwd;
    @ProtoField(tag = 41)
    public final PayMemberInfo payMemberInfo;
    @ProtoField(tag = 77)
    public final Pendant pendant;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 27, type = Message.Datatype.STRING)
    public final String portraith;
    @ProtoField(tag = 37, type = Message.Datatype.INT32)
    public final Integer postNum;
    @ProtoField(tag = 45)
    public final PrivSets privSets;
    @ProtoField(tag = 92, type = Message.Datatype.INT32)
    public final Integer privThread;
    @ProtoField(label = Message.Label.REPEATED, tag = 67)
    public final List<TwAnchorProfitItem> profitList;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String rank;
    @ProtoField(tag = 79, type = Message.Datatype.STRING)
    public final String sealPrefix;
    @ProtoField(tag = 32, type = Message.Datatype.INT32)
    public final Integer sex;
    @ProtoField(tag = 117, type = Message.Datatype.INT32)
    public final Integer showPbPrivateFlag;
    @ProtoField(tag = 82)
    public final SpringVirtualUser springVirtualUser;
    @ProtoField(tag = 38, type = Message.Datatype.STRING)
    public final String tbAge;
    @ProtoField(tag = 72)
    public final TbVipInfo tbVip;
    @ProtoField(tag = 69)
    public final ThemeCardInUser themeCard;
    @ProtoField(tag = 87, type = Message.Datatype.INT32)
    public final Integer threadNum;
    @ProtoField(tag = 120, type = Message.Datatype.STRING)
    public final String tiebaUid;
    @ProtoField(tag = 118, type = Message.Datatype.UINT32)
    public final Integer totalAgreeNum;
    @ProtoField(tag = 76, type = Message.Datatype.INT32)
    public final Integer totalVisitorNum;
    @ProtoField(label = Message.Label.REPEATED, tag = 18)
    public final List<TshowInfo> tshowIcon;
    @ProtoField(tag = 66)
    public final TwZhiBoUser twAnchorInfo;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 107, type = Message.Datatype.STRING)
    public final String uk;
    @ProtoField(label = Message.Label.REPEATED, tag = 44)
    public final List<UserPics> userPics;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer userType;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer userhide;
    @ProtoField(tag = 81)
    public final UserVideoChannelInfo videoChannelInfo;
    @ProtoField(tag = 70)
    public final VipCloseAd vipCloseAd;
    @ProtoField(tag = 61)
    public final UserVipInfo vipInfo;
    @ProtoField(tag = 64)
    public final VipShowInfo vipShowInfo;
    @ProtoField(tag = 75, type = Message.Datatype.INT32)
    public final Integer visitorNum;
    @ProtoField(tag = 124)
    public final WorkCreatorInfo workCreatorInfo;
    @ProtoField(tag = 116, type = Message.Datatype.UINT32)
    public final Integer workNum;
    @ProtoField(tag = 119)
    public final CreationData workcreationData;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<User> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ActivitySponsor activitySponsor;
        public Integer agreeNum;
        public AlaUserInfo alaInfo;
        public AlaLiveInfo alaLiveInfo;
        public String appealThreadPopover;
        public BaijiahaoInfo baijiahaoInfo;
        public Balv balv;
        public BawuThrones bawuThrones;
        public String bawuType;
        public BazhuSign bazhuGrade;
        public String bgPic;
        public Integer bimgEndTime;
        public String bimgUrl;
        public BirthdayInfo birthdayInfo;
        public Integer bookmarkCount;
        public Integer bookmarkNewCount;
        public BusinessAccountInfo businessAccountInfo;
        public CallFansInfo callFansInfo;
        public Integer canModifyAvatar;
        public Integer concernNum;
        public ConsumeInfo consumeInfo;
        public CreationData creationData;
        public Integer displayAuthType;
        public Integer eachOtherFriend;
        public Ecom ecom;
        public EditConfig editConfig;
        public EsportInfo esportData;
        public String fansNickname;
        public Integer fansNum;
        public Integer favoriteNum;
        public String followFrom;
        public List<ForumToolPerm> forumToolAuth;
        public Long friendNum;
        public Integer gender;
        public List<GiftInfo> giftList;
        public Integer giftNum;
        public GodInfo godData;
        public List<MyGroupInfo> groupList;
        public Integer hasBottleEnter;
        public Integer hasConcerned;
        public Integer heavyUser;
        public List<Icon> iconinfo;
        public Long id;
        public Integer influence;
        public String intro;
        public String iosBimgFormat;
        public String ip;
        public Integer isBawu;
        public Integer isCoreuser;
        public Integer isDefaultAvatar;
        public Integer isFans;
        public Integer isFriend;
        public Integer isGuanfang;
        public Integer isHuinibuke;
        public Integer isInterestman;
        public Integer isInvited;
        public Integer isLike;
        public Integer isLogin;
        public Integer isManager;
        public Integer isMask;
        public Integer isMem;
        public Integer isSelectTail;
        public Integer isShowRedpacket;
        public Integer isVerify;
        public Integer isVideobiggie;
        public Integer leftCallNum;
        public Integer levelId;
        public String levelInfluence;
        public String levelName;
        public List<LikeForumInfo> likeForum;
        public LiveRoomInfo liveRoomInfo;
        public List<BazhuSign> managerForum;
        public Integer meizhiLevel;
        public String modifyAvatarDesc;
        public List<SimpleUser> muteUser;
        public Integer myLikeNum;
        public String name;
        public String nameShow;
        public NewGodInfo newGodData;
        public List<TshowInfo> newTshowIcon;
        public NewUser newUserInfo;
        public Integer nicknameUpdateTime;
        public Integer noPostHigh;
        public Integer noUn;
        public NovelFansInfo novelFansInfo;
        public NewParrScores parrScores;
        public String passwd;
        public PayMemberInfo payMemberInfo;
        public Pendant pendant;
        public String portrait;
        public String portraith;
        public Integer postNum;
        public PrivSets privSets;
        public Integer privThread;
        public List<TwAnchorProfitItem> profitList;
        public String rank;
        public String sealPrefix;
        public Integer sex;
        public Integer showPbPrivateFlag;
        public SpringVirtualUser springVirtualUser;
        public String tbAge;
        public TbVipInfo tbVip;
        public ThemeCardInUser themeCard;
        public Integer threadNum;
        public String tiebaUid;
        public Integer totalAgreeNum;
        public Integer totalVisitorNum;
        public List<TshowInfo> tshowIcon;
        public TwZhiBoUser twAnchorInfo;
        public Integer type;
        public String uk;
        public List<UserPics> userPics;
        public Integer userType;
        public Integer userhide;
        public UserVideoChannelInfo videoChannelInfo;
        public VipCloseAd vipCloseAd;
        public UserVipInfo vipInfo;
        public VipShowInfo vipShowInfo;
        public Integer visitorNum;
        public WorkCreatorInfo workCreatorInfo;
        public Integer workNum;
        public CreationData workcreationData;

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
        public Builder(User user) {
            super(user);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {user};
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
            if (user == null) {
                return;
            }
            this.isLogin = user.isLogin;
            this.id = user.id;
            this.name = user.name;
            this.nameShow = user.nameShow;
            this.portrait = user.portrait;
            this.noUn = user.noUn;
            this.type = user.type;
            this.newUserInfo = user.newUserInfo;
            this.userhide = user.userhide;
            this.balv = user.balv;
            this.isManager = user.isManager;
            this.rank = user.rank;
            this.bimgUrl = user.bimgUrl;
            this.meizhiLevel = user.meizhiLevel;
            this.isVerify = user.isVerify;
            this.isInterestman = user.isInterestman;
            this.iconinfo = Message.copyOf(user.iconinfo);
            this.tshowIcon = Message.copyOf(user.tshowIcon);
            this.userType = user.userType;
            this.isCoreuser = user.isCoreuser;
            this.isHuinibuke = user.isHuinibuke;
            this.iosBimgFormat = user.iosBimgFormat;
            this.levelId = user.levelId;
            this.isLike = user.isLike;
            this.isBawu = user.isBawu;
            this.bawuType = user.bawuType;
            this.portraith = user.portraith;
            this.ip = user.ip;
            this.fansNum = user.fansNum;
            this.concernNum = user.concernNum;
            this.sex = user.sex;
            this.myLikeNum = user.myLikeNum;
            this.intro = user.intro;
            this.hasConcerned = user.hasConcerned;
            this.passwd = user.passwd;
            this.postNum = user.postNum;
            this.tbAge = user.tbAge;
            this.isMem = user.isMem;
            this.bimgEndTime = user.bimgEndTime;
            this.payMemberInfo = user.payMemberInfo;
            this.gender = user.gender;
            this.isMask = user.isMask;
            this.userPics = Message.copyOf(user.userPics);
            this.privSets = user.privSets;
            this.isFriend = user.isFriend;
            this.likeForum = Message.copyOf(user.likeForum);
            this.groupList = Message.copyOf(user.groupList);
            this.giftNum = user.giftNum;
            this.giftList = Message.copyOf(user.giftList);
            this.isSelectTail = user.isSelectTail;
            this.isGuanfang = user.isGuanfang;
            this.bookmarkCount = user.bookmarkCount;
            this.bookmarkNewCount = user.bookmarkNewCount;
            this.muteUser = Message.copyOf(user.muteUser);
            this.friendNum = user.friendNum;
            this.fansNickname = user.fansNickname;
            this.bgPic = user.bgPic;
            this.parrScores = user.parrScores;
            this.novelFansInfo = user.novelFansInfo;
            this.vipInfo = user.vipInfo;
            this.godData = user.godData;
            this.heavyUser = user.heavyUser;
            this.vipShowInfo = user.vipShowInfo;
            this.newTshowIcon = Message.copyOf(user.newTshowIcon);
            this.twAnchorInfo = user.twAnchorInfo;
            this.profitList = Message.copyOf(user.profitList);
            this.consumeInfo = user.consumeInfo;
            this.themeCard = user.themeCard;
            this.vipCloseAd = user.vipCloseAd;
            this.activitySponsor = user.activitySponsor;
            this.tbVip = user.tbVip;
            this.noPostHigh = user.noPostHigh;
            this.ecom = user.ecom;
            this.visitorNum = user.visitorNum;
            this.totalVisitorNum = user.totalVisitorNum;
            this.pendant = user.pendant;
            this.alaInfo = user.alaInfo;
            this.sealPrefix = user.sealPrefix;
            this.hasBottleEnter = user.hasBottleEnter;
            this.videoChannelInfo = user.videoChannelInfo;
            this.springVirtualUser = user.springVirtualUser;
            this.eachOtherFriend = user.eachOtherFriend;
            this.esportData = user.esportData;
            this.alaLiveInfo = user.alaLiveInfo;
            this.nicknameUpdateTime = user.nicknameUpdateTime;
            this.threadNum = user.threadNum;
            this.agreeNum = user.agreeNum;
            this.leftCallNum = user.leftCallNum;
            this.isInvited = user.isInvited;
            this.isFans = user.isFans;
            this.privThread = user.privThread;
            this.isVideobiggie = user.isVideobiggie;
            this.isShowRedpacket = user.isShowRedpacket;
            this.baijiahaoInfo = user.baijiahaoInfo;
            this.birthdayInfo = user.birthdayInfo;
            this.canModifyAvatar = user.canModifyAvatar;
            this.modifyAvatarDesc = user.modifyAvatarDesc;
            this.influence = user.influence;
            this.levelInfluence = user.levelInfluence;
            this.newGodData = user.newGodData;
            this.bawuThrones = user.bawuThrones;
            this.callFansInfo = user.callFansInfo;
            this.bazhuGrade = user.bazhuGrade;
            this.isDefaultAvatar = user.isDefaultAvatar;
            this.uk = user.uk;
            this.creationData = user.creationData;
            this.favoriteNum = user.favoriteNum;
            this.liveRoomInfo = user.liveRoomInfo;
            this.businessAccountInfo = user.businessAccountInfo;
            this.appealThreadPopover = user.appealThreadPopover;
            this.forumToolAuth = Message.copyOf(user.forumToolAuth);
            this.workNum = user.workNum;
            this.showPbPrivateFlag = user.showPbPrivateFlag;
            this.totalAgreeNum = user.totalAgreeNum;
            this.workcreationData = user.workcreationData;
            this.tiebaUid = user.tiebaUid;
            this.followFrom = user.followFrom;
            this.managerForum = Message.copyOf(user.managerForum);
            this.displayAuthType = user.displayAuthType;
            this.workCreatorInfo = user.workCreatorInfo;
            this.levelName = user.levelName;
            this.editConfig = user.editConfig;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public User build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new User(this, z, null) : (User) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(317941112, "Lprotobuf/User;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(317941112, "Lprotobuf/User;");
                return;
            }
        }
        DEFAULT_ISLOGIN = 0;
        DEFAULT_ID = 0L;
        DEFAULT_NOUN = 0;
        DEFAULT_TYPE = 0;
        DEFAULT_USERHIDE = 0;
        DEFAULT_ISMANAGER = 0;
        DEFAULT_MEIZHILEVEL = 0;
        DEFAULT_ISVERIFY = 0;
        DEFAULT_ISINTERESTMAN = 0;
        DEFAULT_ICONINFO = Collections.emptyList();
        DEFAULT_TSHOWICON = Collections.emptyList();
        DEFAULT_USERTYPE = 0;
        DEFAULT_ISCOREUSER = 0;
        DEFAULT_ISHUINIBUKE = 0;
        DEFAULT_LEVELID = 0;
        DEFAULT_ISLIKE = 0;
        DEFAULT_ISBAWU = 0;
        DEFAULT_FANSNUM = 0;
        DEFAULT_CONCERNNUM = 0;
        DEFAULT_SEX = 0;
        DEFAULT_MYLIKENUM = 0;
        DEFAULT_HASCONCERNED = 0;
        DEFAULT_POSTNUM = 0;
        DEFAULT_ISMEM = 0;
        DEFAULT_BIMGENDTIME = 0;
        DEFAULT_GENDER = 0;
        DEFAULT_ISMASK = 0;
        DEFAULT_USERPICS = Collections.emptyList();
        DEFAULT_ISFRIEND = 0;
        DEFAULT_LIKEFORUM = Collections.emptyList();
        DEFAULT_GROUPLIST = Collections.emptyList();
        DEFAULT_GIFTNUM = 0;
        DEFAULT_GIFTLIST = Collections.emptyList();
        DEFAULT_ISSELECTTAIL = 0;
        DEFAULT_ISGUANFANG = 0;
        DEFAULT_BOOKMARKCOUNT = 0;
        DEFAULT_BOOKMARKNEWCOUNT = 0;
        DEFAULT_MUTEUSER = Collections.emptyList();
        DEFAULT_FRIENDNUM = 0L;
        DEFAULT_HEAVYUSER = 0;
        DEFAULT_NEWTSHOWICON = Collections.emptyList();
        DEFAULT_PROFITLIST = Collections.emptyList();
        DEFAULT_NOPOSTHIGH = 0;
        DEFAULT_VISITORNUM = 0;
        DEFAULT_TOTALVISITORNUM = 0;
        DEFAULT_HASBOTTLEENTER = 0;
        DEFAULT_EACHOTHERFRIEND = 0;
        DEFAULT_NICKNAMEUPDATETIME = 0;
        DEFAULT_THREADNUM = 0;
        DEFAULT_AGREENUM = 0;
        DEFAULT_LEFTCALLNUM = 0;
        DEFAULT_ISINVITED = 0;
        DEFAULT_ISFANS = 0;
        DEFAULT_PRIVTHREAD = 0;
        DEFAULT_ISVIDEOBIGGIE = 0;
        DEFAULT_ISSHOWREDPACKET = 0;
        DEFAULT_CANMODIFYAVATAR = 0;
        DEFAULT_INFLUENCE = 0;
        DEFAULT_ISDEFAULTAVATAR = 0;
        DEFAULT_FAVORITENUM = 0;
        DEFAULT_FORUMTOOLAUTH = Collections.emptyList();
        DEFAULT_WORKNUM = 0;
        DEFAULT_SHOWPBPRIVATEFLAG = 0;
        DEFAULT_TOTALAGREENUM = 0;
        DEFAULT_MANAGERFORUM = Collections.emptyList();
        DEFAULT_DISPLAYAUTHTYPE = 0;
    }

    public /* synthetic */ User(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public User(Builder builder, boolean z) {
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
            Integer num = builder.isLogin;
            if (num == null) {
                this.isLogin = DEFAULT_ISLOGIN;
            } else {
                this.isLogin = num;
            }
            Long l = builder.id;
            if (l == null) {
                this.id = DEFAULT_ID;
            } else {
                this.id = l;
            }
            String str = builder.name;
            if (str == null) {
                this.name = "";
            } else {
                this.name = str;
            }
            String str2 = builder.nameShow;
            if (str2 == null) {
                this.nameShow = "";
            } else {
                this.nameShow = str2;
            }
            String str3 = builder.portrait;
            if (str3 == null) {
                this.portrait = "";
            } else {
                this.portrait = str3;
            }
            Integer num2 = builder.noUn;
            if (num2 == null) {
                this.noUn = DEFAULT_NOUN;
            } else {
                this.noUn = num2;
            }
            Integer num3 = builder.type;
            if (num3 == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = num3;
            }
            this.newUserInfo = builder.newUserInfo;
            Integer num4 = builder.userhide;
            if (num4 == null) {
                this.userhide = DEFAULT_USERHIDE;
            } else {
                this.userhide = num4;
            }
            this.balv = builder.balv;
            Integer num5 = builder.isManager;
            if (num5 == null) {
                this.isManager = DEFAULT_ISMANAGER;
            } else {
                this.isManager = num5;
            }
            String str4 = builder.rank;
            if (str4 == null) {
                this.rank = "";
            } else {
                this.rank = str4;
            }
            String str5 = builder.bimgUrl;
            if (str5 == null) {
                this.bimgUrl = "";
            } else {
                this.bimgUrl = str5;
            }
            Integer num6 = builder.meizhiLevel;
            if (num6 == null) {
                this.meizhiLevel = DEFAULT_MEIZHILEVEL;
            } else {
                this.meizhiLevel = num6;
            }
            Integer num7 = builder.isVerify;
            if (num7 == null) {
                this.isVerify = DEFAULT_ISVERIFY;
            } else {
                this.isVerify = num7;
            }
            Integer num8 = builder.isInterestman;
            if (num8 == null) {
                this.isInterestman = DEFAULT_ISINTERESTMAN;
            } else {
                this.isInterestman = num8;
            }
            List<Icon> list = builder.iconinfo;
            if (list == null) {
                this.iconinfo = DEFAULT_ICONINFO;
            } else {
                this.iconinfo = Message.immutableCopyOf(list);
            }
            List<TshowInfo> list2 = builder.tshowIcon;
            if (list2 == null) {
                this.tshowIcon = DEFAULT_TSHOWICON;
            } else {
                this.tshowIcon = Message.immutableCopyOf(list2);
            }
            Integer num9 = builder.userType;
            if (num9 == null) {
                this.userType = DEFAULT_USERTYPE;
            } else {
                this.userType = num9;
            }
            Integer num10 = builder.isCoreuser;
            if (num10 == null) {
                this.isCoreuser = DEFAULT_ISCOREUSER;
            } else {
                this.isCoreuser = num10;
            }
            Integer num11 = builder.isHuinibuke;
            if (num11 == null) {
                this.isHuinibuke = DEFAULT_ISHUINIBUKE;
            } else {
                this.isHuinibuke = num11;
            }
            String str6 = builder.iosBimgFormat;
            if (str6 == null) {
                this.iosBimgFormat = "";
            } else {
                this.iosBimgFormat = str6;
            }
            Integer num12 = builder.levelId;
            if (num12 == null) {
                this.levelId = DEFAULT_LEVELID;
            } else {
                this.levelId = num12;
            }
            Integer num13 = builder.isLike;
            if (num13 == null) {
                this.isLike = DEFAULT_ISLIKE;
            } else {
                this.isLike = num13;
            }
            Integer num14 = builder.isBawu;
            if (num14 == null) {
                this.isBawu = DEFAULT_ISBAWU;
            } else {
                this.isBawu = num14;
            }
            String str7 = builder.bawuType;
            if (str7 == null) {
                this.bawuType = "";
            } else {
                this.bawuType = str7;
            }
            String str8 = builder.portraith;
            if (str8 == null) {
                this.portraith = "";
            } else {
                this.portraith = str8;
            }
            String str9 = builder.ip;
            if (str9 == null) {
                this.ip = "";
            } else {
                this.ip = str9;
            }
            Integer num15 = builder.fansNum;
            if (num15 == null) {
                this.fansNum = DEFAULT_FANSNUM;
            } else {
                this.fansNum = num15;
            }
            Integer num16 = builder.concernNum;
            if (num16 == null) {
                this.concernNum = DEFAULT_CONCERNNUM;
            } else {
                this.concernNum = num16;
            }
            Integer num17 = builder.sex;
            if (num17 == null) {
                this.sex = DEFAULT_SEX;
            } else {
                this.sex = num17;
            }
            Integer num18 = builder.myLikeNum;
            if (num18 == null) {
                this.myLikeNum = DEFAULT_MYLIKENUM;
            } else {
                this.myLikeNum = num18;
            }
            String str10 = builder.intro;
            if (str10 == null) {
                this.intro = "";
            } else {
                this.intro = str10;
            }
            Integer num19 = builder.hasConcerned;
            if (num19 == null) {
                this.hasConcerned = DEFAULT_HASCONCERNED;
            } else {
                this.hasConcerned = num19;
            }
            String str11 = builder.passwd;
            if (str11 == null) {
                this.passwd = "";
            } else {
                this.passwd = str11;
            }
            Integer num20 = builder.postNum;
            if (num20 == null) {
                this.postNum = DEFAULT_POSTNUM;
            } else {
                this.postNum = num20;
            }
            String str12 = builder.tbAge;
            if (str12 == null) {
                this.tbAge = "";
            } else {
                this.tbAge = str12;
            }
            Integer num21 = builder.isMem;
            if (num21 == null) {
                this.isMem = DEFAULT_ISMEM;
            } else {
                this.isMem = num21;
            }
            Integer num22 = builder.bimgEndTime;
            if (num22 == null) {
                this.bimgEndTime = DEFAULT_BIMGENDTIME;
            } else {
                this.bimgEndTime = num22;
            }
            this.payMemberInfo = builder.payMemberInfo;
            Integer num23 = builder.gender;
            if (num23 == null) {
                this.gender = DEFAULT_GENDER;
            } else {
                this.gender = num23;
            }
            Integer num24 = builder.isMask;
            if (num24 == null) {
                this.isMask = DEFAULT_ISMASK;
            } else {
                this.isMask = num24;
            }
            List<UserPics> list3 = builder.userPics;
            if (list3 == null) {
                this.userPics = DEFAULT_USERPICS;
            } else {
                this.userPics = Message.immutableCopyOf(list3);
            }
            this.privSets = builder.privSets;
            Integer num25 = builder.isFriend;
            if (num25 == null) {
                this.isFriend = DEFAULT_ISFRIEND;
            } else {
                this.isFriend = num25;
            }
            List<LikeForumInfo> list4 = builder.likeForum;
            if (list4 == null) {
                this.likeForum = DEFAULT_LIKEFORUM;
            } else {
                this.likeForum = Message.immutableCopyOf(list4);
            }
            List<MyGroupInfo> list5 = builder.groupList;
            if (list5 == null) {
                this.groupList = DEFAULT_GROUPLIST;
            } else {
                this.groupList = Message.immutableCopyOf(list5);
            }
            Integer num26 = builder.giftNum;
            if (num26 == null) {
                this.giftNum = DEFAULT_GIFTNUM;
            } else {
                this.giftNum = num26;
            }
            List<GiftInfo> list6 = builder.giftList;
            if (list6 == null) {
                this.giftList = DEFAULT_GIFTLIST;
            } else {
                this.giftList = Message.immutableCopyOf(list6);
            }
            Integer num27 = builder.isSelectTail;
            if (num27 == null) {
                this.isSelectTail = DEFAULT_ISSELECTTAIL;
            } else {
                this.isSelectTail = num27;
            }
            Integer num28 = builder.isGuanfang;
            if (num28 == null) {
                this.isGuanfang = DEFAULT_ISGUANFANG;
            } else {
                this.isGuanfang = num28;
            }
            Integer num29 = builder.bookmarkCount;
            if (num29 == null) {
                this.bookmarkCount = DEFAULT_BOOKMARKCOUNT;
            } else {
                this.bookmarkCount = num29;
            }
            Integer num30 = builder.bookmarkNewCount;
            if (num30 == null) {
                this.bookmarkNewCount = DEFAULT_BOOKMARKNEWCOUNT;
            } else {
                this.bookmarkNewCount = num30;
            }
            List<SimpleUser> list7 = builder.muteUser;
            if (list7 == null) {
                this.muteUser = DEFAULT_MUTEUSER;
            } else {
                this.muteUser = Message.immutableCopyOf(list7);
            }
            Long l2 = builder.friendNum;
            if (l2 == null) {
                this.friendNum = DEFAULT_FRIENDNUM;
            } else {
                this.friendNum = l2;
            }
            String str13 = builder.fansNickname;
            if (str13 == null) {
                this.fansNickname = "";
            } else {
                this.fansNickname = str13;
            }
            String str14 = builder.bgPic;
            if (str14 == null) {
                this.bgPic = "";
            } else {
                this.bgPic = str14;
            }
            this.parrScores = builder.parrScores;
            this.novelFansInfo = builder.novelFansInfo;
            this.vipInfo = builder.vipInfo;
            this.godData = builder.godData;
            Integer num31 = builder.heavyUser;
            if (num31 == null) {
                this.heavyUser = DEFAULT_HEAVYUSER;
            } else {
                this.heavyUser = num31;
            }
            this.vipShowInfo = builder.vipShowInfo;
            List<TshowInfo> list8 = builder.newTshowIcon;
            if (list8 == null) {
                this.newTshowIcon = DEFAULT_NEWTSHOWICON;
            } else {
                this.newTshowIcon = Message.immutableCopyOf(list8);
            }
            this.twAnchorInfo = builder.twAnchorInfo;
            List<TwAnchorProfitItem> list9 = builder.profitList;
            if (list9 == null) {
                this.profitList = DEFAULT_PROFITLIST;
            } else {
                this.profitList = Message.immutableCopyOf(list9);
            }
            this.consumeInfo = builder.consumeInfo;
            this.themeCard = builder.themeCard;
            this.vipCloseAd = builder.vipCloseAd;
            this.activitySponsor = builder.activitySponsor;
            this.tbVip = builder.tbVip;
            Integer num32 = builder.noPostHigh;
            if (num32 == null) {
                this.noPostHigh = DEFAULT_NOPOSTHIGH;
            } else {
                this.noPostHigh = num32;
            }
            this.ecom = builder.ecom;
            Integer num33 = builder.visitorNum;
            if (num33 == null) {
                this.visitorNum = DEFAULT_VISITORNUM;
            } else {
                this.visitorNum = num33;
            }
            Integer num34 = builder.totalVisitorNum;
            if (num34 == null) {
                this.totalVisitorNum = DEFAULT_TOTALVISITORNUM;
            } else {
                this.totalVisitorNum = num34;
            }
            this.pendant = builder.pendant;
            this.alaInfo = builder.alaInfo;
            String str15 = builder.sealPrefix;
            if (str15 == null) {
                this.sealPrefix = "";
            } else {
                this.sealPrefix = str15;
            }
            Integer num35 = builder.hasBottleEnter;
            if (num35 == null) {
                this.hasBottleEnter = DEFAULT_HASBOTTLEENTER;
            } else {
                this.hasBottleEnter = num35;
            }
            this.videoChannelInfo = builder.videoChannelInfo;
            this.springVirtualUser = builder.springVirtualUser;
            Integer num36 = builder.eachOtherFriend;
            if (num36 == null) {
                this.eachOtherFriend = DEFAULT_EACHOTHERFRIEND;
            } else {
                this.eachOtherFriend = num36;
            }
            this.esportData = builder.esportData;
            this.alaLiveInfo = builder.alaLiveInfo;
            Integer num37 = builder.nicknameUpdateTime;
            if (num37 == null) {
                this.nicknameUpdateTime = DEFAULT_NICKNAMEUPDATETIME;
            } else {
                this.nicknameUpdateTime = num37;
            }
            Integer num38 = builder.threadNum;
            if (num38 == null) {
                this.threadNum = DEFAULT_THREADNUM;
            } else {
                this.threadNum = num38;
            }
            Integer num39 = builder.agreeNum;
            if (num39 == null) {
                this.agreeNum = DEFAULT_AGREENUM;
            } else {
                this.agreeNum = num39;
            }
            Integer num40 = builder.leftCallNum;
            if (num40 == null) {
                this.leftCallNum = DEFAULT_LEFTCALLNUM;
            } else {
                this.leftCallNum = num40;
            }
            Integer num41 = builder.isInvited;
            if (num41 == null) {
                this.isInvited = DEFAULT_ISINVITED;
            } else {
                this.isInvited = num41;
            }
            Integer num42 = builder.isFans;
            if (num42 == null) {
                this.isFans = DEFAULT_ISFANS;
            } else {
                this.isFans = num42;
            }
            Integer num43 = builder.privThread;
            if (num43 == null) {
                this.privThread = DEFAULT_PRIVTHREAD;
            } else {
                this.privThread = num43;
            }
            Integer num44 = builder.isVideobiggie;
            if (num44 == null) {
                this.isVideobiggie = DEFAULT_ISVIDEOBIGGIE;
            } else {
                this.isVideobiggie = num44;
            }
            Integer num45 = builder.isShowRedpacket;
            if (num45 == null) {
                this.isShowRedpacket = DEFAULT_ISSHOWREDPACKET;
            } else {
                this.isShowRedpacket = num45;
            }
            this.baijiahaoInfo = builder.baijiahaoInfo;
            this.birthdayInfo = builder.birthdayInfo;
            Integer num46 = builder.canModifyAvatar;
            if (num46 == null) {
                this.canModifyAvatar = DEFAULT_CANMODIFYAVATAR;
            } else {
                this.canModifyAvatar = num46;
            }
            String str16 = builder.modifyAvatarDesc;
            if (str16 == null) {
                this.modifyAvatarDesc = "";
            } else {
                this.modifyAvatarDesc = str16;
            }
            Integer num47 = builder.influence;
            if (num47 == null) {
                this.influence = DEFAULT_INFLUENCE;
            } else {
                this.influence = num47;
            }
            String str17 = builder.levelInfluence;
            if (str17 == null) {
                this.levelInfluence = "";
            } else {
                this.levelInfluence = str17;
            }
            this.newGodData = builder.newGodData;
            this.bawuThrones = builder.bawuThrones;
            this.callFansInfo = builder.callFansInfo;
            this.bazhuGrade = builder.bazhuGrade;
            Integer num48 = builder.isDefaultAvatar;
            if (num48 == null) {
                this.isDefaultAvatar = DEFAULT_ISDEFAULTAVATAR;
            } else {
                this.isDefaultAvatar = num48;
            }
            String str18 = builder.uk;
            if (str18 == null) {
                this.uk = "";
            } else {
                this.uk = str18;
            }
            this.creationData = builder.creationData;
            Integer num49 = builder.favoriteNum;
            if (num49 == null) {
                this.favoriteNum = DEFAULT_FAVORITENUM;
            } else {
                this.favoriteNum = num49;
            }
            this.liveRoomInfo = builder.liveRoomInfo;
            this.businessAccountInfo = builder.businessAccountInfo;
            String str19 = builder.appealThreadPopover;
            if (str19 == null) {
                this.appealThreadPopover = "";
            } else {
                this.appealThreadPopover = str19;
            }
            List<ForumToolPerm> list10 = builder.forumToolAuth;
            if (list10 == null) {
                this.forumToolAuth = DEFAULT_FORUMTOOLAUTH;
            } else {
                this.forumToolAuth = Message.immutableCopyOf(list10);
            }
            Integer num50 = builder.workNum;
            if (num50 == null) {
                this.workNum = DEFAULT_WORKNUM;
            } else {
                this.workNum = num50;
            }
            Integer num51 = builder.showPbPrivateFlag;
            if (num51 == null) {
                this.showPbPrivateFlag = DEFAULT_SHOWPBPRIVATEFLAG;
            } else {
                this.showPbPrivateFlag = num51;
            }
            Integer num52 = builder.totalAgreeNum;
            if (num52 == null) {
                this.totalAgreeNum = DEFAULT_TOTALAGREENUM;
            } else {
                this.totalAgreeNum = num52;
            }
            this.workcreationData = builder.workcreationData;
            String str20 = builder.tiebaUid;
            if (str20 == null) {
                this.tiebaUid = "";
            } else {
                this.tiebaUid = str20;
            }
            String str21 = builder.followFrom;
            if (str21 == null) {
                this.followFrom = "";
            } else {
                this.followFrom = str21;
            }
            List<BazhuSign> list11 = builder.managerForum;
            if (list11 == null) {
                this.managerForum = DEFAULT_MANAGERFORUM;
            } else {
                this.managerForum = Message.immutableCopyOf(list11);
            }
            Integer num53 = builder.displayAuthType;
            if (num53 == null) {
                this.displayAuthType = DEFAULT_DISPLAYAUTHTYPE;
            } else {
                this.displayAuthType = num53;
            }
            this.workCreatorInfo = builder.workCreatorInfo;
            String str22 = builder.levelName;
            if (str22 == null) {
                this.levelName = "";
            } else {
                this.levelName = str22;
            }
            this.editConfig = builder.editConfig;
            return;
        }
        this.isLogin = builder.isLogin;
        this.id = builder.id;
        this.name = builder.name;
        this.nameShow = builder.nameShow;
        this.portrait = builder.portrait;
        this.noUn = builder.noUn;
        this.type = builder.type;
        this.newUserInfo = builder.newUserInfo;
        this.userhide = builder.userhide;
        this.balv = builder.balv;
        this.isManager = builder.isManager;
        this.rank = builder.rank;
        this.bimgUrl = builder.bimgUrl;
        this.meizhiLevel = builder.meizhiLevel;
        this.isVerify = builder.isVerify;
        this.isInterestman = builder.isInterestman;
        this.iconinfo = Message.immutableCopyOf(builder.iconinfo);
        this.tshowIcon = Message.immutableCopyOf(builder.tshowIcon);
        this.userType = builder.userType;
        this.isCoreuser = builder.isCoreuser;
        this.isHuinibuke = builder.isHuinibuke;
        this.iosBimgFormat = builder.iosBimgFormat;
        this.levelId = builder.levelId;
        this.isLike = builder.isLike;
        this.isBawu = builder.isBawu;
        this.bawuType = builder.bawuType;
        this.portraith = builder.portraith;
        this.ip = builder.ip;
        this.fansNum = builder.fansNum;
        this.concernNum = builder.concernNum;
        this.sex = builder.sex;
        this.myLikeNum = builder.myLikeNum;
        this.intro = builder.intro;
        this.hasConcerned = builder.hasConcerned;
        this.passwd = builder.passwd;
        this.postNum = builder.postNum;
        this.tbAge = builder.tbAge;
        this.isMem = builder.isMem;
        this.bimgEndTime = builder.bimgEndTime;
        this.payMemberInfo = builder.payMemberInfo;
        this.gender = builder.gender;
        this.isMask = builder.isMask;
        this.userPics = Message.immutableCopyOf(builder.userPics);
        this.privSets = builder.privSets;
        this.isFriend = builder.isFriend;
        this.likeForum = Message.immutableCopyOf(builder.likeForum);
        this.groupList = Message.immutableCopyOf(builder.groupList);
        this.giftNum = builder.giftNum;
        this.giftList = Message.immutableCopyOf(builder.giftList);
        this.isSelectTail = builder.isSelectTail;
        this.isGuanfang = builder.isGuanfang;
        this.bookmarkCount = builder.bookmarkCount;
        this.bookmarkNewCount = builder.bookmarkNewCount;
        this.muteUser = Message.immutableCopyOf(builder.muteUser);
        this.friendNum = builder.friendNum;
        this.fansNickname = builder.fansNickname;
        this.bgPic = builder.bgPic;
        this.parrScores = builder.parrScores;
        this.novelFansInfo = builder.novelFansInfo;
        this.vipInfo = builder.vipInfo;
        this.godData = builder.godData;
        this.heavyUser = builder.heavyUser;
        this.vipShowInfo = builder.vipShowInfo;
        this.newTshowIcon = Message.immutableCopyOf(builder.newTshowIcon);
        this.twAnchorInfo = builder.twAnchorInfo;
        this.profitList = Message.immutableCopyOf(builder.profitList);
        this.consumeInfo = builder.consumeInfo;
        this.themeCard = builder.themeCard;
        this.vipCloseAd = builder.vipCloseAd;
        this.activitySponsor = builder.activitySponsor;
        this.tbVip = builder.tbVip;
        this.noPostHigh = builder.noPostHigh;
        this.ecom = builder.ecom;
        this.visitorNum = builder.visitorNum;
        this.totalVisitorNum = builder.totalVisitorNum;
        this.pendant = builder.pendant;
        this.alaInfo = builder.alaInfo;
        this.sealPrefix = builder.sealPrefix;
        this.hasBottleEnter = builder.hasBottleEnter;
        this.videoChannelInfo = builder.videoChannelInfo;
        this.springVirtualUser = builder.springVirtualUser;
        this.eachOtherFriend = builder.eachOtherFriend;
        this.esportData = builder.esportData;
        this.alaLiveInfo = builder.alaLiveInfo;
        this.nicknameUpdateTime = builder.nicknameUpdateTime;
        this.threadNum = builder.threadNum;
        this.agreeNum = builder.agreeNum;
        this.leftCallNum = builder.leftCallNum;
        this.isInvited = builder.isInvited;
        this.isFans = builder.isFans;
        this.privThread = builder.privThread;
        this.isVideobiggie = builder.isVideobiggie;
        this.isShowRedpacket = builder.isShowRedpacket;
        this.baijiahaoInfo = builder.baijiahaoInfo;
        this.birthdayInfo = builder.birthdayInfo;
        this.canModifyAvatar = builder.canModifyAvatar;
        this.modifyAvatarDesc = builder.modifyAvatarDesc;
        this.influence = builder.influence;
        this.levelInfluence = builder.levelInfluence;
        this.newGodData = builder.newGodData;
        this.bawuThrones = builder.bawuThrones;
        this.callFansInfo = builder.callFansInfo;
        this.bazhuGrade = builder.bazhuGrade;
        this.isDefaultAvatar = builder.isDefaultAvatar;
        this.uk = builder.uk;
        this.creationData = builder.creationData;
        this.favoriteNum = builder.favoriteNum;
        this.liveRoomInfo = builder.liveRoomInfo;
        this.businessAccountInfo = builder.businessAccountInfo;
        this.appealThreadPopover = builder.appealThreadPopover;
        this.forumToolAuth = Message.immutableCopyOf(builder.forumToolAuth);
        this.workNum = builder.workNum;
        this.showPbPrivateFlag = builder.showPbPrivateFlag;
        this.totalAgreeNum = builder.totalAgreeNum;
        this.workcreationData = builder.workcreationData;
        this.tiebaUid = builder.tiebaUid;
        this.followFrom = builder.followFrom;
        this.managerForum = Message.immutableCopyOf(builder.managerForum);
        this.displayAuthType = builder.displayAuthType;
        this.workCreatorInfo = builder.workCreatorInfo;
        this.levelName = builder.levelName;
        this.editConfig = builder.editConfig;
    }
}
