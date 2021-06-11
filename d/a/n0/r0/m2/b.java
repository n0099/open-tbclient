package d.a.n0.r0.m2;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public g f62617a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f62618b;

    /* renamed from: c  reason: collision with root package name */
    public int f62619c = 0;

    /* renamed from: d  reason: collision with root package name */
    public a f62620d;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i2);
    }

    public b(g gVar, Intent intent) {
        this.f62617a = gVar;
        this.f62618b = intent;
        e c2 = d.d().c(this.f62618b.getStringExtra("info_forum_name_text"));
        c2.b();
        c2.a();
        if (c2.c()) {
            ((RelativeLayout.LayoutParams) this.f62617a.f62644g.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public int a() {
        return this.f62619c;
    }

    public void b(a aVar) {
        this.f62620d = aVar;
    }

    public abstract void c();

    public abstract void d();
}
