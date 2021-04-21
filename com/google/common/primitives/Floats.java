package com.google.common.primitives;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.common.base.Converter;
import d.h.c.a.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes6.dex */
public final class Floats {

    /* loaded from: classes6.dex */
    public static class FloatArrayAsList extends AbstractList<Float> implements RandomAccess, Serializable {
        public static final long serialVersionUID = 0;
        public final float[] array;
        public final int end;
        public final int start;

        public FloatArrayAsList(float[] fArr) {
            this(fArr, 0, fArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Float) && Floats.d(this.array, ((Float) obj).floatValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof FloatArrayAsList) {
                FloatArrayAsList floatArrayAsList = (FloatArrayAsList) obj;
                int size = size();
                if (floatArrayAsList.size() != size) {
                    return false;
                }
                for (int i = 0; i < size; i++) {
                    if (this.array[this.start + i] != floatArrayAsList.array[floatArrayAsList.start + i]) {
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
                i = (i * 31) + Floats.c(this.array[i2]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int d2;
            if (!(obj instanceof Float) || (d2 = Floats.d(this.array, ((Float) obj).floatValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return d2 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int e2;
            if (!(obj instanceof Float) || (e2 = Floats.e(this.array, ((Float) obj).floatValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return e2 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Float> subList(int i, int i2) {
            n.v(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            float[] fArr = this.array;
            int i3 = this.start;
            return new FloatArrayAsList(fArr, i + i3, i3 + i2);
        }

        public float[] toFloatArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
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

        public FloatArrayAsList(float[] fArr, int i, int i2) {
            this.array = fArr;
            this.start = i;
            this.end = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Float get(int i) {
            n.n(i, size());
            return Float.valueOf(this.array[this.start + i]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Float set(int i, Float f2) {
            n.n(i, size());
            float[] fArr = this.array;
            int i2 = this.start;
            float f3 = fArr[i2 + i];
            n.p(f2);
            fArr[i2 + i] = f2.floatValue();
            return Float.valueOf(f3);
        }
    }

    /* loaded from: classes6.dex */
    public static final class FloatConverter extends Converter<String, Float> implements Serializable {
        public static final FloatConverter INSTANCE = new FloatConverter();
        public static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Floats.stringConverter()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public String doBackward(Float f2) {
            return f2.toString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public Float doForward(String str) {
            return Float.valueOf(str);
        }
    }

    /* loaded from: classes6.dex */
    public enum LexicographicalComparator implements Comparator<float[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Floats.lexicographicalComparator()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(float[] fArr, float[] fArr2) {
            int min = Math.min(fArr.length, fArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = Float.compare(fArr[i], fArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return fArr.length - fArr2.length;
        }
    }

    public static int c(float f2) {
        return Float.valueOf(f2).hashCode();
    }

    public static int d(float[] fArr, float f2, int i, int i2) {
        while (i < i2) {
            if (fArr[i] == f2) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int e(float[] fArr, float f2, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (fArr[i3] == f2) {
                return i3;
            }
        }
        return -1;
    }
}
