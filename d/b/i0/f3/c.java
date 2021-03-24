package d.b.i0.f3;

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
import d.b.b.e.m.g;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f54824a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f54825b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f54826c;

    /* renamed from: d  reason: collision with root package name */
    public String f54827d;

    /* renamed from: e  reason: collision with root package name */
    public long f54828e;

    /* renamed from: f  reason: collision with root package name */
    public View f54829f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54830g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54831h;
    public Runnable i = new a();
    public Runnable j = new b();
    public View.OnClickListener k = new View$OnClickListenerC1251c();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f54826c == null || c.this.f54825b == null || c.this.f54825b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = c.this.f54826c.getFragmentTabWidget();
            int k = l.k(c.this.f54824a.getActivity());
            int g2 = l.g(c.this.f54824a.getActivity(), R.dimen.ds278);
            c.this.f54825b.getContentView().measure(0, 0);
            g.l(c.this.f54825b, fragmentTabWidget, (k - l.g(c.this.f54824a.getActivity(), R.dimen.ds430)) / 2, -g2);
            d.b.h0.r.d0.b.i().v("home_tip", c.this.f54828e);
            d.b.b.e.m.e.a().postDelayed(c.this.j, 5000L);
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

    /* renamed from: d.b.i0.f3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1251c implements View.OnClickListener {
        public View$OnClickListenerC1251c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.h();
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            WriteActivityConfig.newInstance(c.this.f54824a).setType(9).setTitle(c.this.f54827d).setForumId("0").send();
            TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 1));
        }
    }

    public c(MainTabActivity mainTabActivity) {
        this.f54824a = mainTabActivity;
        this.f54826c = (FragmentTabHost) mainTabActivity.findViewById(R.id.tab_host);
    }

    public void g() {
        g.c(this.f54825b);
    }

    public void h() {
        d.b.b.e.m.e.a().removeCallbacks(this.i);
        d.b.b.e.m.e.a().removeCallbacks(this.j);
        g();
    }

    public void i() {
        h();
    }

    public void j(String str, String str2, long j) {
        if (d.b.h0.r.d0.b.i().k("home_tip", 0L) == j || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        this.f54827d = str2;
        this.f54828e = j;
        if (this.f54829f == null) {
            View inflate = LayoutInflater.from(this.f54824a.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
            this.f54829f = inflate;
            this.f54830g = (TextView) inflate.findViewById(R.id.tips);
            this.f54831h = (TextView) this.f54829f.findViewById(R.id.tips_content);
            this.f54829f.setOnClickListener(this.k);
        }
        this.f54830g.setText(StringHelper.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
        this.f54831h.setText(R.string.topic_join);
        if (this.f54825b == null) {
            this.f54825b = new PopupWindow(this.f54829f, -2, -2);
        } else {
            h();
        }
        d.b.b.e.m.e.a().removeCallbacks(this.i);
        d.b.b.e.m.e.a().postDelayed(this.i, 100L);
    }
}
