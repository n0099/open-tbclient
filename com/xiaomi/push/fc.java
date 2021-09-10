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
/* loaded from: classes10.dex */
public class fc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ff f77623a;

    /* renamed from: a  reason: collision with other field name */
    public fh f369a;

    /* renamed from: a  reason: collision with other field name */
    public InputStream f370a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f371a;

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f372a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f373a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f374a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f77624b;

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
        this.f371a = ByteBuffer.allocate(2048);
        this.f77624b = ByteBuffer.allocate(4);
        this.f372a = new Adler32();
        this.f370a = new BufferedInputStream(inputStream);
        this.f369a = fhVar;
        this.f77623a = new ff();
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
        this.f371a.clear();
        a(this.f371a, 8);
        short s = this.f371a.getShort(0);
        short s2 = this.f371a.getShort(2);
        if (s != -15618 || s2 != 5) {
            throw new IOException("Malformed Input");
        }
        int i3 = this.f371a.getInt(4);
        int position = this.f371a.position();
        if (i3 > 32768) {
            throw new IOException("Blob size too large");
        }
        if (i3 + 4 <= this.f371a.remaining()) {
            if (this.f371a.capacity() > 4096 && i3 < 2048) {
                allocate = ByteBuffer.allocate(2048);
                allocate.put(this.f371a.array(), 0, this.f371a.arrayOffset() + this.f371a.position());
            }
            a(this.f371a, i3);
            this.f77624b.clear();
            a(this.f77624b, 4);
            this.f77624b.position(0);
            i2 = this.f77624b.getInt();
            this.f372a.reset();
            this.f372a.update(this.f371a.array(), 0, this.f371a.position());
            if (i2 != ((int) this.f372a.getValue())) {
                byte[] bArr = this.f374a;
                if (bArr != null) {
                    com.xiaomi.push.service.be.a(bArr, this.f371a.array(), true, position, i3);
                }
                return this.f371a;
            }
            com.xiaomi.channel.commonutils.logger.b.m73a("CRC = " + ((int) this.f372a.getValue()) + " and " + i2);
            throw new IOException("Corrupted Blob bad CRC");
        }
        allocate = ByteBuffer.allocate(i3 + 2048);
        allocate.put(this.f371a.array(), 0, this.f371a.arrayOffset() + this.f371a.position());
        this.f371a = allocate;
        a(this.f371a, i3);
        this.f77624b.clear();
        a(this.f77624b, 4);
        this.f77624b.position(0);
        i2 = this.f77624b.getInt();
        this.f372a.reset();
        this.f372a.update(this.f371a.array(), 0, this.f371a.position());
        if (i2 != ((int) this.f372a.getValue())) {
        }
    }

    private void a(ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, byteBuffer, i2) == null) {
            int position = byteBuffer.position();
            do {
                int read = this.f370a.read(byteBuffer.array(), position, i2);
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
            this.f373a = false;
            fa m313a = m313a();
            if ("CONN".equals(m313a.m305a())) {
                du.f a2 = du.f.a(m313a.m309a());
                if (a2.a()) {
                    this.f369a.a(a2.a());
                    z = true;
                }
                if (a2.c()) {
                    du.b a3 = a2.a();
                    fa faVar = new fa();
                    faVar.a("SYNC", "CONF");
                    faVar.a(a3.m284a(), (String) null);
                    this.f369a.a(faVar);
                }
                com.xiaomi.channel.commonutils.logger.b.m73a("[Slim] CONN: host = " + a2.b());
            }
            if (!z) {
                com.xiaomi.channel.commonutils.logger.b.m73a("[Slim] Invalid CONN");
                throw new IOException("Invalid Connection");
            }
            this.f374a = this.f369a.a();
            while (!this.f373a) {
                fa m313a2 = m313a();
                this.f369a.c();
                short m307a = m313a2.m307a();
                if (m307a != 1) {
                    if (m307a != 2) {
                        if (m307a != 3) {
                            str = "[Slim] unknow blob type " + ((int) m313a2.m307a());
                            com.xiaomi.channel.commonutils.logger.b.m73a(str);
                        } else {
                            try {
                                this.f369a.b(this.f77623a.a(m313a2.m309a(), this.f369a));
                            } catch (Exception e2) {
                                e = e2;
                                sb = new StringBuilder();
                                sb.append("[Slim] Parse packet from Blob chid=");
                                sb.append(m313a2.a());
                                sb.append("; Id=");
                                sb.append(m313a2.e());
                                sb.append(" failure:");
                                sb.append(e.getMessage());
                                str = sb.toString();
                                com.xiaomi.channel.commonutils.logger.b.m73a(str);
                            }
                        }
                    } else if ("SECMSG".equals(m313a2.m305a()) && ((m313a2.a() == 2 || m313a2.a() == 3) && TextUtils.isEmpty(m313a2.m311b()))) {
                        try {
                            this.f369a.b(this.f77623a.a(m313a2.m310a(com.xiaomi.push.service.av.a().a(Integer.valueOf(m313a2.a()).toString(), m313a2.g()).f78137h), this.f369a));
                        } catch (Exception e3) {
                            e = e3;
                            sb = new StringBuilder();
                            sb.append("[Slim] Parse packet from Blob chid=");
                            sb.append(m313a2.a());
                            sb.append("; Id=");
                            sb.append(m313a2.e());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            com.xiaomi.channel.commonutils.logger.b.m73a(str);
                        }
                    }
                }
                this.f369a.a(m313a2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public fa m313a() {
        InterceptResult invokeV;
        int i2;
        ByteBuffer a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                a2 = a();
                i2 = a2.position();
            } catch (IOException e2) {
                e = e2;
                i2 = 0;
            }
            try {
                a2.flip();
                a2.position(8);
                fa fgVar = i2 == 8 ? new fg() : fa.a(a2.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fgVar.m305a() + ";chid=" + fgVar.a() + ";len=" + i2 + "}");
                return fgVar;
            } catch (IOException e3) {
                e = e3;
                if (i2 == 0) {
                    i2 = this.f371a.position();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] array = this.f371a.array();
                if (i2 > 128) {
                    i2 = 128;
                }
                sb.append(af.a(array, 0, i2));
                sb.append("] Err:");
                sb.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.m73a(sb.toString());
                throw e;
            }
        }
        return (fa) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m314a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                c();
            } catch (IOException e2) {
                if (!this.f373a) {
                    throw e2;
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f373a = true;
        }
    }
}
