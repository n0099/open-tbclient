package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes.dex */
public class LastModifiedFileComparator extends AbstractFileComparator implements Serializable {
    public static final Comparator<File> LASTMODIFIED_COMPARATOR = new LastModifiedFileComparator();
    public static final Comparator<File> LASTMODIFIED_REVERSE = new ReverseComparator(LASTMODIFIED_COMPARATOR);

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ List sort(List list) {
        return super.sort(list);
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ File[] sort(File[] fileArr) {
        return super.sort(fileArr);
    }

    @Override // org.apache.commons.io.comparator.AbstractFileComparator
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        long lastModified = file.lastModified() - file2.lastModified();
        if (lastModified < 0) {
            return -1;
        }
        if (lastModified > 0) {
            return 1;
        }
        return 0;
    }
}
