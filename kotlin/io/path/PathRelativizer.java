package kotlin.io.path;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/io/path/PathRelativizer;", "", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", "path", SchemeCollecter.CLASSIFY_BASE, "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PathRelativizer {
    public static final PathRelativizer INSTANCE = new PathRelativizer();
    public static final Path emptyPath = Paths.get("", new String[0]);
    public static final Path parentPath = Paths.get(IStringUtil.TOP_PATH, new String[0]);

    public final Path tryRelativeTo(Path path, Path base) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(base, "base");
        Path normalize = base.normalize();
        Path r = path.normalize();
        Path relativize = normalize.relativize(r);
        int min = Math.min(normalize.getNameCount(), r.getNameCount());
        int i = 0;
        while (i < min) {
            int i2 = i + 1;
            if (!Intrinsics.areEqual(normalize.getName(i), parentPath)) {
                break;
            } else if (Intrinsics.areEqual(r.getName(i), parentPath)) {
                i = i2;
            } else {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (Intrinsics.areEqual(r, normalize) || !Intrinsics.areEqual(normalize, emptyPath)) {
            String obj = relativize.toString();
            String separator = relativize.getFileSystem().getSeparator();
            Intrinsics.checkNotNullExpressionValue(separator, "rn.fileSystem.separator");
            if (StringsKt__StringsJVMKt.endsWith$default(obj, separator, false, 2, null)) {
                r = relativize.getFileSystem().getPath(StringsKt___StringsKt.dropLast(obj, relativize.getFileSystem().getSeparator().length()), new String[0]);
            } else {
                r = relativize;
            }
        }
        Intrinsics.checkNotNullExpressionValue(r, "r");
        return r;
    }
}
