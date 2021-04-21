package d.a.a.s.c;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final List<a<d.a.a.u.j.h, Path>> f41704a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a<Integer, Integer>> f41705b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Mask> f41706c;

    public g(List<Mask> list) {
        this.f41706c = list;
        this.f41704a = new ArrayList(list.size());
        this.f41705b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f41704a.add(list.get(i).b().a());
            this.f41705b.add(list.get(i).c().a());
        }
    }

    public List<a<d.a.a.u.j.h, Path>> a() {
        return this.f41704a;
    }

    public List<Mask> b() {
        return this.f41706c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f41705b;
    }
}
