package d.a.q0.a2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.myCollection.CollectTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TextView f54480a;

    /* renamed from: b  reason: collision with root package name */
    public final FragmentTabHost f54481b;

    /* renamed from: c  reason: collision with root package name */
    public int f54482c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f54483d;

    /* renamed from: e  reason: collision with root package name */
    public final NavigationBar f54484e;

    /* renamed from: f  reason: collision with root package name */
    public final NoNetworkView f54485f;

    /* renamed from: g  reason: collision with root package name */
    public CollectTabActivity f54486g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54487h;

    /* renamed from: i  reason: collision with root package name */
    public List f54488i;
    public ViewPager.OnPageChangeListener j;

    /* renamed from: d.a.q0.a2.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1259a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f54489e;

        public C1259a(a aVar) {
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
            this.f54489e = aVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f54489e.l(i2);
                this.f54489e.b(false);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collectTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54482c = -1;
        this.f54487h = false;
        this.j = new C1259a(this);
        this.f54486g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.tab_host);
        this.f54481b = fragmentTabHost;
        fragmentTabHost.setup(this.f54486g.getSupportFragmentManager());
        this.f54481b.setOnPageChangeListener(this.j);
        this.f54484e = (NavigationBar) this.f54486g.findViewById(R.id.navigation_bar);
        this.f54485f = (NoNetworkView) this.f54486g.findViewById(R.id.view_no_network);
        this.f54484e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54484e.setCenterTextTitle(this.f54486g.getPageContext().getString(R.string.my_mark));
        TextView textView = (TextView) this.f54484e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f54486g).findViewById(R.id.right_textview);
        this.f54480a = textView;
        textView.setText(R.string.edit);
        this.f54480a.setOnClickListener(this.f54486g);
        this.f54484e.onChangeSkinType(this.f54486g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Fragment fragment = this.f54483d;
            if (fragment instanceof CollectFragment) {
                CollectFragment collectFragment = (CollectFragment) fragment;
                if (!collectFragment.O0()) {
                    z = false;
                }
                k(collectFragment.O0());
                i2 = collectFragment.M0();
            } else {
                i2 = -1;
            }
            this.f54487h = z;
            this.f54480a.setText(z ? R.string.done : R.string.edit);
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                SkinManager.setNavbarTitleColor(this.f54480a, R.color.navi_op_text, R.color.navi_op_text_skin);
            } else {
                SkinManager.setNavbarTitleColor(this.f54480a, this.f54487h ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_edit_state", this.f54487h);
            bundle.putInt("fragment_type", i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
        }
    }

    public final void c(d.a.p0.g0.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        d.a.p0.g0.c fragmentTabStructure;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, fragmentTabIndicator) == null) || (fragmentTabStructure = bVar.getFragmentTabStructure()) == null) {
            return;
        }
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f12395c = fragmentTabStructure.f52618a;
        bVar2.f12393a = fragmentTabStructure.f52622e;
        fragmentTabIndicator.setText(fragmentTabStructure.f52619b);
        fragmentTabIndicator.setTextSize(0, this.f54486g.getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar2.f12394b = fragmentTabIndicator;
        bVar2.f12396d = bVar;
        this.f54481b.a(bVar2);
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f54480a : (TextView) invokeV.objValue;
    }

    public Fragment e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f54483d : (Fragment) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f54482c : invokeV.intValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.getCount(this.f54488i) : invokeV.intValue;
    }

    public void h(ArrayList<d.a.p0.g0.b> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f54488i = arrayList;
        this.f54481b.q();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.p0.g0.b bVar = arrayList.get(i2);
            if (bVar != null && bVar.isAvailable()) {
                c(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.f54486g.getPageContext().getPageActivity()));
            }
        }
        this.f54481b.k(0);
        this.f54481b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.f54481b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f54487h : invokeV.booleanValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f54481b.p(i2);
            if (this.f54481b.getTabWrapper() != null) {
                if (g() <= 1) {
                    this.f54481b.getTabWrapper().setVisibility(8);
                } else {
                    this.f54481b.getTabWrapper().setVisibility(0);
                }
            }
            SkinManager.setNavbarTitleColor(this.f54480a, R.color.navi_op_text, R.color.navi_op_text_skin);
            this.f54484e.onChangeSkinType(this.f54486g.getPageContext(), i2);
            this.f54485f.c(this.f54486g.getPageContext(), i2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f54480a.setEnabled(z);
            if (z) {
                return;
            }
            this.f54480a.setText(R.string.edit);
            SkinManager.setNavbarTitleColor(this.f54480a, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            FragmentTabHost.b f2 = this.f54481b.f(i2);
            this.f54482c = f2.f12393a;
            this.f54483d = f2.f12395c;
        }
    }
}
