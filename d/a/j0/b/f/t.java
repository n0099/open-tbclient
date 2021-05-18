package d.a.j0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class t extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48858c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48859a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b.e f48860b;

    public t() {
        ArrayList<String> arrayList = new ArrayList<>(6);
        this.f48859a = arrayList;
        arrayList.add("12_3_video_release");
        this.f48859a.add("12_3_video_release_a");
        this.f48859a.add("12_3_video_release_b");
        this.f48859a.add("12_3_video_release_c");
        this.f48859a.add("12_3_video_release_d");
        this.f48859a.add("12_3_video_release_e");
    }

    @Override // d.a.j0.b.f.a
    public ArrayList<String> a() {
        return this.f48859a;
    }

    @Override // d.a.j0.b.f.a
    public d.a.j0.b.e b() {
        return this.f48860b;
    }

    @Override // d.a.j0.b.f.a
    public BdUniqueId c() {
        return f48858c;
    }

    @Override // d.a.j0.b.f.a
    public void f(d.a.j0.b.e eVar) {
        this.f48860b = eVar;
    }
}
