package d.a.k0.c1.f.f;

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
import d.a.c.e.m.d;
import d.a.k0.c1.c.p;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Animation f52511a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f52512b;

    /* renamed from: c  reason: collision with root package name */
    public View f52513c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f52514d;

    /* renamed from: e  reason: collision with root package name */
    public View f52515e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1228c f52516f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.c1.f.f.b f52517g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52518h = false;

    /* renamed from: i  reason: collision with root package name */
    public int f52519i;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f52520e;

        public a(Context context) {
            this.f52520e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001433, c.this.f52517g.getItem(i2)));
            c.this.f(this.f52520e);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d {
        public b() {
        }

        @Override // d.a.c.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.f52518h = false;
            if (c.this.f52516f != null) {
                c.this.f52516f.a();
            }
            c.this.f52514d.removeView(c.this.f52513c);
        }
    }

    /* renamed from: d.a.k0.c1.f.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1228c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        this.f52514d = viewGroup;
    }

    public void f(Context context) {
        View view = this.f52513c;
        if (view != null) {
            view.startAnimation(i(context));
        }
    }

    public final View g(Context context, List<p> list, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_scroll_fragment_more, (ViewGroup) null);
        this.f52515e = inflate.findViewById(R.id.topic_more_top_view);
        k(this.f52519i);
        GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        d.a.k0.c1.f.f.b bVar = new d.a.k0.c1.f.f.b(context, i2);
        this.f52517g = bVar;
        bVar.b(list);
        gridView.setAdapter((ListAdapter) this.f52517g);
        gridView.setOnItemClickListener(new a(context));
        return inflate;
    }

    public final Animation h(Context context) {
        if (this.f52511a == null) {
            this.f52511a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.f52511a;
    }

    public final Animation i(Context context) {
        if (this.f52512b == null) {
            this.f52512b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.f52512b.setAnimationListener(new b());
        return this.f52512b;
    }

    public boolean j() {
        return this.f52518h;
    }

    public void k(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f52515e.getLayoutParams();
        layoutParams.height = i2;
        this.f52515e.setLayoutParams(layoutParams);
    }

    public void l(InterfaceC1228c interfaceC1228c) {
        this.f52516f = interfaceC1228c;
    }

    public void m(int i2) {
        this.f52519i = i2;
    }

    public void n(Context context, List<p> list, int i2) {
        if (this.f52518h) {
            return;
        }
        this.f52518h = true;
        View g2 = g(context, list, i2);
        this.f52513c = g2;
        this.f52514d.addView(g2);
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            View view = this.f52513c;
            view.setBackgroundColor(view.getContext().getResources().getColor(R.color.topic_more_background));
        } else {
            View view2 = this.f52513c;
            view2.setBackgroundColor(view2.getContext().getResources().getColor(R.color.topic_more_background_1));
        }
        this.f52513c.startAnimation(h(context));
    }
}
