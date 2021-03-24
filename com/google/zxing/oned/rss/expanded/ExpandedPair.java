package com.google.zxing.oned.rss.expanded;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
/* loaded from: classes6.dex */
public final class ExpandedPair {
    public final FinderPattern finderPattern;
    public final DataCharacter leftChar;
    public final boolean mayBeLast;
    public final DataCharacter rightChar;

    public ExpandedPair(DataCharacter dataCharacter, DataCharacter dataCharacter2, FinderPattern finderPattern, boolean z) {
        this.leftChar = dataCharacter;
        this.rightChar = dataCharacter2;
        this.finderPattern = finderPattern;
        this.mayBeLast = z;
    }

    public static boolean equalsOrNull(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static int hashNotNull(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ExpandedPair) {
            ExpandedPair expandedPair = (ExpandedPair) obj;
            return equalsOrNull(this.leftChar, expandedPair.leftChar) && equalsOrNull(this.rightChar, expandedPair.rightChar) && equalsOrNull(this.finderPattern, expandedPair.finderPattern);
        }
        return false;
    }

    public FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    public DataCharacter getLeftChar() {
        return this.leftChar;
    }

    public DataCharacter getRightChar() {
        return this.rightChar;
    }

    public int hashCode() {
        return (hashNotNull(this.leftChar) ^ hashNotNull(this.rightChar)) ^ hashNotNull(this.finderPattern);
    }

    public boolean mayBeLast() {
        return this.mayBeLast;
    }

    public boolean mustBeLast() {
        return this.rightChar == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.leftChar);
        sb.append(" , ");
        sb.append(this.rightChar);
        sb.append(ZeusCrashHandler.NAME_SEPERATOR);
        FinderPattern finderPattern = this.finderPattern;
        sb.append(finderPattern == null ? StringUtil.NULL_STRING : Integer.valueOf(finderPattern.getValue()));
        sb.append(" ]");
        return sb.toString();
    }
}
