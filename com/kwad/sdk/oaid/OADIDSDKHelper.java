package com.kwad.sdk.oaid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.e;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
@Keep
/* loaded from: classes10.dex */
public class OADIDSDKHelper {
    public static final String SUB_TAG = "OADIDSDKHelper:";
    public static final String TAG = "KSAdSDK";
    public static boolean mIsRequestIng;
    public static boolean sGetOaidFail;

    @Keep
    /* loaded from: classes10.dex */
    public static class IIdentifierListenerImpl implements IIdentifierListener {
        public final a mOaidListener;
        public final long mStartTime;

        public IIdentifierListenerImpl(long j, a aVar) {
            this.mStartTime = j;
            this.mOaidListener = aVar;
        }

        @Override // com.bun.miitmdid.interfaces.IIdentifierListener
        public void onSupport(IdSupplier idSupplier) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (TextUtils.isEmpty(oaid)) {
                    boolean unused = OADIDSDKHelper.sGetOaidFail = true;
                } else {
                    Log.d("KSAdSDK", "OADIDSDKHelper:oaid time=" + currentTimeMillis + "--OAID:" + oaid);
                    this.mOaidListener.cp(oaid);
                }
            }
            boolean unused2 = OADIDSDKHelper.mIsRequestIng = false;
        }
    }

    /* loaded from: classes10.dex */
    public interface a {
        void cp(String str);
    }

    public static void getOAId(Context context, a aVar) {
        if (context == null || sGetOaidFail) {
            return;
        }
        if (!isSupport()) {
            sGetOaidFail = true;
        } else if (mIsRequestIng) {
        } else {
            mIsRequestIng = true;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                int InitSdk = MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListenerImpl(currentTimeMillis, aVar));
                Log.d("KSAdSDK", "OADIDSDKHelper:sdk init time=" + (System.currentTimeMillis() - currentTimeMillis) + "--result=" + InitSdk);
            } catch (Throwable unused) {
                Log.d("KSAdSDK", "OADIDSDKHelper:oaid sdk not find ");
                mIsRequestIng = false;
                sGetOaidFail = true;
            }
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean isSupport() {
        String str;
        if (Build.VERSION.SDK_INT < 16) {
            return false;
        }
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.oaid.OADIDSDKHelper.1
                @Override // com.bun.miitmdid.interfaces.IIdentifierListener
                public final void onSupport(IdSupplier idSupplier) {
                }
            }.onSupport(null);
            try {
                int a2 = e.a();
                Log.d("KSAdSDK", "OADIDSDKHelper:oaidVersion" + a2);
                try {
                    Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, OADIDSDKHelper.class.getClassLoader());
                    return true;
                } catch (Throwable unused) {
                    str = "OADIDSDKHelper:com.bun.miitmdid.core.MdidSdkHelper oaid sdk not find ";
                    Log.d("KSAdSDK", str);
                    return false;
                }
            } catch (Throwable unused2) {
                str = "OADIDSDKHelper:oaidVersion fail";
            }
        } catch (Throwable unused3) {
            str = "OADIDSDKHelper:isSupport oaid sdk not find ";
        }
    }
}
