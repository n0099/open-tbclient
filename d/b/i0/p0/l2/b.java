package d.b.i0.p0.l2;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public g f57834a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f57835b;

    /* renamed from: c  reason: collision with root package name */
    public int f57836c = 0;

    /* renamed from: d  reason: collision with root package name */
    public a f57837d;

    /* loaded from: classes4.dex */
    public interface a {
        void onStateChanged(int i);
    }

    public b(g gVar, Intent intent) {
        this.f57834a = gVar;
        this.f57835b = intent;
        e c2 = d.d().c(this.f57835b.getStringExtra("info_forum_name_text"));
        c2.b();
        c2.a();
        if (c2.c()) {
            ((RelativeLayout.LayoutParams) this.f57834a.f57861g.getLayoutParams()).topMargin = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds_104);
        }
    }

    public int a() {
        return this.f57836c;
    }

    public void b(a aVar) {
        this.f57837d = aVar;
    }

    public abstract void c();

    public abstract void d();
}
