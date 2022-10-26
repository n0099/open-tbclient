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
    public fq f377a;

    /* renamed from: a  reason: collision with other field name */
    public fs f378a;

    /* renamed from: a  reason: collision with other field name */
    public InputStream f379a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f380a;

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f381a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f382a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f383a;
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
        this.f380a = ByteBuffer.allocate(2048);
        this.b = ByteBuffer.allocate(4);
        this.f381a = new Adler32();
        this.f379a = new BufferedInputStream(inputStream);
        this.f378a = fsVar;
        this.f377a = new fq();
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
        this.f380a.clear();
        a(this.f380a, 8);
        short s = this.f380a.getShort(0);
        short s2 = this.f380a.getShort(2);
        if (s != -15618 || s2 != 5) {
            throw new IOException("Malformed Input");
        }
        int i2 = this.f380a.getInt(4);
        int position = this.f380a.position();
        if (i2 > 32768) {
            throw new IOException("Blob size too large");
        }
        if (i2 + 4 <= this.f380a.remaining()) {
            if (this.f380a.capacity() > 4096 && i2 < 2048) {
                allocate = ByteBuffer.allocate(2048);
                allocate.put(this.f380a.array(), 0, this.f380a.arrayOffset() + this.f380a.position());
            }
            a(this.f380a, i2);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            i = this.b.getInt();
            this.f381a.reset();
            this.f381a.update(this.f380a.array(), 0, this.f380a.position());
            if (i != ((int) this.f381a.getValue())) {
                byte[] bArr = this.f383a;
                if (bArr != null) {
                    com.xiaomi.push.service.bp.a(bArr, this.f380a.array(), true, position, i2);
                }
                return this.f380a;
            }
            com.xiaomi.channel.commonutils.logger.b.m89a("CRC = " + ((int) this.f381a.getValue()) + " and " + i);
            throw new IOException("Corrupted Blob bad CRC");
        }
        allocate = ByteBuffer.allocate(i2 + 2048);
        allocate.put(this.f380a.array(), 0, this.f380a.arrayOffset() + this.f380a.position());
        this.f380a = allocate;
        a(this.f380a, i2);
        this.b.clear();
        a(this.b, 4);
        this.b.position(0);
        i = this.b.getInt();
        this.f381a.reset();
        this.f381a.update(this.f380a.array(), 0, this.f380a.position());
        if (i != ((int) this.f381a.getValue())) {
        }
    }

    private void a(ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, byteBuffer, i) == null) {
            int position = byteBuffer.position();
            do {
                int read = this.f379a.read(byteBuffer.array(), position, i);
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
            this.f382a = false;
            fl m343a = m343a();
            if ("CONN".equals(m343a.m335a())) {
                dx.f a = dx.f.a(m343a.m339a());
                if (a.a()) {
                    this.f378a.a(a.a());
                    z = true;
                }
                if (a.c()) {
                    dx.b a2 = a.a();
                    fl flVar = new fl();
                    flVar.a("SYNC", "CONF");
                    flVar.a(a2.m303a(), (String) null);
                    this.f378a.a(flVar);
                }
                com.xiaomi.channel.commonutils.logger.b.m89a("[Slim] CONN: host = " + a.b());
            }
            if (!z) {
                com.xiaomi.channel.commonutils.logger.b.m89a("[Slim] Invalid CONN");
                throw new IOException("Invalid Connection");
            }
            this.f383a = this.f378a.a();
            while (!this.f382a) {
                fl m343a2 = m343a();
                this.f378a.c();
                short m337a = m343a2.m337a();
                if (m337a != 1) {
                    if (m337a != 2) {
                        if (m337a != 3) {
                            str = "[Slim] unknow blob type " + ((int) m343a2.m337a());
                            com.xiaomi.channel.commonutils.logger.b.m89a(str);
                        } else {
                            try {
                                this.f378a.b(this.f377a.a(m343a2.m339a(), this.f378a));
                            } catch (Exception e) {
                                e = e;
                                sb = new StringBuilder();
                                sb.append("[Slim] Parse packet from Blob chid=");
                                sb.append(m343a2.a());
                                sb.append("; Id=");
                                sb.append(m343a2.e());
                                sb.append(" failure:");
                                sb.append(e.getMessage());
                                str = sb.toString();
                                com.xiaomi.channel.commonutils.logger.b.m89a(str);
                            }
                        }
                    } else if ("SECMSG".equals(m343a2.m335a()) && ((m343a2.a() == 2 || m343a2.a() == 3) && TextUtils.isEmpty(m343a2.m341b()))) {
                        try {
                            this.f378a.b(this.f377a.a(m343a2.m340a(com.xiaomi.push.service.bg.a().a(Integer.valueOf(m343a2.a()).toString(), m343a2.g()).h), this.f378a));
                        } catch (Exception e2) {
                            e = e2;
                            sb = new StringBuilder();
                            sb.append("[Slim] Parse packet from Blob chid=");
                            sb.append(m343a2.a());
                            sb.append("; Id=");
                            sb.append(m343a2.e());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            com.xiaomi.channel.commonutils.logger.b.m89a(str);
                        }
                    } else if (m343a2.a() == 10) {
                        m343a2.b(10);
                        m343a2.f373a.f902a = w.a(this.a);
                        m343a2.f373a.f904b = bj.e(this.a);
                        m343a2.f373a.f901a = System.currentTimeMillis();
                        com.xiaomi.channel.commonutils.logger.b.c("rcv blob from chid 10");
                    }
                }
                this.f378a.a(m343a2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public fl m343a() {
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
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + frVar.m335a() + ";chid=" + frVar.a() + ";len=" + i + "}");
                return frVar;
            } catch (IOException e2) {
                e = e2;
                if (i == 0) {
                    i = this.f380a.position();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] array = this.f380a.array();
                if (i > 128) {
                    i = 128;
                }
                sb.append(ai.a(array, 0, i));
                sb.append("] Err:");
                sb.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.m89a(sb.toString());
                throw e;
            }
        }
        return (fl) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m344a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                c();
            } catch (IOException e) {
                if (!this.f382a) {
                    throw e;
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f382a = true;
        }
    }
}
