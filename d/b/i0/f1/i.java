package d.b.i0.f1;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import d.b.b.e.p.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public String f54683c;

    /* renamed from: d  reason: collision with root package name */
    public int f54684d;

    /* renamed from: e  reason: collision with root package name */
    public int f54685e;

    /* renamed from: f  reason: collision with root package name */
    public int f54686f;

    /* renamed from: b  reason: collision with root package name */
    public long f54682b = 0;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f54681a = new HashMap<>();

    public int a() {
        return this.f54685e;
    }

    public int b() {
        return this.f54686f;
    }

    public void c(List<String> list, int i, int i2) {
        synchronized (this.f54681a) {
            if (System.nanoTime() - this.f54682b > AbsMsgImageActivity.INV_TIME && list != null && i < list.size()) {
                this.f54681a.put(list.get(i), Boolean.TRUE);
            }
            this.f54682b = System.nanoTime();
            if (list != null && i2 < list.size() && this.f54681a.get(list.get(i2)) == null) {
                this.f54681a.put(list.get(i2), Boolean.FALSE);
            }
        }
        if (this.f54681a.size() >= 100) {
            g();
        }
    }

    public void d(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.f54683c = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.f54683c = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.f54684d = intExtra;
            this.f54685e = intExtra;
            this.f54686f = intExtra;
        }
    }

    public void e(int i, String str) {
        if (i != 1 || System.nanoTime() - this.f54682b <= AbsMsgImageActivity.INV_TIME) {
            return;
        }
        this.f54681a.put(str, Boolean.TRUE);
    }

    public void f(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putString(ImageViewerConfig.PV_TYPE, this.f54683c);
    }

    public void g() {
        HashMap<String, Boolean> hashMap = this.f54681a;
        if (hashMap == null) {
            return;
        }
        synchronized (hashMap) {
            if (this.f54681a.size() <= 0) {
                return;
            }
            int i = 0;
            for (Map.Entry<String, Boolean> entry : this.f54681a.entrySet()) {
                if (entry.getValue().booleanValue()) {
                    i++;
                }
            }
            TbadkCoreApplication.getInst().sendImagePv(i, this.f54681a.size(), this.f54683c, this.f54684d + 1, this.f54685e + 1);
            this.f54681a.clear();
        }
    }

    public void h(int i) {
        this.f54685e = i;
    }

    public void i(int i) {
        this.f54686f = i;
    }

    public void j(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i2 = this.f54686f;
        if (i2 != this.f54685e) {
            while (true) {
                int i3 = this.f54685e;
                if (i2 > i3) {
                    break;
                }
                if (i2 == i3) {
                    sb.append(i2 + 1);
                    if (this.f54685e == i - 1) {
                        sb2.append(1);
                    } else {
                        sb2.append(0);
                    }
                } else {
                    sb.append(i2 + 1);
                    sb.append(FieldBuilder.SE);
                    sb2.append(0);
                    sb2.append(FieldBuilder.SE);
                }
                i2++;
            }
        } else {
            sb.append(i2 + 1);
            if (this.f54685e == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        statisticItem.param("page_type", "a008");
        if (!k.isEmpty(str2)) {
            statisticItem.param("fid", str2);
        }
        if (!k.isEmpty(str3)) {
            statisticItem.param("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().r);
        }
        statisticItem.param("pic_count", i);
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR_MERGE, sb.toString());
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD_MERGE, sb2.toString());
        int i4 = this.f54685e;
        int i5 = (i4 - this.f54686f) + 1;
        if (i5 == 1) {
            if (i4 == i - 1) {
                statisticItem.param("obj_id", str);
            } else {
                statisticItem.param("obj_id", "");
            }
        }
        if (i5 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i6 = 0; i6 < i5 - 1; i6++) {
                sb3.append(FieldBuilder.SE);
            }
            if (this.f54685e == i - 1) {
                sb3.append(str);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_ID_MERGE, str);
        }
        if (!StringUtils.isNull(str4)) {
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, str4);
        }
        if (!StringUtils.isNull(str5)) {
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, str5);
        }
        TiebaStatic.log(statisticItem);
    }
}
