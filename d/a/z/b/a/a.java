package d.a.z.b.a;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaOneAEffect;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.StatusCode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<Runnable> f68671a;

    /* renamed from: b  reason: collision with root package name */
    public final String f68672b;

    /* renamed from: c  reason: collision with root package name */
    public final String f68673c;

    /* renamed from: d  reason: collision with root package name */
    public int f68674d;

    /* renamed from: e  reason: collision with root package name */
    public int f68675e;

    /* renamed from: f  reason: collision with root package name */
    public int f68676f;

    /* renamed from: g  reason: collision with root package name */
    public int f68677g;

    /* renamed from: h  reason: collision with root package name */
    public int f68678h;

    /* renamed from: i  reason: collision with root package name */
    public int f68679i;
    public int j;
    public boolean k;
    public int l;
    public final SparseArray<String> m;
    public final SparseArray<ShaderParams> n;
    public long o;
    public long p;
    public long q;
    public String r;
    public String s;
    public List<MediaOneAEffect> t;
    public long u;
    public long v;
    public List<ShaderParams> w;
    public long x;
    public float[] y;
    public float[] z;

    /* renamed from: d.a.z.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1958a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68680e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float[] f68681f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f68682g;

        public RunnableC1958a(a aVar, int i2, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68682g = aVar;
            this.f68680e = i2;
            this.f68681f = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68682g.g();
                GLES20.glUniformMatrix4fv(this.f68680e, 1, false, this.f68681f, 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68683e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68683e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68683e.g();
                GLES20.glUniform1f(this.f68683e.f68678h, 1.0f);
                this.f68683e.w();
                this.f68683e.z();
                this.f68683e.y();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68684e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f68685f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f68686g;

        public c(a aVar, int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68686g = aVar;
            this.f68684e = i2;
            this.f68685f = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68686g.g();
                GLES20.glUniform1f(this.f68684e, this.f68685f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68687e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float[] f68688f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f68689g;

        public d(a aVar, int i2, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68689g = aVar;
            this.f68687e = i2;
            this.f68688f = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68689g.g();
                GLES20.glUniform2fv(this.f68687e, 1, FloatBuffer.wrap(this.f68688f));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68690e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float[] f68691f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f68692g;

        public e(a aVar, int i2, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68692g = aVar;
            this.f68690e = i2;
            this.f68691f = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68692g.g();
                GLES20.glUniform3fv(this.f68690e, 1, FloatBuffer.wrap(this.f68691f));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68693e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float[] f68694f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f68695g;

        public f(a aVar, int i2, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68695g = aVar;
            this.f68693e = i2;
            this.f68694f = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68695g.g();
                GLES20.glUniform4fv(this.f68693e, 1, FloatBuffer.wrap(this.f68694f));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68696e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float[] f68697f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f68698g;

        public g(a aVar, int i2, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68698g = aVar;
            this.f68696e = i2;
            this.f68697f = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68698g.g();
                int i2 = this.f68696e;
                float[] fArr = this.f68697f;
                GLES20.glUniform1fv(i2, fArr.length, FloatBuffer.wrap(fArr));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68699e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float[] f68700f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f68701g;

        public h(a aVar, int i2, float[] fArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), fArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68701g = aVar;
            this.f68699e = i2;
            this.f68700f = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68701g.g();
                GLES20.glUniformMatrix3fv(this.f68699e, 1, false, this.f68700f, 0);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision highp float;\n \nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform float alpha;\n \nvoid main()\n{\n     vec4 inputColor = texture2D(inputImageTexture, textureCoordinate);\n     gl_FragColor = vec4(inputColor.rgb, inputColor.a * alpha);\n}");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append('\n');
                } else {
                    bufferedReader.close();
                    fileInputStream.close();
                    return sb.toString();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String n(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, context, i2)) == null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i2)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append('\n');
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return sb.toString();
        }
        return (String) invokeLI.objValue;
    }

    public final float A(ShaderParams shaderParams, float f2) {
        InterceptResult invokeLF;
        double cos;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048576, this, shaderParams, f2)) == null) {
            if (shaderParams.interpolator == null) {
                shaderParams.interpolator = "";
            }
            String str = shaderParams.interpolator;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1383205240:
                    if (str.equals("bounce")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -1354466595:
                    if (str.equals("accelerate")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1263948740:
                    if (str.equals("decelerate")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -749065269:
                    if (str.equals("overshoot")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 95131878:
                    if (str.equals("cycle")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 475910905:
                    if (str.equals("accelerateDecelerate")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1088816001:
                    if (str.equals("anticipateOvershoot")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return Math.abs(f2 * f2);
                case 1:
                    float f5 = 1.0f - f2;
                    return 1.0f - (f5 * f5);
                case 2:
                    cos = (Math.cos((f2 + 1.0f) * 3.141592653589793d) / 2.0d) + 0.5d;
                    break;
                case 3:
                    float f6 = f2 - 1.0f;
                    return (f6 * f6 * ((f6 * 3.0f) + 2.0f)) + 1.0f;
                case 4:
                    cos = Math.sin(f2 * 6.283185307179586d);
                    break;
                case 5:
                    if (f2 < 0.5f) {
                        return (((f2 * 4.0f) * 2.0f) - 3.0f) * 0.5f * f2 * 2.0f * f2 * 2.0f;
                    }
                    float f7 = f2 * 2.0f;
                    return (((f7 - (f7 * 2.0f)) - (((((f2 * 4.0f) * 2.0f) - 2.0f) + 3.0f) * 2.0f)) + 2.0f) * 0.5f;
                case 6:
                    float f8 = f2 * 1.1226f;
                    if (f8 < 0.3535f) {
                        return f8 * f8 * 8.0f;
                    }
                    if (f8 < 0.7408f) {
                        float f9 = f8 - 0.54719f;
                        f3 = f9 * f9 * 8.0f;
                        f4 = 0.7f;
                    } else if (f8 < 0.9644f) {
                        float f10 = f8 - 0.8526f;
                        f3 = f10 * f10 * 8.0f;
                        f4 = 0.9f;
                    } else {
                        float f11 = f8 - 1.0435f;
                        f3 = f11 * f11 * 8.0f;
                        f4 = 0.95f;
                    }
                    return f3 + f4;
                default:
                    return f2;
            }
            return (float) cos;
        }
        return invokeLF.floatValue;
    }

    public void B(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            synchronized (this.f68671a) {
                this.f68671a.addLast(runnable);
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            while (!this.f68671a.isEmpty()) {
                this.f68671a.removeFirst().run();
            }
        }
    }

    public void D(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            G(this.f68678h, f2, true);
        }
    }

    public void E(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.x = j;
        }
    }

    public void F(String str, long j, long j2, long j3, String str2, List<MediaOneAEffect> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str2, list}) == null) {
            this.r = str;
            this.p = j;
            this.q = j2;
            this.o = j3;
            this.s = str2;
            this.t = list;
        }
    }

    public void G(int i2, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            if (z) {
                B(new c(this, i2, f2));
            } else {
                GLES20.glUniform1f(i2, f2);
            }
        }
    }

    public void H(int i2, float[] fArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), fArr, Boolean.valueOf(z)}) == null) {
            if (z) {
                B(new g(this, i2, fArr));
            } else {
                GLES20.glUniform1fv(i2, fArr.length, FloatBuffer.wrap(fArr));
            }
        }
    }

    public void I(int i2, float[] fArr, boolean z) {
        int length;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), fArr, Boolean.valueOf(z)}) == null) || (length = fArr.length) == 0) {
            return;
        }
        if (length == 1) {
            G(i2, fArr[0], z);
        } else if (length == 2) {
            K(i2, fArr, z);
        } else if (length == 3) {
            L(i2, fArr, z);
        } else if (length == 4) {
            M(i2, fArr, z);
        } else if (length == 9) {
            R(i2, fArr, z);
        } else if (length != 16) {
            H(i2, fArr, z);
        } else {
            S(i2, fArr, z);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            B(new b(this));
        }
    }

    public void K(int i2, float[] fArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), fArr, Boolean.valueOf(z)}) == null) {
            if (z) {
                B(new d(this, i2, fArr));
            } else {
                GLES20.glUniform2fv(i2, 1, FloatBuffer.wrap(fArr));
            }
        }
    }

    public void L(int i2, float[] fArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), fArr, Boolean.valueOf(z)}) == null) {
            if (z) {
                B(new e(this, i2, fArr));
            } else {
                GLES20.glUniform3fv(i2, 1, FloatBuffer.wrap(fArr));
            }
        }
    }

    public void M(int i2, float[] fArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), fArr, Boolean.valueOf(z)}) == null) {
            if (z) {
                B(new f(this, i2, fArr));
            } else {
                GLES20.glUniform4fv(i2, 1, FloatBuffer.wrap(fArr));
            }
        }
    }

    public final void N(float[] fArr, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048589, this, fArr, f2) == null) {
            float[] fArr2 = new float[16];
            int i2 = this.f68679i;
            int i3 = this.j;
            if (i2 > i3) {
                float f3 = i2 / i3;
                Matrix.orthoM(fArr2, 0, -f3, f3, -1.0f, 1.0f, -1.0f, 1.0f);
                Matrix.scaleM(fArr, 0, f3, 1.0f, 1.0f);
            } else {
                float f4 = i3 / i2;
                Matrix.orthoM(fArr2, 0, -1.0f, 1.0f, -f4, f4, -1.0f, 1.0f);
                Matrix.scaleM(fArr, 0, 1.0f, f4, 1.0f);
            }
            float[] fArr3 = new float[16];
            Matrix.multiplyMM(fArr3, 0, fArr2, 0, fArr, 0);
            S(i(), fArr3, false);
            if (f2 != 1.0f) {
                GLES20.glUniform1f(this.f68678h, f2);
            }
        }
    }

    public final float O(float[] fArr, float f2, ShaderParams shaderParams) {
        InterceptResult invokeCommon;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{fArr, Float.valueOf(f2), shaderParams})) == null) {
            float A = A(shaderParams, f2);
            float[] fArr2 = shaderParams.values;
            float f4 = ((fArr2[1] - fArr2[0]) * A) + fArr2[0];
            if (AnimatedStateListDrawableCompat.ELEMENT_TRANSITION.equals(shaderParams.name)) {
                float[] fArr3 = shaderParams.values;
                f3 = ((fArr3[3] - fArr3[2]) * A) + fArr3[2];
            } else {
                f3 = 0.0f;
            }
            if ("value".equals(shaderParams.type)) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(j(), shaderParams.name), f4);
            } else {
                r0 = "alpha".equals(shaderParams.name) ? f4 : 1.0f;
                x(shaderParams, fArr, f4, f3);
            }
            return r0;
        }
        return invokeCommon.floatValue;
    }

    public final float P(float f2, float[] fArr, float f3, List<ShaderParams> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), fArr, Float.valueOf(f3), list})) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ShaderParams shaderParams = list.get(i2);
                if (!"value".equals(shaderParams.type) && !ShaderParams.VALUE_TYPE_ANIMATOR.equals(shaderParams.type)) {
                    T(GLES20.glGetUniformLocation(j(), shaderParams.name), shaderParams);
                } else {
                    f2 = O(fArr, f3, shaderParams);
                }
            }
            return f2;
        }
        return invokeCommon.floatValue;
    }

    public void Q(long j, long j2, List<ShaderParams> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), list}) == null) {
            this.u = j;
            this.v = j2;
            this.w = list;
        }
    }

    public void R(int i2, float[] fArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), fArr, Boolean.valueOf(z)}) == null) {
            if (z) {
                B(new h(this, i2, fArr));
            } else {
                GLES20.glUniformMatrix3fv(i2, 1, false, fArr, 0);
            }
        }
    }

    public void S(int i2, float[] fArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), fArr, Boolean.valueOf(z)}) == null) {
            if (z) {
                B(new RunnableC1958a(this, i2, fArr));
            } else {
                GLES20.glUniformMatrix4fv(i2, 1, false, fArr, 0);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r3 >= r7) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T(int i2, ShaderParams shaderParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i2, shaderParams) == null) {
            if (ShaderParams.VALUE_TYPE_FLOAT.equals(shaderParams.type)) {
                float[] fArr = shaderParams.values;
                if (fArr != null && fArr.length > 0) {
                    if (fArr.length > 1) {
                        long j = this.x;
                        long j2 = shaderParams.timeInterval;
                        if (j2 != 0) {
                            long j3 = shaderParams.lastTimeInterval;
                            if (j - j3 <= j2) {
                            }
                        }
                        int i3 = shaderParams.valuesPointer + 1;
                        shaderParams.valuesPointer = i3;
                        if (i3 >= shaderParams.values.length) {
                            shaderParams.valuesPointer = 0;
                        }
                        shaderParams.lastTimeInterval = j;
                    } else {
                        shaderParams.valuesPointer = 0;
                    }
                }
                float[] fArr2 = shaderParams.values;
                if (fArr2 != null) {
                    int length = fArr2.length;
                    int i4 = shaderParams.valuesPointer;
                    if (length > i4) {
                        GLES20.glUniform1f(i2, fArr2[i4]);
                    }
                }
            } else if ("array".equals(shaderParams.type)) {
                float[] fArr3 = shaderParams.values;
                if (fArr3 == null || fArr3.length <= 0) {
                    return;
                }
                I(i2, fArr3, false);
            } else if (ShaderParams.VALUE_TYPE_STEP.equals(shaderParams.type)) {
                float[] fArr4 = shaderParams.values;
                if (fArr4 == null || fArr4.length < 3) {
                    return;
                }
                float f2 = fArr4[0];
                int i5 = shaderParams.valuesPointer;
                float f3 = f2 + (i5 * fArr4[2]);
                shaderParams.valuesPointer = i5 + 1;
                if (f3 > fArr4[1]) {
                    f3 = fArr4[1];
                }
                GLES20.glUniform1f(i2, f3);
            } else if (ShaderParams.IMAGE_WIDTH.equals(shaderParams.name)) {
                GLES20.glUniform1f(i2, this.f68679i);
            } else if (ShaderParams.IMAGE_HEIGHT.equals(shaderParams.name)) {
                GLES20.glUniform1f(i2, this.j);
            }
        }
    }

    public void e(int i2, String str, ShaderParams shaderParams) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048596, this, i2, str, shaderParams) == null) || shaderParams == null) {
            return;
        }
        this.m.put(i2, str);
        this.n.put(i2, shaderParams);
    }

    public final boolean f(MediaOneAEffect mediaOneAEffect, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048597, this, mediaOneAEffect, j)) == null) {
            if (TextUtils.equals(this.r, "end")) {
                return this.q - mediaOneAEffect.end <= j;
            }
            long j2 = mediaOneAEffect.start;
            long j3 = this.p;
            return j2 + j3 <= j && mediaOneAEffect.end + j3 >= j;
        }
        return invokeLJ.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.k) {
            return;
        }
        l();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.k = false;
            GLES20.glDeleteProgram(this.f68674d);
            o();
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f68674d : invokeV.intValue;
    }

    public final float k(long j, long j2, MediaOneAEffect mediaOneAEffect) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), mediaOneAEffect})) == null) {
            long j3 = mediaOneAEffect.end - mediaOneAEffect.start;
            float f2 = 1.0f;
            if (TextUtils.equals(this.r, "end")) {
                long j4 = this.q;
                if (j4 - mediaOneAEffect.end > 0) {
                    long j5 = j4 - j;
                    f2 = (j5 < j3 || j5 % j3 != 0) ? 1.0f - (((float) (j5 % j3)) / (((float) j3) * 1.0f)) : 0.0f;
                    return Math.abs(((float) j2) - f2);
                }
            }
            long j6 = j - (mediaOneAEffect.start + this.p);
            if (j6 < j3 || j6 % j3 != 0) {
                f2 = ((float) (j6 % j3)) / (((float) j3) * 1.0f);
            }
            return Math.abs(((float) j2) - f2);
        }
        return invokeCommon.floatValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.k) {
            return;
        }
        t();
        u();
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    public void p(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048605, this, i2, floatBuffer, floatBuffer2) == null) {
            d.a.z.b.a.g.a("draw start");
            GLES20.glUseProgram(this.f68674d);
            d.a.z.b.a.g.a("glUseProgram");
            C();
            if (this.k) {
                if (i2 != -1) {
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(this.l, i2);
                    GLES20.glUniform1i(this.f68676f, 0);
                }
                floatBuffer.position(0);
                GLES20.glEnableVertexAttribArray(this.f68675e);
                d.a.z.b.a.g.a("glEnableVertexAttribPositionArray");
                GLES20.glVertexAttribPointer(this.f68675e, 2, (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, 0, (Buffer) floatBuffer);
                d.a.z.b.a.g.a("glVertexAttribPositionPointer");
                floatBuffer2.position(0);
                GLES20.glEnableVertexAttribArray(this.f68677g);
                d.a.z.b.a.g.a("glEnableVertexAttribTextureArray");
                GLES20.glVertexAttribPointer(this.f68677g, 2, (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, 0, (Buffer) floatBuffer2);
                d.a.z.b.a.g.a("glVertexAttribTexturePointer");
                r();
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(this.f68675e);
                GLES20.glDisableVertexAttribArray(this.f68677g);
                q();
                GLES20.glBindTexture(this.l, 0);
                GLES20.glUseProgram(0);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            int e2 = d.a.z.b.a.g.e(this.f68672b, this.f68673c);
            this.f68674d = e2;
            this.f68675e = GLES20.glGetAttribLocation(e2, "position");
            this.f68676f = GLES20.glGetUniformLocation(this.f68674d, "inputImageTexture");
            this.f68677g = GLES20.glGetAttribLocation(this.f68674d, "inputTextureCoordinate");
            this.f68678h = GLES20.glGetUniformLocation(this.f68674d, "alpha");
            this.k = true;
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    public void v(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048611, this, i2, i3) == null) {
            this.f68679i = i2;
            this.j = i3;
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || this.t == null) {
            return;
        }
        long j = this.x;
        long j2 = 0;
        if (MediaAEffect.AE_ANIM_REPEAT.equals(this.s)) {
            long j3 = this.p;
            j = ((j - j3) % this.o) + j3;
        } else if (MediaAEffect.AE_ANIM_REVERSE.equals(this.s)) {
            long j4 = this.p;
            long j5 = this.o;
            j = ((j - j4) % j5) + j4;
            j2 = ((j - j4) / j5) % 2;
        }
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        float f2 = 1.0f;
        for (MediaOneAEffect mediaOneAEffect : this.t) {
            if (f(mediaOneAEffect, j) && mediaOneAEffect.aParams != null) {
                float k = k(j, j2, mediaOneAEffect);
                if (k >= 0.0f && k <= 1.0f) {
                    f2 = P(f2, fArr, k, mediaOneAEffect.aParams);
                }
            }
        }
        N(fArr, f2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void x(ShaderParams shaderParams, float[] fArr, float... fArr2) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048613, this, shaderParams, fArr, fArr2) == null) {
            float f2 = fArr2[0];
            String str = shaderParams.name;
            switch (str.hashCode()) {
                case -1909310045:
                    if (str.equals("transitionX")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1909310044:
                    if (str.equals("transitionY")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1724158635:
                    if (str.equals(AnimatedStateListDrawableCompat.ELEMENT_TRANSITION)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109250890:
                    if (str.equals("scale")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    Matrix.scaleM(fArr, 0, f2, f2, 1.0f);
                    return;
                case 1:
                    Matrix.scaleM(fArr, 0, f2, 1.0f, 1.0f);
                    return;
                case 2:
                    Matrix.scaleM(fArr, 0, 1.0f, f2, 1.0f);
                    return;
                case 3:
                    Matrix.translateM(fArr, 0, f2 * 2.0f, 0.0f, 0.0f);
                    return;
                case 4:
                    Matrix.translateM(fArr, 0, 0.0f, f2 * 2.0f, 0.0f);
                    return;
                case 5:
                    Matrix.translateM(fArr, 0, f2 * 2.0f, fArr2[1] * 2.0f, 1.0f);
                    return;
                case 6:
                    float[] fArr3 = shaderParams.values;
                    if (fArr3.length != 2) {
                        f2 *= fArr3[2];
                    }
                    Matrix.rotateM(fArr, 0, f2, 0.0f, 0.0f, 1.0f);
                    return;
                default:
                    return;
            }
        }
    }

    public final void y() {
        ShaderParams shaderParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || this.m.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            int keyAt = this.m.keyAt(i2);
            if (this.n.size() > 0 && (shaderParams = this.n.get(keyAt)) != null) {
                T(keyAt, shaderParams);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.w == null) {
            return;
        }
        long j = this.x;
        long j2 = this.v;
        if (j == j2) {
            return;
        }
        long j3 = this.u;
        long j4 = j2 - j3;
        long j5 = j - j3;
        float f2 = (j5 < j4 || j5 % j4 != 0) ? ((float) (j5 % j4)) / (((float) j4) * 1.0f) : 1.0f;
        if (f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        N(fArr, P(1.0f, fArr, f2, this.w));
    }

    public a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 3553;
        this.f68671a = new LinkedList<>();
        this.m = new SparseArray<>();
        this.n = new SparseArray<>();
        this.f68672b = str;
        this.f68673c = str2;
        if (TextUtils.isEmpty(str2) || !str2.contains("samplerExternalOES") || str2.contains("sampler2D")) {
            return;
        }
        this.l = 36197;
    }
}
