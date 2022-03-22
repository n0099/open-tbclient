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
/* loaded from: classes7.dex */
public class fc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ff a;

    /* renamed from: a  reason: collision with other field name */
    public fh f346a;

    /* renamed from: a  reason: collision with other field name */
    public InputStream f347a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f348a;

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f349a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f350a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f351a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f44242b;

    public fc(InputStream inputStream, fh fhVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, fhVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f348a = ByteBuffer.allocate(2048);
        this.f44242b = ByteBuffer.allocate(4);
        this.f349a = new Adler32();
        this.f347a = new BufferedInputStream(inputStream);
        this.f346a = fhVar;
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65537, this)) != null) {
            return (ByteBuffer) invokeV.objValue;
        }
        this.f348a.clear();
        a(this.f348a, 8);
        short s = this.f348a.getShort(0);
        short s2 = this.f348a.getShort(2);
        if (s != -15618 || s2 != 5) {
            throw new IOException("Malformed Input");
        }
        int i2 = this.f348a.getInt(4);
        int position = this.f348a.position();
        if (i2 > 32768) {
            throw new IOException("Blob size too large");
        }
        if (i2 + 4 <= this.f348a.remaining()) {
            if (this.f348a.capacity() > 4096 && i2 < 2048) {
                allocate = ByteBuffer.allocate(2048);
                allocate.put(this.f348a.array(), 0, this.f348a.arrayOffset() + this.f348a.position());
            }
            a(this.f348a, i2);
            this.f44242b.clear();
            a(this.f44242b, 4);
            this.f44242b.position(0);
            i = this.f44242b.getInt();
            this.f349a.reset();
            this.f349a.update(this.f348a.array(), 0, this.f348a.position());
            if (i != ((int) this.f349a.getValue())) {
                byte[] bArr = this.f351a;
                if (bArr != null) {
                    com.xiaomi.push.service.be.a(bArr, this.f348a.array(), true, position, i2);
                }
                return this.f348a;
            }
            com.xiaomi.channel.commonutils.logger.b.m112a("CRC = " + ((int) this.f349a.getValue()) + " and " + i);
            throw new IOException("Corrupted Blob bad CRC");
        }
        allocate = ByteBuffer.allocate(i2 + 2048);
        allocate.put(this.f348a.array(), 0, this.f348a.arrayOffset() + this.f348a.position());
        this.f348a = allocate;
        a(this.f348a, i2);
        this.f44242b.clear();
        a(this.f44242b, 4);
        this.f44242b.position(0);
        i = this.f44242b.getInt();
        this.f349a.reset();
        this.f349a.update(this.f348a.array(), 0, this.f348a.position());
        if (i != ((int) this.f349a.getValue())) {
        }
    }

    private void a(ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, byteBuffer, i) == null) {
            int position = byteBuffer.position();
            do {
                int read = this.f347a.read(byteBuffer.array(), position, i);
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
            this.f350a = false;
            fa m352a = m352a();
            if ("CONN".equals(m352a.m344a())) {
                du.f a = du.f.a(m352a.m348a());
                if (a.a()) {
                    this.f346a.a(a.a());
                    z = true;
                }
                if (a.c()) {
                    du.b a2 = a.a();
                    fa faVar = new fa();
                    faVar.a("SYNC", "CONF");
                    faVar.a(a2.m323a(), (String) null);
                    this.f346a.a(faVar);
                }
                com.xiaomi.channel.commonutils.logger.b.m112a("[Slim] CONN: host = " + a.b());
            }
            if (!z) {
                com.xiaomi.channel.commonutils.logger.b.m112a("[Slim] Invalid CONN");
                throw new IOException("Invalid Connection");
            }
            this.f351a = this.f346a.a();
            while (!this.f350a) {
                fa m352a2 = m352a();
                this.f346a.c();
                short m346a = m352a2.m346a();
                if (m346a != 1) {
                    if (m346a != 2) {
                        if (m346a != 3) {
                            str = "[Slim] unknow blob type " + ((int) m352a2.m346a());
                            com.xiaomi.channel.commonutils.logger.b.m112a(str);
                        } else {
                            try {
                                this.f346a.b(this.a.a(m352a2.m348a(), this.f346a));
                            } catch (Exception e2) {
                                e = e2;
                                sb = new StringBuilder();
                                sb.append("[Slim] Parse packet from Blob chid=");
                                sb.append(m352a2.a());
                                sb.append("; Id=");
                                sb.append(m352a2.e());
                                sb.append(" failure:");
                                sb.append(e.getMessage());
                                str = sb.toString();
                                com.xiaomi.channel.commonutils.logger.b.m112a(str);
                            }
                        }
                    } else if ("SECMSG".equals(m352a2.m344a()) && ((m352a2.a() == 2 || m352a2.a() == 3) && TextUtils.isEmpty(m352a2.m350b()))) {
                        try {
                            this.f346a.b(this.a.a(m352a2.m349a(com.xiaomi.push.service.av.a().a(Integer.valueOf(m352a2.a()).toString(), m352a2.g()).f44552h), this.f346a));
                        } catch (Exception e3) {
                            e = e3;
                            sb = new StringBuilder();
                            sb.append("[Slim] Parse packet from Blob chid=");
                            sb.append(m352a2.a());
                            sb.append("; Id=");
                            sb.append(m352a2.e());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            com.xiaomi.channel.commonutils.logger.b.m112a(str);
                        }
                    }
                }
                this.f346a.a(m352a2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public fa m352a() {
        InterceptResult invokeV;
        int i;
        ByteBuffer a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                a = a();
                i = a.position();
            } catch (IOException e2) {
                e = e2;
                i = 0;
            }
            try {
                a.flip();
                a.position(8);
                fa fgVar = i == 8 ? new fg() : fa.a(a.slice());
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] Read {cmd=" + fgVar.m344a() + ";chid=" + fgVar.a() + ";len=" + i + "}");
                return fgVar;
            } catch (IOException e3) {
                e = e3;
                if (i == 0) {
                    i = this.f348a.position();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] array = this.f348a.array();
                if (i > 128) {
                    i = 128;
                }
                sb.append(af.a(array, 0, i));
                sb.append("] Err:");
                sb.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.m112a(sb.toString());
                throw e;
            }
        }
        return (fa) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m353a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                c();
            } catch (IOException e2) {
                if (!this.f350a) {
                    throw e2;
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f350a = true;
        }
    }
}
