package d.a.p0.z2.c;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
import com.baidu.tieba.setting.more.TbSettingTextNewDotView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class h extends d.a.c.a.d<SystemHelpSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SystemHelpSettingActivity f66652a;

    /* renamed from: b  reason: collision with root package name */
    public View f66653b;

    /* renamed from: c  reason: collision with root package name */
    public TbSettingTextTipView f66654c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f66655d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwitchView f66656e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f66657f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextNewDotView f66658g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f66659h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f66660i;
    public NavigationBar j;
    public BdSwitchView.b k;

    /* loaded from: classes8.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f66661e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66661e = hVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) && view == this.f66661e.f66659h.getSwitchView()) {
                boolean z = BdSwitchView.SwitchState.ON == switchState;
                d.a.o0.r.d0.b j = d.a.o0.r.d0.b.j();
                j.t("recnbar" + TbadkCoreApplication.getCurrentAccount(), !z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001303) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {systemHelpSettingActivity};
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
        this.f66652a = null;
        this.f66653b = null;
        this.f66654c = null;
        this.f66655d = null;
        this.f66656e = null;
        this.f66657f = null;
        this.f66658g = null;
        this.f66660i = null;
        this.k = new a(this);
        new b(this, 2001303);
        this.f66652a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(R.layout.system_help_activity);
        NavigationBar navigationBar = (NavigationBar) this.f66652a.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        navigationBar.setTitleText(this.f66652a.getPageContext().getString(R.string.systemhelpsetting));
        this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f66652a.findViewById(R.id.clear_cache);
        this.f66654c = tbSettingTextTipView;
        tbSettingTextTipView.c();
        this.f66654c.setOnClickListener(this.f66652a);
        this.f66654c.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f66652a.findViewById(R.id.clear_im);
        this.f66655d = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        this.f66655d.setBottomLineVisibility(true);
        this.f66655d.setOnClickListener(this.f66652a);
        this.f66656e = (BdSwitchView) this.f66652a.findViewById(R.id.item_switch);
        l.c(this.f66652a.getPageContext().getPageActivity(), this.f66656e, 10, 10, 10, 10);
        this.f66656e.setOnSwitchStateChangeListener(this.f66652a);
        this.f66657f = (BdSwitchView) this.f66652a.findViewById(R.id.setting_save_video_switch);
        l.c(this.f66652a.getPageContext().getPageActivity(), this.f66657f, 10, 10, 10, 10);
        this.f66657f.setOnSwitchStateChangeListener(this.f66652a);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f66652a.findViewById(R.id.debug_tool_launch);
        this.f66660i = tbSettingTextTipView3;
        tbSettingTextTipView3.setVisibility(8);
        this.f66660i.c();
        this.f66660i.setOnClickListener(this.f66652a);
        this.f66653b = this.f66652a.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.f66655d.setVisibility(0);
        } else {
            this.f66655d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.f66658g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.f66652a);
        this.f66658g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f66652a.findViewById(R.id.recently_bar_switch);
        this.f66659h = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f66659h.setSpaceView(8);
        this.f66659h.setText(R.string.privacy_hide_recently_bar_text);
        this.f66659h.setOnSwitchStateChangeListener(this.k);
        d.a.o0.r.d0.b j = d.a.o0.r.d0.b.j();
        l(j.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public TbSettingTextTipView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66654c : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66655d : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66660i : (TbSettingTextTipView) invokeV.objValue;
    }

    public BdSwitchView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f66656e : (BdSwitchView) invokeV.objValue;
    }

    public TbSettingTextNewDotView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f66658g : (TbSettingTextNewDotView) invokeV.objValue;
    }

    public BdSwitchView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f66657f : (BdSwitchView) invokeV.objValue;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (!z) {
                this.f66659h.getSwitchView().k();
            } else {
                this.f66659h.getSwitchView().h();
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f66652a.getLayoutMode().k(i2 == 1);
            this.f66652a.getLayoutMode().j(this.f66653b);
            this.j.onChangeSkinType(getPageContext(), i2);
            this.f66656e.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            this.f66657f.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            this.f66659h.c(this.f66652a.getPageContext(), i2);
            SkinManager.setBackgroundResource(this.f66654c, R.drawable.more_all);
        }
    }
}
