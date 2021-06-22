package d.a.n0.i0;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f53207a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<String> f53208b = new ArrayList<>();

    public c(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.f53207a = str;
        f(intent);
    }

    public String a() {
        return this.f53207a;
    }

    public ArrayList<String> b() {
        return TbPageExtraHelper.c(this.f53208b, this.f53207a);
    }

    public ArrayList<String> c() {
        return this.f53208b;
    }

    public String d() {
        return (String) ListUtils.getItem(this.f53208b, ListUtils.getCount(this.f53208b) - 1);
    }

    public boolean e() {
        return StringUtils.isNull(this.f53207a);
    }

    public void f(Intent intent) {
        this.f53208b.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (ListUtils.isEmpty(stringArrayListExtra)) {
                return;
            }
            this.f53208b.addAll(stringArrayListExtra);
        }
    }
}
