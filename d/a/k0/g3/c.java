package d.a.k0.g3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncher.MainTabActivity;
import d.a.c.e.m.g;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f55326a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f55327b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f55328c;

    /* renamed from: d  reason: collision with root package name */
    public String f55329d;

    /* renamed from: e  reason: collision with root package name */
    public long f55330e;

    /* renamed from: f  reason: collision with root package name */
    public View f55331f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55332g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f55333h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f55334i = new a();
    public Runnable j = new b();
    public View.OnClickListener k = new View$OnClickListenerC1343c();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f55328c == null || c.this.f55327b == null || c.this.f55327b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = c.this.f55328c.getFragmentTabWidget();
            int k = l.k(c.this.f55326a.getActivity());
            int g2 = l.g(c.this.f55326a.getActivity(), R.dimen.ds278);
            c.this.f55327b.getContentView().measure(0, 0);
            g.l(c.this.f55327b, fragmentTabWidget, (k - l.g(c.this.f55326a.getActivity(), R.dimen.ds430)) / 2, -g2);
            d.a.j0.r.d0.b.j().w("home_tip", c.this.f55330e);
            d.a.c.e.m.e.a().postDelayed(c.this.j, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 1));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.g();
        }
    }

    /* renamed from: d.a.k0.g3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1343c implements View.OnClickListener {
        public View$OnClickListenerC1343c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.h();
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            WriteActivityConfig.newInstance(c.this.f55326a).setType(9).setTitle(c.this.f55329d).setForumId("0").send();
            TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 1));
        }
    }

    public c(MainTabActivity mainTabActivity) {
        this.f55326a = mainTabActivity;
        this.f55328c = (FragmentTabHost) mainTabActivity.findViewById(R.id.tab_host);
    }

    public void g() {
        g.c(this.f55327b);
    }

    public void h() {
        d.a.c.e.m.e.a().removeCallbacks(this.f55334i);
        d.a.c.e.m.e.a().removeCallbacks(this.j);
        g();
    }

    public void i() {
        h();
    }

    public void j(String str, String str2, long j) {
        if (d.a.j0.r.d0.b.j().l("home_tip", 0L) == j || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        this.f55329d = str2;
        this.f55330e = j;
        if (this.f55331f == null) {
            View inflate = LayoutInflater.from(this.f55326a.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
            this.f55331f = inflate;
            this.f55332g = (TextView) inflate.findViewById(R.id.tips);
            this.f55333h = (TextView) this.f55331f.findViewById(R.id.tips_content);
            this.f55331f.setOnClickListener(this.k);
        }
        this.f55332g.setText(StringHelper.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
        this.f55333h.setText(R.string.topic_join);
        if (this.f55327b == null) {
            this.f55327b = new PopupWindow(this.f55331f, -2, -2);
        } else {
            h();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.f55334i);
        d.a.c.e.m.e.a().postDelayed(this.f55334i, 100L);
    }
}
