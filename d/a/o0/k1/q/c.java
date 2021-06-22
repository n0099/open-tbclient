package d.a.o0.k1.q;

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
import d.a.o0.k1.p.e;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Animation f60592a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f60593b;

    /* renamed from: c  reason: collision with root package name */
    public View f60594c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f60595d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1474c f60596e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.k1.q.b f60597f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60598g = false;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f60599e;

        public a(Context context) {
            this.f60599e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            e item = c.this.f60597f.getItem(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016448));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, item));
            c.this.f(this.f60599e);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d {
        public b() {
        }

        @Override // d.a.c.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.f60598g = false;
            if (c.this.f60596e != null) {
                c.this.f60596e.a();
            }
            c.this.f60595d.removeView(c.this.f60594c);
        }
    }

    /* renamed from: d.a.o0.k1.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1474c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        this.f60595d = viewGroup;
    }

    public void f(Context context) {
        View view = this.f60594c;
        if (view != null) {
            view.startAnimation(i(context));
        }
    }

    public final View g(Context context, List<e> list, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(R.id.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(context.getResources().getColor(17170445)));
        d.a.o0.k1.q.b bVar = new d.a.o0.k1.q.b(context, i2);
        this.f60597f = bVar;
        bVar.b(list);
        gridView.setAdapter((ListAdapter) this.f60597f);
        gridView.setOnItemClickListener(new a(context));
        return inflate;
    }

    public final Animation h(Context context) {
        if (this.f60592a == null) {
            this.f60592a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.f60592a;
    }

    public final Animation i(Context context) {
        if (this.f60593b == null) {
            this.f60593b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.f60593b.setAnimationListener(new b());
        return this.f60593b;
    }

    public boolean j() {
        return this.f60598g;
    }

    public void k(int i2) {
        SkinManager.setBackgroundColor(this.f60594c, R.color.CAM_X0111);
        d.a.o0.k1.q.b bVar = this.f60597f;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void l(InterfaceC1474c interfaceC1474c) {
        this.f60596e = interfaceC1474c;
    }

    public void m(Context context, List<e> list, int i2) {
        if (this.f60598g) {
            return;
        }
        this.f60598g = true;
        View g2 = g(context, list, i2);
        this.f60594c = g2;
        this.f60595d.addView(g2);
        SkinManager.setBackgroundColor(this.f60594c, R.color.CAM_X0111);
        this.f60594c.startAnimation(h(context));
    }
}
