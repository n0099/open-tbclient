package d.a.s0.h2.k.e;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f60571a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f60572b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60573c;

    /* renamed from: d  reason: collision with root package name */
    public int f60574d;

    public h0(d.a.c.a.f fVar, NavigationBarCoverTip navigationBarCoverTip) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, navigationBarCoverTip};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60571a = fVar;
        this.f60572b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f60572b == null) {
            return;
        }
        if (!d.a.c.e.p.k.isEmpty(str) && this.f60574d <= 0) {
            this.f60572b.setVisibility(0);
            this.f60574d++;
            this.f60573c.setText(str);
            SkinManager.setViewTextColor(this.f60573c, R.color.CAM_X0101);
            this.f60572b.removeAllViews();
            this.f60572b.addView(this.f60573c);
            this.f60572b.k(this.f60571a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f60572b.setVisibility(8);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f60573c = new TextView(this.f60571a.getPageActivity());
            this.f60573c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f60573c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
            this.f60573c.setPadding(this.f60571a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f60571a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f60573c.setGravity(19);
            this.f60573c.setTextSize(0, this.f60571a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
            this.f60573c.setLineSpacing(this.f60571a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (navigationBarCoverTip = this.f60572b) == null) {
            return;
        }
        navigationBarCoverTip.i();
    }
}
