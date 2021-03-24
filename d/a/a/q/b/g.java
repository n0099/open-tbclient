package d.a.a.q.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<d.a.a.s.j.h, Path>> f41295a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a<Integer, Integer>> f41296b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Mask> f41297c;

    public g(List<Mask> list) {
        this.f41297c = list;
        this.f41295a = new ArrayList(list.size());
        this.f41296b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f41295a.add(list.get(i).b().a());
            this.f41296b.add(list.get(i).c().a());
        }
    }

    public List<a<d.a.a.s.j.h, Path>> a() {
        return this.f41295a;
    }

    public List<Mask> b() {
        return this.f41297c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f41296b;
    }
}
