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

    /* renamed from: a  reason: collision with root package name */
    public int f43101a;

    /* renamed from: a  reason: collision with other field name */
    public fh f371a;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f372a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f373a;

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f374a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f375a;

    /* renamed from: b  reason: collision with root package name */
    public int f43102b;

    /* renamed from: b  reason: collision with other field name */
    public ByteBuffer f376b;

    public fd(OutputStream outputStream, fh fhVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream, fhVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f373a = ByteBuffer.allocate(2048);
        this.f376b = ByteBuffer.allocate(4);
        this.f374a = new Adler32();
        this.f372a = new BufferedOutputStream(outputStream);
        this.f371a = fhVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.f43101a = timeZone.getRawOffset() / 3600000;
        this.f43102b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fa faVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, faVar)) == null) {
            int c2 = faVar.c();
            if (c2 > 32768) {
                com.xiaomi.channel.commonutils.logger.b.m70a("Blob size=" + c2 + " should be less than 32768 Drop blob chid=" + faVar.a() + " id=" + faVar.e());
                return 0;
            }
            this.f373a.clear();
            int i2 = c2 + 8 + 4;
            if (i2 > this.f373a.capacity() || this.f373a.capacity() > 4096) {
                this.f373a = ByteBuffer.allocate(i2);
            }
            this.f373a.putShort((short) -15618);
            this.f373a.putShort((short) 5);
            this.f373a.putInt(c2);
            int position = this.f373a.position();
            this.f373a = faVar.mo303a(this.f373a);
            if (!"CONN".equals(faVar.m302a())) {
                if (this.f375a == null) {
                    this.f375a = this.f371a.a();
                }
                com.xiaomi.push.service.be.a(this.f375a, this.f373a.array(), true, position, c2);
            }
            this.f374a.reset();
            this.f374a.update(this.f373a.array(), 0, this.f373a.position());
            this.f376b.putInt(0, (int) this.f374a.getValue());
            this.f372a.write(this.f373a.array(), 0, this.f373a.position());
            this.f372a.write(this.f376b.array(), 0, 4);
            this.f372a.flush();
            int position2 = this.f373a.position() + 4;
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + faVar.m302a() + ";chid=" + faVar.a() + ";len=" + position2 + "}");
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
            eVar.b(t.m637a());
            eVar.c(com.xiaomi.push.service.bi.m612a());
            eVar.b(43);
            eVar.d(this.f371a.m324b());
            eVar.e(this.f371a.a());
            eVar.f(Locale.getDefault().toString());
            eVar.c(Build.VERSION.SDK_INT);
            byte[] m330a = this.f371a.m320a().m330a();
            if (m330a != null) {
                eVar.a(du.b.a(m330a));
            }
            fa faVar = new fa();
            faVar.a(0);
            faVar.a("CONN", (String) null);
            faVar.a(0L, "xiaomi.com", null);
            faVar.a(eVar.m281a(), (String) null);
            a(faVar);
            com.xiaomi.channel.commonutils.logger.b.m70a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=43 hash=" + com.xiaomi.push.service.bi.m612a() + " tz=" + this.f43101a + ":" + this.f43102b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fa faVar = new fa();
            faVar.a("CLOSE", (String) null);
            a(faVar);
            this.f372a.close();
        }
    }
}
