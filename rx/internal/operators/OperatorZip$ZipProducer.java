package rx.internal.operators;

import com.baidu.tieba.g7c;
import com.baidu.tieba.j6c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorZip$ZipProducer<R> extends AtomicLong implements j6c {
    public static final long serialVersionUID = -1216676403723546796L;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        this.zipper = operatorZip$Zip;
    }

    @Override // com.baidu.tieba.j6c
    public void request(long j) {
        g7c.b(this, j);
        this.zipper.tick();
    }
}
