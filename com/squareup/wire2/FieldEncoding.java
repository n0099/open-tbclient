package com.squareup.wire2;

import java.io.IOException;
import java.net.ProtocolException;
/* loaded from: classes7.dex */
public enum FieldEncoding {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);
    
    public final int value;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35751a;

        static {
            int[] iArr = new int[FieldEncoding.values().length];
            f35751a = iArr;
            try {
                iArr[FieldEncoding.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35751a[FieldEncoding.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35751a[FieldEncoding.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35751a[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    FieldEncoding(int i2) {
        this.value = i2;
    }

    public static FieldEncoding get(int i2) throws IOException {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 5) {
                        return FIXED32;
                    }
                    throw new ProtocolException("Unexpected FieldEncoding: " + i2);
                }
                return LENGTH_DELIMITED;
            }
            return FIXED64;
        }
        return VARINT;
    }

    public ProtoAdapter<?> rawProtoAdapter() {
        int i2 = a.f35751a[ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        return ProtoAdapter.BYTES;
                    }
                    throw new AssertionError();
                }
                return ProtoAdapter.FIXED64;
            }
            return ProtoAdapter.FIXED32;
        }
        return ProtoAdapter.UINT64;
    }
}
