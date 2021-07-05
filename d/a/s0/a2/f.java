package d.a.s0.a2;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.myCollection.ThreadFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.f0.g;
import d.a.r0.r.s.a;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f57222a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarShadowView f57223b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f57224c;

    /* renamed from: d  reason: collision with root package name */
    public View f57225d;

    /* renamed from: e  reason: collision with root package name */
    public g f57226e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f57227f;

    /* renamed from: g  reason: collision with root package name */
    public e f57228g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f57229h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f57230i;
    public d.a.r0.r.s.a j;
    public a.e k;
    public c l;
    public boolean m;
    public AbsListView.OnScrollListener n;

    /* loaded from: classes9.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f57231e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57231e = fVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (this.f57231e.f57223b == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.f57231e.f57223b.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            NavigationBarShadowView navigationBarShadowView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && (navigationBarShadowView = this.f57231e.f57223b) != null && i2 == 1) {
                navigationBarShadowView.c();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d.a.s0.a2.g.a f57232e;

        public c(d.a.s0.a2.g.a aVar) {
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
            this.f57232e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.s0.a2.g.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f57232e) == null) {
                return;
            }
            aVar.w(Boolean.TRUE);
        }
    }

    public f(ThreadFragment threadFragment, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadFragment, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57222a = null;
        this.f57224c = null;
        this.f57225d = null;
        this.f57227f = null;
        this.f57228g = null;
        this.f57229h = null;
        this.f57230i = null;
        this.j = null;
        this.k = null;
        this.m = false;
        this.n = new a(this);
        this.f57222a = threadFragment.getBaseFragmentActivity();
        this.f57223b = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.f57230i = (ProgressBar) view.findViewById(R.id.progress);
        this.f57229h = (RelativeLayout) view.findViewById(R.id.parent);
        this.f57227f = NoDataViewFactory.a(this.f57222a.getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.COLLECTION, l.g(this.f57222a.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.e.b(R.string.mark_nodata, R.string.mark_nodata_2), null);
        e eVar = new e(threadFragment.getPageContext());
        this.f57228g = eVar;
        eVar.notifyDataSetChanged();
        this.f57226e = new g(threadFragment.getPageContext());
        BdListView bdListView = (BdListView) view.findViewById(R.id.list);
        this.f57224c = bdListView;
        bdListView.setPullRefresh(this.f57226e);
        this.f57226e.a(threadFragment);
        this.f57225d = new TextView(this.f57222a.getActivity());
        this.f57225d.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f57222a.getActivity(), R.dimen.ds88)));
        this.f57224c.x(this.f57225d, 0);
        this.f57224c.setAdapter((ListAdapter) this.f57228g);
        this.f57224c.setOnSrollToBottomListener(threadFragment);
        this.f57224c.setOnItemClickListener(threadFragment);
        this.f57224c.setOnScrollListener(this.n);
        this.f57228g.k(threadFragment);
        this.f57228g.r(threadFragment);
        this.f57228g.q(threadFragment);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f57228g.l(z);
            this.f57228g.notifyDataSetChanged();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            BdListViewHelper.c(this.f57225d, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdListView = this.f57224c) == null) {
            return;
        }
        bdListView.A(0L);
    }

    public void d(boolean z, String str, d.a.s0.a2.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, aVar}) == null) {
            if (z) {
                BaseFragmentActivity baseFragmentActivity = this.f57222a;
                baseFragmentActivity.showToast(baseFragmentActivity.getPageContext().getString(R.string.delete_success));
                if (aVar != null && aVar.n() != null) {
                    this.f57228g.j(aVar.n());
                    if (aVar.n().size() == 0) {
                        if (this.l == null) {
                            this.l = new c(aVar);
                        } else {
                            d.a.c.e.m.e.a().removeCallbacks(this.l);
                        }
                        d.a.c.e.m.e.a().postDelayed(this.l, 600L);
                    }
                } else {
                    this.f57230i.setVisibility(8);
                    return;
                }
            } else {
                this.f57222a.showToast(str);
            }
            this.f57228g.m(false);
            this.f57230i.setVisibility(8);
        }
    }

    public void e(String str, d.a.s0.a2.g.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, str, aVar, z) == null) {
            this.f57228g.p(true);
            if (str != null) {
                this.f57222a.showToast(str);
            }
            if (aVar != null) {
                if (aVar.p() == 0 && !z) {
                    aVar.m();
                }
                if (aVar.p() < 20) {
                    this.f57228g.n(false);
                    this.f57228g.m(true);
                } else {
                    this.f57228g.n(true);
                    this.f57228g.m(true);
                }
                this.f57228g.j(aVar.n());
                p(aVar, z);
            }
            this.f57228g.p(false);
            this.f57228g.notifyDataSetChanged();
            if (k()) {
                r(false);
            }
        }
    }

    public void f(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.f57222a.closeLoadingDialog();
            if (str != null) {
                this.f57222a.showToast(str);
            }
            if (z2) {
                t();
            }
            this.f57228g.notifyDataSetChanged();
        }
    }

    public int g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            if (z) {
                return R.id.share_lv_markitem_delete;
            }
            return R.id.home_lv_markitem_delete;
        }
        return invokeZ.intValue;
    }

    public int h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            if (z) {
                return R.id.share_mark_item_state;
            }
            return R.id.markitem_state;
        }
        return invokeZ.intValue;
    }

    public int i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            if (z) {
                return R.id.share_lv_markitem_userinfo;
            }
            return R.id.home_lv_markitem_userinfo;
        }
        return invokeZ.intValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f57230i.setVisibility(8);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void l(MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, markData) == null) || markData == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f57222a.getPageContext().getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(markData.getUesrId(), 0L), false, markData.isGod())));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f57228g.notifyDataSetChanged();
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f57229h, R.color.CAM_X0201);
            g gVar = this.f57226e;
            if (gVar != null) {
                gVar.I(i2);
            }
            m();
            NoDataView noDataView = this.f57227f;
            if (noDataView != null) {
                noDataView.f(this.f57222a.getPageContext(), i2);
                SkinManager.setBackgroundColor(this.f57227f, R.color.CAM_X0201);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            d.a.r0.r.s.a aVar = this.j;
            if (aVar != null) {
                aVar.dismiss();
                this.j = null;
            }
            ProgressBar progressBar = this.f57230i;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (this.l != null) {
                d.a.c.e.m.e.a().removeCallbacks(this.l);
            }
            e eVar = this.f57228g;
            if (eVar != null) {
                eVar.i();
            }
        }
    }

    public void p(d.a.s0.a2.g.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, aVar, z) == null) {
            if (aVar == null) {
                s();
            } else if (aVar.m() > 0) {
                this.f57227f.setVisibility(8);
                this.f57224c.removeHeaderView(this.f57227f);
                this.f57228g.notifyDataSetChanged();
            } else if (aVar.m() != 0 || z) {
            } else {
                s();
            }
        }
    }

    public void q(a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.m = z;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f57227f.d(this.f57222a.getPageContext());
            this.f57224c.removeHeaderView(this.f57227f);
            this.f57224c.addHeaderView(this.f57227f);
            this.f57227f.setVisibility(0);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.j == null) {
                d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f57222a.getPageContext().getPageActivity());
                this.j = aVar;
                aVar.setTitle(this.f57222a.getPageContext().getString(R.string.sync_mark_fail));
                this.j.setMessage(this.f57222a.getPageContext().getString(R.string.neterror));
                if (this.k != null) {
                    this.j.setPositiveButton(this.f57222a.getPageContext().getString(R.string.retry_rightnow), this.k);
                }
                this.j.setNegativeButton(this.f57222a.getPageContext().getString(R.string.confirm), new b(this));
                this.j.create(this.f57222a.getPageContext());
                this.j.setCanceledOnTouchOutside(true);
            }
            this.j.show();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f57230i.setVisibility(0);
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (i2 == 0) {
                this.f57224c.F();
                return;
            }
            this.f57228g.p(true);
            this.f57228g.notifyDataSetChanged();
        }
    }

    public void w(ArrayList<MarkData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, arrayList) == null) {
            this.f57228g.j(arrayList);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.f57227f.isShown()) {
            this.f57227f.d(this.f57222a.getPageContext());
        }
    }
}
