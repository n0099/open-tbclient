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
/* loaded from: classes7.dex */
public class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0091 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean copyRecursively(File file, File file2, boolean z, Function2<? super File, ? super IOException, ? extends OnErrorAction> function2) {
        boolean z2;
        if (!file.exists()) {
            return function2.invoke(file, new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE;
        }
        try {
            Iterator<File> it = FilesKt__FileTreeWalkKt.walkTopDown(file).onFail(new FilesKt__UtilsKt$copyRecursively$2(function2)).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (!next.exists()) {
                    if (function2.invoke(next, new NoSuchFileException(next, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) {
                        return false;
                    }
                } else {
                    File file3 = new File(file2, toRelativeString(next, file));
                    if (file3.exists() && (!next.isDirectory() || !file3.isDirectory())) {
                        if (z) {
                            if (file3.isDirectory()) {
                                if (!deleteRecursively(file3)) {
                                }
                                z2 = false;
                            } else {
                                if (!file3.delete()) {
                                }
                                z2 = false;
                            }
                            if (!z2) {
                                if (function2.invoke(file3, new FileAlreadyExistsException(next, file3, "The destination file already exists.")) == OnErrorAction.TERMINATE) {
                                    return false;
                                }
                            }
                        }
                        z2 = true;
                        if (!z2) {
                        }
                    }
                    if (next.isDirectory()) {
                        file3.mkdirs();
                    } else if (copyTo$default(next, file3, z, 0, 4, null).length() != next.length() && function2.invoke(next, new IOException("Source file wasn't copied completely, length of destination file differs.")) == OnErrorAction.TERMINATE) {
                        return false;
                    }
                }
            }
            return true;
        } catch (TerminateException unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean copyRecursively$default(File file, File file2, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function2 = FilesKt__UtilsKt$copyRecursively$1.INSTANCE;
        }
        return copyRecursively(file, file2, z, function2);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static final File copyTo(File file, File file2, boolean z, int i) {
        if (file.exists()) {
            if (file2.exists()) {
                if (z) {
                    if (!file2.delete()) {
                        throw new FileAlreadyExistsException(file, file2, "Tried to overwrite the destination, but failed to delete it.");
                    }
                } else {
                    throw new FileAlreadyExistsException(file, file2, "The destination file already exists.");
                }
            }
            if (file.isDirectory()) {
                if (!file2.mkdirs()) {
                    throw new FileSystemException(file, file2, "Failed to create target directory.");
                }
            } else {
                File parentFile = file2.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    ByteStreamsKt.copyTo(fileInputStream, fileOutputStream, i);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                } finally {
                }
            }
            return file2;
        }
        throw new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null);
    }

    public static /* synthetic */ File copyTo$default(File file, File file2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 8192;
        }
        return copyTo(file, file2, z, i);
    }

    public static final File createTempDir(String str, String str2, File file) {
        File dir = File.createTempFile(str, str2, file);
        dir.delete();
        if (dir.mkdir()) {
            Intrinsics.checkExpressionValueIsNotNull(dir, "dir");
            return dir;
        }
        throw new IOException("Unable to create temporary directory " + dir + IStringUtil.EXTENSION_SEPARATOR);
    }

