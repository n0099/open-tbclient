package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes9.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String sb2 = sb.toString();
        q.m(sb2, "sb.toString()");
        return sb2;
    }
}
