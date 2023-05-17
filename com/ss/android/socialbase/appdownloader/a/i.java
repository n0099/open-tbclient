package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.fun.ad.sdk.FunAdSdk;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class i extends a {
    public String d;
    public String e;

    public i(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str, String str2, String str3) {
        super(context, aVar, str);
        this.d = str2;
        this.e = str3;
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        String str;
        String c = this.b.c("s");
        String a = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("ak"), c);
        String a2 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c(FunAdSdk.PLATFORM_AM), c);
        String a3 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("an"), c);
        String str2 = null;
        if (!TextUtils.isEmpty(a3) && a3.split(",").length == 2) {
            String[] split = a3.split(",");
            String a4 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("al"), c);
            String a5 = com.ss.android.socialbase.appdownloader.f.c.a(this.b.c("ao"), c);
            if (!TextUtils.isEmpty(a5) && a5.split(",").length == 2) {
                String[] split2 = a5.split(",");
                JSONObject d = this.b.d("download_dir");
                if (d != null) {
                    String optString = d.optString("dir_name");
                    if (!TextUtils.isEmpty(optString) && optString.contains("%s")) {
                        try {
                            str = String.format(optString, this.e);
                        } catch (Throwable unused) {
                            str = this.e;
                        }
                    } else {
                        str = this.e;
                    }
                    str2 = str;
                    if (str2.length() > 255) {
                        str2 = a4.substring(str2.length() - 255);
                    }
                }
                Intent intent = new Intent(a);
                intent.putExtra(split2[0], split2[1]);
                intent.putExtra(a2, this.d);
                intent.putExtra(a4, str2);
                intent.putExtra(split[0], Integer.parseInt(split[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
