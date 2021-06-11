package d.a.n0.k1.q;

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
import d.a.n0.k1.p.e;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Animation f60467a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f60468b;

    /* renamed from: c  reason: collision with root package name */
    public View f60469c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f60470d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1470c f60471e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.k1.q.b f60472f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60473g = false;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f60474e;

        public a(Context context) {
            this.f60474e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            e item = c.this.f60472f.getItem(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016448));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, item));
            c.this.f(this.f60474e);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d {
        public b() {
        }

        @Override // d.a.c.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.f60473g = false;
            if (c.this.f60471e != null) {
                c.this.f60471e.a();
            }
            c.this.f60470d.removeView(c.this.f60469c);
        }
    }

    /* renamed from: d.a.n0.k1.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1470c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        this.f60470d = viewGroup;
    }

    public void f(Context context) {
        View view = this.f60469c;
        if (view != null) {
            view.startAnimation(i(context));
        }
    }

    public final View g(Context context, List<e> list, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(R.id.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(context.getResources().getColor(17170445)));
        d.a.n0.k1.q.b bVar = new d.a.n0.k1.q.b(context, i2);
        this.f60472f = bVar;
        bVar.b(list);
        gridView.setAdapter((ListAdapter) this.f60472f);
        gridView.setOnItemClickListener(new a(context));
        return inflate;
    }

    public final Animation h(Context context) {
        if (this.f60467a == null) {
            this.f60467a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.f60467a;
    }

    public final Animation i(Context context) {
        if (this.f60468b == null) {
            this.f60468b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.f60468b.setAnimationListener(new b());
        return this.f60468b;
    }

    public boolean j() {
        return this.f60473g;
    }

    public void k(int i2) {
        SkinManager.setBackgroundColor(this.f60469c, R.color.CAM_X0111);
        d.a.n0.k1.q.b bVar = this.f60472f;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void l(InterfaceC1470c interfaceC1470c) {
        this.f60471e = interfaceC1470c;
    }

    public void m(Context context, List<e> list, int i2) {
        if (this.f60473g) {
            return;
        }
        this.f60473g = true;
        View g2 = g(context, list, i2);
        this.f60469c = g2;
        this.f60470d.addView(g2);
        SkinManager.setBackgroundColor(this.f60469c, R.color.CAM_X0111);
        this.f60469c.startAnimation(h(context));
    }
}
