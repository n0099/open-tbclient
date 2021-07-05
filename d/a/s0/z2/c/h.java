package d.a.s0.z2.c;

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
/* loaded from: classes9.dex */
public class h extends d.a.c.a.d<SystemHelpSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SystemHelpSettingActivity f69849a;

    /* renamed from: b  reason: collision with root package name */
    public View f69850b;

    /* renamed from: c  reason: collision with root package name */
    public TbSettingTextTipView f69851c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f69852d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwitchView f69853e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f69854f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextNewDotView f69855g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f69856h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f69857i;
    public NavigationBar j;
    public BdSwitchView.b k;

    /* loaded from: classes9.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f69858e;

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
            this.f69858e = hVar;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) && view == this.f69858e.f69856h.getSwitchView()) {
                boolean z = BdSwitchView.SwitchState.ON == switchState;
                d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
                j.t("recnbar" + TbadkCoreApplication.getCurrentAccount(), !z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f69849a = null;
        this.f69850b = null;
        this.f69851c = null;
        this.f69852d = null;
        this.f69853e = null;
        this.f69854f = null;
        this.f69855g = null;
        this.f69857i = null;
        this.k = new a(this);
        new b(this, 2001303);
        this.f69849a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(R.layout.system_help_activity);
        NavigationBar navigationBar = (NavigationBar) this.f69849a.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        navigationBar.setTitleText(this.f69849a.getPageContext().getString(R.string.systemhelpsetting));
        this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f69849a.findViewById(R.id.clear_cache);
        this.f69851c = tbSettingTextTipView;
        tbSettingTextTipView.c();
        this.f69851c.setOnClickListener(this.f69849a);
        this.f69851c.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f69849a.findViewById(R.id.clear_im);
        this.f69852d = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        this.f69852d.setBottomLineVisibility(true);
        this.f69852d.setOnClickListener(this.f69849a);
        this.f69853e = (BdSwitchView) this.f69849a.findViewById(R.id.item_switch);
        l.c(this.f69849a.getPageContext().getPageActivity(), this.f69853e, 10, 10, 10, 10);
        this.f69853e.setOnSwitchStateChangeListener(this.f69849a);
        this.f69854f = (BdSwitchView) this.f69849a.findViewById(R.id.setting_save_video_switch);
        l.c(this.f69849a.getPageContext().getPageActivity(), this.f69854f, 10, 10, 10, 10);
        this.f69854f.setOnSwitchStateChangeListener(this.f69849a);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f69849a.findViewById(R.id.debug_tool_launch);
        this.f69857i = tbSettingTextTipView3;
        tbSettingTextTipView3.setVisibility(8);
        this.f69857i.c();
        this.f69857i.setOnClickListener(this.f69849a);
        this.f69850b = this.f69849a.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.f69852d.setVisibility(0);
        } else {
            this.f69852d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.f69855g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.f69849a);
        this.f69855g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f69849a.findViewById(R.id.recently_bar_switch);
        this.f69856h = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f69856h.setSpaceView(8);
        this.f69856h.setText(R.string.privacy_hide_recently_bar_text);
        this.f69856h.setOnSwitchStateChangeListener(this.k);
        d.a.r0.r.d0.b j = d.a.r0.r.d0.b.j();
        m(j.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public TbSettingTextTipView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69851c : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69852d : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69857i : (TbSettingTextTipView) invokeV.objValue;
    }

    public BdSwitchView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f69853e : (BdSwitchView) invokeV.objValue;
    }

    public TbSettingTextNewDotView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f69855g : (TbSettingTextNewDotView) invokeV.objValue;
    }

    public BdSwitchView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f69854f : (BdSwitchView) invokeV.objValue;
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (!z) {
                this.f69856h.getSwitchView().k();
            } else {
                this.f69856h.getSwitchView().h();
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f69849a.getLayoutMode().k(i2 == 1);
            this.f69849a.getLayoutMode().j(this.f69850b);
            this.j.onChangeSkinType(getPageContext(), i2);
            this.f69853e.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            this.f69854f.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            this.f69856h.c(this.f69849a.getPageContext(), i2);
            SkinManager.setBackgroundResource(this.f69851c, R.drawable.more_all);
        }
    }
}
