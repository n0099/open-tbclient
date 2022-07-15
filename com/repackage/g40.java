package com.repackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d40;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public abstract class g40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d40.a a;
    public a b;
    public String c;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public d40 b;
        public TrustSubjectManager.d c;
        public ExecutorService d;
        public ExecutorService e;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
        }
    }

    /* loaded from: classes6.dex */
    public interface c<T> {
        void a(int i, Exception exc, Bundle bundle);

        void onResult(T t, Bundle bundle);
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ String b;

        public d(g40 g40Var, c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g40Var, cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onResult(this.b, null);
            }
        }
    }

    public g40(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = str;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            String format = String.format("%s-%s-", str, str2);
            try {
                str3 = new x30("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).c(new c30().a(format.getBytes("UTF-8")));
            } catch (UnsupportedEncodingException unused) {
                str3 = null;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "AAAAAAAA";
            }
            return format + str3;
        }
        return (String) invokeLL.objValue;
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.b = aVar;
            this.a = aVar.b.d().f("ids");
        }
    }

    public abstract String c();

    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public abstract void f(b bVar);

    public void g(c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.b.d.submit(new d(this, cVar, c()));
        }
    }
}
