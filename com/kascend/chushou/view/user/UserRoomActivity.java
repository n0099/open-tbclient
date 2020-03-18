package com.kascend.chushou.view.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.view.base.BaseActivity;
import tv.chushou.zues.widget.animation.AnimationImageView;
/* loaded from: classes5.dex */
public class UserRoomActivity extends BaseActivity {
    private View a;
    private View b;
    private ImageView c;
    private TextView e;
    private String h;
    private String i;
    private FrameLayout nfT;
    private AnimationImageView nhY;
    private b nhZ;

    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().setFormat(-2);
        super.onCreate(bundle);
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void a() {
        setContentView(a.h.activity_my_room);
        this.a = findViewById(a.f.title_view);
        this.nfT = (FrameLayout) findViewById(a.f.fragment_container);
        this.b = findViewById(a.f.rl_empty);
        this.c = (ImageView) findViewById(a.f.iv_empty);
        this.nhY = (AnimationImageView) findViewById(a.f.iv_loading);
        this.e = (TextView) findViewById(a.f.tv_empty);
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void b() {
        Intent intent = getIntent();
        this.h = intent.getStringExtra("uid");
        this.i = intent.getStringExtra("dataInfo");
        boolean booleanExtra = intent.getBooleanExtra("scrollto", false);
        if (!tv.chushou.zues.utils.a.dQQ()) {
            a_(3);
            return;
        }
        a_(1);
        this.nhZ = b.b(this.h, null, booleanExtra, this.i);
        getSupportFragmentManager().beginTransaction().replace(a.f.fragment_container, this.nhZ).commitAllowingStateLoss();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        tv.chushou.zues.utils.systemBar.b.aI(this);
        return 1;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void a_(int i) {
        switch (i) {
            case 1:
                this.a.setVisibility(0);
                this.nfT.setVisibility(8);
                this.b.setVisibility(0);
                this.nhY.setVisibility(0);
                this.c.setVisibility(8);
                this.e.setVisibility(8);
                return;
            case 2:
            default:
                return;
            case 3:
                this.a.setVisibility(0);
                this.nfT.setVisibility(8);
                this.b.setVisibility(0);
                this.nhY.setVisibility(8);
                this.c.setVisibility(0);
                this.c.setImageResource(a.e.commonres_pagestatus_net_error);
                this.e.setVisibility(8);
                return;
            case 4:
                this.a.setVisibility(0);
                this.nfT.setVisibility(8);
                this.b.setVisibility(0);
                this.nhY.setVisibility(8);
                this.c.setVisibility(0);
                this.c.setImageResource(a.e.commonres_pagestatus_unknown_error);
                this.e.setVisibility(8);
                return;
        }
    }

    public void c() {
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.nfT.setVisibility(0);
    }
}
