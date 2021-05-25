package d.a.m0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class u extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f48883c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f48884a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.b.e f48885b;

    public u() {
        ArrayList<String> arrayList = new ArrayList<>(6);
        this.f48884a = arrayList;
        arrayList.add("12_3_video_release");
        this.f48884a.add("12_3_video_release_a");
        this.f48884a.add("12_3_video_release_b");
        this.f48884a.add("12_3_video_release_c");
        this.f48884a.add("12_3_video_release_d");
        this.f48884a.add("12_3_video_release_e");
    }

    @Override // d.a.m0.b.f.a
    public ArrayList<String> a() {
        return this.f48884a;
    }

    @Override // d.a.m0.b.f.a
    public d.a.m0.b.e b() {
        return this.f48885b;
    }

    @Override // d.a.m0.b.f.a
    public BdUniqueId c() {
        return f48883c;
    }

    @Override // d.a.m0.b.f.a
    public void f(d.a.m0.b.e eVar) {
        this.f48885b = eVar;
    }
}
