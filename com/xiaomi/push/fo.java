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
    public fs f1103a;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f1104a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f1105a;

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f1106a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f1107a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public ByteBuffer f1108b;

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
        this.f1105a = ByteBuffer.allocate(2048);
        this.f1108b = ByteBuffer.allocate(4);
        this.f1106a = new Adler32();
        this.f1104a = new BufferedOutputStream(outputStream);
        this.f1103a = fsVar;
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
                com.xiaomi.channel.commonutils.logger.b.m1027a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + flVar.a() + " id=" + flVar.e());
                return 0;
            }
            this.f1105a.clear();
            int i = c + 8 + 4;
            if (i > this.f1105a.capacity() || this.f1105a.capacity() > 4096) {
                this.f1105a = ByteBuffer.allocate(i);
            }
            this.f1105a.putShort((short) -15618);
            this.f1105a.putShort((short) 5);
            this.f1105a.putInt(c);
            int position = this.f1105a.position();
            this.f1105a = flVar.mo1274a(this.f1105a);
            if (!"CONN".equals(flVar.m1273a())) {
                if (this.f1107a == null) {
                    this.f1107a = this.f1103a.a();
                }
                com.xiaomi.push.service.bp.a(this.f1107a, this.f1105a.array(), true, position, c);
            }
            this.f1106a.reset();
            this.f1106a.update(this.f1105a.array(), 0, this.f1105a.position());
            this.f1108b.putInt(0, (int) this.f1106a.getValue());
            this.f1104a.write(this.f1105a.array(), 0, this.f1105a.position());
            this.f1104a.write(this.f1108b.array(), 0, 4);
            this.f1104a.flush();
            int position2 = this.f1105a.position() + 4;
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + flVar.m1273a() + ";chid=" + flVar.a() + ";len=" + position2 + "}");
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
            eVar.b(v.m1626a());
            eVar.c(com.xiaomi.push.service.bv.m1586a());
            eVar.b(48);
            eVar.d(this.f1103a.m1295b());
            eVar.e(this.f1103a.a());
            eVar.f(Locale.getDefault().toString());
            eVar.c(Build.VERSION.SDK_INT);
            byte[] m1301a = this.f1103a.m1291a().m1301a();
            if (m1301a != null) {
                eVar.a(dx.b.a(m1301a));
            }
            fl flVar = new fl();
            flVar.a(0);
            flVar.a("CONN", (String) null);
            flVar.a(0L, "xiaomi.com", null);
            flVar.a(eVar.m1241a(), (String) null);
            a(flVar);
            com.xiaomi.channel.commonutils.logger.b.m1027a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=48 tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fl flVar = new fl();
            flVar.a("CLOSE", (String) null);
            a(flVar);
            this.f1104a.close();
        }
    }
}
