package d.b.i0.p0.n2;

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
    public Activity f58226a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f58227b;

    /* renamed from: c  reason: collision with root package name */
    public View f58228c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f58229d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.p0.n1.e.d f58230e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f58231f = new a();

    /* renamed from: g  reason: collision with root package name */
    public Runnable f58232g = new b();

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f58233h = new c();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.f58226a == null || l.this.f58228c == null || l.this.f58227b == null || l.this.f58227b.getContentView() == null) {
                return;
            }
            int g2 = d.b.b.e.p.l.g(l.this.f58226a, R.dimen.ds270);
            l.this.f58227b.getContentView().measure(0, 0);
            d.b.b.e.m.g.l(l.this.f58227b, l.this.f58228c, (-d.b.b.e.p.l.g(l.this.f58226a, R.dimen.ds430)) + (l.this.f58228c.getMeasuredWidth() / 2) + 30, -g2);
            d.b.b.e.m.e.a().postDelayed(l.this.f58232g, 5000L);
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
            if (l.this.f58229d == null || l.this.f58229d.postTopic == null || l.this.f58229d.getForum() == null) {
                return;
            }
            if ((l.this.f58230e == null || l.this.f58230e.a()) && !WriteActivityConfig.isAsyncWriting()) {
                WriteActivityConfig.newInstance(l.this.f58226a).setType(9).setForumData(l.this.f58229d.getForum()).setAntiData(l.this.f58229d.getAnti()).setTitle(l.this.f58229d.postTopic.recom_topic).send();
                TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 2));
            }
        }
    }

    public l(Activity activity, d.b.i0.p0.n1.e.d dVar) {
        this.f58226a = activity;
        this.f58230e = dVar;
    }

    public final void h() {
        d.b.b.e.m.g.c(this.f58227b);
    }

    public void i() {
        d.b.b.e.m.e.a().removeCallbacks(this.f58231f);
        d.b.b.e.m.e.a().removeCallbacks(this.f58232g);
        h();
    }

    public void j(View view, FrsViewData frsViewData) {
        Activity activity;
        if (view == null || frsViewData == null || frsViewData.postTopic == null || (activity = this.f58226a) == null) {
            return;
        }
        this.f58229d = frsViewData;
        this.f58228c = view;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tips)).setText(StringHelper.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
        ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
        inflate.setOnClickListener(this.f58233h);
        this.f58227b = new PopupWindow(inflate, -2, -2);
        d.b.b.e.m.e.a().removeCallbacks(this.f58231f);
        d.b.b.e.m.e.a().postDelayed(this.f58231f, 100L);
    }
}
