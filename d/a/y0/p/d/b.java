package d.a.y0.p.d;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.player.IPlayer;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.ugc.editvideo.record.source.IDataSourceView;
import com.faceunity.gles.GeneratedTexture;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes9.dex */
public class b extends d.a.y0.p.d.a implements IDataSourceView.IPlayerDataSourceView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public int E;

    /* renamed from: i  reason: collision with root package name */
    public int f71301i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public SurfaceTexture q;
    public float[] r;
    public FullFrameRect s;
    public int t;
    public int u;
    public a v;
    public boolean w;
    public int x;
    public int[] y;
    public int z;

    /* loaded from: classes9.dex */
    public interface a {
        void a(SurfaceTexture surfaceTexture);

        void a(GL10 gl10, int i2, int i3);
    }

    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int i4 = this.j;
            int i5 = this.k;
            int i6 = (this.D ? this.l : this.n) + i4;
            if (this.D) {
                i2 = this.k;
                i3 = this.m;
            } else {
                i2 = this.k;
                i3 = this.o;
            }
            return (x <= ((float) i4) || x >= ((float) i6) || y <= ((float) i5) || y >= ((float) (i2 + i3))) ? !this.D : this.D;
        }
        return invokeL.booleanValue;
    }

    public boolean e(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? !d(motionEvent) : invokeL.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.x == 0) {
            this.x = this.mFullScreen2D.createTexture2DObject();
            GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, this.t, this.u, 0, GeneratedTexture.FORMAT, 5121, null);
            GLES20.glBindTexture(3553, 0);
            GLES20.glGenFramebuffers(1, this.y, 0);
            this.z = this.y[0];
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SurfaceTexture surfaceTexture = this.q;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.q = null;
            }
            int i2 = this.p;
            if (i2 != 0) {
                GLES20.glDeleteTextures(1, new int[]{i2}, 0);
                this.p = 0;
            }
            h();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.x == 0) {
            return;
        }
        GLES20.glDeleteFramebuffers(1, this.y, 0);
        GLES20.glDeleteTextures(1, new int[]{this.x}, 0);
        this.x = 0;
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onCompletion(IPlayer iPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iPlayer) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // d.a.y0.p.d.a, com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onDestroyInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroyInGlThread();
            g();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onError(IPlayer iPlayer, int i2, int i3, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{iPlayer, Integer.valueOf(i2), Integer.valueOf(i3), exc}) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onGLLocation(GLViewPortLocation gLViewPortLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gLViewPortLocation) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onInfo(IPlayer iPlayer, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, iPlayer, i2, i3) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // d.a.y0.p.d.a, com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onPauseInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPauseInGlThread();
            g();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onPlayStateListener(IPlayer iPlayer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, iPlayer, i2) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onPrepared(IPlayer iPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iPlayer) == null) {
            iPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048592, this, gl10, i2, i3) == null) {
            super.onSurfaceChanged(gl10, i2, i3);
            a aVar = this.v;
            if (aVar != null) {
                aVar.a(gl10, i2, i3);
            }
            if (i2 != this.t || i3 != this.u) {
                h();
            }
            this.t = i2;
            this.u = i3;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, fullFrameRect, fullFrameRect2) == null) {
            super.onSurfaceCreate(fullFrameRect, fullFrameRect2);
            this.s = fullFrameRect;
            if (fullFrameRect != null) {
                this.p = fullFrameRect.createTextureObject();
            }
            if (this.C) {
                try {
                    new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_FOLLOW));
                } catch (Exception e2) {
                    d.a.y0.t.c.d(e2.getMessage());
                }
            }
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.p);
            this.q = surfaceTexture;
            a aVar = this.v;
            if (aVar != null) {
                aVar.a(surfaceTexture);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.IDataSourceView.IPlayerDataSourceView
    public void onVideoSizeChanged(int i2, int i3) {
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048594, this, i2, i3) == null) || i2 == 0 || i3 == 0) {
            return;
        }
        int i6 = this.f71301i;
        if (i6 == 90 || i6 == 270) {
            i3 = i2;
            i2 = i3;
        }
        if (this.n == 0 && this.o == 0) {
            this.n = this.l;
            this.o = this.m;
        }
        if (this.E == 0) {
            if (this.l == 0 || (i5 = this.m) == 0) {
                return;
            }
            if (i2 > i3) {
                this.n = i5;
            }
            i4 = (int) (((this.n * i3) * 1.0f) / i2);
        } else if (this.l == 0 || this.m == 0) {
            return;
        } else {
            this.s.setAngle(270.0f);
            if (i3 > i2) {
                this.n = this.m;
            }
            i4 = (int) (((this.n * i2) * 1.0f) / i3);
        }
        this.o = i4;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.w = z;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setScaleAndTranslate(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setTextureMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
        }
    }
}
