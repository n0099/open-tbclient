package d.a.l0.f.j.n;

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
import d.a.l0.a.k;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q0;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static final boolean r = k.f43199a;
    public static int s = 0;

    /* renamed from: a  reason: collision with root package name */
    public GamenowDownloadButtomView f46891a;

    /* renamed from: b  reason: collision with root package name */
    public j f46892b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.f.i.k.f.a f46893c;

    /* renamed from: d  reason: collision with root package name */
    public GameGuideConfigInfo.CloseInfo f46894d;

    /* renamed from: h  reason: collision with root package name */
    public String f46898h;

    /* renamed from: i  reason: collision with root package name */
    public String f46899i;
    public int k;
    public int l;
    public int m;
    public String q;

    /* renamed from: e  reason: collision with root package name */
    public String f46895e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f46896f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f46897g = "";
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
            if (!c.this.f46898h.equals("wdview")) {
                if (c.this.f46898h.equals("gbview") && c.this.f46894d != null) {
                    if (c.this.f46894d.type != 0 && c.this.f46894d.type != 1) {
                        if (c.this.f46894d.type == 2) {
                            d.a.l0.f.j.r.b.n().b("gbADialogClick", "0", "", "");
                        }
                    } else {
                        d.a.l0.f.j.r.b.n().b("gbBDialogClick", "0", "", "");
                    }
                }
            } else {
                d.a.l0.f.j.r.b.n().j("0", c.this.k, c.this.l);
            }
            c.this.s(true);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f46901a;

        static {
            int[] iArr = new int[DownloadState.values().length];
            f46901a = iArr;
            try {
                iArr[DownloadState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46901a[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46901a[DownloadState.DOWNLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46901a[DownloadState.NOT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46901a[DownloadState.DOWNLOAD_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f46901a[DownloadState.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: d.a.l0.f.j.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0992c extends d.a.l0.a.v1.a.b.c.c {

        /* renamed from: c  reason: collision with root package name */
        public String f46902c;

        /* renamed from: d  reason: collision with root package name */
        public String f46903d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.l0.f.i.k.f.a f46904e;

        /* renamed from: f  reason: collision with root package name */
        public String f46905f;

        /* renamed from: g  reason: collision with root package name */
        public String f46906g;

        public C0992c(String str, String str2, d.a.l0.f.i.k.f.a aVar, String str3, String str4) {
            this.f46903d = str;
            this.f46902c = str2;
            this.f46904e = aVar;
            this.f46905f = str3;
            this.f46906g = str4;
        }

        @Override // d.a.l0.a.v1.a.b.c.a
        public long a() {
            return 0L;
        }

        @Override // d.a.l0.a.v1.a.b.c.a
        public boolean c() {
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v1.a.b.c.c, d.a.l0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.l0.a.v1.a.b.a.b bVar) {
            Bundle a2 = bVar.a();
            if (a2 == null) {
                return;
            }
            c.q(a2, this.f46904e, this.f46903d, this.f46902c, this.f46905f, this.f46906g);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f46907a = new c();
    }

    public static String f(String str, Map<String, String> map) {
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!TextUtils.isEmpty(map.get(str2))) {
                    str = d.a.l0.t.i.a(str, str2, map.get(str2));
                }
            }
        }
        return str;
    }

    public static void g(String str, String str2, String str3, String str4, int i2) {
        if (TextUtils.equals(d.a.l0.f.j.m.c.f46874a, str) && TextUtils.equals(str2, "checkPackageExpired")) {
            d.a.l0.f.j.r.b.n().m(str3, str4, i2);
        }
    }

    public static c n() {
        return d.f46907a;
    }

    public static void q(@NonNull Bundle bundle, d.a.l0.f.i.k.f.a aVar, String str, String str2, String str3, String str4) {
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
        j jVar = this.f46892b;
        if (jVar == null) {
            return;
        }
        DownloadState downloadState = jVar.f46933a;
        if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
            String str4 = this.o;
            if (TextUtils.equals(d.a.l0.f.j.m.c.f46874a, this.f46892b.f46935c)) {
                str4 = k(1, str, str2, str3);
                if (!TextUtils.isEmpty(this.q)) {
                    this.f46892b.c(this.q);
                }
            }
            this.f46892b.f46934b = str4;
            this.f46896f = str;
            if (i2 >= 0) {
                this.f46897g = String.valueOf(i2);
            }
        }
        s(false);
    }

    public final void B() {
        j jVar = this.f46892b;
        if (jVar == null) {
            return;
        }
        int i2 = b.f46901a[jVar.f46933a.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.f46891a.j(d.a.l0.a.c1.a.b().getResources().getColor(d.a.l0.f.j.e.aiapps_download_button_blue_color));
            this.f46891a.h(d.a.l0.a.c1.a.b().getResources().getColor(d.a.l0.f.j.e.aiapps_download_button_blue_color));
            this.f46891a.i(d.a.l0.a.c1.a.b().getResources().getColor(d.a.l0.f.j.e.aiapps_download_button_light_blue_color));
        } else if (i2 != 3) {
            this.f46891a.j(d.a.l0.a.c1.a.b().getResources().getColor(d.a.l0.a.c.aiapps_white));
            this.f46891a.h(d.a.l0.a.c1.a.b().getResources().getColor(d.a.l0.f.j.e.aiapps_download_button_blue_color));
            this.f46891a.i(d.a.l0.a.c1.a.b().getResources().getColor(d.a.l0.f.j.e.aiapps_download_button_light_blue_color));
        } else {
            this.f46891a.j(d.a.l0.a.c1.a.b().getResources().getColor(d.a.l0.a.c.aiapps_white));
            this.f46891a.i(d.a.l0.a.c1.a.b().getResources().getColor(d.a.l0.f.j.e.aiapps_download_button_gold_color));
        }
    }

    public final void C(String str) {
        j jVar = this.f46892b;
        if (jVar == null) {
            return;
        }
        jVar.f46935c = str;
    }

    public void D(int i2) {
        y(i2);
    }

    public void E(DownloadState downloadState) {
        z(downloadState);
    }

    public final void F() {
        String string;
        j jVar = this.f46892b;
        if (jVar == null) {
            return;
        }
        if (jVar.f46933a == DownloadState.DOWNLOADING) {
            GamenowDownloadButtomView gamenowDownloadButtomView = this.f46891a;
            if (gamenowDownloadButtomView != null && gamenowDownloadButtomView.getVisibility() != 8) {
                if (this.f46892b.f46936d < this.f46891a.getMax()) {
                    String string2 = d.a.l0.a.c1.a.b().getResources().getString(d.a.l0.f.j.k.aiapps_game_button_downloading);
                    string = String.format(string2, this.f46892b.f46936d + "%");
                } else {
                    string = d.a.l0.a.c1.a.b().getResources().getString(d.a.l0.f.j.k.aiapps_game_download_button_install);
                }
                this.f46891a.setText(string);
                this.f46891a.setProgress(this.f46892b.f46936d);
            }
        } else {
            String string3 = d.a.l0.a.c1.a.b().getResources().getString(v(this.f46892b.f46933a));
            if (this.f46892b.f46933a == DownloadState.DOWNLOADED) {
                this.f46891a.setProgress(100);
            }
            j jVar2 = this.f46892b;
            if (jVar2.f46933a == DownloadState.DOWNLOAD_PAUSED) {
                this.f46891a.setProgress(jVar2.f46936d);
            }
            this.f46891a.setText(string3);
            DownloadState downloadState = this.f46892b.f46933a;
            if ((downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) && !TextUtils.isEmpty(this.f46895e)) {
                this.f46891a.setText(this.f46895e);
            }
        }
        if (this.f46891a != null) {
            B();
            this.f46891a.setState(this.f46892b.f46933a);
            this.f46891a.postInvalidate();
        }
    }

    public final byte[] h(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64Encoder.B64Encode(bArr);
    }

    public GamenowDownloadButtomView i(d.a.l0.f.i.k.f.a aVar, String str, String str2) {
        return j(aVar, str, str2, 0, 0);
    }

    public GamenowDownloadButtomView j(d.a.l0.f.i.k.f.a aVar, String str, String str2, int i2, int i3) {
        this.f46898h = str;
        this.f46899i = str2;
        this.k = i2;
        this.l = i3;
        GameGuideConfigInfo z = d.a.l0.f.j.b.o.z();
        int color = d.a.l0.a.c1.a.b().getResources().getColor(d.a.l0.f.j.e.aiapps_download_button_blue_color);
        int color2 = d.a.l0.a.c1.a.b().getResources().getColor(d.a.l0.f.j.e.swangame_white);
        if (z != null) {
            this.j = z.configName;
            this.o = z.targetAppDownloadUrl;
            String str3 = z.targetAppPackageId;
            this.p = str3;
            if (TextUtils.equals(d.a.l0.f.j.m.c.f46874a, str3)) {
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
                    this.f46895e = dialogInfo.buttonText;
                    this.m = dialogInfo.targetType;
                    this.n = dialogInfo.target;
                }
            } else if (c2 == 1) {
                GameGuideConfigInfo.CloseInfo closeInfo = z.closeInfo;
                this.f46894d = closeInfo;
                if (closeInfo != null) {
                    try {
                        if (!TextUtils.isEmpty(closeInfo.downloadBackgroundColor) && !this.f46894d.downloadBackgroundColor.equals(StringUtil.NULL_STRING)) {
                            color = Color.parseColor(this.f46894d.downloadBackgroundColor);
                        }
                        if (!TextUtils.isEmpty(this.f46894d.downloadTextColor) && !this.f46894d.downloadTextColor.equals(StringUtil.NULL_STRING)) {
                            color2 = Color.parseColor(this.f46894d.downloadTextColor);
                        }
                    } catch (IllegalArgumentException e2) {
                        if (r) {
                            e2.printStackTrace();
                        }
                    }
                    GameGuideConfigInfo.CloseInfo closeInfo2 = this.f46894d;
                    this.f46895e = closeInfo2.buttonText;
                    this.m = closeInfo2.targetType;
                    this.n = closeInfo2.target;
                }
            }
        }
        String str4 = this.o;
        if (TextUtils.equals(d.a.l0.f.j.m.c.f46874a, this.p)) {
            str4 = k(this.m, this.n, "", "");
        }
        this.f46892b = j.a(str4, this.p);
        if (!TextUtils.isEmpty(this.q)) {
            this.f46892b.c(this.q);
        }
        this.f46893c = aVar;
        GamenowDownloadButtomView gamenowDownloadButtomView = new GamenowDownloadButtomView(d.a.l0.a.c1.a.b());
        this.f46891a = gamenowDownloadButtomView;
        gamenowDownloadButtomView.k(n0.g(16.0f));
        gamenowDownloadButtomView.f(true);
        gamenowDownloadButtomView.j(color2);
        gamenowDownloadButtomView.h(color);
        gamenowDownloadButtomView.i(d.a.l0.a.c1.a.b().getResources().getColor(d.a.l0.f.j.e.aiapps_download_button_light_blue_color));
        gamenowDownloadButtomView.g(true);
        this.f46891a.setText(this.f46895e);
        this.f46891a.setVisibility(0);
        this.f46891a.setProgress(s);
        this.f46891a.setState(DownloadState.NOT_START);
        r();
        t();
        return this.f46891a;
    }

    public final String k(int i2, String str, String str2, String str3) {
        String str4 = TextUtils.isEmpty(this.o) ? "https://gamenow.baidu.com/api/download/newest_gamenow" : this.o;
        this.o = str4;
        if (i2 == 0) {
            return str4;
        }
        String i3 = d.a.l0.a.c1.a.a0().i(AppRuntime.getAppContext());
        int J = d.a.l0.f.j.b.o.J();
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(i3)) {
            stringBuffer.append(i3);
        }
        stringBuffer.append(",");
        stringBuffer.append(J);
        if (i2 == 1) {
            if (TextUtils.isEmpty(str) || str.equals(StringUtil.NULL_STRING)) {
                str = d.a.l0.a.a2.d.g().getAppId();
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
        d.a.l0.f.j.b bVar = d.a.l0.f.j.b.o;
        String str5 = (bVar == null || bVar.z() == null || TextUtils.isEmpty(d.a.l0.f.j.b.o.z().gamenowChannel)) ? "2101000000" : d.a.l0.f.j.b.o.z().gamenowChannel;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str6 = new String(h(jSONObject.toString().getBytes()));
        linkedHashMap.put("channel", str5);
        linkedHashMap.put("suffix", str6);
        linkedHashMap.put("filename", "");
        String f2 = f(this.o, linkedHashMap);
        if (!TextUtils.isEmpty(f2)) {
            f2 = d.a.l0.a.c1.a.n().m(f2);
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
        return this.f46896f;
    }

    public String m() {
        return this.f46897g;
    }

    public String o() {
        return this.f46892b.f46934b;
    }

    public final void p(String str, d.a.l0.f.i.k.f.a aVar) {
        if (this.f46892b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("key_download_package_name", this.f46892b.f46935c);
            jSONObject.put("key_download_url", this.f46892b.f46934b);
            jSONObject2.put("from_view", this.f46898h);
            jSONObject2.put("from_value", this.f46899i);
            jSONObject2.put(GameGuideConfigInfo.KEY_CONFIG_NAME, this.j);
            jSONObject2.put("apk_id", this.f46892b.b());
            jSONObject.put("download_params", jSONObject2.toString());
            if (TextUtils.equals(str, "checkPackageExpired")) {
                jSONObject.put(GameGuideConfigInfo.KEY_PACKAGE_EXPIRE, d.a.l0.f.j.b.o.z() == null ? 0L : d.a.l0.f.j.b.o.z().packageExpire);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Bundle bundle = new Bundle();
        bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, str);
        bundle.putString("ubc_params", new d.a.l0.f.j.r.a().a());
        bundle.putString("data", jSONObject.toString());
        d.a.l0.a.v1.c.e.a z = d.a.l0.a.a2.d.g().z();
        if (z != null) {
            z.L(bundle, f.class, new C0992c(this.f46892b.f46935c, str, aVar, this.f46898h, this.f46899i));
        }
    }

    public final void r() {
        this.f46891a.setOnClickListener(new a());
    }

    public void s(boolean z) {
        if (!SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
            Toast.makeText(d.a.l0.a.c1.a.b(), d.a.l0.a.c1.a.b().getResources().getString(d.a.l0.f.j.k.aiapps_gamenow_network_disconnect), 0).show();
            return;
        }
        j jVar = this.f46892b;
        if (jVar == null) {
            return;
        }
        DownloadState downloadState = jVar.f46933a;
        if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
            if (r) {
                Log.d("DownloadButtonManager", "download start");
            }
            p("startDownload", this.f46893c);
        }
        if (this.f46892b.f46933a == DownloadState.DOWNLOADING && z) {
            if (r) {
                Log.d("DownloadButtonManager", "download pause");
            }
            p("pauseDownload", this.f46893c);
        }
        if (this.f46892b.f46933a == DownloadState.DOWNLOAD_PAUSED) {
            if (r) {
                Log.d("DownloadButtonManager", "download resume");
            }
            p("resumeDownload", this.f46893c);
        }
        if (this.f46892b.f46933a == DownloadState.DOWNLOAD_FAILED) {
            if (r) {
                Log.d("DownloadButtonManager", "download retry");
            }
            p("startDownload", this.f46893c);
        }
        if (this.f46892b.f46933a == DownloadState.DOWNLOADED) {
            if (r) {
                Log.d("DownloadButtonManager", "download install");
            }
            this.f46893c.b();
            p("installApp", this.f46893c);
        }
        if (this.f46892b.f46933a == DownloadState.INSTALLED) {
            if (r) {
                Log.d("DownloadButtonManager", "open app");
            }
            String e2 = this.f46893c.e();
            if (TextUtils.isEmpty(this.f46892b.f46935c) && !TextUtils.isEmpty(e2)) {
                C(e2);
            }
            p("open_manual", this.f46893c);
        }
    }

    public final void t() {
        if (this.f46892b == null) {
            return;
        }
        if (q0.F(d.a.l0.a.c1.a.b(), this.f46892b.f46935c)) {
            E(DownloadState.INSTALLED);
            g(this.p, "checkPackageExpired", this.f46898h, this.f46899i, DownloadState.INSTALLED.value());
            return;
        }
        p("checkPackageExpired", this.f46893c);
    }

    public void u() {
        this.f46893c = null;
        this.f46891a = null;
        this.f46892b = null;
    }

    public final int v(DownloadState downloadState) {
        switch (b.f46901a[downloadState.ordinal()]) {
            case 1:
                return d.a.l0.f.j.k.aiapps_game_download_button_pause;
            case 2:
                return d.a.l0.f.j.k.aiapps_game_download_button_continue;
            case 3:
                return d.a.l0.f.j.k.aiapps_game_download_button_install;
            case 4:
                return d.a.l0.f.j.k.aiapps_game_download_button;
            case 5:
                return d.a.l0.f.j.k.aiapps_game_download_button_failed_retry;
            case 6:
                return d.a.l0.f.j.k.aiapps_game_download_button_open;
            default:
                return d.a.l0.f.j.k.aiapps_game_download_button;
        }
    }

    public void w(String str) {
        this.f46896f = str;
    }

    public void x(String str) {
        this.f46897g = str;
    }

    public final void y(int i2) {
        j jVar = this.f46892b;
        if (jVar == null || i2 == jVar.f46936d) {
            return;
        }
        jVar.f46936d = i2;
        F();
    }

    public final void z(DownloadState downloadState) {
        j jVar = this.f46892b;
        if (jVar == null || downloadState == jVar.f46933a) {
            return;
        }
        jVar.f46933a = downloadState;
        F();
    }
}
