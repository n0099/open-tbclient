package d.a.p0.v1.f;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f65174a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f65175b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f65176c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f65177d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f65178e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f65179f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f65180g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f65181h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f65182i;
    public TextView j;
    public TextView k;
    public int l;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f65183e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65183e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f65183e.f65175b, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        }
    }

    public g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 3;
        this.f65174a = tbPageContext.getPageActivity();
        this.f65175b = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.member_pay_result_layout);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.navigation_bar);
        this.f65176c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f65176c.showBottomLine();
        this.f65177d = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.no_network_view);
        this.f65176c.onChangeSkinType(tbPageContext, TbadkApplication.getInst().getSkinType());
        this.f65178e = (TbImageView) tbPageContext.getPageActivity().findViewById(R.id.success_img);
        this.f65179f = (TextView) tbPageContext.getPageActivity().findViewById(R.id.success_text);
        this.f65180g = (TextView) tbPageContext.getPageActivity().findViewById(R.id.pay_content);
        this.f65182i = (TextView) tbPageContext.getPageActivity().findViewById(R.id.super_member);
        this.f65181h = (TextView) tbPageContext.getPageActivity().findViewById(R.id.tip_content);
        TextView textView = (TextView) tbPageContext.getPageActivity().findViewById(R.id.open_card_box_view);
        this.j = textView;
        textView.setOnClickListener(new a(this));
        c();
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f65180g.setText(String.format(this.f65174a.getString(R.string.pay_member_content), str));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k = this.f65176c.setCenterTextTitle(this.f65174a.getString(R.string.card_box_nav_title));
            this.f65177d.c(this.f65175b, TbadkApplication.getInst().getSkinType());
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            SkinManager.setImageResource(this.f65178e, R.drawable.icon_send_ok);
            SkinManager.setViewTextColor(this.f65179f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f65180g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f65182i, R.color.CAM_X0305);
            SkinManager.setViewTextColor(this.f65181h, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.l != i2) {
                this.f65176c.onChangeSkinType(this.f65175b, i2);
                this.f65177d.c(this.f65175b, i2);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
                SkinManager.setImageResource(this.f65178e, R.drawable.icon_send_ok);
                SkinManager.setViewTextColor(this.f65179f, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f65180g, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f65182i, R.color.CAM_X0305);
                SkinManager.setViewTextColor(this.f65181h, R.color.CAM_X0108);
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
                SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
            }
            this.l = i2;
        }
    }
}
