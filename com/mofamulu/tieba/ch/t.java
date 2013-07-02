package com.mofamulu.tieba.ch;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.mofamulu.tieba.sms.SMSOutlineActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    private final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        au.a(this.a, 0, null);
        Activity parent = this.a.getParent();
        if (parent != null && (parent instanceof MainTabActivity)) {
            ((MainTabActivity) parent).c();
        }
        bg c = bg.c();
        if (c.N() && c.e(false)) {
            this.a.startActivity(new Intent(this.a, SMSOutlineActivity.class));
            return;
        }
        au.a(this.a, "http://msg.baidu.com/msg/home");
    }
}
