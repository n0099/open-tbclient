package d.b.i0.j1.q;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.e.m.d;
import d.b.i0.j1.p.e;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Animation f57496a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f57497b;

    /* renamed from: c  reason: collision with root package name */
    public View f57498c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f57499d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1362c f57500e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.j1.q.b f57501f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57502g = false;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f57503e;

        public a(Context context) {
            this.f57503e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            e item = c.this.f57501f.getItem(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016448));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, item));
            c.this.f(this.f57503e);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d {
        public b() {
        }

        @Override // d.b.c.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.f57502g = false;
            if (c.this.f57500e != null) {
                c.this.f57500e.a();
            }
            c.this.f57499d.removeView(c.this.f57498c);
        }
    }

    /* renamed from: d.b.i0.j1.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1362c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        this.f57499d = viewGroup;
    }

    public void f(Context context) {
        View view = this.f57498c;
        if (view != null) {
            view.startAnimation(i(context));
        }
    }

    public final View g(Context context, List<e> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(R.id.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(context.getResources().getColor(17170445)));
        d.b.i0.j1.q.b bVar = new d.b.i0.j1.q.b(context, i);
        this.f57501f = bVar;
        bVar.b(list);
        gridView.setAdapter((ListAdapter) this.f57501f);
        gridView.setOnItemClickListener(new a(context));
        return inflate;
    }

    public final Animation h(Context context) {
        if (this.f57496a == null) {
            this.f57496a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.f57496a;
    }

    public final Animation i(Context context) {
        if (this.f57497b == null) {
            this.f57497b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.f57497b.setAnimationListener(new b());
        return this.f57497b;
    }

    public boolean j() {
        return this.f57502g;
    }

    public void k(int i) {
        SkinManager.setBackgroundColor(this.f57498c, R.color.CAM_X0111);
        d.b.i0.j1.q.b bVar = this.f57501f;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void l(InterfaceC1362c interfaceC1362c) {
        this.f57500e = interfaceC1362c;
    }

    public void m(Context context, List<e> list, int i) {
        if (this.f57502g) {
            return;
        }
        this.f57502g = true;
        View g2 = g(context, list, i);
        this.f57498c = g2;
        this.f57499d.addView(g2);
        SkinManager.setBackgroundColor(this.f57498c, R.color.CAM_X0111);
        this.f57498c.startAnimation(h(context));
    }
}
