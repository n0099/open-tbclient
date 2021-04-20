package d.b.i0.v2.c;

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
import d.b.h0.r.k;
import d.b.h0.r.s.n;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends d.b.c.a.d<BrowseSettingActivity> {

    /* renamed from: a  reason: collision with root package name */
    public BrowseSettingActivity f63076a;

    /* renamed from: b  reason: collision with root package name */
    public View f63077b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f63078c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f63079d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f63080e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f63081f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f63082g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f63083h;
    public d.b.h0.r.s.e i;
    public d.b.h0.r.s.e j;
    public d.b.h0.r.s.e k;
    public d.b.h0.r.s.e l;
    public ArrayList<n> m;
    public ArrayList<n> n;
    public ArrayList<n> o;
    public ArrayList<n> p;
    public TbSettingTextTipView q;
    public final AdapterView.OnItemClickListener r;
    public final AdapterView.OnItemClickListener s;
    public final AdapterView.OnItemClickListener t;
    public final AdapterView.OnItemClickListener u;

    /* loaded from: classes4.dex */
    public class a implements BdSwitchView.b {
        public a(c cVar) {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            d.b.h0.r.d0.b.j().v("slide_local_switch_is_clicked", 1);
            if (switchState == BdSwitchView.SwitchState.ON) {
                TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                TiebaStatic.log(new StatisticItem("c13396").param("obj_type", 1));
                return;
            }
            TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
            TiebaStatic.log(new StatisticItem("c13396").param("obj_type", 2));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c.this.i.h(i);
            if (i == 0) {
                k.c().j(true);
                k.c().k(0);
            } else if (i == 1) {
                k.c().j(true);
                k.c().k(1);
                TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 1));
            } else if (i == 2) {
                k.c().j(true);
                k.c().k(2);
                TiebaStatic.log(new StatisticItem("c10415").param("obj_type", 3));
            } else if (i == 3) {
                k.c().j(false);
            }
            c.this.i.d();
            c.this.I();
        }
    }

    /* renamed from: d.b.i0.v2.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1659c implements AdapterView.OnItemClickListener {
        public C1659c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c.this.j.h(i);
            int i2 = 0;
            if (i == 0) {
                TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 1));
                i2 = 1;
            } else if (i == 1) {
                TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 2));
                i2 = 2;
            } else if (i == 2) {
                TiebaStatic.log(new StatisticItem("c10411").param("obj_type", 3));
            }
            SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
            setImageWatermarkTypeReqMsg.setTag(c.this.f63076a.getUniqueId());
            MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
            k.c().i(i2);
            c.this.J(i2);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c.this.k.h(i);
            if (i == 0) {
                TbadkCoreApplication.getInst().setFontSize(0);
            } else if (i == 1) {
                TbadkCoreApplication.getInst().setFontSize(1);
            } else if (i == 2) {
                TbadkCoreApplication.getInst().setFontSize(2);
            } else if (i == 3) {
                TbadkCoreApplication.getInst().setFontSize(3);
            }
            c.this.G();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c.this.l.h(i);
            if (i == 0) {
                TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 2));
            } else if (i == 1) {
                TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 1));
            } else if (i == 2) {
                TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                TiebaStatic.log(new StatisticItem("c11281").param("obj_type", 3));
            }
            c.this.K();
        }
    }

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.f63076a = null;
        this.f63077b = null;
        this.f63078c = null;
        this.f63079d = null;
        this.f63080e = null;
        this.f63081f = null;
        this.f63082g = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.r = new b();
        this.s = new C1659c();
        this.t = new d();
        this.u = new e();
        this.f63076a = browseSettingActivity;
        initUI();
        E();
        v();
    }

    public void A() {
        w();
        this.l.n();
    }

    public final void B() {
        J(k.c().b());
    }

    public void E() {
        I();
        B();
        G();
        K();
        F();
    }

    public final void F() {
        this.q.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
    }

    public void G() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.f63081f.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.f63081f.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.f63081f.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.f63081f.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public final void I() {
        if (!k.c().g()) {
            this.f63079d.setTip(this.mContext.getString(R.string.close));
        } else if (k.c().e() == 1) {
            this.f63079d.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.c().e() == 2) {
            this.f63079d.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.f63079d.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    public final void J(int i) {
        if (i == 0) {
            this.f63080e.setTip(this.mContext.getString(R.string.image_water_show_none));
        } else if (i == 1) {
            this.f63080e.setTip(this.mContext.getString(R.string.image_water_show_user_name));
        } else if (i != 2) {
        } else {
            this.f63080e.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
        }
    }

    public void K() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.f63082g.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.f63082g.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.f63082g.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }

    public final void initUI() {
        this.f63076a.setContentView(R.layout.browse_setting_activity);
        NavigationBar navigationBar = (NavigationBar) this.f63076a.findViewById(R.id.view_navigation_bar);
        this.f63078c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f63078c.setTitleText(this.f63076a.getPageContext().getString(R.string.browse_setting));
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f63076a.findViewById(R.id.debug_tool_entrance);
        this.q = tbSettingTextTipView;
        tbSettingTextTipView.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f63076a.findViewById(R.id.img_browser);
        this.f63079d = tbSettingTextTipView2;
        tbSettingTextTipView2.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f63076a.findViewById(R.id.add_img_water);
        this.f63080e = tbSettingTextTipView3;
        tbSettingTextTipView3.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.f63076a.findViewById(R.id.font_size);
        this.f63081f = tbSettingTextTipView4;
        tbSettingTextTipView4.setBottomLineVisibility(true);
        this.f63082g = (TbSettingTextTipView) this.f63076a.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.f63082g.setText(R.string.video_gif_auto_play);
        } else {
            this.f63082g.setText(R.string.video_auto_play);
        }
        this.f63082g.setBottomLineVisibility(true);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f63076a.findViewById(R.id.slide_anim_switch);
        this.f63083h = msgSettingItemView;
        msgSettingItemView.setText(R.string.slide_anim_switch);
        this.f63083h.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.f63083h.setOnSwitchStateChangeListener(new a(this));
        this.f63077b = this.f63076a.findViewById(R.id.parent);
    }

    public TbSettingTextTipView l() {
        return this.f63080e;
    }

    public TbSettingTextTipView m() {
        return this.q;
    }

    public TbSettingTextTipView n() {
        return this.f63081f;
    }

    public TbSettingTextTipView o() {
        return this.f63079d;
    }

    public void onChangeSkinType(int i) {
        this.f63076a.getLayoutMode().k(i == 1);
        this.f63076a.getLayoutMode().j(this.f63077b);
        this.f63078c.onChangeSkinType(getPageContext(), i);
        this.f63083h.c(this.f63076a.getPageContext(), i);
        d.b.h0.r.s.e eVar = this.i;
        if (eVar != null) {
            eVar.g();
        }
        d.b.h0.r.s.e eVar2 = this.j;
        if (eVar2 != null) {
            eVar2.g();
        }
        d.b.h0.r.s.e eVar3 = this.k;
        if (eVar3 != null) {
            eVar3.g();
        }
        d.b.h0.r.s.e eVar4 = this.l;
        if (eVar4 != null) {
            eVar4.g();
        }
    }

    public TbSettingTextTipView q() {
        return this.f63082g;
    }

    public final void r() {
        this.o = new ArrayList<>();
        int b2 = k.c().b();
        this.o.add(new n(this.f63076a.getPageContext().getString(R.string.image_water_show_user_name), (String) null, b2 == 1));
        this.o.add(new n(this.f63076a.getPageContext().getString(R.string.image_water_show_forum_name), (String) null, b2 == 2));
        this.o.add(new n(this.f63076a.getPageContext().getString(R.string.image_water_show_none), (String) null, b2 == 0));
        d.b.h0.r.s.e eVar = new d.b.h0.r.s.e(this.f63076a.getPageContext());
        eVar.l(R.string.add_image_water);
        this.j = eVar;
        eVar.k(this.o, this.s);
        eVar.c();
    }

    public final void s() {
        this.k = new d.b.h0.r.s.e(this.f63076a.getPageContext());
        this.m = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.m.add(new n(this.f63076a.getPageContext().getString(R.string.font_size_xlarge), (String) null, fontSize == 0));
        this.m.add(new n(this.f63076a.getPageContext().getString(R.string.font_size_big), (String) null, fontSize == 1));
        this.m.add(new n(this.f63076a.getPageContext().getString(R.string.font_size_mid), (String) null, fontSize == 2));
        this.m.add(new n(this.f63076a.getPageContext().getString(R.string.font_size_small), (String) null, fontSize == 3));
        this.k.l(R.string.font_size);
        this.k.k(this.m, this.t);
        this.k.c();
    }

    public final void u() {
        this.n = new ArrayList<>();
        int e2 = k.c().e();
        boolean g2 = k.c().g();
        boolean z = false;
        this.n.add(new n(this.f63076a.getPageContext().getString(R.string.view_image_quality_auto_menu), this.f63076a.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), g2 && e2 == 0));
        this.n.add(new n(this.f63076a.getPageContext().getString(R.string.view_high), this.f63076a.getPageContext().getString(R.string.view_image_quality_high_menu_desc), g2 && e2 == 1));
        ArrayList<n> arrayList = this.n;
        String string = this.f63076a.getPageContext().getString(R.string.view_low);
        String string2 = this.f63076a.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
        if (g2 && e2 == 2) {
            z = true;
        }
        arrayList.add(new n(string, string2, z));
        d.b.h0.r.s.e eVar = new d.b.h0.r.s.e(this.f63076a.getPageContext());
        this.i = eVar;
        eVar.l(R.string.browser_image_quality);
        d.b.h0.r.s.e eVar2 = this.i;
        eVar2.k(this.n, this.r);
        eVar2.c();
    }

    public final void v() {
        this.f63079d.setOnClickListener(this.f63076a);
        this.f63080e.setOnClickListener(this.f63076a);
        this.f63081f.setOnClickListener(this.f63076a);
        this.f63082g.setOnClickListener(this.f63076a);
        this.q.setOnClickListener(this.f63076a);
    }

    public final void w() {
        this.l = new d.b.h0.r.s.e(this.f63076a.getPageContext());
        this.p = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.p.add(new n(this.f63076a.getPageContext().getString(R.string.video_auto_play_always), (String) null, homePageAutoPlay == 2));
        this.p.add(new n(this.f63076a.getPageContext().getString(R.string.video_auto_play_in_wifi), (String) null, homePageAutoPlay == 0));
        this.p.add(new n(this.f63076a.getPageContext().getString(R.string.close), (String) null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.l.l(R.string.video_gif_auto_play);
        } else {
            this.l.l(R.string.video_auto_play);
        }
        this.l.k(this.p, this.u);
        this.l.c();
    }

    public void x() {
        r();
        this.j.n();
    }

    public void y() {
        s();
        this.k.n();
    }

    public void z() {
        u();
        this.i.n();
    }
}
