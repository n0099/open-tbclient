package d.b.i0.q1.h.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.tieba.R;
import d.b.h0.w.h;
import d.b.h0.w.y.a;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class a extends d.b.h0.w.y.a {
    public LinkedList<h> q;

    /* renamed from: d.b.i0.q1.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1488a implements a.InterfaceC1112a {
        public C1488a() {
        }

        @Override // d.b.h0.w.y.a.InterfaceC1112a
        public View getView(int i, View view, ViewGroup viewGroup) {
            DLauncher D = a.this.D(i);
            if (D.getLayoutParams() == null) {
                D.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            }
            return D;
        }
    }

    public void C(LinkedList<h> linkedList) {
        this.q = linkedList;
    }

    public final DLauncher D(int i) {
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
            this.q = null;
        }
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
        r(4);
        y(2);
        t(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X004));
        w(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
        x(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
        A(new C1488a());
        k().b(this);
    }
}
