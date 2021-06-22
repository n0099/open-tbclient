package d.a.o0.h1;

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
    public String f59259c;

    /* renamed from: d  reason: collision with root package name */
    public int f59260d;

    /* renamed from: e  reason: collision with root package name */
    public int f59261e;

    /* renamed from: f  reason: collision with root package name */
    public int f59262f;

    /* renamed from: b  reason: collision with root package name */
    public long f59258b = 0;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f59257a = new HashMap<>();

    public int a() {
        return this.f59261e;
    }

    public int b() {
        return this.f59262f;
    }

    public void c(List<String> list, int i2, int i3) {
        synchronized (this.f59257a) {
            if (System.nanoTime() - this.f59258b > AbsMsgImageActivity.INV_TIME && list != null && i2 < list.size()) {
                this.f59257a.put(list.get(i2), Boolean.TRUE);
            }
            this.f59258b = System.nanoTime();
            if (list != null && i3 < list.size() && this.f59257a.get(list.get(i3)) == null) {
                this.f59257a.put(list.get(i3), Boolean.FALSE);
            }
        }
        if (this.f59257a.size() >= 100) {
            g();
        }
    }

    public void d(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.f59259c = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.f59259c = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.f59260d = intExtra;
            this.f59261e = intExtra;
            this.f59262f = intExtra;
        }
    }

    public void e(int i2, String str) {
        if (i2 != 1 || System.nanoTime() - this.f59258b <= AbsMsgImageActivity.INV_TIME) {
            return;
        }
        this.f59257a.put(str, Boolean.TRUE);
    }

    public void f(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putString(ImageViewerConfig.PV_TYPE, this.f59259c);
    }

    public void g() {
        HashMap<String, Boolean> hashMap = this.f59257a;
        if (hashMap == null) {
            return;
        }
        synchronized (hashMap) {
            if (this.f59257a.size() <= 0) {
                return;
            }
            int i2 = 0;
            for (Map.Entry<String, Boolean> entry : this.f59257a.entrySet()) {
                if (entry.getValue().booleanValue()) {
                    i2++;
                }
            }
            TbadkCoreApplication.getInst().sendImagePv(i2, this.f59257a.size(), this.f59259c, this.f59260d + 1, this.f59261e + 1);
            this.f59257a.clear();
        }
    }

    public void h(int i2) {
        this.f59261e = i2;
    }

    public void i(int i2) {
        this.f59262f = i2;
    }

    public void j(int i2, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i3 = this.f59262f;
        if (i3 != this.f59261e) {
            while (true) {
                int i4 = this.f59261e;
                if (i3 > i4) {
                    break;
                }
                if (i3 == i4) {
                    sb.append(i3 + 1);
                    if (this.f59261e == i2 - 1) {
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
            if (this.f59261e == i2 - 1) {
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
        int i5 = this.f59261e;
        int i6 = (i5 - this.f59262f) + 1;
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
            if (this.f59261e == i2 - 1) {
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
