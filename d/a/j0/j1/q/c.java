package d.a.j0.j1.q;

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
import d.a.j0.j1.p.e;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Animation f55891a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f55892b;

    /* renamed from: c  reason: collision with root package name */
    public View f55893c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f55894d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1324c f55895e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.j1.q.b f55896f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55897g = false;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f55898e;

        public a(Context context) {
            this.f55898e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            e item = c.this.f55896f.getItem(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016448));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, item));
            c.this.f(this.f55898e);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d {
        public b() {
        }

        @Override // d.a.c.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.f55897g = false;
            if (c.this.f55895e != null) {
                c.this.f55895e.a();
            }
            c.this.f55894d.removeView(c.this.f55893c);
        }
    }

    /* renamed from: d.a.j0.j1.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1324c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        this.f55894d = viewGroup;
    }

    public void f(Context context) {
        View view = this.f55893c;
        if (view != null) {
            view.startAnimation(i(context));
        }
    }

    public final View g(Context context, List<e> list, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(R.id.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(context.getResources().getColor(17170445)));
        d.a.j0.j1.q.b bVar = new d.a.j0.j1.q.b(context, i2);
        this.f55896f = bVar;
        bVar.b(list);
        gridView.setAdapter((ListAdapter) this.f55896f);
        gridView.setOnItemClickListener(new a(context));
        return inflate;
    }

    public final Animation h(Context context) {
        if (this.f55891a == null) {
            this.f55891a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.f55891a;
    }

    public final Animation i(Context context) {
        if (this.f55892b == null) {
            this.f55892b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.f55892b.setAnimationListener(new b());
        return this.f55892b;
    }

    public boolean j() {
        return this.f55897g;
    }

    public void k(int i2) {
        SkinManager.setBackgroundColor(this.f55893c, R.color.CAM_X0111);
        d.a.j0.j1.q.b bVar = this.f55896f;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void l(InterfaceC1324c interfaceC1324c) {
        this.f55895e = interfaceC1324c;
    }

    public void m(Context context, List<e> list, int i2) {
        if (this.f55897g) {
            return;
        }
        this.f55897g = true;
        View g2 = g(context, list, i2);
        this.f55893c = g2;
        this.f55894d.addView(g2);
        SkinManager.setBackgroundColor(this.f55893c, R.color.CAM_X0111);
        this.f55893c.startAnimation(h(context));
    }
}
