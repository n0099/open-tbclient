package d.a.s0.f0.a;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.TbPageContext;
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
import d.a.s0.u3.f;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b implements d.a.s0.f0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59359a;

    /* renamed from: b  reason: collision with root package name */
    public VlogEditManager f59360b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaDataSourceViewAdapter f59361c;

    /* renamed from: d  reason: collision with root package name */
    public TbGLMediaPreviewView f59362d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.n0.a.a f59363e;

    /* renamed from: f  reason: collision with root package name */
    public List<MultiMediaData> f59364f;

    /* renamed from: g  reason: collision with root package name */
    public float f59365g;

    /* renamed from: h  reason: collision with root package name */
    public int f59366h;

    /* renamed from: i  reason: collision with root package name */
    public int f59367i;

    /* loaded from: classes9.dex */
    public class a implements IMultiMediaPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59368a;

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
            this.f59368a = bVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59368a.f59360b == null) {
                return;
            }
            this.f59368a.f59360b.start();
        }
    }

    /* renamed from: d.a.s0.f0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1415b implements d.a.y0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59369a;

        public C1415b(b bVar) {
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
            this.f59369a = bVar;
        }

        @Override // d.a.y0.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new d.a.s0.z3.m.b(this.f59369a.f59359a.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
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

    /* loaded from: classes9.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59370a;

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
                    return;
                }
            }
            this.f59370a = bVar;
        }

        @Override // d.a.s0.u3.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59370a.o();
                this.f59370a.p();
                this.f59370a.n();
            }
        }

        @Override // d.a.s0.u3.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f59370a.f59359a.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(b bVar) {
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

    public b(TbPageContext tbPageContext, TbGLMediaPreviewView tbGLMediaPreviewView, TbMultiMediaData tbMultiMediaData, d.a.s0.n0.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tbGLMediaPreviewView, tbMultiMediaData, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59359a = tbPageContext;
        this.f59362d = tbGLMediaPreviewView;
        ArrayList arrayList = new ArrayList();
        this.f59364f = arrayList;
        arrayList.add(tbMultiMediaData);
        this.f59363e = aVar;
        m();
    }

    @Override // d.a.s0.f0.a.a
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qmFilterItem)) == null) {
            if (this.f59360b != null && qmFilterItem != null) {
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
                    this.f59360b.setFilter(f2, str);
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbMultiMediaData) == null) || tbMultiMediaData == null) {
            return;
        }
        this.f59364f.clear();
        this.f59364f.add(tbMultiMediaData);
        q();
    }

    @Override // d.a.s0.f0.a.a
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // d.a.s0.f0.a.a
    public void d(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048579, this, f2) == null) || this.f59365g == f2) {
            return;
        }
        this.f59365g = f2;
        l();
        VlogEditManager vlogEditManager = this.f59360b;
        if (vlogEditManager == null || vlogEditManager.isPlaying()) {
            return;
        }
        VlogEditManager vlogEditManager2 = this.f59360b;
        vlogEditManager2.seek(vlogEditManager2.getCurrentPlayTime());
    }

    @Override // d.a.s0.f0.a.a
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.s0.f0.a.a
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    @Override // d.a.s0.f0.a.a
    public long getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // d.a.s0.f0.a.a
    public TbMediaTrackConfig getMediaTrackConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f59360b != null) {
                return (TbMediaTrackConfig) new Gson().fromJson(this.f59360b.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class);
            }
            return null;
        }
        return (TbMediaTrackConfig) invokeV.objValue;
    }

    @Override // d.a.s0.f0.a.a
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f59365g : invokeV.floatValue;
    }

    @Override // d.a.s0.f0.a.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            VlogEditManager vlogEditManager = this.f59360b;
            if (vlogEditManager != null) {
                return vlogEditManager.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || !(this.f59362d.getLayoutParams() instanceof FrameLayout.LayoutParams) || ListUtils.isEmpty(this.f59364f) || this.f59364f.get(0) == null || this.f59364f.get(0).height <= 0 || this.f59364f.get(0).width <= 0) {
            return;
        }
        TbGLMediaPreviewView tbGLMediaPreviewView = this.f59362d;
        if (tbGLMediaPreviewView != null) {
            ViewGroup.LayoutParams layoutParams = tbGLMediaPreviewView.getLayoutParams();
            float f2 = this.f59365g;
            if (f2 > 1.0f) {
                layoutParams.width = Math.min((int) (this.f59366h / f2), this.f59367i);
            } else if (f2 > 0.0f) {
                layoutParams.width = this.f59367i;
            }
            layoutParams.height = (int) (layoutParams.width * this.f59365g);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            this.f59362d.setTranslationY(((this.f59366h + statusBarHeight) - layoutParams.height) * 0.5f);
            this.f59362d.setTranslationX((this.f59367i - layoutParams.width) * 0.5f);
            this.f59362d.requestLayout();
        }
        this.f59360b.setVideoRatio(this.f59365g);
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d.a.s0.u3.b.c(this.f59359a.getPageActivity(), new c(this));
            if (d.a.s0.u3.b.b()) {
                return true;
            }
            this.f59359a.getPageActivity().finish();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f59362d.setZOrderMediaOverlay(true);
            this.f59362d.setMultiMediaDataSourceViewAdapter(this.f59361c, false);
            this.f59362d.setCanMeasure(false);
            this.f59366h = l.i(this.f59359a.getPageActivity());
            this.f59367i = l.k(this.f59359a.getPageActivity());
            l();
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a.y0.b.d().i(this.f59359a.getPageActivity());
            d.a.y0.b.d().k(FileHelper.getCacheDir());
            d.a.y0.b.d().l(new C1415b(this));
        }
    }

    @Override // d.a.s0.f0.a.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            VlogEditManager vlogEditManager = this.f59360b;
            if (vlogEditManager != null) {
                vlogEditManager.onDestroy();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f59362d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onDestroy();
            }
            d.a.s0.n0.a.a aVar = this.f59363e;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    @Override // d.a.s0.f0.a.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            VlogEditManager vlogEditManager = this.f59360b;
            if (vlogEditManager != null) {
                vlogEditManager.onPause();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f59362d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onPause();
            }
        }
    }

    @Override // d.a.s0.f0.a.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f59362d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onResume();
            }
            VlogEditManager vlogEditManager = this.f59360b;
            if (vlogEditManager != null) {
                vlogEditManager.onResume();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f59361c = multiMediaDataSourceViewAdapter;
            VlogEditManager vlogEditManager = new VlogEditManager(multiMediaDataSourceViewAdapter);
            this.f59360b = vlogEditManager;
            vlogEditManager.setMultiMediaData(this.f59364f);
            this.f59360b.setLooping(true);
            this.f59360b.setPreparedListener(new a(this));
            d.a.s0.n0.a.a aVar = this.f59363e;
            if (aVar != null) {
                aVar.e(this.f59360b, this.f59361c);
            }
        }
    }

    @Override // d.a.s0.f0.a.a
    public void pause() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (vlogEditManager = this.f59360b) == null) {
            return;
        }
        vlogEditManager.pause();
    }

    public final void q() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (vlogEditManager = this.f59360b) == null) {
            return;
        }
        boolean isPlaying = vlogEditManager.isPlaying();
        this.f59360b.reset();
        this.f59360b.setMultiMediaData(this.f59364f);
        if (isPlaying) {
            this.f59360b.start();
        } else {
            this.f59360b.pause();
        }
    }

    @Override // d.a.s0.f0.a.a
    public void start() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (vlogEditManager = this.f59360b) == null) {
            return;
        }
        vlogEditManager.start();
    }
}
