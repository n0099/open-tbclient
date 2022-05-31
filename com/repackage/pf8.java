package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.abtest.helper.FrsTabTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.util.DataExt;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tbclient.AdMixFloor;
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
/* loaded from: classes6.dex */
public class pf8 implements x55, d65 {
    public static /* synthetic */ Interceptable $ic;
    public static final Wire WIRE;
    public transient /* synthetic */ FieldHolder $fh;
    public int accessFlag;
    public ActivityConfig activityConfig;
    public List<AdMixFloor> adMixFloor;
    public String adSampleMapKey;
    public int adShowSelect;
    public AgreeBanner agreeBanner;
    public int alaLiveCount;
    public AntiData anti;
    public String bawuCenterUrl;
    public AddBawuPopInfo bawuPopInfo;
    public on4 bookInfoData;
    public List<BottomMenu> bottomMenuList;
    public ya6 brandAdData;
    public kf8 businessPromot;
    public ThreadData cardVideoInfo;
    public in4 carrierEnterData;
    public List<CategoryInfo> categoryInfos;
    public df8 chatGroup;
    public ArrayList<kn4> color_eggs;
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
    public PopInfo frsMaskPopInfo;
    public int gameDefaultTabId;
    public String gameName;
    public List<FrsTabInfo> gameTabInfo;
    public String gameUrl;
    public vf8 gconAccount;
    public boolean hasGame;
    public wn4 headSdkData;
    public rn4 headlineImgInfoData;
    public boolean isBrandForum;
    public boolean isFromCache;
    public boolean isFrsVideoAutoPlay;
    public int isNewUrl;
    public boolean isShowRedTip;
    public ItemInfo itemInfo;
    public List<FeedForumData> likeFeedForumDataList;
    public AlaLiveNotify liveNotify;
    public nn4 mActivityHeadData;
    public List<jn> mCardShipinNew;
    public List<Integer> mCardShipinPos;
    public long mDataParseTime;
    public rf8 mEntelechyTabInfo;
    public int mErrorNo;
    public if8 mFrsInsertLiveData;
    public jf8 mFrsStageLiveData;
    public uf8 mFrsVideoActivityData;
    public zp6 mGameRankListData;
    public boolean mHasThreadExceptTop;
    public HotUserRankEntry mHotUserRankData;
    public FrsTabInfo mNewChapterInfo;
    public PrivateForumPopInfoData mPrivateForumPopInfoData;
    public SignActivityInfo mSignActivityInfo;
    public int mSortType;
    public List<WindowToast> mWindowToast;
    public Integer mangaReadRecordChapterId;
    public NebulaHotThreads nebulaHotThreads;
    public int needLog;
    public List<OriForumInfo> oriForumInfoList;
    public po4 page;
    public int photoLivePos;
    public RecomPostTopic postTopic;
    public un4 presentInfoData;
    public yo4 privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    public xn4 recommendBookData;
    public gp4 schoolRecommendInfo;
    public int schoolRecommendPos;
    public fg8 serviceAreaData;
    public List<Map<String, Object>> serviceAreaFlutterData;
    public Integer showAdsense;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    public qf8 star;
    public List<mf8> starEnter;
    public StarRank starRank;
    public ArrayList<jn> threadList;
    public List<Long> threadListIds;
    public Integer toLoadHorseData;
    public List<jn> topThreadList;
    public UserData userData;
    public List<User> userList;
    public HashMap<String, MetaData> userMap;
    public rb6 userRecommend;
    @Nullable
    public yw4 voiceRoomConfig;
    @Nullable
    public zw4 voiceRoomData;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755411729, "Lcom/repackage/pf8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755411729, "Lcom/repackage/pf8;");
                return;
            }
        }
        WIRE = new Wire(new Class[0]);
    }

    public pf8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.mEntelechyTabInfo = new rf8();
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
        this.serviceAreaFlutterData = new ArrayList();
        initData();
    }

    private void handleDefaultTab(int i) {
        List<FrsTabInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
            this.frsDefaultTabId = 1;
            rf8 rf8Var = this.mEntelechyTabInfo;
            if (rf8Var == null || (list = rf8Var.a) == null || list.size() <= 0) {
                return;
            }
            for (FrsTabInfo frsTabInfo : this.mEntelechyTabInfo.a) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() == i) {
                    this.frsDefaultTabId = i;
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
            this.page = new po4();
            this.star = new qf8();
            this.userData = new UserData();
            this.gconAccount = new vf8();
            setAnti(new AntiData());
            setChatGroup(new df8());
            this.privateForumTotalData = new yo4();
            this.mCardShipinNew = new ArrayList();
            this.mCardShipinPos = new ArrayList();
        }
    }

    public void convertThreadInfoToThreadData(DataRes dataRes, List<ThreadInfo> list, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dataRes, list, Long.valueOf(j)}) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                ThreadData threadData = new ThreadData();
                threadData.setDispatchedForumId(dataRes.forum.id.longValue());
                SpecHotTopicHelper.setSpecTopicIcon(j, threadData);
                threadData.setUserMap(this.userMap);
                threadData.setFromFrs(true);
                threadData.parserProtobuf(threadInfo);
                threadData.parser_title();
                threadData.insertItemToTitleOrAbstractText();
                if (threadData.getFid() == 0 && j != 0) {
                    threadData.setFid(j);
                }
                if (StringUtils.isNull(threadData.getForum_name())) {
                    threadData.setForum_name(this.forum.getName());
                }
                threadData.setForumAvatar(this.forum.getImage_url());
                threadData.parseStyle_flag(this.color_eggs);
                threadData.isFromBrandForum = this.forum.isBrandForum;
                if (!TextUtils.isEmpty(threadData.getLegoCard())) {
                    eo4 eo4Var = new eo4();
                    eo4Var.i(threadData.getLegoCard());
                    this.threadList.add(eo4Var);
                } else {
                    this.threadList.add(threadData);
                    JSONObject c = b98.c(threadInfo, threadData.getForum_name());
                    if (c != null) {
                        arrayList.add(c);
                    }
                }
            }
        }
        b98.f().h("FRS", arrayList);
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

    public nn4 getActivityHeadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mActivityHeadData : (nn4) invokeV.objValue;
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

    public on4 getBookInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.bookInfoData : (on4) invokeV.objValue;
    }

    public kf8 getBusinessPromot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.businessPromot : (kf8) invokeV.objValue;
    }

    @Override // com.repackage.y55
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public List<jn> getCardShipinNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mCardShipinNew : (List) invokeV.objValue;
    }

    public List<Integer> getCardShipinPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mCardShipinPos : (List) invokeV.objValue;
    }

    public ThreadData getCardVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.cardVideoInfo : (ThreadData) invokeV.objValue;
    }

    public in4 getCarrierEnterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.carrierEnterData : (in4) invokeV.objValue;
    }

    public List<CategoryInfo> getCategoryInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.categoryInfos : (List) invokeV.objValue;
    }

    public df8 getChatGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.chatGroup : (df8) invokeV.objValue;
    }

    public long getDataParseTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mDataParseTime : invokeV.longValue;
    }

    public rf8 getEntelechyTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mEntelechyTabInfo : (rf8) invokeV.objValue;
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

    public if8 getFrsInsertLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mFrsInsertLiveData : (if8) invokeV.objValue;
    }

    public jf8 getFrsStageLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mFrsStageLiveData : (jf8) invokeV.objValue;
    }

    public uf8 getFrsVideoActivityData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mFrsVideoActivityData : (uf8) invokeV.objValue;
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

    public zp6 getGameRankListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mGameRankListData : (zp6) invokeV.objValue;
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

    public vf8 getGconAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.gconAccount : (vf8) invokeV.objValue;
    }

    public wn4 getHeadSdkData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.headSdkData : (wn4) invokeV.objValue;
    }

    public rn4 getHeadlineImgInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.headlineImgInfoData : (rn4) invokeV.objValue;
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

    public po4 getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.page : (po4) invokeV.objValue;
    }

    public int getPhotoLivePos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.photoLivePos : invokeV.intValue;
    }

    public PrivateForumPopInfoData getPrivateForumPopInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mPrivateForumPopInfoData : (PrivateForumPopInfoData) invokeV.objValue;
    }

    public yo4 getPrivateForumTotalInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.privateForumTotalData : (yo4) invokeV.objValue;
    }

    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.recm_forum_list : (List) invokeV.objValue;
    }

    public int getSchoolRecommendPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.schoolRecommendPos : invokeV.intValue;
    }

    public gp4 getSchoolRecommendUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.schoolRecommendInfo : (gp4) invokeV.objValue;
    }

    public int getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mSortType : invokeV.intValue;
    }

    public qf8 getStar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.star : (qf8) invokeV.objValue;
    }

    public List<mf8> getStarEnter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.starEnter : (List) invokeV.objValue;
    }

    public ArrayList<jn> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.threadList : (ArrayList) invokeV.objValue;
    }

    public List<Long> getThreadListIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.threadListIds : (List) invokeV.objValue;
    }

    public Integer getToLoadHorseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.toLoadHorseData : (Integer) invokeV.objValue;
    }

    public UserData getUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.userData : (UserData) invokeV.objValue;
    }

    public HashMap<String, MetaData> getUserMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.userMap : (HashMap) invokeV.objValue;
    }

    public rb6 getUserRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.userRecommend : (rb6) invokeV.objValue;
    }

    @NonNull
    public yw4 getVoiceRoomConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            yw4 yw4Var = this.voiceRoomConfig;
            return yw4Var != null ? yw4Var : yw4.b;
        }
        return (yw4) invokeV.objValue;
    }

    public zw4 getVoiceRoomData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.voiceRoomData : (zw4) invokeV.objValue;
    }

    @Override // com.repackage.x55
    public boolean initByByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, bArr)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.d65
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, jSONObject) == null) {
        }
    }

    @Override // com.repackage.d65
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, message) == null) {
        }
    }

    public boolean isFortuneBag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.fortuneBag : invokeV.booleanValue;
    }

    public boolean isHasGame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.hasGame : invokeV.booleanValue;
    }

    public boolean isShowRedTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.isShowRedTip : invokeV.booleanValue;
    }

    public FrsPageResIdl parserProtobuf(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048640, this, bArr, z)) == null) {
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
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (FrsPageResIdl) invokeLZ.objValue;
    }

    public void setAccessFlag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i) == null) {
            this.accessFlag = i;
        }
    }

    public void setActivityHeadData(nn4 nn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, nn4Var) == null) {
            this.mActivityHeadData = nn4Var;
        }
    }

    public void setAgreeBanner(AgreeBanner agreeBanner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, agreeBanner) == null) {
            this.agreeBanner = agreeBanner;
        }
    }

    public void setAlaLiveCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
            this.alaLiveCount = i;
        }
    }

    public void setAnti(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, antiData) == null) {
            this.anti = antiData;
        }
    }

    public void setBawuCenterUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            this.bawuCenterUrl = str;
        }
    }

    public void setBookInfo(on4 on4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, on4Var) == null) {
            this.bookInfoData = on4Var;
        }
    }

    public void setBusinessPromot(kf8 kf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, kf8Var) == null) {
            this.businessPromot = kf8Var;
        }
    }

    public void setCardShipinNew(List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, list) == null) {
            this.mCardShipinNew = list;
        }
    }

    public void setCardShipinPos(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, list) == null) {
            this.mCardShipinPos = list;
        }
    }

    public void setCardVideoInfo(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, threadData) == null) {
            this.cardVideoInfo = threadData;
        }
    }

    public void setCarrierEnterData(in4 in4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, in4Var) == null) {
            this.carrierEnterData = in4Var;
        }
    }

    public void setCategoryInfos(List<CategoryInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, list) == null) {
            this.categoryInfos = list;
        }
    }

    public void setChatGroup(df8 df8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, df8Var) == null) {
            this.chatGroup = df8Var;
        }
    }

    public void setEntelechyTabInfo(rf8 rf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, rf8Var) == null) {
            this.mEntelechyTabInfo = rf8Var;
        }
    }

    public void setFortuneBag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048657, this, z) == null) {
            this.fortuneBag = z;
        }
    }

    public void setFortuneDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, str) == null) {
            this.fortuneDesc = str;
        }
    }

    public void setForum(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, forumData) == null) {
            this.forum = forumData;
        }
    }

    public void setForumHeadIcon(ForumHeadIcon forumHeadIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, forumHeadIcon) == null) {
            this.forumHeadIcon = forumHeadIcon;
        }
    }

    public void setForumState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i) == null) {
            this.forumState = i;
        }
    }

    public void setFrsDefaultTabId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048662, this, i) == null) {
            this.frsDefaultTabId = i;
        }
    }

    public void setFrsInsertLiveData(if8 if8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, if8Var) == null) {
            this.mFrsInsertLiveData = if8Var;
        }
    }

    public void setFrsStageLiveData(jf8 jf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, jf8Var) == null) {
            this.mFrsStageLiveData = jf8Var;
        }
    }

    public void setFrsVideoActivityData(uf8 uf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, uf8Var) == null) {
            this.mFrsVideoActivityData = uf8Var;
        }
    }

    public void setGameDefaultTabId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048666, this, i) == null) {
            this.gameDefaultTabId = i;
        }
    }

    public void setGameName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, str) == null) {
            this.gameName = str;
        }
    }

    public void setGameRankListData(zp6 zp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, zp6Var) == null) {
            this.mGameRankListData = zp6Var;
        }
    }

    public void setGameTabInfo(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, list) == null) {
            this.gameTabInfo = list;
        }
    }

    public void setGameUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, str) == null) {
            this.gameUrl = str;
        }
    }

    public void setGconAccount(vf8 vf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, vf8Var) == null) {
            this.gconAccount = vf8Var;
        }
    }

    public void setHasGame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048672, this, z) == null) {
            this.hasGame = z;
        }
    }

    public void setHeadSdkData(wn4 wn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, wn4Var) == null) {
            this.headSdkData = wn4Var;
        }
    }

    public void setHeadlineImgInfoData(rn4 rn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, rn4Var) == null) {
            this.headlineImgInfoData = rn4Var;
        }
    }

    public void setHotUserRankData(HotUserRankEntry hotUserRankEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, hotUserRankEntry) == null) {
            this.mHotUserRankData = hotUserRankEntry;
        }
    }

    public void setIsNewUrl(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048676, this, i) == null) {
            this.isNewUrl = i;
        }
    }

    public void setIsShowRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048677, this, z) == null) {
            this.isShowRedTip = z;
        }
    }

    public void setLikeFeedForumDataList(List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, list) == null) {
            this.likeFeedForumDataList = list;
        }
    }

    public void setLiveNotify(AlaLiveNotify alaLiveNotify) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, alaLiveNotify) == null) {
            this.liveNotify = alaLiveNotify;
        }
    }

    public void setMangaReadRecordChapterId(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, num) == null) {
            this.mangaReadRecordChapterId = num;
        }
    }

    public void setPage(po4 po4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, po4Var) == null) {
            this.page = po4Var;
        }
    }

    public void setPhotoLivePos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i) == null) {
            this.photoLivePos = i;
        }
    }

    public void setPrivateForumPopInfoData(PrivateForumPopInfoData privateForumPopInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, privateForumPopInfoData) == null) {
            this.mPrivateForumPopInfoData = privateForumPopInfoData;
        }
    }

    public void setPrivateForumTotalInfo(yo4 yo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, yo4Var) == null) {
            this.privateForumTotalData = yo4Var;
        }
    }

    public void setSchoolRecommendInfo(gp4 gp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, gp4Var) == null) {
            this.schoolRecommendInfo = gp4Var;
        }
    }

    public void setSchoolRecommendPos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048686, this, i) == null) {
            this.schoolRecommendPos = i;
        }
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048687, this, i) == null) {
            this.mSortType = i;
        }
    }

    public void setStar(qf8 qf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, qf8Var) == null) {
            this.star = qf8Var;
        }
    }

    public void setStarEnter(List<mf8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, list) == null) {
            this.starEnter = list;
        }
    }

    public void setThreadList(ArrayList<jn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, arrayList) == null) {
            this.threadList = arrayList;
        }
    }

    public void setThreadListIds(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, list) == null) {
            this.threadListIds = list;
        }
    }

    public void setUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, userData) == null) {
            this.userData = userData;
        }
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, hashMap) == null) {
            this.userMap = hashMap;
        }
    }

    public void setUserRecommend(rb6 rb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, rb6Var) == null) {
            this.userRecommend = rb6Var;
        }
    }

    public void setVoiceRoomConfig(@Nullable yw4 yw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, yw4Var) == null) {
            this.voiceRoomConfig = yw4Var;
        }
    }

    public zw4 setVoiceRoomData(zw4 zw4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048696, this, zw4Var)) == null) {
            this.voiceRoomData = zw4Var;
            return zw4Var;
        }
        return (zw4) invokeL.objValue;
    }

    public ArrayList<jn> switchThreadDataToThreadCardInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            ArrayList<jn> switchThreadDataToThreadCardInfo = switchThreadDataToThreadCardInfo(this.threadList);
            setThreadList(switchThreadDataToThreadCardInfo);
            return switchThreadDataToThreadCardInfo;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.repackage.x55
    public byte[] toCacheByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public ArrayList<jn> switchThreadDataToThreadCardInfo(ArrayList<jn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048698, this, arrayList)) == null) {
            this.mHasThreadExceptTop = false;
            ArrayList<jn> arrayList2 = new ArrayList<>();
            Iterator<jn> it = arrayList.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                jn next = it.next();
                if (next instanceof co4) {
                    ((co4) next).setPosition(i - i2);
                    arrayList2.add(next);
                } else if (next instanceof eo4) {
                    ((eo4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (threadData.isTop()) {
                        i2++;
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        rp4 rp4Var = new rp4();
                        rp4Var.s = threadData;
                        rp4Var.position = i;
                        rp4Var.a = true;
                        rp4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(rp4Var);
                        rp4 rp4Var2 = new rp4();
                        rp4Var2.s = threadData;
                        rp4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            rp4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            rp4Var2.d = true;
                            rp4Var2.t = imageWidthAndHeight[0];
                            rp4Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            rp4Var2.e = true;
                        } else {
                            rp4Var2.b = true;
                        }
                        rp4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(rp4Var2);
                        if (threadData.getPollData() != null) {
                            rp4 rp4Var3 = new rp4();
                            rp4Var3.o = true;
                            rp4Var3.s = threadData;
                            rp4Var3.position = i;
                            rp4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            rp4 rp4Var4 = new rp4();
                            rp4Var4.l = true;
                            rp4Var4.s = threadData;
                            rp4Var4.position = i;
                            rp4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            rp4 rp4Var5 = new rp4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                rp4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                rp4Var5.q = true;
                            }
                            rp4Var5.s = threadData;
                            rp4Var5.position = i;
                            rp4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            rp4 rp4Var6 = new rp4();
                            rp4Var6.h = true;
                            rp4Var6.s = threadData;
                            rp4Var6.position = i;
                            rp4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var6);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            rp4 rp4Var7 = new rp4();
                            rp4Var7.n = true;
                            rp4Var7.s = threadData;
                            rp4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var7);
                        }
                        rp4 rp4Var8 = new rp4();
                        rp4Var8.g = true;
                        rp4Var8.s = threadData;
                        rp4Var8.position = i;
                        rp4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(rp4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        rp4 rp4Var9 = new rp4();
                        rp4Var9.s = threadData;
                        rp4Var9.position = i;
                        rp4Var9.a = true;
                        rp4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(rp4Var9);
                        rp4 rp4Var10 = new rp4();
                        rp4Var10.s = threadData;
                        rp4Var10.position = i;
                        if (threadData instanceof mo4) {
                            rp4Var10.j = true;
                        } else {
                            rp4Var10.i = true;
                        }
                        rp4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(rp4Var10);
                        if (threadData.getPollData() != null) {
                            rp4 rp4Var11 = new rp4();
                            rp4Var11.o = true;
                            rp4Var11.s = threadData;
                            rp4Var11.position = i;
                            rp4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            rp4 rp4Var12 = new rp4();
                            rp4Var12.l = true;
                            rp4Var12.s = threadData;
                            rp4Var12.position = i;
                            rp4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            rp4 rp4Var13 = new rp4();
                            rp4Var13.h = true;
                            rp4Var13.s = threadData;
                            rp4Var13.position = i;
                            rp4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var13);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            rp4 rp4Var14 = new rp4();
                            rp4Var14.n = true;
                            rp4Var14.s = threadData;
                            rp4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var14);
                        }
                        rp4 rp4Var15 = new rp4();
                        rp4Var15.g = true;
                        rp4Var15.s = threadData;
                        rp4Var15.position = i;
                        rp4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(rp4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        rp4 rp4Var16 = new rp4();
                        rp4Var16.s = threadData;
                        rp4Var16.position = i;
                        rp4Var16.a = true;
                        rp4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(rp4Var16);
                        rp4 rp4Var17 = new rp4();
                        rp4Var17.s = threadData;
                        rp4Var17.position = i;
                        rp4Var17.k = true;
                        rp4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(rp4Var17);
                        if (threadData.getPollData() != null) {
                            rp4 rp4Var18 = new rp4();
                            rp4Var18.o = true;
                            rp4Var18.s = threadData;
                            rp4Var18.position = i;
                            rp4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            rp4 rp4Var19 = new rp4();
                            rp4Var19.l = true;
                            rp4Var19.s = threadData;
                            rp4Var19.position = i;
                            rp4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            rp4 rp4Var20 = new rp4();
                            rp4Var20.h = true;
                            rp4Var20.s = threadData;
                            rp4Var20.position = i;
                            rp4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var20);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            rp4 rp4Var21 = new rp4();
                            rp4Var21.n = true;
                            rp4Var21.s = threadData;
                            rp4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var21);
                        }
                        rp4 rp4Var22 = new rp4();
                        rp4Var22.g = true;
                        rp4Var22.s = threadData;
                        rp4Var22.position = i;
                        rp4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(rp4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        rp4 rp4Var23 = new rp4();
                        rp4Var23.s = threadData;
                        rp4Var23.position = i;
                        arrayList2.add(rp4Var23);
                    }
                    i++;
                    threadData.setSupportType(BaseCardInfo.SupportType.TOP);
                    if (next != null && next.getType() != ThreadData.TYPE_TOP) {
                        this.mHasThreadExceptTop = true;
                    }
                } else {
                    arrayList2.add(next);
                }
                i++;
                if (next != null) {
                    this.mHasThreadExceptTop = true;
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void parserProtobuf(DataRes dataRes) {
        long j;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048641, this, dataRes) == null) || dataRes == null) {
            return;
        }
        try {
            initData();
            if (!ListUtils.isEmpty(dataRes.color_egg)) {
                for (ColorEgg colorEgg : dataRes.color_egg) {
                    if (colorEgg != null && !ListUtils.isEmpty(colorEgg.holiday_words)) {
                        kn4 kn4Var = new kn4();
                        if (kn4Var.c(colorEgg)) {
                            this.color_eggs.add(kn4Var);
                        }
                    }
                }
            }
            int i = 0;
            if (dataRes.forum != null) {
                this.hasGame = dataRes.forum.has_game.intValue() == 1;
                this.gameUrl = dataRes.forum.game_url;
                this.gameName = dataRes.forum.game_name;
                this.isBrandForum = dataRes.forum.is_brand_forum.intValue() == 1;
            }
            if (this.isBrandForum && dataRes.brand_forum_info != null) {
                nn4 nn4Var = new nn4();
                this.mActivityHeadData = nn4Var;
                nn4Var.e(dataRes.brand_forum_info.head_imgs);
                ya6 ya6Var = new ya6();
                this.brandAdData = ya6Var;
                ya6Var.a(dataRes.brand_forum_info);
                if (!ListUtils.isEmpty(dataRes.brand_forum_info.relation_forum)) {
                    this.oriForumInfoList = new ArrayList();
                    for (OriForumInfo oriForumInfo : dataRes.brand_forum_info.relation_forum) {
                        if (oriForumInfo != null) {
                            this.oriForumInfoList.add(oriForumInfo);
                        }
                    }
                }
            } else if (dataRes.activityhead != null) {
                long longValue = dataRes.forum != null ? dataRes.forum.id.longValue() : 0L;
                nn4 nn4Var2 = new nn4();
                this.mActivityHeadData = nn4Var2;
                nn4Var2.d(dataRes.activityhead, longValue);
            } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !ki.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
                nn4 nn4Var3 = new nn4();
                this.mActivityHeadData = nn4Var3;
                nn4Var3.e(dataRes.private_forum_info.head_imgs);
            }
            this.bottomMenuList = dataRes.bottom_menu;
            this.adMixFloor = dataRes.ad_mix_list;
            this.adShowSelect = dataRes.ad_show_select.intValue();
            this.adSampleMapKey = dataRes.ad_sample_map_key;
            List<User> list = dataRes.user_list;
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    MetaData metaData2 = new MetaData();
                    metaData2.parserProtobuf(list.get(i2));
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
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    mf8 mf8Var = new mf8();
                    mf8Var.k(list2.get(i3));
                    this.starEnter.add(mf8Var);
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
                tn8.f(dataRes.anti.block_pop_info);
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
                this.mEntelechyTabInfo.a(builder.build(true));
            } else {
                this.mEntelechyTabInfo.a(dataRes.nav_tab_info);
            }
            this.defaultShowTab = 1;
            if (UbsABTestHelper.isFrsTabLocationTest() && !FrsTabTestHelper.NEW_AREA_TAB_NAME.equals(((FrsTabInfo) ListUtils.getItem(this.mEntelechyTabInfo.a, 0)).tab_name)) {
                this.defaultShowTab = FrsTabTestHelper.getDefaultShowTabId();
            }
            if (this.mEntelechyTabInfo != null && !ListUtils.isEmpty(this.mEntelechyTabInfo.c)) {
                this.mNewChapterInfo = this.mEntelechyTabInfo.c.get(0);
            }
            this.alaLiveCount = dataRes.ala_live_count.intValue();
            handleDefaultTab(dataRes.frs_tab_default.intValue());
            this.photoLivePos = dataRes.twzhibo_pos.intValue();
            this.isShowRedTip = dataRes.trends_redpoint.intValue() == 1;
            convertThreadInfoToThreadData(dataRes, dataRes.thread_list, j);
            this.categoryInfos = dataRes.category_list;
            if (!ki.isEmpty(dataRes.bawu_enter_url)) {
                this.bawuCenterUrl = dataRes.bawu_enter_url;
            }
            if (dataRes.head_sdk != null) {
                wn4 wn4Var = new wn4();
                this.headSdkData = wn4Var;
                wn4Var.a(dataRes.head_sdk);
            }
            if (dataRes.recommend_book != null) {
                xn4 xn4Var = new xn4();
                this.recommendBookData = xn4Var;
                xn4Var.e(dataRes.recommend_book);
            }
            if (dataRes.book_info != null) {
                on4 on4Var = new on4();
                this.bookInfoData = on4Var;
                on4Var.c(dataRes.book_info);
            }
            if (dataRes.forum_present_info != null) {
                un4 un4Var = new un4();
                this.presentInfoData = un4Var;
                un4Var.a(dataRes.forum_present_info);
            }
            if (dataRes.forum_headline_img_info != null) {
                rn4 rn4Var = new rn4();
                this.headlineImgInfoData = rn4Var;
                rn4Var.b(dataRes.forum_headline_img_info);
            }
            if (dataRes.business_promot != null) {
                kf8 kf8Var = new kf8();
                this.businessPromot = kf8Var;
                kf8Var.r(dataRes.business_promot);
            }
            if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                ThreadData threadData = new ThreadData();
                this.cardVideoInfo = threadData;
                threadData.setIsInsertThread(true);
                this.cardVideoInfo.setInsertFloor(this.photoLivePos);
                this.cardVideoInfo.setUserMap(this.userMap);
                this.cardVideoInfo.parserProtobuf(dataRes.card_shipin_info.get(0));
                this.cardVideoInfo.parser_title();
                this.cardVideoInfo.isFromBrandForum = this.isBrandForum;
                if (this.cardVideoInfo.getFid() == 0 && j != 0) {
                    this.cardVideoInfo.setFid(j);
                }
                this.cardVideoInfo.parseStyle_flag(this.color_eggs);
                this.cardVideoInfo.setFloor5Video(!this.cardVideoInfo.isTbReadDispatch());
                if (this.cardVideoInfo.getAuthor() != null && this.cardVideoInfo.getAuthor().getPendantData() == null && (metaData = this.userMap.get(this.cardVideoInfo.getAuthor().getUserId())) != null && metaData.getPendantData() != null) {
                    UserPendantData userPendantData = new UserPendantData();
                    userPendantData.setPropsId(metaData.getPendantData().getPropsId());
                    userPendantData.setImgUrl(metaData.getPendantData().getImgUrl());
                    this.cardVideoInfo.getAuthor().setPendantData(userPendantData);
                }
            }
            if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                if8 if8Var = new if8();
                this.mFrsInsertLiveData = if8Var;
                if8Var.b = dataRes.ala_insert_floor.intValue();
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < dataRes.ala_live_insert.ala_live_list.size(); i4++) {
                    if (dataRes.ala_live_insert.ala_live_list.get(i4) != null) {
                        ThreadData threadData2 = new ThreadData();
                        threadData2.parserProtobuf(dataRes.ala_live_insert.ala_live_list.get(i4));
                        threadData2.isFromBrandForum = this.isBrandForum;
                        arrayList.add(threadData2);
                    }
                }
                this.mFrsInsertLiveData.a = arrayList;
            }
            if (dataRes.ala_stage_list != null) {
                this.mFrsStageLiveData = new jf8();
                ArrayList arrayList2 = new ArrayList();
                for (int i5 = 0; i5 < dataRes.ala_stage_list.size(); i5++) {
                    if (dataRes.ala_stage_list.get(i5) != null) {
                        ThreadData threadData3 = new ThreadData();
                        threadData3.parserProtobuf(dataRes.ala_stage_list.get(i5));
                        threadData3.isFromBrandForum = this.isBrandForum;
                        arrayList2.add(threadData3);
                    }
                }
                this.mFrsStageLiveData.a = arrayList2;
            }
            if (dataRes.school_recom_info != null) {
                this.schoolRecommendPos = dataRes.school_recom_pos.intValue();
                gp4 gp4Var = new gp4();
                this.schoolRecommendInfo = gp4Var;
                gp4Var.g(dataRes.school_recom_info);
            }
            if (dataRes.carrier_enter != null) {
                in4 in4Var = new in4();
                this.carrierEnterData = in4Var;
                in4Var.a(dataRes.carrier_enter);
            }
            if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                this.forumState = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                this.accessFlag = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
            }
            this.mSortType = dataRes.sort_type.intValue();
            this.needLog = dataRes.need_log.intValue();
            y88.e().h(dataRes.asp_shown_info);
            this.mCardShipinPos = dataRes.card_shipin_pos;
            if (dataRes.card_shipin_new != null) {
                for (int i6 = 0; i6 < dataRes.card_shipin_new.size(); i6++) {
                    ThreadData threadData4 = new ThreadData();
                    if (this.mCardShipinPos != null && this.mCardShipinPos.size() >= dataRes.card_shipin_new.size()) {
                        threadData4.setInsertFloor(this.mCardShipinPos.get(i6).intValue());
                    }
                    threadData4.setIsInsertThread(true);
                    threadData4.parserProtobuf(dataRes.card_shipin_new.get(i6));
                    threadData4.isFromBrandForum = this.isBrandForum;
                    this.mCardShipinNew.add(threadData4);
                }
            }
            this.enterFrsDialogInfo = dataRes.enter_pop_info;
            if (dataRes.esport != null) {
                zp6 zp6Var = new zp6();
                this.mGameRankListData = zp6Var;
                zp6Var.e(dataRes.esport);
            }
            this.agreeBanner = dataRes.agree_banner;
            if (dataRes.user_extend != null) {
                rb6 rb6Var = new rb6();
                this.userRecommend = rb6Var;
                rb6Var.i(dataRes.user_extend);
            }
            this.liveNotify = dataRes.live_frs_notify;
            this.gameTabInfo = dataRes.frs_game_tab_info;
            this.gameDefaultTabId = dataRes.game_default_tab_id.intValue();
            this.forumHeadIcon = dataRes.forum_head_icon;
            if (dataRes.video != null && dataRes.video.video_act != null) {
                uf8 uf8Var = new uf8();
                this.mFrsVideoActivityData = uf8Var;
                uf8Var.a(dataRes.video.video_act);
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
            this.isFrsVideoAutoPlay = TbadkCoreApplication.getInst().canAutoPlaySwitch();
            this.smartAppAvatar = dataRes.smart_app_avatar;
            this.smartApp = dataRes.smart_app;
            this.nebulaHotThreads = dataRes.nebula_hot_threads;
            if (dataRes.private_forum_info != null) {
                this.privateForumTotalData.d(dataRes.private_forum_info);
            }
            if (dataRes.bawutask_pop != null) {
                PrivateForumPopInfoData privateForumPopInfoData = new PrivateForumPopInfoData();
                this.mPrivateForumPopInfoData = privateForumPopInfoData;
                privateForumPopInfoData.D(dataRes.bawutask_pop);
            }
            this.forumActiveInfo = dataRes.private_forum_active_info;
            this.userList = dataRes.user_list;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_user_entry;
            this.mHotUserRankData = hotUserRankEntry;
            if (hotUserRankEntry != null) {
                ServiceArea.Builder builder2 = new ServiceArea.Builder();
                builder2.picurl = "icon_mask_service_celebrity24";
                builder2.servicename = "本吧红人榜";
                builder2.service_type = "本吧红人榜";
                this.serviceAreaFlutterData.add(DataExt.toMap(builder2.build(true)));
            }
            if (dataRes.sign_activity_info != null) {
                this.mSignActivityInfo = dataRes.sign_activity_info;
            }
            if (dataRes.add_bawu_pop != null) {
                this.bawuPopInfo = dataRes.add_bawu_pop;
            }
            if (!ListUtils.isEmpty(dataRes.service_area)) {
                this.serviceAreaData = new fg8();
                ArrayList arrayList3 = new ArrayList();
                for (ServiceArea serviceArea : dataRes.service_area) {
                    if (serviceArea != null) {
                        this.serviceAreaFlutterData.add(DataExt.toMap(serviceArea));
                        gg8 gg8Var = new gg8();
                        gg8Var.b = serviceArea.picurl;
                        gg8Var.c = serviceArea.servicename;
                        String str = serviceArea.service_type;
                        gg8Var.a = str;
                        if (str != null && str.equals("原生小程序") && serviceArea.area_smart_app != null) {
                            gg8Var.b = serviceArea.area_smart_app.avatar;
                            gg8Var.c = serviceArea.area_smart_app.name;
                        }
                        gg8Var.d = serviceArea.serviceurl;
                        gg8Var.e = serviceArea.schema;
                        gg8Var.i = serviceArea.third_statistics_url;
                        String str2 = serviceArea.version;
                        String q = ys4.k().q("frs_service_version_" + this.forum.getName() + gg8Var.c, "");
                        if (!TextUtils.isEmpty(q)) {
                            q.equals(serviceArea.version);
                        }
                        if (serviceArea.area_smart_app != null) {
                            hg8 hg8Var = new hg8();
                            hg8Var.a(serviceArea.area_smart_app);
                            gg8Var.f = hg8Var;
                        }
                        if (this.forum != null) {
                            this.forum.getName();
                            gg8Var.g = this.forum.getId();
                        }
                        gg8Var.h = i;
                        i++;
                        arrayList3.add(gg8Var);
                    }
                }
                this.serviceAreaData.a = arrayList3.size();
                this.serviceAreaData.b = arrayList3;
            }
            this.itemInfo = dataRes.item_info;
            this.toLoadHorseData = dataRes.is_get_horse_race_lamp;
            this.forumRule = dataRes.forum_rule;
            this.showAdsense = dataRes.show_adsense;
            this.frsMaskPopInfo = dataRes.frsmask_pop_info;
            this.voiceRoomConfig = yw4.c(dataRes);
            zw4 zw4Var = new zw4();
            this.voiceRoomData = zw4Var;
            zw4Var.d(dataRes);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
