package d.a.q0.v.i.d;

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
import d.a.d.e.p.l;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.w0;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NEGFeedBackView f65435a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f65436b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f65437c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f65438d;

    /* renamed from: e  reason: collision with root package name */
    public NEGFeedBackView.b f65439e;

    /* renamed from: d.a.q0.v.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1779a implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1779a(a aVar) {
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
        this.f65439e = new C1779a(this);
        this.f65436b = tbPageContext;
        this.f65437c = viewGroup;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65435a : (View) invokeV.objValue;
    }

    public void b(b2 b2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var, str) == null) || b2Var == null || b2Var.h1() == null || this.f65436b == null || this.f65437c == null) {
            return;
        }
        int i2 = 0;
        boolean z = (b2Var.H() == null || b2Var.H().getUserId() == null || !b2Var.H().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (TbadkCoreApplication.isLogin() && b2Var.h1().dislikeInfo != null && !z && b2Var.h1().dislikeInfo.size() > 0) {
            if (this.f65435a == null) {
                NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.f65436b);
                this.f65435a = nEGFeedBackView;
                nEGFeedBackView.setUniqueId(this.f65438d);
                this.f65435a.setId(R.id.negative_feedback_view);
                this.f65435a.setDefaultReasonArray(new String[]{this.f65436b.getString(R.string.bad_quality), "", ""});
                this.f65435a.setEventCallback(this.f65439e);
                this.f65435a.n(this.f65437c, l.g(this.f65436b.getPageActivity(), R.dimen.tbds120), l.g(this.f65436b.getPageActivity(), R.dimen.tbds20));
                this.f65435a.q();
            }
            if (this.f65435a.getVisibility() != 0) {
                this.f65435a.setVisibility(0);
            }
            w0 w0Var = new w0();
            w0Var.n(b2Var.o1());
            w0Var.k(b2Var.R());
            w0Var.m(b2Var.B0());
            w0Var.q(str);
            w0Var.j(b2Var.h1().dislikeInfo);
            this.f65435a.setData(w0Var);
        } else {
            NEGFeedBackView nEGFeedBackView2 = this.f65435a;
            if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                this.f65435a.setVisibility(8);
            }
            i2 = l.g(this.f65436b.getPageActivity(), R.dimen.ds32);
        }
        if (this.f65437c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65437c.getLayoutParams();
            layoutParams.rightMargin = i2;
            this.f65437c.setLayoutParams(layoutParams);
        }
        if (this.f65437c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f65437c.getLayoutParams();
            layoutParams2.rightMargin = i2;
            this.f65437c.setLayoutParams(layoutParams2);
        }
        NEGFeedBackView nEGFeedBackView3 = this.f65435a;
        if (nEGFeedBackView3 != null) {
            nEGFeedBackView3.o();
        }
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (nEGFeedBackView = this.f65435a) == null) {
            return;
        }
        nEGFeedBackView.q();
    }

    public void d(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.f65438d = bdUniqueId;
        }
    }
}
