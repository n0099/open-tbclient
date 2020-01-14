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
    private final String name;
    private final MergePaths npn;
    private final Path gg = new Path();
    private final Path gh = new Path();
    private final Path path = new Path();
    private final List<l> fQ = new ArrayList();

    public k(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.npn = mergePaths;
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof l) {
                this.fQ.add((l) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fQ.size()) {
                this.fQ.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path bF() {
        this.path.reset();
        switch (this.npn.dGb()) {
            case Merge:
                bJ();
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

    private void bJ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.fQ.size()) {
                this.path.addPath(this.fQ.get(i2).bF());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.gh.reset();
        this.gg.reset();
        int size = this.fQ.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            l lVar = this.fQ.get(i);
            if (lVar instanceof c) {
                List<l> bD = ((c) lVar).bD();
                for (int size2 = bD.size() - 1; size2 >= 0; size2--) {
                    Path bF = bD.get(size2).bF();
                    bF.transform(((c) lVar).bE());
                    this.gh.addPath(bF);
                }
            } else {
                this.gh.addPath(lVar.bF());
            }
            size = i - 1;
        }
        l lVar2 = this.fQ.get(0);
        if (lVar2 instanceof c) {
            List<l> bD2 = ((c) lVar2).bD();
            for (int i2 = 0; i2 < bD2.size(); i2++) {
                Path bF2 = bD2.get(i2).bF();
                bF2.transform(((c) lVar2).bE());
                this.gg.addPath(bF2);
            }
        } else {
            this.gg.set(lVar2.bF());
        }
        this.path.op(this.gg, this.gh, op);
    }
}
