package d.a.s0.r2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.tieba.postsearch.PostSearchListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f65132a;

    /* renamed from: b  reason: collision with root package name */
    public View f65133b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f65134c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f65135d;

    /* renamed from: e  reason: collision with root package name */
    public PostSearchListFragment f65136e;

    /* renamed from: f  reason: collision with root package name */
    public PostSearchListFragment f65137f;

    /* renamed from: g  reason: collision with root package name */
    public PostSearchListFragment f65138g;

    public f(PostSearchActivity postSearchActivity, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postSearchActivity, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65132a = postSearchActivity;
        this.f65133b = view;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f65136e.G0();
            this.f65137f.G0();
            this.f65138g.G0();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FragmentTabHost.b bVar = new FragmentTabHost.b();
            PostSearchListFragment postSearchListFragment = new PostSearchListFragment(1);
            this.f65136e = postSearchListFragment;
            bVar.f12348c = postSearchListFragment;
            bVar.f12347b = c(R.string.searching_time_tab);
            bVar.f12346a = 1;
            this.f65134c.a(bVar);
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            PostSearchListFragment postSearchListFragment2 = new PostSearchListFragment(2);
            this.f65137f = postSearchListFragment2;
            bVar2.f12348c = postSearchListFragment2;
            bVar2.f12347b = c(R.string.searching_relative_tab);
            bVar2.f12346a = 2;
            this.f65134c.a(bVar2);
            FragmentTabHost.b bVar3 = new FragmentTabHost.b();
            PostSearchListFragment postSearchListFragment3 = new PostSearchListFragment(3);
            this.f65138g = postSearchListFragment3;
            bVar3.f12348c = postSearchListFragment3;
            bVar3.f12347b = c(R.string.searching_only_thread_tab);
            bVar3.f12346a = 3;
            this.f65134c.a(bVar3);
        }
    }

    public final FragmentTabIndicator c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.f65132a.getPageContext().getPageActivity()).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
            fragmentTabIndicator.setText(i2);
            fragmentTabIndicator.setTextSize(0, this.f65132a.getResources().getDimensionPixelSize(R.dimen.ds32));
            fragmentTabIndicator.l = R.color.s_actionbar_text_color;
            fragmentTabIndicator.setContentTvTopMargin(this.f65132a.getResources().getDimensionPixelSize(R.dimen.ds4));
            fragmentTabIndicator.setWidth((l.k(this.f65132a.getPageContext().getContext()) - (this.f65132a.getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) / 3);
            return fragmentTabIndicator;
        }
        return (FragmentTabIndicator) invokeI.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f65134c.getCurrentTabType() : invokeV.intValue;
    }

    public final PostSearchListFragment e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return this.f65138g;
                }
                return this.f65137f;
            }
            return this.f65136e;
        }
        return (PostSearchListFragment) invokeI.objValue;
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            View inflate = ((ViewStub) this.f65133b.findViewById(R.id.search_tab_host_viewstub)).inflate();
            inflate.setVisibility(0);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) inflate.findViewById(R.id.post_search_tab_host);
            this.f65134c = fragmentTabHost;
            fragmentTabHost.setup(this.f65132a.getSupportFragmentManager());
            this.f65134c.setTabWidgetViewHeight((int) this.f65132a.getResources().getDimension(R.dimen.ds80));
            this.f65134c.setShouldDrawIndicatorLine(true);
            b();
            this.f65134c.k(3);
            this.f65134c.setCurrentTabByType(i2);
            this.f65134c.setNeedShowThemeStyle(false);
            this.f65134c.getFragmentTabWidget().setBackGroundDrawableResId(0);
            this.f65134c.p(TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setBackgroundColor(this.f65134c.getFragmentTabWidget(), R.color.CAM_X0201);
            this.f65134c.setOnPageChangeListener(this.f65135d);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            FragmentTabHost fragmentTabHost = this.f65134c;
            if (fragmentTabHost != null) {
                fragmentTabHost.p(i2);
            }
            FragmentTabHost fragmentTabHost2 = this.f65134c;
            if (fragmentTabHost2 == null || fragmentTabHost2.getFragmentTabWidget() == null) {
                return;
            }
            SkinManager.setBackgroundColor(this.f65134c.getFragmentTabWidget(), R.color.CAM_X0201);
        }
    }

    public void h(int i2, b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), bVar, Boolean.valueOf(z)}) == null) {
            j(true);
            PostSearchListFragment e2 = e(i2);
            if (e2 != null) {
                e2.K0(bVar, z);
            }
        }
    }

    public void i(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onPageChangeListener) == null) {
            this.f65135d = onPageChangeListener;
            FragmentTabHost fragmentTabHost = this.f65134c;
            if (fragmentTabHost != null) {
                fragmentTabHost.setOnPageChangeListener(onPageChangeListener);
            }
        }
    }

    public void j(boolean z) {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (fragmentTabHost = this.f65134c) == null) {
            return;
        }
        if (z) {
            fragmentTabHost.setVisibility(0);
        } else {
            fragmentTabHost.setVisibility(8);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (this.f65134c == null) {
                f(1);
                return;
            }
            a();
            if (this.f65134c.getCurrentTabType() == i2) {
                PostSearchListFragment e2 = e(i2);
                if (e2 != null) {
                    e2.L0(true);
                    return;
                }
                return;
            }
            this.f65134c.setCurrentTabByType(i2);
        }
    }
}
