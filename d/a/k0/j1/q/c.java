package d.a.k0.j1.q;

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
import d.a.c.e.m.d;
import d.a.k0.j1.p.e;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Animation f56598a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f56599b;

    /* renamed from: c  reason: collision with root package name */
    public View f56600c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56601d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1396c f56602e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.j1.q.b f56603f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56604g = false;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f56605e;

        public a(Context context) {
            this.f56605e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            e item = c.this.f56603f.getItem(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016448));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, item));
            c.this.f(this.f56605e);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d {
        public b() {
        }

        @Override // d.a.c.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.f56604g = false;
            if (c.this.f56602e != null) {
                c.this.f56602e.a();
            }
            c.this.f56601d.removeView(c.this.f56600c);
        }
    }

    /* renamed from: d.a.k0.j1.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1396c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        this.f56601d = viewGroup;
    }

    public void f(Context context) {
        View view = this.f56600c;
        if (view != null) {
            view.startAnimation(i(context));
        }
    }

    public final View g(Context context, List<e> list, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(R.id.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(context.getResources().getColor(17170445)));
        d.a.k0.j1.q.b bVar = new d.a.k0.j1.q.b(context, i2);
        this.f56603f = bVar;
        bVar.b(list);
        gridView.setAdapter((ListAdapter) this.f56603f);
        gridView.setOnItemClickListener(new a(context));
        return inflate;
    }

    public final Animation h(Context context) {
        if (this.f56598a == null) {
            this.f56598a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.f56598a;
    }

    public final Animation i(Context context) {
        if (this.f56599b == null) {
            this.f56599b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.f56599b.setAnimationListener(new b());
        return this.f56599b;
    }

    public boolean j() {
        return this.f56604g;
    }

    public void k(int i2) {
        SkinManager.setBackgroundColor(this.f56600c, R.color.CAM_X0111);
        d.a.k0.j1.q.b bVar = this.f56603f;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void l(InterfaceC1396c interfaceC1396c) {
        this.f56602e = interfaceC1396c;
    }

    public void m(Context context, List<e> list, int i2) {
        if (this.f56604g) {
            return;
        }
        this.f56604g = true;
        View g2 = g(context, list, i2);
        this.f56600c = g2;
        this.f56601d.addView(g2);
        SkinManager.setBackgroundColor(this.f56600c, R.color.CAM_X0111);
        this.f56600c.startAnimation(h(context));
    }
}
