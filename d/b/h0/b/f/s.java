package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.debugtool.annotation.UbsTest;
import java.util.ArrayList;
@ModifyClass
/* loaded from: classes3.dex */
public class s extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50137c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50138a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f50139b;

    public s() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f50138a = arrayList;
        arrayList.add("70_2");
        this.f50138a.add("70_3");
        this.f50138a.add("70_4");
        this.f50138a.add("70_5");
        this.f50138a.add("70_6");
        this.f50138a.add("71_2");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f50138a;
    }

    @Override // d.b.h0.b.f.a
    @UbsTest(description = "10.5版本卡片相关的abtest分组")
    public d.b.h0.b.e b() {
        return this.f50139b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f50137c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f50139b = eVar;
    }
}
