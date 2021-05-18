package d.a.c.e.a.f;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends DiskFileOperate implements d.a.c.e.a.a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f38785a;

    public e(String str, String str2, DiskFileOperate.Action action, ArrayList<String> arrayList) {
        super(str, str2, action);
        this.f38785a = arrayList;
    }

    @Override // d.a.c.e.a.a
    public boolean compare(File file) {
        if (this.f38785a != null && file != null) {
            String name = file.getName();
            if (!TextUtils.isEmpty(name)) {
                Iterator<String> it = this.f38785a.iterator();
                while (it.hasNext()) {
                    if (name.equals(it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
