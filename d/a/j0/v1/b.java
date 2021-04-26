package d.a.j0.v1;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import d.a.i0.r.q.g1;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<UserData> f61654e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61655f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61656g = false;

    public abstract void a(g1 g1Var);

    public void b() {
        this.f61655f = false;
        ArrayList<UserData> arrayList = this.f61654e;
        if (arrayList == null || arrayList.size() != 0) {
            return;
        }
        this.f61655f = true;
    }

    public boolean c() {
        return this.f61656g;
    }

    public abstract boolean d(long j);

    public void e() {
        this.f61654e.clear();
    }

    public void f(boolean z) {
        this.f61656g = z;
    }
}
