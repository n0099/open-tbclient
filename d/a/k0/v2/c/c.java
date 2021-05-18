package d.a.k0.v2.c;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
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
import d.a.j0.r.k;
import d.a.j0.r.s.n;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c extends d.a.c.a.d<BrowseSettingActivity> {

    /* renamed from: a  reason: collision with root package name */
    public BrowseSettingActivity f62460a;

    /* renamed from: b  reason: collision with root package name */
    public View f62461b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62462c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f62463d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f62464e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f62465f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f62466g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f62467h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.r.s.e f62468i;
    public d.a.j0.r.s.e j;
    public d.a.j0.r.s.e k;
    public d.a.j0.r.s.e l;
    public ArrayList<n> m;
    public ArrayList<n> n;
    public ArrayList<n> o;
    public ArrayList<n> p;
    public TbSettingTextTipView q;
    public final AdapterView.OnItemClickListener r;
    public final AdapterView.OnItemClickListener s;
    public final AdapterView.OnItemClickListener t;
    public final AdapterView.OnItemClickListener u;

    /* loaded from: classes5.dex */
    public class a implements BdSwitchView.b {
        public a(c cVar) {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            d.a.j0.r.d0.b.j().v("slide_local_switch_is_clicked", 1);
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                TiebaStatic.log(new StatisticItem("c13396").param("obj_type", 1));
                return;
            }
            TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
            TiebaStatic.log(new StatisticItem("c13396").param("obj_type", 2));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            c.this.f62468i.h(i2);
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
            c.this.f62468i.d();
            c.this.G();
        }
    }

    /* renamed from: d.a.k0.v2.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1687c implements AdapterView.OnItemClickListener {
        public C1687c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            c.this.j.h(i2);
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
            setImageWatermarkTypeReqMsg.setTag(c.this.f62460a.getUniqueId());
            MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
            k.c().i(i3);
            c.this.H(i3);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            c.this.k.h(i2);
            if (i2 == 0) {
                TbadkCoreApplication.getInst().setFontSize(0);
            } else if (i2 == 1) {
                TbadkCoreApplication.getInst().setFontSize(1);
            } else if (i2 == 2) {
                TbadkCoreApplication.getInst().setFontSize(2);
            } else if (i2 == 3) {
                TbadkCoreApplication.getInst().setFontSize(3);
            }
            c.this.F();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            c.this.l.h(i2);
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
            c.this.I();
        }
    }

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.f62460a = null;
        this.f62461b = null;
        this.f62462c = null;
        this.f62463d = null;
        this.f62464e = null;
        this.f62465f = null;
        this.f62466g = null;
        this.f62468i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.r = new b();
        this.s = new C1687c();
        this.t = new d();
        this.u = new e();
        this.f62460a = browseSettingActivity;
        initUI();
        A();
        t();
    }

    public void A() {
        G();
        z();
        F();
        I();
        B();
    }

    public final void B() {
        this.q.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
    }

    public void F() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.f62465f.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.f62465f.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.f62465f.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.f62465f.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public final void G() {
        if (!k.c().g()) {
            this.f62463d.setTip(this.mContext.getString(R.string.close));
        } else if (k.c().e() == 1) {
            this.f62463d.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.c().e() == 2) {
            this.f62463d.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.f62463d.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    public final void H(int i2) {
        if (i2 == 0) {
            this.f62464e.setTip(this.mContext.getString(R.string.image_water_show_none));
        } else if (i2 == 1) {
            this.f62464e.setTip(this.mContext.getString(R.string.image_water_show_user_name));
        } else if (i2 != 2) {
        } else {
            this.f62464e.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
        }
    }

    public void I() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.f62466g.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.f62466g.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.f62466g.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }

    public final void initUI() {
        this.f62460a.setContentView(R.layout.browse_setting_activity);
        NavigationBar navigationBar = (NavigationBar) this.f62460a.findViewById(R.id.view_navigation_bar);
        this.f62462c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62462c.setTitleText(this.f62460a.getPageContext().getString(R.string.browse_setting));
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f62460a.findViewById(R.id.debug_tool_entrance);
        this.q = tbSettingTextTipView;
        tbSettingTextTipView.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f62460a.findViewById(R.id.img_browser);
        this.f62463d = tbSettingTextTipView2;
        tbSettingTextTipView2.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f62460a.findViewById(R.id.add_img_water);
        this.f62464e = tbSettingTextTipView3;
        tbSettingTextTipView3.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.f62460a.findViewById(R.id.font_size);
        this.f62465f = tbSettingTextTipView4;
        tbSettingTextTipView4.setBottomLineVisibility(true);
        this.f62466g = (TbSettingTextTipView) this.f62460a.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.f62466g.setText(R.string.video_gif_auto_play);
        } else {
            this.f62466g.setText(R.string.video_auto_play);
        }
        this.f62466g.setBottomLineVisibility(true);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f62460a.findViewById(R.id.slide_anim_switch);
        this.f62467h = msgSettingItemView;
        msgSettingItemView.setText(R.string.slide_anim_switch);
        this.f62467h.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.f62467h.setOnSwitchStateChangeListener(new a(this));
        this.f62461b = this.f62460a.findViewById(R.id.parent);
    }

    public TbSettingTextTipView l() {
        return this.f62464e;
    }

    public TbSettingTextTipView m() {
        return this.q;
    }

    public TbSettingTextTipView n() {
        return this.f62465f;
    }

    public TbSettingTextTipView o() {
        return this.f62463d;
    }

    public void onChangeSkinType(int i2) {
        this.f62460a.getLayoutMode().k(i2 == 1);
        this.f62460a.getLayoutMode().j(this.f62461b);
        this.f62462c.onChangeSkinType(getPageContext(), i2);
        this.f62467h.c(this.f62460a.getPageContext(), i2);
        d.a.j0.r.s.e eVar = this.f62468i;
        if (eVar != null) {
            eVar.g();
        }
        d.a.j0.r.s.e eVar2 = this.j;
        if (eVar2 != null) {
            eVar2.g();
        }
        d.a.j0.r.s.e eVar3 = this.k;
        if (eVar3 != null) {
            eVar3.g();
        }
        d.a.j0.r.s.e eVar4 = this.l;
        if (eVar4 != null) {
            eVar4.g();
        }
    }

    public TbSettingTextTipView p() {
        return this.f62466g;
    }

    public final void q() {
        this.o = new ArrayList<>();
        int b2 = k.c().b();
        this.o.add(new n(this.f62460a.getPageContext().getString(R.string.image_water_show_user_name), (String) null, b2 == 1));
        this.o.add(new n(this.f62460a.getPageContext().getString(R.string.image_water_show_forum_name), (String) null, b2 == 2));
        this.o.add(new n(this.f62460a.getPageContext().getString(R.string.image_water_show_none), (String) null, b2 == 0));
        d.a.j0.r.s.e eVar = new d.a.j0.r.s.e(this.f62460a.getPageContext());
        eVar.l(R.string.add_image_water);
        this.j = eVar;
        eVar.k(this.o, this.s);
        eVar.c();
    }

    public final void r() {
        this.k = new d.a.j0.r.s.e(this.f62460a.getPageContext());
        this.m = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.m.add(new n(this.f62460a.getPageContext().getString(R.string.font_size_xlarge), (String) null, fontSize == 0));
        this.m.add(new n(this.f62460a.getPageContext().getString(R.string.font_size_big), (String) null, fontSize == 1));
        this.m.add(new n(this.f62460a.getPageContext().getString(R.string.font_size_mid), (String) null, fontSize == 2));
        this.m.add(new n(this.f62460a.getPageContext().getString(R.string.font_size_small), (String) null, fontSize == 3));
        this.k.l(R.string.font_size);
        this.k.k(this.m, this.t);
        this.k.c();
    }

    public final void s() {
        this.n = new ArrayList<>();
        int e2 = k.c().e();
        boolean g2 = k.c().g();
        boolean z = false;
        this.n.add(new n(this.f62460a.getPageContext().getString(R.string.view_image_quality_auto_menu), this.f62460a.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), g2 && e2 == 0));
        this.n.add(new n(this.f62460a.getPageContext().getString(R.string.view_high), this.f62460a.getPageContext().getString(R.string.view_image_quality_high_menu_desc), g2 && e2 == 1));
        ArrayList<n> arrayList = this.n;
        String string = this.f62460a.getPageContext().getString(R.string.view_low);
        String string2 = this.f62460a.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
        if (g2 && e2 == 2) {
            z = true;
        }
        arrayList.add(new n(string, string2, z));
        d.a.j0.r.s.e eVar = new d.a.j0.r.s.e(this.f62460a.getPageContext());
        this.f62468i = eVar;
        eVar.l(R.string.browser_image_quality);
        d.a.j0.r.s.e eVar2 = this.f62468i;
        eVar2.k(this.n, this.r);
        eVar2.c();
    }

    public final void t() {
        this.f62463d.setOnClickListener(this.f62460a);
        this.f62464e.setOnClickListener(this.f62460a);
        this.f62465f.setOnClickListener(this.f62460a);
        this.f62466g.setOnClickListener(this.f62460a);
        this.q.setOnClickListener(this.f62460a);
    }

    public final void u() {
        this.l = new d.a.j0.r.s.e(this.f62460a.getPageContext());
        this.p = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.p.add(new n(this.f62460a.getPageContext().getString(R.string.video_auto_play_always), (String) null, homePageAutoPlay == 2));
        this.p.add(new n(this.f62460a.getPageContext().getString(R.string.video_auto_play_in_wifi), (String) null, homePageAutoPlay == 0));
        this.p.add(new n(this.f62460a.getPageContext().getString(R.string.close), (String) null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.l.l(R.string.video_gif_auto_play);
        } else {
            this.l.l(R.string.video_auto_play);
        }
        this.l.k(this.p, this.u);
        this.l.c();
    }

    public void v() {
        q();
        this.j.n();
    }

    public void w() {
        r();
        this.k.n();
    }

    public void x() {
        s();
        this.f62468i.n();
    }

    public void y() {
        u();
        this.l.n();
    }

    public final void z() {
        H(k.c().b());
    }
}
