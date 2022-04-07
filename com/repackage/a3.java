package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a3 implements g2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SoundPool a;
    public final AudioManager b;
    public final List<s2> c;

    public a3(Context context, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, e2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        if (!e2Var.p) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.a = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build()).setMaxStreams(e2Var.q).build();
            } else {
                this.a = new SoundPool(e2Var.q, 3, 0);
            }
            this.b = (AudioManager) context.getSystemService("audio");
            if (context instanceof Activity) {
                ((Activity) context).setVolumeControlStream(3);
                return;
            }
            return;
        }
        this.a = null;
        this.b = null;
    }

    @Override // com.repackage.a1
    public c2 a(h3 h3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, h3Var)) == null) {
            if (this.a != null) {
                j2 j2Var = (j2) h3Var;
                if (j2Var.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = j2Var.u();
                        v2 v2Var = new v2(this.a, this.b, this.a.load(u, 1));
                        u.close();
                        return v2Var;
                    } catch (IOException e) {
                        throw new GdxRuntimeException("Error loading audio file: " + h3Var + "\nNote: Internal audio files must be placed in the assets directory.", e);
                    }
                }
                try {
                    return new v2(this.a, this.b, this.a.load(j2Var.e().getPath(), 1));
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Error loading audio file: " + h3Var, e2);
                }
            }
            throw new GdxRuntimeException("Android audio is not enabled by the application config.");
        }
        return (c2) invokeL.objValue;
    }

    @Override // com.repackage.g2
    public void d(s2 s2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s2Var) == null) {
            synchronized (this.c) {
                this.c.remove(this);
            }
        }
    }

    @Override // com.repackage.f7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a == null) {
            return;
        }
        synchronized (this.c) {
            Iterator it = new ArrayList(this.c).iterator();
            while (it.hasNext()) {
                ((s2) it.next()).dispose();
            }
        }
        this.a.release();
    }

    @Override // com.repackage.a1
    public b2 f(h3 h3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, h3Var)) == null) {
            if (this.a != null) {
                j2 j2Var = (j2) h3Var;
                MediaPlayer mediaPlayer = new MediaPlayer();
                if (j2Var.t() == Files.FileType.Internal) {
                    try {
                        AssetFileDescriptor u = j2Var.u();
                        mediaPlayer.setDataSource(u.getFileDescriptor(), u.getStartOffset(), u.getLength());
                        u.close();
                        mediaPlayer.prepare();
                        s2 s2Var = new s2(this, mediaPlayer);
                        synchronized (this.c) {
                            this.c.add(s2Var);
                        }
                        return s2Var;
                    } catch (Exception e) {
                        throw new GdxRuntimeException("Error loading audio file: " + h3Var + "\nNote: Internal audio files must be placed in the assets directory.", e);
                    }
                }
                try {
                    mediaPlayer.setDataSource(j2Var.e().getPath());
                    mediaPlayer.prepare();
                    s2 s2Var2 = new s2(this, mediaPlayer);
                    synchronized (this.c) {
                        this.c.add(s2Var2);
                    }
                    return s2Var2;
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Error loading audio file: " + h3Var, e2);
                }
            }
            throw new GdxRuntimeException("Android audio is not enabled by the application config.");
        }
        return (b2) invokeL.objValue;
    }

    @Override // com.repackage.g2
    public void pause() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a == null) {
            return;
        }
        synchronized (this.c) {
            for (s2 s2Var : this.c) {
                if (s2Var.a()) {
                    s2Var.pause();
                    s2Var.d = true;
                } else {
                    s2Var.d = false;
                }
            }
        }
        this.a.autoPause();
    }

    @Override // com.repackage.g2
    public void resume() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a == null) {
            return;
        }
        synchronized (this.c) {
            for (int i = 0; i < this.c.size(); i++) {
                if (this.c.get(i).d) {
                    this.c.get(i).f();
                }
            }
        }
        this.a.autoResume();
    }
}
