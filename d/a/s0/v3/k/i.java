package d.a.s0.v3.k;

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
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f68839a;

    /* renamed from: b  reason: collision with root package name */
    public int f68840b;

    /* renamed from: c  reason: collision with root package name */
    public RecordVideoActivity f68841c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressView f68842d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f68843e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68844f;

    /* renamed from: g  reason: collision with root package name */
    public long f68845g;

    /* renamed from: h  reason: collision with root package name */
    public int f68846h;

    /* loaded from: classes9.dex */
    public class a implements ProgressView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f68847a;

        /* renamed from: d.a.s0.v3.k.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1859a implements TextureMovieEncoder.OnEncoderStatusUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f68848a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f68849b;

            /* renamed from: d.a.s0.v3.k.i$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class RunnableC1860a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C1859a f68850e;

                public RunnableC1860a(C1859a c1859a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1859a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68850e = c1859a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f68850e.f68849b.f68847a.f68841c == null) {
                        return;
                    }
                    this.f68850e.f68849b.f68847a.f68841c.onRecordDone();
                }
            }

            public C1859a(a aVar, g gVar) {
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
                this.f68849b = aVar;
                this.f68848a = gVar;
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
                    d.a.c.e.m.e.a().post(new RunnableC1860a(this));
                    this.f68848a.setOnEncoderStatusUpdateListener(null);
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
            this.f68847a = iVar;
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i2) {
            h hVar;
            g q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f68847a.f68846h = i2;
                if (i2 != 100 || this.f68847a.f68841c == null || (hVar = this.f68847a.f68841c.mPreviewController) == null || (q = hVar.q()) == null) {
                    return;
                }
                if (q instanceof GLVideoPreviewView) {
                    q.setOnEncoderStatusUpdateListener(new C1859a(this, q));
                    this.f68847a.o();
                    return;
                }
                this.f68847a.o();
                if (this.f68847a.f68841c != null) {
                    this.f68847a.f68841c.onRecordDone();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f68839a = 1;
        this.f68841c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.camera_switch);
        ImageView imageView2 = (ImageView) this.f68841c.findViewById(R.id.flash_switch);
        ProgressView progressView = (ProgressView) this.f68841c.findViewById(R.id.video_progress_view);
        this.f68842d = progressView;
        progressView.setListener(new a(this));
        if (!d.a.s0.v3.k.a.f(true)) {
            imageView2.setVisibility(4);
        }
        if (d.a.s0.v3.k.a.g(recordVideoActivity.getPackageManager())) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (this.f68843e == null) {
                this.f68843e = new ArrayList();
            }
            this.f68843e.add(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ProgressView progressView = this.f68842d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.DELETE);
            }
            this.f68840b = this.f68842d.getLastProgress();
            h hVar = this.f68841c.mPreviewController;
            if (hVar != null) {
                hVar.h();
            }
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68846h : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68839a : invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68840b : invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f68839a == 6 : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            j jVar = this.f68841c.mMusicController;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f68842d.b() : invokeV.booleanValue;
    }

    public void l() {
        ProgressView progressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f68844f || (progressView = this.f68842d) == null) {
            return;
        }
        progressView.setCurrentState(ProgressView.State.ROLLBACK);
    }

    public void m(int i2) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f68839a = i2;
            if (i2 == 1) {
                this.f68842d.setVisibility(4);
                this.f68842d.d();
                this.f68840b = 0;
                File file = new File(d.a.s0.v3.c.f68591d);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2.getPath().startsWith("rec_tmp_")) {
                            file2.delete();
                        }
                    }
                }
            }
            List<b> list = this.f68843e;
            if (list != null) {
                for (b bVar : list) {
                    bVar.a(this.f68839a);
                }
            }
        }
    }

    public void n() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f68844f) {
            return;
        }
        ProgressView progressView = this.f68842d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.f68842d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f68844f) {
            this.f68844f = true;
            this.f68845g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.f68841c;
        if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
            return;
        }
        hVar.L();
        j jVar = this.f68841c.mMusicController;
        if (jVar != null) {
            jVar.n(this.f68840b);
        }
    }

    public void o() {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f68844f) {
            ProgressView progressView = this.f68842d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f68844f = false;
            this.f68840b = (int) (this.f68840b + (System.currentTimeMillis() - this.f68845g));
            ProgressView progressView2 = this.f68842d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i2 = this.f68840b;
                if (lastProgress != i2) {
                    this.f68842d.c(i2);
                }
            }
            RecordVideoActivity recordVideoActivity = this.f68841c;
            if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
                return;
            }
            hVar.M();
        }
    }
}
