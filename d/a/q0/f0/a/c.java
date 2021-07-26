package d.a.q0.f0.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.R;
import com.baidu.tieba.core.edit.TbMediaTrackConfig;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.tieba.view.widget.mediaedit.MultiMediaEditLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener;
import com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener;
import com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaTimelineUpdateListener;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.google.gson.Gson;
import d.a.d.e.p.l;
import d.a.q0.y.c.b;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements d.a.q0.f0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56659a;

    /* renamed from: b  reason: collision with root package name */
    public VlogEditManager f56660b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaDataSourceViewAdapter f56661c;

    /* renamed from: d  reason: collision with root package name */
    public TbGLMediaPreviewView f56662d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f56663e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f56664f;

    /* renamed from: g  reason: collision with root package name */
    public MultiMediaEditLayout f56665g;

    /* renamed from: h  reason: collision with root package name */
    public int f56666h;

    /* renamed from: i  reason: collision with root package name */
    public float f56667i;
    public long j;
    public long k;
    public int l;
    public int m;
    public boolean n;
    public List<MultiMediaData> o;
    public List<d.a.q0.z3.m.c.c.a> p;
    public d.a.q0.y.c.b q;
    public d.a.q0.y.b.b r;
    public boolean s;
    public d.a.q0.y.c.a t;
    public b.a u;
    public d.a.q0.y.b.a v;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.y.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f56668a;

        /* renamed from: d.a.q0.f0.a.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1379a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f56669e;

            public RunnableC1379a(a aVar) {
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
                this.f56669e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f56669e.f56668a.M();
                }
            }
        }

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56668a = cVar;
        }

        @Override // d.a.q0.y.c.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                for (int i2 = 0; i2 < this.f56668a.o.size(); i2++) {
                    MultiMediaData multiMediaData = (MultiMediaData) this.f56668a.o.get(i2);
                    if (multiMediaData != null && multiMediaData.mSpeed != f2) {
                        multiMediaData.mSpeed = f2;
                        this.f56668a.n = true;
                    }
                }
                d.a.d.e.m.e.a().postDelayed(new RunnableC1379a(this), 100L);
                this.f56668a.f56665g.setLocalAlbumInfoData(this.f56668a.f56660b, this.f56668a.o, false);
                if (this.f56668a.q != null) {
                    this.f56668a.f56665g.x(this.f56668a.q.d(), this.f56668a.q.b() == 0);
                }
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.w0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f56670a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56670a = cVar;
        }

        @Override // d.a.w0.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new d.a.q0.z3.m.b(this.f56670a.f56659a.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // d.a.w0.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56670a.s ? d.a.q0.v3.c.f66020c : d.a.q0.v3.c.f66021d : (String) invokeV.objValue;
        }

        @Override // d.a.w0.c
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }

        @Override // d.a.w0.c
        public d.a.w0.j.a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (d.a.w0.j.a) invokeV.objValue;
        }
    }

    /* renamed from: d.a.q0.f0.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1380c implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1380c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) ? str.endsWith(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f56671a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56671a = cVar;
        }

        @Override // d.a.q0.y.c.b.a
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 == 3) {
                    if (ListUtils.getCount(this.f56671a.o) < 1 || ((float) (this.f56671a.k - this.f56671a.j)) * ((MultiMediaData) this.f56671a.o.get(0)).getCurrentSpeed() < 6000.0f) {
                        BdToast.f(this.f56671a.f56659a.getPageActivity(), String.format(this.f56671a.f56659a.getString(R.string.file_edit_less_sec), 6), BdToast.DefaultIcon.FAILURE).q();
                        return false;
                    }
                } else if (i2 == 4 && (ListUtils.getCount(this.f56671a.o) < 1 || ((float) (this.f56671a.k - this.f56671a.j)) * ((MultiMediaData) this.f56671a.o.get(0)).getCurrentSpeed() < 9000.0f)) {
                    BdToast.f(this.f56671a.f56659a.getPageActivity(), String.format(this.f56671a.f56659a.getString(R.string.file_edit_less_sec), 9), BdToast.DefaultIcon.FAILURE).q();
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.a.q0.y.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f56672a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56672a = cVar;
        }

        @Override // d.a.q0.y.b.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                if (this.f56672a.f56667i == f2) {
                    return true;
                }
                this.f56672a.f56667i = f2;
                this.f56672a.G();
                this.f56672a.n = true;
                if (this.f56672a.r != null) {
                    this.f56672a.f56665g.w(this.f56672a.r.b() == 0);
                }
                return false;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f56673e;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56673e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56673e.f56662d == null) {
                return;
            }
            this.f56673e.f56660b.setVideoRatio(this.f56673e.f56667i);
            if (this.f56673e.f56660b == null || this.f56673e.f56660b.isPlaying()) {
                return;
            }
            this.f56673e.f56662d.requestRender();
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f56674e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f56675e;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56675e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int height = this.f56675e.f56674e.f56663e.getHeight();
                    int height2 = this.f56675e.f56674e.f56664f.getHeight();
                    this.f56675e.f56674e.l = (l.i(this.f56675e.f56674e.f56659a.getPageActivity()) - height2) - height;
                    c cVar = this.f56675e.f56674e;
                    cVar.m = l.k(cVar.f56659a.getPageActivity());
                    this.f56675e.f56674e.G();
                }
            }
        }

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56674e = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f56674e.f56662d.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f56674e.f56663e.post(new a(this));
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class h implements d.a.q0.z3.m.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f56676a;

        /* loaded from: classes8.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f56677e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f56678f;

            public a(h hVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56678f = hVar;
                this.f56677e = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f56678f.f56676a.f56660b == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f56678f.f56676a.f56660b.setAngle(this.f56677e, floatValue);
                ((MultiMediaData) this.f56678f.f56676a.o.get(this.f56677e)).angle = floatValue;
                if (this.f56678f.f56676a.f56662d == null || this.f56678f.f56676a.f56660b.isPlaying()) {
                    return;
                }
                this.f56678f.f56676a.f56662d.requestRender();
            }
        }

        /* loaded from: classes8.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f56679e;

            public b(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56679e = hVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f56679e.f56676a.f56660b == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                for (int i2 = 0; i2 < this.f56679e.f56676a.o.size(); i2++) {
                    this.f56679e.f56676a.f56660b.setAngle(i2, floatValue);
                    ((MultiMediaData) this.f56679e.f56676a.o.get(i2)).angle = floatValue;
                    if (this.f56679e.f56676a.f56662d != null && !this.f56679e.f56676a.f56660b.isPlaying()) {
                        this.f56679e.f56676a.f56662d.requestRender();
                    }
                }
            }
        }

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56676a = cVar;
        }

        @Override // d.a.q0.z3.m.c.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.q0.z3.m.c.a
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }

        @Override // d.a.q0.z3.m.c.a
        public void c(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)}) == null) || this.f56676a.f56660b == null) {
                return;
            }
            this.f56676a.f56660b.seek((long) d2);
        }

        @Override // d.a.q0.z3.m.c.a
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // d.a.q0.z3.m.c.a
        public void e(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || this.f56676a.f56660b == null || ListUtils.isEmpty(this.f56676a.o)) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i2, i3);
            ofFloat.addUpdateListener(new b(this));
            ofFloat.setDuration(300L);
            ofFloat.start();
            this.f56676a.G();
            this.f56676a.n = true;
        }

        @Override // d.a.q0.z3.m.c.a
        public void f(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            }
        }

        @Override // d.a.q0.z3.m.c.a
        public void g(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || this.f56676a.f56660b == null) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i3, i4);
            ofFloat.addUpdateListener(new a(this, i2));
            ofFloat.setDuration(300L);
            ofFloat.start();
        }

        @Override // d.a.q0.z3.m.c.a
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f56676a.n = true;
                if ((this.f56676a.k - this.f56676a.j) - 100 >= 3000 || d.a.p0.s.d0.b.j().g("key_file_video_clip_less_3_tip_show", false)) {
                    return;
                }
                this.f56676a.N(R.string.file_video_clip_less_3_tips);
                d.a.p0.s.d0.b.j().t("key_file_video_clip_less_3_tip_show", true);
            }
        }

        @Override // d.a.q0.z3.m.c.a
        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            }
        }

        @Override // d.a.q0.z3.m.c.a
        public void j(int i2, d.a.q0.z3.m.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048585, this, i2, aVar) == null) {
            }
        }

        @Override // d.a.q0.z3.m.c.a
        public void k() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f56676a.r == null) {
                return;
            }
            int b2 = this.f56676a.r.b();
            this.f56676a.H();
            if (b2 != 0) {
                this.f56676a.r.c(0);
            }
            if (this.f56676a.f56665g != null) {
                this.f56676a.f56665g.w(this.f56676a.r.b() == 0);
            }
        }

        @Override // d.a.q0.z3.m.c.a
        public void l(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Double.valueOf(d2)}) == null) || this.f56676a.f56660b == null) {
                return;
            }
            this.f56676a.f56660b.seek((long) d2);
        }

        @Override // d.a.q0.z3.m.c.a
        public void m() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f56676a.q == null) {
                return;
            }
            int b2 = this.f56676a.q.b();
            this.f56676a.H();
            if (b2 != 0) {
                this.f56676a.q.c(0);
            }
            if (this.f56676a.f56665g != null) {
                this.f56676a.f56665g.x(this.f56676a.q.d(), this.f56676a.q.b() == 0);
            }
        }

        @Override // d.a.q0.z3.m.c.a
        public void n(long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f56676a.f56660b == null) {
                return;
            }
            this.f56676a.f56660b.seek(j);
        }

        @Override // d.a.q0.z3.m.c.a
        public void o(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                if (this.f56676a.f56660b != null) {
                    this.f56676a.f56660b.seek(j);
                }
                this.f56676a.j = j;
                this.f56676a.k = j2;
                if (!this.f56676a.n || (this.f56676a.k - this.f56676a.j) - 100 >= 3000 || d.a.p0.s.d0.b.j().g("key_file_video_clip_less_3_tip_show", false)) {
                    return;
                }
                this.f56676a.N(R.string.file_video_clip_less_3_tips);
                d.a.p0.s.d0.b.j().t("key_file_video_clip_less_3_tip_show", true);
            }
        }

        @Override // d.a.q0.z3.m.c.a
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements IMultiMediaPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f56680a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f56681e;

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
                this.f56681e = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f56681e.f56680a.p)) {
                    return;
                }
                this.f56681e.f56680a.f56665g.v(-1, this.f56681e.f56680a.f56660b.getCurrentIndex());
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f56682e;

            /* loaded from: classes8.dex */
            public class a extends AnimatorListenerAdapter {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ b f56683e;

                public a(b bVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f56683e = bVar;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                        this.f56683e.f56682e.f56680a.f56665g.setVisibility(0);
                    }
                }
            }

            public b(i iVar) {
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
                this.f56682e = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f56682e.f56680a.f56665g, "translationY", this.f56682e.f56680a.f56665g.getHeight(), 0.0f);
                    ofFloat.setDuration(250L);
                    ofFloat.addListener(new a(this));
                    d.a.q0.u3.f.i(this.f56682e.f56680a.f56659a.getPageActivity().getIntent(), this.f56682e.f56680a.f56662d);
                    ofFloat.start();
                }
            }
        }

        public i(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56680a = cVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56680a.f56660b == null) {
                return;
            }
            this.f56680a.f56660b.pause();
            this.f56680a.f56665g.post(new a(this));
            if (this.f56680a.f56666h == 2) {
                this.f56680a.f56662d.post(new b(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements MultiMediaTimelineUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f56684a;

        public j(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56684a = cVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaTimelineUpdateListener
        public void onTimelineUpdate(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                if (this.f56684a.f56665g.r()) {
                    j -= this.f56684a.f56665g.getSingleMediaStartDuration();
                    if (this.f56684a.f56665g.getSingleClipTo() - j <= 150) {
                        this.f56684a.f56660b.seek(this.f56684a.f56665g.getSingleClipFrom() + this.f56684a.f56665g.getSingleMediaStartDuration());
                    }
                } else if (this.f56684a.f56665g.getAllClipTo() - j <= 100) {
                    this.f56684a.f56660b.seek(this.f56684a.f56665g.getAllClipFrom());
                }
                this.f56684a.f56665g.y(j);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements MultiMediaStateEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f56685a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f56686e;

            public a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56686e = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f56686e.f56685a.p)) {
                    return;
                }
                this.f56686e.f56685a.f56665g.v(-1, this.f56686e.f56685a.f56660b.getCurrentIndex());
            }
        }

        public k(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56685a = cVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onIndexChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onLoop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f56685a.f56665g.post(new a(this));
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onPlayEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onRepeatIndexEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onRepeatIndexLoop(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            }
        }
    }

    public c(TbPageContext tbPageContext, TbGLMediaPreviewView tbGLMediaPreviewView, MultiMediaEditLayout multiMediaEditLayout, TbMultiMediaData tbMultiMediaData, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tbGLMediaPreviewView, multiMediaEditLayout, tbMultiMediaData, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = false;
        this.s = false;
        this.t = new a(this);
        this.u = new d(this);
        this.v = new e(this);
        this.f56659a = tbPageContext;
        this.q = new d.a.q0.y.c.c(tbPageContext, this.t, this.u);
        this.f56662d = tbGLMediaPreviewView;
        this.f56665g = multiMediaEditLayout;
        this.f56666h = i2;
        this.s = z;
        ArrayList arrayList = new ArrayList();
        this.o = arrayList;
        arrayList.add(tbMultiMediaData);
        if (!ListUtils.isEmpty(this.o) && this.o.get(0).height > 0 && this.o.get(0).width > 0) {
            this.f56667i = (this.o.get(0).height * 1.0f) / this.o.get(0).width;
            d.a.q0.y.b.c cVar = new d.a.q0.y.b.c(this.f56659a, this.o.get(0).height, this.o.get(0).width, this.v);
            this.r = cVar;
            cVar.d(0);
        }
        if (tbMultiMediaData != null) {
            this.j = tbMultiMediaData.start;
            tbMultiMediaData.start = 0L;
            this.k = tbMultiMediaData.end;
            tbMultiMediaData.end = tbMultiMediaData.originalDuration;
        }
        I();
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f56664f.post(new f(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.q0.y.c.b bVar = this.q;
            if (bVar != null) {
                bVar.c(8);
                MultiMediaEditLayout multiMediaEditLayout = this.f56665g;
                if (multiMediaEditLayout != null) {
                    multiMediaEditLayout.x(this.q.d(), false);
                }
            }
            d.a.q0.y.b.b bVar2 = this.r;
            if (bVar2 != null) {
                bVar2.c(8);
                MultiMediaEditLayout multiMediaEditLayout2 = this.f56665g;
                if (multiMediaEditLayout2 != null) {
                    multiMediaEditLayout2.w(false);
                }
            }
        }
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!d.a.q0.u3.a.a()) {
                this.f56659a.getPageActivity().finish();
                return false;
            }
            J();
            L();
            K();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.w0.b.d().i(TbadkCoreApplication.getInst());
            d.a.w0.b.d().k(FileHelper.getCacheDir());
            d.a.w0.b.d().l(new b(this));
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f56662d.getViewTreeObserver().addOnPreDrawListener(new g(this));
            this.f56662d.setZOrderMediaOverlay(true);
            this.f56662d.setMultiMediaDataSourceViewAdapter(this.f56661c, true);
            this.f56663e = (NavigationBar) this.f56659a.getPageActivity().findViewById(R.id.navigation_bar);
            this.f56664f = (FrameLayout) this.f56659a.getPageActivity().findViewById(R.id.tool_root_layout);
            this.f56665g.setPageContext(this.f56659a);
            this.f56665g.setOnlyOneVideo();
            this.f56665g.setLocalAlbumInfoData(this.f56660b, this.o);
            this.f56665g.setMultiVideoClipLayoutRange((int) this.j, (int) this.k);
            this.f56665g.setIMultiMediaEditView(new h(this));
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f56661c = multiMediaDataSourceViewAdapter;
            VlogEditManager vlogEditManager = new VlogEditManager(multiMediaDataSourceViewAdapter);
            this.f56660b = vlogEditManager;
            vlogEditManager.setMultiMediaData(this.o);
            this.f56660b.setLooping(true);
            this.f56660b.setPreparedListener(new i(this));
            this.f56660b.setMultiMediaTimelineUpdateListener(new j(this), true);
            this.f56660b.setMultiMediaStateEventListener(new k(this));
        }
    }

    public final void M() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (vlogEditManager = this.f56660b) == null || this.f56665g == null) {
            return;
        }
        boolean isPlaying = vlogEditManager.isPlaying();
        this.f56660b.reset();
        this.f56660b.setMultiMediaData(this.o);
        if (this.f56665g.r()) {
            int i2 = 0;
            MediaTrack mediaTrack = (MediaTrack) ListUtils.getItem(this.f56660b.getUpdateMediaTracks(), 0);
            int currentMediaPosition = this.f56665g.getCurrentMediaPosition();
            if (mediaTrack != null) {
                List<MediaSegment> list = mediaTrack.mediaSegments;
                if (!ListUtils.isEmpty(list)) {
                    int i3 = 0;
                    while (i2 < currentMediaPosition) {
                        i3 = (int) (i3 + (list.get(i2).end - list.get(i2).start));
                        i2++;
                    }
                    i2 = i3;
                }
            }
            int i4 = i2 + 100;
            this.f56665g.setSingleMediaStartDuration(i4);
            this.f56660b.seek(i4 + this.f56665g.getSingleClipFrom());
        } else {
            this.f56660b.seek(this.f56665g.getAllClipFrom());
        }
        if (isPlaying) {
            this.f56660b.start();
        } else {
            this.f56660b.pause();
        }
    }

    public final void N(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || i2 <= 0) {
            return;
        }
        d.a.q0.e0.e eVar = new d.a.q0.e0.e(this.f56659a, this.f56665g);
        eVar.g0(R.drawable.bg_tip_blue_up_right);
        eVar.L(4);
        eVar.h0(true);
        eVar.j0(-UtilHelper.getDimenPixelSize(R.dimen.tbds78));
        eVar.k0(UtilHelper.getDimenPixelSize(R.dimen.tbds19));
        eVar.X(R.color.CAM_X0101);
        eVar.e0(R.dimen.T_X08);
        eVar.P(R.dimen.T_X08);
        eVar.a0(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
        eVar.d0(UtilHelper.getDimenPixelSize(R.dimen.tbds44));
        eVar.l0(this.f56659a.getPageActivity().getResources().getString(i2));
    }

    @Override // d.a.q0.f0.a.a
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qmFilterItem)) == null) {
            if (this.f56660b != null && qmFilterItem != null) {
                float f2 = 0.0f;
                String str = IVlogEditManager.FILTER_ORIGINAL;
                if (qmFilterItem != null && !StringUtils.isNull(qmFilterItem.localPath) && !FilterValue.DEFAULT_FILTER_VALUE.equals(qmFilterItem.localPath)) {
                    f2 = (d.a.d.e.m.b.c(qmFilterItem.effect, 100.0f) * 1.0f) / 100.0f;
                    File file = new File(qmFilterItem.localPath);
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles(new C1380c(this));
                        if (listFiles.length > 0) {
                            str = listFiles[0].getAbsolutePath();
                        }
                    }
                }
                try {
                    this.f56660b.setFilter(f2, str);
                    return true;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.f0.a.a
    public void b(TbMultiMediaData tbMultiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, tbMultiMediaData) == null) || tbMultiMediaData == null) {
            return;
        }
        this.o.clear();
        this.o.add(tbMultiMediaData);
        M();
        MultiMediaEditLayout multiMediaEditLayout = this.f56665g;
        if (multiMediaEditLayout != null) {
            multiMediaEditLayout.t();
        }
        d.a.q0.y.b.b bVar = this.r;
        if (bVar != null) {
            bVar.reset();
        }
        d.a.q0.y.c.b bVar2 = this.q;
        if (bVar2 != null) {
            bVar2.reset();
        }
    }

    @Override // d.a.q0.f0.a.a
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : invokeV.longValue;
    }

    @Override // d.a.q0.f0.a.a
    public void d(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048587, this, f2) == null) || this.f56667i == f2) {
            return;
        }
        this.f56667i = f2;
        G();
        VlogEditManager vlogEditManager = this.f56660b;
        if (vlogEditManager == null || vlogEditManager.isPlaying()) {
            return;
        }
        VlogEditManager vlogEditManager2 = this.f56660b;
        vlogEditManager2.seek(vlogEditManager2.getCurrentPlayTime());
    }

    @Override // d.a.q0.f0.a.a
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : invokeV.booleanValue;
    }

    @Override // d.a.q0.f0.a.a
    public void f(boolean z) {
        MultiMediaEditLayout multiMediaEditLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (multiMediaEditLayout = this.f56665g) == null) {
            return;
        }
        multiMediaEditLayout.setOnlyClip(z);
    }

    @Override // d.a.q0.f0.a.a
    public long getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.j : invokeV.longValue;
    }

    @Override // d.a.q0.f0.a.a
    public TbMediaTrackConfig getMediaTrackConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f56660b != null) {
                return (TbMediaTrackConfig) new Gson().fromJson(this.f56660b.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class);
            }
            return null;
        }
        return (TbMediaTrackConfig) invokeV.objValue;
    }

    @Override // d.a.q0.f0.a.a
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f56667i : invokeV.floatValue;
    }

    @Override // d.a.q0.f0.a.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            VlogEditManager vlogEditManager = this.f56660b;
            if (vlogEditManager != null) {
                return vlogEditManager.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.f0.a.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            VlogEditManager vlogEditManager = this.f56660b;
            if (vlogEditManager != null) {
                vlogEditManager.onDestroy();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f56662d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onDestroy();
            }
            MultiMediaEditLayout multiMediaEditLayout = this.f56665g;
            if (multiMediaEditLayout != null) {
                multiMediaEditLayout.s();
            }
        }
    }

    @Override // d.a.q0.f0.a.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            VlogEditManager vlogEditManager = this.f56660b;
            if (vlogEditManager != null) {
                vlogEditManager.onPause();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f56662d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onPause();
            }
        }
    }

    @Override // d.a.q0.f0.a.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f56662d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onResume();
            }
            VlogEditManager vlogEditManager = this.f56660b;
            if (vlogEditManager != null) {
                vlogEditManager.onResume();
            }
        }
    }

    @Override // d.a.q0.f0.a.a
    public void pause() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (vlogEditManager = this.f56660b) == null) {
            return;
        }
        vlogEditManager.pause();
    }

    @Override // d.a.q0.f0.a.a
    public void start() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (vlogEditManager = this.f56660b) == null) {
            return;
        }
        vlogEditManager.start();
        this.n = true;
    }
}
