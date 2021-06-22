package kotlin.io;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u001a/\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u001a/\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\u0006\u001a?\u0010\u000f\u001a\u00020\t*\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\t2\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000f\u0010\u0010\u001a-\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0011\u0010\u0015\u001a\u00020\t*\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0018\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0019\u0010\u0018\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u001a\u001a\u0011\u0010\u001b\u001a\u00020\u0003*\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d*\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0013\u0010\u001b\u001a\u00020 *\u00020 H\u0002¢\u0006\u0004\b\u001e\u0010!\u001a\u0019\u0010#\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003¢\u0006\u0004\b#\u0010$\u001a\u001b\u0010%\u001a\u0004\u0018\u00010\u0003*\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003¢\u0006\u0004\b%\u0010$\u001a\u0019\u0010&\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003¢\u0006\u0004\b&\u0010$\u001a\u0019\u0010(\u001a\u00020\u0003*\u00020\u00032\u0006\u0010'\u001a\u00020\u0003¢\u0006\u0004\b(\u0010$\u001a\u0019\u0010(\u001a\u00020\u0003*\u00020\u00032\u0006\u0010'\u001a\u00020\u0000¢\u0006\u0004\b(\u0010)\u001a\u0019\u0010*\u001a\u00020\u0003*\u00020\u00032\u0006\u0010'\u001a\u00020\u0003¢\u0006\u0004\b*\u0010$\u001a\u0019\u0010*\u001a\u00020\u0003*\u00020\u00032\u0006\u0010'\u001a\u00020\u0000¢\u0006\u0004\b*\u0010)\u001a\u0019\u0010+\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b+\u0010\u0019\u001a\u0019\u0010+\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b+\u0010\u001a\u001a\u0019\u0010,\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003¢\u0006\u0004\b,\u0010-\u001a\u001d\u0010/\u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0002¢\u0006\u0004\b.\u0010-\"\u0017\u00102\u001a\u00020\u0000*\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b0\u00101\"\u0017\u00104\u001a\u00020\u0000*\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b3\u00101\"\u0017\u00106\u001a\u00020\u0000*\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b5\u00101¨\u00067"}, d2 = {"", "prefix", "suffix", "Ljava/io/File;", "directory", "createTempDir", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;", "createTempFile", "target", "", "overwrite", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "onError", "copyRecursively", "(Ljava/io/File;Ljava/io/File;ZLkotlin/Function2;)Z", "", "bufferSize", "copyTo", "(Ljava/io/File;Ljava/io/File;ZI)Ljava/io/File;", "deleteRecursively", "(Ljava/io/File;)Z", "other", "endsWith", "(Ljava/io/File;Ljava/io/File;)Z", "(Ljava/io/File;Ljava/lang/String;)Z", "normalize", "(Ljava/io/File;)Ljava/io/File;", "", "normalize$FilesKt__UtilsKt", "(Ljava/util/List;)Ljava/util/List;", "Lkotlin/io/FilePathComponents;", "(Lkotlin/io/FilePathComponents;)Lkotlin/io/FilePathComponents;", SchemeCollecter.CLASSIFY_BASE, "relativeTo", "(Ljava/io/File;Ljava/io/File;)Ljava/io/File;", "relativeToOrNull", "relativeToOrSelf", "relative", "resolve", "(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;", "resolveSibling", "startsWith", "toRelativeString", "(Ljava/io/File;Ljava/io/File;)Ljava/lang/String;", "toRelativeStringOrNull$FilesKt__UtilsKt", "toRelativeStringOrNull", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", ETAG.KEY_EXTENSION, "getInvariantSeparatorsPath", "invariantSeparatorsPath", "getNameWithoutExtension", "nameWithoutExtension", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/io/FilesKt")
/* loaded from: classes8.dex */
public class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean copyRecursively(File copyRecursively, File target, boolean z, Function2<? super File, ? super IOException, ? extends OnErrorAction> onError) {
        boolean z2;
        Intrinsics.checkNotNullParameter(copyRecursively, "$this$copyRecursively");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (!copyRecursively.exists()) {
            return onError.invoke(copyRecursively, new NoSuchFileException(copyRecursively, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE;
        }
        try {
            Iterator<File> it = FilesKt__FileTreeWalkKt.walkTopDown(copyRecursively).onFail(new FilesKt__UtilsKt$copyRecursively$2(onError)).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (!next.exists()) {
                    if (onError.invoke(next, new NoSuchFileException(next, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) {
                        return false;
                    }
                } else {
                    File file = new File(target, toRelativeString(next, copyRecursively));
                    if (file.exists() && (!next.isDirectory() || !file.isDirectory())) {
                        if (z) {
                            if (file.isDirectory()) {
                                if (!deleteRecursively(file)) {
                                }
                                z2 = false;
                            } else {
                                if (!file.delete()) {
                                }
                                z2 = false;
                            }
                            if (!z2) {
                                if (onError.invoke(file, new FileAlreadyExistsException(next, file, "The destination file already exists.")) == OnErrorAction.TERMINATE) {
                                    return false;
                                }
                            }
                        }
                        z2 = true;
                        if (!z2) {
                        }
                    }
                    if (next.isDirectory()) {
                        file.mkdirs();
                    } else if (copyTo$default(next, file, z, 0, 4, null).length() != next.length() && onError.invoke(next, new IOException("Source file wasn't copied completely, length of destination file differs.")) == OnErrorAction.TERMINATE) {
                        return false;
                    }
                }
            }
            return true;
        } catch (TerminateException unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean copyRecursively$default(File file, File file2, boolean z, Function2 function2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            function2 = FilesKt__UtilsKt$copyRecursively$1.INSTANCE;
        }
        return copyRecursively(file, file2, z, function2);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static final File copyTo(File copyTo, File target, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(target, "target");
        if (copyTo.exists()) {
            if (target.exists()) {
                if (z) {
                    if (!target.delete()) {
                        throw new FileAlreadyExistsException(copyTo, target, "Tried to overwrite the destination, but failed to delete it.");
                    }
                } else {
                    throw new FileAlreadyExistsException(copyTo, target, "The destination file already exists.");
                }
            }
            if (copyTo.isDirectory()) {
                if (!target.mkdirs()) {
                    throw new FileSystemException(copyTo, target, "Failed to create target directory.");
                }
            } else {
                File parentFile = target.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileInputStream fileInputStream = new FileInputStream(copyTo);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(target);
                    ByteStreamsKt.copyTo(fileInputStream, fileOutputStream, i2);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                } finally {
                }
            }
            return target;
        }
        throw new NoSuchFileException(copyTo, null, "The source file doesn't exist.", 2, null);
    }

    public static /* synthetic */ File copyTo$default(File file, File file2, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 8192;
        }
        return copyTo(file, file2, z, i2);
    }

    public static final File createTempDir(String prefix, String str, File file) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        File dir = File.createTempFile(prefix, str, file);
        dir.delete();
        if (dir.mkdir()) {
            Intrinsics.checkNotNullExpressionValue(dir, "dir");
            return dir;
        }
        throw new IOException("Unable to create temporary directory " + dir + IStringUtil.EXTENSION_SEPARATOR);
    }

    public static /* synthetic */ File createTempDir$default(String str, String str2, File file, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "tmp";
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            file = null;
        }
        return createTempDir(str, str2, file);
    }

