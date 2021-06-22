package d.a.o0.h3;

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
    public MainTabActivity f59414a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f59415b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f59416c;

    /* renamed from: d  reason: collision with root package name */
    public String f59417d;

    /* renamed from: e  reason: collision with root package name */
    public long f59418e;

    /* renamed from: f  reason: collision with root package name */
    public View f59419f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59420g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59421h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f59422i = new a();
    public Runnable j = new b();
    public View.OnClickListener k = new View$OnClickListenerC1425c();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f59416c == null || c.this.f59415b == null || c.this.f59415b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = c.this.f59416c.getFragmentTabWidget();
            int k = l.k(c.this.f59414a.getActivity());
            int g2 = l.g(c.this.f59414a.getActivity(), R.dimen.ds278);
            c.this.f59415b.getContentView().measure(0, 0);
            g.l(c.this.f59415b, fragmentTabWidget, (k - l.g(c.this.f59414a.getActivity(), R.dimen.ds430)) / 2, -g2);
            d.a.n0.r.d0.b.j().w("home_tip", c.this.f59418e);
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

    /* renamed from: d.a.o0.h3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1425c implements View.OnClickListener {
        public View$OnClickListenerC1425c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.h();
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            WriteActivityConfig.newInstance(c.this.f59414a).setType(9).setTitle(c.this.f59417d).setForumId("0").send();
            TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 1));
        }
    }

    public c(MainTabActivity mainTabActivity) {
        this.f59414a = mainTabActivity;
        this.f59416c = (FragmentTabHost) mainTabActivity.findViewById(R.id.tab_host);
    }

    public void g() {
        g.c(this.f59415b);
    }

    public void h() {
        d.a.c.e.m.e.a().removeCallbacks(this.f59422i);
        d.a.c.e.m.e.a().removeCallbacks(this.j);
        g();
    }

    public void i() {
        h();
    }

    public void j(String str, String str2, long j) {
        if (d.a.n0.r.d0.b.j().l("home_tip", 0L) == j || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        this.f59417d = str2;
        this.f59418e = j;
        if (this.f59419f == null) {
            View inflate = LayoutInflater.from(this.f59414a.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
            this.f59419f = inflate;
            this.f59420g = (TextView) inflate.findViewById(R.id.tips);
            this.f59421h = (TextView) this.f59419f.findViewById(R.id.tips_content);
            this.f59419f.setOnClickListener(this.k);
        }
        this.f59420g.setText(StringHelper.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
        this.f59421h.setText(R.string.topic_join);
        if (this.f59415b == null) {
            this.f59415b = new PopupWindow(this.f59419f, -2, -2);
        } else {
            h();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.f59422i);
        d.a.c.e.m.e.a().postDelayed(this.f59422i, 100L);
    }
}
