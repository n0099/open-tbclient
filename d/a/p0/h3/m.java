package d.a.p0.h3;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import d.a.o0.r.q.a1;
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.h0;
import d.a.o0.r.q.i0;
import d.a.o0.r.q.i1;
import d.a.o0.r.q.n0;
import d.a.o0.r.q.o0;
import d.a.o0.r.q.r1;
import d.a.o0.r.q.x0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.AddBawuPopInfo;
import tbclient.AlaLiveNotify;
import tbclient.BottomMenu;
import tbclient.CategoryInfo;
import tbclient.ForumArIno;
import tbclient.ForumRuleStatus;
import tbclient.FrsPage.ActivityConfig;
import tbclient.FrsPage.AgreeBanner;
import tbclient.FrsPage.ColorEgg;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.FrsPage.ForumHeadIcon;
import tbclient.FrsPage.FrsPageResIdl;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.NebulaHotThreads;
import tbclient.FrsPage.RecmForumInfo;
import tbclient.FrsPage.RecomPostTopic;
import tbclient.FrsPage.StarEnter;
import tbclient.FrsPage.StarRank;
import tbclient.FrsTabInfo;
import tbclient.HotUserRankEntry;
import tbclient.ItemInfo;
import tbclient.OriForumInfo;
import tbclient.PopInfo;
import tbclient.ServiceArea;
import tbclient.SignActivityInfo;
import tbclient.SmartApp;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.WindowToast;
/* loaded from: classes8.dex */
public class m implements d.a.o0.g0.b.b, d.a.o0.g0.b.h {
    public static /* synthetic */ Interceptable $ic;
    public static final Wire WIRE;
    public transient /* synthetic */ FieldHolder $fh;
    public int accessFlag;
    public ActivityConfig activityConfig;
    public AgreeBanner agreeBanner;
    public int alaLiveCount;
    public AntiData anti;
    public String bawuCenterUrl;
    public AddBawuPopInfo bawuPopInfo;
    public WindowToast bazhuExam;
    public d.a.o0.r.q.z bookInfoData;
    public List<BottomMenu> bottomMenuList;
    public d.a.p0.u0.d brandAdData;
    public i businessPromot;
    public b2 cardVideoInfo;
    public d.a.o0.r.q.t carrierEnterData;
    public List<CategoryInfo> categoryInfos;
    public b chatGroup;
    public ArrayList<d.a.o0.r.q.v> color_eggs;
    public int defaultShowTab;
    public PopInfo enterFrsDialogInfo;
    public boolean fortuneBag;
    public String fortuneDesc;
    public ForumData forum;
    public ForumActiveInfo forumActiveInfo;
    public ForumArIno forumArIno;
    public ForumHeadIcon forumHeadIcon;
    public ForumRuleStatus forumRule;
    public int forumState;
    public int frsDefaultTabId;
    public int gameDefaultTabId;
    public String gameName;
    public List<FrsTabInfo> gameTabInfo;
    public String gameUrl;
    public r gconAccount;
    public boolean hasGame;
    public h0 headSdkData;
    public d.a.o0.r.q.c0 headlineImgInfoData;
    public boolean isBrandForum;
    public boolean isFrsVideoAutoPlay;
    public int isNewUrl;
    public boolean isShowRedTip;
    public ItemInfo itemInfo;
    public List<FeedForumData> likeFeedForumDataList;
    public AlaLiveNotify liveNotify;
    public d.a.o0.r.q.y mActivityHeadData;
    public List<d.a.c.k.e.n> mCardShipinNew;
    public List<Integer> mCardShipinPos;
    public long mDataParseTime;
    public NavTabInfo mEntelechyTabInfo;
    public int mErrorNo;
    public g mFrsInsertLiveData;
    public h mFrsStageLiveData;
    public q mFrsVideoActivityData;
    public d.a.p0.x0.b mGameRankListData;
    public boolean mHasThreadExceptTop;
    public HotUserRankEntry mHotUserRankData;
    public FrsTabInfo mNewChapterInfo;
    public SignActivityInfo mSignActivityInfo;
    public int mSortType;
    public List<WindowToast> mWindowToast;
    public Integer mangaReadRecordChapterId;
    public NebulaHotThreads nebulaHotThreads;
    public int needLog;
    public List<OriForumInfo> oriForumInfoList;
    public a1 page;
    public int photoLivePos;
    public RecomPostTopic postTopic;
    public d.a.o0.r.q.f0 presentInfoData;
    public i1 privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    public i0 recommendBookData;
    public r1 schoolRecommendInfo;
    public int schoolRecommendPos;
    public a0 serviceAreaData;
    public Integer showAdsense;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    public n star;
    public List<k> starEnter;
    public StarRank starRank;
    public ArrayList<d.a.c.k.e.n> threadList;
    public List<Long> threadListIds;
    public Integer toLoadHorseData;
    public List<d.a.c.k.e.n> topThreadList;
    public UserData userData;
    public List<User> userList;
    public HashMap<String, MetaData> userMap;
    public d.a.p0.u0.w userRecommend;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1570794776, "Ld/a/p0/h3/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1570794776, "Ld/a/p0/h3/m;");
                return;
            }
        }
        WIRE = new Wire(new Class[0]);
    }

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.needLog = 0;
        this.starEnter = new ArrayList();
        this.isNewUrl = 0;
        this.color_eggs = new ArrayList<>();
        this.mActivityHeadData = null;
        this.frsDefaultTabId = 1;
        this.isShowRedTip = false;
        this.bawuCenterUrl = null;
        this.headSdkData = null;
        this.recommendBookData = null;
        this.postTopic = null;
        this.bookInfoData = null;
        this.mangaReadRecordChapterId = -1;
        this.presentInfoData = null;
        this.headlineImgInfoData = null;
        this.schoolRecommendPos = -1;
        this.topThreadList = null;
        this.forumState = 0;
        this.accessFlag = 0;
        this.alaLiveCount = 0;
        this.gameDefaultTabId = 0;
        this.mErrorNo = 0;
        this.defaultShowTab = 1;
        this.mDataParseTime = 0L;
        initData();
    }

    private void handleDefaultTab(int i2) {
        List<FrsTabInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            this.frsDefaultTabId = 1;
            NavTabInfo navTabInfo = this.mEntelechyTabInfo;
            if (navTabInfo == null || (list = navTabInfo.tab) == null || list.size() <= 0) {
                return;
            }
            for (FrsTabInfo frsTabInfo : this.mEntelechyTabInfo.tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i2) {
                    this.frsDefaultTabId = i2;
                    return;
                }
            }
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.forum = new ForumData();
            this.threadList = new ArrayList<>();
            this.topThreadList = new ArrayList();
            this.userMap = new HashMap<>();
            this.page = new a1();
            this.star = new n();
            this.userData = new UserData();
            this.gconAccount = new r();
            setAnti(new AntiData());
            setChatGroup(new b());
            this.privateForumTotalData = new i1();
            this.mCardShipinNew = new ArrayList();
            this.mCardShipinPos = new ArrayList();
        }
    }

    public void convertThreadInfoToThreadData(List<ThreadInfo> list, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048576, this, list, j) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                b2 b2Var = new b2();
                SpecHotTopicHelper.setSpecTopicIcon(j, b2Var);
                b2Var.i4(this.userMap);
                b2Var.r3(true);
                b2Var.I2(threadInfo);
                b2Var.M2();
                b2Var.z1();
                if (b2Var.Q() == 0 && j != 0) {
                    b2Var.l3(j);
                }
                if (StringUtils.isNull(b2Var.W())) {
                    b2Var.p3(this.forum.getName());
                }
                b2Var.B2(this.color_eggs);
                b2Var.G1 = this.forum.isBrandForum;
                if (!TextUtils.isEmpty(b2Var.t0())) {
                    o0 o0Var = new o0();
                    o0Var.e(b2Var.t0());
                    this.threadList.add(o0Var);
                } else {
                    this.threadList.add(b2Var);
                    JSONObject c2 = d.a.p0.w2.i0.b.c(threadInfo, b2Var.W());
                    if (c2 != null) {
                        arrayList.add(c2);
                    }
                }
            }
        }
        d.a.p0.w2.i0.b.f().h("FRS", arrayList);
    }

    public void deleteLikeFeedForum(String str) {
        List<FeedForumData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (list = this.likeFeedForumDataList) == null || str == null) {
            return;
        }
        for (FeedForumData feedForumData : list) {
            if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(str)) {
                this.likeFeedForumDataList.remove(feedForumData);
                return;
            }
        }
    }

    public int getAccessFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.accessFlag : invokeV.intValue;
    }

    public d.a.o0.r.q.y getActivityHeadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mActivityHeadData : (d.a.o0.r.q.y) invokeV.objValue;
    }

    public AgreeBanner getAgreeBanner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.agreeBanner : (AgreeBanner) invokeV.objValue;
    }

    public int getAlaLiveCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.alaLiveCount : invokeV.intValue;
    }

    public AntiData getAnti() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.anti : (AntiData) invokeV.objValue;
    }

    public String getBawuCenterUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.bawuCenterUrl : (String) invokeV.objValue;
    }

    public d.a.o0.r.q.z getBookInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.bookInfoData : (d.a.o0.r.q.z) invokeV.objValue;
    }

    public i getBusinessPromot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.businessPromot : (i) invokeV.objValue;
    }

    @Override // d.a.o0.g0.b.c
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public List<d.a.c.k.e.n> getCardShipinNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mCardShipinNew : (List) invokeV.objValue;
    }

    public List<Integer> getCardShipinPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mCardShipinPos : (List) invokeV.objValue;
    }

    public b2 getCardVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.cardVideoInfo : (b2) invokeV.objValue;
    }

    public d.a.o0.r.q.t getCarrierEnterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.carrierEnterData : (d.a.o0.r.q.t) invokeV.objValue;
    }

    public List<CategoryInfo> getCategoryInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.categoryInfos : (List) invokeV.objValue;
    }

    public b getChatGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.chatGroup : (b) invokeV.objValue;
    }

    public long getDataParseTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mDataParseTime : invokeV.longValue;
    }

    public NavTabInfo getEntelechyTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mEntelechyTabInfo : (NavTabInfo) invokeV.objValue;
    }

    public String getFortuneDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.fortuneDesc : (String) invokeV.objValue;
    }

    public ForumData getForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.forum : (ForumData) invokeV.objValue;
    }

    public ForumHeadIcon getForumHeadIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.forumHeadIcon : (ForumHeadIcon) invokeV.objValue;
    }

    public int getForumState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.forumState : invokeV.intValue;
    }

    public int getFrsDefaultTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.frsDefaultTabId : invokeV.intValue;
    }

    public g getFrsInsertLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mFrsInsertLiveData : (g) invokeV.objValue;
    }

    public h getFrsStageLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mFrsStageLiveData : (h) invokeV.objValue;
    }

    public q getFrsVideoActivityData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mFrsVideoActivityData : (q) invokeV.objValue;
    }

    public int getGameDefaultTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.gameDefaultTabId : invokeV.intValue;
    }

    public String getGameName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.gameName : (String) invokeV.objValue;
    }

    public d.a.p0.x0.b getGameRankListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mGameRankListData : (d.a.p0.x0.b) invokeV.objValue;
    }

    public List<FrsTabInfo> getGameTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.gameTabInfo : (List) invokeV.objValue;
    }

    public String getGameUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.gameUrl : (String) invokeV.objValue;
    }

    public r getGconAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.gconAccount : (r) invokeV.objValue;
    }

    public h0 getHeadSdkData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.headSdkData : (h0) invokeV.objValue;
    }

    public d.a.o0.r.q.c0 getHeadlineImgInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.headlineImgInfoData : (d.a.o0.r.q.c0) invokeV.objValue;
    }

    public HotUserRankEntry getHotUserRankData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mHotUserRankData : (HotUserRankEntry) invokeV.objValue;
    }

    public int getIsNewUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.isNewUrl : invokeV.intValue;
    }

    public List<FeedForumData> getLikeFeedForumDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.likeFeedForumDataList : (List) invokeV.objValue;
    }

    public AlaLiveNotify getLiveNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.liveNotify : (AlaLiveNotify) invokeV.objValue;
    }

    public Integer getMangaReadRecordChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mangaReadRecordChapterId : (Integer) invokeV.objValue;
    }

    public a1 getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.page : (a1) invokeV.objValue;
    }

    public int getPhotoLivePos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.photoLivePos : invokeV.intValue;
    }

    public i1 getPrivateForumTotalInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.privateForumTotalData : (i1) invokeV.objValue;
    }

    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.recm_forum_list : (List) invokeV.objValue;
    }

    public int getSchoolRecommendPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.schoolRecommendPos : invokeV.intValue;
    }

    public r1 getSchoolRecommendUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.schoolRecommendInfo : (r1) invokeV.objValue;
    }

    public int getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mSortType : invokeV.intValue;
    }

    public n getStar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.star : (n) invokeV.objValue;
    }

    public List<k> getStarEnter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.starEnter : (List) invokeV.objValue;
    }

    public ArrayList<d.a.c.k.e.n> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.threadList : (ArrayList) invokeV.objValue;
    }

    public List<Long> getThreadListIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.threadListIds : (List) invokeV.objValue;
    }

    public Integer getToLoadHorseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.toLoadHorseData : (Integer) invokeV.objValue;
    }

    public UserData getUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.userData : (UserData) invokeV.objValue;
    }

    public HashMap<String, MetaData> getUserMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.userMap : (HashMap) invokeV.objValue;
    }

    public d.a.p0.u0.w getUserRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.userRecommend : (d.a.p0.u0.w) invokeV.objValue;
    }

    @Override // d.a.o0.g0.b.b
    public boolean initByByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, bArr)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.o0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, jSONObject) == null) {
        }
    }

    @Override // d.a.o0.g0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, message) == null) {
        }
    }

    public boolean isFortuneBag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.fortuneBag : invokeV.booleanValue;
    }

    public boolean isHasGame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.hasGame : invokeV.booleanValue;
    }

    public boolean isShowRedTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.isShowRedTip : invokeV.booleanValue;
    }

    public FrsPageResIdl parserProtobuf(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048637, this, bArr, z)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (bArr == null) {
                return null;
            }
            try {
                FrsPageResIdl frsPageResIdl = (FrsPageResIdl) WIRE.parseFrom(bArr, FrsPageResIdl.class);
                if (frsPageResIdl != null && frsPageResIdl.data != null) {
                    parserProtobuf(frsPageResIdl.data);
                }
                if (z) {
                    if (this.mDataParseTime == 0) {
                        this.mDataParseTime = System.currentTimeMillis() - currentTimeMillis;
                    }
                } else {
                    this.mDataParseTime = 0L;
                }
                return frsPageResIdl;
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (FrsPageResIdl) invokeLZ.objValue;
    }

    public void setAccessFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            this.accessFlag = i2;
        }
    }

    public void setActivityHeadData(d.a.o0.r.q.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, yVar) == null) {
            this.mActivityHeadData = yVar;
        }
    }

    public void setAgreeBanner(AgreeBanner agreeBanner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, agreeBanner) == null) {
            this.agreeBanner = agreeBanner;
        }
    }

    public void setAlaLiveCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
            this.alaLiveCount = i2;
        }
    }

    public void setAnti(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, antiData) == null) {
            this.anti = antiData;
        }
    }

    public void setBawuCenterUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            this.bawuCenterUrl = str;
        }
    }

    public void setBookInfo(d.a.o0.r.q.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, zVar) == null) {
            this.bookInfoData = zVar;
        }
    }

    public void setBusinessPromot(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, iVar) == null) {
            this.businessPromot = iVar;
        }
    }

    public void setCardShipinNew(List<d.a.c.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, list) == null) {
            this.mCardShipinNew = list;
        }
    }

    public void setCardShipinPos(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, list) == null) {
            this.mCardShipinPos = list;
        }
    }

    public void setCardVideoInfo(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, b2Var) == null) {
            this.cardVideoInfo = b2Var;
        }
    }

    public void setCarrierEnterData(d.a.o0.r.q.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, tVar) == null) {
            this.carrierEnterData = tVar;
        }
    }

    public void setCategoryInfos(List<CategoryInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, list) == null) {
            this.categoryInfos = list;
        }
    }

    public void setChatGroup(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, bVar) == null) {
            this.chatGroup = bVar;
        }
    }

    public void setEntelechyTabInfo(NavTabInfo navTabInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, navTabInfo) == null) {
            this.mEntelechyTabInfo = navTabInfo;
        }
    }

    public void setFortuneBag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            this.fortuneBag = z;
        }
    }

    public void setFortuneDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, str) == null) {
            this.fortuneDesc = str;
        }
    }

    public void setForum(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, forumData) == null) {
            this.forum = forumData;
        }
    }

    public void setForumHeadIcon(ForumHeadIcon forumHeadIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, forumHeadIcon) == null) {
            this.forumHeadIcon = forumHeadIcon;
        }
    }

    public void setForumState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048658, this, i2) == null) {
            this.forumState = i2;
        }
    }

    public void setFrsDefaultTabId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048659, this, i2) == null) {
            this.frsDefaultTabId = i2;
        }
    }

    public void setFrsInsertLiveData(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, gVar) == null) {
            this.mFrsInsertLiveData = gVar;
        }
    }

    public void setFrsStageLiveData(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, hVar) == null) {
            this.mFrsStageLiveData = hVar;
        }
    }

    public void setFrsVideoActivityData(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, qVar) == null) {
            this.mFrsVideoActivityData = qVar;
        }
    }

    public void setGameDefaultTabId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048663, this, i2) == null) {
            this.gameDefaultTabId = i2;
        }
    }

    public void setGameName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, str) == null) {
            this.gameName = str;
        }
    }

    public void setGameRankListData(d.a.p0.x0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, bVar) == null) {
            this.mGameRankListData = bVar;
        }
    }

    public void setGameTabInfo(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, list) == null) {
            this.gameTabInfo = list;
        }
    }

    public void setGameUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, str) == null) {
            this.gameUrl = str;
        }
    }

    public void setGconAccount(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, rVar) == null) {
            this.gconAccount = rVar;
        }
    }

    public void setHasGame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048669, this, z) == null) {
            this.hasGame = z;
        }
    }

    public void setHeadSdkData(h0 h0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, h0Var) == null) {
            this.headSdkData = h0Var;
        }
    }

    public void setHeadlineImgInfoData(d.a.o0.r.q.c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, c0Var) == null) {
            this.headlineImgInfoData = c0Var;
        }
    }

    public void setHotUserRankData(HotUserRankEntry hotUserRankEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, hotUserRankEntry) == null) {
            this.mHotUserRankData = hotUserRankEntry;
        }
    }

    public void setIsNewUrl(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048673, this, i2) == null) {
            this.isNewUrl = i2;
        }
    }

    public void setIsShowRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            this.isShowRedTip = z;
        }
    }

    public void setLikeFeedForumDataList(List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, list) == null) {
            this.likeFeedForumDataList = list;
        }
    }

    public void setLiveNotify(AlaLiveNotify alaLiveNotify) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, alaLiveNotify) == null) {
            this.liveNotify = alaLiveNotify;
        }
    }

    public void setMangaReadRecordChapterId(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, num) == null) {
            this.mangaReadRecordChapterId = num;
        }
    }

    public void setPage(a1 a1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, a1Var) == null) {
            this.page = a1Var;
        }
    }

    public void setPhotoLivePos(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048679, this, i2) == null) {
            this.photoLivePos = i2;
        }
    }

    public void setPrivateForumTotalInfo(i1 i1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, i1Var) == null) {
            this.privateForumTotalData = i1Var;
        }
    }

    public void setSchoolRecommendInfo(r1 r1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, r1Var) == null) {
            this.schoolRecommendInfo = r1Var;
        }
    }

    public void setSchoolRecommendPos(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i2) == null) {
            this.schoolRecommendPos = i2;
        }
    }

    public void setSortType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048683, this, i2) == null) {
            this.mSortType = i2;
        }
    }

    public void setStar(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, nVar) == null) {
            this.star = nVar;
        }
    }

    public void setStarEnter(List<k> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, list) == null) {
            this.starEnter = list;
        }
    }

    public void setThreadList(ArrayList<d.a.c.k.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, arrayList) == null) {
            this.threadList = arrayList;
        }
    }

    public void setThreadListIds(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, list) == null) {
            this.threadListIds = list;
        }
    }

    public void setUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, userData) == null) {
            this.userData = userData;
        }
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, hashMap) == null) {
            this.userMap = hashMap;
        }
    }

    public void setUserRecommend(d.a.p0.u0.w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, wVar) == null) {
            this.userRecommend = wVar;
        }
    }

    public ArrayList<d.a.c.k.e.n> switchThreadDataToThreadCardInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            ArrayList<d.a.c.k.e.n> switchThreadDataToThreadCardInfo = switchThreadDataToThreadCardInfo(this.threadList);
            setThreadList(switchThreadDataToThreadCardInfo);
            return switchThreadDataToThreadCardInfo;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // d.a.o0.g0.b.b
    public byte[] toCacheByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public ArrayList<d.a.c.k.e.n> switchThreadDataToThreadCardInfo(ArrayList<d.a.c.k.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048692, this, arrayList)) == null) {
            this.mHasThreadExceptTop = false;
            ArrayList<d.a.c.k.e.n> arrayList2 = new ArrayList<>();
            Iterator<d.a.c.k.e.n> it = arrayList.iterator();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                d.a.c.k.e.n next = it.next();
                if (next instanceof n0) {
                    ((n0) next).setPosition(i2 - i3);
                    arrayList2.add(next);
                } else if (next instanceof o0) {
                    ((o0) next).position = i2;
                    arrayList2.add(next);
                } else if (next instanceof b2) {
                    b2 b2Var = (b2) next;
                    if (b2Var.m2()) {
                        i3++;
                    }
                    d.a.o0.b.f.a.e(b2Var);
                    int[] d0 = b2Var.d0();
                    if (b2Var.getType() == b2.O2 && !b2Var.m2()) {
                        a2 a2Var = new a2();
                        a2Var.w = b2Var;
                        a2Var.position = i2;
                        a2Var.f52563e = true;
                        a2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(a2Var);
                        a2 a2Var2 = new a2();
                        a2Var2.w = b2Var;
                        a2Var2.position = i2;
                        if (b2Var.F1()) {
                            a2Var2.j = true;
                        } else if (b2Var.N2() == 1) {
                            a2Var2.f52566h = true;
                            a2Var2.x = d0[0];
                            a2Var2.y = d0[1];
                        } else if (b2Var.N2() >= 2) {
                            a2Var2.f52567i = true;
                        } else {
                            a2Var2.f52564f = true;
                        }
                        a2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var2);
                        if (b2Var.D0() != null) {
                            a2 a2Var3 = new a2();
                            a2Var3.s = true;
                            a2Var3.w = b2Var;
                            a2Var3.position = i2;
                            a2Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var3);
                        }
                        if (b2Var.Z0() != null) {
                            a2 a2Var4 = new a2();
                            a2Var4.p = true;
                            a2Var4.w = b2Var;
                            a2Var4.position = i2;
                            a2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var4);
                        }
                        if (!ListUtils.isEmpty(b2Var.v0()) || !ListUtils.isEmpty(b2Var.Z())) {
                            a2 a2Var5 = new a2();
                            if (ListUtils.getCount(b2Var.v0()) + ListUtils.getCount(b2Var.Z()) == 1) {
                                a2Var5.t = true;
                            } else if (ListUtils.getCount(b2Var.v0()) + ListUtils.getCount(b2Var.Z()) > 1) {
                                a2Var5.u = true;
                            }
                            a2Var5.w = b2Var;
                            a2Var5.position = i2;
                            a2Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var5);
                        }
                        if (b2Var.p1() != null) {
                            a2 a2Var6 = new a2();
                            a2Var6.l = true;
                            a2Var6.w = b2Var;
                            a2Var6.position = i2;
                            a2Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var6);
                        }
                        if (b2Var.n0() != null && !b2Var.t2()) {
                            a2 a2Var7 = new a2();
                            a2Var7.r = true;
                            a2Var7.w = b2Var;
                            a2Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var7);
                        }
                        a2 a2Var8 = new a2();
                        a2Var8.k = true;
                        a2Var8.w = b2Var;
                        a2Var8.position = i2;
                        a2Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(a2Var8);
                    } else if ((b2Var.getType() == b2.l3 || b2Var.getType() == b2.E3) && !b2Var.m2()) {
                        a2 a2Var9 = new a2();
                        a2Var9.w = b2Var;
                        a2Var9.position = i2;
                        a2Var9.f52563e = true;
                        a2Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(a2Var9);
                        a2 a2Var10 = new a2();
                        a2Var10.w = b2Var;
                        a2Var10.position = i2;
                        if (b2Var instanceof x0) {
                            a2Var10.n = true;
                        } else {
                            a2Var10.m = true;
                        }
                        a2Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var10);
                        if (b2Var.D0() != null) {
                            a2 a2Var11 = new a2();
                            a2Var11.s = true;
                            a2Var11.w = b2Var;
                            a2Var11.position = i2;
                            a2Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var11);
                        }
                        if (b2Var.Z0() != null) {
                            a2 a2Var12 = new a2();
                            a2Var12.p = true;
                            a2Var12.w = b2Var;
                            a2Var12.position = i2;
                            a2Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var12);
                        }
                        if (b2Var.p1() != null) {
                            a2 a2Var13 = new a2();
                            a2Var13.l = true;
                            a2Var13.w = b2Var;
                            a2Var13.position = i2;
                            a2Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var13);
                        }
                        if (b2Var.n0() != null && !b2Var.t2()) {
                            a2 a2Var14 = new a2();
                            a2Var14.r = true;
                            a2Var14.w = b2Var;
                            a2Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var14);
                        }
                        a2 a2Var15 = new a2();
                        a2Var15.k = true;
                        a2Var15.w = b2Var;
                        a2Var15.position = i2;
                        a2Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(a2Var15);
                    } else if (b2Var.l1() != null && !b2Var.W1() && b2Var.Q1()) {
                        a2 a2Var16 = new a2();
                        a2Var16.w = b2Var;
                        a2Var16.position = i2;
                        a2Var16.f52563e = true;
                        a2Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(a2Var16);
                        a2 a2Var17 = new a2();
                        a2Var17.w = b2Var;
                        a2Var17.position = i2;
                        a2Var17.o = true;
                        a2Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var17);
                        if (b2Var.D0() != null) {
                            a2 a2Var18 = new a2();
                            a2Var18.s = true;
                            a2Var18.w = b2Var;
                            a2Var18.position = i2;
                            a2Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var18);
                        }
                        if (b2Var.Z0() != null) {
                            a2 a2Var19 = new a2();
                            a2Var19.p = true;
                            a2Var19.w = b2Var;
                            a2Var19.position = i2;
                            a2Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var19);
                        }
                        if (b2Var.p1() != null) {
                            a2 a2Var20 = new a2();
                            a2Var20.l = true;
                            a2Var20.w = b2Var;
                            a2Var20.position = i2;
                            a2Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var20);
                        }
                        if (b2Var.n0() != null && !b2Var.t2()) {
                            a2 a2Var21 = new a2();
                            a2Var21.r = true;
                            a2Var21.w = b2Var;
                            a2Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var21);
                        }
                        a2 a2Var22 = new a2();
                        a2Var22.k = true;
                        a2Var22.w = b2Var;
                        a2Var22.position = i2;
                        a2Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(a2Var22);
                    } else if (b2Var.getType() == b2.d3 && b2Var.E1()) {
                        b2Var.position = i2;
                        arrayList2.add(b2Var);
                    } else {
                        a2 a2Var23 = new a2();
                        a2Var23.w = b2Var;
                        a2Var23.position = i2;
                        arrayList2.add(a2Var23);
                    }
                    i2++;
                    b2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    if (next != null && next.getType() != b2.N2) {
                        this.mHasThreadExceptTop = true;
                    }
                } else {
                    arrayList2.add(next);
                }
                i2++;
                if (next != null) {
                    this.mHasThreadExceptTop = true;
                }
            }
            d.a.o0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void parserProtobuf(DataRes dataRes) {
        long j;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, dataRes) == null) || dataRes == null) {
            return;
        }
        try {
            initData();
            if (!ListUtils.isEmpty(dataRes.color_egg)) {
                for (ColorEgg colorEgg : dataRes.color_egg) {
                    if (colorEgg != null && !ListUtils.isEmpty(colorEgg.holiday_words)) {
                        d.a.o0.r.q.v vVar = new d.a.o0.r.q.v();
                        if (vVar.c(colorEgg)) {
                            this.color_eggs.add(vVar);
                        }
                    }
                }
            }
            int i2 = 0;
            boolean z = true;
            if (dataRes.forum != null) {
                this.hasGame = dataRes.forum.has_game.intValue() == 1;
                this.gameUrl = dataRes.forum.game_url;
                this.gameName = dataRes.forum.game_name;
                this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
            }
            if (this.isBrandForum && dataRes.brand_forum_info != null) {
                d.a.o0.r.q.y yVar = new d.a.o0.r.q.y();
                this.mActivityHeadData = yVar;
                yVar.e(dataRes.brand_forum_info.head_imgs);
                d.a.p0.u0.d dVar = new d.a.p0.u0.d();
                this.brandAdData = dVar;
                dVar.a(dataRes.brand_forum_info);
                if (!ListUtils.isEmpty(dataRes.brand_forum_info.relation_forum)) {
                    this.oriForumInfoList = new ArrayList();
                    for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                        if (oriForumInfo != null) {
                            this.oriForumInfoList.add(oriForumInfo);
                        }
                    }
                }
            } else if (dataRes.activityhead != null) {
                d.a.o0.r.q.y yVar2 = new d.a.o0.r.q.y();
                this.mActivityHeadData = yVar2;
                yVar2.d(dataRes.activityhead);
            } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !d.a.c.e.p.k.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
                d.a.o0.r.q.y yVar3 = new d.a.o0.r.q.y();
                this.mActivityHeadData = yVar3;
                yVar3.e(dataRes.private_forum_info.head_imgs);
            }
            this.bottomMenuList = dataRes.bottom_menu;
            List<User> list = dataRes.user_list;
            if (list != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    MetaData metaData2 = new MetaData();
                    metaData2.parserProtobuf(list.get(i3));
                    String userId = metaData2.getUserId();
                    if (userId != null && !userId.equals("0")) {
                        this.userMap.put(metaData2.getUserId(), metaData2);
                    }
                }
            }
            this.userList = dataRes.user_list;
            setIsNewUrl(dataRes.is_new_url.intValue());
            this.fortuneBag = dataRes.fortune_bag.intValue() == 1;
            this.fortuneDesc = dataRes.fortune_desc;
            List<StarEnter> list2 = dataRes.star_enter;
            this.starEnter.clear();
            if (list2 != null) {
                for (int i4 = 0; i4 < list2.size(); i4++) {
                    k kVar = new k();
                    kVar.l(list2.get(i4));
                    this.starEnter.add(kVar);
                }
            }
            this.gconAccount.c(dataRes.gcon_account);
            this.forum.parserProtobuf(dataRes.forum);
            if (dataRes.forum != null) {
                j = dataRes.forum.id.longValue();
                SpecHotTopicHelper.putSpecialTopicIcon(Long.valueOf(j), dataRes.forum.topic_special_icon, dataRes.forum.topic_special_icon_right);
            } else {
                j = 0;
            }
            this.threadListIds = dataRes.thread_id_list;
            this.anti.parserProtobuf(dataRes.anti);
            if (dataRes.anti != null) {
                d.a.p0.p3.d.f(dataRes.anti.block_pop_info);
            }
            this.chatGroup.a(dataRes.group);
            this.page.j(dataRes.page);
            this.star.c(dataRes.frs_star);
            this.userData.parserProtobuf(dataRes.user);
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.userData.getIsSelectTail());
            }
            if (dataRes.nav_tab_info == null) {
                NavTabInfo.Builder builder = new NavTabInfo.Builder();
                builder.tab = dataRes.frs_tab_info;
                this.mEntelechyTabInfo = builder.build(true);
            } else {
                this.mEntelechyTabInfo = dataRes.nav_tab_info;
            }
            this.defaultShowTab = 1;
            if (d.a.o0.b.d.y() && !d.a.o0.b.g.a.f51512e.equals(((FrsTabInfo) ListUtils.getItem(this.mEntelechyTabInfo.tab, 0)).tab_name)) {
                this.defaultShowTab = d.a.o0.b.g.a.c();
            }
            if (this.mEntelechyTabInfo != null && !ListUtils.isEmpty(this.mEntelechyTabInfo.head)) {
                this.mNewChapterInfo = this.mEntelechyTabInfo.head.get(0);
            }
            this.alaLiveCount = dataRes.ala_live_count.intValue();
            handleDefaultTab(dataRes.frs_tab_default.intValue());
            this.photoLivePos = dataRes.twzhibo_pos.intValue();
            this.isShowRedTip = dataRes.trends_redpoint.intValue() == 1;
            convertThreadInfoToThreadData(dataRes.thread_list, j);
            this.categoryInfos = dataRes.category_list;
            if (!d.a.c.e.p.k.isEmpty(dataRes.bawu_enter_url)) {
                this.bawuCenterUrl = dataRes.bawu_enter_url;
            }
            if (dataRes.head_sdk != null) {
                h0 h0Var = new h0();
                this.headSdkData = h0Var;
                h0Var.a(dataRes.head_sdk);
            }
            if (dataRes.recommend_book != null) {
                i0 i0Var = new i0();
                this.recommendBookData = i0Var;
                i0Var.r4(dataRes.recommend_book);
            }
            if (dataRes.book_info != null) {
                d.a.o0.r.q.z zVar = new d.a.o0.r.q.z();
                this.bookInfoData = zVar;
                zVar.c(dataRes.book_info);
            }
            if (dataRes.forum_present_info != null) {
                d.a.o0.r.q.f0 f0Var = new d.a.o0.r.q.f0();
                this.presentInfoData = f0Var;
                f0Var.a(dataRes.forum_present_info);
            }
            if (dataRes.forum_headline_img_info != null) {
                d.a.o0.r.q.c0 c0Var = new d.a.o0.r.q.c0();
                this.headlineImgInfoData = c0Var;
                c0Var.b(dataRes.forum_headline_img_info);
            }
            if (dataRes.business_promot != null) {
                i iVar = new i();
                this.businessPromot = iVar;
                iVar.m(dataRes.business_promot);
            }
            if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                b2 b2Var = new b2();
                this.cardVideoInfo = b2Var;
                b2Var.y3(true);
                this.cardVideoInfo.w3(this.photoLivePos);
                this.cardVideoInfo.i4(this.userMap);
                this.cardVideoInfo.I2(dataRes.card_shipin_info.get(0));
                this.cardVideoInfo.M2();
                this.cardVideoInfo.G1 = this.isBrandForum;
                if (this.cardVideoInfo.Q() == 0 && j != 0) {
                    this.cardVideoInfo.l3(j);
                }
                this.cardVideoInfo.B2(this.color_eggs);
                this.cardVideoInfo.o3(!this.cardVideoInfo.l2());
                if (this.cardVideoInfo.H() != null && this.cardVideoInfo.H().getPendantData() == null && (metaData = this.userMap.get(this.cardVideoInfo.H().getUserId())) != null && metaData.getPendantData() != null) {
                    d.a.o0.t.n nVar = new d.a.o0.t.n();
                    nVar.e(metaData.getPendantData().b());
                    nVar.d(metaData.getPendantData().a());
                    this.cardVideoInfo.H().setPendantData(nVar);
                }
            }
            if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                g gVar = new g();
                this.mFrsInsertLiveData = gVar;
                gVar.f57949f = dataRes.ala_insert_floor.intValue();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < dataRes.ala_live_insert.ala_live_list.size(); i5++) {
                    if (dataRes.ala_live_insert.ala_live_list.get(i5) != null) {
                        b2 b2Var2 = new b2();
                        b2Var2.I2(dataRes.ala_live_insert.ala_live_list.get(i5));
                        b2Var2.G1 = this.isBrandForum;
                        arrayList.add(b2Var2);
                    }
                }
                this.mFrsInsertLiveData.f57948e = arrayList;
            }
            if (dataRes.ala_stage_list != null) {
                this.mFrsStageLiveData = new h();
                ArrayList arrayList2 = new ArrayList();
                for (int i6 = 0; i6 < dataRes.ala_stage_list.size(); i6++) {
                    if (dataRes.ala_stage_list.get(i6) != null) {
                        b2 b2Var3 = new b2();
                        b2Var3.I2(dataRes.ala_stage_list.get(i6));
                        b2Var3.G1 = this.isBrandForum;
                        arrayList2.add(b2Var3);
                    }
                }
                this.mFrsStageLiveData.f57960e = arrayList2;
            }
            if (dataRes.school_recom_info != null) {
                this.schoolRecommendPos = dataRes.school_recom_pos.intValue();
                r1 r1Var = new r1();
                this.schoolRecommendInfo = r1Var;
                r1Var.s4(dataRes.school_recom_info);
            }
            if (dataRes.carrier_enter != null) {
                d.a.o0.r.q.t tVar = new d.a.o0.r.q.t();
                this.carrierEnterData = tVar;
                tVar.a(dataRes.carrier_enter);
            }
            if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                this.forumState = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                this.accessFlag = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
            }
            this.mSortType = dataRes.sort_type.intValue();
            this.needLog = dataRes.need_log.intValue();
            d.a.p0.w2.g0.a.e().h(dataRes.asp_shown_info);
            this.mCardShipinPos = dataRes.card_shipin_pos;
            if (dataRes.card_shipin_new != null) {
                for (int i7 = 0; i7 < dataRes.card_shipin_new.size(); i7++) {
                    b2 b2Var4 = new b2();
                    if (this.mCardShipinPos != null && this.mCardShipinPos.size() >= dataRes.card_shipin_new.size()) {
                        b2Var4.w3(this.mCardShipinPos.get(i7).intValue());
                    }
                    b2Var4.y3(true);
                    b2Var4.I2(dataRes.card_shipin_new.get(i7));
                    b2Var4.G1 = this.isBrandForum;
                    this.mCardShipinNew.add(b2Var4);
                }
            }
            this.enterFrsDialogInfo = dataRes.enter_pop_info;
            if (dataRes.esport != null) {
                d.a.p0.x0.b bVar = new d.a.p0.x0.b();
                this.mGameRankListData = bVar;
                bVar.d(dataRes.esport);
            }
            this.agreeBanner = dataRes.agree_banner;
            if (dataRes.user_extend != null) {
                d.a.p0.u0.w wVar = new d.a.p0.u0.w();
                this.userRecommend = wVar;
                wVar.i(dataRes.user_extend);
            }
            this.liveNotify = dataRes.live_frs_notify;
            this.gameTabInfo = dataRes.frs_game_tab_info;
            this.gameDefaultTabId = dataRes.game_default_tab_id.intValue();
            this.forumHeadIcon = dataRes.forum_head_icon;
            if (dataRes.video != null && dataRes.video.video_act != null) {
                q qVar = new q();
                this.mFrsVideoActivityData = qVar;
                qVar.b(dataRes.video.video_act);
            }
            if (dataRes.info != null) {
                this.recm_forum_list = dataRes.info.recm_forum_list;
            }
            this.forumArIno = dataRes.forum_ar_info;
            if (dataRes.star_rank_info != null) {
                this.starRank = dataRes.star_rank_info;
            }
            if (dataRes.recom_post_topic != null) {
                this.postTopic = dataRes.recom_post_topic;
            }
            this.mWindowToast = dataRes.window_toast;
            this.activityConfig = dataRes.activity_config;
            if (dataRes.video_auto_play.intValue() != 1) {
                z = false;
            }
            this.isFrsVideoAutoPlay = z;
            this.smartAppAvatar = dataRes.smart_app_avatar;
            this.smartApp = dataRes.smart_app;
            this.nebulaHotThreads = dataRes.nebula_hot_threads;
            if (dataRes.private_forum_info != null) {
                this.privateForumTotalData.d(dataRes.private_forum_info);
            }
            this.forumActiveInfo = dataRes.private_forum_active_info;
            this.userList = dataRes.user_list;
            this.mHotUserRankData = dataRes.hot_user_entry;
            this.bazhuExam = dataRes.bazhu_exam_fail;
            if (dataRes.sign_activity_info != null) {
                this.mSignActivityInfo = dataRes.sign_activity_info;
            }
            if (dataRes.add_bawu_pop != null) {
                this.bawuPopInfo = dataRes.add_bawu_pop;
            }
            if (!ListUtils.isEmpty(dataRes.service_area)) {
                this.serviceAreaData = new a0();
                ArrayList arrayList3 = new ArrayList();
                for (ServiceArea serviceArea : dataRes.service_area) {
                    if (serviceArea != null) {
                        b0 b0Var = new b0();
                        b0Var.f57912b = serviceArea.picurl;
                        b0Var.f57913c = serviceArea.servicename;
                        String str = serviceArea.service_type;
                        b0Var.f57911a = str;
                        if (str != null && str.equals("原生小程序") && serviceArea.area_smart_app != null) {
                            b0Var.f57912b = serviceArea.area_smart_app.avatar;
                            b0Var.f57913c = serviceArea.area_smart_app.name;
                        }
                        b0Var.f57914d = serviceArea.serviceurl;
                        b0Var.f57915e = serviceArea.schema;
                        b0Var.f57919i = serviceArea.third_statistics_url;
                        String str2 = serviceArea.version;
                        String p = d.a.o0.r.d0.b.j().p("frs_service_version_" + this.forum.getName() + b0Var.f57913c, "");
                        if (!TextUtils.isEmpty(p)) {
                            p.equals(serviceArea.version);
                        }
                        if (serviceArea.area_smart_app != null) {
                            c0 c0Var2 = new c0();
                            c0Var2.a(serviceArea.area_smart_app);
                            b0Var.f57916f = c0Var2;
                        }
                        if (this.forum != null) {
                            this.forum.getName();
                            b0Var.f57917g = this.forum.getId();
                        }
                        b0Var.f57918h = i2;
                        i2++;
                        arrayList3.add(b0Var);
                    }
                }
                this.serviceAreaData.f57909a = arrayList3.size();
                this.serviceAreaData.f57910b = arrayList3;
            }
            this.itemInfo = dataRes.item_info;
            this.toLoadHorseData = dataRes.is_get_horse_race_lamp;
            this.forumRule = dataRes.forum_rule;
            this.showAdsense = dataRes.show_adsense;
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
