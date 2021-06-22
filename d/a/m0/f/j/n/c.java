package d.a.m0.f.j.n;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.download.GamenowDownloadButtomView;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.util.Base64Encoder;
import d.a.m0.a.k;
import d.a.m0.a.v2.n0;
import d.a.m0.a.v2.q0;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static final boolean r = k.f46983a;
    public static int s = 0;

    /* renamed from: a  reason: collision with root package name */
    public GamenowDownloadButtomView f50673a;

    /* renamed from: b  reason: collision with root package name */
    public j f50674b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.f.i.k.f.a f50675c;

    /* renamed from: d  reason: collision with root package name */
    public GameGuideConfigInfo.CloseInfo f50676d;

    /* renamed from: h  reason: collision with root package name */
    public String f50680h;

    /* renamed from: i  reason: collision with root package name */
    public String f50681i;
    public int k;
    public int l;
    public int m;
    public String q;

    /* renamed from: e  reason: collision with root package name */
    public String f50677e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f50678f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f50679g = "";
    public String j = "";
    public String n = "";
    public String o = "";
    public String p = "";

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!c.this.f50680h.equals("wdview")) {
                if (c.this.f50680h.equals("gbview") && c.this.f50676d != null) {
                    if (c.this.f50676d.type != 0 && c.this.f50676d.type != 1) {
                        if (c.this.f50676d.type == 2) {
                            d.a.m0.f.j.r.b.n().b("gbADialogClick", "0", "", "");
                        }
                    } else {
                        d.a.m0.f.j.r.b.n().b("gbBDialogClick", "0", "", "");
                    }
                }
            } else {
                d.a.m0.f.j.r.b.n().j("0", c.this.k, c.this.l);
            }
            c.this.s(true);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50683a;

        static {
            int[] iArr = new int[DownloadState.values().length];
            f50683a = iArr;
            try {
                iArr[DownloadState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50683a[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f50683a[DownloadState.DOWNLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f50683a[DownloadState.NOT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f50683a[DownloadState.DOWNLOAD_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f50683a[DownloadState.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: d.a.m0.f.j.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1051c extends d.a.m0.a.v1.a.b.c.c {

        /* renamed from: c  reason: collision with root package name */
        public String f50684c;

        /* renamed from: d  reason: collision with root package name */
        public String f50685d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.m0.f.i.k.f.a f50686e;

        /* renamed from: f  reason: collision with root package name */
        public String f50687f;

        /* renamed from: g  reason: collision with root package name */
        public String f50688g;

        public C1051c(String str, String str2, d.a.m0.f.i.k.f.a aVar, String str3, String str4) {
            this.f50685d = str;
            this.f50684c = str2;
            this.f50686e = aVar;
            this.f50687f = str3;
            this.f50688g = str4;
        }

        @Override // d.a.m0.a.v1.a.b.c.a
        public long a() {
            return 0L;
        }

        @Override // d.a.m0.a.v1.a.b.c.a
        public boolean c() {
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v1.a.b.c.c, d.a.m0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.m0.a.v1.a.b.a.b bVar) {
            Bundle a2 = bVar.a();
            if (a2 == null) {
                return;
            }
            c.q(a2, this.f50686e, this.f50685d, this.f50684c, this.f50687f, this.f50688g);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f50689a = new c();
    }

    public static String f(String str, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    str = d.a.m0.t.i.a(str, str2, map.get(str2));
                }
            }
        }
        return str;
    }

    public static void g(String str, String str2, String str3, String str4, int i2) {
        if (TextUtils.equals(d.a.m0.f.j.m.c.f50656a, str) && TextUtils.equals(str2, "checkPackageExpired")) {
            d.a.m0.f.j.r.b.n().m(str3, str4, i2);
        }
    }

    public static c n() {
        return d.f50689a;
    }

    public static void q(@NonNull Bundle bundle, d.a.m0.f.i.k.f.a aVar, String str, String str2, String str3, String str4) {
        char c2;
        String string = bundle.getString("functionType");
        if (string == null || aVar == null) {
            return;
        }
        String string2 = bundle.getString("resultData", "");
        if (r) {
            Log.d("DownloadButtonManager", "handleResult:function = " + string + ",result = " + string2);
        }
        int hashCode = string.hashCode();
        if (hashCode != -1013362275) {
            if (hashCode == -530890460 && string.equals("onSuccess")) {
                c2 = 0;
            }
            c2 = 65535;
        } else {
            if (string.equals("onFail")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                return;
            }
            g(str, str2, str3, str4, 0);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string2);
            int optInt = jSONObject.optInt("progress", -1);
            if (optInt > -1) {
                aVar.a(optInt);
            }
            if (jSONObject.optBoolean("installed")) {
                aVar.c(DownloadState.INSTALLED, optInt);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return;
            }
            int optInt2 = optJSONObject.optInt("status", 0);
            int value = DownloadState.NOT_START.value();
            if (optInt2 == 0) {
                aVar.c(DownloadState.DOWNLOADING, optInt);
                value = DownloadState.DOWNLOADING.value();
            } else if (optInt2 == 1) {
                aVar.c(DownloadState.DOWNLOADING, optInt);
                value = DownloadState.DOWNLOADING.value();
            } else if (optInt2 == 2) {
                aVar.c(DownloadState.DOWNLOAD_PAUSED, optInt);
                value = DownloadState.DOWNLOAD_PAUSED.value();
            } else if (optInt2 == 3) {
                aVar.c(DownloadState.DOWNLOAD_FAILED, optInt);
                value = DownloadState.DOWNLOAD_FAILED.value();
            } else if (optInt2 == 4) {
                aVar.c(DownloadState.DELETED, optInt);
                value = DownloadState.DELETED.value();
            } else if (optInt2 == 5) {
                aVar.c(DownloadState.DOWNLOADED, optInt);
                value = DownloadState.DOWNLOADED.value();
            }
            g(str, str2, str3, str4, value);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void A(String str, String str2, String str3, int i2) {
        j jVar = this.f50674b;
        if (jVar == null) {
            return;
        }
        DownloadState downloadState = jVar.f50715a;
        if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
            String str4 = this.o;
            if (TextUtils.equals(d.a.m0.f.j.m.c.f50656a, this.f50674b.f50717c)) {
                str4 = k(1, str, str2, str3);
                if (!TextUtils.isEmpty(this.q)) {
                    this.f50674b.c(this.q);
                }
            }
            this.f50674b.f50716b = str4;
            this.f50678f = str;
            if (i2 >= 0) {
                this.f50679g = String.valueOf(i2);
            }
        }
        s(false);
    }

    public final void B() {
        j jVar = this.f50674b;
        if (jVar == null) {
            return;
        }
        int i2 = b.f50683a[jVar.f50715a.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.f50673a.j(d.a.m0.a.c1.a.b().getResources().getColor(d.a.m0.f.j.e.aiapps_download_button_blue_color));
            this.f50673a.h(d.a.m0.a.c1.a.b().getResources().getColor(d.a.m0.f.j.e.aiapps_download_button_blue_color));
            this.f50673a.i(d.a.m0.a.c1.a.b().getResources().getColor(d.a.m0.f.j.e.aiapps_download_button_light_blue_color));
        } else if (i2 != 3) {
            this.f50673a.j(d.a.m0.a.c1.a.b().getResources().getColor(d.a.m0.a.c.aiapps_white));
            this.f50673a.h(d.a.m0.a.c1.a.b().getResources().getColor(d.a.m0.f.j.e.aiapps_download_button_blue_color));
            this.f50673a.i(d.a.m0.a.c1.a.b().getResources().getColor(d.a.m0.f.j.e.aiapps_download_button_light_blue_color));
        } else {
            this.f50673a.j(d.a.m0.a.c1.a.b().getResources().getColor(d.a.m0.a.c.aiapps_white));
            this.f50673a.i(d.a.m0.a.c1.a.b().getResources().getColor(d.a.m0.f.j.e.aiapps_download_button_gold_color));
        }
    }

    public final void C(String str) {
        j jVar = this.f50674b;
        if (jVar == null) {
            return;
        }
        jVar.f50717c = str;
    }

    public void D(int i2) {
        y(i2);
    }

    public void E(DownloadState downloadState) {
        z(downloadState);
    }

    public final void F() {
        String string;
        j jVar = this.f50674b;
        if (jVar == null) {
            return;
        }
        if (jVar.f50715a == DownloadState.DOWNLOADING) {
            GamenowDownloadButtomView gamenowDownloadButtomView = this.f50673a;
            if (gamenowDownloadButtomView != null && gamenowDownloadButtomView.getVisibility() != 8) {
                if (this.f50674b.f50718d < this.f50673a.getMax()) {
                    String string2 = d.a.m0.a.c1.a.b().getResources().getString(d.a.m0.f.j.k.aiapps_game_button_downloading);
                    string = String.format(string2, this.f50674b.f50718d + "%");
                } else {
                    string = d.a.m0.a.c1.a.b().getResources().getString(d.a.m0.f.j.k.aiapps_game_download_button_install);
                }
                this.f50673a.setText(string);
                this.f50673a.setProgress(this.f50674b.f50718d);
            }
        } else {
            String string3 = d.a.m0.a.c1.a.b().getResources().getString(v(this.f50674b.f50715a));
            if (this.f50674b.f50715a == DownloadState.DOWNLOADED) {
                this.f50673a.setProgress(100);
            }
            j jVar2 = this.f50674b;
            if (jVar2.f50715a == DownloadState.DOWNLOAD_PAUSED) {
                this.f50673a.setProgress(jVar2.f50718d);
            }
            this.f50673a.setText(string3);
            DownloadState downloadState = this.f50674b.f50715a;
            if ((downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) && !TextUtils.isEmpty(this.f50677e)) {
                this.f50673a.setText(this.f50677e);
            }
        }
        if (this.f50673a != null) {
            B();
            this.f50673a.setState(this.f50674b.f50715a);
            this.f50673a.postInvalidate();
        }
    }

    public final byte[] h(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64Encoder.B64Encode(bArr);
    }

    public GamenowDownloadButtomView i(d.a.m0.f.i.k.f.a aVar, String str, String str2) {
        return j(aVar, str, str2, 0, 0);
    }

    public GamenowDownloadButtomView j(d.a.m0.f.i.k.f.a aVar, String str, String str2, int i2, int i3) {
        this.f50680h = str;
        this.f50681i = str2;
        this.k = i2;
        this.l = i3;
        GameGuideConfigInfo z = d.a.m0.f.j.b.o.z();
        int color = d.a.m0.a.c1.a.b().getResources().getColor(d.a.m0.f.j.e.aiapps_download_button_blue_color);
        int color2 = d.a.m0.a.c1.a.b().getResources().getColor(d.a.m0.f.j.e.swangame_white);
        if (z != null) {
            this.j = z.configName;
            this.o = z.targetAppDownloadUrl;
            String str3 = z.targetAppPackageId;
            this.p = str3;
            if (TextUtils.equals(d.a.m0.f.j.m.c.f50656a, str3)) {
                this.q = z.gamenowApkId;
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1252040192) {
                if (hashCode == -792126734 && str.equals("wdview")) {
                    c2 = 0;
                }
            } else if (str.equals("gbview")) {
                c2 = 1;
            }
            if (c2 == 0) {
                GameGuideConfigInfo.DialogInfo dialogInfo = z.dialogInfo;
                if (dialogInfo != null) {
                    this.f50677e = dialogInfo.buttonText;
                    this.m = dialogInfo.targetType;
                    this.n = dialogInfo.target;
                }
            } else if (c2 == 1) {
                GameGuideConfigInfo.CloseInfo closeInfo = z.closeInfo;
                this.f50676d = closeInfo;
                if (closeInfo != null) {
                    try {
                        if (!TextUtils.isEmpty(closeInfo.downloadBackgroundColor) && !this.f50676d.downloadBackgroundColor.equals(StringUtil.NULL_STRING)) {
                            color = Color.parseColor(this.f50676d.downloadBackgroundColor);
                        }
                        if (!TextUtils.isEmpty(this.f50676d.downloadTextColor) && !this.f50676d.downloadTextColor.equals(StringUtil.NULL_STRING)) {
                            color2 = Color.parseColor(this.f50676d.downloadTextColor);
                        }
                    } catch (IllegalArgumentException e2) {
                        if (r) {
                            e2.printStackTrace();
                        }
                    }
                    GameGuideConfigInfo.CloseInfo closeInfo2 = this.f50676d;
                    this.f50677e = closeInfo2.buttonText;
                    this.m = closeInfo2.targetType;
                    this.n = closeInfo2.target;
                }
            }
        }
        String str4 = this.o;
        if (TextUtils.equals(d.a.m0.f.j.m.c.f50656a, this.p)) {
            str4 = k(this.m, this.n, "", "");
        }
        this.f50674b = j.a(str4, this.p);
        if (!TextUtils.isEmpty(this.q)) {
            this.f50674b.c(this.q);
        }
        this.f50675c = aVar;
        GamenowDownloadButtomView gamenowDownloadButtomView = new GamenowDownloadButtomView(d.a.m0.a.c1.a.b());
        this.f50673a = gamenowDownloadButtomView;
        gamenowDownloadButtomView.k(n0.g(16.0f));
        gamenowDownloadButtomView.f(true);
        gamenowDownloadButtomView.j(color2);
        gamenowDownloadButtomView.h(color);
        gamenowDownloadButtomView.i(d.a.m0.a.c1.a.b().getResources().getColor(d.a.m0.f.j.e.aiapps_download_button_light_blue_color));
        gamenowDownloadButtomView.g(true);
        this.f50673a.setText(this.f50677e);
        this.f50673a.setVisibility(0);
        this.f50673a.setProgress(s);
        this.f50673a.setState(DownloadState.NOT_START);
        r();
        t();
        return this.f50673a;
    }

    public final String k(int i2, String str, String str2, String str3) {
        String str4 = TextUtils.isEmpty(this.o) ? "https://gamenow.baidu.com/api/download/newest_gamenow" : this.o;
        this.o = str4;
        if (i2 == 0) {
            return str4;
        }
        String i3 = d.a.m0.a.c1.a.a0().i(AppRuntime.getAppContext());
        int J = d.a.m0.f.j.b.o.J();
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(i3)) {
            stringBuffer.append(i3);
        }
        stringBuffer.append(",");
        stringBuffer.append(J);
        if (i2 == 1) {
            if (TextUtils.isEmpty(str) || str.equals(StringUtil.NULL_STRING)) {
                str = d.a.m0.a.a2.d.g().getAppId();
            }
            stringBuffer.append(",");
            stringBuffer.append(str);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                stringBuffer.append(",");
                stringBuffer.append(str2);
                stringBuffer.append(",");
                stringBuffer.append(str3);
            }
        }
        str = (i2 != 2 || TextUtils.isEmpty(str)) ? "" : "";
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ext", new String(h(stringBuffer.toString().getBytes())));
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT, str);
            }
            jSONObject.put("path", "operate");
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d.a.m0.f.j.b bVar = d.a.m0.f.j.b.o;
        String str5 = (bVar == null || bVar.z() == null || TextUtils.isEmpty(d.a.m0.f.j.b.o.z().gamenowChannel)) ? "2101000000" : d.a.m0.f.j.b.o.z().gamenowChannel;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str6 = new String(h(jSONObject.toString().getBytes()));
        linkedHashMap.put("channel", str5);
        linkedHashMap.put("suffix", str6);
        linkedHashMap.put("filename", "");
        String f2 = f(this.o, linkedHashMap);
        if (!TextUtils.isEmpty(f2)) {
            f2 = d.a.m0.a.c1.a.n().m(f2);
        }
        if (r) {
            Log.e("DownloadButtonManager", "channel is " + str5);
            Log.e("DownloadButtonManager", "ext is " + stringBuffer.toString());
            Log.e("DownloadButtonManager", "suffixObj is " + jSONObject.toString());
            Log.e("DownloadButtonManager", "downloadUrl is " + f2);
        }
        return f2;
    }

    public String l() {
        return this.f50678f;
    }

    public String m() {
        return this.f50679g;
    }

    public String o() {
        return this.f50674b.f50716b;
    }

    public final void p(String str, d.a.m0.f.i.k.f.a aVar) {
        if (this.f50674b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("key_download_package_name", this.f50674b.f50717c);
            jSONObject.put("key_download_url", this.f50674b.f50716b);
            jSONObject2.put("from_view", this.f50680h);
            jSONObject2.put("from_value", this.f50681i);
            jSONObject2.put(GameGuideConfigInfo.KEY_CONFIG_NAME, this.j);
            jSONObject2.put("apk_id", this.f50674b.b());
            jSONObject.put("download_params", jSONObject2.toString());
            if (TextUtils.equals(str, "checkPackageExpired")) {
                jSONObject.put(GameGuideConfigInfo.KEY_PACKAGE_EXPIRE, d.a.m0.f.j.b.o.z() == null ? 0L : d.a.m0.f.j.b.o.z().packageExpire);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Bundle bundle = new Bundle();
        bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, str);
        bundle.putString("ubc_params", new d.a.m0.f.j.r.a().a());
        bundle.putString("data", jSONObject.toString());
        d.a.m0.a.v1.c.e.a z = d.a.m0.a.a2.d.g().z();
        if (z != null) {
            z.L(bundle, f.class, new C1051c(this.f50674b.f50717c, str, aVar, this.f50680h, this.f50681i));
        }
    }

    public final void r() {
        this.f50673a.setOnClickListener(new a());
    }

    public void s(boolean z) {
        if (!SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
            Toast.makeText(d.a.m0.a.c1.a.b(), d.a.m0.a.c1.a.b().getResources().getString(d.a.m0.f.j.k.aiapps_gamenow_network_disconnect), 0).show();
            return;
        }
        j jVar = this.f50674b;
        if (jVar == null) {
            return;
        }
        DownloadState downloadState = jVar.f50715a;
        if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
            if (r) {
                Log.d("DownloadButtonManager", "download start");
            }
            p("startDownload", this.f50675c);
        }
        if (this.f50674b.f50715a == DownloadState.DOWNLOADING && z) {
            if (r) {
                Log.d("DownloadButtonManager", "download pause");
            }
            p("pauseDownload", this.f50675c);
        }
        if (this.f50674b.f50715a == DownloadState.DOWNLOAD_PAUSED) {
            if (r) {
                Log.d("DownloadButtonManager", "download resume");
            }
            p("resumeDownload", this.f50675c);
        }
        if (this.f50674b.f50715a == DownloadState.DOWNLOAD_FAILED) {
            if (r) {
                Log.d("DownloadButtonManager", "download retry");
            }
            p("startDownload", this.f50675c);
        }
        if (this.f50674b.f50715a == DownloadState.DOWNLOADED) {
            if (r) {
                Log.d("DownloadButtonManager", "download install");
            }
            this.f50675c.b();
            p("installApp", this.f50675c);
        }
        if (this.f50674b.f50715a == DownloadState.INSTALLED) {
            if (r) {
                Log.d("DownloadButtonManager", "open app");
            }
            String e2 = this.f50675c.e();
            if (TextUtils.isEmpty(this.f50674b.f50717c) && !TextUtils.isEmpty(e2)) {
                C(e2);
            }
            p("open_manual", this.f50675c);
        }
    }

    public final void t() {
        if (this.f50674b == null) {
            return;
        }
        if (q0.F(d.a.m0.a.c1.a.b(), this.f50674b.f50717c)) {
            E(DownloadState.INSTALLED);
            g(this.p, "checkPackageExpired", this.f50680h, this.f50681i, DownloadState.INSTALLED.value());
            return;
        }
        p("checkPackageExpired", this.f50675c);
    }

    public void u() {
        this.f50675c = null;
        this.f50673a = null;
        this.f50674b = null;
    }

    public final int v(DownloadState downloadState) {
        switch (b.f50683a[downloadState.ordinal()]) {
            case 1:
                return d.a.m0.f.j.k.aiapps_game_download_button_pause;
            case 2:
                return d.a.m0.f.j.k.aiapps_game_download_button_continue;
            case 3:
                return d.a.m0.f.j.k.aiapps_game_download_button_install;
            case 4:
                return d.a.m0.f.j.k.aiapps_game_download_button;
            case 5:
                return d.a.m0.f.j.k.aiapps_game_download_button_failed_retry;
            case 6:
                return d.a.m0.f.j.k.aiapps_game_download_button_open;
            default:
                return d.a.m0.f.j.k.aiapps_game_download_button;
        }
    }

    public void w(String str) {
        this.f50678f = str;
    }

    public void x(String str) {
        this.f50679g = str;
    }

    public final void y(int i2) {
        j jVar = this.f50674b;
        if (jVar == null || i2 == jVar.f50718d) {
            return;
        }
        jVar.f50718d = i2;
        F();
    }

    public final void z(DownloadState downloadState) {
        j jVar = this.f50674b;
        if (jVar == null || downloadState == jVar.f50715a) {
            return;
        }
        jVar.f50715a = downloadState;
        F();
    }
}
