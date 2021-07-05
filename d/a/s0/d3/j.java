package d.a.s0.d3;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignAllForumActivity;
import com.baidu.tieba.signall.SignAllForumProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.f0.f;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class j extends d.a.c.a.d<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static int o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SignAllForumActivity f58243a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f58244b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f58245c;

    /* renamed from: d  reason: collision with root package name */
    public SignAllForumProgressView f58246d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f58247e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f58248f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.r0.r.f0.g f58249g;

    /* renamed from: h  reason: collision with root package name */
    public g f58250h;

    /* renamed from: i  reason: collision with root package name */
    public c f58251i;
    public RelativeLayout j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public TextView n;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f58252e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58252e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58252e.f58243a.finish();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signAllForumActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58249g = null;
        this.f58243a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.signallforum_view);
        this.f58245c = (RelativeLayout) this.f58243a.findViewById(R.id.sign_all_forum_parent);
        NavigationBar navigationBar = (NavigationBar) this.f58243a.findViewById(R.id.view_navigation_bar);
        this.f58244b = navigationBar;
        navigationBar.setCenterTextTitle(this.f58243a.getPageContext().getString(R.string.signallforum));
        this.f58244b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.f58244b.showBottomLine();
        BdListView bdListView = (BdListView) this.f58243a.findViewById(R.id.signallforum_list);
        this.f58248f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        d.a.r0.r.f0.g gVar = new d.a.r0.r.f0.g(signAllForumActivity.getPageContext());
        this.f58249g = gVar;
        this.f58248f.setPullRefresh(gVar);
        TextView textView = (TextView) LayoutInflater.from(this.f58243a.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.n = textView;
        this.f58248f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.f58243a.getPageContext().getPageActivity());
        this.f58246d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.f58247e = progressBar;
        progressBar.setOnClickListener(this.f58243a);
        this.f58248f.addHeaderView(this.f58246d);
        this.f58246d.setVisibility(8);
        this.j = (RelativeLayout) this.f58246d.findViewById(R.id.guidecontainer);
        this.m = (LinearLayout) this.f58246d.findViewById(R.id.guideopenbtn);
        this.k = (TextView) this.f58246d.findViewById(R.id.guidetip);
        this.l = (TextView) this.f58246d.findViewById(R.id.guideopen);
        this.m.setOnClickListener(this.f58243a);
        g gVar2 = new g(this.f58243a, null);
        this.f58250h = gVar2;
        this.f58248f.setAdapter((ListAdapter) gVar2);
        this.f58248f.setOnScrollListener(this.f58250h);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f58248f.A(0L);
        }
    }

    public final void f() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f58251i) == null) {
            return;
        }
        this.f58246d.setHasPrivilege(cVar.B());
        this.f58246d.setmCurrentStatus(this.f58251i.q());
        TextView message1 = this.f58246d.getMessage1();
        SpannableString spannableString = new SpannableString(this.f58251i.v() + this.f58251i.t() + this.f58251i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.f58251i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.f58251i.t().length() + length, 33);
        message1.setText(spannableString);
        this.f58246d.getMessage2().setText(this.f58251i.w());
        this.k.setText(this.f58251i.h());
        if (TextUtils.isEmpty(this.f58251i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.f58251i.g());
        }
        this.f58246d.setVisibility(0);
        if (!this.f58251i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public g h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58250h : (g) invokeV.objValue;
    }

    public c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f58251i : (c) invokeV.objValue;
    }

    public LinearLayout k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (LinearLayout) invokeV.objValue;
    }

    public BdListView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58248f : (BdListView) invokeV.objValue;
    }

    public ProgressBar m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f58247e : (ProgressBar) invokeV.objValue;
    }

    public SignAllForumProgressView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f58246d : (SignAllForumProgressView) invokeV.objValue;
    }

    public RelativeLayout o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f58245c : (RelativeLayout) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f58243a.getLayoutMode().k(i2 == 1);
            this.f58243a.getLayoutMode().j(this.f58245c);
            this.f58243a.getLayoutMode().j(this.n);
            this.f58243a.getLayoutMode().j(this.f58246d);
            SkinManager.setBackgroundColor(this.f58245c, R.color.CAM_X0201);
            this.f58244b.onChangeSkinType(getPageContext(), i2);
            SignAllForumProgressView signAllForumProgressView = this.f58246d;
            if (signAllForumProgressView != null) {
                signAllForumProgressView.k();
            }
            this.f58249g.I(i2);
            this.f58250h.notifyDataSetChanged();
        }
    }

    public void p(c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, cVar, z) == null) || cVar == null) {
            return;
        }
        this.f58251i = cVar;
        f();
        ArrayList<d> k = cVar.k();
        this.f58250h.h(this.f58251i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(cVar.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.f58251i.y();
        if (!StringUtils.isNull(y)) {
            this.f58246d.l(this.f58243a, y, this.f58251i.z());
            return;
        }
        this.f58246d.i();
    }

    public void q(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.f58249g.a(gVar);
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f58248f.setSelection(i2);
        }
    }

    public void s(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onItemClickListener) == null) {
            this.f58248f.setOnItemClickListener(onItemClickListener);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f58248f.F();
        }
    }
}
