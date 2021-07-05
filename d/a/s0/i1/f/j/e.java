package d.a.s0.i1.f.j;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipListAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends d.a.c.a.d<OfficialBarTipActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f61568a;

    /* renamed from: b  reason: collision with root package name */
    public OfficialBarTipListAdapter f61569b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61570c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f61571d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f61572e;

    /* renamed from: f  reason: collision with root package name */
    public OfficialBarTipActivity f61573f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f61574g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61575h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f61576i;
    public TextView j;
    public boolean k;
    public TextView l;
    public View m;
    public TextView n;
    public TextView o;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f61577e;

        public a(e eVar, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61577e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f61577e.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f61578e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f61579f;

        public b(e eVar, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61579f = eVar;
            this.f61578e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f61579f.f61575h) {
                    if (this.f61579f.f61573f.hasNoRead()) {
                        this.f61579f.n.setVisibility(0);
                    }
                    this.f61579f.p(this.f61578e, true);
                    return;
                }
                this.f61579f.p(this.f61578e, false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f61580e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f61581f;

        public c(e eVar, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61581f = eVar;
            this.f61580e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f61580e.deleteSelectedDatas();
                this.f61581f.p(this.f61580e, false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f61582e;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61582e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f61582e.k) {
                    this.f61582e.r(true);
                } else {
                    this.f61582e.r(false);
                }
            }
        }
    }

    /* renamed from: d.a.s0.i1.f.j.e$e  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1503e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialBarTipActivity f61583e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f61584f;

        public View$OnClickListenerC1503e(e eVar, OfficialBarTipActivity officialBarTipActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, officialBarTipActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61584f = eVar;
            this.f61583e = officialBarTipActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f61584f.f61573f.setAllRead();
                this.f61584f.p(this.f61583e, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {officialBarTipActivity};
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
        this.f61575h = false;
        this.f61576i = null;
        this.k = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.f61573f = officialBarTipActivity;
        m(officialBarTipActivity);
        n(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    public OfficialBarTipListAdapter i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61569b : (OfficialBarTipListAdapter) invokeV.objValue;
    }

    public BdListView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61568a : (BdListView) invokeV.objValue;
    }

    public final void l(OfficialBarTipActivity officialBarTipActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, officialBarTipActivity) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
            this.f61576i = relativeLayout;
            TextView textView = (TextView) relativeLayout.findViewById(R.id.delete_txt);
            this.l = textView;
            textView.setOnClickListener(new c(this, officialBarTipActivity));
            this.j = (TextView) this.f61576i.findViewById(R.id.select_all_txt);
            int g2 = l.g(this.f61573f.getPageContext().getPageActivity(), R.dimen.ds40);
            Drawable drawable = SkinManager.getDrawable(R.drawable.btn_bgb_choice_n);
            drawable.setBounds(0, 0, g2, g2);
            this.j.setText(this.f61573f.getPageContext().getString(R.string.select_all));
            this.j.setCompoundDrawables(drawable, null, null, null);
            this.j.setOnClickListener(new d(this));
        }
    }

    public final void m(OfficialBarTipActivity officialBarTipActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, officialBarTipActivity) == null) {
            NavigationBar navigationBar = (NavigationBar) officialBarTipActivity.findViewById(R.id.view_navigation_bar);
            this.f61570c = navigationBar;
            navigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(R.string.subscribe_forum_list));
            this.f61570c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this, officialBarTipActivity));
            this.f61570c.showBottomLine();
            ViewGroup viewGroup = (ViewGroup) officialBarTipActivity.findViewById(R.id.root_view);
            this.f61574g = viewGroup;
            this.f61572e = (NoNetworkView) viewGroup.findViewById(R.id.no_network_view);
            View inflate = LayoutInflater.from(this.f61573f.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
            this.m = inflate;
            inflate.setVisibility(8);
            TextView textView = (TextView) this.m.findViewById(R.id.all_read);
            this.n = textView;
            textView.setVisibility(8);
            TextView textView2 = (TextView) this.m.findViewById(R.id.edit);
            this.o = textView2;
            textView2.setVisibility(0);
            this.m = this.f61570c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.m, (View.OnClickListener) null);
            this.o.setOnClickListener(new b(this, officialBarTipActivity));
        }
    }

    public final void n(OfficialBarTipActivity officialBarTipActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, officialBarTipActivity) == null) {
            this.f61568a = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
            OfficialBarTipListAdapter officialBarTipListAdapter = new OfficialBarTipListAdapter(officialBarTipActivity);
            this.f61569b = officialBarTipListAdapter;
            this.f61568a.setAdapter((ListAdapter) officialBarTipListAdapter);
            this.f61571d = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.f61574g, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.a(R.string.official_message_activity_no_data), null);
        }
    }

    public void o(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f61569b.n(list);
            if (list == null || list.size() > 0) {
                return;
            }
            this.o.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f61573f.getLayoutMode().k(i2 == 1);
            this.f61573f.getLayoutMode().j(this.f61574g);
            this.f61570c.onChangeSkinType(this.f61573f.getPageContext(), i2);
            SkinManager.setNavbarTitleColor(this.o, R.color.navi_op_text, R.color.navi_op_text_skin);
            SkinManager.setNavbarTitleColor(this.n, R.color.navi_op_text, R.color.navi_op_text_skin);
            NoDataView noDataView = this.f61571d;
            if (noDataView != null) {
                noDataView.f(this.f61573f.getPageContext(), i2);
            }
            NoNetworkView noNetworkView = this.f61572e;
            if (noNetworkView != null) {
                noNetworkView.c(this.f61573f.getPageContext(), i2);
            }
            this.f61569b.notifyDataSetChanged();
        }
    }

    public final void p(OfficialBarTipActivity officialBarTipActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, officialBarTipActivity, z) == null) {
            if (z) {
                this.f61576i.setVisibility(0);
                this.f61569b.o(true);
                this.f61569b.notifyDataSetChanged();
                if (officialBarTipActivity.hasSelectedData()) {
                    q(true);
                } else {
                    q(false);
                }
                this.o.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
                this.n.setOnClickListener(new View$OnClickListenerC1503e(this, officialBarTipActivity));
                this.f61575h = true;
                return;
            }
            this.f61576i.setVisibility(8);
            this.n.setVisibility(8);
            this.f61569b.o(false);
            this.f61569b.notifyDataSetChanged();
            this.o.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
            this.f61575h = false;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.l.setAlpha(1.0f);
                this.l.setEnabled(true);
                return;
            }
            this.l.setAlpha(0.3f);
            this.l.setEnabled(false);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            int g2 = l.g(this.f61573f.getPageContext().getPageActivity(), R.dimen.ds40);
            if (z) {
                Drawable drawable = SkinManager.getDrawable(R.drawable.btn_bgb_choice_s);
                drawable.setBounds(0, 0, g2, g2);
                this.j.setText(this.f61573f.getPageContext().getString(R.string.cancel_select_all));
                this.j.setCompoundDrawables(drawable, null, null, null);
                q(true);
                this.k = true;
                this.f61573f.updateEditStatus(true);
                return;
            }
            Drawable drawable2 = SkinManager.getDrawable(R.drawable.btn_bgb_choice_n);
            drawable2.setBounds(0, 0, g2, g2);
            this.j.setText(this.f61573f.getPageContext().getString(R.string.select_all));
            this.j.setCompoundDrawables(drawable2, null, null, null);
            q(false);
            this.k = false;
            this.f61573f.updateEditStatus(false);
        }
    }
}
