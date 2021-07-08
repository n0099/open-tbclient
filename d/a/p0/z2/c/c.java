package d.a.p0.z2.c;

import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.switchs.RichTextGifViewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.tieba.setting.more.BrowseSettingActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.k;
import d.a.o0.r.s.n;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c extends d.a.c.a.d<BrowseSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BrowseSettingActivity f66606a;

    /* renamed from: b  reason: collision with root package name */
    public View f66607b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f66608c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f66609d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f66610e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f66611f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f66612g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f66613h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.r.s.e f66614i;
    public d.a.o0.r.s.e j;
    public d.a.o0.r.s.e k;
    public d.a.o0.r.s.e l;
    public ArrayList<n> m;
    public ArrayList<n> n;
    public ArrayList<n> o;
    public ArrayList<n> p;
    public TbSettingTextTipView q;
    public final AdapterView.OnItemClickListener r;
    public final AdapterView.OnItemClickListener s;
    public final AdapterView.OnItemClickListener t;
    public final AdapterView.OnItemClickListener u;

    /* loaded from: classes8.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, switchState) == null) {
                d.a.o0.r.d0.b.j().v("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new StatisticItem("c13396").param("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new StatisticItem("c13396").param("obj_type", 2));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f66615e;

        public b(c cVar) {
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
            this.f66615e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f66615e.f66614i.h(i2);
                if (i2 == 0) {
                    k.c().j(true);
                    k.c().k(0);
                } else if (i2 == 1) {
                    k.c().j(true);
                    k.c().k(1);
                    TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 1));
                } else if (i2 == 2) {
                    k.c().j(true);
                    k.c().k(2);
                    TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 3));
                } else if (i2 == 3) {
                    k.c().j(false);
                }
                this.f66615e.f66614i.d();
                this.f66615e.G();
            }
        }
    }

    /* renamed from: d.a.p0.z2.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1863c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f66616e;

        public C1863c(c cVar) {
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
            this.f66616e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f66616e.j.h(i2);
                int i3 = 0;
                if (i2 == 0) {
                    TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 1));
                    i3 = 1;
                } else if (i2 == 1) {
                    TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 2));
                    i3 = 2;
                } else if (i2 == 2) {
                    TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 3));
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i3);
                setImageWatermarkTypeReqMsg.setTag(this.f66616e.f66606a.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.c().i(i3);
                this.f66616e.H(i3);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f66617e;

        public d(c cVar) {
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
            this.f66617e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f66617e.k.h(i2);
                if (i2 == 0) {
                    TbadkCoreApplication.getInst().setFontSize(0);
                } else if (i2 == 1) {
                    TbadkCoreApplication.getInst().setFontSize(1);
                } else if (i2 == 2) {
                    TbadkCoreApplication.getInst().setFontSize(2);
                } else if (i2 == 3) {
                    TbadkCoreApplication.getInst().setFontSize(3);
                }
                this.f66617e.F();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f66618e;

        public e(c cVar) {
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
            this.f66618e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f66618e.l.h(i2);
                if (i2 == 0) {
                    TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                    TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 2));
                } else if (i2 == 1) {
                    TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                    TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 1));
                } else if (i2 == 2) {
                    TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                    TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 3));
                }
                this.f66618e.I();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {browseSettingActivity};
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
        this.f66606a = null;
        this.f66607b = null;
        this.f66608c = null;
        this.f66609d = null;
        this.f66610e = null;
        this.f66611f = null;
        this.f66612g = null;
        this.f66614i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.r = new b(this);
        this.s = new C1863c(this);
        this.t = new d(this);
        this.u = new e(this);
        this.f66606a = browseSettingActivity;
        initUI();
        A();
        t();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            G();
            z();
            F();
            I();
            B();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.q.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (TbadkCoreApplication.getInst().getFontSize() == 0) {
                this.f66611f.setTip(this.mContext.getString(R.string.font_size_xlarge));
            } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
                this.f66611f.setTip(this.mContext.getString(R.string.font_size_big));
            } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
                this.f66611f.setTip(this.mContext.getString(R.string.font_size_mid));
            } else {
                this.f66611f.setTip(this.mContext.getString(R.string.font_size_small));
            }
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!k.c().g()) {
                this.f66609d.setTip(this.mContext.getString(R.string.close));
            } else if (k.c().e() == 1) {
                this.f66609d.setTip(this.mContext.getString(R.string.view_high));
            } else if (k.c().e() == 2) {
                this.f66609d.setTip(this.mContext.getString(R.string.view_low));
            } else {
                this.f66609d.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
            }
        }
    }

    public final void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 == 0) {
                this.f66610e.setTip(this.mContext.getString(R.string.image_water_show_none));
            } else if (i2 == 1) {
                this.f66610e.setTip(this.mContext.getString(R.string.image_water_show_user_name));
            } else if (i2 != 2) {
            } else {
                this.f66610e.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
                this.f66612g.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
            } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
                this.f66612g.setTip(this.mContext.getString(R.string.close));
            } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
                this.f66612g.setTip(this.mContext.getString(R.string.video_auto_play_always));
            }
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f66606a.setContentView(R.layout.browse_setting_activity);
            NavigationBar navigationBar = (NavigationBar) this.f66606a.findViewById(R.id.view_navigation_bar);
            this.f66608c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f66608c.setTitleText(this.f66606a.getPageContext().getString(R.string.browse_setting));
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f66606a.findViewById(R.id.debug_tool_entrance);
            this.q = tbSettingTextTipView;
            tbSettingTextTipView.setBottomLineVisibility(true);
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f66606a.findViewById(R.id.img_browser);
            this.f66609d = tbSettingTextTipView2;
            tbSettingTextTipView2.setBottomLineVisibility(true);
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f66606a.findViewById(R.id.add_img_water);
            this.f66610e = tbSettingTextTipView3;
            tbSettingTextTipView3.setBottomLineVisibility(true);
            TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.f66606a.findViewById(R.id.font_size);
            this.f66611f = tbSettingTextTipView4;
            tbSettingTextTipView4.setBottomLineVisibility(true);
            this.f66612g = (TbSettingTextTipView) this.f66606a.findViewById(R.id.video_auto_play);
            if (RichTextGifViewSwitch.isOn()) {
                this.f66612g.setText(R.string.video_gif_auto_play);
            } else {
                this.f66612g.setText(R.string.video_auto_play);
            }
            this.f66612g.setBottomLineVisibility(true);
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f66606a.findViewById(R.id.slide_anim_switch);
            this.f66613h = msgSettingItemView;
            msgSettingItemView.setText(R.string.slide_anim_switch);
            this.f66613h.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
            this.f66613h.setOnSwitchStateChangeListener(new a(this));
            this.f66607b = this.f66606a.findViewById(R.id.parent);
        }
    }

    public TbSettingTextTipView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f66610e : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.q : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f66611f : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f66609d : (TbSettingTextTipView) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f66606a.getLayoutMode().k(i2 == 1);
            this.f66606a.getLayoutMode().j(this.f66607b);
            this.f66608c.onChangeSkinType(getPageContext(), i2);
            this.f66613h.c(this.f66606a.getPageContext(), i2);
            d.a.o0.r.s.e eVar = this.f66614i;
            if (eVar != null) {
                eVar.g();
            }
            d.a.o0.r.s.e eVar2 = this.j;
            if (eVar2 != null) {
                eVar2.g();
            }
            d.a.o0.r.s.e eVar3 = this.k;
            if (eVar3 != null) {
                eVar3.g();
            }
            d.a.o0.r.s.e eVar4 = this.l;
            if (eVar4 != null) {
                eVar4.g();
            }
        }
    }

    public TbSettingTextTipView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f66612g : (TbSettingTextTipView) invokeV.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.o = new ArrayList<>();
            int b2 = k.c().b();
            this.o.add(new n(this.f66606a.getPageContext().getString(R.string.image_water_show_user_name), (String) null, b2 == 1));
            this.o.add(new n(this.f66606a.getPageContext().getString(R.string.image_water_show_forum_name), (String) null, b2 == 2));
            this.o.add(new n(this.f66606a.getPageContext().getString(R.string.image_water_show_none), (String) null, b2 == 0));
            d.a.o0.r.s.e eVar = new d.a.o0.r.s.e(this.f66606a.getPageContext());
            eVar.l(R.string.add_image_water);
            this.j = eVar;
            eVar.k(this.o, this.s);
            eVar.c();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.k = new d.a.o0.r.s.e(this.f66606a.getPageContext());
            this.m = new ArrayList<>();
            int fontSize = TbadkCoreApplication.getInst().getFontSize();
            this.m.add(new n(this.f66606a.getPageContext().getString(R.string.font_size_xlarge), (String) null, fontSize == 0));
            this.m.add(new n(this.f66606a.getPageContext().getString(R.string.font_size_big), (String) null, fontSize == 1));
            this.m.add(new n(this.f66606a.getPageContext().getString(R.string.font_size_mid), (String) null, fontSize == 2));
            this.m.add(new n(this.f66606a.getPageContext().getString(R.string.font_size_small), (String) null, fontSize == 3));
            this.k.l(R.string.font_size);
            this.k.k(this.m, this.t);
            this.k.c();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.n = new ArrayList<>();
            int e2 = k.c().e();
            boolean g2 = k.c().g();
            boolean z = false;
            this.n.add(new n(this.f66606a.getPageContext().getString(R.string.view_image_quality_auto_menu), this.f66606a.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), g2 && e2 == 0));
            this.n.add(new n(this.f66606a.getPageContext().getString(R.string.view_high), this.f66606a.getPageContext().getString(R.string.view_image_quality_high_menu_desc), g2 && e2 == 1));
            ArrayList<n> arrayList = this.n;
            String string = this.f66606a.getPageContext().getString(R.string.view_low);
            String string2 = this.f66606a.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
            if (g2 && e2 == 2) {
                z = true;
            }
            arrayList.add(new n(string, string2, z));
            d.a.o0.r.s.e eVar = new d.a.o0.r.s.e(this.f66606a.getPageContext());
            this.f66614i = eVar;
            eVar.l(R.string.browser_image_quality);
            d.a.o0.r.s.e eVar2 = this.f66614i;
            eVar2.k(this.n, this.r);
            eVar2.c();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f66609d.setOnClickListener(this.f66606a);
            this.f66610e.setOnClickListener(this.f66606a);
            this.f66611f.setOnClickListener(this.f66606a);
            this.f66612g.setOnClickListener(this.f66606a);
            this.q.setOnClickListener(this.f66606a);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.l = new d.a.o0.r.s.e(this.f66606a.getPageContext());
            this.p = new ArrayList<>();
            int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
            this.p.add(new n(this.f66606a.getPageContext().getString(R.string.video_auto_play_always), (String) null, homePageAutoPlay == 2));
            this.p.add(new n(this.f66606a.getPageContext().getString(R.string.video_auto_play_in_wifi), (String) null, homePageAutoPlay == 0));
            this.p.add(new n(this.f66606a.getPageContext().getString(R.string.close), (String) null, homePageAutoPlay == 1));
            if (RichTextGifViewSwitch.isOn()) {
                this.l.l(R.string.video_gif_auto_play);
            } else {
                this.l.l(R.string.video_auto_play);
            }
            this.l.k(this.p, this.u);
            this.l.c();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            q();
            this.j.n();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            r();
            this.k.n();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            s();
            this.f66614i.n();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            u();
            this.l.n();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            H(k.c().b());
        }
    }
}
