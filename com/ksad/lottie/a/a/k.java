package com.ksad.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.ksad.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes3.dex */
public class k implements i, l {
    private final String d;
    private final MergePaths f;

    /* renamed from: a  reason: collision with root package name */
    private final Path f5314a = new Path();
    private final Path b = new Path();
    private final Path c = new Path();
    private final List<l> e = new ArrayList();

    public k(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.d = mergePaths.a();
        this.f = mergePaths;
    }

    private void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.size()) {
                return;
            }
            this.c.addPath(this.e.get(i2).d());
            i = i2 + 1;
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.b.reset();
        this.f5314a.reset();
        int size = this.e.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            l lVar = this.e.get(i);
            if (lVar instanceof c) {
                List<l> b = ((c) lVar).b();
                for (int size2 = b.size() - 1; size2 >= 0; size2--) {
                    Path d = b.get(size2).d();
                    d.transform(((c) lVar).c());
                    this.b.addPath(d);
                }
            } else {
                this.b.addPath(lVar.d());
            }
            size = i - 1;
        }
        l lVar2 = this.e.get(0);
        if (lVar2 instanceof c) {
            List<l> b2 = ((c) lVar2).b();
            for (int i2 = 0; i2 < b2.size(); i2++) {
                Path d2 = b2.get(i2).d();
                d2.transform(((c) lVar2).c());
                this.f5314a.addPath(d2);
            }
        } else {
            this.f5314a.set(lVar2.d());
        }
        this.c.op(this.f5314a, this.b, op);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.size()) {
                return;
            }
            this.e.get(i2).a(list, list2);
            i = i2 + 1;
        }
    }

    @Override // com.ksad.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof l) {
                this.e.add((l) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        this.c.reset();
        switch (this.f.b()) {
            case Merge:
                a();
                break;
            case Add:
                a(Path.Op.UNION);
                break;
            case Subtract:
                a(Path.Op.REVERSE_DIFFERENCE);
                break;
            case Intersect:
                a(Path.Op.INTERSECT);
                break;
            case ExcludeIntersections:
                a(Path.Op.XOR);
                break;
        }
        return this.c;
    }
}
