package com.tb.airbnb.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.tb.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes17.dex */
public class k implements i, l {
    private final String name;
    private final MergePaths oso;
    private final Path CX = new Path();
    private final Path CY = new Path();
    private final Path path = new Path();
    private final List<l> CD = new ArrayList();

    public k(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.oso = mergePaths;
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof l) {
                this.CD.add((l) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.CD.size()) {
                this.CD.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path iV() {
        this.path.reset();
        switch (this.oso.ehG()) {
            case Merge:
                iZ();
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

    private void iZ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.CD.size()) {
                this.path.addPath(this.CD.get(i2).iV());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.CY.reset();
        this.CX.reset();
        int size = this.CD.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            l lVar = this.CD.get(i);
            if (lVar instanceof c) {
                List<l> iT = ((c) lVar).iT();
                for (int size2 = iT.size() - 1; size2 >= 0; size2--) {
                    Path iV = iT.get(size2).iV();
                    iV.transform(((c) lVar).iU());
                    this.CY.addPath(iV);
                }
            } else {
                this.CY.addPath(lVar.iV());
            }
            size = i - 1;
        }
        l lVar2 = this.CD.get(0);
        if (lVar2 instanceof c) {
            List<l> iT2 = ((c) lVar2).iT();
            for (int i2 = 0; i2 < iT2.size(); i2++) {
                Path iV2 = iT2.get(i2).iV();
                iV2.transform(((c) lVar2).iU());
                this.CX.addPath(iV2);
            }
        } else {
            this.CX.set(lVar2.iV());
        }
        this.path.op(this.CX, this.CY, op);
    }
}
