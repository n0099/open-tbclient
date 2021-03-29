package d.b.i0.u1;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import d.b.h0.r.q.g1;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<UserData> f61264e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61265f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61266g = false;

    public abstract void a(g1 g1Var);

    public void b() {
        this.f61265f = false;
        ArrayList<UserData> arrayList = this.f61264e;
        if (arrayList == null || arrayList.size() != 0) {
            return;
        }
        this.f61265f = true;
    }

    public boolean c() {
        return this.f61266g;
    }

    public abstract boolean d(long j);

    public void e() {
        this.f61264e.clear();
    }

    public void f(boolean z) {
        this.f61266g = z;
    }
}
