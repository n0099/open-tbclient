package d.a.i0.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.debugtool.annotation.UbsTest;
import java.util.ArrayList;
@ModifyClass
/* loaded from: classes3.dex */
public class s extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48027c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48028a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.b.e f48029b;

    public s() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f48028a = arrayList;
        arrayList.add("70_2");
        this.f48028a.add("70_3");
        this.f48028a.add("70_4");
        this.f48028a.add("70_5");
        this.f48028a.add("70_6");
        this.f48028a.add("71_2");
    }

    @Override // d.a.i0.b.f.a
    public ArrayList<String> a() {
        return this.f48028a;
    }

    @Override // d.a.i0.b.f.a
    @UbsTest(description = "10.5版本卡片相关的abtest分组")
    public d.a.i0.b.e b() {
        return this.f48029b;
    }

    @Override // d.a.i0.b.f.a
    public BdUniqueId c() {
        return f48027c;
    }

    @Override // d.a.i0.b.f.a
    public void f(d.a.i0.b.e eVar) {
        this.f48029b = eVar;
    }
}
