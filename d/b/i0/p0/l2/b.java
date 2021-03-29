package d.b.i0.p0.l2;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public g f57835a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f57836b;

    /* renamed from: c  reason: collision with root package name */
    public int f57837c = 0;

    /* renamed from: d  reason: collision with root package name */
    public a f57838d;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i);
    }

    public b(g gVar, Intent intent) {
        this.f57835a = gVar;
        this.f57836b = intent;
        e c2 = d.d().c(this.f57836b.getStringExtra("info_forum_name_text"));
        c2.b();
        c2.a();
        if (c2.c()) {
            ((RelativeLayout.LayoutParams) this.f57835a.f57862g.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public int a() {
        return this.f57837c;
    }

    public void b(a aVar) {
        this.f57838d = aVar;
    }

    public abstract void c();

    public abstract void d();
}
