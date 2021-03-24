package d.b.i0.t.j.g.c.c;

import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f60916a;

    /* renamed from: b  reason: collision with root package name */
    public String f60917b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b> f60918c = new ArrayList<>();

    public void a(b bVar) {
        this.f60918c.add(bVar);
    }

    public b b(int i) {
        return (b) ListUtils.getItem(this.f60918c, i);
    }

    public String c() {
        return this.f60917b;
    }

    public int d() {
        return this.f60916a;
    }

    public void e(String str) {
        this.f60917b = str;
    }

    public void f(int i) {
        this.f60916a = i;
    }
}
