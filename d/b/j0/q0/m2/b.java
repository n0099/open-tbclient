package d.b.j0.q0.m2;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public g f59965a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f59966b;

    /* renamed from: c  reason: collision with root package name */
    public int f59967c = 0;

    /* renamed from: d  reason: collision with root package name */
    public a f59968d;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i);
    }

    public b(g gVar, Intent intent) {
        this.f59965a = gVar;
        this.f59966b = intent;
        e c2 = d.d().c(this.f59966b.getStringExtra("info_forum_name_text"));
        c2.b();
        c2.a();
        if (c2.c()) {
            ((RelativeLayout.LayoutParams) this.f59965a.f59992g.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public int a() {
        return this.f59967c;
    }

    public void b(a aVar) {
        this.f59968d = aVar;
    }

    public abstract void c();

    public abstract void d();
}
