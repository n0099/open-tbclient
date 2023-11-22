package org.chromium.net;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.base.BuildConfig;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.NativeClassQualifiedName;
import org.chromium.base.annotations.UsedByReflection;
import org.chromium.net.ProxyChangeListener;
@UsedByReflection("WebView embedders call this to override proxy settings")
@JNINamespace("net")
/* loaded from: classes2.dex */
public class ProxyChangeListener {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "ProxyChangeListener";
    public static boolean sEnabled = true;
    public Delegate mDelegate;
    public long mNativePtr;
    public ProxyReceiver mProxyReceiver;
    public BroadcastReceiver mRealProxyReceiver;
    public final Looper mLooper = Looper.myLooper();
    public final Handler mHandler = new Handler(this.mLooper);

    /* loaded from: classes2.dex */
    public interface Delegate {
        void proxySettingsChanged();
    }

    /* loaded from: classes2.dex */
    public interface Natives {
        @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
        void proxySettingsChanged(long j, ProxyChangeListener proxyChangeListener);

        @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
        void proxySettingsChangedTo(long j, ProxyChangeListener proxyChangeListener, String str, int i, String str2, String[] strArr);
    }

    @UsedByReflection("WebView embedders call this to override proxy settings")
    /* loaded from: classes2.dex */
    public class ProxyReceiver extends BroadcastReceiver {
        public ProxyReceiver() {
        }

        public /* synthetic */ void a(Intent intent) {
            ProxyChangeListener.this.proxySettingsChanged(ProxyChangeListener.extractNewProxy(intent));
        }

