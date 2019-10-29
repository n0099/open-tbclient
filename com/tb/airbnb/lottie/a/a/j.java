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
public class j implements i, k {
    private final MergePaths ktf;
    private final String name;
    private final Path eS = new Path();
    private final Path eT = new Path();
    private final Path path = new Path();
    private final List<k> eD = new ArrayList();

    public j(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.name = mergePaths.getName();
        this.ktf = mergePaths;
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b previous = listIterator.previous();
            if (previous instanceof k) {
                this.eD.add((k) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eD.size()) {
                this.eD.get(i2).b(list, list2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.k
    public Path bw() {
        this.path.reset();
        switch (this.ktf.cLQ()) {
            case Merge:
                bA();
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

    private void bA() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.eD.size()) {
                this.path.addPath(this.eD.get(i2).bw());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.eT.reset();
        this.eS.reset();
        int size = this.eD.size() - 1;
        while (true) {
            int i = size;
            if (i < 1) {
                break;
            }
            k kVar = this.eD.get(i);
            if (kVar instanceof c) {
                List<k> bu = ((c) kVar).bu();
                for (int size2 = bu.size() - 1; size2 >= 0; size2--) {
                    Path bw = bu.get(size2).bw();
                    bw.transform(((c) kVar).bv());
                    this.eT.addPath(bw);
                }
            } else {
                this.eT.addPath(kVar.bw());
            }
            size = i - 1;
        }
        k kVar2 = this.eD.get(0);
        if (kVar2 instanceof c) {
            List<k> bu2 = ((c) kVar2).bu();
            for (int i2 = 0; i2 < bu2.size(); i2++) {
                Path bw2 = bu2.get(i2).bw();
                bw2.transform(((c) kVar2).bv());
                this.eS.addPath(bw2);
            }
        } else {
            this.eS.set(kVar2.bw());
        }
        this.path.op(this.eS, this.eT, op);
    }
}
