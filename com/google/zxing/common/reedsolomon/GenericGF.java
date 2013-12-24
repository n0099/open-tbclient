package com.google.zxing.common.reedsolomon;

import com.baidu.zeus.NotificationProxy;
import com.google.protobuf.CodedOutputStream;
/* loaded from: classes.dex */
public final class GenericGF {
    private static final int INITIALIZATION_THRESHOLD = 0;
    private int[] expTable;
    private final int generatorBase;
    private boolean initialized = false;
    private int[] logTable;
    private GenericGFPoly one;
    private final int primitive;
    private final int size;
    private GenericGFPoly zero;
    public static final GenericGF AZTEC_DATA_12 = new GenericGF(4201, CodedOutputStream.DEFAULT_BUFFER_SIZE, 1);
    public static final GenericGF AZTEC_DATA_10 = new GenericGF(1033, NotificationProxy.MAX_URL_LENGTH, 1);
    public static final GenericGF AZTEC_DATA_6 = new GenericGF(67, 64, 1);
    public static final GenericGF AZTEC_PARAM = new GenericGF(19, 16, 1);
    public static final GenericGF QR_CODE_FIELD_256 = new GenericGF(285, 256, 0);
    public static final GenericGF DATA_MATRIX_FIELD_256 = new GenericGF(301, 256, 1);
    public static final GenericGF AZTEC_DATA_8 = DATA_MATRIX_FIELD_256;
    public static final GenericGF MAXICODE_FIELD_64 = AZTEC_DATA_6;

    public GenericGF(int i, int i2, int i3) {
        this.primitive = i;
        this.size = i2;
        this.generatorBase = i3;
        if (i2 <= 0) {
            initialize();
        }
    }

    private void initialize() {
        this.expTable = new int[this.size];
        this.logTable = new int[this.size];
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            this.expTable[i2] = i;
            i <<= 1;
            if (i >= this.size) {
                i = (i ^ this.primitive) & (this.size - 1);
            }
        }
        for (int i3 = 0; i3 < this.size - 1; i3++) {
            this.logTable[this.expTable[i3]] = i3;
        }
        this.zero = new GenericGFPoly(this, new int[1]);
        this.one = new GenericGFPoly(this, new int[]{1});
        this.initialized = true;
    }

    private void checkInit() {
        if (!this.initialized) {
            initialize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GenericGFPoly getZero() {
        checkInit();
        return this.zero;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GenericGFPoly getOne() {
        checkInit();
        return this.one;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GenericGFPoly buildMonomial(int i, int i2) {
        checkInit();
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.zero;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new GenericGFPoly(this, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int addOrSubtract(int i, int i2) {
        return i ^ i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int exp(int i) {
        checkInit();
        return this.expTable[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int log(int i) {
        checkInit();
        if (i == 0) {
            throw new IllegalArgumentException();
        }
        return this.logTable[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int inverse(int i) {
        checkInit();
        if (i == 0) {
            throw new ArithmeticException();
        }
        return this.expTable[(this.size - this.logTable[i]) - 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int multiply(int i, int i2) {
        checkInit();
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return this.expTable[(this.logTable[i] + this.logTable[i2]) % (this.size - 1)];
    }

    public int getSize() {
        return this.size;
    }

    public int getGeneratorBase() {
        return this.generatorBase;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.primitive) + ',' + this.size + ')';
    }
}
