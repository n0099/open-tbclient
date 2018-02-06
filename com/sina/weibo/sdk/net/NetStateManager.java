package com.sina.weibo.sdk.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class NetStateManager {
    public static NetState CUR_NETSTATE = NetState.Mobile;
    private static Context mContext;

    /* loaded from: classes3.dex */
    public enum NetState {
        Mobile,
        WIFI,
        NOWAY;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetState[] valuesCustom() {
            NetState[] valuesCustom = values();
            int length = valuesCustom.length;
            NetState[] netStateArr = new NetState[length];
            System.arraycopy(valuesCustom, 0, netStateArr, 0, length);
            return netStateArr;
        }
    }

    /* loaded from: classes3.dex */
    public class NetStateReceive extends BroadcastReceiver {
        public NetStateReceive() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetStateManager.mContext = context;
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (!wifiManager.isWifiEnabled() || -1 == connectionInfo.getNetworkId()) {
                    NetStateManager.CUR_NETSTATE = NetState.Mobile;
                }
            }
        }
    }

    public static HttpHost getAPN() {
        HttpHost httpHost = null;
        Cursor query = mContext != null ? mContext.getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null) : null;
        if (query != null && query.moveToFirst()) {
            String string = query.getString(query.getColumnIndex("proxy"));
            if (string != null && string.trim().length() > 0) {
                httpHost = new HttpHost(string, 80);
            }
            query.close();
        }
        return httpHost;
    }
}
