package com.sina.weibo.sdk.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Pair;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.sina.weibo.sdk.utils.LogUtil;
/* loaded from: classes7.dex */
public class NetStateManager {
    public static NetState CUR_NETSTATE = NetState.Mobile;
    public static Context mContext;

    /* loaded from: classes7.dex */
    public enum NetState {
        Mobile,
        WIFI,
        NOWAY
    }

    /* loaded from: classes7.dex */
    public class NetStateReceive extends BroadcastReceiver {
        public NetStateReceive() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Context unused = NetStateManager.mContext = context;
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (!wifiManager.isWifiEnabled() || -1 == connectionInfo.getNetworkId()) {
                    NetStateManager.CUR_NETSTATE = NetState.Mobile;
                }
            }
        }
    }

    public static Pair<String, Integer> getAPN() {
        Uri parse = Uri.parse("content://telephony/carriers/preferapn");
        Context context = mContext;
        Pair<String, Integer> pair = null;
        Cursor query = context != null ? context.getContentResolver().query(parse, null, null, null, null) : null;
        if (query != null && query.moveToFirst()) {
            String string = query.getString(query.getColumnIndex(IMTrack.AckBuilder.PROXY_TYPE));
            if (string != null && string.trim().length() > 0) {
                pair = new Pair<>(string, 80);
            }
            query.close();
        }
        return pair;
    }

    public static boolean isNetworkConnected(Context context) {
        if (context == null) {
            LogUtil.e("Weibosdk", "unexpected null context in isNetworkConnected");
            return false;
        } else if (context.getPackageManager().checkPermission(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION, context.getPackageName()) != 0) {
            return false;
        } else {
            NetworkInfo networkInfo = null;
            try {
                networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (NullPointerException unused) {
            }
            return networkInfo != null && networkInfo.isAvailable();
        }
    }
}
