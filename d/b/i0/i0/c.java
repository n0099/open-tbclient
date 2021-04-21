package d.b.i0.i0;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f50972a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<String> f50973b = new ArrayList<>();

    public c(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.f50972a = str;
        f(intent);
    }

    public String a() {
        return this.f50972a;
    }

    public ArrayList<String> b() {
        return TbPageExtraHelper.c(this.f50973b, this.f50972a);
    }

    public ArrayList<String> c() {
        return this.f50973b;
    }

    public String d() {
        return (String) ListUtils.getItem(this.f50973b, ListUtils.getCount(this.f50973b) - 1);
    }

    public boolean e() {
        return StringUtils.isNull(this.f50972a);
    }

    public void f(Intent intent) {
        this.f50973b.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (ListUtils.isEmpty(stringArrayListExtra)) {
                return;
            }
            this.f50973b.addAll(stringArrayListExtra);
        }
    }
}
