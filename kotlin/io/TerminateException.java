package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes14.dex */
final class TerminateException extends FileSystemException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TerminateException(File file) {
        super(file, null, null, 6, null);
        p.p(file, "file");
    }
}
