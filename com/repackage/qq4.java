package com.repackage;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qq4 extends nn4 implements nn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public ThreadData s;
    public int t;
    public int u;

    public qq4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.t = 0;
        this.u = 0;
    }

    @Override // com.repackage.nn4
    public kp4 getNegFeedBackData() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ThreadData threadData = this.s;
            if (threadData == null || (sparseArray = threadData.feedBackReasonMap) == null || sparseArray.size() <= 0) {
                return null;
            }
            kp4 kp4Var = new kp4();
            kp4Var.o(getThreadData().getTid());
            kp4Var.k(getThreadData().getFid());
            kp4Var.n(getThreadData().getNid());
            kp4Var.j(this.s.feedBackReasonMap);
            ThreadData threadData2 = this.s;
            kp4Var.g = threadData2.feedBackExtraMap;
            kp4Var.p = threadData2.mRecomAbTag;
            kp4Var.k = threadData2.mRecomWeight;
            kp4Var.m = threadData2.mRecomExtra;
            kp4Var.l = threadData2.mRecomSource;
            kp4Var.q = threadData2.statFloor;
            kp4Var.o = threadData2.getRecomCardType();
            return kp4Var;
        }
        return (kp4) invokeV.objValue;
    }

    @Override // com.repackage.nn4
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s.mRecomReason : (String) invokeV.objValue;
    }

    @Override // com.repackage.nn4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.s : (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.nn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ThreadData threadData = this.s;
            if (threadData == null) {
                return null;
            }
            if (threadData.getIsDailyThread()) {
                if (this.s.getThreadVideoInfo() != null) {
                    return ThreadData.TYPE_VIDEO;
                }
                return ThreadData.TYPE_NORMAL;
            }
            int is_top = this.s.getIs_top();
            ThreadData threadData2 = this.s;
            int i2 = threadData2.threadType;
            if (i2 == 63) {
                return ThreadData.TYPE_SMART_APP_IMAGE;
            }
            if (i2 == 64) {
                return ThreadData.TYPE_SMART_APP_VIDEO;
            }
            if (i2 == 65) {
                return ThreadData.TYPE_ARTICLE;
            }
            if (threadData2.getThreadAlaInfo() != null && this.s.threadType == 60) {
                return ThreadData.TYPE_ALA_SHARE_THREAD;
            }
            if (this.s.getThreadAlaInfo() != null && ((i = this.s.threadType) == 49 || i == 69)) {
                return ThreadData.TYPE_VIDEO_ALA_ONLIVE;
            }
            if (this.s.getThreadAlaInfo() != null && this.s.threadType == 67) {
                return ThreadData.TYPE_ALA_FRIEND_ROOM;
            }
            ThreadData threadData3 = this.s;
            if (threadData3.threadType == 51) {
                return ThreadData.TYPE_ALA_LIVE_EMPTY;
            }
            if (is_top != 2 && is_top != 1) {
                if (threadData3.getThreadVideoInfo() != null && this.s.isInsertThread() && !this.s.isLiveInterviewLiveType()) {
                    return ThreadData.TYPE_INSERT_VIDEO;
                }
                ThreadData threadData4 = this.s;
                if (threadData4.isShareThread && (originalThreadInfo = threadData4.originalThreadData) != null) {
                    if (originalThreadInfo.x) {
                        if (originalThreadInfo.r != null) {
                            return ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD;
                        }
                        if (originalThreadInfo.h()) {
                            return ThreadData.TYPE_ARTICLE_SHARE_THREAD;
                        }
                        return ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD;
                    }
                    return ThreadData.TYPE_SHARE_THREAD;
                } else if (this.s.isInterviewLiveStyle()) {
                    return ThreadData.isFRSExtraLoaded.get() ? ThreadData.TYPE_STAR_INTERVIEW : ThreadData.TYPE_NORMAL;
                } else if (this.s.isActInfo() && this.s.getActInfoType() == 1) {
                    return ThreadData.isFRSExtraLoaded.get() ? ThreadData.TYPE_LOTTERY : ThreadData.TYPE_NORMAL;
                } else if (this.s.isLinkThread()) {
                    return ThreadData.TYPE_LINK;
                } else {
                    if (this.s.isTopicThread()) {
                        return this.s.getHotTopicInfo() != null ? ThreadData.TYPE_FRS_HOTTOPIC_VIDEO : ThreadData.TYPE_FRS_HOTTOPIC;
                    }
                    mi8 mi8Var = this.s.funAdData;
                    if (mi8Var != null && mi8Var.f()) {
                        return this.s.funAdData.g() ? AdvertAppInfo.D : AdvertAppInfo.E;
                    } else if (this.r) {
                        return ThreadData.TYPE_FORUM_HEADER;
                    } else {
                        if (this.a) {
                            return ThreadData.TYPE_USER_NORMAL;
                        }
                        if (this.b) {
                            return ThreadData.TYPE_CONTENT_TEXT_NORMAL;
                        }
                        if (this.c) {
                            return ThreadData.TYPE_CONTENT_SINGLE_H_NORMAL;
                        }
                        if (this.d) {
                            return ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL;
                        }
                        if (this.e) {
                            return ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL;
                        }
                        if (this.f) {
                            return ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL;
                        }
                        if (this.g) {
                            return ThreadData.TYPE_BOTTOM_NORMAL;
                        }
                        if (this.h) {
                            return ThreadData.TYPE_GODREPLY_NORMAL;
                        }
                        if (this.i) {
                            return ThreadData.TYPE_VIDEO;
                        }
                        if (this.j) {
                            return ThreadData.TYPE_FAKE_VIDEO;
                        }
                        if (this.s.isGodThread()) {
                            if (this.k) {
                                return ThreadData.TYPE_VIDEO_GOD;
                            }
                            return ThreadData.TYPE_GOD_NORMAL;
                        } else if (this.l) {
                            return ThreadData.TYPE_SMART_APP;
                        } else {
                            if (this.m) {
                                return ThreadData.TYPE_ENTER_FORUM;
                            }
                            if (this.n) {
                                return ThreadData.TYPE_ITEM;
                            }
                            if (this.o) {
                                return ThreadData.TYPE_VOTE;
                            }
                            if (this.p) {
                                return ThreadData.TYPE_SINGLE_LINK;
                            }
                            if (this.q) {
                                return ThreadData.TYPE_MULTI_LINK;
                            }
                            return ThreadData.TYPE_NORMAL;
                        }
                    }
                }
            }
            return ThreadData.TYPE_TOP;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
