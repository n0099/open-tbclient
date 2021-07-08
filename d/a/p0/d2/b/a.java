package d.a.p0.d2.b;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.adapter.InterestedForumAdapter;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.o0.b.d;
import d.a.p0.d2.c.c;
import d.a.p0.d2.e.b;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f54901e;

    /* renamed from: f  reason: collision with root package name */
    public final b f54902f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f54903g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f54904h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f54905i;
    public final TBSpecificationBtn j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public BdListView.p n;

    /* renamed from: d.a.p0.d2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1318a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f54906e;

        public C1318a(a aVar) {
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
                    return;
                }
            }
            this.f54906e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f54906e.f54902f.k()) {
                this.f54906e.f54902f.j();
                this.f54906e.i();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interestedForumFragment, bdRecyclerView, tBSpecificationBtn, tBSpecificationBtn2, tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.n = new C1318a(this);
        this.f54901e = interestedForumFragment;
        this.f54903g = bdRecyclerView;
        this.f54902f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.j = tBSpecificationBtn2;
        f();
        g();
    }

    @Override // d.a.p0.d2.e.b.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.m) {
                this.m = true;
            } else if (d.v()) {
                this.f54901e.getActivity().setResult(-1);
                this.f54901e.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // d.a.p0.d2.e.b.d
    public void b(c cVar) {
        List<d.a.p0.d2.c.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (list = cVar.f54915a) != null && !ListUtils.isEmpty(list)) {
                if (this.f54903g.getVisibility() == 8) {
                    this.f54903g.setVisibility(0);
                }
                this.f54904h.n(cVar.f54915a);
                this.f54901e.L0();
            }
            if (this.f54902f.k()) {
                return;
            }
            j();
        }
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 > 0 && !this.k.isEnabled()) {
                this.k.setEnabled(true);
                this.k.setText(this.f54903g.getResources().getString(R.string.start_the_trip));
            } else if (i2 == 0) {
                this.k.setEnabled(false);
                this.k.setText(this.f54903g.getResources().getString(R.string.try_to_select));
            }
            d.a.o0.r.f0.n.b bVar = new d.a.o0.r.f0.n.b();
            if (!z) {
                this.j.setText(this.l.getString(R.string.select_all));
                this.j.setConfig(bVar);
                return;
            }
            this.j.setText(this.l.getString(R.string.unselect_all));
            bVar.r(R.color.CAM_X0109);
            this.j.setConfig(bVar);
        }
    }

    public void e(List<d.a.p0.d2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f54902f.o(list);
            this.f54902f.j();
            this.f54902f.e();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f54904h = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.f54903g;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.f54903g.setAdapter(this.f54904h);
            PbListView pbListView = new PbListView(this.f54903g.getContext());
            this.f54905i = pbListView;
            pbListView.a();
            this.f54905i.o(R.color.CAM_X0205);
            this.f54905i.v();
            this.f54905i.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f54905i.E(R.dimen.tbfontsize33);
            this.f54905i.y(R.color.CAM_X0110);
            this.f54903g.setNextPage(this.f54905i);
            i();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f54903g.setOnSrollToBottomListener(this.n);
            this.f54902f.q(this);
            this.f54902f.p(this);
            this.f54904h.w(this);
            this.k.setOnClickListener(this);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f54904h.t();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f54905i.H();
            this.f54905i.O();
            this.f54905i.A(this.f54903g.getContext().getString(R.string.list_loading));
            this.f54905i.J(l.g(this.f54903g.getContext(), R.dimen.tbds217));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f54905i.B(this.f54903g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f54903g.getContext(), R.dimen.tbds178));
            this.f54905i.E(R.dimen.tbds36);
            this.f54905i.y(R.color.CAM_X0109);
            this.f54905i.f();
            this.f54905i.J(l.g(this.f54903g.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, view) == null) && view == this.k) {
            try {
                this.f54902f.f(this.f54904h.o());
                d.a.p0.d2.d.a.a(2, 1, this.f54901e.I0());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.p0.d2.e.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            this.f54901e.M0(str);
        }
    }
}
