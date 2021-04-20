package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.debugtool.annotation.UbsTest;
import java.util.ArrayList;
@ModifyClass
/* loaded from: classes3.dex */
public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50098c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50099a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f50100b;

    public e() {
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f50099a = arrayList;
        arrayList.add("11_9_frs_page_guide");
        this.f50099a.add("11_9_frs_page_guide_a");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f50099a;
    }

    @Override // d.b.h0.b.f.a
    @UbsTest(description = "frs引导弹窗的abtest，FRS页引导关注")
    public d.b.h0.b.e b() {
        return this.f50100b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f50098c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f50100b = eVar;
    }
}
