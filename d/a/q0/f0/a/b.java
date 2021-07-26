package d.a.q0.f0.a;

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
import d.a.d.e.p.l;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements d.a.q0.f0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56648a;

    /* renamed from: b  reason: collision with root package name */
    public VlogEditManager f56649b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaDataSourceViewAdapter f56650c;

    /* renamed from: d  reason: collision with root package name */
    public TbGLMediaPreviewView f56651d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.n0.a.a f56652e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56653f;

    /* renamed from: g  reason: collision with root package name */
    public List<MultiMediaData> f56654g;

    /* renamed from: h  reason: collision with root package name */
    public float f56655h;

    /* renamed from: i  reason: collision with root package name */
    public int f56656i;
    public int j;

    /* loaded from: classes8.dex */
    public class a implements IMultiMediaPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56657a;

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
            this.f56657a = bVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56657a.f56649b == null) {
                return;
            }
            this.f56657a.f56649b.start();
        }
    }

    /* renamed from: d.a.q0.f0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1378b implements d.a.w0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56658a;

        public C1378b(b bVar) {
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
            this.f56658a = bVar;
        }

        @Override // d.a.w0.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new d.a.q0.z3.m.b(this.f56658a.f56648a.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // d.a.w0.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56658a.f56653f ? d.a.q0.v3.c.f66020c : d.a.q0.v3.c.f66021d : (String) invokeV.objValue;
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

    public b(TbPageContext tbPageContext, TbGLMediaPreviewView tbGLMediaPreviewView, TbMultiMediaData tbMultiMediaData, d.a.q0.n0.a.a aVar, boolean z) {
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
        this.f56653f = false;
        this.f56648a = tbPageContext;
        this.f56651d = tbGLMediaPreviewView;
        ArrayList arrayList = new ArrayList();
        this.f56654g = arrayList;
        arrayList.add(tbMultiMediaData);
        this.f56652e = aVar;
        this.f56653f = z;
        k();
    }

    @Override // d.a.q0.f0.a.a
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qmFilterItem)) == null) {
            if (this.f56649b != null && qmFilterItem != null) {
                float f2 = 0.0f;
                String str = IVlogEditManager.FILTER_ORIGINAL;
                if (qmFilterItem != null && !StringUtils.isNull(qmFilterItem.localPath) && !FilterValue.DEFAULT_FILTER_VALUE.equals(qmFilterItem.localPath)) {
                    f2 = (d.a.d.e.m.b.c(qmFilterItem.effect, 100.0f) * 1.0f) / 100.0f;
                    File file = new File(qmFilterItem.localPath);
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles(new c(this));
                        if (listFiles.length > 0) {
                            str = listFiles[0].getAbsolutePath();
                        }
                    }
                }
                try {
                    this.f56649b.setFilter(f2, str);
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbMultiMediaData) == null) || tbMultiMediaData == null) {
            return;
        }
        this.f56654g.clear();
        this.f56654g.add(tbMultiMediaData);
        o();
    }

    @Override // d.a.q0.f0.a.a
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // d.a.q0.f0.a.a
    public void d(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048579, this, f2) == null) || this.f56655h == f2) {
            return;
        }
        this.f56655h = f2;
        j();
        VlogEditManager vlogEditManager = this.f56649b;
        if (vlogEditManager == null || vlogEditManager.isPlaying()) {
            return;
        }
        VlogEditManager vlogEditManager2 = this.f56649b;
        vlogEditManager2.seek(vlogEditManager2.getCurrentPlayTime());
    }

    @Override // d.a.q0.f0.a.a
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.f0.a.a
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    @Override // d.a.q0.f0.a.a
    public long getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // d.a.q0.f0.a.a
    public TbMediaTrackConfig getMediaTrackConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f56649b != null) {
                return (TbMediaTrackConfig) new Gson().fromJson(this.f56649b.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class);
            }
            return null;
        }
        return (TbMediaTrackConfig) invokeV.objValue;
    }

    @Override // d.a.q0.f0.a.a
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f56655h : invokeV.floatValue;
    }

    @Override // d.a.q0.f0.a.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            VlogEditManager vlogEditManager = this.f56649b;
            if (vlogEditManager != null) {
                return vlogEditManager.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || !(this.f56651d.getLayoutParams() instanceof FrameLayout.LayoutParams) || ListUtils.isEmpty(this.f56654g) || this.f56654g.get(0) == null || this.f56654g.get(0).height <= 0 || this.f56654g.get(0).width <= 0) {
            return;
        }
        TbGLMediaPreviewView tbGLMediaPreviewView = this.f56651d;
        if (tbGLMediaPreviewView != null) {
            ViewGroup.LayoutParams layoutParams = tbGLMediaPreviewView.getLayoutParams();
            float f2 = this.f56655h;
            if (f2 > 1.0f) {
                layoutParams.width = Math.min((int) (this.f56656i / f2), this.j);
            } else if (f2 > 0.0f) {
                layoutParams.width = this.j;
            }
            layoutParams.height = (int) (layoutParams.width * this.f56655h);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            this.f56651d.setTranslationY(((this.f56656i + statusBarHeight) - layoutParams.height) * 0.5f);
            this.f56651d.setTranslationX((this.j - layoutParams.width) * 0.5f);
            this.f56651d.requestLayout();
        }
        this.f56649b.setVideoRatio(this.f56655h);
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!d.a.q0.u3.a.a()) {
                this.f56648a.getPageActivity().finish();
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
            this.f56651d.setZOrderMediaOverlay(true);
            this.f56651d.setMultiMediaDataSourceViewAdapter(this.f56650c, false);
            this.f56651d.setCanMeasure(false);
            this.f56656i = l.i(this.f56648a.getPageActivity());
            this.j = l.k(this.f56648a.getPageActivity());
            j();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a.w0.b.d().i(TbadkCoreApplication.getInst());
            d.a.w0.b.d().k(FileHelper.getCacheDir());
            d.a.w0.b.d().l(new C1378b(this));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f56650c = multiMediaDataSourceViewAdapter;
            VlogEditManager vlogEditManager = new VlogEditManager(multiMediaDataSourceViewAdapter);
            this.f56649b = vlogEditManager;
            vlogEditManager.setMultiMediaData(this.f56654g);
            this.f56649b.setLooping(true);
            this.f56649b.setPreparedListener(new a(this));
            d.a.q0.n0.a.a aVar = this.f56652e;
            if (aVar != null) {
                aVar.e(this.f56649b, this.f56650c);
            }
        }
    }

    public final void o() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (vlogEditManager = this.f56649b) == null) {
            return;
        }
        boolean isPlaying = vlogEditManager.isPlaying();
        this.f56649b.reset();
        this.f56649b.setMultiMediaData(this.f56654g);
        if (isPlaying) {
            this.f56649b.start();
        } else {
            this.f56649b.pause();
        }
    }

    @Override // d.a.q0.f0.a.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            VlogEditManager vlogEditManager = this.f56649b;
            if (vlogEditManager != null) {
                vlogEditManager.onDestroy();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f56651d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onDestroy();
            }
            d.a.q0.n0.a.a aVar = this.f56652e;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    @Override // d.a.q0.f0.a.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            VlogEditManager vlogEditManager = this.f56649b;
            if (vlogEditManager != null) {
                vlogEditManager.onPause();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f56651d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onPause();
            }
        }
    }

    @Override // d.a.q0.f0.a.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f56651d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onResume();
            }
            VlogEditManager vlogEditManager = this.f56649b;
            if (vlogEditManager != null) {
                vlogEditManager.onResume();
            }
        }
    }

    @Override // d.a.q0.f0.a.a
    public void pause() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (vlogEditManager = this.f56649b) == null) {
            return;
        }
        vlogEditManager.pause();
    }

    @Override // d.a.q0.f0.a.a
    public void start() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (vlogEditManager = this.f56649b) == null) {
            return;
        }
        vlogEditManager.start();
    }
}
