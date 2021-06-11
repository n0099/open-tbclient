package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class u extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52557c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52558a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f52559b;

    public u() {
        ArrayList<String> arrayList = new ArrayList<>(6);
        this.f52558a = arrayList;
        arrayList.add("12_3_video_release");
        this.f52558a.add("12_3_video_release_a");
        this.f52558a.add("12_3_video_release_b");
        this.f52558a.add("12_3_video_release_c");
        this.f52558a.add("12_3_video_release_d");
        this.f52558a.add("12_3_video_release_e");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f52558a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f52559b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f52557c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f52559b = eVar;
    }
}
