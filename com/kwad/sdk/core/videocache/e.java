package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes10.dex */
public class e extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final h f72347a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a.b f72348b;

    /* renamed from: c  reason: collision with root package name */
    public b f72349c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, com.kwad.sdk.core.videocache.a.b bVar) {
        super(hVar, bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((m) objArr2[0], (a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72348b = bVar;
        this.f72347a = hVar;
    }

    private String a(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, objArr)) == null) ? String.format(Locale.US, str, objArr) : (String) invokeLL.objValue;
    }

    private void a(OutputStream outputStream, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLJ(65538, this, outputStream, j2) != null) {
            return;
        }
        byte[] bArr = new byte[8192];
        while (true) {
            int a2 = a(bArr, j2, 8192);
            if (a2 == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, a2);
                j2 += a2;
            }
        }
    }

    private boolean a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, dVar)) == null) {
            long a2 = this.f72347a.a();
            return (((a2 > 0L ? 1 : (a2 == 0L ? 0 : -1)) > 0) && dVar.f72345c && ((float) dVar.f72344b) > ((float) this.f72348b.a()) + (((float) a2) * 0.2f)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    private String b(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dVar)) == null) {
            String c2 = this.f72347a.c();
            boolean z = !TextUtils.isEmpty(c2);
            long a2 = this.f72348b.d() ? this.f72348b.a() : this.f72347a.a();
            boolean z2 = a2 >= 0;
            long j2 = dVar.f72345c ? a2 - dVar.f72344b : a2;
            boolean z3 = z2 && dVar.f72345c;
            StringBuilder sb = new StringBuilder();
            sb.append(dVar.f72345c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
            sb.append("Accept-Ranges: bytes\n");
            sb.append(z2 ? a("Content-Length: %d\n", Long.valueOf(j2)) : "");
            sb.append(z3 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.f72344b), Long.valueOf(a2 - 1), Long.valueOf(a2)) : "");
            sb.append(z ? a("Content-Type: %s\n", c2) : "");
            sb.append(StringUtils.LF);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private void b(OutputStream outputStream, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, this, outputStream, j2) != null) {
            return;
        }
        h hVar = new h(this.f72347a);
        try {
            hVar.a((int) j2);
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = hVar.a(bArr);
                if (a2 == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, a2);
            }
        } finally {
            hVar.b();
        }
    }

    @Override // com.kwad.sdk.core.videocache.k
    public void a(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (bVar = this.f72349c) == null) {
            return;
        }
        bVar.a(this.f72348b.f72328a, this.f72347a.d(), i2);
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f72349c = bVar;
        }
    }

    public void a(d dVar, Socket socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, socket) == null) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
            long j2 = dVar.f72344b;
            if (a(dVar)) {
                a(bufferedOutputStream, j2);
            } else {
                b(bufferedOutputStream, j2);
            }
        }
    }
}
