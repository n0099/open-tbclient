package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;
/* loaded from: classes2.dex */
final class FilesKt__UtilsKt$copyRecursively$2 extends Lambda implements kotlin.jvm.a.c<File, IOException, kotlin.e> {
    final /* synthetic */ kotlin.jvm.a.c $onError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FilesKt__UtilsKt$copyRecursively$2(kotlin.jvm.a.c cVar) {
        super(2);
        this.$onError = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.c
    public /* bridge */ /* synthetic */ kotlin.e invoke(File file, IOException iOException) {
        invoke2(file, iOException);
        return kotlin.e.kst;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(File file, IOException iOException) {
        p.k(file, "f");
        p.k(iOException, "e");
        if (p.h((OnErrorAction) this.$onError.invoke(file, iOException), OnErrorAction.TERMINATE)) {
            throw new TerminateException(file);
        }
    }
}
