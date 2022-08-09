package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.repackage.ci3;
import com.repackage.gi3;
import com.repackage.kh3;
import com.repackage.rj3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public interface bi3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, lh1 lh1Var);

    zh3 d(Context context);

    void e(Activity activity, String str, String str2, ai3 ai3Var);

    void f(Context context, rj3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(nh1 nh1Var);

    void i(Context context, ci3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, ai3 ai3Var);

    void m(Activity activity, String str, gj3 gj3Var);

    void n(String str, ArrayList<String> arrayList, gi3.c cVar);

    void o(kh3.a aVar, String str, List<String> list);
}
