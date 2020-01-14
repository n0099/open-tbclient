package com.xiaomi.miui.pushads.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.xiaomi.push.ce;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class j extends AsyncTask<String, Integer, Integer> {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private Context f89a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f90a;

    /* renamed from: a  reason: collision with other field name */
    private c f91a;

    /* renamed from: a  reason: collision with other field name */
    private ce f92a;

    /* renamed from: a  reason: collision with other field name */
    private String f93a;
    private String b;

    public j(Context context, SharedPreferences sharedPreferences, String str, int i, String str2, c cVar) {
        this.f89a = context;
        this.f91a = cVar;
        this.f93a = str;
        this.f90a = sharedPreferences;
        this.b = str2;
    }

    private int a(File file) {
        h hVar = (h) this.f92a;
        String str = hVar.b;
        if (str == null) {
            return -1;
        }
        int a = b.a(this.f89a, file, str, hVar);
        d.a("下载广告 imgUrl: " + str + " 结果： " + a);
        if (isCancelled() || a != 0) {
            if (isCancelled()) {
                d.a("asynctask 被cancel");
                return a;
            }
            d.a("网络类型改变，中断下载: " + f.a(this.f89a) + HanziToPinyin.Token.SEPARATOR + a);
            return a;
        }
        return a;
    }

    private int a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int a = a(jSONObject);
            k.a("解析参数并检查, 返回结果: " + m112a(a));
            if (a != 0) {
                return a;
            }
            int c = c(jSONObject);
            if (this.f92a != null) {
                k.a("广告获取最终结果： " + c + " 类型: " + this.f92a.a);
                return c;
            }
            return c;
        } catch (JSONException e) {
            return -1;
        }
    }

    private int a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.optString("status").equals("success")) {
            int optInt = jSONObject.optInt("nonsense");
            if (optInt != 0) {
                Log.e("MIUIADSPUSH", "广告无效标志设置: " + optInt);
                d.a("广告无效");
                return -2;
            }
            long optLong = jSONObject.optLong("lastShowTime", 0L);
            l.a("expireTime: " + optLong + " currentTime: " + System.currentTimeMillis());
            if (optLong == 0 || optLong >= System.currentTimeMillis()) {
                return 0;
            }
            d.a("广告已经过期 lastShow: " + optLong + " current: " + System.currentTimeMillis());
            return -4;
        }
        return -1;
    }

    private ce a(int i) {
        ce ceVar = new ce();
        switch (i) {
            case 1:
                ceVar = new a();
                break;
            case 2:
                ceVar = new h();
                break;
        }
        ceVar.d = this.a;
        ceVar.h = this.f93a;
        return ceVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m112a(int i) {
        switch (i) {
            case -5:
                return "消息不匹配";
            case -4:
                return "过期";
            case -3:
                return "到达上限";
            case -2:
                return "广告失效";
            case -1:
                return "未知原因";
            case 0:
                return "成功";
            default:
                return "";
        }
    }

    private boolean a(int i, int i2) {
        synchronized (this.f90a) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f90a.getLong(LogBuilder.KEY_START_TIME, 0L);
            if (j == 0) {
                this.f90a.edit().putLong(LogBuilder.KEY_START_TIME, currentTimeMillis).commit();
                return true;
            } else if (currentTimeMillis - j > 86400000) {
                this.f90a.edit().putLong(LogBuilder.KEY_START_TIME, 0L).commit();
                this.f90a.edit().putInt("notifycount", 0).commit();
                this.f90a.edit().putInt("bubblecount", 0).commit();
                return true;
            } else {
                if (i2 == 2) {
                    if (this.f90a.getInt("notifycount", 0) < i) {
                        return true;
                    }
                } else if (i2 == 1 && this.f90a.getInt("bubblecount", 0) < i * 4) {
                    return true;
                }
                d.b("超过了每天接受广告的上限");
                return false;
            }
        }
    }

    private int b(JSONObject jSONObject) {
        return jSONObject.optInt("showType");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00f7 -> B:18:0x009f). Please submit an issue!!! */
    private int c(JSONObject jSONObject) {
        boolean z;
        boolean z2 = true;
        int b = b(jSONObject);
        try {
            Method method = Class.forName("miui.util.NotificationFilterHelper").getMethod("canSendNotifications", Context.class, String.class);
            k.a(this.b);
            z = !((Boolean) method.invoke(null, this.f89a, this.b)).booleanValue();
        } catch (Exception e) {
            Log.d("NotifyAdsDownloader", "reflect errors!");
            e.printStackTrace();
            z = false;
        }
        k.a("是否禁用了通知栏广告 " + z);
        int optInt = jSONObject.optInt("receiveUpperBound");
        if (optInt <= 0) {
            z2 = false;
        } else if (a(optInt, b)) {
            z2 = false;
        }
        k.a("是否达到上限 " + z2);
        try {
            if (!z2 && (b != 2 || !z)) {
                k.a("使用主广告 ");
                this.f92a = a(b);
                this.f92a.a(jSONObject);
                return 0;
            }
            k.a("使用候选广告 ");
            if (jSONObject.optLong("subAdId") <= 0) {
                k.a("没有候选广告 ");
                return -5;
            }
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("subAdInfo"));
            int b2 = b(jSONObject2);
            if (b2 == 2 && z) {
                return -6;
            }
            int a = a(jSONObject2);
            k.a("候选广告解析参数并检查： " + a);
            if (a != 0) {
                return a;
            }
            this.f92a = a(b2);
            this.f92a.a(jSONObject2);
            return 0;
        } catch (JSONException e2) {
            return -1;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Integer doInBackground(String... strArr) {
        int a = a(this.f93a);
        if (a != 0) {
            d.a("广告解析失败 " + a);
            return Integer.valueOf(a);
        }
        if (this.f92a.a == 2) {
            a = a(this.f89a.getDir("comxiaomimiuipushadssdk", 0));
        }
        return Integer.valueOf(a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.f91a != null) {
            d.a("下载 post 的结果是: " + num);
            this.f91a.a(num.intValue(), this.f92a, this);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        Log.d("ADS_DOWNLOAD", "onCancelled");
    }
}
