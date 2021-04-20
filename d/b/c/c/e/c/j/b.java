package d.b.c.c.e.c.j;

import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import d.b.c.c.e.c.h;
import d.b.c.e.p.g;
import d.b.c.e.p.s;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f42028a;

    public static b f() {
        if (f42028a == null) {
            synchronized (b.class) {
                if (f42028a == null) {
                    f42028a = new b();
                }
            }
        }
        return f42028a;
    }

    public byte[] a(byte[] bArr, int i, int i2) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            g.a(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            d.b.c.e.m.a.d(byteArrayOutputStream);
            d.b.c.e.m.a.c(byteArrayInputStream);
        }
    }

    public SocketResponsedMessage b(int i, byte[] bArr, SocketMessage socketMessage, SocketMessageTask socketMessageTask, boolean z) throws CoderException {
        SocketResponsedMessage newInstance;
        try {
            Class<? extends SocketResponsedMessage> responsedClass = socketMessageTask.getResponsedClass();
            try {
                newInstance = responsedClass.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception unused) {
                newInstance = responsedClass.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i));
            }
            newInstance.setOrginalMessage(socketMessage);
            if (z) {
                try {
                    newInstance.onDecodeFailedInBackGround(i, bArr, h.f42014c);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                newInstance.decodeInBackGround(i, bArr);
            }
            return newInstance;
        } catch (Throwable th) {
            BdStatisticsManager.getInstance().error("im", socketMessage != null ? socketMessage.getClientLogID() : 0L, (String) null, "cmd", Integer.valueOf(i), "byteslength", Integer.valueOf(bArr != null ? bArr.length : 0), "comment", th.getMessage());
            throw new CoderException(h.f42014c);
        }
    }

    public c c(byte[] bArr) throws CoderException {
        int f2 = a.f();
        if (bArr != null && bArr.length >= f2) {
            a a2 = a.a(bArr);
            if (a2 != null) {
                c cVar = new c();
                cVar.f42029a = a2;
                cVar.f42030b = bArr;
                cVar.f42031c = f2;
                cVar.f42032d = bArr.length - f2;
                return cVar;
            }
            throw new CoderException(h.f42013b);
        }
        throw new CoderException(h.f42013b);
    }

    public c d(c cVar) throws CoderException {
        a aVar;
        int i;
        if (cVar != null && (aVar = cVar.f42029a) != null && cVar.f42030b != null) {
            if (aVar.d() && cVar.f42032d > 0) {
                if (d.a().b() != null) {
                    try {
                        byte[] a2 = s.a(d.a().b(), cVar.f42030b, cVar.f42031c, cVar.f42032d);
                        cVar.f42030b = a2;
                        cVar.f42031c = 0;
                        cVar.f42032d = a2.length;
                    } catch (Exception unused) {
                        throw new CoderException(h.f42019h);
                    }
                } else {
                    throw new CoderException(h.f42018g);
                }
            }
            if (aVar.c() && (i = cVar.f42032d) > 0) {
                try {
                    byte[] g2 = g(cVar.f42030b, cVar.f42031c, i);
                    cVar.f42030b = g2;
                    cVar.f42031c = 0;
                    cVar.f42032d = g2.length;
                } catch (Exception unused2) {
                    throw new CoderException(h.f42017f);
                }
            }
            return cVar;
        }
        throw new CoderException(h.f42013b);
    }

    public byte[] e(SocketMessage socketMessage, int i, boolean z, boolean z2) throws CoderException {
        boolean z3;
        if (socketMessage == null) {
            return null;
        }
        byte[] encodeInBackGround = socketMessage.encodeInBackGround();
        byte[] encodeExtraDataInBackGround = socketMessage.encodeExtraDataInBackGround();
        if (encodeExtraDataInBackGround != null) {
            ByteBuffer allocate = ByteBuffer.allocate(encodeInBackGround.length + encodeExtraDataInBackGround.length + a.f42020g);
            if (encodeExtraDataInBackGround.length <= Integer.MAX_VALUE) {
                allocate.putInt(encodeExtraDataInBackGround.length);
                allocate.put(encodeExtraDataInBackGround);
                allocate.put(encodeInBackGround);
                encodeInBackGround = allocate.array();
                z3 = true;
            } else {
                throw new CoderException(h.f42016e);
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
        return a.i(z2, z, socketMessage.getCmd(), i, encodeInBackGround, z3);
    }

    public byte[] g(byte[] bArr, int i, int i2) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            g.c(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            d.b.c.e.m.a.d(byteArrayOutputStream);
            d.b.c.e.m.a.c(byteArrayInputStream);
        }
    }
}
