package com.qq.e.ads.nativ;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class NativeExpressADView extends FrameLayout implements ApkDownloadComplianceInterface, DownloadConfirmListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NEADVI f40794a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40795b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f40796c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f40797d;

    /* renamed from: e  reason: collision with root package name */
    public NativeExpressMediaListener f40798e;
    public Map<String, String> ext;

    /* renamed from: f  reason: collision with root package name */
    public AdData f40799f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f40800g;

    /* renamed from: h  reason: collision with root package name */
    public ViewBindStatusListener f40801h;

    /* renamed from: i  reason: collision with root package name */
    public DownloadConfirmListener f40802i;

    /* loaded from: classes7.dex */
    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeExpressADView(NEADI neadi, Context context, ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap<String, Object> hashMap) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {neadi, context, aDSize, str, str2, jSONObject, hashMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40795b = false;
        this.f40796c = false;
        this.f40797d = false;
        this.ext = new HashMap();
        this.f40800g = false;
        this.f40799f = a(hashMap);
        GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, context, str, neadi, aDSize, str2, jSONObject, hashMap) { // from class: com.qq.e.ads.nativ.NativeExpressADView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f40803a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f40804b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ NEADI f40805c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ADSize f40806d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f40807e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f40808f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ HashMap f40809g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ NativeExpressADView f40810h;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, context, str, neadi, aDSize, str2, jSONObject, hashMap};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f40810h = this;
                this.f40803a = context;
                this.f40804b = str;
                this.f40805c = neadi;
                this.f40806d = aDSize;
                this.f40807e = str2;
                this.f40808f = jSONObject;
                this.f40809g = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (!GDTADManager.getInstance().initWith(this.f40803a, this.f40804b)) {
                        GDTLogger.e("Fail to init ADManager");
                        return;
                    }
                    try {
                        new Handler(Looper.getMainLooper()).post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.nativ.NativeExpressADView.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public /* synthetic */ POFactory f40811a;

                            /* renamed from: b  reason: collision with root package name */
                            public /* synthetic */ AnonymousClass1 f40812b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr2 = {this, r7};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i4 = newInitContext2.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.f40812b = this;
                                this.f40811a = r7;
                            }

                            /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, IGET, INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, IGET, IGET, INVOKE, MOVE_EXCEPTION] complete} */
                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        if (this.f40811a != null) {
                                            this.f40812b.f40810h.f40794a = this.f40811a.getNativeExpressADView(this.f40812b.f40805c, this.f40812b.f40803a, this.f40812b.f40810h, this.f40812b.f40806d, this.f40812b.f40804b, this.f40812b.f40807e, this.f40812b.f40808f, this.f40812b.f40809g);
                                            this.f40812b.f40810h.f40795b = true;
                                            if (this.f40812b.f40810h.f40798e != null) {
                                                this.f40812b.f40810h.setMediaListener(this.f40812b.f40810h.f40798e);
                                            }
                                            if (this.f40812b.f40810h.f40796c) {
                                                this.f40812b.f40810h.preloadVideo();
                                            }
                                            if (this.f40812b.f40810h.f40797d) {
                                                this.f40812b.f40810h.render();
                                            }
                                            if (this.f40812b.f40810h.f40800g) {
                                                this.f40812b.f40810h.negativeFeedback();
                                            }
                                        }
                                    } finally {
                                        try {
                                        } finally {
                                        }
                                    }
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init Native Express AD View plugin", th);
                    }
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0020 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AdData a(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, hashMap)) != null) {
            return (AdData) invokeL.objValue;
        }
        if (hashMap != null) {
            try {
                jSONObject = (JSONObject) hashMap.get(Constants.KEYS.AD_INFO);
            } catch (JSONException unused) {
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            obj = jSONObject.get(Constants.KEYS.AD_INFO);
            if (obj instanceof AdData) {
                return null;
            }
            return (AdData) obj;
        }
        obj = null;
        if (obj instanceof AdData) {
        }
    }

    public void destroy() {
        NEADVI neadvi;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (neadvi = this.f40794a) == null) {
            return;
        }
        neadvi.destroy();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NEADVI neadvi = this.f40794a;
            if (neadvi != null) {
                return neadvi.getApkInfoUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public AdData getBoundData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40799f : (AdData) invokeV.objValue;
    }

    public void negativeFeedback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!this.f40795b) {
                this.f40800g = true;
                return;
            }
            NEADVI neadvi = this.f40794a;
            if (neadvi == null) {
                GDTLogger.e("Native Express negativeFeedback  core is null");
                return;
            }
            neadvi.reportAdNegative();
            this.f40800g = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            ViewBindStatusListener viewBindStatusListener = this.f40801h;
            if (viewBindStatusListener != null) {
                viewBindStatusListener.onAttachedToWindow();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            ViewBindStatusListener viewBindStatusListener = this.f40801h;
            if (viewBindStatusListener != null) {
                viewBindStatusListener.onDetachedFromWindow();
            }
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048582, this, activity, i2, str, downloadConfirmCallBack) == null) || (downloadConfirmListener = this.f40802i) == null) {
            return;
        }
        downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onFinishTemporaryDetach();
            ViewBindStatusListener viewBindStatusListener = this.f40801h;
            if (viewBindStatusListener != null) {
                viewBindStatusListener.onFinishTemporaryDetach();
            }
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStartTemporaryDetach();
            ViewBindStatusListener viewBindStatusListener = this.f40801h;
            if (viewBindStatusListener != null) {
                viewBindStatusListener.onStartTemporaryDetach();
            }
        }
    }

    public void preloadVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!this.f40795b) {
                this.f40796c = true;
                return;
            }
            NEADVI neadvi = this.f40794a;
            if (neadvi != null) {
                neadvi.preloadVideo();
            } else {
                GDTLogger.e("Native Express AD View Init Error");
            }
        }
    }

    public void render() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (!this.f40795b) {
                this.f40797d = true;
                return;
            }
            NEADVI neadvi = this.f40794a;
            if (neadvi != null) {
                neadvi.render();
            } else {
                GDTLogger.e("Native Express AD View Init Error");
            }
        }
    }

    public void setAdSize(ADSize aDSize) {
        NEADVI neadvi;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aDSize) == null) || (neadvi = this.f40794a) == null) {
            return;
        }
        neadvi.setAdSize(aDSize);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, downloadConfirmListener) == null) {
            this.f40802i = downloadConfirmListener;
            NEADVI neadvi = this.f40794a;
            if (neadvi != null) {
                neadvi.setDownloadConfirmListener(this);
            }
        }
    }

    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, nativeExpressMediaListener) == null) {
            this.f40798e = nativeExpressMediaListener;
            NEADVI neadvi = this.f40794a;
            if (neadvi == null || nativeExpressMediaListener == null) {
                return;
            }
            neadvi.setAdListener(new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener));
        }
    }

    public void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, viewBindStatusListener) == null) {
            this.f40801h = viewBindStatusListener;
        }
    }
}
