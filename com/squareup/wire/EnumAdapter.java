package com.squareup.wire;

import com.squareup.wire.ProtoEnum;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes4.dex */
final class EnumAdapter<E extends ProtoEnum> {
    private static final Comparator<ProtoEnum> COMPARATOR = new Comparator<ProtoEnum>() { // from class: com.squareup.wire.EnumAdapter.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(ProtoEnum protoEnum, ProtoEnum protoEnum2) {
            return protoEnum.getValue() - protoEnum2.getValue();
        }
    };
    private final E[] constants;
    private final boolean isDense;
    private final Class<E> type;
    private final int[] values;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EnumAdapter(Class<E> cls) {
        this.type = cls;
        this.constants = cls.getEnumConstants();
        Arrays.sort(this.constants, COMPARATOR);
        int length = this.constants.length;
        if (this.constants[0].getValue() == 1 && this.constants[length - 1].getValue() == length) {
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

    public int toInt(E e) {
        return e.getValue();
    }

    public E fromInt(int i) {
        try {
            return this.constants[this.isDense ? i - 1 : Arrays.binarySearch(this.values, i)];
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Unknown enum tag " + i + " for " + this.type.getCanonicalName());
        }
    }
}
