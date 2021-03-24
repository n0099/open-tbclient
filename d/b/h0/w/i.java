package d.b.h0.w;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.tbadk.editortools.view.CommonTabContentView;
import com.baidu.tieba.R;
import d.b.h0.w.y.a;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class i extends d.b.h0.w.y.a {
    public LinkedList<h> q;

    /* loaded from: classes3.dex */
    public class a implements a.InterfaceC1111a {
        public a() {
        }

        @Override // d.b.h0.w.y.a.InterfaceC1111a
        public View getView(int i, View view, ViewGroup viewGroup) {
            DLauncher F = i.this.F(i);
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
        public void a(View view, int i, long j) {
            if (view.isEnabled() && (view instanceof DLauncher) && i.this.n != null) {
                i.this.n.x(view);
            }
        }
    }

    public void E(LinkedList<h> linkedList) {
        this.q = linkedList;
    }

    public final DLauncher F(int i) {
        if (i < 0 || i >= e()) {
            return null;
        }
        return (DLauncher) this.q.get(i);
    }

    @Override // d.b.h0.w.y.a
    public void a() {
        LinkedList<h> linkedList = this.q;
        if (linkedList != null) {
            linkedList.clear();
        }
        this.q = null;
    }

    @Override // d.b.h0.w.y.a
    public int e() {
        LinkedList<h> linkedList = this.q;
        if (linkedList != null) {
            return linkedList.size();
        }
        return 0;
    }

    @Override // d.b.h0.w.b
    public void onAction(d.b.h0.w.a aVar) {
    }

    @Override // d.b.h0.w.y.a
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
