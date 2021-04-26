package d.a.j0.g3;

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
    public MainTabActivity f54619a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f54620b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f54621c;

    /* renamed from: d  reason: collision with root package name */
    public String f54622d;

    /* renamed from: e  reason: collision with root package name */
    public long f54623e;

    /* renamed from: f  reason: collision with root package name */
    public View f54624f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54625g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54626h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f54627i = new a();
    public Runnable j = new b();
    public View.OnClickListener k = new View$OnClickListenerC1271c();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f54621c == null || c.this.f54620b == null || c.this.f54620b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = c.this.f54621c.getFragmentTabWidget();
            int k = l.k(c.this.f54619a.getActivity());
            int g2 = l.g(c.this.f54619a.getActivity(), R.dimen.ds278);
            c.this.f54620b.getContentView().measure(0, 0);
            g.l(c.this.f54620b, fragmentTabWidget, (k - l.g(c.this.f54619a.getActivity(), R.dimen.ds430)) / 2, -g2);
            d.a.i0.r.d0.b.j().w("home_tip", c.this.f54623e);
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

    /* renamed from: d.a.j0.g3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1271c implements View.OnClickListener {
        public View$OnClickListenerC1271c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.h();
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            WriteActivityConfig.newInstance(c.this.f54619a).setType(9).setTitle(c.this.f54622d).setForumId("0").send();
            TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 1));
        }
    }

    public c(MainTabActivity mainTabActivity) {
        this.f54619a = mainTabActivity;
        this.f54621c = (FragmentTabHost) mainTabActivity.findViewById(R.id.tab_host);
    }

    public void g() {
        g.c(this.f54620b);
    }

    public void h() {
        d.a.c.e.m.e.a().removeCallbacks(this.f54627i);
        d.a.c.e.m.e.a().removeCallbacks(this.j);
        g();
    }

    public void i() {
        h();
    }

    public void j(String str, String str2, long j) {
        if (d.a.i0.r.d0.b.j().l("home_tip", 0L) == j || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        this.f54622d = str2;
        this.f54623e = j;
        if (this.f54624f == null) {
            View inflate = LayoutInflater.from(this.f54619a.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
            this.f54624f = inflate;
            this.f54625g = (TextView) inflate.findViewById(R.id.tips);
            this.f54626h = (TextView) this.f54624f.findViewById(R.id.tips_content);
            this.f54624f.setOnClickListener(this.k);
        }
        this.f54625g.setText(StringHelper.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
        this.f54626h.setText(R.string.topic_join);
        if (this.f54620b == null) {
            this.f54620b = new PopupWindow(this.f54624f, -2, -2);
        } else {
            h();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.f54627i);
        d.a.c.e.m.e.a().postDelayed(this.f54627i, 100L);
    }
}
