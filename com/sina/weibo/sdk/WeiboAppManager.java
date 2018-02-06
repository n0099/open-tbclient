package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class WeiboAppManager {
    private static final String SDK_INT_FILE_NAME = "weibo_for_sdk.json";
    private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
    private static WeiboAppManager sInstance;
    private Context mContext;
    private static final String TAG = WeiboAppManager.class.getName();
    private static final Uri WEIBO_NAME_URI = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");

    /* loaded from: classes3.dex */
    public static class WeiboInfo {
        private String mPackageName;
        private int mSupportApi;

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageName(String str) {
            this.mPackageName = str;
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSupportApi(int i) {
            this.mSupportApi = i;
        }

        public int getSupportApi() {
            return this.mSupportApi;
        }

        public boolean isLegal() {
            return !TextUtils.isEmpty(this.mPackageName) && this.mSupportApi > 0;
        }

        public String toString() {
            return "WeiboInfo: PackageName = " + this.mPackageName + ", supportApi = " + this.mSupportApi;
        }
    }

    private WeiboAppManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized WeiboAppManager getInstance(Context context) {
        WeiboAppManager weiboAppManager;
        synchronized (WeiboAppManager.class) {
            if (sInstance == null) {
                sInstance = new WeiboAppManager(context);
            }
            weiboAppManager = sInstance;
        }
        return weiboAppManager;
    }

    public synchronized WeiboInfo getWeiboInfo() {
        return queryWeiboInfoInternal(this.mContext);
    }

    private WeiboInfo queryWeiboInfoInternal(Context context) {
        WeiboInfo queryWeiboInfoByProvider = queryWeiboInfoByProvider(context);
        WeiboInfo queryWeiboInfoByAsset = queryWeiboInfoByAsset(context);
        boolean z = queryWeiboInfoByProvider != null;
        boolean z2 = queryWeiboInfoByAsset != null;
        if (z && z2) {
            return queryWeiboInfoByProvider.getSupportApi() >= queryWeiboInfoByAsset.getSupportApi() ? queryWeiboInfoByProvider : queryWeiboInfoByAsset;
        } else if (!z) {
            if (z2) {
                return queryWeiboInfoByAsset;
            }
            return null;
        } else {
            return queryWeiboInfoByProvider;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [151=5, 152=5] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private WeiboInfo queryWeiboInfoByProvider(Context context) {
        Cursor cursor;
        int i;
        try {
            cursor = context.getContentResolver().query(WEIBO_NAME_URI, null, null, null, null);
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        if (cursor == null) {
            if (cursor != null) {
                cursor.close();
            }
            return null;
        }
        try {
            try {
                int columnIndex = cursor.getColumnIndex("support_api");
                int columnIndex2 = cursor.getColumnIndex("package");
                if (cursor.moveToFirst()) {
                    try {
                        i = Integer.parseInt(cursor.getString(columnIndex));
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                        i = -1;
                    }
                    String string = cursor.getString(columnIndex2);
                    if (!TextUtils.isEmpty(string) && ApiUtils.validateWeiboSign(context, string)) {
                        WeiboInfo weiboInfo = new WeiboInfo();
                        weiboInfo.setPackageName(string);
                        weiboInfo.setSupportApi(i);
                        if (cursor != null) {
                            cursor.close();
                            return weiboInfo;
                        }
                        return weiboInfo;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e3) {
                e = e3;
                LogUtil.e(TAG, e.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private WeiboInfo queryWeiboInfoByAsset(Context context) {
        WeiboInfo parseWeiboInfoByAsset;
        Intent intent = new Intent(WEIBO_IDENTITY_ACTION);
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return null;
        }
        WeiboInfo weiboInfo = null;
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.applicationInfo != null && !TextUtils.isEmpty(resolveInfo.serviceInfo.applicationInfo.packageName) && (parseWeiboInfoByAsset = parseWeiboInfoByAsset(resolveInfo.serviceInfo.applicationInfo.packageName)) != null) {
                if (weiboInfo == null) {
                    weiboInfo = parseWeiboInfoByAsset;
                } else if (weiboInfo.getSupportApi() < parseWeiboInfoByAsset.getSupportApi()) {
                    weiboInfo = parseWeiboInfoByAsset;
                }
            }
        }
        return weiboInfo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [243=7, 245=7, 246=7, 247=7] */
    public WeiboInfo parseWeiboInfoByAsset(String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                byte[] bArr = new byte[4096];
                inputStream = this.mContext.createPackageContext(str, 2).getAssets().open(SDK_INT_FILE_NAME);
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int read = inputStream.read(bArr, 0, 4096);
                        if (read == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                    if (TextUtils.isEmpty(sb.toString()) || !ApiUtils.validateWeiboSign(this.mContext, str)) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return null;
                            } catch (IOException e) {
                                LogUtil.e(TAG, e.getMessage());
                                return null;
                            }
                        }
                        return null;
                    }
                    int optInt = new JSONObject(sb.toString()).optInt("support_api", -1);
                    WeiboInfo weiboInfo = new WeiboInfo();
                    weiboInfo.setPackageName(str);
                    weiboInfo.setSupportApi(optInt);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            LogUtil.e(TAG, e2.getMessage());
                        }
                    }
                    return weiboInfo;
                } catch (PackageManager.NameNotFoundException e3) {
                    e = e3;
                    LogUtil.e(TAG, e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            return null;
                        } catch (IOException e4) {
                            LogUtil.e(TAG, e4.getMessage());
                            return null;
                        }
                    }
                    return null;
                } catch (IOException e5) {
                    e = e5;
                    LogUtil.e(TAG, e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            return null;
                        } catch (IOException e6) {
                            LogUtil.e(TAG, e6.getMessage());
                            return null;
                        }
                    }
                    return null;
                } catch (JSONException e7) {
                    e = e7;
                    LogUtil.e(TAG, e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            return null;
                        } catch (IOException e8) {
                            LogUtil.e(TAG, e8.getMessage());
                            return null;
                        }
                    }
                    return null;
                } catch (Exception e9) {
                    e = e9;
                    LogUtil.e(TAG, e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            return null;
                        } catch (IOException e10) {
                            LogUtil.e(TAG, e10.getMessage());
                            return null;
                        }
                    }
                    return null;
                }
            } catch (PackageManager.NameNotFoundException e11) {
                e = e11;
                inputStream = null;
            } catch (IOException e12) {
                e = e12;
                inputStream = null;
            } catch (JSONException e13) {
                e = e13;
                inputStream = null;
            } catch (Exception e14) {
                e = e14;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (IOException e15) {
                        LogUtil.e(TAG, e15.getMessage());
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
