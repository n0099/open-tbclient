package d.a.q0.d3;

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
import d.a.p0.s.f0.f;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class j extends d.a.d.a.d<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static int o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SignAllForumActivity f55532a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f55533b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f55534c;

    /* renamed from: d  reason: collision with root package name */
    public SignAllForumProgressView f55535d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f55536e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f55537f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.s.f0.g f55538g;

    /* renamed from: h  reason: collision with root package name */
    public g f55539h;

    /* renamed from: i  reason: collision with root package name */
    public c f55540i;
    public RelativeLayout j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public TextView n;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f55541e;

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
            this.f55541e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55541e.f55532a.finish();
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
                super((d.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55538g = null;
        this.f55532a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.signallforum_view);
        this.f55534c = (RelativeLayout) this.f55532a.findViewById(R.id.sign_all_forum_parent);
        NavigationBar navigationBar = (NavigationBar) this.f55532a.findViewById(R.id.view_navigation_bar);
        this.f55533b = navigationBar;
        navigationBar.setCenterTextTitle(this.f55532a.getPageContext().getString(R.string.signallforum));
        this.f55533b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.f55533b.showBottomLine();
        BdListView bdListView = (BdListView) this.f55532a.findViewById(R.id.signallforum_list);
        this.f55537f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        d.a.p0.s.f0.g gVar = new d.a.p0.s.f0.g(signAllForumActivity.getPageContext());
        this.f55538g = gVar;
        this.f55537f.setPullRefresh(gVar);
        TextView textView = (TextView) LayoutInflater.from(this.f55532a.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.n = textView;
        this.f55537f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.f55532a.getPageContext().getPageActivity());
        this.f55535d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.f55536e = progressBar;
        progressBar.setOnClickListener(this.f55532a);
        this.f55537f.addHeaderView(this.f55535d);
        this.f55535d.setVisibility(8);
        this.j = (RelativeLayout) this.f55535d.findViewById(R.id.guidecontainer);
        this.m = (LinearLayout) this.f55535d.findViewById(R.id.guideopenbtn);
        this.k = (TextView) this.f55535d.findViewById(R.id.guidetip);
        this.l = (TextView) this.f55535d.findViewById(R.id.guideopen);
        this.m.setOnClickListener(this.f55532a);
        g gVar2 = new g(this.f55532a, null);
        this.f55539h = gVar2;
        this.f55537f.setAdapter((ListAdapter) gVar2);
        this.f55537f.setOnScrollListener(this.f55539h);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f55537f.A(0L);
        }
    }

    public final void f() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f55540i) == null) {
            return;
        }
        this.f55535d.setHasPrivilege(cVar.B());
        this.f55535d.setmCurrentStatus(this.f55540i.q());
        TextView message1 = this.f55535d.getMessage1();
        SpannableString spannableString = new SpannableString(this.f55540i.v() + this.f55540i.t() + this.f55540i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.f55540i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.f55540i.t().length() + length, 33);
        message1.setText(spannableString);
        this.f55535d.getMessage2().setText(this.f55540i.w());
        this.k.setText(this.f55540i.h());
        if (TextUtils.isEmpty(this.f55540i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.f55540i.g());
        }
        this.f55535d.setVisibility(0);
        if (!this.f55540i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public g g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f55539h : (g) invokeV.objValue;
    }

    public c h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55540i : (c) invokeV.objValue;
    }

    public LinearLayout j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (LinearLayout) invokeV.objValue;
    }

    public BdListView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f55537f : (BdListView) invokeV.objValue;
    }

    public ProgressBar l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f55536e : (ProgressBar) invokeV.objValue;
    }

    public SignAllForumProgressView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f55535d : (SignAllForumProgressView) invokeV.objValue;
    }

    public RelativeLayout n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f55534c : (RelativeLayout) invokeV.objValue;
    }

    public void o(c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, cVar, z) == null) || cVar == null) {
            return;
        }
        this.f55540i = cVar;
        f();
        ArrayList<d> k = cVar.k();
        this.f55539h.h(this.f55540i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(cVar.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.f55540i.y();
        if (!StringUtils.isNull(y)) {
            this.f55535d.l(this.f55532a, y, this.f55540i.z());
            return;
        }
        this.f55535d.i();
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f55532a.getLayoutMode().k(i2 == 1);
            this.f55532a.getLayoutMode().j(this.f55534c);
            this.f55532a.getLayoutMode().j(this.n);
            this.f55532a.getLayoutMode().j(this.f55535d);
            SkinManager.setBackgroundColor(this.f55534c, R.color.CAM_X0201);
            this.f55533b.onChangeSkinType(getPageContext(), i2);
            SignAllForumProgressView signAllForumProgressView = this.f55535d;
            if (signAllForumProgressView != null) {
                signAllForumProgressView.k();
            }
            this.f55538g.I(i2);
            this.f55539h.notifyDataSetChanged();
        }
    }

    public void p(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.f55538g.a(gVar);
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f55537f.setSelection(i2);
        }
    }

    public void r(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onItemClickListener) == null) {
            this.f55537f.setOnItemClickListener(onItemClickListener);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f55537f.F();
        }
    }
}
