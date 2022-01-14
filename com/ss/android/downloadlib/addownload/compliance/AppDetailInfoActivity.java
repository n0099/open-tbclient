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
import com.bytedance.sdk.openadsdk.R;
import java.util.List;
/* loaded from: classes3.dex */
public class AppDetailInfoActivity extends Activity {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59485b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f59486c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f59487d;

    /* renamed from: e  reason: collision with root package name */
    public long f59488e;

    /* renamed from: f  reason: collision with root package name */
    public long f59489f;

    /* renamed from: g  reason: collision with root package name */
    public List<Pair<String, String>> f59490g;

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.Adapter<Object> {
        public a() {
        }
    }

    private void b() {
        this.a = (ImageView) findViewById(R.id.iv_detail_back);
        this.f59485b = (TextView) findViewById(R.id.tv_empty);
        this.f59487d = (RecyclerView) findViewById(R.id.permission_list);
        this.f59486c = (LinearLayout) findViewById(R.id.ll_download);
        if (this.f59490g.isEmpty()) {
            this.f59487d.setVisibility(8);
            this.f59485b.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.f59487d.setLayoutManager(linearLayoutManager);
            this.f59487d.setAdapter(new a());
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_detail_click_close", AppDetailInfoActivity.this.f59489f);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.f59486c.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_detail_click_download", AppDetailInfoActivity.this.f59489f);
                b.a().b(AppDetailInfoActivity.this.f59489f);
                com.ss.android.socialbase.appdownloader.c.a((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.c.a(b.a().b());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        e.a("lp_app_detail_click_close", this.f59489f);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_detail_info);
        if (a()) {
            b();
        } else {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }

    public static void a(Activity activity, long j2) {
        Intent intent = new Intent(activity, AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j2);
        activity.startActivity(intent);
    }

    private boolean a() {
        this.f59488e = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.b.b a2 = c.a().a(this.f59488e);
        if (a2 == null) {
            return false;
        }
        this.f59489f = a2.f59441b;
        this.f59490g = a2.f59447h;
        return true;
    }
}