    public static final File createTempFile(String prefix, String str, File file) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        File createTempFile = File.createTempFile(prefix, str, file);
        Intrinsics.checkNotNullExpressionValue(createTempFile, "File.createTempFile(prefix, suffix, directory)");
        return createTempFile;
    }

    public static /* synthetic */ File createTempFile$default(String str, String str2, File file, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "tmp";
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            file = null;
        }
        return createTempFile(str, str2, file);
    }

    public static final boolean deleteRecursively(File deleteRecursively) {
        Intrinsics.checkNotNullParameter(deleteRecursively, "$this$deleteRecursively");
        while (true) {
            boolean z = true;
            for (File file : FilesKt__FileTreeWalkKt.walkBottomUp(deleteRecursively)) {
                if (file.delete() || !file.exists()) {
                    if (z) {
                        break;
                    }
                }
                z = false;
            }
            return z;
        }
    }

    public static final boolean endsWith(File endsWith, File other) {
        Intrinsics.checkNotNullParameter(endsWith, "$this$endsWith");
        Intrinsics.checkNotNullParameter(other, "other");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(endsWith);
        FilePathComponents components2 = FilesKt__FilePathComponentsKt.toComponents(other);
        if (components2.isRooted()) {
            return Intrinsics.areEqual(endsWith, other);
        }
        int size = components.getSize() - components2.getSize();
        if (size < 0) {
            return false;
        }
        return components.getSegments().subList(size, components.getSize()).equals(components2.getSegments());
    }

    public static final String getExtension(File extension) {
        Intrinsics.checkNotNullParameter(extension, "$this$extension");
        String name = extension.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return StringsKt__StringsKt.substringAfterLast(name, (char) IStringUtil.EXTENSION_SEPARATOR, "");
    }

    public static final String getInvariantSeparatorsPath(File invariantSeparatorsPath) {
        Intrinsics.checkNotNullParameter(invariantSeparatorsPath, "$this$invariantSeparatorsPath");
        if (File.separatorChar != '/') {
            String path = invariantSeparatorsPath.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "path");
            return StringsKt__StringsJVMKt.replace$default(path, File.separatorChar, '/', false, 4, (Object) null);
        }
        String path2 = invariantSeparatorsPath.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "path");
        return path2;
    }

    public static final String getNameWithoutExtension(File nameWithoutExtension) {
        Intrinsics.checkNotNullParameter(nameWithoutExtension, "$this$nameWithoutExtension");
        String name = nameWithoutExtension.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return StringsKt__StringsKt.substringBeforeLast$default(name, ".", (String) null, 2, (Object) null);
    }

    public static final File normalize(File normalize) {
        Intrinsics.checkNotNullParameter(normalize, "$this$normalize");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(normalize);
        File root = components.getRoot();
        List<File> normalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(components.getSegments());
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "File.separator");
        return resolve(root, CollectionsKt___CollectionsKt.joinToString$default(normalize$FilesKt__UtilsKt, str, null, null, 0, null, null, 62, null));
    }

    public static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents filePathComponents) {
        return new FilePathComponents(filePathComponents.getRoot(), normalize$FilesKt__UtilsKt(filePathComponents.getSegments()));
    }

    public static final File relativeTo(File relativeTo, File base) {
        Intrinsics.checkNotNullParameter(relativeTo, "$this$relativeTo");
        Intrinsics.checkNotNullParameter(base, "base");
        return new File(toRelativeString(relativeTo, base));
    }

    public static final File relativeToOrNull(File relativeToOrNull, File base) {
        Intrinsics.checkNotNullParameter(relativeToOrNull, "$this$relativeToOrNull");
        Intrinsics.checkNotNullParameter(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(relativeToOrNull, base);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return new File(relativeStringOrNull$FilesKt__UtilsKt);
        }
        return null;
    }

    public static final File relativeToOrSelf(File relativeToOrSelf, File base) {
        Intrinsics.checkNotNullParameter(relativeToOrSelf, "$this$relativeToOrSelf");
        Intrinsics.checkNotNullParameter(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(relativeToOrSelf, base);
        return relativeStringOrNull$FilesKt__UtilsKt != null ? new File(relativeStringOrNull$FilesKt__UtilsKt) : relativeToOrSelf;
    }

    public static final File resolve(File resolve, File relative) {
        Intrinsics.checkNotNullParameter(resolve, "$this$resolve");
        Intrinsics.checkNotNullParameter(relative, "relative");
        if (FilesKt__FilePathComponentsKt.isRooted(relative)) {
            return relative;
        }
        String file = resolve.toString();
        Intrinsics.checkNotNullExpressionValue(file, "this.toString()");
        if ((file.length() == 0) || StringsKt__StringsKt.endsWith$default((CharSequence) file, File.separatorChar, false, 2, (Object) null)) {
            return new File(file + relative);
        }
        return new File(file + File.separatorChar + relative);
    }

    public static final File resolveSibling(File resolveSibling, File relative) {
        Intrinsics.checkNotNullParameter(resolveSibling, "$this$resolveSibling");
        Intrinsics.checkNotNullParameter(relative, "relative");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(resolveSibling);
        return resolve(resolve(components.getRoot(), components.getSize() == 0 ? new File(IStringUtil.TOP_PATH) : components.subPath(0, components.getSize() - 1)), relative);
    }

    public static final boolean startsWith(File startsWith, File other) {
        Intrinsics.checkNotNullParameter(startsWith, "$this$startsWith");
        Intrinsics.checkNotNullParameter(other, "other");
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(startsWith);
        FilePathComponents components2 = FilesKt__FilePathComponentsKt.toComponents(other);
        if (!(!Intrinsics.areEqual(components.getRoot(), components2.getRoot())) && components.getSize() >= components2.getSize()) {
            return components.getSegments().subList(0, components2.getSize()).equals(components2.getSegments());
        }
        return false;
    }

    public static final String toRelativeString(File toRelativeString, File base) {
        Intrinsics.checkNotNullParameter(toRelativeString, "$this$toRelativeString");
        Intrinsics.checkNotNullParameter(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(toRelativeString, base);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return relativeStringOrNull$FilesKt__UtilsKt;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + toRelativeString + " and " + base + IStringUtil.EXTENSION_SEPARATOR);
    }

    public static final String toRelativeStringOrNull$FilesKt__UtilsKt(File file, File file2) {
        FilePathComponents normalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(file));
        FilePathComponents normalize$FilesKt__UtilsKt2 = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(file2));
        if (!Intrinsics.areEqual(normalize$FilesKt__UtilsKt.getRoot(), normalize$FilesKt__UtilsKt2.getRoot())) {
            return null;
        }
        int size = normalize$FilesKt__UtilsKt2.getSize();
        int size2 = normalize$FilesKt__UtilsKt.getSize();
        int i2 = 0;
        int min = Math.min(size2, size);
        while (i2 < min && Intrinsics.areEqual(normalize$FilesKt__UtilsKt.getSegments().get(i2), normalize$FilesKt__UtilsKt2.getSegments().get(i2))) {
            i2++;
        }
        StringBuilder sb = new StringBuilder();
        int i3 = size - 1;
        if (i3 >= i2) {
            while (!Intrinsics.areEqual(normalize$FilesKt__UtilsKt2.getSegments().get(i3).getName(), IStringUtil.TOP_PATH)) {
                sb.append(IStringUtil.TOP_PATH);
                if (i3 != i2) {
                    sb.append(File.separatorChar);
                }
                if (i3 != i2) {
                    i3--;
                }
            }
            return null;
        }
        if (i2 < size2) {
            if (i2 < size) {
                sb.append(File.separatorChar);
            }
            List drop = CollectionsKt___CollectionsKt.drop(normalize$FilesKt__UtilsKt.getSegments(), i2);
            String str = File.separator;
            Intrinsics.checkNotNullExpressionValue(str, "File.separator");
            CollectionsKt___CollectionsKt.joinTo(drop, sb, (r14 & 2) != 0 ? StringUtil.ARRAY_ELEMENT_SEPARATOR : str, (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? StringHelper.STRING_MORE : null, (r14 & 64) != 0 ? null : null);
        }
        return sb.toString();
    }

    public static final List<File> normalize$FilesKt__UtilsKt(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != 46) {
                    if (hashCode == 1472 && name.equals(IStringUtil.TOP_PATH)) {
                        if (arrayList.isEmpty() || !(!Intrinsics.areEqual(((File) CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList)).getName(), IStringUtil.TOP_PATH))) {
                            arrayList.add(file);
                        } else {
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                } else if (name.equals(".")) {
                }
            }
            arrayList.add(file);
        }
        return arrayList;
    }

    public static final File resolve(File resolve, String relative) {
        Intrinsics.checkNotNullParameter(resolve, "$this$resolve");
        Intrinsics.checkNotNullParameter(relative, "relative");
        return resolve(resolve, new File(relative));
    }

    public static final File resolveSibling(File resolveSibling, String relative) {
        Intrinsics.checkNotNullParameter(resolveSibling, "$this$resolveSibling");
        Intrinsics.checkNotNullParameter(relative, "relative");
        return resolveSibling(resolveSibling, new File(relative));
    }

    public static final boolean startsWith(File startsWith, String other) {
        Intrinsics.checkNotNullParameter(startsWith, "$this$startsWith");
        Intrinsics.checkNotNullParameter(other, "other");
        return startsWith(startsWith, new File(other));
    }

    public static final boolean endsWith(File endsWith, String other) {
        Intrinsics.checkNotNullParameter(endsWith, "$this$endsWith");
        Intrinsics.checkNotNullParameter(other, "other");
        return endsWith(endsWith, new File(other));
    }
}
