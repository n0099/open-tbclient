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
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Animation f56048a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f56049b;

    /* renamed from: c  reason: collision with root package name */
    public View f56050c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56051d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1305c f56052e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.i1.q.b f56053f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56054g = false;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f56055e;

        public a(Context context) {
            this.f56055e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            e item = c.this.f56053f.getItem(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016448));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, item));
            c.this.f(this.f56055e);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d {
        public b() {
        }

        @Override // d.b.b.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.f56054g = false;
            if (c.this.f56052e != null) {
                c.this.f56052e.a();
            }
            c.this.f56051d.removeView(c.this.f56050c);
        }
    }

    /* renamed from: d.b.i0.i1.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1305c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        this.f56051d = viewGroup;
    }

    public void f(Context context) {
        View view = this.f56050c;
        if (view != null) {
            view.startAnimation(i(context));
        }
    }

    public final View g(Context context, List<e> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(R.id.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(context.getResources().getColor(17170445)));
        d.b.i0.i1.q.b bVar = new d.b.i0.i1.q.b(context, i);
        this.f56053f = bVar;
        bVar.b(list);
        gridView.setAdapter((ListAdapter) this.f56053f);
        gridView.setOnItemClickListener(new a(context));
        return inflate;
    }

    public final Animation h(Context context) {
        if (this.f56048a == null) {
            this.f56048a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.f56048a;
    }

    public final Animation i(Context context) {
        if (this.f56049b == null) {
            this.f56049b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.f56049b.setAnimationListener(new b());
        return this.f56049b;
    }

    public boolean j() {
        return this.f56054g;
    }

    public void k(int i) {
        SkinManager.setBackgroundColor(this.f56050c, R.color.CAM_X0111);
        d.b.i0.i1.q.b bVar = this.f56053f;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void l(InterfaceC1305c interfaceC1305c) {
        this.f56052e = interfaceC1305c;
    }

    public void m(Context context, List<e> list, int i) {
        if (this.f56054g) {
            return;
        }
        this.f56054g = true;
        View g2 = g(context, list, i);
        this.f56050c = g2;
        this.f56051d.addView(g2);
        SkinManager.setBackgroundColor(this.f56050c, R.color.CAM_X0111);
        this.f56050c.startAnimation(h(context));
    }
}
