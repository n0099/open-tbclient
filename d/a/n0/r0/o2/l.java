package d.a.n0.r0.o2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public Activity f59319a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f59320b;

    /* renamed from: c  reason: collision with root package name */
    public View f59321c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f59322d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.r0.n1.e.d f59323e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f59324f = new a();

    /* renamed from: g  reason: collision with root package name */
    public Runnable f59325g = new b();

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f59326h = new c();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.f59319a == null || l.this.f59321c == null || l.this.f59320b == null || l.this.f59320b.getContentView() == null) {
                return;
            }
            int g2 = d.a.c.e.p.l.g(l.this.f59319a, R.dimen.ds270);
            l.this.f59320b.getContentView().measure(0, 0);
            d.a.c.e.m.g.l(l.this.f59320b, l.this.f59321c, (-d.a.c.e.p.l.g(l.this.f59319a, R.dimen.ds430)) + (l.this.f59321c.getMeasuredWidth() / 2) + 30, -g2);
            d.a.c.e.m.e.a().postDelayed(l.this.f59325g, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 2));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.h();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.i();
            if (l.this.f59322d == null || l.this.f59322d.postTopic == null || l.this.f59322d.getForum() == null) {
                return;
            }
            if ((l.this.f59323e == null || l.this.f59323e.a()) && !WriteActivityConfig.isAsyncWriting()) {
                WriteActivityConfig.newInstance(l.this.f59319a).setType(9).setForumData(l.this.f59322d.getForum()).setAntiData(l.this.f59322d.getAnti()).setTitle(l.this.f59322d.postTopic.recom_topic).send();
                TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 2));
            }
        }
    }

    public l(Activity activity, d.a.n0.r0.n1.e.d dVar) {
        this.f59319a = activity;
        this.f59323e = dVar;
    }

    public final void h() {
        d.a.c.e.m.g.c(this.f59320b);
    }

    public void i() {
        d.a.c.e.m.e.a().removeCallbacks(this.f59324f);
        d.a.c.e.m.e.a().removeCallbacks(this.f59325g);
        h();
    }

    public void j(View view, FrsViewData frsViewData) {
        Activity activity;
        if (view == null || frsViewData == null || frsViewData.postTopic == null || (activity = this.f59319a) == null) {
            return;
        }
        this.f59322d = frsViewData;
        this.f59321c = view;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tips)).setText(StringHelper.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
        ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
        inflate.setOnClickListener(this.f59326h);
        this.f59320b = new PopupWindow(inflate, -2, -2);
        d.a.c.e.m.e.a().removeCallbacks(this.f59324f);
        d.a.c.e.m.e.a().postDelayed(this.f59324f, 100L);
    }
}
