package d.a.k0.d3;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.g0;
import d.a.j0.r.q.h0;
import d.a.j0.r.q.h1;
import d.a.j0.r.q.m0;
import d.a.j0.r.q.n0;
import d.a.j0.r.q.q1;
import d.a.j0.r.q.w0;
import d.a.j0.r.q.z0;
import d.a.j0.r.q.z1;
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
/* loaded from: classes5.dex */
public class m implements d.a.j0.g0.b.b, d.a.j0.g0.b.h {
    public static final Wire WIRE = new Wire(new Class[0]);
    public ActivityConfig activityConfig;
    public AgreeBanner agreeBanner;
    public AntiData anti;
    public AddBawuPopInfo bawuPopInfo;
    public WindowToast bazhuExam;
    public List<BottomMenu> bottomMenuList;
    public d.a.k0.q0.d brandAdData;
    public i businessPromot;
    public a2 cardVideoInfo;
    public d.a.j0.r.q.s carrierEnterData;
    public List<CategoryInfo> categoryInfos;
    public b chatGroup;
    public PopInfo enterFrsDialogInfo;
    public boolean fortuneBag;
    public String fortuneDesc;
    public ForumData forum;
    public ForumActiveInfo forumActiveInfo;
    public ForumArIno forumArIno;
    public ForumHeadIcon forumHeadIcon;
    public ForumRuleStatus forumRule;
    public String gameName;
    public List<FrsTabInfo> gameTabInfo;
    public String gameUrl;
    public r gconAccount;
    public boolean hasGame;
    public boolean isBrandForum;
    public boolean isFrsVideoAutoPlay;
    public ItemInfo itemInfo;
    public List<FeedForumData> likeFeedForumDataList;
    public AlaLiveNotify liveNotify;
    public List<d.a.c.j.e.n> mCardShipinNew;
    public List<Integer> mCardShipinPos;
    public NavTabInfo mEntelechyTabInfo;
    public g mFrsInsertLiveData;
    public h mFrsStageLiveData;
    public q mFrsVideoActivityData;
    public d.a.k0.t0.b mGameRankListData;
    public boolean mHasThreadExceptTop;
    public HotUserRankEntry mHotUserRankData;
    public FrsTabInfo mNewChapterInfo;
    public SignActivityInfo mSignActivityInfo;
    public int mSortType;
    public List<WindowToast> mWindowToast;
    public NebulaHotThreads nebulaHotThreads;
    public List<OriForumInfo> oriForumInfoList;
    public z0 page;
    public int photoLivePos;
    public h1 privateForumTotalData;
    public List<RecmForumInfo> recm_forum_list;
    public q1 schoolRecommendInfo;
    public a0 serviceAreaData;
    public Integer showAdsense;
    public SmartApp smartApp;
    public List<String> smartAppAvatar;
    public n star;
    public StarRank starRank;
    public ArrayList<d.a.c.j.e.n> threadList;
    public List<Long> threadListIds;
    public Integer toLoadHorseData;
    public UserData userData;
    public List<User> userList;
    public HashMap<String, MetaData> userMap;
    public d.a.k0.q0.x userRecommend;
    public int needLog = 0;
    public List<k> starEnter = new ArrayList();
    public int isNewUrl = 0;
    public ArrayList<d.a.j0.r.q.u> color_eggs = new ArrayList<>();
    public d.a.j0.r.q.x mActivityHeadData = null;
    public int frsDefaultTabId = 1;
    public boolean isShowRedTip = false;
    public String bawuCenterUrl = null;
    public g0 headSdkData = null;
    public h0 recommendBookData = null;
    public RecomPostTopic postTopic = null;
    public d.a.j0.r.q.y bookInfoData = null;
    public Integer mangaReadRecordChapterId = -1;
    public d.a.j0.r.q.e0 presentInfoData = null;
    public d.a.j0.r.q.b0 headlineImgInfoData = null;
    public int schoolRecommendPos = -1;
    public List<d.a.c.j.e.n> topThreadList = null;
    public int forumState = 0;
    public int accessFlag = 0;
    public int alaLiveCount = 0;
    public int gameDefaultTabId = 0;
    public int mErrorNo = 0;
    public int defaultShowTab = 1;
    public long mDataParseTime = 0;

    public m() {
        initData();
    }

