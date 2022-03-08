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

    /* renamed from: b  reason: collision with root package name */
    public TextView f58047b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f58048c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f58049d;

    /* renamed from: e  reason: collision with root package name */
    public long f58050e;

    /* renamed from: f  reason: collision with root package name */
    public long f58051f;

    /* renamed from: g  reason: collision with root package name */
    public List<Pair<String, String>> f58052g;

    /* loaded from: classes8.dex */
    public class a extends RecyclerView.Adapter<Object> {
        public a() {
        }
    }

    private void b() {
        this.a = (ImageView) findViewById(R.id.iv_detail_back);
        this.f58047b = (TextView) findViewById(R.id.tv_empty);
        this.f58049d = (RecyclerView) findViewById(R.id.permission_list);
        this.f58048c = (LinearLayout) findViewById(R.id.ll_download);
        if (this.f58052g.isEmpty()) {
            this.f58049d.setVisibility(8);
            this.f58047b.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.f58049d.setLayoutManager(linearLayoutManager);
            this.f58049d.setAdapter(new a());
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_detail_click_close", AppDetailInfoActivity.this.f58051f);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.f58048c.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_detail_click_download", AppDetailInfoActivity.this.f58051f);
                b.a().b(AppDetailInfoActivity.this.f58051f);
                com.ss.android.socialbase.appdownloader.c.a((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.c.a(b.a().b());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        e.a("lp_app_detail_click_close", this.f58051f);
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
        this.f58050e = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.b.b a2 = c.a().a(this.f58050e);
        if (a2 == null) {
            return false;
        }
        this.f58051f = a2.f58003b;
        this.f58052g = a2.f58009h;
        return true;
    }
}
