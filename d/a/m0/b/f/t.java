package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.debugtool.annotation.UbsTest;
import java.util.ArrayList;
@ModifyClass
/* loaded from: classes3.dex */
public class t extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48880c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48881a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48882b;

    public t() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f48881a = arrayList;
        arrayList.add("70_2");
        this.f48881a.add("70_3");
        this.f48881a.add("70_4");
        this.f48881a.add("70_5");
        this.f48881a.add("70_6");
        this.f48881a.add("71_2");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48881a;
    }

    @Override // d.a.m0.b.f.a
    @UbsTest(description = "10.5版本卡片相关的abtest分组")
    public d.a.m0.b.e b() {
        return this.f48882b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48880c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48882b = eVar;
    }
}
