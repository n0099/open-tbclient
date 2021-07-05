package d.a.s0.z2.e;

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
import d.a.c.a.d;
import d.a.c.a.f;
/* loaded from: classes9.dex */
public class a extends d<PrivacyMarkActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f<?> f69880a;

    /* renamed from: b  reason: collision with root package name */
    public View f69881b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f69882c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f69883d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f69884e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f69885f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f69886g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f69887h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f69888i;
    public boolean j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: d.a.s0.z2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1907a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f69889e;

        public C1907a(a aVar) {
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
            this.f69889e = aVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
                if (view == this.f69889e.f69885f) {
                    this.f69889e.k = switchState == BdSwitchView.SwitchState.ON;
                    this.f69889e.f69880a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == this.f69889e.f69888i) {
                    this.f69889e.j = switchState == BdSwitchView.SwitchState.ON;
                    this.f69889e.f69880a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != this.f69889e.f69885f ? 2 : 1));
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
        this.l = new C1907a(this);
        this.f69880a = fVar;
        k(fVar.getPageActivity(), i2);
        l();
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69881b : (View) invokeV.objValue;
    }

    public final void k(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
            this.f69881b = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            this.f69882c = navigationBar;
            navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
            this.f69882c.showBottomLine();
            this.f69882c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f69883d = (TextView) this.f69881b.findViewById(R.id.inside_text);
            this.f69884e = (TextView) this.f69881b.findViewById(R.id.inside_desc);
            this.f69885f = (BdSwitchView) this.f69881b.findViewById(R.id.inside_switch);
            this.f69886g = (TextView) this.f69881b.findViewById(R.id.outside_text);
            this.f69887h = (TextView) this.f69881b.findViewById(R.id.outside_desc);
            this.f69888i = (BdSwitchView) this.f69881b.findViewById(R.id.outside_switch);
            this.f69883d.setText(R.string.mark_show_inside);
            this.f69884e.setText(R.string.mark_show_everywhere);
            this.f69886g.setText(R.string.mark_show_outside);
            this.f69887h.setText(R.string.mark_show_somewhere);
            int i3 = i2 & 3;
            int i4 = (i2 >> 2) & 3;
            if (i3 == 3) {
                this.f69888i.h();
            } else {
                this.f69888i.k();
            }
            if (i4 == 3) {
                this.f69885f.h();
            } else {
                this.f69885f.k();
            }
            this.j = i3 != 3;
            this.k = i4 != 3;
            this.f69885f.setOnSwitchStateChangeListener(this.l);
            this.f69888i.setOnSwitchStateChangeListener(this.l);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f69883d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f69884e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f69886g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f69887h, R.color.CAM_X0109);
            this.f69882c.onChangeSkinType(this.f69880a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = !this.k;
            this.k = z;
            if (z) {
                this.f69885f.k();
            } else {
                this.f69885f.h();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = !this.j;
            this.j = z;
            if (z) {
                this.f69888i.k();
            } else {
                this.f69888i.h();
            }
        }
    }
}
