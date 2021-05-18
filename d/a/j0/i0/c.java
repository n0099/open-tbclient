package d.a.j0.i0;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f49382a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<String> f49383b = new ArrayList<>();

    public c(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.f49382a = str;
        f(intent);
    }

    public String a() {
        return this.f49382a;
    }

    public ArrayList<String> b() {
        return TbPageExtraHelper.c(this.f49383b, this.f49382a);
    }

    public ArrayList<String> c() {
        return this.f49383b;
    }

    public String d() {
        return (String) ListUtils.getItem(this.f49383b, ListUtils.getCount(this.f49383b) - 1);
    }

    public boolean e() {
        return StringUtils.isNull(this.f49382a);
    }

    public void f(Intent intent) {
        this.f49383b.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (ListUtils.isEmpty(stringArrayListExtra)) {
                return;
            }
            this.f49383b.addAll(stringArrayListExtra);
        }
    }
}
