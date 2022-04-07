package com.repackage;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.relatelist.RelateRecThreadListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.RelateRecThread.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class px7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<uo> a;
    public final RelateRecThreadListModel b;
    public zv7 c;
    public PbModel d;
    public boolean e;
    public List<uo> f;
    public final gm4 g;

    /* loaded from: classes6.dex */
    public class a implements gm4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px7 a;

        public a(px7 px7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {px7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = px7Var;
        }

        @Override // com.repackage.gm4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) || this.a.c == null || this.a.c.O0() == null) {
                return;
            }
            this.a.c.O0().M();
        }

        @Override // com.repackage.gm4
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.a.d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    yr7 T0 = this.a.d.T0();
                    String first_class = T0.l() != null ? T0.l().getFirst_class() : "";
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.a.c == null || this.a.c.O0() == null) {
                            return;
                        }
                        this.a.c.O0().u(T0.t());
                        this.a.c.O0().M();
                        if (T0.t()) {
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem.param("fid", T0.m());
                            statisticItem.param("fname", T0.n());
                            statisticItem.param("tid", T0.Q());
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    }
                    List<uo> b = qx7.b(list, first_class, this.a.d.S0());
                    this.a.a.addAll(b);
                    T0.L0(this.a.a);
                    this.a.f.addAll(b);
                    Integer num = dataRes.rec_type;
                    T0.I0(num == null ? 0 : num.intValue());
                }
                if (this.a.c != null && !ListUtils.isEmpty(this.a.a)) {
                    this.a.c.y3();
                }
                if (this.a.c.O0() == null || !this.a.c.O0().n() || ListUtils.isEmpty(this.a.a)) {
                    return;
                }
                this.a.c.O0().k();
            }
        }
    }

    public px7(cz7 cz7Var, BdUniqueId bdUniqueId, zv7 zv7Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cz7Var, bdUniqueId, zv7Var, pbModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f = new ArrayList();
        this.g = new a(this);
        this.c = zv7Var;
        this.d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(cz7Var.getPageContext(), bdUniqueId);
        this.b = relateRecThreadListModel;
        relateRecThreadListModel.F(this.g);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.l1()) || this.d.T0() == null) {
                return false;
            }
            if (this.e) {
                return true;
            }
            if (this.d.T0().a0()) {
                return false;
            }
            String forumId = this.d.getForumId();
            if (TextUtils.isEmpty(forumId) && this.d.T0().l() != null) {
                forumId = this.d.T0().l().getId();
            }
            long g = mg.g(forumId, 0L);
            long g2 = mg.g(this.d.l1(), 0L);
            int g1 = this.d.g1();
            String f1 = this.d.f1();
            if (!this.e) {
                this.e = true;
            }
            return this.b.E(g, g2, 1, g1, f1);
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.clear();
            this.b.onDestroy();
        }
    }

    public void f(zv7 zv7Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, zv7Var, pbModel) == null) {
            this.c = zv7Var;
            this.d = pbModel;
        }
    }
}
