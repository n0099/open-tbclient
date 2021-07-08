package d.a.p0.n3.e;

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
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackgroundPreviewActivity f60952a;

    /* renamed from: b  reason: collision with root package name */
    public View f60953b;

    /* renamed from: c  reason: collision with root package name */
    public View f60954c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f60955d;

    /* renamed from: e  reason: collision with root package name */
    public i f60956e;

    /* renamed from: f  reason: collision with root package name */
    public BdExpandListView f60957f;

    /* renamed from: g  reason: collision with root package name */
    public g f60958g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f60959h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f60960i;
    public d j;
    public View.OnClickListener k;
    public d.a.c.c.g.a l;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f60961e;

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
            this.f60961e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f60961e.f60960i == null || this.f60961e.j == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c10284"));
            if (this.f60961e.f60960i.getInUse()) {
                d.a.o0.r.a0.b.e(this.f60961e.f60952a.getPageContext().getPageActivity(), 8);
            } else {
                this.f60961e.j.e(this.f60961e.f60960i, true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f60962a;

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
            this.f60962a = jVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    TiebaStatic.log(new StatisticItem("c10286").param("obj_id", this.f60962a.f60960i.getPropsId()).param("obj_type", this.f60962a.f60960i.getFreeUserLevel()));
                    this.f60962a.f60960i.setInUse(true);
                    this.f60962a.m();
                    d.a.o0.r.d0.b j = d.a.o0.r.d0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), this.f60962a.f60960i.getPropsId());
                    return;
                }
                int i2 = d.a.p0.n3.c.f60869b;
                if (responsedMessage.getError() == d.a.p0.n3.c.f60870c) {
                    i2 = d.a.p0.n3.c.f60868a;
                }
                this.f60962a.j.d(i2, responsedMessage.getErrorString(), this.f60962a.f60960i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-970450565, "Ld/a/p0/n3/e/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-970450565, "Ld/a/p0/n3/e/j;");
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
        this.f60952a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.background_preview, (ViewGroup) null);
        this.f60953b = inflate;
        this.f60952a.setContentView(inflate);
        this.f60954c = this.f60953b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f60953b.findViewById(R.id.view_navigation_bar);
        this.f60955d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60955d.showBottomLine(false);
        this.f60957f = (BdExpandListView) this.f60952a.findViewById(R.id.personcenter_list);
        this.f60959h = (SkinProgressView) this.f60953b.findViewById(R.id.view_bg_use);
        d dVar = new d(backgroundPreviewActivity.getPageContext(), this.f60952a.getUniqueId());
        this.j = dVar;
        dVar.c(this.f60952a.getFrom());
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.f60953b, R.color.CAM_X0204);
            this.f60952a.hideNetRefreshView(this.f60953b);
            this.f60954c.setVisibility(0);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60953b : (View) invokeV.objValue;
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.o0.s0.a.a(this.f60952a.getPageContext(), this.f60953b);
            NavigationBar navigationBar = this.f60955d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f60952a.getPageContext(), TbadkApplication.getInst().getSkinType());
                SkinManager.setBackgroundResource(this.f60955d, R.color.common_color_10262);
            }
            BdExpandListView bdExpandListView = this.f60957f;
            if (bdExpandListView == null || bdExpandListView.getVisibility() != 0 || (gVar = this.f60958g) == null) {
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
            d.a.p0.h3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            d.a.p0.h3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void j(BdExpandListView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f60957f.setExpandListRefreshListener(bVar);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f60954c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f60953b, R.color.CAM_X0201);
            String string = this.f60952a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f60952a.setNetRefreshViewTopMargin(m);
            this.f60952a.showNetRefreshView(this.f60953b, string, false);
        }
    }

    public void l(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dressItemData) == null) {
            this.f60960i = dressItemData;
            if (dressItemData == null) {
                k();
                return;
            }
            e();
            if (this.f60956e == null) {
                i iVar = new i(this.f60952a);
                this.f60956e = iVar;
                iVar.e(dressItemData);
                this.f60957f.addHeaderView(this.f60956e.b());
                this.f60956e.d();
                this.f60957f.setExpandView(this.f60956e.b(), this.f60952a.getResources().getDimensionPixelSize(R.dimen.ds400));
                g gVar = new g(this.f60952a.getPageContext(), dressItemData);
                this.f60958g = gVar;
                this.f60957f.setAdapter((ListAdapter) gVar);
                i();
                this.f60952a.registerListener(this.l);
            }
            this.f60959h.setDressData(this.f60960i);
            this.f60959h.setOnClickListener(this.k);
            m();
        }
    }

    public final void m() {
        DressItemData dressItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dressItemData = this.f60960i) == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.f60960i.getActivityFinish();
        this.f60959h.setFontSize(l.g(this.f60952a.getPageContext().getPageActivity(), R.dimen.fontsize32));
        if (inUse) {
            this.f60959h.b(0, 0.0f, this.f60960i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.f60959h.b(9, 0.0f, this.f60960i.getFreeUserLevel(), activityFinish, 2);
        }
    }
}
