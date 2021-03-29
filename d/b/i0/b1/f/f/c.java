package d.b.i0.b1.f.f;

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
import d.b.b.e.m.d;
import d.b.i0.b1.c.p;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Animation f52218a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f52219b;

    /* renamed from: c  reason: collision with root package name */
    public View f52220c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f52221d;

    /* renamed from: e  reason: collision with root package name */
    public View f52222e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1135c f52223f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.b1.f.f.b f52224g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52225h = false;
    public int i;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f52226e;

        public a(Context context) {
            this.f52226e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001433, c.this.f52224g.getItem(i)));
            c.this.f(this.f52226e);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d {
        public b() {
        }

        @Override // d.b.b.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.f52225h = false;
            if (c.this.f52223f != null) {
                c.this.f52223f.a();
            }
            c.this.f52221d.removeView(c.this.f52220c);
        }
    }

    /* renamed from: d.b.i0.b1.f.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1135c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        this.f52221d = viewGroup;
    }

    public void f(Context context) {
        View view = this.f52220c;
        if (view != null) {
            view.startAnimation(i(context));
        }
    }

    public final View g(Context context, List<p> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_scroll_fragment_more, (ViewGroup) null);
        this.f52222e = inflate.findViewById(R.id.topic_more_top_view);
        k(this.i);
        GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        d.b.i0.b1.f.f.b bVar = new d.b.i0.b1.f.f.b(context, i);
        this.f52224g = bVar;
        bVar.b(list);
        gridView.setAdapter((ListAdapter) this.f52224g);
        gridView.setOnItemClickListener(new a(context));
        return inflate;
    }

    public final Animation h(Context context) {
        if (this.f52218a == null) {
            this.f52218a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.f52218a;
    }

    public final Animation i(Context context) {
        if (this.f52219b == null) {
            this.f52219b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.f52219b.setAnimationListener(new b());
        return this.f52219b;
    }

    public boolean j() {
        return this.f52225h;
    }

    public void k(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f52222e.getLayoutParams();
        layoutParams.height = i;
        this.f52222e.setLayoutParams(layoutParams);
    }

    public void l(InterfaceC1135c interfaceC1135c) {
        this.f52223f = interfaceC1135c;
    }

    public void m(int i) {
        this.i = i;
    }

    public void n(Context context, List<p> list, int i) {
        if (this.f52225h) {
            return;
        }
        this.f52225h = true;
        View g2 = g(context, list, i);
        this.f52220c = g2;
        this.f52221d.addView(g2);
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            View view = this.f52220c;
            view.setBackgroundColor(view.getContext().getResources().getColor(R.color.topic_more_background));
        } else {
            View view2 = this.f52220c;
            view2.setBackgroundColor(view2.getContext().getResources().getColor(R.color.topic_more_background_1));
        }
        this.f52220c.startAnimation(h(context));
    }
}
