package d.a.q0.v3.l;

import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.ProgressView;
import com.baidu.tieba.video.record.RecordVideoActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.encoder.TextureMovieEncoder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f66280a;

    /* renamed from: b  reason: collision with root package name */
    public int f66281b;

    /* renamed from: c  reason: collision with root package name */
    public RecordVideoActivity f66282c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressView f66283d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f66284e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66285f;

    /* renamed from: g  reason: collision with root package name */
    public long f66286g;

    /* renamed from: h  reason: collision with root package name */
    public int f66287h;

    /* loaded from: classes8.dex */
    public class a implements ProgressView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f66288a;

        /* renamed from: d.a.q0.v3.l.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1820a implements TextureMovieEncoder.OnEncoderStatusUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f66289a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f66290b;

            /* renamed from: d.a.q0.v3.l.i$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC1821a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C1820a f66291e;

                public RunnableC1821a(C1820a c1820a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1820a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66291e = c1820a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f66291e.f66290b.f66288a.f66282c == null) {
                        return;
                    }
                    this.f66291e.f66290b.f66288a.f66282c.onRecordDone();
                }
            }

            public C1820a(a aVar, g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66290b = aVar;
                this.f66289a = gVar;
            }

            @Override // com.faceunity.encoder.TextureMovieEncoder.OnEncoderStatusUpdateListener
            public void onStartSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.faceunity.encoder.TextureMovieEncoder.OnEncoderStatusUpdateListener
            public void onStopSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    d.a.d.e.m.e.a().post(new RunnableC1821a(this));
                    this.f66289a.setOnEncoderStatusUpdateListener(null);
                }
            }
        }

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66288a = iVar;
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i2) {
            h hVar;
            g q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f66288a.f66287h = i2;
                if (i2 != 100 || this.f66288a.f66282c == null || (hVar = this.f66288a.f66282c.mPreviewController) == null || (q = hVar.q()) == null) {
                    return;
                }
                if (q instanceof GLVideoPreviewView) {
                    q.setOnEncoderStatusUpdateListener(new C1820a(this, q));
                    this.f66288a.o();
                    return;
                }
                this.f66288a.o();
                if (this.f66288a.f66282c != null) {
                    this.f66288a.f66282c.onRecordDone();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i2);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recordVideoActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66280a = 1;
        this.f66282c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.camera_switch);
        ImageView imageView2 = (ImageView) this.f66282c.findViewById(R.id.flash_switch);
        ProgressView progressView = (ProgressView) this.f66282c.findViewById(R.id.video_progress_view);
        this.f66283d = progressView;
        progressView.setListener(new a(this));
        if (!d.a.q0.v3.l.a.f(true)) {
            imageView2.setVisibility(4);
        }
        if (d.a.q0.v3.l.a.g(recordVideoActivity.getPackageManager())) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (this.f66284e == null) {
                this.f66284e = new ArrayList();
            }
            this.f66284e.add(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ProgressView progressView = this.f66283d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.DELETE);
            }
            this.f66281b = this.f66283d.getLastProgress();
            h hVar = this.f66282c.mPreviewController;
            if (hVar != null) {
                hVar.h();
            }
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66287h : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f66280a : invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f66281b : invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f66280a == 6 : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            j jVar = this.f66282c.mMusicController;
            if (jVar != null) {
                return jVar.i();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int f2 = f();
            return f2 == 2 || f2 == 7;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f66283d.b() : invokeV.booleanValue;
    }

    public void l() {
        ProgressView progressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f66285f || (progressView = this.f66283d) == null) {
            return;
        }
        progressView.setCurrentState(ProgressView.State.ROLLBACK);
    }

    public void m(int i2) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f66280a = i2;
            if (i2 == 1) {
                this.f66283d.setVisibility(4);
                this.f66283d.d();
                this.f66281b = 0;
                File file = new File(d.a.q0.v3.c.f66023f);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2.getPath().startsWith("rec_tmp_")) {
                            file2.delete();
                        }
                    }
                }
            }
            List<b> list = this.f66284e;
            if (list != null) {
                for (b bVar : list) {
                    bVar.a(this.f66280a);
                }
            }
        }
    }

    public void n() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f66285f) {
            return;
        }
        ProgressView progressView = this.f66283d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.f66283d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f66285f) {
            this.f66285f = true;
            this.f66286g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.f66282c;
        if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
            return;
        }
        hVar.L();
        j jVar = this.f66282c.mMusicController;
        if (jVar != null) {
            jVar.n(this.f66281b);
        }
    }

    public void o() {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f66285f) {
            ProgressView progressView = this.f66283d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f66285f = false;
            this.f66281b = (int) (this.f66281b + (System.currentTimeMillis() - this.f66286g));
            ProgressView progressView2 = this.f66283d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i2 = this.f66281b;
                if (lastProgress != i2) {
                    this.f66283d.c(i2);
                }
            }
            RecordVideoActivity recordVideoActivity = this.f66282c;
            if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
                return;
            }
            hVar.M();
        }
    }
}
