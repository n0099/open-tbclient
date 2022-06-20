package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* loaded from: classes6.dex */
public class mn0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements yn0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Ref.LongRef a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ Ref.ObjectRef c;
        public final /* synthetic */ Ref.ObjectRef d;
        public final /* synthetic */ sk0 e;
        public final /* synthetic */ File f;
        public final /* synthetic */ Ref.BooleanRef g;

        public a(Ref.LongRef longRef, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, sk0 sk0Var, File file, Ref.BooleanRef booleanRef) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {longRef, objectRef, objectRef2, objectRef3, sk0Var, file, booleanRef};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = longRef;
            this.b = objectRef;
            this.c = objectRef2;
            this.d = objectRef3;
            this.e = sk0Var;
            this.f = file;
            this.g = booleanRef;
        }

        @Override // com.repackage.yn0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                this.e.accept(new xn0(false, this.a.element, (String) this.b.element, (String) this.c.element, exc));
            }
        }

        /* JADX WARN: Type inference failed for: r10v2, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r11v19, types: [T, java.lang.Exception] */
        /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.String] */
        @Override // com.repackage.yn0
        public void c(Headers headers, InputStream inputStream, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) {
                if (headers != null && inputStream != null) {
                    this.b.element = headers.d(com.baidubce.http.Headers.ETAG);
                    this.c.element = headers.d(com.baidubce.http.Headers.LAST_MODIFIED);
                    if (i == 200) {
                        FileOutputStream fileOutputStream = new FileOutputStream(this.f);
                        this.a.element = f01.b(inputStream, fileOutputStream);
                        eh0.a(inputStream);
                        eh0.a(fileOutputStream);
                    } else if (i != 304) {
                        this.g.element = false;
                        Ref.ObjectRef objectRef = this.d;
                        objectRef.element = new Exception("Unsupport http code:" + i);
                    }
                    this.e.accept(new xn0(this.g.element, this.a.element, (String) this.b.element, (String) this.c.element, (Exception) this.d.element));
                    return;
                }
                this.e.accept(new xn0(false, this.a.element, (String) this.b.element, (String) this.c.element, (Exception) this.d.element));
            }
        }
    }

    public mn0() {
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

    /* JADX WARN: Type inference failed for: r11v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v2, types: [T, java.lang.String] */
    public void a(String url, rn0 meta, File toFile, sk0<sn0> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, url, meta, toFile, callback) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(meta, "meta");
            Intrinsics.checkNotNullParameter(toFile, "toFile");
            Intrinsics.checkNotNullParameter(callback, "callback");
            tn0 a2 = pn0.b().a();
            Intrinsics.checkNotNullExpressionValue(a2, "HttpFactory.getInstance().getHttp()");
            ho0 ho0Var = new ho0();
            ho0Var.k(url);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = meta.a;
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = meta.b;
            if (!meta.c) {
                if (!TextUtils.isEmpty((String) objectRef.element)) {
                    ho0Var.a("If-None-Match", (String) objectRef.element);
                }
                if (!TextUtils.isEmpty((String) objectRef2.element)) {
                    ho0Var.a("If-Modified-Since", (String) objectRef2.element);
                }
            }
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = 0L;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = true;
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.element = null;
            a2.b(ho0Var, new a(longRef, objectRef, objectRef2, objectRef3, callback, toFile, booleanRef));
        }
    }
}
