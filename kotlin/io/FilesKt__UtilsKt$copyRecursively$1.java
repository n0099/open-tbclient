package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes17.dex */
final class FilesKt__UtilsKt$copyRecursively$1 extends Lambda implements kotlin.jvm.a.c {
    public static final FilesKt__UtilsKt$copyRecursively$1 INSTANCE = new FilesKt__UtilsKt$copyRecursively$1();

    FilesKt__UtilsKt$copyRecursively$1() {
        super(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.c
    public final Void invoke(File file, IOException iOException) {
        p.o(file, "<anonymous parameter 0>");
        p.o(iOException, "exception");
        throw iOException;
    }
}
