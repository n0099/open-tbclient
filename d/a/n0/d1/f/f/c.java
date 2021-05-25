package d.a.n0.d1.f.f;

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
import d.a.n0.d1.c.p;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Animation f52691a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f52692b;

    /* renamed from: c  reason: collision with root package name */
    public View f52693c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f52694d;

    /* renamed from: e  reason: collision with root package name */
    public View f52695e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1245c f52696f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.d1.f.f.b f52697g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52698h = false;

    /* renamed from: i  reason: collision with root package name */
    public int f52699i;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f52700e;

        public a(Context context) {
            this.f52700e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001433, c.this.f52697g.getItem(i2)));
            c.this.f(this.f52700e);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d {
        public b() {
        }

        @Override // d.a.c.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.f52698h = false;
            if (c.this.f52696f != null) {
                c.this.f52696f.a();
            }
            c.this.f52694d.removeView(c.this.f52693c);
        }
    }

    /* renamed from: d.a.n0.d1.f.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1245c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        this.f52694d = viewGroup;
    }

    public void f(Context context) {
        View view = this.f52693c;
        if (view != null) {
            view.startAnimation(i(context));
        }
    }

    public final View g(Context context, List<p> list, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_scroll_fragment_more, (ViewGroup) null);
        this.f52695e = inflate.findViewById(R.id.topic_more_top_view);
        k(this.f52699i);
        GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        d.a.n0.d1.f.f.b bVar = new d.a.n0.d1.f.f.b(context, i2);
        this.f52697g = bVar;
        bVar.b(list);
        gridView.setAdapter((ListAdapter) this.f52697g);
        gridView.setOnItemClickListener(new a(context));
        return inflate;
    }

    public final Animation h(Context context) {
        if (this.f52691a == null) {
            this.f52691a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.f52691a;
    }

    public final Animation i(Context context) {
        if (this.f52692b == null) {
            this.f52692b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.f52692b.setAnimationListener(new b());
        return this.f52692b;
    }

    public boolean j() {
        return this.f52698h;
    }

    public void k(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f52695e.getLayoutParams();
        layoutParams.height = i2;
        this.f52695e.setLayoutParams(layoutParams);
    }

    public void l(InterfaceC1245c interfaceC1245c) {
        this.f52696f = interfaceC1245c;
    }

    public void m(int i2) {
        this.f52699i = i2;
    }

    public void n(Context context, List<p> list, int i2) {
        if (this.f52698h) {
            return;
        }
        this.f52698h = true;
        View g2 = g(context, list, i2);
        this.f52693c = g2;
        this.f52694d.addView(g2);
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            View view = this.f52693c;
            view.setBackgroundColor(view.getContext().getResources().getColor(R.color.topic_more_background));
        } else {
            View view2 = this.f52693c;
            view2.setBackgroundColor(view2.getContext().getResources().getColor(R.color.topic_more_background_1));
        }
        this.f52693c.startAnimation(h(context));
    }
}
