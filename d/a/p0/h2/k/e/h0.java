package d.a.p0.h2.k.e;

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
/* loaded from: classes8.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f f57327a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarCoverTip f57328b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57329c;

    /* renamed from: d  reason: collision with root package name */
    public int f57330d;

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
        this.f57327a = fVar;
        this.f57328b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f57328b == null) {
            return;
        }
        if (!d.a.c.e.p.k.isEmpty(str) && this.f57330d <= 0) {
            this.f57328b.setVisibility(0);
            this.f57330d++;
            this.f57329c.setText(str);
            SkinManager.setViewTextColor(this.f57329c, R.color.CAM_X0101);
            this.f57328b.removeAllViews();
            this.f57328b.addView(this.f57329c);
            this.f57328b.k(this.f57327a.getPageActivity(), 5000);
            return;
        }
        c();
        this.f57328b.setVisibility(8);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f57329c = new TextView(this.f57327a.getPageActivity());
            this.f57329c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f57329c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
            this.f57329c.setPadding(this.f57327a.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.f57327a.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.f57329c.setGravity(19);
            this.f57329c.setTextSize(0, this.f57327a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
            this.f57329c.setLineSpacing(this.f57327a.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (navigationBarCoverTip = this.f57328b) == null) {
            return;
        }
        navigationBarCoverTip.i();
    }
}
