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
    public fq f400a;

    /* renamed from: a  reason: collision with other field name */
    public fs f401a;

    /* renamed from: a  reason: collision with other field name */
    public InputStream f402a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f403a;

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f404a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f405a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f406a;
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
        this.f403a = ByteBuffer.allocate(2048);
        this.b = ByteBuffer.allocate(4);
        this.f404a = new Adler32();
        this.f402a = new BufferedInputStream(inputStream);
        this.f401a = fsVar;
        this.f400a = new fq();
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
        this.f403a.clear();
        a(this.f403a, 8);
        short s = this.f403a.getShort(0);
        short s2 = this.f403a.getShort(2);
        if (s != -15618 || s2 != 5) {
            throw new IOException("Malformed Input");
        }
        int i2 = this.f403a.getInt(4);
        int position = this.f403a.position();
        if (i2 > 32768) {
            throw new IOException("Blob size too large");
        }
        if (i2 + 4 <= this.f403a.remaining()) {
            if (this.f403a.capacity() > 4096 && i2 < 2048) {
                allocate = ByteBuffer.allocate(2048);
                allocate.put(this.f403a.array(), 0, this.f403a.arrayOffset() + this.f403a.position());
            }
            a(this.f403a, i2);
            this.b.clear();
            a(this.b, 4);
            this.b.position(0);
            i = this.b.getInt();
            this.f404a.reset();
            this.f404a.update(this.f403a.array(), 0, this.f403a.position());
            if (i != ((int) this.f404a.getValue())) {
                byte[] bArr = this.f406a;
                if (bArr != null) {
                    com.xiaomi.push.service.bp.a(bArr, this.f403a.array(), true, position, i2);
                }
                return this.f403a;
            }
            com.xiaomi.channel.commonutils.logger.b.m103a("CRC = " + ((int) this.f404a.getValue()) + " and " + i);
            throw new IOException("Corrupted Blob bad CRC");
        }
        allocate = ByteBuffer.allocate(i2 + 2048);
        allocate.put(this.f403a.array(), 0, this.f403a.arrayOffset() + this.f403a.position());
        this.f403a = allocate;
        a(this.f403a, i2);
        this.b.clear();
        a(this.b, 4);
        this.b.position(0);
        i = this.b.getInt();
        this.f404a.reset();
        this.f404a.update(this.f403a.array(), 0, this.f403a.position());
        if (i != ((int) this.f404a.getValue())) {
        }
    }

    private void a(ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, byteBuffer, i) == null) {
            int position = byteBuffer.position();
            do {
                int read = this.f402a.read(byteBuffer.array(), position, i);
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
            this.f405a = false;
            fl m412a = m412a();
            if ("CONN".equals(m412a.m404a())) {
                dx.f a = dx.f.a(m412a.m408a());
                if (a.m343a()) {
                    this.f401a.a(a.m342a());
                    z = true;
                }
                if (a.c()) {
                    dx.b m341a = a.m341a();
                    fl flVar = new fl();
                    flVar.a("SYNC", "CONF");
                    flVar.a(m341a.m368a(), (String) null);
                    this.f401a.a(flVar);
                }
                com.xiaomi.channel.commonutils.logger.b.m103a("[Slim] CONN: host = " + a.m344b());
            }
            if (!z) {
                com.xiaomi.channel.commonutils.logger.b.m103a("[Slim] Invalid CONN");
                throw new IOException("Invalid Connection");
            }
            this.f406a = this.f401a.m419a();
            while (!this.f405a) {
                fl m412a2 = m412a();
                this.f401a.c();
                short m406a = m412a2.m406a();
                if (m406a != 1) {
                    if (m406a != 2) {
                        if (m406a != 3) {
                            str = "[Slim] unknow blob type " + ((int) m412a2.m406a());
                            com.xiaomi.channel.commonutils.logger.b.m103a(str);
                        } else {
                            try {
                                this.f401a.b(this.f400a.a(m412a2.m408a(), this.f401a));
                            } catch (Exception e) {
                                e = e;
                                sb = new StringBuilder();
                                sb.append("[Slim] Parse packet from Blob chid=");
                                sb.append(m412a2.a());
                                sb.append("; Id=");
                                sb.append(m412a2.e());
                                sb.append(" failure:");
                                sb.append(e.getMessage());
                                str = sb.toString();
                                com.xiaomi.channel.commonutils.logger.b.m103a(str);
                            }
                        }
                    } else if ("SECMSG".equals(m412a2.m404a()) && ((m412a2.a() == 2 || m412a2.a() == 3) && TextUtils.isEmpty(m412a2.m410b()))) {
                        try {
                            this.f401a.b(this.f400a.a(m412a2.m409a(com.xiaomi.push.service.bg.a().a(Integer.valueOf(m412a2.a()).toString(), m412a2.g()).h), this.f401a));
                        } catch (Exception e2) {
                            e = e2;
                            sb = new StringBuilder();
                            sb.append("[Slim] Parse packet from Blob chid=");
                            sb.append(m412a2.a());
                            sb.append("; Id=");
                            sb.append(m412a2.e());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            com.xiaomi.channel.commonutils.logger.b.m103a(str);
                        }
                    } else if (m412a2.a() == 10) {
                        m412a2.b(10);
                        m412a2.f396a.f925a = w.a(this.a);
                        m412a2.f396a.f927b = bj.e(this.a);
                        m412a2.f396a.f924a = System.currentTimeMillis();
                        com.xiaomi.channel.commonutils.logger.b.c("rcv blob from chid 10");
                    }
                }
                this.f401a.a(m412a2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public fl m412a() {
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
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + frVar.m404a() + ";chid=" + frVar.a() + ";len=" + i + "}");
                return frVar;
            } catch (IOException e2) {
                e = e2;
                if (i == 0) {
                    i = this.f403a.position();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] array = this.f403a.array();
                if (i > 128) {
                    i = 128;
                }
                sb.append(ai.a(array, 0, i));
                sb.append("] Err:");
                sb.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.m103a(sb.toString());
                throw e;
            }
        }
        return (fl) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m413a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                c();
            } catch (IOException e) {
                if (!this.f405a) {
                    throw e;
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f405a = true;
        }
    }
}
