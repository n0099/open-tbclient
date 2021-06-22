package d.a.o0.d1.f.f;

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
import d.a.o0.d1.c.p;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Animation f56505a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f56506b;

    /* renamed from: c  reason: collision with root package name */
    public View f56507c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56508d;

    /* renamed from: e  reason: collision with root package name */
    public View f56509e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1305c f56510f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.d1.f.f.b f56511g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56512h = false;

    /* renamed from: i  reason: collision with root package name */
    public int f56513i;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f56514e;

        public a(Context context) {
            this.f56514e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001433, c.this.f56511g.getItem(i2)));
            c.this.f(this.f56514e);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d {
        public b() {
        }

        @Override // d.a.c.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.f56512h = false;
            if (c.this.f56510f != null) {
                c.this.f56510f.a();
            }
            c.this.f56508d.removeView(c.this.f56507c);
        }
    }

    /* renamed from: d.a.o0.d1.f.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1305c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        this.f56508d = viewGroup;
    }

    public void f(Context context) {
        View view = this.f56507c;
        if (view != null) {
            view.startAnimation(i(context));
        }
    }

    public final View g(Context context, List<p> list, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_scroll_fragment_more, (ViewGroup) null);
        this.f56509e = inflate.findViewById(R.id.topic_more_top_view);
        k(this.f56513i);
        GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        d.a.o0.d1.f.f.b bVar = new d.a.o0.d1.f.f.b(context, i2);
        this.f56511g = bVar;
        bVar.b(list);
        gridView.setAdapter((ListAdapter) this.f56511g);
        gridView.setOnItemClickListener(new a(context));
        return inflate;
    }

    public final Animation h(Context context) {
        if (this.f56505a == null) {
            this.f56505a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.f56505a;
    }

    public final Animation i(Context context) {
        if (this.f56506b == null) {
            this.f56506b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.f56506b.setAnimationListener(new b());
        return this.f56506b;
    }

    public boolean j() {
        return this.f56512h;
    }

    public void k(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f56509e.getLayoutParams();
        layoutParams.height = i2;
        this.f56509e.setLayoutParams(layoutParams);
    }

    public void l(InterfaceC1305c interfaceC1305c) {
        this.f56510f = interfaceC1305c;
    }

    public void m(int i2) {
        this.f56513i = i2;
    }

    public void n(Context context, List<p> list, int i2) {
        if (this.f56512h) {
            return;
        }
        this.f56512h = true;
        View g2 = g(context, list, i2);
        this.f56507c = g2;
        this.f56508d.addView(g2);
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            View view = this.f56507c;
            view.setBackgroundColor(view.getContext().getResources().getColor(R.color.topic_more_background));
        } else {
            View view2 = this.f56507c;
            view2.setBackgroundColor(view2.getContext().getResources().getColor(R.color.topic_more_background_1));
        }
        this.f56507c.startAnimation(h(context));
    }
}
