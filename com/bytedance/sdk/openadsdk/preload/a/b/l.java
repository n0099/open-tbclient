package com.bytedance.sdk.openadsdk.preload.a.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.b.a.n;
import com.bytedance.sdk.openadsdk.preload.a.p;
import com.bytedance.sdk.openadsdk.preload.a.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes5.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.bytedance.sdk.openadsdk.preload.a.l a(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws p {
        boolean z;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65536, null, aVar)) != null) {
            return (com.bytedance.sdk.openadsdk.preload.a.l) invokeL.objValue;
        }
        try {
            try {
                aVar.f();
                z = false;
                try {
                    return n.X.b(aVar);
                } catch (EOFException e2) {
                    e = e2;
                    if (z) {
                        return com.bytedance.sdk.openadsdk.preload.a.n.f32263a;
                    }
                    throw new t(e);
                }
            } catch (EOFException e3) {
                e = e3;
                z = true;
            }
        } catch (com.bytedance.sdk.openadsdk.preload.a.d.d e4) {
            throw new t(e4);
        } catch (IOException e5) {
            throw new com.bytedance.sdk.openadsdk.preload.a.m(e5);
        } catch (NumberFormatException e6) {
            throw new t(e6);
        }
    }

    /* loaded from: classes5.dex */
    public static final class a extends Writer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Appendable f32193a;

        /* renamed from: b  reason: collision with root package name */
        public final C0365a f32194b;

        /* renamed from: com.bytedance.sdk.openadsdk.preload.a.b.l$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0365a implements CharSequence {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public char[] f32195a;

            public C0365a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.CharSequence
            public char charAt(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f32195a[i2] : invokeI.charValue;
            }

            @Override // java.lang.CharSequence
            public int length() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32195a.length : invokeV.intValue;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i2, int i3) {
                InterceptResult invokeII;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) ? new String(this.f32195a, i2, i3 - i2) : (CharSequence) invokeII.objValue;
            }
        }

        public a(Appendable appendable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appendable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32194b = new C0365a();
            this.f32193a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, cArr, i2, i3) == null) {
                C0365a c0365a = this.f32194b;
                c0365a.f32195a = cArr;
                this.f32193a.append(c0365a, i2, i3 + i2);
            }
        }

        @Override // java.io.Writer
        public void write(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f32193a.append((char) i2);
            }
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.preload.a.l lVar, com.bytedance.sdk.openadsdk.preload.a.d.c cVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, lVar, cVar) == null) {
            n.X.a(cVar, lVar);
        }
    }

    public static Writer a(Appendable appendable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, appendable)) == null) ? appendable instanceof Writer ? (Writer) appendable : new a(appendable) : (Writer) invokeL.objValue;
    }
}
