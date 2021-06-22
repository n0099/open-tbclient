package kotlin.io;

import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0080\b\u0018\u0000B\u001f\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u0003R\u0013\u0010\u001f\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0019R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\u0006R\u0013\u0010#\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010\u0012¨\u0006&"}, d2 = {"Lkotlin/io/FilePathComponents;", "Ljava/io/File;", "component1", "()Ljava/io/File;", "", "component2", "()Ljava/util/List;", PrefetchEvent.EVENT_DATA_ROOT_PATH, "segments", "copy", "(Ljava/io/File;Ljava/util/List;)Lkotlin/io/FilePathComponents;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "beginIndex", "endIndex", "subPath", "(II)Ljava/io/File;", "", "toString", "()Ljava/lang/String;", "isRooted", "()Z", "Ljava/io/File;", "getRoot", "getRootName", "rootName", "Ljava/util/List;", "getSegments", "getSize", "size", "<init>", "(Ljava/io/File;Ljava/util/List;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class FilePathComponents {
    public final File root;
    public final List<File> segments;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends java.io.File> */
    /* JADX WARN: Multi-variable type inference failed */
    public FilePathComponents(File root, List<? extends File> segments) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(segments, "segments");
        this.root = root;
        this.segments = segments;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlin.io.FilePathComponents */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilePathComponents copy$default(FilePathComponents filePathComponents, File file, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            file = filePathComponents.root;
        }
        if ((i2 & 2) != 0) {
            list = filePathComponents.segments;
        }
        return filePathComponents.copy(file, list);
    }

    public final File component1() {
        return this.root;
    }

    public final List<File> component2() {
        return this.segments;
    }

    public final FilePathComponents copy(File root, List<? extends File> segments) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(segments, "segments");
        return new FilePathComponents(root, segments);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FilePathComponents) {
                FilePathComponents filePathComponents = (FilePathComponents) obj;
                return Intrinsics.areEqual(this.root, filePathComponents.root) && Intrinsics.areEqual(this.segments, filePathComponents.segments);
            }
            return false;
        }
        return true;
    }

    public final File getRoot() {
        return this.root;
    }

    public final String getRootName() {
        String path = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "root.path");
        return path;
    }

    public final List<File> getSegments() {
        return this.segments;
    }

    public final int getSize() {
        return this.segments.size();
    }

    public int hashCode() {
        File file = this.root;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        List<File> list = this.segments;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public final boolean isRooted() {
        String path = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "root.path");
        return path.length() > 0;
    }

    public final File subPath(int i2, int i3) {
        if (i2 >= 0 && i2 <= i3 && i3 <= getSize()) {
            List<File> subList = this.segments.subList(i2, i3);
            String str = File.separator;
            Intrinsics.checkNotNullExpressionValue(str, "File.separator");
            return new File(CollectionsKt___CollectionsKt.joinToString$default(subList, str, null, null, 0, null, null, 62, null));
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        return "FilePathComponents(root=" + this.root + ", segments=" + this.segments + SmallTailInfo.EMOTION_SUFFIX;
    }
}
