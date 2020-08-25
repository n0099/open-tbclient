package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes20.dex */
public final class FileAlreadyExistsException extends FileSystemException {
    public /* synthetic */ FileAlreadyExistsException(File file, File file2, String str, int i, o oVar) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileAlreadyExistsException(File file, File file2, String str) {
        super(file, file2, str);
        q.m(file, "file");
    }
}
