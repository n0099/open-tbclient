package d.b.i0.g3;

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
import d.b.c.e.m.g;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f56295a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f56296b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f56297c;

    /* renamed from: d  reason: collision with root package name */
    public String f56298d;

    /* renamed from: e  reason: collision with root package name */
    public long f56299e;

    /* renamed from: f  reason: collision with root package name */
    public View f56300f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56301g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56302h;
    public Runnable i = new a();
    public Runnable j = new b();
    public View.OnClickListener k = new View$OnClickListenerC1309c();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f56297c == null || c.this.f56296b == null || c.this.f56296b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = c.this.f56297c.getFragmentTabWidget();
            int k = l.k(c.this.f56295a.getActivity());
            int g2 = l.g(c.this.f56295a.getActivity(), R.dimen.ds278);
            c.this.f56296b.getContentView().measure(0, 0);
            g.l(c.this.f56296b, fragmentTabWidget, (k - l.g(c.this.f56295a.getActivity(), R.dimen.ds430)) / 2, -g2);
            d.b.h0.r.d0.b.j().w("home_tip", c.this.f56299e);
            d.b.c.e.m.e.a().postDelayed(c.this.j, 5000L);
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

    /* renamed from: d.b.i0.g3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1309c implements View.OnClickListener {
        public View$OnClickListenerC1309c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.h();
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            WriteActivityConfig.newInstance(c.this.f56295a).setType(9).setTitle(c.this.f56298d).setForumId("0").send();
            TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 1));
        }
    }

    public c(MainTabActivity mainTabActivity) {
        this.f56295a = mainTabActivity;
        this.f56297c = (FragmentTabHost) mainTabActivity.findViewById(R.id.tab_host);
    }

    public void g() {
        g.c(this.f56296b);
    }

    public void h() {
        d.b.c.e.m.e.a().removeCallbacks(this.i);
        d.b.c.e.m.e.a().removeCallbacks(this.j);
        g();
    }

    public void i() {
        h();
    }

    public void j(String str, String str2, long j) {
        if (d.b.h0.r.d0.b.j().l("home_tip", 0L) == j || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        this.f56298d = str2;
        this.f56299e = j;
        if (this.f56300f == null) {
            View inflate = LayoutInflater.from(this.f56295a.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
            this.f56300f = inflate;
            this.f56301g = (TextView) inflate.findViewById(R.id.tips);
            this.f56302h = (TextView) this.f56300f.findViewById(R.id.tips_content);
            this.f56300f.setOnClickListener(this.k);
        }
        this.f56301g.setText(StringHelper.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
        this.f56302h.setText(R.string.topic_join);
        if (this.f56296b == null) {
            this.f56296b = new PopupWindow(this.f56300f, -2, -2);
        } else {
            h();
        }
        d.b.c.e.m.e.a().removeCallbacks(this.i);
        d.b.c.e.m.e.a().postDelayed(this.i, 100L);
    }
}
