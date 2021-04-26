package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.debugtool.annotation.UbsTest;
import java.util.ArrayList;
@ModifyClass
/* loaded from: classes3.dex */
public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f47988c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f47989a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f47990b;

    public e() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f47989a = arrayList;
        arrayList.add("11_9_frs_page_guide");
        this.f47989a.add("11_9_frs_page_guide_a");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f47989a;
    }

    @Override // d.a.i0.b.f.a
    @UbsTest(description = "frs引导弹窗的abtest，FRS页引导关注")
    public d.a.i0.b.e b() {
        return this.f47990b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f47988c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f47990b = eVar;
    }
}
