package com.repackage;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.SurfaceHolder;
import com.badlogic.gdx.backends.android.AndroidLiveWallpaperService;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes7.dex */
public final class r2 extends q2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends GLSurfaceView20 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(r2 r2Var, Context context, i3 i3Var) {
            super(context, i3Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r2Var, context, i3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (i3) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = r2Var;
        }

        @Override // android.view.SurfaceView
        public SurfaceHolder getHolder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e.y() : (SurfaceHolder) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r2(t2 t2Var, h2 h2Var, i3 i3Var) {
        super(t2Var, h2Var, i3Var, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t2Var, h2Var, i3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((g2) objArr2[0], (h2) objArr2[1], (i3) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.q2
    public GLSurfaceView20 i(g2 g2Var, i3 i3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, g2Var, i3Var)) == null) {
            if (g()) {
                GLSurfaceView.EGLConfigChooser l = l();
                a aVar = new a(this, g2Var.getContext(), i3Var);
                if (l != null) {
                    aVar.setEGLConfigChooser(l);
                } else {
                    h2 h2Var = this.s;
                    aVar.setEGLConfigChooser(h2Var.a, h2Var.b, h2Var.c, h2Var.d, h2Var.e, h2Var.f);
                }
                aVar.setRenderer(this);
                return aVar;
            }
            throw new GdxRuntimeException("Libgdx requires OpenGL ES 2.0");
        }
        return (GLSurfaceView20) invokeLL.objValue;
    }

    @Override // com.repackage.q2
    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && AndroidLiveWallpaperService.DEBUG) {
            super.o();
        }
    }

    @Override // com.repackage.q2, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gl10) == null) {
            long nanoTime = System.nanoTime();
            if (!this.q) {
                this.j = ((float) (nanoTime - this.i)) / 1.0E9f;
            } else {
                this.j = 0.0f;
            }
            this.i = nanoTime;
            synchronized (this.v) {
                z = this.o;
                z2 = this.p;
                z3 = this.r;
                z4 = this.q;
                if (this.q) {
                    this.q = false;
                    this.v.notifyAll();
                }
                if (this.p) {
                    this.p = false;
                    this.v.notifyAll();
                }
                if (this.r) {
                    this.r = false;
                    this.v.notifyAll();
                }
            }
            if (z4) {
                this.d.getApplicationListener().resume();
                e1.a.log("AndroidGraphics", "resumed");
            }
            if (z) {
                synchronized (this.d.getRunnables()) {
                    this.d.getExecutedRunnables().clear();
                    this.d.getExecutedRunnables().b(this.d.getRunnables());
                    this.d.getRunnables().clear();
                    for (int i = 0; i < this.d.getExecutedRunnables().b; i++) {
                        this.d.getExecutedRunnables().get(i).run();
                    }
                }
                this.d.getInput().R0();
                this.l++;
                this.d.getApplicationListener().render();
            }
            if (z2) {
                this.d.getApplicationListener().pause();
                e1.a.log("AndroidGraphics", "paused");
            }
            if (z3) {
                this.d.getApplicationListener().dispose();
                e1.a.log("AndroidGraphics", "destroyed");
            }
            if (nanoTime - this.k > C.NANOS_PER_SECOND) {
                this.m = 0;
                this.k = nanoTime;
            }
            this.m++;
        }
    }

    @Override // com.repackage.q2
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this.v) {
                this.o = true;
                this.q = true;
                while (this.q) {
                    try {
                        c();
                        this.v.wait();
                    } catch (InterruptedException unused) {
                        e1.a.log("AndroidGraphics", "waiting for resume synchronization failed!");
                    }
                }
            }
        }
    }

    public SurfaceHolder y() {
        InterceptResult invokeV;
        SurfaceHolder surfaceHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (((t2) this.d).a.sync) {
                surfaceHolder = ((t2) this.d).a.getSurfaceHolder();
            }
            return surfaceHolder;
        }
        return (SurfaceHolder) invokeV.objValue;
    }

    public void z() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (gLSurfaceView20 = this.a) == null) {
            return;
        }
        try {
            gLSurfaceView20.onDetachedFromWindow();
            if (AndroidLiveWallpaperService.DEBUG) {
                Log.d(AndroidLiveWallpaperService.TAG, " > AndroidLiveWallpaper - onDestroy() stopped GLThread managed by GLSurfaceView");
            }
        } catch (Throwable th) {
            Log.e(AndroidLiveWallpaperService.TAG, "failed to destroy GLSurfaceView's thread! GLSurfaceView.onDetachedFromWindow impl changed since API lvl 16!");
            th.printStackTrace();
        }
    }
}
