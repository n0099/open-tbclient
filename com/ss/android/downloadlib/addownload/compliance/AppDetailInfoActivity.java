package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class AppDetailInfoActivity extends Activity {
    public ImageView a;
    public TextView b;
    public LinearLayout c;
    public RecyclerView d;
    public long e;
    public long f;
    public List<Pair<String, String>> g;

    /* loaded from: classes8.dex */
    public class a extends RecyclerView.Adapter<Object> {
        public a() {
        }
    }

    private boolean a() {
        this.e = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.b.b a2 = c.a().a(this.e);
        if (a2 == null) {
            return false;
        }
        this.f = a2.b;
        this.g = a2.h;
        return true;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        e.a("lp_app_detail_click_close", this.f);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d08fc);
        if (a()) {
            b();
        } else {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }

    public static void a(Activity activity, long j) {
        Intent intent = new Intent(activity, AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private void b() {
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f09113a);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f09252b);
        this.d = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091a20);
        this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091530);
        if (this.g.isEmpty()) {
            this.d.setVisibility(8);
            this.b.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.d.setLayoutManager(linearLayoutManager);
            this.d.setAdapter(new a());
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.a("lp_app_detail_click_close", AppDetailInfoActivity.this.f);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                e.a("lp_app_detail_click_download", AppDetailInfoActivity.this.f);
                b.a().b(AppDetailInfoActivity.this.f);
                com.ss.android.socialbase.appdownloader.c.a((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.c.a(b.a().b());
            }
        });
    }
}
