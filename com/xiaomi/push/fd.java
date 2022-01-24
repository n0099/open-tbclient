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
/* loaded from: classes4.dex */
public class fd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public fh f376a;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f377a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f378a;

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f379a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f380a;

    /* renamed from: b  reason: collision with root package name */
    public int f61120b;

    /* renamed from: b  reason: collision with other field name */
    public ByteBuffer f381b;

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
        this.f378a = ByteBuffer.allocate(2048);
        this.f381b = ByteBuffer.allocate(4);
        this.f379a = new Adler32();
        this.f377a = new BufferedOutputStream(outputStream);
        this.f376a = fhVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.f61120b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fa faVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, faVar)) == null) {
            int c2 = faVar.c();
            if (c2 > 32768) {
                com.xiaomi.channel.commonutils.logger.b.m134a("Blob size=" + c2 + " should be less than 32768 Drop blob chid=" + faVar.a() + " id=" + faVar.e());
                return 0;
            }
            this.f378a.clear();
            int i2 = c2 + 8 + 4;
            if (i2 > this.f378a.capacity() || this.f378a.capacity() > 4096) {
                this.f378a = ByteBuffer.allocate(i2);
            }
            this.f378a.putShort((short) -15618);
            this.f378a.putShort((short) 5);
            this.f378a.putInt(c2);
            int position = this.f378a.position();
            this.f378a = faVar.mo367a(this.f378a);
            if (!"CONN".equals(faVar.m366a())) {
                if (this.f380a == null) {
                    this.f380a = this.f376a.a();
                }
                com.xiaomi.push.service.be.a(this.f380a, this.f378a.array(), true, position, c2);
            }
            this.f379a.reset();
            this.f379a.update(this.f378a.array(), 0, this.f378a.position());
            this.f381b.putInt(0, (int) this.f379a.getValue());
            this.f377a.write(this.f378a.array(), 0, this.f378a.position());
            this.f377a.write(this.f381b.array(), 0, 4);
            this.f377a.flush();
            int position2 = this.f378a.position() + 4;
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + faVar.m366a() + ";chid=" + faVar.a() + ";len=" + position2 + "}");
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
            eVar.b(t.m701a());
            eVar.c(com.xiaomi.push.service.bi.m676a());
            eVar.b(43);
            eVar.d(this.f376a.m388b());
            eVar.e(this.f376a.a());
            eVar.f(Locale.getDefault().toString());
            eVar.c(Build.VERSION.SDK_INT);
            byte[] m394a = this.f376a.m384a().m394a();
            if (m394a != null) {
                eVar.a(du.b.a(m394a));
            }
            fa faVar = new fa();
            faVar.a(0);
            faVar.a("CONN", (String) null);
            faVar.a(0L, "xiaomi.com", null);
            faVar.a(eVar.m345a(), (String) null);
            a(faVar);
            com.xiaomi.channel.commonutils.logger.b.m134a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=43 hash=" + com.xiaomi.push.service.bi.m676a() + " tz=" + this.a + ":" + this.f61120b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fa faVar = new fa();
            faVar.a("CLOSE", (String) null);
            a(faVar);
            this.f377a.close();
        }
    }
}
