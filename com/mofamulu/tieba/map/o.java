package com.mofamulu.tieba.map;

import android.support.v4.view.ViewPager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements m {
    final /* synthetic */ FreeNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FreeNearbyActivity freeNearbyActivity) {
        this.a = freeNearbyActivity;
    }

    @Override // com.mofamulu.tieba.map.m
    public void a(FreeLocationService freeLocationService) {
        ProgressBar progressBar;
        ViewPager viewPager;
        TextView textView;
        TextView textView2;
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        String b = freeLocationService.b();
        if (b != null) {
            Toast.makeText(this.a, "坐标解析失败：" + b, 0).show();
            viewPager = this.a.m;
            if (viewPager.getChildCount() != 0) {
                textView = this.a.q;
                textView.setText(freeLocationService.b() + "\n" + this.a.getString(R.string.retry_location));
                textView2 = this.a.q;
                textView2.setVisibility(0);
            }
        }
        this.a.a(false);
    }
}
