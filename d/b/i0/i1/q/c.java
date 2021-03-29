package d.b.i0.i1.q;

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
import d.b.b.e.m.d;
import d.b.i0.i1.p.e;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Animation f56049a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f56050b;

    /* renamed from: c  reason: collision with root package name */
    public View f56051c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56052d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1306c f56053e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.i1.q.b f56054f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56055g = false;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f56056e;

        public a(Context context) {
            this.f56056e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            e item = c.this.f56054f.getItem(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016448));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, item));
            c.this.f(this.f56056e);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d {
        public b() {
        }

        @Override // d.b.b.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.f56055g = false;
            if (c.this.f56053e != null) {
                c.this.f56053e.a();
            }
            c.this.f56052d.removeView(c.this.f56051c);
        }
    }

    /* renamed from: d.b.i0.i1.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1306c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        this.f56052d = viewGroup;
    }

    public void f(Context context) {
        View view = this.f56051c;
        if (view != null) {
            view.startAnimation(i(context));
        }
    }

    public final View g(Context context, List<e> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(R.id.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(context.getResources().getColor(17170445)));
        d.b.i0.i1.q.b bVar = new d.b.i0.i1.q.b(context, i);
        this.f56054f = bVar;
        bVar.b(list);
        gridView.setAdapter((ListAdapter) this.f56054f);
        gridView.setOnItemClickListener(new a(context));
        return inflate;
    }

    public final Animation h(Context context) {
        if (this.f56049a == null) {
            this.f56049a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.f56049a;
    }

    public final Animation i(Context context) {
        if (this.f56050b == null) {
            this.f56050b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.f56050b.setAnimationListener(new b());
        return this.f56050b;
    }

    public boolean j() {
        return this.f56055g;
    }

    public void k(int i) {
        SkinManager.setBackgroundColor(this.f56051c, R.color.CAM_X0111);
        d.b.i0.i1.q.b bVar = this.f56054f;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void l(InterfaceC1306c interfaceC1306c) {
        this.f56053e = interfaceC1306c;
    }

    public void m(Context context, List<e> list, int i) {
        if (this.f56055g) {
            return;
        }
        this.f56055g = true;
        View g2 = g(context, list, i);
        this.f56051c = g2;
        this.f56052d.addView(g2);
        SkinManager.setBackgroundColor(this.f56051c, R.color.CAM_X0111);
        this.f56051c.startAnimation(h(context));
    }
}
