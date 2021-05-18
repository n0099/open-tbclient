package d.a.k0.a1.d.f;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoTitleBar;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.i.v0.a;
import d.a.j0.r.f0.f;
import d.a.k0.f0.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    public BdUniqueId A;
    public d.a.k0.f0.a B;
    public NEGFeedBackView.b C;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51352a;

    /* renamed from: b  reason: collision with root package name */
    public View f51353b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f51354c;

    /* renamed from: d  reason: collision with root package name */
    public BigdaySwipeRefreshLayout f51355d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.a1.g.i.a f51356e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f51357f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.d0.g f51358g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f51359h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f51360i;
    public d.a.k0.a1.d.a.a j;
    public View k;
    public FrameLayout l;
    public d.a.j0.d0.h m;
    public GameVideoTitleBar n;
    public AlphaAnimation o;
    public AlphaAnimation p;
    public boolean q;
    public RotateAnimation r;
    public RotateAnimation s;
    public d.a.k0.j2.i v;
    public boolean t = false;
    public boolean u = false;
    public int w = 0;
    public int x = 0;
    public boolean y = false;
    public boolean z = true;
    public f.h D = new c();
    public f.InterfaceC1125f E = new d();
    public CustomMessageListener F = new e(2921420);
    public View.OnTouchListener G = new f();
    public a.b H = new g();
    public CustomMessageListener I = new h(2921381);
    public RecyclerView.RecyclerListener J = new i();
    public RecyclerView.OnScrollListener K = new j();

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (b.this.f51359h != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(b.this.f51359h, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                b.this.t = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: d.a.k0.a1.d.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1180b implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC1180b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (b.this.f51359h != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(b.this.f51359h, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                b.this.t = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.h {
        public c() {
        }

        @Override // d.a.j0.r.f0.f.h
        public void a(boolean z) {
            b.this.m0();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.InterfaceC1125f {
        public d() {
        }

        @Override // d.a.j0.r.f0.f.InterfaceC1125f
        public void a(View view, boolean z) {
            b.this.X(true);
            if (b.this.v == null || b.this.y || !b.this.z) {
                return;
            }
            b.this.v.n(b.this.w, b.this.x, b.this.u, true);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.j.c();
                if (b.this.y || !b.this.z) {
                    return;
                }
                b.this.v.n(b.this.w, b.this.x, b.this.u, true);
            }
        }

        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.c.e.m.e.a().postDelayed(new a(), 500L);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.B != null) {
                b.this.B.c(motionEvent);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.b {
        public g() {
        }

        @Override // d.a.k0.f0.a.b
        public void a(int i2, int i3) {
            b.this.u = false;
        }

        @Override // d.a.k0.f0.a.b
        public void b(int i2, int i3) {
            b.this.u = true;
        }

        @Override // d.a.k0.f0.a.b
        public void c(int i2, int i3) {
        }

        @Override // d.a.k0.f0.a.b
        public void d(int i2, int i3) {
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public h(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder v;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof KeyEvent)) {
                return;
            }
            KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
            if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (v = b.this.v()) == null || v.b() == null) {
                return;
            }
            v.b().o(new a.C0549a(3));
        }
    }

    /* loaded from: classes4.dex */
    public class i implements RecyclerView.RecyclerListener {
        public i() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder == null || (view = viewHolder.itemView) == null) {
                return;
            }
            if (b.this.v != null) {
                b.this.v.k(view);
            }
            if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view.getTag()).b().stopPlay();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends RecyclerView.OnScrollListener {
        public j() {
        }

        public void a(int i2, int i3) {
            b.this.w = i2;
            b.this.x = (i2 + i3) - 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 1) {
                b.this.k0();
                return;
            }
            b bVar = b.this;
            if (bVar.M(bVar.f51354c)) {
                b.this.u();
            }
            if (i2 == 0 && b.this.v != null && b.this.z) {
                b.this.v.m(b.this.w, b.this.x, b.this.u, 1);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            int i4;
            int i5 = 0;
            if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                i4 = 0;
            } else {
                BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                i5 = bdRecyclerView.getFirstVisiblePosition();
                i4 = bdRecyclerView.getLastVisiblePosition();
            }
            a(i5, (i4 - i5) + 1);
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Animation.AnimationListener {
        public k() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.k.setVisibility(8);
            b.this.q = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.b bVar) {
        this.f51352a = tbPageContext;
        this.A = bdUniqueId;
        this.C = bVar;
        D();
    }

    public void A() {
        d.a.j0.d0.g gVar = this.f51358g;
        if (gVar != null) {
            gVar.dettachView(this.f51353b);
        }
    }

    public void B() {
        d.a.j0.d0.h hVar = this.m;
        if (hVar != null) {
            hVar.dettachView(this.l);
            this.m = null;
        }
    }

    public void C() {
        this.f51354c.addOnScrollListener(this.K);
        this.f51354c.setOnTouchListener(this.G);
        this.f51354c.setRecyclerListener(this.J);
        this.B.d(this.H);
        this.f51356e.b(this.D);
        this.f51356e.l(this.E);
        this.f51356e.Z(this.f51352a.getUniqueId());
        O();
    }

    public final void D() {
        View inflate = LayoutInflater.from(this.f51352a.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.f51353b = inflate;
        inflate.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.n = (GameVideoTitleBar) this.f51353b.findViewById(R.id.game_video_title_bar);
        this.l = (FrameLayout) this.f51353b.findViewById(R.id.game_video_framelayout);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f51353b.findViewById(R.id.game_video_recycle_view);
        this.f51354c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f51352a.getPageActivity()));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f51354c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.B = new d.a.k0.f0.a();
        d.a.k0.j2.i iVar = new d.a.k0.j2.i(this.f51352a, this.f51354c);
        this.v = iVar;
        iVar.u(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.v.t(this.A);
        this.f51355d = (BigdaySwipeRefreshLayout) this.f51353b.findViewById(R.id.game_video_refresh_layout);
        d.a.k0.a1.g.i.a aVar = new d.a.k0.a1.g.i.a(this.f51352a);
        this.f51356e = aVar;
        this.f51355d.setProgressView(aVar);
        int i2 = (int) (this.f51352a.getResources().getDisplayMetrics().density * 86.0f);
        this.f51355d.setCustomDistances(i2, i2, i2 * 2);
        PbListView pbListView = new PbListView(this.f51352a.getPageActivity());
        this.f51357f = pbListView;
        pbListView.a();
        this.f51357f.o(R.color.transparent);
        this.f51357f.r(l.g(this.f51352a.getPageActivity(), R.dimen.tbds178));
        this.f51357f.v();
        this.f51357f.E(R.dimen.tbfontsize36);
        this.f51357f.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f51357f.y(R.color.CAM_X0110);
        this.f51357f.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        d.a.k0.a1.d.a.a aVar2 = new d.a.k0.a1.d.a.a(this.f51352a, this.f51354c);
        this.j = aVar2;
        aVar2.h(this.C);
        this.j.i(this.A);
        this.k = this.f51353b.findViewById(R.id.game_video_divider_shadow);
        this.f51359h = (ImageView) this.f51353b.findViewById(R.id.game_video_select_icon);
        TextView textView = (TextView) this.f51353b.findViewById(R.id.game_video_game_title);
        this.f51360i = textView;
        textView.setText(d.a.j0.r.d0.b.j().p("key_game_video_tab_has_choosed_sub_class_name", ""));
        r();
    }

    public boolean E() {
        return this.t;
    }

    public final boolean F() {
        d.a.j0.d0.g gVar = this.f51358g;
        if (gVar == null) {
            return false;
        }
        return gVar.isViewAttached();
    }

    public void G() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51354c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setSelection(0);
            u();
        }
    }

    public void H(boolean z) {
        this.y = z;
        d.a.k0.j2.i iVar = this.v;
        if (iVar == null) {
            return;
        }
        iVar.q(!z);
        ThreadCardViewHolder v = v();
        boolean z2 = false;
        if (v != null && v.b() != null) {
            z2 = v.b().o(new a.C0549a(8, Boolean.valueOf(z)));
        }
        if (z2) {
            return;
        }
        if (z) {
            this.v.w();
        } else if (this.z) {
            this.v.n(this.w, this.x, this.u, true);
        }
    }

    public void I() {
        d.a.j0.d0.g gVar = this.f51358g;
        if (gVar != null) {
            gVar.m();
        }
        AlphaAnimation alphaAnimation = this.o;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
        }
        AlphaAnimation alphaAnimation2 = this.p;
        if (alphaAnimation2 != null) {
            alphaAnimation2.cancel();
        }
        n0(null);
        d.a.k0.a1.g.i.a aVar = this.f51356e;
        if (aVar != null) {
            aVar.X();
        }
        d.a.k0.a1.d.a.a aVar2 = this.j;
        if (aVar2 != null) {
            aVar2.d();
        }
        RotateAnimation rotateAnimation = this.r;
        if (rotateAnimation != null) {
            rotateAnimation.cancel();
        }
        RotateAnimation rotateAnimation2 = this.s;
        if (rotateAnimation2 != null) {
            rotateAnimation2.cancel();
        }
        d.a.k0.j2.i iVar = this.v;
        if (iVar != null) {
            iVar.h();
        }
        t();
        MessageManager.getInstance().unRegisterListener(this.I);
        MessageManager.getInstance().unRegisterListener(this.F);
    }

    public void J() {
        d.a.k0.a1.d.a.a aVar = this.j;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void K() {
        H(true);
    }

    public void L() {
        d.a.k0.j2.i iVar = this.v;
        if (iVar == null || !this.z) {
            return;
        }
        iVar.n(this.w, this.x, this.u, true);
    }

    public final boolean M(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void N() {
        d.a.k0.a1.d.a.a aVar = this.j;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void O() {
        this.F.setTag(this.A);
        MessageManager.getInstance().registerListener(this.F);
        this.I.setTag(this.A);
        MessageManager.getInstance().registerListener(this.I);
    }

    public void P(String str) {
        List<Integer> z = z(str, this.f51354c);
        int intValue = z.get(0).intValue();
        int intValue2 = z.get(1).intValue();
        if (intValue == -1 || intValue2 == -1) {
            return;
        }
        this.f51354c.E(intValue, intValue2);
    }

    public void Q(boolean z) {
        this.t = z;
    }

    public void R(boolean z) {
        ImageView imageView = this.f51359h;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
        if (z) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f51359h, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundResource(this.n, R.color.CAM_X0201);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f51359h, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundResource(this.n, R.color.CAM_X0207);
    }

    public void S(List<n> list) {
        d.a.k0.a1.d.a.a aVar = this.j;
        if (aVar != null) {
            aVar.f(list);
        }
        L();
    }

    public void T(String str) {
        TextView textView;
        if (StringUtils.isNull(str) || (textView = this.f51360i) == null) {
            return;
        }
        textView.setVisibility(0);
        this.f51360i.setText(str);
    }

    public void U(int i2) {
        d.a.k0.a1.d.a.a aVar = this.j;
        if (aVar != null) {
            aVar.g(i2);
        }
    }

    public void V(f.g gVar) {
        d.a.k0.a1.g.i.a aVar = this.f51356e;
        if (aVar != null) {
            aVar.a(gVar);
        }
    }

    public void W(View.OnClickListener onClickListener) {
        ImageView imageView = this.f51359h;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void X(boolean z) {
        this.z = z;
    }

    public void Y(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51354c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
        }
    }

    public void Z(boolean z) {
        this.y = z;
    }

    public void a0() {
        H(false);
    }

    public void b0(View.OnClickListener onClickListener) {
        PbListView pbListView = this.f51357f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f51354c.setNextPage(this.f51357f);
            }
            this.f51357f.r(l.g(this.f51352a.getPageActivity(), R.dimen.tbds178));
            this.f51357f.A(this.f51352a.getResources().getString(R.string.game_video_click_load));
            this.f51357f.z(onClickListener);
            this.f51357f.f();
        }
    }

    public void c0() {
        if (this.s == null) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.s = rotateAnimation;
            rotateAnimation.setDuration(300L);
            this.s.setInterpolator(new AccelerateInterpolator());
            this.s.setFillAfter(true);
            this.s.setAnimationListener(new animation.Animation$AnimationListenerC1180b());
        }
        this.f51359h.startAnimation(this.s);
    }

    public void d0() {
        if (this.r == null) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.r = rotateAnimation;
            rotateAnimation.setDuration(300L);
            this.r.setInterpolator(new AccelerateInterpolator());
            this.r.setFillAfter(true);
            this.r.setAnimationListener(new a());
        }
        this.f51359h.startAnimation(this.r);
    }

    public void e0() {
        TextView textView = this.f51360i;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void f0() {
        PbListView pbListView = this.f51357f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f51354c.setNextPage(this.f51357f);
            }
            this.f51357f.r(l.g(this.f51352a.getPageActivity(), R.dimen.tbds178));
            this.f51357f.A(this.f51352a.getResources().getString(R.string.loading));
            this.f51357f.z(null);
            this.f51357f.O();
        }
    }

    public void g0() {
        if (F()) {
            return;
        }
        if (this.f51358g == null) {
            d.a.j0.d0.g gVar = new d.a.j0.d0.g(this.f51352a.getPageActivity());
            this.f51358g = gVar;
            gVar.h();
            this.f51358g.q((((this.f51353b.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(this.f51352a.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
            this.f51358g.onChangeSkinType();
        }
        this.f51358g.attachView(this.f51353b, false);
    }

    public void h0(View.OnClickListener onClickListener) {
        if (this.m == null) {
            this.m = new d.a.j0.d0.h(this.f51352a.getPageActivity(), onClickListener);
        }
        this.m.o();
        this.m.l(null);
        this.m.m(this.f51352a.getResources().getString(R.string.refresh_view_title_text));
        this.m.i(R.drawable.new_pic_emotion_08);
        this.m.k(0);
        this.m.attachView(this.l, false);
    }

    public void i0() {
        if (this.m == null) {
            this.m = new d.a.j0.d0.h(this.f51352a.getPageActivity(), null);
        }
        this.m.e();
        this.m.i(R.drawable.new_pic_emotion_03);
        this.m.n(this.f51352a.getString(R.string.no_data_common_txt));
        this.m.attachView(this.l, false);
    }

    public void j0() {
        PbListView pbListView = this.f51357f;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f51354c.setNextPage(this.f51357f);
            }
            this.f51357f.r(l.g(this.f51352a.getPageActivity(), R.dimen.tbds178));
            this.f51357f.A(this.f51352a.getResources().getString(R.string.game_video_no_more));
            this.f51357f.z(null);
            this.f51357f.f();
        }
    }

    public void k0() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.k.setVisibility(0);
        if (this.o == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.o = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.o.setDuration(300L);
        }
        this.k.startAnimation(this.o);
    }

    public void l0() {
        this.f51355d.setRefreshing(true);
    }

    public void m0() {
        d.a.k0.j2.i iVar = this.v;
        if (iVar != null) {
            iVar.w();
        }
    }

    public void n0(f.i iVar) {
        this.f51355d.z(iVar);
    }

    public void r() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.f51359h != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f51359h, R.drawable.icon_pure_more_administration24_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        }
        d.a.j0.d0.g gVar = this.f51358g;
        if (gVar != null) {
            gVar.p(TbadkCoreApplication.getInst().getSkinType());
            this.f51358g.onChangeSkinType();
        }
        d.a.j0.d0.h hVar = this.m;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        TextView textView = this.f51360i;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        d.a.k0.a1.g.i.a aVar = this.f51356e;
        if (aVar != null) {
            aVar.I(skinType);
        }
        d.a.k0.a1.d.a.a aVar2 = this.j;
        if (aVar2 != null) {
            aVar2.c();
        }
    }

    public void s() {
        S(new LinkedList());
    }

    public final void t() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51354c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.removeOnScrollListener(this.K);
            this.f51354c.setOnTouchListener(null);
            this.f51354c.setRecyclerListener(null);
        }
        d.a.k0.f0.a aVar = this.B;
        if (aVar != null) {
            aVar.d(null);
        }
        d.a.k0.a1.g.i.a aVar2 = this.f51356e;
        if (aVar2 != null) {
            aVar2.b(null);
            this.f51356e.l(null);
        }
    }

    public void u() {
        if (this.q) {
            if (this.p == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                this.p = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.p.setDuration(300L);
                this.p.setAnimationListener(new k());
            }
            this.k.startAnimation(this.p);
        }
    }

    public ThreadCardViewHolder v() {
        d.a.k0.j2.i iVar = this.v;
        if (iVar == null || iVar.j() == null || !(this.v.j().getTag() instanceof ThreadCardViewHolder)) {
            return null;
        }
        return (ThreadCardViewHolder) this.v.j().getTag();
    }

    public List<n> w() {
        d.a.k0.a1.d.a.a aVar = this.j;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public View x() {
        return this.f51353b.findViewById(R.id.game_video_title_bar);
    }

    public View y() {
        return this.f51353b;
    }

    public final List<Integer> z(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        ArrayList arrayList = new ArrayList(2);
        boolean z = false;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
            n B = bdTypeRecyclerView.B(i4);
            if (B instanceof d.a.k0.x.e0.b) {
                d.a.k0.x.e0.b bVar = (d.a.k0.x.e0.b) B;
                if (bVar.m() != null && bVar.m().x1().equals(str)) {
                    if (!z) {
                        i2 = i4;
                    }
                    z = true;
                    i3 = i4;
                }
            }
        }
        arrayList.add(Integer.valueOf(i2));
        arrayList.add(Integer.valueOf(i3));
        return arrayList;
    }
}
