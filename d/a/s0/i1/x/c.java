package d.a.s0.i1.x;

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
import d.a.c.a.d;
import d.a.c.a.f;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends d<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f61952a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f61953b;

    /* renamed from: c  reason: collision with root package name */
    public ValidateActivity f61954c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f61955d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.i1.x.a f61956e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f61957f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f61958g;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61959e;

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
            this.f61959e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f61959e.f61954c.finish();
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
        this.f61954c = validateActivity;
        h();
        d.a.s0.i1.x.a aVar = new d.a.s0.i1.x.a(this.f61954c);
        this.f61956e = aVar;
        this.f61955d.setAdapter((ListAdapter) aVar);
        this.f61955d.setOnSrollToBottomListener(this.f61954c);
    }

    @Override // d.a.c.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.destroy();
            d.a.s0.i1.x.a aVar = this.f61956e;
            if (aVar != null) {
                aVar.a();
                this.f61956e = null;
            }
            this.f61954c = null;
        }
    }

    public ImageView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61953b : (ImageView) invokeV.objValue;
    }

    public d.a.s0.i1.x.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61956e : (d.a.s0.i1.x.a) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = View.inflate(this.f61954c.getPageContext().getPageActivity(), R.layout.validate_activity, null);
            this.f61952a = inflate;
            this.f61954c.setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) this.f61954c.findViewById(R.id.view_navigation_bar);
            this.f61958g = navigationBar;
            navigationBar.setTitleText(this.f61954c.getPageContext().getString(R.string.validate));
            this.f61958g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.f61955d = (BdListView) this.f61952a.findViewById(R.id.validate_list);
            this.f61957f = (ProgressBar) this.f61952a.findViewById(R.id.pro_load);
            k(false);
        }
    }

    public void i(List<ValidateItemData> list) {
        d.a.s0.i1.x.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || (aVar = this.f61956e) == null) {
            return;
        }
        aVar.c(list);
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f61957f.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f61954c.getLayoutMode().k(i2 == 1);
            this.f61954c.getLayoutMode().j(this.f61952a);
            this.f61958g.onChangeSkinType(this.f61954c.getPageContext(), i2);
            if (i2 != 1 && i2 != 4) {
                this.f61955d.setDivider(new ColorDrawable(this.f61954c.getResources().getColor(R.color.common_color_10241)));
                this.f61955d.setDividerHeight(this.f61954c.getResources().getDimensionPixelSize(R.dimen.ds2));
                return;
            }
            this.f61955d.setDivider(new ColorDrawable(this.f61954c.getResources().getColor(R.color.common_color_10179)));
            this.f61955d.setDividerHeight(this.f61954c.getResources().getDimensionPixelSize(R.dimen.ds2));
        }
    }
}
