package d.a.n0.w1;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import d.a.m0.r.q.g1;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<UserData> f62484e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62485f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62486g = false;

    public abstract void a(g1 g1Var);

    public void b() {
        this.f62485f = false;
        ArrayList<UserData> arrayList = this.f62484e;
        if (arrayList == null || arrayList.size() != 0) {
            return;
        }
        this.f62485f = true;
    }

    public boolean c() {
        return this.f62486g;
    }

    public abstract boolean d(long j);

    public void e() {
        this.f62484e.clear();
    }

    public void f(boolean z) {
        this.f62486g = z;
    }
}
