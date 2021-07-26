package d.a.q0.v1.h.c;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f65945a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<?> f65946b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f65947c;

    /* renamed from: d  reason: collision with root package name */
    public View f65948d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f65949e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f65950f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f65951g;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65946b = baseActivity;
        this.f65948d = baseActivity.findViewById(R.id.tail_management_root);
        this.f65945a = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.f65947c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.f65950f = this.f65947c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f65946b.getString(R.string.cancel), onClickListener);
        TextView addTextButton = this.f65947c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.f65951g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65950f.getLayoutParams();
        layoutParams.leftMargin = l.g(this.f65946b, R.dimen.ds16);
        this.f65950f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f65951g.getLayoutParams();
        layoutParams2.rightMargin = l.g(this.f65946b, R.dimen.ds16);
        this.f65951g.setLayoutParams(layoutParams2);
        int g2 = l.g(this.f65946b, R.dimen.tbds27);
        this.f65951g.setPadding(g2, 0, g2, 0);
        this.f65949e = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.f65945a.addFooterView(view);
        this.f65945a.addHeaderView(view2);
    }

    public TextView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65950f : (TextView) invokeV.objValue;
    }

    public TextView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65951g : (TextView) invokeV.objValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f65946b.getLayoutMode().k(i2 == 1);
            this.f65946b.getLayoutMode().j(this.f65948d);
            this.f65949e.c(this.f65946b.getPageContext(), i2);
            this.f65947c.onChangeSkinType(this.f65946b.getPageContext(), i2);
            SkinManager.setViewTextColor(this.f65951g, R.color.navbar_btn_color);
            SkinManager.setViewTextColor(this.f65950f, R.color.navi_back_text_color);
            SkinManager.setBackgroundResource(this.f65951g, R.drawable.s_navbar_button_bg);
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f65945a.setAdapter((ListAdapter) aVar);
        }
    }

    public void e(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                this.f65951g.setText(this.f65946b.getPageContext().getString(R.string.done));
                return;
            }
            this.f65951g.setText(this.f65946b.getPageContext().getString(R.string.edit));
            this.f65951g.setEnabled(!z2);
        }
    }
}
