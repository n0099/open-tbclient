package com.google.common.primitives;

import com.baidu.android.common.others.lang.StringUtil;
import d.g.c.a.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes6.dex */
public final class Chars {

    /* loaded from: classes6.dex */
    public static class CharArrayAsList extends AbstractList<Character> implements RandomAccess, Serializable {
        public static final long serialVersionUID = 0;
        public final char[] array;
        public final int end;
        public final int start;

        public CharArrayAsList(char[] cArr) {
            this(cArr, 0, cArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Character) && Chars.e(this.array, ((Character) obj).charValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CharArrayAsList) {
                CharArrayAsList charArrayAsList = (CharArrayAsList) obj;
                int size = size();
                if (charArrayAsList.size() != size) {
                    return false;
                }
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.array[this.start + i2] != charArrayAsList.array[charArrayAsList.start + i2]) {
                        return false;
                    }
                }
                return true;
            }
            return super.equals(obj);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i2 = 1;
            for (int i3 = this.start; i3 < this.end; i3++) {
                char c2 = this.array[i3];
                Chars.d(c2);
                i2 = (i2 * 31) + c2;
            }
            return i2;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int e2;
            if (!(obj instanceof Character) || (e2 = Chars.e(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return e2 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int f2;
            if (!(obj instanceof Character) || (f2 = Chars.f(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return f2 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Character> subList(int i2, int i3) {
            n.v(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            char[] cArr = this.array;
            int i4 = this.start;
            return new CharArrayAsList(cArr, i2 + i4, i4 + i3);
        }

        public char[] toCharArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 3);
            sb.append('[');
            sb.append(this.array[this.start]);
            int i2 = this.start;
            while (true) {
                i2++;
                if (i2 < this.end) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(this.array[i2]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        public CharArrayAsList(char[] cArr, int i2, int i3) {
            this.array = cArr;
            this.start = i2;
            this.end = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Character get(int i2) {
            n.n(i2, size());
            return Character.valueOf(this.array[this.start + i2]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Character set(int i2, Character ch) {
            n.n(i2, size());
            char[] cArr = this.array;
            int i3 = this.start;
            char c2 = cArr[i3 + i2];
            n.p(ch);
            cArr[i3 + i2] = ch.charValue();
            return Character.valueOf(c2);
        }
    }

    /* loaded from: classes6.dex */
    public enum LexicographicalComparator implements Comparator<char[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Chars.lexicographicalComparator()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(char[] cArr, char[] cArr2) {
            int min = Math.min(cArr.length, cArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int c2 = Chars.c(cArr[i2], cArr2[i2]);
                if (c2 != 0) {
                    return c2;
                }
            }
            return cArr.length - cArr2.length;
        }
    }

    public static int c(char c2, char c3) {
        return c2 - c3;
    }

    public static int d(char c2) {
        return c2;
    }

    public static int e(char[] cArr, char c2, int i2, int i3) {
        while (i2 < i3) {
            if (cArr[i2] == c2) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int f(char[] cArr, char c2, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (cArr[i4] == c2) {
                return i4;
            }
        }
        return -1;
    }
}
