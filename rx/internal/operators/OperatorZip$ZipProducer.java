package rx.internal.operators;

import com.baidu.tieba.a2b;
import com.baidu.tieba.h1b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OperatorZip$ZipProducer<R> extends AtomicLong implements h1b {
    public static final long serialVersionUID = -1216676403723546796L;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        this.zipper = operatorZip$Zip;
    }

    @Override // com.baidu.tieba.h1b
    public void request(long j) {
        a2b.b(this, j);
        this.zipper.tick();
    }
}
