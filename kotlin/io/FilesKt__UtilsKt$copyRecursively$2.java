package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import kotlin.l;
@kotlin.h
/* loaded from: classes7.dex */
final class FilesKt__UtilsKt$copyRecursively$2 extends Lambda implements m<File, IOException, l> {
    final /* synthetic */ m $onError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FilesKt__UtilsKt$copyRecursively$2(m mVar) {
        super(2);
        this.$onError = mVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.m
    public /* bridge */ /* synthetic */ l invoke(File file, IOException iOException) {
        invoke2(file, iOException);
        return l.nto;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(File file, IOException iOException) {
        q.m(file, "f");
        q.m(iOException, "e");
        if (((OnErrorAction) this.$onError.invoke(file, iOException)) == OnErrorAction.TERMINATE) {
            throw new TerminateException(file);
        }
    }
}
