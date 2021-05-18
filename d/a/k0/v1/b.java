package d.a.k0.v1;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import d.a.j0.r.q.g1;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<UserData> f62378e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62379f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62380g = false;

    public abstract void a(g1 g1Var);

    public void b() {
        this.f62379f = false;
        ArrayList<UserData> arrayList = this.f62378e;
        if (arrayList == null || arrayList.size() != 0) {
            return;
        }
        this.f62379f = true;
    }

    public boolean c() {
        return this.f62380g;
    }

    public abstract boolean d(long j);

    public void e() {
        this.f62378e.clear();
    }

    public void f(boolean z) {
        this.f62380g = z;
    }
}
