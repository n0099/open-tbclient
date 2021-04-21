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
import d.p.a.d.f.c;
import java.util.List;
/* loaded from: classes6.dex */
public class AppDetailInfoActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f39029a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f39030b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f39031c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f39032d;

    /* renamed from: e  reason: collision with root package name */
    public long f39033e;

    /* renamed from: f  reason: collision with root package name */
    public long f39034f;

    /* renamed from: g  reason: collision with root package name */
    public List<Pair<String, String>> f39035g;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.p.a.d.f.f.c.c("lp_app_detail_click_close", AppDetailInfoActivity.this.f39034f);
            AppDetailInfoActivity.this.finish();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.p.a.d.f.f.c.c("lp_app_detail_click_download", AppDetailInfoActivity.this.f39034f);
            d.p.a.d.f.f.b.a().i(AppDetailInfoActivity.this.f39034f);
            d.p.a.e.a.d.q(AppDetailInfoActivity.this);
            d.p.a.e.a.d.q(d.p.a.d.f.f.b.a().h());
        }
    }

    /* loaded from: classes6.dex */
    public class c extends RecyclerView.Adapter<Object> {
        public c() {
        }

        public /* synthetic */ c(AppDetailInfoActivity appDetailInfoActivity, a aVar) {
            this();
        }
    }

    private void b() {
        this.f39029a = (ImageView) findViewById(d.p.a.d.b.iv_detail_back);
        this.f39030b = (TextView) findViewById(d.p.a.d.b.tv_empty);
        this.f39032d = (RecyclerView) findViewById(d.p.a.d.b.permission_list);
        this.f39031c = (LinearLayout) findViewById(d.p.a.d.b.ll_download);
        if (this.f39035g.isEmpty()) {
            this.f39032d.setVisibility(8);
            this.f39030b.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.f39032d.setLayoutManager(linearLayoutManager);
            this.f39032d.setAdapter(new c(this, null));
        }
        this.f39029a.setOnClickListener(new a());
        this.f39031c.setOnClickListener(new b());
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        d.p.a.d.f.f.c.c("lp_app_detail_click_close", this.f39034f);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.p.a.d.c.ttdownloader_activity_app_detail_info);
        a();
        b();
    }

    public static void a(Activity activity, long j) {
        Intent intent = new Intent(activity, AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private void a() {
        this.f39033e = getIntent().getLongExtra("app_info_id", 0L);
        c.C1863c a2 = com.ss.android.downloadlib.addownload.compliance.c.a().a(this.f39033e);
        this.f39034f = a2.f67662b;
        this.f39035g = a2.f67667g;
    }
}
