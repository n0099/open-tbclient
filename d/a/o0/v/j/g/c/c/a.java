package d.a.o0.v.j.g.c.c;

import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f65955a;

    /* renamed from: b  reason: collision with root package name */
    public String f65956b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b> f65957c = new ArrayList<>();

    public void a(b bVar) {
        this.f65957c.add(bVar);
    }

    public b b(int i2) {
        return (b) ListUtils.getItem(this.f65957c, i2);
    }

    public String c() {
        return this.f65956b;
    }

    public int d() {
        return this.f65955a;
    }

    public void e(String str) {
        this.f65956b = str;
    }

    public void f(int i2) {
        this.f65955a = i2;
    }
}
