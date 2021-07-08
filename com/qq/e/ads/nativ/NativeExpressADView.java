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
/* loaded from: classes6.dex */
public class NativeExpressADView extends FrameLayout implements ApkDownloadComplianceInterface, DownloadConfirmListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NEADVI f37808a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37809b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f37810c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f37811d;

    /* renamed from: e  reason: collision with root package name */
    public NativeExpressMediaListener f37812e;
    public Map<String, String> ext;

    /* renamed from: f  reason: collision with root package name */
    public AdData f37813f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f37814g;

    /* renamed from: h  reason: collision with root package name */
    public ViewBindStatusListener f37815h;

    /* renamed from: i  reason: collision with root package name */
    public DownloadConfirmListener f37816i;

    /* loaded from: classes6.dex */
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
        this.f37809b = false;
        this.f37810c = false;
        this.f37811d = false;
        this.ext = new HashMap();
        this.f37814g = false;
        this.f37813f = a(hashMap);
        GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, context, str, neadi, aDSize, str2, jSONObject, hashMap) { // from class: com.qq.e.ads.nativ.NativeExpressADView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f37817a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f37818b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ NEADI f37819c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ADSize f37820d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f37821e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f37822f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ HashMap f37823g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ NativeExpressADView f37824h;

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
                this.f37824h = this;
                this.f37817a = context;
                this.f37818b = str;
                this.f37819c = neadi;
                this.f37820d = aDSize;
                this.f37821e = str2;
                this.f37822f = jSONObject;
                this.f37823g = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (!GDTADManager.getInstance().initWith(this.f37817a, this.f37818b)) {
                        GDTLogger.e("Fail to init ADManager");
                        return;
                    }
                    try {
                        new Handler(Looper.getMainLooper()).post(new Runnable(this, GDTADManager.getInstance().getPM().getPOFactory()) { // from class: com.qq.e.ads.nativ.NativeExpressADView.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public /* synthetic */ POFactory f37825a;

                            /* renamed from: b  reason: collision with root package name */
                            public /* synthetic */ AnonymousClass1 f37826b;

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
                                this.f37826b = this;
                                this.f37825a = r7;
                            }

                            /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, IGET, INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, IGET, IGET, INVOKE, MOVE_EXCEPTION] complete} */
                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        if (this.f37825a != null) {
                                            this.f37826b.f37824h.f37808a = this.f37825a.getNativeExpressADView(this.f37826b.f37819c, this.f37826b.f37817a, this.f37826b.f37824h, this.f37826b.f37820d, this.f37826b.f37818b, this.f37826b.f37821e, this.f37826b.f37822f, this.f37826b.f37823g);
                                            this.f37826b.f37824h.f37809b = true;
                                            if (this.f37826b.f37824h.f37812e != null) {
                                                this.f37826b.f37824h.setMediaListener(this.f37826b.f37824h.f37812e);
                                            }
                                            if (this.f37826b.f37824h.f37810c) {
                                                this.f37826b.f37824h.preloadVideo();
                                            }
                                            if (this.f37826b.f37824h.f37811d) {
                                                this.f37826b.f37824h.render();
                                            }
                                            if (this.f37826b.f37824h.f37814g) {
                                                this.f37826b.f37824h.negativeFeedback();
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (neadvi = this.f37808a) == null) {
            return;
        }
        neadvi.destroy();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NEADVI neadvi = this.f37808a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37813f : (AdData) invokeV.objValue;
    }

    public void negativeFeedback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!this.f37809b) {
                this.f37814g = true;
                return;
            }
            NEADVI neadvi = this.f37808a;
            if (neadvi == null) {
                GDTLogger.e("Native Express negativeFeedback  core is null");
                return;
            }
            neadvi.reportAdNegative();
            this.f37814g = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            ViewBindStatusListener viewBindStatusListener = this.f37815h;
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
            ViewBindStatusListener viewBindStatusListener = this.f37815h;
            if (viewBindStatusListener != null) {
                viewBindStatusListener.onDetachedFromWindow();
            }
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048582, this, activity, i2, str, downloadConfirmCallBack) == null) || (downloadConfirmListener = this.f37816i) == null) {
            return;
        }
        downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onFinishTemporaryDetach();
            ViewBindStatusListener viewBindStatusListener = this.f37815h;
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
            ViewBindStatusListener viewBindStatusListener = this.f37815h;
            if (viewBindStatusListener != null) {
                viewBindStatusListener.onStartTemporaryDetach();
            }
        }
    }

    public void preloadVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!this.f37809b) {
                this.f37810c = true;
                return;
            }
            NEADVI neadvi = this.f37808a;
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
            if (!this.f37809b) {
                this.f37811d = true;
                return;
            }
            NEADVI neadvi = this.f37808a;
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
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aDSize) == null) || (neadvi = this.f37808a) == null) {
            return;
        }
        neadvi.setAdSize(aDSize);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, downloadConfirmListener) == null) {
            this.f37816i = downloadConfirmListener;
            NEADVI neadvi = this.f37808a;
            if (neadvi != null) {
                neadvi.setDownloadConfirmListener(this);
            }
        }
    }

    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, nativeExpressMediaListener) == null) {
            this.f37812e = nativeExpressMediaListener;
            NEADVI neadvi = this.f37808a;
            if (neadvi == null || nativeExpressMediaListener == null) {
                return;
            }
            neadvi.setAdListener(new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener));
        }
    }

    public void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, viewBindStatusListener) == null) {
            this.f37815h = viewBindStatusListener;
        }
    }
}
