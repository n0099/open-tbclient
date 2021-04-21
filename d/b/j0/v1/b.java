package d.b.j0.v1;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import d.b.i0.r.q.g1;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<UserData> f63423e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63424f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63425g = false;

    public abstract void a(g1 g1Var);

    public void b() {
        this.f63424f = false;
        ArrayList<UserData> arrayList = this.f63423e;
        if (arrayList == null || arrayList.size() != 0) {
            return;
        }
        this.f63424f = true;
    }

    public boolean c() {
        return this.f63425g;
    }

    public abstract boolean d(long j);

    public void e() {
        this.f63423e.clear();
    }

    public void f(boolean z) {
        this.f63425g = z;
    }
}
