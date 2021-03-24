package d.b.i0.u1;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import d.b.h0.r.q.g1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<UserData> f61263e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61264f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61265g = false;

    public abstract void a(g1 g1Var);

    public void b() {
        this.f61264f = false;
        ArrayList<UserData> arrayList = this.f61263e;
        if (arrayList == null || arrayList.size() != 0) {
            return;
        }
        this.f61264f = true;
    }

    public boolean c() {
        return this.f61265g;
    }

    public abstract boolean d(long j);

    public void e() {
        this.f61263e.clear();
    }

    public void f(boolean z) {
        this.f61265g = z;
    }
}
