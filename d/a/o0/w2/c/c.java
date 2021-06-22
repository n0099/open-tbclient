package d.a.o0.w2.c;

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
import d.a.n0.r.k;
import d.a.n0.r.s.n;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c extends d.a.c.a.d<BrowseSettingActivity> {

    /* renamed from: a  reason: collision with root package name */
    public BrowseSettingActivity f66407a;

    /* renamed from: b  reason: collision with root package name */
    public View f66408b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f66409c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f66410d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f66411e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f66412f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f66413g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f66414h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.r.s.e f66415i;
    public d.a.n0.r.s.e j;
    public d.a.n0.r.s.e k;
    public d.a.n0.r.s.e l;
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
            d.a.n0.r.d0.b.j().v("slide_local_switch_is_clicked", 1);
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
            c.this.f66415i.h(i2);
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
            c.this.f66415i.d();
            c.this.G();
        }
    }

    /* renamed from: d.a.o0.w2.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1761c implements AdapterView.OnItemClickListener {
        public C1761c() {
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
            setImageWatermarkTypeReqMsg.setTag(c.this.f66407a.getUniqueId());
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
        this.f66407a = null;
        this.f66408b = null;
        this.f66409c = null;
        this.f66410d = null;
        this.f66411e = null;
        this.f66412f = null;
        this.f66413g = null;
        this.f66415i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.r = new b();
        this.s = new C1761c();
        this.t = new d();
        this.u = new e();
        this.f66407a = browseSettingActivity;
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
            this.f66412f.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.f66412f.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.f66412f.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.f66412f.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public final void G() {
        if (!k.c().g()) {
            this.f66410d.setTip(this.mContext.getString(R.string.close));
        } else if (k.c().e() == 1) {
            this.f66410d.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.c().e() == 2) {
            this.f66410d.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.f66410d.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    public final void H(int i2) {
        if (i2 == 0) {
            this.f66411e.setTip(this.mContext.getString(R.string.image_water_show_none));
        } else if (i2 == 1) {
            this.f66411e.setTip(this.mContext.getString(R.string.image_water_show_user_name));
        } else if (i2 != 2) {
        } else {
            this.f66411e.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
        }
    }

    public void I() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.f66413g.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.f66413g.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.f66413g.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }

    public final void initUI() {
        this.f66407a.setContentView(R.layout.browse_setting_activity);
        NavigationBar navigationBar = (NavigationBar) this.f66407a.findViewById(R.id.view_navigation_bar);
        this.f66409c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f66409c.setTitleText(this.f66407a.getPageContext().getString(R.string.browse_setting));
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f66407a.findViewById(R.id.debug_tool_entrance);
        this.q = tbSettingTextTipView;
        tbSettingTextTipView.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f66407a.findViewById(R.id.img_browser);
        this.f66410d = tbSettingTextTipView2;
        tbSettingTextTipView2.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f66407a.findViewById(R.id.add_img_water);
        this.f66411e = tbSettingTextTipView3;
        tbSettingTextTipView3.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.f66407a.findViewById(R.id.font_size);
        this.f66412f = tbSettingTextTipView4;
        tbSettingTextTipView4.setBottomLineVisibility(true);
        this.f66413g = (TbSettingTextTipView) this.f66407a.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.f66413g.setText(R.string.video_gif_auto_play);
        } else {
            this.f66413g.setText(R.string.video_auto_play);
        }
        this.f66413g.setBottomLineVisibility(true);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f66407a.findViewById(R.id.slide_anim_switch);
        this.f66414h = msgSettingItemView;
        msgSettingItemView.setText(R.string.slide_anim_switch);
        this.f66414h.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.f66414h.setOnSwitchStateChangeListener(new a(this));
        this.f66408b = this.f66407a.findViewById(R.id.parent);
    }

    public TbSettingTextTipView l() {
        return this.f66411e;
    }

    public TbSettingTextTipView m() {
        return this.q;
    }

    public TbSettingTextTipView n() {
        return this.f66412f;
    }

    public TbSettingTextTipView o() {
        return this.f66410d;
    }

    public void onChangeSkinType(int i2) {
        this.f66407a.getLayoutMode().k(i2 == 1);
        this.f66407a.getLayoutMode().j(this.f66408b);
        this.f66409c.onChangeSkinType(getPageContext(), i2);
        this.f66414h.c(this.f66407a.getPageContext(), i2);
        d.a.n0.r.s.e eVar = this.f66415i;
        if (eVar != null) {
            eVar.g();
        }
        d.a.n0.r.s.e eVar2 = this.j;
        if (eVar2 != null) {
            eVar2.g();
        }
        d.a.n0.r.s.e eVar3 = this.k;
        if (eVar3 != null) {
            eVar3.g();
        }
        d.a.n0.r.s.e eVar4 = this.l;
        if (eVar4 != null) {
            eVar4.g();
        }
    }

    public TbSettingTextTipView p() {
        return this.f66413g;
    }

    public final void q() {
        this.o = new ArrayList<>();
        int b2 = k.c().b();
        this.o.add(new n(this.f66407a.getPageContext().getString(R.string.image_water_show_user_name), (String) null, b2 == 1));
        this.o.add(new n(this.f66407a.getPageContext().getString(R.string.image_water_show_forum_name), (String) null, b2 == 2));
        this.o.add(new n(this.f66407a.getPageContext().getString(R.string.image_water_show_none), (String) null, b2 == 0));
        d.a.n0.r.s.e eVar = new d.a.n0.r.s.e(this.f66407a.getPageContext());
        eVar.l(R.string.add_image_water);
        this.j = eVar;
        eVar.k(this.o, this.s);
        eVar.c();
    }

    public final void r() {
        this.k = new d.a.n0.r.s.e(this.f66407a.getPageContext());
        this.m = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.m.add(new n(this.f66407a.getPageContext().getString(R.string.font_size_xlarge), (String) null, fontSize == 0));
        this.m.add(new n(this.f66407a.getPageContext().getString(R.string.font_size_big), (String) null, fontSize == 1));
        this.m.add(new n(this.f66407a.getPageContext().getString(R.string.font_size_mid), (String) null, fontSize == 2));
        this.m.add(new n(this.f66407a.getPageContext().getString(R.string.font_size_small), (String) null, fontSize == 3));
        this.k.l(R.string.font_size);
        this.k.k(this.m, this.t);
        this.k.c();
    }

    public final void s() {
        this.n = new ArrayList<>();
        int e2 = k.c().e();
        boolean g2 = k.c().g();
        boolean z = false;
        this.n.add(new n(this.f66407a.getPageContext().getString(R.string.view_image_quality_auto_menu), this.f66407a.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), g2 && e2 == 0));
        this.n.add(new n(this.f66407a.getPageContext().getString(R.string.view_high), this.f66407a.getPageContext().getString(R.string.view_image_quality_high_menu_desc), g2 && e2 == 1));
        ArrayList<n> arrayList = this.n;
        String string = this.f66407a.getPageContext().getString(R.string.view_low);
        String string2 = this.f66407a.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
        if (g2 && e2 == 2) {
            z = true;
        }
        arrayList.add(new n(string, string2, z));
        d.a.n0.r.s.e eVar = new d.a.n0.r.s.e(this.f66407a.getPageContext());
        this.f66415i = eVar;
        eVar.l(R.string.browser_image_quality);
        d.a.n0.r.s.e eVar2 = this.f66415i;
        eVar2.k(this.n, this.r);
        eVar2.c();
    }

    public final void t() {
        this.f66410d.setOnClickListener(this.f66407a);
        this.f66411e.setOnClickListener(this.f66407a);
        this.f66412f.setOnClickListener(this.f66407a);
        this.f66413g.setOnClickListener(this.f66407a);
        this.q.setOnClickListener(this.f66407a);
    }

    public final void u() {
        this.l = new d.a.n0.r.s.e(this.f66407a.getPageContext());
        this.p = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.p.add(new n(this.f66407a.getPageContext().getString(R.string.video_auto_play_always), (String) null, homePageAutoPlay == 2));
        this.p.add(new n(this.f66407a.getPageContext().getString(R.string.video_auto_play_in_wifi), (String) null, homePageAutoPlay == 0));
        this.p.add(new n(this.f66407a.getPageContext().getString(R.string.close), (String) null, homePageAutoPlay == 1));
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
        this.f66415i.n();
    }

    public void y() {
        u();
        this.l.n();
    }

    public final void z() {
        H(k.c().b());
    }
}
