package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;
/* loaded from: classes7.dex */
public class fe {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f40787a = {80, 85, 83, 72};

    /* renamed from: a  reason: collision with other field name */
    public byte f374a;

    /* renamed from: a  reason: collision with other field name */
    public int f375a;

    /* renamed from: a  reason: collision with other field name */
    public short f376a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f40788b;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f40789a = new c();

        /* renamed from: a  reason: collision with other field name */
        public static final d f377a = new d();

        public static byte[] a(byte[] bArr) {
            return a(bArr, f377a);
        }

        public static byte[] a(byte[] bArr, b bVar) {
            if (fe.m298a(bArr)) {
                fe a2 = fe.a(bArr);
                return (a2.f374a == 0 || a2.f374a != bVar.a()) ? a2.f40788b : bVar.a(a2.f40788b, a2.f375a);
            }
            return bArr;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i);
    }

    /* loaded from: classes7.dex */
    public static final class c {
    }

    /* loaded from: classes7.dex */
    public static final class d implements b {
        @Override // com.xiaomi.push.fe.b
        public byte a() {
            return (byte) 2;
        }

        @Override // com.xiaomi.push.fe.b
        public byte[] a(byte[] bArr, int i) {
            GZIPInputStream gZIPInputStream = null;
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
                try {
                    byte[] bArr2 = new byte[i];
                    gZIPInputStream2.read(bArr2);
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return bArr2;
                } catch (IOException unused2) {
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public fe(byte b2, int i, byte[] bArr) {
        this((short) 1, b2, i, bArr);
    }

    public fe(short s, byte b2, int i, byte[] bArr) {
        this.f376a = (short) 1;
        this.f376a = s;
        this.f374a = b2;
        this.f375a = i;
        this.f40788b = bArr;
    }

    public static fe a(byte b2, int i, byte[] bArr) {
        return new fe(b2, i, bArr);
    }

    public static fe a(short s, byte b2, int i, byte[] bArr) {
        return new fe(s, b2, i, bArr);
    }

    public static fe a(byte[] bArr) {
        if (m298a(bArr)) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            order.getInt();
            short s = order.getShort();
            byte b2 = order.get();
            int i = order.getInt();
            byte[] bArr2 = new byte[order.getInt()];
            order.get(bArr2);
            return a(s, b2, i, bArr2);
        }
        return a((byte) 0, bArr.length, bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m298a(byte[] bArr) {
        byte[] bArr2 = f40787a;
        return a(bArr2, bArr, bArr2.length);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
