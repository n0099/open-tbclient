package com.tb.airbnb.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.tb.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes5.dex */
public class k implements i, l {
    private final MergePaths nOq;
    private final String name;
    private final Path Cn = new Path();
    private final Path Co = new Path();
    private final Path path = new Path();
    private final List<l> BY = new ArrayList();

    public k(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.nOq = mergePaths;
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof l) {
                this.BY.add((l) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.BY.size()) {
                this.BY.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path ht() {
        this.path.reset();
        switch (this.nOq.dRx()) {
            case Merge:
                hx();
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
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    private void hx() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.BY.size()) {
                this.path.addPath(this.BY.get(i2).ht());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.Co.reset();
        this.Cn.reset();
        int size = this.BY.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            l lVar = this.BY.get(i);
            if (lVar instanceof c) {
                List<l> hr = ((c) lVar).hr();
                for (int size2 = hr.size() - 1; size2 >= 0; size2--) {
                    Path ht = hr.get(size2).ht();
                    ht.transform(((c) lVar).hs());
                    this.Co.addPath(ht);
                }
            } else {
                this.Co.addPath(lVar.ht());
            }
            size = i - 1;
        }
        l lVar2 = this.BY.get(0);
        if (lVar2 instanceof c) {
            List<l> hr2 = ((c) lVar2).hr();
            for (int i2 = 0; i2 < hr2.size(); i2++) {
                Path ht2 = hr2.get(i2).ht();
                ht2.transform(((c) lVar2).hs());
                this.Cn.addPath(ht2);
            }
        } else {
            this.Cn.set(lVar2.ht());
        }
        this.path.op(this.Cn, this.Co, op);
    }
}
