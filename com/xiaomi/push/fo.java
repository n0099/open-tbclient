package com.xiaomi.push;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.dx;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;
/* loaded from: classes8.dex */
public class fo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public fs f376a;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f377a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f378a;

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f379a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f380a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public ByteBuffer f381b;

    public fo(OutputStream outputStream, fs fsVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream, fsVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f378a = ByteBuffer.allocate(2048);
        this.f381b = ByteBuffer.allocate(4);
        this.f379a = new Adler32();
        this.f377a = new BufferedOutputStream(outputStream);
        this.f376a = fsVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.a = timeZone.getRawOffset() / 3600000;
        this.b = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(fl flVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, flVar)) == null) {
            int c = flVar.c();
            if (c > 32768) {
                com.xiaomi.channel.commonutils.logger.b.m84a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + flVar.a() + " id=" + flVar.e());
                return 0;
            }
            this.f378a.clear();
            int i = c + 8 + 4;
            if (i > this.f378a.capacity() || this.f378a.capacity() > 4096) {
                this.f378a = ByteBuffer.allocate(i);
            }
            this.f378a.putShort((short) -15618);
            this.f378a.putShort((short) 5);
            this.f378a.putInt(c);
            int position = this.f378a.position();
            this.f378a = flVar.mo331a(this.f378a);
            if (!"CONN".equals(flVar.m330a())) {
                if (this.f380a == null) {
                    this.f380a = this.f376a.a();
                }
                com.xiaomi.push.service.bp.a(this.f380a, this.f378a.array(), true, position, c);
            }
            this.f379a.reset();
            this.f379a.update(this.f378a.array(), 0, this.f378a.position());
            this.f381b.putInt(0, (int) this.f379a.getValue());
            this.f377a.write(this.f378a.array(), 0, this.f378a.position());
            this.f377a.write(this.f381b.array(), 0, 4);
            this.f377a.flush();
            int position2 = this.f378a.position() + 4;
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + flVar.m330a() + ";chid=" + flVar.a() + ";len=" + position2 + "}");
            return position2;
        }
        return invokeL.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dx.e eVar = new dx.e();
            eVar.a(106);
            eVar.a(Build.MODEL);
            eVar.b(v.m683a());
            eVar.c(com.xiaomi.push.service.bv.m643a());
            eVar.b(48);
            eVar.d(this.f376a.m352b());
            eVar.e(this.f376a.a());
            eVar.f(Locale.getDefault().toString());
            eVar.c(Build.VERSION.SDK_INT);
            byte[] m358a = this.f376a.m348a().m358a();
            if (m358a != null) {
                eVar.a(dx.b.a(m358a));
            }
            fl flVar = new fl();
            flVar.a(0);
            flVar.a("CONN", (String) null);
            flVar.a(0L, "xiaomi.com", null);
            flVar.a(eVar.m298a(), (String) null);
            a(flVar);
            com.xiaomi.channel.commonutils.logger.b.m84a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=48 tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fl flVar = new fl();
            flVar.a("CLOSE", (String) null);
            a(flVar);
            this.f377a.close();
        }
    }
}
