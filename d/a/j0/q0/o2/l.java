package d.a.j0.q0.o2;

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
    public Activity f58436a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f58437b;

    /* renamed from: c  reason: collision with root package name */
    public View f58438c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f58439d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.q0.n1.e.d f58440e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f58441f = new a();

    /* renamed from: g  reason: collision with root package name */
    public Runnable f58442g = new b();

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f58443h = new c();

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.f58436a == null || l.this.f58438c == null || l.this.f58437b == null || l.this.f58437b.getContentView() == null) {
                return;
            }
            int g2 = d.a.c.e.p.l.g(l.this.f58436a, R.dimen.ds270);
            l.this.f58437b.getContentView().measure(0, 0);
            d.a.c.e.m.g.l(l.this.f58437b, l.this.f58438c, (-d.a.c.e.p.l.g(l.this.f58436a, R.dimen.ds430)) + (l.this.f58438c.getMeasuredWidth() / 2) + 30, -g2);
            d.a.c.e.m.e.a().postDelayed(l.this.f58442g, 5000L);
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
            if (l.this.f58439d == null || l.this.f58439d.postTopic == null || l.this.f58439d.getForum() == null) {
                return;
            }
            if ((l.this.f58440e == null || l.this.f58440e.a()) && !WriteActivityConfig.isAsyncWriting()) {
                WriteActivityConfig.newInstance(l.this.f58436a).setType(9).setForumData(l.this.f58439d.getForum()).setAntiData(l.this.f58439d.getAnti()).setTitle(l.this.f58439d.postTopic.recom_topic).send();
                TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 2));
            }
        }
    }

    public l(Activity activity, d.a.j0.q0.n1.e.d dVar) {
        this.f58436a = activity;
        this.f58440e = dVar;
    }

    public final void h() {
        d.a.c.e.m.g.c(this.f58437b);
    }

    public void i() {
        d.a.c.e.m.e.a().removeCallbacks(this.f58441f);
        d.a.c.e.m.e.a().removeCallbacks(this.f58442g);
        h();
    }

    public void j(View view, FrsViewData frsViewData) {
        Activity activity;
        if (view == null || frsViewData == null || frsViewData.postTopic == null || (activity = this.f58436a) == null) {
            return;
        }
        this.f58439d = frsViewData;
        this.f58438c = view;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tips)).setText(StringHelper.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
        ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
        inflate.setOnClickListener(this.f58443h);
        this.f58437b = new PopupWindow(inflate, -2, -2);
        d.a.c.e.m.e.a().removeCallbacks(this.f58441f);
        d.a.c.e.m.e.a().postDelayed(this.f58441f, 100L);
    }
}