    public static /* synthetic */ File createTempDir$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return createTempDir(str, str2, file);
    }

    public static final File createTempFile(String str, String str2, File file) {
        File createTempFile = File.createTempFile(str, str2, file);
        Intrinsics.checkExpressionValueIsNotNull(createTempFile, "File.createTempFile(prefix, suffix, directory)");
        return createTempFile;
    }

    public static /* synthetic */ File createTempFile$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return createTempFile(str, str2, file);
    }

    public static final boolean deleteRecursively(File file) {
        while (true) {
            boolean z = true;
            for (File file2 : FilesKt__FileTreeWalkKt.walkBottomUp(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (z) {
                        break;
                    }
                }
                z = false;
            }
            return z;
        }
    }

    public static final boolean endsWith(File file, File file2) {
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        FilePathComponents components2 = FilesKt__FilePathComponentsKt.toComponents(file2);
        if (components2.isRooted()) {
            return Intrinsics.areEqual(file, file2);
        }
        int size = components.getSize() - components2.getSize();
        if (size < 0) {
            return false;
        }
        return components.getSegments().subList(size, components.getSize()).equals(components2.getSegments());
    }

    public static final String getExtension(File file) {
        String name = file.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "name");
        return StringsKt__StringsKt.substringAfterLast(name, (char) IStringUtil.EXTENSION_SEPARATOR, "");
    }

    public static final String getInvariantSeparatorsPath(File file) {
        if (File.separatorChar != '/') {
            String path = file.getPath();
            Intrinsics.checkExpressionValueIsNotNull(path, "path");
            return StringsKt__StringsJVMKt.replace$default(path, File.separatorChar, '/', false, 4, (Object) null);
        }
        String path2 = file.getPath();
        Intrinsics.checkExpressionValueIsNotNull(path2, "path");
        return path2;
    }

    public static final String getNameWithoutExtension(File file) {
        String name = file.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "name");
        return StringsKt__StringsKt.substringBeforeLast$default(name, ".", (String) null, 2, (Object) null);
    }

    public static final File normalize(File file) {
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        File root = components.getRoot();
        List<File> normalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(components.getSegments());
        String str = File.separator;
        Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
        return resolve(root, CollectionsKt___CollectionsKt.joinToString$default(normalize$FilesKt__UtilsKt, str, null, null, 0, null, null, 62, null));
    }

    public static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents filePathComponents) {
        return new FilePathComponents(filePathComponents.getRoot(), normalize$FilesKt__UtilsKt(filePathComponents.getSegments()));
    }

    public static final File relativeTo(File file, File file2) {
        return new File(toRelativeString(file, file2));
    }

    public static final File relativeToOrNull(File file, File file2) {
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return new File(relativeStringOrNull$FilesKt__UtilsKt);
        }
        return null;
    }

    public static final File relativeToOrSelf(File file, File file2) {
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        return relativeStringOrNull$FilesKt__UtilsKt != null ? new File(relativeStringOrNull$FilesKt__UtilsKt) : file;
    }

    public static final File resolve(File file, File file2) {
        if (FilesKt__FilePathComponentsKt.isRooted(file2)) {
            return file2;
        }
        String file3 = file.toString();
        Intrinsics.checkExpressionValueIsNotNull(file3, "this.toString()");
        if ((file3.length() == 0) || StringsKt__StringsKt.endsWith$default((CharSequence) file3, File.separatorChar, false, 2, (Object) null)) {
            return new File(file3 + file2);
        }
        return new File(file3 + File.separatorChar + file2);
    }

    public static final File resolveSibling(File file, File file2) {
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        return resolve(resolve(components.getRoot(), components.getSize() == 0 ? new File(IStringUtil.TOP_PATH) : components.subPath(0, components.getSize() - 1)), file2);
    }

    public static final boolean startsWith(File file, File file2) {
        FilePathComponents components = FilesKt__FilePathComponentsKt.toComponents(file);
        FilePathComponents components2 = FilesKt__FilePathComponentsKt.toComponents(file2);
        if (!(!Intrinsics.areEqual(components.getRoot(), components2.getRoot())) && components.getSize() >= components2.getSize()) {
            return components.getSegments().subList(0, components2.getSize()).equals(components2.getSegments());
        }
        return false;
    }

    public static final String toRelativeString(File file, File file2) {
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return relativeStringOrNull$FilesKt__UtilsKt;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + file2 + IStringUtil.EXTENSION_SEPARATOR);
    }

    public static final String toRelativeStringOrNull$FilesKt__UtilsKt(File file, File file2) {
        FilePathComponents normalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(file));
        FilePathComponents normalize$FilesKt__UtilsKt2 = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(file2));
        if (!Intrinsics.areEqual(normalize$FilesKt__UtilsKt.getRoot(), normalize$FilesKt__UtilsKt2.getRoot())) {
            return null;
        }
        int size = normalize$FilesKt__UtilsKt2.getSize();
        int size2 = normalize$FilesKt__UtilsKt.getSize();
        int i = 0;
        int min = Math.min(size2, size);
        while (i < min && Intrinsics.areEqual(normalize$FilesKt__UtilsKt.getSegments().get(i), normalize$FilesKt__UtilsKt2.getSegments().get(i))) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = size - 1;
        if (i2 >= i) {
            while (!Intrinsics.areEqual(normalize$FilesKt__UtilsKt2.getSegments().get(i2).getName(), IStringUtil.TOP_PATH)) {
                sb.append(IStringUtil.TOP_PATH);
                if (i2 != i) {
                    sb.append(File.separatorChar);
                }
                if (i2 != i) {
                    i2--;
                }
            }
            return null;
        }
        if (i < size2) {
            if (i < size) {
                sb.append(File.separatorChar);
            }
            List drop = CollectionsKt___CollectionsKt.drop(normalize$FilesKt__UtilsKt.getSegments(), i);
            String str = File.separator;
            Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
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

    public static final File resolve(File file, String str) {
        return resolve(file, new File(str));
    }

    public static final File resolveSibling(File file, String str) {
        return resolveSibling(file, new File(str));
    }

    public static final boolean startsWith(File file, String str) {
        return startsWith(file, new File(str));
    }

    public static final boolean endsWith(File file, String str) {
        return endsWith(file, new File(str));
    }
}
