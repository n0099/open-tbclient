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
import d.o.a.d.f.c;
import java.util.List;
/* loaded from: classes7.dex */
public class AppDetailInfoActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f39570a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f39571b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f39572c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f39573d;

    /* renamed from: e  reason: collision with root package name */
    public long f39574e;

    /* renamed from: f  reason: collision with root package name */
    public long f39575f;

    /* renamed from: g  reason: collision with root package name */
    public List<Pair<String, String>> f39576g;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.o.a.d.f.f.c.c("lp_app_detail_click_close", AppDetailInfoActivity.this.f39575f);
            AppDetailInfoActivity.this.finish();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.o.a.d.f.f.c.c("lp_app_detail_click_download", AppDetailInfoActivity.this.f39575f);
            d.o.a.d.f.f.b.a().i(AppDetailInfoActivity.this.f39575f);
            d.o.a.e.a.d.q(AppDetailInfoActivity.this);
            d.o.a.e.a.d.q(d.o.a.d.f.f.b.a().h());
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.Adapter<Object> {
        public c() {
        }

        public /* synthetic */ c(AppDetailInfoActivity appDetailInfoActivity, a aVar) {
            this();
        }
    }

    private void b() {
        this.f39570a = (ImageView) findViewById(d.o.a.d.b.iv_detail_back);
        this.f39571b = (TextView) findViewById(d.o.a.d.b.tv_empty);
        this.f39573d = (RecyclerView) findViewById(d.o.a.d.b.permission_list);
        this.f39572c = (LinearLayout) findViewById(d.o.a.d.b.ll_download);
        if (this.f39576g.isEmpty()) {
            this.f39573d.setVisibility(8);
            this.f39571b.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.f39573d.setLayoutManager(linearLayoutManager);
            this.f39573d.setAdapter(new c(this, null));
        }
        this.f39570a.setOnClickListener(new a());
        this.f39572c.setOnClickListener(new b());
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        d.o.a.d.f.f.c.c("lp_app_detail_click_close", this.f39575f);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.o.a.d.c.ttdownloader_activity_app_detail_info);
        a();
        b();
    }

    public static void a(Activity activity, long j) {
        Intent intent = new Intent(activity, AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private void a() {
        this.f39574e = getIntent().getLongExtra("app_info_id", 0L);
        c.C1929c a2 = com.ss.android.downloadlib.addownload.compliance.c.a().a(this.f39574e);
        this.f39575f = a2.f70627b;
        this.f39576g = a2.f70632g;
    }
}
