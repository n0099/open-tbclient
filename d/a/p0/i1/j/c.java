package d.a.p0.i1.j;

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
/* loaded from: classes8.dex */
public class c extends d<UpdatesActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f58495a;

    /* renamed from: b  reason: collision with root package name */
    public View f58496b;

    /* renamed from: c  reason: collision with root package name */
    public UpdatesActivity f58497c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f58498d;

    /* renamed from: e  reason: collision with root package name */
    public a f58499e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f58500f;

    /* renamed from: g  reason: collision with root package name */
    public Button f58501g;

    /* renamed from: h  reason: collision with root package name */
    public Button f58502h;

    /* renamed from: i  reason: collision with root package name */
    public Button f58503i;
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
        this.f58497c = updatesActivity;
        m();
        a aVar = new a(this.f58497c);
        this.f58499e = aVar;
        this.f58498d.setAdapter((ListAdapter) aVar);
        this.f58498d.setOnScrollListener(this.f58497c);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f58501g.setVisibility(0);
            this.f58496b.setVisibility(0);
            this.f58502h.setVisibility(8);
            this.k.setVisibility(8);
            p(0);
            n();
        }
    }

    @Override // d.a.c.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.destroy();
            a aVar = this.f58499e;
            if (aVar != null) {
                aVar.a();
                this.f58499e = null;
            }
            this.f58497c = null;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f58501g.setVisibility(8);
            this.f58496b.setVisibility(8);
            this.f58502h.setVisibility(0);
            this.k.setVisibility(0);
            n();
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f58496b : (View) invokeV.objValue;
    }

    public Button g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f58502h : (Button) invokeV.objValue;
    }

    public Button h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58503i : (Button) invokeV.objValue;
    }

    public Button j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f58501g : (Button) invokeV.objValue;
    }

    public a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f58499e : (a) invokeV.objValue;
    }

    public BdListView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f58498d : (BdListView) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            View inflate = View.inflate(this.f58497c.getPageContext().getPageActivity(), R.layout.updates_activity, null);
            this.f58495a = inflate;
            this.f58497c.setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) this.f58497c.findViewById(R.id.view_navigation_bar);
            this.j = navigationBar;
            this.f58496b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.j.setTitleText(this.f58497c.getPageContext().getString(R.string.updates_activity_title));
            this.k = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.updates_activity_nav_left, (View.OnClickListener) null);
            this.l = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.updates_activity_nav_right, (View.OnClickListener) null);
            Button button = (Button) this.k.findViewById(R.id.btn_delete);
            this.f58503i = button;
            button.setOnClickListener(this.f58497c);
            this.f58496b.setOnClickListener(this.f58497c);
            this.f58498d = (BdListView) this.f58495a.findViewById(R.id.updates_list);
            this.f58500f = (ProgressBar) this.f58495a.findViewById(R.id.pro_load);
            Button button2 = (Button) this.l.findViewById(R.id.btn_edit);
            this.f58501g = button2;
            button2.setOnClickListener(this.f58497c);
            Button button3 = (Button) this.l.findViewById(R.id.btn_cancel);
            this.f58502h = button3;
            button3.setOnClickListener(this.f58497c);
            p(0);
            q(false);
        }
    }

    public void n() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aVar = this.f58499e) == null) {
            return;
        }
        aVar.notifyDataSetChanged();
    }

    public void o(List<UpdatesItemData> list) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || (aVar = this.f58499e) == null) {
            return;
        }
        aVar.c(list);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f58497c.getLayoutMode().k(i2 == 1);
            this.f58497c.getLayoutMode().j(this.f58495a);
            this.j.onChangeSkinType(this.f58497c.getPageContext(), i2);
            SkinManager.setBackgroundResource(this.f58503i, R.drawable.btn_delete_groupupdates);
        }
    }

    public void p(int i2) {
        Button button;
        UpdatesActivity updatesActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (button = this.f58503i) == null || (updatesActivity = this.f58497c) == null) {
            return;
        }
        button.setText(String.format(updatesActivity.getPageContext().getString(R.string.del_count), Integer.valueOf(i2)));
        if (i2 == 0) {
            this.f58503i.setEnabled(false);
        } else {
            this.f58503i.setEnabled(true);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f58500f.setVisibility(z ? 0 : 8);
        }
    }
}
