package d.a.v0.p.h;

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
import d.a.v0.t.u;
import d.a.z.a.a;
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
    public d.a.z.a.a f68220e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.z.a.f.a f68221f;

    /* renamed from: g  reason: collision with root package name */
    public Context f68222g;

    /* renamed from: h  reason: collision with root package name */
    public int f68223h;

    /* renamed from: i  reason: collision with root package name */
    public Sticker f68224i;
    public Filter j;
    public ConcurrentHashMap<BeautyType, Object> k;
    public int l;
    public int m;
    public d.a.v0.f.b.a n;
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

    /* renamed from: d.a.v0.p.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1940a implements DefinedLuaListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68225a;

        public C1940a(a aVar) {
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
            this.f68225a = aVar;
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
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f68225a.v == null) {
                return;
            }
            this.f68225a.v.f(i2);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements LuaMsgListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68226a;

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
            this.f68226a = aVar;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) || this.f68226a.v == null) {
                return;
            }
            this.f68226a.v.onLuaMessage(hashMap);
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

        @Override // d.a.z.a.a.l
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
        public final /* synthetic */ a f68227a;

        /* renamed from: d.a.v0.p.h.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1941a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f68228e;

            public RunnableC1941a(d dVar) {
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
                this.f68228e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f68228e.f68227a.v.onBeautyEnableChanged(this.f68228e.f68227a.f68221f);
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
            this.f68227a = aVar;
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
                this.f68227a.f68221f.d(bool4 == null || bool4.booleanValue());
                this.f68227a.f68221f.c(bool2 == null || bool2.booleanValue());
                this.f68227a.f68221f.a(bool3 == null || bool3.booleanValue());
                this.f68227a.f68221f.b((bool == null || bool.booleanValue()) ? true : true);
                if (this.f68227a.v != null) {
                    u.a().post(new RunnableC1941a(this));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements DuMixCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68229e;

        /* renamed from: d.a.v0.p.h.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1942a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f68230e;

            public RunnableC1942a(e eVar) {
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
                this.f68230e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f68230e.f68229e.g0();
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
            this.f68229e = aVar;
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseCreate(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) || this.f68229e.B == null) {
                return;
            }
            this.f68229e.B.onCaseCreate(z, str, str2);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseDestroy() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f68229e.B == null) {
                return;
            }
            this.f68229e.B.onCaseDestroy();
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, duMixErrorType, str, str2) == null) || this.f68229e.B == null) {
                return;
            }
            this.f68229e.B.onError(duMixErrorType, str, str2);
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f68229e.B != null) {
                    this.f68229e.B.onRelease();
                }
                this.f68229e.y = false;
                this.f68229e.s = new SurfaceTexture(0);
                this.f68229e.s.detachFromGLContext();
                if (this.f68229e.v == null || this.f68229e.s == null) {
                    return;
                }
                this.f68229e.v.b(this.f68229e.s);
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), duMixInput, duMixOutput}) == null) {
                this.f68229e.y = z;
                if (this.f68229e.B != null) {
                    this.f68229e.B.onSetup(z, duMixInput, duMixOutput);
                }
                this.f68229e.z = false;
                if (!z) {
                    a aVar = this.f68229e;
                    aVar.h(1571, "onSetup返回失败：" + z);
                }
                ThreadPool.a().e(new RunnableC1942a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68231e;

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
            this.f68231e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68231e.v.onBeautyEnableChanged(this.f68231e.f68221f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68232e;

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
            this.f68232e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.v0.t.k.a(this.f68232e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements ICallbackWith<ICaptureResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68233a;

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
            this.f68233a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.ar.callback.ICallbackWith
        /* renamed from: a */
        public void run(ICaptureResult iCaptureResult) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, iCaptureResult) == null) && iCaptureResult != null && this.f68233a.D) {
                this.f68233a.C = false;
                if (this.f68233a.v != null) {
                    this.f68233a.v.a(iCaptureResult);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements ICaptureAbilityListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68234a;

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
            this.f68234a = aVar;
        }

        @Override // com.baidu.ar.capture.ICaptureAbilityListener
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68234a.C = false;
                this.f68234a.D = false;
                if (this.f68234a.f68220e != null) {
                    this.f68234a.f68220e.T0(null);
                }
            }
        }

        @Override // com.baidu.ar.capture.ICaptureAbilityListener
        public void onOpen() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f68234a.C = true;
                this.f68234a.D = false;
                if (this.f68234a.f68220e != null) {
                    this.f68234a.f68220e.T0(this.f68234a.H);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements FaceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68235a;

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
            this.f68235a = aVar;
        }

        @Override // com.baidu.ar.face.FaceListener
        public void onFaceResult(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.f68235a.z && obj != null && (obj instanceof FaceResultData)) {
                FaceResultData faceResultData = (FaceResultData) obj;
                int[] faceIds = faceResultData.getFaceIds();
                if (faceIds != null) {
                    this.f68235a.L = faceIds.length;
                }
                boolean z = this.f68235a.f68223h == 1;
                float[] faceBoxes = faceResultData.getFaceBoxes();
                if (faceBoxes != null && faceBoxes.length <= 4 && faceIds != null) {
                    a aVar = this.f68235a;
                    float[] u = aVar.u(aVar.l, this.f68235a.m, z, faceBoxes[0], faceBoxes[1], faceBoxes[2], faceBoxes[3]);
                    int i2 = (int) (u[0] - u[2]);
                    int i3 = (int) (u[1] - u[3]);
                    int i4 = ((int) (u[0] + u[2])) / 2;
                    int i5 = ((int) (u[1] + u[3])) / 2;
                    if (this.f68235a.v != null) {
                        this.f68235a.v.e(i2, i3, i4, i5);
                    }
                }
                this.f68235a.k(faceResultData);
                float[] genders = faceResultData.getGenders();
                if (genders == null) {
                    return;
                }
                this.f68235a.K = genders[0] > 0.8f;
                if (this.f68235a.v != null) {
                    this.f68235a.v.onChangeGender(this.f68235a.K);
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
        public final /* synthetic */ a f68236a;

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
            this.f68236a = aVar;
        }

        @Override // com.baidu.ar.DuMixStateListener
        public void onInputSurfaceTextureAttach(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, surfaceTexture) == null) || this.f68236a.v == null) {
                return;
            }
            this.f68236a.v.onInputSurfaceTextureAttach(surfaceTexture);
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

        void onBeautyEnableChanged(d.a.z.a.f.a aVar);

        void onChangeGender(boolean z);

        void onInputSurfaceTextureAttach(SurfaceTexture surfaceTexture);

        void onLuaMessage(HashMap<String, Object> hashMap);
    }

    /* loaded from: classes8.dex */
    public static class m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f68237a;

        /* renamed from: b  reason: collision with root package name */
        public int f68238b;

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
            this.f68237a = i2;
            this.f68238b = i3;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68237a : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68238b : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(817156176, "Ld/a/v0/p/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(817156176, "Ld/a/v0/p/h/a;");
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
        this.f68221f = new d.a.z.a.f.a();
        this.f68223h = 1;
        this.k = new SafeConcurrentHashMap();
        new SafeConcurrentHashMap();
        this.p = new int[1];
        this.w = RecordConstants.VIDEO_CONSTANT_HEIGHT;
        this.x = RecordConstants.VIDEO_CONSTANT_WIDTH;
        this.A = true;
        this.E = false;
        this.K = false;
        this.L = 0;
        this.f68222g = context;
        this.t = onFrameAvailableListener;
        this.q = new SurfaceTexture(0);
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        this.s = surfaceTexture;
        surfaceTexture.detachFromGLContext();
    }

    public void A(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            if (d.a.v0.t.c.f68247a) {
                d.a.v0.t.c.c("DuAr_ARProcessor", "initSourceSize[" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + PreferencesUtil.RIGHT_MOUNT);
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
            d.a.z.a.a aVar = this.f68220e;
            if (aVar != null) {
                aVar.L0(beautyType, f2);
            }
        }
    }

    public void C(String str) {
        d.a.z.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (aVar = this.f68220e) == null) {
            return;
        }
        aVar.b1(str);
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.E = z;
            if (e0() && this.f68220e != null && this.E) {
                this.f68220e.K0();
            }
        }
    }

    public boolean E(Sticker sticker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sticker)) == null) {
            int i2 = !sticker.isSupport(d.a.z.a.a.a0()) ? d.a.v0.q.a.sticker_version_expired : 0;
            if (TextUtils.isEmpty(sticker.getPath()) || !new File(sticker.getPath()).exists()) {
                i2 = d.a.v0.q.a.sticker_file_unexists;
            }
            if (!d.a.z.a.a.k1(sticker.getPath())) {
                i2 = d.a.v0.q.a.sticker_file_unkown;
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
                this.f68220e.O();
            } else if (E(sticker)) {
                Sticker.AbilityModel abilityModel = sticker.getAbilityModel();
                if (abilityModel != null) {
                    this.f68220e.d1(abilityModel.getPath());
                }
                int arType = sticker.getArType();
                this.f68220e.j0(ARType.valueOf(arType), sticker.getPath(), sticker.getId());
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
            d.a.z.a.a aVar = this.f68220e;
            if (aVar != null) {
                aVar.L0(beautyType, f2);
            }
        }
    }

    public final void S(boolean z) {
        d.a.z.a.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && this.y && (aVar = this.f68220e) != null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f68224i : (Sticker) invokeV.objValue;
    }

    public Sticker W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (d.a.z.a.b.h() != null) {
                d.a.z.a.b.h();
                return d.a.z.a.c.f();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.y && d.a.z.a.a.M(this.f68220e, M) : invokeV.booleanValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || this.f68223h == i2) {
            return;
        }
        this.f68223h = i2;
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
            if (d.a.z.a.b.h() != null) {
                d.a.z.a.b.h();
                C(d.a.z.a.c.d(true));
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
        d.a.z.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (aVar = this.f68220e) == null) {
            return;
        }
        aVar.f1(d.a.z.a.b.g());
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
            r(d.a.v0.t.j.d(str));
        }
    }

    public final String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            String e2 = d.a.z.a.b.h() != null ? d.a.z.a.c.e() : null;
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
            d.a.z.a.a aVar = this.f68220e;
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
            d.a.z.a.a aVar = this.f68220e;
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
                if (d.a.z.a.b.h() != null) {
                    d.a.z.a.b.h();
                    str = d.a.z.a.c.c();
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
                d.a.z.a.a aVar = this.f68220e;
                if (aVar != null && str != null) {
                    aVar.P0(BeautyType.lutFile, str);
                }
            }
            O(f2);
        }
    }

    public final void n0() {
        d.a.z.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (aVar = this.f68220e) == null) {
            return;
        }
        aVar.R0(this.k);
    }

    public void o(Sticker sticker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, sticker) == null) {
            this.f68224i = sticker;
            H(sticker);
        }
    }

    public final boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? 1 == this.f68223h : invokeV.booleanValue;
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
            d.a.z.a.a aVar = this.f68220e;
            if (aVar == null) {
                d.a.v0.t.c.c("DuAr_ARProcessor", "onARDrawerCreated Effect == null");
                return;
            }
            aVar.V0(new C1940a(this));
            this.f68220e.L(new b(this));
            this.f68220e.t0(surfaceTexture, onFrameAvailableListener, i4, i5, o0(), p0());
            this.f68220e.a1(new d(this));
        }
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048616, this, surfaceTexture, i2, i3) == null) {
            d.a.z.a.a aVar = this.f68220e;
            if (aVar != null) {
                aVar.v0(surfaceTexture, i2, i3);
            } else {
                d.a.v0.t.c.c("DuAr_ARProcessor", "onCameraDrawerCreated Effect == null");
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
            d.a.z.a.a aVar = this.f68220e;
            if (aVar != null) {
                aVar.B0();
                this.f68220e = null;
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
                d.a.v0.f.b.a aVar = this.n;
                if (aVar != null) {
                    aVar.c();
                }
            }
            SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = this.t;
            if (onFrameAvailableListener != null) {
                onFrameAvailableListener.onFrameAvailable(surfaceTexture);
            }
            d.a.v0.f.b.a aVar2 = this.n;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.BaseEffectProcessor, com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            d.a.v0.f.b.a aVar = this.n;
            if (aVar != null) {
                aVar.a();
            }
            super.onPause();
            d.a.z.a.a aVar2 = this.f68220e;
            if (aVar2 != null) {
                aVar2.y0();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int onProcessFrame(d.a.z.b.a.e eVar, int i2, float[] fArr) {
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
            if (d.a.z.a.a.M(this.f68220e, M)) {
                this.f68220e.F0();
                return;
            }
            l lVar = this.v;
            if (lVar != null) {
                lVar.c();
            }
            this.f68220e = d.a.z.a.a.V(this.f68222g, M, d.a.z.a.b.b());
            D(this.E);
            this.H = new h(this);
            this.f68220e.S0(new i(this));
            this.f68220e.X0(new j(this));
            this.f68220e.W0(new k(this));
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
                this.f68220e.J0(aRRenderFpsCallback);
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
        d.a.z.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, hashMap) == null) || (aVar = this.f68220e) == null || hashMap == null) {
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
        d.a.z.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048628, this, view, motionEvent)) == null) {
            Sticker V = V();
            return (V != null && V.isTouchAble()) && (aVar = this.f68220e) != null && aVar.x0(view, motionEvent);
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
            r(d.a.v0.t.j.c((this.L == 1 && this.K) ? 0 : 0));
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            this.f68221f.d(i2 == 1);
            if (this.v != null) {
                u.a().post(new f(this));
            }
        }
    }
}
