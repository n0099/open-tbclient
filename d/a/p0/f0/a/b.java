package d.a.p0.f0.a;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.core.edit.TbMediaTrackConfig;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
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
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.google.gson.Gson;
import d.a.c.e.p.l;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements d.a.p0.f0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56104a;

    /* renamed from: b  reason: collision with root package name */
    public VlogEditManager f56105b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaDataSourceViewAdapter f56106c;

    /* renamed from: d  reason: collision with root package name */
    public TbGLMediaPreviewView f56107d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.n0.a.a f56108e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56109f;

    /* renamed from: g  reason: collision with root package name */
    public List<MultiMediaData> f56110g;

    /* renamed from: h  reason: collision with root package name */
    public float f56111h;

    /* renamed from: i  reason: collision with root package name */
    public int f56112i;
    public int j;

    /* loaded from: classes8.dex */
    public class a implements IMultiMediaPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56113a;

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
            this.f56113a = bVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56113a.f56105b == null) {
                return;
            }
            this.f56113a.f56105b.start();
        }
    }

    /* renamed from: d.a.p0.f0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1369b implements d.a.v0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56114a;

        public C1369b(b bVar) {
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
            this.f56114a = bVar;
        }

        @Override // d.a.v0.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new d.a.p0.z3.m.b(this.f56114a.f56104a.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // d.a.v0.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56114a.f56109f ? d.a.p0.v3.c.f65372c : d.a.p0.v3.c.f65373d : (String) invokeV.objValue;
        }

        @Override // d.a.v0.c
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }

        @Override // d.a.v0.c
        public d.a.v0.j.a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (d.a.v0.j.a) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(b bVar) {
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

    public b(TbPageContext tbPageContext, TbGLMediaPreviewView tbGLMediaPreviewView, TbMultiMediaData tbMultiMediaData, d.a.p0.n0.a.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tbGLMediaPreviewView, tbMultiMediaData, aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56109f = false;
        this.f56104a = tbPageContext;
        this.f56107d = tbGLMediaPreviewView;
        ArrayList arrayList = new ArrayList();
        this.f56110g = arrayList;
        arrayList.add(tbMultiMediaData);
        this.f56108e = aVar;
        this.f56109f = z;
        k();
    }

    @Override // d.a.p0.f0.a.a
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qmFilterItem)) == null) {
            if (this.f56105b != null && qmFilterItem != null) {
                float f2 = 0.0f;
                String str = IVlogEditManager.FILTER_ORIGINAL;
                if (qmFilterItem != null && !StringUtils.isNull(qmFilterItem.localPath) && !FilterValue.DEFAULT_FILTER_VALUE.equals(qmFilterItem.localPath)) {
                    f2 = (d.a.c.e.m.b.c(qmFilterItem.effect, 100.0f) * 1.0f) / 100.0f;
                    File file = new File(qmFilterItem.localPath);
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles(new c(this));
                        if (listFiles.length > 0) {
                            str = listFiles[0].getAbsolutePath();
                        }
                    }
                }
                try {
                    this.f56105b.setFilter(f2, str);
                    return true;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.p0.f0.a.a
    public void b(TbMultiMediaData tbMultiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbMultiMediaData) == null) || tbMultiMediaData == null) {
            return;
        }
        this.f56110g.clear();
        this.f56110g.add(tbMultiMediaData);
        o();
    }

    @Override // d.a.p0.f0.a.a
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // d.a.p0.f0.a.a
    public void d(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048579, this, f2) == null) || this.f56111h == f2) {
            return;
        }
        this.f56111h = f2;
        j();
        VlogEditManager vlogEditManager = this.f56105b;
        if (vlogEditManager == null || vlogEditManager.isPlaying()) {
            return;
        }
        VlogEditManager vlogEditManager2 = this.f56105b;
        vlogEditManager2.seek(vlogEditManager2.getCurrentPlayTime());
    }

    @Override // d.a.p0.f0.a.a
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.f0.a.a
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    @Override // d.a.p0.f0.a.a
    public long getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // d.a.p0.f0.a.a
    public TbMediaTrackConfig getMediaTrackConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f56105b != null) {
                return (TbMediaTrackConfig) new Gson().fromJson(this.f56105b.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class);
            }
            return null;
        }
        return (TbMediaTrackConfig) invokeV.objValue;
    }

    @Override // d.a.p0.f0.a.a
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f56111h : invokeV.floatValue;
    }

    @Override // d.a.p0.f0.a.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            VlogEditManager vlogEditManager = this.f56105b;
            if (vlogEditManager != null) {
                return vlogEditManager.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || !(this.f56107d.getLayoutParams() instanceof FrameLayout.LayoutParams) || ListUtils.isEmpty(this.f56110g) || this.f56110g.get(0) == null || this.f56110g.get(0).height <= 0 || this.f56110g.get(0).width <= 0) {
            return;
        }
        TbGLMediaPreviewView tbGLMediaPreviewView = this.f56107d;
        if (tbGLMediaPreviewView != null) {
            ViewGroup.LayoutParams layoutParams = tbGLMediaPreviewView.getLayoutParams();
            float f2 = this.f56111h;
            if (f2 > 1.0f) {
                layoutParams.width = Math.min((int) (this.f56112i / f2), this.j);
            } else if (f2 > 0.0f) {
                layoutParams.width = this.j;
            }
            layoutParams.height = (int) (layoutParams.width * this.f56111h);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            this.f56107d.setTranslationY(((this.f56112i + statusBarHeight) - layoutParams.height) * 0.5f);
            this.f56107d.setTranslationX((this.j - layoutParams.width) * 0.5f);
            this.f56107d.requestLayout();
        }
        this.f56105b.setVideoRatio(this.f56111h);
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!d.a.p0.u3.a.a()) {
                this.f56104a.getPageActivity().finish();
                return false;
            }
            m();
            n();
            l();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f56107d.setZOrderMediaOverlay(true);
            this.f56107d.setMultiMediaDataSourceViewAdapter(this.f56106c, false);
            this.f56107d.setCanMeasure(false);
            this.f56112i = l.i(this.f56104a.getPageActivity());
            this.j = l.k(this.f56104a.getPageActivity());
            j();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a.v0.b.d().i(TbadkCoreApplication.getInst());
            d.a.v0.b.d().k(FileHelper.getCacheDir());
            d.a.v0.b.d().l(new C1369b(this));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f56106c = multiMediaDataSourceViewAdapter;
            VlogEditManager vlogEditManager = new VlogEditManager(multiMediaDataSourceViewAdapter);
            this.f56105b = vlogEditManager;
            vlogEditManager.setMultiMediaData(this.f56110g);
            this.f56105b.setLooping(true);
            this.f56105b.setPreparedListener(new a(this));
            d.a.p0.n0.a.a aVar = this.f56108e;
            if (aVar != null) {
                aVar.e(this.f56105b, this.f56106c);
            }
        }
    }

    public final void o() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (vlogEditManager = this.f56105b) == null) {
            return;
        }
        boolean isPlaying = vlogEditManager.isPlaying();
        this.f56105b.reset();
        this.f56105b.setMultiMediaData(this.f56110g);
        if (isPlaying) {
            this.f56105b.start();
        } else {
            this.f56105b.pause();
        }
    }

    @Override // d.a.p0.f0.a.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            VlogEditManager vlogEditManager = this.f56105b;
            if (vlogEditManager != null) {
                vlogEditManager.onDestroy();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f56107d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onDestroy();
            }
            d.a.p0.n0.a.a aVar = this.f56108e;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    @Override // d.a.p0.f0.a.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            VlogEditManager vlogEditManager = this.f56105b;
            if (vlogEditManager != null) {
                vlogEditManager.onPause();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f56107d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onPause();
            }
        }
    }

    @Override // d.a.p0.f0.a.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f56107d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onResume();
            }
            VlogEditManager vlogEditManager = this.f56105b;
            if (vlogEditManager != null) {
                vlogEditManager.onResume();
            }
        }
    }

    @Override // d.a.p0.f0.a.a
    public void pause() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (vlogEditManager = this.f56105b) == null) {
            return;
        }
        vlogEditManager.pause();
    }

    @Override // d.a.p0.f0.a.a
    public void start() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (vlogEditManager = this.f56105b) == null) {
            return;
        }
        vlogEditManager.start();
    }
}
