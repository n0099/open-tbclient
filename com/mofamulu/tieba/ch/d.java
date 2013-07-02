package com.mofamulu.tieba.ch;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import java.net.URLEncoder;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private final /* synthetic */ Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Activity activity) {
        this.a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        try {
            if (this.a.getIntent().getStringExtra("name") == null) {
                this.a.getIntent().getStringExtra("fname");
            }
            com.baidu.tieba.model.v vVar = ((FrsActivity) this.a).a;
            if (vVar != null) {
                String encode = URLEncoder.encode(vVar.a().b(), "GBK");
                ArrayList h = vVar.a().h();
                if (view.getId() == R.id.ranklist) {
                    au.a(this.a, "http://tieba.baidu.com/f/like/furank?kw=" + encode + "#p");
                } else if (view.getId() == R.id.enter_bawu_admin) {
                    if (h != null && h.contains(bg.a())) {
                        str = "http://tieba.baidu.com/bawu/main";
                    } else {
                        str = "http://tieba.baidu.com/bawu/info";
                    }
                    au.a(this.a, String.valueOf(str) + "?fid=" + vVar.a().a() + "&word=" + encode);
                } else if (view.getId() == R.id.enter_gcode) {
                    au.a(this.a, "http://code.google.com/p/tieba-helper/wiki/FAQForAll");
                } else if (view.getId() == R.id.enter_kaka) {
                    ((FrsActivity) this.a).c("咔咔_嘎嘎的窝");
                } else if (view.getId() == R.id.enter_3force) {
                    ((FrsActivity) this.a).c("第三势力");
                } else if (view.getId() == R.id.enter_mofamumulu) {
                    ((FrsActivity) this.a).c("魔法书目录");
                }
            }
        } catch (Exception e) {
        }
    }
}
