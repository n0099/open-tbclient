package com.repackage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
/* loaded from: classes7.dex */
public class x3 extends x1<w3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;
    public com.badlogic.gdx.math.a c;

    /* loaded from: classes7.dex */
    public static class a extends h1<w3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String b;
        public int c;
        public String[] d;

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
                    return;
                }
            }
            this.b = "i ";
            this.c = 1024;
            this.d = new String[]{"png", "PNG", "jpeg", "JPEG", "jpg", "JPG", "cim", "CIM", "etc1", "ETC1", "ktx", "KTX", "zktx", "ZKTX"};
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x3(o1 o1Var) {
        super(o1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((o1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a();
        this.c = new com.badlogic.gdx.math.a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.k1
    /* renamed from: d */
    public y6<f1> a(String str, h3 h3Var, a aVar) {
        InterceptResult invokeLLL;
        String str2;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, h3Var, aVar)) == null) {
            if (aVar == null) {
                aVar = this.b;
            }
            try {
                BufferedReader q = h3Var.q(aVar.c);
                while (true) {
                    String readLine = q.readLine();
                    if (readLine != null) {
                        if (readLine.startsWith(aVar.b)) {
                            str2 = readLine.substring(aVar.b.length());
                            break;
                        }
                    } else {
                        str2 = null;
                        break;
                    }
                }
                q.close();
                if (str2 == null && (strArr = aVar.d) != null) {
                    for (String str3 : strArr) {
                        h3 s = h3Var.s(h3Var.h().concat("." + str3));
                        if (s.c()) {
                            str2 = s.g();
                        }
                    }
                }
                if (str2 != null) {
                    y6<f1> y6Var = new y6<>(1);
                    y6Var.a(new f1(h3Var.s(str2), Texture.class));
                    return y6Var;
                }
                return null;
            } catch (IOException e) {
                throw new GdxRuntimeException("Error reading " + str, e);
            }
        }
        return (y6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.x1
    /* renamed from: e */
    public w3 c(j1 j1Var, String str, h3 h3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, j1Var, str, h3Var, aVar)) == null) ? f(new a4((Texture) j1Var.i(j1Var.n(str).f())), h3Var) : (w3) invokeLLLL.objValue;
    }

    public w3 f(a4 a4Var, h3 h3Var) {
        InterceptResult invokeLL;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, a4Var, h3Var)) == null) {
            BufferedReader q = h3Var.q(256);
            do {
                try {
                    try {
                        readLine = q.readLine();
                        if (readLine == null) {
                            g8.a(q);
                            throw new GdxRuntimeException("Polygon shape not found: " + h3Var);
                        }
                    } catch (IOException e) {
                        throw new GdxRuntimeException("Error reading polygon shape file: " + h3Var, e);
                    }
                } finally {
                    g8.a(q);
                }
            } while (!readLine.startsWith("s"));
            String[] split = readLine.substring(1).trim().split(",");
            int length = split.length;
            float[] fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = Float.parseFloat(split[i]);
            }
            return new w3(a4Var, fArr, this.c.c(fArr).f());
        }
        return (w3) invokeLL.objValue;
    }
}
