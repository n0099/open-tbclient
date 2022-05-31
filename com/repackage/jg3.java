package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.repackage.kg3;
import com.repackage.og3;
import com.repackage.sf3;
import com.repackage.zh3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public interface jg3 {
    String a(Context context);

    String b(Context context);

    void c(Context context, Bundle bundle, tf1 tf1Var);

    hg3 d(Context context);

    void e(Activity activity, String str, String str2, ig3 ig3Var);

    void f(Context context, zh3.d dVar);

    boolean g(Context context);

    String getBduss(Context context);

    void h(vf1 vf1Var);

    void i(Context context, kg3.d dVar);

    void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str);

    String k(Context context);

    void l(Activity activity, String str, String str2, ig3 ig3Var);

    void m(Activity activity, String str, oh3 oh3Var);

    void n(String str, ArrayList<String> arrayList, og3.c cVar);

    void o(sf3.a aVar, String str, List<String> list);
}
