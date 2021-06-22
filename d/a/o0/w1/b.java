package d.a.o0.w1;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import d.a.n0.r.q.g1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<UserData> f66324e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66325f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66326g = false;

    public abstract void a(g1 g1Var);

    public void b() {
        this.f66325f = false;
        ArrayList<UserData> arrayList = this.f66324e;
        if (arrayList == null || arrayList.size() != 0) {
            return;
        }
        this.f66325f = true;
    }

    public boolean c() {
        return this.f66326g;
    }

    public abstract boolean d(long j);

    public void e() {
        this.f66324e.clear();
    }

    public void f(boolean z) {
        this.f66326g = z;
    }
}
