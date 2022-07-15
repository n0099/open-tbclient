package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SmartApp;
/* loaded from: classes7.dex */
public class vy5 extends ny5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId A0;
    public static final BdUniqueId B0;
    public static final BdUniqueId C0;
    public static final BdUniqueId D0;
    public static final BdUniqueId E0;
    public static final BdUniqueId F0;
    public static final BdUniqueId G0;
    public static final BdUniqueId H0;
    public static final BdUniqueId I0;
    public static final BdUniqueId J0;
    public static final BdUniqueId K0;
    public static final BdUniqueId L0;
    public static final BdUniqueId M0;
    public static String R = "";
    public static String S = "";
    public static String T = "";
    public static String U = "";
    public static String V = "";
    public static String W = "";
    public static String X = "";
    public static String Y = "";
    public static String Z = "";
    public static String g0 = "";
    public static String h0 = "";
    public static String i0 = "";
    public static String j0 = "";
    public static String k0 = "";
    public static String l0 = "";
    public static String m0 = "";
    public static String n0 = "";
    public static final BdUniqueId o0;
    public static final BdUniqueId p0;
    public static final BdUniqueId q0;
    public static final BdUniqueId r0;
    public static final BdUniqueId s0;
    public static final BdUniqueId t0;
    public static final BdUniqueId u0;
    public static final BdUniqueId v0;
    public static final BdUniqueId w0;
    public static final BdUniqueId x0;
    public static final BdUniqueId y0;
    public static final BdUniqueId z0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755214817, "Lcom/repackage/vy5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755214817, "Lcom/repackage/vy5;");
                return;
            }
        }
        o0 = BdUniqueId.gen();
        p0 = BdUniqueId.gen();
        q0 = BdUniqueId.gen();
        r0 = BdUniqueId.gen();
        s0 = BdUniqueId.gen();
        t0 = BdUniqueId.gen();
        u0 = BdUniqueId.gen();
        v0 = BdUniqueId.gen();
        w0 = BdUniqueId.gen();
        x0 = BdUniqueId.gen();
        y0 = BdUniqueId.gen();
        z0 = BdUniqueId.gen();
        A0 = BdUniqueId.gen();
        B0 = BdUniqueId.gen();
        C0 = BdUniqueId.gen();
        D0 = BdUniqueId.gen();
        E0 = BdUniqueId.gen();
        F0 = BdUniqueId.gen();
        G0 = BdUniqueId.gen();
        H0 = BdUniqueId.gen();
        I0 = BdUniqueId.gen();
        J0 = BdUniqueId.gen();
        K0 = BdUniqueId.gen();
        L0 = BdUniqueId.gen();
        M0 = BdUniqueId.gen();
    }

    public vy5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean W(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, threadData)) == null) {
            if (threadData == null) {
                return false;
            }
            return threadData.getType() == ThreadData.TYPE_NORMAL || threadData.getType() == ThreadData.TYPE_GOD_NORMAL || threadData.getType() == ThreadData.TYPE_LINK || threadData.getType() == ThreadData.TYPE_SHARE_THREAD || threadData.getType() == ThreadData.TYPE_FRS_HOTTOPIC;
        }
        return invokeL.booleanValue;
    }

    public static boolean X(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, threadData)) == null) {
            if (threadData == null) {
                return false;
            }
            return threadData.getType() == ThreadData.TYPE_SMART_APP_IMAGE || threadData.getType() == ThreadData.TYPE_SMART_APP_VIDEO;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ny5
    public StatisticItem A() {
        InterceptResult invokeV;
        StatisticItem s;
        SmartApp smartApp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (V()) {
                s = s(X);
            } else if (U()) {
                StatisticItem s2 = s(j0);
                if (s2 != null && getThreadData() != null && (smartApp = getThreadData().getSmartApp()) != null) {
                    TiebaStatic.deleteParamByKey(s2, "obj_type");
                    s2.param("obj_type", smartApp.id);
                    s2.param("obj_name", smartApp.name);
                }
                return s2;
            } else {
                s = s(S);
                if (s != null) {
                    s.param(TiebaStatic.Params.AB_ACTION, "click");
                    if (getThreadData() != null) {
                        ThreadData threadData = getThreadData();
                        if (threadData.getBaijiahaoData() != null) {
                            s.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                        }
                        s.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData));
                    }
                }
            }
            if (s != null && getThreadData() != null) {
                s.param(TiebaStatic.Params.IS_FULL, getThreadData().isShowFullThread() ? 1 : 0);
            }
            return s;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // com.repackage.ny5
    public StatisticItem B() {
        InterceptResult invokeV;
        SmartApp smartApp;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = 0;
            int i2 = 1;
            if (V()) {
                StatisticItem s = s(W);
                if (s != null) {
                    s.setPosition(this.position);
                    if (getThreadData() != null) {
                        ThreadData threadData = getThreadData();
                        if (threadData.getTopAgreePost() != null && (threadData.getTopAgreePost().Q() != null || threadData.getTopAgreePost().e0() != null)) {
                            i = 1;
                        }
                        s.param("obj_name", i);
                        if (threadData.getAuthor() != null) {
                            s.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                        }
                        s.param(TiebaStatic.Params.IS_FULL, threadData.isShowFullThread() ? 1 : 0);
                    }
                }
                return s;
            } else if (U()) {
                StatisticItem s2 = s(i0);
                if (s2 != null) {
                    s2.setPosition(this.position);
                    if (getThreadData() != null && (smartApp = getThreadData().getSmartApp()) != null) {
                        TiebaStatic.deleteParamByKey(s2, "obj_type");
                        s2.param("obj_type", smartApp.id);
                        s2.param("obj_name", smartApp.name);
                    }
                }
                return s2;
            } else if (isVideoThreadType()) {
                return null;
            } else {
                StatisticItem s3 = s(R);
                if (s3 != null) {
                    s3.setPosition(this.position);
                    s3.param(TiebaStatic.Params.AB_ACTION, "show");
                    if (getThreadData() != null) {
                        ThreadData threadData2 = getThreadData();
                        int i3 = (threadData2.getTopAgreePost() == null || (threadData2.getTopAgreePost().Q() == null && threadData2.getTopAgreePost().e0() == null)) ? 0 : 1;
                        s3.param("obj_name", i3);
                        if (i3 != 0 && threadData2.getTopAgreePost().Q() != null && threadData2.getTopAgreePost().Q().C() != null && threadData2.getTopAgreePost().Q().C().size() > 0) {
                            s3.param(TiebaStatic.Params.OBJ_TO, threadData2.getTopAgreePost().L ? 2 : 1);
                        }
                        if (threadData2.getAuthor() != null) {
                            s3.param(TiebaStatic.Params.AB_TYPE, threadData2.getAuthor().hadConcerned() ? 1 : 0);
                        }
                        s3.param(TiebaStatic.Params.IS_FULL, threadData2.isShowFullThread() ? 1 : 0);
                        if (threadData2.getBaijiahaoData() != null) {
                            s3.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.getBaijiahaoData().oriUgcNid);
                        }
                        s3.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData2));
                        if (threadData2.isAlaLiveUser()) {
                            s3.param(TiebaStatic.Params.OBJ_PARAM6, 2);
                        } else {
                            s3.param(TiebaStatic.Params.OBJ_PARAM6, 1);
                        }
                        if (threadData2.isGoods()) {
                            s3.param(TiebaStatic.Params.GUA_TYPE, 1);
                        } else if (threadData2.getItem() != null) {
                            s3.param(TiebaStatic.Params.GUA_TYPE, 2);
                        } else {
                            s3.param(TiebaStatic.Params.GUA_TYPE, 0);
                        }
                        if (threadData2.getAuthor() != null && threadData2.getAuthor().getAlaInfo() != null) {
                            int calculateLiveType = YYLiveUtil.calculateLiveType(threadData2.getAuthor().getAlaInfo());
                            if (threadData2.getAuthor().getAlaInfo().live_status != 1 && threadData2.getAuthor().getAlaInfo().friendRoomStatus != 2) {
                                i2 = 2;
                            }
                            if (threadData2.getAuthor().getAlaInfo().mYyExtData != null) {
                                TiebaStaticHelper.addYYParam(s3, threadData2.getAuthor().getAlaInfo().mYyExtData);
                            }
                            s3.param(TiebaStatic.Params.OBJ_PARAM7, i2);
                            s3.param(TiebaStatic.Params.OBJ_PARAM8, calculateLiveType);
                        }
                    }
                }
                return s3;
            }
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // com.repackage.ny5
    public StatisticItem C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StatisticItem u = u(k0, true);
            if (getThreadData() != null) {
                ThreadData threadData = getThreadData();
                if (threadData.getBaijiahaoData() != null) {
                    u.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    u.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                u.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData));
            }
            return u;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public int N(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, threadData)) == null) {
            if (threadData == null) {
                return 0;
            }
            if (threadData.isBJHArticleThreadType()) {
                return 1;
            }
            if (threadData.isVideoThreadType()) {
                return 2;
            }
            if (threadData.isBJHNormalThreadType()) {
                return 3;
            }
            return threadData.isBJHVideoDynamicThreadType() ? 4 : 0;
        }
        return invokeL.intValue;
    }

    public StatisticItem O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            StatisticItem s = s(str);
            if (s != null) {
                s.param("ab_tag", c()).param(TiebaStatic.Params.AB_ACTION, "show");
                if (getThreadData() != null) {
                    ThreadData threadData = getThreadData();
                    int i = (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().Q() == null && threadData.getTopAgreePost().e0() == null)) ? 0 : 1;
                    s.param("obj_name", i);
                    if (i != 0 && threadData.getTopAgreePost().Q() != null && threadData.getTopAgreePost().Q().C() != null && threadData.getTopAgreePost().Q().C().size() > 0) {
                        s.param(TiebaStatic.Params.OBJ_TO, threadData.getTopAgreePost().L ? 2 : 1);
                    }
                }
            }
            return s;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public StatisticItem P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (V()) {
                return s(g0);
            }
            StatisticItem s = s(V);
            if (s != null) {
                s.param(TiebaStatic.Params.AB_ACTION, "click");
                if (getThreadData() != null) {
                    ThreadData threadData = getThreadData();
                    if (threadData.getBaijiahaoData() != null) {
                        s.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    }
                    s.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData));
                }
                s.param(TiebaStatic.Params.OBJ_TO, le5.c() ? 1 : 2);
            }
            return s;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? s(str) : (StatisticItem) invokeL.objValue;
    }

    public StatisticItem R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            StatisticItem s = s(str);
            ThreadData threadData = this.a;
            if (threadData != null && threadData.getAuthor() != null) {
                s.param(TiebaStatic.Params.AB_TYPE, this.a.getAuthor().hadConcerned() ? 1 : 0);
            }
            return s;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public StatisticItem S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (wy5.R(this.a)) {
                StatisticItem u = u(l0, true);
                if (u != null && getThreadData() != null) {
                    ThreadData threadData = getThreadData();
                    if (threadData.getBaijiahaoData() != null) {
                        u.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                        u.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                    }
                    u.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData));
                    if (threadData.isAlaLiveUser()) {
                        u.addParam(TiebaStatic.Params.OBJ_PARAM2, 2);
                    } else {
                        u.addParam(TiebaStatic.Params.OBJ_PARAM2, 1);
                    }
                    if (threadData.getAuthor() != null && threadData.getAuthor().getAlaInfo() != null) {
                        int calculateLiveType = YYLiveUtil.calculateLiveType(threadData.getAuthor().getAlaInfo());
                        if (threadData.getAuthor().getAlaInfo().mYyExtData != null) {
                            TiebaStaticHelper.addYYParam(u, threadData.getAuthor().getAlaInfo().mYyExtData);
                        }
                        u.param(TiebaStatic.Params.OBJ_PARAM7, calculateLiveType);
                    }
                }
                return u;
            } else if (V()) {
                return s(Z);
            } else {
                StatisticItem s = s(U);
                if (s != null) {
                    s.param("ab_tag", c()).param(TiebaStatic.Params.AB_ACTION, "click");
                    if (getThreadData() != null) {
                        ThreadData threadData2 = getThreadData();
                        if (threadData2.getBaijiahaoData() != null) {
                            s.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.getBaijiahaoData().oriUgcNid);
                        }
                        s.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData2));
                        s.param("nid", threadData2.getNid());
                        if (threadData2.isAlaLiveUser()) {
                            s.param(TiebaStatic.Params.OBJ_PARAM2, 2);
                        } else {
                            s.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                        }
                        if (threadData2.getAuthor() != null && threadData2.getAuthor().getAlaInfo() != null) {
                            int calculateLiveType2 = YYLiveUtil.calculateLiveType(threadData2.getAuthor().getAlaInfo());
                            if (threadData2.getAuthor().getAlaInfo().mYyExtData != null) {
                                TiebaStaticHelper.addYYParam(s, threadData2.getAuthor().getAlaInfo().mYyExtData);
                            }
                            s.param(TiebaStatic.Params.OBJ_PARAM6, calculateLiveType2);
                        }
                    }
                }
                return s;
            }
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? s(h0) : (StatisticItem) invokeV.objValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ThreadData threadData = this.a;
            return threadData == null || threadData.isSmartAppThreadType();
        }
        return invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ThreadData threadData = this.a;
            return (threadData == null || ListUtils.getCount(threadData.getVoice()) == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public int Y(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, threadData)) == null) {
            if (threadData == null) {
                return 1;
            }
            if (threadData.isBJHVideoDynamicThreadType() || threadData.isBJHNormalThreadType()) {
                return 2;
            }
            return (threadData.isBJHArticleThreadType() || threadData.isBJHVideoThreadType()) ? 3 : 1;
        }
        return invokeL.intValue;
    }

    @Override // com.repackage.ny5
    public StatisticItem d(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            ThreadData threadData = this.a;
            if (threadData != null) {
                if (threadData.getBaijiahaoData() == null) {
                    statisticItem.param("fid", this.a.getFid());
                    statisticItem.param("tid", this.a.getTid());
                    statisticItem.param("fname", this.a.getForum_name());
                } else {
                    statisticItem.param("tid", this.a.getBaijiahaoData().oriUgcNid);
                }
                if (this.a.isVideoThreadType()) {
                    i = 2;
                } else if (this.a.isLinkThread()) {
                    i = 4;
                } else {
                    ThreadData threadData2 = this.a;
                    if (threadData2.isShareThread) {
                        i = 5;
                    } else if (threadData2.isBJHArticleThreadType()) {
                        i = 6;
                    } else if (this.a.isBJHNormalThreadType()) {
                        i = 7;
                    } else if (this.a.isBJHVideoThreadType()) {
                        i = 8;
                    } else {
                        i = this.a.isBJHVideoDynamicThreadType() ? 9 : 1;
                    }
                }
                statisticItem.param("obj_type", i);
                statisticItem.param("obj_id", this.a.getAuthor().getUserId());
                statisticItem.param("obj_param1", E() ? 2 : 1);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // com.repackage.ny5, com.repackage.nn4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData == null) {
                return null;
            }
            if (threadData.getResource() == 5) {
                return this.a;
            }
            this.a.setResource(1);
            return this.a;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.nn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        OriginalThreadInfo originalThreadInfo;
        int indexOf;
        int indexOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData == null) {
                return o0;
            }
            if (this.B && ny5.Q.length > 1) {
                BdUniqueId type = threadData.getType();
                if (type == ThreadData.TYPE_NORMAL || type == ThreadData.TYPE_LINK || type == ThreadData.TYPE_FRS_HOTTOPIC || type == ThreadData.TYPE_GOD_NORMAL) {
                    if (this.n) {
                        indexOf = ny5.O.indexOf(ny5.E);
                    } else {
                        indexOf = ny5.O.indexOf(ny5.D);
                    }
                    if (this.o) {
                        indexOf2 = ny5.P.indexOf(ny5.F);
                    } else if (this.q) {
                        indexOf2 = ny5.P.indexOf(ny5.H);
                    } else if (this.p) {
                        indexOf2 = ny5.P.indexOf(ny5.G);
                    } else {
                        indexOf2 = ny5.P.indexOf(ny5.I);
                    }
                    if (indexOf >= 0) {
                        BdUniqueId[][] bdUniqueIdArr = ny5.Q;
                        return (indexOf >= bdUniqueIdArr.length || indexOf2 < 0 || indexOf2 >= bdUniqueIdArr[0].length) ? type : bdUniqueIdArr[indexOf][indexOf2];
                    }
                    return type;
                }
                return type;
            }
            ThreadData threadData2 = this.a;
            int i = threadData2.threadType;
            if (i == 63) {
                return v0;
            }
            if (i == 64) {
                return w0;
            }
            if (threadData2.isShareThread && (originalThreadInfo = threadData2.originalThreadData) != null) {
                if (originalThreadInfo.x) {
                    if (originalThreadInfo.r != null) {
                        return u0;
                    }
                    if (originalThreadInfo.h()) {
                        return t0;
                    }
                    return s0;
                }
                return r0;
            } else if (this.m) {
                return z0;
            } else {
                if (this.t) {
                    return F0;
                }
                if (this.r) {
                    return B0;
                }
                if (this.p) {
                    return C0;
                }
                if (this.q) {
                    return D0;
                }
                if (this.o) {
                    return E0;
                }
                if (this.A) {
                    return G0;
                }
                if (this.y) {
                    return I0;
                }
                if (this.x) {
                    return H0;
                }
                if (this.n) {
                    return A0;
                }
                if (this.u) {
                    return J0;
                }
                if (this.v) {
                    return K0;
                }
                if (this.w) {
                    return L0;
                }
                if (this.z) {
                    return M0;
                }
                return y0;
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.repackage.ny5
    public StatisticItem i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (V()) {
                return s(Y);
            }
            if (wy5.R(this.a)) {
                StatisticItem u = u(m0, true);
                if (u != null && getThreadData() != null) {
                    ThreadData threadData = getThreadData();
                    if (threadData.getBaijiahaoData() != null) {
                        u.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                        u.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                    }
                    u.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData));
                }
                return u;
            }
            StatisticItem t = t(T, 0);
            if (t != null) {
                t.param("ab_tag", c()).param(TiebaStatic.Params.AB_ACTION, "click");
                if (getThreadData() != null) {
                    ThreadData threadData2 = getThreadData();
                    if (threadData2.getBaijiahaoData() != null) {
                        t.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.getBaijiahaoData().oriUgcNid);
                    }
                    t.param(TiebaStatic.Params.OBJ_PARAM5, Y(threadData2));
                    t.param("nid", threadData2.getNid());
                }
            }
            return t;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // com.repackage.ny5
    public boolean isVideoThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ThreadData threadData = this.a;
            return threadData != null && threadData.isVideoThreadType();
        }
        return invokeV.booleanValue;
    }
}
