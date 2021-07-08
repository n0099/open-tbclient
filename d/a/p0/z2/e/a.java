package d.a.p0.z2.e;

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
/* loaded from: classes8.dex */
public class a extends d<PrivacyMarkActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f<?> f66683a;

    /* renamed from: b  reason: collision with root package name */
    public View f66684b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f66685c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f66686d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66687e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f66688f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66689g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f66690h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwitchView f66691i;
    public boolean j;
    public boolean k;
    public BdSwitchView.b l;

    /* renamed from: d.a.p0.z2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1866a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66692e;

        public C1866a(a aVar) {
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
            this.f66692e = aVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
                if (view == this.f66692e.f66688f) {
                    this.f66692e.k = switchState == BdSwitchView.SwitchState.ON;
                    this.f66692e.f66683a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                } else if (view == this.f66692e.f66691i) {
                    this.f66692e.j = switchState == BdSwitchView.SwitchState.ON;
                    this.f66692e.f66683a.sendMessage(new PrivacySettingMessage(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE, switchState == BdSwitchView.SwitchState.ON ? 1 : 3));
                }
                TiebaStatic.log(new StatisticItem("c14003").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", view != this.f66692e.f66688f ? 2 : 1));
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
        this.l = new C1866a(this);
        this.f66683a = fVar;
        k(fVar.getPageActivity(), i2);
        l();
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66684b : (View) invokeV.objValue;
    }

    public final void k(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.privacy_mark_activity, (ViewGroup) null);
            this.f66684b = inflate;
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            this.f66685c = navigationBar;
            navigationBar.setCenterTextTitle(context.getString(R.string.privacy_mark_setting));
            this.f66685c.showBottomLine();
            this.f66685c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f66686d = (TextView) this.f66684b.findViewById(R.id.inside_text);
            this.f66687e = (TextView) this.f66684b.findViewById(R.id.inside_desc);
            this.f66688f = (BdSwitchView) this.f66684b.findViewById(R.id.inside_switch);
            this.f66689g = (TextView) this.f66684b.findViewById(R.id.outside_text);
            this.f66690h = (TextView) this.f66684b.findViewById(R.id.outside_desc);
            this.f66691i = (BdSwitchView) this.f66684b.findViewById(R.id.outside_switch);
            this.f66686d.setText(R.string.mark_show_inside);
            this.f66687e.setText(R.string.mark_show_everywhere);
            this.f66689g.setText(R.string.mark_show_outside);
            this.f66690h.setText(R.string.mark_show_somewhere);
            int i3 = i2 & 3;
            int i4 = (i2 >> 2) & 3;
            if (i3 == 3) {
                this.f66691i.h();
            } else {
                this.f66691i.k();
            }
            if (i4 == 3) {
                this.f66688f.h();
            } else {
                this.f66688f.k();
            }
            this.j = i3 != 3;
            this.k = i4 != 3;
            this.f66688f.setOnSwitchStateChangeListener(this.l);
            this.f66691i.setOnSwitchStateChangeListener(this.l);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f66686d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f66687e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f66689g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f66690h, R.color.CAM_X0109);
            this.f66685c.onChangeSkinType(this.f66683a, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean z = !this.k;
            this.k = z;
            if (z) {
                this.f66688f.k();
            } else {
                this.f66688f.h();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = !this.j;
            this.j = z;
            if (z) {
                this.f66691i.k();
            } else {
                this.f66691i.h();
            }
        }
    }
}
