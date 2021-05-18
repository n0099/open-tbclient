package d.a.c.e.r;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.android.internal.http.multipart.Part;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.WebSocketException;
import d.a.c.e.r.e;
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
    public final Handler f39280e;

    /* renamed from: f  reason: collision with root package name */
    public final e.a f39281f;

    /* renamed from: g  reason: collision with root package name */
    public final d0 f39282g;

    /* renamed from: h  reason: collision with root package name */
    public final ByteBuffer f39283h;

    /* renamed from: i  reason: collision with root package name */
    public final d f39284i;
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
        public int f39285a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f39286b;

        /* renamed from: c  reason: collision with root package name */
        public int f39287c;

        /* renamed from: d  reason: collision with root package name */
        public int f39288d;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f39289e;

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
        this.f39280e = handler;
        this.f39281f = aVar;
        this.f39282g = d0Var;
        this.f39283h = ByteBuffer.allocateDirect(d0Var.b() + 14);
        this.f39284i = new d(d0Var.c());
        this.n = null;
        this.k = 1;
    }

    public void a() {
        synchronized (e0.class) {
            t = 0L;
        }
    }

    public final boolean b() throws Exception {
        int i2 = this.k;
        if (i2 == 3 || i2 == 2) {
            return n();
        }
        if (i2 == 1) {
            return o();
        }
        if (i2 == 0) {
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
        Message obtainMessage = this.f39280e.obtainMessage();
        obtainMessage.obj = obj;
        this.f39280e.sendMessage(obtainMessage);
    }

    public void e(byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis();
        this.s = currentTimeMillis;
        d(new k(bArr, this.r, currentTimeMillis));
    }

    public void f(int i2, String str) {
        d(new m(i2, str));
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
        int i2 = 4;
        while (i2 < this.f39283h.position() && this.f39283h.get(i2) != 32) {
            i2++;
        }
        int i3 = i2 + 1;
        int i4 = i3;
        while (i4 < this.f39283h.position() && this.f39283h.get(i4) != 32) {
            i4++;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i3 + i5;
            if (i7 >= i4) {
                break;
            }
            i6 = (i6 * 10) + (this.f39283h.get(i7) - 48);
            i5++;
        }
        int i8 = i4 + 1;
        int i9 = i8;
        while (i9 < this.f39283h.position() && this.f39283h.get(i9) != 13) {
            i9++;
        }
        int i10 = i9 - i8;
        byte[] bArr = new byte[i10];
        this.f39283h.position(i8);
        this.f39283h.get(bArr, 0, i10);
        return new Pair<>(Integer.valueOf(i6), new String(bArr, "UTF-8"));
    }

    /* JADX WARN: Removed duplicated region for block: B:186:0x035c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x035e A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean n() throws Exception {
        int i2;
        int i3;
        String str;
        long j;
        b bVar = this.n;
        int i4 = 10;
        byte[] bArr = null;
        if (bVar == null) {
            if (this.f39283h.position() >= 2) {
                byte b2 = this.f39283h.get(0);
                boolean z = (b2 & ByteCompanionObject.MIN_VALUE) != 0;
                int i5 = (b2 & 112) >> 4;
                int i6 = b2 & 15;
                byte b3 = this.f39283h.get(1);
                boolean z2 = (b3 & ByteCompanionObject.MIN_VALUE) != 0;
                int i7 = b3 & ByteCompanionObject.MAX_VALUE;
                if (i5 == 0) {
                    if (!z2) {
                        if (i6 > 7) {
                            if (!z) {
                                throw new WebSocketException("fragmented control frame");
                            }
                            if (i7 > 125) {
                                throw new WebSocketException("control frame with payload length > 125 octets");
                            }
                            if (i6 != 8 && i6 != 9 && i6 != 10) {
                                throw new WebSocketException("control frame using reserved opcode " + i6);
                            } else if (i6 == 8 && i7 == 1) {
                                throw new WebSocketException("received close control frame with payload len 1");
                            }
                        } else if (i6 != 0 && i6 != 1 && i6 != 2) {
                            throw new WebSocketException("data frame using reserved opcode " + i6);
                        } else if (!this.l && i6 == 0) {
                            throw new WebSocketException("received continuation data frame outside fragmented message");
                        } else {
                            if (this.l && i6 != 0) {
                                throw new WebSocketException("received non-continuation data frame while inside fragmented message");
                            }
                        }
                        if (i7 < 126) {
                            i4 = 2;
                        } else if (i7 == 126) {
                            i4 = 4;
                        } else if (i7 != 127) {
                            throw new Exception("BdLogic error");
                        }
                        if (this.f39283h.position() >= i4) {
                            if (i7 == 126) {
                                j = ((this.f39283h.get(2) & 255) << 8) | (this.f39283h.get(3) & 255);
                                if (j < 126) {
                                    throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                                }
                            } else if (i7 != 127) {
                                j = i7;
                            } else if ((this.f39283h.get(2) & ByteCompanionObject.MIN_VALUE) == 0) {
                                j = (this.f39283h.get(9) & 255) | ((this.f39283h.get(2) & 255) << 56) | ((this.f39283h.get(3) & 255) << 48) | ((this.f39283h.get(4) & 255) << 40) | ((this.f39283h.get(5) & 255) << 32) | ((this.f39283h.get(6) & 255) << 24) | ((this.f39283h.get(7) & 255) << 16) | ((this.f39283h.get(8) & 255) << 8);
                                if (j < 65536) {
                                    throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                                }
                            } else {
                                throw new WebSocketException("invalid data frame length (> 2^63)");
                            }
                            b bVar2 = new b();
                            this.n = bVar2;
                            bVar2.f39285a = i6;
                            bVar2.f39286b = z;
                            bVar2.f39288d = (int) j;
                            bVar2.f39287c = i4;
                            int position = this.f39283h.position();
                            b bVar3 = this.n;
                            bVar3.f39289e = new byte[bVar3.f39287c];
                            this.f39283h.position(0);
                            ByteBuffer byteBuffer = this.f39283h;
                            b bVar4 = this.n;
                            byteBuffer.get(bVar4.f39289e, 0, bVar4.f39287c);
                            this.f39283h.position(this.n.f39287c);
                            this.f39283h.limit(position);
                            this.f39283h.compact();
                            return this.n.f39288d == 0 || this.f39283h.position() >= this.n.f39288d;
                        }
                        return false;
                    }
                    throw new WebSocketException("masked server frame");
                }
                throw new WebSocketException("RSV != 0 and no extension negotiated");
            }
            return false;
        }
        int i8 = this.o;
        int i9 = bVar.f39288d;
        if (i8 >= i9) {
            int i10 = bVar.f39285a;
            if (i10 <= 7) {
                if (this.l) {
                    i2 = 1;
                } else {
                    i2 = 1;
                    this.l = true;
                    this.m = i10;
                    if (i10 == 1 && this.f39282g.h()) {
                        this.p.b();
                    }
                }
                if (this.m == i2 && this.f39282g.h() && !this.p.c(this.f39284i.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.n.f39286b) {
                    int i11 = this.m;
                    if (i11 == 1) {
                        if (this.f39282g.h() && !this.p.a()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.f39282g.d()) {
                            j(this.f39284i.toByteArray());
                        } else {
                            k(new String(this.f39284i.toByteArray(), "UTF-8"));
                        }
                    } else if (i11 == 2) {
                        e(this.f39284i.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    i3 = 0;
                    this.l = false;
                    this.f39284i.reset();
                    this.n = null;
                    this.o = i3;
                    return this.f39283h.position() <= 0;
                }
            } else if (i10 == 8) {
                int i12 = 1005;
                if (i9 >= 2) {
                    byte[] bArr2 = bVar.f39289e;
                    i12 = ((bArr2[0] & 255) * 256) + (bArr2[1] & 255);
                    if (i12 >= 1000 && ((i12 < 1000 || i12 > 2999 || i12 == 1000 || i12 == 1001 || i12 == 1002 || i12 == 1003 || i12 == 1007 || i12 == 1008 || i12 == 1009 || i12 == 1010 || i12 == 1011) && i12 < 5000)) {
                        b bVar5 = this.n;
                        int i13 = bVar5.f39288d;
                        if (i13 > 2) {
                            byte[] bArr3 = new byte[i13 - 2];
                            System.arraycopy(bVar5.f39289e, 2, bArr3, 0, i13 - 2);
                            f fVar = new f();
                            fVar.c(bArr3);
                            if (fVar.a()) {
                                str = new String(bArr3, "UTF-8");
                                f(i12, str);
                            } else {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                        }
                    } else {
                        throw new WebSocketException("invalid close code " + i12);
                    }
                }
                str = null;
                f(i12, str);
            } else if (i10 == 9) {
                h(this.f39284i.toByteArray());
            } else if (i10 == 10) {
                i(this.f39284i.toByteArray());
            } else {
                throw new Exception("BdLogic error");
            }
            i3 = 0;
            this.n = null;
            this.o = i3;
            if (this.f39283h.position() <= 0) {
            }
        } else {
            int position2 = this.f39283h.position();
            int i14 = this.n.f39288d;
            int i15 = this.o;
            if (i14 - i15 < position2) {
                position2 = i14 - i15;
            }
            int position3 = this.f39283h.position();
            if (this.n.f39288d > 0) {
                bArr = new byte[position2];
                this.f39283h.position(0);
                this.f39283h.get(bArr, 0, position2);
            }
            this.f39283h.position(position2);
            this.f39283h.limit(position3);
            this.f39283h.compact();
            if (bArr != null) {
                this.f39284i.write(bArr);
            }
            int i16 = this.o + position2;
            this.o = i16;
            return i16 >= this.n.f39288d;
        }
    }

    public final boolean o() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        int position = this.f39283h.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.f39283h.get(position + 0) == 13 && this.f39283h.get(position + 1) == 10 && this.f39283h.get(position + 2) == 13 && this.f39283h.get(position + 3) == 10) {
                int position2 = this.f39283h.position();
                Map<String, String> map = null;
                if (this.f39283h.get(0) == 72 && this.f39283h.get(1) == 84 && this.f39283h.get(2) == 84 && this.f39283h.get(3) == 80) {
                    Pair<Integer, String> m = m();
                    if (((Integer) m.first).intValue() >= 300) {
                        d(new z(((Integer) m.first).intValue(), (String) m.second));
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (position > 0) {
                        this.f39283h.position(0);
                        byte[] bArr = new byte[position];
                        this.f39283h.get(bArr);
                        map = l(bArr);
                    }
                } else {
                    z2 = false;
                }
                this.f39283h.position(position + 4);
                this.f39283h.limit(position2);
                this.f39283h.compact();
                if (this.q < this.f39281f.a() && map.size() == 0) {
                    this.q++;
                    return true;
                }
                this.q = 0;
                if (!z2) {
                    z = this.f39283h.position() > 0;
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
            this.f39281f.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    this.f39283h.clear();
                    do {
                        try {
                            int read = this.f39281f.read(this.f39283h);
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
                            if (!d.a.c.e.p.j.z()) {
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
