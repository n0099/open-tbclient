package com.ksad.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.ksad.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes6.dex */
public class k implements i, l {

    /* renamed from: d  reason: collision with root package name */
    public final String f31768d;

    /* renamed from: f  reason: collision with root package name */
    public final MergePaths f31770f;

    /* renamed from: a  reason: collision with root package name */
    public final Path f31765a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final Path f31766b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public final Path f31767c = new Path();

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f31769e = new ArrayList();

    /* renamed from: com.ksad.lottie.a.a.k$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31771a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f31771a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.Merge.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31771a[MergePaths.MergePathsMode.Add.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31771a[MergePaths.MergePathsMode.Subtract.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31771a[MergePaths.MergePathsMode.Intersect.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31771a[MergePaths.MergePathsMode.ExcludeIntersections.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public k(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.f31768d = mergePaths.a();
        this.f31770f = mergePaths;
    }

    private void a() {
        for (int i2 = 0; i2 < this.f31769e.size(); i2++) {
            this.f31767c.addPath(this.f31769e.get(i2).d());
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.f31766b.reset();
        this.f31765a.reset();
        for (int size = this.f31769e.size() - 1; size >= 1; size--) {
            l lVar = this.f31769e.get(size);
            if (lVar instanceof c) {
                c cVar = (c) lVar;
                List<l> b2 = cVar.b();
                for (int size2 = b2.size() - 1; size2 >= 0; size2--) {
                    Path d2 = b2.get(size2).d();
                    d2.transform(cVar.c());
                    this.f31766b.addPath(d2);
                }
            } else {
                this.f31766b.addPath(lVar.d());
            }
        }
        l lVar2 = this.f31769e.get(0);
        if (lVar2 instanceof c) {
            c cVar2 = (c) lVar2;
            List<l> b3 = cVar2.b();
            for (int i2 = 0; i2 < b3.size(); i2++) {
                Path d3 = b3.get(i2).d();
                d3.transform(cVar2.c());
                this.f31765a.addPath(d3);
            }
        } else {
            this.f31765a.set(lVar2.d());
        }
        this.f31767c.op(this.f31765a, this.f31766b, op);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < this.f31769e.size(); i2++) {
            this.f31769e.get(i2).a(list, list2);
        }
    }

    @Override // com.ksad.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof l) {
                this.f31769e.add((l) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        Path.Op op;
        this.f31767c.reset();
        int i2 = AnonymousClass1.f31771a[this.f31770f.b().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                op = Path.Op.UNION;
            } else if (i2 == 3) {
                op = Path.Op.REVERSE_DIFFERENCE;
            } else if (i2 == 4) {
                op = Path.Op.INTERSECT;
            } else if (i2 == 5) {
                op = Path.Op.XOR;
            }
            a(op);
        } else {
            a();
        }
        return this.f31767c;
    }
}
