package d.a.p0.d2.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.fragment.InterestSelectionFragment;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.d2.c.b;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements View.OnClickListener, InterestSelectionFragment.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f54930e;

    /* renamed from: f  reason: collision with root package name */
    public int f54931f;

    /* renamed from: g  reason: collision with root package name */
    public View f54932g;

    /* renamed from: h  reason: collision with root package name */
    public View f54933h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f54934i;
    public NavigationBar j;
    public InterestedForumFragment k;
    public InterestSelectionFragment l;

    public a(BaseFragmentActivity baseFragmentActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54930e = baseFragmentActivity;
        this.f54931f = i2;
        e();
        f();
    }

    @Override // com.baidu.tieba.newinterest.fragment.InterestSelectionFragment.a
    public void a(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            InterestedForumFragment H0 = InterestedForumFragment.H0(this.f54931f);
            this.k = H0;
            H0.N0(list);
            b().beginTransaction().add(R.id.content_container, this.k).addToBackStack(null).commitAllowingStateLoss();
            d.a.p0.d2.d.a.a(b().getFragments().size() == 1 ? 1 : 2, 1, this.f54931f);
        }
    }

    public final FragmentManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54930e.getSupportFragmentManager() : (FragmentManager) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f54932g : (View) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 1);
            TiebaStatic.log(statisticItem);
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.f54930e).createNormalCfg(0)));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(this.f54930e).inflate(R.layout.activity_interest_guide_layout, (ViewGroup) null);
            this.f54932g = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            this.j = navigationBar;
            TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f54930e.getString(R.string.skip));
            this.f54934i = addTextButton;
            addTextButton.setId(R.id.btn_skip);
            SkinManager.setViewTextColor(this.f54934i, R.color.CAM_X0107);
            this.f54933h = this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.l = InterestSelectionFragment.H0(this.f54931f);
            b().beginTransaction().add(R.id.content_container, this.l).commitAllowingStateLoss();
            TiebaStatic.log(new StatisticItem("c13681"));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f54934i.setOnClickListener(this);
            this.f54933h.setOnClickListener(this);
            this.l.K0(this);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && b().getFragments().size() == 1) {
            d.a.p0.d2.d.a.b(1, this.f54931f);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SkinManager.setBackgroundColor(this.f54932g, R.color.CAM_X0201);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            if (view == this.f54933h && this.f54930e != null) {
                InterestedForumFragment interestedForumFragment = this.k;
                if (interestedForumFragment != null && interestedForumFragment.isVisible()) {
                    b().popBackStack();
                    d.a.p0.d2.d.a.b(1, this.f54931f);
                    return;
                }
                d();
            } else if (view == this.f54934i) {
                d();
                d.a.p0.d2.d.a.a(b().getFragments().size() != 1 ? 2 : 1, 2, this.f54931f);
            }
        }
    }
}
