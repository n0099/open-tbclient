package d.a.j0.t.j.g.c.c;

import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f61103a;

    /* renamed from: b  reason: collision with root package name */
    public String f61104b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b> f61105c = new ArrayList<>();

    public void a(b bVar) {
        this.f61105c.add(bVar);
    }

    public b b(int i2) {
        return (b) ListUtils.getItem(this.f61105c, i2);
    }

    public String c() {
        return this.f61104b;
    }

    public int d() {
        return this.f61103a;
    }

    public void e(String str) {
        this.f61104b = str;
    }

    public void f(int i2) {
        this.f61103a = i2;
    }
}
