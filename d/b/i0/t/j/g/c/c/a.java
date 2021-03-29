package d.b.i0.t.j.g.c.c;

import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f60917a;

    /* renamed from: b  reason: collision with root package name */
    public String f60918b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b> f60919c = new ArrayList<>();

    public void a(b bVar) {
        this.f60919c.add(bVar);
    }

    public b b(int i) {
        return (b) ListUtils.getItem(this.f60919c, i);
    }

    public String c() {
        return this.f60918b;
    }

    public int d() {
        return this.f60917a;
    }

    public void e(String str) {
        this.f60918b = str;
    }

    public void f(int i) {
        this.f60917a = i;
    }
}
