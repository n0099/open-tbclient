package com.tb.airbnb.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.tb.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* loaded from: classes6.dex */
public class k implements i, l {
    private final String name;
    private final MergePaths niG;
    private final Path BL = new Path();
    private final Path BM = new Path();
    private final Path path = new Path();
    private final List<l> Bw = new ArrayList();

    public k(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.niG = mergePaths;
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof l) {
                this.Bw.add((l) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.Bw.size()) {
                this.Bw.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path hd() {
        this.path.reset();
        switch (this.niG.dJd()) {
            case Merge:
                hh();
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

    private void hh() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.Bw.size()) {
                this.path.addPath(this.Bw.get(i2).hd());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.BM.reset();
        this.BL.reset();
        int size = this.Bw.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            l lVar = this.Bw.get(i);
            if (lVar instanceof c) {
                List<l> hb = ((c) lVar).hb();
                for (int size2 = hb.size() - 1; size2 >= 0; size2--) {
                    Path hd = hb.get(size2).hd();
                    hd.transform(((c) lVar).hc());
                    this.BM.addPath(hd);
                }
            } else {
                this.BM.addPath(lVar.hd());
            }
            size = i - 1;
        }
        l lVar2 = this.Bw.get(0);
        if (lVar2 instanceof c) {
            List<l> hb2 = ((c) lVar2).hb();
            for (int i2 = 0; i2 < hb2.size(); i2++) {
                Path hd2 = hb2.get(i2).hd();
                hd2.transform(((c) lVar2).hc());
                this.BL.addPath(hd2);
            }
        } else {
            this.BL.set(lVar2.hd());
        }
        this.path.op(this.BL, this.BM, op);
    }
}
