package d.a.s0.v.i.d;

import android.view.View;
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
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.w0;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NEGFeedBackView f68008a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f68009b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f68010c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f68011d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f68012e;

    /* renamed from: d.a.s0.v.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1818a implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1818a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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
            if ("ala_frs_demo_hell_live_feed_back_type".equals(w0Var.h())) {
                TiebaStatic.log(new StatisticItem("c12803").param("tid", w0Var.e()));
            } else if ("ala_frs_stage_live_feed_back_type".equals(w0Var.h())) {
                TiebaStatic.log(new StatisticItem("c12807").param("tid", w0Var.e()));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(w0 w0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w0Var) == null) || w0Var == null) {
                return;
            }
            if ("ala_frs_demo_hell_live_feed_back_type".equals(w0Var.h())) {
                TiebaStatic.log(new StatisticItem("c12802").param("tid", w0Var.e()));
            } else if ("ala_frs_stage_live_feed_back_type".equals(w0Var.h())) {
                TiebaStatic.log(new StatisticItem("c12806").param("tid", w0Var.e()));
            }
        }
    }

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
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
        this.f68012e = new C1818a(this);
        this.f68009b = tbPageContext;
        this.f68010c = viewGroup;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68008a : (View) invokeV.objValue;
    }

    public void b(b2 b2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var, str) == null) || b2Var == null || b2Var.g1() == null || this.f68009b == null || this.f68010c == null) {
            return;
        }
        int i2 = 0;
        boolean z = (b2Var.H() == null || b2Var.H().getUserId() == null || !b2Var.H().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (TbadkCoreApplication.isLogin() && b2Var.g1().dislikeInfo != null && !z && b2Var.g1().dislikeInfo.size() > 0) {
            if (this.f68008a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.f68009b);
                this.f68008a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.f68011d);
                this.f68008a.setId(R.id.negative_feedback_view);
                this.f68008a.setDefaultReasonArray(new String[]{this.f68009b.getString(R.string.bad_quality), "", ""});
                this.f68008a.setEventCallback(this.f68012e);
                this.f68008a.n(this.f68010c, l.g(this.f68009b.getPageActivity(), R.dimen.tbds120), l.g(this.f68009b.getPageActivity(), R.dimen.tbds20));
                this.f68008a.q();
            }
            if (this.f68008a.getVisibility() != 0) {
                this.f68008a.setVisibility(0);
            }
            w0 w0Var = new w0();
            w0Var.n(b2Var.n1());
            w0Var.k(b2Var.Q());
            w0Var.m(b2Var.A0());
            w0Var.q(str);
            w0Var.j(b2Var.g1().dislikeInfo);
            this.f68008a.setData(w0Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.f68008a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.f68008a.setVisibility(8);
            }
            i2 = l.g(this.f68009b.getPageActivity(), R.dimen.ds32);
        }
        if (this.f68010c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f68010c.getLayoutParams();
            layoutParams.rightMargin = i2;
            this.f68010c.setLayoutParams(layoutParams);
        }
        if (this.f68010c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f68010c.getLayoutParams();
            layoutParams2.rightMargin = i2;
            this.f68010c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.f68008a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.o();
        }
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nEGFeedBackView = this.f68008a) == null) {
            return;
        }
        nEGFeedBackView.q();
    }

    public void d(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.f68011d = bdUniqueId;
        }
    }
}
