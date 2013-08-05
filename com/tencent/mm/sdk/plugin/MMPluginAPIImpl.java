package com.tencent.mm.sdk.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.tencent.mm.algorithm.a;
import com.tencent.mm.sdk.ConstantsUI;
import com.tencent.mm.sdk.channel.MMessage;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants;
/* loaded from: classes.dex */
public class MMPluginAPIImpl implements IMMPluginAPI {
    private static final String[] columns = {"key", "type", "value"};
    private final Context R;
    private String aE;
    private MMessage.Receiver bz;

    public MMPluginAPIImpl(Context context) {
        this.R = context;
        this.aE = context.getPackageName();
    }

    private void a(String str, String str2, Intent intent) {
        Intent intent2 = new Intent(str2);
        intent2.setClassName(MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN, "com.tencent.mm.plugin.PluginProxyUI");
        if (intent != null) {
            intent2.putExtras(intent);
        }
        intent2.putExtra(MMPluginProviderConstants.PluginIntent.ACCESS_TOKEN, str);
        this.R.startActivity(intent2);
    }

    private Object c(String str) {
        Cursor query = this.R.getContentResolver().query(MMPluginProviderConstants.PluginDB.CONTENT_URI, columns, null, new String[]{str}, null);
        if (query != null) {
            r3 = query.moveToFirst() ? MMPluginProviderConstants.Resolver.resolveObj(query.getInt(query.getColumnIndex("type")), query.getString(query.getColumnIndex("value"))) : null;
            query.close();
        }
        return r3;
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public boolean appendNetStat(int i, int i2, int i3) {
        return Util.nullAsFalse((Boolean) c("plugindb://" + this.aE + "/action.appnetstat?recv=" + i + "&send=" + i2 + "&type=" + i3));
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public void createMsgController(String str) {
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public void createQRCodeController(String str) {
        a(str, "qrcode", null);
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public void createQRCodeController(String str, MMessage.CallBack callBack) {
        createQRCodeController(str, callBack, "*");
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public void createQRCodeController(String str, MMessage.CallBack callBack, String str2) {
        a(str, "qrcode", new Intent().putExtra("qrcode_pattern", str2));
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public Profile getCurrentProfile(String str) {
        Profile profile = null;
        Cursor query = this.R.getContentResolver().query(Profile.CONTENT_URI, Profile.columns, null, new String[]{str}, null);
        if (query == null) {
            Log.e("MicroMsg.SDK.MMPluginMgrImpl", "get current profile failed");
        } else {
            if (query.moveToFirst()) {
                profile = new Profile();
                profile.convertFrom(query);
            }
            query.close();
        }
        return profile;
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public String getPluginKey(String str) {
        return (String) c("plugindb://" + str + "/comm.pluginkey");
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public boolean installPlugin(String str) {
        return Util.nullAsFalse((Boolean) c("plugindb://" + str + "/action.install"));
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public boolean isPluginInstalled(String str) {
        return Util.nullAsFalse((Boolean) c("plugindb://" + str + "/comm.installed"));
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public void jumpToBindEmail(String str) {
        a(str, "bindemail", new Intent());
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public void jumpToBindMobile(String str) {
        a(str, "bindmobile", new Intent());
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public void jumpToBindQQ(String str) {
        a(str, "bindqq", new Intent());
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public void jumpToChattingUI(String str, String str2) {
        a(str, "chatting", new Intent().putExtra(ConstantsUI.Contact.KUser, str2).setFlags(67108864));
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public void jumpToSettingView(String str, String str2) {
        a(str, "profile", new Intent().putExtra(ConstantsUI.Contact.KUser, str2).setFlags(67108864));
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public boolean registerAutoMsg(String str, String str2) {
        return Util.nullAsFalse((Boolean) c("plugindb://" + this.aE + "/action.automsg?pluginMsgUsername=" + str + "&pluginUsername=" + str2));
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public boolean registerPattern(String str, MMessage.CallBack callBack, String str2) {
        return false;
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public boolean registerQRCodePattern(String str, MMessage.CallBack callBack, String str2) {
        if (this.bz != null) {
            this.R.unregisterReceiver(this.bz);
        }
        this.bz = new MMessage.Receiver(callBack);
        this.R.registerReceiver(this.bz, new IntentFilter(MMPluginProviderConstants.PluginIntent.ACTION_QRCODE_SCANNED));
        return Util.nullAsFalse((Boolean) c("plugindb://" + str + "/action.register_qrcode_result?pattern=" + str2));
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public void release() {
        Log.d("MicroMsg.SDK.MMPluginMgrImpl", "release plugin mgr implemetation");
        if (this.bz != null) {
            this.R.unregisterReceiver(this.bz);
            Log.d("MicroMsg.SDK.MMPluginMgrImpl", "unregister qrcode scan result receiver");
        }
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public boolean sendMsgNotify(String str, String str2, int i, String str3, Class cls) {
        if (cls == null) {
            return false;
        }
        return Util.nullAsFalse((Boolean) c("plugindb://" + this.aE + "/action.msgnotify?username=" + str + "&msgContent=" + str2 + "&msgType=" + i + "&customNotify=" + str3 + "&intentUri=" + a.b(new Intent(this.R, cls).toUri(0).getBytes(), false)));
    }

    @Override // com.tencent.mm.sdk.plugin.IMMPluginAPI
    public boolean unregisterAutoMsg(String str, String str2) {
        return Util.nullAsFalse((Boolean) c("plugindb://" + this.aE + "/action.unautomsg?pluginMsgUsername=" + str + "&pluginUsername=" + str2));
    }
}
