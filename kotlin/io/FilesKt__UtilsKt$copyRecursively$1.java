package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
final class FilesKt__UtilsKt$copyRecursively$1 extends Lambda implements m {
    public static final FilesKt__UtilsKt$copyRecursively$1 INSTANCE = new FilesKt__UtilsKt$copyRecursively$1();

    FilesKt__UtilsKt$copyRecursively$1() {
        super(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.m
    public final Void invoke(File file, IOException iOException) {
        q.j(file, "<anonymous parameter 0>");
        q.j(iOException, com.baidu.fsg.base.statistics.b.k);
        throw iOException;
    }
}
