package com.bytedance.tools.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.bmb;
import com.baidu.tieba.emb;
import com.baidu.tieba.fmb;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class ToolsActivity extends AppCompatActivity {
    public List<LinearLayout> a = new ArrayList();
    public List<TextView> b = new ArrayList();
    public List<View> c = new ArrayList();

    /* loaded from: classes9.dex */
    public class a implements ViewPager.OnPageChangeListener {
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ToolsActivity.this.s1(i);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ ViewPager a;
        public final /* synthetic */ int b;

        public b(ViewPager viewPager, int i) {
            this.a = viewPager;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            this.a.setCurrentItem(this.b);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        fmb.c(this, "test_tool_close");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: java.util.List<android.widget.LinearLayout> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: java.util.List<android.widget.LinearLayout> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: java.util.List<android.widget.LinearLayout> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v7, resolved type: java.util.List<android.widget.TextView> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: java.util.List<android.widget.TextView> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: java.util.List<android.widget.TextView> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d005d);
        if (!bmb.d(this)) {
            Toast.makeText(this, "穿山甲SDK或不存在，无法使用测试工具", 0).show();
            finish();
            return;
        }
        fmb.c(this, "test_tool_start");
        this.a.add(findViewById(R.id.obfuscated_res_0x7f09036b));
        this.a.add(findViewById(R.id.obfuscated_res_0x7f090e55));
        this.a.add(findViewById(R.id.obfuscated_res_0x7f091f96));
        this.b.add(findViewById(R.id.obfuscated_res_0x7f09036d));
        this.b.add(findViewById(R.id.obfuscated_res_0x7f090e57));
        this.b.add(findViewById(R.id.obfuscated_res_0x7f091f98));
        this.c.add(findViewById(R.id.obfuscated_res_0x7f09036c));
        this.c.add(findViewById(R.id.obfuscated_res_0x7f090e56));
        this.c.add(findViewById(R.id.obfuscated_res_0x7f091f97));
        s1(0);
        emb.a(this, (Toolbar) findViewById(R.id.obfuscated_res_0x7f092644), "穿山甲SDK测试工具");
        com.bytedance.tools.ui.ui.main.a aVar = new com.bytedance.tools.ui.ui.main.a(this, getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.obfuscated_res_0x7f0929bf);
        viewPager.setAdapter(aVar);
        viewPager.addOnPageChangeListener(new a());
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).setOnClickListener(new b(viewPager, i));
        }
    }

    public final void s1(int i) {
        String str = "test_tool_basic_info";
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    str = "test_tool_slot_info";
                }
            } else {
                str = "test_tool_overall_info";
            }
        }
        fmb.c(this, str);
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (i == i2) {
                this.b.get(i2).setTextColor(Color.parseColor("#161823"));
                this.c.get(i2).setBackgroundColor(Color.parseColor("#161823"));
                this.b.get(i2).getPaint().setFakeBoldText(true);
            } else {
                this.b.get(i2).setTextColor(Color.parseColor("#80161823"));
                this.c.get(i2).setBackgroundColor(Color.parseColor("#ffffff"));
                this.b.get(i2).getPaint().setFakeBoldText(false);
            }
        }
    }
}
