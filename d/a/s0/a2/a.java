package d.a.s0.a2;

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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TextView f57191a;

    /* renamed from: b  reason: collision with root package name */
    public final FragmentTabHost f57192b;

    /* renamed from: c  reason: collision with root package name */
    public int f57193c;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f57194d;

    /* renamed from: e  reason: collision with root package name */
    public final NavigationBar f57195e;

    /* renamed from: f  reason: collision with root package name */
    public final NoNetworkView f57196f;

    /* renamed from: g  reason: collision with root package name */
    public CollectTabActivity f57197g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57198h;

    /* renamed from: i  reason: collision with root package name */
    public List f57199i;
    public ViewPager.OnPageChangeListener j;

    /* renamed from: d.a.s0.a2.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1296a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57200e;

        public C1296a(a aVar) {
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
            this.f57200e = aVar;
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
                this.f57200e.l(i2);
                this.f57200e.b(false);
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
        this.f57193c = -1;
        this.f57198h = false;
        this.j = new C1296a(this);
        this.f57197g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.tab_host);
        this.f57192b = fragmentTabHost;
        fragmentTabHost.setup(this.f57197g.getSupportFragmentManager());
        this.f57192b.setOnPageChangeListener(this.j);
        this.f57195e = (NavigationBar) this.f57197g.findViewById(R.id.navigation_bar);
        this.f57196f = (NoNetworkView) this.f57197g.findViewById(R.id.view_no_network);
        this.f57195e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57195e.setCenterTextTitle(this.f57197g.getPageContext().getString(R.string.my_mark));
        TextView textView = (TextView) this.f57195e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f57197g).findViewById(R.id.right_textview);
        this.f57191a = textView;
        textView.setText(R.string.edit);
        this.f57191a.setOnClickListener(this.f57197g);
        this.f57195e.onChangeSkinType(this.f57197g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            Fragment fragment = this.f57194d;
            if (fragment instanceof CollectFragment) {
                CollectFragment collectFragment = (CollectFragment) fragment;
                if (!collectFragment.I0()) {
                    z = false;
                }
                k(collectFragment.I0());
                i2 = collectFragment.G0();
            } else {
                i2 = -1;
            }
            this.f57198h = z;
            this.f57191a.setText(z ? R.string.done : R.string.edit);
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                SkinManager.setNavbarTitleColor(this.f57191a, R.color.navi_op_text, R.color.navi_op_text_skin);
            } else {
                SkinManager.setNavbarTitleColor(this.f57191a, this.f57198h ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_edit_state", this.f57198h);
            bundle.putInt("fragment_type", i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
        }
    }

    public final void c(d.a.r0.e0.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        d.a.r0.e0.c fragmentTabStructure;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, fragmentTabIndicator) == null) || (fragmentTabStructure = bVar.getFragmentTabStructure()) == null) {
            return;
        }
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f12348c = fragmentTabStructure.f55251a;
        bVar2.f12346a = fragmentTabStructure.f55255e;
        fragmentTabIndicator.setText(fragmentTabStructure.f55252b);
        fragmentTabIndicator.setTextSize(0, this.f57197g.getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar2.f12347b = fragmentTabIndicator;
        bVar2.f12349d = bVar;
        this.f57192b.a(bVar2);
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57191a : (TextView) invokeV.objValue;
    }

    public Fragment e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57194d : (Fragment) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57193c : invokeV.intValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ListUtils.getCount(this.f57199i) : invokeV.intValue;
    }

    public void h(ArrayList<d.a.r0.e0.b> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f57199i = arrayList;
        this.f57192b.q();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.r0.e0.b bVar = arrayList.get(i2);
            if (bVar != null && bVar.isAvailable()) {
                c(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.f57197g.getPageContext().getPageActivity()));
            }
        }
        this.f57192b.k(0);
        this.f57192b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.f57192b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f57198h : invokeV.booleanValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f57192b.p(i2);
            if (this.f57192b.getTabWrapper() != null) {
                if (g() <= 1) {
                    this.f57192b.getTabWrapper().setVisibility(8);
                } else {
                    this.f57192b.getTabWrapper().setVisibility(0);
                }
            }
            SkinManager.setNavbarTitleColor(this.f57191a, R.color.navi_op_text, R.color.navi_op_text_skin);
            this.f57195e.onChangeSkinType(this.f57197g.getPageContext(), i2);
            this.f57196f.c(this.f57197g.getPageContext(), i2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f57191a.setEnabled(z);
            if (z) {
                return;
            }
            this.f57191a.setText(R.string.edit);
            SkinManager.setNavbarTitleColor(this.f57191a, R.color.navi_op_text, R.color.navi_op_text_skin);
        }
    }

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            FragmentTabHost.b f2 = this.f57192b.f(i2);
            this.f57193c = f2.f12346a;
            this.f57194d = f2.f12348c;
        }
    }
}
