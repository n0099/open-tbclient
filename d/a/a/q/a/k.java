package d.a.a.q.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes.dex */
public class k implements l, i {

    /* renamed from: d  reason: collision with root package name */
    public final String f41247d;

    /* renamed from: f  reason: collision with root package name */
    public final MergePaths f41249f;

    /* renamed from: a  reason: collision with root package name */
    public final Path f41244a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final Path f41245b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public final Path f41246c = new Path();

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f41248e = new ArrayList();

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41250a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f41250a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.Merge.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41250a[MergePaths.MergePathsMode.Add.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41250a[MergePaths.MergePathsMode.Subtract.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41250a[MergePaths.MergePathsMode.Intersect.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41250a[MergePaths.MergePathsMode.ExcludeIntersections.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public k(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f41247d = mergePaths.c();
            this.f41249f = mergePaths;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    public final void a() {
        for (int i = 0; i < this.f41248e.size(); i++) {
            this.f41246c.addPath(this.f41248e.get(i).getPath());
        }
    }

    @Override // d.a.a.q.a.b
    public void b(List<b> list, List<b> list2) {
        for (int i = 0; i < this.f41248e.size(); i++) {
            this.f41248e.get(i).b(list, list2);
        }
    }

    @TargetApi(19)
    public final void d(Path.Op op) {
        this.f41245b.reset();
        this.f41244a.reset();
        for (int size = this.f41248e.size() - 1; size >= 1; size--) {
            l lVar = this.f41248e.get(size);
            if (lVar instanceof c) {
                c cVar = (c) lVar;
                List<l> i = cVar.i();
                for (int size2 = i.size() - 1; size2 >= 0; size2--) {
                    Path path = i.get(size2).getPath();
                    path.transform(cVar.j());
                    this.f41245b.addPath(path);
                }
            } else {
                this.f41245b.addPath(lVar.getPath());
            }
        }
        l lVar2 = this.f41248e.get(0);
        if (lVar2 instanceof c) {
            c cVar2 = (c) lVar2;
            List<l> i2 = cVar2.i();
            for (int i3 = 0; i3 < i2.size(); i3++) {
                Path path2 = i2.get(i3).getPath();
                path2.transform(cVar2.j());
                this.f41244a.addPath(path2);
            }
        } else {
            this.f41244a.set(lVar2.getPath());
        }
        this.f41246c.op(this.f41244a, this.f41245b, op);
    }

    @Override // d.a.a.q.a.i
    public void f(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof l) {
                this.f41248e.add((l) previous);
                listIterator.remove();
            }
        }
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.f41247d;
    }

    @Override // d.a.a.q.a.l
    public Path getPath() {
        this.f41246c.reset();
        int i = a.f41250a[this.f41249f.b().ordinal()];
        if (i == 1) {
            a();
        } else if (i == 2) {
            d(Path.Op.UNION);
        } else if (i == 3) {
            d(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            d(Path.Op.INTERSECT);
        } else if (i == 5) {
            d(Path.Op.XOR);
        }
        return this.f41246c;
    }
}
