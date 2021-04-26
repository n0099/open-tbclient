package d.a.j0.r.a.f;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f59485a = TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info", 0);

    public c(Context context) {
    }

    public String a() {
        return this.f59485a.getString("splash", "");
    }

    public void b(String str) {
        SharedPreferences.Editor edit = this.f59485a.edit();
        edit.putString("splash", str);
        edit.commit();
    }
}
