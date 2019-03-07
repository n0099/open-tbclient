package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
public class FileSystemException extends IOException {
    private final File file;
    private final File other;
    private final String reason;

    public final File getFile() {
        return this.file;
    }

    public /* synthetic */ FileSystemException(File file, File file2, String str, int i, o oVar) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    public final File getOther() {
        return this.other;
    }

    public final String getReason() {
        return this.reason;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FileSystemException(File file, File file2, String str) {
        super(r0);
        String b;
        p.k(file, "file");
        b = b.b(file, file2, str);
        this.file = file;
        this.other = file2;
        this.reason = str;
    }
}
