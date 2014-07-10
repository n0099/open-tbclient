package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.io.FileUtils;
/* loaded from: classes.dex */
public class SizeFileComparator extends AbstractFileComparator implements Serializable {
    public static final Comparator<File> SIZE_COMPARATOR = new SizeFileComparator();
    public static final Comparator<File> SIZE_REVERSE = new ReverseComparator(SIZE_COMPARATOR);
    public static final Comparator<File> SIZE_SUMDIR_COMPARATOR = new SizeFileComparator(true);
    public static final Comparator<File> SIZE_SUMDIR_REVERSE = new ReverseComparator(SIZE_SUMDIR_COMPARATOR);
    private final boolean sumDirectoryContents;

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ List sort(List list) {
        return super.sort(list);
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ File[] sort(File[] fileArr) {
        return super.sort(fileArr);
    }

    public SizeFileComparator() {
        this.sumDirectoryContents = false;
    }

    public SizeFileComparator(boolean z) {
        this.sumDirectoryContents = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        long length;
        long length2;
        if (file.isDirectory()) {
            length = (this.sumDirectoryContents && file.exists()) ? FileUtils.sizeOfDirectory(file) : 0L;
        } else {
            length = file.length();
        }
        if (file2.isDirectory()) {
            length2 = (this.sumDirectoryContents && file2.exists()) ? FileUtils.sizeOfDirectory(file2) : 0L;
        } else {
            length2 = file2.length();
        }
        long j = length - length2;
        if (j < 0) {
            return -1;
        }
        if (j > 0) {
            return 1;
        }
        return 0;
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public String toString() {
        return super.toString() + "[sumDirectoryContents=" + this.sumDirectoryContents + "]";
    }
}
