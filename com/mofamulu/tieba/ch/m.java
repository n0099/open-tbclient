package com.mofamulu.tieba.ch;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import com.mofamulu.tieba.sign.MoreSignActivity;
import com.mofamulu.tieba.tail.MoreMapActivity;
import com.mofamulu.tieba.tail.MoreOthersActivity;
import com.mofamulu.tieba.tail.MoreTailActivity;
/* loaded from: classes.dex */
public class m {
    public static void a(Activity activity, int i) {
        ((LinearLayout) activity.findViewById(R.id.nick_settings)).setOnClickListener(new e(activity, MoreNickActivity.class));
        ((LinearLayout) activity.findViewById(R.id.sign_settings)).setOnClickListener(new e(activity, MoreSignActivity.class));
        ((LinearLayout) activity.findViewById(R.id.tail_settings)).setOnClickListener(new e(activity, MoreTailActivity.class));
        ((LinearLayout) activity.findViewById(R.id.map_settings)).setOnClickListener(new e(activity, MoreMapActivity.class));
        ((LinearLayout) activity.findViewById(R.id.other_settings)).setOnClickListener(new e(activity, MoreOthersActivity.class));
        ((LinearLayout) activity.findViewById(R.id.vip_settings)).setOnClickListener(new e(activity, MoreVipActivity.class));
    }

    public static void a(Activity activity, Bundle bundle) {
        LinearLayout linearLayout = (LinearLayout) activity.findViewById(R.id.position_paper);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new n(activity));
        }
        LinearLayout linearLayout2 = (LinearLayout) activity.findViewById(R.id.person_info);
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    public static void b(Activity activity, int i) {
        be.a((ViewGroup) activity.findViewById(R.id.body_container), i);
    }

    public static void c(Activity activity, int i) {
        ((Button) activity.findViewById(R.id.jump_tbhp_clan_button)).setOnClickListener(new o(activity));
    }
}
