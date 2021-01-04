package com.win.opensdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.win.opensdk.downloader.WinDReceiver;
import com.win.opensdk.poseidon.PoseidonReceiver;
import java.io.UnsupportedEncodingException;
/* loaded from: classes4.dex */
public class PBInitialize {
    private static String java = PBInitialize.class.getSimpleName();

    public static void init(final Context context, String str) {
        if (context == null) {
            throw new RuntimeException("Error:Context is not allowed to be null");
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            context.registerReceiver(new PoseidonReceiver(), intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter2.addDataScheme("package");
            context.registerReceiver(new WinDReceiver(), intentFilter2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        final ao eJZ = ao.eJZ();
        if (context == null) {
            throw new RuntimeException("Error:Context is not allowed to be null");
        }
        eJZ.qbB = context.getApplicationContext();
        if (!TextUtils.isEmpty(str)) {
            az.bL(context, str);
        }
        ba.D(new Runnable() { // from class: com.win.opensdk.ao.1
            @Override // java.lang.Runnable
            public final void run() {
                final Context context2 = context;
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        try {
                            Process.myPid();
                            String iR = be.iR(context2);
                            if (!TextUtils.equals(context2.getPackageName(), iR)) {
                                WebView.setDataDirectorySuffix(iR);
                            }
                        } catch (Exception e3) {
                        }
                    }
                    be.java = System.getProperty("http.agent");
                    if (Build.VERSION.SDK_INT >= 17) {
                        be.java = WebSettings.getDefaultUserAgent(context2);
                    } else if (Looper.myLooper() == Looper.getMainLooper()) {
                        be.java = new WebView(context2).getSettings().getUserAgentString();
                    } else {
                        bb.D(new Runnable() { // from class: com.win.opensdk.be.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                be.java = new WebView(context2).getSettings().getUserAgentString();
                            }
                        });
                    }
                } catch (Exception e4) {
                }
            }
        });
        final ab iN = ab.iN(context);
        if (iN.m52java()) {
            iN.qbX = System.currentTimeMillis();
            ba.D(new Runnable() { // from class: com.win.opensdk.ab.1
                @Override // java.lang.Runnable
                public final void run() {
                    String str2 = "";
                    try {
                        str2 = ab.f7case + ak.R(ak.iO(iN.qbB));
                    } catch (UnsupportedEncodingException e3) {
                    }
                    ai.a(str2, new r<am>() { // from class: com.win.opensdk.ab.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // com.win.opensdk.r
                        public final /* synthetic */ void bG(am amVar) {
                            iN.qcD = System.currentTimeMillis() - iN.qbX;
                            ab.a(iN, amVar);
                        }

                        @Override // com.win.opensdk.r
                        public final void eJL() {
                        }

                        @Override // com.win.opensdk.r
                        public final void cc(int i, String str3) {
                            iN.qcD = System.currentTimeMillis() - iN.qbX;
                            w.iM(iN.qbB).F(i, iN.qcD).eJL();
                        }
                    });
                }
            });
        }
        v.iK(context);
        au.iK(context);
    }
}
