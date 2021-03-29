package d.b.h0.i0;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f50229a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<String> f50230b = new ArrayList<>();

    public c(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.f50229a = str;
        f(intent);
    }

    public String a() {
        return this.f50229a;
    }

    public ArrayList<String> b() {
        return TbPageExtraHelper.c(this.f50230b, this.f50229a);
    }

    public ArrayList<String> c() {
        return this.f50230b;
    }

    public String d() {
        return (String) ListUtils.getItem(this.f50230b, ListUtils.getCount(this.f50230b) - 1);
    }

    public boolean e() {
        return StringUtils.isNull(this.f50229a);
    }

    public void f(Intent intent) {
        this.f50230b.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (ListUtils.isEmpty(stringArrayListExtra)) {
                return;
            }
            this.f50230b.addAll(stringArrayListExtra);
        }
    }
}
