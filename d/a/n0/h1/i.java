package d.a.n0.h1;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import d.a.c.e.p.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public String f59134c;

    /* renamed from: d  reason: collision with root package name */
    public int f59135d;

    /* renamed from: e  reason: collision with root package name */
    public int f59136e;

    /* renamed from: f  reason: collision with root package name */
    public int f59137f;

    /* renamed from: b  reason: collision with root package name */
    public long f59133b = 0;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f59132a = new HashMap<>();

    public int a() {
        return this.f59136e;
    }

    public int b() {
        return this.f59137f;
    }

    public void c(List<String> list, int i2, int i3) {
        synchronized (this.f59132a) {
            if (System.nanoTime() - this.f59133b > AbsMsgImageActivity.INV_TIME && list != null && i2 < list.size()) {
                this.f59132a.put(list.get(i2), Boolean.TRUE);
            }
            this.f59133b = System.nanoTime();
            if (list != null && i3 < list.size() && this.f59132a.get(list.get(i3)) == null) {
                this.f59132a.put(list.get(i3), Boolean.FALSE);
            }
        }
        if (this.f59132a.size() >= 100) {
            g();
        }
    }

    public void d(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.f59134c = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.f59134c = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.f59135d = intExtra;
            this.f59136e = intExtra;
            this.f59137f = intExtra;
        }
    }

    public void e(int i2, String str) {
        if (i2 != 1 || System.nanoTime() - this.f59133b <= AbsMsgImageActivity.INV_TIME) {
            return;
        }
        this.f59132a.put(str, Boolean.TRUE);
    }

    public void f(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putString(ImageViewerConfig.PV_TYPE, this.f59134c);
    }

    public void g() {
        HashMap<String, Boolean> hashMap = this.f59132a;
        if (hashMap == null) {
            return;
        }
        synchronized (hashMap) {
            if (this.f59132a.size() <= 0) {
                return;
            }
            int i2 = 0;
            for (Map.Entry<String, Boolean> entry : this.f59132a.entrySet()) {
                if (entry.getValue().booleanValue()) {
                    i2++;
                }
            }
            TbadkCoreApplication.getInst().sendImagePv(i2, this.f59132a.size(), this.f59134c, this.f59135d + 1, this.f59136e + 1);
            this.f59132a.clear();
        }
    }

    public void h(int i2) {
        this.f59136e = i2;
    }

    public void i(int i2) {
        this.f59137f = i2;
    }

    public void j(int i2, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i3 = this.f59137f;
        if (i3 != this.f59136e) {
            while (true) {
                int i4 = this.f59136e;
                if (i3 > i4) {
                    break;
                }
                if (i3 == i4) {
                    sb.append(i3 + 1);
                    if (this.f59136e == i2 - 1) {
                        sb2.append(1);
                    } else {
                        sb2.append(0);
                    }
                } else {
                    sb.append(i3 + 1);
                    sb.append("|");
                    sb2.append(0);
                    sb2.append("|");
                }
                i3++;
            }
        } else {
            sb.append(i3 + 1);
            if (this.f59136e == i2 - 1) {
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
        statisticItem.param("pic_count", i2);
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR_MERGE, sb.toString());
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD_MERGE, sb2.toString());
        int i5 = this.f59136e;
        int i6 = (i5 - this.f59137f) + 1;
        if (i6 == 1) {
            if (i5 == i2 - 1) {
                statisticItem.param("obj_id", str);
            } else {
                statisticItem.param("obj_id", "");
            }
        }
        if (i6 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i7 = 0; i7 < i6 - 1; i7++) {
                sb3.append("|");
            }
            if (this.f59136e == i2 - 1) {
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
