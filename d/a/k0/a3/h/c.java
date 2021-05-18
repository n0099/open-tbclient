package d.a.k0.a3.h;

import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.square.flist.ForumListActivity;
import d.a.c.e.p.l;
import d.a.j0.r.f0.g;
/* loaded from: classes5.dex */
public class c {
    public ProgressBar A;
    public boolean B;
    public int C = 0;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f51982a;

    /* renamed from: b  reason: collision with root package name */
    public final View f51983b;

    /* renamed from: c  reason: collision with root package name */
    public final View f51984c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager f51985d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f51986e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f51987f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51988g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f51989h;

    /* renamed from: i  reason: collision with root package name */
    public BdListView f51990i;
    public BdListView j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public TextView n;
    public ImageView o;
    public LinearLayout p;
    public TextView q;
    public ImageView r;
    public g s;
    public g t;
    public PopupWindow u;
    public View v;
    public ForumListActivity w;
    public ListView x;
    public d.a.k0.a3.h.a y;
    public LinearLayout z;

    /* loaded from: classes5.dex */
    public class a implements View.OnKeyListener {
        public a() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 == 4 && c.this.u.isShowing()) {
                c cVar = c.this;
                d.a.c.e.m.g.d(cVar.u, cVar.w.getPageContext().getPageActivity());
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.u.isShowing()) {
                c cVar = c.this;
                d.a.c.e.m.g.d(cVar.u, cVar.w.getPageContext().getPageActivity());
                return false;
            }
            return false;
        }
    }

    /* renamed from: d.a.k0.a3.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1206c implements PopupWindow.OnDismissListener {
        public C1206c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            c.this.B = false;
        }
    }

    public c(ForumListActivity forumListActivity) {
        this.B = false;
        this.f51982a = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        ViewPager viewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.f51985d = viewPager;
        viewPager.setOnPageChangeListener(forumListActivity);
        this.f51986e = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        NavigationBar navigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.f51987f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        LinearLayout linearLayout = (LinearLayout) this.f51987f.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.z = linearLayout;
        this.f51988g = (TextView) linearLayout.findViewById(R.id.title_text);
        this.f51989h = (ImageView) this.z.findViewById(R.id.forum_list_title_arrow);
        TextView textView = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.k = textView;
        textView.setOnClickListener(forumListActivity);
        TextView textView2 = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.l = textView2;
        textView2.setOnClickListener(forumListActivity);
        this.s = new g(forumListActivity.getPageContext());
        this.t = new g(forumListActivity.getPageContext());
        LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.m = linearLayout2;
        this.f51983b = linearLayout2.findViewById(R.id.footer_background);
        this.n = (TextView) this.m.findViewById(R.id.footer_text);
        this.o = (ImageView) this.m.findViewById(R.id.footer_icon);
        LinearLayout linearLayout3 = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.p = linearLayout3;
        this.f51984c = linearLayout3.findViewById(R.id.footer_background);
        this.q = (TextView) this.p.findViewById(R.id.footer_text);
        this.r = (ImageView) this.p.findViewById(R.id.footer_icon);
        this.A = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.B = false;
        this.w = forumListActivity;
        this.y = new d.a.k0.a3.h.a(this.w.getPageContext().getContext());
    }

    public View b(int i2, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.w.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.x = listView;
        listView.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.C = this.y.getCount();
        this.x.setAdapter((ListAdapter) this.y);
        return inflate;
    }

    public void c() {
        this.f51986e.setVisibility(8);
    }

    public void d() {
        BdListView bdListView;
        ProgressBar progressBar = this.A;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        ViewPager viewPager = this.f51985d;
        if (viewPager == null) {
            return;
        }
        if (viewPager.getCurrentItem() == 0 && (bdListView = this.f51990i) != null) {
            bdListView.A(0L);
            return;
        }
        BdListView bdListView2 = this.j;
        if (bdListView2 != null) {
            bdListView2.A(0L);
        }
    }

    public void e() {
        this.f51989h.setVisibility(4);
        this.z.setClickable(false);
        this.z.setOnClickListener(null);
    }

    public void f(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.B) {
            this.B = true;
            if (this.v == null) {
                this.v = b(0, onItemClickListener);
            }
            int e2 = (l.e(this.w.getPageContext().getPageActivity(), 160.0f) - this.z.getWidth()) / 2;
            if (this.u == null) {
                PopupWindow popupWindow = new PopupWindow(this.v, l.e(this.w.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.u = popupWindow;
                popupWindow.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.C > 6) {
                    this.u.setHeight(l.e(this.w.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.u.setOutsideTouchable(true);
            this.u.setFocusable(true);
            this.v.setFocusable(true);
            this.v.setFocusableInTouchMode(true);
            d.a.c.e.m.g.l(this.u, this.z, 0 - e2, l.e(this.w.getPageContext().getPageActivity(), 0.0f));
            this.v.setOnKeyListener(new a());
            this.v.setOnTouchListener(new b());
            this.u.setOnDismissListener(new C1206c());
            return;
        }
        d.a.c.e.m.g.d(this.u, this.w.getPageContext().getPageActivity());
        this.B = false;
    }

    public void g() {
        this.f51986e.setVisibility(0);
    }

    public void h() {
        this.f51989h.setVisibility(0);
    }
}
