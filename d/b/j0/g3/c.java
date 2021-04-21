package d.b.j0.g3;

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
    public MainTabActivity f56716a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f56717b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f56718c;

    /* renamed from: d  reason: collision with root package name */
    public String f56719d;

    /* renamed from: e  reason: collision with root package name */
    public long f56720e;

    /* renamed from: f  reason: collision with root package name */
    public View f56721f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56722g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56723h;
    public Runnable i = new a();
    public Runnable j = new b();
    public View.OnClickListener k = new View$OnClickListenerC1332c();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f56718c == null || c.this.f56717b == null || c.this.f56717b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = c.this.f56718c.getFragmentTabWidget();
            int k = l.k(c.this.f56716a.getActivity());
            int g2 = l.g(c.this.f56716a.getActivity(), R.dimen.ds278);
            c.this.f56717b.getContentView().measure(0, 0);
            g.l(c.this.f56717b, fragmentTabWidget, (k - l.g(c.this.f56716a.getActivity(), R.dimen.ds430)) / 2, -g2);
            d.b.i0.r.d0.b.j().w("home_tip", c.this.f56720e);
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

    /* renamed from: d.b.j0.g3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1332c implements View.OnClickListener {
        public View$OnClickListenerC1332c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.h();
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            WriteActivityConfig.newInstance(c.this.f56716a).setType(9).setTitle(c.this.f56719d).setForumId("0").send();
            TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 1));
        }
    }

    public c(MainTabActivity mainTabActivity) {
        this.f56716a = mainTabActivity;
        this.f56718c = (FragmentTabHost) mainTabActivity.findViewById(R.id.tab_host);
    }

    public void g() {
        g.c(this.f56717b);
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
        if (d.b.i0.r.d0.b.j().l("home_tip", 0L) == j || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        this.f56719d = str2;
        this.f56720e = j;
        if (this.f56721f == null) {
            View inflate = LayoutInflater.from(this.f56716a.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
            this.f56721f = inflate;
            this.f56722g = (TextView) inflate.findViewById(R.id.tips);
            this.f56723h = (TextView) this.f56721f.findViewById(R.id.tips_content);
            this.f56721f.setOnClickListener(this.k);
        }
        this.f56722g.setText(StringHelper.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
        this.f56723h.setText(R.string.topic_join);
        if (this.f56717b == null) {
            this.f56717b = new PopupWindow(this.f56721f, -2, -2);
        } else {
            h();
        }
        d.b.c.e.m.e.a().removeCallbacks(this.i);
        d.b.c.e.m.e.a().postDelayed(this.i, 100L);
    }
}
