package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.debugtool.annotation.UbsTest;
import java.util.ArrayList;
@ModifyClass
/* loaded from: classes3.dex */
public class f extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52622c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52623a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52624b;

    public f() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f52623a = arrayList;
        arrayList.add("11_9_frs_page_guide");
        this.f52623a.add("11_9_frs_page_guide_a");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52623a;
    }

    @Override // d.a.n0.b.f.a
    @UbsTest(description = "frs引导弹窗的abtest，FRS页引导关注")
    public d.a.n0.b.e b() {
        return this.f52624b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52622c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52624b = eVar;
    }
}
