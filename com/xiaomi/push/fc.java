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
/* loaded from: classes6.dex */
public class fc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ff f40113a;

    /* renamed from: a  reason: collision with other field name */
    public fh f365a;

    /* renamed from: a  reason: collision with other field name */
    public InputStream f366a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f367a;

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f368a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f369a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f370a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f40114b;

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
        this.f367a = ByteBuffer.allocate(2048);
        this.f40114b = ByteBuffer.allocate(4);
        this.f368a = new Adler32();
        this.f366a = new BufferedInputStream(inputStream);
        this.f365a = fhVar;
        this.f40113a = new ff();
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
        this.f367a.clear();
        a(this.f367a, 8);
        short s = this.f367a.getShort(0);
        short s2 = this.f367a.getShort(2);
        if (s != -15618 || s2 != 5) {
            throw new IOException("Malformed Input");
        }
        int i3 = this.f367a.getInt(4);
        int position = this.f367a.position();
        if (i3 > 32768) {
            throw new IOException("Blob size too large");
        }
        if (i3 + 4 <= this.f367a.remaining()) {
            if (this.f367a.capacity() > 4096 && i3 < 2048) {
                allocate = ByteBuffer.allocate(2048);
                allocate.put(this.f367a.array(), 0, this.f367a.arrayOffset() + this.f367a.position());
            }
            a(this.f367a, i3);
            this.f40114b.clear();
            a(this.f40114b, 4);
            this.f40114b.position(0);
            i2 = this.f40114b.getInt();
            this.f368a.reset();
            this.f368a.update(this.f367a.array(), 0, this.f367a.position());
            if (i2 != ((int) this.f368a.getValue())) {
                byte[] bArr = this.f370a;
                if (bArr != null) {
                    com.xiaomi.push.service.be.a(bArr, this.f367a.array(), true, position, i3);
                }
                return this.f367a;
            }
            com.xiaomi.channel.commonutils.logger.b.m70a("CRC = " + ((int) this.f368a.getValue()) + " and " + i2);
            throw new IOException("Corrupted Blob bad CRC");
        }
        allocate = ByteBuffer.allocate(i3 + 2048);
        allocate.put(this.f367a.array(), 0, this.f367a.arrayOffset() + this.f367a.position());
        this.f367a = allocate;
        a(this.f367a, i3);
        this.f40114b.clear();
        a(this.f40114b, 4);
        this.f40114b.position(0);
        i2 = this.f40114b.getInt();
        this.f368a.reset();
        this.f368a.update(this.f367a.array(), 0, this.f367a.position());
        if (i2 != ((int) this.f368a.getValue())) {
        }
    }

    private void a(ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, byteBuffer, i2) == null) {
            int position = byteBuffer.position();
            do {
                int read = this.f366a.read(byteBuffer.array(), position, i2);
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
            this.f369a = false;
            fa m310a = m310a();
            if ("CONN".equals(m310a.m302a())) {
                du.f a2 = du.f.a(m310a.m306a());
                if (a2.a()) {
                    this.f365a.a(a2.a());
                    z = true;
                }
                if (a2.c()) {
                    du.b a3 = a2.a();
                    fa faVar = new fa();
                    faVar.a("SYNC", "CONF");
                    faVar.a(a3.m281a(), (String) null);
                    this.f365a.a(faVar);
                }
                com.xiaomi.channel.commonutils.logger.b.m70a("[Slim] CONN: host = " + a2.b());
            }
            if (!z) {
                com.xiaomi.channel.commonutils.logger.b.m70a("[Slim] Invalid CONN");
                throw new IOException("Invalid Connection");
            }
            this.f370a = this.f365a.a();
            while (!this.f369a) {
                fa m310a2 = m310a();
                this.f365a.c();
                short m304a = m310a2.m304a();
                if (m304a != 1) {
                    if (m304a != 2) {
                        if (m304a != 3) {
                            str = "[Slim] unknow blob type " + ((int) m310a2.m304a());
                            com.xiaomi.channel.commonutils.logger.b.m70a(str);
                        } else {
                            try {
                                this.f365a.b(this.f40113a.a(m310a2.m306a(), this.f365a));
                            } catch (Exception e2) {
                                e = e2;
                                sb = new StringBuilder();
                                sb.append("[Slim] Parse packet from Blob chid=");
                                sb.append(m310a2.a());
                                sb.append("; Id=");
                                sb.append(m310a2.e());
                                sb.append(" failure:");
                                sb.append(e.getMessage());
                                str = sb.toString();
                                com.xiaomi.channel.commonutils.logger.b.m70a(str);
                            }
                        }
                    } else if ("SECMSG".equals(m310a2.m302a()) && ((m310a2.a() == 2 || m310a2.a() == 3) && TextUtils.isEmpty(m310a2.m308b()))) {
                        try {
                            this.f365a.b(this.f40113a.a(m310a2.m307a(com.xiaomi.push.service.av.a().a(Integer.valueOf(m310a2.a()).toString(), m310a2.g()).f40609h), this.f365a));
                        } catch (Exception e3) {
                            e = e3;
                            sb = new StringBuilder();
                            sb.append("[Slim] Parse packet from Blob chid=");
                            sb.append(m310a2.a());
                            sb.append("; Id=");
                            sb.append(m310a2.e());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            com.xiaomi.channel.commonutils.logger.b.m70a(str);
                        }
                    }
                }
                this.f365a.a(m310a2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public fa m310a() {
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
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fgVar.m302a() + ";chid=" + fgVar.a() + ";len=" + i2 + "}");
                return fgVar;
            } catch (IOException e3) {
                e = e3;
                if (i2 == 0) {
                    i2 = this.f367a.position();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] array = this.f367a.array();
                if (i2 > 128) {
                    i2 = 128;
                }
                sb.append(af.a(array, 0, i2));
                sb.append("] Err:");
                sb.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.m70a(sb.toString());
                throw e;
            }
        }
        return (fa) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m311a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                c();
            } catch (IOException e2) {
                if (!this.f369a) {
                    throw e2;
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f369a = true;
        }
    }
}
