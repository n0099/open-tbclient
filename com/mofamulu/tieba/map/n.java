package com.mofamulu.tieba.map;

import android.support.v4.view.bq;
import android.widget.RadioGroup;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements bq {
    final /* synthetic */ FreeNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FreeNearbyActivity freeNearbyActivity) {
        this.a = freeNearbyActivity;
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
        boolean z;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;
        RadioGroup radioGroup4;
        com.baidu.tieba.util.z.c("onPageSelected positon = " + String.valueOf(i));
        z = this.a.z;
        if (!z) {
            this.a.A = true;
            if (i == 0) {
                radioGroup3 = this.a.r;
                if (radioGroup3.getCheckedRadioButtonId() != R.id.title_lbs_threads) {
                    radioGroup4 = this.a.r;
                    radioGroup4.check(R.id.title_lbs_threads);
                }
            } else {
                radioGroup = this.a.r;
                if (radioGroup.getCheckedRadioButtonId() != R.id.title_lbs_bars) {
                    radioGroup2 = this.a.r;
                    radioGroup2.check(R.id.title_lbs_bars);
                }
            }
            this.a.A = false;
        }
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
    }
}
