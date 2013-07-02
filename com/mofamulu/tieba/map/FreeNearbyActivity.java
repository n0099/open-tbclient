package com.mofamulu.tieba.map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.view.BaseViewPagerAdapter;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.baidu.tieba.write.bb;
import com.mofamulu.tieba.ch.be;
import com.mofamulu.tieba.ch.bg;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FreeNearbyActivity extends com.mofamulu.tieba.ch.aa {
    FreeLocationService j;
    private RelativeLayout k = null;
    private TextView l = null;
    private ViewPager m = null;
    private BaseViewPagerAdapter n = null;
    LocalActivityManager g = null;
    private m o = null;
    private ProgressBar p = null;
    private TextView q = null;
    private RadioGroup r = null;
    private CompoundButton.OnCheckedChangeListener s = null;
    private RadioButton t = null;
    private RadioButton u = null;
    private ImageView v = null;
    private ImageView w = null;
    private View.OnTouchListener x = null;
    private boolean y = false;
    private boolean z = false;
    private boolean A = false;
    private ImageView B = null;
    private ImageView C = null;
    private ImageView D = null;
    private ImageView E = null;
    private ImageView F = null;
    private View.OnClickListener G = null;
    private boolean H = true;
    private AlertDialog I = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tbhp_free_nearby_activity);
        this.j = FreeLocationService.a(this);
        this.g = new LocalActivityManager(this, false);
        this.g.dispatchCreate(bundle != null ? bundle.getBundle("android:states") : null);
        o();
        q();
        r();
        this.j.a(this.o);
        a(false);
    }

    @Override // com.baidu.tieba.g
    public boolean e() {
        return TiebaApplication.f().v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.ch.aa, com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        this.g.dispatchResume();
        this.l.setText(this.j.f());
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bundle saveInstanceState = this.g.saveInstanceState();
        if (saveInstanceState != null) {
            bundle.putBundle("android:states", saveInstanceState);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.ch.aa, com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        this.g.dispatchPause(isFinishing());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onStop() {
        super.onStop();
        this.g.dispatchStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.ch.aa, com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        this.j.b(this.o);
        this.g.dispatchDestroy(isFinishing());
        super.onDestroy();
    }

    private void p() {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent(this, FreeNearbyPostActivity.class);
        Intent intent2 = new Intent(this, FreeNearbyForumActivity.class);
        View decorView = this.g.startActivity("nearby_post", intent).getDecorView();
        View decorView2 = this.g.startActivity("nearby_forum", intent2).getDecorView();
        arrayList.add(decorView);
        arrayList.add(decorView2);
        this.n.a(arrayList);
        this.n.notifyDataSetChanged();
    }

    private void q() {
        this.m = (ViewPager) findViewById(R.id.view_pager);
        this.n = new BaseViewPagerAdapter();
        this.m.setAdapter(this.n);
        this.m.setOnPageChangeListener(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        String D = TiebaApplication.D();
        if (D == null || D.length() <= 0) {
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100016);
            }
        } else if (i == 0) {
            WriteActivity.a(this);
        } else {
            this.I.show();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 811:
                    b();
                    this.l.setText(this.j.f());
                    this.j.e();
                    break;
                case 1100001:
                    b(0);
                    break;
                case 1100016:
                    this.I.show();
                    break;
                case 1200001:
                    WriteImageActivity.b(this, 1200001, 1200010, null);
                    break;
                case 1200002:
                    if (intent != null && intent.getData() != null) {
                        WriteImageActivity.b(this, 1200002, 1200009, intent.getData());
                        break;
                    } else {
                        bb.b(this);
                        break;
                    }
                    break;
                case 1200009:
                case 1200010:
                    if (intent == null || intent.getStringExtra("filename") == null) {
                        WriteActivity.a((Activity) this, true, (String) null);
                        break;
                    } else {
                        WriteActivity.a((Activity) this, true, intent.getStringExtra("filename"));
                        break;
                    }
                case 1300005:
                    t();
                    break;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 1200009:
                    bb.b(this);
                    break;
                case 1200010:
                    bb.a(this);
                    break;
            }
        } else if (i2 == 100) {
            switch (i) {
                case 811:
                    b();
                    this.l.setText("定位到当前坐标中……");
                    this.j.a(true);
                    break;
            }
        }
        Activity activity = this.g.getActivity("nearby_post");
        if (activity instanceof FreeNearbyPostActivity) {
            if (i == 1300006 || i == 1100024) {
                ((FreeNearbyPostActivity) activity).onActivityResult(i, i2, intent);
            }
        }
    }

    private void r() {
        this.o = new o(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        this.p.setVisibility(8);
        this.q.setVisibility(8);
        if (this.m.getChildCount() == 0) {
            p();
        }
        this.l.setText(this.j.f());
        if (z || bg.c().U()) {
            s();
        }
    }

    public void b() {
        this.p.setVisibility(0);
    }

    public void c() {
        b();
        a(true);
    }

    private void s() {
        int currentItem = this.m.getCurrentItem();
        if (this.g.getActivity("nearby_post") instanceof FreeNearbyPostActivity) {
            ((FreeNearbyPostActivity) this.g.getActivity("nearby_post")).a(0, this.j.a(), currentItem == 0);
        }
        if (this.g.getActivity("nearby_forum") instanceof FreeNearbyForumActivity) {
            ((FreeNearbyForumActivity) this.g.getActivity("nearby_forum")).a(this.j.a(), currentItem == 1);
        }
    }

    private void t() {
        if (this.m.getCurrentItem() != 0) {
            this.m.a(0, true);
        }
        if (this.g.getActivity("nearby_post") instanceof FreeNearbyPostActivity) {
            ((FreeNearbyPostActivity) this.g.getActivity("nearby_post")).a(0, this.j.a(), true);
        }
    }

    public void d() {
        if (this.m.getChildCount() < 2 || !(this.g.getActivity("nearby_post") instanceof FreeNearbyPostActivity) || ((FreeNearbyPostActivity) this.g.getActivity("nearby_post")).m() == null) {
        }
    }

    public int m() {
        return this.m.getCurrentItem();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.y = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0 && !this.y) {
            n();
        }
        return dispatchTouchEvent;
    }

    public void n() {
        if (!this.H) {
            this.G.onClick(this.B);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.ch.aa, com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        be.a((ViewGroup) findViewById(R.id.new_nearby_activity_layout), i);
        if (i == 1) {
            this.B.setImageResource(R.drawable.lbs_send_normal_1);
            this.C.setImageResource(R.drawable.lbs_send_pic_1);
            this.D.setImageResource(R.drawable.lbs_send_text_1);
            this.E.setImageResource(R.drawable.lbs_send_jump_hand_1);
            this.F.setImageResource(R.drawable.lbs_send_jump_map_1);
            com.baidu.tieba.util.x.h((View) this.t, (int) R.drawable.lbs_title_bg_1);
            com.baidu.tieba.util.x.h((View) this.u, (int) R.drawable.lbs_title_bg_1);
            this.t.setTextColor(getResources().getColorStateList(R.color.lbs_title_color_1));
            this.u.setTextColor(getResources().getColorStateList(R.color.lbs_title_color_1));
            com.baidu.tieba.util.x.h(this.v, (int) R.drawable.lbs_title_bg_normal_1);
            com.baidu.tieba.util.x.h(this.w, (int) R.drawable.lbs_title_bg_normal_1);
            this.w.setImageDrawable(new ColorDrawable(-13421773));
            this.m.setBackgroundColor(-13618114);
            return;
        }
        this.B.setImageResource(R.drawable.lbs_send_normal);
        this.C.setImageResource(R.drawable.lbs_send_pic);
        this.D.setImageResource(R.drawable.lbs_send_text);
        this.E.setImageResource(R.drawable.lbs_send_jump_hand);
        this.F.setImageResource(R.drawable.lbs_send_jump_map);
        com.baidu.tieba.util.x.h((View) this.t, (int) R.drawable.lbs_title_bg);
        com.baidu.tieba.util.x.h((View) this.u, (int) R.drawable.lbs_title_bg);
        this.t.setTextColor(getResources().getColorStateList(R.color.lbs_title_color));
        this.u.setTextColor(getResources().getColorStateList(R.color.lbs_title_color));
        com.baidu.tieba.util.x.h(this.v, (int) R.drawable.lbs_title_bg_normal);
        com.baidu.tieba.util.x.h(this.w, (int) R.drawable.lbs_title_bg_normal);
        this.w.setImageDrawable(new ColorDrawable(-2763307));
        this.m.setBackgroundColor(-1380623);
    }

    void o() {
        this.k = (RelativeLayout) findViewById(R.id.new_nearby_activity_layout);
        CompatibleUtile.getInstance().closeViewGpu(this.k);
        this.l = (TextView) findViewById(R.id.static_map_text);
        this.G = new p(this);
        this.s = new q(this);
        this.x = new r(this);
        this.B = (ImageView) findViewById(R.id.main_key);
        this.C = (ImageView) findViewById(R.id.send_pic);
        this.D = (ImageView) findViewById(R.id.send_text);
        this.E = (ImageView) findViewById(R.id.teleport_cord);
        this.F = (ImageView) findViewById(R.id.teleport_map);
        this.B.setOnClickListener(this.G);
        this.C.setOnClickListener(this.G);
        this.D.setOnClickListener(this.G);
        this.E.setOnClickListener(this.G);
        this.F.setOnClickListener(this.G);
        this.r = (RadioGroup) findViewById(R.id.title_lbs);
        this.t = (RadioButton) findViewById(R.id.title_lbs_threads);
        this.u = (RadioButton) findViewById(R.id.title_lbs_bars);
        this.v = (ImageView) findViewById(R.id.refresh);
        this.w = (ImageView) findViewById(R.id.divider);
        this.t.setOnCheckedChangeListener(this.s);
        this.u.setOnCheckedChangeListener(this.s);
        this.C.setOnTouchListener(this.x);
        this.D.setOnTouchListener(this.x);
        this.B.setOnTouchListener(this.x);
        this.E.setOnTouchListener(this.x);
        this.F.setOnTouchListener(this.x);
        this.v.setOnClickListener(this.G);
        this.q = (TextView) findViewById(R.id.no_location_info_view);
        this.p = (ProgressBar) findViewById(R.id.location_progress);
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new s(this));
        if (this.I == null) {
            this.I = builder.create();
            this.I.setCanceledOnTouchOutside(true);
        }
    }
}
