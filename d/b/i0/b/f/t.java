package d.b.i0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class t extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f50476c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f50477a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b.e f50478b;

    public t() {
        ArrayList<String> arrayList = new ArrayList<>(6);
        this.f50477a = arrayList;
        arrayList.add("12_3_video_release");
        this.f50477a.add("12_3_video_release_a");
        this.f50477a.add("12_3_video_release_b");
        this.f50477a.add("12_3_video_release_c");
        this.f50477a.add("12_3_video_release_d");
        this.f50477a.add("12_3_video_release_e");
    }

    @Override // d.b.i0.b.f.a
    public ArrayList<String> a() {
        return this.f50477a;
    }

    @Override // d.b.i0.b.f.a
    public d.b.i0.b.e b() {
        return this.f50478b;
    }

    @Override // d.b.i0.b.f.a
    public BdUniqueId c() {
        return f50476c;
    }

    @Override // d.b.i0.b.f.a
    public void f(d.b.i0.b.e eVar) {
        this.f50478b = eVar;
    }
}