        @Override // android.content.BroadcastReceiver
        @UsedByReflection("WebView embedders call this to override proxy settings")
        public void onReceive(Context context, final Intent intent) {
            if (intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
                ProxyChangeListener.this.runOnThread(new Runnable() { // from class: com.baidu.tieba.aic
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            ProxyChangeListener.ProxyReceiver.this.a(intent);
                        }
                    }
                });
            }
        }
    }

    private void assertOnThread() {
        if (BuildConfig.DCHECK_IS_ON && !onThread()) {
            throw new IllegalStateException("Must be called on ProxyChangeListener thread.");
        }
    }

    @CalledByNative
    public static ProxyChangeListener create() {
        return new ProxyChangeListener();
    }

    private boolean onThread() {
        if (this.mLooper == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    private void unregisterReceiver() {
        assertOnThread();
        ContextUtils.getApplicationContext().unregisterReceiver(this.mProxyReceiver);
        if (this.mRealProxyReceiver != null) {
            ContextUtils.getApplicationContext().unregisterReceiver(this.mRealProxyReceiver);
        }
        this.mProxyReceiver = null;
        this.mRealProxyReceiver = null;
    }

    @CalledByNative
    public void stop() {
        assertOnThread();
        this.mNativePtr = 0L;
        unregisterReceiver();
    }

    /* loaded from: classes2.dex */
    public static class ProxyConfig {
        public static final ProxyConfig DIRECT = new ProxyConfig("", 0, "", new String[0]);
        public final String[] mExclusionList;
        public final String mHost;
        public final String mPacUrl;
        public final int mPort;

        public ProxyConfig(String str, int i, String str2, String[] strArr) {
            this.mHost = str;
            this.mPort = i;
            this.mPacUrl = str2;
            this.mExclusionList = strArr;
        }

        @TargetApi(21)
        public static ProxyConfig fromProxyInfo(ProxyInfo proxyInfo) {
            String str = null;
            if (proxyInfo == null) {
                return null;
            }
            Uri pacFileUrl = proxyInfo.getPacFileUrl();
            String host = proxyInfo.getHost();
            int port = proxyInfo.getPort();
            if (!Uri.EMPTY.equals(pacFileUrl)) {
                str = pacFileUrl.toString();
            }
            return new ProxyConfig(host, port, str, proxyInfo.getExclusionList());
        }
    }

    @CalledByNative
    public static String getProperty(String str) {
        return System.getProperty(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnThread(Runnable runnable) {
        if (onThread()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    public static void setEnabled(boolean z) {
        sEnabled = z;
    }

    public /* synthetic */ void a(Intent intent) {
        proxySettingsChanged(getProxyConfig(intent));
    }

    public void setDelegateForTesting(Delegate delegate) {
        this.mDelegate = delegate;
    }

    @CalledByNative
    public void start(long j) {
        assertOnThread();
        this.mNativePtr = j;
        registerReceiver();
    }

    public void updateProxyConfigFromConnectivityManager(final Intent intent) {
        runOnThread(new Runnable() { // from class: com.baidu.tieba.zhc
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ProxyChangeListener.this.a(intent);
                }
            }
        });
    }

    public static ProxyConfig extractNewProxy(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return ProxyConfig.fromProxyInfo((ProxyInfo) extras.get("android.intent.extra.PROXY_INFO"));
        }
        try {
            Object obj = extras.get(cl.c);
            if (obj == null) {
                return null;
            }
            Class<?> cls = Class.forName("android.net.ProxyProperties");
            Method declaredMethod = cls.getDeclaredMethod("getHost", new Class[0]);
            Method declaredMethod2 = cls.getDeclaredMethod("getPort", new Class[0]);
            Method declaredMethod3 = cls.getDeclaredMethod("getExclusionList", new Class[0]);
            String str = (String) declaredMethod.invoke(obj, new Object[0]);
            int intValue = ((Integer) declaredMethod2.invoke(obj, new Object[0])).intValue();
            String[] split = ((String) declaredMethod3.invoke(obj, new Object[0])).split(",");
            if (Build.VERSION.SDK_INT >= 19) {
                String str2 = (String) cls.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(obj, new Object[0]);
                if (!TextUtils.isEmpty(str2)) {
                    return new ProxyConfig(str, intValue, str2, split);
                }
            }
            return new ProxyConfig(str, intValue, null, split);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | NullPointerException | InvocationTargetException e) {
            Log.e(TAG, "Using no proxy configuration due to exception:" + e, new Object[0]);
            return null;
        }
    }

    @TargetApi(23)
    private ProxyConfig getProxyConfig(Intent intent) {
        ProxyInfo defaultProxy = ((ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity")).getDefaultProxy();
        if (defaultProxy == null) {
            return ProxyConfig.DIRECT;
        }
        if (Build.VERSION.SDK_INT != 29 || !defaultProxy.getHost().equals("localhost") || defaultProxy.getPort() != -1) {
            return ProxyConfig.fromProxyInfo(defaultProxy);
        }
        return extractNewProxy(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void proxySettingsChanged(ProxyConfig proxyConfig) {
        assertOnThread();
        if (!sEnabled) {
            return;
        }
        Delegate delegate = this.mDelegate;
        if (delegate != null) {
            delegate.proxySettingsChanged();
        }
        if (this.mNativePtr == 0) {
            return;
        }
        if (proxyConfig != null) {
            ProxyChangeListenerJni.get().proxySettingsChangedTo(this.mNativePtr, this, proxyConfig.mHost, proxyConfig.mPort, proxyConfig.mPacUrl, proxyConfig.mExclusionList);
        } else {
            ProxyChangeListenerJni.get().proxySettingsChanged(this.mNativePtr, this);
        }
    }

    private void registerReceiver() {
        assertOnThread();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PROXY_CHANGE");
        this.mProxyReceiver = new ProxyReceiver();
        if (Build.VERSION.SDK_INT < 23) {
            ContextUtils.getApplicationContext().registerReceiver(this.mProxyReceiver, intentFilter);
            return;
        }
        ContextUtils.getApplicationContext().registerReceiver(this.mProxyReceiver, new IntentFilter());
        this.mRealProxyReceiver = new ProxyBroadcastReceiver(this);
        ContextUtils.getApplicationContext().registerReceiver(this.mRealProxyReceiver, intentFilter);
    }
}
