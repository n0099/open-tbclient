package d.a.p0.s.e0;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
import d.a.d.a.j;
import d.a.d.e.l.c;
import d.a.d.e.l.d;
import d.a.d.e.p.l;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f52973a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f52974b;

    /* renamed from: c  reason: collision with root package name */
    public final c<d.a.d.k.d.a> f52975c;

    /* renamed from: d.a.p0.s.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1211a extends c<d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f52976a;

        public C1211a(a aVar) {
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
            this.f52976a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((C1211a) aVar, str, i2);
                if (this.f52976a.f52974b == null || aVar == null || !aVar.w()) {
                    this.f52976a.f();
                    return;
                }
                FragmentTabWidget fragmentTabWidget = this.f52976a.f52974b.getFragmentTabWidget();
                CustomViewPager fragmentViewPager = this.f52976a.f52974b.getFragmentViewPager();
                ViewGroup tabWrapper = this.f52976a.f52974b.getTabWrapper();
                if (fragmentTabWidget == null || fragmentViewPager == null) {
                    return;
                }
                this.f52976a.f52974b.setNeedShowThemeStyle(false);
                fragmentTabWidget.setBackGroundDrawableResId(R.color.black_alpha0);
                SkinManager.setBackgroundColor(tabWrapper, R.color.black_alpha0);
                SkinManager.setBackgroundColor(fragmentTabWidget, R.color.black_alpha0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fragmentViewPager.getLayoutParams();
                layoutParams.bottomMargin = l.g(this.f52976a.f52974b.getContext(), R.dimen.tbds100);
                fragmentViewPager.setLayoutParams(layoutParams);
                fragmentTabWidget.setBackgroundDrawable(new BitmapDrawable(aVar.p()));
            }
        }
    }

    public a(FragmentTabHost fragmentTabHost, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentTabHost, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52973a = 0;
        this.f52975c = new C1211a(this);
        this.f52974b = fragmentTabHost;
        this.f52973a = i2;
    }

    public final BdUniqueId c() {
        InterceptResult invokeV;
        f<?> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            FragmentTabHost fragmentTabHost = this.f52974b;
            if (fragmentTabHost == null || fragmentTabHost.getContext() == null || (a2 = j.a(this.f52974b.getContext())) == null) {
                return null;
            }
            return a2.getUniqueId();
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            d.h().m(str, 10, this.f52975c, c());
        }
    }

    public void e(Pair<String, String> pair) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pair) == null) || pair == null) {
            return;
        }
        String str = (String) pair.first;
        String str2 = (String) pair.second;
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(str2)) {
            d(str2);
        } else if (!TextUtils.isEmpty(str)) {
            d(str);
        } else {
            f();
        }
    }

    public final void f() {
        FragmentTabHost fragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (fragmentTabHost = this.f52974b) == null || fragmentTabHost.getFragmentTabWidget() == null) {
            return;
        }
        this.f52974b.getFragmentTabWidget().setBackGroundDrawableResId(this.f52973a);
        SkinManager.setBackgroundColor(this.f52974b.getFragmentTabWidget(), this.f52973a);
        SkinManager.setBackgroundColor(this.f52974b.getTabWrapper(), this.f52973a);
    }
}
