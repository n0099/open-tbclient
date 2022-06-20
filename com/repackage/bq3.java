package com.repackage;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.download.GamenowDownloadButtomView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bq3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public static int s;
    public transient /* synthetic */ FieldHolder $fh;
    public GamenowDownloadButtomView a;
    public iq3 b;
    public sn3 c;
    public GameGuideConfigInfo.CloseInfo d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;
    public int l;
    public int m;
    public String n;
    public String o;
    public String p;
    public String q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bq3 a;

        public a(bq3 bq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bq3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!this.a.h.equals("wdview")) {
                    if (this.a.h.equals("gbview") && this.a.d != null) {
                        if (this.a.d.type != 0 && this.a.d.type != 1) {
                            if (this.a.d.type == 2) {
                                nq3.n().b("gbADialogClick", "0", "", "");
                            }
                        } else {
                            nq3.n().b("gbBDialogClick", "0", "", "");
                        }
                    }
                } else {
                    nq3.n().j("0", this.a.k, this.a.l);
                }
                this.a.s(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-492015889, "Lcom/repackage/bq3$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-492015889, "Lcom/repackage/bq3$b;");
                    return;
                }
            }
            int[] iArr = new int[DownloadState.values().length];
            a = iArr;
            try {
                iArr[DownloadState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DownloadState.DOWNLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[DownloadState.NOT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[DownloadState.DOWNLOAD_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[DownloadState.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends zv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String c;
        public String d;
        public sn3 e;
        public String f;
        public String g;

        public c(String str, String str2, sn3 sn3Var, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, sn3Var, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = str;
            this.c = str2;
            this.e = sn3Var;
            this.f = str3;
            this.g = str4;
        }

        @Override // com.repackage.xv2
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // com.repackage.xv2
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.zv2, com.repackage.xv2
        public void onEvent(@NonNull vv2 vv2Var) {
            Bundle a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vv2Var) == null) || (a = vv2Var.a()) == null) {
                return;
            }
            bq3.q(a, this.e, this.d, this.c, this.f, this.g);
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final bq3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-492015827, "Lcom/repackage/bq3$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-492015827, "Lcom/repackage/bq3$d;");
                    return;
                }
            }
            a = new bq3();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755818387, "Lcom/repackage/bq3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755818387, "Lcom/repackage/bq3;");
                return;
            }
        }
        r = cg1.a;
        s = 0;
    }

    public bq3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = "";
        this.f = "";
        this.g = "";
        this.j = "";
        this.n = "";
        this.o = "";
        this.p = "";
    }

    public static String f(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, map)) == null) {
            if (map != null) {
                for (String str2 : map.keySet()) {
                    if (!TextUtils.isEmpty(map.get(str2))) {
                        str = zf4.a(str, str2, map.get(str2));
                    }
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static void g(String str, String str2, String str3, String str4, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i)}) == null) && TextUtils.equals(vp3.a, str) && TextUtils.equals(str2, "checkPackageExpired")) {
            nq3.n().m(str3, str4, i);
        }
    }

    public static bq3 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? d.a : (bq3) invokeV.objValue;
    }

    public static void q(@NonNull Bundle bundle, sn3 sn3Var, String str, String str2, String str3, String str4) {
        String string;
        char c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{bundle, sn3Var, str, str2, str3, str4}) == null) || (string = bundle.getString("functionType")) == null || sn3Var == null) {
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
            if (!TextUtils.isEmpty(string2) && string2.equals(DownloadState.NOT_START.name())) {
                sn3Var.c(DownloadState.NOT_START, 0);
            }
            g(str, str2, str3, str4, 0);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string2);
            int optInt = jSONObject.optInt("progress", -1);
            if (optInt > -1) {
                sn3Var.a(optInt);
            }
            if (jSONObject.optBoolean("installed")) {
                sn3Var.c(DownloadState.INSTALLED, optInt);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return;
            }
            int optInt2 = optJSONObject.optInt("status", 0);
            int value = DownloadState.NOT_START.value();
            if (optInt2 == 0) {
                sn3Var.c(DownloadState.DOWNLOADING, optInt);
                value = DownloadState.DOWNLOADING.value();
            } else if (optInt2 == 1) {
                sn3Var.c(DownloadState.DOWNLOADING, optInt);
                value = DownloadState.DOWNLOADING.value();
            } else if (optInt2 == 2) {
                sn3Var.c(DownloadState.DOWNLOAD_PAUSED, optInt);
                value = DownloadState.DOWNLOAD_PAUSED.value();
            } else if (optInt2 == 3) {
                sn3Var.c(DownloadState.DOWNLOAD_FAILED, optInt);
                value = DownloadState.DOWNLOAD_FAILED.value();
            } else if (optInt2 == 4) {
                sn3Var.c(DownloadState.DELETED, optInt);
                value = DownloadState.DELETED.value();
            } else if (optInt2 == 5) {
                sn3Var.c(DownloadState.DOWNLOADED, optInt);
                value = DownloadState.DOWNLOADED.value();
            }
            g(str, str2, str3, str4, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void A(String str, String str2, String str3, int i) {
        iq3 iq3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048576, this, str, str2, str3, i) == null) || (iq3Var = this.b) == null) {
            return;
        }
        DownloadState downloadState = iq3Var.a;
        if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
            String str4 = this.o;
            if (TextUtils.equals(vp3.a, this.b.c)) {
                str4 = k(1, str, str2, str3);
                if (!TextUtils.isEmpty(this.q)) {
                    this.b.c(this.q);
                }
            }
            this.b.b = str4;
            this.f = str;
            if (i >= 0) {
                this.g = String.valueOf(i);
            }
        }
        s(false);
    }

    public final void B() {
        iq3 iq3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (iq3Var = this.b) == null) {
            return;
        }
        int i = b.a[iq3Var.a.ordinal()];
        if (i == 1 || i == 2) {
            this.a.j(zi2.c().getResources().getColor(R.color.obfuscated_res_0x7f060395));
            this.a.h(zi2.c().getResources().getColor(R.color.obfuscated_res_0x7f060395));
            this.a.i(zi2.c().getResources().getColor(R.color.obfuscated_res_0x7f060399));
        } else if (i != 3) {
            this.a.j(-1);
            this.a.h(zi2.c().getResources().getColor(R.color.obfuscated_res_0x7f060395));
            this.a.i(zi2.c().getResources().getColor(R.color.obfuscated_res_0x7f060399));
        } else {
            this.a.j(-1);
            this.a.i(zi2.c().getResources().getColor(R.color.obfuscated_res_0x7f060398));
        }
    }

    public final void C(String str) {
        iq3 iq3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (iq3Var = this.b) == null) {
            return;
        }
        iq3Var.c = str;
    }

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            y(i);
        }
    }

    public void E(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadState) == null) {
            z(downloadState);
        }
    }

    public final void F() {
        iq3 iq3Var;
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (iq3Var = this.b) == null) {
            return;
        }
        if (iq3Var.a == DownloadState.DOWNLOADING) {
            GamenowDownloadButtomView gamenowDownloadButtomView = this.a;
            if (gamenowDownloadButtomView != null && gamenowDownloadButtomView.getVisibility() != 8) {
                if (this.b.d < this.a.getMax()) {
                    String string2 = zi2.c().getResources().getString(R.string.obfuscated_res_0x7f0f015c);
                    string = String.format(string2, this.b.d + "%");
                } else {
                    string = zi2.c().getResources().getString(R.string.obfuscated_res_0x7f0f0166);
                }
                this.a.setText(string);
                this.a.setProgress(this.b.d);
            }
        } else {
            String string3 = zi2.c().getResources().getString(v(this.b.a));
            if (this.b.a == DownloadState.DOWNLOADED) {
                this.a.setProgress(100);
            }
            iq3 iq3Var2 = this.b;
            if (iq3Var2.a == DownloadState.DOWNLOAD_PAUSED) {
                this.a.setProgress(iq3Var2.d);
            }
            this.a.setText(string3);
            DownloadState downloadState = this.b.a;
            if ((downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) && !TextUtils.isEmpty(this.e)) {
                this.a.setText(this.e);
            }
        }
        if (this.a != null) {
            B();
            this.a.setState(this.b.a);
            this.a.postInvalidate();
        }
    }

    public final byte[] h(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            return Base64Encoder.B64Encode(bArr);
        }
        return (byte[]) invokeL.objValue;
    }

    public GamenowDownloadButtomView i(sn3 sn3Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, sn3Var, str, str2)) == null) ? j(sn3Var, str, str2, 0, 0) : (GamenowDownloadButtomView) invokeLLL.objValue;
    }

    public GamenowDownloadButtomView j(sn3 sn3Var, String str, String str2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{sn3Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            this.h = str;
            this.i = str2;
            this.k = i;
            this.l = i2;
            GameGuideConfigInfo z = qp3.o.z();
            int color = zi2.c().getResources().getColor(R.color.obfuscated_res_0x7f060395);
            int color2 = zi2.c().getResources().getColor(R.color.obfuscated_res_0x7f060ab7);
            if (z != null) {
                this.j = z.configName;
                this.o = z.targetAppDownloadUrl;
                String str3 = z.targetAppPackageId;
                this.p = str3;
                if (TextUtils.equals(vp3.a, str3)) {
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
                        this.e = dialogInfo.buttonText;
                        this.m = dialogInfo.targetType;
                        this.n = dialogInfo.target;
                    }
                } else if (c2 == 1) {
                    GameGuideConfigInfo.CloseInfo closeInfo = z.closeInfo;
                    this.d = closeInfo;
                    if (closeInfo != null) {
                        try {
                            if (!TextUtils.isEmpty(closeInfo.downloadBackgroundColor) && !this.d.downloadBackgroundColor.equals(StringUtil.NULL_STRING)) {
                                color = Color.parseColor(this.d.downloadBackgroundColor);
                            }
                            if (!TextUtils.isEmpty(this.d.downloadTextColor) && !this.d.downloadTextColor.equals(StringUtil.NULL_STRING)) {
                                color2 = Color.parseColor(this.d.downloadTextColor);
                            }
                        } catch (IllegalArgumentException e) {
                            if (r) {
                                e.printStackTrace();
                            }
                        }
                        GameGuideConfigInfo.CloseInfo closeInfo2 = this.d;
                        this.e = closeInfo2.buttonText;
                        this.m = closeInfo2.targetType;
                        this.n = closeInfo2.target;
                    }
                }
            }
            String str4 = this.o;
            if (TextUtils.equals(vp3.a, this.p)) {
                str4 = k(this.m, this.n, "", "");
            }
            this.b = iq3.a(str4, this.p);
            if (!TextUtils.isEmpty(this.q)) {
                this.b.c(this.q);
            }
            this.c = sn3Var;
            GamenowDownloadButtomView gamenowDownloadButtomView = new GamenowDownloadButtomView(zi2.c());
            this.a = gamenowDownloadButtomView;
            gamenowDownloadButtomView.k(jd3.g(16.0f));
            gamenowDownloadButtomView.f(true);
            gamenowDownloadButtomView.j(color2);
            gamenowDownloadButtomView.h(color);
            gamenowDownloadButtomView.i(zi2.c().getResources().getColor(R.color.obfuscated_res_0x7f060399));
            gamenowDownloadButtomView.g(true);
            this.a.setText(this.e);
            this.a.setVisibility(0);
            this.a.setProgress(s);
            this.a.setState(DownloadState.NOT_START);
            r();
            t();
            return this.a;
        }
        return (GamenowDownloadButtomView) invokeCommon.objValue;
    }

    public final String k(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            String str4 = TextUtils.isEmpty(this.o) ? "https://gamenow.baidu.com/api/download/newest_gamenow" : this.o;
            this.o = str4;
            if (i == 0) {
                return str4;
            }
            String i2 = zi2.h0().i(AppRuntime.getAppContext());
            int J = qp3.o.J();
            StringBuffer stringBuffer = new StringBuffer();
            if (!TextUtils.isEmpty(i2)) {
                stringBuffer.append(i2);
            }
            stringBuffer.append(",");
            stringBuffer.append(J);
            if (i == 1) {
                if (TextUtils.isEmpty(str) || str.equals(StringUtil.NULL_STRING)) {
                    str = rz2.K().getAppId();
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
            str = (i != 2 || TextUtils.isEmpty(str)) ? "" : "";
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ext", new String(h(stringBuffer.toString().getBytes())));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT, str);
                }
                jSONObject.put("path", "operate");
                jSONObject.put("data", jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            qp3 qp3Var = qp3.o;
            String str5 = (qp3Var == null || qp3Var.z() == null || TextUtils.isEmpty(qp3.o.z().gamenowChannel)) ? "2101000000" : qp3.o.z().gamenowChannel;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str6 = new String(h(jSONObject.toString().getBytes()));
            linkedHashMap.put("channel", str5);
            linkedHashMap.put("suffix", str6);
            linkedHashMap.put(BreakpointSQLiteKey.FILENAME, "");
            String f = f(this.o, linkedHashMap);
            if (!TextUtils.isEmpty(f)) {
                f = zi2.o().m(f);
            }
            if (r) {
                Log.e("DownloadButtonManager", "channel is " + str5);
                Log.e("DownloadButtonManager", "ext is " + stringBuffer.toString());
                Log.e("DownloadButtonManager", "suffixObj is " + jSONObject.toString());
                Log.e("DownloadButtonManager", "downloadUrl is " + f);
            }
            return f;
        }
        return (String) invokeCommon.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.b.b : (String) invokeV.objValue;
    }

    public final void p(String str, sn3 sn3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, sn3Var) == null) || this.b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("key_download_package_name", this.b.c);
            jSONObject.put("key_download_url", this.b.b);
            jSONObject2.put("from_view", this.h);
            jSONObject2.put("from_value", this.i);
            jSONObject2.put(GameGuideConfigInfo.KEY_CONFIG_NAME, this.j);
            jSONObject2.put("apk_id", this.b.b());
            jSONObject.put("download_params", jSONObject2.toString());
            if (TextUtils.equals(str, "checkPackageExpired")) {
                jSONObject.put(GameGuideConfigInfo.KEY_PACKAGE_EXPIRE, qp3.o.z() == null ? 0L : qp3.o.z().packageExpire);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bundle bundle = new Bundle();
        bundle.putString("operation", str);
        bundle.putString("ubc_params", new mq3().a());
        bundle.putString("data", jSONObject.toString());
        nw2 z = rz2.K().z();
        if (z != null) {
            z.X(bundle, eq3.class, new c(this.b.c, str, sn3Var, this.h, this.i));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a.setOnClickListener(new a(this));
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (!SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
                Toast.makeText(zi2.c(), zi2.c().getResources().getString(R.string.obfuscated_res_0x7f0f0184), 0).show();
                return;
            }
            iq3 iq3Var = this.b;
            if (iq3Var == null) {
                return;
            }
            DownloadState downloadState = iq3Var.a;
            if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download start");
                }
                p("startDownload", this.c);
            }
            if (this.b.a == DownloadState.DOWNLOADING && z) {
                if (r) {
                    Log.d("DownloadButtonManager", "download pause");
                }
                p("pauseDownload", this.c);
            }
            if (this.b.a == DownloadState.DOWNLOAD_PAUSED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download resume");
                }
                p("resumeDownload", this.c);
            }
            if (this.b.a == DownloadState.DOWNLOAD_FAILED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download retry");
                }
                p("startDownload", this.c);
            }
            if (this.b.a == DownloadState.DOWNLOADED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download install");
                }
                this.c.b();
                p("installApp", this.c);
            }
            if (this.b.a == DownloadState.INSTALLED) {
                if (r) {
                    Log.d("DownloadButtonManager", "open app");
                }
                String e = this.c.e();
                if (TextUtils.isEmpty(this.b.c) && !TextUtils.isEmpty(e)) {
                    C(e);
                }
                p("open_manual", this.c);
            }
        }
    }

    public void t() {
        iq3 iq3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (iq3Var = this.b) == null || TextUtils.isEmpty(iq3Var.c) || TextUtils.isEmpty(this.p) || this.c == null) {
            return;
        }
        if (md3.F(zi2.c(), this.b.c)) {
            E(DownloadState.INSTALLED);
            g(this.p, "checkPackageExpired", this.h, this.i, DownloadState.INSTALLED.value());
            return;
        }
        p("checkPackageExpired", this.c);
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c = null;
            this.a = null;
            this.b = null;
        }
    }

    public final int v(DownloadState downloadState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, downloadState)) == null) {
            switch (b.a[downloadState.ordinal()]) {
                case 1:
                    return R.string.obfuscated_res_0x7f0f0168;
                case 2:
                    return R.string.obfuscated_res_0x7f0f0164;
                case 3:
                    return R.string.obfuscated_res_0x7f0f0166;
                case 4:
                default:
                    return R.string.obfuscated_res_0x7f0f0163;
                case 5:
                    return R.string.obfuscated_res_0x7f0f0165;
                case 6:
                    return R.string.obfuscated_res_0x7f0f0167;
            }
        }
        return invokeL.intValue;
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f = str;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.g = str;
        }
    }

    public final void y(int i) {
        iq3 iq3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i) == null) || (iq3Var = this.b) == null || i == iq3Var.d) {
            return;
        }
        iq3Var.d = i;
        F();
    }

    public final void z(DownloadState downloadState) {
        iq3 iq3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, downloadState) == null) || (iq3Var = this.b) == null || downloadState == iq3Var.a) {
            return;
        }
        iq3Var.a = downloadState;
        F();
    }
}
