package d.a.s0.n3.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.SkinProgressView;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity;
import com.baidu.tieba.themeCenter.background.BackgroundSetHttpResponseMessage;
import com.baidu.tieba.themeCenter.background.BackgroundSetRequestMessage;
import com.baidu.tieba.themeCenter.background.BackgroundSetSocketResponseMessage;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackgroundPreviewActivity f64186a;

    /* renamed from: b  reason: collision with root package name */
    public View f64187b;

    /* renamed from: c  reason: collision with root package name */
    public View f64188c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f64189d;

    /* renamed from: e  reason: collision with root package name */
    public i f64190e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f64191f;

    /* renamed from: g  reason: collision with root package name */
    public g f64192g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f64193h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f64194i;
    public d j;
    public View.OnClickListener k;
    public d.a.c.c.g.a l;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f64195e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64195e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f64195e.f64194i == null || this.f64195e.j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (this.f64195e.f64194i.getInUse()) {
                d.a.r0.r.a0.b.e(this.f64195e.f64186a.getPageContext().getPageActivity(), 8);
            } else {
                this.f64195e.j.e(this.f64195e.f64194i, true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f64196a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64196a = jVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", this.f64196a.f64194i.getPropsId()).param("obj_type", this.f64196a.f64194i.getFreeUserLevel()));
                    this.f64196a.f64194i.setInUse(true);
                    this.f64196a.m();
                    d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), this.f64196a.f64194i.getPropsId());
                    return;
                }
                int i2 = d.a.s0.n3.c.f64103b;
                if (responsedMessage.getError() == d.a.s0.n3.c.f64104c) {
                    i2 = d.a.s0.n3.c.f64102a;
                }
                this.f64196a.j.d(i2, responsedMessage.getErrorString(), this.f64196a.f64194i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1559991080, "Ld/a/s0/n3/e/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1559991080, "Ld/a/s0/n3/e/j;");
                return;
            }
        }
        m = l.g(TbadkApplication.getInst().getContext(), R.dimen.ds320);
    }

    public j(BackgroundPreviewActivity backgroundPreviewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundPreviewActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.l = new b(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
        this.f64186a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f64187b = inflate;
        this.f64186a.setContentView(inflate);
        this.f64188c = this.f64187b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f64187b.findViewById(R.id.view_navigation_bar);
        this.f64189d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f64189d.showBottomLine(false);
        this.f64191f = (BdExpandListView) this.f64186a.findViewById(R.id.personcenter_list);
        this.f64193h = (SkinProgressView) this.f64187b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.f64186a.getUniqueId());
        this.j = dVar;
        dVar.c(this.f64186a.getFrom());
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.f64187b, R.color.CAM_X0204);
            this.f64186a.hideNetRefreshView(this.f64187b);
            this.f64188c.setVisibility(0);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64187b : (View) invokeV.objValue;
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.r0.s0.a.a(this.f64186a.getPageContext(), this.f64187b);
            NavigationBar navigationBar = this.f64189d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f64186a.getPageContext(), TbadkApplication.getInst().getSkinType());
                SkinManager.setBackgroundResource(this.f64189d, R.color.common_color_10262);
            }
            BdExpandListView bdExpandListView = this.f64191f;
            if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f64192g) == null) {
                return;
            }
            gVar.notifyDataSetChanged();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.s0.h3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            d.a.s0.h3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void j(BdExpandListView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f64191f.setExpandListRefreshListener(bVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f64188c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f64187b, R.color.CAM_X0201);
            String string = this.f64186a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f64186a.setNetRefreshViewTopMargin(m);
            this.f64186a.showNetRefreshView(this.f64187b, string, false);
        }
    }

    public void l(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dressItemData) == null) {
            this.f64194i = dressItemData;
            if (dressItemData == null) {
                k();
                return;
            }
            e();
            if (this.f64190e == null) {
                i iVar = new i(this.f64186a);
                this.f64190e = iVar;
                iVar.e(dressItemData);
                this.f64191f.addHeaderView(this.f64190e.b());
                this.f64190e.d();
                this.f64191f.setExpandView(this.f64190e.b(), this.f64186a.getResources().getDimensionPixelSize(R.dimen.ds400));
                g gVar = new g(this.f64186a.getPageContext(), dressItemData);
                this.f64192g = gVar;
                this.f64191f.setAdapter((ListAdapter) gVar);
                i();
                this.f64186a.registerListener(this.l);
            }
            this.f64193h.setDressData(this.f64194i);
            this.f64193h.setOnClickListener(this.k);
            m();
        }
    }

    public final void m() {
        DressItemData dressItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dressItemData = this.f64194i) == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.f64194i.getActivityFinish();
        this.f64193h.setFontSize(l.g(this.f64186a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f64193h.b(0, 0.0f, this.f64194i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f64193h.b(9, 0.0f, this.f64194i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
