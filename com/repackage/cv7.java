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
/* loaded from: classes5.dex */
public class cv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<jn> a;
    public final RelateRecThreadListModel b;
    public ot7 c;
    public PbModel d;
    public boolean e;
    public List<jn> f;
    public final el4 g;

    /* loaded from: classes5.dex */
    public class a implements el4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv7 a;

        public a(cv7 cv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cv7Var;
        }

        @Override // com.repackage.el4
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) || this.a.c == null || this.a.c.X0() == null) {
                return;
            }
            this.a.c.X0().M();
        }

        @Override // com.repackage.el4
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                if (this.a.d != null && (obj instanceof DataRes)) {
                    DataRes dataRes = (DataRes) obj;
                    kp7 P1 = this.a.d.P1();
                    String first_class = P1.l() != null ? P1.l().getFirst_class() : "";
                    List<ThreadInfo> list = dataRes.recom_thread_info;
                    if (ListUtils.isEmpty(list)) {
                        if (this.a.c == null || this.a.c.X0() == null) {
                            return;
                        }
                        this.a.c.X0().u(P1.t());
                        this.a.c.X0().M();
                        if (P1.t()) {
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem.param("fid", P1.m());
                            statisticItem.param("fname", P1.n());
                            statisticItem.param("tid", P1.Q());
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        return;
                    }
                    List<jn> b = dv7.b(list, first_class, this.a.d.O1());
                    this.a.a.addAll(b);
                    P1.L0(this.a.a);
                    this.a.f.addAll(b);
                    Integer num = dataRes.rec_type;
                    P1.I0(num == null ? 0 : num.intValue());
                }
                if (this.a.c != null && !ListUtils.isEmpty(this.a.a)) {
                    this.a.c.N3();
                }
                if (this.a.c.X0() == null || !this.a.c.X0().n() || ListUtils.isEmpty(this.a.a)) {
                    return;
                }
                this.a.c.X0().k();
            }
        }
    }

    public cv7(pw7 pw7Var, BdUniqueId bdUniqueId, ot7 ot7Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pw7Var, bdUniqueId, ot7Var, pbModel};
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
        this.c = ot7Var;
        this.d = pbModel;
        RelateRecThreadListModel relateRecThreadListModel = new RelateRecThreadListModel(pw7Var.getPageContext(), bdUniqueId);
        this.b = relateRecThreadListModel;
        relateRecThreadListModel.F(this.g);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.d;
            if (pbModel == null || TextUtils.isEmpty(pbModel.h2()) || this.d.P1() == null) {
                return false;
            }
            if (this.e) {
                return true;
            }
            if (this.d.P1().a0()) {
                return false;
            }
            String forumId = this.d.getForumId();
            if (TextUtils.isEmpty(forumId) && this.d.P1().l() != null) {
                forumId = this.d.P1().l().getId();
            }
            long g = jg.g(forumId, 0L);
            long g2 = jg.g(this.d.h2(), 0L);
            int c2 = this.d.c2();
            String b2 = this.d.b2();
            if (!this.e) {
                this.e = true;
            }
            return this.b.E(g, g2, 1, c2, b2);
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

    public void f(ot7 ot7Var, PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ot7Var, pbModel) == null) {
            this.c = ot7Var;
            this.d = pbModel;
        }
    }
}
