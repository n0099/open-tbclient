package d.a.a.s.b;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes.dex */
public class l implements m, j {

    /* renamed from: d  reason: collision with root package name */
    public final String f41552d;

    /* renamed from: f  reason: collision with root package name */
    public final MergePaths f41554f;

    /* renamed from: a  reason: collision with root package name */
    public final Path f41549a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final Path f41550b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public final Path f41551c = new Path();

    /* renamed from: e  reason: collision with root package name */
    public final List<m> f41553e = new ArrayList();

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41555a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f41555a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41555a[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41555a[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41555a[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41555a[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f41552d = mergePaths.c();
            this.f41554f = mergePaths;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    public final void a() {
        for (int i = 0; i < this.f41553e.size(); i++) {
            this.f41551c.addPath(this.f41553e.get(i).getPath());
        }
    }

    @Override // d.a.a.s.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < this.f41553e.size(); i++) {
            this.f41553e.get(i).b(list, list2);
        }
    }

    @TargetApi(19)
    public final void c(Path.Op op) {
        this.f41550b.reset();
        this.f41549a.reset();
        for (int size = this.f41553e.size() - 1; size >= 1; size--) {
            m mVar = this.f41553e.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List<m> i = dVar.i();
                for (int size2 = i.size() - 1; size2 >= 0; size2--) {
                    Path path = i.get(size2).getPath();
                    path.transform(dVar.j());
                    this.f41550b.addPath(path);
                }
            } else {
                this.f41550b.addPath(mVar.getPath());
            }
        }
        m mVar2 = this.f41553e.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List<m> i2 = dVar2.i();
            for (int i3 = 0; i3 < i2.size(); i3++) {
                Path path2 = i2.get(i3).getPath();
                path2.transform(dVar2.j());
                this.f41549a.addPath(path2);
            }
        } else {
            this.f41549a.set(mVar2.getPath());
        }
        this.f41551c.op(this.f41549a, this.f41550b, op);
    }

    @Override // d.a.a.s.b.j
    public void f(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c previous = listIterator.previous();
            if (previous instanceof m) {
                this.f41553e.add((m) previous);
                listIterator.remove();
            }
        }
    }

    @Override // d.a.a.s.b.c
    public String getName() {
        return this.f41552d;
    }

    @Override // d.a.a.s.b.m
    public Path getPath() {
        this.f41551c.reset();
        if (this.f41554f.d()) {
            return this.f41551c;
        }
        int i = a.f41555a[this.f41554f.b().ordinal()];
        if (i == 1) {
            a();
        } else if (i == 2) {
            c(Path.Op.UNION);
        } else if (i == 3) {
            c(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            c(Path.Op.INTERSECT);
        } else if (i == 5) {
            c(Path.Op.XOR);
        }
        return this.f41551c;
    }
}
