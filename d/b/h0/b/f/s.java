package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.debugtool.annotation.UbsTest;
import java.util.ArrayList;
@ModifyClass
/* loaded from: classes3.dex */
public class s extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49744c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49745a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49746b;

    public s() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f49745a = arrayList;
        arrayList.add("70_2");
        this.f49745a.add("70_3");
        this.f49745a.add("70_4");
        this.f49745a.add("70_5");
        this.f49745a.add("70_6");
        this.f49745a.add("71_2");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49745a;
    }

    @Override // d.b.h0.b.f.a
    @UbsTest(description = "10.5版本卡片相关的abtest分组")
    public d.b.h0.b.e b() {
        return this.f49746b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49744c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49746b = eVar;
    }
}
