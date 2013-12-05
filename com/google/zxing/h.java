package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f2874a;
    private final byte[] b;
    private i[] c;
    private final BarcodeFormat d;
    private Map<ResultMetadataType, Object> e;
    private final long f;

    public h(String str, byte[] bArr, i[] iVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, iVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public h(String str, byte[] bArr, i[] iVarArr, BarcodeFormat barcodeFormat, long j) {
        this.f2874a = str;
        this.b = bArr;
        this.c = iVarArr;
        this.d = barcodeFormat;
        this.e = null;
        this.f = j;
    }

    public String a() {
        return this.f2874a;
    }

    public i[] b() {
        return this.c;
    }

    public BarcodeFormat c() {
        return this.d;
    }

    public void a(ResultMetadataType resultMetadataType, Object obj) {
        if (this.e == null) {
            this.e = new EnumMap(ResultMetadataType.class);
        }
        this.e.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.f2874a;
    }
}
