package d.b.j0.c1.f.f;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.c.e.m.d;
import d.b.j0.c1.c.p;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Animation f54040a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f54041b;

    /* renamed from: c  reason: collision with root package name */
    public View f54042c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f54043d;

    /* renamed from: e  reason: collision with root package name */
    public View f54044e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1217c f54045f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.c1.f.f.b f54046g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54047h = false;
    public int i;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f54048e;

        public a(Context context) {
            this.f54048e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001433, c.this.f54046g.getItem(i)));
            c.this.f(this.f54048e);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d {
        public b() {
        }

        @Override // d.b.c.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.f54047h = false;
            if (c.this.f54045f != null) {
                c.this.f54045f.a();
            }
            c.this.f54043d.removeView(c.this.f54042c);
        }
    }

    /* renamed from: d.b.j0.c1.f.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1217c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        this.f54043d = viewGroup;
    }

    public void f(Context context) {
        View view = this.f54042c;
        if (view != null) {
            view.startAnimation(i(context));
        }
    }

    public final View g(Context context, List<p> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_scroll_fragment_more, (ViewGroup) null);
        this.f54044e = inflate.findViewById(R.id.topic_more_top_view);
        k(this.i);
        GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        d.b.j0.c1.f.f.b bVar = new d.b.j0.c1.f.f.b(context, i);
        this.f54046g = bVar;
        bVar.b(list);
        gridView.setAdapter((ListAdapter) this.f54046g);
        gridView.setOnItemClickListener(new a(context));
        return inflate;
    }

    public final Animation h(Context context) {
        if (this.f54040a == null) {
            this.f54040a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.f54040a;
    }

    public final Animation i(Context context) {
        if (this.f54041b == null) {
            this.f54041b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.f54041b.setAnimationListener(new b());
        return this.f54041b;
    }

    public boolean j() {
        return this.f54047h;
    }

    public void k(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f54044e.getLayoutParams();
        layoutParams.height = i;
        this.f54044e.setLayoutParams(layoutParams);
    }

    public void l(InterfaceC1217c interfaceC1217c) {
        this.f54045f = interfaceC1217c;
    }

    public void m(int i) {
        this.i = i;
    }

    public void n(Context context, List<p> list, int i) {
        if (this.f54047h) {
            return;
        }
        this.f54047h = true;
        View g2 = g(context, list, i);
        this.f54042c = g2;
        this.f54043d.addView(g2);
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            View view = this.f54042c;
            view.setBackgroundColor(view.getContext().getResources().getColor(R.color.topic_more_background));
        } else {
            View view2 = this.f54042c;
            view2.setBackgroundColor(view2.getContext().getResources().getColor(R.color.topic_more_background_1));
        }
        this.f54042c.startAnimation(h(context));
    }
}
