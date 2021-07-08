package d.a.p0.z2.c;

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
/* loaded from: classes8.dex */
public class a extends d.a.c.a.d<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AboutActivity f66584a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f66585b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f66586c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f66587d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66588e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextTestNewView f66589f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f66590g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f66591h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f66592i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public TbSettingTextTipView l;
    public TextView m;
    public ProgressBar n;

    /* renamed from: d.a.p0.z2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1862a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f66593e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f66594f;

        public View$OnClickListenerC1862a(a aVar, d dVar) {
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
            this.f66594f = aVar;
            this.f66593e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f66594f.f66592i) {
                    UrlManager.getInstance().dealOneLink(this.f66594f.f66584a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == this.f66594f.j) {
                    UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f66594f.f66584a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                    TbSingleton.getInstance().needRefreshForumSquare = true;
                } else if (view != this.f66594f.k) {
                    if (view != this.f66594f.f66589f) {
                        if (view != this.f66594f.f66591h) {
                            if (view != this.f66594f.f66590g) {
                                if (view == this.f66594f.l) {
                                    UrlManager.getInstance().dealOneLink(this.f66594f.f66584a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/thirdparty-sdk.html"});
                                    return;
                                }
                                return;
                            }
                            this.f66593e.a(4);
                            System.arraycopy(this.f66594f.f66585b, 1, this.f66594f.f66585b, 0, this.f66594f.f66585b.length - 1);
                            this.f66594f.f66585b[this.f66594f.f66585b.length - 1] = SystemClock.uptimeMillis();
                            if (this.f66594f.f66585b[0] >= this.f66594f.f66585b[this.f66594f.f66585b.length - 1] - 2000) {
                                this.f66594f.f66585b = new long[5];
                                this.f66593e.a(6);
                                this.f66594f.t();
                                return;
                            }
                            return;
                        }
                        this.f66593e.a(2);
                        return;
                    }
                    this.f66593e.a(1);
                } else if (CurrencySwitchUtil.isYyIsConvert()) {
                    UrlManager.getInstance().dealOneLink(this.f66594f.f66584a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/yy/agreement.html"});
                } else {
                    UrlManager.getInstance().dealOneLink(this.f66594f.f66584a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f66595e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f66596f;

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
            this.f66596f = aVar;
            this.f66595e = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view == this.f66596f.f66590g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    this.f66595e.a(5);
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
        this.f66585b = new long[5];
        this.f66584a = aboutActivity;
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
            View$OnClickListenerC1862a view$OnClickListenerC1862a = new View$OnClickListenerC1862a(this, dVar);
            b bVar = new b(this, dVar);
            this.f66589f.setOnClickListener(view$OnClickListenerC1862a);
            this.f66591h.setOnClickListener(view$OnClickListenerC1862a);
            this.f66592i.setOnClickListener(view$OnClickListenerC1862a);
            this.j.setOnClickListener(view$OnClickListenerC1862a);
            this.k.setOnClickListener(view$OnClickListenerC1862a);
            this.l.setOnClickListener(view$OnClickListenerC1862a);
            this.f66590g.setOnClickListener(view$OnClickListenerC1862a);
            this.f66590g.setOnLongClickListener(bVar);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f66584a.setContentView(R.layout.about_activity);
            this.f66587d = (RelativeLayout) this.f66584a.findViewById(R.id.parent);
            this.f66590g = (ImageView) this.f66584a.findViewById(R.id.image_logo);
            NavigationBar navigationBar = (NavigationBar) this.f66584a.findViewById(R.id.view_navigation_bar);
            this.f66586c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f66586c.setTitleText(this.f66584a.getPageContext().getString(R.string.version_info));
            this.f66588e = (TextView) this.f66584a.findViewById(R.id.text_versioninfo);
            this.f66589f = (SettingTextTestNewView) this.f66584a.findViewById(R.id.about_version_update);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f66584a.findViewById(R.id.about_guide);
            this.f66591h = tbSettingTextTipView;
            tbSettingTextTipView.c();
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f66584a.findViewById(R.id.tieba_protocol_text);
            this.f66592i = tbSettingTextTipView2;
            tbSettingTextTipView2.c();
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f66584a.findViewById(R.id.tieba_privacy_text);
            this.j = tbSettingTextTipView3;
            tbSettingTextTipView3.c();
            this.k = (TbSettingTextTipView) this.f66584a.findViewById(R.id.tieba_tdou_use_introduce);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.k.setText(R.string.ybean_use_introduce);
            } else {
                this.k.setText(R.string.tdou_use_introduce);
            }
            this.k.c();
            TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.f66584a.findViewById(R.id.thirdparty_data_share);
            this.l = tbSettingTextTipView4;
            tbSettingTextTipView4.c();
            this.n = (ProgressBar) this.f66584a.findViewById(R.id.about_progress);
            String version = TbConfig.getVersion();
            if (TbConfig.getVersionType() == 1 && !k.isEmpty(TbConfig.getSubVersion())) {
                version = version + "." + TbConfig.getSubVersion();
            }
            this.f66588e.setText(this.f66584a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.f66584a.getPageContext().getString(R.string.setting_version_text) + " " + version);
            this.m = (TextView) this.f66584a.findViewById(R.id.text_version_protoco);
            w(TbadkCoreApplication.getInst().getSkinType());
            if (MessageManager.getInstance().findTask(2015001) == null) {
                this.f66591h.setVisibility(8);
            }
            if (d.a.o0.r.d0.b.j().g("debug_plugin_switcher", false)) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (settingTextTestNewView = this.f66589f) == null) {
            return;
        }
        settingTextTestNewView.i();
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f66584a.findViewById(R.id.line0).setVisibility(i2);
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f66587d, R.color.CAM_X0201);
            this.f66586c.onChangeSkinType(getPageContext(), i2);
            this.f66584a.getLayoutMode().k(i2 == 1);
            this.f66584a.getLayoutMode().j(this.f66587d);
            u();
        }
    }
}
