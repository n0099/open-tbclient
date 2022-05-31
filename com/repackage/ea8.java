package com.repackage;

import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.AboutActivity;
import com.baidu.tieba.setting.more.SettingTextTestNewView;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class ea8 extends z8<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AboutActivity a;
    public long[] b;
    public NavigationBar c;
    public RelativeLayout d;
    public TextView e;
    public SettingTextTestNewView f;
    public ImageView g;
    public TbSettingTextTipView h;
    public TbSettingTextTipView i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public TbSettingTextTipView l;
    public TextView m;
    public ProgressBar n;

    /* loaded from: classes5.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ea8 ea8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                ai.a(ka8.a(view2.getContext()));
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha8 a;
        public final /* synthetic */ ea8 b;

        public b(ea8 ea8Var, ha8 ha8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea8Var, ha8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ea8Var;
            this.a = ha8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.b.i) {
                    UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
                } else if (view2 == this.b.j) {
                    UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.b.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
                    TbSingleton.getInstance().needRefreshForumSquare = true;
                } else if (view2 != this.b.k) {
                    if (view2 != this.b.f) {
                        if (view2 != this.b.h) {
                            if (view2 != this.b.g) {
                                if (view2 == this.b.l) {
                                    UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/thirdparty-sdk.html"});
                                    return;
                                }
                                return;
                            }
                            this.a.a(4);
                            System.arraycopy(this.b.b, 1, this.b.b, 0, this.b.b.length - 1);
                            this.b.b[this.b.b.length - 1] = SystemClock.uptimeMillis();
                            if (this.b.b[0] >= this.b.b[this.b.b.length - 1] - 2000) {
                                this.b.b = new long[5];
                                this.a.a(6);
                                this.b.u();
                                return;
                            }
                            return;
                        }
                        this.a.a(2);
                        return;
                    }
                    this.a.a(1);
                } else if (CurrencySwitchUtil.isYyIsConvert()) {
                    UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/yy/agreement.html"});
                } else {
                    UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha8 a;
        public final /* synthetic */ ea8 b;

        public c(ea8 ea8Var, ha8 ha8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ea8Var, ha8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ea8Var;
            this.a = ha8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (view2 == this.b.g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    this.a.a(5);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ea8(AboutActivity aboutActivity, ha8 ha8Var) {
        super(aboutActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aboutActivity, ha8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new long[5];
        this.a = aboutActivity;
        t();
        s(ha8Var);
    }

    public void q() {
        ProgressBar progressBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (progressBar = this.n) == null) {
            return;
        }
        progressBar.setVisibility(0);
    }

    public void r() {
        ProgressBar progressBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (progressBar = this.n) == null) {
            return;
        }
        progressBar.setVisibility(8);
    }

    public final void s(ha8 ha8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ha8Var) == null) {
            b bVar = new b(this, ha8Var);
            c cVar = new c(this, ha8Var);
            this.f.setOnClickListener(bVar);
            this.h.setOnClickListener(bVar);
            this.i.setOnClickListener(bVar);
            this.j.setOnClickListener(bVar);
            this.k.setOnClickListener(bVar);
            this.l.setOnClickListener(bVar);
            this.g.setOnClickListener(bVar);
            this.g.setOnLongClickListener(cVar);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d001c);
            this.d = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09161e);
            this.g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090e42);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f0923a2);
            this.c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1504));
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091f40);
            this.f = (SettingTextTestNewView) this.a.findViewById(R.id.obfuscated_res_0x7f090022);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090020);
            this.h = tbSettingTextTipView;
            tbSettingTextTipView.c();
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091fdb);
            this.i = tbSettingTextTipView2;
            tbSettingTextTipView2.c();
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091fda);
            this.j = tbSettingTextTipView3;
            tbSettingTextTipView3.c();
            this.k = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091fdc);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.k.setText(R.string.obfuscated_res_0x7f0f15f8);
            } else {
                this.k.setText(R.string.obfuscated_res_0x7f0f13b9);
            }
            this.k.c();
            TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091f72);
            this.l = tbSettingTextTipView4;
            tbSettingTextTipView4.c();
            this.n = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f090021);
            String version = TbConfig.getVersion();
            if (TbConfig.getVersionType() == 1 && !ki.isEmpty(TbConfig.getSubVersion())) {
                version = version + "." + TbConfig.getSubVersion();
            }
            String str = this.a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1135) + " " + version;
            if (TbadkCoreApplication.getInst().isDebugMode()) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("(");
                sb.append(zh.a() ? WebKitFactory.OS_64 : "32");
                sb.append(zh.b() ? "s" : "u");
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                String sb2 = sb.toString();
                SpannableString spannableString = new SpannableString(sb2);
                spannableString.setSpan(new AbsoluteSizeSpan(10, true), sb2.length() - 5, sb2.length(), 33);
                this.e.setText(spannableString);
            } else {
                this.e.setText(str);
            }
            this.m = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091f3f);
            x(TbadkCoreApplication.getInst().getSkinType());
            this.h.setVisibility(8);
            if (ys4.k().h("debug_plugin_switcher", false)) {
                w(0);
            }
            this.m.setOnLongClickListener(new a(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && ul4.f()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a, "ToolsSwitchPage", new HashMap())));
        }
    }

    public void v() {
        SettingTextTestNewView settingTextTestNewView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (settingTextTestNewView = this.f) == null) {
            return;
        }
        settingTextTestNewView.i();
    }

    public final void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a.findViewById(R.id.obfuscated_res_0x7f09121b).setVisibility(i);
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            this.c.onChangeSkinType(getPageContext(), i);
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.d);
            v();
        }
    }
}
