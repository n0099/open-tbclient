package d.a.a.s.c;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<d.a.a.u.j.h, Path>> f41609a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a<Integer, Integer>> f41610b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Mask> f41611c;

    public g(List<Mask> list) {
        this.f41611c = list;
        this.f41609a = new ArrayList(list.size());
        this.f41610b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f41609a.add(list.get(i).b().a());
            this.f41610b.add(list.get(i).c().a());
        }
    }

    public List<a<d.a.a.u.j.h, Path>> a() {
        return this.f41609a;
    }

    public List<Mask> b() {
        return this.f41611c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f41610b;
    }
}
