package d.a.i0.i0;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f48554a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<String> f48555b = new ArrayList<>();

    public c(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.f48554a = str;
        f(intent);
    }

    public String a() {
        return this.f48554a;
    }

    public ArrayList<String> b() {
        return TbPageExtraHelper.c(this.f48555b, this.f48554a);
    }

    public ArrayList<String> c() {
        return this.f48555b;
    }

    public String d() {
        return (String) ListUtils.getItem(this.f48555b, ListUtils.getCount(this.f48555b) - 1);
    }

    public boolean e() {
        return StringUtils.isNull(this.f48554a);
    }

    public void f(Intent intent) {
        this.f48555b.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (ListUtils.isEmpty(stringArrayListExtra)) {
                return;
            }
            this.f48555b.addAll(stringArrayListExtra);
        }
    }
}
