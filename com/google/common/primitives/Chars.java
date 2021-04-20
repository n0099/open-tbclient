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
                for (int i = 0; i < size; i++) {
                    if (this.array[this.start + i] != charArrayAsList.array[charArrayAsList.start + i]) {
                        return false;
                    }
                }
                return true;
            }
            return super.equals(obj);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                char c2 = this.array[i2];
                Chars.d(c2);
                i = (i * 31) + c2;
            }
            return i;
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
        public List<Character> subList(int i, int i2) {
            n.v(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            char[] cArr = this.array;
            int i3 = this.start;
            return new CharArrayAsList(cArr, i + i3, i3 + i2);
        }

        public char[] toCharArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 3);
            sb.append('[');
            sb.append(this.array[this.start]);
            int i = this.start;
            while (true) {
                i++;
                if (i < this.end) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(this.array[i]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        public CharArrayAsList(char[] cArr, int i, int i2) {
            this.array = cArr;
            this.start = i;
            this.end = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Character get(int i) {
            n.n(i, size());
            return Character.valueOf(this.array[this.start + i]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Character set(int i, Character ch) {
            n.n(i, size());
            char[] cArr = this.array;
            int i2 = this.start;
            char c2 = cArr[i2 + i];
            n.p(ch);
            cArr[i2 + i] = ch.charValue();
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
            for (int i = 0; i < min; i++) {
                int c2 = Chars.c(cArr[i], cArr2[i]);
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

    public static int e(char[] cArr, char c2, int i, int i2) {
        while (i < i2) {
            if (cArr[i] == c2) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int f(char[] cArr, char c2, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (cArr[i3] == c2) {
                return i3;
            }
        }
        return -1;
    }
}
