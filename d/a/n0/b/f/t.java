package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.debugtool.annotation.UbsTest;
import java.util.ArrayList;
@ModifyClass
/* loaded from: classes3.dex */
public class t extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52661c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52662a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52663b;

    public t() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f52662a = arrayList;
        arrayList.add("70_2");
        this.f52662a.add("70_3");
        this.f52662a.add("70_4");
        this.f52662a.add("70_5");
        this.f52662a.add("70_6");
        this.f52662a.add("71_2");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52662a;
    }

    @Override // d.a.n0.b.f.a
    @UbsTest(description = "10.5版本卡片相关的abtest分组")
    public d.a.n0.b.e b() {
        return this.f52663b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52661c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52663b = eVar;
    }
}
