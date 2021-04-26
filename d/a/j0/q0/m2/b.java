package d.a.j0.q0.m2;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public g f58043a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f58044b;

    /* renamed from: c  reason: collision with root package name */
    public int f58045c = 0;

    /* renamed from: d  reason: collision with root package name */
    public a f58046d;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i2);
    }

    public b(g gVar, Intent intent) {
        this.f58043a = gVar;
        this.f58044b = intent;
        e c2 = d.d().c(this.f58044b.getStringExtra("info_forum_name_text"));
        c2.b();
        c2.a();
        if (c2.c()) {
            ((RelativeLayout.LayoutParams) this.f58043a.f58070g.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public int a() {
        return this.f58045c;
    }

    public void b(a aVar) {
        this.f58046d = aVar;
    }

    public abstract void c();

    public abstract void d();
}
