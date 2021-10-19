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
/* loaded from: classes10.dex */
public class fd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f77979a;

    /* renamed from: a  reason: collision with other field name */
    public fh f375a;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f376a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f377a;

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f378a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f379a;

    /* renamed from: b  reason: collision with root package name */
    public int f77980b;

    /* renamed from: b  reason: collision with other field name */
    public ByteBuffer f380b;

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
        this.f377a = ByteBuffer.allocate(2048);
        this.f380b = ByteBuffer.allocate(4);
        this.f378a = new Adler32();
        this.f376a = new BufferedOutputStream(outputStream);
        this.f375a = fhVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.f77979a = timeZone.getRawOffset() / 3600000;
        this.f77980b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fa faVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, faVar)) == null) {
            int c2 = faVar.c();
            if (c2 > 32768) {
                com.xiaomi.channel.commonutils.logger.b.m73a("Blob size=" + c2 + " should be less than 32768 Drop blob chid=" + faVar.a() + " id=" + faVar.e());
                return 0;
            }
            this.f377a.clear();
            int i2 = c2 + 8 + 4;
            if (i2 > this.f377a.capacity() || this.f377a.capacity() > 4096) {
                this.f377a = ByteBuffer.allocate(i2);
            }
            this.f377a.putShort((short) -15618);
            this.f377a.putShort((short) 5);
            this.f377a.putInt(c2);
            int position = this.f377a.position();
            this.f377a = faVar.mo306a(this.f377a);
            if (!"CONN".equals(faVar.m305a())) {
                if (this.f379a == null) {
                    this.f379a = this.f375a.a();
                }
                com.xiaomi.push.service.be.a(this.f379a, this.f377a.array(), true, position, c2);
            }
            this.f378a.reset();
            this.f378a.update(this.f377a.array(), 0, this.f377a.position());
            this.f380b.putInt(0, (int) this.f378a.getValue());
            this.f376a.write(this.f377a.array(), 0, this.f377a.position());
            this.f376a.write(this.f380b.array(), 0, 4);
            this.f376a.flush();
            int position2 = this.f377a.position() + 4;
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + faVar.m305a() + ";chid=" + faVar.a() + ";len=" + position2 + "}");
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
            eVar.b(t.m640a());
            eVar.c(com.xiaomi.push.service.bi.m615a());
            eVar.b(43);
            eVar.d(this.f375a.m327b());
            eVar.e(this.f375a.a());
            eVar.f(Locale.getDefault().toString());
            eVar.c(Build.VERSION.SDK_INT);
            byte[] m333a = this.f375a.m323a().m333a();
            if (m333a != null) {
                eVar.a(du.b.a(m333a));
            }
            fa faVar = new fa();
            faVar.a(0);
            faVar.a("CONN", (String) null);
            faVar.a(0L, "xiaomi.com", null);
            faVar.a(eVar.m284a(), (String) null);
            a(faVar);
            com.xiaomi.channel.commonutils.logger.b.m73a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=43 hash=" + com.xiaomi.push.service.bi.m615a() + " tz=" + this.f77979a + ":" + this.f77980b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fa faVar = new fa();
            faVar.a("CLOSE", (String) null);
            a(faVar);
            this.f376a.close();
        }
    }
}
