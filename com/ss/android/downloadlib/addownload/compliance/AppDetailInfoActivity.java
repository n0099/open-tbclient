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
/* loaded from: classes7.dex */
public class AppDetailInfoActivity extends Activity {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f42795b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f42796c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f42797d;

    /* renamed from: e  reason: collision with root package name */
    public long f42798e;

    /* renamed from: f  reason: collision with root package name */
    public long f42799f;

    /* renamed from: g  reason: collision with root package name */
    public List<Pair<String, String>> f42800g;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.Adapter<Object> {
        public a() {
        }
    }

    private void b() {
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fcf);
        this.f42795b = (TextView) findViewById(R.id.obfuscated_res_0x7f0921a6);
        this.f42797d = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f09176e);
        this.f42796c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0912f0);
        if (this.f42800g.isEmpty()) {
            this.f42797d.setVisibility(8);
            this.f42795b.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.f42797d.setLayoutManager(linearLayoutManager);
            this.f42797d.setAdapter(new a());
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_detail_click_close", AppDetailInfoActivity.this.f42799f);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.f42796c.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_detail_click_download", AppDetailInfoActivity.this.f42799f);
                b.a().b(AppDetailInfoActivity.this.f42799f);
                com.ss.android.socialbase.appdownloader.c.a((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.c.a(b.a().b());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        e.a("lp_app_detail_click_close", this.f42799f);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d0851);
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

    private boolean a() {
        this.f42798e = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.b.b a2 = c.a().a(this.f42798e);
        if (a2 == null) {
            return false;
        }
        this.f42799f = a2.f42753b;
        this.f42800g = a2.f42759h;
        return true;
    }
}
