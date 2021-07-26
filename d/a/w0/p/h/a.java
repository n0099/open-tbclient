package d.a.w0.p.h;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.ARType;
import com.baidu.ar.DefinedLuaListener;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.DuMixStateListener;
import com.baidu.ar.arrender.ARRenderFpsCallback;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.capture.ICaptureAbilityListener;
import com.baidu.ar.capture.ICaptureResult;
import com.baidu.ar.face.FaceListener;
import com.baidu.ar.face.FaceResultData;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterStateListener;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.minivideo.arface.bean.Filter;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.faceunity.gles.Texture2dProgram;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor;
import com.baidu.ugc.utils.SafeConcurrentHashMap;
import com.faceunity.gles.GeneratedTexture;
import d.a.a0.a.a;
import d.a.w0.t.u;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class a extends BaseEffectProcessor implements SurfaceTexture.OnFrameAvailableListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static a.l M = null;
    public static String N = "500001";
    public static float O = 0.35f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public DuMixCallback B;
    public boolean C;
    public boolean D;
    public volatile boolean E;
    public boolean F;
    public float[] G;
    public ICallbackWith<ICaptureResult> H;
    public boolean I;
    public ARRenderFpsCallback J;
    public boolean K;
    public int L;

    /* renamed from: e  reason: collision with root package name */
    public d.a.a0.a.a f68898e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.a0.a.f.a f68899f;

    /* renamed from: g  reason: collision with root package name */
    public Context f68900g;

    /* renamed from: h  reason: collision with root package name */
    public int f68901h;

    /* renamed from: i  reason: collision with root package name */
    public Sticker f68902i;
    public Filter j;
    public ConcurrentHashMap<BeautyType, Object> k;
    public int l;
    public int m;
    public d.a.w0.f.b.a n;
    public int o;
    public int[] p;
    public SurfaceTexture q;
    public int r;
    public SurfaceTexture s;
    public SurfaceTexture.OnFrameAvailableListener t;
    public FullFrameRect u;
    public l v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* renamed from: d.a.w0.p.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1945a implements DefinedLuaListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68903a;

        public C1945a(a aVar) {
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
            this.f68903a = aVar;
        }

        @Override // com.baidu.ar.DefinedLuaListener
        public void onOpenUrl(String str, int i2, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, hashMap) == null) {
            }
        }

        @Override // com.baidu.ar.DefinedLuaListener
        public void onRequireSwitchCamera(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f68903a.v == null) {
                return;
            }
            this.f68903a.v.f(i2);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements LuaMsgListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68904a;

        public b(a aVar) {
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
            this.f68904a = aVar;
        }

        @Override // com.baidu.ar.lua.LuaMsgListener
        public List<String> getMsgKeyListened() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("event_name");
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        @Override // com.baidu.ar.lua.LuaMsgListener
        public void onLuaMessage(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) || this.f68904a.v == null) {
                return;
            }
            this.f68904a.v.onLuaMessage(hashMap);
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements a.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.a0.a.a.l
        public void onHolderChanged(a.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lVar) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements FilterStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68905a;

        /* renamed from: d.a.w0.p.h.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1946a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f68906e;

            public RunnableC1946a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68906e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f68906e.f68905a.v.onBeautyEnableChanged(this.f68906e.f68905a.f68899f);
                }
            }
        }

        public d(a aVar) {
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
            this.f68905a = aVar;
        }

        @Override // com.baidu.ar.filter.FilterStateListener
        public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
            Boolean bool;
            Boolean bool2;
            Boolean bool3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, hashMap, str) == null) {
                Boolean bool4 = null;
                if (hashMap != null) {
                    bool4 = hashMap.get(FilterNode.makeupFilter);
                    bool2 = hashMap.get(FilterNode.lutFilter);
                    bool3 = hashMap.get(FilterNode.skinFilter);
                    bool = hashMap.get(FilterNode.faceFilter);
                } else {
                    bool = null;
                    bool2 = null;
                    bool3 = null;
                }
                boolean z = false;
                this.f68905a.f68899f.d(bool4 == null || bool4.booleanValue());
                this.f68905a.f68899f.c(bool2 == null || bool2.booleanValue());
                this.f68905a.f68899f.a(bool3 == null || bool3.booleanValue());
                this.f68905a.f68899f.b((bool == null || bool.booleanValue()) ? true : true);
                if (this.f68905a.v != null) {
                    u.a().post(new RunnableC1946a(this));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements DuMixCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68907e;

        /* renamed from: d.a.w0.p.h.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1947a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f68908e;

            public RunnableC1947a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68908e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f68908e.f68907e.g0();
                }
            }
        }

        public e(a aVar) {
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
            this.f68907e = aVar;
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseCreate(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) || this.f68907e.B == null) {
                return;
            }
            this.f68907e.B.onCaseCreate(z, str, str2);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseDestroy() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f68907e.B == null) {
                return;
            }
            this.f68907e.B.onCaseDestroy();
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, duMixErrorType, str, str2) == null) || this.f68907e.B == null) {
                return;
            }
            this.f68907e.B.onError(duMixErrorType, str, str2);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f68907e.B != null) {
                    this.f68907e.B.onRelease();
                }
                this.f68907e.y = false;
                this.f68907e.s = new SurfaceTexture(0);
                this.f68907e.s.detachFromGLContext();
                if (this.f68907e.v == null || this.f68907e.s == null) {
                    return;
                }
                this.f68907e.v.b(this.f68907e.s);
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), duMixInput, duMixOutput}) == null) {
                this.f68907e.y = z;
                if (this.f68907e.B != null) {
                    this.f68907e.B.onSetup(z, duMixInput, duMixOutput);
                }
                this.f68907e.z = false;
                if (!z) {
                    a aVar = this.f68907e;
                    aVar.h(1571, "onSetup返回失败：" + z);
                }
                ThreadPool.a().e(new RunnableC1947a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68909e;

        public f(a aVar) {
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
            this.f68909e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68909e.v.onBeautyEnableChanged(this.f68909e.f68899f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68910e;

        public g(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68910e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.w0.t.k.a(this.f68910e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements ICallbackWith<ICaptureResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68911a;

        public h(a aVar) {
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
            this.f68911a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.ar.callback.ICallbackWith
        /* renamed from: a */
        public void run(ICaptureResult iCaptureResult) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, iCaptureResult) == null) && iCaptureResult != null && this.f68911a.D) {
                this.f68911a.C = false;
                if (this.f68911a.v != null) {
                    this.f68911a.v.a(iCaptureResult);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements ICaptureAbilityListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68912a;

        public i(a aVar) {
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
            this.f68912a = aVar;
        }

        @Override // com.baidu.ar.capture.ICaptureAbilityListener
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68912a.C = false;
                this.f68912a.D = false;
                if (this.f68912a.f68898e != null) {
                    this.f68912a.f68898e.T0(null);
                }
            }
        }

        @Override // com.baidu.ar.capture.ICaptureAbilityListener
        public void onOpen() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f68912a.C = true;
                this.f68912a.D = false;
                if (this.f68912a.f68898e != null) {
                    this.f68912a.f68898e.T0(this.f68912a.H);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements FaceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68913a;

        public j(a aVar) {
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
            this.f68913a = aVar;
        }

        @Override // com.baidu.ar.face.FaceListener
        public void onFaceResult(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.f68913a.z && obj != null && (obj instanceof FaceResultData)) {
                FaceResultData faceResultData = (FaceResultData) obj;
                int[] faceIds = faceResultData.getFaceIds();
                if (faceIds != null) {
                    this.f68913a.L = faceIds.length;
                }
                boolean z = this.f68913a.f68901h == 1;
                float[] faceBoxes = faceResultData.getFaceBoxes();
                if (faceBoxes != null && faceBoxes.length <= 4 && faceIds != null) {
                    a aVar = this.f68913a;
                    float[] u = aVar.u(aVar.l, this.f68913a.m, z, faceBoxes[0], faceBoxes[1], faceBoxes[2], faceBoxes[3]);
                    int i2 = (int) (u[0] - u[2]);
                    int i3 = (int) (u[1] - u[3]);
                    int i4 = ((int) (u[0] + u[2])) / 2;
                    int i5 = ((int) (u[1] + u[3])) / 2;
                    if (this.f68913a.v != null) {
                        this.f68913a.v.e(i2, i3, i4, i5);
                    }
                }
                this.f68913a.k(faceResultData);
                float[] genders = faceResultData.getGenders();
                if (genders == null) {
                    return;
                }
                this.f68913a.K = genders[0] > 0.8f;
                if (this.f68913a.v != null) {
                    this.f68913a.v.onChangeGender(this.f68913a.K);
                }
                if (faceIds == null) {
                }
            }
        }

        @Override // com.baidu.ar.face.FaceListener
        public void onStickerLoadingFinished(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }

        @Override // com.baidu.ar.face.FaceListener
        public void onTriggerFired(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements DuMixStateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68914a;

        public k(a aVar) {
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
            this.f68914a = aVar;
        }

        @Override // com.baidu.ar.DuMixStateListener
        public void onInputSurfaceTextureAttach(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) || this.f68914a.v == null) {
                return;
            }
            this.f68914a.v.onInputSurfaceTextureAttach(surfaceTexture);
        }
    }

    /* loaded from: classes8.dex */
    public interface l {
        void a(ICaptureResult iCaptureResult);

        void b(SurfaceTexture surfaceTexture);

        void c();

        void d(int i2);

        void e(int i2, int i3, int i4, int i5);

        void f(int i2);

        void onBeautyEnableChanged(d.a.a0.a.f.a aVar);

        void onChangeGender(boolean z);

        void onInputSurfaceTextureAttach(SurfaceTexture surfaceTexture);

        void onLuaMessage(HashMap<String, Object> hashMap);
    }

    /* loaded from: classes8.dex */
    public static class m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f68915a;

        /* renamed from: b  reason: collision with root package name */
        public int f68916b;

        public m(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68915a = i2;
            this.f68916b = i3;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68915a : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68916b : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-990298287, "Ld/a/w0/p/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-990298287, "Ld/a/w0/p/h/a;");
                return;
            }
        }
        M = new c();
    }

    public a(Context context, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onFrameAvailableListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68899f = new d.a.a0.a.f.a();
        this.f68901h = 1;
        this.k = new SafeConcurrentHashMap();
        new SafeConcurrentHashMap();
        this.p = new int[1];
        this.w = RecordConstants.VIDEO_CONSTANT_HEIGHT;
        this.x = RecordConstants.VIDEO_CONSTANT_WIDTH;
        this.A = true;
        this.E = false;
        this.K = false;
        this.L = 0;
        this.f68900g = context;
        this.t = onFrameAvailableListener;
        this.q = new SurfaceTexture(0);
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        this.s = surfaceTexture;
        surfaceTexture.detachFromGLContext();
    }

    public void A(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            if (d.a.w0.t.c.f68925a) {
                d.a.w0.t.c.c("DuAr_ARProcessor", "initSourceSize[" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + PreferencesUtil.RIGHT_MOUNT);
            }
            if (i2 <= 0 || i3 <= 0) {
                return;
            }
            this.w = i3;
            this.x = i2;
        }
    }

    public void B(BeautyType beautyType, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, beautyType, f2) == null) {
            this.k.put(beautyType, Float.valueOf(f2));
            d.a.a0.a.a aVar = this.f68898e;
            if (aVar != null) {
                aVar.L0(beautyType, f2);
            }
        }
    }

    public void C(String str) {
        d.a.a0.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (aVar = this.f68898e) == null) {
            return;
        }
        aVar.b1(str);
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.E = z;
            if (e0() && this.f68898e != null && this.E) {
                this.f68898e.K0();
            }
        }
    }

    public boolean E(Sticker sticker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sticker)) == null) {
            int i2 = !sticker.isSupport(d.a.a0.a.a.a0()) ? d.a.w0.q.a.sticker_version_expired : 0;
            if (TextUtils.isEmpty(sticker.getPath()) || !new File(sticker.getPath()).exists()) {
                i2 = d.a.w0.q.a.sticker_file_unexists;
            }
            if (!d.a.a0.a.a.k1(sticker.getPath())) {
                i2 = d.a.w0.q.a.sticker_file_unkown;
            }
            if (i2 != 0) {
                u.a().post(new g(this, i2));
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final int G(FaceResultData faceResultData) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, faceResultData)) == null) {
            if (faceResultData != null && faceResultData.isTracked()) {
                if (faceResultData.getFaceCount() > 1) {
                    return 6;
                }
                float[] normalizedFaceBoxes = faceResultData.getNormalizedFaceBoxes();
                if (normalizedFaceBoxes != null && this.G != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < normalizedFaceBoxes.length && (i3 = i4 + 3) < normalizedFaceBoxes.length; i4 += 4) {
                        int i5 = i4 + 1;
                        arrayList.add(new float[]{normalizedFaceBoxes[i4], normalizedFaceBoxes[i5] + normalizedFaceBoxes[i3], normalizedFaceBoxes[i4] + normalizedFaceBoxes[i4 + 2], normalizedFaceBoxes[i5]});
                    }
                    while (i2 < arrayList.size()) {
                        float f2 = ((float[]) arrayList.get(i2))[0];
                        float f3 = ((float[]) arrayList.get(i2))[3];
                        float f4 = ((float[]) arrayList.get(i2))[2];
                        float f5 = ((float[]) arrayList.get(i2))[1];
                        float f6 = (f2 + f4) / 2.0f;
                        float[] fArr = this.G;
                        if (f6 >= fArr[0] && f6 <= fArr[2]) {
                            float f7 = (f3 + f5) / 2.0f;
                            i2 = (f7 >= fArr[1] && f7 <= fArr[3]) ? i2 + 1 : 0;
                        }
                        float[] fArr2 = this.G;
                        return (f4 < fArr2[0] || f2 > fArr2[2] || f5 < fArr2[1] || f3 > fArr2[3]) ? 1 : 4;
                    }
                }
                return 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final void H(Sticker sticker) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, sticker) == null) && e0()) {
            if (sticker == null) {
                this.f68898e.O();
            } else if (E(sticker)) {
                Sticker.AbilityModel abilityModel = sticker.getAbilityModel();
                if (abilityModel != null) {
                    this.f68898e.d1(abilityModel.getPath());
                }
                int arType = sticker.getArType();
                this.f68898e.j0(ARType.valueOf(arType), sticker.getPath(), sticker.getId());
            }
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.A = z;
        }
    }

    public void O(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            BeautyType beautyType = BeautyType.lutIntensity;
            Object obj = this.k.get(beautyType);
            if ((obj instanceof Float) && ((Float) obj).floatValue() == f2) {
                return;
            }
            this.k.put(beautyType, Float.valueOf(f2));
            d.a.a0.a.a aVar = this.f68898e;
            if (aVar != null) {
                aVar.L0(beautyType, f2);
            }
        }
    }

    public final void S(boolean z) {
        d.a.a0.a.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && this.y && (aVar = this.f68898e) != null) {
            if (z) {
                aVar.i1();
            } else {
                aVar.j1();
            }
        }
    }

    public Sticker V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f68902i : (Sticker) invokeV.objValue;
    }

    public Sticker W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (d.a.a0.a.b.h() != null) {
                d.a.a0.a.b.h();
                return d.a.a0.a.c.f();
            }
            return null;
        }
        return (Sticker) invokeV.objValue;
    }

    public Filter Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : (Filter) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.D = false;
        }
    }

    public final File d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, file)) == null) {
            if (file == null) {
                return null;
            }
            if (file.isFile()) {
                return file;
            }
            File[] listFiles = file.listFiles();
            for (int i2 = 0; listFiles != null && i2 < listFiles.length; i2++) {
                String name = listFiles[i2].getName();
                if (name.substring(name.lastIndexOf(".") + 1).toLowerCase().equals("png")) {
                    return listFiles[i2];
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.C = true;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            GLES20.glDeleteFramebuffers(1, this.p, 0);
            GLES20.glDeleteTextures(1, new int[]{this.o}, 0);
            this.o = 0;
        }
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.y && d.a.a0.a.a.M(this.f68898e, M) : invokeV.booleanValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || this.f68901h == i2) {
            return;
        }
        this.f68901h = i2;
    }

    public SurfaceTexture f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.s : (SurfaceTexture) invokeV.objValue;
    }

    public void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) || i2 == 0 || i3 == 0) {
            return;
        }
        if (i2 == this.mPreviewWidth && i3 == this.mPreviewHeight) {
            return;
        }
        this.mPreviewWidth = i2;
        this.mPreviewHeight = i3;
        onARDrawerCreated(this.q, this, i2, i3);
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.I) {
                H(W());
                return;
            }
            h0();
            H(V());
            n(Z());
            n0();
            j0();
        }
    }

    public final void h(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048598, this, i2, str) == null) {
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && e0()) {
            if (d.a.a0.a.b.h() != null) {
                d.a.a0.a.b.h();
                C(d.a.a0.a.c.d(true));
            }
            i0();
            D(this.E);
        }
    }

    public void i(DuMixCallback duMixCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, duMixCallback) == null) {
            this.B = duMixCallback;
        }
    }

    public final void i0() {
        d.a.a0.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (aVar = this.f68898e) == null) {
            return;
        }
        aVar.f1(d.a.a0.a.b.g());
    }

    public void j(ARRenderFpsCallback aRRenderFpsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, aRRenderFpsCallback) == null) {
            this.J = aRRenderFpsCallback;
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            C(l0());
            l(BeautyType.blackEyeCircle, 1);
            m(BeautyType.blackEyeCircle, l0());
            B(BeautyType.blackEyeCircle, 0.5f);
            C(m0());
            l(BeautyType.laughLine, 1);
            m(BeautyType.laughLine, m0());
            B(BeautyType.laughLine, 0.6f);
        }
    }

    public void k(FaceResultData faceResultData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, faceResultData) == null) {
            if (!this.C || faceResultData == null) {
                l lVar = this.v;
                if (lVar != null) {
                    lVar.d(5);
                    return;
                }
                return;
            }
            int G = this.F ? G(faceResultData) : w(faceResultData);
            l lVar2 = this.v;
            if (lVar2 != null) {
                lVar2.d(G);
            }
            if (this.F) {
                return;
            }
            if (G == 0) {
                this.D = true;
                str = "capture_timer_start";
            } else {
                this.D = false;
                str = "capture_timer_clear";
            }
            r(d.a.w0.t.j.d(str));
        }
    }

    public final String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            String e2 = d.a.a0.a.b.h() != null ? d.a.a0.a.c.e() : null;
            if (TextUtils.isEmpty(e2) || e2.charAt(e2.length() - 1) == File.separatorChar) {
                return e2;
            }
            return e2 + File.separator;
        }
        return (String) invokeV.objValue;
    }

    public void l(BeautyType beautyType, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048606, this, beautyType, i2) == null) {
            this.k.put(beautyType, Integer.valueOf(i2));
            d.a.a0.a.a aVar = this.f68898e;
            if (aVar != null) {
                aVar.M0(beautyType, i2);
            }
        }
    }

    public final String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return k0() + "blackeyecircle/open";
        }
        return (String) invokeV.objValue;
    }

    public void m(BeautyType beautyType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, beautyType, str) == null) {
            this.k.put(beautyType, str);
            d.a.a0.a.a aVar = this.f68898e;
            if (aVar != null) {
                aVar.P0(beautyType, str);
            }
        }
    }

    public final String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return k0() + "laughline/open";
        }
        return (String) invokeV.objValue;
    }

    public void n(Filter filter) {
        String str;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, filter) == null) {
            this.j = filter;
            if (filter == null && !this.A) {
                f2 = 0.0f;
                str = null;
            } else if (filter == null || N.equals(filter.getParam())) {
                if (d.a.a0.a.b.h() != null) {
                    d.a.a0.a.b.h();
                    str = d.a.a0.a.c.c();
                } else {
                    str = null;
                }
                f2 = O;
            } else {
                File d2 = d(filter.getFile());
                str = d2 != null ? d2.getAbsolutePath() : null;
                f2 = filter.getLevel();
            }
            Object obj = this.k.get(BeautyType.lutFile);
            String str2 = obj instanceof String ? (String) obj : null;
            if (str != null && !str.equals(str2)) {
                this.k.put(BeautyType.lutFile, str);
                d.a.a0.a.a aVar = this.f68898e;
                if (aVar != null && str != null) {
                    aVar.P0(BeautyType.lutFile, str);
                }
            }
            O(f2);
        }
    }

    public final void n0() {
        d.a.a0.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (aVar = this.f68898e) == null) {
            return;
        }
        aVar.R0(this.k);
    }

    public void o(Sticker sticker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, sticker) == null) {
            this.f68902i = sticker;
            H(sticker);
        }
    }

    public final boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? 1 == this.f68901h : invokeV.booleanValue;
    }

    public void onARDrawerChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048614, this, surfaceTexture, i2, i3) == null) {
        }
    }

    public void onARDrawerCreated(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048615, this, surfaceTexture, onFrameAvailableListener, i2, i3) == null) {
            if (i2 == 0 || i3 == 0) {
                i2 = this.l;
                i3 = this.m;
            }
            int i4 = i2;
            int i5 = i3;
            d.a.a0.a.a aVar = this.f68898e;
            if (aVar == null) {
                d.a.w0.t.c.c("DuAr_ARProcessor", "onARDrawerCreated Effect == null");
                return;
            }
            aVar.V0(new C1945a(this));
            this.f68898e.L(new b(this));
            this.f68898e.t0(surfaceTexture, onFrameAvailableListener, i4, i5, o0(), p0());
            this.f68898e.a1(new d(this));
        }
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048616, this, surfaceTexture, i2, i3) == null) {
            d.a.a0.a.a aVar = this.f68898e;
            if (aVar != null) {
                aVar.v0(surfaceTexture, i2, i3);
            } else {
                d.a.w0.t.c.c("DuAr_ARProcessor", "onCameraDrawerCreated Effect == null");
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.y = false;
            SurfaceTexture surfaceTexture = this.q;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.q = null;
            }
            d.a.a0.a.a aVar = this.f68898e;
            if (aVar != null) {
                aVar.B0();
                this.f68898e = null;
            }
            FullFrameRect fullFrameRect = this.u;
            if (fullFrameRect != null) {
                fullFrameRect.release(false);
            }
            if (this.F) {
                S(false);
            }
            super.onDestroy();
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, surfaceTexture) == null) {
            if (!this.z) {
                this.z = true;
                d.a.w0.f.b.a aVar = this.n;
                if (aVar != null) {
                    aVar.c();
                }
            }
            SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = this.t;
            if (onFrameAvailableListener != null) {
                onFrameAvailableListener.onFrameAvailable(surfaceTexture);
            }
            d.a.w0.f.b.a aVar2 = this.n;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            d.a.w0.f.b.a aVar = this.n;
            if (aVar != null) {
                aVar.a();
            }
            super.onPause();
            d.a.a0.a.a aVar2 = this.f68898e;
            if (aVar2 != null) {
                aVar2.y0();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(d.a.a0.b.a.e eVar, int i2, float[] fArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048620, this, eVar, i2, fArr)) == null) {
            SurfaceTexture surfaceTexture = this.q;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                this.q.getTransformMatrix(fArr);
            }
            if (this.o == 0) {
                this.o = this.u.createTexture2DObject();
                GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, this.l, this.m, 0, GeneratedTexture.FORMAT, 5121, null);
                GLES20.glBindTexture(3553, 0);
                GLES20.glGenFramebuffers(1, this.p, 0);
            }
            GLES20.glBindFramebuffer(36160, this.p[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.o, 0);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            GLES20.glViewport(0, 0, this.l, this.m);
            this.u.drawFrame(this.r, GlUtil.IDENTITY_MATRIX);
            GLES20.glBindFramebuffer(36160, 0);
            return this.o;
        }
        return invokeLIL.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            super.onResume();
            if (d.a.a0.a.a.M(this.f68898e, M)) {
                this.f68898e.F0();
                return;
            }
            l lVar = this.v;
            if (lVar != null) {
                lVar.c();
            }
            this.f68898e = d.a.a0.a.a.V(this.f68900g, M, d.a.a0.a.b.b());
            D(this.E);
            this.H = new h(this);
            this.f68898e.S0(new i(this));
            this.f68898e.X0(new j(this));
            this.f68898e.W0(new k(this));
            SurfaceTexture surfaceTexture = this.s;
            if (surfaceTexture != null && this.q != null) {
                onCameraDrawerCreated(surfaceTexture, this.w, this.x);
                int i3 = this.mPreviewWidth;
                if (i3 != 0 && (i2 = this.mPreviewHeight) != 0) {
                    onARDrawerCreated(this.q, this, i3, i2);
                }
            }
            ARRenderFpsCallback aRRenderFpsCallback = this.J;
            if (aRRenderFpsCallback != null) {
                this.f68898e.J0(aRRenderFpsCallback);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, fullFrameRect, fullFrameRect2) == null) {
            this.u = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_AR));
        }
    }

    public void p(l lVar) {
        SurfaceTexture surfaceTexture;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, lVar) == null) {
            this.v = lVar;
            if (lVar == null || (surfaceTexture = this.s) == null) {
                return;
            }
            lVar.b(surfaceTexture);
        }
    }

    public final DuMixCallback p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? new e(this) : (DuMixCallback) invokeV.objValue;
    }

    public void r(HashMap<String, Object> hashMap) {
        d.a.a0.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, hashMap) == null) || (aVar = this.f68898e) == null || hashMap == null) {
            return;
        }
        aVar.I0(hashMap);
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor
    public void releaseInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            e();
        }
    }

    public boolean s(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        d.a.a0.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048628, this, view, motionEvent)) == null) {
            Sticker V = V();
            return (V != null && V.isTouchAble()) && (aVar = this.f68898e) != null && aVar.x0(view, motionEvent);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void setPreviewSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048629, this, i2, i3) == null) {
            if (this.l != i2 || this.m != i3) {
                e();
            }
            this.l = i2;
            this.m = i3;
            onARDrawerChanged(this.q, i2, i3);
        }
    }

    public final float[] u(int i2, int i3, boolean z, float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            m mVar = new m(i2, i3);
            m mVar2 = new m(180, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
            PointF pointF = new PointF(f2, f3);
            float b2 = mVar.b() / mVar2.b();
            float a2 = mVar.a() / mVar2.a();
            float f6 = pointF.x;
            float f7 = pointF.y;
            return new float[]{(f4 + f6) * a2, (f5 + f7) * b2, f6 * a2, f7 * b2};
        }
        return (float[]) invokeCommon.objValue;
    }

    public final int w(FaceResultData faceResultData) {
        InterceptResult invokeL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, faceResultData)) == null) {
            if (faceResultData == null) {
                return 5;
            }
            boolean z2 = true;
            if (faceResultData.isTracked()) {
                float[] normalizedFaceBoxes = faceResultData.getNormalizedFaceBoxes();
                if (normalizedFaceBoxes != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < normalizedFaceBoxes.length && (i2 = i3 + 3) < normalizedFaceBoxes.length; i3 += 4) {
                        int i4 = i3 + 1;
                        arrayList.add(new float[]{normalizedFaceBoxes[i3], normalizedFaceBoxes[i4] + normalizedFaceBoxes[i2], normalizedFaceBoxes[i3] + normalizedFaceBoxes[i3 + 2], normalizedFaceBoxes[i4]});
                    }
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        float f2 = ((float[]) arrayList.get(i5))[0];
                        float f3 = ((float[]) arrayList.get(i5))[1];
                        float f4 = ((float[]) arrayList.get(i5))[2];
                        float f5 = ((float[]) arrayList.get(i5))[3];
                        if (f2 < 0.0f || f4 > 1.0f || f3 > 0.75f || f5 < 0.1f) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    return 4;
                }
                List<float[]> headPoses = faceResultData.getHeadPoses();
                if (headPoses != null) {
                    for (float[] fArr : headPoses) {
                        if (fArr.length < 3) {
                            break;
                        }
                        float f6 = fArr[0];
                        float f7 = fArr[1];
                        float f8 = fArr[2];
                        if (Math.abs(f6) > 20.0f) {
                            break;
                        } else if (Math.abs(f7) > 30.0f) {
                            break;
                        }
                    }
                }
                z2 = false;
                return z2 ? 2 : 0;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            int i2 = 1;
            r(d.a.w0.t.j.c((this.L == 1 && this.K) ? 0 : 0));
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            this.f68899f.d(i2 == 1);
            if (this.v != null) {
                u.a().post(new f(this));
            }
        }
    }
}
