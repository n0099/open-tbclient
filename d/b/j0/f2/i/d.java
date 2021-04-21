package d.b.j0.f2.i;

import com.baidu.adp.BdUniqueId;
import d.b.c.j.e.n;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f56419f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56420e;

    public d(boolean z, a aVar) {
        String str = aVar.f56415e;
        String str2 = aVar.f56414d;
        this.f56420e = aVar.f56411a;
        String str3 = aVar.f56416f;
        List<b> list = aVar.f56413c;
        int i = aVar.f56412b;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f56419f;
    }
}
