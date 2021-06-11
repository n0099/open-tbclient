package d.a.n0.v.j.g.c.c;

import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f65830a;

    /* renamed from: b  reason: collision with root package name */
    public String f65831b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b> f65832c = new ArrayList<>();

    public void a(b bVar) {
        this.f65832c.add(bVar);
    }

    public b b(int i2) {
        return (b) ListUtils.getItem(this.f65832c, i2);
    }

    public String c() {
        return this.f65831b;
    }

    public int d() {
        return this.f65830a;
    }

    public void e(String str) {
        this.f65831b = str;
    }

    public void f(int i2) {
        this.f65830a = i2;
    }
}
