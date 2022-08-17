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
import com.baidu.tbadk.core.data.ForumTagInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PrivateForumPopInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
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
import tbclient.FrsPage.LiveFuseForumData;
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
/* loaded from: classes7.dex */
public class qj8 implements n85, t85 {
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
    public int baWuNoticeNum;
    public String bawuCenterUrl;
    public AddBawuPopInfo bawuPopInfo;
    public fp4 bookInfoData;
    public List<BottomMenu> bottomMenuList;
    public ne6 brandAdData;
    public lj8 businessPromot;
    public ThreadData cardVideoInfo;
    public zo4 carrierEnterData;
    public List<CategoryInfo> categoryInfos;
    public ej8 chatGroup;
    public ArrayList<bp4> color_eggs;
    public int defaultShowTab;
    public PopInfo enterFrsDialogInfo;
    public String firstCategory;
    public boolean fortuneBag;
    public String fortuneDesc;
    public ForumData forum;
    public ForumActiveInfo forumActiveInfo;
    public ForumArIno forumArIno;
    public ForumHeadIcon forumHeadIcon;
    public ForumRuleStatus forumRule;
    public int forumState;
    public ForumTagInfo forumTagInfo;
    public int frsDefaultTabId;
    public PopInfo frsMaskPopInfo;
    public int gameDefaultTabId;
    public String gameName;
    public List<FrsTabInfo> gameTabInfo;
    public String gameUrl;
    public wj8 gconAccount;
    public boolean hasGame;
    public np4 headSdkData;
    public ip4 headlineImgInfoData;
    public boolean isBrandForum;
    public boolean isFromCache;
    public boolean isFrsVideoAutoPlay;
    public int isNewUrl;
    public boolean isShowRedTip;
    public ItemInfo itemInfo;
    public List<FeedForumData> likeFeedForumDataList;
    public List<LiveFuseForumData> liveFuseForumDataList;
    public AlaLiveNotify liveNotify;
    public ep4 mActivityHeadData;
    public List<on> mCardShipinNew;
    public List<Integer> mCardShipinPos;
    public long mDataParseTime;
    public sj8 mEntelechyTabInfo;
    public int mErrorNo;
    public jj8 mFrsInsertLiveData;
    public kj8 mFrsStageLiveData;
    public vj8 mFrsVideoActivityData;
    public it6 mGameRankListData;
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
    public gq4 page;
    public int photoLivePos;
    public RecomPostTopic postTopic;
    public lp4 presentInfoData;
    public pq4 privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    public op4 recommendBookData;
    public xq4 schoolRecommendInfo;
    public int schoolRecommendPos;
    public gk8 serviceAreaData;
    public List<Map<String, Object>> serviceAreaFlutterData;
    public Integer showAdsense;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    public rj8 star;
    public List<nj8> starEnter;
    public StarRank starRank;
    public ArrayList<on> threadList;
    public List<Long> threadListIds;
    public Integer toLoadHorseData;
    public List<on> topThreadList;
    public UserData userData;
    public List<User> userList;
    public HashMap<String, MetaData> userMap;
    public gf6 userRecommend;
    @Nullable
    public cz4 voiceRoomConfig;
    @Nullable
    public dz4 voiceRoomData;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755378094, "Lcom/repackage/qj8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755378094, "Lcom/repackage/qj8;");
                return;
            }
        }
        WIRE = new Wire(new Class[0]);
    }

    public qj8() {
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
        this.mEntelechyTabInfo = new sj8();
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
            sj8 sj8Var = this.mEntelechyTabInfo;
            if (sj8Var == null || (list = sj8Var.a) == null || list.size() <= 0) {
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
            this.page = new gq4();
            this.star = new rj8();
            this.userData = new UserData();
            this.gconAccount = new wj8();
            setAnti(new AntiData());
            setChatGroup(new ej8());
            this.privateForumTotalData = new pq4();
            this.mCardShipinNew = new ArrayList();
            this.mCardShipinPos = new ArrayList();
        }
    }

    private void insertRecommendInfo(ThreadData threadData, ArrayList<on> arrayList, int i) {
        ThreadRecommendInfoData threadRecommendInfoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, threadData, arrayList, i) == null) || threadData == null || arrayList == null || (threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData.getThreadRecommendInfoDataList(), 0)) == null || TextUtils.isEmpty(threadRecommendInfoData.recommendReason)) {
            return;
        }
        ir4 ir4Var = new ir4();
        ir4Var.s = true;
        ir4Var.t = threadData;
        ir4Var.position = i;
        ir4Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        arrayList.add(ir4Var);
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
                    vp4 vp4Var = new vp4();
                    vp4Var.h(threadData.getLegoCard());
                    this.threadList.add(vp4Var);
                } else {
                    this.threadList.add(threadData);
                    JSONObject c = kd8.c(threadInfo, threadData.getForum_name());
                    if (c != null) {
                        arrayList.add(c);
                    }
                }
            }
        }
        kd8.f().h("FRS", arrayList);
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

    public ep4 getActivityHeadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mActivityHeadData : (ep4) invokeV.objValue;
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

    public int getBaWuNoticeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.baWuNoticeNum : invokeV.intValue;
    }

    public String getBawuCenterUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.bawuCenterUrl : (String) invokeV.objValue;
    }

    public fp4 getBookInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.bookInfoData : (fp4) invokeV.objValue;
    }

    public lj8 getBusinessPromot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.businessPromot : (lj8) invokeV.objValue;
    }

    @Override // com.repackage.o85
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public List<on> getCardShipinNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mCardShipinNew : (List) invokeV.objValue;
    }

    public List<Integer> getCardShipinPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mCardShipinPos : (List) invokeV.objValue;
    }

    public ThreadData getCardVideoInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.cardVideoInfo : (ThreadData) invokeV.objValue;
    }

    public zo4 getCarrierEnterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.carrierEnterData : (zo4) invokeV.objValue;
    }

    public List<CategoryInfo> getCategoryInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.categoryInfos : (List) invokeV.objValue;
    }

    public ej8 getChatGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.chatGroup : (ej8) invokeV.objValue;
    }

    public long getDataParseTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mDataParseTime : invokeV.longValue;
    }

    public sj8 getEntelechyTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mEntelechyTabInfo : (sj8) invokeV.objValue;
    }

    public String getFortuneDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.fortuneDesc : (String) invokeV.objValue;
    }

    public ForumData getForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.forum : (ForumData) invokeV.objValue;
    }

    public ForumHeadIcon getForumHeadIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.forumHeadIcon : (ForumHeadIcon) invokeV.objValue;
    }

    public int getForumState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.forumState : invokeV.intValue;
    }

    public int getFrsDefaultTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.frsDefaultTabId : invokeV.intValue;
    }

    public jj8 getFrsInsertLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mFrsInsertLiveData : (jj8) invokeV.objValue;
    }

    public kj8 getFrsStageLiveData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mFrsStageLiveData : (kj8) invokeV.objValue;
    }

    public vj8 getFrsVideoActivityData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mFrsVideoActivityData : (vj8) invokeV.objValue;
    }

    public int getGameDefaultTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.gameDefaultTabId : invokeV.intValue;
    }

    public String getGameName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.gameName : (String) invokeV.objValue;
    }

    public it6 getGameRankListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mGameRankListData : (it6) invokeV.objValue;
    }

    public List<FrsTabInfo> getGameTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.gameTabInfo : (List) invokeV.objValue;
    }

    public String getGameUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.gameUrl : (String) invokeV.objValue;
    }

    public wj8 getGconAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.gconAccount : (wj8) invokeV.objValue;
    }

    public np4 getHeadSdkData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.headSdkData : (np4) invokeV.objValue;
    }

    public ip4 getHeadlineImgInfoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.headlineImgInfoData : (ip4) invokeV.objValue;
    }

    public HotUserRankEntry getHotUserRankData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mHotUserRankData : (HotUserRankEntry) invokeV.objValue;
    }

    public int getIsNewUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.isNewUrl : invokeV.intValue;
    }

    public List<FeedForumData> getLikeFeedForumDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.likeFeedForumDataList : (List) invokeV.objValue;
    }

    public AlaLiveNotify getLiveNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.liveNotify : (AlaLiveNotify) invokeV.objValue;
    }

    public Integer getMangaReadRecordChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mangaReadRecordChapterId : (Integer) invokeV.objValue;
    }

    public gq4 getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.page : (gq4) invokeV.objValue;
    }

    public int getPhotoLivePos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.photoLivePos : invokeV.intValue;
    }

    public PrivateForumPopInfoData getPrivateForumPopInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mPrivateForumPopInfoData : (PrivateForumPopInfoData) invokeV.objValue;
    }

    public pq4 getPrivateForumTotalInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.privateForumTotalData : (pq4) invokeV.objValue;
    }

    public List<RecmForumInfo> getRecm_forum_list() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.recm_forum_list : (List) invokeV.objValue;
    }

    public int getSchoolRecommendPos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.schoolRecommendPos : invokeV.intValue;
    }

    public xq4 getSchoolRecommendUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.schoolRecommendInfo : (xq4) invokeV.objValue;
    }

    public int getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mSortType : invokeV.intValue;
    }

    public rj8 getStar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.star : (rj8) invokeV.objValue;
    }

    public List<nj8> getStarEnter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.starEnter : (List) invokeV.objValue;
    }

    public ArrayList<on> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.threadList : (ArrayList) invokeV.objValue;
    }

    public List<Long> getThreadListIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.threadListIds : (List) invokeV.objValue;
    }

    public Integer getToLoadHorseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.toLoadHorseData : (Integer) invokeV.objValue;
    }

    public UserData getUserData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.userData : (UserData) invokeV.objValue;
    }

    public HashMap<String, MetaData> getUserMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.userMap : (HashMap) invokeV.objValue;
    }

    public gf6 getUserRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.userRecommend : (gf6) invokeV.objValue;
    }

    @NonNull
    public cz4 getVoiceRoomConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            cz4 cz4Var = this.voiceRoomConfig;
            return cz4Var != null ? cz4Var : cz4.b;
        }
        return (cz4) invokeV.objValue;
    }

    public dz4 getVoiceRoomData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.voiceRoomData : (dz4) invokeV.objValue;
    }

    @Override // com.repackage.n85
    public boolean initByByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, bArr)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.t85
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, jSONObject) == null) {
        }
    }

    @Override // com.repackage.t85
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, message) == null) {
        }
    }

    public boolean isFortuneBag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.fortuneBag : invokeV.booleanValue;
    }

    public boolean isHasGame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.hasGame : invokeV.booleanValue;
    }

    public boolean isShowRedTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.isShowRedTip : invokeV.booleanValue;
    }

    public FrsPageResIdl parserProtobuf(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048641, this, bArr, z)) == null) {
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
        if (interceptable == null || interceptable.invokeI(1048643, this, i) == null) {
            this.accessFlag = i;
        }
    }

    public void setActivityHeadData(ep4 ep4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, ep4Var) == null) {
            this.mActivityHeadData = ep4Var;
        }
    }

    public void setAgreeBanner(AgreeBanner agreeBanner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, agreeBanner) == null) {
            this.agreeBanner = agreeBanner;
        }
    }

    public void setAlaLiveCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i) == null) {
            this.alaLiveCount = i;
        }
    }

    public void setAnti(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, antiData) == null) {
            this.anti = antiData;
        }
    }

    public void setBaWuNoticeNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i) == null) {
            this.baWuNoticeNum = i;
        }
    }

    public void setBawuCenterUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, str) == null) {
            this.bawuCenterUrl = str;
        }
    }

    public void setBookInfo(fp4 fp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, fp4Var) == null) {
            this.bookInfoData = fp4Var;
        }
    }

    public void setBusinessPromot(lj8 lj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, lj8Var) == null) {
            this.businessPromot = lj8Var;
        }
    }

    public void setCardShipinNew(List<on> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, list) == null) {
            this.mCardShipinNew = list;
        }
    }

    public void setCardShipinPos(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, list) == null) {
            this.mCardShipinPos = list;
        }
    }

    public void setCardVideoInfo(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, threadData) == null) {
            this.cardVideoInfo = threadData;
        }
    }

    public void setCarrierEnterData(zo4 zo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, zo4Var) == null) {
            this.carrierEnterData = zo4Var;
        }
    }

    public void setCategoryInfos(List<CategoryInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, list) == null) {
            this.categoryInfos = list;
        }
    }

    public void setChatGroup(ej8 ej8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, ej8Var) == null) {
            this.chatGroup = ej8Var;
        }
    }

    public void setEntelechyTabInfo(sj8 sj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, sj8Var) == null) {
            this.mEntelechyTabInfo = sj8Var;
        }
    }

    public void setFortuneBag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z) == null) {
            this.fortuneBag = z;
        }
    }

    public void setFortuneDesc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            this.fortuneDesc = str;
        }
    }

    public void setForum(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, forumData) == null) {
            this.forum = forumData;
        }
    }

    public void setForumHeadIcon(ForumHeadIcon forumHeadIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, forumHeadIcon) == null) {
            this.forumHeadIcon = forumHeadIcon;
        }
    }

    public void setForumState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048663, this, i) == null) {
            this.forumState = i;
        }
    }

    public void setFrsDefaultTabId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048664, this, i) == null) {
            this.frsDefaultTabId = i;
        }
    }

    public void setFrsInsertLiveData(jj8 jj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, jj8Var) == null) {
            this.mFrsInsertLiveData = jj8Var;
        }
    }

    public void setFrsStageLiveData(kj8 kj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, kj8Var) == null) {
            this.mFrsStageLiveData = kj8Var;
        }
    }

    public void setFrsVideoActivityData(vj8 vj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, vj8Var) == null) {
            this.mFrsVideoActivityData = vj8Var;
        }
    }

    public void setGameDefaultTabId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048668, this, i) == null) {
            this.gameDefaultTabId = i;
        }
    }

    public void setGameName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, str) == null) {
            this.gameName = str;
        }
    }

    public void setGameRankListData(it6 it6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, it6Var) == null) {
            this.mGameRankListData = it6Var;
        }
    }

    public void setGameTabInfo(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, list) == null) {
            this.gameTabInfo = list;
        }
    }

    public void setGameUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, str) == null) {
            this.gameUrl = str;
        }
    }

    public void setGconAccount(wj8 wj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, wj8Var) == null) {
            this.gconAccount = wj8Var;
        }
    }

    public void setHasGame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            this.hasGame = z;
        }
    }

    public void setHeadSdkData(np4 np4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, np4Var) == null) {
            this.headSdkData = np4Var;
        }
    }

    public void setHeadlineImgInfoData(ip4 ip4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, ip4Var) == null) {
            this.headlineImgInfoData = ip4Var;
        }
    }

    public void setHotUserRankData(HotUserRankEntry hotUserRankEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, hotUserRankEntry) == null) {
            this.mHotUserRankData = hotUserRankEntry;
        }
    }

    public void setIsNewUrl(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048678, this, i) == null) {
            this.isNewUrl = i;
        }
    }

    public void setIsShowRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z) == null) {
            this.isShowRedTip = z;
        }
    }

    public void setLikeFeedForumDataList(List<FeedForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, list) == null) {
            this.likeFeedForumDataList = list;
        }
    }

    public void setLiveNotify(AlaLiveNotify alaLiveNotify) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, alaLiveNotify) == null) {
            this.liveNotify = alaLiveNotify;
        }
    }

    public void setMangaReadRecordChapterId(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, num) == null) {
            this.mangaReadRecordChapterId = num;
        }
    }

    public void setPage(gq4 gq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, gq4Var) == null) {
            this.page = gq4Var;
        }
    }

    public void setPhotoLivePos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i) == null) {
            this.photoLivePos = i;
        }
    }

    public void setPrivateForumPopInfoData(PrivateForumPopInfoData privateForumPopInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, privateForumPopInfoData) == null) {
            this.mPrivateForumPopInfoData = privateForumPopInfoData;
        }
    }

    public void setPrivateForumTotalInfo(pq4 pq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, pq4Var) == null) {
            this.privateForumTotalData = pq4Var;
        }
    }

    public void setSchoolRecommendInfo(xq4 xq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, xq4Var) == null) {
            this.schoolRecommendInfo = xq4Var;
        }
    }

    public void setSchoolRecommendPos(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048688, this, i) == null) {
            this.schoolRecommendPos = i;
        }
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048689, this, i) == null) {
            this.mSortType = i;
        }
    }

    public void setStar(rj8 rj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, rj8Var) == null) {
            this.star = rj8Var;
        }
    }

    public void setStarEnter(List<nj8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, list) == null) {
            this.starEnter = list;
        }
    }

    public void setThreadList(ArrayList<on> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, arrayList) == null) {
            this.threadList = arrayList;
        }
    }

    public void setThreadListIds(List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, list) == null) {
            this.threadListIds = list;
        }
    }

    public void setUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, userData) == null) {
            this.userData = userData;
        }
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, hashMap) == null) {
            this.userMap = hashMap;
        }
    }

    public void setUserRecommend(gf6 gf6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, gf6Var) == null) {
            this.userRecommend = gf6Var;
        }
    }

    public void setVoiceRoomConfig(@Nullable cz4 cz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, cz4Var) == null) {
            this.voiceRoomConfig = cz4Var;
        }
    }

    public dz4 setVoiceRoomData(dz4 dz4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048698, this, dz4Var)) == null) {
            this.voiceRoomData = dz4Var;
            return dz4Var;
        }
        return (dz4) invokeL.objValue;
    }

    public ArrayList<on> switchThreadDataToThreadCardInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            ArrayList<on> switchThreadDataToThreadCardInfo = switchThreadDataToThreadCardInfo(this.threadList);
            setThreadList(switchThreadDataToThreadCardInfo);
            return switchThreadDataToThreadCardInfo;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.repackage.n85
    public byte[] toCacheByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public ArrayList<on> switchThreadDataToThreadCardInfo(ArrayList<on> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048700, this, arrayList)) == null) {
            this.mHasThreadExceptTop = false;
            ArrayList<on> arrayList2 = new ArrayList<>();
            Iterator<on> it = arrayList.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                on next = it.next();
                if (next instanceof tp4) {
                    ((tp4) next).setPosition(i - i2);
                    arrayList2.add(next);
                } else if (next instanceof vp4) {
                    ((vp4) next).position = i;
                    arrayList2.add(next);
                } else if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (threadData.isTop()) {
                        i2++;
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL && !threadData.isTop()) {
                        ir4 ir4Var = new ir4();
                        ir4Var.t = threadData;
                        ir4Var.position = i;
                        ir4Var.a = true;
                        ir4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(ir4Var);
                        ir4 ir4Var2 = new ir4();
                        ir4Var2.t = threadData;
                        ir4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            ir4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            ir4Var2.d = true;
                            ir4Var2.u = imageWidthAndHeight[0];
                            ir4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            ir4Var2.e = true;
                        } else {
                            ir4Var2.b = true;
                        }
                        ir4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(ir4Var2);
                        if (threadData.getPollData() != null) {
                            ir4 ir4Var3 = new ir4();
                            ir4Var3.o = true;
                            ir4Var3.t = threadData;
                            ir4Var3.position = i;
                            ir4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var3);
                        }
                        if (threadData.getSmartApp() != null) {
                            ir4 ir4Var4 = new ir4();
                            ir4Var4.l = true;
                            ir4Var4.t = threadData;
                            ir4Var4.position = i;
                            ir4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var4);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            ir4 ir4Var5 = new ir4();
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                ir4Var5.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                ir4Var5.q = true;
                            }
                            ir4Var5.t = threadData;
                            ir4Var5.position = i;
                            ir4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var5);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            ir4 ir4Var6 = new ir4();
                            ir4Var6.h = true;
                            ir4Var6.t = threadData;
                            ir4Var6.position = i;
                            ir4Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var6);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            ir4 ir4Var7 = new ir4();
                            ir4Var7.n = true;
                            ir4Var7.t = threadData;
                            ir4Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var7);
                        }
                        insertRecommendInfo(threadData, arrayList2, i);
                        ir4 ir4Var8 = new ir4();
                        ir4Var8.g = true;
                        ir4Var8.t = threadData;
                        ir4Var8.position = i;
                        ir4Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(ir4Var8);
                    } else if ((threadData.getType() == ThreadData.TYPE_VIDEO || threadData.getType() == ThreadData.TYPE_FAKE_VIDEO) && !threadData.isTop()) {
                        ir4 ir4Var9 = new ir4();
                        ir4Var9.t = threadData;
                        ir4Var9.position = i;
                        ir4Var9.a = true;
                        ir4Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(ir4Var9);
                        ir4 ir4Var10 = new ir4();
                        ir4Var10.t = threadData;
                        ir4Var10.position = i;
                        if (threadData instanceof dq4) {
                            ir4Var10.j = true;
                        } else {
                            ir4Var10.i = true;
                        }
                        ir4Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(ir4Var10);
                        if (threadData.getPollData() != null) {
                            ir4 ir4Var11 = new ir4();
                            ir4Var11.o = true;
                            ir4Var11.t = threadData;
                            ir4Var11.position = i;
                            ir4Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var11);
                        }
                        if (threadData.getSmartApp() != null) {
                            ir4 ir4Var12 = new ir4();
                            ir4Var12.l = true;
                            ir4Var12.t = threadData;
                            ir4Var12.position = i;
                            ir4Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var12);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            ir4 ir4Var13 = new ir4();
                            ir4Var13.h = true;
                            ir4Var13.t = threadData;
                            ir4Var13.position = i;
                            ir4Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var13);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            ir4 ir4Var14 = new ir4();
                            ir4Var14.n = true;
                            ir4Var14.t = threadData;
                            ir4Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var14);
                        }
                        insertRecommendInfo(threadData, arrayList2, i);
                        ir4 ir4Var15 = new ir4();
                        ir4Var15.g = true;
                        ir4Var15.t = threadData;
                        ir4Var15.position = i;
                        ir4Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(ir4Var15);
                    } else if (threadData.getThreadVideoInfo() != null && !threadData.isLiveInterviewLiveType() && threadData.isGodThread()) {
                        ir4 ir4Var16 = new ir4();
                        ir4Var16.t = threadData;
                        ir4Var16.position = i;
                        ir4Var16.a = true;
                        ir4Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(ir4Var16);
                        ir4 ir4Var17 = new ir4();
                        ir4Var17.t = threadData;
                        ir4Var17.position = i;
                        ir4Var17.k = true;
                        ir4Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(ir4Var17);
                        if (threadData.getPollData() != null) {
                            ir4 ir4Var18 = new ir4();
                            ir4Var18.o = true;
                            ir4Var18.t = threadData;
                            ir4Var18.position = i;
                            ir4Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var18);
                        }
                        if (threadData.getSmartApp() != null) {
                            ir4 ir4Var19 = new ir4();
                            ir4Var19.l = true;
                            ir4Var19.t = threadData;
                            ir4Var19.position = i;
                            ir4Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var19);
                        }
                        if (threadData.getTopAgreePost() != null) {
                            ir4 ir4Var20 = new ir4();
                            ir4Var20.h = true;
                            ir4Var20.t = threadData;
                            ir4Var20.position = i;
                            ir4Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var20);
                        }
                        if (threadData.getItem() != null && !threadData.isVoteThreadType()) {
                            ir4 ir4Var21 = new ir4();
                            ir4Var21.n = true;
                            ir4Var21.t = threadData;
                            ir4Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var21);
                        }
                        insertRecommendInfo(threadData, arrayList2, i);
                        ir4 ir4Var22 = new ir4();
                        ir4Var22.g = true;
                        ir4Var22.t = threadData;
                        ir4Var22.position = i;
                        ir4Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(ir4Var22);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        arrayList2.add(threadData);
                    } else {
                        ir4 ir4Var23 = new ir4();
                        ir4Var23.t = threadData;
                        ir4Var23.position = i;
                        arrayList2.add(ir4Var23);
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
        if (!(interceptable == null || interceptable.invokeL(1048642, this, dataRes) == null) || dataRes == null) {
            return;
        }
        try {
            initData();
            if (!ListUtils.isEmpty(dataRes.color_egg)) {
                for (ColorEgg colorEgg : dataRes.color_egg) {
                    if (colorEgg != null && !ListUtils.isEmpty(colorEgg.holiday_words)) {
                        bp4 bp4Var = new bp4();
                        if (bp4Var.c(colorEgg)) {
                            this.color_eggs.add(bp4Var);
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
                if (dataRes.forum.tag_info != null) {
                    this.firstCategory = dataRes.forum.tag_info.first_category;
                    if (dataRes.forum.tag_info.recom_tag != null) {
                        ForumTagInfo forumTagInfo = new ForumTagInfo();
                        this.forumTagInfo = forumTagInfo;
                        forumTagInfo.id = String.valueOf(dataRes.forum.tag_info.recom_tag.id);
                        this.forumTagInfo.name = dataRes.forum.tag_info.recom_tag.name;
                        this.forumTagInfo.pic = dataRes.forum.tag_info.recom_tag.pic;
                    }
                }
            }
            if (this.isBrandForum && dataRes.brand_forum_info != null) {
                ep4 ep4Var = new ep4();
                this.mActivityHeadData = ep4Var;
                ep4Var.e(dataRes.brand_forum_info.head_imgs);
                ne6 ne6Var = new ne6();
                this.brandAdData = ne6Var;
                ne6Var.a(dataRes.brand_forum_info);
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
                ep4 ep4Var2 = new ep4();
                this.mActivityHeadData = ep4Var2;
                ep4Var2.d(dataRes.activityhead, longValue);
            } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !pi.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
                ep4 ep4Var3 = new ep4();
                this.mActivityHeadData = ep4Var3;
                ep4Var3.e(dataRes.private_forum_info.head_imgs);
            }
            this.bottomMenuList = dataRes.bottom_menu;
            this.adMixFloor = dataRes.ad_mix_list;
            this.adShowSelect = dataRes.ad_show_select.intValue();
            this.adSampleMapKey = dataRes.ad_sample_map_key;
            this.liveFuseForumDataList = dataRes.live_fuse_forum;
            this.baWuNoticeNum = dataRes.bawu_unread_notice_num.intValue();
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
                    nj8 nj8Var = new nj8();
                    nj8Var.k(list2.get(i3));
                    this.starEnter.add(nj8Var);
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
                or8.f(dataRes.anti.block_pop_info);
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
            FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(this.mEntelechyTabInfo.a, 0);
            if (UbsABTestHelper.isFrsTabLocationTest() && frsTabInfo != null && !FrsTabTestHelper.NEW_AREA_TAB_NAME.equals(frsTabInfo.tab_name)) {
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
            if (!pi.isEmpty(dataRes.bawu_enter_url)) {
                this.bawuCenterUrl = dataRes.bawu_enter_url;
            }
            if (dataRes.head_sdk != null) {
                np4 np4Var = new np4();
                this.headSdkData = np4Var;
                np4Var.a(dataRes.head_sdk);
            }
            if (dataRes.recommend_book != null) {
                op4 op4Var = new op4();
                this.recommendBookData = op4Var;
                op4Var.c(dataRes.recommend_book);
            }
            if (dataRes.book_info != null) {
                fp4 fp4Var = new fp4();
                this.bookInfoData = fp4Var;
                fp4Var.c(dataRes.book_info);
            }
            if (dataRes.forum_present_info != null) {
                lp4 lp4Var = new lp4();
                this.presentInfoData = lp4Var;
                lp4Var.a(dataRes.forum_present_info);
            }
            if (dataRes.forum_headline_img_info != null) {
                ip4 ip4Var = new ip4();
                this.headlineImgInfoData = ip4Var;
                ip4Var.b(dataRes.forum_headline_img_info);
            }
            if (dataRes.business_promot != null) {
                lj8 lj8Var = new lj8();
                this.businessPromot = lj8Var;
                lj8Var.r(dataRes.business_promot);
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
                jj8 jj8Var = new jj8();
                this.mFrsInsertLiveData = jj8Var;
                jj8Var.b = dataRes.ala_insert_floor.intValue();
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
                this.mFrsStageLiveData = new kj8();
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
                xq4 xq4Var = new xq4();
                this.schoolRecommendInfo = xq4Var;
                xq4Var.f(dataRes.school_recom_info);
            }
            if (dataRes.carrier_enter != null) {
                zo4 zo4Var = new zo4();
                this.carrierEnterData = zo4Var;
                zo4Var.a(dataRes.carrier_enter);
            }
            if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                this.forumState = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                this.accessFlag = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
            }
            this.mSortType = dataRes.sort_type.intValue();
            this.needLog = dataRes.need_log.intValue();
            hd8.e().h(dataRes.asp_shown_info);
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
                it6 it6Var = new it6();
                this.mGameRankListData = it6Var;
                it6Var.c(dataRes.esport);
            }
            this.agreeBanner = dataRes.agree_banner;
            if (dataRes.user_extend != null) {
                gf6 gf6Var = new gf6();
                this.userRecommend = gf6Var;
                gf6Var.h(dataRes.user_extend);
            }
            this.liveNotify = dataRes.live_frs_notify;
            this.gameTabInfo = dataRes.frs_game_tab_info;
            this.gameDefaultTabId = dataRes.game_default_tab_id.intValue();
            this.forumHeadIcon = dataRes.forum_head_icon;
            if (dataRes.video != null && dataRes.video.video_act != null) {
                vj8 vj8Var = new vj8();
                this.mFrsVideoActivityData = vj8Var;
                vj8Var.a(dataRes.video.video_act);
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
                privateForumPopInfoData.E(dataRes.bawutask_pop);
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
                this.serviceAreaData = new gk8();
                ArrayList arrayList3 = new ArrayList();
                for (ServiceArea serviceArea : dataRes.service_area) {
                    if (serviceArea != null) {
                        this.serviceAreaFlutterData.add(DataExt.toMap(serviceArea));
                        hk8 hk8Var = new hk8();
                        hk8Var.b = serviceArea.picurl;
                        hk8Var.c = serviceArea.servicename;
                        String str = serviceArea.service_type;
                        hk8Var.a = str;
                        if (str != null && str.equals("原生小程序") && serviceArea.area_smart_app != null) {
                            hk8Var.b = serviceArea.area_smart_app.avatar;
                            hk8Var.c = serviceArea.area_smart_app.name;
                        }
                        hk8Var.d = serviceArea.serviceurl;
                        hk8Var.e = serviceArea.schema;
                        hk8Var.i = serviceArea.third_statistics_url;
                        String str2 = serviceArea.version;
                        String q = ru4.k().q("frs_service_version_" + this.forum.getName() + hk8Var.c, "");
                        if (!TextUtils.isEmpty(q)) {
                            q.equals(serviceArea.version);
                        }
                        if (serviceArea.area_smart_app != null) {
                            ik8 ik8Var = new ik8();
                            ik8Var.a(serviceArea.area_smart_app);
                            hk8Var.f = ik8Var;
                        }
                        if (this.forum != null) {
                            this.forum.getName();
                            hk8Var.g = this.forum.getId();
                        }
                        hk8Var.h = i;
                        i++;
                        arrayList3.add(hk8Var);
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
            this.voiceRoomConfig = cz4.c(dataRes);
            dz4 dz4Var = new dz4();
            this.voiceRoomData = dz4Var;
            dz4Var.d(dataRes);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
