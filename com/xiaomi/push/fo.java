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
    public fs f383a;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f384a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f385a;

    /* renamed from: a  reason: collision with other field name */
    public Adler32 f386a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f387a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public ByteBuffer f388b;

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
        this.f385a = ByteBuffer.allocate(2048);
        this.f388b = ByteBuffer.allocate(4);
        this.f386a = new Adler32();
        this.f384a = new BufferedOutputStream(outputStream);
        this.f383a = fsVar;
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
                com.xiaomi.channel.commonutils.logger.b.m89a("Blob size=" + c + " should be less than 32768 Drop blob chid=" + flVar.a() + " id=" + flVar.e());
                return 0;
            }
            this.f385a.clear();
            int i = c + 8 + 4;
            if (i > this.f385a.capacity() || this.f385a.capacity() > 4096) {
                this.f385a = ByteBuffer.allocate(i);
            }
            this.f385a.putShort((short) -15618);
            this.f385a.putShort((short) 5);
            this.f385a.putInt(c);
            int position = this.f385a.position();
            this.f385a = flVar.mo336a(this.f385a);
            if (!"CONN".equals(flVar.m335a())) {
                if (this.f387a == null) {
                    this.f387a = this.f383a.a();
                }
                com.xiaomi.push.service.bp.a(this.f387a, this.f385a.array(), true, position, c);
            }
            this.f386a.reset();
            this.f386a.update(this.f385a.array(), 0, this.f385a.position());
            this.f388b.putInt(0, (int) this.f386a.getValue());
            this.f384a.write(this.f385a.array(), 0, this.f385a.position());
            this.f384a.write(this.f388b.array(), 0, 4);
            this.f384a.flush();
            int position2 = this.f385a.position() + 4;
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + flVar.m335a() + ";chid=" + flVar.a() + ";len=" + position2 + "}");
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
            eVar.b(v.m688a());
            eVar.c(com.xiaomi.push.service.bv.m648a());
            eVar.b(48);
            eVar.d(this.f383a.m357b());
            eVar.e(this.f383a.a());
            eVar.f(Locale.getDefault().toString());
            eVar.c(Build.VERSION.SDK_INT);
            byte[] m363a = this.f383a.m353a().m363a();
            if (m363a != null) {
                eVar.a(dx.b.a(m363a));
            }
            fl flVar = new fl();
            flVar.a(0);
            flVar.a("CONN", (String) null);
            flVar.a(0L, "xiaomi.com", null);
            flVar.a(eVar.m303a(), (String) null);
            a(flVar);
            com.xiaomi.channel.commonutils.logger.b.m89a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=48 tz=" + this.a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fl flVar = new fl();
            flVar.a("CLOSE", (String) null);
            a(flVar);
            this.f384a.close();
        }
    }
}
