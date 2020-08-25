package com.tb.airbnb.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.tb.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes7.dex */
public class k implements i, l {
    private final String name;
    private final MergePaths oim;
    private final Path CX = new Path();
    private final Path CY = new Path();
    private final Path path = new Path();
    private final List<l> CD = new ArrayList();

    public k(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.oim = mergePaths;
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
    public Path iU() {
        this.path.reset();
        switch (this.oim.edA()) {
            case Merge:
                iY();
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

    private void iY() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.CD.size()) {
                this.path.addPath(this.CD.get(i2).iU());
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
                List<l> iS = ((c) lVar).iS();
                for (int size2 = iS.size() - 1; size2 >= 0; size2--) {
                    Path iU = iS.get(size2).iU();
                    iU.transform(((c) lVar).iT());
                    this.CY.addPath(iU);
                }
            } else {
                this.CY.addPath(lVar.iU());
            }
            size = i - 1;
        }
        l lVar2 = this.CD.get(0);
        if (lVar2 instanceof c) {
            List<l> iS2 = ((c) lVar2).iS();
            for (int i2 = 0; i2 < iS2.size(); i2++) {
                Path iU2 = iS2.get(i2).iU();
                iU2.transform(((c) lVar2).iT());
                this.CX.addPath(iU2);
            }
        } else {
            this.CX.set(lVar2.iU());
        }
        this.path.op(this.CX, this.CY, op);
    }
}
