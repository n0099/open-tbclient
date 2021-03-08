package com.facebook.common.file;

import com.facebook.common.internal.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes4.dex */
public class FileUtils {
    public static void ax(File file) throws CreateDirectoryException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.delete()) {
                    throw new CreateDirectoryException(file.getAbsolutePath(), new FileDeleteException(file.getAbsolutePath()));
                }
            } else {
                return;
            }
        }
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new CreateDirectoryException(file.getAbsolutePath());
        }
    }

    public static void rename(File file, File file2) throws RenameException {
        g.checkNotNull(file);
        g.checkNotNull(file2);
        file2.delete();
        if (file.renameTo(file2)) {
            return;
        }
        Throwable th = null;
        if (file2.exists()) {
            th = new FileDeleteException(file2.getAbsolutePath());
        } else if (!file.getParentFile().exists()) {
            th = new ParentDirNotFoundException(file.getAbsolutePath());
        } else if (!file.exists()) {
            th = new FileNotFoundException(file.getAbsolutePath());
        }
        throw new RenameException("Unknown error renaming " + file.getAbsolutePath() + " to " + file2.getAbsolutePath(), th);
    }

    /* loaded from: classes4.dex */
    public static class CreateDirectoryException extends IOException {
        public CreateDirectoryException(String str) {
            super(str);
        }

        public CreateDirectoryException(String str, Throwable th) {
            super(str);
            initCause(th);
        }
    }

    /* loaded from: classes4.dex */
    public static class ParentDirNotFoundException extends FileNotFoundException {
        public ParentDirNotFoundException(String str) {
            super(str);
        }
    }

    /* loaded from: classes4.dex */
    public static class FileDeleteException extends IOException {
        public FileDeleteException(String str) {
            super(str);
        }
    }

    /* loaded from: classes4.dex */
    public static class RenameException extends IOException {
        public RenameException(String str) {
            super(str);
        }

        public RenameException(String str, Throwable th) {
            super(str);
            initCause(th);
        }
    }
}
