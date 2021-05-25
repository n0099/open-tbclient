package d.a.c.c.e.c.j;

import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import d.a.c.c.e.c.h;
import d.a.c.e.p.g;
import d.a.c.e.p.s;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f38366a;

    public static b f() {
        if (f38366a == null) {
            synchronized (b.class) {
                if (f38366a == null) {
                    f38366a = new b();
                }
            }
        }
        return f38366a;
    }

    public byte[] a(byte[] bArr, int i2, int i3) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i2, i3);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            g.a(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            d.a.c.e.m.a.d(byteArrayOutputStream);
            d.a.c.e.m.a.c(byteArrayInputStream);
        }
    }

    public SocketResponsedMessage b(int i2, byte[] bArr, SocketMessage socketMessage, SocketMessageTask socketMessageTask, boolean z) throws CoderException {
        SocketResponsedMessage newInstance;
        try {
            Class<? extends SocketResponsedMessage> responsedClass = socketMessageTask.getResponsedClass();
            try {
                newInstance = responsedClass.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception unused) {
                newInstance = responsedClass.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i2));
            }
            newInstance.setOrginalMessage(socketMessage);
            if (z) {
                try {
                    newInstance.onDecodeFailedInBackGround(i2, bArr, h.f38350c);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                newInstance.decodeInBackGround(i2, bArr);
            }
            return newInstance;
        } catch (Throwable th) {
            BdStatisticsManager.getInstance().error("im", socketMessage != null ? socketMessage.getClientLogID() : 0L, (String) null, "cmd", Integer.valueOf(i2), "byteslength", Integer.valueOf(bArr != null ? bArr.length : 0), "comment", th.getMessage());
            throw new CoderException(h.f38350c);
        }
    }

    public c c(byte[] bArr) throws CoderException {
        int f2 = a.f();
        if (bArr != null && bArr.length >= f2) {
            a a2 = a.a(bArr);
            if (a2 != null) {
                c cVar = new c();
                cVar.f38367a = a2;
                cVar.f38368b = bArr;
                cVar.f38369c = f2;
                cVar.f38370d = bArr.length - f2;
                return cVar;
            }
            throw new CoderException(h.f38349b);
        }
        throw new CoderException(h.f38349b);
    }

    public c d(c cVar) throws CoderException {
        a aVar;
        int i2;
        if (cVar != null && (aVar = cVar.f38367a) != null && cVar.f38368b != null) {
            if (aVar.d() && cVar.f38370d > 0) {
                if (d.a().b() != null) {
                    try {
                        byte[] a2 = s.a(d.a().b(), cVar.f38368b, cVar.f38369c, cVar.f38370d);
                        cVar.f38368b = a2;
                        cVar.f38369c = 0;
                        cVar.f38370d = a2.length;
                    } catch (Exception unused) {
                        throw new CoderException(h.f38355h);
                    }
                } else {
                    throw new CoderException(h.f38354g);
                }
            }
            if (aVar.c() && (i2 = cVar.f38370d) > 0) {
                try {
                    byte[] g2 = g(cVar.f38368b, cVar.f38369c, i2);
                    cVar.f38368b = g2;
                    cVar.f38369c = 0;
                    cVar.f38370d = g2.length;
                } catch (Exception unused2) {
                    throw new CoderException(h.f38353f);
                }
            }
            return cVar;
        }
        throw new CoderException(h.f38349b);
    }

    public byte[] e(SocketMessage socketMessage, int i2, boolean z, boolean z2) throws CoderException {
        boolean z3;
        if (socketMessage == null) {
            return null;
        }
        byte[] encodeInBackGround = socketMessage.encodeInBackGround();
        byte[] encodeExtraDataInBackGround = socketMessage.encodeExtraDataInBackGround();
        if (encodeExtraDataInBackGround != null) {
            ByteBuffer allocate = ByteBuffer.allocate(encodeInBackGround.length + encodeExtraDataInBackGround.length + a.f38357g);
            if (encodeExtraDataInBackGround.length <= Integer.MAX_VALUE) {
                allocate.putInt(encodeExtraDataInBackGround.length);
                allocate.put(encodeExtraDataInBackGround);
                allocate.put(encodeInBackGround);
                encodeInBackGround = allocate.array();
                z3 = true;
            } else {
                throw new CoderException(h.f38352e);
            }
        } else {
            z3 = false;
        }
        if (encodeInBackGround != null && z) {
            encodeInBackGround = a(encodeInBackGround, 0, encodeInBackGround.length);
        }
        if (encodeInBackGround != null && z2) {
            encodeInBackGround = s.c(d.a().b(), encodeInBackGround);
        }
        return a.i(z2, z, socketMessage.getCmd(), i2, encodeInBackGround, z3);
    }

    public byte[] g(byte[] bArr, int i2, int i3) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i2, i3);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            g.c(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            d.a.c.e.m.a.d(byteArrayOutputStream);
            d.a.c.e.m.a.c(byteArrayInputStream);
        }
    }
}
