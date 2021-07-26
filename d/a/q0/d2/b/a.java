package d.a.q0.d2.b;

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
import d.a.d.e.p.l;
import d.a.p0.b.d;
import d.a.q0.d2.c.c;
import d.a.q0.d2.e.b;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f55445e;

    /* renamed from: f  reason: collision with root package name */
    public final b f55446f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f55447g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f55448h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f55449i;
    public final TBSpecificationBtn j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public BdListView.p n;

    /* renamed from: d.a.q0.d2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1327a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f55450e;

        public C1327a(a aVar) {
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
            this.f55450e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f55450e.f55446f.k()) {
                this.f55450e.f55446f.j();
                this.f55450e.i();
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
        this.n = new C1327a(this);
        this.f55445e = interestedForumFragment;
        this.f55447g = bdRecyclerView;
        this.f55446f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.j = tBSpecificationBtn2;
        f();
        g();
    }

    @Override // d.a.q0.d2.e.b.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.m) {
                this.m = true;
            } else if (d.w()) {
                this.f55445e.getActivity().setResult(-1);
                this.f55445e.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // d.a.q0.d2.e.b.d
    public void b(c cVar) {
        List<d.a.q0.d2.c.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (list = cVar.f55459a) != null && !ListUtils.isEmpty(list)) {
                if (this.f55447g.getVisibility() == 8) {
                    this.f55447g.setVisibility(0);
                }
                this.f55448h.n(cVar.f55459a);
                this.f55445e.Q0();
            }
            if (this.f55446f.k()) {
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
                this.k.setText(this.f55447g.getResources().getString(R.string.start_the_trip));
            } else if (i2 == 0) {
                this.k.setEnabled(false);
                this.k.setText(this.f55447g.getResources().getString(R.string.try_to_select));
            }
            d.a.p0.s.f0.n.b bVar = new d.a.p0.s.f0.n.b();
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

    public void e(List<d.a.q0.d2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f55446f.o(list);
            this.f55446f.j();
            this.f55446f.e();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f55448h = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.f55447g;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.f55447g.setAdapter(this.f55448h);
            PbListView pbListView = new PbListView(this.f55447g.getContext());
            this.f55449i = pbListView;
            pbListView.a();
            this.f55449i.o(R.color.CAM_X0205);
            this.f55449i.v();
            this.f55449i.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f55449i.E(R.dimen.tbfontsize33);
            this.f55449i.y(R.color.CAM_X0110);
            this.f55447g.setNextPage(this.f55449i);
            i();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f55447g.setOnSrollToBottomListener(this.n);
            this.f55446f.q(this);
            this.f55446f.p(this);
            this.f55448h.w(this);
            this.k.setOnClickListener(this);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f55448h.t();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f55449i.H();
            this.f55449i.O();
            this.f55449i.A(this.f55447g.getContext().getString(R.string.list_loading));
            this.f55449i.J(l.g(this.f55447g.getContext(), R.dimen.tbds217));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f55449i.B(this.f55447g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f55447g.getContext(), R.dimen.tbds178));
            this.f55449i.E(R.dimen.tbds36);
            this.f55449i.y(R.color.CAM_X0109);
            this.f55449i.f();
            this.f55449i.J(l.g(this.f55447g.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, view) == null) && view == this.k) {
            try {
                this.f55446f.f(this.f55448h.o());
                d.a.q0.d2.d.a.a(2, 1, this.f55445e.N0());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.q0.d2.e.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            this.f55445e.R0(str);
        }
    }
}
