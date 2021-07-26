package d.a.q0.z2.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.setting.privacy.PrivacyMarkActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.d;
import d.a.d.a.f;
/* loaded from: classes8.dex */
public class a extends d<PrivacyMarkActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f<?> f67361a;

    /* renamed from: b  reason: collision with root package name */
    public View f67362b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f67363c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f67364d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f67365e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f67366f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f67367g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f67368h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f67369i;
    public boolean j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: d.a.q0.z2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1871a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f67370e;

        public C1871a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67370e = aVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
                if (view == this.f67370e.f67366f) {
                    this.f67370e.k = switchState == BdSwitchView.SwitchState.ON;
                    this.f67370e.f67361a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == this.f67370e.f67369i) {
                    this.f67370e.j = switchState == BdSwitchView.SwitchState.ON;
                    this.f67370e.f67361a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != this.f67370e.f67366f ? 2 : 1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f<PrivacyMarkActivity> fVar, int i2) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new C1871a(this);
        this.f67361a = fVar;
        k(fVar.getPageActivity(), i2);
        l();
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67362b : (View) invokeV.objValue;
    }

    public final void k(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
            this.f67362b = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            this.f67363c = navigationBar;
            navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
            this.f67363c.showBottomLine();
            this.f67363c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f67364d = (TextView) this.f67362b.findViewById(R.id.inside_text);
            this.f67365e = (TextView) this.f67362b.findViewById(R.id.inside_desc);
            this.f67366f = (BdSwitchView) this.f67362b.findViewById(R.id.inside_switch);
            this.f67367g = (TextView) this.f67362b.findViewById(R.id.outside_text);
            this.f67368h = (TextView) this.f67362b.findViewById(R.id.outside_desc);
            this.f67369i = (BdSwitchView) this.f67362b.findViewById(R.id.outside_switch);
            this.f67364d.setText(R.string.mark_show_inside);
            this.f67365e.setText(R.string.mark_show_everywhere);
            this.f67367g.setText(R.string.mark_show_outside);
            this.f67368h.setText(R.string.mark_show_somewhere);
            int i3 = i2 & 3;
            int i4 = (i2 >> 2) & 3;
            if (i3 == 3) {
                this.f67369i.h();
            } else {
                this.f67369i.k();
            }
            if (i4 == 3) {
                this.f67366f.h();
            } else {
                this.f67366f.k();
            }
            this.j = i3 != 3;
            this.k = i4 != 3;
            this.f67366f.setOnSwitchStateChangeListener(this.l);
            this.f67369i.setOnSwitchStateChangeListener(this.l);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f67364d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f67365e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f67367g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f67368h, R.color.CAM_X0109);
            this.f67363c.onChangeSkinType(this.f67361a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = !this.k;
            this.k = z;
            if (z) {
                this.f67366f.k();
            } else {
                this.f67366f.h();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = !this.j;
            this.j = z;
            if (z) {
                this.f67369i.k();
            } else {
                this.f67369i.h();
            }
        }
    }
}
