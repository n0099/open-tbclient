package d.a.s0.f0.a;

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
import d.a.s0.y.c.b;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c implements d.a.s0.f0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59371a;

    /* renamed from: b  reason: collision with root package name */
    public VlogEditManager f59372b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaDataSourceViewAdapter f59373c;

    /* renamed from: d  reason: collision with root package name */
    public TbGLMediaPreviewView f59374d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f59375e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f59376f;

    /* renamed from: g  reason: collision with root package name */
    public MultiMediaEditLayout f59377g;

    /* renamed from: h  reason: collision with root package name */
    public int f59378h;

    /* renamed from: i  reason: collision with root package name */
    public float f59379i;
    public long j;
    public long k;
    public int l;
    public int m;
    public boolean n;
    public List<MultiMediaData> o;
    public List<d.a.s0.z3.m.c.c.a> p;
    public d.a.s0.y.c.b q;
    public d.a.s0.y.b.b r;
    public d.a.s0.y.c.a s;
    public b.a t;
    public d.a.s0.y.b.a u;

    /* loaded from: classes9.dex */
    public class a implements d.a.s0.y.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59380a;

        /* renamed from: d.a.s0.f0.a.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1416a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f59381e;

            public RunnableC1416a(a aVar) {
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
                this.f59381e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f59381e.f59380a.O();
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
            this.f59380a = cVar;
        }

        @Override // d.a.s0.y.c.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                for (int i2 = 0; i2 < this.f59380a.o.size(); i2++) {
                    MultiMediaData multiMediaData = (MultiMediaData) this.f59380a.o.get(i2);
                    if (multiMediaData != null && multiMediaData.mSpeed != f2) {
                        multiMediaData.mSpeed = f2;
                        this.f59380a.n = true;
                    }
                }
                d.a.c.e.m.e.a().postDelayed(new RunnableC1416a(this), 100L);
                this.f59380a.f59377g.setLocalAlbumInfoData(this.f59380a.f59372b, this.f59380a.o, false);
                if (this.f59380a.q != null) {
                    this.f59380a.f59377g.x(this.f59380a.q.d(), this.f59380a.q.b() == 0);
                }
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d.a.y0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59382a;

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
            this.f59382a = cVar;
        }

        @Override // d.a.y0.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new d.a.s0.z3.m.b(this.f59382a.f59371a.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // d.a.y0.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a.s0.v3.c.f68590c : (String) invokeV.objValue;
        }

        @Override // d.a.y0.c
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }

        @Override // d.a.y0.c
        public d.a.y0.j.a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (d.a.y0.j.a) invokeV.objValue;
        }
    }

    /* renamed from: d.a.s0.f0.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1417c implements d.a.s0.u3.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59383a;

        public C1417c(c cVar) {
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
            this.f59383a = cVar;
        }

        @Override // d.a.s0.u3.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59383a.L();
                this.f59383a.N();
                this.f59383a.M();
            }
        }

        @Override // d.a.s0.u3.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f59383a.f59371a.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

    /* loaded from: classes9.dex */
    public class e implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59384a;

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
            this.f59384a = cVar;
        }

        @Override // d.a.s0.y.c.b.a
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 == 3) {
                    if (ListUtils.getCount(this.f59384a.o) < 1 || ((float) (this.f59384a.k - this.f59384a.j)) * ((MultiMediaData) this.f59384a.o.get(0)).getCurrentSpeed() < 6000.0f) {
                        BdToast.f(this.f59384a.f59371a.getPageActivity(), String.format(this.f59384a.f59371a.getString(R.string.file_edit_less_sec), 6), BdToast.DefaultIcon.FAILURE).q();
                        return false;
                    }
                } else if (i2 == 4 && (ListUtils.getCount(this.f59384a.o) < 1 || ((float) (this.f59384a.k - this.f59384a.j)) * ((MultiMediaData) this.f59384a.o.get(0)).getCurrentSpeed() < 9000.0f)) {
                    BdToast.f(this.f59384a.f59371a.getPageActivity(), String.format(this.f59384a.f59371a.getString(R.string.file_edit_less_sec), 9), BdToast.DefaultIcon.FAILURE).q();
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class f implements d.a.s0.y.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59385a;

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
            this.f59385a = cVar;
        }

        @Override // d.a.s0.y.b.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                if (this.f59385a.f59379i == f2) {
                    return true;
                }
                this.f59385a.f59379i = f2;
                this.f59385a.I();
                this.f59385a.n = true;
                if (this.f59385a.r != null) {
                    this.f59385a.f59377g.w(this.f59385a.r.b() == 0);
                }
                return false;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f59386e;

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
            this.f59386e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59386e.f59374d == null) {
                return;
            }
            this.f59386e.f59372b.setVideoRatio(this.f59386e.f59379i);
            if (this.f59386e.f59372b == null || this.f59386e.f59372b.isPlaying()) {
                return;
            }
            this.f59386e.f59374d.requestRender();
        }
    }

    /* loaded from: classes9.dex */
    public class h implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f59387e;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f59388e;

            public a(h hVar) {
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
                this.f59388e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int height = this.f59388e.f59387e.f59375e.getHeight();
                    int height2 = this.f59388e.f59387e.f59376f.getHeight();
                    this.f59388e.f59387e.l = (d.a.c.e.p.l.i(this.f59388e.f59387e.f59371a.getPageActivity()) - height2) - height;
                    c cVar = this.f59388e.f59387e;
                    cVar.m = d.a.c.e.p.l.k(cVar.f59371a.getPageActivity());
                    this.f59388e.f59387e.I();
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
            this.f59387e = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f59387e.f59374d.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f59387e.f59375e.post(new a(this));
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class i implements d.a.s0.z3.m.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59389a;

        /* loaded from: classes9.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f59390e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f59391f;

            public a(i iVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59391f = iVar;
                this.f59390e = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f59391f.f59389a.f59372b == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f59391f.f59389a.f59372b.setAngle(this.f59390e, floatValue);
                ((MultiMediaData) this.f59391f.f59389a.o.get(this.f59390e)).angle = floatValue;
                if (this.f59391f.f59389a.f59374d == null || this.f59391f.f59389a.f59372b.isPlaying()) {
                    return;
                }
                this.f59391f.f59389a.f59374d.requestRender();
            }
        }

        /* loaded from: classes9.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f59392e;

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
                this.f59392e = iVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f59392e.f59389a.f59372b == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                for (int i2 = 0; i2 < this.f59392e.f59389a.o.size(); i2++) {
                    this.f59392e.f59389a.f59372b.setAngle(i2, floatValue);
                    ((MultiMediaData) this.f59392e.f59389a.o.get(i2)).angle = floatValue;
                    if (this.f59392e.f59389a.f59374d != null && !this.f59392e.f59389a.f59372b.isPlaying()) {
                        this.f59392e.f59389a.f59374d.requestRender();
                    }
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
            this.f59389a = cVar;
        }

        @Override // d.a.s0.z3.m.c.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.s0.z3.m.c.a
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }

        @Override // d.a.s0.z3.m.c.a
        public void c(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d2)}) == null) || this.f59389a.f59372b == null) {
                return;
            }
            this.f59389a.f59372b.seek((long) d2);
        }

        @Override // d.a.s0.z3.m.c.a
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // d.a.s0.z3.m.c.a
        public void e(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || this.f59389a.f59372b == null || ListUtils.isEmpty(this.f59389a.o)) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i2, i3);
            ofFloat.addUpdateListener(new b(this));
            ofFloat.setDuration(300L);
            ofFloat.start();
            this.f59389a.I();
            this.f59389a.n = true;
        }

        @Override // d.a.s0.z3.m.c.a
        public void f(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            }
        }

        @Override // d.a.s0.z3.m.c.a
        public void g(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || this.f59389a.f59372b == null) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i3, i4);
            ofFloat.addUpdateListener(new a(this, i2));
            ofFloat.setDuration(300L);
            ofFloat.start();
        }

        @Override // d.a.s0.z3.m.c.a
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.f59389a.n = true;
                if ((this.f59389a.k - this.f59389a.j) - 100 >= 3000 || d.a.r0.r.d0.b.j().g("key_file_video_clip_less_3_tip_show", false)) {
                    return;
                }
                this.f59389a.P(R.string.file_video_clip_less_3_tips);
                d.a.r0.r.d0.b.j().t("key_file_video_clip_less_3_tip_show", true);
            }
        }

        @Override // d.a.s0.z3.m.c.a
        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            }
        }

        @Override // d.a.s0.z3.m.c.a
        public void j(int i2, d.a.s0.z3.m.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048585, this, i2, aVar) == null) {
            }
        }

        @Override // d.a.s0.z3.m.c.a
        public void k() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f59389a.r == null) {
                return;
            }
            int b2 = this.f59389a.r.b();
            this.f59389a.J();
            if (b2 != 0) {
                this.f59389a.r.c(0);
            }
            if (this.f59389a.f59377g != null) {
                this.f59389a.f59377g.w(this.f59389a.r.b() == 0);
            }
        }

        @Override // d.a.s0.z3.m.c.a
        public void l(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Double.valueOf(d2)}) == null) || this.f59389a.f59372b == null) {
                return;
            }
            this.f59389a.f59372b.seek((long) d2);
        }

        @Override // d.a.s0.z3.m.c.a
        public void m() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f59389a.q == null) {
                return;
            }
            int b2 = this.f59389a.q.b();
            this.f59389a.J();
            if (b2 != 0) {
                this.f59389a.q.c(0);
            }
            if (this.f59389a.f59377g != null) {
                this.f59389a.f59377g.x(this.f59389a.q.d(), this.f59389a.q.b() == 0);
            }
        }

        @Override // d.a.s0.z3.m.c.a
        public void n(long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f59389a.f59372b == null) {
                return;
            }
            this.f59389a.f59372b.seek(j);
        }

        @Override // d.a.s0.z3.m.c.a
        public void o(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                if (this.f59389a.f59372b != null) {
                    this.f59389a.f59372b.seek(j);
                }
                this.f59389a.j = j;
                this.f59389a.k = j2;
                if (!this.f59389a.n || (this.f59389a.k - this.f59389a.j) - 100 >= 3000 || d.a.r0.r.d0.b.j().g("key_file_video_clip_less_3_tip_show", false)) {
                    return;
                }
                this.f59389a.P(R.string.file_video_clip_less_3_tips);
                d.a.r0.r.d0.b.j().t("key_file_video_clip_less_3_tip_show", true);
            }
        }

        @Override // d.a.s0.z3.m.c.a
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements IMultiMediaPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59393a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f59394e;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59394e = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f59394e.f59393a.p)) {
                    return;
                }
                this.f59394e.f59393a.f59377g.v(-1, this.f59394e.f59393a.f59372b.getCurrentIndex());
            }
        }

        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f59395e;

            /* loaded from: classes9.dex */
            public class a extends AnimatorListenerAdapter {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ b f59396e;

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
                    this.f59396e = bVar;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                        this.f59396e.f59395e.f59393a.f59377g.setVisibility(0);
                    }
                }
            }

            public b(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59395e = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f59395e.f59393a.f59377g, "translationY", this.f59395e.f59393a.f59377g.getHeight(), 0.0f);
                    ofFloat.setDuration(250L);
                    ofFloat.addListener(new a(this));
                    d.a.s0.u3.g.i(this.f59395e.f59393a.f59371a.getPageActivity().getIntent(), this.f59395e.f59393a.f59374d);
                    ofFloat.start();
                }
            }
        }

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
            this.f59393a = cVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59393a.f59372b == null) {
                return;
            }
            this.f59393a.f59372b.pause();
            this.f59393a.f59377g.post(new a(this));
            if (this.f59393a.f59378h == 2) {
                this.f59393a.f59374d.post(new b(this));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements MultiMediaTimelineUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59397a;

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
            this.f59397a = cVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaTimelineUpdateListener
        public void onTimelineUpdate(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                if (this.f59397a.f59377g.r()) {
                    j -= this.f59397a.f59377g.getSingleMediaStartDuration();
                    if (this.f59397a.f59377g.getSingleClipTo() - j <= 150) {
                        this.f59397a.f59372b.seek(this.f59397a.f59377g.getSingleClipFrom() + this.f59397a.f59377g.getSingleMediaStartDuration());
                    }
                } else if (this.f59397a.f59377g.getAllClipTo() - j <= 100) {
                    this.f59397a.f59372b.seek(this.f59397a.f59377g.getAllClipFrom());
                }
                this.f59397a.f59377g.y(j);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements MultiMediaStateEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59398a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f59399e;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59399e = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f59399e.f59398a.p)) {
                    return;
                }
                this.f59399e.f59398a.f59377g.v(-1, this.f59399e.f59398a.f59372b.getCurrentIndex());
            }
        }

        public l(c cVar) {
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
            this.f59398a = cVar;
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
                this.f59398a.f59377g.post(new a(this));
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

    public c(TbPageContext tbPageContext, TbGLMediaPreviewView tbGLMediaPreviewView, MultiMediaEditLayout multiMediaEditLayout, TbMultiMediaData tbMultiMediaData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tbGLMediaPreviewView, multiMediaEditLayout, tbMultiMediaData, Integer.valueOf(i2)};
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
        this.s = new a(this);
        this.t = new e(this);
        this.u = new f(this);
        this.f59371a = tbPageContext;
        this.q = new d.a.s0.y.c.c(tbPageContext, this.s, this.t);
        this.f59374d = tbGLMediaPreviewView;
        this.f59377g = multiMediaEditLayout;
        this.f59378h = i2;
        ArrayList arrayList = new ArrayList();
        this.o = arrayList;
        arrayList.add(tbMultiMediaData);
        if (!ListUtils.isEmpty(this.o) && this.o.get(0).height > 0 && this.o.get(0).width > 0) {
            this.f59379i = (this.o.get(0).height * 1.0f) / this.o.get(0).width;
            d.a.s0.y.b.c cVar = new d.a.s0.y.b.c(this.f59371a, this.o.get(0).height, this.o.get(0).width, this.u);
            this.r = cVar;
            cVar.d(0);
        }
        if (tbMultiMediaData != null) {
            this.j = tbMultiMediaData.start;
            tbMultiMediaData.start = 0L;
            this.k = tbMultiMediaData.end;
            tbMultiMediaData.end = tbMultiMediaData.originalDuration;
        }
        K();
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f59376f.post(new g(this));
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.s0.y.c.b bVar = this.q;
            if (bVar != null) {
                bVar.c(8);
                MultiMediaEditLayout multiMediaEditLayout = this.f59377g;
                if (multiMediaEditLayout != null) {
                    multiMediaEditLayout.x(this.q.d(), false);
                }
            }
            d.a.s0.y.b.b bVar2 = this.r;
            if (bVar2 != null) {
                bVar2.c(8);
                MultiMediaEditLayout multiMediaEditLayout2 = this.f59377g;
                if (multiMediaEditLayout2 != null) {
                    multiMediaEditLayout2.w(false);
                }
            }
        }
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.s0.u3.b.c(this.f59371a.getPageActivity(), new C1417c(this));
            if (d.a.s0.u3.b.b()) {
                return true;
            }
            this.f59371a.getPageActivity().finish();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.y0.b.d().i(this.f59371a.getPageActivity());
            d.a.y0.b.d().k(FileHelper.getCacheDir());
            d.a.y0.b.d().l(new b(this));
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f59374d.getViewTreeObserver().addOnPreDrawListener(new h(this));
            this.f59374d.setZOrderMediaOverlay(true);
            this.f59374d.setMultiMediaDataSourceViewAdapter(this.f59373c, true);
            this.f59375e = (NavigationBar) this.f59371a.getPageActivity().findViewById(R.id.navigation_bar);
            this.f59376f = (FrameLayout) this.f59371a.getPageActivity().findViewById(R.id.tool_root_layout);
            this.f59377g.setPageContext(this.f59371a);
            this.f59377g.setOnlyOneVideo();
            this.f59377g.setLocalAlbumInfoData(this.f59372b, this.o);
            this.f59377g.setMultiVideoClipLayoutRange((int) this.j, (int) this.k);
            this.f59377g.setIMultiMediaEditView(new i(this));
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f59373c = multiMediaDataSourceViewAdapter;
            VlogEditManager vlogEditManager = new VlogEditManager(multiMediaDataSourceViewAdapter);
            this.f59372b = vlogEditManager;
            vlogEditManager.setMultiMediaData(this.o);
            this.f59372b.setLooping(true);
            this.f59372b.setPreparedListener(new j(this));
            this.f59372b.setMultiMediaTimelineUpdateListener(new k(this), true);
            this.f59372b.setMultiMediaStateEventListener(new l(this));
        }
    }

    public final void O() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (vlogEditManager = this.f59372b) == null || this.f59377g == null) {
            return;
        }
        boolean isPlaying = vlogEditManager.isPlaying();
        this.f59372b.reset();
        this.f59372b.setMultiMediaData(this.o);
        if (this.f59377g.r()) {
            int i2 = 0;
            MediaTrack mediaTrack = (MediaTrack) ListUtils.getItem(this.f59372b.getUpdateMediaTracks(), 0);
            int currentMediaPosition = this.f59377g.getCurrentMediaPosition();
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
            this.f59377g.setSingleMediaStartDuration(i4);
            this.f59372b.seek(i4 + this.f59377g.getSingleClipFrom());
        } else {
            this.f59372b.seek(this.f59377g.getAllClipFrom());
        }
        if (isPlaying) {
            this.f59372b.start();
        } else {
            this.f59372b.pause();
        }
    }

    public final void P(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || i2 <= 0) {
            return;
        }
        d.a.s0.e0.e eVar = new d.a.s0.e0.e(this.f59371a, this.f59377g);
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
        eVar.l0(this.f59371a.getPageActivity().getResources().getString(i2));
    }

    @Override // d.a.s0.f0.a.a
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qmFilterItem)) == null) {
            if (this.f59372b != null && qmFilterItem != null) {
                float f2 = 0.0f;
                String str = IVlogEditManager.FILTER_ORIGINAL;
                if (qmFilterItem != null && !StringUtils.isNull(qmFilterItem.localPath) && !FilterValue.DEFAULT_FILTER_VALUE.equals(qmFilterItem.localPath)) {
                    f2 = (d.a.c.e.m.b.c(qmFilterItem.effect, 100.0f) * 1.0f) / 100.0f;
                    File file = new File(qmFilterItem.localPath);
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles(new d(this));
                        if (listFiles.length > 0) {
                            str = listFiles[0].getAbsolutePath();
                        }
                    }
                }
                try {
                    this.f59372b.setFilter(f2, str);
                    return true;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.s0.f0.a.a
    public void b(TbMultiMediaData tbMultiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, tbMultiMediaData) == null) || tbMultiMediaData == null) {
            return;
        }
        this.o.clear();
        this.o.add(tbMultiMediaData);
        O();
        MultiMediaEditLayout multiMediaEditLayout = this.f59377g;
        if (multiMediaEditLayout != null) {
            multiMediaEditLayout.t();
        }
        d.a.s0.y.b.b bVar = this.r;
        if (bVar != null) {
            bVar.reset();
        }
        d.a.s0.y.c.b bVar2 = this.q;
        if (bVar2 != null) {
            bVar2.reset();
        }
    }

    @Override // d.a.s0.f0.a.a
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : invokeV.longValue;
    }

    @Override // d.a.s0.f0.a.a
    public void d(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048587, this, f2) == null) || this.f59379i == f2) {
            return;
        }
        this.f59379i = f2;
        I();
        VlogEditManager vlogEditManager = this.f59372b;
        if (vlogEditManager == null || vlogEditManager.isPlaying()) {
            return;
        }
        VlogEditManager vlogEditManager2 = this.f59372b;
        vlogEditManager2.seek(vlogEditManager2.getCurrentPlayTime());
    }

    @Override // d.a.s0.f0.a.a
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : invokeV.booleanValue;
    }

    @Override // d.a.s0.f0.a.a
    public void f(boolean z) {
        MultiMediaEditLayout multiMediaEditLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (multiMediaEditLayout = this.f59377g) == null) {
            return;
        }
        multiMediaEditLayout.setOnlyClip(z);
    }

    @Override // d.a.s0.f0.a.a
    public long getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.j : invokeV.longValue;
    }

    @Override // d.a.s0.f0.a.a
    public TbMediaTrackConfig getMediaTrackConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f59372b != null) {
                return (TbMediaTrackConfig) new Gson().fromJson(this.f59372b.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class);
            }
            return null;
        }
        return (TbMediaTrackConfig) invokeV.objValue;
    }

    @Override // d.a.s0.f0.a.a
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f59379i : invokeV.floatValue;
    }

    @Override // d.a.s0.f0.a.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            VlogEditManager vlogEditManager = this.f59372b;
            if (vlogEditManager != null) {
                return vlogEditManager.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.s0.f0.a.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            VlogEditManager vlogEditManager = this.f59372b;
            if (vlogEditManager != null) {
                vlogEditManager.onDestroy();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f59374d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onDestroy();
            }
            MultiMediaEditLayout multiMediaEditLayout = this.f59377g;
            if (multiMediaEditLayout != null) {
                multiMediaEditLayout.s();
            }
        }
    }

    @Override // d.a.s0.f0.a.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            VlogEditManager vlogEditManager = this.f59372b;
            if (vlogEditManager != null) {
                vlogEditManager.onPause();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f59374d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onPause();
            }
        }
    }

    @Override // d.a.s0.f0.a.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f59374d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onResume();
            }
            VlogEditManager vlogEditManager = this.f59372b;
            if (vlogEditManager != null) {
                vlogEditManager.onResume();
            }
        }
    }

    @Override // d.a.s0.f0.a.a
    public void pause() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (vlogEditManager = this.f59372b) == null) {
            return;
        }
        vlogEditManager.pause();
    }

    @Override // d.a.s0.f0.a.a
    public void start() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (vlogEditManager = this.f59372b) == null) {
            return;
        }
        vlogEditManager.start();
        this.n = true;
    }
}
