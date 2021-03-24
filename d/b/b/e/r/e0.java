package d.b.b.e.r;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.android.internal.http.multipart.Part;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.WebSocketException;
import d.b.b.e.r.e;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes.dex */
public class e0 extends Thread {
    public static long t;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f42083e;

    /* renamed from: f  reason: collision with root package name */
    public final e.a f42084f;

    /* renamed from: g  reason: collision with root package name */
    public final d0 f42085g;

    /* renamed from: h  reason: collision with root package name */
    public final ByteBuffer f42086h;
    public final d i;
    public boolean j;
    public int k;
    public boolean l;
    public int m;
    public b n;
    public int o;
    public final f p;
    public int q;
    public long r;
    public long s;

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f42087a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f42088b;

        /* renamed from: c  reason: collision with root package name */
        public int f42089c;

        /* renamed from: d  reason: collision with root package name */
        public int f42090d;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f42091e;

        public b() {
        }
    }

    public e0(Handler handler, e.a aVar, d0 d0Var, String str) {
        super(str);
        this.j = false;
        this.l = false;
        this.p = new f();
        this.q = 0;
        this.r = 0L;
        this.s = 0L;
        this.f42083e = handler;
        this.f42084f = aVar;
        this.f42085g = d0Var;
        this.f42086h = ByteBuffer.allocateDirect(d0Var.b() + 14);
        this.i = new d(d0Var.c());
        this.n = null;
        this.k = 1;
    }

    public void a() {
        synchronized (e0.class) {
            t = 0L;
        }
    }

    public final boolean b() throws Exception {
        int i = this.k;
        if (i == 3 || i == 2) {
            return n();
        }
        if (i == 1) {
            return o();
        }
        if (i == 0) {
        }
        return false;
    }

    public long c() {
        long j;
        synchronized (e0.class) {
            j = t;
        }
        return j;
    }

    public void d(Object obj) {
        this.r = 0L;
        this.s = 0L;
        Message obtainMessage = this.f42083e.obtainMessage();
        obtainMessage.obj = obj;
        this.f42083e.sendMessage(obtainMessage);
    }

    public void e(byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis();
        this.s = currentTimeMillis;
        d(new k(bArr, this.r, currentTimeMillis));
    }

    public void f(int i, String str) {
        d(new m(i, str));
    }

    public void g(boolean z, Map<String, String> map) {
        d(new a0(z, map));
    }

    public void h(byte[] bArr) {
        d(new t(bArr));
    }

    public void i(byte[] bArr) {
        d(new u(bArr));
    }

    public void j(byte[] bArr) {
        d(new w(bArr));
    }

    public void k(String str) {
        d(new c0(str));
    }

    public final Map<String, String> l(byte[] bArr) throws UnsupportedEncodingException {
        String[] split;
        String str = new String(bArr, "UTF-8");
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(Part.CRLF)) {
            if (str2.length() > 0) {
                String[] split2 = str2.split(": ");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }

    public final Pair<Integer, String> m() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.f42086h.position() && this.f42086h.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        int i3 = i2;
        while (i3 < this.f42086h.position() && this.f42086h.get(i3) != 32) {
            i3++;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i2 + i4;
            if (i6 >= i3) {
                break;
            }
            i5 = (i5 * 10) + (this.f42086h.get(i6) - 48);
            i4++;
        }
        int i7 = i3 + 1;
        int i8 = i7;
        while (i8 < this.f42086h.position() && this.f42086h.get(i8) != 13) {
            i8++;
        }
        int i9 = i8 - i7;
        byte[] bArr = new byte[i9];
        this.f42086h.position(i7);
        this.f42086h.get(bArr, 0, i9);
        return new Pair<>(Integer.valueOf(i5), new String(bArr, "UTF-8"));
    }

    /* JADX WARN: Removed duplicated region for block: B:186:0x035b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x035d A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean n() throws Exception {
        int i;
        int i2;
        String str;
        long j;
        b bVar = this.n;
        int i3 = 10;
        byte[] bArr = null;
        if (bVar == null) {
            if (this.f42086h.position() >= 2) {
                byte b2 = this.f42086h.get(0);
                boolean z = (b2 & ByteCompanionObject.MIN_VALUE) != 0;
                int i4 = (b2 & 112) >> 4;
                int i5 = b2 & 15;
                byte b3 = this.f42086h.get(1);
                boolean z2 = (b3 & ByteCompanionObject.MIN_VALUE) != 0;
                int i6 = b3 & ByteCompanionObject.MAX_VALUE;
                if (i4 == 0) {
                    if (!z2) {
                        if (i5 > 7) {
                            if (!z) {
                                throw new WebSocketException("fragmented control frame");
                            }
                            if (i6 > 125) {
                                throw new WebSocketException("control frame with payload length > 125 octets");
                            }
                            if (i5 != 8 && i5 != 9 && i5 != 10) {
                                throw new WebSocketException("control frame using reserved opcode " + i5);
                            } else if (i5 == 8 && i6 == 1) {
                                throw new WebSocketException("received close control frame with payload len 1");
                            }
                        } else if (i5 != 0 && i5 != 1 && i5 != 2) {
                            throw new WebSocketException("data frame using reserved opcode " + i5);
                        } else if (!this.l && i5 == 0) {
                            throw new WebSocketException("received continuation data frame outside fragmented message");
                        } else {
                            if (this.l && i5 != 0) {
                                throw new WebSocketException("received non-continuation data frame while inside fragmented message");
                            }
                        }
                        if (i6 < 126) {
                            i3 = 2;
                        } else if (i6 == 126) {
                            i3 = 4;
                        } else if (i6 != 127) {
                            throw new Exception("BdLogic error");
                        }
                        if (this.f42086h.position() >= i3) {
                            if (i6 == 126) {
                                j = ((this.f42086h.get(2) & 255) << 8) | (this.f42086h.get(3) & 255);
                                if (j < 126) {
                                    throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                                }
                            } else if (i6 != 127) {
                                j = i6;
                            } else if ((this.f42086h.get(2) & ByteCompanionObject.MIN_VALUE) == 0) {
                                j = (this.f42086h.get(9) & 255) | ((this.f42086h.get(2) & 255) << 56) | ((this.f42086h.get(3) & 255) << 48) | ((this.f42086h.get(4) & 255) << 40) | ((this.f42086h.get(5) & 255) << 32) | ((this.f42086h.get(6) & 255) << 24) | ((this.f42086h.get(7) & 255) << 16) | ((this.f42086h.get(8) & 255) << 8);
                                if (j < 65536) {
                                    throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                                }
                            } else {
                                throw new WebSocketException("invalid data frame length (> 2^63)");
                            }
                            b bVar2 = new b();
                            this.n = bVar2;
                            bVar2.f42087a = i5;
                            bVar2.f42088b = z;
                            bVar2.f42090d = (int) j;
                            bVar2.f42089c = i3;
                            int position = this.f42086h.position();
                            b bVar3 = this.n;
                            bVar3.f42091e = new byte[bVar3.f42089c];
                            this.f42086h.position(0);
                            ByteBuffer byteBuffer = this.f42086h;
                            b bVar4 = this.n;
                            byteBuffer.get(bVar4.f42091e, 0, bVar4.f42089c);
                            this.f42086h.position(this.n.f42089c);
                            this.f42086h.limit(position);
                            this.f42086h.compact();
                            return this.n.f42090d == 0 || this.f42086h.position() >= this.n.f42090d;
                        }
                        return false;
                    }
                    throw new WebSocketException("masked server frame");
                }
                throw new WebSocketException("RSV != 0 and no extension negotiated");
            }
            return false;
        }
        int i7 = this.o;
        int i8 = bVar.f42090d;
        if (i7 >= i8) {
            int i9 = bVar.f42087a;
            if (i9 <= 7) {
                if (this.l) {
                    i = 1;
                } else {
                    i = 1;
                    this.l = true;
                    this.m = i9;
                    if (i9 == 1 && this.f42085g.h()) {
                        this.p.b();
                    }
                }
                if (this.m == i && this.f42085g.h() && !this.p.c(this.i.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.n.f42088b) {
                    int i10 = this.m;
                    if (i10 == 1) {
                        if (this.f42085g.h() && !this.p.a()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.f42085g.d()) {
                            j(this.i.toByteArray());
                        } else {
                            k(new String(this.i.toByteArray(), "UTF-8"));
                        }
                    } else if (i10 == 2) {
                        e(this.i.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    i2 = 0;
                    this.l = false;
                    this.i.reset();
                    this.n = null;
                    this.o = i2;
                    return this.f42086h.position() <= 0;
                }
            } else if (i9 == 8) {
                int i11 = 1005;
                if (i8 >= 2) {
                    byte[] bArr2 = bVar.f42091e;
                    i11 = ((bArr2[0] & 255) * 256) + (bArr2[1] & 255);
                    if (i11 >= 1000 && ((i11 < 1000 || i11 > 2999 || i11 == 1000 || i11 == 1001 || i11 == 1002 || i11 == 1003 || i11 == 1007 || i11 == 1008 || i11 == 1009 || i11 == 1010 || i11 == 1011) && i11 < 5000)) {
                        b bVar5 = this.n;
                        int i12 = bVar5.f42090d;
                        if (i12 > 2) {
                            byte[] bArr3 = new byte[i12 - 2];
                            System.arraycopy(bVar5.f42091e, 2, bArr3, 0, i12 - 2);
                            f fVar = new f();
                            fVar.c(bArr3);
                            if (fVar.a()) {
                                str = new String(bArr3, "UTF-8");
                                f(i11, str);
                            } else {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                        }
                    } else {
                        throw new WebSocketException("invalid close code " + i11);
                    }
                }
                str = null;
                f(i11, str);
            } else if (i9 == 9) {
                h(this.i.toByteArray());
            } else if (i9 == 10) {
                i(this.i.toByteArray());
            } else {
                throw new Exception("BdLogic error");
            }
            i2 = 0;
            this.n = null;
            this.o = i2;
            if (this.f42086h.position() <= 0) {
            }
        } else {
            int position2 = this.f42086h.position();
            int i13 = this.n.f42090d;
            int i14 = this.o;
            if (i13 - i14 < position2) {
                position2 = i13 - i14;
            }
            int position3 = this.f42086h.position();
            if (this.n.f42090d > 0) {
                bArr = new byte[position2];
                this.f42086h.position(0);
                this.f42086h.get(bArr, 0, position2);
            }
            this.f42086h.position(position2);
            this.f42086h.limit(position3);
            this.f42086h.compact();
            if (bArr != null) {
                this.i.write(bArr);
            }
            int i15 = this.o + position2;
            this.o = i15;
            return i15 >= this.n.f42090d;
        }
    }

    public final boolean o() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        int position = this.f42086h.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.f42086h.get(position + 0) == 13 && this.f42086h.get(position + 1) == 10 && this.f42086h.get(position + 2) == 13 && this.f42086h.get(position + 3) == 10) {
                int position2 = this.f42086h.position();
                Map<String, String> map = null;
                if (this.f42086h.get(0) == 72 && this.f42086h.get(1) == 84 && this.f42086h.get(2) == 84 && this.f42086h.get(3) == 80) {
                    Pair<Integer, String> m = m();
                    if (((Integer) m.first).intValue() >= 300) {
                        d(new z(((Integer) m.first).intValue(), (String) m.second));
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (position > 0) {
                        this.f42086h.position(0);
                        byte[] bArr = new byte[position];
                        this.f42086h.get(bArr);
                        map = l(bArr);
                    }
                } else {
                    z2 = false;
                }
                this.f42086h.position(position + 4);
                this.f42086h.limit(position2);
                this.f42086h.compact();
                if (this.q < this.f42084f.b() && map.size() == 0) {
                    this.q++;
                    return true;
                }
                this.q = 0;
                if (!z2) {
                    z = this.f42086h.position() > 0;
                    this.k = 3;
                } else {
                    this.k = 0;
                    this.j = true;
                    z = true;
                }
                g(!z2, map);
            } else {
                position--;
            }
        }
        return z;
    }

    public void p() {
        this.j = true;
        try {
            this.f42084f.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    this.f42086h.clear();
                    do {
                        try {
                            int read = this.f42084f.read(this.f42086h);
                            if (read > 0) {
                                if (this.r <= 0) {
                                    this.r = System.currentTimeMillis();
                                }
                                synchronized (e0.class) {
                                    t += read;
                                }
                            }
                            if (read > 0) {
                                while (b()) {
                                }
                            } else if (read < 0) {
                                d(new n(new SocketException("len < 0")));
                                this.j = true;
                            }
                        } catch (SocketTimeoutException unused) {
                            if (!d.b.b.e.p.j.z()) {
                                this.j = true;
                                d(new n(new SocketException("not net")));
                                return;
                            }
                        }
                    } while (!this.j);
                } finally {
                    this.j = true;
                }
            } catch (SocketException e2) {
                d(new n(e2));
            }
        } catch (WebSocketException e3) {
            d(new v(e3));
        } catch (Exception e4) {
            d(new p(e4));
        }
    }
}
