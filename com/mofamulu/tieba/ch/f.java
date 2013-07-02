package com.mofamulu.tieba.ch;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
public class f {
    private static BroadcastReceiver a = null;

    public static boolean a(PersonInfoActivity personInfoActivity) {
        com.baidu.tieba.model.bi biVar = personInfoActivity.b;
        if (biVar == null) {
            return true;
        }
        if (biVar.a() == null || biVar.a().length() <= 0) {
            return false;
        }
        return biVar.b();
    }

    public static void a(PersonInfoActivity personInfoActivity, com.baidu.tieba.model.bi biVar) {
        a(personInfoActivity, (Bundle) null);
        p.a(personInfoActivity, 0);
    }

    public static void a(PersonInfoActivity personInfoActivity, Bundle bundle) {
        String str;
        if (a(personInfoActivity)) {
            str = bg.a();
            if (a == null) {
                a = new l((TextView) personInfoActivity.findViewById(R.id.new_sms_count));
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.baidu.tieba.broadcast.sms");
                personInfoActivity.registerReceiver(a, intentFilter);
            }
            g gVar = new g(personInfoActivity);
            FrameLayout frameLayout = (FrameLayout) personInfoActivity.findViewById(R.id.info);
            if (frameLayout != null) {
                frameLayout.setLongClickable(true);
                frameLayout.setOnLongClickListener(gVar);
            }
        } else {
            String str2 = null;
            Intent intent = personInfoActivity.getIntent();
            if (intent != null) {
                str2 = intent.getStringExtra("name");
            }
            if (str2 == null && personInfoActivity.b != null) {
                str2 = personInfoActivity.b.f();
            }
            if (str2 != null) {
                View findViewById = personInfoActivity.findViewById(R.id.name);
                findViewById.setClickable(true);
                findViewById.setLongClickable(true);
                findViewById.setOnLongClickListener(new i(str2, personInfoActivity));
                str = str2;
            } else {
                return;
            }
        }
        as.a(personInfoActivity, str, new j(personInfoActivity, (ImageView) personInfoActivity.findViewById(R.id.background_image)));
    }

    public static void b(PersonInfoActivity personInfoActivity) {
        if (a(personInfoActivity) && a != null) {
            try {
                personInfoActivity.unregisterReceiver(a);
                a = null;
            } catch (Throwable th) {
            }
        }
    }

    public static void a(PersonInfoActivity personInfoActivity, boolean z) {
        LinearLayout linearLayout = (LinearLayout) personInfoActivity.findViewById(R.id.button_sign);
        LinearLayout linearLayout2 = (LinearLayout) personInfoActivity.findViewById(R.id.button_loved_sites);
        LinearLayout linearLayout3 = (LinearLayout) personInfoActivity.findViewById(R.id.button_sms);
        if (!a(personInfoActivity)) {
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(8);
            linearLayout3.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        linearLayout2.setVisibility(0);
        linearLayout3.setVisibility(0);
        TextView textView = (TextView) personInfoActivity.findViewById(R.id.button_sign_text);
        TextView textView2 = (TextView) personInfoActivity.findViewById(R.id.button_loved_sites_text);
        TextView textView3 = (TextView) personInfoActivity.findViewById(R.id.my_sms_text);
        ImageView imageView = (ImageView) personInfoActivity.findViewById(R.id.sign_image);
        ImageView imageView2 = (ImageView) personInfoActivity.findViewById(R.id.loved_sites_image);
        ImageView imageView3 = (ImageView) personInfoActivity.findViewById(R.id.my_sms_image);
        if (linearLayout != null) {
            if (z) {
                linearLayout.setBackgroundResource(R.drawable.person_button_1);
                linearLayout2.setBackgroundResource(R.drawable.person_button_1);
                linearLayout3.setBackgroundResource(R.drawable.person_button_1);
                int color = personInfoActivity.getResources().getColor(R.color.skin_1_common_color);
                textView.setTextColor(color);
                textView2.setTextColor(color);
                textView3.setTextColor(color);
                imageView.setImageResource(R.drawable.person_sign_1);
                imageView2.setImageResource(R.drawable.person_loved_bars2_1);
                imageView3.setImageResource(R.drawable.person_sms_1);
                return;
            }
            linearLayout.setBackgroundResource(R.drawable.person_button);
            linearLayout2.setBackgroundResource(R.drawable.person_button);
            linearLayout3.setBackgroundResource(R.drawable.person_button);
            int color2 = personInfoActivity.getResources().getColor(R.color.more_color);
            textView.setTextColor(color2);
            textView2.setTextColor(color2);
            textView3.setTextColor(color2);
            imageView.setImageResource(R.drawable.person_sign);
            imageView2.setImageResource(R.drawable.person_loved_bars2);
            imageView3.setImageResource(R.drawable.person_sms);
        }
    }
}
