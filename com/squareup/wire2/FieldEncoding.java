package com.squareup.wire2;

import java.io.IOException;
import java.net.ProtocolException;
/* loaded from: classes6.dex */
public enum FieldEncoding {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);
    
    public final int value;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38992a;

        static {
            int[] iArr = new int[FieldEncoding.values().length];
            f38992a = iArr;
            try {
                iArr[FieldEncoding.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38992a[FieldEncoding.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38992a[FieldEncoding.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38992a[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    FieldEncoding(int i) {
        this.value = i;
    }

    public static FieldEncoding get(int i) throws IOException {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 5) {
                        return FIXED32;
                    }
                    throw new ProtocolException("Unexpected FieldEncoding: " + i);
                }
                return LENGTH_DELIMITED;
            }
            return FIXED64;
        }
        return VARINT;
    }

    public ProtoAdapter<?> rawProtoAdapter() {
        int i = a.f38992a[ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
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
