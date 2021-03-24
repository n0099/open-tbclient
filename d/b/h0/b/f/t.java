package d.b.h0.b.f;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class t extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f49746c = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f49747a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.b.e f49748b;

    public t() {
        ArrayList<String> arrayList = new ArrayList<>(6);
        this.f49747a = arrayList;
        arrayList.add("12_3_video_release");
        this.f49747a.add("12_3_video_release_a");
        this.f49747a.add("12_3_video_release_b");
        this.f49747a.add("12_3_video_release_c");
        this.f49747a.add("12_3_video_release_d");
        this.f49747a.add("12_3_video_release_e");
    }

    @Override // d.b.h0.b.f.a
    public ArrayList<String> a() {
        return this.f49747a;
    }

    @Override // d.b.h0.b.f.a
    public d.b.h0.b.e b() {
        return this.f49748b;
    }

    @Override // d.b.h0.b.f.a
    public BdUniqueId c() {
        return f49746c;
    }

    @Override // d.b.h0.b.f.a
    public void f(d.b.h0.b.e eVar) {
        this.f49748b = eVar;
    }
}
