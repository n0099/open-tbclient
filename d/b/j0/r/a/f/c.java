package d.b.j0.r.a.f;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f61343a = TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info", 0);

    public c(Context context) {
    }

    public String a() {
        return this.f61343a.getString("splash", "");
    }

    public void b(String str) {
        SharedPreferences.Editor edit = this.f61343a.edit();
        edit.putString("splash", str);
        edit.commit();
    }
}
