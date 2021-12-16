package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes3.dex */
public class e extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final h a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.kwai.b f58478b;

    /* renamed from: c  reason: collision with root package name */
    public b f58479c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, com.kwad.sdk.core.videocache.kwai.b bVar) {
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
        this.f58478b = bVar;
        this.a = hVar;
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
            int a = a(bArr, j2, 8192);
            if (a == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, a);
                j2 += a;
            }
        }
    }

    private boolean a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, dVar)) == null) {
            long a = this.a.a();
            return (((a > 0L ? 1 : (a == 0L ? 0 : -1)) > 0) && dVar.f58477c && ((float) dVar.f58476b) > ((float) this.f58478b.a()) + (((float) a) * 0.2f)) ? false : true;
        }
        return invokeL.booleanValue;
    }

    private String b(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dVar)) == null) {
            String c2 = this.a.c();
            boolean z = !TextUtils.isEmpty(c2);
            long a = this.f58478b.d() ? this.f58478b.a() : this.a.a();
            boolean z2 = a >= 0;
            long j2 = dVar.f58477c ? a - dVar.f58476b : a;
            boolean z3 = z2 && dVar.f58477c;
            StringBuilder sb = new StringBuilder();
            sb.append(dVar.f58477c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
            sb.append("Accept-Ranges: bytes\n");
            sb.append(z2 ? a("Content-Length: %d\n", Long.valueOf(j2)) : "");
            sb.append(z3 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.f58476b), Long.valueOf(a - 1), Long.valueOf(a)) : "");
            sb.append(z ? a("Content-Type: %s\n", c2) : "");
            sb.append(StringUtils.LF);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private void b(OutputStream outputStream, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLJ(65541, this, outputStream, j2) != null) {
            return;
        }
        h hVar = new h(this.a);
        try {
            hVar.a((int) j2);
            byte[] bArr = new byte[8192];
            while (true) {
                int a = hVar.a(bArr);
                if (a == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, a);
            }
        } finally {
            hVar.b();
        }
    }

    @Override // com.kwad.sdk.core.videocache.k
    public void a(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (bVar = this.f58479c) == null) {
            return;
        }
        bVar.a(this.f58478b.a, this.a.d(), i2);
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f58479c = bVar;
        }
    }

    public void a(d dVar, Socket socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, socket) == null) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
            long j2 = dVar.f58476b;
            if (a(dVar)) {
                a(bufferedOutputStream, j2);
            } else {
                b(bufferedOutputStream, j2);
            }
        }
    }
}
