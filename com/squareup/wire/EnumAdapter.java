package com.squareup.wire;

import com.squareup.wire.ProtoEnum;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes6.dex */
public final class EnumAdapter<E extends ProtoEnum> {
    public static final Comparator<ProtoEnum> COMPARATOR = new Comparator<ProtoEnum>() { // from class: com.squareup.wire.EnumAdapter.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(ProtoEnum protoEnum, ProtoEnum protoEnum2) {
            return protoEnum.getValue() - protoEnum2.getValue();
        }
    };
    public final E[] constants;
    public final boolean isDense;
    public final Class<E> type;
    public final int[] values;

    public EnumAdapter(Class<E> cls) {
        this.type = cls;
        E[] enumConstants = cls.getEnumConstants();
        this.constants = enumConstants;
        Arrays.sort(enumConstants, COMPARATOR);
        E[] eArr = this.constants;
        int length = eArr.length;
        if (eArr[0].getValue() == 1 && this.constants[length - 1].getValue() == length) {
            this.isDense = true;
            this.values = null;
            return;
        }
        this.isDense = false;
        this.values = new int[length];
        for (int i = 0; i < length; i++) {
            this.values[i] = this.constants[i].getValue();
        }
    }

    public E fromInt(int i) {
        try {
            return this.constants[this.isDense ? i - 1 : Arrays.binarySearch(this.values, i)];
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("Unknown enum tag " + i + " for " + this.type.getCanonicalName());
        }
    }

    public int toInt(E e2) {
        return e2.getValue();
    }
}
