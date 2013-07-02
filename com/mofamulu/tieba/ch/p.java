package com.mofamulu.tieba.ch;

import android.app.Activity;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonInfoActivity;
import com.mofamulu.tieba.sign.AccountListActivity;
import com.mofamulu.tieba.sign.SignService;
import com.mofamulu.tieba.sign.SignServiceBinder;
import com.mofamulu.tieba.tail.LovedBarListActivity;
/* loaded from: classes.dex */
public class p {
    private static Activity a;
    private static com.mofamulu.tieba.sign.am b = new q();

    public static void a(PersonInfoActivity personInfoActivity) {
        if (f.a(personInfoActivity)) {
            a = personInfoActivity;
            SignServiceBinder a2 = SignService.a();
            if (a2 != null) {
                a2.a(b);
            } else {
                SignService.a = b;
            }
        }
    }

    public static void b(PersonInfoActivity personInfoActivity) {
        if (f.a(personInfoActivity)) {
            SignService.a = null;
            SignServiceBinder b2 = SignService.b();
            if (b2 != null) {
                b2.b(b);
            }
            a = null;
        }
    }

    public static void a() {
        SignServiceBinder a2 = SignService.a();
        if (a2 != null && a != null) {
            a.a(new r(a2));
        }
    }

    public static void a(PersonInfoActivity personInfoActivity, int i) {
        if (f.a(personInfoActivity)) {
            LinearLayout linearLayout = (LinearLayout) personInfoActivity.findViewById(R.id.button_sign);
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new e(personInfoActivity, AccountListActivity.class));
            }
            LinearLayout linearLayout2 = (LinearLayout) personInfoActivity.findViewById(R.id.button_loved_sites);
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(new e(personInfoActivity, LovedBarListActivity.class));
            }
            ((LinearLayout) personInfoActivity.findViewById(R.id.button_sms)).setOnClickListener(new t(personInfoActivity));
            a();
        }
    }
}
