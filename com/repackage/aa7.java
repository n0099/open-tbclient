package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.EmotionImageUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.AtMessageActivity;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.da7;
import java.util.List;
/* loaded from: classes5.dex */
public class aa7 extends z8<AtMessageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d75<FeedData, v65, x97> a;
    public BdListView b;
    public View c;
    public AtMessageActivity d;
    public du4 e;
    public f75 f;
    public View g;
    public NavigationBar h;
    public NoNetworkView i;
    public List<FeedData> j;

    /* loaded from: classes5.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        public a(aa7 aa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.l(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        public b(aa7 aa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void n(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.a.d.loadMoreData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements da7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedData a;
        public final /* synthetic */ aa7 b;

        public c(aa7 aa7Var, FeedData feedData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var, feedData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aa7Var;
            this.a = feedData;
        }

        @Override // com.repackage.da7.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.b.j)) {
                return;
            }
            this.b.j.remove(this.a);
            if (this.b.a != null) {
                this.b.a.k(this.b.j);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa7 a;

        public d(aa7 aa7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.F();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa7(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atMessageActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = atMessageActivity;
    }

    public void h(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        ca7 ca7Var = new ca7();
        ca7Var.a = 2;
        ca7Var.b = mg.g(feedData.getThread_id(), 0L);
        ca7Var.c = mg.g(feedData.getPost_id(), 0L);
        ca7Var.d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        da7 da7Var = new da7(getPageContext());
        da7Var.g(ca7Var);
        da7Var.h(new c(this, feedData));
        da7Var.i();
    }

    public void i() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.b) == null) {
            return;
        }
        bdListView.A(0L);
    }

    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            d75<FeedData, v65, x97> d75Var = this.a;
            if (d75Var != null) {
                d75Var.onChangeSkinType(tbPageContext, i);
            }
            f75 f75Var = this.f;
            if (f75Var != null) {
                f75Var.onChangeSkinType(tbPageContext, i);
            }
            du4 du4Var = this.e;
            if (du4Var != null) {
                du4Var.H(i);
            }
            this.h.onChangeSkinType(tbPageContext, i);
            vr4.d(this.b).f(R.color.CAM_X0201);
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.d.getActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0127, (ViewGroup) null);
            this.c = inflate;
            this.d.setContentView(inflate);
            this.b = (BdListView) this.c.findViewById(R.id.obfuscated_res_0x7f0902c2);
            NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f0923ac);
            this.h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.h.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f029a));
            this.h.showBottomLine();
            du4 du4Var = new du4(this.d.getPageContext());
            this.e = du4Var;
            du4Var.a0(this.d.getUniqueId());
            this.e.f(this.d);
            f75 f75Var = new f75(this.d);
            this.f = f75Var;
            f75Var.a();
            this.g = new TextView(this.d.getPageContext().getPageActivity());
            this.g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + oi.f(this.d.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070309)));
            BdListViewHelper.c(this.g, BdListViewHelper.HeadType.DEFAULT, mi.z());
            this.b.setPullRefresh(this.e);
            this.b.x(this.g, 0);
            this.b.setNextPage(this.f);
            this.b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.c.findViewById(R.id.obfuscated_res_0x7f09159a);
            this.i = noNetworkView;
            noNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.i.a(new a(this));
            this.b.setExOnSrollToBottomListener(new b(this));
            d75<FeedData, v65, x97> d75Var = new d75<>(this.d.getPageContext(), x97.class, R.layout.obfuscated_res_0x7f0d054d, this.d.getEventCenter());
            this.a = d75Var;
            d75Var.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.d)), NoDataViewFactory.e.d(null, this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0ab6)), null, null);
            this.b.setAdapter((ListAdapter) this.a);
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void l(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.g, BdListViewHelper.HeadType.DEFAULT, mi.z());
            if (z && (bdListView = this.b) != null && bdListView.getWrappedAdapter() != null && this.b.getWrappedAdapter().getCount() <= 0) {
                pg.a().post(new d(this));
            }
        }
    }

    public void m(i65 i65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, i65Var) == null) && (i65Var instanceof ea7)) {
            ea7 ea7Var = (ea7) i65Var;
            this.j = ea7Var.a();
            d75<FeedData, v65, x97> d75Var = this.a;
            if (d75Var != null) {
                d75Var.k(ea7Var.a());
            }
        }
    }

    public void n(v65 v65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, v65Var) == null) && (v65Var instanceof u65)) {
            u65 u65Var = (u65) v65Var;
            if (this.f != null) {
                if (u65Var.d()) {
                    this.f.d();
                    if (u65Var.b()) {
                        this.f.f(R.string.obfuscated_res_0x7f0f0a2e);
                    } else if (u65Var.a()) {
                        this.f.f(R.string.obfuscated_res_0x7f0f0a2e);
                    } else {
                        this.f.g(R.string.obfuscated_res_0x7f0f0c48);
                    }
                } else {
                    this.f.e();
                }
            }
            if (u65Var.c()) {
                o();
            } else {
                i();
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            du4 du4Var = this.e;
            if (du4Var != null) {
                du4Var.f(null);
            }
            BdListView bdListView = this.b;
            if (bdListView != null) {
                bdListView.F();
            }
            du4 du4Var2 = this.e;
            if (du4Var2 != null) {
                du4Var2.f(this.d);
            }
        }
    }
}
