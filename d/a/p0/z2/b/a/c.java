package d.a.p0.z2.b.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.im.more.SecretSettingActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.d;
import d.a.c.a.f;
/* loaded from: classes8.dex */
public class c extends d<SecretSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NavigationBar f66574a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f66575b;

    /* renamed from: c  reason: collision with root package name */
    public View f66576c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f66577d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f66578e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f66579f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f66580g;

    /* renamed from: h  reason: collision with root package name */
    public View f66581h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f66582i;
    public TbSettingTextTipView j;
    public SecretSettingActivity k;
    public View l;
    public String[] m;
    public TbSettingTextTipView n;
    public TbSettingTextTipView o;
    public View.OnClickListener p;
    public b q;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f66583e;

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
            this.f66583e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f66583e.q == null) {
                return;
            }
            if (view == this.f66583e.f66576c) {
                this.f66583e.q.onBackPressed();
            } else if (view == this.f66583e.f66577d) {
                this.f66583e.q.h();
            } else if (view == this.f66583e.f66578e) {
                this.f66583e.q.g();
            } else if (view == this.f66583e.f66580g) {
                this.f66583e.q.c();
            } else if (view == this.f66583e.j) {
                this.f66583e.q.e();
            } else if (view == this.f66583e.f66582i) {
                this.f66583e.q.a();
            } else if (view == this.f66583e.n) {
                this.f66583e.q.f();
            } else if (view == this.f66583e.f66579f) {
                this.f66583e.q.d();
            } else if (view == this.f66583e.o) {
                this.f66583e.q.b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();

        void onBackPressed();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {secretSettingActivity};
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
        this.f66574a = null;
        this.p = new a(this);
        this.k = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.secret_setting_activity);
        o(secretSettingActivity);
    }

    public final void o(SecretSettingActivity secretSettingActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, secretSettingActivity) == null) {
            this.f66575b = (LinearLayout) secretSettingActivity.findViewById(R.id.parent);
            NavigationBar navigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.view_navigation_bar);
            this.f66574a = navigationBar;
            this.f66576c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f66574a.setTitleText(secretSettingActivity.getPageContext().getString(R.string.secretSetting));
            this.f66577d = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.black_address_list);
            this.f66578e = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_bar);
            this.f66579f = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.mark_setting);
            this.j = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_group);
            this.f66580g = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_attention_live);
            this.f66582i = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.thread_reply_setting);
            this.f66581h = secretSettingActivity.findViewById(R.id.container_thread_reply_setting);
            this.f66576c.setOnClickListener(this.p);
            this.f66577d.setOnClickListener(this.p);
            this.j.setOnClickListener(this.p);
            this.f66578e.setOnClickListener(this.p);
            this.f66579f.setOnClickListener(this.p);
            this.f66580g.setOnClickListener(this.p);
            this.f66582i.setOnClickListener(this.p);
            this.l = this.k.findViewById(R.id.privacy_setting_container);
            this.m = this.k.getResources().getStringArray(R.array.privacy_setting_config);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_permission);
            this.n = tbSettingTextTipView;
            tbSettingTextTipView.setOnClickListener(this.p);
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.privacy_forbidden_forum);
            this.o = tbSettingTextTipView2;
            tbSettingTextTipView2.setOnClickListener(this.p);
            UserData b2 = d.a.o0.z.b.a().b();
            if (b2 != null && b2.getBazhuGradeData() != null && !StringUtils.isNull(b2.getBazhuGradeData().getDesc()) && !StringUtils.isNull(b2.getBazhuGradeData().getLevel())) {
                this.f66579f.setVisibility(0);
            } else {
                this.f66579f.setVisibility(8);
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.k.getLayoutMode().k(i2 == 1);
            this.k.getLayoutMode().j(this.f66575b);
            this.f66574a.onChangeSkinType(this.k.getPageContext(), i2);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f66577d.g();
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.q = bVar;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
            }
            if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
                this.f66581h.setVisibility(0);
                this.f66582i.setVisibility(0);
                return;
            }
            this.f66581h.setVisibility(8);
            this.f66582i.setVisibility(8);
        }
    }

    public void s(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            if (i3 == 3 && i2 == 3) {
                this.f66579f.setTip(this.k.getString(R.string.mark_tip_no));
            } else if (i3 == 3) {
                this.f66579f.setTip(this.k.getString(R.string.mark_tip_inside));
            } else if (i2 == 3) {
                this.f66579f.setTip(this.k.getString(R.string.mark_tip_outside));
            } else {
                this.f66579f.setTip(this.k.getString(R.string.mark_tip_all));
            }
        }
    }

    public void t(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            int i3 = i2 - 1;
            String[] strArr = this.m;
            if (strArr == null || i3 >= strArr.length || i3 < 0) {
                return;
            }
            if (TextUtils.equals(str, "like")) {
                this.f66578e.setTip(this.m[i3]);
            } else if (TextUtils.equals(str, "group")) {
                this.j.setTip(this.m[i3]);
            } else if (TextUtils.equals(str, "live")) {
                this.f66580g.setTip(this.m[i3]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i3 == 0) {
                    this.f66582i.setTip(this.k.getString(R.string.all_person));
                } else {
                    this.f66582i.setTip(this.m[i3]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                s(d.a.o0.r.d0.b.j().k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), d.a.o0.r.d0.b.j().k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void u(d.a.p0.z2.b.a.a aVar) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null || (strArr = this.m) == null) {
            return;
        }
        int length = strArr.length;
        int d2 = aVar.d() - 1;
        if (d2 < length && d2 >= 0) {
            this.j.setTip(this.m[d2]);
        }
        int c2 = aVar.c() - 1;
        if (c2 < length && c2 >= 0) {
            this.f66578e.setTip(this.m[c2]);
        }
        int e2 = aVar.e() - 1;
        if (e2 < length && e2 >= 0) {
            this.f66580g.setTip(this.m[e2]);
        }
        int g2 = aVar.g() - 1;
        if (g2 < length && g2 >= 0) {
            if (g2 == 0) {
                this.f66582i.setTip(this.k.getString(R.string.all_person));
            } else {
                this.f66582i.setTip(this.m[g2]);
            }
        }
        s(aVar.a(), aVar.b());
    }
}