    private void handleDefaultTab(int i2) {
        List<FrsTabInfo> list;
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

    private void initData() {
        this.forum = new ForumData();
        this.threadList = new ArrayList<>();
        this.topThreadList = new ArrayList();
        this.userMap = new HashMap<>();
        this.page = new z0();
        this.star = new n();
        this.userData = new UserData();
        this.gconAccount = new r();
        setAnti(new AntiData());
        setChatGroup(new b());
        this.privateForumTotalData = new h1();
        this.mCardShipinNew = new ArrayList();
        this.mCardShipinPos = new ArrayList();
    }

    public void convertThreadInfoToThreadData(List<ThreadInfo> list, long j) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                a2 a2Var = new a2();
                SpecHotTopicHelper.setSpecTopicIcon(j, a2Var);
                a2Var.s4(this.userMap);
                a2Var.C3(true);
                a2Var.T2(threadInfo);
                a2Var.X2();
                a2Var.K1();
                if (a2Var.c0() == 0 && j != 0) {
                    a2Var.w3(j);
                }
                if (StringUtils.isNull(a2Var.i0())) {
                    a2Var.A3(this.forum.getName());
                }
                a2Var.M2(this.color_eggs);
                a2Var.D1 = this.forum.isBrandForum;
                if (!TextUtils.isEmpty(a2Var.E0())) {
                    n0 n0Var = new n0();
                    n0Var.m(a2Var.E0());
                    this.threadList.add(n0Var);
                } else {
                    this.threadList.add(a2Var);
                    JSONObject c2 = d.a.k0.s2.i0.b.c(threadInfo, a2Var.i0());
                    if (c2 != null) {
                        arrayList.add(c2);
                    }
                }
            }
        }
        d.a.k0.s2.i0.b.f().h("FRS", arrayList);
    }

    public void deleteLikeFeedForum(String str) {
        List<FeedForumData> list = this.likeFeedForumDataList;
        if (list == null || str == null) {
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
        return this.accessFlag;
    }

    public d.a.j0.r.q.x getActivityHeadData() {
        return this.mActivityHeadData;
    }

    public AgreeBanner getAgreeBanner() {
        return this.agreeBanner;
    }

    public int getAlaLiveCount() {
        return this.alaLiveCount;
    }

    public AntiData getAnti() {
        return this.anti;
    }

    public String getBawuCenterUrl() {
        return this.bawuCenterUrl;
    }

    public d.a.j0.r.q.y getBookInfo() {
        return this.bookInfoData;
    }

    public i getBusinessPromot() {
        return this.businessPromot;
    }

    @Override // d.a.j0.g0.b.c
    public String getCacheKey() {
        return null;
    }

    public List<d.a.c.j.e.n> getCardShipinNew() {
        return this.mCardShipinNew;
    }

    public List<Integer> getCardShipinPos() {
        return this.mCardShipinPos;
    }

    public a2 getCardVideoInfo() {
        return this.cardVideoInfo;
    }

    public d.a.j0.r.q.s getCarrierEnterData() {
        return this.carrierEnterData;
    }

    public List<CategoryInfo> getCategoryInfos() {
        return this.categoryInfos;
    }

    public b getChatGroup() {
        return this.chatGroup;
    }

    public long getDataParseTime() {
        return this.mDataParseTime;
    }

    public NavTabInfo getEntelechyTabInfo() {
        return this.mEntelechyTabInfo;
    }

    public String getFortuneDesc() {
        return this.fortuneDesc;
    }

    public ForumData getForum() {
        return this.forum;
    }

    public ForumHeadIcon getForumHeadIcon() {
        return this.forumHeadIcon;
    }

    public int getForumState() {
        return this.forumState;
    }

    public int getFrsDefaultTabId() {
        return this.frsDefaultTabId;
    }

    public g getFrsInsertLiveData() {
        return this.mFrsInsertLiveData;
    }

    public h getFrsStageLiveData() {
        return this.mFrsStageLiveData;
    }

    public q getFrsVideoActivityData() {
        return this.mFrsVideoActivityData;
    }

    public int getGameDefaultTabId() {
        return this.gameDefaultTabId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public d.a.k0.t0.b getGameRankListData() {
        return this.mGameRankListData;
    }

    public List<FrsTabInfo> getGameTabInfo() {
        return this.gameTabInfo;
    }

    public String getGameUrl() {
        return this.gameUrl;
    }

    public r getGconAccount() {
        return this.gconAccount;
    }

    public g0 getHeadSdkData() {
        return this.headSdkData;
    }

    public d.a.j0.r.q.b0 getHeadlineImgInfoData() {
        return this.headlineImgInfoData;
    }

    public HotUserRankEntry getHotUserRankData() {
        return this.mHotUserRankData;
    }

    public int getIsNewUrl() {
        return this.isNewUrl;
    }

    public List<FeedForumData> getLikeFeedForumDataList() {
        return this.likeFeedForumDataList;
    }

    public AlaLiveNotify getLiveNotify() {
        return this.liveNotify;
    }

    public Integer getMangaReadRecordChapterId() {
        return this.mangaReadRecordChapterId;
    }

    public z0 getPage() {
        return this.page;
    }

    public int getPhotoLivePos() {
        return this.photoLivePos;
    }

    public h1 getPrivateForumTotalInfo() {
        return this.privateForumTotalData;
    }

    public List<RecmForumInfo> getRecm_forum_list() {
        return this.recm_forum_list;
    }

    public int getSchoolRecommendPos() {
        return this.schoolRecommendPos;
    }

    public q1 getSchoolRecommendUserInfo() {
        return this.schoolRecommendInfo;
    }

    public int getSortType() {
        return this.mSortType;
    }

    public n getStar() {
        return this.star;
    }

    public List<k> getStarEnter() {
        return this.starEnter;
    }

    public ArrayList<d.a.c.j.e.n> getThreadList() {
        return this.threadList;
    }

    public List<Long> getThreadListIds() {
        return this.threadListIds;
    }

    public Integer getToLoadHorseData() {
        return this.toLoadHorseData;
    }

    public UserData getUserData() {
        return this.userData;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public d.a.k0.q0.x getUserRecommend() {
        return this.userRecommend;
    }

    @Override // d.a.j0.g0.b.b
    public boolean initByByteArray(byte[] bArr) {
        return false;
    }

    @Override // d.a.j0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // d.a.j0.g0.b.h
    public void initByProtobuf(Message message) {
    }

    public boolean isFortuneBag() {
        return this.fortuneBag;
    }

    public boolean isHasGame() {
        return this.hasGame;
    }

    public boolean isShowRedTip() {
        return this.isShowRedTip;
    }

    public FrsPageResIdl parserProtobuf(byte[] bArr, boolean z) {
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

    public void setAccessFlag(int i2) {
        this.accessFlag = i2;
    }

    public void setActivityHeadData(d.a.j0.r.q.x xVar) {
        this.mActivityHeadData = xVar;
    }

    public void setAgreeBanner(AgreeBanner agreeBanner) {
        this.agreeBanner = agreeBanner;
    }

    public void setAlaLiveCount(int i2) {
        this.alaLiveCount = i2;
    }

    public void setAnti(AntiData antiData) {
        this.anti = antiData;
    }

    public void setBawuCenterUrl(String str) {
        this.bawuCenterUrl = str;
    }

    public void setBookInfo(d.a.j0.r.q.y yVar) {
        this.bookInfoData = yVar;
    }

    public void setBusinessPromot(i iVar) {
        this.businessPromot = iVar;
    }

    public void setCardShipinNew(List<d.a.c.j.e.n> list) {
        this.mCardShipinNew = list;
    }

    public void setCardShipinPos(List<Integer> list) {
        this.mCardShipinPos = list;
    }

    public void setCardVideoInfo(a2 a2Var) {
        this.cardVideoInfo = a2Var;
    }

    public void setCarrierEnterData(d.a.j0.r.q.s sVar) {
        this.carrierEnterData = sVar;
    }

    public void setCategoryInfos(List<CategoryInfo> list) {
        this.categoryInfos = list;
    }

    public void setChatGroup(b bVar) {
        this.chatGroup = bVar;
    }

    public void setEntelechyTabInfo(NavTabInfo navTabInfo) {
        this.mEntelechyTabInfo = navTabInfo;
    }

    public void setFortuneBag(boolean z) {
        this.fortuneBag = z;
    }

    public void setFortuneDesc(String str) {
        this.fortuneDesc = str;
    }

    public void setForum(ForumData forumData) {
        this.forum = forumData;
    }

    public void setForumHeadIcon(ForumHeadIcon forumHeadIcon) {
        this.forumHeadIcon = forumHeadIcon;
    }

    public void setForumState(int i2) {
        this.forumState = i2;
    }

    public void setFrsDefaultTabId(int i2) {
        this.frsDefaultTabId = i2;
    }

    public void setFrsInsertLiveData(g gVar) {
        this.mFrsInsertLiveData = gVar;
    }

    public void setFrsStageLiveData(h hVar) {
        this.mFrsStageLiveData = hVar;
    }

    public void setFrsVideoActivityData(q qVar) {
        this.mFrsVideoActivityData = qVar;
    }

    public void setGameDefaultTabId(int i2) {
        this.gameDefaultTabId = i2;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setGameRankListData(d.a.k0.t0.b bVar) {
        this.mGameRankListData = bVar;
    }

    public void setGameTabInfo(List<FrsTabInfo> list) {
        this.gameTabInfo = list;
    }

    public void setGameUrl(String str) {
        this.gameUrl = str;
    }

    public void setGconAccount(r rVar) {
        this.gconAccount = rVar;
    }

    public void setHasGame(boolean z) {
        this.hasGame = z;
    }

    public void setHeadSdkData(g0 g0Var) {
        this.headSdkData = g0Var;
    }

    public void setHeadlineImgInfoData(d.a.j0.r.q.b0 b0Var) {
        this.headlineImgInfoData = b0Var;
    }

    public void setHotUserRankData(HotUserRankEntry hotUserRankEntry) {
        this.mHotUserRankData = hotUserRankEntry;
    }

    public void setIsNewUrl(int i2) {
        this.isNewUrl = i2;
    }

    public void setIsShowRedTip(boolean z) {
        this.isShowRedTip = z;
    }

    public void setLikeFeedForumDataList(List<FeedForumData> list) {
        this.likeFeedForumDataList = list;
    }

    public void setLiveNotify(AlaLiveNotify alaLiveNotify) {
        this.liveNotify = alaLiveNotify;
    }

    public void setMangaReadRecordChapterId(Integer num) {
        this.mangaReadRecordChapterId = num;
    }

    public void setPage(z0 z0Var) {
        this.page = z0Var;
    }

    public void setPhotoLivePos(int i2) {
        this.photoLivePos = i2;
    }

    public void setPrivateForumTotalInfo(h1 h1Var) {
        this.privateForumTotalData = h1Var;
    }

    public void setSchoolRecommendInfo(q1 q1Var) {
        this.schoolRecommendInfo = q1Var;
    }

    public void setSchoolRecommendPos(int i2) {
        this.schoolRecommendPos = i2;
    }

    public void setSortType(int i2) {
        this.mSortType = i2;
    }

    public void setStar(n nVar) {
        this.star = nVar;
    }

    public void setStarEnter(List<k> list) {
        this.starEnter = list;
    }

    public void setThreadList(ArrayList<d.a.c.j.e.n> arrayList) {
        this.threadList = arrayList;
    }

    public void setThreadListIds(List<Long> list) {
        this.threadListIds = list;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public void setUserRecommend(d.a.k0.q0.x xVar) {
        this.userRecommend = xVar;
    }

    public ArrayList<d.a.c.j.e.n> switchThreadDataToThreadCardInfo() {
        ArrayList<d.a.c.j.e.n> switchThreadDataToThreadCardInfo = switchThreadDataToThreadCardInfo(this.threadList);
        setThreadList(switchThreadDataToThreadCardInfo);
        return switchThreadDataToThreadCardInfo;
    }

    @Override // d.a.j0.g0.b.b
    public byte[] toCacheByteArray() {
        return null;
    }

    public ArrayList<d.a.c.j.e.n> switchThreadDataToThreadCardInfo(ArrayList<d.a.c.j.e.n> arrayList) {
        this.mHasThreadExceptTop = false;
        ArrayList<d.a.c.j.e.n> arrayList2 = new ArrayList<>();
        Iterator<d.a.c.j.e.n> it = arrayList.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            d.a.c.j.e.n next = it.next();
            if (next instanceof m0) {
                ((m0) next).setPosition(i2 - i3);
                arrayList2.add(next);
            } else if (next instanceof n0) {
                ((n0) next).position = i2;
                arrayList2.add(next);
            } else if (next instanceof a2) {
                a2 a2Var = (a2) next;
                if (a2Var.x2()) {
                    i3++;
                }
                d.a.j0.b.f.a.e(a2Var);
                int[] p0 = a2Var.p0();
                if (a2Var.getType() == a2.I2 && !a2Var.x2()) {
                    z1 z1Var = new z1();
                    z1Var.w = a2Var;
                    z1Var.position = i2;
                    z1Var.f50153e = true;
                    z1Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(z1Var);
                    z1 z1Var2 = new z1();
                    z1Var2.w = a2Var;
                    z1Var2.position = i2;
                    if (a2Var.Q1()) {
                        z1Var2.j = true;
                    } else if (a2Var.Y2() == 1) {
                        z1Var2.f50156h = true;
                        z1Var2.x = p0[0];
                        z1Var2.y = p0[1];
                    } else if (a2Var.Y2() >= 2) {
                        z1Var2.f50157i = true;
                    } else {
                        z1Var2.f50154f = true;
                    }
                    z1Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(z1Var2);
                    if (a2Var.O0() != null) {
                        z1 z1Var3 = new z1();
                        z1Var3.s = true;
                        z1Var3.w = a2Var;
                        z1Var3.position = i2;
                        z1Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var3);
                    }
                    if (a2Var.j1() != null) {
                        z1 z1Var4 = new z1();
                        z1Var4.p = true;
                        z1Var4.w = a2Var;
                        z1Var4.position = i2;
                        z1Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var4);
                    }
                    if (!ListUtils.isEmpty(a2Var.G0()) || !ListUtils.isEmpty(a2Var.l0())) {
                        z1 z1Var5 = new z1();
                        if (ListUtils.getCount(a2Var.G0()) + ListUtils.getCount(a2Var.l0()) == 1) {
                            z1Var5.t = true;
                        } else if (ListUtils.getCount(a2Var.G0()) + ListUtils.getCount(a2Var.l0()) > 1) {
                            z1Var5.u = true;
                        }
                        z1Var5.w = a2Var;
                        z1Var5.position = i2;
                        z1Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var5);
                    }
                    if (a2Var.A1() != null) {
                        z1 z1Var6 = new z1();
                        z1Var6.l = true;
                        z1Var6.w = a2Var;
                        z1Var6.position = i2;
                        z1Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var6);
                    }
                    if (a2Var.y0() != null && !a2Var.E2()) {
                        z1 z1Var7 = new z1();
                        z1Var7.r = true;
                        z1Var7.w = a2Var;
                        z1Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var7);
                    }
                    z1 z1Var8 = new z1();
                    z1Var8.k = true;
                    z1Var8.w = a2Var;
                    z1Var8.position = i2;
                    z1Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(z1Var8);
                } else if ((a2Var.getType() == a2.f3 || a2Var.getType() == a2.y3) && !a2Var.x2()) {
                    z1 z1Var9 = new z1();
                    z1Var9.w = a2Var;
                    z1Var9.position = i2;
                    z1Var9.f50153e = true;
                    z1Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(z1Var9);
                    z1 z1Var10 = new z1();
                    z1Var10.w = a2Var;
                    z1Var10.position = i2;
                    if (a2Var instanceof w0) {
                        z1Var10.n = true;
                    } else {
                        z1Var10.m = true;
                    }
                    z1Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(z1Var10);
                    if (a2Var.O0() != null) {
                        z1 z1Var11 = new z1();
                        z1Var11.s = true;
                        z1Var11.w = a2Var;
                        z1Var11.position = i2;
                        z1Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var11);
                    }
                    if (a2Var.j1() != null) {
                        z1 z1Var12 = new z1();
                        z1Var12.p = true;
                        z1Var12.w = a2Var;
                        z1Var12.position = i2;
                        z1Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var12);
                    }
                    if (a2Var.A1() != null) {
                        z1 z1Var13 = new z1();
                        z1Var13.l = true;
                        z1Var13.w = a2Var;
                        z1Var13.position = i2;
                        z1Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var13);
                    }
                    if (a2Var.y0() != null && !a2Var.E2()) {
                        z1 z1Var14 = new z1();
                        z1Var14.r = true;
                        z1Var14.w = a2Var;
                        z1Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var14);
                    }
                    z1 z1Var15 = new z1();
                    z1Var15.k = true;
                    z1Var15.w = a2Var;
                    z1Var15.position = i2;
                    z1Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(z1Var15);
                } else if (a2Var.v1() != null && !a2Var.h2() && a2Var.b2()) {
                    z1 z1Var16 = new z1();
                    z1Var16.w = a2Var;
                    z1Var16.position = i2;
                    z1Var16.f50153e = true;
                    z1Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList2.add(z1Var16);
                    z1 z1Var17 = new z1();
                    z1Var17.w = a2Var;
                    z1Var17.position = i2;
                    z1Var17.o = true;
                    z1Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList2.add(z1Var17);
                    if (a2Var.O0() != null) {
                        z1 z1Var18 = new z1();
                        z1Var18.s = true;
                        z1Var18.w = a2Var;
                        z1Var18.position = i2;
                        z1Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var18);
                    }
                    if (a2Var.j1() != null) {
                        z1 z1Var19 = new z1();
                        z1Var19.p = true;
                        z1Var19.w = a2Var;
                        z1Var19.position = i2;
                        z1Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var19);
                    }
                    if (a2Var.A1() != null) {
                        z1 z1Var20 = new z1();
                        z1Var20.l = true;
                        z1Var20.w = a2Var;
                        z1Var20.position = i2;
                        z1Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var20);
                    }
                    if (a2Var.y0() != null && !a2Var.E2()) {
                        z1 z1Var21 = new z1();
                        z1Var21.r = true;
                        z1Var21.w = a2Var;
                        z1Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(z1Var21);
                    }
                    z1 z1Var22 = new z1();
                    z1Var22.k = true;
                    z1Var22.w = a2Var;
                    z1Var22.position = i2;
                    z1Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList2.add(z1Var22);
                } else if (a2Var.getType() == a2.X2 && a2Var.P1()) {
                    a2Var.position = i2;
                    arrayList2.add(a2Var);
                } else {
                    z1 z1Var23 = new z1();
                    z1Var23.w = a2Var;
                    z1Var23.position = i2;
                    arrayList2.add(z1Var23);
                }
                i2++;
                a2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                if (next != null && next.getType() != a2.H2) {
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
        d.a.j0.b.f.a.d(arrayList2);
        return arrayList2;
    }

    public void parserProtobuf(DataRes dataRes) {
        long j;
        MetaData metaData;
        if (dataRes == null) {
            return;
        }
        try {
            initData();
            if (!ListUtils.isEmpty(dataRes.color_egg)) {
                for (ColorEgg colorEgg : dataRes.color_egg) {
                    if (colorEgg != null && !ListUtils.isEmpty(colorEgg.holiday_words)) {
                        d.a.j0.r.q.u uVar = new d.a.j0.r.q.u();
                        if (uVar.c(colorEgg)) {
                            this.color_eggs.add(uVar);
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
                d.a.j0.r.q.x xVar = new d.a.j0.r.q.x();
                this.mActivityHeadData = xVar;
                xVar.d(dataRes.brand_forum_info.head_imgs);
                d.a.k0.q0.d dVar = new d.a.k0.q0.d();
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
            } else if (dataRes.activityhead != null && !ListUtils.isEmpty(dataRes.activityhead.head_imgs)) {
                d.a.j0.r.q.x xVar2 = new d.a.j0.r.q.x();
                this.mActivityHeadData = xVar2;
                xVar2.c(dataRes.activityhead);
            } else if (dataRes.private_forum_info != null && dataRes.private_forum_info.head_imgs != null && !d.a.c.e.p.k.isEmpty(dataRes.private_forum_info.head_imgs.img_url)) {
                d.a.j0.r.q.x xVar3 = new d.a.j0.r.q.x();
                this.mActivityHeadData = xVar3;
                xVar3.d(dataRes.private_forum_info.head_imgs);
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
                    kVar.m(list2.get(i4));
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
                d.a.k0.l3.d.f(dataRes.anti.block_pop_info);
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
            if (this.mEntelechyTabInfo != null && ListUtils.getItem(this.mEntelechyTabInfo.tab, 0) != null) {
                this.defaultShowTab = ((FrsTabInfo) ListUtils.getItem(this.mEntelechyTabInfo.tab, 0)).tab_id.intValue();
            }
            if (d.a.j0.b.d.o() && !d.a.j0.b.g.a.f48865e.equals(((FrsTabInfo) ListUtils.getItem(this.mEntelechyTabInfo.tab, 0)).tab_name)) {
                this.defaultShowTab = d.a.j0.b.g.a.c();
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
                g0 g0Var = new g0();
                this.headSdkData = g0Var;
                g0Var.a(dataRes.head_sdk);
            }
            if (dataRes.recommend_book != null) {
                h0 h0Var = new h0();
                this.recommendBookData = h0Var;
                h0Var.B4(dataRes.recommend_book);
            }
            if (dataRes.book_info != null) {
                d.a.j0.r.q.y yVar = new d.a.j0.r.q.y();
                this.bookInfoData = yVar;
                yVar.c(dataRes.book_info);
            }
            if (dataRes.forum_present_info != null) {
                d.a.j0.r.q.e0 e0Var = new d.a.j0.r.q.e0();
                this.presentInfoData = e0Var;
                e0Var.a(dataRes.forum_present_info);
            }
            if (dataRes.forum_headline_img_info != null) {
                d.a.j0.r.q.b0 b0Var = new d.a.j0.r.q.b0();
                this.headlineImgInfoData = b0Var;
                b0Var.b(dataRes.forum_headline_img_info);
            }
            if (dataRes.business_promot != null) {
                i iVar = new i();
                this.businessPromot = iVar;
                iVar.m(dataRes.business_promot);
            }
            if (dataRes.card_shipin_info != null && dataRes.card_shipin_info.size() > 0) {
                a2 a2Var = new a2();
                this.cardVideoInfo = a2Var;
                a2Var.J3(true);
                this.cardVideoInfo.H3(this.photoLivePos);
                this.cardVideoInfo.s4(this.userMap);
                this.cardVideoInfo.T2(dataRes.card_shipin_info.get(0));
                this.cardVideoInfo.X2();
                this.cardVideoInfo.D1 = this.isBrandForum;
                if (this.cardVideoInfo.c0() == 0 && j != 0) {
                    this.cardVideoInfo.w3(j);
                }
                this.cardVideoInfo.M2(this.color_eggs);
                this.cardVideoInfo.z3(!this.cardVideoInfo.w2());
                if (this.cardVideoInfo.T() != null && this.cardVideoInfo.T().getPendantData() == null && (metaData = this.userMap.get(this.cardVideoInfo.T().getUserId())) != null && metaData.getPendantData() != null) {
                    d.a.j0.t.n nVar = new d.a.j0.t.n();
                    nVar.e(metaData.getPendantData().b());
                    nVar.d(metaData.getPendantData().a());
                    this.cardVideoInfo.T().setPendantData(nVar);
                }
            }
            if (dataRes.ala_live_insert != null && dataRes.ala_live_insert.ala_live_list != null && dataRes.ala_live_insert.ala_live_list.size() > 0) {
                g gVar = new g();
                this.mFrsInsertLiveData = gVar;
                gVar.f53761f = dataRes.ala_insert_floor.intValue();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < dataRes.ala_live_insert.ala_live_list.size(); i5++) {
                    if (dataRes.ala_live_insert.ala_live_list.get(i5) != null) {
                        a2 a2Var2 = new a2();
                        a2Var2.T2(dataRes.ala_live_insert.ala_live_list.get(i5));
                        a2Var2.D1 = this.isBrandForum;
                        arrayList.add(a2Var2);
                    }
                }
                this.mFrsInsertLiveData.f53760e = arrayList;
            }
            if (dataRes.ala_stage_list != null) {
                this.mFrsStageLiveData = new h();
                ArrayList arrayList2 = new ArrayList();
                for (int i6 = 0; i6 < dataRes.ala_stage_list.size(); i6++) {
                    if (dataRes.ala_stage_list.get(i6) != null) {
                        a2 a2Var3 = new a2();
                        a2Var3.T2(dataRes.ala_stage_list.get(i6));
                        a2Var3.D1 = this.isBrandForum;
                        arrayList2.add(a2Var3);
                    }
                }
                this.mFrsStageLiveData.f53772e = arrayList2;
            }
            if (dataRes.school_recom_info != null) {
                this.schoolRecommendPos = dataRes.school_recom_pos.intValue();
                q1 q1Var = new q1();
                this.schoolRecommendInfo = q1Var;
                q1Var.C4(dataRes.school_recom_info);
            }
            if (dataRes.carrier_enter != null) {
                d.a.j0.r.q.s sVar = new d.a.j0.r.q.s();
                this.carrierEnterData = sVar;
                sVar.a(dataRes.carrier_enter);
            }
            if (dataRes.vitality_info != null && dataRes.vitality_info.frequently_forum_info != null) {
                this.forumState = dataRes.vitality_info.frequently_forum_info.forum_state.intValue();
                this.accessFlag = dataRes.vitality_info.frequently_forum_info.access_flag.intValue();
            }
            this.mSortType = dataRes.sort_type.intValue();
            this.needLog = dataRes.need_log.intValue();
            d.a.k0.s2.g0.a.e().h(dataRes.asp_shown_info);
            this.mCardShipinPos = dataRes.card_shipin_pos;
            if (dataRes.card_shipin_new != null) {
                for (int i7 = 0; i7 < dataRes.card_shipin_new.size(); i7++) {
                    a2 a2Var4 = new a2();
                    if (this.mCardShipinPos != null && this.mCardShipinPos.size() >= dataRes.card_shipin_new.size()) {
                        a2Var4.H3(this.mCardShipinPos.get(i7).intValue());
                    }
                    a2Var4.J3(true);
                    a2Var4.T2(dataRes.card_shipin_new.get(i7));
                    a2Var4.D1 = this.isBrandForum;
                    this.mCardShipinNew.add(a2Var4);
                }
            }
            this.enterFrsDialogInfo = dataRes.enter_pop_info;
            if (dataRes.esport != null) {
                d.a.k0.t0.b bVar = new d.a.k0.t0.b();
                this.mGameRankListData = bVar;
                bVar.f(dataRes.esport);
            }
            this.agreeBanner = dataRes.agree_banner;
            if (dataRes.user_extend != null) {
                d.a.k0.q0.x xVar4 = new d.a.k0.q0.x();
                this.userRecommend = xVar4;
                xVar4.k(dataRes.user_extend);
            }
            this.liveNotify = dataRes.live_frs_notify;
            this.gameTabInfo = dataRes.frs_game_tab_info;
            this.gameDefaultTabId = dataRes.game_default_tab_id.intValue();
            this.forumHeadIcon = dataRes.forum_head_icon;
            if (dataRes.video != null && dataRes.video.video_act != null) {
                q qVar = new q();
                this.mFrsVideoActivityData = qVar;
                qVar.c(dataRes.video.video_act);
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
                        b0 b0Var2 = new b0();
                        b0Var2.f53724b = serviceArea.picurl;
                        b0Var2.f53725c = serviceArea.servicename;
                        String str = serviceArea.service_type;
                        b0Var2.f53723a = str;
                        if (str != null && str.equals("原生小程序") && serviceArea.area_smart_app != null) {
                            b0Var2.f53724b = serviceArea.area_smart_app.avatar;
                            b0Var2.f53725c = serviceArea.area_smart_app.name;
                        }
                        b0Var2.f53726d = serviceArea.serviceurl;
                        b0Var2.f53727e = serviceArea.schema;
                        b0Var2.f53731i = serviceArea.third_statistics_url;
                        String str2 = serviceArea.version;
                        String p = d.a.j0.r.d0.b.j().p("frs_service_version_" + this.forum.getName() + b0Var2.f53725c, "");
                        if (!TextUtils.isEmpty(p)) {
                            p.equals(serviceArea.version);
                        }
                        if (serviceArea.area_smart_app != null) {
                            c0 c0Var = new c0();
                            c0Var.a(serviceArea.area_smart_app);
                            b0Var2.f53728f = c0Var;
                        }
                        if (this.forum != null) {
                            this.forum.getName();
                            b0Var2.f53729g = this.forum.getId();
                        }
                        b0Var2.f53730h = i2;
                        i2++;
                        arrayList3.add(b0Var2);
                    }
                }
                this.serviceAreaData.f53721a = arrayList3.size();
                this.serviceAreaData.f53722b = arrayList3;
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
