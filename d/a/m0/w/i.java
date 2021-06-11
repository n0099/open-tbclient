package d.a.m0.w;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tieba.R;
import d.a.m0.w.y.a;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class i extends d.a.m0.w.y.a {
    public LinkedList<h> q;

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC1226a {
        public a() {
        }

        @Override // d.a.m0.w.y.a.InterfaceC1226a
        public View getView(int i2, View view, ViewGroup viewGroup) {
            DLauncher F = i.this.F(i2);
            if (F.getLayoutParams() == null) {
                F.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            }
            return F;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CommonTabContentView.c {
        public b() {
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabContentView.c
        public void a(View view, int i2, long j) {
            if (view.isEnabled() && (view instanceof DLauncher) && i.this.n != null) {
                i.this.n.x(view);
            }
        }
    }

    public void E(LinkedList<h> linkedList) {
        this.q = linkedList;
    }

    public final DLauncher F(int i2) {
        if (i2 < 0 || i2 >= f()) {
            return null;
        }
        return (DLauncher) this.q.get(i2);
    }

    @Override // d.a.m0.w.y.a
    public void a() {
        LinkedList<h> linkedList = this.q;
        if (linkedList != null) {
            linkedList.clear();
        }
        this.q = null;
    }

    @Override // d.a.m0.w.y.a
    public int f() {
        LinkedList<h> linkedList = this.q;
        if (linkedList != null) {
            return linkedList.size();
        }
        return 0;
    }

    @Override // d.a.m0.w.b
    public void onAction(d.a.m0.w.a aVar) {
    }

    @Override // d.a.m0.w.y.a
    public void q(Context context) {
        t(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X004));
        w(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
        x(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
        r(4);
        y(2);
        A(new a());
        k().b(this);
        v(new b());
    }
}
