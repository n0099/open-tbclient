package d.a.j0.c1.f.f;

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
import d.a.j0.c1.c.p;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Animation f51812a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f51813b;

    /* renamed from: c  reason: collision with root package name */
    public View f51814c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f51815d;

    /* renamed from: e  reason: collision with root package name */
    public View f51816e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1156c f51817f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.c1.f.f.b f51818g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51819h = false;

    /* renamed from: i  reason: collision with root package name */
    public int f51820i;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f51821e;

        public a(Context context) {
            this.f51821e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001433, c.this.f51818g.getItem(i2)));
            c.this.f(this.f51821e);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d {
        public b() {
        }

        @Override // d.a.c.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.f51819h = false;
            if (c.this.f51817f != null) {
                c.this.f51817f.a();
            }
            c.this.f51815d.removeView(c.this.f51814c);
        }
    }

    /* renamed from: d.a.j0.c1.f.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1156c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        this.f51815d = viewGroup;
    }

    public void f(Context context) {
        View view = this.f51814c;
        if (view != null) {
            view.startAnimation(i(context));
        }
    }

    public final View g(Context context, List<p> list, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_scroll_fragment_more, (ViewGroup) null);
        this.f51816e = inflate.findViewById(R.id.topic_more_top_view);
        k(this.f51820i);
        GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        d.a.j0.c1.f.f.b bVar = new d.a.j0.c1.f.f.b(context, i2);
        this.f51818g = bVar;
        bVar.b(list);
        gridView.setAdapter((ListAdapter) this.f51818g);
        gridView.setOnItemClickListener(new a(context));
        return inflate;
    }

    public final Animation h(Context context) {
        if (this.f51812a == null) {
            this.f51812a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.f51812a;
    }

    public final Animation i(Context context) {
        if (this.f51813b == null) {
            this.f51813b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.f51813b.setAnimationListener(new b());
        return this.f51813b;
    }

    public boolean j() {
        return this.f51819h;
    }

    public void k(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f51816e.getLayoutParams();
        layoutParams.height = i2;
        this.f51816e.setLayoutParams(layoutParams);
    }

    public void l(InterfaceC1156c interfaceC1156c) {
        this.f51817f = interfaceC1156c;
    }

    public void m(int i2) {
        this.f51820i = i2;
    }

    public void n(Context context, List<p> list, int i2) {
        if (this.f51819h) {
            return;
        }
        this.f51819h = true;
        View g2 = g(context, list, i2);
        this.f51814c = g2;
        this.f51815d.addView(g2);
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            View view = this.f51814c;
            view.setBackgroundColor(view.getContext().getResources().getColor(R.color.topic_more_background));
        } else {
            View view2 = this.f51814c;
            view2.setBackgroundColor(view2.getContext().getResources().getColor(R.color.topic_more_background_1));
        }
        this.f51814c.startAnimation(h(context));
    }
}
