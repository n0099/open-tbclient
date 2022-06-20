package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;
    public String c;
    public b d;
    public Context e;

    /* loaded from: classes5.dex */
    public class a implements aa0<i80> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ e80 c;

        public a(e80 e80Var, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e80Var, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e80Var;
            this.a = str;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't wrap try/catch for region: R(13:3|(2:5|(1:45)(1:8))(1:46)|9|(1:11)(1:44)|12|(3:14|(9:38|39|40|18|(2:(1:36)(1:27)|28)(1:37)|29|30|31|32)|16)(1:43)|17|18|(0)(0)|29|30|31|32) */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
        @Override // com.repackage.aa0
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(NetResponse netResponse, i80 i80Var, Map<String, String> map, List<String> list) {
            String str;
            String str2;
            int i;
            String str3;
            String str4;
            String str5;
            String str6;
            long j;
            String str7;
            m80 m80Var;
            List<LiveTabEntity> list2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, netResponse, i80Var, map, list) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                String str8 = "";
                if (netResponse == null) {
                    String string = this.c.e.getResources().getString(R.string.obfuscated_res_0x7f0f0a03);
                    this.c.d.b(-100, string, map);
                    str = "";
                    str2 = string;
                    i = -100;
                } else if (!netResponse.isSuccessful() || i80Var == null) {
                    this.c.d.b(netResponse.netErrorCode, netResponse.exception, map);
                    int i2 = netResponse.netErrorCode;
                    str2 = netResponse.exception;
                    str = "";
                    i = i2;
                } else {
                    this.c.d.a(i80Var, map);
                    t80.a(list);
                    i = i80Var.a;
                    str2 = i80Var.b;
                    str = i80Var.c;
                }
                String str9 = this.c.b ? "chenjinshi" : "zhibopindao";
                if (map != null) {
                    String str10 = map.get("tab");
                    String str11 = map.get("subtab");
                    str4 = map.get("resource");
                    String str12 = map.get("session_id");
                    if (map.containsKey(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY)) {
                        try {
                            j = currentTimeMillis - Long.parseLong(map.get(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY));
                            str3 = str10;
                            str5 = str11;
                            str6 = str12;
                        } catch (NumberFormatException unused) {
                        }
                        if (str4.contains("tab")) {
                            str7 = "";
                        } else {
                            str7 = (i80Var == null || (m80Var = i80Var.g) == null || (list2 = m80Var.c) == null || list2.isEmpty()) ? "1" : "0";
                        }
                        str8 = URLEncoder.encode(str4, "UTF-8");
                        d80.r(this.c.e, this.c.a, str9, j, i, str2, str, str8, str3, str5, str6, str7);
                    }
                    str3 = str10;
                    str5 = str11;
                    str6 = str12;
                } else {
                    str3 = "";
                    str4 = str3;
                    str5 = str4;
                    str6 = str5;
                }
                j = 0;
                if (str4.contains("tab")) {
                }
                str8 = URLEncoder.encode(str4, "UTF-8");
                d80.r(this.c.e, this.c.a, str9, j, i, str2, str, str8, str3, str5, str6, str7);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.aa0
        /* renamed from: c */
        public i80 onParseResponseInBackground(NetResponse netResponse) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, netResponse)) == null) {
                i80 i80Var = new i80();
                if (netResponse != null && !TextUtils.isEmpty(netResponse.decodedResponseStr)) {
                    try {
                        i80Var.c(new JSONObject(netResponse.decodedResponseStr), this.a, this.b);
                    } catch (JSONException e) {
                        LiveFeedPageSdk.m(e.getMessage());
                        if (TextUtils.equals("banner,tab,feed,follow,config", this.a)) {
                            i80Var.a("banner,tab,feed,follow,config", -101, e.getMessage());
                        }
                    }
                }
                return i80Var;
            }
            return (i80) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(i80 i80Var, Map<String, String> map);

        void b(int i, String str, Map<String, String> map);
    }

    public e80(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = context;
        this.a = str;
        this.b = z;
        this.c = z ? "immer" : "tab";
    }

    public final void e(String str, String str2, int i, String str3, String str4, String str5, int i2, String str6, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), str3, str4, str5, Integer.valueOf(i2), str6, list}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("resource", str);
            hashMap.put("scene", this.c);
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("session_id", str2);
            hashMap.put("refresh_type", String.valueOf(i));
            hashMap.put("tab", str3);
            hashMap.put("channel_id", str4);
            hashMap.put("subtab", str5);
            hashMap.put("upload_ids", str6);
            hashMap.put("refresh_index", String.valueOf(i2));
            hashMap.put(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY, System.currentTimeMillis() + "");
            ba0.f("https://tiebac.baidu.com/livefeed/feed", hashMap, new a(this, str, i), 0, 0, null, list);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e(PersonListActivityConfig.FOLLOW, "", 0, "", "", "", 1, "", null);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            e("banner,tab,feed,follow,config", "", 0, "", "", "", 1, t80.b(), t80.b);
        }
    }

    public void h(String str, String str2, int i, String str3, String str4, String str5, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), str3, str4, str5, Integer.valueOf(i2)}) == null) {
            e(str, str2, i, str3, str4, str5, i2, t80.b(), t80.b);
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.d = bVar;
        }
    }
}
