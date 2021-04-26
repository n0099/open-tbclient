package d.a.j0.i2.j;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.tieba.personPolymeric.header.PersonHeaderBackgroundController;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterMainTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import com.google.android.material.appbar.AppBarLayout;
import d.a.j0.t2.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class p {
    public static int T = 5000;
    public static final float U = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    public FrameLayout A;
    public RelativeLayout B;
    public int C;
    public int D;
    public GradientDrawable E;
    public FrameLayout F;
    public FrameLayout.LayoutParams G;
    public AlphaAnimation H;
    public AlphaAnimation I;
    public d.a.j0.i2.g.b J;
    public d.a.j0.i2.j.k K;
    public ValueAnimator L;
    public long M;
    public boolean N;
    public int O;
    public int P;
    public boolean Q;
    public Runnable R;
    public d.a.j0.i2.d.a S;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55648a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f55649b;

    /* renamed from: c  reason: collision with root package name */
    public PluginErrorTipView f55650c;

    /* renamed from: d  reason: collision with root package name */
    public View f55651d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.s1.a f55652e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f55653f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f55654g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f55655h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f55656i;
    public d.a.j0.i2.e.a j;
    public boolean k;
    public BdUniqueId l;
    public d.a.j0.i2.d.f m;
    public BaseFragment n;
    public float[] o;
    public float p;
    public int q;
    public PullRefreshFrameLayout r;
    public PersonHeaderBackgroundController s;
    public AppBarLayout t;
    public FrameLayout u;
    public NewPagerSlidingTabBaseStrip v;
    public View w;
    public CustomViewPager x;
    public C1316p y;
    public LinearLayout z;

    /* loaded from: classes4.dex */
    public class a implements PullRefreshFrameLayout.i {

        /* renamed from: d.a.j0.i2.j.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1315a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f55658e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f55659f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f55660g;

            public C1315a(int i2, int i3, int i4) {
                this.f55658e = i2;
                this.f55659f = i3;
                this.f55660g = i4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                p.this.G.height = (int) (this.f55658e - (this.f55659f * animatedFraction));
                p.this.F.setLayoutParams(p.this.G);
                if (p.this.s != null) {
                    p.this.s.j((int) (this.f55660g - (animatedFraction * this.f55659f)));
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Animator.AnimatorListener {
            public b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                p pVar = p.this;
                pVar.D = pVar.G.height;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        /* loaded from: classes4.dex */
        public class c implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f55663e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f55664f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f55665g;

            public c(int i2, int i3, int i4) {
                this.f55663e = i2;
                this.f55664f = i3;
                this.f55665g = i4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                p.this.G.height = (int) (this.f55663e - (this.f55664f * floatValue));
                p.this.F.setLayoutParams(p.this.G);
                if (p.this.s == null || this.f55665g <= 0) {
                    return;
                }
                p.this.s.j((int) (this.f55665g - (floatValue * this.f55664f)));
            }
        }

        /* loaded from: classes4.dex */
        public class d implements Animator.AnimatorListener {
            public d() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (p.this.Q) {
                    p.this.J.M();
                }
                p.this.D = 0;
                p.this.G.height = -2;
                p.this.F.setLayoutParams(p.this.G);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public a() {
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void k() {
            int measuredHeight = p.this.F.getMeasuredHeight();
            int i2 = (measuredHeight - p.this.C) - (p.this.Q ? d.a.j0.i2.g.a.b0 : 0);
            int g2 = p.this.s != null ? p.this.s.g() : 0;
            if (p.this.Q) {
                p.this.J.J(false);
                p.this.J.H();
            }
            if (i2 > 0 || (i2 == 0 && p.this.Q)) {
                p.this.L = ValueAnimator.ofFloat(0.0f, 1.0f);
                p.this.L.setDuration(300L);
                p.this.L.addUpdateListener(new c(measuredHeight, i2, g2));
                p.this.L.start();
                p.this.L.addListener(new d());
            }
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void l(double d2) {
            p.this.G.height = (int) (p.this.C + (p.this.Q ? d.a.j0.i2.g.a.b0 : 0) + (PullRefreshFrameLayout.D * d2));
            p.this.F.setLayoutParams(p.this.G);
            if (p.this.s != null) {
                p.this.s.h(d2);
            }
            p.this.r.r();
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.i
        public void m(int i2, double d2) {
            p.this.L = ValueAnimator.ofFloat(0.0f, 1.0f);
            p.this.L.setDuration(150L);
            p.this.L.addUpdateListener(new C1315a(p.this.F.getMeasuredHeight(), i2, p.this.s.g()));
            p.this.L.addListener(new b());
            p.this.L.start();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p pVar;
            if (p.this.C == 0) {
                p pVar2 = p.this;
                pVar2.C = pVar2.F.getMeasuredHeight();
                p.this.p = pVar.F.getMeasuredHeight() - p.this.K.e().getMeasuredHeight();
                if (p.this.s != null) {
                    p pVar3 = p.this;
                    pVar3.P = pVar3.q + p.this.K.e().getMeasuredHeight() + p.this.F.getMeasuredHeight() + p.this.v.getMeasuredHeight();
                    boolean z = (p.this.k || p.this.j.j() == null || p.this.j.j().getNewGodData() == null || !p.this.j.j().getNewGodData().isNewGod()) ? false : true;
                    p.this.G.height = p.this.P;
                    p.this.F.setLayoutParams(p.this.G);
                    p.this.P += z ? d.a.j0.i2.g.a.b0 : 0;
                    p.this.s.i(p.this.P);
                    p.this.G.height = -2;
                    p.this.F.setLayoutParams(p.this.G);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof d.a.j0.t2.b)) {
                SparseArray<b.a> sparseArray = ((d.a.j0.t2.b) customResponsedMessage.getData()).f61229a;
                if (sparseArray.size() <= 0) {
                    return;
                }
                b.a aVar = sparseArray.get(2);
                if (p.this.J != null && aVar != null) {
                    p.this.J.K(aVar.f61230a);
                }
                b.a aVar2 = sparseArray.get(4);
                b.a aVar3 = sparseArray.get(3);
                b.a aVar4 = sparseArray.get(1);
                b.a aVar5 = sparseArray.get(7);
                b.a aVar6 = sparseArray.get(8);
                if (p.this.j != null) {
                    if (p.this.j.w != null && p.this.j.w.f55545b != null && aVar2 != null) {
                        p.this.j.w.f55545b.putBoolean("person_center_item_red_tip_show", aVar2.f61230a);
                    }
                    if (aVar3 != null && p.this.j.v != null && p.this.j.v.f55545b != null) {
                        p.this.j.v.f55545b.putBoolean("person_center_item_red_tip_show", aVar3.f61230a);
                    }
                    if (aVar4 != null && p.this.j.u != null && p.this.j.u.f55545b != null) {
                        p.this.j.u.f55545b.putBoolean("person_center_item_red_tip_show", aVar4.f61230a);
                    }
                    if (aVar5 != null && p.this.j.x != null && p.this.j.x.f55545b != null) {
                        p.this.j.x.f55545b.putBoolean("person_center_item_red_tip_show", aVar5.f61230a);
                    }
                    if (aVar6 == null || p.this.j.y == null || p.this.j.y.f55545b == null) {
                        return;
                    }
                    p.this.j.y.f55545b.putBoolean("person_center_item_red_tip_show", aVar6.f61230a);
                    p.this.j.y.f55545b.putString("person_center_item_txt", String.valueOf(aVar6.f61231b));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.i0.t.n nVar;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.i0.t.n) || (nVar = (d.a.i0.t.n) customResponsedMessage.getData()) == null) {
                return;
            }
            p.this.J.N(nVar.a());
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && p.this.O == ((Integer) customResponsedMessage.getData()).intValue() && p.this.N) {
                d.a.c.e.m.e.a().removeCallbacks(p.this.R);
                p.this.Z();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.N) {
                p.this.Z();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.a.j0.i2.d.a {
        public g() {
        }

        @Override // d.a.j0.i2.d.a
        public void a(int i2) {
            p.this.G.height = -2;
            p.this.F.setLayoutParams(p.this.G);
        }

        @Override // d.a.j0.i2.d.a
        public void b(boolean z) {
            p.this.Q = z;
            if (!z) {
                p.this.s.i(p.this.P);
            }
            if (p.this.J == null || p.this.J.B() == null) {
                return;
            }
            p.this.J.B().setOpen(z);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements PullRefreshFrameLayout.h {
        public h() {
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.h
        public void m() {
            d.a.c.e.m.e.a().postDelayed(p.this.R, p.T);
            p.this.N = true;
            p pVar = p.this;
            pVar.O = pVar.y.d();
            p.this.Q();
            p.this.y.c();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements PullRefreshFrameLayout.f {
        public i() {
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.f
        public void onCancel() {
            p.this.D = 0;
            p.this.G.height = -2;
            p.this.F.setLayoutParams(p.this.G);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements PullRefreshFrameLayout.g {
        public j() {
        }

        @Override // com.baidu.tbadk.core.view.PullRefreshFrameLayout.g
        public void onLoadingStart() {
            p.this.G.height = -2;
            p.this.F.setLayoutParams(p.this.G);
        }
    }

    /* loaded from: classes4.dex */
    public class k implements AppBarLayout.OnOffsetChangedListener {
        public k() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(i2 == 0, p.this.f55648a.getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(true, p.this.f55648a.getPageActivity());
            }
            p.this.r.setInterceptScrollDown(i2 == 0);
            int abs = Math.abs(i2);
            p.this.K.i(abs == 0);
            float f2 = abs;
            p.this.K.m(f2 > p.this.p / 2.0f);
            float abs2 = ((double) p.this.p) == 0.0d ? 0.0f : Math.abs(f2 / p.this.p);
            p.this.K.h(abs2);
            if (abs2 >= 1.0f) {
                p.this.o = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                p.this.E.setCornerRadii(p.this.o);
                p.this.u.setBackgroundDrawable(p.this.E);
                p.this.c0();
            } else {
                p.this.o = new float[]{p.U, p.U, p.U, p.U, 0.0f, 0.0f, 0.0f, 0.0f};
                p.this.E.setCornerRadii(p.this.o);
                p.this.u.setBackgroundDrawable(p.this.E);
                p.this.S();
            }
            int i3 = p.this.D - p.this.C;
            if (p.this.D <= 0 || Math.abs(i2) < i3) {
                return;
            }
            p.this.r.i();
        }
    }

    /* loaded from: classes4.dex */
    public class l implements ViewPager.OnPageChangeListener {
        public l() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            p.this.y.h(i2);
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public m(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || p.this.K == null) {
                return;
            }
            p.this.K.n();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Animation.AnimationListener {
        public n() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            p.this.H.reset();
            p.this.H = null;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class o implements Animation.AnimationListener {
        public o() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            p.this.w.setVisibility(8);
            p.this.I.reset();
            p.this.I = null;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: d.a.j0.i2.j.p$p  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1316p extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f55682a;

        /* renamed from: b  reason: collision with root package name */
        public List<PersonCenterTabBaseFragment> f55683b;

        public C1316p(p pVar, FragmentManager fragmentManager) {
            super(fragmentManager);
            ArrayList arrayList = new ArrayList();
            this.f55682a = arrayList;
            arrayList.add(pVar.f55648a.getResources().getString(R.string.person_center_tab_main));
            this.f55682a.add(pVar.f55648a.getResources().getString(R.string.person_center_tab_thread));
            this.f55682a.add(pVar.f55648a.getResources().getString(R.string.person_center_tab_dynamic));
            ArrayList arrayList2 = new ArrayList();
            this.f55683b = arrayList2;
            arrayList2.add(PersonCenterMainTabFragment.K0(pVar.M, pVar.k));
            this.f55683b.add(PersonCenterThreadTabFragment.Q0(pVar.M, pVar.k));
            this.f55683b.add(PersonCenterDynamicTabFragment.N0(pVar.M, pVar.k));
        }

        public void c() {
            if (ListUtils.isEmpty(this.f55683b)) {
                return;
            }
            for (int i2 = 0; i2 < this.f55683b.size(); i2++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f55683b.get(i2);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.E0(false);
                }
            }
        }

        public int d() {
            if (ListUtils.isEmpty(this.f55683b)) {
                return -1;
            }
            for (int i2 = 0; i2 < this.f55683b.size(); i2++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f55683b.get(i2);
                if (personCenterTabBaseFragment != null && personCenterTabBaseFragment.isPrimary()) {
                    return personCenterTabBaseFragment.F0();
                }
            }
            return -1;
        }

        public PersonCenterTabBaseFragment e(int i2) {
            if (i2 < this.f55683b.size()) {
                return this.f55683b.get(i2);
            }
            return null;
        }

        public final String f(int i2) {
            return this.f55682a.get(i2);
        }

        public void g(int i2) {
            List<PersonCenterTabBaseFragment> list = this.f55683b;
            if (list == null || list.size() <= 0) {
                return;
            }
            int size = this.f55683b.size();
            for (int i3 = 0; i3 < size; i3++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f55683b.get(i3);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.onChangeSkinType(i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            List<PersonCenterTabBaseFragment> list = this.f55683b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            return e(i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            return f(i2);
        }

        public void h(int i2) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            for (int i3 = 0; i3 < this.f55682a.size() && (personCenterTabBaseFragment = this.f55683b.get(i3)) != null; i3++) {
                if (i3 == i2) {
                    personCenterTabBaseFragment.setPrimary(true);
                } else {
                    personCenterTabBaseFragment.setPrimary(false);
                }
            }
        }

        public void i(d.a.j0.i2.e.a aVar) {
            if (aVar == null || ListUtils.isEmpty(this.f55683b)) {
                return;
            }
            for (int i2 = 0; i2 < this.f55683b.size(); i2++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f55683b.get(i2);
                if (personCenterTabBaseFragment instanceof PersonCenterMainTabFragment) {
                    ((PersonCenterMainTabFragment) personCenterTabBaseFragment).M0(aVar);
                }
            }
        }

        public void j(d.a.j0.i2.e.a aVar) {
            if (aVar == null || aVar.i() == null || ListUtils.isEmpty(this.f55683b)) {
                return;
            }
            for (int i2 = 0; i2 < this.f55683b.size(); i2++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f55683b.get(i2);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.H0(aVar.C);
                    personCenterTabBaseFragment.I0(aVar.i());
                }
            }
        }
    }

    public p(BaseFragment baseFragment, d.a.j0.i2.d.g gVar, BdUniqueId bdUniqueId, boolean z, long j2) {
        float f2 = U;
        this.o = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
        this.p = 674.0f;
        this.N = false;
        this.O = -1;
        this.R = new f();
        this.S = new g();
        this.n = baseFragment;
        this.f55648a = baseFragment.getPageContext();
        this.l = bdUniqueId;
        this.k = z;
        this.M = j2;
        this.m = gVar.l();
        V(gVar.f55448i);
    }

    public d.a.j0.i2.g.b P() {
        return this.J;
    }

    public void Q() {
        if (d.a.c.e.p.j.z()) {
            this.f55652e.f();
            this.f55652e.g();
            this.m.l();
            return;
        }
        this.m.p();
    }

    public void R() {
        this.m.p();
    }

    public void S() {
        AlphaAnimation alphaAnimation;
        if (W() && (alphaAnimation = this.I) == null && alphaAnimation == null) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.I = alphaAnimation2;
            alphaAnimation2.setFillAfter(true);
            this.I.setDuration(300L);
            this.I.setAnimationListener(new o());
            this.w.startAnimation(this.I);
        }
    }

    public final void T(TbPageContext tbPageContext) {
        m mVar = new m(2005016);
        this.f55656i = mVar;
        mVar.setTag(this.l);
        tbPageContext.registerListener(this.f55656i);
    }

    public final void U(TbPageContext tbPageContext) {
        c cVar = new c(2001435);
        this.f55653f = cVar;
        cVar.setTag(this.l);
        tbPageContext.registerListener(this.f55653f);
        d dVar = new d(2016485);
        this.f55654g = dVar;
        dVar.setTag(this.l);
        tbPageContext.registerListener(this.f55654g);
        e eVar = new e(2921435);
        this.f55655h = eVar;
        eVar.setTag(this.l);
        tbPageContext.registerListener(this.f55655h);
    }

    public final void V(View view) {
        this.f55651d = view;
        this.q = UtilHelper.getStatusBarHeight();
        this.r = (PullRefreshFrameLayout) this.f55651d.findViewById(R.id.person_center_content_view);
        View findViewById = this.f55651d.findViewById(R.id.person_center_background_cover);
        this.s = new PersonHeaderBackgroundController(this.f55648a, (TbImageView) this.f55651d.findViewById(R.id.person_center_header_bg), findViewById, this.k);
        TbPageContext tbPageContext = this.f55648a;
        View view2 = this.f55651d;
        this.K = new d.a.j0.i2.j.k(tbPageContext, view2, view2.findViewById(R.id.person_center_status_bar_space), this.k);
        FrameLayout frameLayout = (FrameLayout) this.f55651d.findViewById(R.id.person_center_header_container);
        this.F = frameLayout;
        this.G = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
        this.r.setOnTouchCallback(new a());
        this.r.setOnPullRefreshListener(new h());
        this.r.setOnCancelCallBack(new i());
        this.r.setOnLoadingStartCallback(new j());
        AppBarLayout appBarLayout = (AppBarLayout) this.f55651d.findViewById(R.id.person_center_app_bar_layout);
        this.t = appBarLayout;
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new k());
        this.u = (FrameLayout) this.f55651d.findViewById(R.id.person_center_tab_layout_container);
        NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) this.f55651d.findViewById(R.id.person_center_tab_layout);
        this.v = newPagerSlidingTabBaseStrip;
        newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        this.v.setRectPaintColor(R.color.CAM_X0302);
        this.v.B(d.a.c.e.p.l.g(this.f55648a.getPageActivity(), R.dimen.tbds46), d.a.c.e.p.l.g(this.f55648a.getPageActivity(), R.dimen.tbds46), d.a.c.e.p.l.g(this.f55648a.getPageActivity(), R.dimen.tbds10), d.a.c.e.p.l.g(this.f55648a.getPageActivity(), R.dimen.tbds46), true);
        this.v.setIndicatorOffset(d.a.c.e.p.l.g(this.f55648a.getPageActivity(), R.dimen.tbds64));
        this.v.setIndicatorOvershot(d.a.c.e.p.l.g(this.f55648a.getPageActivity(), R.dimen.tbds8));
        this.v.setIndicatorRadius(d.a.c.e.p.l.g(this.f55648a.getPageActivity(), R.dimen.tbds8));
        this.v.setIndicatorMarginBottom(d.a.c.e.p.l.g(this.f55648a.getPageActivity(), R.dimen.tbds0));
        this.v.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(d.a.c.e.p.l.g(this.f55648a.getPageActivity(), R.dimen.tbds166), -1));
        this.v.setOnPageChangeListener(new l());
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.E = gradientDrawable;
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0201));
        this.E.setCornerRadii(this.o);
        this.u.setBackgroundDrawable(this.E);
        View findViewById2 = this.f55651d.findViewById(R.id.person_center_pager_shadow);
        this.w = findViewById2;
        SkinManager.setBackgroundResource(findViewById2, R.drawable.personalize_tab_shadow);
        this.x = (CustomViewPager) this.f55651d.findViewById(R.id.person_center_view_pager);
        C1316p c1316p = new C1316p(this, this.n.getActivity().getSupportFragmentManager());
        this.y = c1316p;
        this.x.setAdapter(c1316p);
        this.x.setOffscreenPageLimit(this.y.f55683b.size());
        this.y.notifyDataSetChanged();
        this.v.setViewPager(this.x);
        this.x.setCurrentItem(1);
        d.a.j0.i2.g.b bVar = new d.a.j0.i2.g.b(this.f55648a, this.k);
        this.J = bVar;
        bVar.I(this.S);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.F.addView(this.J.C(), layoutParams);
        if (this.K.f()) {
            U(this.f55648a);
        }
        T(this.f55648a);
        this.f55649b = (NoNetworkView) this.f55651d.findViewById(R.id.person_center_no_network_view);
        this.f55650c = (PluginErrorTipView) this.f55651d.findViewById(R.id.person_center_plugin_error_tip_view);
        this.z = (LinearLayout) this.f55651d.findViewById(R.id.person_center_anti_container);
        this.A = (FrameLayout) this.f55651d.findViewById(R.id.person_center_anti_content);
        this.B = (RelativeLayout) this.f55651d.findViewById(R.id.person_center_noanti_rootview);
    }

    public final boolean W() {
        return this.w.getVisibility() == 0;
    }

    public void X(int i2) {
        d.a.j0.i2.j.k kVar = this.K;
        if (kVar != null) {
            kVar.g(i2);
        }
        NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.v;
        if (newPagerSlidingTabBaseStrip != null) {
            newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.v.setRectPaintColor(R.color.CAM_X0302);
            this.v.G();
        }
        GradientDrawable gradientDrawable = this.E;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0201));
        }
        d.a.j0.i2.g.b bVar = this.J;
        if (bVar != null) {
            bVar.F(i2);
        }
        C1316p c1316p = this.y;
        if (c1316p != null) {
            c1316p.g(i2);
        }
        NoNetworkView noNetworkView = this.f55649b;
        if (noNetworkView != null) {
            noNetworkView.c(this.f55648a, i2);
        }
        PluginErrorTipView pluginErrorTipView = this.f55650c;
        if (pluginErrorTipView != null) {
            pluginErrorTipView.e(this.f55648a, i2);
        }
        SkinManager.setBackgroundResource(this.z, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.f55651d, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.w, R.drawable.personalize_tab_shadow);
    }

    public void Y() {
        d.a.j0.i2.g.b bVar = this.J;
        if (bVar != null) {
            bVar.G();
        }
        PullRefreshFrameLayout pullRefreshFrameLayout = this.r;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.q();
        }
        ValueAnimator valueAnimator = this.L;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.L.removeAllListeners();
            this.L.removeAllUpdateListeners();
            this.L = null;
        }
        d.a.c.e.m.e.a().removeCallbacks(this.R);
    }

    public final void Z() {
        this.O = -1;
        this.N = false;
        PullRefreshFrameLayout pullRefreshFrameLayout = this.r;
        if (pullRefreshFrameLayout != null) {
            pullRefreshFrameLayout.p();
        }
    }

    public void a0(d.a.j0.s1.a aVar) {
        this.f55652e = aVar;
    }

    public void b0(d.a.j0.u3.f fVar) {
        d.a.j0.i2.j.k kVar = this.K;
        if (kVar != null) {
            kVar.j(fVar);
        }
    }

    public void c0() {
        if (W() || this.H != null) {
            return;
        }
        this.w.setVisibility(0);
        if (this.H == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.H = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.H.setDuration(300L);
            this.H.setAnimationListener(new n());
            this.w.startAnimation(this.H);
        }
    }

    public void d0(d.a.j0.i2.e.a aVar, boolean z, PersonStatus personStatus) {
        if (aVar == null) {
            return;
        }
        this.j = aVar;
        this.z.setVisibility(8);
        this.B.setVisibility(0);
        d.a.j0.i2.j.k kVar = this.K;
        if (kVar != null) {
            kVar.l(aVar, personStatus);
        }
        d.a.j0.i2.g.b bVar = this.J;
        if (bVar != null) {
            bVar.p(aVar);
        }
        PersonHeaderBackgroundController personHeaderBackgroundController = this.s;
        if (personHeaderBackgroundController != null) {
            personHeaderBackgroundController.e(this.j.j());
        }
        this.F.post(new b());
        this.y.j(aVar);
        this.y.i(aVar);
        if (ListUtils.isEmpty(aVar.f())) {
            this.m.m();
            d.a.c.e.p.l.M(this.f55648a.getContext(), this.f55648a.getString(R.string.data_load_error));
            return;
        }
        d.a.j0.t2.a.v().K(this.k);
        int size = aVar.f().size();
        for (int i2 = 0; i2 < size; i2++) {
            d.a.c.j.e.n nVar = aVar.f().get(i2);
            if (nVar != null && (nVar instanceof d.a.j0.i2.e.i)) {
                this.m.m();
                return;
            }
        }
        if (z) {
            return;
        }
        this.m.z(true, aVar.f());
    }
}
