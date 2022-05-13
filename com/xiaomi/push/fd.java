package com.xiaomi.push;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.du;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;
/* loaded from: classes8.dex */
public class fd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public fh f352a;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f353a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f354a;

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f355a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f356a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public ByteBuffer f357b;

    public fd(OutputStream outputStream, fh fhVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream, fhVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f354a = ByteBuffer.allocate(2048);
        this.f357b = ByteBuffer.allocate(4);
        this.f355a = new Adler32();
        this.f353a = new BufferedOutputStream(outputStream);
        this.f352a = fhVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fa faVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, faVar)) == null) {
            int c = faVar.c();
            if (c > 32768) {
                com.xiaomi.channel.commonutils.logger.b.m109a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + faVar.a() + " id=" + faVar.e());
                return 0;
            }
            this.f354a.clear();
            int i = c + 8 + 4;
            if (i > this.f354a.capacity() || this.f354a.capacity() > 4096) {
                this.f354a = ByteBuffer.allocate(i);
            }
            this.f354a.putShort((short) -15618);
            this.f354a.putShort((short) 5);
            this.f354a.putInt(c);
            int position = this.f354a.position();
            this.f354a = faVar.mo342a(this.f354a);
            if (!"CONN".equals(faVar.m341a())) {
                if (this.f356a == null) {
                    this.f356a = this.f352a.a();
                }
                com.xiaomi.push.service.be.a(this.f356a, this.f354a.array(), true, position, c);
            }
            this.f355a.reset();
            this.f355a.update(this.f354a.array(), 0, this.f354a.position());
            this.f357b.putInt(0, (int) this.f355a.getValue());
            this.f353a.write(this.f354a.array(), 0, this.f354a.position());
            this.f353a.write(this.f357b.array(), 0, 4);
            this.f353a.flush();
            int position2 = this.f354a.position() + 4;
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + faVar.m341a() + ";chid=" + faVar.a() + ";len=" + position2 + "}");
            return position2;
        }
        return invokeL.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            du.e eVar = new du.e();
            eVar.a(106);
            eVar.a(Build.MODEL);
            eVar.b(t.m676a());
            eVar.c(com.xiaomi.push.service.bi.m651a());
            eVar.b(43);
            eVar.d(this.f352a.m363b());
            eVar.e(this.f352a.a());
            eVar.f(Locale.getDefault().toString());
            eVar.c(Build.VERSION.SDK_INT);
            byte[] m369a = this.f352a.m359a().m369a();
            if (m369a != null) {
                eVar.a(du.b.a(m369a));
            }
            fa faVar = new fa();
            faVar.a(0);
            faVar.a("CONN", (String) null);
            faVar.a(0L, "xiaomi.com", null);
            faVar.a(eVar.m320a(), (String) null);
            a(faVar);
            com.xiaomi.channel.commonutils.logger.b.m109a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=43 hash=" + com.xiaomi.push.service.bi.m651a() + " tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fa faVar = new fa();
            faVar.a("CLOSE", (String) null);
            a(faVar);
            this.f353a.close();
        }
    }
}
