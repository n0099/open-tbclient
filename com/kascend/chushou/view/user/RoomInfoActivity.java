package com.kascend.chushou.view.user;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.tbadk.log.LogConfig;
import com.kascend.chushou.a;
import com.kascend.chushou.view.base.BaseActivity;
import com.kascend.chushou.view.h5.H5Options;
/* loaded from: classes5.dex */
public class RoomInfoActivity extends BaseActivity {
    private TextView a;

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void a() {
        setContentView(a.h.activity_single_fragment_with_title);
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void M() {
        this.a = (TextView) findViewById(a.f.tittle_name);
        findViewById(a.f.back_icon).setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.view.user.RoomInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RoomInfoActivity.this.finish();
            }
        });
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void b() {
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("type", 2);
        String stringExtra = intent.getStringExtra(LogConfig.LOG_ROOMID);
        com.kascend.chushou.view.h5.a aVar = null;
        if (intExtra == 2) {
            this.a.setText(a.i.str_contribute_tittle);
            H5Options h5Options = new H5Options();
            h5Options.d = true;
            h5Options.a = tv.chushou.common.a.dJu() + "m/room-billboard/" + stringExtra + ".htm";
            aVar = com.kascend.chushou.view.h5.a.a(h5Options);
        }
        if (aVar != null) {
            getSupportFragmentManager().beginTransaction().add(a.f.fragment_container, aVar).commit();
        }
    }
}
