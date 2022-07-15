package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.videoPreload.IVideoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wy5 extends ny5 implements IVideoData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId U;
    public static String V;
    public static String W;
    public static String X;
    public static String Y;
    public static String Z;
    public static String g0;
    public static String h0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean R;
    public boolean S;
    public int T;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755185026, "Lcom/repackage/wy5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755185026, "Lcom/repackage/wy5;");
                return;
            }
        }
        U = BdUniqueId.gen();
        V = "";
        W = "";
        X = "";
        Y = "";
        h0 = "";
    }

    public wy5(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.R = false;
        this.S = true;
        this.T = 0;
        this.a = threadData;
    }

    public static boolean R(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, threadData)) == null) ? (threadData == null || threadData.getThreadVideoInfo() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // com.repackage.ny5
    public StatisticItem B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = 1;
            StatisticItem u = u(X, true);
            if (u != null && getThreadData() != null) {
                ThreadData threadData = getThreadData();
                u.param("obj_name", (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().Q() == null && threadData.getTopAgreePost().e0() == null)) ? 0 : 1);
                if (threadData.getAuthor() != null) {
                    u.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                }
                if (threadData.getBaijiahaoData() != null) {
                    u.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    u.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                u.param(TiebaStatic.Params.OBJ_PARAM5, S(threadData));
                if (threadData.isAlaLiveUser()) {
                    u.param(TiebaStatic.Params.OBJ_TO, 2);
                } else {
                    u.param(TiebaStatic.Params.OBJ_TO, 1);
                }
                if (threadData.getAuthor() != null && threadData.getAuthor().getAlaInfo() != null) {
                    int calculateLiveType = YYLiveUtil.calculateLiveType(threadData.getAuthor().getAlaInfo());
                    if (threadData.getAuthor().getAlaInfo().live_status != 1 && threadData.getAuthor().getAlaInfo().friendRoomStatus != 2) {
                        i = 2;
                    }
                    if (threadData.getAuthor().getAlaInfo().mYyExtData != null) {
                        TiebaStaticHelper.addYYParam(u, threadData.getAuthor().getAlaInfo().mYyExtData);
                    }
                    u.param(TiebaStatic.Params.OBJ_PARAM7, i);
                    u.param(TiebaStatic.Params.OBJ_PARAM8, calculateLiveType);
                }
            }
            return u;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // com.repackage.ny5
    public StatisticItem C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StatisticItem u = u(Y, true);
            if (getThreadData() != null) {
                ThreadData threadData = getThreadData();
                if (threadData.getBaijiahaoData() != null) {
                    u.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    u.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                u.param(TiebaStatic.Params.OBJ_PARAM5, S(threadData));
                u.param("nid", threadData.getNid());
            }
            return u;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem N(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) ? O(threadData, -1) : (StatisticItem) invokeL.objValue;
    }

    public StatisticItem O(ThreadData threadData, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, threadData, i)) == null) {
            StatisticItem u = u(Y, true);
            if (u != null) {
                if (i != -1) {
                    u.param(TiebaStatic.Params.CLICK_LOCATE, i);
                }
                if (getThreadData() != null) {
                    ThreadData threadData2 = getThreadData();
                    if (threadData2.getBaijiahaoData() != null) {
                        u.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.getBaijiahaoData().oriUgcNid);
                        u.param(TiebaStatic.Params.OBJ_PARAM6, threadData2.getBaijiahaoData().oriUgcVid);
                    }
                    u.param(TiebaStatic.Params.OBJ_PARAM5, S(threadData2));
                }
            }
            return u;
        }
        return (StatisticItem) invokeLI.objValue;
    }

    public StatisticItem P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StatisticItem u = u(h0, true);
            if (u != null && getThreadData() != null) {
                ThreadData threadData = getThreadData();
                if (threadData.getBaijiahaoData() != null) {
                    u.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    u.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                u.param(TiebaStatic.Params.OBJ_PARAM5, S(threadData));
            }
            return u;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem Q(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, threadData)) == null) {
            StatisticItem u = u(V, true);
            if (u != null && getThreadData() != null) {
                ThreadData threadData2 = getThreadData();
                if (threadData2.getBaijiahaoData() != null) {
                    u.param(TiebaStatic.Params.OBJ_PARAM4, threadData2.getBaijiahaoData().oriUgcNid);
                    u.param(TiebaStatic.Params.OBJ_PARAM6, threadData2.getBaijiahaoData().oriUgcVid);
                    if (threadData2.isAlaLiveUser()) {
                        u.param(TiebaStatic.Params.OBJ_PARAM2, 2);
                    } else {
                        u.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    }
                }
                if (threadData2.getAuthor() != null && threadData2.getAuthor().getAlaInfo() != null) {
                    int calculateLiveType = YYLiveUtil.calculateLiveType(threadData2.getAuthor().getAlaInfo());
                    if (threadData2.getAuthor().getAlaInfo().mYyExtData != null) {
                        TiebaStaticHelper.addYYParam(u, threadData2.getAuthor().getAlaInfo().mYyExtData);
                    }
                    u.param(TiebaStatic.Params.OBJ_PARAM7, calculateLiveType);
                }
                u.param(TiebaStatic.Params.OBJ_PARAM5, S(threadData2));
            }
            return u;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public int S(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, threadData)) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            ThreadData threadData = this.a;
            if (threadData != null) {
                statisticItem.param("fid", threadData.getFid());
                statisticItem.param("tid", this.a.getTid());
                if (this.a.isBJHVideoThreadType()) {
                    statisticItem.param("obj_type", 8);
                } else if (this.a.isBJHVideoDynamicThreadType()) {
                    statisticItem.param("obj_type", 9);
                } else if (this.a.isVideoThreadType()) {
                    statisticItem.param("obj_type", 2);
                }
                statisticItem.param("obj_param1", E() ? 2 : 1);
                if (this.a.getAuthor() != null) {
                    statisticItem.param("obj_id", this.a.getAuthor().getUserId());
                }
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // com.repackage.nn4
    public String getRecomReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData == null) {
                return null;
            }
            return threadData.mRecomReason;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.ny5, com.repackage.nn4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData == null) {
                return null;
            }
            if (threadData.getResource() != 5) {
                this.a.setResource(1);
            }
            return this.a;
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.nn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData == null) {
                return vy5.o0;
            }
            if (this.B) {
                if (this.n) {
                    return ThreadData.TYPE_VIDEO_WITH_FORUM_HEADER;
                }
                return threadData.getType();
            } else if (this.m) {
                return vy5.z0;
            } else {
                if (this.s) {
                    return U;
                }
                if (this.A) {
                    return vy5.G0;
                }
                if (this.y) {
                    return vy5.I0;
                }
                if (this.x) {
                    return vy5.H0;
                }
                if (this.n) {
                    return vy5.A0;
                }
                if (this.u) {
                    return vy5.J0;
                }
                if (this.v) {
                    return vy5.K0;
                }
                if (this.w) {
                    return vy5.L0;
                }
                if (this.z) {
                    return vy5.M0;
                }
                return U;
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.videoPreload.IVideoData
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData == null || threadData.getThreadVideoInfo() == null || this.a.getThreadVideoInfo().video_url == null) {
                return null;
            }
            return this.a.getThreadVideoInfo().video_url;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.ny5
    public StatisticItem i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            StatisticItem u = u(W, true);
            if (u != null && getThreadData() != null) {
                ThreadData threadData = getThreadData();
                if (threadData.getBaijiahaoData() != null) {
                    u.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                    u.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                u.param(TiebaStatic.Params.OBJ_PARAM5, S(threadData));
            }
            return u;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // com.repackage.ny5
    public boolean isVideoThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
