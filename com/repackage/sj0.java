package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public long d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public String i;
    public int j;
    public int k;
    public String l;
    public String m;
    public long n;
    public long o;
    public boolean p;
    public int q;

    public sj0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = "";
        this.d = 0L;
        this.e = false;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.n = -1L;
        this.o = -1L;
        this.p = false;
        this.q = 0;
    }

    public static String a(@NonNull sj0 sj0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sj0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", sj0Var.a);
                jSONObject.put(Constant.KEY_BUSINESS, sj0Var.b);
                jSONObject.put("content_type", sj0Var.c);
                jSONObject.put(BreakpointSQLiteKey.CONTENT_LENGTH, sj0Var.d);
                int i = 1;
                jSONObject.put("is_dirty", sj0Var.e ? 1 : 0);
                jSONObject.put("close_v_download", sj0Var.f);
                jSONObject.put("no_click_opt", sj0Var.g);
                jSONObject.put("open_after_install", sj0Var.h);
                jSONObject.put("action_area", sj0Var.i);
                jSONObject.put("notification_show_count", sj0Var.j);
                jSONObject.put("tips_show_count", sj0Var.k);
                jSONObject.put("als_app_save_day", sj0Var.n);
                jSONObject.put("finished_install_time", sj0Var.o);
                if (!sj0Var.p) {
                    i = 0;
                }
                jSONObject.put("lazy_launch_switch", i);
                jSONObject.put("lazy_launch_internal", sj0Var.q);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
