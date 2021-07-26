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
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
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
/* loaded from: classes6.dex */
public class NativeExpressADView extends FrameLayout implements ApkDownloadComplianceInterface, DownloadConfirmListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NEADVI f37997a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37998b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f37999c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f38000d;

    /* renamed from: e  reason: collision with root package name */
    public NativeExpressMediaListener f38001e;
    public Map<String, String> ext;

    /* renamed from: f  reason: collision with root package name */
    public AdData f38002f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f38003g;

    /* renamed from: h  reason: collision with root package name */
    public ViewBindStatusListener f38004h;

    /* renamed from: i  reason: collision with root package name */
    public DownloadConfirmListener f38005i;

    /* loaded from: classes6.dex */
    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeExpressADView(NEADI neadi, NEADVI neadvi, NativeExpressADData2 nativeExpressADData2, Context context, ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap<String, Object> hashMap) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {neadi, neadvi, nativeExpressADData2, context, aDSize, str, str2, jSONObject, hashMap};
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
        this.f37998b = false;
        this.f37999c = false;
        this.f38000d = false;
        this.ext = new HashMap();
        this.f38003g = false;
        this.f38002f = a(hashMap);
        GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, context, str, neadi, neadvi, nativeExpressADData2, aDSize, str2, jSONObject, hashMap) { // from class: com.qq.e.ads.nativ.NativeExpressADView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f38006a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f38007b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ NEADI f38008c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ NEADVI f38009d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ NativeExpressADData2 f38010e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ ADSize f38011f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f38012g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ JSONObject f38013h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ HashMap f38014i;
            public final /* synthetic */ NativeExpressADView j;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, context, str, neadi, neadvi, nativeExpressADData2, aDSize, str2, jSONObject, hashMap};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.j = this;
                this.f38006a = context;
                this.f38007b = str;
                this.f38008c = neadi;
                this.f38009d = neadvi;
                this.f38010e = nativeExpressADData2;
                this.f38011f = aDSize;
                this.f38012g = str2;
                this.f38013h = jSONObject;
                this.f38014i = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (!GDTADManager.getInstance().initWith(this.f38006a, this.f38007b)) {
                        GDTLogger.e("Fail to init ADManager");
                        return;
                    }
                    try {
                        new Handler(Looper.getMainLooper()).post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.nativ.NativeExpressADView.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public /* synthetic */ POFactory f38015a;

                            /* renamed from: b  reason: collision with root package name */
                            public /* synthetic */ AnonymousClass1 f38016b;

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
                                this.f38016b = this;
                                this.f38015a = r7;
                            }

                            /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, IGET, INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, IGET, IGET, INVOKE, MOVE_EXCEPTION] complete} */
                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        if (this.f38015a != null) {
                                            this.f38016b.j.f37997a = this.f38015a.getNativeExpressADView(this.f38016b.f38008c, this.f38016b.f38009d, this.f38016b.f38010e, this.f38016b.f38006a, this.f38016b.j, this.f38016b.f38011f, this.f38016b.f38007b, this.f38016b.f38012g, this.f38016b.f38013h, this.f38016b.f38014i);
                                            this.f38016b.j.f37998b = true;
                                            if (this.f38016b.j.f38001e != null) {
                                                this.f38016b.j.setMediaListener(this.f38016b.j.f38001e);
                                            }
                                            if (this.f38016b.j.f37999c) {
                                                this.f38016b.j.preloadVideo();
                                            }
                                            if (this.f38016b.j.f38000d) {
                                                this.f38016b.j.render();
                                            }
                                            if (this.f38016b.j.f38003g) {
                                                this.f38016b.j.negativeFeedback();
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (neadvi = this.f37997a) == null) {
            return;
        }
        neadvi.destroy();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NEADVI neadvi = this.f37997a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38002f : (AdData) invokeV.objValue;
    }

    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            NEADVI neadvi = this.f37997a;
            if (neadvi != null) {
                return neadvi.getECPM();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            NEADVI neadvi = this.f37997a;
            return neadvi != null ? neadvi.getECPMLevel() : "";
        }
        return (String) invokeV.objValue;
    }

    public void negativeFeedback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!this.f37998b) {
                this.f38003g = true;
                return;
            }
            NEADVI neadvi = this.f37997a;
            if (neadvi == null) {
                GDTLogger.e("Native Express negativeFeedback  core is null");
                return;
            }
            neadvi.reportAdNegative();
            this.f38003g = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onAttachedToWindow();
            ViewBindStatusListener viewBindStatusListener = this.f38004h;
            if (viewBindStatusListener != null) {
                viewBindStatusListener.onAttachedToWindow();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            ViewBindStatusListener viewBindStatusListener = this.f38004h;
            if (viewBindStatusListener != null) {
                viewBindStatusListener.onDetachedFromWindow();
            }
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, i2, str, downloadConfirmCallBack) == null) || (downloadConfirmListener = this.f38005i) == null) {
            return;
        }
        downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onFinishTemporaryDetach();
            ViewBindStatusListener viewBindStatusListener = this.f38004h;
            if (viewBindStatusListener != null) {
                viewBindStatusListener.onFinishTemporaryDetach();
            }
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onStartTemporaryDetach();
            ViewBindStatusListener viewBindStatusListener = this.f38004h;
            if (viewBindStatusListener != null) {
                viewBindStatusListener.onStartTemporaryDetach();
            }
        }
    }

    public void preloadVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!this.f37998b) {
                this.f37999c = true;
                return;
            }
            NEADVI neadvi = this.f37997a;
            if (neadvi != null) {
                neadvi.preloadVideo();
            } else {
                GDTLogger.e("Native Express AD View Init Error");
            }
        }
    }

    public void render() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (!this.f37998b) {
                this.f38000d = true;
                return;
            }
            NEADVI neadvi = this.f37997a;
            if (neadvi != null) {
                neadvi.render();
            } else {
                GDTLogger.e("Native Express AD View Init Error");
            }
        }
    }

    @Deprecated
    public void setAdSize(ADSize aDSize) {
        NEADVI neadvi;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aDSize) == null) || (neadvi = this.f37997a) == null) {
            return;
        }
        neadvi.setAdSize(aDSize);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, downloadConfirmListener) == null) {
            this.f38005i = downloadConfirmListener;
            NEADVI neadvi = this.f37997a;
            if (neadvi != null) {
                neadvi.setDownloadConfirmListener(this);
            }
        }
    }

    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, nativeExpressMediaListener) == null) {
            this.f38001e = nativeExpressMediaListener;
            NEADVI neadvi = this.f37997a;
            if (neadvi == null || nativeExpressMediaListener == null) {
                return;
            }
            neadvi.setAdListener(new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener));
        }
    }

    public void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, viewBindStatusListener) == null) {
            this.f38004h = viewBindStatusListener;
        }
    }
}
