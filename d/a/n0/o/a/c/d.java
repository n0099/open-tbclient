package d.a.n0.o.a.c;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Writer;
/* loaded from: classes7.dex */
public class d extends Writer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f50909e;

    /* renamed from: f  reason: collision with root package name */
    public StringBuilder f50910f;

    public d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50910f = new StringBuilder(128);
        this.f50909e = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            g();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f50910f.length() <= 0) {
            return;
        }
        Log.d(this.f50909e, this.f50910f.toString());
        StringBuilder sb = this.f50910f;
        sb.delete(0, sb.length());
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, cArr, i2, i3) == null) {
            for (int i4 = 0; i4 < i3; i4++) {
                char c2 = cArr[i2 + i4];
                if (c2 == '\n') {
                    g();
                } else {
                    this.f50910f.append(c2);
                }
            }
        }
    }
}
