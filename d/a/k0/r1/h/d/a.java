package d.a.k0.r1.h.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.tieba.R;
import d.a.j0.w.h;
import d.a.j0.w.y.a;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class a extends d.a.j0.w.y.a {
    public LinkedList<h> q;

    /* renamed from: d.a.k0.r1.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1588a implements a.InterfaceC1161a {
        public C1588a() {
        }

        @Override // d.a.j0.w.y.a.InterfaceC1161a
        public View getView(int i2, View view, ViewGroup viewGroup) {
            DLauncher D = a.this.D(i2);
            if (D.getLayoutParams() == null) {
                D.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            }
            return D;
        }
    }

    public void C(LinkedList<h> linkedList) {
        this.q = linkedList;
    }

    public final DLauncher D(int i2) {
        if (i2 < 0 || i2 >= f()) {
            return null;
        }
        return (DLauncher) this.q.get(i2);
    }

    @Override // d.a.j0.w.y.a
    public void a() {
        LinkedList<h> linkedList = this.q;
        if (linkedList != null) {
            linkedList.clear();
            this.q = null;
        }
    }

    @Override // d.a.j0.w.y.a
    public int f() {
        LinkedList<h> linkedList = this.q;
        if (linkedList != null) {
            return linkedList.size();
        }
        return 0;
    }

    @Override // d.a.j0.w.b
    public void onAction(d.a.j0.w.a aVar) {
    }

    @Override // d.a.j0.w.y.a
    public void q(Context context) {
        r(4);
        y(2);
        t(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X004));
        w(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
        x(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X006));
        A(new C1588a());
        k().b(this);
    }
}
