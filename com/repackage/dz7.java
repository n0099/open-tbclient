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
public class dz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<on> a;
    public final RelateRecThreadListModel b;
    public nx7 c;
    public PbModel d;
    public boolean e;
    public List<on> f;
    public final vm4 g;

    /* loaded from: classes6.dex */
    public class a implements vm4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dz7 a;

        public a(dz7 dz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dz7Var;
        }

        @Override // com.repackage.vm4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) || this.a.c == null || this.a.c.X0() == null) {
                return;
            }
            this.a.c.X0().M();
        }

        @Override // com.repackage.vm4
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.a.d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    ft7 Q1 = this.a.d.Q1();
                    String first_class = Q1.l() != null ? Q1.l().getFirst_class() : "";
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.a.c == null || this.a.c.X0() == null) {
                            return;
                        }
                        this.a.c.X0().u(Q1.t());
                        this.a.c.X0().M();
                        if (Q1.t()) {
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem.param("fid", Q1.m());
                            statisticItem.param("fname", Q1.n());
                            statisticItem.param("tid", Q1.Q());
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    }
                    List<on> b = ez7.b(list, first_class, this.a.d.P1());
                    this.a.a.addAll(b);
                    Q1.O0(this.a.a);
                    this.a.f.addAll(b);
                    Integer num = dataRes.rec_type;
                    Q1.L0(num == null ? 0 : num.intValue());
                }
                if (this.a.c != null && !ListUtils.isEmpty(this.a.a)) {
                    this.a.c.R3();
                }
                if (this.a.c.X0() == null || !this.a.c.X0().n() || ListUtils.isEmpty(this.a.a)) {
                    return;
                }
                this.a.c.X0().k();
            }
        }
    }

    public dz7(t08 t08Var, BdUniqueId bdUniqueId, nx7 nx7Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t08Var, bdUniqueId, nx7Var, pbModel};
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
        this.c = nx7Var;
        this.d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(t08Var.getPageContext(), bdUniqueId);
        this.b = relateRecThreadListModel;
        relateRecThreadListModel.G(this.g);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.i2()) || this.d.Q1() == null) {
                return false;
            }
            if (this.e) {
                return true;
            }
            if (this.d.Q1().b0()) {
                return false;
            }
            String forumId = this.d.getForumId();
            if (TextUtils.isEmpty(forumId) && this.d.Q1().l() != null) {
                forumId = this.d.Q1().l().getId();
            }
            long g = og.g(forumId, 0L);
            long g2 = og.g(this.d.i2(), 0L);
            int d2 = this.d.d2();
            String c2 = this.d.c2();
            if (!this.e) {
                this.e = true;
            }
            return this.b.F(g, g2, 1, d2, c2);
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

    public void f(nx7 nx7Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, nx7Var, pbModel) == null) {
            this.c = nx7Var;
            this.d = pbModel;
        }
    }
}
