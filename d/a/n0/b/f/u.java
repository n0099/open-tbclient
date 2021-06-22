package d.a.n0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class u extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f52664c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f52665a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.b.e f52666b;

    public u() {
        ArrayList<String> arrayList = new ArrayList<>(6);
        this.f52665a = arrayList;
        arrayList.add("12_3_video_release");
        this.f52665a.add("12_3_video_release_a");
        this.f52665a.add("12_3_video_release_b");
        this.f52665a.add("12_3_video_release_c");
        this.f52665a.add("12_3_video_release_d");
        this.f52665a.add("12_3_video_release_e");
    }

    @Override // d.a.n0.b.f.a
    public ArrayList<String> a() {
        return this.f52665a;
    }

    @Override // d.a.n0.b.f.a
    public d.a.n0.b.e b() {
        return this.f52666b;
    }

    @Override // d.a.n0.b.f.a
    public BdUniqueId c() {
        return f52664c;
    }

    @Override // d.a.n0.b.f.a
    public void f(d.a.n0.b.e eVar) {
        this.f52666b = eVar;
    }
}
