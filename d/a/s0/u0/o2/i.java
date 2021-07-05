package d.a.s0.u0.o2;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.w0;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NEGFeedBackView f66668a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f66669b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f66670c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f66671d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f66672e;

    /* loaded from: classes9.dex */
    public class a implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(w0 w0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, w0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, w0 w0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, w0Var) == null) || arrayList == null || w0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append(arrayList.get(i2) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", w0Var.c()).param("tid", w0Var.e()).param("nid", w0Var.d()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", w0Var.k).param("weight", w0Var.j).param("ab_tag", w0Var.o).param("extra", w0Var.l).param("card_type", w0Var.n).param(TiebaStatic.Params.OBJ_FLOOR, w0Var.p));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(w0 w0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w0Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", w0Var.c()).param("tid", w0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66672e = new a(this);
        this.f66669b = tbPageContext;
        this.f66670c = viewGroup;
    }

    public void a(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) || b2Var == null || this.f66669b == null || this.f66670c == null) {
            return;
        }
        int i2 = 0;
        boolean z = (b2Var.H() == null || b2Var.H().getUserId() == null || !b2Var.H().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (b2Var.k2() && b2Var.P() != null && !z) {
            if (this.f66668a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.f66669b);
                this.f66668a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.f66671d);
                this.f66668a.setId(R.id.negative_feedback_view);
                this.f66668a.setDefaultReasonArray(new String[]{this.f66669b.getString(R.string.bad_quality), "", ""});
                this.f66668a.setEventCallback(this.f66672e);
                this.f66668a.l(this.f66670c, d.a.c.e.p.l.g(this.f66669b.getPageActivity(), R.dimen.tbds120), 0);
                this.f66668a.q();
            }
            if (this.f66668a.getVisibility() != 0) {
                this.f66668a.setVisibility(0);
            }
            w0 w0Var = new w0();
            w0Var.n(b2Var.n1());
            w0Var.k(b2Var.Q());
            w0Var.m(b2Var.A0());
            w0Var.j(b2Var.P());
            w0Var.f56085g = b2Var.h1;
            this.f66668a.setData(w0Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.f66668a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.f66668a.setVisibility(8);
            }
            i2 = d.a.c.e.p.l.g(this.f66669b.getPageActivity(), R.dimen.ds32);
        }
        if (this.f66670c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f66670c.getLayoutParams();
            layoutParams.rightMargin = i2;
            this.f66670c.setLayoutParams(layoutParams);
        }
        if (this.f66670c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f66670c.getLayoutParams();
            layoutParams2.rightMargin = i2;
            this.f66670c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.f66668a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.o();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NEGFeedBackView nEGFeedBackView = this.f66668a;
            return nEGFeedBackView != null && nEGFeedBackView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nEGFeedBackView = this.f66668a) == null) {
            return;
        }
        nEGFeedBackView.q();
    }

    public void d(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.f66671d = bdUniqueId;
        }
    }
}
