package d.b.i0.z2.h;

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
import d.b.b.e.p.l;
import d.b.h0.r.f0.g;
/* loaded from: classes5.dex */
public class c {
    public ProgressBar A;
    public boolean B;
    public int C = 0;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f63508a;

    /* renamed from: b  reason: collision with root package name */
    public final View f63509b;

    /* renamed from: c  reason: collision with root package name */
    public final View f63510c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager f63511d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f63512e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBar f63513f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f63514g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f63515h;
    public BdListView i;
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
    public d.b.i0.z2.h.a y;
    public LinearLayout z;

    /* loaded from: classes5.dex */
    public class a implements View.OnKeyListener {
        public a() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && c.this.u.isShowing()) {
                c cVar = c.this;
                d.b.b.e.m.g.d(cVar.u, cVar.w.getPageContext().getPageActivity());
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
                d.b.b.e.m.g.d(cVar.u, cVar.w.getPageContext().getPageActivity());
                return false;
            }
            return false;
        }
    }

    /* renamed from: d.b.i0.z2.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1719c implements PopupWindow.OnDismissListener {
        public C1719c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            c.this.B = false;
        }
    }

    public c(ForumListActivity forumListActivity) {
        this.B = false;
        this.f63508a = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        ViewPager viewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.f63511d = viewPager;
        viewPager.setOnPageChangeListener(forumListActivity);
        this.f63512e = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        NavigationBar navigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.f63513f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        LinearLayout linearLayout = (LinearLayout) this.f63513f.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.z = linearLayout;
        this.f63514g = (TextView) linearLayout.findViewById(R.id.title_text);
        this.f63515h = (ImageView) this.z.findViewById(R.id.forum_list_title_arrow);
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
        this.f63509b = linearLayout2.findViewById(R.id.footer_background);
        this.n = (TextView) this.m.findViewById(R.id.footer_text);
        this.o = (ImageView) this.m.findViewById(R.id.footer_icon);
        LinearLayout linearLayout3 = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.p = linearLayout3;
        this.f63510c = linearLayout3.findViewById(R.id.footer_background);
        this.q = (TextView) this.p.findViewById(R.id.footer_text);
        this.r = (ImageView) this.p.findViewById(R.id.footer_icon);
        this.A = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.B = false;
        this.w = forumListActivity;
        this.y = new d.b.i0.z2.h.a(this.w.getPageContext().getContext());
    }

    public View b(int i, AdapterView.OnItemClickListener onItemClickListener) {
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
        this.f63512e.setVisibility(8);
    }

    public void d() {
        BdListView bdListView;
        ProgressBar progressBar = this.A;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        ViewPager viewPager = this.f63511d;
        if (viewPager == null) {
            return;
        }
        if (viewPager.getCurrentItem() == 0 && (bdListView = this.i) != null) {
            bdListView.A(0L);
            return;
        }
        BdListView bdListView2 = this.j;
        if (bdListView2 != null) {
            bdListView2.A(0L);
        }
    }

    public void e() {
        this.f63515h.setVisibility(4);
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
            d.b.b.e.m.g.l(this.u, this.z, 0 - e2, l.e(this.w.getPageContext().getPageActivity(), 0.0f));
            this.v.setOnKeyListener(new a());
            this.v.setOnTouchListener(new b());
            this.u.setOnDismissListener(new C1719c());
            return;
        }
        d.b.b.e.m.g.d(this.u, this.w.getPageContext().getPageActivity());
        this.B = false;
    }

    public void g() {
        this.f63512e.setVisibility(0);
    }

    public void h() {
        this.f63515h.setVisibility(0);
    }
}
