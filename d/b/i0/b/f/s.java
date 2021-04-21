package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.debugtool.annotation.UbsTest;
import java.util.ArrayList;
@ModifyClass
/* loaded from: classes3.dex */
public class s extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50473c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50474a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50475b;

    public s() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f50474a = arrayList;
        arrayList.add("70_2");
        this.f50474a.add("70_3");
        this.f50474a.add("70_4");
        this.f50474a.add("70_5");
        this.f50474a.add("70_6");
        this.f50474a.add("71_2");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50474a;
    }

    @Override // d.b.i0.b.f.a
    @UbsTest(description = "10.5版本卡片相关的abtest分组")
    public d.b.i0.b.e b() {
        return this.f50475b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50473c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50475b = eVar;
    }
}
