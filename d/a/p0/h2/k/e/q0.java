package d.a.p0.h2.k.e;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
/* loaded from: classes8.dex */
public class q0 extends d.a.o0.r.f0.t.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean s;
    public boolean t;
    public int u;
    public TbPageContext v;
    public String w;
    public int x;
    public b2 y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(TbPageContext tbPageContext, d.a.o0.r.f0.t.b bVar, int i2) {
        super(tbPageContext, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (d.a.o0.r.f0.t.b) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = false;
        this.t = false;
        this.u = 0;
        this.u = i2;
        this.v = tbPageContext;
        if (i2 == 1) {
            super.m("4");
        } else if (i2 == 3) {
            super.m("5");
        } else if (i2 != 4 && i2 != 5 && i2 != 6) {
            super.m("0");
        } else {
            super.m("4");
        }
    }

    @Override // d.a.o0.r.f0.t.c, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || view.getAlpha() < 0.4d) {
            return;
        }
        d.a.o0.r.f0.t.a aVar = this.f52413e;
        String userId = aVar != null ? aVar.getUserId() : "";
        TiebaStatic.log(new StatisticItem("c12408").param("obj_source", t()).param("obj_id", userId).param("tid", this.w));
        int i2 = this.u;
        int i3 = 8;
        int i4 = 0;
        if (i2 == 1) {
            i3 = 3;
        } else if (i2 == 3) {
            i3 = 2;
        } else if (i2 == 5) {
            i3 = 5;
        } else if (i2 == 7) {
            i3 = 7;
        } else if (i2 == 6) {
            i3 = 6;
        } else if (i2 == 4) {
            i3 = 4;
        } else if (i2 != 8) {
            i3 = 0;
        }
        StatisticItem statisticItem = new StatisticItem("c12507");
        statisticItem.param("obj_locate", i3);
        statisticItem.param("obj_id", userId);
        statisticItem.param("tid", this.w);
        statisticItem.param("obj_param1", this.x);
        if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(statisticItem);
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
        statisticItem2.param("obj_id", userId);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem2.param("tid", this.w);
        b2 b2Var = this.y;
        if (b2Var != null) {
            statisticItem2.param("nid", b2Var.A0());
            if (this.y.J() != null && !d.a.c.e.p.k.isEmpty(this.y.J().oriUgcVid)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, this.y.J().oriUgcVid);
            }
            statisticItem2.param("recom_source", this.y.T0);
            statisticItem2.param("ab_tag", this.y.V0);
            statisticItem2.param("weight", this.y.U0);
            statisticItem2.param("extra", this.y.W0);
        }
        TbPageContext tbPageContext = this.v;
        if (tbPageContext != null) {
            d.a.o0.j0.c.e(tbPageContext.getPageActivity(), statisticItem2);
        }
        TiebaStatic.log(statisticItem2);
        super.onClick(view);
        if (this.s && this.f52413e != null) {
            TiebaStatic.log(new StatisticItem("c11924").param("obj_id", this.f52413e.getUserId()));
        }
        if (!this.t || this.f52413e == null) {
            return;
        }
        int i5 = this.u;
        if (i5 == 1) {
            i4 = 1;
        } else if (i5 == 2) {
            i4 = 2;
        }
        TiebaStatic.log(new StatisticItem("c12150").param("obj_locate", i4).param("obj_id", this.f52413e.getUserId()));
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String fromPageKey = UtilHelper.getFromPageKey(this.v);
            if (fromPageKey == null) {
                return 3;
            }
            if (fromPageKey.equals("a038")) {
                return 1;
            }
            if (fromPageKey.equals("a002")) {
                return 2;
            }
            if (fromPageKey.equals("a006")) {
                return 3;
            }
            if (fromPageKey.equals("a011")) {
                return 4;
            }
            if (fromPageKey.equals("a033")) {
                return 5;
            }
            return fromPageKey.equals("a010") ? 6 : 7;
        }
        return invokeV.intValue;
    }

    public void u(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var) == null) {
            this.y = b2Var;
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.x = i2;
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.w = str;
        }
    }
}
