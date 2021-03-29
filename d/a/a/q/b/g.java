package d.a.a.q.b;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<d.a.a.s.j.h, Path>> f41296a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a<Integer, Integer>> f41297b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Mask> f41298c;

    public g(List<Mask> list) {
        this.f41298c = list;
        this.f41296a = new ArrayList(list.size());
        this.f41297b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f41296a.add(list.get(i).b().a());
            this.f41297b.add(list.get(i).c().a());
        }
    }

    public List<a<d.a.a.s.j.h, Path>> a() {
        return this.f41296a;
    }

    public List<Mask> b() {
        return this.f41298c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f41297b;
    }
}
