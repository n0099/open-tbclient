package d.b.j0.t.j.g.c.c;

import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f62902a;

    /* renamed from: b  reason: collision with root package name */
    public String f62903b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b> f62904c = new ArrayList<>();

    public void a(b bVar) {
        this.f62904c.add(bVar);
    }

    public b b(int i) {
        return (b) ListUtils.getItem(this.f62904c, i);
    }

    public String c() {
        return this.f62903b;
    }

    public int d() {
        return this.f62902a;
    }

    public void e(String str) {
        this.f62903b = str;
    }

    public void f(int i) {
        this.f62902a = i;
    }
}
