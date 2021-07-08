package d.a.n0.f.j.n;

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
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.download.GamenowDownloadButtomView;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import d.a.n0.a.k;
import d.a.n0.a.v2.n0;
import d.a.n0.a.v2.q0;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public static int s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public GamenowDownloadButtomView f49517a;

    /* renamed from: b  reason: collision with root package name */
    public j f49518b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.f.i.k.f.a f49519c;

    /* renamed from: d  reason: collision with root package name */
    public GameGuideConfigInfo.CloseInfo f49520d;

    /* renamed from: e  reason: collision with root package name */
    public String f49521e;

    /* renamed from: f  reason: collision with root package name */
    public String f49522f;

    /* renamed from: g  reason: collision with root package name */
    public String f49523g;

    /* renamed from: h  reason: collision with root package name */
    public String f49524h;

    /* renamed from: i  reason: collision with root package name */
    public String f49525i;
    public String j;
    public int k;
    public int l;
    public int m;
    public String n;
    public String o;
    public String p;
    public String q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f49526e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49526e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f49526e.f49524h.equals("wdview")) {
                    if (this.f49526e.f49524h.equals("gbview") && this.f49526e.f49520d != null) {
                        if (this.f49526e.f49520d.type != 0 && this.f49526e.f49520d.type != 1) {
                            if (this.f49526e.f49520d.type == 2) {
                                d.a.n0.f.j.r.b.n().b("gbADialogClick", "0", "", "");
                            }
                        } else {
                            d.a.n0.f.j.r.b.n().b("gbBDialogClick", "0", "", "");
                        }
                    }
                } else {
                    d.a.n0.f.j.r.b.n().j("0", this.f49526e.k, this.f49526e.l);
                }
                this.f49526e.s(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f49527a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(347299025, "Ld/a/n0/f/j/n/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(347299025, "Ld/a/n0/f/j/n/c$b;");
                    return;
                }
            }
            int[] iArr = new int[DownloadState.values().length];
            f49527a = iArr;
            try {
                iArr[DownloadState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f49527a[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f49527a[DownloadState.DOWNLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f49527a[DownloadState.NOT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f49527a[DownloadState.DOWNLOAD_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f49527a[DownloadState.INSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: d.a.n0.f.j.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1060c extends d.a.n0.a.v1.a.b.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public String f49528c;

        /* renamed from: d  reason: collision with root package name */
        public String f49529d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.n0.f.i.k.f.a f49530e;

        /* renamed from: f  reason: collision with root package name */
        public String f49531f;

        /* renamed from: g  reason: collision with root package name */
        public String f49532g;

        public C1060c(String str, String str2, d.a.n0.f.i.k.f.a aVar, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, aVar, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49529d = str;
            this.f49528c = str2;
            this.f49530e = aVar;
            this.f49531f = str3;
            this.f49532g = str4;
        }

        @Override // d.a.n0.a.v1.a.b.c.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // d.a.n0.a.v1.a.b.c.a
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v1.a.b.c.c, d.a.n0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.n0.a.v1.a.b.a.b bVar) {
            Bundle a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (a2 = bVar.a()) == null) {
                return;
            }
            c.q(a2, this.f49530e, this.f49529d, this.f49528c, this.f49531f, this.f49532g);
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f49533a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(347299087, "Ld/a/n0/f/j/n/c$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(347299087, "Ld/a/n0/f/j/n/c$d;");
                    return;
                }
            }
            f49533a = new c();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(608181967, "Ld/a/n0/f/j/n/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(608181967, "Ld/a/n0/f/j/n/c;");
                return;
            }
        }
        r = k.f45831a;
        s = 0;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49521e = "";
        this.f49522f = "";
        this.f49523g = "";
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
                        str = d.a.n0.t.i.a(str, str2, map.get(str2));
                    }
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static void g(String str, String str2, String str3, String str4, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, str2, str3, str4, Integer.valueOf(i2)}) == null) && TextUtils.equals(d.a.n0.f.j.m.c.f49500a, str) && TextUtils.equals(str2, "checkPackageExpired")) {
            d.a.n0.f.j.r.b.n().m(str3, str4, i2);
        }
    }

    public static c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? d.f49533a : (c) invokeV.objValue;
    }

    public static void q(@NonNull Bundle bundle, d.a.n0.f.i.k.f.a aVar, String str, String str2, String str3, String str4) {
        String string;
        char c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{bundle, aVar, str, str2, str3, str4}) == null) || (string = bundle.getString("functionType")) == null || aVar == null) {
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
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048576, this, str, str2, str3, i2) == null) || (jVar = this.f49518b) == null) {
            return;
        }
        DownloadState downloadState = jVar.f49559a;
        if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
            String str4 = this.o;
            if (TextUtils.equals(d.a.n0.f.j.m.c.f49500a, this.f49518b.f49561c)) {
                str4 = k(1, str, str2, str3);
                if (!TextUtils.isEmpty(this.q)) {
                    this.f49518b.c(this.q);
                }
            }
            this.f49518b.f49560b = str4;
            this.f49522f = str;
            if (i2 >= 0) {
                this.f49523g = String.valueOf(i2);
            }
        }
        s(false);
    }

    public final void B() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (jVar = this.f49518b) == null) {
            return;
        }
        int i2 = b.f49527a[jVar.f49559a.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.f49517a.j(d.a.n0.a.c1.a.b().getResources().getColor(d.a.n0.f.j.e.aiapps_download_button_blue_color));
            this.f49517a.h(d.a.n0.a.c1.a.b().getResources().getColor(d.a.n0.f.j.e.aiapps_download_button_blue_color));
            this.f49517a.i(d.a.n0.a.c1.a.b().getResources().getColor(d.a.n0.f.j.e.aiapps_download_button_light_blue_color));
        } else if (i2 != 3) {
            this.f49517a.j(d.a.n0.a.c1.a.b().getResources().getColor(d.a.n0.a.c.aiapps_white));
            this.f49517a.h(d.a.n0.a.c1.a.b().getResources().getColor(d.a.n0.f.j.e.aiapps_download_button_blue_color));
            this.f49517a.i(d.a.n0.a.c1.a.b().getResources().getColor(d.a.n0.f.j.e.aiapps_download_button_light_blue_color));
        } else {
            this.f49517a.j(d.a.n0.a.c1.a.b().getResources().getColor(d.a.n0.a.c.aiapps_white));
            this.f49517a.i(d.a.n0.a.c1.a.b().getResources().getColor(d.a.n0.f.j.e.aiapps_download_button_gold_color));
        }
    }

    public final void C(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (jVar = this.f49518b) == null) {
            return;
        }
        jVar.f49561c = str;
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            y(i2);
        }
    }

    public void E(DownloadState downloadState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadState) == null) {
            z(downloadState);
        }
    }

    public final void F() {
        j jVar;
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (jVar = this.f49518b) == null) {
            return;
        }
        if (jVar.f49559a == DownloadState.DOWNLOADING) {
            GamenowDownloadButtomView gamenowDownloadButtomView = this.f49517a;
            if (gamenowDownloadButtomView != null && gamenowDownloadButtomView.getVisibility() != 8) {
                if (this.f49518b.f49562d < this.f49517a.getMax()) {
                    String string2 = d.a.n0.a.c1.a.b().getResources().getString(d.a.n0.f.j.k.aiapps_game_button_downloading);
                    string = String.format(string2, this.f49518b.f49562d + "%");
                } else {
                    string = d.a.n0.a.c1.a.b().getResources().getString(d.a.n0.f.j.k.aiapps_game_download_button_install);
                }
                this.f49517a.setText(string);
                this.f49517a.setProgress(this.f49518b.f49562d);
            }
        } else {
            String string3 = d.a.n0.a.c1.a.b().getResources().getString(v(this.f49518b.f49559a));
            if (this.f49518b.f49559a == DownloadState.DOWNLOADED) {
                this.f49517a.setProgress(100);
            }
            j jVar2 = this.f49518b;
            if (jVar2.f49559a == DownloadState.DOWNLOAD_PAUSED) {
                this.f49517a.setProgress(jVar2.f49562d);
            }
            this.f49517a.setText(string3);
            DownloadState downloadState = this.f49518b.f49559a;
            if ((downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) && !TextUtils.isEmpty(this.f49521e)) {
                this.f49517a.setText(this.f49521e);
            }
        }
        if (this.f49517a != null) {
            B();
            this.f49517a.setState(this.f49518b.f49559a);
            this.f49517a.postInvalidate();
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

    public GamenowDownloadButtomView i(d.a.n0.f.i.k.f.a aVar, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, aVar, str, str2)) == null) ? j(aVar, str, str2, 0, 0) : (GamenowDownloadButtomView) invokeLLL.objValue;
    }

    public GamenowDownloadButtomView j(d.a.n0.f.i.k.f.a aVar, String str, String str2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{aVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            this.f49524h = str;
            this.f49525i = str2;
            this.k = i2;
            this.l = i3;
            GameGuideConfigInfo z = d.a.n0.f.j.b.o.z();
            int color = d.a.n0.a.c1.a.b().getResources().getColor(d.a.n0.f.j.e.aiapps_download_button_blue_color);
            int color2 = d.a.n0.a.c1.a.b().getResources().getColor(d.a.n0.f.j.e.swangame_white);
            if (z != null) {
                this.j = z.configName;
                this.o = z.targetAppDownloadUrl;
                String str3 = z.targetAppPackageId;
                this.p = str3;
                if (TextUtils.equals(d.a.n0.f.j.m.c.f49500a, str3)) {
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
                        this.f49521e = dialogInfo.buttonText;
                        this.m = dialogInfo.targetType;
                        this.n = dialogInfo.target;
                    }
                } else if (c2 == 1) {
                    GameGuideConfigInfo.CloseInfo closeInfo = z.closeInfo;
                    this.f49520d = closeInfo;
                    if (closeInfo != null) {
                        try {
                            if (!TextUtils.isEmpty(closeInfo.downloadBackgroundColor) && !this.f49520d.downloadBackgroundColor.equals(StringUtil.NULL_STRING)) {
                                color = Color.parseColor(this.f49520d.downloadBackgroundColor);
                            }
                            if (!TextUtils.isEmpty(this.f49520d.downloadTextColor) && !this.f49520d.downloadTextColor.equals(StringUtil.NULL_STRING)) {
                                color2 = Color.parseColor(this.f49520d.downloadTextColor);
                            }
                        } catch (IllegalArgumentException e2) {
                            if (r) {
                                e2.printStackTrace();
                            }
                        }
                        GameGuideConfigInfo.CloseInfo closeInfo2 = this.f49520d;
                        this.f49521e = closeInfo2.buttonText;
                        this.m = closeInfo2.targetType;
                        this.n = closeInfo2.target;
                    }
                }
            }
            String str4 = this.o;
            if (TextUtils.equals(d.a.n0.f.j.m.c.f49500a, this.p)) {
                str4 = k(this.m, this.n, "", "");
            }
            this.f49518b = j.a(str4, this.p);
            if (!TextUtils.isEmpty(this.q)) {
                this.f49518b.c(this.q);
            }
            this.f49519c = aVar;
            GamenowDownloadButtomView gamenowDownloadButtomView = new GamenowDownloadButtomView(d.a.n0.a.c1.a.b());
            this.f49517a = gamenowDownloadButtomView;
            gamenowDownloadButtomView.k(n0.g(16.0f));
            gamenowDownloadButtomView.f(true);
            gamenowDownloadButtomView.j(color2);
            gamenowDownloadButtomView.h(color);
            gamenowDownloadButtomView.i(d.a.n0.a.c1.a.b().getResources().getColor(d.a.n0.f.j.e.aiapps_download_button_light_blue_color));
            gamenowDownloadButtomView.g(true);
            this.f49517a.setText(this.f49521e);
            this.f49517a.setVisibility(0);
            this.f49517a.setProgress(s);
            this.f49517a.setState(DownloadState.NOT_START);
            r();
            t();
            return this.f49517a;
        }
        return (GamenowDownloadButtomView) invokeCommon.objValue;
    }

    public final String k(int i2, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), str, str2, str3})) == null) {
            String str4 = TextUtils.isEmpty(this.o) ? "https://gamenow.baidu.com/api/download/newest_gamenow" : this.o;
            this.o = str4;
            if (i2 == 0) {
                return str4;
            }
            String i3 = d.a.n0.a.c1.a.a0().i(AppRuntime.getAppContext());
            int J = d.a.n0.f.j.b.o.J();
            StringBuffer stringBuffer = new StringBuffer();
            if (!TextUtils.isEmpty(i3)) {
                stringBuffer.append(i3);
            }
            stringBuffer.append(",");
            stringBuffer.append(J);
            if (i2 == 1) {
                if (TextUtils.isEmpty(str) || str.equals(StringUtil.NULL_STRING)) {
                    str = d.a.n0.a.a2.d.g().getAppId();
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
            d.a.n0.f.j.b bVar = d.a.n0.f.j.b.o;
            String str5 = (bVar == null || bVar.z() == null || TextUtils.isEmpty(d.a.n0.f.j.b.o.z().gamenowChannel)) ? "2101000000" : d.a.n0.f.j.b.o.z().gamenowChannel;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str6 = new String(h(jSONObject.toString().getBytes()));
            linkedHashMap.put("channel", str5);
            linkedHashMap.put("suffix", str6);
            linkedHashMap.put("filename", "");
            String f2 = f(this.o, linkedHashMap);
            if (!TextUtils.isEmpty(f2)) {
                f2 = d.a.n0.a.c1.a.n().m(f2);
            }
            if (r) {
                Log.e("DownloadButtonManager", "channel is " + str5);
                Log.e("DownloadButtonManager", "ext is " + stringBuffer.toString());
                Log.e("DownloadButtonManager", "suffixObj is " + jSONObject.toString());
                Log.e("DownloadButtonManager", "downloadUrl is " + f2);
            }
            return f2;
        }
        return (String) invokeCommon.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f49522f : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f49523g : (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f49518b.f49560b : (String) invokeV.objValue;
    }

    public final void p(String str, d.a.n0.f.i.k.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, aVar) == null) || this.f49518b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("key_download_package_name", this.f49518b.f49561c);
            jSONObject.put("key_download_url", this.f49518b.f49560b);
            jSONObject2.put("from_view", this.f49524h);
            jSONObject2.put("from_value", this.f49525i);
            jSONObject2.put(GameGuideConfigInfo.KEY_CONFIG_NAME, this.j);
            jSONObject2.put("apk_id", this.f49518b.b());
            jSONObject.put("download_params", jSONObject2.toString());
            if (TextUtils.equals(str, "checkPackageExpired")) {
                jSONObject.put(GameGuideConfigInfo.KEY_PACKAGE_EXPIRE, d.a.n0.f.j.b.o.z() == null ? 0L : d.a.n0.f.j.b.o.z().packageExpire);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Bundle bundle = new Bundle();
        bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, str);
        bundle.putString("ubc_params", new d.a.n0.f.j.r.a().a());
        bundle.putString("data", jSONObject.toString());
        d.a.n0.a.v1.c.e.a z = d.a.n0.a.a2.d.g().z();
        if (z != null) {
            z.L(bundle, f.class, new C1060c(this.f49518b.f49561c, str, aVar, this.f49524h, this.f49525i));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f49517a.setOnClickListener(new a(this));
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (!SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
                Toast.makeText(d.a.n0.a.c1.a.b(), d.a.n0.a.c1.a.b().getResources().getString(d.a.n0.f.j.k.aiapps_gamenow_network_disconnect), 0).show();
                return;
            }
            j jVar = this.f49518b;
            if (jVar == null) {
                return;
            }
            DownloadState downloadState = jVar.f49559a;
            if (downloadState == DownloadState.NOT_START || downloadState == DownloadState.DELETED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download start");
                }
                p("startDownload", this.f49519c);
            }
            if (this.f49518b.f49559a == DownloadState.DOWNLOADING && z) {
                if (r) {
                    Log.d("DownloadButtonManager", "download pause");
                }
                p("pauseDownload", this.f49519c);
            }
            if (this.f49518b.f49559a == DownloadState.DOWNLOAD_PAUSED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download resume");
                }
                p("resumeDownload", this.f49519c);
            }
            if (this.f49518b.f49559a == DownloadState.DOWNLOAD_FAILED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download retry");
                }
                p("startDownload", this.f49519c);
            }
            if (this.f49518b.f49559a == DownloadState.DOWNLOADED) {
                if (r) {
                    Log.d("DownloadButtonManager", "download install");
                }
                this.f49519c.b();
                p("installApp", this.f49519c);
            }
            if (this.f49518b.f49559a == DownloadState.INSTALLED) {
                if (r) {
                    Log.d("DownloadButtonManager", "open app");
                }
                String e2 = this.f49519c.e();
                if (TextUtils.isEmpty(this.f49518b.f49561c) && !TextUtils.isEmpty(e2)) {
                    C(e2);
                }
                p("open_manual", this.f49519c);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f49518b == null) {
            return;
        }
        if (q0.F(d.a.n0.a.c1.a.b(), this.f49518b.f49561c)) {
            E(DownloadState.INSTALLED);
            g(this.p, "checkPackageExpired", this.f49524h, this.f49525i, DownloadState.INSTALLED.value());
            return;
        }
        p("checkPackageExpired", this.f49519c);
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f49519c = null;
            this.f49517a = null;
            this.f49518b = null;
        }
    }

    public final int v(DownloadState downloadState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, downloadState)) == null) {
            switch (b.f49527a[downloadState.ordinal()]) {
                case 1:
                    return d.a.n0.f.j.k.aiapps_game_download_button_pause;
                case 2:
                    return d.a.n0.f.j.k.aiapps_game_download_button_continue;
                case 3:
                    return d.a.n0.f.j.k.aiapps_game_download_button_install;
                case 4:
                    return d.a.n0.f.j.k.aiapps_game_download_button;
                case 5:
                    return d.a.n0.f.j.k.aiapps_game_download_button_failed_retry;
                case 6:
                    return d.a.n0.f.j.k.aiapps_game_download_button_open;
                default:
                    return d.a.n0.f.j.k.aiapps_game_download_button;
            }
        }
        return invokeL.intValue;
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f49522f = str;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f49523g = str;
        }
    }

    public final void y(int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (jVar = this.f49518b) == null || i2 == jVar.f49562d) {
            return;
        }
        jVar.f49562d = i2;
        F();
    }

    public final void z(DownloadState downloadState) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, downloadState) == null) || (jVar = this.f49518b) == null || downloadState == jVar.f49559a) {
            return;
        }
        jVar.f49559a = downloadState;
        F();
    }
}
