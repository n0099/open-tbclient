package d.a.q0.n3.e;

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
import d.a.d.e.p.l;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackgroundPreviewActivity f61566a;

    /* renamed from: b  reason: collision with root package name */
    public View f61567b;

    /* renamed from: c  reason: collision with root package name */
    public View f61568c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f61569d;

    /* renamed from: e  reason: collision with root package name */
    public i f61570e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f61571f;

    /* renamed from: g  reason: collision with root package name */
    public g f61572g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f61573h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f61574i;
    public d j;
    public View.OnClickListener k;
    public d.a.d.c.g.a l;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f61575e;

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
            this.f61575e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f61575e.f61574i == null || this.f61575e.j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (this.f61575e.f61574i.getInUse()) {
                d.a.p0.s.a0.b.e(this.f61575e.f61566a.getPageContext().getPageActivity(), 8);
            } else {
                this.f61575e.j.e(this.f61575e.f61574i, true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f61576a;

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
            this.f61576a = jVar;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", this.f61576a.f61574i.getPropsId()).param("obj_type", this.f61576a.f61574i.getFreeUserLevel()));
                    this.f61576a.f61574i.setInUse(true);
                    this.f61576a.m();
                    d.a.p0.s.d0.b j = d.a.p0.s.d0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), this.f61576a.f61574i.getPropsId());
                    return;
                }
                int i2 = d.a.q0.n3.c.f61483b;
                if (responsedMessage.getError() == d.a.q0.n3.c.f61484c) {
                    i2 = d.a.q0.n3.c.f61482a;
                }
                this.f61576a.j.d(i2, responsedMessage.getErrorString(), this.f61576a.f61574i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1166964070, "Ld/a/q0/n3/e/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1166964070, "Ld/a/q0/n3/e/j;");
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
        this.f61566a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f61567b = inflate;
        this.f61566a.setContentView(inflate);
        this.f61568c = this.f61567b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f61567b.findViewById(R.id.view_navigation_bar);
        this.f61569d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61569d.showBottomLine(false);
        this.f61571f = (BdExpandListView) this.f61566a.findViewById(R.id.personcenter_list);
        this.f61573h = (SkinProgressView) this.f61567b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.f61566a.getUniqueId());
        this.j = dVar;
        dVar.c(this.f61566a.getFrom());
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.f61567b, R.color.CAM_X0204);
            this.f61566a.hideNetRefreshView(this.f61567b);
            this.f61568c.setVisibility(0);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61567b : (View) invokeV.objValue;
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.p0.u0.a.a(this.f61566a.getPageContext(), this.f61567b);
            NavigationBar navigationBar = this.f61569d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f61566a.getPageContext(), TbadkApplication.getInst().getSkinType());
                SkinManager.setBackgroundResource(this.f61569d, R.color.common_color_10262);
            }
            BdExpandListView bdExpandListView = this.f61571f;
            if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f61572g) == null) {
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
            d.a.q0.h3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            d.a.q0.h3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void j(BdExpandListView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f61571f.setExpandListRefreshListener(bVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f61568c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f61567b, R.color.CAM_X0201);
            String string = this.f61566a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f61566a.setNetRefreshViewTopMargin(m);
            this.f61566a.showNetRefreshView(this.f61567b, string, false);
        }
    }

    public void l(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dressItemData) == null) {
            this.f61574i = dressItemData;
            if (dressItemData == null) {
                k();
                return;
            }
            e();
            if (this.f61570e == null) {
                i iVar = new i(this.f61566a);
                this.f61570e = iVar;
                iVar.e(dressItemData);
                this.f61571f.addHeaderView(this.f61570e.b());
                this.f61570e.d();
                this.f61571f.setExpandView(this.f61570e.b(), this.f61566a.getResources().getDimensionPixelSize(R.dimen.ds400));
                g gVar = new g(this.f61566a.getPageContext(), dressItemData);
                this.f61572g = gVar;
                this.f61571f.setAdapter((ListAdapter) gVar);
                i();
                this.f61566a.registerListener(this.l);
            }
            this.f61573h.setDressData(this.f61574i);
            this.f61573h.setOnClickListener(this.k);
            m();
        }
    }

    public final void m() {
        DressItemData dressItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dressItemData = this.f61574i) == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.f61574i.getActivityFinish();
        this.f61573h.setFontSize(l.g(this.f61566a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f61573h.b(0, 0.0f, this.f61574i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f61573h.b(9, 0.0f, this.f61574i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
