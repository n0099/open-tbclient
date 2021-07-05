package d.a.s0.z2.c;

import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.AboutActivity;
import com.baidu.tieba.setting.more.SettingTextTestNewView;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
/* loaded from: classes9.dex */
public class a extends d.a.c.a.d<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AboutActivity f69781a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f69782b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f69783c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f69784d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f69785e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextTestNewView f69786f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f69787g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f69788h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f69789i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public TbSettingTextTipView l;
    public TextView m;
    public ProgressBar n;

    /* renamed from: d.a.s0.z2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1903a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f69790e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f69791f;

        public View$OnClickListenerC1903a(a aVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69791f = aVar;
            this.f69790e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f69791f.f69789i) {
                    UrlManager.getInstance().dealOneLink(this.f69791f.f69781a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == this.f69791f.j) {
                    UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f69791f.f69781a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                    TbSingleton.getInstance().needRefreshForumSquare = true;
                } else if (view != this.f69791f.k) {
                    if (view != this.f69791f.f69786f) {
                        if (view != this.f69791f.f69788h) {
                            if (view != this.f69791f.f69787g) {
                                if (view == this.f69791f.l) {
                                    UrlManager.getInstance().dealOneLink(this.f69791f.f69781a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/thirdparty-sdk.html"});
                                    return;
                                }
                                return;
                            }
                            this.f69790e.a(4);
                            System.arraycopy(this.f69791f.f69782b, 1, this.f69791f.f69782b, 0, this.f69791f.f69782b.length - 1);
                            this.f69791f.f69782b[this.f69791f.f69782b.length - 1] = SystemClock.uptimeMillis();
                            if (this.f69791f.f69782b[0] >= this.f69791f.f69782b[this.f69791f.f69782b.length - 1] - 2000) {
                                this.f69791f.f69782b = new long[5];
                                this.f69790e.a(6);
                                this.f69791f.t();
                                return;
                            }
                            return;
                        }
                        this.f69790e.a(2);
                        return;
                    }
                    this.f69790e.a(1);
                } else if (CurrencySwitchUtil.isYyIsConvert()) {
                    UrlManager.getInstance().dealOneLink(this.f69791f.f69781a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/yy/agreement.html"});
                } else {
                    UrlManager.getInstance().dealOneLink(this.f69791f.f69781a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f69792e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f69793f;

        public b(a aVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69793f = aVar;
            this.f69792e = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view == this.f69793f.f69787g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    this.f69792e.a(5);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aboutActivity, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69782b = new long[5];
        this.f69781a = aboutActivity;
        s();
        r(dVar);
    }

    public void p() {
        ProgressBar progressBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (progressBar = this.n) == null) {
            return;
        }
        progressBar.setVisibility(0);
    }

    public void q() {
        ProgressBar progressBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (progressBar = this.n) == null) {
            return;
        }
        progressBar.setVisibility(8);
    }

    public final void r(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            View$OnClickListenerC1903a view$OnClickListenerC1903a = new View$OnClickListenerC1903a(this, dVar);
            b bVar = new b(this, dVar);
            this.f69786f.setOnClickListener(view$OnClickListenerC1903a);
            this.f69788h.setOnClickListener(view$OnClickListenerC1903a);
            this.f69789i.setOnClickListener(view$OnClickListenerC1903a);
            this.j.setOnClickListener(view$OnClickListenerC1903a);
            this.k.setOnClickListener(view$OnClickListenerC1903a);
            this.l.setOnClickListener(view$OnClickListenerC1903a);
            this.f69787g.setOnClickListener(view$OnClickListenerC1903a);
            this.f69787g.setOnLongClickListener(bVar);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f69781a.setContentView(R.layout.about_activity);
            this.f69784d = (RelativeLayout) this.f69781a.findViewById(R.id.parent);
            this.f69787g = (ImageView) this.f69781a.findViewById(R.id.image_logo);
            NavigationBar navigationBar = (NavigationBar) this.f69781a.findViewById(R.id.view_navigation_bar);
            this.f69783c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f69783c.setTitleText(this.f69781a.getPageContext().getString(R.string.version_info));
            this.f69785e = (TextView) this.f69781a.findViewById(R.id.text_versioninfo);
            this.f69786f = (SettingTextTestNewView) this.f69781a.findViewById(R.id.about_version_update);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f69781a.findViewById(R.id.about_guide);
            this.f69788h = tbSettingTextTipView;
            tbSettingTextTipView.c();
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f69781a.findViewById(R.id.tieba_protocol_text);
            this.f69789i = tbSettingTextTipView2;
            tbSettingTextTipView2.c();
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f69781a.findViewById(R.id.tieba_privacy_text);
            this.j = tbSettingTextTipView3;
            tbSettingTextTipView3.c();
            this.k = (TbSettingTextTipView) this.f69781a.findViewById(R.id.tieba_tdou_use_introduce);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.k.setText(R.string.ybean_use_introduce);
            } else {
                this.k.setText(R.string.tdou_use_introduce);
            }
            this.k.c();
            TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.f69781a.findViewById(R.id.thirdparty_data_share);
            this.l = tbSettingTextTipView4;
            tbSettingTextTipView4.c();
            this.n = (ProgressBar) this.f69781a.findViewById(R.id.about_progress);
            String version = TbConfig.getVersion();
            if (TbConfig.getVersionType() == 1 && !k.isEmpty(TbConfig.getSubVersion())) {
                version = version + "." + TbConfig.getSubVersion();
            }
            this.f69785e.setText(this.f69781a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.f69781a.getPageContext().getString(R.string.setting_version_text) + " " + version);
            this.m = (TextView) this.f69781a.findViewById(R.id.text_version_protoco);
            w(TbadkCoreApplication.getInst().getSkinType());
            if (MessageManager.getInstance().findTask(2015001) == null) {
                this.f69788h.setVisibility(8);
            }
            if (d.a.r0.r.d0.b.j().g("debug_plugin_switcher", false)) {
                v(0);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void u() {
        SettingTextTestNewView settingTextTestNewView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (settingTextTestNewView = this.f69786f) == null) {
            return;
        }
        settingTextTestNewView.i();
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f69781a.findViewById(R.id.line0).setVisibility(i2);
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f69784d, R.color.CAM_X0201);
            this.f69783c.onChangeSkinType(getPageContext(), i2);
            this.f69781a.getLayoutMode().k(i2 == 1);
            this.f69781a.getLayoutMode().j(this.f69784d);
            u();
        }
    }
}
