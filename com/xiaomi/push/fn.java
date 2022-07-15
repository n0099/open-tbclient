package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.dx;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;
/* loaded from: classes8.dex */
public class fn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public fq f1096a;

    /* renamed from: a  reason: collision with other field name */
    public fs f1097a;

    /* renamed from: a  reason: collision with other field name */
    public InputStream f1098a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f1099a;

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f1100a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f1101a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f1102a;
    public ByteBuffer b;

    public fn(InputStream inputStream, fs fsVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, fsVar, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1099a = ByteBuffer.allocate(2048);
        this.b = ByteBuffer.allocate(4);
        this.f1100a = new Adler32();
        this.f1098a = new BufferedInputStream(inputStream);
        this.f1097a = fsVar;
        this.f1096a = new fq();
        this.a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ByteBuffer a() {
        InterceptResult invokeV;
        ByteBuffer allocate;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65537, this)) != null) {
            return (ByteBuffer) invokeV.objValue;
        }
        this.f1099a.clear();
        a(this.f1099a, 8);
        short s = this.f1099a.getShort(0);
        short s2 = this.f1099a.getShort(2);
        if (s != -15618 || s2 != 5) {
            throw new IOException("Malformed Input");
        }
        int i2 = this.f1099a.getInt(4);
        int position = this.f1099a.position();
        if (i2 > 32768) {
            throw new IOException("Blob size too large");
        }
        if (i2 + 4 <= this.f1099a.remaining()) {
            if (this.f1099a.capacity() > 4096 && i2 < 2048) {
                allocate = ByteBuffer.allocate(2048);
                allocate.put(this.f1099a.array(), 0, this.f1099a.arrayOffset() + this.f1099a.position());
            }
            a(this.f1099a, i2);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            i = this.b.getInt();
            this.f1100a.reset();
            this.f1100a.update(this.f1099a.array(), 0, this.f1099a.position());
            if (i != ((int) this.f1100a.getValue())) {
                byte[] bArr = this.f1102a;
                if (bArr != null) {
                    com.xiaomi.push.service.bp.a(bArr, this.f1099a.array(), true, position, i2);
                }
                return this.f1099a;
            }
            com.xiaomi.channel.commonutils.logger.b.m1027a("CRC = " + ((int) this.f1100a.getValue()) + " and " + i);
            throw new IOException("Corrupted Blob bad CRC");
        }
        allocate = ByteBuffer.allocate(i2 + 2048);
        allocate.put(this.f1099a.array(), 0, this.f1099a.arrayOffset() + this.f1099a.position());
        this.f1099a = allocate;
        a(this.f1099a, i2);
        this.b.clear();
        a(this.b, 4);
        this.b.position(0);
        i = this.b.getInt();
        this.f1100a.reset();
        this.f1100a.update(this.f1099a.array(), 0, this.f1099a.position());
        if (i != ((int) this.f1100a.getValue())) {
        }
    }

    private void a(ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, byteBuffer, i) == null) {
            int position = byteBuffer.position();
            do {
                int read = this.f1098a.read(byteBuffer.array(), position, i);
                if (read == -1) {
                    throw new EOFException();
                }
                i -= read;
                position += read;
            } while (i > 0);
            byteBuffer.position(position);
        }
    }

    private void c() {
        String str;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            boolean z = false;
            this.f1101a = false;
            fl m1281a = m1281a();
            if ("CONN".equals(m1281a.m1273a())) {
                dx.f a = dx.f.a(m1281a.m1277a());
                if (a.a()) {
                    this.f1097a.a(a.a());
                    z = true;
                }
                if (a.c()) {
                    dx.b a2 = a.a();
                    fl flVar = new fl();
                    flVar.a("SYNC", "CONF");
                    flVar.a(a2.m1241a(), (String) null);
                    this.f1097a.a(flVar);
                }
                com.xiaomi.channel.commonutils.logger.b.m1027a("[Slim] CONN: host = " + a.b());
            }
            if (!z) {
                com.xiaomi.channel.commonutils.logger.b.m1027a("[Slim] Invalid CONN");
                throw new IOException("Invalid Connection");
            }
            this.f1102a = this.f1097a.a();
            while (!this.f1101a) {
                fl m1281a2 = m1281a();
                this.f1097a.c();
                short m1275a = m1281a2.m1275a();
                if (m1275a != 1) {
                    if (m1275a != 2) {
                        if (m1275a != 3) {
                            str = "[Slim] unknow blob type " + ((int) m1281a2.m1275a());
                            com.xiaomi.channel.commonutils.logger.b.m1027a(str);
                        } else {
                            try {
                                this.f1097a.b(this.f1096a.a(m1281a2.m1277a(), this.f1097a));
                            } catch (Exception e) {
                                e = e;
                                sb = new StringBuilder();
                                sb.append("[Slim] Parse packet from Blob chid=");
                                sb.append(m1281a2.a());
                                sb.append("; Id=");
                                sb.append(m1281a2.e());
                                sb.append(" failure:");
                                sb.append(e.getMessage());
                                str = sb.toString();
                                com.xiaomi.channel.commonutils.logger.b.m1027a(str);
                            }
                        }
                    } else if ("SECMSG".equals(m1281a2.m1273a()) && ((m1281a2.a() == 2 || m1281a2.a() == 3) && TextUtils.isEmpty(m1281a2.m1279b()))) {
                        try {
                            this.f1097a.b(this.f1096a.a(m1281a2.m1278a(com.xiaomi.push.service.bg.a().a(Integer.valueOf(m1281a2.a()).toString(), m1281a2.g()).h), this.f1097a));
                        } catch (Exception e2) {
                            e = e2;
                            sb = new StringBuilder();
                            sb.append("[Slim] Parse packet from Blob chid=");
                            sb.append(m1281a2.a());
                            sb.append("; Id=");
                            sb.append(m1281a2.e());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            com.xiaomi.channel.commonutils.logger.b.m1027a(str);
                        }
                    } else if (m1281a2.a() == 10) {
                        m1281a2.b(10);
                        m1281a2.f1092a.f1621a = w.a(this.a);
                        m1281a2.f1092a.f1623b = bj.e(this.a);
                        m1281a2.f1092a.f1620a = System.currentTimeMillis();
                        com.xiaomi.channel.commonutils.logger.b.c("rcv blob from chid 10");
                    }
                }
                this.f1097a.a(m1281a2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public fl m1281a() {
        InterceptResult invokeV;
        int i;
        ByteBuffer a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                a = a();
                i = a.position();
            } catch (IOException e) {
                e = e;
                i = 0;
            }
            try {
                a.flip();
                a.position(8);
                fl frVar = i == 8 ? new fr() : fl.a(a.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + frVar.m1273a() + ";chid=" + frVar.a() + ";len=" + i + "}");
                return frVar;
            } catch (IOException e2) {
                e = e2;
                if (i == 0) {
                    i = this.f1099a.position();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] array = this.f1099a.array();
                if (i > 128) {
                    i = 128;
                }
                sb.append(ai.a(array, 0, i));
                sb.append("] Err:");
                sb.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.m1027a(sb.toString());
                throw e;
            }
        }
        return (fl) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1282a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                c();
            } catch (IOException e) {
                if (!this.f1101a) {
                    throw e;
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f1101a = true;
        }
    }
}
