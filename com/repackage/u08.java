package com.repackage;

import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import java.util.List;
import tbclient.Anti;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.HotUserRankEntry;
import tbclient.PostInfoList;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.TAInfo;
import tbclient.Profile.UserAgreeInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.TbBookrack;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes7.dex */
public interface u08 {
    Anti GetAntiStat();

    List<PostInfoList> GetPostList();

    User GetUser();

    TbBookrack getBookrackData();

    List<ForumDynamic> getConcernedForumList();

    List<DynamicInfo> getDynamicInfoList();

    int getErrorCode();

    is6 getGoodsWindowInfo();

    HotUserRankEntry getHotRankEntry();

    AlaLiveInfoCoreData getLiveInfo();

    List<AlaLiveInfoCoreData> getLiveReplayInfo();

    int getMaskType();

    List<ThreadInfo> getNewestThreadList();

    NicknameInfo getNicknameInfo();

    TAInfo getTaInfo();

    UserAgreeInfo getUserAgreeInfo();

    UserGodInfo getUserGodInfo();
}
