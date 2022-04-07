package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.repackage.y6;
import com.tachikoma.core.utility.FileUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes7.dex */
public class v3 implements f7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y6<ParticleEmitter> a;
    public boolean b;

    public v3() {
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
        this.a = new y6<>(8);
    }

    public void a(h3 h3Var, h3 h3Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, h3Var, h3Var2) == null) {
            i(h3Var);
            g(h3Var2);
        }
    }

    @Override // com.repackage.f7
    public void dispose() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b) {
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                y6.b<y3> it = this.a.get(i2).g().iterator();
                while (it.hasNext()) {
                    it.next().f().dispose();
                }
            }
        }
    }

    public void f(h3 h3Var, z3 z3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, h3Var, z3Var, str) == null) {
            i(h3Var);
            h(z3Var, str);
        }
    }

    public void g(h3 h3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, h3Var) == null) {
            this.b = true;
            u7 u7Var = new u7(this.a.b);
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                ParticleEmitter particleEmitter = this.a.get(i2);
                if (particleEmitter.f().b != 0) {
                    y6<y3> y6Var = new y6<>();
                    y6.b<String> it = particleEmitter.f().iterator();
                    while (it.hasNext()) {
                        String name = new File(it.next().replace(FileUtil.WINDOWS_SEPARATOR, WebvttCueParser.CHAR_SLASH)).getName();
                        y3 y3Var = (y3) u7Var.c(name);
                        if (y3Var == null) {
                            y3Var = new y3(j(h3Var.a(name)));
                            u7Var.i(name, y3Var);
                        }
                        y6Var.a(y3Var);
                    }
                    particleEmitter.u(y6Var);
                }
            }
        }
    }

    public void h(z3 z3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, z3Var, str) == null) {
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                ParticleEmitter particleEmitter = this.a.get(i2);
                if (particleEmitter.f().b != 0) {
                    y6<y3> y6Var = new y6<>();
                    y6.b<String> it = particleEmitter.f().iterator();
                    while (it.hasNext()) {
                        String name = new File(it.next().replace(FileUtil.WINDOWS_SEPARATOR, WebvttCueParser.CHAR_SLASH)).getName();
                        int lastIndexOf = name.lastIndexOf(46);
                        if (lastIndexOf != -1) {
                            name = name.substring(0, lastIndexOf);
                        }
                        if (str != null) {
                            name = str + name;
                        }
                        y3 a = z3Var.a(name);
                        if (a != null) {
                            y6Var.a(a);
                        } else {
                            throw new IllegalArgumentException("SpriteSheet missing image: " + name);
                        }
                    }
                    particleEmitter.u(y6Var);
                }
            }
        }
    }

    public void i(h3 h3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048581, this, h3Var) != null) {
            return;
        }
        InputStream m = h3Var.m();
        this.a.clear();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(m), 512);
                do {
                    try {
                        this.a.a(k(bufferedReader2));
                    } catch (IOException e) {
                        e = e;
                        throw new GdxRuntimeException("Error loading effect: " + h3Var, e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        g8.a(bufferedReader);
                        throw th;
                    }
                } while (bufferedReader2.readLine() != null);
                g8.a(bufferedReader2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public Texture j(h3 h3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, h3Var)) == null) ? new Texture(h3Var, false) : (Texture) invokeL.objValue;
    }

    public ParticleEmitter k(BufferedReader bufferedReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bufferedReader)) == null) ? new ParticleEmitter(bufferedReader) : (ParticleEmitter) invokeL.objValue;
    }

    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) {
            int i = this.a.b;
            for (int i2 = 0; i2 < i; i2++) {
                this.a.get(i2).update(f);
            }
        }
    }
}
