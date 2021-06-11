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
    public Animation f56380a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f56381b;

    /* renamed from: c  reason: collision with root package name */
    public View f56382c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56383d;

    /* renamed from: e  reason: collision with root package name */
    public View f56384e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1301c f56385f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.d1.f.f.b f56386g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56387h = false;

    /* renamed from: i  reason: collision with root package name */
    public int f56388i;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f56389e;

        public a(Context context) {
            this.f56389e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001433, c.this.f56386g.getItem(i2)));
            c.this.f(this.f56389e);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d {
        public b() {
        }

        @Override // d.a.c.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.f56387h = false;
            if (c.this.f56385f != null) {
                c.this.f56385f.a();
            }
            c.this.f56383d.removeView(c.this.f56382c);
        }
    }

    /* renamed from: d.a.n0.d1.f.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1301c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        this.f56383d = viewGroup;
    }

    public void f(Context context) {
        View view = this.f56382c;
        if (view != null) {
            view.startAnimation(i(context));
        }
    }

    public final View g(Context context, List<p> list, int i2) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_scroll_fragment_more, (ViewGroup) null);
        this.f56384e = inflate.findViewById(R.id.topic_more_top_view);
        k(this.f56388i);
        GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        d.a.n0.d1.f.f.b bVar = new d.a.n0.d1.f.f.b(context, i2);
        this.f56386g = bVar;
        bVar.b(list);
        gridView.setAdapter((ListAdapter) this.f56386g);
        gridView.setOnItemClickListener(new a(context));
        return inflate;
    }

    public final Animation h(Context context) {
        if (this.f56380a == null) {
            this.f56380a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.f56380a;
    }

    public final Animation i(Context context) {
        if (this.f56381b == null) {
            this.f56381b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.f56381b.setAnimationListener(new b());
        return this.f56381b;
    }

    public boolean j() {
        return this.f56387h;
    }

    public void k(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f56384e.getLayoutParams();
        layoutParams.height = i2;
        this.f56384e.setLayoutParams(layoutParams);
    }

    public void l(InterfaceC1301c interfaceC1301c) {
        this.f56385f = interfaceC1301c;
    }

    public void m(int i2) {
        this.f56388i = i2;
    }

    public void n(Context context, List<p> list, int i2) {
        if (this.f56387h) {
            return;
        }
        this.f56387h = true;
        View g2 = g(context, list, i2);
        this.f56382c = g2;
        this.f56383d.addView(g2);
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            View view = this.f56382c;
            view.setBackgroundColor(view.getContext().getResources().getColor(R.color.topic_more_background));
        } else {
            View view2 = this.f56382c;
            view2.setBackgroundColor(view2.getContext().getResources().getColor(R.color.topic_more_background_1));
        }
        this.f56382c.startAnimation(h(context));
    }
}
