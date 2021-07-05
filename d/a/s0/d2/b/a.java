package d.a.s0.d2.b;

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
import d.a.r0.b.d;
import d.a.s0.d2.c.c;
import d.a.s0.d2.e.b;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f58156e;

    /* renamed from: f  reason: collision with root package name */
    public final b f58157f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f58158g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f58159h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f58160i;
    public final TBSpecificationBtn j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m;
    public BdListView.p n;

    /* renamed from: d.a.s0.d2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1364a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58161e;

        public C1364a(a aVar) {
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
            this.f58161e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f58161e.f58157f.k()) {
                this.f58161e.f58157f.j();
                this.f58161e.j();
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
        this.n = new C1364a(this);
        this.f58156e = interestedForumFragment;
        this.f58158g = bdRecyclerView;
        this.f58157f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.j = tBSpecificationBtn2;
        f();
        h();
    }

    @Override // d.a.s0.d2.e.b.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.m) {
                this.m = true;
            } else if (d.l()) {
                this.f58156e.getActivity().setResult(-1);
                this.f58156e.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // d.a.s0.d2.e.b.d
    public void b(c cVar) {
        List<d.a.s0.d2.c.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (list = cVar.f58170a) != null && !ListUtils.isEmpty(list)) {
                if (this.f58158g.getVisibility() == 8) {
                    this.f58158g.setVisibility(0);
                }
                this.f58159h.n(cVar.f58170a);
                this.f58156e.K0();
            }
            if (this.f58157f.k()) {
                return;
            }
            k();
        }
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 > 0 && !this.k.isEnabled()) {
                this.k.setEnabled(true);
                this.k.setText(this.f58158g.getResources().getString(R.string.start_the_trip));
            } else if (i2 == 0) {
                this.k.setEnabled(false);
                this.k.setText(this.f58158g.getResources().getString(R.string.try_to_select));
            }
            d.a.r0.r.f0.m.b bVar = new d.a.r0.r.f0.m.b();
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

    public void e(List<d.a.s0.d2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f58157f.o(list);
            this.f58157f.j();
            this.f58157f.e();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f58159h = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.f58158g;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.f58158g.setAdapter(this.f58159h);
            PbListView pbListView = new PbListView(this.f58158g.getContext());
            this.f58160i = pbListView;
            pbListView.a();
            this.f58160i.o(R.color.CAM_X0205);
            this.f58160i.v();
            this.f58160i.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f58160i.E(R.dimen.tbfontsize33);
            this.f58160i.y(R.color.CAM_X0110);
            this.f58158g.setNextPage(this.f58160i);
            j();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f58158g.setOnSrollToBottomListener(this.n);
            this.f58157f.q(this);
            this.f58157f.p(this);
            this.f58159h.w(this);
            this.k.setOnClickListener(this);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f58159h.t();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f58160i.H();
            this.f58160i.O();
            this.f58160i.A(this.f58158g.getContext().getString(R.string.list_loading));
            this.f58160i.J(l.g(this.f58158g.getContext(), R.dimen.tbds217));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f58160i.B(this.f58158g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f58158g.getContext(), R.dimen.tbds178));
            this.f58160i.E(R.dimen.tbds36);
            this.f58160i.y(R.color.CAM_X0109);
            this.f58160i.f();
            this.f58160i.J(l.g(this.f58158g.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, view) == null) && view == this.k) {
            try {
                this.f58157f.f(this.f58159h.o());
                d.a.s0.d2.d.a.a(2, 1, this.f58156e.H0());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.s0.d2.e.b.d
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            this.f58156e.L0(str);
        }
    }
}
