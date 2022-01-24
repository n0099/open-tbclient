package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.du;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;
/* loaded from: classes4.dex */
public class fc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ff a;

    /* renamed from: a  reason: collision with other field name */
    public fh f370a;

    /* renamed from: a  reason: collision with other field name */
    public InputStream f371a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f372a;

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f373a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f374a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f375a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f61119b;

    public fc(InputStream inputStream, fh fhVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, fhVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f372a = ByteBuffer.allocate(2048);
        this.f61119b = ByteBuffer.allocate(4);
        this.f373a = new Adler32();
        this.f371a = new BufferedInputStream(inputStream);
        this.f370a = fhVar;
        this.a = new ff();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ByteBuffer a() {
        InterceptResult invokeV;
        ByteBuffer allocate;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65537, this)) != null) {
            return (ByteBuffer) invokeV.objValue;
        }
        this.f372a.clear();
        a(this.f372a, 8);
        short s = this.f372a.getShort(0);
        short s2 = this.f372a.getShort(2);
        if (s != -15618 || s2 != 5) {
            throw new IOException("Malformed Input");
        }
        int i3 = this.f372a.getInt(4);
        int position = this.f372a.position();
        if (i3 > 32768) {
            throw new IOException("Blob size too large");
        }
        if (i3 + 4 <= this.f372a.remaining()) {
            if (this.f372a.capacity() > 4096 && i3 < 2048) {
                allocate = ByteBuffer.allocate(2048);
                allocate.put(this.f372a.array(), 0, this.f372a.arrayOffset() + this.f372a.position());
            }
            a(this.f372a, i3);
            this.f61119b.clear();
            a(this.f61119b, 4);
            this.f61119b.position(0);
            i2 = this.f61119b.getInt();
            this.f373a.reset();
            this.f373a.update(this.f372a.array(), 0, this.f372a.position());
            if (i2 != ((int) this.f373a.getValue())) {
                byte[] bArr = this.f375a;
                if (bArr != null) {
                    com.xiaomi.push.service.be.a(bArr, this.f372a.array(), true, position, i3);
                }
                return this.f372a;
            }
            com.xiaomi.channel.commonutils.logger.b.m134a("CRC = " + ((int) this.f373a.getValue()) + " and " + i2);
            throw new IOException("Corrupted Blob bad CRC");
        }
        allocate = ByteBuffer.allocate(i3 + 2048);
        allocate.put(this.f372a.array(), 0, this.f372a.arrayOffset() + this.f372a.position());
        this.f372a = allocate;
        a(this.f372a, i3);
        this.f61119b.clear();
        a(this.f61119b, 4);
        this.f61119b.position(0);
        i2 = this.f61119b.getInt();
        this.f373a.reset();
        this.f373a.update(this.f372a.array(), 0, this.f372a.position());
        if (i2 != ((int) this.f373a.getValue())) {
        }
    }

    private void a(ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, byteBuffer, i2) == null) {
            int position = byteBuffer.position();
            do {
                int read = this.f371a.read(byteBuffer.array(), position, i2);
                if (read == -1) {
                    throw new EOFException();
                }
                i2 -= read;
                position += read;
            } while (i2 > 0);
            byteBuffer.position(position);
        }
    }

    private void c() {
        String str;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            boolean z = false;
            this.f374a = false;
            fa m374a = m374a();
            if ("CONN".equals(m374a.m366a())) {
                du.f a = du.f.a(m374a.m370a());
                if (a.a()) {
                    this.f370a.a(a.a());
                    z = true;
                }
                if (a.c()) {
                    du.b a2 = a.a();
                    fa faVar = new fa();
                    faVar.a("SYNC", "CONF");
                    faVar.a(a2.m345a(), (String) null);
                    this.f370a.a(faVar);
                }
                com.xiaomi.channel.commonutils.logger.b.m134a("[Slim] CONN: host = " + a.b());
            }
            if (!z) {
                com.xiaomi.channel.commonutils.logger.b.m134a("[Slim] Invalid CONN");
                throw new IOException("Invalid Connection");
            }
            this.f375a = this.f370a.a();
            while (!this.f374a) {
                fa m374a2 = m374a();
                this.f370a.c();
                short m368a = m374a2.m368a();
                if (m368a != 1) {
                    if (m368a != 2) {
                        if (m368a != 3) {
                            str = "[Slim] unknow blob type " + ((int) m374a2.m368a());
                            com.xiaomi.channel.commonutils.logger.b.m134a(str);
                        } else {
                            try {
                                this.f370a.b(this.a.a(m374a2.m370a(), this.f370a));
                            } catch (Exception e2) {
                                e = e2;
                                sb = new StringBuilder();
                                sb.append("[Slim] Parse packet from Blob chid=");
                                sb.append(m374a2.a());
                                sb.append("; Id=");
                                sb.append(m374a2.e());
                                sb.append(" failure:");
                                sb.append(e.getMessage());
                                str = sb.toString();
                                com.xiaomi.channel.commonutils.logger.b.m134a(str);
                            }
                        }
                    } else if ("SECMSG".equals(m374a2.m366a()) && ((m374a2.a() == 2 || m374a2.a() == 3) && TextUtils.isEmpty(m374a2.m372b()))) {
                        try {
                            this.f370a.b(this.a.a(m374a2.m371a(com.xiaomi.push.service.av.a().a(Integer.valueOf(m374a2.a()).toString(), m374a2.g()).f61469h), this.f370a));
                        } catch (Exception e3) {
                            e = e3;
                            sb = new StringBuilder();
                            sb.append("[Slim] Parse packet from Blob chid=");
                            sb.append(m374a2.a());
                            sb.append("; Id=");
                            sb.append(m374a2.e());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            com.xiaomi.channel.commonutils.logger.b.m134a(str);
                        }
                    }
                }
                this.f370a.a(m374a2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public fa m374a() {
        InterceptResult invokeV;
        int i2;
        ByteBuffer a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                a = a();
                i2 = a.position();
            } catch (IOException e2) {
                e = e2;
                i2 = 0;
            }
            try {
                a.flip();
                a.position(8);
                fa fgVar = i2 == 8 ? new fg() : fa.a(a.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fgVar.m366a() + ";chid=" + fgVar.a() + ";len=" + i2 + "}");
                return fgVar;
            } catch (IOException e3) {
                e = e3;
                if (i2 == 0) {
                    i2 = this.f372a.position();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] array = this.f372a.array();
                if (i2 > 128) {
                    i2 = 128;
                }
                sb.append(af.a(array, 0, i2));
                sb.append("] Err:");
                sb.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.m134a(sb.toString());
                throw e;
            }
        }
        return (fa) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m375a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                c();
            } catch (IOException e2) {
                if (!this.f374a) {
                    throw e2;
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f374a = true;
        }
    }
}
