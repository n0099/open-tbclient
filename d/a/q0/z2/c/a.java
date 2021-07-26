package d.a.q0.z2.c;

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
import d.a.d.e.p.k;
/* loaded from: classes8.dex */
public class a extends d.a.d.a.d<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AboutActivity f67262a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f67263b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f67264c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f67265d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f67266e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextTestNewView f67267f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f67268g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f67269h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f67270i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public TbSettingTextTipView l;
    public TextView m;
    public ProgressBar n;

    /* renamed from: d.a.q0.z2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1867a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f67271e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f67272f;

        public View$OnClickListenerC1867a(a aVar, d dVar) {
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
            this.f67272f = aVar;
            this.f67271e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f67272f.f67270i) {
                    UrlManager.getInstance().dealOneLink(this.f67272f.f67262a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view == this.f67272f.j) {
                    UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f67272f.f67262a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                    TbSingleton.getInstance().needRefreshForumSquare = true;
                } else if (view != this.f67272f.k) {
                    if (view != this.f67272f.f67267f) {
                        if (view != this.f67272f.f67269h) {
                            if (view != this.f67272f.f67268g) {
                                if (view == this.f67272f.l) {
                                    UrlManager.getInstance().dealOneLink(this.f67272f.f67262a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/thirdparty-sdk.html"});
                                    return;
                                }
                                return;
                            }
                            this.f67271e.a(4);
                            System.arraycopy(this.f67272f.f67263b, 1, this.f67272f.f67263b, 0, this.f67272f.f67263b.length - 1);
                            this.f67272f.f67263b[this.f67272f.f67263b.length - 1] = SystemClock.uptimeMillis();
                            if (this.f67272f.f67263b[0] >= this.f67272f.f67263b[this.f67272f.f67263b.length - 1] - 2000) {
                                this.f67272f.f67263b = new long[5];
                                this.f67271e.a(6);
                                this.f67272f.t();
                                return;
                            }
                            return;
                        }
                        this.f67271e.a(2);
                        return;
                    }
                    this.f67271e.a(1);
                } else if (CurrencySwitchUtil.isYyIsConvert()) {
                    UrlManager.getInstance().dealOneLink(this.f67272f.f67262a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/yy/agreement.html"});
                } else {
                    UrlManager.getInstance().dealOneLink(this.f67272f.f67262a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f67273e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f67274f;

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
            this.f67274f = aVar;
            this.f67273e = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view == this.f67274f.f67268g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    this.f67273e.a(5);
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
                super((d.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67263b = new long[5];
        this.f67262a = aboutActivity;
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
            View$OnClickListenerC1867a view$OnClickListenerC1867a = new View$OnClickListenerC1867a(this, dVar);
            b bVar = new b(this, dVar);
            this.f67267f.setOnClickListener(view$OnClickListenerC1867a);
            this.f67269h.setOnClickListener(view$OnClickListenerC1867a);
            this.f67270i.setOnClickListener(view$OnClickListenerC1867a);
            this.j.setOnClickListener(view$OnClickListenerC1867a);
            this.k.setOnClickListener(view$OnClickListenerC1867a);
            this.l.setOnClickListener(view$OnClickListenerC1867a);
            this.f67268g.setOnClickListener(view$OnClickListenerC1867a);
            this.f67268g.setOnLongClickListener(bVar);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f67262a.setContentView(R.layout.about_activity);
            this.f67265d = (RelativeLayout) this.f67262a.findViewById(R.id.parent);
            this.f67268g = (ImageView) this.f67262a.findViewById(R.id.image_logo);
            NavigationBar navigationBar = (NavigationBar) this.f67262a.findViewById(R.id.view_navigation_bar);
            this.f67264c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f67264c.setTitleText(this.f67262a.getPageContext().getString(R.string.version_info));
            this.f67266e = (TextView) this.f67262a.findViewById(R.id.text_versioninfo);
            this.f67267f = (SettingTextTestNewView) this.f67262a.findViewById(R.id.about_version_update);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f67262a.findViewById(R.id.about_guide);
            this.f67269h = tbSettingTextTipView;
            tbSettingTextTipView.c();
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f67262a.findViewById(R.id.tieba_protocol_text);
            this.f67270i = tbSettingTextTipView2;
            tbSettingTextTipView2.c();
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f67262a.findViewById(R.id.tieba_privacy_text);
            this.j = tbSettingTextTipView3;
            tbSettingTextTipView3.c();
            this.k = (TbSettingTextTipView) this.f67262a.findViewById(R.id.tieba_tdou_use_introduce);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.k.setText(R.string.ybean_use_introduce);
            } else {
                this.k.setText(R.string.tdou_use_introduce);
            }
            this.k.c();
            TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.f67262a.findViewById(R.id.thirdparty_data_share);
            this.l = tbSettingTextTipView4;
            tbSettingTextTipView4.c();
            this.n = (ProgressBar) this.f67262a.findViewById(R.id.about_progress);
            String version = TbConfig.getVersion();
            if (TbConfig.getVersionType() == 1 && !k.isEmpty(TbConfig.getSubVersion())) {
                version = version + "." + TbConfig.getSubVersion();
            }
            this.f67266e.setText(this.f67262a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.f67262a.getPageContext().getString(R.string.setting_version_text) + " " + version);
            this.m = (TextView) this.f67262a.findViewById(R.id.text_version_protoco);
            w(TbadkCoreApplication.getInst().getSkinType());
            if (MessageManager.getInstance().findTask(2015001) == null) {
                this.f67269h.setVisibility(8);
            }
            if (d.a.p0.s.d0.b.j().g("debug_plugin_switcher", false)) {
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (settingTextTestNewView = this.f67267f) == null) {
            return;
        }
        settingTextTestNewView.i();
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f67262a.findViewById(R.id.line0).setVisibility(i2);
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f67265d, R.color.CAM_X0201);
            this.f67264c.onChangeSkinType(getPageContext(), i2);
            this.f67262a.getLayoutMode().k(i2 == 1);
            this.f67262a.getLayoutMode().j(this.f67265d);
            u();
        }
    }
}
