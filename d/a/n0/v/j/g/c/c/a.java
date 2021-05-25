package d.a.n0.v.j.g.c.c;

import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f62115a;

    /* renamed from: b  reason: collision with root package name */
    public String f62116b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b> f62117c = new ArrayList<>();

    public void a(b bVar) {
        this.f62117c.add(bVar);
    }

    public b b(int i2) {
        return (b) ListUtils.getItem(this.f62117c, i2);
    }

    public String c() {
        return this.f62116b;
    }

    public int d() {
        return this.f62115a;
    }

    public void e(String str) {
        this.f62116b = str;
    }

    public void f(int i2) {
        this.f62115a = i2;
    }
}
