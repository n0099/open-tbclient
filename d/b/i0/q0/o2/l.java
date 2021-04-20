package d.b.i0.q0.o2;

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
    public Activity f59923a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f59924b;

    /* renamed from: c  reason: collision with root package name */
    public View f59925c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f59926d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.q0.n1.e.d f59927e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f59928f = new a();

    /* renamed from: g  reason: collision with root package name */
    public Runnable f59929g = new b();

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f59930h = new c();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.f59923a == null || l.this.f59925c == null || l.this.f59924b == null || l.this.f59924b.getContentView() == null) {
                return;
            }
            int g2 = d.b.c.e.p.l.g(l.this.f59923a, R.dimen.ds270);
            l.this.f59924b.getContentView().measure(0, 0);
            d.b.c.e.m.g.l(l.this.f59924b, l.this.f59925c, (-d.b.c.e.p.l.g(l.this.f59923a, R.dimen.ds430)) + (l.this.f59925c.getMeasuredWidth() / 2) + 30, -g2);
            d.b.c.e.m.e.a().postDelayed(l.this.f59929g, 5000L);
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
            if (l.this.f59926d == null || l.this.f59926d.postTopic == null || l.this.f59926d.getForum() == null) {
                return;
            }
            if ((l.this.f59927e == null || l.this.f59927e.a()) && !WriteActivityConfig.isAsyncWriting()) {
                WriteActivityConfig.newInstance(l.this.f59923a).setType(9).setForumData(l.this.f59926d.getForum()).setAntiData(l.this.f59926d.getAnti()).setTitle(l.this.f59926d.postTopic.recom_topic).send();
                TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 2));
            }
        }
    }

    public l(Activity activity, d.b.i0.q0.n1.e.d dVar) {
        this.f59923a = activity;
        this.f59927e = dVar;
    }

    public final void h() {
        d.b.c.e.m.g.c(this.f59924b);
    }

    public void i() {
        d.b.c.e.m.e.a().removeCallbacks(this.f59928f);
        d.b.c.e.m.e.a().removeCallbacks(this.f59929g);
        h();
    }

    public void j(View view, FrsViewData frsViewData) {
        Activity activity;
        if (view == null || frsViewData == null || frsViewData.postTopic == null || (activity = this.f59923a) == null) {
            return;
        }
        this.f59926d = frsViewData;
        this.f59925c = view;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tips)).setText(StringHelper.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
        ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
        inflate.setOnClickListener(this.f59930h);
        this.f59924b = new PopupWindow(inflate, -2, -2);
        d.b.c.e.m.e.a().removeCallbacks(this.f59928f);
        d.b.c.e.m.e.a().postDelayed(this.f59928f, 100L);
    }
}
