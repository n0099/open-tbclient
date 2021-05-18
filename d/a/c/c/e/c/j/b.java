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
    public static b f38702a;

    public static b f() {
        if (f38702a == null) {
            synchronized (b.class) {
                if (f38702a == null) {
                    f38702a = new b();
                }
            }
        }
        return f38702a;
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
                    newInstance.onDecodeFailedInBackGround(i2, bArr, h.f38686c);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                newInstance.decodeInBackGround(i2, bArr);
            }
            return newInstance;
        } catch (Throwable th) {
            BdStatisticsManager.getInstance().error("im", socketMessage != null ? socketMessage.getClientLogID() : 0L, (String) null, "cmd", Integer.valueOf(i2), "byteslength", Integer.valueOf(bArr != null ? bArr.length : 0), "comment", th.getMessage());
            throw new CoderException(h.f38686c);
        }
    }

    public c c(byte[] bArr) throws CoderException {
        int f2 = a.f();
        if (bArr != null && bArr.length >= f2) {
            a a2 = a.a(bArr);
            if (a2 != null) {
                c cVar = new c();
                cVar.f38703a = a2;
                cVar.f38704b = bArr;
                cVar.f38705c = f2;
                cVar.f38706d = bArr.length - f2;
                return cVar;
            }
            throw new CoderException(h.f38685b);
        }
        throw new CoderException(h.f38685b);
    }

    public c d(c cVar) throws CoderException {
        a aVar;
        int i2;
        if (cVar != null && (aVar = cVar.f38703a) != null && cVar.f38704b != null) {
            if (aVar.d() && cVar.f38706d > 0) {
                if (d.a().b() != null) {
                    try {
                        byte[] a2 = s.a(d.a().b(), cVar.f38704b, cVar.f38705c, cVar.f38706d);
                        cVar.f38704b = a2;
                        cVar.f38705c = 0;
                        cVar.f38706d = a2.length;
                    } catch (Exception unused) {
                        throw new CoderException(h.f38691h);
                    }
                } else {
                    throw new CoderException(h.f38690g);
                }
            }
            if (aVar.c() && (i2 = cVar.f38706d) > 0) {
                try {
                    byte[] g2 = g(cVar.f38704b, cVar.f38705c, i2);
                    cVar.f38704b = g2;
                    cVar.f38705c = 0;
                    cVar.f38706d = g2.length;
                } catch (Exception unused2) {
                    throw new CoderException(h.f38689f);
                }
            }
            return cVar;
        }
        throw new CoderException(h.f38685b);
    }

    public byte[] e(SocketMessage socketMessage, int i2, boolean z, boolean z2) throws CoderException {
        boolean z3;
        if (socketMessage == null) {
            return null;
        }
        byte[] encodeInBackGround = socketMessage.encodeInBackGround();
        byte[] encodeExtraDataInBackGround = socketMessage.encodeExtraDataInBackGround();
        if (encodeExtraDataInBackGround != null) {
            ByteBuffer allocate = ByteBuffer.allocate(encodeInBackGround.length + encodeExtraDataInBackGround.length + a.f38693g);
            if (encodeExtraDataInBackGround.length <= Integer.MAX_VALUE) {
                allocate.putInt(encodeExtraDataInBackGround.length);
                allocate.put(encodeExtraDataInBackGround);
                allocate.put(encodeInBackGround);
                encodeInBackGround = allocate.array();
                z3 = true;
            } else {
                throw new CoderException(h.f38688e);
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
