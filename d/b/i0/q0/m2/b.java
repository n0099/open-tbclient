package d.b.i0.q0.m2;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public g f59544a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f59545b;

    /* renamed from: c  reason: collision with root package name */
    public int f59546c = 0;

    /* renamed from: d  reason: collision with root package name */
    public a f59547d;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i);
    }

    public b(g gVar, Intent intent) {
        this.f59544a = gVar;
        this.f59545b = intent;
        e c2 = d.d().c(this.f59545b.getStringExtra("info_forum_name_text"));
        c2.b();
        c2.a();
        if (c2.c()) {
            ((RelativeLayout.LayoutParams) this.f59544a.f59571g.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public int a() {
        return this.f59546c;
    }

    public void b(a aVar) {
        this.f59547d = aVar;
    }

    public abstract void c();

    public abstract void d();
}
