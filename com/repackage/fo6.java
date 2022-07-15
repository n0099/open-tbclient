package com.repackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class fo6 {
    public static /* synthetic */ Interceptable $ic;
    public static int e;
    public static fo6 f;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener a;
    public c b;
    public Handler c;
    public SparseArray<HashSet<String>> d;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fo6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fo6 fo6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fo6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fo6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.d == null) {
                return;
            }
            this.a.d.clear();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fo6 fo6Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fo6Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 5) {
                Object obj = message.obj;
                if (!(obj instanceof c) || (cVar = (c) obj) == null) {
                    return;
                }
                cVar.d = false;
                cVar.a = false;
                cVar.b = 0;
            }
        }
    }

    public fo6() {
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
        this.a = new a(this, 2005016);
        this.c = new b(this, Looper.getMainLooper());
        e = xt4.k().l("card_show_statistic_max_count", 200);
        MessageManager.getInstance().registerListener(this.a);
    }

    public static fo6 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f == null) {
                synchronized (cy5.class) {
                    if (f == null) {
                        f = new fo6();
                    }
                }
            }
            return f;
        }
        return (fo6) invokeV.objValue;
    }

    public static void m(FrsViewData frsViewData, int i, int i2, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{frsViewData, Integer.valueOf(i), Integer.valueOf(i2), context}) == null) || frsViewData == null || frsViewData.getForum() == null || frsViewData.needLog != 1) {
            return;
        }
        StatisticItem param = new StatisticItem("c11440").param("fid", frsViewData.getForum().getId()).param("obj_locate", i).param("obj_type", i2);
        if (context != null) {
            u85.b(context, param);
        }
        TiebaStatic.log(param);
    }

    public void b(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && threadData != null && threadData.isFloor5Video()) {
            StatisticItem statisticItem = new StatisticItem("c11717");
            statisticItem.param("fid", threadData.getFid());
            statisticItem.param("obj_source", threadData.mRecomSource);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, threadData.mRecomWeight);
            statisticItem.param("obj_param1", threadData.mRecomReason);
            statisticItem.param("obj_locate", 1);
            statisticItem.param("tid", threadData.getTid());
            cy5.b().a(statisticItem);
        }
    }

    public void c(eo6 eo6Var, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eo6Var, threadData) == null) || eo6Var == null || !eo6Var.a || threadData == null || threadData.getTid() == null) {
            return;
        }
        if (this.d == null) {
            this.d = new SparseArray<>();
        }
        if (this.d.get(eo6Var.e) == null) {
            this.d.put(eo6Var.e, new HashSet<>());
        }
        HashSet<String> hashSet = this.d.get(eo6Var.e);
        String tid = threadData.getTid();
        if (eo6Var.f >= 0) {
            tid = tid + "_" + eo6Var.f;
        }
        if (hashSet.contains(tid) || g()) {
            return;
        }
        hashSet.add(tid);
        StatisticItem statisticItem = new StatisticItem("c11439");
        statisticItem.param("fid", eo6Var.c);
        statisticItem.param("obj_locate", l(eo6Var));
        statisticItem.param("obj_source", threadData.mRecomSource);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, threadData.mRecomWeight);
        statisticItem.param("obj_param1", threadData.mRecomAbTag);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, threadData.mRecomReason);
        statisticItem.param("tid", threadData.getTid());
        statisticItem.param("nid", threadData.getNid());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
        int i = eo6Var.e;
        if (i >= 0) {
            statisticItem.param("tab_id", i);
        }
        int i2 = threadData.statFloor;
        if (i2 >= 0) {
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
        }
        int i3 = (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().Q() == null && threadData.getTopAgreePost().e0() == null)) ? 0 : 1;
        if (i3 != 0 && threadData.getTopAgreePost().Q() != null && threadData.getTopAgreePost().Q().C() != null && threadData.getTopAgreePost().Q().C().size() > 0) {
            statisticItem.param("obj_name", threadData.getTopAgreePost().L ? 3 : 2);
        } else {
            statisticItem.param("obj_name", i3);
        }
        boolean z = threadData.getType() == ThreadData.TYPE_FRS_HOTTOPIC;
        statisticItem.param("thread_type", z ? 2 : 1);
        if (z && threadData.getAuthor() != null && !StringUtils.isNull(threadData.getAuthor().getName_show())) {
            statisticItem.param("obj_name", threadData.getAuthor().getName_show());
        }
        if (!threadData.isBJHVideoThreadType() && !threadData.isBJHVideoDynamicThreadType()) {
            if (threadData.isBJHArticleThreadType()) {
                statisticItem.param("obj_type", 13);
            }
        } else {
            statisticItem.param("obj_type", 14);
        }
        cy5.b().a(statisticItem);
        if (threadData.isVideoThreadType()) {
            StatisticItem statisticItem2 = new StatisticItem("c12099");
            statisticItem2.param("fid", eo6Var.c);
            statisticItem2.param("obj_locate", l(eo6Var));
            statisticItem2.param("obj_source", threadData.mRecomSource);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, threadData.mRecomWeight);
            statisticItem2.param("obj_param1", threadData.mRecomAbTag);
            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, threadData.mRecomReason);
            statisticItem2.param("tid", threadData.getTid());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            cy5.b().a(statisticItem2);
        }
        if (eo6Var.e == 501) {
            StatisticItem statisticItem3 = new StatisticItem("c13259");
            statisticItem3.param("fid", eo6Var.c);
            statisticItem3.param("tid", threadData.getTid());
            cy5.b().a(statisticItem3);
        }
    }

    public void d(ThreadData threadData, HashSet<String> hashSet) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, threadData, hashSet) == null) && threadData != null && threadData.isTbReadDispatch()) {
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            if (threadData.getTid() == null || hashSet.contains(threadData.getTid())) {
                return;
            }
            hashSet.add(threadData.getTid());
            cy5.b().a(new StatisticItem("c11662").param("obj_param1", 1).param("post_id", threadData.getTid()));
        }
    }

    public void e(ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, threadData, z) == null) || threadData == null) {
            return;
        }
        cy5.b().a(new StatisticItem("c12125").param("tid", threadData.getId()).param("obj_locate", z ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() != null ? threadData.getThreadAlaInfo().live_id : -1L).param("obj_type", 1));
    }

    public void f(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) || threadData == null) {
            return;
        }
        cy5.b().a(new StatisticItem("c14381").param("tid", threadData.getId()).param("fid", threadData.getFid()).param("fname", threadData.getForum_name()).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b == null) {
                this.b = new c(this, null);
            }
            long currentTimeMillis = System.currentTimeMillis();
            c cVar = this.b;
            if (cVar.d) {
                return true;
            }
            if (cVar.a) {
                int i = cVar.b + 1;
                cVar.b = i;
                if (currentTimeMillis - cVar.c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    if (i >= e) {
                        cVar.d = true;
                        i(cVar);
                        return true;
                    }
                } else {
                    cVar.a = false;
                    cVar.b = 0;
                }
            } else {
                cVar.a = true;
                cVar.c = currentTimeMillis;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h(eo6 eo6Var, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048582, this, eo6Var, threadData, i) == null) || threadData == null || threadData.getTid() == null || eo6Var == null) {
            return;
        }
        if (eo6Var.a || threadData.isJumpToFrsVideoTabPlay) {
            cy5.b().e(true);
            StatisticItem statisticItem = new StatisticItem("c11438");
            statisticItem.param("fid", eo6Var.c);
            statisticItem.param("fname", eo6Var.d);
            statisticItem.param("obj_locate", l(eo6Var));
            statisticItem.param("obj_source", threadData.mRecomSource);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, threadData.mRecomWeight);
            statisticItem.param("obj_param1", threadData.mRecomAbTag);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, threadData.mRecomReason);
            statisticItem.param("tid", threadData.getTid());
            statisticItem.param("hid", kn6.c());
            if (!threadData.isBJHVideoThreadType() && !threadData.isBJHVideoDynamicThreadType()) {
                if (threadData.isBJHArticleThreadType()) {
                    statisticItem.param("obj_type", 13);
                } else {
                    statisticItem.param("obj_type", i);
                }
            } else {
                statisticItem.param("obj_type", 14);
            }
            if (i == 3) {
                statisticItem.param(TiebaStatic.Params.OBJ_TO_PB, le5.c() ? 1 : 2);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_TO, j(threadData));
            int i2 = eo6Var.e;
            if (i2 >= 0) {
                statisticItem.param("tab_id", i2);
            }
            int i3 = threadData.statFloor;
            if (i3 >= 0) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i3);
            }
            statisticItem.param("thread_type", threadData.getType() == ThreadData.TYPE_FRS_HOTTOPIC ? 2 : 1);
            TiebaStatic.log(statisticItem);
            if (threadData.isVideoThreadType()) {
                StatisticItem statisticItem2 = new StatisticItem("c12098");
                statisticItem2.param("fid", eo6Var.c);
                statisticItem2.param("obj_locate", l(eo6Var));
                statisticItem2.param("obj_source", threadData.mRecomSource);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, threadData.mRecomWeight);
                statisticItem2.param("obj_param1", threadData.mRecomAbTag);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, threadData.mRecomReason);
                statisticItem2.param("tid", threadData.getTid());
                statisticItem2.param("obj_type", i);
                statisticItem2.param(TiebaStatic.Params.OBJ_TO, j(threadData));
                TiebaStatic.log(statisticItem2);
            }
            if (eo6Var.e == 501) {
                StatisticItem statisticItem3 = new StatisticItem("c13260");
                statisticItem3.param("fid", eo6Var.c);
                statisticItem3.param("tid", threadData.getTid());
                cy5.b().a(statisticItem3);
            }
            if (threadData.getAuthor() == null || threadData.getAuthor().getAlaUserData() == null) {
                return;
            }
            AlaUserInfoData alaUserData = threadData.getAuthor().getAlaUserData();
            if (alaUserData.live_status != 1 || alaUserData.live_id <= 0) {
                return;
            }
            StatisticItem statisticItem4 = new StatisticItem("c11850");
            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem4);
        }
    }

    public final void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = cVar;
            this.c.removeMessages(5);
            this.c.sendMessageDelayed(obtainMessage, 300000L);
        }
    }

    public final String j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData)) == null) {
            if (threadData.isInsertThread) {
                return String.valueOf(threadData.getInsertFloor());
            }
            return String.valueOf(4);
        }
        return (String) invokeL.objValue;
    }

    public int l(eo6 eo6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, eo6Var)) == null) {
            if (eo6Var == null) {
                return 5;
            }
            int i = eo6Var.b;
            int i2 = eo6Var.h;
            if (i2 == 100) {
                return 20;
            }
            int i3 = eo6Var.g;
            if (i3 > 0) {
                if (eo6Var.e == 1120) {
                    return 15;
                }
                if (i2 == 3) {
                    return 13;
                }
                return i3;
            }
            if (i == 8) {
                i = 9;
            }
            if (eo6Var.e == 504) {
                i = 11;
            }
            if (eo6Var.e == 1120) {
                return 15;
            }
            return i;
        }
        return invokeL.intValue;
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public int b;
        public long c;
        public boolean d;

        public c(fo6 fo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fo6Var};
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
            this.b = 0;
            this.d = false;
        }

        public /* synthetic */ c(fo6 fo6Var, a aVar) {
            this(fo6Var);
        }
    }
}
