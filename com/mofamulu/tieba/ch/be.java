package com.mofamulu.tieba.ch;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class be {
    private static int a = -1;
    private static int b = -1;

    public static void a(View view) {
        if (view instanceof ViewGroup) {
            a((ViewGroup) view, TiebaApplication.f().as());
        }
    }

    public static void a(ViewGroup viewGroup, int i) {
        if (a == -1) {
            a = TiebaApplication.f().getResources().getColor(R.color.skin_1_common_color);
            b = TiebaApplication.f().getResources().getColor(R.color.more_color);
        }
        int childCount = viewGroup.getChildCount();
        boolean z = i == 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            Object tag = childAt.getTag();
            if (tag != null) {
                if ("text_group".equals(tag)) {
                    b((TextView) childAt, i);
                } else if ("text_content".equals(tag)) {
                    b((TextView) childAt, i);
                } else if ("text_num".equals(tag)) {
                    a((TextView) childAt, i);
                } else if ("check_box".equals(tag)) {
                    a((CheckBox) childAt, i);
                } else if ("sidebar_content".equals(tag)) {
                    ((TextView) childAt).setTextAppearance(TiebaApplication.f(), z ? R.style.sidebar_content_1 : R.style.sidebar_content);
                } else if ("more_up".equals(tag)) {
                    if (childAt instanceof RadioButton) {
                        ((RadioButton) childAt).setTextColor(z ? a : b);
                    }
                    com.baidu.tieba.util.x.h(childAt, z ? R.drawable.more_up_1 : R.drawable.more_up);
                } else if ("more_middle".equals(tag)) {
                    if (childAt instanceof RadioButton) {
                        ((RadioButton) childAt).setTextColor(z ? a : b);
                    }
                    com.baidu.tieba.util.x.h(childAt, z ? R.drawable.more_middle_1 : R.drawable.more_middle);
                } else if ("more_down".equals(tag)) {
                    if (childAt instanceof RadioButton) {
                        ((RadioButton) childAt).setTextColor(z ? a : b);
                    }
                    com.baidu.tieba.util.x.h(childAt, z ? R.drawable.more_down_1 : R.drawable.more_down);
                } else if ("more_all".equals(tag)) {
                    if (childAt instanceof RadioButton) {
                        ((RadioButton) childAt).setTextColor(z ? a : b);
                    }
                    com.baidu.tieba.util.x.h(childAt, z ? R.drawable.more_all_1 : R.drawable.more_all);
                } else if ("arrow".equals(tag)) {
                    ((ImageView) childAt).setImageResource(z ? R.drawable.icon_arrow_right_1 : R.drawable.icon_arrow_right);
                }
            }
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, i);
            }
        }
    }

    public static void a(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                textView.setTextColor(-11446171);
            } else {
                textView.setTextColor(-5065030);
            }
        }
    }

    public static void b(TextView textView, int i) {
        if (a == -1) {
            a = TiebaApplication.f().getResources().getColor(R.color.skin_1_common_color);
            b = TiebaApplication.f().getResources().getColor(R.color.more_color);
        }
        if (textView != null) {
            if (i == 1) {
                textView.setTextColor(a);
            } else {
                textView.setTextColor(b);
            }
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (a == -1) {
            a = TiebaApplication.f().getResources().getColor(R.color.skin_1_common_color);
            b = TiebaApplication.f().getResources().getColor(R.color.more_color);
        }
        if (checkBox != null) {
            if (i == 1) {
                checkBox.setTextColor(a);
            } else {
                checkBox.setTextColor(b);
            }
        }
    }
}
