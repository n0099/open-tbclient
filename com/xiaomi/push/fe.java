package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;
/* loaded from: classes7.dex */
public class fe {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f41257a = {80, 85, 83, 72};

    /* renamed from: a  reason: collision with other field name */
    public byte f374a;

    /* renamed from: a  reason: collision with other field name */
    public int f375a;

    /* renamed from: a  reason: collision with other field name */
    public short f376a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f41258b;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f41259a = new c();

        /* renamed from: a  reason: collision with other field name */
        public static final d f377a = new d();

        public static byte[] a(byte[] bArr) {
            return a(bArr, f377a);
        }

        public static byte[] a(byte[] bArr, b bVar) {
            if (fe.m299a(bArr)) {
                fe a2 = fe.a(bArr);
                return (a2.f374a == 0 || a2.f374a != bVar.a()) ? a2.f41258b : bVar.a(a2.f41258b, a2.f375a);
            }
            return bArr;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i2);
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
        public byte[] a(byte[] bArr, int i2) {
            GZIPInputStream gZIPInputStream = null;
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr), i2);
                try {
                    byte[] bArr2 = new byte[i2];
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

    public fe(byte b2, int i2, byte[] bArr) {
        this((short) 1, b2, i2, bArr);
    }

    public fe(short s, byte b2, int i2, byte[] bArr) {
        this.f376a = (short) 1;
        this.f376a = s;
        this.f374a = b2;
        this.f375a = i2;
        this.f41258b = bArr;
    }

    public static fe a(byte b2, int i2, byte[] bArr) {
        return new fe(b2, i2, bArr);
    }

    public static fe a(short s, byte b2, int i2, byte[] bArr) {
        return new fe(s, b2, i2, bArr);
    }

    public static fe a(byte[] bArr) {
        if (m299a(bArr)) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
            order.getInt();
            short s = order.getShort();
            byte b2 = order.get();
            int i2 = order.getInt();
            byte[] bArr2 = new byte[order.getInt()];
            order.get(bArr2);
            return a(s, b2, i2, bArr2);
        }
        return a((byte) 0, bArr.length, bArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m299a(byte[] bArr) {
        byte[] bArr2 = f41257a;
        return a(bArr2, bArr, bArr2.length);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i2) {
        if (bArr.length < i2 || bArr2.length < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }
}
