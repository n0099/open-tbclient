package d.a.s0.i1.j;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.d;
import d.a.c.a.f;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends d<UpdatesActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f61730a;

    /* renamed from: b  reason: collision with root package name */
    public View f61731b;

    /* renamed from: c  reason: collision with root package name */
    public UpdatesActivity f61732c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f61733d;

    /* renamed from: e  reason: collision with root package name */
    public a f61734e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f61735f;

    /* renamed from: g  reason: collision with root package name */
    public Button f61736g;

    /* renamed from: h  reason: collision with root package name */
    public Button f61737h;

    /* renamed from: i  reason: collision with root package name */
    public Button f61738i;
    public NavigationBar j;
    public View k;
    public View l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {updatesActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61732c = updatesActivity;
        n();
        a aVar = new a(this.f61732c);
        this.f61734e = aVar;
        this.f61733d.setAdapter((ListAdapter) aVar);
        this.f61733d.setOnScrollListener(this.f61732c);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f61736g.setVisibility(0);
            this.f61731b.setVisibility(0);
            this.f61737h.setVisibility(8);
            this.k.setVisibility(8);
            q(0);
            o();
        }
    }

    @Override // d.a.c.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.destroy();
            a aVar = this.f61734e;
            if (aVar != null) {
                aVar.a();
                this.f61734e = null;
            }
            this.f61732c = null;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f61736g.setVisibility(8);
            this.f61731b.setVisibility(8);
            this.f61737h.setVisibility(0);
            this.k.setVisibility(0);
            o();
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f61731b : (View) invokeV.objValue;
    }

    public Button h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f61737h : (Button) invokeV.objValue;
    }

    public Button i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f61738i : (Button) invokeV.objValue;
    }

    public Button k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f61736g : (Button) invokeV.objValue;
    }

    public a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f61734e : (a) invokeV.objValue;
    }

    public BdListView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f61733d : (BdListView) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            View inflate = View.inflate(this.f61732c.getPageContext().getPageActivity(), R.layout.updates_activity, null);
            this.f61730a = inflate;
            this.f61732c.setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) this.f61732c.findViewById(R.id.view_navigation_bar);
            this.j = navigationBar;
            this.f61731b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.j.setTitleText(this.f61732c.getPageContext().getString(R.string.updates_activity_title));
            this.k = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
            this.l = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
            Button button = (Button) this.k.findViewById(R.id.btn_delete);
            this.f61738i = button;
            button.setOnClickListener(this.f61732c);
            this.f61731b.setOnClickListener(this.f61732c);
            this.f61733d = (BdListView) this.f61730a.findViewById(R.id.updates_list);
            this.f61735f = (ProgressBar) this.f61730a.findViewById(R.id.pro_load);
            Button button2 = (Button) this.l.findViewById(R.id.btn_edit);
            this.f61736g = button2;
            button2.setOnClickListener(this.f61732c);
            Button button3 = (Button) this.l.findViewById(R.id.btn_cancel);
            this.f61737h = button3;
            button3.setOnClickListener(this.f61732c);
            q(0);
            r(false);
        }
    }

    public void o() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aVar = this.f61734e) == null) {
            return;
        }
        aVar.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f61732c.getLayoutMode().k(i2 == 1);
            this.f61732c.getLayoutMode().j(this.f61730a);
            this.j.onChangeSkinType(this.f61732c.getPageContext(), i2);
            SkinManager.setBackgroundResource(this.f61738i, R.drawable.btn_delete_groupupdates);
        }
    }

    public void p(List<UpdatesItemData> list) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, list) == null) || (aVar = this.f61734e) == null) {
            return;
        }
        aVar.c(list);
    }

    public void q(int i2) {
        Button button;
        UpdatesActivity updatesActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (button = this.f61738i) == null || (updatesActivity = this.f61732c) == null) {
            return;
        }
        button.setText(String.format(updatesActivity.getPageContext().getString(R.string.del_count), Integer.valueOf(i2)));
        if (i2 == 0) {
            this.f61738i.setEnabled(false);
        } else {
            this.f61738i.setEnabled(true);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f61735f.setVisibility(z ? 0 : 8);
        }
    }
}
