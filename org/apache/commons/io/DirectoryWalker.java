package org.apache.commons.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
/* loaded from: classes.dex */
public abstract class DirectoryWalker<T> {
    private final int depthLimit;
    private final FileFilter filter;

    protected DirectoryWalker() {
        this(null, -1);
    }

    protected DirectoryWalker(FileFilter fileFilter, int i) {
        this.filter = fileFilter;
        this.depthLimit = i;
    }

    protected DirectoryWalker(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2, int i) {
        if (iOFileFilter == null && iOFileFilter2 == null) {
            this.filter = null;
        } else {
            this.filter = FileFilterUtils.or(FileFilterUtils.makeDirectoryOnly(iOFileFilter == null ? TrueFileFilter.TRUE : iOFileFilter), FileFilterUtils.makeFileOnly(iOFileFilter2 == null ? TrueFileFilter.TRUE : iOFileFilter2));
        }
        this.depthLimit = i;
    }

    protected final void walk(File file, Collection<T> collection) {
        if (file == null) {
            throw new NullPointerException("Start Directory is null");
        }
        try {
            handleStart(file, collection);
            walk(file, 0, collection);
            handleEnd(collection);
        } catch (CancelException e) {
            handleCancelled(file, collection, e);
        }
    }

    private void walk(File file, int i, Collection<T> collection) {
        checkIfCancelled(file, i, collection);
        if (handleDirectory(file, i, collection)) {
            handleDirectoryStart(file, i, collection);
            int i2 = i + 1;
            if (this.depthLimit < 0 || i2 <= this.depthLimit) {
                checkIfCancelled(file, i, collection);
                File[] filterDirectoryContents = filterDirectoryContents(file, i, this.filter == null ? file.listFiles() : file.listFiles(this.filter));
                if (filterDirectoryContents == null) {
                    handleRestricted(file, i2, collection);
                } else {
                    for (File file2 : filterDirectoryContents) {
                        if (file2.isDirectory()) {
                            walk(file2, i2, collection);
                        } else {
                            checkIfCancelled(file2, i2, collection);
                            handleFile(file2, i2, collection);
                            checkIfCancelled(file2, i2, collection);
                        }
                    }
                }
            }
            handleDirectoryEnd(file, i, collection);
        }
        checkIfCancelled(file, i, collection);
    }

    protected final void checkIfCancelled(File file, int i, Collection<T> collection) {
        if (handleIsCancelled(file, i, collection)) {
            throw new CancelException(file, i);
        }
    }

    protected boolean handleIsCancelled(File file, int i, Collection<T> collection) {
        return false;
    }

    protected void handleCancelled(File file, Collection<T> collection, CancelException cancelException) {
        throw cancelException;
    }

    protected void handleStart(File file, Collection<T> collection) {
    }

    protected boolean handleDirectory(File file, int i, Collection<T> collection) {
        return true;
    }

    protected void handleDirectoryStart(File file, int i, Collection<T> collection) {
    }

    protected File[] filterDirectoryContents(File file, int i, File[] fileArr) {
        return fileArr;
    }

    protected void handleFile(File file, int i, Collection<T> collection) {
    }

    protected void handleRestricted(File file, int i, Collection<T> collection) {
    }

    protected void handleDirectoryEnd(File file, int i, Collection<T> collection) {
    }

    protected void handleEnd(Collection<T> collection) {
    }

    /* loaded from: classes.dex */
    public class CancelException extends IOException {
        private static final long serialVersionUID = 1347339620135041008L;
        private final int depth;
        private final File file;

        public CancelException(File file, int i) {
            this("Operation Cancelled", file, i);
        }

        public CancelException(String str, File file, int i) {
            super(str);
            this.file = file;
            this.depth = i;
        }

        public File getFile() {
            return this.file;
        }

        public int getDepth() {
            return this.depth;
        }
    }
}
