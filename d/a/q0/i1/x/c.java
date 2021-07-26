package d.a.q0.i1.x;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.validate.ValidateActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.d;
import d.a.d.a.f;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends d<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f59331a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f59332b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f59333c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f59334d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.i1.x.a f59335e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f59336f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f59337g;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f59338e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59338e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f59338e.f59333c.finish();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {validateActivity};
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
        this.f59333c = validateActivity;
        g();
        d.a.q0.i1.x.a aVar = new d.a.q0.i1.x.a(this.f59333c);
        this.f59335e = aVar;
        this.f59334d.setAdapter((ListAdapter) aVar);
        this.f59334d.setOnSrollToBottomListener(this.f59333c);
    }

    @Override // d.a.d.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.destroy();
            d.a.q0.i1.x.a aVar = this.f59335e;
            if (aVar != null) {
                aVar.a();
                this.f59335e = null;
            }
            this.f59333c = null;
        }
    }

    public ImageView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59332b : (ImageView) invokeV.objValue;
    }

    public d.a.q0.i1.x.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59335e : (d.a.q0.i1.x.a) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = View.inflate(this.f59333c.getPageContext().getPageActivity(), R.layout.validate_activity, null);
            this.f59331a = inflate;
            this.f59333c.setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) this.f59333c.findViewById(R.id.view_navigation_bar);
            this.f59337g = navigationBar;
            navigationBar.setTitleText(this.f59333c.getPageContext().getString(R.string.validate));
            this.f59337g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.f59334d = (BdListView) this.f59331a.findViewById(R.id.validate_list);
            this.f59336f = (ProgressBar) this.f59331a.findViewById(R.id.pro_load);
            j(false);
        }
    }

    public void h(List<ValidateItemData> list) {
        d.a.q0.i1.x.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || (aVar = this.f59335e) == null) {
            return;
        }
        aVar.c(list);
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f59336f.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f59333c.getLayoutMode().k(i2 == 1);
            this.f59333c.getLayoutMode().j(this.f59331a);
            this.f59337g.onChangeSkinType(this.f59333c.getPageContext(), i2);
            if (i2 != 1 && i2 != 4) {
                this.f59334d.setDivider(new ColorDrawable(this.f59333c.getResources().getColor(R.color.common_color_10241)));
                this.f59334d.setDividerHeight(this.f59333c.getResources().getDimensionPixelSize(R.dimen.ds2));
                return;
            }
            this.f59334d.setDivider(new ColorDrawable(this.f59333c.getResources().getColor(R.color.common_color_10179)));
            this.f59334d.setDividerHeight(this.f59333c.getResources().getDimensionPixelSize(R.dimen.ds2));
        }
    }
}
