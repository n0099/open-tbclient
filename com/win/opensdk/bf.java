package com.win.opensdk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class bf {
    public static final String java = bf.class.getSimpleName();
    Context pYI;
    Handler pZQ = new Handler() { // from class: com.win.opensdk.bf.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 11:
                    try {
                        String str = (String) message.obj;
                        w.iK(bf.this.pYI).b(new x(bf.this.pZd), 2002, str).eGz();
                        be.i(bf.this.pYI, Uri.parse(str));
                        return;
                    } catch (Exception e) {
                        return;
                    }
                case 12:
                    try {
                        be.i(bf.this.pYI, Uri.parse((String) message.obj));
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                default:
                    return;
            }
        }
    };
    Info pZd;

    public static bf eGW() {
        return new bf();
    }

    public static boolean ai(Uri uri) {
        return "appmarket".equalsIgnoreCase(uri.getScheme());
    }

    public static boolean aj(Uri uri) {
        String scheme = uri.getScheme();
        String host = uri.getHost();
        return "market".equalsIgnoreCase(scheme) || "market.android.com".equalsIgnoreCase(host) || "play.google.com".equalsIgnoreCase(host);
    }
}
