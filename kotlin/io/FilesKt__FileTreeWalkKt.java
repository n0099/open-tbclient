package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Ljava/io/File;", "Lkotlin/io/FileWalkDirection;", "direction", "Lkotlin/io/FileTreeWalk;", "walk", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)Lkotlin/io/FileTreeWalk;", "walkBottomUp", "(Ljava/io/File;)Lkotlin/io/FileTreeWalk;", "walkTopDown", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/io/FilesKt")
/* loaded from: classes7.dex */
public class FilesKt__FileTreeWalkKt extends FilesKt__FileReadWriteKt {
    public static final FileTreeWalk walk(File walk, FileWalkDirection direction) {
        Intrinsics.checkNotNullParameter(walk, "$this$walk");
        Intrinsics.checkNotNullParameter(direction, "direction");
        return new FileTreeWalk(walk, direction);
    }

    public static /* synthetic */ FileTreeWalk walk$default(File file, FileWalkDirection fileWalkDirection, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        return walk(file, fileWalkDirection);
    }

    public static final FileTreeWalk walkBottomUp(File walkBottomUp) {
        Intrinsics.checkNotNullParameter(walkBottomUp, "$this$walkBottomUp");
        return walk(walkBottomUp, FileWalkDirection.BOTTOM_UP);
    }

    public static final FileTreeWalk walkTopDown(File walkTopDown) {
        Intrinsics.checkNotNullParameter(walkTopDown, "$this$walkTopDown");
        return walk(walkTopDown, FileWalkDirection.TOP_DOWN);
    }
}
